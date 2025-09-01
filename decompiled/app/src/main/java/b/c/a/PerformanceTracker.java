package b.c.a;

import androidx.collection.ArraySet;
import b.c.a.b0.MeanCalculator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: PerformanceTracker.java */
/* renamed from: b.c.a.s, reason: use source file name */
/* loaded from: classes.dex */
public class PerformanceTracker {
    public boolean a = false;

    /* renamed from: b, reason: collision with root package name */
    public final Set<a> f375b = new ArraySet();
    public final Map<String, MeanCalculator> c = new HashMap();

    /* compiled from: PerformanceTracker.java */
    /* renamed from: b.c.a.s$a */
    public interface a {
        void a(float f);
    }
}
