package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.DeleteDAO;
import model.dao.JudgeUserDAO;
import model.entity.TaskBean;
import model.entity.UserStatusCategoryTaskBean;

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "judge-user-failure.jsp";
		
		TaskBean bean = new TaskBean();
		JudgeUserDAO dao = new JudgeUserDAO();
		DeleteDAO deleteDAO = new DeleteDAO();
		
		//本番環境
//		HttpSession session = request.getSession();
//		String userId = session.getParameter("userId");
//		int taskId =  Integer.parseInt(session.getParameter("taskId"));
		
		//テスト
		String userId = "abc123";
		int taskId = 11;
		
		bean.setUserId(userId);
		bean.setTaskId(taskId);
		
		List<UserStatusCategoryTaskBean> listTask= deleteDAO.DeleteCheck(bean);
		request.setAttribute("list", listTask);
		
		
		int result = dao.UserCheck(bean);
		System.out.println(result);
		if (result == 1) {
			url = "task-delete-confirmation.jsp";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(url);

		rd.forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
