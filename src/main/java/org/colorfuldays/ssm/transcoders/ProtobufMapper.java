package org.colorfuldays.ssm.transcoders;

/**
 * Created by IntelliJ IDEA.
 * User: huxing(huxing1985@gmail.com)
 * Date: 12-5-22
 * Time: 下午4:29
 */
public interface ProtobufMapper<T,P> {
    public T encode();
}
