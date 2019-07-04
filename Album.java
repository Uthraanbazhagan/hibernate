package com.lti.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="TBL_ALBUM")
public class Album {
 private String name;
 @Id
 @GeneratedValue
 @Column(name ="AL_ID")
 private int id;
 private String copyright;
 public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getCopyright() {
	return copyright;
}
public void setCopyright(String copyright) {
	this.copyright = copyright;
}
public int getYear() {
	return year;
}
public void setYear(int year) {
	this.year = year;
}
public Set<Song> getSongs() {
	return songs;
}
public void setSongs(Set<Song> songs) {
	this.songs = songs;
}
private int year;
@OneToMany(mappedBy="album")
 private Set<Song> songs;
}
