package com.StudentManagementController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.StudentManagementDAO.UserDAO;
import com.StudentManagementDTO.UserRequestDTO;
import com.StudentManagementModel.UserBean;

/**
 * Servlet implementation class UserUpdate
 */
@WebServlet("/UserUpdate")
public class UserUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserRequestDTO dto=new UserRequestDTO();
		dto.setId(request.getParameter("id"));
		UserDAO dao=new UserDAO();
		request.setAttribute("bean", dao.select(dto).get(0));
		request.getRequestDispatcher("USR002-01.jsp").forward(request, response);


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserBean bean = new UserBean();
		bean.setId(request.getParameter("id"));
		bean.setName(request.getParameter("name"));
		bean.setPwd(request.getParameter("pwd"));
		bean.setConpassword(request.getParameter("confirmpwd"));

		if (bean.getId().equals("") || bean.getName().equals("") || bean.getPwd().equals("")
				|| bean.getConpassword().equals("")) {
			request.setAttribute("error", "Can't be Field Blank!");
			request.setAttribute("bean", bean);
			request.getRequestDispatcher("USR002-01.jsp").forward(request, response);

		} else {
			if (bean.getPwd().equals(bean.getConpassword())) {
				UserRequestDTO dto = new UserRequestDTO();
				dto.setId(bean.getId());
				dto.setName(bean.getName());
				dto.setPassword(bean.getPwd());
				UserDAO dao = new UserDAO();
					int result = dao.update(dto);
					if (result < 0) {
						request.setAttribute("error", "Update Failed!!");
						request.getRequestDispatcher("USR002-01.jsp").forward(request, response);

					} else {
						request.setAttribute("success", "Update Successful");
						request.getRequestDispatcher("USR002-01.jsp").forward(request, response);
					}
				

			} else {
				request.setAttribute("error", "Password Must Be Same!!");
				request.getRequestDispatcher("USR002-01.jsp").forward(request, response);
			}
			}
		

	}

}
