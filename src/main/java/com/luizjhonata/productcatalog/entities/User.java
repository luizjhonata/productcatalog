package com.luizjhonata.productcatalog.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String username;

    private String password;


    @ManyToMany
    private List<Role> roles;

}
