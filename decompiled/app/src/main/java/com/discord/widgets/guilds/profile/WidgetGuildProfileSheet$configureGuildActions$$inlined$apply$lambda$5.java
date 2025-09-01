package com.discord.widgets.guilds.profile;

import androidx.core.app.NotificationCompat;
import com.discord.app.AppActivity;
import com.discord.widgets.guilds.profile.WidgetGuildProfileSheetViewModel;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import rx.functions.Action1;

/* compiled from: WidgetGuildProfileSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"", "kotlin.jvm.PlatformType", "checked", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Boolean;)V", "com/discord/widgets/guilds/profile/WidgetGuildProfileSheet$configureGuildActions$8$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetGuildProfileSheet$configureGuildActions$$inlined$apply$lambda$5<T> implements Action1<Boolean> {
    public final /* synthetic */ WidgetGuildProfileSheetViewModel.Actions $actions$inlined;
    public final /* synthetic */ long $guildId$inlined;
    public final /* synthetic */ WidgetGuildProfileSheet this$0;

    public WidgetGuildProfileSheet$configureGuildActions$$inlined$apply$lambda$5(WidgetGuildProfileSheet widgetGuildProfileSheet, WidgetGuildProfileSheetViewModel.Actions actions, long j) {
        this.this$0 = widgetGuildProfileSheet;
        this.$actions$inlined = actions;
        this.$guildId$inlined = j;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Boolean bool) {
        call2(bool);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Boolean bool) {
        WidgetGuildProfileSheetViewModel widgetGuildProfileSheetViewModelAccess$getViewModel$p = WidgetGuildProfileSheet.access$getViewModel$p(this.this$0);
        AppActivity appActivity = this.this$0.getAppActivity();
        long j = this.$guildId$inlined;
        Intrinsics3.checkNotNullExpressionValue(bool, "checked");
        widgetGuildProfileSheetViewModelAccess$getViewModel$p.setAllowDM(appActivity, j, bool.booleanValue());
    }
}
