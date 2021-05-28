package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.dto.OldAssicuratoDTO;
import com.example.demo.model.nuovo.Assicurato;
import com.example.demo.model.nuovo.NotProcessed;
import com.example.demo.service.assicurato.AssicuratoServiceImpl;
import com.example.demo.service.notprocessed.NotProcessedServiceImpl;
import com.example.demo.service.oldassicurato.OldAssicuratoServiceImpl;

@SpringBootApplication
public class DatamigratorApplication implements CommandLineRunner {

	@Autowired
	private OldAssicuratoServiceImpl oldAssicuratoServiceImpl;

	@Autowired
	private AssicuratoServiceImpl assicuratoServiceImpl;

	@Autowired
	private NotProcessedServiceImpl NotProcessedServiceImpl;

	public static void main(String[] args) {
		SpringApplication.run(DatamigratorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<OldAssicuratoDTO> old = oldAssicuratoServiceImpl.listAll();
		System.out.println(old);

		for (OldAssicuratoDTO item : old) {
			if (item.getCodiceFiscale().length() != 16) {
				NotProcessed notProcessed = new NotProcessed(item.getCodiceFiscale(), item.getId());
				NotProcessedServiceImpl.inserisciNotProcessed(notProcessed);
			} else {
				assicuratoServiceImpl
						.inserisciAssicurato(new Assicurato(item.getId(), item.getNome(), item.getCognome(),
								item.getData(), item.getNumeroSinistri().byteValue(), item.getCodiceFiscale()));
			}
		}

	}

}
