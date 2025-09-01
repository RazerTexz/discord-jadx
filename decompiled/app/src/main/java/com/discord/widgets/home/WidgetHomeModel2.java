package com.discord.widgets.home;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreChannelsSelected;
import d0.Tuples;
import kotlin.Metadata;
import kotlin.Tuples2;
import rx.functions.Func2;

/* compiled from: WidgetHomeModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\t\u001aV\u0012\u0016\u0012\u0014 \u0002*\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00010\u0000j\u0002`\u0001\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00040\u0004 \u0002**\u0012\u0016\u0012\u0014 \u0002*\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00010\u0000j\u0002`\u0001\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00060\u00062\u0018\u0010\u0003\u001a\u0014 \u0002*\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00010\u0000j\u0002`\u00012\u000e\u0010\u0005\u001a\n \u0002*\u0004\u0018\u00010\u00040\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "Lcom/discord/primitives/GuildId;", "kotlin.jvm.PlatformType", "selectedGuildId", "Lcom/discord/stores/StoreChannelsSelected$ResolvedSelectedChannel;", "selectedChannel", "Lkotlin/Pair;", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Long;Lcom/discord/stores/StoreChannelsSelected$ResolvedSelectedChannel;)Lkotlin/Pair;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.home.WidgetHomeModel$Companion$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetHomeModel2<T1, T2, R> implements Func2<Long, StoreChannelsSelected.ResolvedSelectedChannel, Tuples2<? extends Long, ? extends StoreChannelsSelected.ResolvedSelectedChannel>> {
    public static final WidgetHomeModel2 INSTANCE = new WidgetHomeModel2();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ Tuples2<? extends Long, ? extends StoreChannelsSelected.ResolvedSelectedChannel> call(Long l, StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel) {
        return call2(l, resolvedSelectedChannel);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Tuples2<Long, StoreChannelsSelected.ResolvedSelectedChannel> call2(Long l, StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel) {
        return Tuples.to(l, resolvedSelectedChannel);
    }
}
