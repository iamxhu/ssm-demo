package org.colorfuldays.ssm.transcoders;

import com.google.code.ssm.providers.CacheTranscoder;
import com.google.code.ssm.providers.CachedObject;
import com.google.code.ssm.providers.CachedObjectImpl;
import com.google.protobuf.InvalidProtocolBufferException;
import org.colorfuldays.ssm.domain.Session;
import org.colorfuldays.ssm.domain.protobuf.Ssm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;

/**
 * Created by IntelliJ IDEA.
 * User: huxing(xing.hu@360hqb.com)
 * Date: 12-5-28
 * Time: 上午11:44
 */
public class SessionPBTranscoder implements CacheTranscoder<Session> {
    private static final Logger LOG = LoggerFactory.getLogger(SessionPBTranscoder.class);
    @Override
    public Session decode(CachedObject data) {
        try {
            Ssm.Session session = Ssm.Session.parseFrom(data.getData());
            return new Session(session);
        } catch (InvalidProtocolBufferException e) {
            LOG.error("parse session from protobuf error", e);
        }
        return null;
    }

    @Override
    public CachedObject encode(Session session) {
        Ssm.Session.Builder builder = Ssm.Session.newBuilder();
        Iterator<String> iterator = session.getAttributeKeySet().iterator();
        int index = 0;
        while (iterator.hasNext()) {
            Ssm.MapEntity.Builder entityBuilder = Ssm.MapEntity.newBuilder();
            entityBuilder.setKey(iterator.next()).setValue(session.getAttribute(iterator.next()));
            builder.setAttributes(index, entityBuilder.build());
        }

        return new CachedObjectImpl(PROTOBUF_SERIALIZED,builder.build().toByteArray());
    }

    private static final int PROTOBUF_SERIALIZED = 9;
}
