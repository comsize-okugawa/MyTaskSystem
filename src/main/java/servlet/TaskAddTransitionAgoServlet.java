package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.TaskAddDAO;
import model.entity.CategoryBean;
import model.entity.StatusBean;
import model.entity.UserBean;

/**
 * Servlet implementation class TaskAddTransitionAgoServlet
 */
@WebServlet("/task-add-transition-ago-servlet")
public class TaskAddTransitionAgoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TaskAddTransitionAgoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			// TaskAddDAOのインスタンス化
			TaskAddDAO dao = new TaskAddDAO();

			/* テーブルの全レコードをListで取得し、
			 * リクエストスコープに格納する処理 */
			// m_user
			List<UserBean> userList = dao.AllSelectUser();
			request.setAttribute("userList", userList);

			// m_category
			List<CategoryBean> categoryList = dao.AllSelectCategory();
			request.setAttribute("categoryList", categoryList);

			// m_status
			List<StatusBean> statusList = dao.AllSelectStatus();
			request.setAttribute("statusList", statusList);

			// 転送処理用オブジェクトを取得とパス指定/リクエストの転送(forward)
			request.getRequestDispatcher("task-add.jsp").forward(request, response);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
