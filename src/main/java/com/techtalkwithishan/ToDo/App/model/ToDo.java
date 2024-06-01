package com.techtalkwithishan.ToDo.App.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "todo")
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   private long id;
    @Column
   private  String title;
    @Column
   private Date date;
    @Column
   private String status;

    public ToDo(long id, String title, Date date, String status) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.status = status;
    }

    public ToDo() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
