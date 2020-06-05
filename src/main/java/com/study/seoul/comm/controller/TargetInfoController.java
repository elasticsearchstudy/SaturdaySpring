package com.study.seoul.comm.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.study.seoul.comm.service.TargetService;
import com.study.seoul.comm.vo.DataGrid;
import com.study.seoul.comm.vo.TargetVO;

@Controller
public class TargetInfoController {
	
	@Autowired
	private TargetService targetService;
	

	/**
	 * Target Info list  
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/tgt/getList")
	public String getList(Model model) {
		return "tgtInfo/infoList";
	}
	
	@RequestMapping(value = "/tgt/getListData")
	public @ResponseBody String getListData(@RequestBody TargetVO tgtVo){
		System.out.println("input tg site : " +tgtVo.getTgSite());
		DataGrid dtG = new DataGrid();
		dtG.setData(targetService.getTargetList(tgtVo));
		
		Gson json = new Gson();
		String jstr = json.toJson(dtG);
		System.out.println("jstr : " +jstr);
		
		return json.toJson(dtG);
	}
	
	@RequestMapping(value="/tgt/modifyData")
	public @ResponseBody String modifyData(@RequestBody TargetVO tgtVO){
		System.out.println("input tg site : " +tgtVO.getTgSite());
		// 1. update data
		targetService.modifyTargetInfo(tgtVO);
		// 2. updated data select.
		TargetVO rtnVO = targetService.getTargetData(tgtVO);
		DataGrid dtG = new DataGrid();
		List<TargetVO> list = new ArrayList<TargetVO>();
		list.add(rtnVO);
		dtG.setData(list);
		Gson json = new Gson();
		
		return json.toJson(dtG);
	}
	
	@RequestMapping(value="/tgt/regData")
	public @ResponseBody String regData(@RequestBody TargetVO tgtVO){
		System.out.println("input tg site : " +tgtVO.getTgSite());
		// 1. Insert data
		targetService.registerTargetInfo(tgtVO);
		// 2. inserted data select.
		TargetVO rtnVO = targetService.getTargetData(tgtVO);
		DataGrid dtG = new DataGrid();
		List<TargetVO> list = new ArrayList<TargetVO>();
		list.add(rtnVO);
		dtG.setData(list);
		Gson json = new Gson();
		
		return json.toJson(dtG);
	}
	
	@RequestMapping(value="/tgt/delData")
	public @ResponseBody String delData(@RequestBody TargetVO tgtVO){
		System.out.println("input tg site : " +tgtVO.getTgSite());
		// 1. delete data
		targetService.delTargetInfo(tgtVO);
		// 2. Inquiry all data.
		TargetVO schVo = new TargetVO();
		List<TargetVO> list = targetService.getTargetList(schVo);
		DataGrid dtG = new DataGrid();
		dtG.setData(list);
		Gson json = new Gson();
		
		return json.toJson(dtG);
	}

}
