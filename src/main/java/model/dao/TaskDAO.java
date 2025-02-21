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
		String sql = "SELECT * FROM m_categorySELECT * FROM  t_task t  LEFT OUTER JOIN m_status s ON t.update_datetime = s.update_datetime LEFT OUTER JOIN m_category c ON t.update_datetime = c.update_datetime LEFT OUTER JOIN m_user u ON t.update_datetime = u.update_datetime;";

		/*
		sql文
		
		SELECT
		 *
		FROM
		 t_task t
		LEFT OUTER JOIN m_status s
		ON t.update_datetime = s.update_datetime
		LEFT OUTER JOIN m_category c
		ON t.update_datetime = c.update_datetime
		LEFT OUTER JOIN m_user u
		ON t.update_datetime = u.update_datetime;
		 */

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
				
				// beanインスタンス化
				UserStatusCategoryTaskBean userStatusCategoryTaskBean = new UserStatusCategoryTaskBean();

				// UserStatusCategoryTaskBean型に各カラムを設定する
				userStatusCategoryTaskBean.setTaskName(taskName);
				userStatusCategoryTaskBean.setCategoryName(categoryName);;
				userStatusCategoryTaskBean.setLimitDate(limitDate);
				userStatusCategoryTaskBean.setUserName(userName);
				userStatusCategoryTaskBean.setStatusName(statusName);
				userStatusCategoryTaskBean.setMemo(memo);
				
				
				// listにbeanを入れる
				taskList.add(userStatusCategoryTaskBean);
			}
		}
		return taskList;
	}

}
