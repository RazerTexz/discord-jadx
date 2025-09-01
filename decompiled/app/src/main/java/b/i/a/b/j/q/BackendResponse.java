package b.i.a.b.j.q;

import com.google.auto.value.AutoValue;

/* compiled from: BackendResponse.java */
@AutoValue
/* renamed from: b.i.a.b.j.q.g, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class BackendResponse {

    /* compiled from: BackendResponse.java */
    /* renamed from: b.i.a.b.j.q.g$a */
    public enum a {
        OK,
        TRANSIENT_ERROR,
        FATAL_ERROR
    }

    public static BackendResponse a() {
        return new AutoValue_BackendResponse(a.FATAL_ERROR, -1L);
    }

    public abstract long b();

    public abstract a c();
}
