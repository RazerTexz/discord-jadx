package com.discord.widgets.chat.overlay;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreChat;
import j0.k.Func1;
import kotlin.Metadata;

/* compiled from: WidgetChatOverlay.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/stores/StoreChat$InteractionState;", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/stores/StoreChat$InteractionState;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.overlay.WidgetChatOverlay$OldMessageModel$Companion$get$1$isViewingOldMessagesObs$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatOverlay4<T, R> implements Func1<StoreChat.InteractionState, Boolean> {
    public final /* synthetic */ Long $selectedChannelId;

    public WidgetChatOverlay4(Long l) {
        this.$selectedChannelId = l;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Boolean call(StoreChat.InteractionState interactionState) {
        return call2(interactionState);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(StoreChat.InteractionState interactionState) {
        long channelId = interactionState.getChannelId();
        Long l = this.$selectedChannelId;
        return Boolean.valueOf((l == null || channelId != l.longValue() || interactionState.getLastMessageId() == 0) ? false : true);
    }
}
