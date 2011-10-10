package com.wurzburg.interedition.server;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import org.eclipse.jdt.internal.compiler.classfmt.AnnotationInfo;
import org.mortbay.util.Scanner.BulkListener;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import com.wurzburg.interedition.client.entity.Annotation;
import com.wurzburg.interedition.client.entity.AnnotationBody;
import com.wurzburg.interedition.client.entity.AnnotationConstraint;
import com.wurzburg.interedition.client.entity.AnnotationTargetInfo;
import com.wurzburg.interedition.client.entity.AnnotationTargetInstance;
import com.wurzburg.interedition.client.service.GWTService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.StringTokenizer;

public class GWTServiceImpl extends RemoteServiceServlet implements GWTService {

	private static ArrayList<Long> ids;
	@PersistenceContext(name = "System")
	private EntityManager entityManager;
	private EntityTransaction entityTransaction;

	public Annotation getAnnotationByURI(String annotationURI) {

		URL url;
		URLConnection connection;
		String line;
		StringBuilder builder = new StringBuilder();
		BufferedReader reader;
		String stringJSON = null;
		ArrayList<Annotation> annotations = new ArrayList<Annotation>();
		Annotation annotation = new Annotation();
		try {
			url = new URL(annotationURI + ".json");
			connection = url.openConnection();
			connection.addRequestProperty("Referer",
					"http://kido180020783.appspot.com/");
			reader = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			while ((line = reader.readLine()) != null) {
				builder.append(line);
			}

			JSONObject json = new JSONObject(builder.toString());
			JSONObject responseObject = json.getJSONObject("annotation");
			JSONArray results = responseObject
					.getJSONArray("annotation_target_instances");
			AnnotationBody annotationBody = new AnnotationBody(responseObject
					.getJSONObject("annotation_body").getString("uri"),
					responseObject.getJSONObject("annotation_body").getString(
							"mime_type"), responseObject.getJSONObject(
							"annotation_body").getString("created_at"),
					responseObject.getJSONObject("annotation_body").getString(
							"updated_at"));
			annotationBody.setContent(getAnnotationBodyContent(annotationBody
					.getUri()));
			ArrayList<AnnotationTargetInstance> annotationsTargetInstances = new ArrayList<AnnotationTargetInstance>();

			AnnotationTargetInstance annotationTargetInstance;
			for (int i = 0; i < results.length(); i++) {
				JSONObject jsonTargetInstace = results.getJSONObject(i);
				AnnotationConstraint annotationContraint = new AnnotationConstraint(
						jsonTargetInstace
								.getJSONObject("annotation_target_instance")
								.getJSONObject("annotation_constraint")
								.getString("position"), jsonTargetInstace
								.getJSONObject("annotation_target_instance")
								.getJSONObject("annotation_constraint")
								.getString("checksum"), jsonTargetInstace
								.getJSONObject("annotation_target_instance")
								.getJSONObject("annotation_constraint")
								.getString("context"), jsonTargetInstace
								.getJSONObject("annotation_target_instance")
								.getJSONObject("annotation_constraint")
								.getString("created_at"), jsonTargetInstace
								.getJSONObject("annotation_target_instance")
								.getJSONObject("annotation_constraint")
								.getString("updated_at"));
				AnnotationTargetInfo annotationTargetInfo = new AnnotationTargetInfo(
						jsonTargetInstace
								.getJSONObject("annotation_target_instance")
								.getJSONObject("annotation_target_info")
								.getString("uri"), jsonTargetInstace
								.getJSONObject("annotation_target_instance")
								.getJSONObject("annotation_target_info")
								.getString("mime_type"));
				annotationTargetInstance = new AnnotationTargetInstance(
						annotationContraint, annotationTargetInfo);
				annotationsTargetInstances.add(annotationTargetInstance);
			}
			annotation = new Annotation(annotationBody,
					annotationsTargetInstances);

		} catch (MalformedURLException ex) {
			Logger.getLogger(GWTServiceImpl.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (IOException ex) {
			Logger.getLogger(GWTServiceImpl.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (JSONException ex) {
			Logger.getLogger(GWTServiceImpl.class.getName()).log(Level.SEVERE,
					null, ex);
		}
		return annotation;
	}

	public String getAnnotationBodyContent(String uri) {

		URL url;
		URLConnection connection;
		String line;
		StringBuilder builder = new StringBuilder();
		BufferedReader reader;
		String stringJSON = null;
		String annotationBodyContent = new String();
		try {
			url = new URL(uri + ".json");
			connection = url.openConnection();
			connection.addRequestProperty("Referer",
					"http://kido180020783.appspot.com/");
			reader = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			while ((line = reader.readLine()) != null) {
				builder.append(line);
			}

			JSONObject json = new JSONObject(builder.toString());
			JSONObject responseObject = json.getJSONObject("annotation_body");
			annotationBodyContent = responseObject.getString("content");

		} catch (MalformedURLException ex) {
			Logger.getLogger(GWTServiceImpl.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (IOException ex) {
			Logger.getLogger(GWTServiceImpl.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (JSONException ex) {
			Logger.getLogger(GWTServiceImpl.class.getName()).log(Level.SEVERE,
					null, ex);
		}

		return annotationBodyContent;

	}

	@Override
	public ArrayList<String> getAnnotationsURI(String targetURI) {
		URL url;
		URLConnection connection;
		String line;
		StringBuilder builder = new StringBuilder();
		BufferedReader reader;
		String stringJSON = null;
		ArrayList<String> annotationsURIs = new ArrayList<String>();

		try {
			url = new URL(targetURI);
			connection = url.openConnection();
			connection.addRequestProperty("Referer",
					"http://kido180020783.appspot.com/");
			reader = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			while ((line = reader.readLine()) != null) {
				builder.append(line);
			}

			JSONArray results = new JSONArray(builder.toString());

			for (int i = 0; i < results.length(); i++) {
				JSONObject jsonAnnotations = results.getJSONObject(i);
				annotationsURIs.add(jsonAnnotations.getJSONObject("annotation")
						.getString("uri"));
			}

		} catch (MalformedURLException ex) {
			Logger.getLogger(GWTServiceImpl.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (IOException ex) {
			Logger.getLogger(GWTServiceImpl.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (JSONException ex) {
			Logger.getLogger(GWTServiceImpl.class.getName()).log(Level.SEVERE,
					null, ex);
		}
		return annotationsURIs;
	}

}
