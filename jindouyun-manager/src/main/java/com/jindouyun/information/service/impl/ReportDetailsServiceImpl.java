package com.jindouyun.information.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.jindouyun.information.dao.ReportDetailsDao;
import com.jindouyun.information.domain.ReportDetailsDO;
import com.jindouyun.information.service.ReportDetailsService;



@Service
public class ReportDetailsServiceImpl implements ReportDetailsService {
	@Autowired
	private ReportDetailsDao reportDetailsDao;
	
	@Override
	public ReportDetailsDO get(Integer id){
		return reportDetailsDao.get(id);
	}
	
	@Override
	public List<ReportDetailsDO> list(Map<String, Object> map){
		return reportDetailsDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return reportDetailsDao.count(map);
	}
	
	@Override
	public int save(ReportDetailsDO reportDetails){
		return reportDetailsDao.save(reportDetails);
	}
	
	@Override
	public int update(ReportDetailsDO reportDetails){
		return reportDetailsDao.update(reportDetails);
	}
	
	@Override
	public int remove(Integer id){
		return reportDetailsDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return reportDetailsDao.batchRemove(ids);
	}
	
}
