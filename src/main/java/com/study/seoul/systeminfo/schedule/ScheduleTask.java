package com.study.seoul.systeminfo.schedule;

import com.study.seoul.systeminfo.dao.JavaProcessRepository;
import com.study.seoul.systeminfo.service.SystemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleTask {

    Logger logger = LoggerFactory.getLogger(ScheduleTask.class);
    private final SystemService systemService;
    JavaProcessRepository javaProcessRepository;

    public ScheduleTask( SystemService systemService, JavaProcessRepository javaProcessRepository ){
        this.systemService = systemService;
        this.javaProcessRepository = javaProcessRepository;
    }

    @Scheduled(cron="*/5 * * * * *")
    public void saveJavaInfo(){
        //TODO. repository에 저장하기
//        javaProcessRepository.saveProcess(currentJavaProcess);
        logger.info("insert JavaPRocesses into DB");
        currentJavaProcess.forEach( javaProcessInfo ->{
            javaProcessRepository.saveProcess(javaProcessInfo);
                });
    }

}
