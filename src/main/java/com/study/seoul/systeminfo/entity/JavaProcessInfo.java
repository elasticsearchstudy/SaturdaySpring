package com.study.seoul.systeminfo.entity;

import com.oracle.webservices.internal.api.databinding.DatabindingMode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import oshi.util.FormatUtil;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@NoArgsConstructor
@Data
public class JavaProcessInfo {

    private int pid ;
    private float cpuUsage ;
    private float memoryUsage ;

    private float virtualSizeUsage ;
    private float residentSetSize ;
    private String name ;
    private Timestamp  logtime;

    public JavaProcessInfo(int pid, float cpuUsage, float memoryUsage, float virtualSizeUsage, float residentSetSize, String name) {
        this.pid = pid;
        this.cpuUsage = cpuUsage;
        this.memoryUsage = memoryUsage;
        this.virtualSizeUsage = virtualSizeUsage;
        this.residentSetSize = residentSetSize;
        this.name = name;
    }
    public JavaProcessInfo(int pid, float cpuUsage, float memoryUsage, float virtualSizeUsage, float residentSetSize, String name, Timestamp localDateTime) {
        this.pid = pid;
        this.cpuUsage = cpuUsage;
        this.memoryUsage = memoryUsage;
        this.virtualSizeUsage = virtualSizeUsage;
        this.residentSetSize = residentSetSize;
        this.name = name;
        this.logtime = localDateTime;
    }
}
