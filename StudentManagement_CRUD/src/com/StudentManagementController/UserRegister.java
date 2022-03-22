package com.StudentManagementController;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.StudentManagementDAO.UserDAO;
import com.StudentManagementDTO.UserRequestDTO;
import com.StudentManagementDTO.UserResponseDTO;
import com.StudentManagementModel.UserBean;

/**
 * Servlet implementation class UserRegister
 */
@WebServlet("/UserRegister")
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserRegister() {
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
		UserBean bean = new UserBean();
		bean.setId(request.getParameter("id"));
		bean.setName(request.getParameter("name"));
		bean.setPwd(request.getParameter("pwd"));
		bean.setConpassword(request.getParameter("confirmpwd"));
		UserDAO dao=new UserDAO();
		/*
		 * List<UserResponseDTO> list=dao.select(dto); if(list.size() !=0) {
		 * 
		 * }
		 */

		if (bean.getId().equals("") || bean.getName().equals("") || bean.getPwd().equals("")
				|| bean.getConpassword().equals("")) {
			request.setAttribute("error", "Can't be Field Blank!");
			request.getRequestDispatcher("USR002.jsp").forward(request, response);

		} else {
			if (bean.getPwd().equals(bean.getConpassword())) {
				UserRequestDTO dto = new UserRequestDTO();
				dto.setId(bean.getId());
				dto.setName(bean.getName());
				dto.setPassword(bean.getPwd());
				
				
				if (dao.loginAcceess(dto)) {
					request.setAttribute("error", "This ID has already!! Please change Id ");
					//request.setAttribute("bean", bean);
					request.getRequestDispatcher("USR002.jsp").forward(request, response);

				} else {
					int result = dao.insertData(dto);
					if (result < 0) {
						request.setAttribute("error", "Register Failed!!");
						request.getRequestDispatcher("USR002.jsp").forward(request, response);

					} else {
						request.setAttribute("success", "Register Successful");
						request.getRequestDispatcher("USR002.jsp").forward(request, response);
					}
				}

			} else {
				request.setAttribute("error", "Password Must Be Same!!");
				request.getRequestDispatcher("USR002.jsp").forward(request, response);
			}

		}
	}

}
