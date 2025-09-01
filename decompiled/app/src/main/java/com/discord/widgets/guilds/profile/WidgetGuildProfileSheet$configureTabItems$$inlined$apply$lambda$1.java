package com.discord.widgets.guilds.profile;

import android.content.Context;
import android.view.View;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits;
import com.discord.widgets.servers.guildboost.WidgetGuildBoost;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetGuildProfileSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroid/view/View;", "view", "", "invoke", "(Landroid/view/View;)V", "com/discord/widgets/guilds/profile/WidgetGuildProfileSheet$configureTabItems$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetGuildProfileSheet$configureTabItems$$inlined$apply$lambda$1 extends Lambda implements Function1<View, Unit> {
    public final /* synthetic */ long $guildId$inlined;
    public final /* synthetic */ int $iconColor$inlined;
    public final /* synthetic */ int $premiumSubscriptionCount$inlined;
    public final /* synthetic */ WidgetGuildProfileSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildProfileSheet$configureTabItems$$inlined$apply$lambda$1(WidgetGuildProfileSheet widgetGuildProfileSheet, int i, int i2, long j) {
        super(1);
        this.this$0 = widgetGuildProfileSheet;
        this.$premiumSubscriptionCount$inlined = i;
        this.$iconColor$inlined = i2;
        this.$guildId$inlined = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        AnalyticsTracker.guildBoostPromotionOpened$default(AnalyticsTracker.INSTANCE, this.$guildId$inlined, new Traits.Location(null, Traits.Location.Section.GUILD_POPOUT, Traits.Location.Obj.BOOST_GEM_ICON, null, null, 25, null), null, 4, null);
        WidgetGuildBoost.Companion companion = WidgetGuildBoost.INSTANCE;
        Context context = view.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "view.context");
        companion.create(context, this.$guildId$inlined);
    }
}
