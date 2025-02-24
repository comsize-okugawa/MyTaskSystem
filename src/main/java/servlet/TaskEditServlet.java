package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.TaskAddEditDAO;
import model.entity.TaskBean;

/**
 * Servlet implementation class TaskEditServlet
 */
@WebServlet("/task-edit-servlet")
public class TaskEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TaskEditServlet() {
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
		// try-catch
		try {

			// リクエストのエンコーディング方式を指定
			request.setCharacterEncoding("UTF-8");

			// リクエストパラメーターから値を取得
			String taskName = request.getParameter("taskName"); // タスク名
			String strCategoryId = request.getParameter("categoryId"); // カテゴリID IDだけ送られてくる			
				int categoryId = Integer.parseInt(strCategoryId); // 型変換
			String strLimitDate = request.getParameter("limitDate"); // 期限
				LocalDate limitDate = LocalDate.parse(strLimitDate); // 型変換（LocalDate型）
			String userId = request.getParameter("userId"); // ユーザID IDだけ送られてくる
			String statusCode = request.getParameter("statusCode"); // ステータスコード Codeだけ送られてくる
			String memo = request.getParameter("memo"); // メモ

			// TaskBean インスタンス化
			TaskBean taskBeanAfter = new TaskBean();

			// taskBeanに取得した値を設定
			taskBeanAfter.setTaskName(taskName); // タスク名
			taskBeanAfter.setCategoryId(categoryId); // カテゴリID
			taskBeanAfter.setLimitDate(limitDate); // 期限
			taskBeanAfter.setUserId(userId); // ユーザID
			taskBeanAfter.setStatusCode(statusCode); // ステータスコード
			taskBeanAfter.setMemo(memo); // メモ
			
			// インスタンス化
			TaskAddEditDAO taskEditDao = new TaskAddEditDAO();
			
			// 編集処理のメソッド
			int count = taskEditDao.taskEdit(taskBeanAfter);

			// パス指定して転送処理用オブジェクトを取得/転送
			if(count == 1) {
				request.getRequestDispatcher("task-edit-success.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("task-edit-failure.jsp").forward(request, response);
			}

			// 登録処理メソッドの例外処理
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
