package com.pokemonDB.controllers;
import com.pokemonDB.util.SQL_Connection;
import com.pokemonDB.services.Create_Pokemon;
import com.pokemonDB.services.Create_PokemonEx;
import com.pokemonDB.services.Create_Trainer;
import com.pokemonDB.services.Create_Card;
import java.sql.Connection;
import java.util.Scanner;

public class Main_Controler {
	//	create a connection 
	
	public static void main (String [] args) {
		Connection connect = SQL_Connection.start_connection();
		Create_Pokemon pokemon = new Create_Pokemon (connect);
		Create_PokemonEx pokemonEx = new Create_PokemonEx (connect);
		Create_Trainer trainer = new Create_Trainer (connect);
		Create_Card card = new Create_Card (connect);
		Scanner scan = new Scanner (System.in);
		//	prompt user
		boolean runApp = true;
		while (runApp) {
			
			System.out.println ("\nWelcome Trainer!");
			System.out.println ("Do You Want To:\n ");
			System.out.println ("1.		Add Something To Your Pokedex");
			System.out.println ("2.		View The Something In Your Pokedex");
			System.out.println ("3.		Update Something In Your Pokedex");
			System.out.println ("4.		Delete Something From The Pokedex\n");
			
			System.out.println ("TYPE 1 2, 3 OR 4\n");
			
			String response = scan.nextLine();
			
			switch (response) {
			case "1":
				System.out.println ("\nWhat Do You Want To Add?");
				System.out.println ("\nTYPE 1, 2, 3, OR 4\n");
				System.out.println ("1.		Pokemon");
				System.out.println ("2.		Pokemon Ex");
				System.out.println ("3.		Trainer Card");
				System.out.println ("4.		New Trainer\n");
				
				String response1 = scan.nextLine();
				if (response1.equals("1")) {
					System.out.println("\nPOKEMON\n");
					pokemon.new_pokemon(scan);
					break;
					
				} else if (response1.equals("2")) {
					System.out.println("\nPOKEMON EX\n");
					pokemonEx.new_pokemon(scan);
					break;
				}
					else if (response1.equals("3")) {
						System.out.println("\nTRAINER CARD\n");
						card.new_card(scan);
						break;
						
					}	 else if (response1.equals("4")) {
					System.out.println("\nNEW TRAINER\n");
					trainer.new_trainer(scan);
					break;
					
				}	else {
				
					System.out.print("\nInvalid Response. Please Retry.\n");
				}
				
			case "2":
				System.out.println ("\nWhich Pokemon Do You Want To See?\n");
				System.out.println ("\nTYPE 1 OR 2\n");
				System.out.println ("1.		Pokemon");
				System.out.println ("2.		Pokemon EX");
				System.out.println ("3.		Trainer Cards\n");
				
				String response2 = scan.nextLine();
				if (response2.equals("1")) {
					System.out.println("\nPOKEMON\n");
					pokemon.get_all_pokemon();
					break;
					
				} else if (response2.equals("2")) {
					System.out.println("\nPOKEMON EX\n");
					pokemonEx.get_all_pokemonex();
					break;
					
				} else if (response2.equals("3")) {
					System.out.println ("\nTRAINER CARDS\n");
					card.get_all_cards();
					break;
				}
				else {
					System.out.print("\nInvalid Response. Please Retry.\n");
				}
				
			case "3":
				System.out.println("\nWhat Do You Want To Update?\n");
				System.out.println("\nType 1, 2, OR 3\n");
				System.out.println ("1.		Pokemon");
				System.out.println ("2.		Pokemon Ex");
				System.out.println ("3.		Trainer Cards\n");
				String response3 = scan.nextLine();
				if ( response3.equals("1")) {
					
					System.out.println ("\nLet's Add The New Pokemon Information\n");
					pokemon.update_Pokemon(scan);
					break;
				} else if ( response3.equals("2")) {
					
					System.out.println ("\nLet's Add The New Pokemon EX Information\n");
					pokemonEx.update_PokemonEx(scan);
					break;
				}
			
			case "4":
				System.out.println ("\nWhat Do You Want To Remove From The Pokedex?\n");
				System.out.println ("\nType 1, 2, OR 3\n");
				System.out.println ("1.		Pokemon");
				System.out.println ("2.		Pokemon Ex");
				System.out.println ("3.		Trainer Cards\n");
				String response4 = scan.nextLine ();
				
				response4 = scan.nextLine ();
					
				if (response4.equals("1")) {
					System.out.println ("\nPOKEMON\n");
					pokemon.delete_pokemon(scan);
					break;
						
				} else if (response4.equals("2")) {
					System.out.println ("\nPOKEMON EX\n");
					pokemonEx.delete_pokemonex(scan);
					break;
				} 
					else if (response4.equals("3")) {
					System.out.println ("\nTRAINER CARD\n");
					card.delete_card (scan);
				}
					
			}
		}
	}
	
	public static void main_method () {
		Connection connect = SQL_Connection.start_connection();
		Create_Pokemon pokemon = new Create_Pokemon (connect);
		Create_PokemonEx pokemonEx = new Create_PokemonEx (connect);
		Create_Trainer trainer = new Create_Trainer (connect);
		Create_Card card = new Create_Card (connect);
		Scanner scan = new Scanner (System.in);
		//	prompt user
		boolean runApp = true;
		while (runApp) {
			
			System.out.println ("\nWelcome Trainer!");
			System.out.println ("Do You Want To:\n ");
			System.out.println ("1.		Add Something To Your Pokedex");
			System.out.println ("2.		View The Something In Your Pokedex");
			System.out.println ("3.		Delete Something From The Pokedex");
			
			System.out.println ("TYPE 1 2, OR 3\n");
			
			String response = scan.nextLine();
			
			switch (response) {
			case "1":
				System.out.println ("\nWhat Do You Want To Add?");
				System.out.println ("\nTYPE 1, 2, 3, OR 4\n");
				System.out.println ("1.		Pokemon");
				System.out.println ("2.		Pokemon Ex");
				System.out.println ("3.		New Trainer");
				System.out.println ("4.		Trainer Card");
				
				String response1 = scan.nextLine();
				if (response1.equals("1")) {
					System.out.println("\nPOKEMON\n");
					pokemon.new_pokemon(scan);
					break;
					
				} else if (response1.equals("2")) {
					System.out.println("\nPOKEMON EX");
					pokemonEx.new_pokemon(scan);
					break;
					
				} else if (response1.equals("3")) {
					System.out.println("\nNEW TRAINER\n");
					trainer.new_trainer(scan);
					break;
					
				}	else if (response1.equals("4")) {
					System.out.println("\nTRAINER CARD\n");
					card.new_card(scan);
					break;
				}
				else {
				
					System.out.print("\nInvalid Response. Please Retry.\n");
				}
				
			case "2":
				System.out.println ("\nWhich Pokemon Do You Want To See?\n");
				System.out.println ("\nTYPE 1 OR 2\n");
				System.out.println ("1.		Pokemon");
				System.out.println ("2.		Pokemon EX");
				System.out.println ("4.		Trainer Cards");
				
				String response2 = scan.nextLine();
				if (response2.equals("1")) {
					System.out.println("\nPOKEMON\n");
					pokemon.get_all_pokemon();
					
				} else if (response2.equals("2")) {
					System.out.println("\nPOKEMON EX\n");
					pokemonEx.get_all_pokemonex();
					
					
				} else if (response2.equals("4")) {
					System.out.println ("\nTRAINER CARDS\n");
					card.get_all_cards();
					
				}
				else {
					System.out.print("\nInvalid Response. Please Retry.\n");
				}
				
				case "3":
					System.out.println ("\nWhat Do You Want To Remove From The Pokedex?\n");
					System.out.println ("\nType 1, 2, OR 3\n");
					System.out.println ("1.		Pokemon");
					System.out.println ("2.		Pokemon Ex");
					System.out.println ("3.		Trainer Cards");
					
					String response3 = scan.nextLine ();
					
					if (response3.equals("1")) {
						System.out.println ("\nPOKEMON\n");
						pokemon.delete_pokemon(scan);
					} else if (response3.equals("2")) {
						System.out.println ("\nPOKEMON EX\n");
						pokemonEx.delete_pokemonex(scan);
					} 
						else if (response3.equals("3")) {
						System.out.println ("\nTRAINER CARD\n");
						card.delete_card (scan);
					}
					
			}
		}
	}
}
