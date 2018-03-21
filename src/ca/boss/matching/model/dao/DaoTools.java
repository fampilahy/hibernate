package ca.boss.matching.model.dao;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoTools {
	
	public static void close(Closeable closeable) throws DaoException{
		if(closeable!=null){
			try {
				closeable.close();
			} catch (IOException e) {
				throw new DaoException("impossible to close "+closeable.getClass());
			}
		}
	}
	
	public static void close(Connection connection) throws DaoException {
		if(connection!=null){
			try {
				connection.close();
			} catch (SQLException e) {
				throw new DaoException("impossible to close connection");
			}
		}
	}
	
	public static void close(ResultSet resultSet) throws DaoException {
		if(resultSet!=null){
			try {
				resultSet.close();
			} catch (SQLException e) {
				throw new DaoException("impossible to close resultSet");
			}
		}
	}
	
	public static void close (PreparedStatement preparedStatement) throws DaoException{
		if(preparedStatement!=null){
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				throw new DaoException("impossible to close statement");
			}
		}
	}

}
