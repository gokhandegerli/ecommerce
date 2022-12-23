package com.avazon.ecommerce.repository;

import com.avazon.ecommerce.model.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {


    List<Address> findAddressByUserId(long userId);


}
