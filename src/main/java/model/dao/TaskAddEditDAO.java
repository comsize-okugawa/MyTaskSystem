package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.entity.CategoryBean;
import model.entity.StatusBean;
import model.entity.TaskBean;
import model.entity.UserBean;

/* タスク登録のために必要な処理や情報の獲得を行うクラス */
public class TaskAddEditDAO {

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
			int categoryId = taskBean.getCategoryId(); // カテゴリID
			LocalDate localDate = taskBean.getLimitDate(); // 期限
			java.sql.Date date = java.sql.Date.valueOf(localDate); // かたへんかん
			String userId = taskBean.getUserId(); // ユーザID
			String statusCode = taskBean.getStatusCode(); // ステータスコード
			String memo = taskBean.getMemo(); // ステータスコード

			// 各カラムの値をプレースホルダに設定
			pstmt.setString(1, taskName); // タスク名
			pstmt.setInt(2, categoryId); // カテゴリID
			pstmt.setDate(3, date); // 期限
			pstmt.setString(4, userId); // ユーザID
			pstmt.setString(5, statusCode); // ステータスコード
			pstmt.setString(6, memo); // メモ	

			// sql文の実行
			count = pstmt.executeUpdate();

		}

		// return
		return count;
	}

	// タスク編集する処理
	public int taskEdit(TaskBean taskBeanAfter) throws ClassNotFoundException, SQLException {

		// return用
		int count;

		// 変更前のレコードを取得するメソッド
		int taskId = 1; // 仮
		TaskBean taskBeanBefore = SelectTask(taskId);

		// 動的sql文を生成するメソッド
		StringBuilder strBuiEditSql = sqlGeneration(taskBeanBefore, taskBeanAfter);
		
		/* 変更があるかどうかチェック
		 * 変更がない場合：sql処理せずに、count = 0
		 * 変更がある場合：sqlの処理に移る
		 */
		if (strBuiEditSql == null) {
			
			count = 0;
			
		} else {
			
			// StringBuilder→String に変換（prepareStatementはString型しか受け付けないっぽい）
			String editSql = strBuiEditSql.toString(); // ここでnull
			
			// DB接続とSQL文の設定
			try (Connection con = ConnectionManager.getConnection();
					PreparedStatement pstmt = con.prepareStatement(editSql)) {

				// 変更前の値を取得
				String taskNameBefore = taskBeanBefore.getTaskName();
				int categoryIdBefore = taskBeanBefore.getCategoryId();
				LocalDate limitLocalDateBefore = taskBeanBefore.getLimitDate();
				java.sql.Date limitDateBefore = java.sql.Date.valueOf(limitLocalDateBefore); // 型変換
				String userIdBefore = taskBeanBefore.getUserId();
				String statusCodeBefore = taskBeanBefore.getStatusCode();
				String memoBefore = taskBeanBefore.getMemo();

				// 変更予定の値を取得
				String taskNameAfter = taskBeanAfter.getTaskName();
				int categoryIdAfter = taskBeanAfter.getCategoryId();
				LocalDate limitLocalDateAfter = taskBeanAfter.getLimitDate();
				java.sql.Date limitDateAfter = java.sql.Date.valueOf(limitLocalDateAfter); // 型変換
				String userIdAfter = taskBeanAfter.getUserId();
				String statusCodeAfter = taskBeanAfter.getStatusCode();
				String memoAfter = taskBeanAfter.getMemo();
				
				// プレースホルダに値を設定（nullチェック, 変更しているかどうかチェック）
				int indexNum = 1; // プレースホルダのインデックス用
				
				if (taskNameAfter != null && !taskNameBefore.equals(taskNameAfter)) {
					pstmt.setString(indexNum, taskNameAfter);
					indexNum++;
				}
				if (categoryIdBefore != categoryIdAfter) {
					pstmt.setInt(indexNum, categoryIdAfter);
					indexNum++;
				}
				if (limitDateAfter != null && !limitDateBefore.equals(limitDateAfter)) {
					pstmt.setDate(indexNum, limitDateAfter);
					System.out.println("if文入った");
					indexNum++;
				}
				if (userIdAfter != null && !userIdBefore.equals(userIdAfter)) {
					pstmt.setString(indexNum, userIdAfter);
					indexNum++;
				}
				if (statusCodeAfter != null && !statusCodeBefore.equals(statusCodeAfter)) {
					pstmt.setString(indexNum, statusCodeAfter);
					indexNum++;
				}
				if (memoAfter != null && !memoBefore.equals(memoAfter)) {
					pstmt.setString(indexNum, memoAfter);
					indexNum++;
				}
				
				// WHERE句のプレースホルダの値の設定
				pstmt.setInt(indexNum , taskId); 
				
				// sql文の実行
				count = pstmt.executeUpdate();
			}
		}

		return count;

	}

	// 動的sql文を生成する（taskEdit）
	public StringBuilder sqlGeneration(TaskBean taskBeanBefore, TaskBean taskBeanAfter) {

		// return用 動的sql文の生成
		StringBuilder editSql = new StringBuilder("UPDATE t_task SET ");

		// SET句の追加用のList
		List<String> setClause = new ArrayList<>();

		// 変更前の値を取得
		String taskNameBefore = taskBeanBefore.getTaskName();
		int categoryIdBefore = taskBeanBefore.getCategoryId();
		LocalDate limitDateBefore = taskBeanBefore.getLimitDate();
		String userIdBefore = taskBeanBefore.getUserId();
		String statusCodeBefore = taskBeanBefore.getStatusCode();
		String memoBefore = taskBeanBefore.getMemo();

		// 変更予定の値を取得
		String taskNameAfter = taskBeanAfter.getTaskName();
		int categoryIdAfter = taskBeanAfter.getCategoryId();
		LocalDate limitDateAfter = taskBeanAfter.getLimitDate();
		String userIdAfter = taskBeanAfter.getUserId();
		String statusCodeAfter = taskBeanAfter.getStatusCode();
		String memoAfter = taskBeanAfter.getMemo();

		// SET句追加用のListに追加（nullチェック, 変更しているかどうかチェック） 		
		if (taskNameAfter != null && !taskNameBefore.equals(taskNameAfter)) {
			setClause.add("task_name = ? ");
		}
		if (categoryIdBefore != categoryIdAfter) {
			setClause.add("category_id = ? ");
		}
		if (limitDateAfter != null && !limitDateBefore.equals(limitDateAfter)) {
			setClause.add("limit_date = ? ");
		}
		if (userIdAfter != null && !userIdBefore.equals(userIdAfter)) {
			setClause.add("user_id = ? ");
		}
		if (statusCodeAfter != null && !statusCodeBefore.equals(statusCodeAfter)) {
			setClause.add("status_code = ? ");
		}
		if (memoAfter != null && !memoBefore.equals(memoAfter)) {
			setClause.add("memo = ? ");
		}

		/* 変更が歩かないかチェック
		 * ない場合：nullを返す
		 * ある場合：WHERE句以降を追加し、sql文を返す
		 */
		if (setClause.isEmpty()) {
			return null;
			
		} else {
			
			// SET句/WHEREの追加 
//			for(String list : setClause) {
//				editSql.append(list);
//				editSql.append(",");
//			}	
			editSql.append(String.join(",", setClause)).append("WHERE task_id = ?");
			
			// デバッグ
			System.out.println(editSql);
			
			// return
			return editSql;
		}
	}

	// taskIdをもとにレコードを取得する
	// taskIdをもとにタスクのレコードを取得する（taskEditで使用）
	public TaskBean SelectTask(int taskId) throws ClassNotFoundException, SQLException {

		// return用 
		TaskBean taskBeanBefore = new TaskBean();

		// sql文
		String sql = "SELECT * FROM t_task WHERE task_id = ? ";

		// DB接続とSQL文の設定
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			// プレースホルダに値を設定
			pstmt.setInt(1, taskId);

			// sql文の実行
			ResultSet res = pstmt.executeQuery();

			// beanに設定
			while (res.next()) {
				// カーソルのある表（sql）から値を受け取る
				String taskName = res.getString("task_name");
				int categoryId = res.getInt("category_id");
				String strLimitDate = res.getString("limit_date");
				LocalDate limitDate = LocalDate.parse(strLimitDate); // 型変換（Javaの処理の時はLocalDate型にする)
				String userId = res.getString("user_id");
				String statusCode = res.getString("status_code");
				String memo = res.getString("memo");

				// UserBean型に各カラムを設定する
				taskBeanBefore.setTaskName(taskName);
				taskBeanBefore.setCategoryId(categoryId);
				taskBeanBefore.setLimitDate(limitDate);
				taskBeanBefore.setUserId(userId);
				taskBeanBefore.setStatusCode(statusCode);
				taskBeanBefore.setMemo(memo);
			}

		}
		return taskBeanBefore;
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
