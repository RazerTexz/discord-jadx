package b.g.a.c.c0;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* compiled from: AnnotatedMethodMap.java */
/* renamed from: b.g.a.c.c0.l, reason: use source file name */
/* loaded from: classes3.dex */
public final class AnnotatedMethodMap implements Iterable<AnnotatedMethod> {
    public Map<MemberKey, AnnotatedMethod> j;

    public AnnotatedMethodMap() {
    }

    @Override // java.lang.Iterable
    public Iterator<AnnotatedMethod> iterator() {
        Map<MemberKey, AnnotatedMethod> map = this.j;
        return map == null ? Collections.emptyIterator() : map.values().iterator();
    }

    public AnnotatedMethodMap(Map<MemberKey, AnnotatedMethod> map) {
        this.j = map;
    }
}
