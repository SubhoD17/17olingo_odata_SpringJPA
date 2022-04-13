package com.subho.service;
import org.springframework.data.jpa.repository.JpaRepository;

import com.subho.entities.address;

public interface IAddressPersistence extends JpaRepository<address, Long> {

}
