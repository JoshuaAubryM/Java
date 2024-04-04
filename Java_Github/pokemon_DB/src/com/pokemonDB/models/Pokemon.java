package com.pokemonDB.models;

public class Pokemon {
	public int id;
	public String name;
	public int collectionN;
	public int HP;
	public String stage;
	public String type;
	
	public Pokemon() {
	}
	
	public Pokemon (String name, int collectionN, int HP, String stage, String type) {
		
		this.name = name;
		this.collectionN = collectionN;
		this.HP = HP;
		this.stage = stage;
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
	
	public int get_HP () {
		return HP;
	}
	
	public void set_HP (int HP) {
		this.HP = HP;
	}
	
	public String get_stage () {
		return stage;
	}
	
	public void set_stage (String stage) {
		this.stage = stage;
	}
	
	public String get_type () {
		return type;
	}
	
	public void set_type (String type) {
		this.type = type;
	}
}
