package com.discord.utilities.view.extensions;

import android.view.View;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: ViewExtensions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.view.extensions.ViewExtensions$sam$android_view_View_OnClickListener$0, reason: use source file name */
/* loaded from: classes2.dex */
public final class ViewExtensions6 implements View.OnClickListener {
    private final /* synthetic */ Function1 function;

    public ViewExtensions6(Function1 function1) {
        this.function = function1;
    }

    @Override // android.view.View.OnClickListener
    public final /* synthetic */ void onClick(View view) {
        Intrinsics3.checkNotNullExpressionValue(this.function.invoke(view), "invoke(...)");
    }
}
