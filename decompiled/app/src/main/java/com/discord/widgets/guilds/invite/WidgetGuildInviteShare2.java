package com.discord.widgets.guilds.invite;

import androidx.core.app.NotificationCompat;
import com.discord.models.experiments.domain.Experiment;
import d0.Tuples;
import java.util.List;
import kotlin.Metadata;
import kotlin.Tuples2;
import rx.functions.Func2;

/* compiled from: WidgetGuildInviteShare.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\t\u001aN\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002 \u0004*&\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002\u0018\u00010\u00060\u00062\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/discord/models/experiments/domain/Experiment;", "exp", "", "Lcom/discord/widgets/guilds/invite/InviteSuggestion;", "kotlin.jvm.PlatformType", "inviteService", "Lkotlin/Pair;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/experiments/domain/Experiment;Ljava/util/List;)Lkotlin/Pair;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShare$Companion$launch$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGuildInviteShare2<T1, T2, R> implements Func2<Experiment, List<? extends InviteSuggestion>, Tuples2<? extends Experiment, ? extends List<? extends InviteSuggestion>>> {
    public static final WidgetGuildInviteShare2 INSTANCE = new WidgetGuildInviteShare2();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ Tuples2<? extends Experiment, ? extends List<? extends InviteSuggestion>> call(Experiment experiment, List<? extends InviteSuggestion> list) {
        return call2(experiment, list);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Tuples2<Experiment, List<InviteSuggestion>> call2(Experiment experiment, List<? extends InviteSuggestion> list) {
        return Tuples.to(experiment, list);
    }
}
