package com.pokemonDB.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.pokemonDB.models.Trainers;

public class TrainerDAO_Impl implements TrainerDAO {
	Connection connect = null;
	Trainers trainer = new Trainers ();
	
	public TrainerDAO_Impl (Connection connect) {
		this.connect = connect;
	}
	
	
	@Override
	public boolean insert_trainer(Trainers trainer) {
		// TODO Auto-generated method stub
		boolean status = false;
		
		try {
			String sql = "insert into trainers(id, name, username, trainerID) values(?,?,?,?)";
			PreparedStatement statement = connect.prepareStatement(sql);
			
			statement.setInt(1, trainer.get_id());
			statement.setString(2, trainer.get_name());
			statement.setString(3, trainer.get_username());
			statement.setInt(4, trainer.get_trainerID());
			
			int return_data = statement.executeUpdate();
			
			if (return_data > 0) {
				status = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

}
