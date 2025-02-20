package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.CategoryBean;
import model.entity.StatusBean;
import model.entity.TaskBean;
import model.entity.UserBean;

/* タスク登録のために必要な処理や情報の獲得を行うクラス */
public class TaskAddDAO {

	// タスク登録する処理（t_taskに登録する）
	public int taskAdd(TaskBean taskBean) throws ClassNotFoundException, SQLException {

		// return用
		int count;

		// sql文
		String sql = "INSERT INTO t_task(task_name, category_id, limit_date, user_id, status_code, memo) VALUES (?,?,?,?,?,?)";

		// DB接続とSQL文の設定
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			// 各カラムの値を変数に入れる
			String taskName = taskBean.getTaskName(); // タスク名
			int categoryId = taskBean.getTaskId(); // カテゴリID
			String date = taskBean.getLimitDate(); // 期限
			String userId = taskBean.getUserId(); // ユーザID
			String statusCode = taskBean.getStatusCode(); // ステータスコード
			String memo = taskBean.getMemo(); // ステータスコード

			// 各カラムの値をプレースホルダに設定
			pstmt.setString(1, taskName); // タスク名
			pstmt.setInt(2, categoryId); // カテゴリID
			pstmt.setString(3, date); // 期限
			pstmt.setString(4, userId); // ユーザID
			pstmt.setString(5, statusCode); // ステータスコード
			pstmt.setString(6, memo); // メモ	

			// sql文の実行
			count = pstmt.executeUpdate();

		}

		// return
		return count;
	}

	// テーブルにあるすべてのレコードを取得 m_user
	public List<UserBean> AllSelectUser() throws ClassNotFoundException, SQLException {

		// return用
		List<UserBean> userList = new ArrayList<UserBean>();

		// sql文
		String sql = "SELECT * FROM m_user";

		// DB接続とSQL文の設定
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			// sql文の実行
			ResultSet res = pstmt.executeQuery();

			while (res.next()) {
				// カーソルのある表（sql）から値を受け取る（timestamp型は使わないので受け取らない）
				String userId = res.getString("user_id");
				String password = res.getString("password");
				String userName = res.getString("user_name");

				// beanインスタンス化
				UserBean userBean = new UserBean();

				// UserBean型に各カラムを設定する
				userBean.setUserId(userId);
				userBean.setPassword(password);
				userBean.setUserName(userName);

				// listにbeanを入れる
				userList.add(userBean);
			}
		}
		return userList;

	}

	// テーブルにあるすべてのレコードを取得 m_category
	public List<CategoryBean> AllSelectCategory() throws ClassNotFoundException, SQLException {

		// return用
		List<CategoryBean> categoryList = new ArrayList<CategoryBean>();

		// sql文
		String sql = "SELECT * FROM m_category";

		// DB接続とSQL文の設定
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			// sql文の実行
			ResultSet res = pstmt.executeQuery();

			while (res.next()) {

				// カーソルのある表（sql）から値を受け取る（timestamp型は使わないので受け取らない）
				int categoryId = res.getInt("category_id");
				String categoryName = res.getString("category_name");

				// beanインスタンス化
				CategoryBean categoryBean = new CategoryBean();

				// UserBean型に各カラムを設定する
				categoryBean.setCategoryId(categoryId);
				categoryBean.setCategoryName(categoryName);

				// listにbeanを入れる
				categoryList.add(categoryBean);
			}
		}
		return categoryList;
	}

	// テーブルにあるすべてのレコードを取得 m_status
	public List<StatusBean> AllSelectStatus() throws ClassNotFoundException, SQLException {

		// return用
		List<StatusBean> statusList = new ArrayList<StatusBean>();

		// sql文
		String sql = "SELECT * FROM m_status";

		// DB接続とSQL文の設定
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			// sql文の実行
			ResultSet res = pstmt.executeQuery();

			while (res.next()) {
				// カーソルのある表（sql）から値を受け取る（timestamp型は使わないので受け取らない）
				String statusCode = res.getString("status_code");
				String statusName = res.getString("status_name");

				// beanインスタンス化
				StatusBean statusBean = new StatusBean();

				// UserBean型に各カラムを設定する
				statusBean.setStatusCode(statusCode);
				statusBean.setStatusName(statusName);

				// listにbeanを入れる
				statusList.add(statusBean);
			}
		}
		return statusList;
	}
}
