package com.wurzburg.interedition.client.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import javax.persistence.Temporal;


@Entity

public class Annotation implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Basic
	private AnnotationBody annotationBody;
	@Basic
	@OneToMany
	private ArrayList<AnnotationTargetInstance> annotationsTargetInstances;
	@Basic
	private String URI;

	public Annotation() {
	}

	public Annotation(AnnotationBody annotationBody,
			ArrayList<AnnotationTargetInstance> annotationsTargetInstances) {
		super();
		this.annotationBody = annotationBody;
		this.annotationsTargetInstances = annotationsTargetInstances;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AnnotationBody getAnnotationBody() {
		return annotationBody;
	}

	public void setAnnotationBody(AnnotationBody annotationBody) {
		this.annotationBody = annotationBody;
	}

	public ArrayList<AnnotationTargetInstance> getAnnotationsTargetInstances() {
		return annotationsTargetInstances;
	}

	public void setAnnotationsTargetInstances(
			ArrayList<AnnotationTargetInstance> annotationsTargetInstances) {
		this.annotationsTargetInstances = annotationsTargetInstances;
	}

	public String getURI() {
		return URI;
	}

	public void setURI(String uRI) {
		URI = uRI;
	}

}
