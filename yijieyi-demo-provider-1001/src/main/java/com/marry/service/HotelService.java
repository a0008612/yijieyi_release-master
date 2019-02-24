package com.marry.service;

import com.marry.entity.Hotel;
import com.marry.pojo.vo.HotelPageVO;
import com.marry.pojo.vo.PageVO;

import java.util.List;

public interface HotelService {
    public List<Hotel> listAllHotel();

    HotelPageVO listAllHotelByPage(PageVO<Hotel> pageVO);
}
