import java.sql.*;

public class Validate {
    public static boolean checkUser(String email,String password) 
    {
        boolean st =false;
        try {

            //loading drivers for mysql
            Class.forName("com.mysql.cj.jdbc.Driver");

            //creating connection with the database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/spotify","root","chander@1234");
            PreparedStatement ps = con.prepareStatement("select * from tb1 where email=? and password=?");
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs =ps.executeQuery();
            st = rs.next();

        }
        catch(ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return st;                 
    }   
}
