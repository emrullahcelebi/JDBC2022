package jdbc;

import java.sql.*;

public class CallableStatement01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
      /*
    Java'da methodlar return type sahibi olsa da, void olsa da method olarak adlandırılır.
    SQL'de ise data return ediyorsa "function" denir. Return yapmıyorsa "procedure" diye adlandırılır.
     */

        Class.forName("org.postgresql.Driver"); //1.
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tecproed",
                "postgres", "Melek15e.");//2.
        Statement st = con.createStatement();//3.

//1. adim fonksiyon kodunu yaz
        String sql1 = "CREATE OR REPLACE FUNCTION toplamaF(x NUMERIC,y NUMERIC)\n" +
                "RETURNS NUMERIC\n" +
                "LANGUAGE plpgsql\n" +
                "AS\n" +
                "$$\n" +
                "BEGIN\n" +
                "\n" +
                "RETURN x+y;\n" +
                "\n" +
                "END\n" +
                "$$";

        //2. adim Fonksiyonu calistir

        st.execute(sql1);

        //3.adim FOnksiyonu cagir

        CallableStatement cst1 = con.prepareCall("{? = call toplamaF(?,?)}");

        //4. adim: Return icin registerOutParameter() methodunu,
        // parametreler icin set() methodlarindan uygun olannlari kullanilir

        cst1.registerOutParameter(1, Types.NUMERIC);
        cst1.setInt(2, 15);
        cst1.setInt(3, 25);


        //5. adim : Calistirmak icin execute() methodunu kullan
        cst1.execute();

//6. Adim: Sonucu cagirmK ICIN UYGUN OLANI KULLAN
        System.out.println(cst1.getBigDecimal(1));


        //
        //2. Örnek: Koninin hacmini hesaplayan bir function yazın.

        //1. adim fonksiyon kodunu yaz
        String sql2 = "CREATE OR REPLACE FUNCTION koniHacmi(r NUMERIC,h NUMERIC)\n" +
                "RETURNS NUMERIC\n" +
                "LANGUAGE plpgsql\n" +
                "AS\n" +
                "$$\n" +
                "BEGIN\n" +
                "\n" +
                "RETURN 3.14*r*r*h/3;\n" +
                "\n" +
                "END\n" +
                "$$";

        //2. adim Fonksiyonu calistir

        st.execute(sql2);

        //3.adim FOnksiyonu cagir

        CallableStatement cst2 = con.prepareCall("{? = call koniHacmi(?,?)}");

        //4. adim: Return icin registerOutParameter() methodunu,
        // parametreler icin set() methodlarindan uygun olannlari kullanilir

        cst2.registerOutParameter(1, Types.NUMERIC);
        cst2.setInt(2, 3);
        cst2.setInt(3, 5);


        //5. adim : Calistirmak icin execute() methodunu kullan
        cst2.execute();

        //6. Adim: Sonucu cagirmK ICIN UYGUN OLANI KULLAN
        System.out.println(cst2.getBigDecimal(1));


        con.close();
        st.close();
    }


}
