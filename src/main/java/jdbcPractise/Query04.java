package jdbcPractise;

import java.sql.*;

public class Query04 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//1) Driver yukle
        Class.forName("org.postgresql.Driver");

        //2) Baglanti olustur
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tecproed",
                "postgres", "Melek15e.");

        //3) Statement
        //Statement st= con.createStatement();
        //Statement st= con.prepareStatement("SELECT * FROM ogrenciler");
        //ResultSet rs=ps.executeQuery();

        PreparedStatement ps = con.prepareStatement("INSERT INTO ogrenciler VALUES (?, ?, ?, ?)");
        ps.setInt(1,200);
        ps.setString(2,"Veli can");
        ps.setString(3,"12");
        ps.setString(4,"E");

        ps.executeUpdate();
        System.out.println("Veri girisi yapildi");
    }
}
