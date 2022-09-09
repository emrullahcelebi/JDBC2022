package jdbcPractise;

import java.sql.*;

public class Query01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1) Driver yukle
        Class.forName("org.postgresql.Driver");

        //2) Baglanti olustur
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tecproed",
                "postgres", "Melek15e.");

        //3) Statement
        Statement st= con.createStatement();

        //4) ResultSet--donen verileri tutmak icin

        ResultSet veri = st.executeQuery("SELECT * FROM ogrenciler");

        //Sonuclari al
        while (veri.next())

            //index kullanarak
            System.out.println(veri.getInt(1)+ veri.getString(2)+
                    veri.getString(3)+veri.getString(4));
        System.out.printf("%-6d %-15.15s %-8s %-8s\n", veri.getInt(1),
                veri.getString(2), veri.getString(3), veri.getString(4));

        con.close();
        st.close();
        veri.close();
    }

}
