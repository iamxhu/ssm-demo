package org.colorfuldays.ssm.domain;

import org.colorfuldays.ssm.domain.protobuf.Ssm;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: huxing(huxing1985@gmail.com)
 * Date: 12-5-18
 * Time: 下午5:44
 */
public class UserDO implements Serializable{

    private static final long serialVersionUID = -9096141633317522945L;

    public UserDO(Ssm.User user) {
        this.name = user.getName();
        this.password = user.getPassword();
        this.id = user.getId();
    }

    public UserDO() {

    }

    private String name;
    private Long id;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserDO{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDO)) return false;

        UserDO userDO = (UserDO) o;

        if (id != null ? !id.equals(userDO.id) : userDO.id != null) return false;
        if (name != null ? !name.equals(userDO.name) : userDO.name != null) return false;
        if (password != null ? !password.equals(userDO.password) : userDO.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
