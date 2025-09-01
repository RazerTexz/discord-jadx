package com.discord.widgets.user.usersheet;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import b.a.d.AppToast;
import com.discord.widgets.user.usersheet.WidgetUserSheetViewModel;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: WidgetUserSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "com/discord/widgets/user/usersheet/WidgetUserSheet$configureDeveloperSection$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetUserSheet$configureDeveloperSection$$inlined$apply$lambda$1 implements View.OnClickListener {
    public final /* synthetic */ TextView $this_apply;
    public final /* synthetic */ WidgetUserSheetViewModel.ViewState.Loaded $viewState$inlined;
    public final /* synthetic */ WidgetUserSheet this$0;

    public WidgetUserSheet$configureDeveloperSection$$inlined$apply$lambda$1(TextView textView, WidgetUserSheet widgetUserSheet, WidgetUserSheetViewModel.ViewState.Loaded loaded) {
        this.$this_apply = textView;
        this.this$0 = widgetUserSheet;
        this.$viewState$inlined = loaded;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context = this.$this_apply.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        AppToast.c(context, String.valueOf(this.$viewState$inlined.getUser().getId()), 0, 4);
        this.this$0.dismiss();
    }
}
