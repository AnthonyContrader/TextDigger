package it.contrader.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Document;
import it.contrader.model.User;

public class DocumentDAO {
	
	private final String QUERY_ALL = "SELECT * FROM document";
	private final String QUERY_CREATE = "INSERT INTO document (text) VALUES (?)";
	private final String QUERY_READ = "SELECT * FROM document WHERE iddocument=?";
	private final String QUERY_UPDATE = "UPDATE document SET  WHERE iddocument=?";
	private final String QUERY_DELETE = "DELETE FROM document WHERE iddocument=?";

	public DocumentDAO() {
		
	}
	
	public List<Document> getAll(){
		List<Document> documentList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Document document;
			while(resultSet.next()) {
				int userId = resultSet.getInt("user");
				User userDoc = new User(null, null, null);
				userDoc.setId(userId);
				
				String text = resultSet.getString("text");
				
				document = new Document(userDoc,text);
				document.setIdDocument(resultSet.getInt("iddocument"));
				documentList.add(document);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return documentList;
	}
	
	public boolean insertDoc(Document document) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, document.getTextBlob());
			return preparedStatement.execute();
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Document readDocumentById(int idDocument) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, idDocument);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String user, textDocument;
			
			textDocument = resultSet.getString("text");
			int userId = resultSet.getInt("user");
			User userDoc = new User(null, null, null);
			
			Document document = new Document(userDoc, textDocument);
			document.setIdDocument(resultSet.getInt("iddocument"));
			
			return document;
		}catch (SQLException e) {
		    e.printStackTrace();
		    return null;
		}
	}

}
