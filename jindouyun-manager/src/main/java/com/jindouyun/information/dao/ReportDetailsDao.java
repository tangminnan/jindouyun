package com.jindouyun.information.dao;

import com.jindouyun.information.domain.ReportDetailsDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 报告详情
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-05-11 15:31:11
 */
@Mapper
public interface ReportDetailsDao {

	ReportDetailsDO get(Integer id);
	
	List<ReportDetailsDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(ReportDetailsDO reportDetails);
	
	int update(ReportDetailsDO reportDetails);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
