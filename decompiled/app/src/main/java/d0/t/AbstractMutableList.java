package d0.t;

import d0.z.d.g0.KMarkers3;
import java.util.AbstractList;
import java.util.List;

/* compiled from: AbstractMutableList.kt */
/* renamed from: d0.t.e, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class AbstractMutableList<E> extends AbstractList<E> implements List<E>, KMarkers3 {
    public abstract int getSize();

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ E remove(int i) {
        return removeAt(i);
    }

    public abstract E removeAt(int i);

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return getSize();
    }
}
