package com.marry.pojo.vo;

import com.marry.entity.Hotel;

import java.io.Serializable;
import java.util.List;

public class HotelPageVO implements Serializable {

        private PageVO<Hotel> pageVO;
        private List<List<String>> hotel_type_list;

        public PageVO<Hotel> getPageVO() {
            return pageVO;
        }

        public void setPageVO(PageVO<Hotel> pageVO) {
            this.pageVO = pageVO;
        }

        public List<List<String>> getHotel_type_list() {
            return hotel_type_list;
        }

        public void setHotel_type_list(List<List<String>> hotel_type_list) {
            this.hotel_type_list = hotel_type_list;
        }


}
