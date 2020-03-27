

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class cookie_assignment
 */
@WebServlet("/cookie_assignment")
public class cookie_assignment extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public cookie_assignment() {
        super();
       
    }
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] c=request.getCookies();
		//response.setContentType("text/html");
		PrintWriter p=response.getWriter();
		p.println("<html>");
		if(c==null) {	
			p.println("<body>");
			p.println("<form action=http://localhost:8080/Servlet_Practice/seResponse>");
			p.println("Please customise your font colour<br>");
			p.println("<input type=text name=txtcolour><br>");
			p.println("Please customise your background colour<br>");
			p.println("<input type=text name=txtbgcolour><br><br>");
			p.println("<input type=submit>");
			p.println("</form></body></html>");
		}
		else {
			for(int i=0;i<c.length;i++) {
				if(c[i].getName().equalsIgnoreCase("tcolour1")) {
					String cval=c[i].getValue();
					String[] sval=cval.split("-");
					p.printf("<body style=background-color:%s;>",sval[1]);
					p.printf("<font color=%s size=10><b>WELCOME</font>", sval[0]);
					p.println("</body></html>");
				}
			}
		}
		
	}

	

}
