package com.wurzburg.interedition.client;

import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.wurzburg.interedition.client.entity.AnnotationConstraint;
import com.wurzburg.interedition.client.entity.AnnotationTargetInfo;
import com.wurzburg.interedition.client.factoria.Factory;

public class AnnotationTargetURI extends DialogBox {

	public AnnotationTargetURI(AnnotationTargetInfo ATI, AnnotationConstraint AC) {
		HorizontalPanel HP=new HorizontalPanel();
		setAutoHideEnabled(true);
		setGlassEnabled(true);
		setHTML("Anotation Target");
		AtributePanel AConstrains=Factory.generaAP(ATI);
		
		AtributePanel AInfo=Factory.generaAP(AC);
		HP.add(AInfo);
		HP.add(AConstrains);
		setWidget(HP);
	}

}
