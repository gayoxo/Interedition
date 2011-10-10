package com.wurzburg.interedition.client.factoria;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.wurzburg.interedition.client.AnnotationURIs;
import com.wurzburg.interedition.client.AtributePanel;
import com.wurzburg.interedition.client.BotonSpecialAnnot;
import com.wurzburg.interedition.client.LoadingPanel;
import com.wurzburg.interedition.client.entity.Annotation;
import com.wurzburg.interedition.client.entity.AnnotationBody;
import com.wurzburg.interedition.client.entity.AnnotationConstraint;
import com.wurzburg.interedition.client.entity.AnnotationTargetInfo;
import com.wurzburg.interedition.client.entity.AnnotationTargetInstance;
import com.wurzburg.interedition.client.service.GWTService;
import com.wurzburg.interedition.client.service.GWTServiceAsync;

public class Factory {

	
	static GWTServiceAsync intereditionServiceHolder = GWT
			.create(GWTService.class);
	
	public static AtributePanel generaAP(Object O)
	{
		if (O instanceof String)
			{
			String AA=(String)O;
			AtributePanel AP= new AtributePanel(true,AnnotationNameLabels.title,new ClickHandler() {
				
				
				@Override
				public void onClick(ClickEvent event) {
					
					String AA=(String)((BotonSpecialAnnot)event.getSource()).getObject();
					LoadingPanel.getInstance().center();
					intereditionServiceHolder.getAnnotationByURI(AA, new AsyncCallback<Annotation>() {
						
						@Override
						public void onSuccess(Annotation result) {
							AnnotationURIs AP=new AnnotationURIs(result.getAnnotationBody(),result.getAnnotationsTargetInstances());
							AP.center();
							LoadingPanel.getInstance().hide();

							
						}
						
						@Override
						public void onFailure(Throwable caught) {
							Window.alert("Some error has occured loading Annotation");
							LoadingPanel.getInstance().hide();
						}
					});
					
					
				}
			},O);
			
			AP.addCamp(AnnotationNameLabels.annotationURI, AA);
			return AP;
			}
		else if (O instanceof AnnotationBody)
		{
			AnnotationBody AA=(AnnotationBody)O;
			AtributePanel AP= new AtributePanel(false,AnnotationBodyNameLabels.title,null,null);
			
			AP.addCamp(AnnotationBodyNameLabels.annotationBodyURI, AA.getUri());
			AP.addCamp(AnnotationBodyNameLabels.mimeType, AA.getMimeType());
			AP.addCamp(AnnotationBodyNameLabels.content, AA.getContent());
			AP.addCamp(AnnotationBodyNameLabels.createdDate, AA.getCreatedDate());
			AP.addCamp(AnnotationBodyNameLabels.updatedDate, AA.getUpdatedDate());
		
			return AP;
			
		}
		else if (O instanceof AnnotationTargetInfo)
		{
			AnnotationTargetInfo AA=(AnnotationTargetInfo)O;
			AtributePanel AP= new AtributePanel(false,AnnotationTargetNameLabels.titleTarget,null,null);
			
			AP.addCamp(AnnotationTargetNameLabels.uri, AA.getUri());
			AP.addCamp(AnnotationTargetNameLabels.mimeType, AA.getMimeType());
			return AP;
		}
		else if (O instanceof AnnotationConstraint)
		{
			AnnotationConstraint AA=(AnnotationConstraint)O;
			AtributePanel AP= new AtributePanel(false,AnnotationTargetNameLabels.titleConstraint,null,null);
			
			AP.addCamp(AnnotationTargetNameLabels.position, AA.getPosition());
			AP.addCamp(AnnotationTargetNameLabels.checksum, AA.getChecksum());
			AP.addCamp(AnnotationTargetNameLabels.context, AA.getContext());
			AP.addCamp(AnnotationTargetNameLabels.createdDate, AA.getCreatedDate());
			AP.addCamp(AnnotationTargetNameLabels.updatedDate, AA.getUpdatedDate());
			return AP;
		}else
			return null;
	}
}
