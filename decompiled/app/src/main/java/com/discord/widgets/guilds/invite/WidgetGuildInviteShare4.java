package com.discord.widgets.guilds.invite;

import android.content.Context;
import android.content.Intent;
import b.a.d.AppScreen2;
import com.discord.models.experiments.domain.Experiment;
import com.discord.utilities.analytics.AnalyticsTracker;
import d0.z.d.Lambda;
import java.util.List;
import kotlin.Metadata;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetGuildInviteShare.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\t\u001a\u00020\u00062R\u0010\u0005\u001aN\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002 \u0004*&\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lkotlin/Pair;", "Lcom/discord/models/experiments/domain/Experiment;", "", "Lcom/discord/widgets/guilds/invite/InviteSuggestion;", "kotlin.jvm.PlatformType", "<name for destructuring parameter 0>", "", "invoke", "(Lkotlin/Pair;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShare$Companion$launch$3, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGuildInviteShare4 extends Lambda implements Function1<Tuples2<? extends Experiment, ? extends List<? extends InviteSuggestion>>, Unit> {
    public final /* synthetic */ Intent $arguments;
    public final /* synthetic */ Context $context;
    public final /* synthetic */ String $source;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildInviteShare4(String str, Context context, Intent intent) {
        super(1);
        this.$source = str;
        this.$context = context;
        this.$arguments = intent;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Tuples2<? extends Experiment, ? extends List<? extends InviteSuggestion>> tuples2) {
        invoke2((Tuples2<Experiment, ? extends List<? extends InviteSuggestion>>) tuples2);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Tuples2<Experiment, ? extends List<? extends InviteSuggestion>> tuples2) {
        Experiment experimentComponent1 = tuples2.component1();
        List<? extends InviteSuggestion> listComponent2 = tuples2.component2();
        AnalyticsTracker.openModal$default("Instant Invite Modal", this.$source, null, 4, null);
        AppScreen2.d(this.$context, listComponent2.isEmpty() ? WidgetGuildInviteShareEmptySuggestions.class : (experimentComponent1 == null || experimentComponent1.getBucket() != 1) ? WidgetGuildInviteShare.class : WidgetGuildInviteShareCompact.class, this.$arguments);
    }
}
