package it.contrader.dao;
 
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
	private final String QUERY_CREATE = "INSERT INTO document (iddocument,text) VALUES (?,?)";
	private final String QUERY_READ = "SELECT * FROM document WHERE iddocument=?";
	private final String QUERY_UPDATE = "UPDATE document SET iddocument=?, text=?  WHERE iddocument=?";
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
				int idDocument = resultSet.getInt("iddocument");
				
				int userId = resultSet.getInt("user");
				User userDoc = new User(null, null, null);
				userDoc.setId(userId);
				
				String text = resultSet.getString("text");
				
				document = new Document(userDoc,text);
				document.setIdDocument(idDocument);
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
			preparedStatement.setInt(1, document.getIdDocument());
			preparedStatement.setString(3, document.getText());
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
			//String user;
			String textDocument;
			
			textDocument = resultSet.getString("text");
			int userId = resultSet.getInt("user");
			User userDoc = new User(null, null, null);
			userDoc.setId(userId);
			
			Document document = new Document(userDoc, textDocument);
			document.setIdDocument(resultSet.getInt("iddocument"));
			
			return document;
		}catch (SQLException e) {
		    e.printStackTrace();
		    return null;
		}
	}
	
	public boolean updateDocument(Document document) {
		Connection connection = ConnectionSingleton.getInstance();
		if(document.getIdDocument() == 0) {
			return false;
		}
		
		try {
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
			preparedStatement.setInt(1, document.getIdDocument());
			preparedStatement.setString(3, document.getText());
			int a = preparedStatement.executeUpdate();
			if(a > 0) {
				return true;
			}else {
				return false;
			}
		}catch (SQLException e) {
			return false;
		}
	}
	
	public boolean deleteDocument(Integer id) {
		Connection connection = ConnectionSingleton.getInstance();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id);
			int n = preparedStatement.executeUpdate();
			if(n != 0) {
				return true;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}	
		return false;
	}
	
	

}
