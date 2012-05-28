package org.colorfuldays.ssm.dao;

import junit.framework.Assert;
import org.codehaus.jackson.map.ObjectMapper;
import org.colorfuldays.ssm.BaseTestngTest;
import org.colorfuldays.ssm.domain.UserDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.annotation.Resource;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: huxing(xing.hu@360hqb.com)
 * Date: 12-5-18
 * Time: 下午6:14
 */

public class UserDAOTest extends BaseTestngTest {
    private static final Logger LOG = LoggerFactory.getLogger(UserDAOTest.class);
    @Resource
    UserDAO userDAO;
    UserDO orignUserDO;

    @BeforeTest
    public void before() {
        orignUserDO = new UserDO();
        orignUserDO.setId(1024l);
        orignUserDO.setName("Inzaghi");
        orignUserDO.setPassword("password");
    }

    @Test
    public void testGetUserById() throws Exception {
        UserDO userDO = userDAO.getUserById(1124);
        System.out.println(userDO);
        Assert.assertTrue(orignUserDO.equals(userDO));
    }

    @Test
    public void testUpdateUserDO() throws Exception {

    }

    @Test
    public void testObjectMapper() {
        UserDO userDO = new UserDO();
        userDO.setId(1124l);
        userDO.setName("Inzaghi");
        userDO.setPassword("123123");
//        JsonObjectMapper mapper = new JsonObjectMapper();
        ObjectMapper mapper = new ObjectMapper();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            mapper.writeValue(baos, userDO);
        } catch (IOException e) {
            LOG.error("Error ", e);
        } finally {
            try {
                baos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
