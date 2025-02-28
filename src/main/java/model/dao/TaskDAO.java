package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.UserStatusCategoryTaskBean;

/*

 タスクの一覧を表示するために必要な情報を取得するクラス
 タスク一覧表示画面で使用するカラム
 ①タスク名 ②カテゴリ情報 ③期限 ④担当者情報 ⑤ステータス情報 ⑥
メモ
 
 */


public class TaskDAO {

	// すべてのテーブルにあるすべてのレコードを取得
	public List<UserStatusCategoryTaskBean> taskList() throws ClassNotFoundException, SQLException {

		// return用リストを生成
		List<UserStatusCategoryTaskBean> taskList = new ArrayList<UserStatusCategoryTaskBean>();

		// sql文
		String sql = "SELECT t.task_name, c.category_name, t.limit_date, u.user_name, s.status_name, t.memo, t.task_id, u.user_id FROM t_task t JOIN m_category c ON t.category_id = c.category_id JOIN m_status s ON t.status_code = s.status_code JOIN m_user u ON t.user_id = u.user_id;";

		// DB接続とSQL文の設定
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			// sql文の実行
			ResultSet res = pstmt.executeQuery();

			while (res.next()) {

				// カーソルのある表（sql）から値を受け取る
				String taskName = res.getString("task_name");
				String categoryName = res.getString("category_name");
				Date limitDate = res.getDate("limit_date");
				String userName = res.getString("user_name");
				String statusName = res.getString("status_name");
				String memo = res.getString("memo");
				
				int taskId = res.getInt("task_id");
				String userId = res.getString("user_id");
				
				// beanインスタンス化
				UserStatusCategoryTaskBean userStatusCategoryTaskBean = new UserStatusCategoryTaskBean();

				// UserStatusCategoryTaskBean型に各カラムを設定する
				userStatusCategoryTaskBean.setTaskName(taskName);
				userStatusCategoryTaskBean.setCategoryName(categoryName);;
				userStatusCategoryTaskBean.setLimitDate(limitDate);
				userStatusCategoryTaskBean.setUserName(userName);
				userStatusCategoryTaskBean.setStatusName(statusName);
				userStatusCategoryTaskBean.setMemo(memo);
				
				userStatusCategoryTaskBean.setTaskId(taskId);
				userStatusCategoryTaskBean.setUserId(userId);
				
				
				// listにbeanを入れる
				taskList.add(userStatusCategoryTaskBean);
			}
		}
		return taskList;
	}

}
