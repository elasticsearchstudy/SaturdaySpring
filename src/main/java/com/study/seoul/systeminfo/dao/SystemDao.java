package com.study.seoul.systeminfo.dao;

import com.study.seoul.systeminfo.entity.JavaProcessInfo;

import java.util.List;

public interface SystemDao {

    void saveProcess(JavaProcessInfo javaProcessInfo);
    List<JavaProcessInfo> findById(String processId);
    List<JavaProcessInfo> findAll();
}
