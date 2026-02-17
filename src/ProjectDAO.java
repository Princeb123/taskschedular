import java.sql.*;
import java.util.*;

public class ProjectDAO {

    public static void addProject(String title, int deadline, int revenue) throws Exception {
        Connection con = connection.getConnection();
        PreparedStatement ps = con.prepareStatement("INSERT INTO projects (title, deadline, revenue) VALUES (?, ?, ?)");
        ps.setString(1, title);
        ps.setInt(2, deadline);
        ps.setInt(3, revenue);
        ps.executeUpdate();
        con.close();
    }

    public static List<Project> getAllProjects() throws Exception {
        List<Project> list = new ArrayList<>();
        Connection con = connection.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM projects");

        while (rs.next()) {
            list.add(new Project(
                    rs.getInt("project_id"),
                    rs.getString("title"),
                    rs.getInt("deadline"),
                    rs.getInt("revenue")
            ));
        }
        con.close();
        return list;
    }
}
