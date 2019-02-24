package com.marry.dao;

import com.marry.entity.Merch;
import org.apache.ibatis.annotations.Param;

public interface MerchDao {
    int addMerch(@Param("merch")Merch merch);
}
