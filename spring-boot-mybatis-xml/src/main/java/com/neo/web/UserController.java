package com.neo.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neo.annotation.Aliyun;
import com.neo.entity.UserEntity;
import com.neo.enums.UserSexEnum;
import com.neo.mapper.test1.UserMapper1;
import com.neo.mapper.test2.UserMapper2;
import com.neo.properties.RedisProperties;
import com.neo.util.NeoProperties;

@RestController
public class UserController {
	
	@Autowired
	private UserMapper1 userMapper;
	
	@Autowired
	private UserMapper2 userMapper2;
	
	@Autowired
	private NeoProperties neoProperties;
	
	@Autowired
	private Aliyun aliyun;

	private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping("/getUsers")
	public List<UserEntity> getUsers() {
		System.out.println("UserController.getUsers()");
		System.out.println("aliyun.getAppKey()=" + aliyun.getAppKey());
		List<UserEntity> users=userMapper.getAll();
		return users;
	}
	
    @RequestMapping("/getUser")
    public UserEntity getUser(Long id) {
		System.out.println("UserController.getUser()");
    	UserEntity user=userMapper.getOne(id);
        return user;
    }
    
    @RequestMapping("/add")
    public void save(UserEntity user) {
		LOG.info("-->>com.neo.web.UserController.save(UserEntity) start");
		user = new UserEntity(neoProperties.getName(), neoProperties.getPassword(), UserSexEnum.MAN);
    	userMapper.insert(user);
		LOG.error("-->这里是测试error错误日志!");
		LOG.info("-->>com.neo.web.UserController.save(UserEntity) end");
    }
    
    @RequestMapping(value="update")
    public void update(UserEntity user) {
    	userMapper.update(user);
    }
    
    @RequestMapping(value="/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
    	userMapper.delete(id);
    }
    
    @RequestMapping(value="/test")
    public void test() {
    	System.out.println(RedisProperties.getHost());
    	System.out.println(RedisProperties.getPort());
    }
    
    @RequestMapping("/getUser1")
    public UserEntity getUser1(Long id) {
		System.out.println("UserController.getUser1()");
    	UserEntity user=userMapper.getOne(id);
        return user;
    }
    @RequestMapping("/getUser2")
    public UserEntity getUser2(Long id) {
    	System.out.println("UserController.getUser2()");
    	UserEntity user=userMapper2.getOne(id);
    	return user;
    }
    
    
}