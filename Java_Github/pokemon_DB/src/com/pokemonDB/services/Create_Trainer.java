package com.pokemonDB.services;

import java.util.Scanner;

import java.sql.Connection;

import com.pokemonDB.daos.TrainerDAO_Impl;

import com.pokemonDB.models.Trainers;

public class Create_Trainer {
	static Scanner scan = new Scanner (System.in);
	static Scanner scanN = new Scanner (System.in);
	static TrainerDAO_Impl trainerDao;
	public Create_Trainer (Connection connect) {
		trainerDao = new TrainerDAO_Impl (connect);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	}
	
	public void new_trainer (Scanner scan) {
		String name = new_name ();
		String username = new_username ();
		int trainer = new_trainerID ();
		
		Trainers new_trainer = new Trainers (name, username, trainer);
		boolean status = trainerDao.insert_trainer(new_trainer);
		if (status) {
			System.out.println ("\nI Have Registered You With A Pokedex\n");
		} else {
			System.out.println ("\nInvalid Creedentials. \nTry Again\n");
		}
		}
	
	public static String new_name () {
		String new_name = null;
		
		System.out.println ("\nWhat Is Your Name? \n");
		new_name = scan.nextLine();
		return new_name.toUpperCase();
	}
	
	public static String new_username () {
		String new_username = null;
		
		System.out.println ("\nWhat Is Your Username?\n");
		new_username = scan.nextLine();
		return new_username.toUpperCase();
	}
	
	public static int new_trainerID () {
		int new_trainerID = 0;
		
		System.out.println ("\nWhat Is Your Trainer Identification Number?\n");
		new_trainerID = scanN.nextInt();
		return new_trainerID;
	}
}
