package com.mytest.ptmanager.api;

import com.mytest.ptmanager.model.dto.LoadTestDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//TODO 接入springmvc
@Controller
@RequestMapping("/LoadTest")
//@RestController
@ResponseBody
public class TestCaseExecController {
    @ResponseBody
    @RequestMapping(value="/modifyQps",method= RequestMethod.POST)
    public LoadTestDTO modifyQps(@RequestParam("threadCount")Integer threadCount,
                                 @RequestParam("cyclesCount")Integer cyclesCount){


          return null;
    }
    @ResponseBody
    @RequestMapping(value="/startLoadTest",method= RequestMethod.POST)
    public LoadTestDTO startLoadTest(@RequestParam("tcId")String tcId,
                                     @RequestParam("threadCount")Integer threadCount,
                                     @RequestParam("cyclesCount")Integer cyclesCount){


        return null;
    }

    @ResponseBody
    @RequestMapping(value="/stopLoadTest",method= RequestMethod.POST)
    public LoadTestDTO stopLoadTest(@RequestParam("tcId")String tcId){


        return null;
    }

    @ResponseBody
    @RequestMapping(value="/queryStatus",method= RequestMethod.POST)
    public LoadTestDTO queryStatus(@RequestParam("tcId")String tcId){


        return null;
    }
}
