package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionGroupListing;
import j0.k.Func1;
import kotlin.Metadata;
import kotlin.Tuples2;

/* compiled from: StoreGuildRoleSubscriptions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0004\u0010\u0007\u001a*\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0003 \u0004*\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionGroupListing;", "it", "Lkotlin/Pair;", "", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionGroupListing;)Lkotlin/Pair;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.stores.StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroup$observable$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreGuildRoleSubscriptions3<T, R> implements Func1<GuildRoleSubscriptionGroupListing, Tuples2> {
    public static final StoreGuildRoleSubscriptions3 INSTANCE = new StoreGuildRoleSubscriptions3();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Tuples2 call(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing) {
        return call2(guildRoleSubscriptionGroupListing);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Tuples2 call2(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing) {
        return new Tuples2(guildRoleSubscriptionGroupListing, null);
    }
}
