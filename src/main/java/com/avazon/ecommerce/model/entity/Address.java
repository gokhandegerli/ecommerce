package com.avazon.ecommerce.model.entity;

import com.avazon.ecommerce.dto.AddressDto;
import com.avazon.ecommerce.dto.CartDto;
import com.avazon.ecommerce.dto.UserDto;
import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

@Entity
public class Address {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable=false, length=512)
    private String line;

    @Column(nullable=false)
    private String city;

    @Column(nullable=false)
    private String country;

    private String postCode;

    @Column(nullable=false)
    private boolean active;

    @ManyToOne
    private LocalUser user;

    public Address() {
    }

    public Address(long id, String line, String city, String country, String postCode,
                   boolean active, LocalUser user) {
        this.id = id;
        this.line = line;
        this.city = city;
        this.country = country;
        this.postCode = postCode;
        this.active = active;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public LocalUser getUser() {
        return user;
    }

    public void setUser(LocalUser localUser) {
        this.user = localUser;
    }

    public UserDto getUserDto() {
        return user == null
                ? null
                : user.toDto(); //If else'in kısa hali
    }

    public AddressDto toDto() {
        AddressDto dto = new AddressDto();
        dto.setId(this.getId());
        dto.setLine(this.getLine());
        dto.setCity(this.getCity());
        dto.setCountry(this.getCountry());
        dto.setPostCode(this.getPostCode());
        dto.setActive(this.isActive());
        dto.setUser(this.getUserDto());
        return dto;
    }
}
