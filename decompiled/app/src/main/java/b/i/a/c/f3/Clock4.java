package b.i.a.c.f3;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;

/* compiled from: Clock.java */
/* renamed from: b.i.a.c.f3.g, reason: use source file name */
/* loaded from: classes3.dex */
public interface Clock4 {
    public static final Clock4 a = new SystemClock2();

    long a();

    HandlerWrapper b(Looper looper, @Nullable Handler.Callback callback);

    void c();

    long d();
}
