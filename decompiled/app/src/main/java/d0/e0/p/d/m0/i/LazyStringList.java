package d0.e0.p.d.m0.i;

import java.util.List;

/* compiled from: LazyStringList.java */
/* renamed from: d0.e0.p.d.m0.i.l, reason: use source file name */
/* loaded from: classes3.dex */
public interface LazyStringList extends ProtocolStringList {
    void add(ByteString3 byteString3);

    ByteString3 getByteString(int i);

    List<?> getUnderlyingElements();

    LazyStringList getUnmodifiableView();
}
