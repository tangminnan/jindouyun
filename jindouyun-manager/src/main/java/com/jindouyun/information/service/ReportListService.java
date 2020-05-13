package com.jindouyun.information.service;

import com.jindouyun.common.utils.R;
import com.jindouyun.information.domain.ReportListDO;

import java.util.List;
import java.util.Map;

/**
 * 报告列表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-05-11 15:31:11
 */
public interface ReportListService {
	
	ReportListDO get(Integer id);
	
	List<ReportListDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ReportListDO reportList);
	R saveReport(ReportListDO reportList);
	int update(ReportListDO reportList);
	R updateReport(ReportListDO reportList);
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
