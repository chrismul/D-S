package com.chrismuldoon.development.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnore;


@Entity 
@Table(name="users")
@XmlRootElement
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="username") private String username; 
	@Column(name="password") private String password; 

	@JsonIgnore
    @OneToMany(mappedBy="user", cascade={CascadeType.MERGE, CascadeType.PERSIST})
    private Set<Library> libraries = new HashSet<Library>();

    public Set<Library> getLibraries() {
                    return libraries;
    }

    public void setLibraries(Set<Library> libraries) {
                    this.libraries = libraries;
    }
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public User() {}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}	
	
}
