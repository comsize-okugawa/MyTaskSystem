package model.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;

public class TaskBean implements Serializable {

	//タスクID
	private int taskId;

	//タスク名
	private String taskName;

	//カテゴリID
	private int categoryId;

	//期限
	private LocalDate limitDate;

	//ユーザID
	private String userId;

	//ステータスコード
	private String statusCode;

	//メモ
	private String memo;

	//登録日時
	private Timestamp createDatetime;

	//更新日時
	private Timestamp updateDatetime;

	//Beanを構築
	public TaskBean() {
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

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	// Date→Stringにいったん変えた
	public LocalDate getLimitDate() {
		return limitDate;
	}

	public void setLimitDate(LocalDate limitDate) {
		this.limitDate = limitDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
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
