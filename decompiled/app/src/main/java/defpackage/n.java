package defpackage;

import android.view.View;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: kotlin-style lambda group */
/* loaded from: classes2.dex */
public final class n extends Lambda implements Function1<View, Unit> {
    public static final n j = new n(0);
    public static final n k = new n(1);
    public final /* synthetic */ int l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(int i) {
        super(1);
        this.l = i;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(View view) {
        int i = this.l;
        if (i == 0) {
            Intrinsics3.checkNotNullParameter(view, "it");
            return Unit.a;
        }
        if (i != 1) {
            throw null;
        }
        Intrinsics3.checkNotNullParameter(view, "it");
        return Unit.a;
    }
}
