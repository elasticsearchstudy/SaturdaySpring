package com.study.seoul.systeminfo.controller;

import com.study.seoul.systeminfo.dao.JavaProcessRepository;
import com.study.seoul.systeminfo.entity.JavaProcessInfo;
import com.study.seoul.systeminfo.service.SystemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SystemController {

    private SystemService systemService;

    public SystemController( SystemService systemService){
        this.systemService = systemService;

    }

    @RequestMapping(value ="/java/current")
    public @ResponseBody List<JavaProcessInfo> getCurrentJavaProcesses(){
        List<JavaProcessInfo> currentJavaProcess = systemService.getCurrentJavaProcess();
        System.out.println("---------current------------");
        currentJavaProcess.forEach(System.out::println);
        if( currentJavaProcess.size()==0) {
        	return null;
        }
        return currentJavaProcess;
    }
//데이터베이스에서 조회하는거
    @RequestMapping(value = "/java/list")
    public @ResponseBody List<JavaProcessInfo> getJavaProcesses(){

        return systemService.findAll();
    }

    @RequestMapping(value = "/java/{pid}")
    public @ResponseBody List<JavaProcessInfo> getJavaProcessesById(@PathVariable String pid){

        return systemService.getByJavaProcessId(pid);
    }
    @RequestMapping(value="/")
    public @ResponseBody String helloProject(){
//    	List<JavaProcessInfo> currentJavaProcess = systemService.getCurrentJavaProcess();
//    	JavaProcessInfo element = currentJavaProcess.get(0);
        return "Hello Saturday Spring";
//        return element;
    }

    @RequestMapping(value="/monitor")
    public String getMonitor( Model model){
        model.addAttribute("data","data");
        return "thymeleaf/monitor";
    }


}
