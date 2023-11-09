package com.example.toy.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Diary {
    @Id
    @GeneratedValue
    private long id;
    private String title;
    private String content;
    private Date creDate;
    
}
