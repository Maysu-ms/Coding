package com.StudentManagementController;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.StudentManagementDAO.ClassDAO;
import com.StudentManagementDAO.StudentDAO;
import com.StudentManagementDTO.ClassRequestDTO;
import com.StudentManagementDTO.ClassResponseDTO;
import com.StudentManagementDTO.StudentRequestDTO;
import com.StudentManagementDTO.StudentResponseDTO;
import com.StudentManagementModel.StudentBean;

/**
 * Servlet implementation class StudentRegister
 */
@WebServlet("/StudentRegister")
public class StudentRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentRegister() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ClassDAO dao = new ClassDAO();
//		ClassRequestDTO dto = new ClassRequestDTO();
//		dto.setId("");
//		dto.setName("");
//		List<ClassResponseDTO> list = dao.select(dto);
		List<ClassResponseDTO> list = dao.selectAll();
		System.out.println("Bla Bla " +list);
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("BUD002.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String stuno = request.getParameter("id");
		String stuname = request.getParameter("name");
		String classname = request.getParameter("className");
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String attend = request.getParameter("status");
		StudentBean bean = new StudentBean();
		bean.setId(stuno);
		bean.setName(stuname);
		bean.setClassName(classname);
		bean.setYear(year);
		bean.setMonth(month);
		bean.setDay(day);
		bean.setStatus(attend);

		if (bean.getId().equals("") || bean.getName().equals("") || bean.getClassName().equals("") || bean.getYear().equals("Year")
				|| bean.getMonth().equals("Month") || bean.getDay().equals("Day") || bean.getStatus().equals("")) {

			request.setAttribute("error", "Cann't Field Blank!!");
			request.setAttribute("bean", bean);
			request.getRequestDispatcher("BUD002.jsp").forward(request, response);
		} else {
			
						
			StudentRequestDTO dto=new StudentRequestDTO();
			dto.setStudentId(bean.getId());
			dto.setStudentName(bean.getName());
			dto.setClassName(bean.getClassName());
			dto.setRegisterDate(bean.getYear()+"-"+bean.getMonth()+"-"+bean.getDay());
			dto.setStatus(bean.getStatus());
			
			StudentDAO dao=new StudentDAO();
			
			List<StudentResponseDTO> list=dao.select(dto);
			if(list.size() !=0) {
				int result=dao.insert(dto);
				if(result>0) {
					request.setAttribute("success", "Register Successful!!");
					request.getRequestDispatcher("BUD002.jsp").forward(request, response);
					
				}else {
					request.setAttribute("error", "Register Failed!!");
					request.getRequestDispatcher("BUD002.jsp").forward(request, response);	
			}
			
			}else {
				request.setAttribute("error", "StudentId has been already exist!");
				request.getRequestDispatcher("BUD002.jsp").forward(request, response);
				
			}

		}

	}

}
