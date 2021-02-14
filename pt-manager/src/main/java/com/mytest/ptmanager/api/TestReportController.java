package com.mytest.ptmanager.api;

import com.mytest.ptmanager.wrapper.PtWorkerWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

//TODO 接入springmvc
@Controller
@RequestMapping("/Report")
//@RestController
@ResponseBody
public class TestReportController {

    @Resource
    private PtWorkerWrapper ptWorkerWrapper;

    @GetMapping("test")
    private void test(){
        ptWorkerWrapper.test();
    }
}
