package com.avazon.ecommerce.service;

import com.avazon.ecommerce.repository.AddressRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private AddressRepository repository;

    public AddressService(AddressRepository addressRepository) {
        this.repository = addressRepository;
    }


}
