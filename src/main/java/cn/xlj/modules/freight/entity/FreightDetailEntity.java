package cn.xlj.modules.freight.entity;

import cn.xlj.modules.freight.dto.FreightDto;

import java.io.Serializable;
import java.util.Date;


/**
 * 运费数据明细表
 * 
 * @author gengbeijun
 * @email gengbeijun@xinliangjishipin.com
 * @date 2018-01-24 15:44:20
 */
public class FreightDetailEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//请求ID
	private long freightId;
	//商品sku
	private String sku;
	//是否赠品
	private Boolean isGift;
	//商品名称
	private String name;
	//商品单价
	private double unitPrice;
	//商品数量
	private Integer number;
	//单个商品重量
	private Integer weight;
	//商品高度
	private String width;
	//运输开始省份
	private String length;
	//运输开始城市
	private String height;
	//创建人
	private String createUser;
	//创建时间
	private Date createTime;
	//修改人
	private String updateUser;
	//修改时间
	private Date updateTime;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getFreightId() {
		return freightId;
	}

	public void setFreightId(long freightId) {
		this.freightId = freightId;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public Boolean getGift() {
		return isGift;
	}

	public void setGift(Boolean gift) {
		isGift = gift;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "FreightDetailEntity{" +
				"id=" + id +
				", freightId='" + freightId + '\'' +
				", sku='" + sku + '\'' +
				", isGift=" + isGift +
				", name='" + name + '\'' +
				", unitPrice=" + unitPrice +
				", number=" + number +
				", weight=" + weight +
				", width='" + width + '\'' +
				", length='" + length + '\'' +
				", height='" + height + '\'' +
				", createUser='" + createUser + '\'' +
				", createTime=" + createTime +
				", updateUser='" + updateUser + '\'' +
				", updateTime=" + updateTime +
				'}';
	}
}
