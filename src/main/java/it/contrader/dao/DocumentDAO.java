package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.contrader.model.Document;
import it.contrader.utils.ConnectionSingleton;

public class DocumentDAO implements DAO<Document> {
	
	private final String QUERY_ALL = "SELECT * FROM document";
	private final String QUERY_CREATE = "INSERT INTO document (text) VALUES (?)";
	private final String QUERY_READ = "SELECT * FROM document WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE document SET text=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM document WHERE id=?";

	@Override
	public List<Document> getAll() {
		List<Document> documentList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Document document;
			while (resultSet.next()) {
				int userId = resultSet.getInt("user");
				String text = resultSet.getString("text");
				
				document = new Document(userId, text);
				document.setIdDocument(resultSet.getInt("id"));
				documentList.add(document);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return documentList;
	}

	@Override
	public Document read(int id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			
			String text;
			int userId;
			
			text = resultSet.getString("text");
			userId = resultSet.getInt("user");
			Document document = new Document(userId, text);
			document.setIdDocument(resultSet.getInt("id"));
			return document;
		} catch (SQLException e) {
			return null;
		}
	}

	@Override
	public boolean insert(Document documentToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, documentToInsert.getText());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	@Override
	public boolean update(Document documentToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (documentToUpdate.getIdDocument() == 0)
			return false;

		Document documentRead = read(documentToUpdate.getIdDocument());
		if (!documentRead.equals(documentToUpdate)) {
			try {
				// Fill the userToUpdate object
				if (documentToUpdate.getText() == null || documentToUpdate.getText().equals("")) {
					documentToUpdate.setText(documentRead.getText());
				}

				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setInt(1, documentToUpdate.getIdDocument());
				preparedStatement.setString(2, documentToUpdate.getText());
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
	public boolean delete(int id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;

		} catch (SQLException e) {
		}
		return false;	
	}

}
