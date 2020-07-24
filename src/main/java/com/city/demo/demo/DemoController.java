package com.city.demo.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class DemoController {
    
    DemoSevice demoSevice = new DemoSevice();
    String result = "no";

    @GetMapping("/connected")
    public String getConnectedCities(@RequestParam("origin") String city1,@RequestParam("destination") String city2 ) {
        if(city1 == null || city1 == "" || city2 == null || city2 == "")
            return result;

        try {
           result = demoSevice.getcitiesConnected(city1,city2);
        } catch (IOException ex){
            ex.printStackTrace();
        }

        return result;
    }

}
