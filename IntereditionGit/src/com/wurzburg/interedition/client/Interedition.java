package com.wurzburg.interedition.client;



import java.util.ArrayList;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.wurzburg.interedition.client.entity.Annotation;
import com.wurzburg.interedition.client.factoria.Factory;
import com.wurzburg.interedition.client.service.GWTService;
import com.wurzburg.interedition.client.service.GWTServiceAsync;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Interedition implements EntryPoint {
	
	private TextBox txtbxHttp;
	private Button btnNewButton;
	private VerticalPanel verticalPanel_2;
	private Button btnClearreset;
	private Label lblNewLabel_1;
	private Label lblError;
	static GWTServiceAsync intereditionServiceHolder = GWT
	.create(GWTService.class);
	
	
	public void onModuleLoad() {
		RootPanel RP=RootPanel.get("APP");
		RP.setStyleName("body");
		RP.setWidth("100%");
		
		VerticalPanel verticalPanel = new VerticalPanel();
		RP.add(verticalPanel);
		verticalPanel.setSize("100%", "");
		
		DecoratorPanel decoratorPanel = new DecoratorPanel();
		verticalPanel.add(decoratorPanel);
		
		FormPanel formPanel = new FormPanel();
		decoratorPanel.setWidget(formPanel);
		formPanel.setMethod(FormPanel.METHOD_POST);
		formPanel.setWidth("100%");
		
		VerticalPanel verticalPanel_1 = new VerticalPanel();
		formPanel.setWidget(verticalPanel_1);
		verticalPanel_1.setSize("100%", "100%");
		
		Grid grid = new Grid(7, 3);
		verticalPanel_1.add(grid);
		
		Label lblTargeturi = new Label("Target URI");
		lblTargeturi.setStyleName("gwt-LabelTitle");
		grid.setWidget(0, 2, lblTargeturi);
		lblTargeturi.setSize("100%", "100%");
		
		Image image = new Image((String) null);
		grid.setWidget(1, 0, image);
		
		txtbxHttp = new TextBox();
		txtbxHttp.setText("http://");
		txtbxHttp.setVisibleLength(100);
		grid.setWidget(1, 2, txtbxHttp);
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		grid.setWidget(2, 2, horizontalPanel);
		horizontalPanel.setWidth("100%");
		
		btnNewButton = new Button("Get");
		btnNewButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				
				LoadingPanel.getInstance().center();
				intereditionServiceHolder.getAnnotationsURI(txtbxHttp.getText(), new AsyncCallback<ArrayList<String>>()
						{

							@Override
							public void onFailure(Throwable caught) {
								lblError.setText("Some error has occured");
								
								LoadingPanel.getInstance().hide();
							}

							@Override
							public void onSuccess(ArrayList<String> result) {
								verticalPanel_2.clear();
								for (String URIString : result) {
									AtributePanel A= Factory.generaAP(URIString);
									A.setSize("100%", "100%");
									verticalPanel_2.add(A);
									
								}
								LoadingPanel.getInstance().hide();
								txtbxHttp.setReadOnly(true);
								btnNewButton.setEnabled(false);
								btnClearreset.setEnabled(true);
								lblError.setText("");
								LoadingPanel.getInstance().hashCode();
								
							}
					
						});
				
				
				
		
				
				
			}
		});
		horizontalPanel.add(btnNewButton);
		
		
		btnClearreset = new Button("Clear/Reset");
		btnClearreset.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				txtbxHttp.setText("http://");
				txtbxHttp.setReadOnly(false);
				btnNewButton.setEnabled(true);
				verticalPanel_2.clear();
				verticalPanel_2.add(lblNewLabel_1);
				lblError.setText("");
			}
		});
		btnClearreset.setEnabled(false);
		horizontalPanel.add(btnClearreset);
		
		lblError = new Label("");
		horizontalPanel.add(lblError);
		lblError.setVisible(false);
		lblError.setStyleName("gwt-Labelred");
		
		Label lblNewLabel = new Label("Result");
		lblNewLabel.setStyleName("gwt-LabelTitle");
		grid.setWidget(5, 2, lblNewLabel);
		
		ScrollPanel scrollPanel = new ScrollPanel();
		grid.setWidget(6, 2, scrollPanel);
		scrollPanel.setHeight("422px");
		
		verticalPanel_2 = new VerticalPanel();
		scrollPanel.setWidget(verticalPanel_2);
		verticalPanel_2.setSize("100%", "100%");
		
		lblNewLabel_1 = new Label("No Annotations!!!");
		lblNewLabel_1.setStyleName("gwt-Labelred");
		verticalPanel_2.add(lblNewLabel_1);
		
		
	}
}
