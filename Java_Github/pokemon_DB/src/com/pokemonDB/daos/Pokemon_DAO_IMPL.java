package com.pokemonDB.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pokemonDB.models.Pokemon;

public class Pokemon_DAO_IMPL implements Pokemon_DAO{
	//	Use this class for prepared statements;
	Connection connect = null;
	Pokemon pokemon = new Pokemon();

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	}
	
	public Pokemon_DAO_IMPL (Connection connection) {
		this.connect = connection;
	}

	/*--------------- INSERT POKEMON METHOD ---------------*/
	/*--------------- INSERT POKEMON METHOD ---------------*/
	/*--------------- INSERT POKEMON METHOD ---------------*/
	@Override
	public boolean insert_Pokemon(Pokemon pokemon) {
		
		// Take a created Pokemon object and add it to the database;
		//	Use a prepared statement to add the pokemon;
		boolean status = false;
		String sql = "insert into pokemon(id, name, collectionN, HP, stage, type)values(?,?,?,?,?,?)";
		try {
			PreparedStatement statement = connect.prepareStatement(sql);
			//	takes argument of sql;
			
			statement.setInt(1, pokemon.get_id());
			
			statement.setString(2, pokemon.get_name());
			
			statement.setInt(3, pokemon.get_collectionN());
			
			statement.setInt(4, pokemon.get_HP());
			
			statement.setString(5, pokemon.get_stage ());
			
			statement.setString(6, pokemon.get_type());
			
			int returned_data = statement.executeUpdate();
			
			if (returned_data > 0) {
				status = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	/*---------------End of addPokemon Method---------------*/
	/*---------------End of addPokemon Method---------------*/
	/*---------------End of addPokemon Method---------------*/

	@Override
	public List<Pokemon> get_All_Pokemon() {
		// TODO Auto-generated method stub
		//	retrieve all data from the database table
		List<Pokemon> pokelist = new ArrayList<Pokemon>();
		try {
		String sql = "Select * from pokemon";
		PreparedStatement statement = connect.prepareStatement(sql);
		
		ResultSet result = statement.executeQuery(sql);
		
		while (result.next()) {
			Pokemon pokemon = new Pokemon();
			pokemon.set_id(result.getInt(1));
			pokemon.set_name(result.getString(2));
			pokemon.set_collectionN(result.getInt(3));
			pokemon.set_HP(result.getInt(4));
			pokemon.set_stage(result.getString(5));
			pokemon.set_type(result.getString(6));
			pokelist.add(pokemon);
			System.out.println ("\nIdentificaion Number: " + result.getInt(1) + "	NAME: " + result.getString(2) + " \n" + "\nCOLLECTION NUMBER: " 
					+ result.getInt(3) + "	HP: " + result.getInt(4) + "	STAGE: " + result.getString(5) + "	TYPE: " + result.getString(6) + "\n");
				
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pokelist;
	}
	
	@Override
	public boolean delete_Pokemon (int collectionN) {
		
		boolean status = false;
		try {
			String sql = "delete from pokemon where id=?";
			PreparedStatement statement = connect.prepareStatement(sql);
			int result = statement.executeUpdate();
			if ( result > 0 ) {
				status = true;
			}
		} catch ( SQLException e ) {
			e.printStackTrace();
		} return status;
	}

	@Override 
	public List <Pokemon> get_pokemon_collectionN (int collectionN) {
		List < Pokemon > pokelist = new ArrayList<Pokemon> ();
		
		try {
			String sql = "Select * from pokemon";
			PreparedStatement statement = connect.prepareStatement(sql);
			ResultSet result = statement.executeQuery(sql);
			
			while (result.next () ) {
				Pokemon pokemon = new Pokemon ();
				pokemon.set_id(result.getInt(1));
				pokemon.set_name(result.getString(2));
				pokemon.set_collectionN(result.getInt(3));
				pokemon.set_HP(result.getInt(4));
				pokemon.set_stage(result.getString(5));
				pokemon.set_type(result.getString(6));
				pokelist.add(pokemon);
				
				
				for ( int i = 0; i < pokelist.size(); i++) {
					
					if (collectionN == pokemon.collectionN) {
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
	public boolean update_Pokemon (int collectionN, String name, String type) {
		boolean status = false;
		
		
		try {
			String sql = "update pokemon set name = ?, type = ? where collectionN = ?";
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
