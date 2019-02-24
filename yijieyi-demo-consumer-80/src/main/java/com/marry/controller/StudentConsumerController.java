package com.marry.controller;

import com.marry.entity.Student;
import com.marry.fdfs.FastDFSFile;
import com.marry.fdfs.FastDFSUtils;
import com.marry.service.StudentClientService;
import com.marry.util.PropKit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 服务消费者-学生信息控制器
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/student")
public class StudentConsumerController {

    private Logger logger= LoggerFactory.getLogger(StudentConsumerController.class);

	@Autowired
	private StudentClientService studentClientService;


    @CrossOrigin
    @GetMapping(value="/gagaga")
    public String gagaga(){
        return studentClientService.gagaga();
    }

	/**;
     * 添加或者修改学生信息
     * @param student
     * @return
     */
    @CrossOrigin
    @PostMapping(value="/save")
    public boolean save(Student student){
    	return studentClientService.save(student);
    }
     
    /**
     * 查询学生信息
     * @return
     */
    @CrossOrigin
	@GetMapping(value="/list")
    public List<Student> list(){
        return studentClientService.list();
    }
     
    /**
     * 根据id查询学生信息
     * @return
     */
    @CrossOrigin
    @GetMapping(value="/get/{id}")
    public Student get(@PathVariable("id") Integer id){
        return studentClientService.get(id);
    }
     
    /**
     * 根据id删除学生信息
     * @return
     */
    @CrossOrigin
    @GetMapping(value="/delete/{id}")
    public boolean delete(@PathVariable("id") Integer id){
        return studentClientService.delete(id);
    }
	
    /**
     * 根据id删除学生信息
     * @return
     */
    @CrossOrigin
    @GetMapping(value="/getInfo")
    @ResponseBody
    public Map<String,Object> getInfo(){
        return studentClientService.getInfo();
    }


    @CrossOrigin
    @PostMapping("/upload")
    public Map<String,Object> upload(@RequestParam("file")MultipartFile file){
        Map<String,Object> map=new HashMap<>();
        map.put("code",1);
        map.put("msg","error");
        try{
            FastDFSFile fastDFSFile=new FastDFSFile(file.getBytes(),file.getOriginalFilename(),file.getSize());
            String path= PropKit.use("fdfs_client.conf").get("fdfs_server");
            String name = FastDFSUtils.uploadFile(fastDFSFile);
            map.put("code",0);
            map.put("msg","success");
            Map<String,String> data=new HashMap<>();
            data.put("src",path+"/"+name);
            map.put("data",data);
        }catch (IOException e){
            map.put("code",1);
            logger.error(e.getMessage());
        }catch (RuntimeException re){
            map.put("code",1);
            re.getMessage();
            logger.error(re.getMessage());
        }

        return map;
    }
}
