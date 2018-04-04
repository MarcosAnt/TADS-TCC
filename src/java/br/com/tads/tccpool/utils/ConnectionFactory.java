/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tads.tccpool.utils;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
/**
 *
 * @author onurb
 */
public class ConnectionFactory {
    public Connection getConnection(){
        try {
			Properties prop = new Properties();
			prop.load(getClass().getResourceAsStream("DB.properties"));
			String dbDriver = prop.getProperty("db.driver");
			String dbUrl = prop.getProperty("db.url");
			String dbUser = prop.getProperty("db.user");
			String dbPwd = prop.getProperty("db.pwd");
			Class.forName(dbDriver);
			
			return DriverManager.getConnection(dbUrl, dbUser, dbPwd);
			
		} catch (ClassNotFoundException ex) {
			throw new RuntimeException(ex);
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
    }
    
}
