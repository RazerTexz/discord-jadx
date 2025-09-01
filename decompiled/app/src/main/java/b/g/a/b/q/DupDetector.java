package b.g.a.b.q;

import java.util.HashSet;

/* compiled from: DupDetector.java */
/* renamed from: b.g.a.b.q.a, reason: use source file name */
/* loaded from: classes3.dex */
public class DupDetector {
    public final Object a;

    /* renamed from: b, reason: collision with root package name */
    public String f670b;
    public String c;
    public HashSet<String> d;

    public DupDetector(Object obj) {
        this.a = obj;
    }

    public DupDetector a() {
        return new DupDetector(this.a);
    }
}
