package com.entity.vo;

import com.entity.RexiaonongchanpinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 热销农产品
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2023-03-19 17:44:19
 */
public class RexiaonongchanpinVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 农产品名称
	 */
	
	private String nongchanpinmingcheng;
		
	/**
	 * 农产品图片
	 */
	
	private String nongchanpintupian;
		
	/**
	 * 产品分类
	 */
	
	private String chanpinfenlei;
		
	/**
	 * 是否有机
	 */
	
	private String shifouyouji;
		
	/**
	 * 品牌
	 */
	
	private String pinpai;
		
	/**
	 * 规格包装
	 */
	
	private String guigebaozhuang;
		
	/**
	 * 产地
	 */
	
	private String chandi;
		
	/**
	 * 农产品介绍
	 */
	
	private String nongchanpinjieshao;
		
	/**
	 * 单限
	 */
	
	private Integer onelimittimes;
		
	/**
	 * 库存
	 */
	
	private Integer alllimittimes;
		
	/**
	 * 最近点击时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date clicktime;
		
	/**
	 * 点击次数
	 */
	
	private Integer clicknum;
		
	/**
	 * 价格
	 */
	
	private Float price;
				
	
	/**
	 * 设置：农产品名称
	 */
	 
	public void setNongchanpinmingcheng(String nongchanpinmingcheng) {
		this.nongchanpinmingcheng = nongchanpinmingcheng;
	}
	
	/**
	 * 获取：农产品名称
	 */
	public String getNongchanpinmingcheng() {
		return nongchanpinmingcheng;
	}
				
	
	/**
	 * 设置：农产品图片
	 */
	 
	public void setNongchanpintupian(String nongchanpintupian) {
		this.nongchanpintupian = nongchanpintupian;
	}
	
	/**
	 * 获取：农产品图片
	 */
	public String getNongchanpintupian() {
		return nongchanpintupian;
	}
				
	
	/**
	 * 设置：产品分类
	 */
	 
	public void setChanpinfenlei(String chanpinfenlei) {
		this.chanpinfenlei = chanpinfenlei;
	}
	
	/**
	 * 获取：产品分类
	 */
	public String getChanpinfenlei() {
		return chanpinfenlei;
	}
				
	
	/**
	 * 设置：是否有机
	 */
	 
	public void setShifouyouji(String shifouyouji) {
		this.shifouyouji = shifouyouji;
	}
	
	/**
	 * 获取：是否有机
	 */
	public String getShifouyouji() {
		return shifouyouji;
	}
				
	
	/**
	 * 设置：品牌
	 */
	 
	public void setPinpai(String pinpai) {
		this.pinpai = pinpai;
	}
	
	/**
	 * 获取：品牌
	 */
	public String getPinpai() {
		return pinpai;
	}
				
	
	/**
	 * 设置：规格包装
	 */
	 
	public void setGuigebaozhuang(String guigebaozhuang) {
		this.guigebaozhuang = guigebaozhuang;
	}
	
	/**
	 * 获取：规格包装
	 */
	public String getGuigebaozhuang() {
		return guigebaozhuang;
	}
				
	
	/**
	 * 设置：产地
	 */
	 
	public void setChandi(String chandi) {
		this.chandi = chandi;
	}
	
	/**
	 * 获取：产地
	 */
	public String getChandi() {
		return chandi;
	}
				
	
	/**
	 * 设置：农产品介绍
	 */
	 
	public void setNongchanpinjieshao(String nongchanpinjieshao) {
		this.nongchanpinjieshao = nongchanpinjieshao;
	}
	
	/**
	 * 获取：农产品介绍
	 */
	public String getNongchanpinjieshao() {
		return nongchanpinjieshao;
	}
				
	
	/**
	 * 设置：单限
	 */
	 
	public void setOnelimittimes(Integer onelimittimes) {
		this.onelimittimes = onelimittimes;
	}
	
	/**
	 * 获取：单限
	 */
	public Integer getOnelimittimes() {
		return onelimittimes;
	}
				
	
	/**
	 * 设置：库存
	 */
	 
	public void setAlllimittimes(Integer alllimittimes) {
		this.alllimittimes = alllimittimes;
	}
	
	/**
	 * 获取：库存
	 */
	public Integer getAlllimittimes() {
		return alllimittimes;
	}
				
	
	/**
	 * 设置：最近点击时间
	 */
	 
	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}
	
	/**
	 * 获取：最近点击时间
	 */
	public Date getClicktime() {
		return clicktime;
	}
				
	
	/**
	 * 设置：点击次数
	 */
	 
	public void setClicknum(Integer clicknum) {
		this.clicknum = clicknum;
	}
	
	/**
	 * 获取：点击次数
	 */
	public Integer getClicknum() {
		return clicknum;
	}
				
	
	/**
	 * 设置：价格
	 */
	 
	public void setPrice(Float price) {
		this.price = price;
	}
	
	/**
	 * 获取：价格
	 */
	public Float getPrice() {
		return price;
	}
			
}
