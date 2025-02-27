package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.DeleteDAO;
import model.entity.TaskBean;

/**
 * Servlet implementation class TaskDeleteServlet
 */
@WebServlet("/TaskDeleteServlet")
public class TaskDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaskDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TaskBean bean = new TaskBean();
		DeleteDAO dao = new DeleteDAO();
		bean.setTaskId(12);
		
		
		int res = dao.Delete(bean);
		
		dao.DeleteCheck(bean);
		
		
		if(res == 0) {
			
			RequestDispatcher rd = request.getRequestDispatcher("task-delete-failure.jsp");
			
			rd.forward(request, response);
		}
		request.setAttribute("res", res);
		
		RequestDispatcher rd = request.getRequestDispatcher("task-delete-success.jsp");

		rd.forward(request, response);
	}
}
