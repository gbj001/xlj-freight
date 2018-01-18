package cn.xlj.modules.orderdetail.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author gengbeijun
 * @email gengbeijun@xinliangjishipin.com
 * @date 2018-01-12 15:04:51
 */
public class OrderDetailEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//姓名
	private String name;
	//备注
	private String content;
	//创建时间
	private Date createdTime;
	//创建人
	private String createdUser;
	//修改时间
	private Date updatedTime;
	//修改人
	private String updatedUser;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：姓名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：姓名
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：备注
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：备注
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreatedTime() {
		return createdTime;
	}
	/**
	 * 设置：创建人
	 */
	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}
	/**
	 * 获取：创建人
	 */
	public String getCreatedUser() {
		return createdUser;
	}
	/**
	 * 设置：修改时间
	 */
	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getUpdatedTime() {
		return updatedTime;
	}
	/**
	 * 设置：修改人
	 */
	public void setUpdatedUser(String updatedUser) {
		this.updatedUser = updatedUser;
	}
	/**
	 * 获取：修改人
	 */
	public String getUpdatedUser() {
		return updatedUser;
	}
}
