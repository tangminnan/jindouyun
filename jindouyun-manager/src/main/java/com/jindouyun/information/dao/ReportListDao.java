package com.jindouyun.information.dao;

import com.jindouyun.information.domain.ReportListDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 报告列表
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-05-11 15:31:11
 */
@Mapper
public interface ReportListDao {

	ReportListDO get(Integer id);
	
	List<ReportListDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(ReportListDO reportList);
	
	int update(ReportListDO reportList);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
