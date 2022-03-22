package bookmanagement.controller;

import java.io.IOException;

import bookmanagement.model.DataBean;
import bookmanagement.persistant.dao.bookDAO;
import bookmanagement.persistant.dto.BookRequestDTO;

/**
 * Servlet implementation class AddBookServlet
 */
@WebServlet("/AddBookServlet")
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddBookServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DataBean bean = new DataBean();

		bean.setBookCode(request.getParameter("code"));
		bean.setBookTitle(request.getParameter("title"));
		bean.setBookAuthor(request.getParameter("author"));
		bean.setBookPrice(request.getParameter("price"));

		if (bean.getBookCode().equals("") || bean.getBookTitle().equals("") || bean.getBookAuthor().equals("")
				|| bean.getBookPrice().equals("")) {
			request.setAttribute("Error", "Fields cannot be blank");
			request.setAttribute("bean", bean);
			request.getRequestDispatcher("AddBook.jsp").forward(request, response);
		} else {
			bookDAO dao = new bookDAO();

			BookRequestDTO dto = new BookRequestDTO();

			dto.setBookCode(bean.getBookCode());
			dto.setBookTitle(bean.getBookTitle());
			dto.setBookAuthor(bean.getBookAuthor());
			dto.setBookPrice(Double.valueOf(bean.getBookPrice()));

			int i =  dao.insertData(dto);
			if(i>0) {
				response.sendRedirect("DisplayBookServlet");
			}else {
				request.setAttribute("Error", "Insert Fail");
				request.setAttribute("bean", bean);
				request.getRequestDispatcher("AddBook.jsp").forward(request, response);
			}
			
		}

	}

}
