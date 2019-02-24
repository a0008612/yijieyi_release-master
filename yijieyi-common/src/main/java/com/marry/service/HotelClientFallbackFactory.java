package com.marry.service;


import com.marry.entity.Hotel;
import com.marry.pojo.vo.HotelPageVO;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class HotelClientFallbackFactory implements FallbackFactory<HotelClientService>{

	@Override
	public HotelClientService create(Throwable cause) {
		// TODO Auto-generated method stub
		return new HotelClientService() {
			@Override
			public List<Hotel> listAllHotel() {
				return null;
			}

			@Override
			public HotelPageVO listHotelByPage(int current, int pagesize) {
				return null;
			}
		};
	}

}
