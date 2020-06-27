package com.study.seoul.comm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TargetViewController {
	
	/**
	 * Target Info list  
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/tgt/getList")
	public String getList(Model model) {
		return "tgtInfo/infoList";
	}
	
	
	/**
	 * System Monitor  
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/tgt/monitor")
	public String monitor(Model model) {
		return "monitor/monitor";
	}
}
