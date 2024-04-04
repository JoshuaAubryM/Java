package com.pokemonDB.daos;

import java.util.List;

import com.pokemonDB.models.PokemonEx;

public interface PokemonEx_DAO {

	public boolean insert_pokemon (PokemonEx pokemon);
	
	public List<PokemonEx> get_all_pokemonex ();
	
	public boolean delete_pokemonex (int collectionN);
	
	 List<PokemonEx> get_pokemonex_collectionN (int collectionN);
	
	 boolean update_PokemonEx (int collectionN, String name, String type);
}
