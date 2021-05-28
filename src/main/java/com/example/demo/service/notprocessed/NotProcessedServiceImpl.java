package com.example.demo.service.notprocessed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.nuovo.NotProcessed;
import com.example.demo.repository.notprocessed.NotProcessedRepository;

@Service
public class NotProcessedServiceImpl {
	@Autowired
	private NotProcessedRepository notProcessedRepo;

	public void inserisciNotProcessed(NotProcessed input) {
		notProcessedRepo.save(input);
	}
}
