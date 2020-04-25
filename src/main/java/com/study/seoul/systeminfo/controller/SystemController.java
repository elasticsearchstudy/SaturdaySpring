package com.study.seoul.systeminfo.controller;

import com.study.seoul.systeminfo.dao.JavaProcessRepository;
import com.study.seoul.systeminfo.entity.JavaProcessInfo;
import com.study.seoul.systeminfo.service.SystemService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SystemController {

    private SystemService systemService;

    public SystemController( SystemService systemService){
        this.systemService = systemService;

    }

    @RequestMapping(value ="/java/current/list")
    public List<JavaProcessInfo> getCurrentJavaProcesses(){
        List<JavaProcessInfo> currentJavaProcess = systemService.getCurrentJavaProcess();
        return currentJavaProcess;
    }

    @RequestMapping(value = "/java/list")
    public List<JavaProcessInfo> getJavaProcesses(){

        return systemService.getJavaProcessList();
    }

    @RequestMapping(value="/")
    public String helloProject(){
        return "Hello Saturday Spring";
    }






}
