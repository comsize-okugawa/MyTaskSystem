package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.entity.TaskBean;

public class JudgeUserDAO {
	public int UserCheck(TaskBean bean) {
		int user_id = 0;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con
						.prepareStatement(
								"SELECT user_id FROM test_task WHERE task_id = ?")) {
			int taskId = bean.getTaskId();
			pstmt.setInt(1, taskId);

			ResultSet res = pstmt.executeQuery();

			while (res.next()) {
				user_id = res.getInt(user_id);
			}

			if (taskId == user_id) {
				
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return 0;

	}
}