package it.contrader.dao;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.Tag;

/**
 * 
 * @author Vittorio
 *
 *Per i dettagli della classe vedi Guida sez 6: DAO
 */
public class TagDAO implements DAO<Tag> {

	private final String QUERY_ALL = "SELECT * FROM tag";
	private final String QUERY_CREATE = "INSERT INTO tag (tag) VALUE (?)";
	private final String QUERY_READ = "SELECT * FROM tag WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE tag SET tag=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM tag WHERE id=?";

	public TagDAO() {

	}

	public List<Tag> getAll() {
		List<Tag> tagsList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Tag tag;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String tagText = resultSet.getString("tag");
				tag = new Tag(tagText);
				tag.setId(id);
				tagsList.add(tag);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tagsList;
	}

	public boolean insert(Tag tagToInsert) {
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

	public Tag read(int tagId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {


			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, tagId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String tagText;

			tagText = resultSet.getString("tag");
			Tag tag = new Tag(tagText);
			tag.setId(resultSet.getInt("id"));

			return tag;
		} catch (SQLException e) {
			return null;
		}

	}

	public boolean update(Tag tagToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (tagToUpdate.getId() == 0)
			return false;

		Tag tagRead = read(tagToUpdate.getId());
		if (!tagRead.equals(tagToUpdate)) {
			try {
				// Fill the tagToUpdate object
				if (tagToUpdate.getTag() == null || tagToUpdate.getTag().equals("")) {
					tagToUpdate.setTag(tagRead.getTag());
				}

				
				// Update the tag
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, tagToUpdate.getTag());
				preparedStatement.setInt(2, tagToUpdate.getId());
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