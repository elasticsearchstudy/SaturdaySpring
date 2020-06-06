package com.study.seoul.systeminfo.schedule;

import com.study.seoul.systeminfo.dao.JavaProcessRepository;
import com.study.seoul.systeminfo.entity.JavaProcessInfo;
import com.study.seoul.systeminfo.service.SystemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class ScheduleTask {

    Logger logger = LoggerFactory.getLogger(ScheduleTask.class);
    private final SystemService systemService;
    JavaProcessRepository javaProcessRepository;

    public ScheduleTask( SystemService systemService, JavaProcessRepository javaProcessRepository ){
        this.systemService = systemService;
        this.javaProcessRepository = javaProcessRepository;
    }

//    @Scheduled(cron="*/5 * * * * *")
    @Scheduled(cron="*/30 * * * * *")
    @Transactional
    public void saveJavaInfo(){
        List<JavaProcessInfo> currentJavaProcess = systemService.getCurrentJavaProcess();
        //TODO. 특정 수치 이상이면 메일로알람 메세지보내기
        //currentJavaProcess 를 사용해서 특정 확인

        //TODO. repository에 저장하기
//        javaProcessRepository.saveProcess(currentJavaProcess);
        logger.info("insert JavaPRocesses into DB");
        currentJavaProcess.forEach( javaProcessInfo ->{
            javaProcessRepository.saveProcess(javaProcessInfo);
                });
    }

}
