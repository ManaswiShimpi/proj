package com.lti.demo.Controller;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.lti.demo.model.Disease;
import com.lti.demo.model.DiseasesList;
import com.lti.demo.model.Employee;
import com.lti.demo.model.EmployeesList;
import com.lti.demo.model.Patient;
import com.lti.demo.service.PatientService;


@RestController
@RequestMapping("admission")
public class AdmissionController {
	@Autowired
	private PatientService patientService;
	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/physicians")
	public List<EmployeesList> getPhysicians() {
		EmployeesList[] physicians = restTemplate.getForObject("http://HR/hr/getAll", EmployeesList[].class);
		return Arrays.asList(physicians);
	}

	@RequestMapping("/diseases")
	public List<DiseasesList> getDiseases() {
		DiseasesList[] diseasesList = restTemplate.getForObject("http://pathology-service/pathology/getAll", DiseasesList[].class);
		return Arrays.asList(diseasesList);
	}

	@RequestMapping("/create")
	public String create(@RequestParam(value = "PId", required = true) String PId, @RequestParam("name") String name,
			@RequestParam("nationality") String nationality) {
		Patient p = patientService.create(PId, name, nationality);
		return p.toString();
	}

	@RequestMapping("/get")
	public Patient getPatient(@RequestParam("PId") String PId) {
		return patientService.getByPId(PId);
	}

	@RequestMapping("/getAll")
	public List<Patient> getAll() {
		return patientService.getAll();
	}

	@RequestMapping("/update")
	public String update(@RequestParam String PId, @RequestParam String name, @RequestParam String nationality) {
		Patient p = patientService.update(PId, name, nationality);
		return p.toString();
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam String PId) {
		patientService.delete(PId);
		return "Deleted" + PId;
	}

	@RequestMapping("/deleteAll")
	public String deleteAll() {
		patientService.deleteAll();
		return "Deleted all records";
	}
}