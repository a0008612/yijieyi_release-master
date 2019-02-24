package com.marry.controller;

import com.marry.entity.Hotel;
import com.marry.pojo.vo.HotelPageVO;
import com.marry.pojo.vo.PageVO;
import com.marry.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelProviderController {
    @Autowired
    private HotelService hotelService;

    /**
     * 查询所有的旅馆信息
     * @return
     */
    @CrossOrigin
    @RequestMapping(value="/all",method = RequestMethod.GET)
    public List<Hotel> listAllHotel(){
        return hotelService.listAllHotel();
    }

    /**
     * 通过分页的方式查询宾馆信息
     * @param current
     * @param pagesize
     * @return
     */
    @CrossOrigin
    @RequestMapping(value="/bypage",method = RequestMethod.GET)
    public HotelPageVO listHotelByPage(@RequestParam(defaultValue = "1") int current, @RequestParam(defaultValue = "8") int pagesize){
        System.out.println(current+"oooooooooooooo"+pagesize);
        PageVO<Hotel> pageVO = new PageVO<>();
        pageVO.setCurrentPage(current);
        pageVO.setPageSize(pagesize);
        return hotelService.listAllHotelByPage(pageVO);
    }
}
