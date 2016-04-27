package com.chrismuldoon.development.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement 
public class TrackList implements Serializable {

	private static final long serialVersionUID = 1L;
	private Collection<Track> trackCollection;
	
    public Collection<Track> getTrackCollection() {
        return trackCollection;
    }

    public void setTrackCollection(Collection<Track> trackCollection) {
        this.trackCollection = trackCollection;
    }

}
