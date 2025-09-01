package b.i.a.c.e3.b0;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* compiled from: ContentMetadataMutations.java */
/* renamed from: b.i.a.c.e3.b0.m, reason: use source file name */
/* loaded from: classes3.dex */
public class ContentMetadataMutations {
    public final Map<String, Object> a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final List<String> f935b = new ArrayList();

    public static ContentMetadataMutations a(ContentMetadataMutations contentMetadataMutations, long j) {
        Long lValueOf = Long.valueOf(j);
        Map<String, Object> map = contentMetadataMutations.a;
        Objects.requireNonNull(lValueOf);
        map.put("exo_len", lValueOf);
        contentMetadataMutations.f935b.remove("exo_len");
        return contentMetadataMutations;
    }
}
