package it.contrader.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.contrader.main.ConnectionSingleton;
import it.contrader.model.SearchConnections;
import it.contrader.model.Tags;

public class SearchConnectionsDAO {
	
	private final String QUERY_ALL = "SELECT * FROM searchconnections";
	private final String QUERY_CREATE = "INSERT INTO searchconnections (username, password) VALUES (?,?)";
	private final String QUERY_READ = "SELECT * FROM searchconnections WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE searchconnections SET username=?, password=?, usertype=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM searchconnections WHERE id=?";
	
	public SearchConnectionsDAO() {
		
	}
	
	public List<SearchConnections> getAll(){
		List<SearchConnections> list = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			SearchConnections connections;
			while(resultSet.next()) {
				int idTag = resultSet.getInt("idtag");
				int idDocument = resultSet.getInt("iddocument");
				connections = new SearchConnections(idTag, idDocument);
				connections.setIdTags(idTag);
				connections.setIdDocument(idDocument);
				list.add(connections);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
