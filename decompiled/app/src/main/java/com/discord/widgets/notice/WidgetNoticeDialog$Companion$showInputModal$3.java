package com.discord.widgets.notice;

import android.view.View;
import com.discord.R;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetNoticeDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "view", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetNoticeDialog$Companion$showInputModal$3 extends Lambda implements Function1<View, Unit> {
    public final /* synthetic */ CharSequence $hintText;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetNoticeDialog$Companion$showInputModal$3(CharSequence charSequence) {
        super(1);
        this.$hintText = charSequence;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        View viewFindViewById = view.findViewById(R.id.view_input);
        Intrinsics3.checkNotNullExpressionValue(viewFindViewById, "view.findViewById<TextIn…tLayout>(R.id.view_input)");
        ((TextInputLayout) viewFindViewById).setHint(this.$hintText);
    }
}
