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
 * Servlet implementation class StudentUpdateServlet
 */
@WebServlet("/StudentUpdateServlet")
public class StudentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClassDAO cdao = new ClassDAO();
		ClassRequestDTO cdto = new ClassRequestDTO();
		cdto.setId("");
		cdto.setName("");
		List<ClassResponseDTO> list = cdao.select(cdto);
		request.getServletContext().setAttribute("classlist", list);

		StudentRequestDTO dto = new StudentRequestDTO();
		dto.setStudentName(request.getParameter("name"));
		dto.setStudentId("");
		dto.setClassName("");
		StudentDAO dao = new StudentDAO();
		StudentResponseDTO res = dao.select(dto).get(0);
		StudentBean bean = new StudentBean();
		bean.setId(res.getStudentId());
		bean.setName(res.getStudentName());
		bean.setClassName(res.getClassName());
		bean.setYear(res.getRegisterDate().substring(0, 4));
		bean.setMonth(res.getRegisterDate().substring(5, 7));
		bean.setDay(res.getRegisterDate().substring(8, 10));
		bean.setStatus(res.getStatus());

		request.setAttribute("bean", bean);
		request.getRequestDispatcher("BUD002-01.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentBean bean = new StudentBean();
		bean.setId(request.getParameter("id"));
		bean.setName(request.getParameter("name"));
		bean.setDay(request.getParameter("day"));
		bean.setMonth(request.getParameter("month"));
		bean.setYear(request.getParameter("year"));
		bean.setStatus(request.getParameter("status"));
		bean.setClassName(request.getParameter("className"));
		if (!bean.getId().equals("") || !bean.getName().equals("") || !bean.getStatus().equals("")
				|| !bean.getClassName().equals("") || !bean.getDay().equals("Day") || !bean.getMonth().equals("Month")
				|| !bean.getYear().equals("Year")) {
			StudentRequestDTO dto = new StudentRequestDTO();
			dto.setStudentId(bean.getId());
			dto.setStudentName(bean.getName());
			dto.setStatus(bean.getStatus());
			dto.setClassName(bean.getClassName());
			dto.setRegisterDate(bean.getYear() + "-" + bean.getMonth() + "-" + bean.getDay());
			StudentDAO dao = new StudentDAO();

			int res = dao.update(dto);
			if (res > 0)
				request.setAttribute("msg", "Update successful");
			else
				request.setAttribute("err", "Update fail");

		} else
			request.setAttribute("err", "Fields must not be null");
		request.setAttribute("bean", bean);
		request.getRequestDispatcher("BUD002-01.jsp").forward(request, response);
	}

}
