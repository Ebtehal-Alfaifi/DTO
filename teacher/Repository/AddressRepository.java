package com.example.teacher.Repository;

import com.example.teacher.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Integer> {
    Address findAddressByAddressId(Integer id);
}
