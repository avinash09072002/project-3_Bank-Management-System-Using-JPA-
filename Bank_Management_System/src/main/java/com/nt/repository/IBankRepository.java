package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.BankDetails;

public interface IBankRepository extends JpaRepository<BankDetails, Integer> {

}
