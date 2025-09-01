package b.f.b.b;

import com.facebook.cache.common.CacheKey;

/* compiled from: SettableCacheEvent.java */
/* renamed from: b.f.b.b.i, reason: use source file name */
/* loaded from: classes.dex */
public class SettableCacheEvent {
    public static final Object a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static SettableCacheEvent f468b;
    public static int c;
    public CacheKey d;
    public SettableCacheEvent e;

    public static SettableCacheEvent a() {
        synchronized (a) {
            SettableCacheEvent settableCacheEvent = f468b;
            if (settableCacheEvent == null) {
                return new SettableCacheEvent();
            }
            f468b = settableCacheEvent.e;
            settableCacheEvent.e = null;
            c--;
            return settableCacheEvent;
        }
    }

    public void b() {
        synchronized (a) {
            int i = c;
            if (i < 5) {
                c = i + 1;
                SettableCacheEvent settableCacheEvent = f468b;
                if (settableCacheEvent != null) {
                    this.e = settableCacheEvent;
                }
                f468b = this;
            }
        }
    }
}
