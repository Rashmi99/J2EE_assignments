

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class page2
 */
@WebServlet("/page2")
public class page2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public page2() {
        super();
        // TODO Auto-generated constructor stub
    }


	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {			
			HttpSession h=request.getSession(false);
			String uname=(String)h.getAttribute("user");
			PrintWriter p=response.getWriter();
			if(uname!=null) {
			p.println("<html><body>");	
			p.println("<form action=http://localhost:8080/LoginPage/page3 method=post>");
			p.println("Old password<input type=password name=txtold><br>New password<input type=password name=txtnew><br>");
			p.println("Confirm password<input type=password name=txtconfirm><br><input type=submit value=Confirm>");
			p.println("</form></body></html>");
			}
			
		}
		catch(Exception e) {System.out.println(e);}
		
		
	}

}
