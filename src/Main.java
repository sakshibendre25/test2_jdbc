import java.sql.*;
public class Main {
    public static void main(String[] args)throws ClassNotFoundException  {

        String url="jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "root";
        String query = "DELETE FROM employees where id = 4;";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Drivers loaded succesfully");
        }catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());

        }

        try {
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("connection established succesfully");
            Statement stmt = con.createStatement();
            int rowsaffected = stmt.executeUpdate(query);

            if(rowsaffected>0) {
                System.out.println("Deletion Succesfull." + rowsaffected + " row(s) affected.");
            }else {
                System.out.println("Deletion Failed");


            }
            stmt.close();
            con.close();

            System.out.println("connection closed succesfully");

        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}