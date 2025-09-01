package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionGroupListing;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionTierFreeTrial;
import java.util.List;
import kotlin.Metadata;
import kotlin.Tuples2;
import rx.functions.Func2;

/* compiled from: StoreGuildRoleSubscriptions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\t\u001aN\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002 \u0004*&\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002\u0018\u00010\u00060\u00062\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionGroupListing;", "guildRoleSubscriptionGroupListing", "", "Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionTierFreeTrial;", "kotlin.jvm.PlatformType", "guildRoleSubscriptionFreeTrials", "Lkotlin/Pair;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionGroupListing;Ljava/util/List;)Lkotlin/Pair;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.stores.StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroup$observable$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreGuildRoleSubscriptions2<T1, T2, R> implements Func2<GuildRoleSubscriptionGroupListing, List<? extends GuildRoleSubscriptionTierFreeTrial>, Tuples2<? extends GuildRoleSubscriptionGroupListing, ? extends List<? extends GuildRoleSubscriptionTierFreeTrial>>> {
    public static final StoreGuildRoleSubscriptions2 INSTANCE = new StoreGuildRoleSubscriptions2();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ Tuples2<? extends GuildRoleSubscriptionGroupListing, ? extends List<? extends GuildRoleSubscriptionTierFreeTrial>> call(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing, List<? extends GuildRoleSubscriptionTierFreeTrial> list) {
        return call2(guildRoleSubscriptionGroupListing, (List<GuildRoleSubscriptionTierFreeTrial>) list);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Tuples2<GuildRoleSubscriptionGroupListing, List<GuildRoleSubscriptionTierFreeTrial>> call2(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing, List<GuildRoleSubscriptionTierFreeTrial> list) {
        return new Tuples2<>(guildRoleSubscriptionGroupListing, list);
    }
}
