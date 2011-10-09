package com.wurzburg.interedition.server;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
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
	@PersistenceContext(name = "BookReader11Abr01PU")
	private EntityManager entityManager;
	private EntityTransaction entityTransaction;

	
	

}
