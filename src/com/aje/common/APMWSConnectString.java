/* Clase    : Connection
 * Autor    : Wilmer Reyes Alfaro
 * Revision : 22/06/2013 12:45
 * Funcion  : Permite obtener la cadena de conexi�n hacia la base de datos APM. 
 * 			  Se obtiene a partir del archivo config.xml de la carpeta conf del proyecto.
 * */
package com.aje.common;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class APMWSConnectString extends DefaultHandler {
	String xmlFileName;
	String tmpValue;
	String WSName;
	String WSUrlServiceRecuperar;
	static String WSUrlServiceCargar;
	String WSUser;
	String WSPassword;
	OperatingSystem OS = new OperatingSystem();
	Boolean fName;
	Boolean fUrlServiceRecuperar;
	Boolean fUrlServiceCargar;
	Boolean fUser;
	Boolean fPassword;

	public APMWSConnectString() {
		ResourcePath resource = new ResourcePath(this);

		// Obtener archivo de carpeta Build o WEB-INF del proyecto
		this.xmlFileName = resource.getWEBINFpath() + OS.getOSPathDelimiter()
				+ "conf" + OS.getOSPathDelimiter() + "APM_WSConfig.xml"; // Windows

		parseDocument();
	}

	private void parseDocument() {
		// parse
		SAXParserFactory factory = SAXParserFactory.newInstance();
		fName = false;
		fUrlServiceRecuperar = false;
		fUrlServiceCargar = false;
		fUser = false;
		fPassword = false;

		try {
			SAXParser parser = factory.newSAXParser();
			parser.parse(this.xmlFileName, this);
		} catch (ParserConfigurationException e) {
			System.out.println("ParserConfig error: " + e.getMessage());
			e.printStackTrace();
		} catch (SAXException e) {
			System.out.println("SAXException : xml not well formed | "
					+ e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IO Error: " + e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public void startElement(String s, String s1, String elementName,
			Attributes attributes) throws SAXException {

		if (elementName.equalsIgnoreCase("name")) {
			fName = true;
		}
		if (elementName.equalsIgnoreCase("urlServiceRecuperar")) {
			fUrlServiceRecuperar = true;
		}
		if (elementName.equalsIgnoreCase("urlServiceCargar")) {
			fUrlServiceCargar = true;
		}
		if (elementName.equalsIgnoreCase("user")) {
			fUser = true;
		}
		if (elementName.equalsIgnoreCase("password")) {
			fPassword = true;
		}

	}

	@Override
	public void endElement(String s, String s1, String element)
			throws SAXException {
		// if end of book element add to list

	}

	@Override
	public void characters(char[] ac, int i, int j) throws SAXException {
		if (fName) {
			this.setName(new String(ac, i, j));
			fName = false;
		}
		if (fUrlServiceRecuperar) {
			this.setUrlServiceRecuperar(new String(ac, i, j));
			fUrlServiceRecuperar = false;
		}
		if (fUrlServiceCargar) {
			this.setUrlServiceCargar(new String(ac, i, j));
			fUrlServiceCargar = false;
		}
		if (fUser) {
			this.setUser(new String(ac, i, j));
			fUser = false;
		}
		if (fPassword) {
			this.setPassword(new String(ac, i, j));
			fPassword = false;
		}
	}

	public String getName() {
		return WSName;
	}

	public void setName(String name) {
		this.WSName = name;
	}

	public String getServiceRecuperar() {
		return WSUrlServiceRecuperar;
	}

	public void setUrlServiceRecuperar(String service) {
		this.WSUrlServiceRecuperar = service;
	}

	public static String getServiceCargar() {
		return WSUrlServiceCargar;
	}

	public void setUrlServiceCargar(String service) {
		this.WSUrlServiceCargar = service;
	}

	public String getUser() {
		return WSUser;
	}

	public void setUser(String dataBaseUser) {
		this.WSUser = dataBaseUser;
	}

	public String getPassword() {
		return WSPassword;
	}

	public void setPassword(String dataBasePassword) {
		this.WSPassword = dataBasePassword;
	}

}
