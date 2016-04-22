package com.chrismuldoon.development.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by nicktodd on 09/09/2014.
 */
@XmlRootElement // this is required to enable JSON serialization
public class TrackList implements Serializable {

	private Collection<Track> trackCollection;
	
    public Collection<Track> getTrackCollection() {
        return trackCollection;
    }

    public void setTrackCollection(Collection<Track> trackCollection) {
        this.trackCollection = trackCollection;
    }


    




}
