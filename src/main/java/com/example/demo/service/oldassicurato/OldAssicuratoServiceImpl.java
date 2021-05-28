package com.example.demo.service.oldassicurato;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.OldAssicuratoDTO;
import com.example.demo.old.repository.OldAssicuratoRepositoryImpl;

@Service
public class OldAssicuratoServiceImpl {
	@Autowired
	private OldAssicuratoRepositoryImpl oldAssicuratoRepository;

	public List<OldAssicuratoDTO> listAll() {
		return oldAssicuratoRepository.oldDataInterrogation();
	}

}
