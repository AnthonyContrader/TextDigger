package it.contrader.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import it.contrader.main.ConnectionSingleton;
import it.contrader.model.SearchConnections;
import it.contrader.model.Tags;

public class SearchConnectionsDAO {
	
	private final String QUERY_ALL = "SELECT * FROM user";
	private final String QUERY_CREATE = "INSERT INTO user (username, password) VALUES (?,?)";
	private final String QUERY_READ = "SELECT * FROM user WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE user SET username=?, password=?, usertype=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM user WHERE id=?";
	
	public SearchConnectionsDAO() {
		/*
		public List<SearchConnections> getAll(){
			Connection connection = ConnectionSingleton.getInstance();
			try {
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(QUERY_ALL);
				SearchConnections connections;
				while(resultSet.next()) {
					int idTag = resultSet.getInt("idtag");
					Tags tagConnection = new Tags(null, null);
					tagConnection.setIdTag(idTag);
					int idDocument = resultSet.getInt("iddocument");
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		*/
	}
	
	

}
