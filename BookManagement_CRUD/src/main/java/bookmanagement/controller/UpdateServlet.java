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
import bookmanagement.persistant.dto.BookResponseDTO;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BookRequestDTO dto = new BookRequestDTO();
		dto.setBookCode(request.getParameter("code"));

		bookDAO dao = new bookDAO();
		BookResponseDTO res = dao.selectOne(dto);

		request.setAttribute("res", res);
		request.getRequestDispatcher("updatebook.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DataBean bean = new DataBean();
		String code = request.getParameter("code");
		bean.setBookCode(code);
		bean.setBookTitle(request.getParameter("title"));
		bean.setBookAuthor(request.getParameter("author"));
		bean.setBookPrice(request.getParameter("price"));

		if (bean.getBookCode().equals("") || bean.getBookTitle().equals("") || bean.getBookAuthor().equals("")
				|| bean.getBookPrice().equals("")) {
			request.setAttribute("Error", "Fields shouldn't be blank....");
			request.setAttribute("bean", bean);
			request.getRequestDispatcher("updatebook.jsp").forward(request, response);

		} else {
			bookDAO dao = new bookDAO();

			BookRequestDTO dto = new BookRequestDTO();

			dto.setBookCode(bean.getBookCode());
			dto.setBookTitle(bean.getBookTitle());
			dto.setBookAuthor(bean.getBookAuthor());
			dto.setBookPrice(Double.valueOf(bean.getBookPrice()));

			int i = dao.updateData(dto);
			if (i > 0) {
				response.sendRedirect("DisplayBookServlet");
			} else {
				request.setAttribute("Error", "Update Fail");
				request.setAttribute("bean", bean);
				request.getRequestDispatcher("AddBook.jsp").forward(request, response);
			}
		}
	}
}
