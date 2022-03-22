package bookmanagement.controller;

import java.io.IOException;
import java.util.ArrayList;

import bookmanagement.persistant.dao.bookDAO;
import bookmanagement.persistant.dto.BookResponseDTO;

/**
 * Servlet implementation class DisplayBookServlet
 */
@WebServlet("/DisplayBookServlet")
public class DisplayBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DisplayBookServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		bookDAO dao = new bookDAO();

		ArrayList<BookResponseDTO> list = dao.selectAll();
		if (list.size() == 0) {
			request.setAttribute("msg", "Data not found");
		} else {
			request.setAttribute("list", list);
		}
		request.getRequestDispatcher("displaybook.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
