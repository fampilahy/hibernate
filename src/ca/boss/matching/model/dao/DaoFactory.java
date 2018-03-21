package ca.boss.matching.model.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.jolbox.bonecp.BoneCP;
import com.jolbox.bonecp.BoneCPConfig;

public class DaoFactory {

	private static final String PROPERTIES_FILE_PATH = "/ca/boss/matching/model/dao/mysql_db_boss_matching_reference_test.properties";
	private static final String DRIVER_KEY = "driver";
	private static final String URL_KEY = "url";
	private static final String PORT_KEY = "port";
	private static final String DATA_BASE_KEY = "base";
	private static final String USER_KEY = "user";
	private static final String PASS_KEY = "pass";
	private static final String PATH_SEPARATOR = "/";
	private static final String PORT_SEPARATOR = ":";
	
	private BoneCP connectionPool = null;
	
	private DaoFactory(BoneCP connectionPool){
		this.connectionPool = connectionPool;
	}

	public static DaoFactory getInstance() throws DaoConfigurationException {
		String driver, url, port, dataBase, user, pass;

		InputStream propertiesStream = null;
		Properties properties = null;

		try {
			propertiesStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(PROPERTIES_FILE_PATH);
			properties = new Properties();
			properties.load(propertiesStream);
		} catch (Exception e) {
			throw new DaoConfigurationException("impossible to load properties file : " + PROPERTIES_FILE_PATH);
		}

		driver = properties.getProperty(DRIVER_KEY);
		url = properties.getProperty(URL_KEY);
		port = properties.getProperty(PORT_KEY);
		dataBase = properties.getProperty(DATA_BASE_KEY);
		user = properties.getProperty(USER_KEY);
		pass = properties.getProperty(PASS_KEY);
		pass = properties.getProperty("bobo");

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			throw new DaoConfigurationException("impossible to load the driver : " + driver);
		}

//		Connection connection = null;
//		try {
			url += PORT_SEPARATOR + port + PATH_SEPARATOR + dataBase;
//			connection = DriverManager.getConnection(url, user, pass);
//		} catch (SQLException e) {
//			throw new DaoConfigurationException("Impossible to get the connection ... url - user - pass -"+url+" - "+user+" - "+pass);
//		}
		BoneCPConfig config = new BoneCPConfig();
		config.setPartitionCount(2);
		config.setMinConnectionsPerPartition(3);
		config.setMaxConnectionsPerPartition(5);
		config.setJdbcUrl(url);
		config.setUsername(user);
		config.setPassword(pass);
		
		
		BoneCP connectionPool;
		try {
			connectionPool = new BoneCP(config);
		} catch (SQLException e) {
			throw new DaoConfigurationException("error on connection pooling configuration");
		}
		

		return new DaoFactory(connectionPool);

	}
	
	public Connection getConnection() throws SQLException{
		return connectionPool.getConnection();
	}

	public ReferenceDao getReferenceDao() {
		return new RerefenceDaoImplementation(this);
	}

}
