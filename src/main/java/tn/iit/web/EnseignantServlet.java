package tn.iit.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tn.iit.dao.EnseignantDAO;
import tn.iit.models.Enseignant;

/**
 * Servlet implementation class EnseignantServlet
 */
@WebServlet("/")
public class EnseignantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EnseignantDAO enseignantDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	public EnseignantServlet() {
		this.enseignantDAO = new EnseignantDAO();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertEnseignant(request, response);
				break;
			case "/delete":
				deleteEnseignant(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateEnseignant(request, response);
				break;
			default:
				listEnseignant(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listEnseignant(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Enseignant> listEnseignant = enseignantDAO.selectAllUsers();
		request.setAttribute("listEnseignant", listEnseignant);
		RequestDispatcher dispatcher = request.getRequestDispatcher("enseignant-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("enseignant-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
	
		int id = Integer.parseInt(request.getParameter("id"));
		Enseignant existingEnseignant = enseignantDAO.selectUser(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("enseignant-form.jsp");
		request.setAttribute("user", existingEnseignant);
		
		dispatcher.forward(request, response);
	}

	private void insertEnseignant(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String institution = request.getParameter("institution");
		Enseignant newEnseignant = new Enseignant(name, email, institution);
		enseignantDAO.insertUser(newEnseignant);
		response.sendRedirect("list");
	}

	private void updateEnseignant(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String institution = request.getParameter("institution");
		Enseignant book = new Enseignant(id, name, email, institution);
		enseignantDAO.updateUser(book);
		response.sendRedirect("list");
	}

	private void deleteEnseignant(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		enseignantDAO.deleteUser(id);
		response.sendRedirect("list");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
