package b.m.a;

import d0.t.Collections2;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* compiled from: DefaultParam.kt */
/* renamed from: b.m.a.c, reason: use source file name */
/* loaded from: classes3.dex */
public final class DefaultParam {

    /* renamed from: b, reason: collision with root package name */
    public static final long f1903b;
    public static final long c;
    public static final long d;
    public static final DefaultParam e = new DefaultParam();
    public static final List<String> a = Collections2.listOf((Object[]) new String[]{"2.us.pool.ntp.org", "1.us.pool.ntp.org", "0.us.pool.ntp.org"});

    static {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        f1903b = timeUnit.toMillis(1L);
        c = timeUnit.toMillis(1L);
        d = TimeUnit.SECONDS.toMillis(6L);
    }
}
