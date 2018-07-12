package br.com.TestBack2017.factory;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Casa
 */
public class TestaConexao {
    public static void main(String[] args) throws SQLException {
        try (Connection connection = new ConnectionFactory().getConnection()) {
            System.out.println("Conexão aberta!");
        }
    }
}
