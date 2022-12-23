package com.avazon.ecommerce.service;

import com.avazon.ecommerce.api.model.AddressCreateBody;
import com.avazon.ecommerce.dto.AddressDto;
import com.avazon.ecommerce.exception.FieldsMissingException;
import com.avazon.ecommerce.model.entity.Address;
import com.avazon.ecommerce.model.entity.LocalUser;
import com.avazon.ecommerce.repository.AddressRepository;
import com.avazon.ecommerce.response.AddressResponse;
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

        if (addressCreateBody.getLine() == null || addressCreateBody.getLine().equals("") ||
                addressCreateBody.getCity() == null || addressCreateBody.getCity().equals("")) {
            throw new FieldsMissingException("Address Line and City should have been filled, please check!!");
        }
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
}
