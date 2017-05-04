package com.iyunr.pro;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * ������
 * @author Boyce Lee
 *
 */

/**
 * ����spring��junit���ϣ�Junit����ʱ����springIOC���� spring-test��Junit
 */
@RunWith(SpringJUnit4ClassRunner.class)
//����Junit spring�����ļ�������dao��ֻ����spring-dao.xml���ɣ���Ϊ��service����Ե�ʱ����õ�spring-service.xml������һ������
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
public class BaseTest {

}
