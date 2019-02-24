package com.marry.service;

import com.marry.entity.Hotel;
import com.marry.pojo.vo.HotelPageVO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;
import com.marry.service.HotelClientFallbackFactory;

import java.util.List;
import java.util.Map;


@FeignClient(value="QIUJIE",fallbackFactory=HotelClientFallbackFactory.class)
public interface HotelClientService {


    @RequestMapping(value="/hotel/all",method = RequestMethod.GET)
    public List<Hotel> listAllHotel();


    @RequestMapping(value="/hotel/bypage",method = RequestMethod.GET)
    public HotelPageVO listHotelByPage(@RequestParam(value = "current",defaultValue = "1") int current, @RequestParam(value = "pagesize",defaultValue = "8") int pagesize);





//    @GetMapping(value="/student/get/{id}")
//    public Student get(@PathVariable("id") Integer id);

	
}
