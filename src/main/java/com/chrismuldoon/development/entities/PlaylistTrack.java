package com.chrismuldoon.development.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

	import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnore;


	@Entity 
	@Table(name="playlist_track")
	@XmlRootElement
	public class PlaylistTrack implements Serializable {

		private static final long serialVersionUID = 1L;
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name="id") private String id;
		
		@ManyToOne
		@JoinColumn(name="playlist_id", referencedColumnName = "id", updatable = false)
		private Playlist playlist;
		
		@ManyToOne
		@JoinColumn(name="track_id", referencedColumnName = "track_id", updatable = false)
		private Track track;

		public PlaylistTrack(Playlist playlist, Track track) {
			super();
			this.playlist = playlist;
			this.track = track;
		}
		
		public PlaylistTrack(){}

		public Playlist getPlaylist() {
			return playlist;
		}

		public void setPlaylist(Playlist playlist) {
			this.playlist = playlist;
		}

		public Track getTrack() {
			return track;
		}

		public void setTrack(Track track) {
			this.track = track;
		}
		
		
	    
	}
