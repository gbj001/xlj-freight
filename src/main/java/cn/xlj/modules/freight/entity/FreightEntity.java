package cn.xlj.modules.freight.entity;

import cn.xlj.modules.freight.dto.FreightDto;

import java.io.Serializable;
import java.util.Date;



/**
 * 运费数据表
 * 
 * @author gengbeijun
 * @email gengbeijun@xinliangjishipin.com
 * @date 2018-01-24 15:44:20
 */
public class FreightEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//请求ID
	private String requestId;
	//运输开始省份
	private String fromProvince;
	//运输开始城市
	private String fromCity;
	//运输开始区县
	private String fromArea;
	//运输到达省份
	private String toProvince;
	//运输到达城市
	private String toCity;
	//运输到达区县
	private String toArea;
	//运输到达详细地址
	private String address;
	//系统计算运费
	private Double expectFee;
	//实际运费
	private Double actualFee;
	//创建人
	private String createUser;
	//创建时间
	private Date createTime;
	//修改人
	private String updateUser;
	//修改时间
	private Date updateTime;

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：请求ID
	 */
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	/**
	 * 获取：请求ID
	 */
	public String getRequestId() {
		return requestId;
	}
	/**
	 * 设置：运输开始省份
	 */
	public void setFromProvince(String fromProvince) {
		this.fromProvince = fromProvince;
	}
	/**
	 * 获取：运输开始省份
	 */
	public String getFromProvince() {
		return fromProvince;
	}
	/**
	 * 设置：运输开始城市
	 */
	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}
	/**
	 * 获取：运输开始城市
	 */
	public String getFromCity() {
		return fromCity;
	}
	/**
	 * 设置：运输开始区县
	 */
	public void setFromArea(String fromArea) {
		this.fromArea = fromArea;
	}
	/**
	 * 获取：运输开始区县
	 */
	public String getFromArea() {
		return fromArea;
	}
	/**
	 * 设置：运输到达省份
	 */
	public void setToProvince(String toProvince) {
		this.toProvince = toProvince;
	}
	/**
	 * 获取：运输到达省份
	 */
	public String getToProvince() {
		return toProvince;
	}
	/**
	 * 设置：运输到达城市
	 */
	public void setToCity(String toCity) {
		this.toCity = toCity;
	}
	/**
	 * 获取：运输到达城市
	 */
	public String getToCity() {
		return toCity;
	}
	/**
	 * 设置：运输到达区县
	 */
	public void setToArea(String toArea) {
		this.toArea = toArea;
	}
	/**
	 * 获取：运输到达区县
	 */
	public String getToArea() {
		return toArea;
	}
	/**
	 * 设置：运输到达详细地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：运输到达详细地址
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：系统计算运费
	 */
	public void setExpectFee(Double expectFee) {
		this.expectFee = expectFee;
	}
	/**
	 * 获取：系统计算运费
	 */
	public Double getExpectFee() {
		return expectFee;
	}
	/**
	 * 设置：实际运费
	 */
	public void setActualFee(Double actualFee) {
		this.actualFee = actualFee;
	}
	/**
	 * 获取：实际运费
	 */
	public Double getActualFee() {
		return actualFee;
	}
	/**
	 * 设置：创建人
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	/**
	 * 获取：创建人
	 */
	public String getCreateUser() {
		return createUser;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：修改人
	 */
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	/**
	 * 获取：修改人
	 */
	public String getUpdateUser() {
		return updateUser;
	}
	/**
	 * 设置：修改时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	public FreightEntity(){

	}


	public FreightEntity(FreightDto freightDto){
		this.requestId = freightDto.getRequestId();
		this.fromProvince = freightDto.getFromProvince();
		this.fromCity = freightDto.getFromCity();
		this.fromArea = freightDto.getFromArea();
		this.toProvince = freightDto.getToProvince();
		this.toCity = freightDto.getToCity();
		this.toArea = freightDto.getToArea();
		this.address = freightDto.getAddress();
		this.createTime = new Date();
	}

	@Override
	public String toString() {
		return "FreightEntity{" +
				"id=" + id +
				", requestId='" + requestId + '\'' +
				", fromProvince='" + fromProvince + '\'' +
				", fromCity='" + fromCity + '\'' +
				", fromArea='" + fromArea + '\'' +
				", toProvince='" + toProvince + '\'' +
				", toCity='" + toCity + '\'' +
				", toArea='" + toArea + '\'' +
				", address='" + address + '\'' +
				", expectFee=" + expectFee +
				", actualFee=" + actualFee +
				", createUser='" + createUser + '\'' +
				", createTime=" + createTime +
				", updateUser='" + updateUser + '\'' +
				", updateTime=" + updateTime +
				'}';
	}
}
