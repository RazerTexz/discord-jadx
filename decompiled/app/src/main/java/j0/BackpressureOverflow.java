package j0;

import rx.exceptions.MissingBackpressureException;

/* compiled from: BackpressureOverflow.java */
/* renamed from: j0.a, reason: use source file name */
/* loaded from: classes3.dex */
public final class BackpressureOverflow {
    public static final /* synthetic */ int a = 0;

    /* compiled from: BackpressureOverflow.java */
    /* renamed from: j0.a$a */
    public static final class a implements b {
        public static final a a = new a();

        @Override // j0.BackpressureOverflow.b
        public boolean a() throws MissingBackpressureException {
            throw new MissingBackpressureException("Overflowed buffer");
        }
    }

    /* compiled from: BackpressureOverflow.java */
    /* renamed from: j0.a$b */
    public interface b {
        boolean a() throws MissingBackpressureException;
    }
}
