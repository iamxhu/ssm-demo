package org.colorfuldays.ssm.dao;

import org.colorfuldays.ssm.BaseTestngTest;
import org.colorfuldays.ssm.domain.BookDO;
import org.testng.annotations.Test;

import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA.
 * User: huxing(xing.hu@360hqb.com)
 * Date: 12-5-22
 * Time: 下午5:10
 */
public class BookDAOTest extends BaseTestngTest {

    @Resource
    private BookDAO bookDAO;

    @Test
    public void testGetBookByName() throws Exception {
        BookDO bookDO = bookDAO.getBookByName("The C Programming Language");
        System.out.println(bookDO);
    }
}
