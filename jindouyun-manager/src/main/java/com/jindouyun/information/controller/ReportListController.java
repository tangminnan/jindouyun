package com.jindouyun.information.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jindouyun.information.domain.ReportDetailsDO;
import com.jindouyun.information.domain.ReportListDO;
import com.jindouyun.information.service.ReportDetailsService;
import com.jindouyun.information.service.ReportListService;
import com.jindouyun.common.config.BootdoConfig;
import com.jindouyun.common.utils.PageUtils;
import com.jindouyun.common.utils.QRCodeUtils;
import com.jindouyun.common.utils.Query;
import com.jindouyun.common.utils.R;
import com.jindouyun.common.utils.ShiroUtils;

/**
 * 报告列表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-05-11 15:31:11
 */
 
@Controller
@RequestMapping("/information/reportList")
public class ReportListController {
	@Autowired
	private ReportListService reportListService;
	@Autowired
	private ReportDetailsService reportDetailsService;
	@Autowired
	private BootdoConfig bootdoConfig;

	
	@GetMapping()
	@RequiresPermissions("information:reportList:reportList")
	String ReportList(){
	    return "information/reportList/reportList";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("information:reportList:reportList")
	public PageUtils list(@RequestParam Map<String, Object> params) throws UnsupportedEncodingException{
		//查询列表数据
		Object object = params.get("reportName")==""?"":params.get("reportName");
		object = ((String) object).replaceAll("%(?![0-9a-fA-F]{2})", "%25");
		String urlStr = URLDecoder.decode((String) object, "UTF-8");
		params.put("reportName", urlStr);
		System.out.println(urlStr);
		if(!ShiroUtils.getUser().getUsername().equals("admin")){
			params.put("createBy", ShiroUtils.getUser().getUsername());
		}
        Query query = new Query(params);
		List<ReportListDO> reportListList = reportListService.list(query);
		int total = reportListService.count(query);
		PageUtils pageUtils = new PageUtils(reportListList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("information:reportList:add")
	String add(){
	    return "information/reportList/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("information:reportList:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		ReportListDO reportList = reportListService.get(id);
		model.addAttribute("reportList", reportList);
	    return "information/reportList/edit";
	}
	
	@ResponseBody
	@GetMapping("/getReportDetails/{id}")
	List<ReportDetailsDO> getReportDetails(@PathVariable("id") Integer id){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("reportId", id);
		List<ReportDetailsDO> ReportDetails = reportDetailsService.list(map);
	    return ReportDetails;
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("information:reportList:add")
	public R save(@RequestBody ReportListDO reportList){
		return reportListService.saveReport(reportList);
		
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@PostMapping("/update")
	@RequiresPermissions("information:reportList:edit")
	public R update(@RequestBody ReportListDO reportList){
		return reportListService.updateReport(reportList);
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("information:reportList:remove")
	public R remove( Integer id){
		
		if(reportListService.remove(id)>0){
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("reportId", id);
			List<ReportDetailsDO> ReportDetails = reportDetailsService.list(map);
			for (ReportDetailsDO reportDetailsDO : ReportDetails) {
				reportDetailsService.remove(reportDetailsDO.getId());
			}
			return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("information:reportList:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		reportListService.batchRemove(ids);
		return R.ok();
	}

	
	@GetMapping("/erweicode/{id}")
	String erweicode(@PathVariable("id") Integer id,Model model){
		try {
			//File directory = new File("src/main/resources"); 
	        //String courseFile = directory.getCanonicalPath();
			String resource = ReportListController.class.getResource("/static/img/logo.jpg").getPath();
			String destPath = bootdoConfig.getUploadPath();
			int rand = new Random().nextInt(99999999);
	        String con = "http://jdy.jingtu99.com/report/mobilePage/"+String.valueOf(id);
	        //System.out.println(con);
			String encode = QRCodeUtils.encode(con, resource, destPath, "qrcode", true);
			model.addAttribute("url", "/files/"+encode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return "information/reportList/erweicode";
	}

	
}
