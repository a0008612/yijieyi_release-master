package com.marry.service.impl;

import com.marry.dao.HotelDao;
import com.marry.entity.Hotel;
import com.marry.pojo.vo.HotelPageVO;
import com.marry.pojo.vo.PageVO;
import com.marry.service.HotelService;
import com.marry.util.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class HotelServiceImpl implements HotelService {
    private Logger logger= LoggerFactory.getLogger(StudentServiceImpl.class);

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private HotelDao dao;

    @Override
    public List<Hotel> listAllHotel() {

        String key = "allhotel";
        //定义返回的数据
        ArrayList<Hotel> hotels = new ArrayList<>();
        String allHotelString = "";
        // 缓存存在
        boolean hasKey = stringRedisTemplate.hasKey(key);
        if (hasKey) { // 从缓存中取
            allHotelString = stringRedisTemplate.opsForValue().get(key);
            System.out.println("缓存中取了宾馆分页数据");
            logger.info("从缓存中获取了宾馆分页数据！");

            System.out.println(allHotelString);

            return JsonUtils.jsonToList(allHotelString,Hotel.class);
        }


        hotels = dao.listAllHotel();

        //         放入缓存，并设置缓存时间
        stringRedisTemplate.opsForValue().set(key,JsonUtils.objectToJson(hotels)  , 60, TimeUnit.SECONDS);



        return hotels;
    }

    @Override
    public HotelPageVO listAllHotelByPage(PageVO<Hotel> pageVO) {

        String key = "hotelbypage";
        //定义返回的数据
        HotelPageVO hotelPageVO = new HotelPageVO();
        String hotelString = "";
        // 缓存存在
        boolean hasKey = stringRedisTemplate.hasKey(key);
        if (hasKey) { // 从缓存中取
            hotelString = stringRedisTemplate.opsForValue().get(key);
            System.out.println("缓存中取了宾馆分页数据");
            logger.info("从缓存中获取了宾馆分页数据！");


            return JsonUtils.jsonToPojo(hotelString, HotelPageVO.class);
        }


        List<Hotel> hotels = dao.listAllHotel();
        //放入数据总数
        pageVO.setTotalNum(hotels.size());
        List<Hotel> hotelsByPage = dao.listAllHotelByPage(pageVO);
        pageVO.setListData(hotelsByPage);

//        System.out.println(pageVO);
        hotels = pageVO.getListData();
        List<List<String>> hotel_types = new ArrayList<>();
        for (int i = 0;i < hotels.size();i++){
            String hotel_type = hotels.get(i).getHotel_type();
            String[] sps = hotel_type.split("\\|");
            System.out.println("bbbbbbbbb"+sps);
            hotel_types.add(Arrays.asList(sps));
//            for (int j = 0;j < sps.length;j++){
//                System.out.print(sps[j]);
//                System.out.println();
//            }
//            String sbsjson = JsonUtils.objectToJson(sps);
//            System.out.println("aaaaaaaaaa"+sbsjson);
//            hotels.get(i).setHotel_type(sbsjson);
        }
//        hotelPageVO.setHotel_type_list(null);

        hotelPageVO.setHotel_type_list(hotel_types);
        hotelPageVO.setPageVO(pageVO);

//         放入缓存，并设置缓存时间
        stringRedisTemplate.opsForValue().set(key,JsonUtils.objectToJson(hotelPageVO)  , 60, TimeUnit.SECONDS);

        return hotelPageVO;
    }
}
