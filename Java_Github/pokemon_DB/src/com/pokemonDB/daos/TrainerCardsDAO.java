package com.pokemonDB.daos;
import java.sql.Connection;

import java.util.List;

import com.pokemonDB.models.TrainerCards;
public interface TrainerCardsDAO {

	public boolean insert_tcards (TrainerCards card);
	
	List <TrainerCards> get_all_cards ();
	
	public boolean delete_card (int collectionN);
}
