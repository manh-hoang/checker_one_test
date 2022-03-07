
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import checker_one_test.Customer;
import checker_one_test.CustomerImp;

@WebServlet("/changeLg")
public class changelange extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static CustomerImp cus_imp;

	public changelange() {
		super();
		cus_imp = new CustomerImp();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 
		String lang = request.getParameter("lang");
		HttpSession session = request.getSession();
		switch (lang) {
		case "vi":
			session.setAttribute("lang", "vi_VN");
			
			break;
		case "en":
			session.setAttribute("lang", "en_US");
			
			break;
		case "ja":
			session.setAttribute("lang", "ja_JP");
			
			break;

		default:
			session.setAttribute("lang", "");
			break;
		}
		
		response.sendRedirect("checker_one ");
		
		
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		}
	}
		

