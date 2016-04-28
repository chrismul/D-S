package com.chrismuldoon.development.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

	@Entity 
	@Table(name="playlist_track")
	@XmlRootElement
	public class PlaylistTrack implements Serializable {

		private static final long serialVersionUID = 1L;
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name="playlistTrackId") private String playlistTrackId;
		
		@ManyToOne
		@JoinColumn(name="playlistId", referencedColumnName = "playlistId", updatable = false)
		private Playlist playlist;
		
		@ManyToOne
		@JoinColumn(name="trackId", referencedColumnName = "trackId", updatable = false)
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
