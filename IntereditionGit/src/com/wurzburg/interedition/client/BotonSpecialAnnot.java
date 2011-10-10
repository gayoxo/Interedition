package com.wurzburg.interedition.client;

import com.google.gwt.user.client.ui.Button;
import com.wurzburg.interedition.client.entity.AnnotationTargetInstance;

public class BotonSpecialAnnot extends Button {

	private Object ATargetInstance;
	
	public BotonSpecialAnnot(String S,Object ATargetInstancein) {
		super(S);
		ATargetInstance=ATargetInstancein;
		
	}
	
	public Object getObject() {
		return ATargetInstance;
	}
	
	public void setObject(Object aTargetInstance) {
		ATargetInstance = aTargetInstance;
	}
}
