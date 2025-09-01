package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.view.View;
import com.discord.widgets.settings.account.WidgetSettingsAccount;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: WidgetChatListAdapterItemGift.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGift$configureResolvedUI$visibleButton$2$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemGift6 implements View.OnClickListener {
    public static final WidgetChatListAdapterItemGift6 INSTANCE = new WidgetChatListAdapterItemGift6();

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetSettingsAccount.Companion companion = WidgetSettingsAccount.INSTANCE;
        Intrinsics3.checkNotNullExpressionValue(view, "it");
        Context context = view.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "it.context");
        WidgetSettingsAccount.Companion.launch$default(companion, context, false, null, 6, null);
    }
}
