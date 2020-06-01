package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.contrader.model.SearchConnection;
import it.contrader.model.User;
import it.contrader.utils.ConnectionSingleton;


public class SearchConnectionDAO implements DAO<SearchConnection> {

	private final String QUERY_ALL = "SELECT * FROM searchconnection";
	private final String QUERY_CREATE = "INSERT INTO searchconnection (iddocument, idtag) VALUE (?,?)";
	private final String QUERY_READ = "SELECT * FROM searchconnection WHERE idtag=?";
	private final String QUERY_UPDATE = "UPDATE searchconnection SET iddocument=? WHERE idtag=?";
	private final String QUERY_DELETE = "DELETE FROM searchconnection WHERE idtag=?";
	
	public SearchConnectionDAO() {
		
	}
	
	public List<SearchConnection> getAll() {
		List<SearchConnection> SearchConnectionList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			SearchConnection searchConnection;
			while (resultSet.next()) {
				int idDocument = resultSet.getInt("iddocument");
				int idTag = resultSet.getInt("idtag");
				searchConnection = new SearchConnection(idDocument, idTag);
				searchConnection.setIdTag(idTag);
				searchConnection.setIdDocument(idDocument);
				SearchConnectionList.add(searchConnection);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return SearchConnectionList;
	}


	@Override
	public SearchConnection read(int idTag) {
		
		Connection connection = ConnectionSingleton.getInstance();
		
		try {
			
		
		PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
		preparedStatement.setInt(1, idTag);
		ResultSet resultSet = preparedStatement.executeQuery();
		resultSet.next();
		
		int idDocument = resultSet.getInt("iddocument");
	    idTag = resultSet.getInt("idtag");
		
		SearchConnection searchConnection = new SearchConnection(idDocument, idTag);
		searchConnection.setIdTag(idTag);
		searchConnection.setIdDocument(idDocument);
		
		return searchConnection;
		
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean insert(SearchConnection searchConnectionToInsert) {
		
		Connection connection = ConnectionSingleton.getInstance();
		
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setInt(1, searchConnectionToInsert.getIdDocument());
			preparedStatement.setInt(2, searchConnectionToInsert.getIdTag());
			preparedStatement.execute();
			return true;
			
		} catch (SQLException e) {
			return false;
		}
	}

	@Override
	public boolean update(SearchConnection searchConnectionToUpdate) {
		
		Connection connection = ConnectionSingleton.getInstance();

		if (searchConnectionToUpdate.getIdTag() == 0)
			return false;

		SearchConnection SearchConnectionRead = read (searchConnectionToUpdate.getIdTag());
		if (!SearchConnectionRead.equals(searchConnectionToUpdate)) {
			try {
				if (searchConnectionToUpdate.getIdDocument() == 0) {
					searchConnectionToUpdate.setIdDocument(SearchConnectionRead.getIdDocument());
				}
				
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setInt (1, searchConnectionToUpdate.getIdDocument());
				preparedStatement.setInt(2, searchConnectionToUpdate.getIdTag());
				
				int a = preparedStatement.executeUpdate();
				if (a > 0)
					return true;
				else
					return false;

			} catch (SQLException e) {
				return false;
			}
		}
		return false;
	}

	@Override
	public boolean delete(int idTag) {
		
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, idTag);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;

		} catch (SQLException e) {
		}
		return false;
	}


}
