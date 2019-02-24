package com.marry.dao;

import com.marry.entity.Hotel;
import com.marry.pojo.vo.PageVO;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

public interface HotelDao {
    public ArrayList<Hotel> listAllHotel();

    ArrayList<Hotel> listAllHotelByPage(@Param("pageVO") PageVO<Hotel> pageVO);
}
