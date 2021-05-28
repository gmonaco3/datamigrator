package com.example.demo.service.assicurato;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.nuovo.Assicurato;
import com.example.demo.repository.assicurato.AssicuratoRepository;

@Service
public class AssicuratoServiceImpl {
	@Autowired
	private AssicuratoRepository assicuratoRepository;

	public void inserisciAssicurato(Assicurato input) {
		assicuratoRepository.save(input);
	}

}
