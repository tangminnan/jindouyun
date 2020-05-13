package com.jindouyun.information.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 报告详情
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-05-11 15:31:11
 */
public class ReportDetailsDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//报告id
	private Integer reportId;
	//标题
	private String title;
	//内容
	private String content;
	//序号
	private Integer sort;
	
	

	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
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
	 * 设置：报告id
	 */
	public void setReportId(Integer reportId) {
		this.reportId = reportId;
	}
	/**
	 * 获取：报告id
	 */
	public Integer getReportId() {
		return reportId;
	}
	/**
	 * 设置：标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：标题
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：内容
	 */
	public String getContent() {
		return content;
	}
}
