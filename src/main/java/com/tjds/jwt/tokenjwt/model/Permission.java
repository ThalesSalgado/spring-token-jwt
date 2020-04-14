package com.tjds.jwt.tokenjwt.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Permission {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @Column
    private String description;

}
