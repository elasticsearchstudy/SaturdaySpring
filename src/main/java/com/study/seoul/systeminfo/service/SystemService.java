package com.study.seoul.systeminfo.service;

import com.study.seoul.systeminfo.dao.JavaProcessRepository;
import com.study.seoul.systeminfo.entity.JavaProcessInfo;
import org.apache.ibatis.jdbc.Null;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OSProcess;
import oshi.software.os.OperatingSystem;
import oshi.util.FormatUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class SystemService {

    Logger logger = LoggerFactory.getLogger(SystemService.class);

    private SystemInfo systemInfo;
    private HardwareAbstractionLayer hardwareAbstractionLayer;
    private CentralProcessor cpu;
    private OperatingSystem operatingSystem;
//    @Autowired
    private JavaProcessRepository javaProcessRepository;
    //    private Map<String,String> value;
    public SystemService( JavaProcessRepository javaProcessRepository){
        this.javaProcessRepository = javaProcessRepository;

        this.systemInfo = new SystemInfo();
        this.hardwareAbstractionLayer = systemInfo.getHardware();
        this.cpu = hardwareAbstractionLayer.getProcessor();
        this.operatingSystem = systemInfo.getOperatingSystem();

    }
    public List<JavaProcessInfo> getByJavaProcessId(String pid){

        return javaProcessRepository.findById(pid);
    }


    public List<JavaProcessInfo> getCurrentJavaProcess() {
        GlobalMemory memory = hardwareAbstractionLayer.getMemory();
        List<JavaProcessInfo> currentJavaProcess = new ArrayList<>();
        //getJavaProcessMap();
        LocalDateTime localDateTime = LocalDateTime.now();
        Map<String,String> jps= getJavaProcessMap();

        logger.info("Processes: " + operatingSystem.getProcessCount() + ", Threads: " + operatingSystem.getThreadCount());
        // Sort by highest CPU
        List<OSProcess> procs = Arrays.asList(operatingSystem.getProcesses(10, OperatingSystem.ProcessSort.CPU));

        logger.info("   PID  %CPU %MEM       VSZ       RSS Name");
        for (int i = 0; i < procs.size() && i < 10; i++) {

            OSProcess p = procs.get(i);

            if(p.getName().equals("java")){

                int pid = p.getProcessID();
                float cpuUsage = (float) (100d * (p.getKernelTime() + p.getUserTime()) / p.getUpTime());
                float memoryUsage = (float)100d * p.getResidentSetSize() / memory.getTotal();
                float virtualSizeUsage = p.getVirtualSize();
                float residentSetSize = p.getResidentSetSize();
                String javaProcessName = jps.get(String.valueOf(p.getProcessID()));
//                String virtualSizeUsage = FormatUtil.formatBytes(p.getVirtualSize());
//                String residentSetSize = FormatUtil.formatBytes(p.getResidentSetSize());
//                String javaProcessName = jps.get(String.valueOf(p.getProcessID()));

                currentJavaProcess.add(
                        new JavaProcessInfo( pid, cpuUsage, memoryUsage, virtualSizeUsage,
                                residentSetSize, javaProcessName));
            }

        }
        return currentJavaProcess;
    }

    public List<JavaProcessInfo> findAll(){
        List<JavaProcessInfo> processes =  javaProcessRepository.findAll();

        if(Optional.of(processes).isPresent()==false)
            throw new NullPointerException("null 입니다");
        return processes;
    }

    //parsing jps info using commandline
    private Map<String,String> getJavaProcessMap( )  {
        Map<String,String> javaProcesses = new HashMap<String,String>();
        String command = "jps";
        Process p = null;
        try {
            p = Runtime.getRuntime().exec(command);
            BufferedReader inn = new BufferedReader(new InputStreamReader(p.getInputStream()));

            while (true) {
                String line = inn.readLine();
                System.out.println(line +" , "+line.split(" ").length);
                String [] javaProcess = line.split(" ");
                if(javaProcess.length==2){
                    javaProcesses.put(javaProcess[0],javaProcess[1]);
                }
                if (line == null)
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException ne){

        }
        p.destroy();


        return javaProcesses;
    }


}
