package com.StudentManagementController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.StudentManagementDAO.StudentDAO;
import com.StudentManagementDTO.StudentRequestDTO;

/**
 * Servlet implementation class StudentDeleteServlet
 */
@WebServlet("/StudentDeleteServlet")
public class StudentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentRequestDTO dto = new StudentRequestDTO();
		dto.setStudentId(request.getParameter("id"));
		StudentDAO dao = new StudentDAO();
		int res = dao.delete(dto);
		if (res > 0)
			request.setAttribute("msg", "Delete successful");
		else
			request.setAttribute("err", "Delete fail");
		request.getRequestDispatcher("BUD002-01.jsp").forward(request, response);
	}

}
