package com.lti.pathologyservice.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.pathologyservice.model.Disease;
import com.lti.pathologyservice.service.DiseaseService;

@RestController
@RequestMapping("/pathology")
public class PathologyResource {
	@Autowired
private DiseaseService diseaseService;

	@RequestMapping("/create")
	public String create(@RequestParam("dId") String dId, @RequestParam ("description") String description, @RequestParam  ("treatment") String treatment)
	{
	Disease p= diseaseService.create(dId,description,treatment);
	return p.toString();
}
	@RequestMapping("/get")
	public Disease getDisease(@RequestParam ("dId") String dId)
	{
		return  diseaseService.getBydId(dId); 
	}
	@RequestMapping("/getAll")
public List<Disease> getAll()
{
	return  diseaseService.getAll();
}
	@RequestMapping("/update")
public String update(@RequestParam String dId,@RequestParam String description, @RequestParam String treatment)
{
	Disease p= diseaseService.update(dId, description, treatment);
	return p.toString();
}
	 
	@RequestMapping("/delete")
public String delete(@RequestParam String dId)
{
	 diseaseService.delete(dId);
	return"Deleted"+dId;
}
	@RequestMapping("/deleteAll")
public String deleteAll()
{
	 diseaseService.deleteAll();
	return"Deleted all records";
}

}
