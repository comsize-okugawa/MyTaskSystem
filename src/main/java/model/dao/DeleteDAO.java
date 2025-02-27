package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.entity.TaskBean;

public class DeleteDAO {
	public int Delete(TaskBean task) {
		int result = 0;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con
						.prepareStatement(
								"DELETE FROM test_task WHERE task_id = ?")) {
			//task_idを取得
			int taskId = task.getTaskId();

			pstmt.setInt(1, taskId);

			result = pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return result;

	}
}
