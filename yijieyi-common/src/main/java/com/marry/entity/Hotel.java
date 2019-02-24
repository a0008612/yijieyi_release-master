package com.marry.entity;

import com.marry.util.JsonUtils;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class Hotel implements Serializable {
    private String hotel_id;
    private String hotel_name;
    private String hotel_price;
    private String hotel_type;
    private String hotel_address;
    private String hotel_tables;
    private int hotel_banquet;
    private String hotel_images;
    private String imagesList;
    private String typeList;

    public String getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(String hotel_id) {
        this.hotel_id = hotel_id;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public String getHotel_price() {
        return hotel_price;
    }

    public void setHotel_price(String hotel_price) {
        this.hotel_price = hotel_price;
    }

    public String getHotel_type() {
        return hotel_type;
    }

    public void setHotel_type(String hotel_type) {
        this.hotel_type = hotel_type;
    }

    public String getHotel_address() {
        return hotel_address;
    }

    public void setHotel_address(String hotel_address) {
        this.hotel_address = hotel_address;
    }

    public String getHotel_tables() {
        return hotel_tables;
    }

    public void setHotel_tables(String hotel_tables) {
        this.hotel_tables = hotel_tables;
    }

    public int getHotel_banquet() {
        return hotel_banquet;
    }

    public void setHotel_banquet(int hotel_banquet) {
        this.hotel_banquet = hotel_banquet;
    }

    public String getHotel_images() {
        return hotel_images;
    }

    public void setHotel_images(String hotel_images) {
        this.hotel_images = hotel_images;
    }

    public List<String> getImagesList(){
        return JsonUtils.jsonToList(hotel_images,String.class);
    }

    public void setImagesList(Object imagesList) {
        if(imagesList instanceof String){
            this.imagesList=(String)imagesList;
        }else {
            this.imagesList=JsonUtils.objectToJson(imagesList);
        }
    }


    public List<String> getTypeList(){
        return Arrays.asList(hotel_type.split("\\|"));

//        return null;
//        System.out.println("bbbbbbbbb"+sps);
//        for (int j = 0;j < sps.length;j++){
//            System.out.print(sps[j]);
//            System.out.println();
//        }
//        String sbsjson = JsonUtils.objectToJson(sps);
//        System.out.println("aaaaaaaaaa"+sbsjson);
//        hotels.get(i).setHotel_type(sbsjson);
    }
    public void setTypeList(Object typeList){
        if(typeList instanceof String){
            this.typeList=(String)typeList;
        }else {
            this.typeList=JsonUtils.objectToJson(typeList);
        }
    }
}
