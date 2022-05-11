package org.example;

import java.sql.*;

/**
 *
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Connection connection=null;
        try {
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca","root", "password");
        } catch (SQLException e) {
            System.out.println("Eccezione: "+e.toString());
        }
        try {
            Statement statement=connection.createStatement();
            ResultSet result=statement.executeQuery("select id_disposizione, genere from disposizione");

            while (result.next()) System.out.println(result.getString("id_disposizione")+"  "+result.getString("genere"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
