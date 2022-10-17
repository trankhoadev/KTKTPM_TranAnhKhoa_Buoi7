package com.demo.springsecurity.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "chuyenbay")
@Data
public class ChuyenBay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String maCb;
    private String gaDi;
    private String gaDen;
}
