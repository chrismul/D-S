package com.chrismuldoon.development.services;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import com.chrismuldoon.development.entities.Library;
import com.chrismuldoon.development.entities.Playlist;
import com.chrismuldoon.development.entities.PlaylistTrack;
import com.chrismuldoon.development.entities.Track;
import com.mysql.fabric.xmlrpc.base.Array;

public class XMLParser {

	public ArrayList<Track> tracks = new ArrayList<Track>();

	public ArrayList<Playlist> playlists = new ArrayList<Playlist>();

	public ArrayList<PlaylistTrack> allplaylisttrack = new ArrayList<PlaylistTrack>();

	private HashMap<Integer, Track> trackMap = new HashMap<Integer, Track>();

	public Library library = new Library();

	public XMLParser() {}

	public void parseXML() {


		try {

			String filePath = "C:/Users/Chris/Desktop/Library3.xml";
			File xmlFile = new File(filePath);

			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			Document doc = builder.parse(xmlFile);

			Element root = doc.getDocumentElement();
			NodeList c = root.getChildNodes();

			getLibraryDict(c);
			
			for(Track track: trackMap.values()){
				tracks.add(track);
			}


		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}


	private void getLibraryDict(NodeList nodeList) {
		//cycles through list and creates node from each one in list
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);

			//if node name is dict
			//this is where library starts
			//makes a list of nodes children
			if (node.getNodeName().contains("dict")) {
				NodeList childrenOfDictNode = node.getChildNodes();


				//cycles through list and creates node from each one in list
				for (int j = 0; j < childrenOfDictNode.getLength(); j++) {
					Node node2 = childrenOfDictNode.item(j);

					if(node2.getTextContent().contains("Library Persistent ID")){
						library.setId(node2.getNextSibling().getTextContent());
					}
					//if node name is dict
					//this is where tracks start
					//makes a list of nodes children
					if (node2.getNodeName().contains("dict")) {
						NodeList nodeList2 = node2.getChildNodes();
						getTracksDict(nodeList2);
					}

					if (node2.getNodeName().contains("array")) {
						NodeList nodeList2 = node2.getChildNodes();
						getPlaylistsDict(nodeList2);
					}

				}
			}
		}
	}




	private void getTracksDict(NodeList nodeList) {
		//cycles through list and creates node from each one in list
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);

			//if node name is dict
			//this is where info for individual tracks are
			//makes a list of nodes children
			//passes to method to get individual track info
			if (node.getNodeName().contains("dict")) {
				NodeList list = nodeList.item(i).getChildNodes();
				getIndividualTracksFromDict(list);
			}
		}
	}

	private void getIndividualTracksFromDict(NodeList nodeList){
		Track track = new Track();	
		for (int i = 0; i < nodeList.getLength(); i++) {

			Node node = nodeList.item(i);



			if(node.getTextContent().contains("Track ID")){
				int trackId = Integer.parseInt(node.getNextSibling().getTextContent());
				track.setId(trackId);
			}
			if (node.getTextContent().contains("Name")) {
				track.setName(node.getNextSibling().getTextContent());
			}
			if (node.getTextContent().contains("Artist")) {
				track.setArtist(node.getNextSibling().getTextContent());
			}
			if (node.getTextContent().contains("Album")) {
				track.setAlbum(node.getNextSibling().getTextContent()); 
			}
			if (node.getTextContent().contains("Genre")) {
				track.setGenre(node.getNextSibling().getTextContent());
			}
			if (node.getTextContent().contains("Year")) {
				track.setYear(node.getNextSibling().getTextContent());
			}

			if (node.getTextContent().contains("Location")) {
				track.setLocation(node.getNextSibling().getTextContent());
			}



		}

		trackMap.put(track.getId(), track);

		//	tracks.add(track);
	}


	private void getPlaylistsDict(NodeList nodeList) {
		//cycles through list and creates node from each one in list
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);

			//if node name is dict
			//this is where info for individual tracks are
			//makes a list of nodes children
			//passes to method to get individual track info
			if (node.getNodeName().contains("dict")) {
				NodeList list = nodeList.item(i).getChildNodes();
				getIndividualPlaylistsFromDict(list);
			}
		}
	}

	private void getIndividualPlaylistsFromDict(NodeList nodeList){
		Playlist playlist = new Playlist();	
		
		for (int i = 0; i < nodeList.getLength(); i++) {

			Node node = nodeList.item(i);


			playlist.setLibrary(library);
			if(node.getTextContent().contains("Playlist ID")){
				int playlistId = Integer.parseInt(node.getNextSibling().getTextContent());
				playlist.setId(playlistId);
			}
			if (node.getTextContent().contains("Name")) {
				playlist.setPlaylistName(node.getNextSibling().getTextContent());
			}

			if(node.getNodeName().contains("array")){
				NodeList list = nodeList.item(i).getChildNodes();

				for (int j = 0; j < list.getLength(); j++) {
					NodeList list2 = list.item(j).getChildNodes();

					for (int k = 0; k < list2.getLength(); k++) {
						if(list2.item(k).getNodeName().equals("integer")){

							Integer ptId = Integer.parseInt(list2.item(k).getTextContent());
							Track t = trackMap.get(ptId);
							
							PlaylistTrack playlisttrack = new PlaylistTrack(playlist, t);
							
							allplaylisttrack.add(playlisttrack);
						}

					}
				}
			}
		}

//		playlistMap.put(playlist.getId(), playlist);
		playlists.add(playlist);
	}





		public ArrayList<Track> getAllTracks(){
			return tracks;
			
		}
		
		public ArrayList<Playlist> getAllPlaylists(){
			return playlists;
			
		}
		
		public ArrayList<PlaylistTrack> getAllPlaylistTracks(){
			return allplaylisttrack;
			
		}



	public Library getLibrary(){
		return library;
	}


}

/*

 //	System.out.println("Artist: "+artist);
//	System.out.println("Title: "+name);
//	System.out.println("Album: "+album);
//	System.out.println("Genre: "+genre);
//	System.out.println("Year: "+year);
//	System.out.println("Location: "+location);
//
//	System.out.println("");



 package parser;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLParser {



	private void getLibraryDict(NodeList nodeList) {
		//cycles through list and creates node from each one in list
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);


			//if node name is dict
			//this is where library starts
			//makes a list of nodes children
			if (node.getNodeName().contains("dict")) {
				NodeList childrenOfDictNode = node.getChildNodes();


				//cycles through list and creates node from each one in list
				for (int j = 0; j < childrenOfDictNode.getLength(); j++) {
					Node node2 = childrenOfDictNode.item(j);

					//if node name is dict
					//this is where tracks start
					//makes a list of nodes children
					if (node2.getNodeName().contains("dict")) {
						NodeList nodeList2 = node2.getChildNodes();
						getTracksDict(nodeList2);
					}

				}
			}
		}
	}




	private void getTracksDict(NodeList nodeList) {
		//cycles through list and creates node from each one in list
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);

			//if node name is dict
			//this is where info for individual tracks are
			//makes a list of nodes children
			//passes to method to get individual track info
			if (node.getNodeName().contains("dict")) {
				NodeList list = nodeList.item(i).getChildNodes();
				getIndividualTracksFromDict(list);
			}
		}
	}

	private void getIndividualTracksFromDict(NodeList nodeList){
		String name = null;
		String artist = null;
		String album = null;
		String genre = null;
		String year = null;
		String location = null;

	for (int i = 0; i < nodeList.getLength(); i++) {

		Node node = nodeList.item(i);

		if (node.getTextContent().contains("Name")) {
			name = node.getNextSibling().getTextContent();
		}
		if (node.getTextContent().contains("Artist")) {
			artist = node.getNextSibling().getTextContent();
		}
		if (node.getTextContent().contains("Album")) {
			album = node.getNextSibling().getTextContent();
		}
		if (node.getTextContent().contains("Genre")) {
			genre = node.getNextSibling().getTextContent();
		}
		if (node.getTextContent().contains("Year")) {
			year = node.getNextSibling().getTextContent();
		}

		if (node.getTextContent().contains("Location")) {
			location = node.getNextSibling().getTextContent();
	}

	}

	System.out.println("Artist: "+artist);
	System.out.println("Title: "+name);
	System.out.println("Album: "+album);
	System.out.println("Genre: "+genre);
	System.out.println("Year: "+year);
	System.out.println("Location: "+location);

	System.out.println("");
	}

	public static void main(String[] args) {
		try {
			String filePath = "C:/Users/D15122952/Desktop/itunes.xml";
			File xmlFile = new File(filePath);

			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			Document doc = builder.parse(xmlFile);

			Element root = doc.getDocumentElement();
			NodeList c = root.getChildNodes();

			XMLParser x = new XMLParser();
			x.getLibraryDict(c);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}



 */