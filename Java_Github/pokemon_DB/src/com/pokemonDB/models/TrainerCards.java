package com.pokemonDB.models;

public class TrainerCards {
	private int id;
	private String name;
	private int collectionN;
	private String type;
	
	public TrainerCards () {
		
	}
	public TrainerCards (String name, int collectionN, String type) {
		this.name = name;
		this.collectionN = collectionN;
		this.type = type;
	}
	
	public int get_id () {
		return id;
	}
	
	public void set_id (int id) {
		this.id = id;
	}
	
	public String get_name () {
		return name;
	}
	
	public void set_name (String name) {
		this.name = name;
	}
	
	public int get_collectionN () {
		return collectionN;
	}
	
	public void set_collectionN (int collectionN) {
		this.collectionN = collectionN;
	}
	
	public String get_type () {
		return type;
	}
	
	public void set_type (String type) {
		this.type = type;
	}
}


