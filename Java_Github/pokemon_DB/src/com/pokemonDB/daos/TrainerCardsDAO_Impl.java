package com.pokemonDB.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pokemonDB.models.TrainerCards;

public class TrainerCardsDAO_Impl implements TrainerCardsDAO{
	Connection connect = null;
	TrainerCards card = new TrainerCards ();
	
	public TrainerCardsDAO_Impl (Connection connect) {
		this.connect = connect;
	}
	
	
	@Override
	public boolean insert_tcards (TrainerCards card) {
		// TODO Auto-generated method 
		boolean status = false;
		
		try {
			String sql = "insert into trainer_cards(id, name, collectionN, type) values(?,?,?,?)";
			PreparedStatement statement = connect.prepareStatement(sql);
			
			statement.setInt(1, card.get_id());
			
			statement.setString(2,card.get_name());
			
			statement.setInt(3, card.get_collectionN ());
			
			statement.setString(4,  card.get_type());
			
			int return_data = statement.executeUpdate();
			
			if (return_data > 0) {
				status = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}


	@Override
	public List<TrainerCards> get_all_cards() {
		// TODO Auto-generated method stub
		List <TrainerCards> card_list = new ArrayList <TrainerCards> ();
		
		try {
			String sql = "Select * from trainer_cards";
			PreparedStatement statement = connect.prepareStatement(sql);
			
			ResultSet result = statement.executeQuery(sql);
			
			while ( result.next()) {
				TrainerCards card = new TrainerCards ();
				card.set_id ( result.getInt (1));
				card.set_name( result.getString (2));
				card.set_collectionN(result.getInt(3));
				card.set_type( result.getString(4));
				
				card_list.add( card );
				
				System.out.println ( "\nIDENTIFICATION NUMBER:	" + result.getInt(1) + "		NAEM:	"  + result.getString (2) + "\n" +
						"\nCOLLECTION NUMBER:	" + result.getInt (3) + "		TYPE:	" + result.getString(4) + "\n");
			}
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
		return card_list;
	}


	@Override
	public boolean delete_card(int collectionN) {
		// TODO Auto-generated method stub
		boolean status = false;
		
		try {
			String sql = "delete from trainer_cards where collectionN = ?";
			PreparedStatement statement = connect.prepareStatement(sql);
			statement.setInt (1, collectionN);
			int result = statement.executeUpdate();
			
			if (result > 0) {
				status = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

}
