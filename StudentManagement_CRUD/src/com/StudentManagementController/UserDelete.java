package com.StudentManagementController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.StudentManagementDAO.UserDAO;
import com.StudentManagementDTO.UserRequestDTO;


/**
 * Servlet implementation class UserDelete
 */
@WebServlet("/UserDelete")
public class UserDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDelete() {
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
	int result=dao.delete(dto);
	if (result > 0) {
		request.setAttribute("success", "Delete successful");
		request.getRequestDispatcher("USR001.jsp").forward(request, response);
	}else {
		request.setAttribute("error", "Delete fail");
	request.getRequestDispatcher("USR001.jsp").forward(request, response);

	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			
			
			
		
	}

}
