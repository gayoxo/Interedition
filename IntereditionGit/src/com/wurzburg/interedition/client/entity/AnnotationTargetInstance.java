package com.wurzburg.interedition.client.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AnnotationTargetInstance implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Basic
	private AnnotationConstraint annotationConstraint;
	@Basic
	private AnnotationTargetInfo annotationTargetInfo;

	public AnnotationConstraint getAnnotationConstraint() {
		return annotationConstraint;
	}

	public AnnotationTargetInstance(AnnotationConstraint annotationConstraint,
			AnnotationTargetInfo annotationTargetInfo) {
		super();
		this.annotationConstraint = annotationConstraint;
		this.annotationTargetInfo = annotationTargetInfo;
	}

	public void setAnnotationConstraint(
			AnnotationConstraint annotationConstraint) {
		this.annotationConstraint = annotationConstraint;
	}

	public AnnotationTargetInfo getAnnotationTargetInfo() {
		return annotationTargetInfo;
	}

	public void setAnnotationTargetInfo(
			AnnotationTargetInfo annotationTargetInfo) {
		this.annotationTargetInfo = annotationTargetInfo;
	}

	public AnnotationTargetInstance() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
