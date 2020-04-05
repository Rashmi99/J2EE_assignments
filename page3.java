

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class page3
 */
@WebServlet("/page3")
public class page3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public page3() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/Login", "root", "7777");
			Statement cmd=con.createStatement();
			HttpSession h=request.getSession(false);
			String uname=(String)h.getAttribute("user");
			String old=request.getParameter("txtold");
			String newp=request.getParameter("txtnew");
			String confirm=request.getParameter("txtconfirm");
			String u="select * from loginDetails where username='"+uname+"' and password='"+old+"'";
			ResultSet buffer=cmd.executeQuery(u);
			PrintWriter p=response.getWriter();
			p.println("<html><body>");
			if(buffer.next()) {
			if((newp.equals(confirm)) & (old.equals(buffer.getString("password")))) {
				String cp="update loginDetails set password='"+confirm+"'where username='"+uname+"'";
				int b=cmd.executeUpdate(cp);
				if(b==1)p.println("Updation successful!");
				else p.println("Updation error");
				p.println("</body></html>");
			
				
				}			
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	}


