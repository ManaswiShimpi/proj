package com.lti.pathologyservice.repository;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.lti.pathologyservice.model.Disease;
import com.lti.pathologyservice.service.*;

@Repository
public interface DiseaseRepository extends MongoRepository<Disease, String>{
	public Disease getBydId(String dId);
	}
	


