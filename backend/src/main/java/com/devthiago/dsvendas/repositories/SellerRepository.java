package com.devthiago.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devthiago.dsvendas.entities.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long>{

}
