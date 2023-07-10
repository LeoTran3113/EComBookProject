package coding.mentor.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import coding.mentor.entity.Account;
import coding.mentor.service.RegisterService;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public RegisterServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String user = request.getParameter("user");
			String password = request.getParameter("pass");
			String repassword = request.getParameter("repass");
			String email = request.getParameter("repass");
			
			if(!password.equals(repassword)) {
				response.sendRedirect("register.jsp");
			}else {
				RegisterService registerService = new RegisterService();
				Account acc = registerService.checkAccountExist(user);
				if(acc == null) {
					//dc sign up
					registerService.signup(user,password,email);
					RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
					rd.forward(request, response);
				}else {
					// day ve trang login.jsp
					response.sendRedirect("register.jsp");
				}
				
			}
			
		} catch (Exception e) {
			
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
