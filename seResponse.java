

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class seResponse
 */
@WebServlet("/seResponse")
public class seResponse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public seResponse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter p=response.getWriter();
		p.println("Thank you!");
		String cval=request.getParameter("txtcolour")+"-"+request.getParameter("txtbgcolour");
		Cookie c1=new Cookie("tcolour1",cval);
		//Cookie c2=new Cookie("bcolour",bval);
		c1.setMaxAge(60);
		response.addCookie(c1);
	}

}
