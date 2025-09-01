package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionGroupListing;
import j0.k.Func1;
import java.util.List;
import kotlin.Metadata;
import kotlin.Tuples2;

/* compiled from: StoreGuildRoleSubscriptions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\u0010\b\u001aN\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0005 \u0002*&\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00040\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionGroupListing;", "kotlin.jvm.PlatformType", "it", "Lkotlin/Pair;", "", NotificationCompat.CATEGORY_CALL, "(Ljava/util/List;)Lkotlin/Pair;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.stores.StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroupsForGuild$observable$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreGuildRoleSubscriptions5<T, R> implements Func1<List<? extends GuildRoleSubscriptionGroupListing>, Tuples2> {
    public static final StoreGuildRoleSubscriptions5 INSTANCE = new StoreGuildRoleSubscriptions5();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Tuples2 call(List<? extends GuildRoleSubscriptionGroupListing> list) {
        return call2((List<GuildRoleSubscriptionGroupListing>) list);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Tuples2 call2(List<GuildRoleSubscriptionGroupListing> list) {
        return new Tuples2(list, null);
    }
}
