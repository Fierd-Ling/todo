package com.hand.pojo;

import java.sql.Timestamp;
import java.util.Date;

/**
 * 
 * CUX_USER表对应user实体
 * 
 * @author zhongLingYun
 * 
 **/
public class UserDTO {

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

	/**
	 * 
	 * 用户id 主键
	 * 
	 */
	private Integer userId;

	/**
	 * 
	 * 用户名
	 * 
	 */
	private String userName;

	/**
	 * 
	 * 密码
	 * 
	 */
	private String password;

	/**
	 * 
	 * 性别 只能是M或者W m代表男 w代表女
	 * 
	 */
	private String sex;

	/**
	 * 
	 * 年龄
	 * 
	 **/
	private Integer age;

	/**
	 * 
	 * 手机号码
	 * 
	 **/
	private String phoneNumber;

	/**
	 * 
	 * 账号创建时间，由系统工具类自动提供无需用户填写
	 * 
	 */
	private Date creationDate;

	/**
	 * 
	 * 账号最后修改时间，由系统工具类自动提供无需用户填写，也不展示
	 * 
	 */
	private Date lastUpdateDate;

	/**
	 * 
	 * 账号备注信息
	 * 
	 **/
	private String comments;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
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

	public void setLastUpdateDate(Timestamp lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

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
}
