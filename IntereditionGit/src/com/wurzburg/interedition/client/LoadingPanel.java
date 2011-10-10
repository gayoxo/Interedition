package com.wurzburg.interedition.client;

import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Image;

public class LoadingPanel extends PopupPanel{

	private static LoadingPanel LP;
	
	public static LoadingPanel getInstance()
	{
	if (LP==null) LP=new LoadingPanel();
	return LP;
	} 
	
	private LoadingPanel() {
		setGlassEnabled(true);
		setModal(true);
		Image image = new Image("ajax-loader.gif");
		setWidget(image);
		image.setSize("30px", "30px");
		// TODO Auto-generated constructor stub
	}
	
	
}
