/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wurzburg.interedition.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.wurzburg.interedition.client.entity.Annotation;

import java.util.ArrayList;


/**
 * 
 * @author Cesar y Joaquin
 */
@RemoteServiceRelativePath("book.reader/gwtservice")
public interface GWTService extends RemoteService {

	public Annotation getAnnotationByURI(String annotationURI);
	
	public ArrayList<String> getAnnotationsURI(String targetURI);

	
}
