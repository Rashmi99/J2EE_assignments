

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
 * Servlet implementation class page1
 */
@WebServlet("/page1")
public class page1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public page1() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.sendRedirect("http://localhost:8080/LoginPage/slogin.html");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/Login", "root", "7777");
			Statement cmd=con.createStatement();
			
			String email=request.getParameter("txtemail");
			String pwd=request.getParameter("txtpwd");
			
			HttpSession h=request.getSession();
			h.setAttribute("user", email);
			
			String sql="select * from loginDetails where username='"+ email +"' and password='"+ pwd+"'";
			ResultSet buffer=cmd.executeQuery(sql);
			if(buffer.next()) {
			PrintWriter p=response.getWriter();
			
			
			if((email.equals(buffer.getString("username")))&(pwd.equals(buffer.getString("password")))){
				p.println("<html><body>");
				p.println("<form action=http://localhost:8080/LoginPage/page2 method=post>");
				p.println("Welcome"+email);
				p.println("<br><input type=submit value=change-password>");
				p.println("</form></body></html>");
				}
			}
			con.close();			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
