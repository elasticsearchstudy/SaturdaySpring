package com.study.seoul.comm.schedule;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.study.seoul.comm.service.TargetService;
import com.study.seoul.comm.service.TargetStsService;
import com.study.seoul.comm.vo.TargetStsVO;
import com.study.seoul.comm.vo.TargetVO;
import com.study.seoul.systeminfo.schedule.ScheduleTask;

@Component
public class TargetCheckScheduleTask {
	Logger logger = LoggerFactory.getLogger(ScheduleTask.class);

    @Autowired
	private TargetService targetService;
    
    @Autowired
	private TargetStsService targetStsService;
    

    @Scheduled(cron="*/5 * * * * *")
    @Transactional
    public void saveJavaInfo(){
    	
    	// 1. do make HTTP request target site every 3seconds
    	TargetVO tgVo = new TargetVO();
    	List<TargetVO> list = targetService.getTargetList(tgVo);
    	String strUrl = "";
    	int resCd = 0;
    	TargetStsVO tgtStsVo = null;
    	try {
	    	for(TargetVO rtnVo : list) {
	    		strUrl = rtnVo.getTgSite();
	    		URL u = new URL("http://"+strUrl);

	    		HttpURLConnection.setFollowRedirects(false);
	    		HttpURLConnection con = (HttpURLConnection)u.openConnection();
	    		u = null;
	    		resCd = con.getResponseCode();
	    		con.disconnect();
	    		con = null;
	    		System.out.println(resCd);
	    		tgtStsVo = new TargetStsVO();
	    		tgtStsVo.setTgSite(strUrl);
				tgtStsVo.setTrnDt(tgtStsVo.getRegDate());
	
	    		if(resCd == 200) {
	    			tgtStsVo.setSiteStatus("NOR");
	    		}else {
	    			tgtStsVo.setSiteStatus("ERR");
	    		}
	
	    		// 2. and get response insert db
	    		// targetStsService.registerTargetStsInfo(tgtStsVo);
	    	
	    		Thread.sleep(3000);
	    	}
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }    
}
