package coding.mentor.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import coding.mentor.entity.Account;
import coding.mentor.service.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try { 
		String username = request.getParameter("user");
		String password = request.getParameter("password");
		
		LoginService loginService = new LoginService();
		
		Account acc = loginService.login(username, password);
		
		if(acc == null) {
			response.sendRedirect("fail.jsp");
//			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
//			request.setAttribute("message","Wrong user or password");
//			rd.forward(request, response);
		}else {
			//request.getRequestDispatcher("home.jsp").forward(request, response);
			//response.sendRedirect("home");
			HttpSession session = request.getSession();
			session.setAttribute("acc", acc.getUser_name());
			
			response.sendRedirect("home");
			
		}
		System.out.println(acc.getId());
		System.out.println(acc.getEmail());

	}catch (Exception e) {}
		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
