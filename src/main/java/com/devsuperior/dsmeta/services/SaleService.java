package com.devsuperior.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import com.devsuperior.dsmeta.dto.SaleReportDTO;
import com.devsuperior.dsmeta.dto.SaleSummaryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;
	
	public SaleMinDTO findById(Long id) {
		Optional<Sale> result = repository.findById(id);
		Sale entity = result.get();
		return new SaleMinDTO(entity);
	}

	@Transactional(readOnly = true)
	public Page<SaleReportDTO> searchReport(String minDate, String maxDate, String name, Pageable pageable){
		//Tratando os dados
		LocalDate min, max;
		if (maxDate.isEmpty()){
			max = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());//cria a data com a data atual
		}else {
			max = LocalDate.parse(maxDate);
		}

		if (minDate.isEmpty()){
			min = max.minusYears(1L);
		}else {
			min = LocalDate.parse(minDate);
		}
		Page<Sale> result = repository.searchReport(min, max, name, pageable);
		return result.map(x -> new SaleReportDTO(x));
	}

	public List<SaleSummaryDTO> searchSummary(String minDate, String maxDate){
		LocalDate min, max;
		if (maxDate.isEmpty()) {
			max = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		}else {
			max = LocalDate.parse(maxDate);
		}

		if (minDate.isEmpty()){
			min = max.minusYears(1L);
		}else {
			min = LocalDate.parse(minDate);
		}

		return repository.searchSummary(min, max);
	}
}
