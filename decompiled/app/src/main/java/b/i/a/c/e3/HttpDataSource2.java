package b.i.a.c.e3;

import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: HttpDataSource.java */
/* renamed from: b.i.a.c.e3.u, reason: use source file name */
/* loaded from: classes3.dex */
public final class HttpDataSource2 {
    public final Map<String, String> a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public Map<String, String> f952b;

    public synchronized Map<String, String> a() {
        if (this.f952b == null) {
            this.f952b = Collections.unmodifiableMap(new HashMap(this.a));
        }
        return this.f952b;
    }
}
