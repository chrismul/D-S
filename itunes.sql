DROP SCHEMA IF EXISTS iTunesLibrary ;

CREATE SCHEMA IF NOT EXISTS iTunesLibrary DEFAULT CHARACTER SET utf8 ;
USE iTunesLibrary ;

-- -----------------------------------------------------
-- Table `iTunesLibrary`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS users ;

CREATE TABLE IF NOT EXISTS users (
  username VARCHAR(45) NOT NULL,
  password VARCHAR(45) NOT NULL,
  PRIMARY KEY (username))
ENGINE = InnoDB;

insert into users values('John','123');
insert into users values('Kevin','123');
insert into users values('Joe','123');

-- -----------------------------------------------------
-- Table `iTunesLibrary`.`Libraries`
-- -----------------------------------------------------
DROP TABLE IF EXISTS libraries ;

CREATE TABLE IF NOT EXISTS libraries (
  libraryPersistentId VARCHAR(45),
  username VARCHAR(45) NULL,
  PRIMARY KEY (libraryPersistentId),
     FOREIGN KEY (username)
    REFERENCES users (username))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `iTunesLibrary`.`Playlists`
-- -----------------------------------------------------
DROP TABLE IF EXISTS playlists ;

CREATE TABLE IF NOT EXISTS playlists (
  playlistId INT NOT NULL AUTO_INCREMENT,
  playlistName VARCHAR(100) NULL,
  libraryPersistentId  VARCHAR(100) NULL,
  PRIMARY KEY (playlistId),
  FOREIGN KEY (libraryPersistentId)
    REFERENCES libraries (libraryPersistentId))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `iTunesLibrary`.`Tracks`
-- -----------------------------------------------------
DROP TABLE IF EXISTS tracks ;

CREATE TABLE IF NOT EXISTS tracks (
  trackId INT NOT NULL,
  name VARCHAR(100) NOT NULL,
  artist VARCHAR(100) NULL,
  album VARCHAR(100) NULL,
  genre VARCHAR(45) NULL,
  year VARCHAR(45) NULL,
  location VARCHAR(1000) NOT NULL,
  PRIMARY KEY (trackId))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `iTunesLibrary`.`Playlists_tracks`
-- -----------------------------------------------------
DROP TABLE IF EXISTS playlist_track ;

CREATE TABLE IF NOT EXISTS playlist_track (
  playlistTrackId INT NOT NULL AUTO_INCREMENT,
  playlistId INT NOT NULL,
  trackId INT NOT NULL,
  PRIMARY KEY (playlistTrackId),
  FOREIGN KEY (playlistId)
	REFERENCES playlists (playlistId),
  FOREIGN KEY (trackId)
    REFERENCES tracks (trackId))
ENGINE = InnoDB;

set FOREIGN_KEY_CHECKS=1;

