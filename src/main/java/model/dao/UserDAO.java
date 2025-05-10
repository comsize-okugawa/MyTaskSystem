package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.entity.UserBean;

public class UserDAO {

	public UserBean login(String userId,String password) throws SQLException, ClassNotFoundException{
		
//		データベース接続
		try(Connection con = ConnectionManager.getConnection();
			PreparedStatement pstmt = con.prepareStatement("SELECT user_id, password, user_name FROM m_user WHERE user_id = ? AND password = ?")){
		
//		プレースホルダ仮置き
				pstmt.setString(1, userId);
				pstmt.setString(2, password);
				
//		sql実行
				try(ResultSet res = pstmt.executeQuery()){
					
					if(res.next()) {
						UserBean userBean = new UserBean();
						userBean.setUserId(res.getString("user_id"));
						userBean.setPassword(res.getString("password"));
						userBean.setUserName(res.getString("user_name"));
						return userBean;
					}
					
				}
					return null;
				
		}
		
	}
	
}
