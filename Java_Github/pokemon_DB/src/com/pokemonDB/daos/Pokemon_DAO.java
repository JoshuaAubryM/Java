package com.pokemonDB.daos;

import java.util.List;

import com.pokemonDB.models.Pokemon;

public interface Pokemon_DAO {
	
	 boolean insert_Pokemon(Pokemon pokemon); // Add a new book

	 List<Pokemon> get_All_Pokemon(); // Retrieve all books
	 
	 boolean delete_Pokemon (int collectionN);
	 
	 List<Pokemon> get_pokemon_collectionN (int collectionN);
	 
	 boolean update_Pokemon (int collectionN, String name, String type);
	 
	 
}
