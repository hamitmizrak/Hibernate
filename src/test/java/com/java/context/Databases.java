package com.java.context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Databases {
	private static final String USERNAME="root";
	private static final String USERPASSWORD="root";
	private static final String URL="jdbc:mysql://localhost:3306/tunaydb?serverTimezone=Turkey";
	
	private static Connection conn=null;
	private static Statement statement; //Unutma Statenebt güvenlik açığını oluşturuyor. PreparedStatement ile yaz kodlarını
	private static ResultSet resultSet;
	
	//Driver Connection
	public Connection DatabaseConnectivity() {
		try {
			//IsConnection(conn);
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver başarılı bir şekilde kuruldu.");
			
		} catch (Exception e) {
			System.err.println("Driver Yüklenmedi: "+e);
			e.printStackTrace();
		}
		
		try {
			//IsConnection(conn);
			conn=DriverManager.getConnection(URL, USERNAME, USERPASSWORD);
			System.out.println("Bağlantı başarılı bir şekilde kuruldu.");
			System.out.println("Veritabanım: "+conn.getMetaData().getDatabaseProductName());
			
		} catch (Exception e) {
			System.err.println("Bağlantı Kurulamadı: "+e);
			e.printStackTrace();
		}
		return conn;
		
	}
	

	
	//Insert 
	public void getInsertStatementDatabases(String sql) {
		conn=DatabaseConnectivity();
		
		try {
			statement=conn.createStatement();
			int affected=statement.executeUpdate(sql);
			getAffected(affected);
			System.out.println("Veri başarıyla Eklendi");
			
			ConnectionClosed();
			System.out.println("Closed");
		} catch (SQLException e) {
			System.err.println("Statement Databases Ekleme sırasında hata alındı");
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("Kayıt eklerken hata alındı");
			e.printStackTrace();
		}
		
	}
	
	
	//select
	public ResultSet getSelectStatementDatabases(String sql) throws SQLException {
		conn=DatabaseConnectivity();
		statement=conn.createStatement();
		resultSet=statement.executeQuery(sql); //resultSet sorgu sonucundaki kayıtlar
		return resultSet;

	}
	
	//Conn null değilse
	public Connection IsConnection(Connection conn) {
		if(conn!=null) {
			conn=null;
			return conn;
		}else {
			return conn;
		}
	}
	
	//Connection closed
	public void ConnectionClosed() {
		try {
			if(conn!=null)
			conn.close();
		} catch (SQLException e) {
			System.err.println("Bağlantı kapatılamadı");
			e.printStackTrace();
		}
	}
	
	
	//affetted
	private void getAffected(int number) throws Exception {
		if(number<0)
			throw new Exception("Veri eklenmedi");
	}

}
