package com.pokemonDB.services;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.pokemonDB.daos.TrainerCardsDAO_Impl;

import com.pokemonDB.models.TrainerCards;

public class Create_Card {
	Connection connect;
	TrainerCardsDAO_Impl card;
	static Scanner scan = new Scanner (System.in);
	static Scanner scanN = new Scanner (System.in);
	public Create_Card (Connection connect) {
		card = new TrainerCardsDAO_Impl (connect);
	}
	
	public void new_card (Scanner scan) {
		String name = new_name ();
		int collectionN = new_collectionN ();
		String type = new_type ();
		
		TrainerCards trainercard = new TrainerCards (name, collectionN, type);
		boolean status = false;
		status = this.card.insert_tcards(trainercard);
		
		if (status) {
			System.out.println("\nI Have Added Your Trainer Card To Your Pokedex!\n");
		} else {
			System.out.println("\nThis Card Does Not Exist.\nTry Again\n");
		}
	}
	
	public void get_all_cards () {
		List <TrainerCards> card_list = this.card.get_all_cards();
		
			System.out.println("\nTOTAL TRAINER CARDS: " + card_list.size() + "\n");
		
	}
	
	public void delete_card (Scanner scan) {
		System.out.println("\nWhat Is The Collection Number Of The Card?\n");
		int collectionN = scanN.nextInt ();
		boolean status = this.card.delete_card(collectionN);
		if (status) {
			System.out.println ("\nI Have Removed Your Trainer Card From The Pokedex!\n");
			card.get_all_cards();
		} else {
			System.out.println ("\nThis Card Does Not Exist,\nTry Again.\n");
		}
	}
	
	public static String new_name () {
		String name = null;
		System.out.println ("\nWhat Is The Card Name?\n");
		name = scan.nextLine ();
		System.out.println ("\nNAME: " + name.toUpperCase() + "\n");
		return name.toUpperCase();
	}
	
	public static int new_collectionN () {
		int collectionN = 0;
		System.out.println ("\nWhat Is The Collectin Number?\n");
		collectionN = scanN.nextInt();
		System.out.println ("\nCOLLECTION NUMBER: " + collectionN + "\n");
		return collectionN;
	}
	
	public static String new_type () {
		String type = null;
	
		System.out.println ("\nWhat Type of Trainer Card Is It?\n");
		System.out.println ("\n1.	Item Card		2.	Support Card		3.	Stadium Card\n");
		System.out.println("\nType 1, 2, OR, 3\n");
		String response = scan.nextLine();
		switch (response) {
		case "1": 
			System.out.println("\nTYPE: ITEM CARD\n");
			type = "ITEM CARD";
			break;
		case "2": 
			System.out.println("\nTYPE: SUPPORT CARD\n");
			type = "SUPPORT CARD";
			break;
		case "3": 
			System.out.println("\nTYPE: STADIUM CARD\n");
			type = "STADIUM CARD";
			break;
		default:
			System.out.println("\nInvalid Response.\nTry Again\n");
		}
		return type;
	}
}
