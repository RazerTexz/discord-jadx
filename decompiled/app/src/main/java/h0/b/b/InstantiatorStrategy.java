package h0.b.b;

import h0.b.a.ObjectInstantiator;

/* compiled from: InstantiatorStrategy.java */
/* renamed from: h0.b.b.a, reason: use source file name */
/* loaded from: classes3.dex */
public interface InstantiatorStrategy {
    <T> ObjectInstantiator<T> newInstantiatorOf(Class<T> cls);
}
