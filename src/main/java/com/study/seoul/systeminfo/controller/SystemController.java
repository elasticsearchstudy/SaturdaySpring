package com.study.seoul.systeminfo.controller;

import com.study.seoul.systeminfo.dao.JavaProcessRepository;
import com.study.seoul.systeminfo.entity.JavaProcessInfo;
import com.study.seoul.systeminfo.service.SystemService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SystemController {

    private SystemService systemService;

    public SystemController( SystemService systemService){
        this.systemService = systemService;

    }

    @RequestMapping(value ="/java/current")
    public List<JavaProcessInfo> getCurrentJavaProcesses(){
        List<JavaProcessInfo> currentJavaProcess = systemService.getCurrentJavaProcess();
        return currentJavaProcess;
    }
//데이터베이스에서 조회하는거
    @RequestMapping(value = "/java/list")
    public List<JavaProcessInfo> getJavaProcesses(){

        return systemService.findAll();
    }

    @RequestMapping(value = "/java/{pid}")
    public List<JavaProcessInfo> getJavaProcessesById(@PathVariable String pid){

        return systemService.getByJavaProcessId(pid);
    }
    @RequestMapping(value="/")
    public String helloProject(){
        return "Hello Saturday Spring";
    }


}
