package com.marry.controller;

import com.marry.entity.Hotel;
import com.marry.entity.Merch;
import com.marry.service.MerchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/merch")
public class MerchProviderController {
    @Autowired
    private MerchService merchService;

    /**
     * 新增merch
     * @return
     */
    @CrossOrigin
    @RequestMapping(value="/add",method = RequestMethod.POST)
    public int addMerch(Merch merch){
        System.out.println("ddddddddddddddddd"+merch);
        int r = merchService.addMerch(merch);
        return r;
    }

}
