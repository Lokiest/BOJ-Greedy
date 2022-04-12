package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import springbook.user.domain.User;

public class UserDao {
	private static UserDao INSTANCE;
	private ConnectionMaker connectionMaker;
	
	private UserDao(ConnectionMaker connectionMaker) {
		this.connectionMaker = connectionMaker;
	}
	
	public static synchronized UserDao getInstance() {
		if (INSTANCE == null) INSTANCE = new UserDao(null);
		return INSTANCE;
	}
	
	public void add(User user) throws ClassNotFoundException, SQLException {
		Connection con = connectionMaker.makeConnection();
		
		PreparedStatement ps = con.prepareStatement("INSERT INTO USERS(id, name, password) values(?,?,?)");
		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());
		
		ps.executeUpdate();
		
		ps.close();
		con.close();
	}

	public User get(String id) throws ClassNotFoundException, SQLException {
		Connection con = connectionMaker.makeConnection();
		
		PreparedStatement ps = con.prepareStatement("SELECT * FROM USERS WHERE ID = ?");
		ps.setString(1, id);
		
		ResultSet rs  = ps.executeQuery();
		rs.next();
		User user = new User();
		user.setId(rs.getString("id"));
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));
		
		rs.close();
		ps.close();
		con.close();
		
		return user;
	}
}
