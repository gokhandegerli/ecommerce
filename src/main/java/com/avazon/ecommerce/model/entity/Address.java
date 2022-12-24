package com.avazon.ecommerce.model.entity;

import com.avazon.ecommerce.dto.AddressDto;
import com.avazon.ecommerce.dto.UserDto;
import jakarta.persistence.*;

@Entity
public class Address {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PRIVATE_SEQ")
    private long id;

    @Column(nullable=false, length=512)
    private String line;

    @Column(nullable=false)
    private String city;

    @Column(nullable=false)
    private String country;

    private String postCode;

    @OneToOne
    private LocalUser user;

    public Address() {
    }

    public Address(long id, String line, String city, String country, String postCode, LocalUser user) {
        this.id = id;
        this.line = line;
        this.city = city;
        this.country = country;
        this.postCode = postCode;
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
        dto.setUser(this.getUserDto());
        return dto;
    }
}
