package com.discord.widgets.user.account;

import android.content.Context;
import android.view.View;
import com.discord.widgets.user.phone.WidgetUserPhoneManage;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: WidgetUserAccountVerify.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroid/view/View;", "v", "", "onClick", "(Landroid/view/View;)V", "com/discord/widgets/user/account/WidgetUserAccountVerify$$special$$inlined$apply$lambda$2", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.user.account.WidgetUserAccountVerify$onViewBound$$inlined$with$lambda$2, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetUserAccountVerify3 implements View.OnClickListener {
    public final /* synthetic */ WidgetUserAccountVerify this$0;

    public WidgetUserAccountVerify3(WidgetUserAccountVerify widgetUserAccountVerify) {
        this.this$0 = widgetUserAccountVerify;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Intrinsics3.checkNotNullParameter(view, "v");
        WidgetUserPhoneManage.Companion companion = WidgetUserPhoneManage.INSTANCE;
        Context context = view.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "v.context");
        companion.launch(context, this.this$0.getMode(), WidgetUserPhoneManage.Companion.Source.USER_ACTION_REQUIRED);
    }
}
