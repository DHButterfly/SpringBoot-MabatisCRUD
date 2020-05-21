package com.dl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootresultcrudApplicationTests {
	@Autowired
	private DataSource dataSource;
	@Test
	public void contextLoads() throws SQLException {
		System.out.println("使用的数据源:"+dataSource.getClass());
		Connection connection = dataSource.getConnection();
		System.out.println("连接："+connection);
		connection.close();
	}

}
