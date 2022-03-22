package bookmanagement.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookmanagement.model.DataBean;
import bookmanagement.persistant.dao.bookDAO;
import bookmanagement.persistant.dto.BookRequestDTO;

/**
 * Servlet implementation class deleteBookServlet
 */
@WebServlet("/deleteBookServlet")
public class deleteBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		
		BookRequestDTO dto =new BookRequestDTO();
		dto.setBookCode(code);
		
		bookDAO dao = new bookDAO();
		int i = dao.deleteData(dto);
		if(i>0) {
		response.sendRedirect("DisplayBookServlet");
		}else {
			request.setAttribute("Error", "Delete Fail");
			request.getRequestDispatcher("AddBook.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
