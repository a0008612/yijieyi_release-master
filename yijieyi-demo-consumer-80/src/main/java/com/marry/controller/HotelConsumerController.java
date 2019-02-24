package com.marry.controller;

import com.marry.entity.Hotel;
import com.marry.entity.Student;
import com.marry.fdfs.FastDFSFile;
import com.marry.fdfs.FastDFSUtils;
import com.marry.pojo.vo.HotelPageVO;
import com.marry.pojo.vo.PageVO;
import com.marry.service.HotelClientService;
import com.marry.service.StudentClientService;
import com.marry.util.PropKit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 宾馆消费者-宾馆信息控制器
 * @auhor Administratort
 *
 */
@RestController
@RequestMapping("/hotel")
public class HotelConsumerController {

    private Logger logger= LoggerFactory.getLogger(HotelConsumerController.class);

	@Autowired
	private HotelClientService hotelClientService;


    @CrossOrigin
    @RequestMapping(value="/all",method = RequestMethod.GET)
    public List<Hotel> listAllHotel(){
        return hotelClientService.listAllHotel();
    }


    @CrossOrigin
    @RequestMapping(value="/bypage",method = RequestMethod.GET)
    public HotelPageVO listHotelByPage(@RequestParam(defaultValue = "1") int current, @RequestParam(defaultValue = "8") int pagesize){
        return hotelClientService.listHotelByPage(current, pagesize);
    }
}
