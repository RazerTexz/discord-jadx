package com.discord.widgets.hubs;

import android.content.Context;
import android.view.View;
import b.a.d.AppScreen2;
import kotlin.Metadata;

/* compiled from: WidgetHubDomains.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "com/discord/widgets/hubs/WidgetHubDomains$onViewBound$2$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.hubs.WidgetHubDomains$onViewBound$$inlined$apply$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetHubDomains6 implements View.OnClickListener {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ WidgetHubDomains this$0;

    public WidgetHubDomains6(Context context, WidgetHubDomains widgetHubDomains) {
        this.$context = context;
        this.this$0 = widgetHubDomains;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        AppScreen2.g(AppScreen2.g, this.this$0.getParentFragmentManager(), this.$context, WidgetHubWaitlist.class, 0, true, null, new WidgetHubWaitlistViewModel2(this.this$0.getArgs().getEmail()), 40);
    }
}
