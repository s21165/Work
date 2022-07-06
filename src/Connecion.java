import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;

public class Connecion {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/work", "root", "root");
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT t1.NAME, avg(t2.age) as avgAge, min(age) as minAge FROM company t1 INNER JOIN workers t2 ON t1.id = t2.COMPANY_ID group by t1.NAME");
            System.out.println("Company, avgAge, minAge");
            while (resultSet.next()) {
                String name=resultSet.getString(1);
                int avgAge=resultSet.getInt(2);
                int minAge=resultSet.getInt(3);
                System.out.println(name + "   " + avgAge +"  "+minAge);
            }


        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

