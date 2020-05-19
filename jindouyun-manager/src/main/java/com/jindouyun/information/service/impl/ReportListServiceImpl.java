package com.jindouyun.information.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.jindouyun.common.utils.R;
import com.jindouyun.common.utils.ShiroUtils;
import com.jindouyun.information.dao.ReportDetailsDao;
import com.jindouyun.information.dao.ReportListDao;
import com.jindouyun.information.domain.ReportDetailsDO;
import com.jindouyun.information.domain.ReportListDO;
import com.jindouyun.information.service.ReportListService;



@Service
public class ReportListServiceImpl implements ReportListService {
	@Autowired
	private ReportListDao reportListDao;
	@Autowired
	private ReportDetailsDao reportDetailsDao;
	
	@Override
	public ReportListDO get(Integer id){
		return reportListDao.get(id);
	}
	
	@Override
	public List<ReportListDO> list(Map<String, Object> map){
		return reportListDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return reportListDao.count(map);
	}
	
	@Override
	public int save(ReportListDO reportList){
		return reportListDao.save(reportList);
	}
	
	@Override
	public int update(ReportListDO reportList){
		return reportListDao.update(reportList);
	}
	
	@Override
	public int remove(Integer id){
		return reportListDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return reportListDao.batchRemove(ids);
	}

	@Override
	public R saveReport(ReportListDO reportList) {
		ReportListDO report = new ReportListDO();
		report.setDeleteFlag(1);
		report.setCreateDate(new Date());
		report.setCreateBy(ShiroUtils.getUser().getName());
		report.setReportName(reportList.getReportName());
		if(reportListDao.save(report)>0){
			List<ReportDetailsDO> reportDetails = reportList.getReportList();
			for (ReportDetailsDO reportDetailsDO : reportDetails) {
				ReportDetailsDO rd = new ReportDetailsDO();
				rd.setReportId(report.getId());
				rd.setSort(reportDetailsDO.getSort());
				rd.setTitle(reportDetailsDO.getTitle());
				rd.setContent(reportDetailsDO.getContent());
				reportDetailsDao.save(rd);
			}
			return R.ok();
		}
		return R.error();
	}

	@Override
	public R updateReport(ReportListDO reportList) {
		ReportListDO report = new ReportListDO();
		report.setDeleteFlag(1);
		report.setCreateDate(new Date());
		report.setCreateBy(reportList.getCreateBy());
		report.setReportName(reportList.getReportName());
		
		reportListDao.remove(reportList.getId());
		
		if(reportListDao.save(report)>0){
			List<ReportDetailsDO> reportDetails = reportList.getReportList();
			for (ReportDetailsDO reportDetailsDO : reportDetails) {
				
				reportDetailsDao.remove(reportDetailsDO.getId());
				
				ReportDetailsDO rd = new ReportDetailsDO();
				rd.setReportId(report.getId());
				rd.setSort(reportDetailsDO.getSort());
				rd.setTitle(reportDetailsDO.getTitle());
				rd.setContent(reportDetailsDO.getContent());
				reportDetailsDao.save(rd);
			}
			return R.ok();
		}
		return R.error();
	}
	
}
