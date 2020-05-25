package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Tags;

public class TagDAO {
	
	private final String QUERY_ALL = "SELECT * FROM tags";
	private final String QUERY_CREATE = "INSERT INTO tags (tag) VALUES (?)";
	private final String QUERY_READ = "SELECT * FROM tags WHERE idtags=?";
	private final String QUERY_UPDATE = "UPDATE tags SET tag=? WHERE idtags=?";
	private final String QUERY_DELETE = "DELETE FROM tags WHERE idtags=?";
	
	public TagDAO() {
		
	}
	
	public List<Tags> getAll(){
		List<Tags> tagsList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Tags tags;
			while(resultSet.next()) {
			 int idTag = resultSet.getInt("idtags");
			 String tag = resultSet.getString("tag");
			 tags = new Tags(idTag, tag);
			 tags.setIdTag(idTag);
			 tagsList.add(tags);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return tagsList;
	}
	
	public boolean insertTag(Tags tagToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, tagToInsert.getTag());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	
	public Tags read(int idTag) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, idTag);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String tags;

			tags = resultSet.getString("tag");
			Tags tag = new Tags(idTag,tags);
			tag.setIdTag(resultSet.getInt("idtags"));

			return tag;
		} catch (SQLException e) {
			return null;
		}
	}
	
	public boolean update(Tags tagToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();
		if(tagToUpdate.getIdTag() == 0) {
			return false;
		}
		
		Tags tagRead = read(tagToUpdate.getIdTag());
		if(!tagRead.equals(tagToUpdate)) {
			try {
				if (tagToUpdate.getTag() == null || tagToUpdate.getTag().equals("")) {
					tagToUpdate.setTag(tagRead.getTag());
				}
			
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, tagToUpdate.getTag());
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
