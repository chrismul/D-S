package com.chrismuldoon.development.services;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.*;

import com.chrismuldoon.development.entities.Library;
import com.chrismuldoon.development.entities.Playlist;
import com.chrismuldoon.development.entities.PlaylistTrack;
import com.chrismuldoon.development.entities.Track;

public class XMLParser {

	public ArrayList<Track> tracks = new ArrayList<Track>();

	public ArrayList<Playlist> playlists = new ArrayList<Playlist>();

	public ArrayList<PlaylistTrack> allplaylisttrack = new ArrayList<PlaylistTrack>();

	private HashMap<Integer, Track> trackMap = new HashMap<Integer, Track>();

	public Library library = new Library();

	public XMLParser() {}

	public void parseXML(String filename) {


		try {

			File xmlFile = new File("C:/Users/Chris/Desktop/"+filename);

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
						library.setLibraryPersistentId(node2.getNextSibling().getTextContent());
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
				track.setTrackId(trackId);
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
		trackMap.put(track.getTrackId(), track);
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
				playlist.setPlaylistId(playlistId);
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
