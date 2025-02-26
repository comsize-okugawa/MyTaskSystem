package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.TaskAddEditDAO;
import model.entity.CategoryBean;
import model.entity.StatusBean;
import model.entity.UserBean;

/**
 * Servlet implementation class JudgeUserEditServlet
 */
@WebServlet("/judge-user-edit-servlet")
public class JudgeUserEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JudgeUserEditServlet() {
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

		// 選択したタスクのtaskIdを取得し、
		int taskId = 1; // 仮

		// 選択したタスクのuserIdを取得

		/* ユーザー認証
		 * ログイン中のユーザのuserIdと選択したタスクのuserIdが一致するか検証
		 * 一致する場合：編集画面に必要な情報を取得し、編集画面に遷移
		 * 一致しない場合：エラー画面に遷移
		 * */
		String loginUserId = "okugawa"; // 仮
		String taskUserId = "okugawa"; // 仮

		try {
			if (loginUserId.equals(taskUserId)) {
				
				// taskIdをセッションスコープに格納
				HttpSession session = request.getSession();
				session.setAttribute("taskId", taskId);
				
				// TaskAddDAOのインスタンス化
				TaskAddEditDAO dao = new TaskAddEditDAO();

				/* テーブルの全レコードをListで取得し、
				 * リクエストスコープに格納する処理 */
				// m_user
				List<UserBean> userList = dao.AllSelectUser();
				session.setAttribute("userList", userList);

				// m_category
				List<CategoryBean> categoryList = dao.AllSelectCategory();
				session.setAttribute("categoryList", categoryList);

				// m_status
				List<StatusBean> statusList = dao.AllSelectStatus();

				session.setAttribute("statusList", statusList);

				// 編集画面に遷移
				request.getRequestDispatcher("task-edit.jsp").forward(request, response);

			} else {
				// エラー画面に遷移
				request.getRequestDispatcher("task-edit-error.jsp").forward(request, response);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
