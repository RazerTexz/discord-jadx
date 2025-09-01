package b.i.c.l;

import b.i.c.t.Provider2;
import java.util.Set;

/* compiled from: ComponentContainer.java */
/* renamed from: b.i.c.l.e, reason: use source file name */
/* loaded from: classes3.dex */
public interface ComponentContainer {
    <T> T a(Class<T> cls);

    <T> Provider2<T> b(Class<T> cls);

    <T> Provider2<Set<T>> c(Class<T> cls);

    <T> Set<T> d(Class<T> cls);
}
