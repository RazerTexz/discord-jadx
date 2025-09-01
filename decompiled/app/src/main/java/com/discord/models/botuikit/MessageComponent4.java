package com.discord.models.botuikit;

import com.discord.models.botuikit.ActionInteractionComponentState;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: MessageComponent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/discord/models/botuikit/MessageComponentUtils;", "", "Lcom/discord/models/botuikit/LayoutMessageComponent;", "Lcom/discord/models/botuikit/ActionInteractionComponentState$Failed;", "getChildError", "(Lcom/discord/models/botuikit/LayoutMessageComponent;)Lcom/discord/models/botuikit/ActionInteractionComponentState$Failed;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.models.botuikit.MessageComponentUtils, reason: use source file name */
/* loaded from: classes.dex */
public final class MessageComponent4 {
    public static final MessageComponent4 INSTANCE = new MessageComponent4();

    private MessageComponent4() {
    }

    public final ActionInteractionComponentState.Failed getChildError(MessageComponent3 messageComponent3) {
        Intrinsics3.checkNotNullParameter(messageComponent3, "$this$getChildError");
        for (MessageComponent messageComponent : messageComponent3.getChildren()) {
            if (messageComponent instanceof MessageComponent2) {
                ActionInteractionComponentState stateInteraction = ((MessageComponent2) messageComponent).getStateInteraction();
                if (stateInteraction instanceof ActionInteractionComponentState.Failed) {
                    return (ActionInteractionComponentState.Failed) stateInteraction;
                }
            }
        }
        return null;
    }
}
