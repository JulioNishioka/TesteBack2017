package br.com.TestBack2017.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Casa
 */
public class ConnectionFactory {
    
        private final String DRIVER = "com.mysql.jdbc.Driver";
        private final String URL = "jdbc:mysql://localhost:3306/valemobi?useTimezone=true&serverTimezone=UTC";
        private final String USER = "root";
        private final String PASS = " ";
            
    public Connection getConnection(){
        try {
            //Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        }
        catch (SQLException excecao) {
            throw new RuntimeException("Erro na conexão", excecao);
        }
    }
    
    public void closeConnection(Connection con) {
        try {
            if(con != null){
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void closeConnection(Connection con, PreparedStatement stmt) {
        
        closeConnection(con);
        try {
            if(stmt != null){
                stmt.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        public void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
        
        closeConnection(con, stmt);
        try {
            if(rs != null){
                rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}