package b.i.c.l;

import b.i.c.t.Provider2;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: ComponentRuntime.java */
/* renamed from: b.i.c.l.i, reason: use source file name */
/* loaded from: classes3.dex */
public final /* synthetic */ class ComponentRuntime2 implements Provider2 {
    public final Set a;

    public ComponentRuntime2(Set set) {
        this.a = set;
    }

    @Override // b.i.c.t.Provider2
    public Object get() {
        Set set = this.a;
        int i = ComponentRuntime4.a;
        HashSet hashSet = new HashSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            hashSet.add(((Lazy2) it.next()).get());
        }
        return Collections.unmodifiableSet(hashSet);
    }
}
