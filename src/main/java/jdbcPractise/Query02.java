package jdbcPractise;

import java.sql.*;

public class Query02 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1) Driver yukle
        Class.forName("org.postgresql.Driver");

        //2) Baglanti olustur
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tecproed",
                                                    "postgres", "Melek15e.");

        //3) Statement
        Statement st= con.createStatement();

        //4) ResultSet--donen verileri tutmak icin

        ResultSet veri = st.executeQuery("SELECT * FROM ogrenciler where cinsiyet = 'E'");
//ogrenciler tablosundaki erkek ogrencileri listele


       while (veri.next()){
           System.out.println(veri.getInt(1)+veri.getString(2)+veri.getInt(3)+veri.getString(4));
       }
        con.close();
        st.close();
        veri.close();
    }
}
