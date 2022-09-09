package jdbc;

import java.sql.*;

public class Excecute02 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver"); //1.
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tecproed",
                "postgres", "Melek15e.");//2.
        Statement st = con.createStatement();//3.

        //1. Ornek: region id si 1 olan "country name" degerlerini cagirin
        String sql1 = "SELECT country_name FROM countries WHERE region_id=1 ";


        //Recordleri gormek icin executeQuery () methodu kullanmak gerekli
        ResultSet result1 = st.executeQuery(sql1);

        while (result1.next()) {//next() methodu bize boolean verir

            System.out.println(result1.getString("country_name"));

        }

        //2.Örnek: "region_id"nin 2'den büyük olduğu "country_id" ve "country_name" değerlerini çağırın.

        String sql2 = "SELECT country_id,country_name FROM countries WHERE region_id>2 ";

        ResultSet result2 = st.executeQuery(sql2);

        while (result2.next()) {

            System.out.println(result2.getString("country_id") + "==>" + result2.getString("country_name"));
        }

        //3.Example: "number_of_employees" değeri en düşük olan satırın tüm değerlerini çağırın.
        String sql3 = "SELECT * FROM companies WHERE number_of_employees = (SELECT MIN(number_of_employees) FROM companies) ";
        ResultSet result3 = st.executeQuery(sql3);

        while (result3.next()) {
            System.out.println(result3.getInt("company_id") + "-->" + result3.getString("company") + "-->" + result3.getInt("number_of_employees"));
        }

        //Baglanti  ve Statement'i kapat
        con.close();
       st.close();//scan.close gibi

    }
}
