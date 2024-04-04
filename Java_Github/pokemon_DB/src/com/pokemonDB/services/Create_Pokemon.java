package com.pokemonDB.services;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;
import com.pokemonDB.daos.Pokemon_DAO_IMPL;
import com.pokemonDB.models.Pokemon;
public class Create_Pokemon {

	Pokemon_DAO_IMPL pokemondao;

	static Scanner scan = new Scanner (System.in);
	static Scanner scanN = new Scanner (System.in);
	/* --------------------------------------------------------------------------------------------*/
	/* --------------------------------------------------------------------------------------------*/
	
	public Create_Pokemon(Connection connect) {
		pokemondao = new Pokemon_DAO_IMPL(connect);
	}
	
	public void new_pokemon(Scanner scan) {
		String name = new_name ();
		int collectionN = new_collectionN ();
		int HP = new_HP ();
		String stage = new_stage ();
		String type = new_type ();
		
		Pokemon pokemon = new Pokemon(name, collectionN, HP, stage, type);
		
		boolean status = false;
		
		status = this.pokemondao.insert_Pokemon(pokemon);
		
		if (status) {
			System.out.println(name + " Is In Your Pokedex!");
		} else {
			System.out.println("This Pokemon Does Not Exist.\nTry Again");
		}
	}
	
	public void get_all_pokemon () {
		List <Pokemon> poke_list = this.pokemondao.get_All_Pokemon();
		System.out.print("\nTOTAL POKEMON: " + poke_list.size() + " POKEMON\n");
	}
	
	public void delete_pokemon ( Scanner scan ) {
		System.out.println ("\nWhat Is The Collection Number Of The Pokemon You Want To Remove?:\n");
		int collectionN = scanN.nextInt ();
		boolean status = this.pokemondao.delete_Pokemon(collectionN);
		if (status) {
			System.out.println ("\nI Have Removed Your Pokemon From The Pokedex!\n");
			pokemondao.get_All_Pokemon();
		} else {
			System.out.println ("\nThis Collection Number Does Not Exist.\nTry Again\n");
		}
	}
	
	public void update_Pokemon (Scanner scan) {
		System.out.println ("\nWhat Is The Collection Number Of Your Pokemon?\n");
		int collectionN = scanN.nextInt ();
		pokemondao.get_pokemon_collectionN(collectionN);
		
		System.out.println ("\nWhat Is The New Name Of Your Pokemon?\n");
		System.out.println ("\nEnter The Same Name If It Has Not Changed\n");
		String response1 = scan.nextLine().toUpperCase();
		String name = response1;
		
		System.out.println ("\nWhat Is The New Type Of Your Pokemon?\n");
		System.out.println ("\nEnter The Same Type If It Has Not Changed\n");
		String response2 = scan.nextLine().toUpperCase();
		String type = response2 + " Type";
		
		boolean status = this.pokemondao.update_Pokemon(collectionN, name, type);
		
		if (status) {
			System.out.println ("\nI Have Updated Your Pokemon\n");
		} else {
			System.out.println ("\nSomething Went Wrong.\nPlease Try Again\n");
		}
		
	}
		
		
	public static String new_name() {
		String new_name = null;
		System.out.println("\nWhat Is The Original Name Of Your Pokemon?\n");
		String response = scan.nextLine().toUpperCase();
		System.out.println("\nNAME: " + response.toUpperCase() + "\n");
		new_name = response;
		return new_name;
	}
	

	public static int new_collectionN() {
		
		int new_collectionN = 0;
		System.out.println("\nWhat Is The Pokemon Collection Number?:\n");
		int response = scanN.nextInt();
		System.out.println("\nCOLLECTION NUMBER: " + response + "\n");
		new_collectionN = response;
		return new_collectionN;
	}
	
	public static int new_HP () {
	
		int new_HP = 0;
		System.out.println("\nHow Much HP Does Your Pokemon Have?\n");
		int response = scanN.nextInt();
		System.out.println("\nHP: " + response + " HP\n");
		new_HP = response;
		return new_HP;
	}
	
	public static String new_stage () {
		String new_stage = null;
		System.out.println("\nWhat Stage Is Your Pokemon?\n");
		String response = scan.nextLine();
		new_stage = response.toUpperCase();
		System.out.println("STAGE: " + new_stage);
		return new_stage;
	}
	
	public static String new_type () {
		String new_type = null;
		boolean active = true;
		while (active) {
		System.out.println("\nWhat Is The Type Of Your Pokemon?\n");
		System.out.println("1.	Grass");
		System.out.println("2.	Fire");
		System.out.println("3.	Water");
		System.out.println("4.	Lightning");
		System.out.println("5.	Pyschic");
		System.out.println("6.	Fighting");
		System.out.println("7.	Darkness");
		System.out.println("8.	Metal");
		System.out.println("9.	Fairy");
		System.out.println("10.	Dragon");
		System.out.println("11.	Dual Type\n");
		String response = scan.nextLine().toString();
		switch (response) {
		case "1":
			System.out.println("\nTYPE: Grass Type\n");
			new_type = "Grass Type";
			active = false;
			break;
		case "2":
			System.out.println("\nTYPE: Fire Type\n");
			new_type = "Fire Type";
			active = false;
			break;
			
		case "3":
			System.out.println("\nTYPE: Water Type\n");
			new_type = "Water Type";
			active = false;
			break;

		case "4": 
			System.out.println("\nTYPE: Lightning\n");
			new_type = "Lightning Type";
			active = false;
			break;
			
		case "5":
			System.out.println("\nTYPE: Psychic\n");
			new_type = "Psychic Type";
			active = false;
			break;
	
		case "6":
			System.out.println("\nTYPE: Fighting\n");
			new_type = "Fighting Type";
			active = false;
			break;
			
		case "7":
			System.out.println("\nTYPE: Darkness\n");
			new_type = "Darkness";
			active = false;
			break;
			
		case "8":
			System.out.println("\nTYPE: Metal Type\n");
			new_type = "Metal Type";
			active = false;
			break;
			
		case "9":
			System.out.println("\nTYPE: Fairy Type\n");
			new_type = "Fairy Type";
			active = false;
			break;
			
		case "10":
			System.out.println("\nTYPE: Dragon Type\n");
			new_type = "Dragon Type";
			active = false;
			break;
			
		case "11":
			System.out.println("\nPlease Enter Your Dual Type");
			System.out.println("Format: (Type 1 / Type 2)\n");
			response = scan.nextLine();
			new_type = response;
			break;
			
			
		default:
			System.out.println("\nUnknown Type: " + response + "\nLet's Start Over!\n");
			//System.out.println("\nLet's Start Over!");
		} 
		
		}	active = false;
		System.out.println("\nTYPE " + new_type + "\n");
		return new_type;
	}
	
	
	
}
