package com.avazon.ecommerce.service;

import com.avazon.ecommerce.api.model.AddressCreateBody;
import com.avazon.ecommerce.api.model.AddressUpdateBody;
import com.avazon.ecommerce.dto.AddressDto;
import com.avazon.ecommerce.exception.FieldsMissingException;
import com.avazon.ecommerce.exception.NotExistException;
import com.avazon.ecommerce.model.entity.Address;
import com.avazon.ecommerce.model.entity.LocalUser;
import com.avazon.ecommerce.repository.AddressRepository;
import com.avazon.ecommerce.response.AddressResponse;
import com.avazon.ecommerce.response.Meta;
import com.avazon.ecommerce.response.UserResponse;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    private AddressRepository repository;
    private UserService userService;

    public AddressService(AddressRepository repository, UserService userService) {
        this.repository = repository;
        this.userService = userService;
    }


    public AddressResponse createAddress(AddressCreateBody addressCreateBody) throws FieldsMissingException {

        Address address = new Address();
        address.setLine(addressCreateBody.getLine());
        address.setCity(addressCreateBody.getCity());
        address.setCountry(addressCreateBody.getCountry());
        address.setPostCode(addressCreateBody.getPostCode());
        AddressResponse response = new AddressResponse();
        response.setAddress(repository.save(address).toDto());
        return response;
    }

    public AddressResponse addAddressToUser(long addressId, long userId) throws EntityNotFoundException{
        Optional<Address> address = repository.findById(addressId);
        Optional<LocalUser> user = userService.getUserEntity(userId);
        AddressResponse response = new AddressResponse();

        if (address.isPresent() && user.isPresent()) {
            address.get().setUser(user.get());
            response.setAddress(repository.save(address.get()).toDto());
            return response;
        } else {
            throw new EntityNotFoundException("Address or User could not be identified, please check data!");
        }
    }

    public List<AddressResponse> getUserAddressList(long userId) {

        List<Address> addressList = repository.findAddressByUserId(userId);
        List<AddressDto> addressDtoList = addressList.stream().map(Address::toDto).toList();
        return addressDtoList.stream().map(addressDto -> new AddressResponse(addressDto)).toList();
    }

    public AddressResponse updateAddress(long addressId, AddressUpdateBody addressUpdateBody) throws NotExistException {

        Optional<Address> opAddress = repository.findById(addressId);

        if (opAddress.isPresent()) {
            Address address = opAddress.get();
            AddressResponse response = new AddressResponse();
            response.setAddress(address.toDto());
            if (addressUpdateBody.getLine() != null) {
                address.setLine(addressUpdateBody.getLine());
                response.getAddress().setLine(address.getLine());
            }
            if (addressUpdateBody.getCity() != null) {
                address.setCity(addressUpdateBody.getCity());
                response.getAddress().setCity(address.getCity());
            }
            if (addressUpdateBody.getCountry() != null) {
                address.setCountry(addressUpdateBody.getCountry());
                response.getAddress().setCountry(address.getCountry());
            }
            if (addressUpdateBody.getPostCode() != null) {
                address.setPostCode(addressUpdateBody.getPostCode());
                response.getAddress().setPostCode(address.getPostCode());
            }
            repository.save(address);
            return response;
        }
        else {
            throw new NotExistException("This address does not exist in DB! Please check your data!");
        }
    }

    public Meta deleteAddress(long addressId) {

        Optional<Address> addressToBeDeleted = repository.findById(addressId);

        if (addressToBeDeleted.isPresent()) {
            repository.deleteById(addressId);
            return new Meta();
        } else {
            return new Meta(1003,"Address not exist!");
        }
    }


}
