package d0.e0.p.d.m0.j;

import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: DescriptorRenderer.kt */
/* renamed from: d0.e0.p.d.m0.j.p, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class DescriptorRenderer9 {
    public static final DescriptorRenderer9 j;
    public static final DescriptorRenderer9 k;
    public static final /* synthetic */ DescriptorRenderer9[] l;

    /* compiled from: DescriptorRenderer.kt */
    /* renamed from: d0.e0.p.d.m0.j.p$a */
    public static final class a extends DescriptorRenderer9 {
        public a(String str, int i) {
            super(str, i, null);
        }

        @Override // d0.e0.p.d.m0.j.DescriptorRenderer9
        public String escape(String str) {
            Intrinsics3.checkNotNullParameter(str, "string");
            return StringsJVM.replace$default(StringsJVM.replace$default(str, "<", "&lt;", false, 4, (Object) null), ">", "&gt;", false, 4, (Object) null);
        }
    }

    /* compiled from: DescriptorRenderer.kt */
    /* renamed from: d0.e0.p.d.m0.j.p$b */
    public static final class b extends DescriptorRenderer9 {
        public b(String str, int i) {
            super(str, i, null);
        }

        @Override // d0.e0.p.d.m0.j.DescriptorRenderer9
        public String escape(String str) {
            Intrinsics3.checkNotNullParameter(str, "string");
            return str;
        }
    }

    static {
        b bVar = new b("PLAIN", 0);
        j = bVar;
        a aVar = new a("HTML", 1);
        k = aVar;
        l = new DescriptorRenderer9[]{bVar, aVar};
    }

    public DescriptorRenderer9(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
    }

    public static DescriptorRenderer9 valueOf(String str) {
        Intrinsics3.checkNotNullParameter(str, "value");
        return (DescriptorRenderer9) Enum.valueOf(DescriptorRenderer9.class, str);
    }

    public static DescriptorRenderer9[] values() {
        DescriptorRenderer9[] descriptorRenderer9Arr = l;
        DescriptorRenderer9[] descriptorRenderer9Arr2 = new DescriptorRenderer9[descriptorRenderer9Arr.length];
        System.arraycopy(descriptorRenderer9Arr, 0, descriptorRenderer9Arr2, 0, descriptorRenderer9Arr.length);
        return descriptorRenderer9Arr2;
    }

    public abstract String escape(String str);
}
