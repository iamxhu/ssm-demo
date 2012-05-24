package org.colorfuldays.ssm.transcoders;

import com.google.code.ssm.providers.CacheTranscoder;
import com.google.code.ssm.providers.CachedObject;
import com.google.code.ssm.providers.CachedObjectImpl;
import com.google.protobuf.InvalidProtocolBufferException;
import org.colorfuldays.ssm.domain.UserDO;
import org.colorfuldays.ssm.domain.protobuf.Ssm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by IntelliJ IDEA.
 * User: huxing(huxing1985@gmail.com)
 * Date: 12-5-22
 * Time: 上午9:32
 */
public class ProtobufTranscoder implements CacheTranscoder<UserDO> {
    private static final Logger LOG = LoggerFactory.getLogger(ProtobufTranscoder.class);

    private static final int PROTOBUF_SERIALIZED = 9;

    @Override
    public UserDO decode(CachedObject data) {
        try {
            Ssm.User user = Ssm.User.parseFrom(data.getData());
            return new UserDO(user);
        } catch (InvalidProtocolBufferException e) {
            LOG.error("pass error", e);
        }
        return null;
    }

    @Override
    public CachedObject encode(UserDO userDO) {
        Ssm.User.Builder userBuilder = Ssm.User.newBuilder().setId(userDO.getId())
                .setName(userDO.getName())
                .setPassword(userDO.getPassword());

        return new CachedObjectImpl(PROTOBUF_SERIALIZED,userBuilder.build().toByteArray());
    }
}
