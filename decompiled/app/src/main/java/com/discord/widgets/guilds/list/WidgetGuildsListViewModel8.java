package com.discord.widgets.guilds.list;

import com.discord.stores.StoreGuildsSorted;
import com.discord.widgets.guilds.list.WidgetGuildsListViewModel;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetGuildsListViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/stores/StoreGuildsSorted$Entry$SingletonGuild;", "it", "", "invoke", "(Lcom/discord/stores/StoreGuildsSorted$Entry$SingletonGuild;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guilds.list.WidgetGuildsListViewModel$handleStoreState$lurkerGuildItems$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGuildsListViewModel8 extends Lambda implements Function1<StoreGuildsSorted.Entry.SingletonGuild, Boolean> {
    public final /* synthetic */ WidgetGuildsListViewModel.StoreState $storeState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildsListViewModel8(WidgetGuildsListViewModel.StoreState storeState) {
        super(1);
        this.$storeState = storeState;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(StoreGuildsSorted.Entry.SingletonGuild singletonGuild) {
        return Boolean.valueOf(invoke2(singletonGuild));
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(StoreGuildsSorted.Entry.SingletonGuild singletonGuild) {
        Intrinsics3.checkNotNullParameter(singletonGuild, "it");
        return this.$storeState.getLurkingGuildIds().contains(Long.valueOf(singletonGuild.getGuild().getId()));
    }
}
