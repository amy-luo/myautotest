package com.mytest.ptmanager.api;

import com.mytest.ptmanager.biz.impl.TestCaseExecManagerImpl;
import com.mytest.ptmanager.model.dto.LoadTestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//TODO 接入springmvc
//@Controller
@RequestMapping("/LoadTest")
@RestController
//@ResponseBody
public class TestCaseExecController {

    @Autowired
    private TestCaseExecManagerImpl manager;

    @ResponseBody
    @RequestMapping(value="/modifyQps",method= RequestMethod.POST)
    public LoadTestDTO modifyQps(@RequestParam String methodType,@RequestParam("tcId")String tcId,@RequestParam("threadCount")Integer threadCount,
                                 @RequestParam("cyclesCount")Integer cyclesCount){

        LoadTestDTO dto=manager.modifyQps(methodType,tcId,threadCount,cyclesCount);
        return dto;
    }
    @ResponseBody
    @RequestMapping(value="/startLoadTest",method= RequestMethod.POST)
    public LoadTestDTO startLoadTest(@RequestParam String methodType,@RequestParam("tcId")String tcId,
                                     @RequestParam("threadCount")Integer threadCount,
                                     @RequestParam("cyclesCount")Integer cyclesCount){

        LoadTestDTO dto=manager.startLoadTest(methodType,tcId,threadCount,cyclesCount);
        return dto;
    }

    @ResponseBody
    @RequestMapping(value="/stopLoadTest",method= RequestMethod.POST)
    public LoadTestDTO stopLoadTest(@RequestParam String methodType){
        LoadTestDTO dto=manager.stopLoadTest(methodType);
        return dto;
    }

    @ResponseBody
    @RequestMapping(value="/queryStatus",method= RequestMethod.POST)
    public LoadTestDTO queryStatus(@RequestParam String methodType){
        LoadTestDTO dto=manager.queryStatus(methodType);
        return dto;
    }
}
