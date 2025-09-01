package b.i.a.c.z2.i;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

/* compiled from: EventMessageEncoder.java */
/* renamed from: b.i.a.c.z2.i.b, reason: use source file name */
/* loaded from: classes3.dex */
public final class EventMessageEncoder {
    public final ByteArrayOutputStream a;

    /* renamed from: b, reason: collision with root package name */
    public final DataOutputStream f1322b;

    public EventMessageEncoder() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        this.a = byteArrayOutputStream;
        this.f1322b = new DataOutputStream(byteArrayOutputStream);
    }
}
