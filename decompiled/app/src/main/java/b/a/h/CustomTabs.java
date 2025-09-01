package b.a.h;

import android.content.Context;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* compiled from: CustomTabs.kt */
/* renamed from: b.a.h.a, reason: use source file name */
/* loaded from: classes.dex */
public final class CustomTabs extends Lambda implements Function1<String, Boolean> {
    public final /* synthetic */ Context $context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomTabs(Context context) {
        super(1);
        this.$context = context;
    }

    @Override // kotlin.jvm.functions.Function1
    public Boolean invoke(String str) {
        Intrinsics3.checkNotNullParameter(str, "it");
        return Boolean.valueOf(!Intrinsics3.areEqual(r2, this.$context.getPackageName()));
    }
}
