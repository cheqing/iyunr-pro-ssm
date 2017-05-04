package com.iyunr.pro;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 测试类
 * @author Boyce Lee
 *
 */

/**
 * 配置spring和junit整合，Junit启动时加载springIOC容器 spring-test，Junit
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉Junit spring配置文件，测试dao层只引入spring-dao.xml即可，因为在service层测试的时候会用到spring-service.xml，所有一并引入
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
public class BaseTest {

}
