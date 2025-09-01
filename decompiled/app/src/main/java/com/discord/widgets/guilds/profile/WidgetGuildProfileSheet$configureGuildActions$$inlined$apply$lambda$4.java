package com.discord.widgets.guilds.profile;

import android.content.Context;
import android.view.View;
import com.discord.models.experiments.domain.Experiment;
import com.discord.stores.StoreStream;
import com.discord.widgets.guilds.profile.WidgetChangeGuildIdentity;
import com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetGuildProfileSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroid/view/View;", "it", "", "invoke", "(Landroid/view/View;)V", "com/discord/widgets/guilds/profile/WidgetGuildProfileSheet$configureGuildActions$5$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetGuildProfileSheet$configureGuildActions$$inlined$apply$lambda$4 extends Lambda implements Function1<View, Unit> {
    public final /* synthetic */ long $guildId$inlined;
    public final /* synthetic */ WidgetGuildProfileSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildProfileSheet$configureGuildActions$$inlined$apply$lambda$4(WidgetGuildProfileSheet widgetGuildProfileSheet, long j) {
        super(1);
        this.this$0 = widgetGuildProfileSheet;
        this.$guildId$inlined = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "it");
        Experiment userExperiment = StoreStream.INSTANCE.getExperiments().getUserExperiment("2021-10_premium_guild_member_profiles", true);
        if (userExperiment == null || userExperiment.getBucket() != 1) {
            WidgetChangeGuildIdentity.Companion companion = WidgetChangeGuildIdentity.INSTANCE;
            long j = this.$guildId$inlined;
            Context context = view.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "it.context");
            companion.launch(j, "Guild Bottom Sheet", context);
            return;
        }
        WidgetEditUserOrGuildMemberProfile.Companion companion2 = WidgetEditUserOrGuildMemberProfile.INSTANCE;
        Long lValueOf = Long.valueOf(this.$guildId$inlined);
        Context context2 = view.getContext();
        Intrinsics3.checkNotNullExpressionValue(context2, "it.context");
        WidgetEditUserOrGuildMemberProfile.Companion.launch$default(companion2, context2, null, lValueOf, 2, null);
    }
}
