package com.wurzburg.interedition.client;

import java.util.ArrayList;

import com.gargoylesoftware.htmlunit.DialogWindow;

import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.HorizontalSplitPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.wurzburg.interedition.client.entity.AnnotationBody;
import com.wurzburg.interedition.client.entity.AnnotationTargetInstance;
import com.wurzburg.interedition.client.factoria.Factory;

public class AnnotationURIs extends DialogBox {

	public AnnotationURIs(AnnotationBody AB,ArrayList<AnnotationTargetInstance> ListTI) {
		setHTML("Annotation");
		setAutoHideEnabled(true);
		setGlassEnabled(true);
		setModal(true);
		setSize("722px", "362px");
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		setWidget(horizontalPanel);
		horizontalPanel.setSize("409px", "316px");
		
		VerticalPanel verticalPanel = new VerticalPanel();
		horizontalPanel.add(verticalPanel);
		verticalPanel.setSize("360px", "100%");
		
		AtributePanel atributePanel = Factory.generaAP(AB);
		verticalPanel.add(atributePanel);
		atributePanel.setSize("100%", "100%");
		
		VerticalPanel verticalPanel_1 = new VerticalPanel();
		verticalPanel_1.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		horizontalPanel.add(verticalPanel_1);
		verticalPanel_1.setSize("100%", "100%");
		
		DecoratorPanel decoratorPanel = new DecoratorPanel();
		verticalPanel_1.add(decoratorPanel);
		decoratorPanel.setSize("100%", "100%");
		
		VerticalPanel verticalPanel_2 = new VerticalPanel();
		decoratorPanel.setWidget(verticalPanel_2);
		verticalPanel_2.setSize("100%", "100%");
		
		DecoratorPanel decoratorPanel_1 = new DecoratorPanel();
		verticalPanel_2.add(decoratorPanel_1);
		decoratorPanel_1.setSize("100%", "100%");
		
		Label lblAnnotationTargets = new Label("Annotation Targets\r\n");
		lblAnnotationTargets.setStyleName("gwt-LabelTitle");
		decoratorPanel_1.setWidget(lblAnnotationTargets);
		lblAnnotationTargets.setSize("100%", "100%");
		
		DecoratorPanel decoratorPanel_2 = new DecoratorPanel();
		verticalPanel_2.add(decoratorPanel_2);
		decoratorPanel_2.setSize("100%", "100%");
		
		SimplePanel simplePanel = new SimplePanel();
		decoratorPanel_2.setWidget(simplePanel);
		simplePanel.setSize("323px", "250px");
		
		ScrollPanel scrollPanel = new ScrollPanel();
		simplePanel.setWidget(scrollPanel);
		scrollPanel.setSize("100%", "100%");
		
		for (int j = 0; j < ListTI.size(); j++) {
			BotonSpecial button = new BotonSpecial(Integer.toString(j+1),ListTI.get(j));
			button.addClickHandler(new ClickHandler() {
				public void onClick(ClickEvent event) {
					AnnotationTargetInstance ATargetInstance= ((BotonSpecial)(event.getSource())).getATargetInstance();
					AnnotationTargetURI ATU=new AnnotationTargetURI(ATargetInstance.getAnnotationTargetInfo(),ATargetInstance.getAnnotationConstraint());
					ATU.center();
				}
			});
			scrollPanel.setWidget(button);
			button.setSize("100%", "100%");
		}
		
	}

	

}
