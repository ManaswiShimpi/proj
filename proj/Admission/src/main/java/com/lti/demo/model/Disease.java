package com.lti.demo.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Disease {
private String dId;
private String description;
private String treatments;
public Disease(String dId, String description, String treatments) {
	
	this.dId = dId;
	this.description = description;
	this.treatments = treatments;
}

public String getdId() {
	return dId;
}
@Override
public String toString() {
	return "Disease [dId=" + dId + ", description=" + description + ", treatments=" + treatments + "]";
}
public void setId(String dId) {
	dId = dId;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getTreatments() {
	return treatments;
}
public void setTreatments(String treatments) {
	this.treatments = treatments;
}
}
