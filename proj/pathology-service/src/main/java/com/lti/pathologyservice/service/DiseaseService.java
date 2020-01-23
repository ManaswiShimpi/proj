package com.lti.pathologyservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;



import com.lti.pathologyservice.model.Disease;
import com.lti.pathologyservice.repository.DiseaseRepository;

@Service
public class DiseaseService {
	

		@Autowired
	private DiseaseRepository diseaseRepository;

	//create
	public Disease create(String dId,String description,String treatement)
	{
		return diseaseRepository.save(new Disease(dId,description,treatement)) ;

	}
	//retrive
	public List<Disease> getAll()
	{
		return diseaseRepository.findAll();
	}
	public Disease getBydId(String dId) 
	{
		return diseaseRepository.getBydId(dId);
	}
	//update
	public Disease update(String dId,String description,String treatement)
	{
		Disease p=diseaseRepository.getBydId(dId);
		p.setDescription(description);
		p.setTreatments(treatement);
		return diseaseRepository.save(p);
	}
	//Delete
	public void deleteAll()
	{
		diseaseRepository.deleteAll();
	}
	public void delete(String dId)
	{
		Disease p=diseaseRepository.getBydId(dId);
		diseaseRepository.delete(p);
	}
	}