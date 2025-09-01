package d0.e0.p.d.m0.i;

import java.io.IOException;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;

/* compiled from: MessageLite.java */
/* renamed from: d0.e0.p.d.m0.i.n, reason: use source file name */
/* loaded from: classes3.dex */
public interface MessageLite extends MessageLiteOrBuilder {

    /* compiled from: MessageLite.java */
    /* renamed from: d0.e0.p.d.m0.i.n$a */
    public interface a extends Cloneable, MessageLiteOrBuilder {
        MessageLite build();

        a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException;
    }

    int getSerializedSize();

    a newBuilderForType();

    a toBuilder();

    void writeTo(CodedOutputStream codedOutputStream) throws IOException;
}
