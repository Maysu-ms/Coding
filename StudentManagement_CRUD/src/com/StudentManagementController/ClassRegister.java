package com.StudentManagementController;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.StudentManagementDAO.ClassDAO;
import com.StudentManagementDTO.ClassRequestDTO;
import com.StudentManagementDTO.ClassResponseDTO;
import com.StudentManagementModel.ClassBean;

/**
 * Servlet implementation class ClassRegister
 */
@WebServlet("/ClassRegister")
public class ClassRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassRegister() {
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
		ClassBean bean=new ClassBean();
		bean.setId(request.getParameter("id"));
		bean.setName(request.getParameter("name"));
		
		if(!bean.getId().equals("") || !bean.getName().equals("")) {
			ClassRequestDTO dto=new ClassRequestDTO();
			dto.setId(bean.getId());
			dto.setName(bean.getName());
			ClassDAO dao=new ClassDAO();
			
			List<ClassResponseDTO> list=dao.select(dto);
			if(list.size() !=0) {
				int result=dao.insertData(dto);
				if(result<0) {
					request.setAttribute("error", "Register Failed!!");
					request.getRequestDispatcher("BUD003.jsp").forward(request, response);
					
				}else {
					request.setAttribute("success", "Register Successful!!");
					//request.getServletContext().setAttribute("list", list);
					request.getRequestDispatcher("BUD003.jsp").forward(request, response);
				}
			}else {
				
				request.setAttribute("error", "Register Id has already Exit!!");
				request.getRequestDispatcher("BUD003.jsp").forward(request, response);
			}
			
		}else {
			request.setAttribute("error", "Can't be Field Blank!!");
			request.setAttribute("bean", bean);
			request.getRequestDispatcher("BUD003.jsp").forward(request, response);
		}
	}

}
