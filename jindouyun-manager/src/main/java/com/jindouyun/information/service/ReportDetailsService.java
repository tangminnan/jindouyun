package com.jindouyun.information.service;

import com.jindouyun.information.domain.ReportDetailsDO;

import java.util.List;
import java.util.Map;

/**
 * 报告详情
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-05-11 15:31:11
 */
public interface ReportDetailsService {
	
	ReportDetailsDO get(Integer id);
	
	List<ReportDetailsDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ReportDetailsDO reportDetails);
	
	int update(ReportDetailsDO reportDetails);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
