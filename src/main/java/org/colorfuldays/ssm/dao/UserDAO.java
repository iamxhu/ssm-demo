package org.colorfuldays.ssm.dao;

import org.colorfuldays.ssm.domain.UserDO;

/**
 * Created by IntelliJ IDEA.
 * User: huxing(xing.hu@360hqb.com)
 * Date: 12-5-18
 * Time: 下午5:49
 */
public interface UserDAO {

    public UserDO getUserById(long id);

    public int updateUserDO(UserDO userDO);
}
