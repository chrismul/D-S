package com.chrismuldoon.development.services;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class XMLParser {

	public XMLParser() {
		// TODO Auto-generated constructor stub
	}

	public void parseXML(String filename) {
					
			
			try {
				String path = "c:/xml/"+filename;
				File xmlFile = new File(path);
				
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				DocumentBuilder builder = factory.newDocumentBuilder();
				
				Document doc = builder.parse(xmlFile);
				
				Element root = doc.getDocumentElement();
				NodeList childNodes = root.getChildNodes();
				
			} catch (Exception ex){
				ex.printStackTrace();
			}
			
		}
	}

/*
package parser;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLParser {

	private void populateLibrary(NodeList nodeList) {
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);

			if (node.getNodeName().equals("dict")) {
				NodeList nodeChildren = node.getChildNodes();

				for (int j = 0; j < nodeChildren.getLength(); j++) {
					Node node2 = nodeChildren.item(j);

					if (node2.getNodeName().equals("dict")) {
						NodeList nodeList2 = node2.getChildNodes();
						getTracks(nodeList2);
					}

				}
			}
		}
	}
	
	
	
	

	private void getTracks(NodeList nodeList) {
		for (int i = 0; i < nodeList.getLength(); i++) {
			if (nodeList.item(i).getNodeName().equals("dict")) {
				
				NodeList innerList = nodeList.item(i).getChildNodes();
				for (int j = 0; j < innerList.getLength(); j++) {

					if (innerList.item(j).getTextContent().equals("Name")) {
						System.out.println(innerList.item(j).getNextSibling()
								.getTextContent());
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		try {
			String path = "C:/Users/Chris/Desktop/itunes.xml";
			File xmlFile = new File(path);

			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			Document doc = builder.parse(xmlFile);

			Element root = doc.getDocumentElement();
			NodeList c = root.getChildNodes();

			XMLParser x = new XMLParser();
			x.populateLibrary(c);

			// Node tracks = root.;
			// NodeList nodeList = tracks.getChildNodes();
			// System.out.println("Number of tracks = "+ tracks.getLength());

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}*/