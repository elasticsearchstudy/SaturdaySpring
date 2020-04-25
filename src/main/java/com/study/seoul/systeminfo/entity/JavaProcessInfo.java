package com.study.seoul.systeminfo.entity;

import com.oracle.webservices.internal.api.databinding.DatabindingMode;
import lombok.AllArgsConstructor;
import lombok.Data;
import oshi.util.FormatUtil;

import java.time.LocalDateTime;

@Data
public class JavaProcessInfo {

    private int pid ;
    private float cpuUsage ;
    private float memoryUsage ;
    private String virtualSizeUsage ;
    private String residentSetSize ;
    private String javaProcessName ;

    public JavaProcessInfo(int pid, float cpuUsage, float memoryUsage, String virtualSizeUsage, String residentSetSize, String javaProcessName, LocalDateTime localDateTime) {
        this.pid = pid;
        this.cpuUsage = cpuUsage;
        this.memoryUsage = memoryUsage;
        this.virtualSizeUsage = virtualSizeUsage;
        this.residentSetSize = residentSetSize;
        this.javaProcessName = javaProcessName;
    }
}
