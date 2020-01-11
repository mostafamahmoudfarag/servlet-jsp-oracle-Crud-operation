
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class connect {
  public static Connection conn()
  {
      Connection con = null;
      try {
          Class.forName("oracle.jdbc.OracleDriver");
          con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl","hr","hr");
          
      } catch (Exception ex) {
          
          System.out.println(ex.getMessage());
          
      }
  return con;
  }
public void add(int id,String name,String address)
{
    String sqlquery="insert into temp values ("+id+",'"+name+"','"+address+"')";
      try {
          PreparedStatement stmt=conn().prepareStatement(sqlquery);
          stmt.executeUpdate();
          
      } catch (SQLException ex) {
          System.out.println(ex.getMessage());
      }

}
public void delete(int id)
{
    String sqlquery="delete from temp where id="+id+"";
      try {
          PreparedStatement stmt=conn().prepareStatement(sqlquery);
          stmt.executeUpdate();
          
      } catch (SQLException ex) {
          System.out.println(ex.getMessage());
      }

}public void update(int id,String name,String address)
{
    String sqlquery="update temp set name='"+name+"',address='"+address+"' where id="+id+"";
      try {
          PreparedStatement stmt=conn().prepareStatement(sqlquery);
          stmt.executeUpdate();
          
      } catch (SQLException ex) {
          System.out.println(ex.getMessage());
      }

}
  public List<Student> allelement()
  {
       List<Student> student=new ArrayList<>();
      String sqlquery="select * from temp";
      try {
          PreparedStatement p=conn().prepareStatement(sqlquery);
          ResultSet s=p.executeQuery();
         
          
          while(s.next())
          {
           student.add(new Student(s.getInt(1),s.getString(2),s.getString(3)));
          }
      } catch (SQLException ex) {
            System.out.println(ex.getMessage());
      }
   return student;
  }
  public Student search_for(int id)
  {
      Student s = null;
       String sqlquery="select * from temp where id="+id+"";
      try {
          PreparedStatement p=conn().prepareStatement(sqlquery);
          ResultSet r=p.executeQuery();
          
          s=new Student(r.getInt(1), r.getString(2), r.getString(3));
          
   } 
      catch (Exception ex) {
            System.out.println(ex.getMessage());
      }
      return s;
      
  }
          

}
