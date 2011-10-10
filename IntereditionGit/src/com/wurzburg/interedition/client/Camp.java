package com.wurzburg.interedition.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.HasVerticalAlignment;

public class Camp extends Composite {

	public Camp(String CampName,String Textin) {
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		initWidget(horizontalPanel);
		horizontalPanel.setSize("100%", "100%");
		
		Label lblNewLabel = new Label(CampName);
		horizontalPanel.add(lblNewLabel);
		
		TextBox textBox = new TextBox();
		textBox.setVisibleLength(90);
		horizontalPanel.add(textBox);
		textBox.setWidth("90%");
		textBox.setText(Textin);
		textBox.setReadOnly(true);
	}

}
