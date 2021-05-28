package com.example.demo.old.repository;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.OldAssicuratoDTO;

@Repository
public class OldAssicuratoRepositoryImpl {
	@Autowired
	@Qualifier("oldEntityManagerFactory")
	private EntityManager oldEntityManager;

	public List<OldAssicuratoDTO> oldDataInterrogation() {

		Query q = oldEntityManager.createNativeQuery(
				"SELECT d.id, d.codice_fiscale, a.nome, a.cognome,a.data, count(s.id) as numero_sinistri "
						+ "from dati_fiscali d inner join anagrafica a "
						+ "ON  a.id_datifiscali=d.id left join sinistri s ON s.id_anagrafica=a.id " + "group by d.id;");
		List<Object[]> resultList = q.getResultList();

		List<OldAssicuratoDTO> result = new ArrayList<>(resultList.size());
		for (Object[] row : resultList) {
			result.add(new OldAssicuratoDTO(((Integer) row[0]).longValue(), (String) row[2], (String) row[3],
					(String) row[1], (Date) row[4], ((BigInteger) row[5]).intValueExact()));
		}

		return result;
	}

}
