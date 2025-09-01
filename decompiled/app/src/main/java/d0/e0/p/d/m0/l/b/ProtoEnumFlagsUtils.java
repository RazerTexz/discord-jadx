package d0.e0.p.d.m0.l.b;

import d0.e0.p.d.m0.c.CallableMemberDescriptor;
import d0.e0.p.d.m0.c.DescriptorVisibilities;
import d0.e0.p.d.m0.c.DescriptorVisibility2;
import d0.z.d.Intrinsics3;

/* compiled from: ProtoEnumFlagsUtils.kt */
/* renamed from: d0.e0.p.d.m0.l.b.a0, reason: use source file name */
/* loaded from: classes3.dex */
public final class ProtoEnumFlagsUtils {

    /* compiled from: ProtoEnumFlagsUtils.kt */
    /* renamed from: d0.e0.p.d.m0.l.b.a0$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f3482b;

        static {
            d0.e0.p.d.m0.f.j.values();
            a = new int[]{1, 2, 3, 4};
            CallableMemberDescriptor.a.values();
            d0.e0.p.d.m0.f.x.values();
            f3482b = new int[]{1, 2, 4, 5, 3, 6};
        }
    }

    public static final DescriptorVisibility2 descriptorVisibility(ProtoEnumFlags protoEnumFlags, d0.e0.p.d.m0.f.x xVar) {
        Intrinsics3.checkNotNullParameter(protoEnumFlags, "<this>");
        switch (xVar == null ? -1 : a.f3482b[xVar.ordinal()]) {
            case 1:
                DescriptorVisibility2 descriptorVisibility2 = DescriptorVisibilities.d;
                Intrinsics3.checkNotNullExpressionValue(descriptorVisibility2, "INTERNAL");
                return descriptorVisibility2;
            case 2:
                DescriptorVisibility2 descriptorVisibility22 = DescriptorVisibilities.a;
                Intrinsics3.checkNotNullExpressionValue(descriptorVisibility22, "PRIVATE");
                return descriptorVisibility22;
            case 3:
                DescriptorVisibility2 descriptorVisibility23 = DescriptorVisibilities.f3300b;
                Intrinsics3.checkNotNullExpressionValue(descriptorVisibility23, "PRIVATE_TO_THIS");
                return descriptorVisibility23;
            case 4:
                DescriptorVisibility2 descriptorVisibility24 = DescriptorVisibilities.c;
                Intrinsics3.checkNotNullExpressionValue(descriptorVisibility24, "PROTECTED");
                return descriptorVisibility24;
            case 5:
                DescriptorVisibility2 descriptorVisibility25 = DescriptorVisibilities.e;
                Intrinsics3.checkNotNullExpressionValue(descriptorVisibility25, "PUBLIC");
                return descriptorVisibility25;
            case 6:
                DescriptorVisibility2 descriptorVisibility26 = DescriptorVisibilities.f;
                Intrinsics3.checkNotNullExpressionValue(descriptorVisibility26, "LOCAL");
                return descriptorVisibility26;
            default:
                DescriptorVisibility2 descriptorVisibility27 = DescriptorVisibilities.a;
                Intrinsics3.checkNotNullExpressionValue(descriptorVisibility27, "PRIVATE");
                return descriptorVisibility27;
        }
    }

    public static final CallableMemberDescriptor.a memberKind(ProtoEnumFlags protoEnumFlags, d0.e0.p.d.m0.f.j jVar) {
        CallableMemberDescriptor.a aVar = CallableMemberDescriptor.a.DECLARATION;
        Intrinsics3.checkNotNullParameter(protoEnumFlags, "<this>");
        int i = jVar == null ? -1 : a.a[jVar.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? aVar : CallableMemberDescriptor.a.SYNTHESIZED : CallableMemberDescriptor.a.DELEGATION : CallableMemberDescriptor.a.FAKE_OVERRIDE : aVar;
    }
}
