package com.StudentManagementController;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.StudentManagementDAO.UserDAO;
import com.StudentManagementDTO.UserRequestDTO;
import com.StudentManagementModel.UserBean;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("userid");
		String pwd = request.getParameter("password");
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		request.getSession().setAttribute("date", formatter.format(date));

		if (id.equals("") || pwd.equals("")) {
			request.setAttribute("error", "Can't Field Blank!!");
			request.getRequestDispatcher("LGN001.jsp").forward(request, response);

		} else {

			UserBean bean = new UserBean();
			bean.setId(id);
			bean.setPwd(pwd);
			UserRequestDTO dto = new UserRequestDTO();
			dto.setId(bean.getId());
			dto.setPassword(bean.getPwd());
			UserDAO dao = new UserDAO();
			dao.loginAcceess(dto);
			if (dao.loginAcceess(dto)) {
				request.getSession().setAttribute("dto", dto);
				request.getSession().setAttribute("name", dto.getName());
				request.getRequestDispatcher("M00001.jsp").forward(request, response);

			} else {
				request.setAttribute("error", "Login Failed!!");
				request.getRequestDispatcher("LGN001.jsp").forward(request, response);

			}
		}
	}

}
