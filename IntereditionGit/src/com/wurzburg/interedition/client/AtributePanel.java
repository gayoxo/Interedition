package com.wurzburg.interedition.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ScrollPanel;

public class AtributePanel extends Composite {
	private Label Tittle;
	private VerticalPanel Camps;
	private Object AlmacenTemporal;

	public AtributePanel(boolean OpenPanel, String Tittlein, ClickHandler CHM,Object AlmacenTemporal) {
		
		SimplePanel simplePanel = new SimplePanel();
		initWidget(simplePanel);
		simplePanel.setSize("358px", "100%");
		
		DecoratorPanel decoratorPanel = new DecoratorPanel();
		simplePanel.setWidget(decoratorPanel);
		decoratorPanel.setSize("", "");
		
		VerticalPanel verticalPanel = new VerticalPanel();
		decoratorPanel.setWidget(verticalPanel);
		verticalPanel.setSize("100%", "100%");
		
		DecoratorPanel decoratorPanel_1 = new DecoratorPanel();
		verticalPanel.add(decoratorPanel_1);
		decoratorPanel_1.setSize("100%", "100%");
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		decoratorPanel_1.setWidget(horizontalPanel);
		horizontalPanel.setWidth("100%");
		
		Tittle = new Label(Tittlein);
		Tittle.setStyleName("gwt-LabelTitle");
		horizontalPanel.add(Tittle);
		Tittle.setWidth("253px");
		
		if (OpenPanel) {
			BotonSpecialAnnot btnNewButton = new BotonSpecialAnnot("Open",AlmacenTemporal);
		btnNewButton.addClickHandler(CHM);
		horizontalPanel.add(btnNewButton);
		btnNewButton.setSize("85px", "35px");
		}
		
		DecoratorPanel decoratorPanel_2 = new DecoratorPanel();
		verticalPanel.add(decoratorPanel_2);
		decoratorPanel_2.setSize("100%", "100%");
		
		ScrollPanel scrollPanel = new ScrollPanel();
		decoratorPanel_2.setWidget(scrollPanel);
		scrollPanel.setSize("337px", "250px");
		
		Camps = new VerticalPanel();
		scrollPanel.setWidget(Camps);
		Camps.setSize("100%", "100%");
		
		
		
	}

	public Label getTittle() {
		return Tittle;
	}

	public void setTittle(Label tittle) {
		Tittle = tittle;
	}

	public void addCamp(String nombre,String Asiciado)
	{
		Camp C = new Camp(nombre, Asiciado);
		Camps.add(C);
	}

	public Object getAlmacenTemporal() {
		return AlmacenTemporal;
	}
	
	public void setAlmacenTemporal(Object almacenTemporal) {
		AlmacenTemporal = almacenTemporal;
	}
	
	public VerticalPanel getCamps() {
		return Camps;
	}
	
	public void addCamp(Button b)
	{
		Camps.add(b);
		}
}
