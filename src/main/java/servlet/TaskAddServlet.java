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
 * Servlet implementation class TaskAddServlet
 */
@WebServlet("/task-add-servlet")
public class TaskAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TaskAddServlet() {
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
				LocalDate limitDate = null; // 初期値をnullに設定
				if (strLimitDate != null && !strLimitDate.trim().isEmpty()) {
					limitDate = LocalDate.parse(strLimitDate); // 型変換（LocalDate型）
				}
			String userId = request.getParameter("userId"); // ユーザID IDだけ送られてくる
			String statusCode = request.getParameter("statusCode"); // ステータスコード Codeだけ送られてくる
			String memo = request.getParameter("memo"); // メモ
						
			// TaskBean インスタンス化
			TaskBean taskBean = new TaskBean(); 
			
			// taskBeanに取得した値を設定
			taskBean.setTaskName(taskName); // タスク名
			taskBean.setCategoryId(categoryId); // カテゴリID
			taskBean.setLimitDate(limitDate); // 期限
			taskBean.setUserId(userId); // ユーザID
			taskBean.setStatusCode(statusCode); // ステータスコード
			taskBean.setMemo(memo); // メモ
			
			// TaskAddDAO インスタンス化
			TaskAddEditDAO taskAddDao = new TaskAddEditDAO();

			// 登録処理のメソッド
			int count = taskAddDao.taskAdd(taskBean);
			

			// パス指定して転送処理用オブジェクトを取得/転送
			request.getRequestDispatcher("task-add-success.jsp").forward(request, response);

			// String型→Date型への型変換
//		} catch (ParseException e) {
//			e.printStackTrace();

			// 登録処理メソッドの例外処理
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
