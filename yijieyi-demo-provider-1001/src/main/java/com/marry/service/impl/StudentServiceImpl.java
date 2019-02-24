package com.marry.service.impl;


import com.marry.dao.StudentDao;
import com.marry.entity.Student;
import com.marry.entity.StudentPrefix;
import com.marry.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 学生信息Service实现类
 * @author Administrator
 *
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {

    private Logger logger= LoggerFactory.getLogger(StudentServiceImpl.class);

    @Resource
    private RedisTemplate<String,Student> redisTemplate;
    // private RedisTemplate<String, Object> redisTemplate;根据实际情况取泛型

    @Autowired
    private StudentDao studentDao;
     
    @Override
    public void save(Student student) {
        studentDao.save(student);
    }
 
    @Override
    public Student findById(Integer id) {
        String key = StudentPrefix.STUDENT + id;
        // 缓存存在
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) { // 从缓存中取
            Student student = redisTemplate.opsForValue().get(key);
            System.out.println("取了");
            logger.info("从缓存中获取了用户！");
            return student;
        }
        // 从数据库取，并存回缓存
        Student student = studentDao.findById(id);
        // 放入缓存，并设置缓存时间
        redisTemplate.opsForValue().set(key, student , 600, TimeUnit.SECONDS);
        return student;
    }
 
    @Override
    public List<Student> list() {
        return studentDao.list();
    }
 
    @Override
    public void delete(Integer id) {
        studentDao.delete(id);
    }
 
}