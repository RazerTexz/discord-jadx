package com.discord.widgets.user.search;

import android.view.View;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;

/* compiled from: WidgetGlobalSearchAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Landroid/view/View;", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$ItemDataPayload;", "<anonymous parameter 2>", "", "<anonymous parameter 3>", "", "invoke", "(Landroid/view/View;ILcom/discord/widgets/user/search/WidgetGlobalSearchModel$ItemDataPayload;Z)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.user.search.WidgetGlobalSearchAdapter$onSelectedListener$1, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetGlobalSearchAdapter6 extends Lambda implements Function4<View, Integer, WidgetGlobalSearchModel.ItemDataPayload, Boolean, Unit> {
    public static final WidgetGlobalSearchAdapter6 INSTANCE = new WidgetGlobalSearchAdapter6();

    public WidgetGlobalSearchAdapter6() {
        super(4);
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Unit invoke(View view, Integer num, WidgetGlobalSearchModel.ItemDataPayload itemDataPayload, Boolean bool) {
        invoke(view, num.intValue(), itemDataPayload, bool.booleanValue());
        return Unit.a;
    }

    public final void invoke(View view, int i, WidgetGlobalSearchModel.ItemDataPayload itemDataPayload, boolean z2) {
        Intrinsics3.checkNotNullParameter(view, "<anonymous parameter 0>");
        Intrinsics3.checkNotNullParameter(itemDataPayload, "<anonymous parameter 2>");
    }
}
