package b.g.a.b.t;

import java.util.concurrent.ConcurrentHashMap;

/* compiled from: InternCache.java */
/* renamed from: b.g.a.b.t.f, reason: use source file name */
/* loaded from: classes3.dex */
public final class InternCache extends ConcurrentHashMap<String, String> {
    public static final InternCache j = new InternCache();
    private static final long serialVersionUID = 1;
    private final Object lock;

    public InternCache() {
        super(180, 0.8f, 4);
        this.lock = new Object();
    }

    public String a(String str) {
        String str2 = get(str);
        if (str2 != null) {
            return str2;
        }
        if (size() >= 180) {
            synchronized (this.lock) {
                if (size() >= 180) {
                    clear();
                }
            }
        }
        String strIntern = str.intern();
        put(strIntern, strIntern);
        return strIntern;
    }
}
