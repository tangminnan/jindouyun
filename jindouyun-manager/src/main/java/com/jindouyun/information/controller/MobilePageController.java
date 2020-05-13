package com.jindouyun.information.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jindouyun.information.domain.ReportDetailsDO;
import com.jindouyun.information.service.ReportDetailsService;

@Controller
public class MobilePageController {
	
	@Autowired
	private ReportDetailsService reportDetailsService;
	
	@GetMapping("/report/mobilePage/{id}")
	String lin(@PathVariable("id") Integer id,Model model){
		model.addAttribute("id", id);
	    return "information/mobilePage/mobilePage";
	}
	
	
	@ResponseBody
	@GetMapping("/report/getReportDetails/{id}")
	List<ReportDetailsDO> getReportDetails(@PathVariable("id") Integer id){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("reportId", id);
		List<ReportDetailsDO> ReportDetails = reportDetailsService.list(map);
	    return ReportDetails;
	}

}
