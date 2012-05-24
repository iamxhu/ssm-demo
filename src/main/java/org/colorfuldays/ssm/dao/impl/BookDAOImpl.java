package org.colorfuldays.ssm.dao.impl;

import com.google.code.ssm.api.ReadThroughAssignCache;
import com.google.code.ssm.api.format.UseJson;
import org.colorfuldays.ssm.dao.BookDAO;
import org.colorfuldays.ssm.domain.BookDO;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * User: huxing(xing.hu@360hqb.com)
 * Date: 12-5-22
 * Time: 下午4:57
 */
@Repository("bookDAO")
public class BookDAOImpl implements BookDAO {
    @Override
    @UseJson
    @ReadThroughAssignCache(namespace = "star", assignedKey ="110", expiration = 30)
    public BookDO getBookByName(String name) {
        BookDO bookDO = new BookDO();
        bookDO.setName("The C Programming Language");
        bookDO.addAuthor("Brian W.Kernighan");
        bookDO.addAuthor("Dennis M.Ritchie");
        bookDO.setIsbn("978-7-111-12806-9");
        bookDO.setPublishDate(1380000212);

        return bookDO;
    }
}
