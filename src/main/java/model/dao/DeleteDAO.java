package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.TaskBean;
import model.entity.UserStatusCategoryTaskBean;

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
	
	public List<UserStatusCategoryTaskBean> DeleteChuckDAO(TaskBean task) throws ClassNotFoundException, SQLException {
		
		List<UserStatusCategoryTaskBean>listTask = new ArrayList<>();
		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con
						.prepareStatement(
								"SELECT t1.task_name, t2.category_name, t1.limit_date, t3.user_name, t4.status_name, t1.memo FROM test_task t1 INNER JOIN m_category t2 ON t1.category_id = t2.category_id INNER JOIN m_user t3 ON t1.user_id = t3.user_id INNER JOIN m_status t4 ON t1.status_code = t4.status_code WHERE task_id = 11;")){
			int taskId = task.getTaskId();

			pstmt.setInt(1, taskId);

			ResultSet res = pstmt.executeQuery();
			
			while(res.next()) {
				String taskName = res.getString("task_name");
				String categoryName = res.getString("category_name");
				Date limitDate = res.getDate("limit_date");
				String userName = res.getString("user_name");
				String statusName = res.getString("status_name");
				String memo = res.getString("memo");
				UserStatusCategoryTaskBean bean = new UserStatusCategoryTaskBean();
				bean.setTaskName(taskName);
				bean.setCategoryName(categoryName);
				bean.setLimitDate(limitDate);
				bean.setUserName(userName);
				bean.setStatusName(statusName);
				bean.setMemo(memo);
				listTask.add(bean);
			}

		}
		return listTask;
		
	}
}
