package ca.boss.matching.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ca.boss.matching.model.bean.Reference;
import jdk.nashorn.internal.runtime.arrays.IteratorAction;

public class RerefenceDaoImplementation implements ReferenceDao {

	// private List<String> daoErrors;

	// public List<String> getDaoErrors() {
	// return daoErrors;
	// }
	// private void addError(String errorMessage) {
	// if (daoErrors == null)
	// daoErrors = new ArrayList<String>();
	// if (StringUtils.isNotBlank(errorMessage))
	// daoErrors.add(errorMessage);
	// }

	private DaoFactory daoFactory;

	public RerefenceDaoImplementation(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	//

	// id universe_id catalog_id brand model title ean color size capacity
	// memory description price url image image1 image2 image3 image4
	private String getCreateReferenceQuery() {
		String query = "INSERT INTO reference (brand,model,title,url,image,ean,color,size,capacity,memory,description,image1,image2,image3,image4,price)";
		query += " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		return query;
	}

	private PreparedStatement updateStatement(PreparedStatement preparedStatement, Reference reference)
			throws SQLException {
		if (preparedStatement == null)
			return null;
		preparedStatement.setString(1, reference.getBrand());
		preparedStatement.setString(2, reference.getModel());
		preparedStatement.setString(3, reference.getTitle());
		preparedStatement.setString(4, reference.getUrl());
		preparedStatement.setString(5, reference.getImage());
		preparedStatement.setString(6, reference.getEan());
		preparedStatement.setString(7, reference.getColor());
		preparedStatement.setString(8, reference.getSize());
		preparedStatement.setString(9, reference.getCapacity());
		preparedStatement.setString(10, reference.getMemory());
		preparedStatement.setString(11, reference.getDescription());
		preparedStatement.setString(12, reference.getImage1());
		preparedStatement.setString(13, reference.getImage2());
		preparedStatement.setString(14, reference.getImage3());
		preparedStatement.setString(15, reference.getImage4());
		preparedStatement.setObject(16, reference.getPrice());
		// preparedStatement.setFloat(16,reference.getPrice());
		return preparedStatement;
	}

	@Override
	public Integer createReference(Reference reference) throws DaoException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = daoFactory.getConnection();
		} catch (SQLException e) {
			throw new DaoException("impossible to get connection");
		}

		try {
			preparedStatement = connection.prepareStatement(getCreateReferenceQuery());
		} catch (SQLException e) {
			DaoTools.close(connection);
			throw new DaoException("impossible to create statement");
		}

		try {
			preparedStatement = updateStatement(preparedStatement, reference);
		} catch (Exception e) {
			DaoTools.close(preparedStatement);
			DaoTools.close(connection);
			throw new DaoException("impossible to update statement");
		}

		try {
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			DaoTools.close(preparedStatement);
			DaoTools.close(connection);
			throw new DaoException("error on reference insert");
		}

		DaoTools.close(preparedStatement);
		DaoTools.close(connection);
		return null;
	}

	@Override
	public List<Reference> searchReference(Reference reference) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reference getReference(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	private String getListReferenceQuery() {
		return "SELECT id, title, brand, model, url, image, ean, color, size,capacity, memory, description, price from reference";
	}

	@Override
	public List<Reference> listReferences() throws DaoException {
		List<Reference> references = null;
		Connection connection = null;
		PreparedStatement listReferencePreparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = daoFactory.getConnection();
		} catch (SQLException e) {
			throw new DaoException("listReference - impossible to get connection");
		}

		try {
			listReferencePreparedStatement = connection.prepareStatement(getListReferenceQuery());
		} catch (SQLException e) {
			DaoTools.close(connection);
			throw new DaoException("listReference - impossible to create statement");
		}

		try {
			resultSet = listReferencePreparedStatement.executeQuery();
		} catch (SQLException e) {
			DaoTools.close(listReferencePreparedStatement);
			DaoTools.close(connection);
			throw new DaoException("listReference - impossible to execute query");
		}

		references = referencesMapper(resultSet);
		DaoTools.close(resultSet);
		DaoTools.close(listReferencePreparedStatement);
		DaoTools.close(connection);

		return references;
	}

	private List<Reference> referencesMapper(ResultSet resultSet) throws DaoException {
		if (resultSet == null)
			return null;

		List<Reference> references = new ArrayList<Reference>();
		Reference reference;
		try {
			while (resultSet.next()) {
				reference = new Reference();
				reference.setId(resultSet.getInt(1));
				reference.setTitle(resultSet.getString(2));
				reference.setBrand(resultSet.getString(3));
				reference.setModel(resultSet.getString(4));
				reference.setUrl(resultSet.getString(5));
				reference.setImage(resultSet.getString(6));
				reference.setEan(resultSet.getString(7));
				reference.setColor(resultSet.getString(8));
				reference.setSize(resultSet.getString(9));
				reference.setCapacity(resultSet.getString(10));
				reference.setMemory(resultSet.getString(11));
				reference.setDescription(resultSet.getString(12));
				reference.setPrice(resultSet.getFloat(13));
				references.add(reference);
			}
		} catch (SQLException e) {
			throw new DaoException("listReference - impossible to list reference");
		}

		return references.isEmpty() ? null : references;
	}

	private String getDeleteReferenceQuery() {
		return "DELETE from reference where id = ? ";
	}

	private PreparedStatement deleteReferenceUpdateStatement(PreparedStatement preparedStatement, Integer integer)
			throws DaoException {
		try {
			preparedStatement.setObject(1, integer);
		} catch (SQLException e) {
			throw new DaoException("deleteReference - impossible to update query");
		}
		return preparedStatement;
	}

	@Override
	public Integer deleteReference(Integer id) throws DaoException {
		// TODO Auto-generated method stub

		Connection connection = null;
		PreparedStatement deleteReferencePreparedStatement = null;

		try {
			connection = daoFactory.getConnection();
		} catch (Exception e) {
			throw new DaoException("deleteReference - impossible to get connection");
		}

		try {
			deleteReferencePreparedStatement = connection.prepareStatement(getDeleteReferenceQuery());
		} catch (Exception e) {
			DaoTools.close(connection);
			throw new DaoException("deleteReference - impossible to create statement");
		}

		try {
			deleteReferencePreparedStatement = deleteReferenceUpdateStatement(deleteReferencePreparedStatement, id);
		} catch (Exception e) {
			DaoTools.close(deleteReferencePreparedStatement);
			DaoTools.close(connection);
			throw new DaoException("deleteReference - impossible to create statement");
		}
		
		try {
			deleteReferencePreparedStatement.executeUpdate();
		} catch (SQLException e) {
			DaoTools.close(deleteReferencePreparedStatement);
			DaoTools.close(connection);
			throw new DaoException("deleteReference - error while deleting reference");
		}
		DaoTools.close(deleteReferencePreparedStatement);
		DaoTools.close(connection);
		return null;
	}

}
