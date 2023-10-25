package br.com.fiap.seriesapi.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	final static String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    final static String USER = "rm99570";
    final static String PASS = "310505";

    public static Connection createConnection() throws SQLException, ClassNotFoundException{
        var conexao = DriverManager.getConnection(URL, USER, PASS);
        System.out.println("Fact: " + conexao);
        Class.forName("oracle.jdbc.driver.OracleDriver");
        return conexao;
    }
}
