package com.pokemonDB.daos;

import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.pokemonDB.models.PokemonEx;
public class PokemonEx_Impl implements PokemonEx_DAO {

	Connection connect = null;
	PokemonEx pokemon = new PokemonEx();
	
	public PokemonEx_Impl (Connection connect) {
		this.connect = connect;
	}
	@Override
	public boolean insert_pokemon(PokemonEx pokemon) {
		// Checks To See If The Input Information Is A Pokemon;
		boolean status = false;
		try {
		String sql = "insert into pokemon_ex(id, name, collectionN, HP, stage, type) values(?,?,?,?,?,?)";
		PreparedStatement new_statement =  connect.prepareStatement(sql);
		new_statement.setInt(1, pokemon.get_id());
		
		new_statement.setString(2, pokemon.get_name());
		
		new_statement.setInt(3, pokemon.get_collectionN());
		
		new_statement.setInt(4, pokemon.get_HP());
		
		new_statement.setString(5, pokemon.get_stage());
		
		new_statement.setString(6,  pokemon.get_type());
		
		int returned_statement = new_statement.executeUpdate();
		
		if (returned_statement > 0) {
			status = true;
		}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
	
	@Override
	public List<PokemonEx> get_all_pokemonex() {
		// TODO Auto-generated method stub
		//	i need a list of pokemon
		List<PokemonEx>  poke_list = new ArrayList<>();
		try {
			String sql = "Select * from pokemon_ex";
			
			PreparedStatement new_statement = connect.prepareStatement(sql);
			ResultSet result = new_statement.executeQuery();
			while (result.next()) {
				PokemonEx pokemon = new PokemonEx ();
				pokemon.set_id(result.getInt(1));
				pokemon.set_name(result.getString(2));
				pokemon.set_collectionN(result.getInt(3));
				pokemon.set_HP(result.getInt(4));
				pokemon.set_stage(result.getString(5));
				pokemon.set_type(result.getString(6));
				
				poke_list.add(pokemon);
				System.out.println ("\nIdentificaion Number: " + result.getInt(1) + " 	NAME: " + result.getString(2) + " \n" + "\nCOLLECTION NUMBER: " 
						+ result.getInt(3) + "	HP: " + result.getInt(4) + "	STAGE: " + result.getString(5) + "	TYPE: " + result.getString(6) + "\n");
					
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return poke_list;
		
	}
	@Override
	public boolean delete_pokemonex(int collectionN) {
		// TODO Auto-generated method stub
		boolean status = false;
		try {
			String sql = "delete from pokemon_ex where collectionN = ?";
			PreparedStatement statement = connect.prepareStatement(sql);
			statement.setInt(1, collectionN);
			int result = statement.executeUpdate();
			
			if (result > 0) {
				status = true;
			} 
		}catch ( SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
	
	@Override 
	public List <PokemonEx> get_pokemonex_collectionN (int collectionN) {
		List < PokemonEx > pokelist = new ArrayList <PokemonEx> ();
		
		try {
			String sql = "Select * from pokemon_ex";
			PreparedStatement statement = connect.prepareStatement(sql);
			ResultSet result = statement.executeQuery(sql);
			
			while (result.next () ) {
				PokemonEx pokemonex = new PokemonEx ();
				pokemonex.set_id(result.getInt(1));
				pokemonex.set_name(result.getString(2));
				pokemonex.set_collectionN(result.getInt(3));
				pokemonex.set_HP(result.getInt(4));
				pokemonex.set_stage(result.getString(5));
				pokemonex.set_type(result.getString(6));
				pokelist.add(pokemon);
				
				
				for ( int i = 0; i < pokelist.size(); i++) {
					
					if (collectionN == pokemonex.collectionN) {
						System.out.println("\nThis Is Your Pokemon: " + result.getString(2) + "\n");
						break;
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} return pokelist;
	}
	
	@Override 
	public boolean update_PokemonEx (int collectionN, String name, String type) {
		boolean status = false;
		
		
		try {
			String sql = "update pokemon_ex set name = ?, type = ? where collectionN = ?";
			PreparedStatement statement = connect.prepareStatement (sql);
			
			statement.setString ( 1, name);
		
			statement.setString( 2,  type );
			
			statement.setInt(3, collectionN);
		
			int result = statement.executeUpdate();
			if (result > 0) {
				status = true;
			} else {
				System.out.println ("\nResult Is Null");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} return status;
	}
}
