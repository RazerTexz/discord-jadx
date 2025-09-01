package com.discord.widgets.channels.threads.browser;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.stores.ArchivedThreadsStore;
import kotlin.Metadata;
import kotlin.Tuples2;
import rx.functions.Func2;

/* compiled from: WidgetThreadBrowserArchivedViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a6\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00000\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0003 \u0001*\u001a\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00000\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00050\u00052\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/discord/stores/ArchivedThreadsStore$ThreadListingState;", "kotlin.jvm.PlatformType", "listingState", "Lcom/discord/api/channel/Channel;", "channel", "Lkotlin/Pair;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/stores/ArchivedThreadsStore$ThreadListingState;Lcom/discord/api/channel/Channel;)Lkotlin/Pair;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserArchivedViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetThreadBrowserArchivedViewModel2<T1, T2, R> implements Func2<ArchivedThreadsStore.ThreadListingState, Channel, Tuples2<? extends ArchivedThreadsStore.ThreadListingState, ? extends Channel>> {
    public static final WidgetThreadBrowserArchivedViewModel2 INSTANCE = new WidgetThreadBrowserArchivedViewModel2();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ Tuples2<? extends ArchivedThreadsStore.ThreadListingState, ? extends Channel> call(ArchivedThreadsStore.ThreadListingState threadListingState, Channel channel) {
        return call2(threadListingState, channel);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Tuples2<ArchivedThreadsStore.ThreadListingState, Channel> call2(ArchivedThreadsStore.ThreadListingState threadListingState, Channel channel) {
        return new Tuples2<>(threadListingState, channel);
    }
}
