package com.discord.widgets.chat.overlay;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreChat;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import rx.functions.Func2;

/* compiled from: WidgetChatOverlay.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "kotlin.jvm.PlatformType", "isDetached", "Lcom/discord/stores/StoreChat$InteractionState;", "interactionState", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Boolean;Lcom/discord/stores/StoreChat$InteractionState;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.overlay.WidgetChatOverlay$OldMessageModel$Companion$get$1$isViewingOldMessagesObs$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatOverlay5<T1, T2, R> implements Func2<Boolean, StoreChat.InteractionState, Boolean> {
    public static final WidgetChatOverlay5 INSTANCE = new WidgetChatOverlay5();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ Boolean call(Boolean bool, StoreChat.InteractionState interactionState) {
        return call2(bool, interactionState);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(Boolean bool, StoreChat.InteractionState interactionState) {
        Intrinsics3.checkNotNullExpressionValue(bool, "isDetached");
        return Boolean.valueOf(bool.booleanValue() || !(interactionState.isAtBottomIgnoringTouch() || interactionState.isNearBottomIgnoringTouch()));
    }
}
