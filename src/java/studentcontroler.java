
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.jasper.tagplugins.jstl.core.Catch;

public class studentcontroler extends HttpServlet {

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        int id = 0;
      if(request.getParameter("id")!="")
              id=Integer.parseInt(request.getParameter("id"));
      
      String name=request.getParameter("name");
      String address=request.getParameter("address");
      connect c=new connect();
 

      if(request.getParameter("add")!=null)
      {
          c.add(id, name, address);
      }
       if(request.getParameter("delete")!=null)
      {
        c.delete(id);
      }
        if(request.getParameter("update")!=null)
      {
          c.update(id, name, address);
      }
 response.sendRedirect("studentview.jsp");
    }
   
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

  
  
}
