package d0.e0.p.d.m0.f.z;

import d0.e0.p.d.m0.f.v;
import d0.e0.p.d.m0.f.w;
import d0.t.Collections2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: VersionRequirement.kt */
/* renamed from: d0.e0.p.d.m0.f.z.i, reason: use source file name */
/* loaded from: classes3.dex */
public final class VersionRequirement2 {
    public static final a a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public static final VersionRequirement2 f3421b = new VersionRequirement2(Collections2.emptyList());
    public final List<v> c;

    /* compiled from: VersionRequirement.kt */
    /* renamed from: d0.e0.p.d.m0.f.z.i$a */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final VersionRequirement2 create(w wVar) {
            Intrinsics3.checkNotNullParameter(wVar, "table");
            if (wVar.getRequirementCount() == 0) {
                return getEMPTY();
            }
            List<v> requirementList = wVar.getRequirementList();
            Intrinsics3.checkNotNullExpressionValue(requirementList, "table.requirementList");
            return new VersionRequirement2(requirementList, null);
        }

        public final VersionRequirement2 getEMPTY() {
            return VersionRequirement2.access$getEMPTY$cp();
        }
    }

    public VersionRequirement2(List<v> list) {
        this.c = list;
    }

    public static final /* synthetic */ VersionRequirement2 access$getEMPTY$cp() {
        return f3421b;
    }

    public final v get(int i) {
        return (v) _Collections.getOrNull(this.c, i);
    }

    public VersionRequirement2(List list, DefaultConstructorMarker defaultConstructorMarker) {
        this.c = list;
    }
}
