package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PostGres {
	public static void main(String[] args) {
		
        try {
            Class.forName("org.postgresql.Driver");
        }
        catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        // replace below details
        String url = "jdbc:postgresql://wlqa.crvrogielca5.eu-west-1.rds.amazonaws.com:5432/WLQA";
        String username = "wlmember";
        String password = "wlmember";

        try {
            Connection db = DriverManager.getConnection(url, username, password);
            // create object for the Statement class
            Statement st = db.createStatement();
            // execute the quesry on database
            ResultSet rs = st.executeQuery("SELECT fname,lname,zip FROM member where mem_id=37427424");
            System.out.println("Data retrieved from the PostgreSQL database ");
            while (rs.next()) {
                System.out.println(rs.getString(1) + " | "+rs.getString(2) +" | "+ rs.getString(3));
            }
            rs.close();
            // close the result set
            st.close();
            //close the database connection
            db.close();
            }
        catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}