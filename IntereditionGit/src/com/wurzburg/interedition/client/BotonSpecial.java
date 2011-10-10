package com.wurzburg.interedition.client;

import com.google.gwt.user.client.ui.Button;
import com.wurzburg.interedition.client.entity.AnnotationTargetInstance;

public class BotonSpecial extends Button {

	private AnnotationTargetInstance ATargetInstance;
	
	public BotonSpecial(String S,AnnotationTargetInstance ATargetInstancein) {
		super(S);
		ATargetInstance=ATargetInstancein;
		
	}
	
	public AnnotationTargetInstance getATargetInstance() {
		return ATargetInstance;
	}
	
	public void setATargetInstance(AnnotationTargetInstance aTargetInstance) {
		ATargetInstance = aTargetInstance;
	}
}
