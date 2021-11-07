package com.devthiago.dsvendas.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devthiago.dsvendas.dto.SaleDTO;
import com.devthiago.dsvendas.dto.SaleSuccessDTO;
import com.devthiago.dsvendas.dto.SaleSumDTO;
import com.devthiago.dsvendas.entities.Sale;
import com.devthiago.dsvendas.repositories.SaleRepository;
import com.devthiago.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@Transactional(readOnly=true)
	public Page<SaleDTO> findAll(Pageable pageable){
		sellerRepository.findAll();
		Page<Sale> result =  repository.findAll(pageable);
		return result.map(x -> new SaleDTO(x));
	}
	
	@Transactional(readOnly=true)
	public 	List<SaleSumDTO> amountGroupedBySeller(){
		return repository.amountGroupedBySeller();
	}
	
	public 	List<SaleSuccessDTO> successGroupedBySeller(){
		return repository.successGroupedBySeller();
	}



}
