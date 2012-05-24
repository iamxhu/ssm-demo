package org.colorfuldays.ssm.dao;

import org.colorfuldays.ssm.domain.BookDO;

/**
 * Created by IntelliJ IDEA.
 * User: huxing(xing.hu@360hqb.com)
 * Date: 12-5-22
 * Time: 下午4:56
 */
public interface BookDAO {

    public BookDO getBookByName(String name);
}
