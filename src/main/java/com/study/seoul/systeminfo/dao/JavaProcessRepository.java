package com.study.seoul.systeminfo.dao;

import com.study.seoul.systeminfo.entity.JavaProcessInfo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class JavaProcessRepository implements SystemDao{

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;
    private String nameSpace = "mappers.system-mapper";

    @Override
    public void saveProcess(JavaProcessInfo javaProcessInfo) {
        //mapper name
        // saveProcess
        sqlSessionTemplate.insert(nameSpace+".saveProcess",javaProcessInfo);
    }

    @Override
    public List<JavaProcessInfo> findById(String processId) {
        //mapper name selectListByID
        List<JavaProcessInfo> javaProcessInfo = sqlSessionTemplate.selectList(nameSpace + ".selectListByID", processId);
        return javaProcessInfo;
    }

    @Override
    public List<JavaProcessInfo> findAll() {
        //mapper name : //readProcesses
        List<JavaProcessInfo> processes = sqlSessionTemplate.selectList(nameSpace + ".findAll");
        return processes;
    }

}
