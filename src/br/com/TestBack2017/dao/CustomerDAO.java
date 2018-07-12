package br.com.TestBack2017.dao;

import br.com.TestBack2017.factory.ConnectionFactory;
import br.com.TestBack2017.modelo.Customer;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Casa
 */

public class CustomerDAO {
    
    private final ConnectionFactory connection;
    
    public CustomerDAO(ConnectionFactory connection) {
        this.connection = connection;
    }

    public CustomerDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ArrayList<Customer> readAll(){
       try {
           String SQL = "SELECT * FROM tb_customer_account";
           PreparedStatement ps; 
           ps = connection.getConnection().prepareStatement(SQL);
           ResultSet rs;
           rs = ps.executeQuery();
           
           ArrayList<Customer> lista = new ArrayList<>();
           
           while (rs.next()) {
               Customer cust = new Customer();
               cust.setCpf_cnpj(rs.getString("cpf_cnpj"));
               cust.setNm_customer(rs.getString("nm_customer"));
               cust.setIs_active(rs.getString("is_active"));
               cust.setVl_total(rs.getBigDecimal("vl_total"));
               lista.add(cust);
           }
       }
       catch (SQLException ex) {
           System.err.println("Erro ao recuperar!" + ex.getMessage());
       }
       catch (Exception ex) {
          System.err.println("Erro geral!" + ex.getMessage());
       }
       return null;
    }

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/valemobi?useTimezone=true&serverTimezone=UTC";
        try {
            Connection connection = DriverManager.getConnection(url, "root", "$l4y3r_7$");
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM tb_customer_account");
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                String id_customer = rs.getString("id_customer");
                String cpf_cnpj = rs.getString("cpf_cnpj");
                String nm_customer = rs.getString("nm_customer");
                String is_active = rs.getString("is_active");
                String vl_total = rs.getString("vl_total");
                System.out.println("ID: " + id_customer
                        + "     CPF/CNPJ: " + cpf_cnpj 
                        + "     NOME: " + nm_customer 
                        + "     STATUS: " + is_active 
                        + "     SALDO: " + vl_total);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
} 