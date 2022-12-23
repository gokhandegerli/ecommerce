package com.avazon.ecommerce.model.entity;

import com.avazon.ecommerce.dto.CartDto;
import com.avazon.ecommerce.dto.UserDto;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class LocalUser implements Serializable {
    //private static final String MAP_CAT = "user";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PRIVATE_SEQ")
    private long id;

    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String name;

    //The orphanRemoval is an ORM concept,it tells if the child is orphaned. it should also be
    // removed from the database. CascadeType.REMOVE (ALL consists of REMOVE) is a database level concept
    // and it tells if the parent is removed, all its related records in the child table should be removed.
    /*@OneToMany(mappedBy = MAP_CAT, cascade = CascadeType.REMOVE, orphanRemoval = true)
    List<Address> addressList = new ArrayList<>();*/


    public LocalUser() {
    }

    public LocalUser(long id, String email, String password, String name) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public UserDto toDto() {
        UserDto dto = new UserDto();
        dto.setId(this.getId());
        dto.setEmail(this.getEmail());
        dto.setPassword(this.getPassword());
        dto.setName(this.getName());
        return dto;
    }

}
