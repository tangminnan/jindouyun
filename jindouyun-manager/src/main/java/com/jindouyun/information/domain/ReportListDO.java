package com.jindouyun.information.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;



/**
 * 报告列表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-05-11 15:31:11
 */
public class ReportListDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//报告编号
	private String reportNum;
	//报告名称
	private String reportName;
	//创建日期
	private Date createDate;
	//开始时间
	private Date startTime;
	//结束时间
	private Date endTime;
	//1：正常2：禁止
	private Integer deleteFlag;

	private List<ReportDetailsDO> reportList;
	
	
	
	public List<ReportDetailsDO> getReportList() {
		return reportList;
	}
	public void setReportList(List<ReportDetailsDO> reportList) {
		this.reportList = reportList;
	}
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
	 * 设置：报告编号
	 */
	public void setReportNum(String reportNum) {
		this.reportNum = reportNum;
	}
	/**
	 * 获取：报告编号
	 */
	public String getReportNum() {
		return reportNum;
	}
	/**
	 * 设置：报告名称
	 */
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}
	/**
	 * 获取：报告名称
	 */
	public String getReportName() {
		return reportName;
	}
	/**
	 * 设置：创建日期
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * 获取：创建日期
	 */
	public Date getCreateDate() {
		return createDate;
	}
	/**
	 * 设置：开始时间
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	/**
	 * 获取：开始时间
	 */
	public Date getStartTime() {
		return startTime;
	}
	/**
	 * 设置：结束时间
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	/**
	 * 获取：结束时间
	 */
	public Date getEndTime() {
		return endTime;
	}
	/**
	 * 设置：1：正常2：禁止
	 */
	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	/**
	 * 获取：1：正常2：禁止
	 */
	public Integer getDeleteFlag() {
		return deleteFlag;
	}
}
