package model.entity;

import java.sql.Timestamp;

public class CategoryBean {
	
	// カテゴリID
	private int categoryId;
	// カテゴリ名
	private String CategoryName;
	// 更新日時
	private Timestamp updateDatetime;
	
	// コンストラクタ
	public CategoryBean() {
	}

	// setter/getter
	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return CategoryName;
	}

	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}

	public Timestamp getUpdateDatetime() {
		return updateDatetime;
	}

	public void setUpdateDatetime(Timestamp updateDatetime) {
		this.updateDatetime = updateDatetime;
	}
	
	
}
