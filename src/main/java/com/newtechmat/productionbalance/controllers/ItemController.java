package com.newtechmat.productionbalance.controllers;

import com.newtechmat.productionbalance.data.dto.ItemUpdateDto;
import com.newtechmat.productionbalance.data.models.Item;
import com.newtechmat.productionbalance.data.models.Operation;
import com.newtechmat.productionbalance.services.ItemService;
import com.newtechmat.productionbalance.services.OperationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;

@Controller
public class ItemController {

    private final ItemService itemService;
    private final OperationService operationService;

    public ItemController(ItemService itemService, OperationService operationService) {
        this.itemService = itemService;
        this.operationService = operationService;
    }

    @PostMapping(path="/save_item")
    @ResponseBody
    ResponseEntity<Item> saveItem(@RequestBody Item item) {
        Item newItem = itemService.saveItem(item);
        if (newItem == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(newItem, HttpStatus.OK);
    }

    /*@PostMapping(path="/save_test_item")
    @ResponseBody
    ResponseEntity<TestItem> saveTestItem(@RequestBody TestItem item) {
        TestItem newItem = testService.save(item);
        if (newItem == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(newItem, HttpStatus.OK);
    }*/

    @GetMapping(path="/item/{id}")
    String editItem(@PathVariable Integer id, Model model) {
        Item item = itemService.getItemById(id);
        model.addAttribute("currentItem", item);
        model.addAttribute("byOpId", Comparator.comparing(Operation::getId));
        return "data/item";
    }

    @PostMapping(path="/items/{id}")
    @ResponseBody
    ResponseEntity<Item> getItem(@PathVariable Integer id, Model model) {
        Item item = itemService.getItemById(id);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @PostMapping(path="/save_operation")
    @ResponseBody
    ResponseEntity<Operation> saveOperation(@RequestBody Operation operation) {
        Operation newOperation = operationService.saveOperation(operation);
        if (newOperation == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(newOperation, HttpStatus.OK);
    }

    @PostMapping(path="/update_operation")
    @ResponseBody
    ResponseEntity<Operation> updateWorker(@RequestBody Operation requestOperation) {
        Operation operation = operationService.updateOperation(requestOperation);
        if (operation == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(operation, HttpStatus.OK);
    }

    @PostMapping(path="/remove_operation")
    @ResponseBody
    ResponseEntity<Operation> removeOperation(@RequestParam Integer id) {
        operationService.removeOperationById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(path="/remove_item")
    @ResponseBody
    ResponseEntity<Item> removeItem(@RequestParam Integer id) {
        itemService.removeItemById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(path="/update_item")
    @ResponseBody
    ResponseEntity<Item> updateItem(@RequestBody ItemUpdateDto itemDto) {
        Item item = itemService.getItemById(itemDto.getId());
        item.setName(itemDto.getName());
        itemService.saveItem(item);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
