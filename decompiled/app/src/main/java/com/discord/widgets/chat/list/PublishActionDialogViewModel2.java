package com.discord.widgets.chat.list;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelChannelFollowerStats;
import com.discord.widgets.chat.list.PublishActionDialogViewModel;
import j0.k.Func1;
import kotlin.Metadata;

/* compiled from: PublishActionDialogViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/models/domain/ModelChannelFollowerStats;", "followerStats", "Lcom/discord/widgets/chat/list/PublishActionDialogViewModel$StoreState;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/domain/ModelChannelFollowerStats;)Lcom/discord/widgets/chat/list/PublishActionDialogViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.list.PublishActionDialogViewModel$Companion$observeChannelFollowerStatsStoreState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class PublishActionDialogViewModel2<T, R> implements Func1<ModelChannelFollowerStats, PublishActionDialogViewModel.StoreState> {
    public static final PublishActionDialogViewModel2 INSTANCE = new PublishActionDialogViewModel2();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ PublishActionDialogViewModel.StoreState call(ModelChannelFollowerStats modelChannelFollowerStats) {
        return call2(modelChannelFollowerStats);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final PublishActionDialogViewModel.StoreState call2(ModelChannelFollowerStats modelChannelFollowerStats) {
        return new PublishActionDialogViewModel.StoreState(modelChannelFollowerStats);
    }
}
