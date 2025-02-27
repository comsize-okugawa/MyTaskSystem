package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.entity.TaskBean;

public class JudgeUserDAO {
	int result = 0;

	public int UserCheck(TaskBean bean) {
		String user_id = null;
		int result = 0;

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con
						.prepareStatement(
								"SELECT user_id FROM test_task WHERE task_id = ?")) {

			int taskId = bean.getTaskId();
			//テスト
			System.out.println("DAOtaskId:" + taskId);

			String userId = bean.getUserId();
			//テスト
			System.out.println("DAOuserId:" + userId);

			pstmt.setInt(1, taskId);

			ResultSet res = pstmt.executeQuery();

			while (res.next()) {
				user_id = res.getString("user_id");
			}
			
			//テスト
			System.out.println("DAO:"+user_id);
			
			if (userId.equals(user_id)) {
				result = 1;
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		return result;

	}
}