package com.StudentManagementController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.StudentManagementDAO.UserDAO;
import com.StudentManagementDTO.UserRequestDTO;
import com.StudentManagementDTO.UserResponseDTO;


/**
 * Servlet implementation class UserSearch
 */
@WebServlet("/UserSearch")
public class UserSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	UserRequestDTO dto=new UserRequestDTO();
	dto.setId(request.getParameter("id"));
	dto.setName(request.getParameter("name"));
	UserDAO dao=new UserDAO();
	ArrayList<UserResponseDTO> list=dao.select(dto);
	if(list.size()==0) {
		request.setAttribute("error", "User Not Found!!!");
		request.getRequestDispatcher("USR001.jsp").forward(request, response);
	}else {
		request.setAttribute("list", list);
		request.getRequestDispatcher("USR001.jsp").forward(request, response);
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
	}

}
