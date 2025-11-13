package com.chder.gasheatsupply;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.chder.gasheatsupply.dto.ZWTimingTestPointDT0;
import com.chder.gasheatsupply.service.GasSupplyService;
import com.chder.gasheatsupply.utils.HttpClientUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class GasheatsupplyApplicationTests {

    @Autowired
    private GasSupplyService gasSupplyService;
    @Autowired
    private HttpClientUtil httpClientUtil;

    @Test
    void contextLoads() {
        //第三方接口调用
//        String s = httpClientUtil.get("https://www.cnblogs.com/miracle-luna/ajax/calendar?dateStr=");

        Map<String, Object> params = new HashMap<>();
        int[] units = new int[]{1,2};
        params.put("unitOneStatus",1);
        params.put("unitTwoStatus",1);
        params.put("actualCoalPrice",320);
        params.put("midVolSteamDemandAmount",180);
        params.put("lowVolSteamDemandAmount",90);
        params.put("pe",1100);
        params.put("unitSources",units);
        String s1 = httpClientUtil.postJson("http://192.168.111.245:8080/heatLoad/test", params);
        Object data = JSONObject.parse(s1).get("data");
        List<ZWTimingTestPointDT0> zwTimingTestPointDT0List = JSONArray.parse(JSONObject.toJSONString(data)).toJavaList(ZWTimingTestPointDT0.class);
        int i = 0;
        Date date = new Date();
        long time = date.getTime();
        String s2 = String.valueOf(time);
        System.out.printf(String.valueOf(time));
    }



}
