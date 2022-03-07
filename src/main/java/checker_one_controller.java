
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

import checker_one_test.Customer;
import checker_one_test.CustomerImp;

@WebServlet("/checker_one")
public class checker_one_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static CustomerImp cus_imp;

	public checker_one_controller() {
		super();
		cus_imp = new CustomerImp();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		String action = request.getParameter("action");
		String view = "";
		if (action == null) {
			List<Customer> cus_lst = new ArrayList<>();
			cus_lst = cus_imp.getAll();
			request.setAttribute("cus_lst", cus_lst);
			
			view = "views/index.jsp";
			
		} else {
			if (action.equals("create"))
				view = "views/create.jsp";
			else if (action.equals("edit")) {
				String id_got = request.getParameter("id_cus");
				Customer cus_found = cus_imp.get_infor(id_got);
				request.setAttribute("old_cus", cus_found);
				view = "views/edit.jsp";
			} else if (action.equals("delete")) {
				String id_delete = request.getParameter("id_delete");
				boolean check_delete = cus_imp.delete(id_delete);
				view = "views/index.jsp";
				request.setAttribute("tbao", "xóa rồi nha người anh em");
			} else if (action.equals("detail")) {
				String id_detail = request.getParameter("id_cus");
				Customer cus_detail = cus_imp.get_infor(id_detail);
				request.setAttribute("detail", cus_detail);
				view = "views/detail.jsp";
			}
			else if (action.equals("login")) {
				
				view = "views/login.jsp";
			}


		}
		request.getRequestDispatcher(view).forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String action = request.getParameter("action");
		String notifi = null, view = "";
		if ("create".equals(action)) {
			try {
				Random random = new Random();
				int n = random.nextInt(50);
				String cus_id = "CUS" + String.valueOf(n);
				String cus_name = request.getParameter("cus_name");
				int gender = Integer.parseInt(request.getParameter("gender"));
				SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
				Date birth_day = fmt.parse(request.getParameter("birth_day"));
				String country = request.getParameter("country");
				String email = request.getParameter("email");
				String phone_number = request.getParameter("phone_number");
				String bank_number = request.getParameter("bank_number");
				String banking = request.getParameter("banking");
				Customer newCus = new Customer(cus_id, cus_name, gender, birth_day, country, email, phone_number,
						bank_number, banking);
				boolean check_insert = cus_imp.create_new(newCus);
				
				if (check_insert)
					notifi = "Thêm mới thành công rồi nè";
				else
					notifi = "Thêm mới thất bại rồi nè";
			} catch (ParseException e) {
				e.printStackTrace();
			}
				view = "views/create.jsp";
				request.setAttribute("tbao", notifi);
		} else if (action.equals("edit")) {
			try {
				String old_id = request.getParameter("old_cus_id");
				String cus_name = request.getParameter("cus_name");
				int gender = Integer.parseInt(request.getParameter("gender"));
				SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
				Date birth_day;
				birth_day = fmt.parse(request.getParameter("birth_day"));
				String country = request.getParameter("country");
				String email = request.getParameter("email");
				String phone_number = request.getParameter("phone_number");
				String bank_number = request.getParameter("bank_number");
				String banking = request.getParameter("banking");
				Customer cusUpdate = new Customer(old_id, cus_name, gender, birth_day, country, email, phone_number,
						bank_number, banking);
				boolean check_insert = cus_imp.update(old_id, cusUpdate);
				if (check_insert)
					notifi = "Sửa thành công rồi bé ơi";
				else
					notifi = "Sửa thất bại rồi bé ơi";
			} catch (ParseException e) {
				e.printStackTrace();
			}
			view = "views/edit.jsp";
			 request.setAttribute("tbao", notifi);
		} else if (action.equals("search")) {
			List<Customer> found = new ArrayList<>();
			String type = request.getParameter("sort_by");
			String value = "";
			if (type == null || type.equals("name")) {
				value = request.getParameter("value");
				found = cus_imp.find_by_name(value);
			} else if (type.equals("country")) {
				value = request.getParameter("value");
				found = cus_imp.find_by_country(value);
			} else if (type.equals("phone_number")) {
				
				
				value = request.getParameter("value");
				found = cus_imp.find_by_phone(value);
			}
			request.setAttribute("found", found);
			request.setAttribute("types", "search");
			view = "views/index.jsp";
		}
		request.getRequestDispatcher(view).forward(request, response);
	}

}
