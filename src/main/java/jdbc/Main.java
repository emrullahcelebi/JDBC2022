package jdbc;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        //DBWork objesini olustur
        DBWork db=new DBWork();

        //Connection fonksiyonunu datab den cagir

        Connection con=db.connect_to_db("tecproed","postgres","Melek15e.");


        //Yeni table olusturma methodunu cagir
        db.createTable(con,"employees");
    }
}
