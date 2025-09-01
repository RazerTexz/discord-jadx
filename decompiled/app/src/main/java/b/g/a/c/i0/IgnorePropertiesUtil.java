package b.g.a.c.i0;

import java.io.Serializable;
import java.util.Collections;
import java.util.Set;

/* compiled from: IgnorePropertiesUtil.java */
/* renamed from: b.g.a.c.i0.g, reason: use source file name */
/* loaded from: classes3.dex */
public final class IgnorePropertiesUtil implements Serializable {
    private static final long serialVersionUID = 1;
    private final Set<String> _toIgnore;
    private final Set<String> _toInclude;

    public IgnorePropertiesUtil(Set<String> set, Set<String> set2) {
        this._toIgnore = set == null ? Collections.emptySet() : set;
        this._toInclude = set2;
    }

    public boolean a(Object obj) {
        Set<String> set = this._toInclude;
        return !(set == null || set.contains(obj)) || this._toIgnore.contains(obj);
    }
}
