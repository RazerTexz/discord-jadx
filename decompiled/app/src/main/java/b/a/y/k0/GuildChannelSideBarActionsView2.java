package b.a.y.k0;

import android.view.View;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* compiled from: GuildChannelSideBarActionsView.kt */
/* renamed from: b.a.y.k0.a, reason: use source file name */
/* loaded from: classes2.dex */
public final class GuildChannelSideBarActionsView2 implements View.OnClickListener {
    public final /* synthetic */ Function1 j;

    public GuildChannelSideBarActionsView2(Function1 function1) {
        this.j = function1;
    }

    @Override // android.view.View.OnClickListener
    public final /* synthetic */ void onClick(View view) {
        Intrinsics3.checkNotNullExpressionValue(this.j.invoke(view), "invoke(...)");
    }
}
