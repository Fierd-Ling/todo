package com.hand.pojo;

import java.util.Date;

/**
 * 
 * CUX_TODO_ITEMS表页面传过来的参数实体
 * 
 * @author zhongLingYun
 * 
 **/
public class ItemsVO {

	/**
	 * 
	 * 待办事件的id主键
	 */
	private Integer toDoItemId;

	/***
	 * 
	 * 用户id 外键关联
	 * 
	 */
	private Integer userId;

	/**
	 * 
	 * 待办事件的标题
	 * 
	 **/
	private String toDoItemTitle;

	/**
	 * 
	 * 待办事件的内容
	 * 
	 */
	private String todoItemContenet;

	/**
	 * 
	 * 待办事件的优先级1-3 1.low 2.medium 3.high
	 * 
	 * 
	 */
	private String priority;

	/**
	 * 創建時間
	 * 
	 */
	private Date creationDate;

	/**
	 * 
	 * 最後一次修改時間
	 * 
	 */
	private Date lastUpdateDate;

	/**
	 * 
	 * 待办事件的备注
	 * 
	 **/
	private String comments;

	/**
	 * 
	 * 頁面展示跟新時間
	 * 
	 */
	private String lastUpdateDateString;

	/**
	 * 
	 * 頁面展是创建时间
	 * 
	 */
	private String creationDateString;

	public String getLastUpdateDateString() {
		return lastUpdateDateString;
	}

	public void setLastUpdateDateString(String lastUpdateDateString) {
		this.lastUpdateDateString = lastUpdateDateString;
	}

	public String getCreationDateString() {
		return creationDateString;
	}

	public void setCreationDateString(String creationDateString) {
		this.creationDateString = creationDateString;
	}

	public Integer getToDoItemId() {
		return toDoItemId;
	}

	public void setToDoItemId(Integer toDoItemId) {
		this.toDoItemId = toDoItemId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getToDoItemTitle() {
		return toDoItemTitle;
	}

	public void setToDoItemTitle(String toDoItemTitle) {
		this.toDoItemTitle = toDoItemTitle;
	}

	public String getTodoItemContenet() {
		return todoItemContenet;
	}

	public void setTodoItemContenet(String todoItemContenet) {
		this.todoItemContenet = todoItemContenet;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}
