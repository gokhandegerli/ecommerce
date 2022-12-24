package com.avazon.ecommerce.api.controller;

import com.avazon.ecommerce.api.model.AddressCreateBody;
import com.avazon.ecommerce.api.model.AddressUpdateBody;
import com.avazon.ecommerce.api.model.UserUpdateBody;
import com.avazon.ecommerce.exception.FieldsMissingException;
import com.avazon.ecommerce.exception.NotExistException;
import com.avazon.ecommerce.response.AddressResponse;
import com.avazon.ecommerce.response.Meta;
import com.avazon.ecommerce.response.UserResponse;
import com.avazon.ecommerce.service.AddressService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("addresses")
public class AddressController {

    private AddressService service;

    public AddressController(AddressService addressService) {
        this.service = addressService;
    }


    @PostMapping()
    public AddressResponse createAddress (@RequestBody AddressCreateBody addressCreateBody) {


        try {
            return service.createAddress(addressCreateBody);
        }
        catch (FieldsMissingException ex) {
            ex.printStackTrace();
            AddressResponse failResponse = new AddressResponse();
            failResponse.getMeta().setCode(1002);
            failResponse.getMeta().setDescription("Please fill all fields!");
            return failResponse;
        }
    }

    @PostMapping("{addressId}/user/{userId}")
    public AddressResponse addAddressToUser(@PathVariable(value = "addressId") long addressId,
                                            @PathVariable(value = "userId") long userId) {
        try {
            return service.addAddressToUser(addressId, userId );
        } catch (EntityNotFoundException ex){
            ex.printStackTrace();
            AddressResponse failResponse = new AddressResponse();
            failResponse.getMeta().setCode(1003);
            failResponse.getMeta().setDescription("Address or User could not be identified, please check data!");
            return failResponse;
        }
    }

    @GetMapping ("get-user-address-list/{userId}")
    public List<AddressResponse> getUserAddressList (@PathVariable(value = "userId") long userId) {
        return service.getUserAddressList(userId);
    }

    @PutMapping("/{addressId}")
    public AddressResponse updateAddress(@Valid @PathVariable(value = "addressId") long addressId,
                                   @RequestBody AddressUpdateBody addressUpdateBody) {
        try {
            return service.updateAddress(addressId, addressUpdateBody);
        } catch (NotExistException ex) {
            ex.printStackTrace();
            AddressResponse failResponse = new AddressResponse();
            failResponse.getMeta().setCode(1004);
            failResponse.getMeta().setDescription("This address does not exist!");
            return failResponse;
        }
    }

    @DeleteMapping("{addressId}")
    public Meta deleteAddress (@PathVariable (value="addressId") long addressId) {
        return service.deleteAddress(addressId);
    }



}
