package model.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class UserStatusCategoryTaskBean implements Serializable {

	//	ユーザID
	private String userId;

	//	パスワード
	private String password;

	//	ユーザ名
	private String userName;

	//	カテゴリID
	private int categoryId;

	//	カテゴリ名
	private String categoryName;

	//	ステータスコード
	private String statusCode;

	//	ステータス名
	private String statusName;

	//	タスクID
	private int taskId;

	//	タスク名
	private String taskName;

	//	期限
	private Date limitDate;

	//	メモ
	private String memo;

	//	登録日時
	private Timestamp createDatetime;

	//	更新日時
	private Timestamp updateDatetime;

	// コンストラクタ
	public UserStatusCategoryTaskBean() {
	}

	//	getter／setter

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public Date getLimitDate() {
		return limitDate;
	}

	public void setLimitDate(Date limitDate) {
		this.limitDate = limitDate;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Timestamp getCreateDatetime() {
		return createDatetime;
	}

	public void setCreateDatetime(Timestamp createDatetime) {
		this.createDatetime = createDatetime;
	}

	public Timestamp getUpdateDatetime() {
		return updateDatetime;
	}

	public void setUpdateDatetime(Timestamp updateDatetime) {
		this.updateDatetime = updateDatetime;
	}

}
