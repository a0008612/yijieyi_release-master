package com.marry.service.impl;

import com.marry.dao.MerchDao;
import com.marry.entity.Merch;
import com.marry.service.MerchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;


@Service
public class MerchServiceImpl implements MerchService {
    private Logger logger= LoggerFactory.getLogger(StudentServiceImpl.class);

    @Autowired
    private MerchDao dao;

    @Override
    public int addMerch(Merch merch) {
        return dao.addMerch(merch);
    }
}
