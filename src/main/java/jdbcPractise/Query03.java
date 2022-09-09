package jdbcPractise;

import java.sql.*;

public class Query03 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1) Driver yukle
        Class.forName("org.postgresql.Driver");

        //2) Baglanti olustur
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tecproed",
                "postgres", "Melek15e.");

        //3) Statement
        //Statement st= con.createStatement();
        PreparedStatement ps= con.prepareStatement("SELECT * FROM ogrenciler");
        ResultSet rs=ps.executeQuery();

         ResultSetMetaData rsmd = rs.getMetaData();

        System.out.println("Sutun sayisi : "+rsmd.getColumnCount());

        System.out.println("1. sutunun ismi : "+rsmd.getColumnName(1));
        System.out.println("2. sutunun ismi : "+rsmd.getColumnName(2));
        System.out.println("3. sutunun ismi : "+rsmd.getColumnName(3));
        System.out.println("4. sutunun ismi : "+rsmd.getColumnName(4));

        System.out.println("1.sutunun data tipi : "+rsmd.getColumnTypeName(1));
        System.out.println("2.sutunun data tipi : "+rsmd.getColumnTypeName(2));
        System.out.println("3.sutunun data tipi : "+rsmd.getColumnTypeName(3));
        System.out.println("4.sutunun data tipi : "+rsmd.getColumnTypeName(4));

        System.out.println("Tablo ismi : "+rsmd.getTableName(2));




    }
}
