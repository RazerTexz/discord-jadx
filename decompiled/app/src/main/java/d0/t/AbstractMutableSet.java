package d0.t;

import d0.z.d.g0.KMarkers5;
import java.util.AbstractSet;
import java.util.Set;

/* compiled from: AbstractMutableSet.kt */
/* renamed from: d0.t.f, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class AbstractMutableSet<E> extends AbstractSet<E> implements Set<E>, KMarkers5 {
    public abstract int getSize();

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return getSize();
    }
}
