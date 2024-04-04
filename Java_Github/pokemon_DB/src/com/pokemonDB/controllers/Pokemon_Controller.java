package com.pokemonDB.controllers;

import java.sql.Connection;
import java.util.Scanner;
import com.pokemonDB.util.SQL_Connection;
import com.pokemonDB.services.Create_Pokemon;

public class Pokemon_Controller {
	//	This runs the entire app;
	//	public static final ArrayList<Object> pokemon_ID = new ArrayList<>();
	//	attributes\
	public static void main(String[] args) {
	Connection connect = SQL_Connection.start_connection();
	Create_Pokemon pokemon = new Create_Pokemon(connect);
	Scanner scan = new Scanner(System.in);
	System.out.println("--------------- WELCOME TRAINER ---------------");
	
	String response = null;
	boolean runApp = true;
	
	while(runApp) {
		System.out.println("Did You Catch A New Pokemon? ");
		if (scan.nextLine().equalsIgnoreCase("yes")) {
			System.out.println("Okay!");
		} else if (scan.nextLine().equalsIgnoreCase("no")){
			System.out.println("Come Back When You Find One!");
			runApp = false;
		} else {
			continue;
		}
		System.out.println("Choose A Number\n");
		System.out.println("1.	Add Pokemon To Pokedex?");
		System.out.println("2.	Do You Want To Update Your Pokedex??");
		System.out.println("3.	Do You Want To Remove A Pokemon??");
		System.out.println("4.	Do You Want To See All Of Your Pokemon?");
		response = scan.nextLine();
		switch(response) {
		case "1":
			System.out.println("Okay");
			pokemon.new_pokemon(scan);
			runApp = false;
			break;
		case "4":
			pokemon.get_all_pokemon();
			break;
			
				
		}
	}
}
	
	


}
