/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wurzburg.interedition.client.service;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.wurzburg.interedition.client.entity.Annotation;


/**
 * 
 * @author Cesar y Gayoso.
 */
public interface GWTServiceAsync {

	void getAnnotationByURI(String annotationURI,
			AsyncCallback<Annotation> callback);

	void getAnnotationsURI(String targetURI,
			AsyncCallback<ArrayList<String>> callback);

	
}
