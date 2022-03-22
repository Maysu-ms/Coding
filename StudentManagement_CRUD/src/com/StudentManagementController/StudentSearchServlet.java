package com.StudentManagementController;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.StudentManagementDAO.StudentDAO;
import com.StudentManagementDTO.StudentRequestDTO;
import com.StudentManagementDTO.StudentResponseDTO;

/**
 * Servlet implementation class StudentSearchServlet
 */
@WebServlet("/StudentSearchServlet")
public class StudentSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentRequestDTO dto = new StudentRequestDTO();
		dto.setStudentId(request.getParameter("id"));
		dto.setStudentName(request.getParameter("name"));
		dto.setClassName(request.getParameter("className"));
		StudentDAO dao = new StudentDAO();
		List<StudentResponseDTO> list = dao.select(dto);
		if (list.size() == 0)
			request.setAttribute("msg", "Student not found!");
		else
			request.setAttribute("stulist", list);
		request.getRequestDispatcher("BUD001.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
