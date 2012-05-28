package org.colorfuldays.ssm.util;

import junit.framework.Assert;
import org.colorfuldays.ssm.BaseTestngTest;
import org.colorfuldays.ssm.domain.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by IntelliJ IDEA.
 * User: huxing(xing.hu@360hqb.com)
 * Date: 12-5-28
 * Time: 下午12:54
 */
public class SessionManagerTest extends BaseTestngTest{

    @Autowired
    SessionManager sessionManager;

    Session dsession = null;

    @BeforeMethod
    public void setup() {
        dsession = new Session();
        dsession.setSessionId(112321);
        dsession.setAttribute("key", "attribute");
        dsession.setAttribute("group", "dba");
    }

    @Test
    public void testGetSession() throws Exception {
        Session session = sessionManager.getSession(112321);
        System.out.println(session);
        Assert.assertEquals(session.getSessionId(), 112321);
    }

    @Test
    public void testUpdateSession() throws Exception {
        Session session = sessionManager.updateSession(dsession);
        System.out.println(session);
        Assert.assertEquals(session.getAttribute("sign"),"1234569");
    }

    @Test
    public void testCleanSession() {
        sessionManager.cleanSession(112321);
    }
}
