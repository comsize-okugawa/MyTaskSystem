package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.JudgeUserDAO;
import model.entity.TaskBean;

/**
 * Servlet implementation class JudgeUserDeleteServlet
 */
@WebServlet("/JudgeUserDeleteServlet")
public class JudgeUserDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JudgeUserDeleteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "judge-user-failure.jsp";

		JudgeUserDAO dao = new JudgeUserDAO();

		TaskBean bean = new TaskBean(); 

		// 選択したタスクのtaskIdを取得
		String strTaskId = request.getParameter("taskId");
		int taskId = Integer.parseInt(strTaskId);
		
		// ログイン中のuserIdを取得
		HttpSession session = request.getSession();
		String loginUserId = (String) session.getAttribute("userId");

		bean.setUserId(loginUserId);
		bean.setTaskId(taskId);

		int res = dao.UserCheck(bean);

		if (res == 1) {
			url = "task-delete-confirmation.jsp";
		}

		RequestDispatcher rd = request.getRequestDispatcher(url);

		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
