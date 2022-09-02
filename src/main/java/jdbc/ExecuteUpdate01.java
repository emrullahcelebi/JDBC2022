package jdbc;

import java.sql.*;

public class ExecuteUpdate01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver"); //1.
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tecproed",
                "postgres", "Melek15e.");//2.
        Statement st = con.createStatement();//3.

        //1. Örnek: number_of_employees değeri ortalama çalışan sayısından az olan
        //          number_of_employees değerlerini 16000 olarak UPDATE edin.

        String sql1="UPDATE companies\n" +
                "SET number_of_employees =16000\n" +
                "WHERE number_of_employees<(\tSELECT AVG(number_of_employees)\n" +
                "\t\t\t\t\t\t\tFROM companies)\n";

       int updateSatirSayisi= st.executeUpdate(sql1);//UPDATE edilen satir sayisini return eder

        System.out.println("updateSatirSayisi = " + updateSatirSayisi);

        String sql2="SELECT * FROM companies";
        ResultSet result=st.executeQuery(sql2);

        while (result.next()){
            System.out.println(result.getInt(1)+"--"+result.getString(2)+"--"+result.getInt(3));
        }

        con.close();
        st.close();
    }
}
