package com.pokemonDB.controllers;

import java.sql.Connection;

import com.pokemonDB.services.Create_PokemonEx;

import com.pokemonDB.util.SQL_Connection;
import java.util.Scanner;

public class PokemonEx_Controller {

	public static void main(String[] args) {
		// TODO Auto-generated method stu
		Scanner scan = new Scanner(System.in);
		Connection connect = SQL_Connection.start_connection();
		Create_PokemonEx pokemon = new Create_PokemonEx(connect);
		
		boolean runApp = true;
		String response = null;
		while (runApp) {
			System.out.println("\nWelcome To Your Pokedex.");
			System.out.println("Pokemon Ex Are Rare! Did You Find A Nww One?");
			response = scan.nextLine();
			if (response.equalsIgnoreCase("yes")) {
				System.out.println("Okay!");	
			}
			System.out.println("1.	Add Your New Pokemon Ex To Your Pokedex");
			System.out.println("2.	See A Pokemon In Your PokeDex");
			response = scan.nextLine();
			switch (response.toString()) {
			case "1": 
				pokemon.new_pokemon(scan);
				break;
			case "2":
				pokemon.get_all_pokemonex();
				break;
			}
		}
	}

}
