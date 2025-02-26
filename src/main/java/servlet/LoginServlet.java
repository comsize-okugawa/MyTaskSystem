package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.UserDAO;
import model.entity.UserBean;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		遷移先指定	エラー時は再度login.jspへ
		String url = "login.jsp";
		
//		エラーメッセージ初期化
		String message = null;
		
//		ユーザIDとパスワード初期化
		String userId = null;
		String password = null;
		
//		ユーザIDとパスワードをパラメータから取得
		 userId = request.getParameter("userId");
		 password = request.getParameter("password");
		 

//		入力チェック
        if (userId == null) {
        	
            if (password == null) {
                message = "ユーザIDとパスワードが未入力です";
                
            } else {
                message = "ユーザIDが未入力です";
                
            }
			request.setAttribute("message",message);
			
        } else if (password == null) {
            message = "パスワードが未入力です";
			request.setAttribute("message",message);

        } else {
        	
			try {
//				ユーザ認証
				UserDAO userDao = new UserDAO();
				UserBean userBean = userDao.login(userId, password );
				
				if(userBean != null) {
//					成功時menu.jspへ
					url = "menu.jsp";
			
				} else {
					message = "ログイン認証に失敗しました";
					request.setAttribute("message",message);
			
				}
			} catch (SQLException | ClassNotFoundException e){
			e.printStackTrace();
			}
		}
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
	}
}
