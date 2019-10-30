package com.neo.mapper;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.neo.entity.UserEntity;
import com.neo.enums.UserSexEnum;
import com.neo.mapper.test1.UserMapper1;
import com.neo.mapper.test2.UserMapper2;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

	@Autowired
	private UserMapper1 UserMapper;
	@Autowired
	private UserMapper2 UserMapper2;

	@Test
	public void testInsert() throws Exception {
//		UserMapper.insert(new UserEntity("aa", "a123456", UserSexEnum.MAN));
//		UserMapper.insert(new UserEntity("bb", "b123456", UserSexEnum.WOMAN));
//		UserMapper.insert(new UserEntity("cc", "b123456", UserSexEnum.WOMAN));

		UserMapper2.insert(new UserEntity("aa", "a123456", UserSexEnum.MAN));
		UserMapper2.insert(new UserEntity("bb", "b123456", UserSexEnum.WOMAN));
		UserMapper2.insert(new UserEntity("cc", "b123456", UserSexEnum.WOMAN));
	}

	@Test
	public void testQuery() throws Exception {
		List<UserEntity> users = UserMapper.getAll();
		if(users==null || users.size()==0){
			System.out.println("is null");
		}else{
			System.out.println(users.toString());
		}
	}
	
	
	@Test
	public void testUpdate() throws Exception {
		UserEntity user = UserMapper.getOne(6l);
		System.out.println(user.toString());
		user.setNickName("neo");
		UserMapper.update(user);
		Assert.assertTrue(("neo".equals(UserMapper.getOne(6l).getNickName())));
	}

}