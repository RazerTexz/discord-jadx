package d0.e0.p.d.m0.i;

import d0.e0.p.d.m0.i.AbstractMessageLite;
import d0.e0.p.d.m0.i.MessageLite;
import java.io.IOException;
import java.io.InputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

/* compiled from: AbstractParser.java */
/* renamed from: d0.e0.p.d.m0.i.b, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class AbstractParser<MessageType extends MessageLite> implements Parser2<MessageType> {
    static {
        ExtensionRegistryLite.getEmptyRegistry();
    }

    public final MessageType a(MessageType messagetype) throws InvalidProtocolBufferException {
        if (messagetype == null || messagetype.isInitialized()) {
            return messagetype;
        }
        throw (messagetype instanceof AbstractMessageLite ? new UninitializedMessageException((AbstractMessageLite) messagetype) : new UninitializedMessageException(messagetype)).asInvalidProtocolBufferException().setUnfinishedMessage(messagetype);
    }

    /* renamed from: parseDelimitedFrom, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m89parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    /* renamed from: parseFrom, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m90parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return parseFrom(inputStream, extensionRegistryLite);
    }

    public MessageType parsePartialDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        try {
            int i = inputStream.read();
            if (i == -1) {
                return null;
            }
            return (MessageType) parsePartialFrom(new AbstractMessageLite.a.C0400a(inputStream, CodedInputStream.readRawVarint32(i, inputStream)), extensionRegistryLite);
        } catch (IOException e) {
            throw new InvalidProtocolBufferException(e.getMessage());
        }
    }

    public MessageType parsePartialFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        CodedInputStream codedInputStreamNewInstance = CodedInputStream.newInstance(inputStream);
        MessageType partialFrom = parsePartialFrom(codedInputStreamNewInstance, extensionRegistryLite);
        try {
            codedInputStreamNewInstance.checkLastTagWas(0);
            return partialFrom;
        } catch (InvalidProtocolBufferException e) {
            throw e.setUnfinishedMessage(partialFrom);
        }
    }

    public MessageType parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        MessageType messagetype = (MessageType) parsePartialDelimitedFrom(inputStream, extensionRegistryLite);
        a(messagetype);
        return messagetype;
    }

    public MessageType parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        MessageType messagetype = (MessageType) parsePartialFrom(inputStream, extensionRegistryLite);
        a(messagetype);
        return messagetype;
    }
}
