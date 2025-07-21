package com.newtechmat.productionbalance.data.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name="worktasks")
public class WorkTask {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @OneToMany(mappedBy="workTask", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JsonManagedReference
    @JsonIgnore
    private Set<WorkTaskEntry> workTaskEntryes;

    @Column(nullable = false)
    private String number;

    @Column(nullable = false)
    //@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "item_id")
    //@JsonBackReference
    private Item item;

    /*@Column(nullable = false)
    private Integer itemId;*/

    public WorkTask(String number, LocalDate date) {
        this.number = number;
        this.date = date;
    }

    public WorkTask(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<WorkTaskEntry> getWorkTaskEntryes() {
        return workTaskEntryes;
    }

    public void setWorkTaskEntryes(Set<WorkTaskEntry> workTaskEntryes) {
        this.workTaskEntryes = workTaskEntryes;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
