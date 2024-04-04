package com.pokemonDB.models;

public class Trainers {
	public int id;
	public String name;
	public String username;
	public int trainerID;
	
	public Trainers () {
		}
	
	public Trainers (String name, String username, int trainerID) {
		
		this.name = name;
		this.username = username;
		this.trainerID = trainerID;
	}
	
	public int get_id () {
		return id;
	}
	
	public void get_id (int id) {
		this.id = id;
	}
	
	public String get_name () {
		return name;
	}
	
	public void set_name (String name) {
		this.name = name;
	}
	
	public String get_username () {
		return username;
	}
	
	public void set_username (String username) {
		this.username = username;
	}
	
	public int get_trainerID () {
		return trainerID;
	}
	
	public void set_trainerID (int trainerID) {
		this.trainerID = trainerID;
	}
}
