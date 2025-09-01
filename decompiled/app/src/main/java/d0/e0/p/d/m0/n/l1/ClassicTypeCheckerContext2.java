package d0.e0.p.d.m0.n.l1;

import b.d.b.a.outline;
import d0.z.d.Reflection2;

/* compiled from: ClassicTypeCheckerContext.kt */
/* renamed from: d0.e0.p.d.m0.n.l1.b, reason: use source file name */
/* loaded from: classes3.dex */
public final class ClassicTypeCheckerContext2 {
    public static final String access$errorMessage(Object obj) {
        StringBuilder sbU = outline.U("ClassicTypeCheckerContext couldn't handle ");
        sbU.append(Reflection2.getOrCreateKotlinClass(obj.getClass()));
        sbU.append(' ');
        sbU.append(obj);
        return sbU.toString();
    }
}
