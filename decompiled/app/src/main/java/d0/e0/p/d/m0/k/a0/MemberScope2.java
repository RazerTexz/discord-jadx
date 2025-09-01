package d0.e0.p.d.m0.k.a0;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.t.Collections2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: MemberScope.kt */
/* renamed from: d0.e0.p.d.m0.k.a0.d, reason: use source file name */
/* loaded from: classes3.dex */
public final class MemberScope2 {
    public static final a a;

    /* renamed from: b, reason: collision with root package name */
    public static int f3453b;
    public static final int c;
    public static final int d;
    public static final int e;
    public static final int f;
    public static final int g;
    public static final int h;
    public static final int i;
    public static final int j;
    public static final int k;
    public static final int l;
    public static final MemberScope2 m;
    public static final MemberScope2 n;
    public static final MemberScope2 o;
    public static final MemberScope2 p;
    public static final MemberScope2 q;
    public static final List<a.C0403a> r;

    /* renamed from: s, reason: collision with root package name */
    public static final List<a.C0403a> f3454s;
    public final List<MemberScope> t;
    public final int u;

    /* compiled from: MemberScope.kt */
    /* renamed from: d0.e0.p.d.m0.k.a0.d$a */
    public static final class a {

        /* compiled from: MemberScope.kt */
        /* renamed from: d0.e0.p.d.m0.k.a0.d$a$a, reason: collision with other inner class name */
        public static final class C0403a {
            public final int a;

            /* renamed from: b, reason: collision with root package name */
            public final String f3455b;

            public C0403a(int i, String str) {
                Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
                this.a = i;
                this.f3455b = str;
            }

            public final int getMask() {
                return this.a;
            }

            public final String getName() {
                return this.f3455b;
            }
        }

        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public static final int access$nextMask(a aVar) {
            Objects.requireNonNull(aVar);
            int iAccess$getNextMaskValue$cp = MemberScope2.access$getNextMaskValue$cp();
            MemberScope2.access$setNextMaskValue$cp(MemberScope2.access$getNextMaskValue$cp() << 1);
            return iAccess$getNextMaskValue$cp;
        }

        public final int getALL_KINDS_MASK() {
            return MemberScope2.access$getALL_KINDS_MASK$cp();
        }

        public final int getCALLABLES_MASK() {
            return MemberScope2.access$getCALLABLES_MASK$cp();
        }

        public final int getCLASSIFIERS_MASK() {
            return MemberScope2.access$getCLASSIFIERS_MASK$cp();
        }

        public final int getFUNCTIONS_MASK() {
            return MemberScope2.access$getFUNCTIONS_MASK$cp();
        }

        public final int getNON_SINGLETON_CLASSIFIERS_MASK() {
            return MemberScope2.access$getNON_SINGLETON_CLASSIFIERS_MASK$cp();
        }

        public final int getPACKAGES_MASK() {
            return MemberScope2.access$getPACKAGES_MASK$cp();
        }

        public final int getSINGLETON_CLASSIFIERS_MASK() {
            return MemberScope2.access$getSINGLETON_CLASSIFIERS_MASK$cp();
        }

        public final int getTYPE_ALIASES_MASK() {
            return MemberScope2.access$getTYPE_ALIASES_MASK$cp();
        }

        public final int getVALUES_MASK() {
            return MemberScope2.access$getVALUES_MASK$cp();
        }

        public final int getVARIABLES_MASK() {
            return MemberScope2.access$getVARIABLES_MASK$cp();
        }
    }

    static {
        a.C0403a c0403a;
        a.C0403a c0403a2;
        a aVar = new a(null);
        a = aVar;
        f3453b = 1;
        c = a.access$nextMask(aVar);
        d = a.access$nextMask(aVar);
        e = a.access$nextMask(aVar);
        f = a.access$nextMask(aVar);
        g = a.access$nextMask(aVar);
        h = a.access$nextMask(aVar);
        i = a.access$nextMask(aVar) - 1;
        j = aVar.getNON_SINGLETON_CLASSIFIERS_MASK() | aVar.getSINGLETON_CLASSIFIERS_MASK() | aVar.getTYPE_ALIASES_MASK();
        k = aVar.getSINGLETON_CLASSIFIERS_MASK() | aVar.getFUNCTIONS_MASK() | aVar.getVARIABLES_MASK();
        l = aVar.getFUNCTIONS_MASK() | aVar.getVARIABLES_MASK();
        m = new MemberScope2(aVar.getALL_KINDS_MASK(), null, 2, null);
        n = new MemberScope2(aVar.getCALLABLES_MASK(), null, 2, null);
        new MemberScope2(aVar.getNON_SINGLETON_CLASSIFIERS_MASK(), null, 2, null);
        new MemberScope2(aVar.getSINGLETON_CLASSIFIERS_MASK(), null, 2, null);
        new MemberScope2(aVar.getTYPE_ALIASES_MASK(), null, 2, null);
        o = new MemberScope2(aVar.getCLASSIFIERS_MASK(), null, 2, null);
        new MemberScope2(aVar.getPACKAGES_MASK(), null, 2, null);
        p = new MemberScope2(aVar.getFUNCTIONS_MASK(), null, 2, null);
        q = new MemberScope2(aVar.getVARIABLES_MASK(), null, 2, null);
        new MemberScope2(aVar.getVALUES_MASK(), null, 2, null);
        Field[] fields = MemberScope2.class.getFields();
        Intrinsics3.checkNotNullExpressionValue(fields, "T::class.java.fields");
        ArrayList<Field> arrayList = new ArrayList();
        for (Field field : fields) {
            if (Modifier.isStatic(field.getModifiers())) {
                arrayList.add(field);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Field field2 : arrayList) {
            Object obj = field2.get(null);
            MemberScope2 memberScope2 = obj instanceof MemberScope2 ? (MemberScope2) obj : null;
            if (memberScope2 != null) {
                int kindMask = memberScope2.getKindMask();
                String name = field2.getName();
                Intrinsics3.checkNotNullExpressionValue(name, "field.name");
                c0403a2 = new a.C0403a(kindMask, name);
            } else {
                c0403a2 = null;
            }
            if (c0403a2 != null) {
                arrayList2.add(c0403a2);
            }
        }
        r = arrayList2;
        Field[] fields2 = MemberScope2.class.getFields();
        Intrinsics3.checkNotNullExpressionValue(fields2, "T::class.java.fields");
        ArrayList arrayList3 = new ArrayList();
        for (Field field3 : fields2) {
            if (Modifier.isStatic(field3.getModifiers())) {
                arrayList3.add(field3);
            }
        }
        ArrayList<Field> arrayList4 = new ArrayList();
        for (Object obj2 : arrayList3) {
            if (Intrinsics3.areEqual(((Field) obj2).getType(), Integer.TYPE)) {
                arrayList4.add(obj2);
            }
        }
        ArrayList arrayList5 = new ArrayList();
        for (Field field4 : arrayList4) {
            Object obj3 = field4.get(null);
            Objects.requireNonNull(obj3, "null cannot be cast to non-null type kotlin.Int");
            int iIntValue = ((Integer) obj3).intValue();
            if (iIntValue == ((-iIntValue) & iIntValue)) {
                String name2 = field4.getName();
                Intrinsics3.checkNotNullExpressionValue(name2, "field.name");
                c0403a = new a.C0403a(iIntValue, name2);
            } else {
                c0403a = null;
            }
            if (c0403a != null) {
                arrayList5.add(c0403a);
            }
        }
        f3454s = arrayList5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MemberScope2(int i2, List<? extends MemberScope> list) {
        Intrinsics3.checkNotNullParameter(list, "excludes");
        this.t = list;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            i2 &= ~((MemberScope) it.next()).getFullyExcludedDescriptorKinds();
        }
        this.u = i2;
    }

    public static final /* synthetic */ int access$getALL_KINDS_MASK$cp() {
        return i;
    }

    public static final /* synthetic */ int access$getCALLABLES_MASK$cp() {
        return l;
    }

    public static final /* synthetic */ int access$getCLASSIFIERS_MASK$cp() {
        return j;
    }

    public static final /* synthetic */ int access$getFUNCTIONS_MASK$cp() {
        return g;
    }

    public static final /* synthetic */ int access$getNON_SINGLETON_CLASSIFIERS_MASK$cp() {
        return c;
    }

    public static final /* synthetic */ int access$getNextMaskValue$cp() {
        return f3453b;
    }

    public static final /* synthetic */ int access$getPACKAGES_MASK$cp() {
        return f;
    }

    public static final /* synthetic */ int access$getSINGLETON_CLASSIFIERS_MASK$cp() {
        return d;
    }

    public static final /* synthetic */ int access$getTYPE_ALIASES_MASK$cp() {
        return e;
    }

    public static final /* synthetic */ int access$getVALUES_MASK$cp() {
        return k;
    }

    public static final /* synthetic */ int access$getVARIABLES_MASK$cp() {
        return h;
    }

    public static final /* synthetic */ void access$setNextMaskValue$cp(int i2) {
        f3453b = i2;
    }

    public final boolean acceptsKinds(int i2) {
        return (i2 & this.u) != 0;
    }

    public final List<MemberScope> getExcludes() {
        return this.t;
    }

    public final int getKindMask() {
        return this.u;
    }

    public final MemberScope2 restrictedToKindsOrNull(int i2) {
        int i3 = i2 & this.u;
        if (i3 == 0) {
            return null;
        }
        return new MemberScope2(i3, this.t);
    }

    public String toString() {
        Object next;
        Iterator<T> it = r.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((a.C0403a) next).getMask() == getKindMask()) {
                break;
            }
        }
        a.C0403a c0403a = (a.C0403a) next;
        String name = c0403a == null ? null : c0403a.getName();
        if (name == null) {
            List<a.C0403a> list = f3454s;
            ArrayList arrayList = new ArrayList();
            for (a.C0403a c0403a2 : list) {
                String name2 = acceptsKinds(c0403a2.getMask()) ? c0403a2.getName() : null;
                if (name2 != null) {
                    arrayList.add(name2);
                }
            }
            name = _Collections.joinToString$default(arrayList, " | ", null, null, 0, null, null, 62, null);
        }
        StringBuilder sbY = outline.Y("DescriptorKindFilter(", name, ", ");
        sbY.append(this.t);
        sbY.append(')');
        return sbY.toString();
    }

    public /* synthetic */ MemberScope2(int i2, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i2, (i3 & 2) != 0 ? Collections2.emptyList() : list);
    }
}
