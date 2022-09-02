package jdbc;

import java.sql.*;

public class ExecuteQuery01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver"); //1.
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tecproed",
                "postgres", "Melek15e.");//2.
        Statement st = con.createStatement();//3.


      //1. Örnek: companies tablosundan en yüksek ikinci number_of_employees değeri olan company ve number_of_employees
        // değerlerini çağırın.

        //1.yol OFFSET ve FETCH NEXT
        String sql1 = "SELECT company, number_of_employees\n" +
                "FROM companies\n" +
                "ORDER BY number_of_employees DESC\n" +
                "OFFSET 1 ROW\n" +
                "FETCH NEXT 1 ROW ONLY";

     ResultSet result1= st.executeQuery(sql1);

     while(result1.next()){
         System.out.println(result1.getString("company")+"--"+result1.getInt("number_of_employees"));
     }

     //2.yol SUBQUERY kullanarak
        String sql2="SELECT company, number_of_employees\n" +
                "FROM companies\n" +
                "WHERE number_of_employees=(\tSELECT MAX(number_of_employees)\n" +
                "\t\t\t\t\t\t\tFROM companies\n" +
                "\t\t\t\t\t\t\tWHERE number_of_employees<(SELECT MAX(number_of_employees)\n" +
                "\t\t\t\t\t\t\tFROM companies))\n";
    ResultSet result2= st.executeQuery(sql2);
    while (result2.next()){
        System.out.println(result2.getString("company")+"--"+result2.getInt("number_of_employees"));
    }
    con.close();
    st.close();
    }
}
