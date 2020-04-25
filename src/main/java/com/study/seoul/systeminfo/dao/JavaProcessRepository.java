package com.study.seoul.systeminfo.dao;

import com.study.seoul.systeminfo.entity.JavaProcessInfo;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.ArrayList;

@Component
public class JavaProcessRepository {

    private static List<JavaProcessInfo> list = new ArrayList<>();

    public void saveProcess( List<JavaProcessInfo> javaProcessInfos){

        javaProcessInfos.forEach( javaProcessInfo ->{
            this.list.add(javaProcessInfo);
        });

    }

    public List<JavaProcessInfo> getProcess( ){
        return this.list;
    }
}
