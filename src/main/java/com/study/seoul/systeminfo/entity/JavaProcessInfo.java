package com.study.seoul.systeminfo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import oshi.util.FormatUtil;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

@NoArgsConstructor
@Data
//@AllArgsConstructor
public class JavaProcessInfo {

    private int pid ;
    private float cpuUsage ;
    private float memoryUsage ;
	private float virtualSizeUsage ;
    private float residentSetSize ;
    private String name ;
    private Timestamp  logtime=null;

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
    
    @Override
	public String toString() {
		return "JavaProcessInfo [pid=" + pid + ", cpuUsage=" + cpuUsage + ", memoryUsage=" + memoryUsage
				+ ", virtualSizeUsage=" + virtualSizeUsage + ", residentSetSize=" + residentSetSize + ", name=" + name+"]";
	}
   
}
