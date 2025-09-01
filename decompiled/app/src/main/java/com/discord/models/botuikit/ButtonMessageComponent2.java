package com.discord.models.botuikit;

import com.discord.api.botuikit.ButtonComponent;
import com.discord.api.botuikit.ButtonComponent2;
import com.discord.api.botuikit.Component6;
import com.discord.models.botuikit.ActionInteractionComponentState;
import com.discord.widgets.botuikit.ComponentChatListState;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ButtonMessageComponent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a-\u0010\t\u001a\u00020\b*\u00020\u00002\n\u0010\u0003\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/discord/api/botuikit/ButtonComponent;", "", "Lcom/discord/widgets/botuikit/ComponentIndex;", "index", "Lcom/discord/models/botuikit/ActionInteractionComponentState;", "buttonStateInteraction", "Lcom/discord/widgets/botuikit/ComponentChatListState$ComponentStoreState;", "componentStoreState", "Lcom/discord/models/botuikit/ButtonMessageComponent;", "mergeToMessageComponent", "(Lcom/discord/api/botuikit/ButtonComponent;ILcom/discord/models/botuikit/ActionInteractionComponentState;Lcom/discord/widgets/botuikit/ComponentChatListState$ComponentStoreState;)Lcom/discord/models/botuikit/ButtonMessageComponent;", "app_productionGoogleRelease"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.models.botuikit.ButtonMessageComponentKt, reason: use source file name */
/* loaded from: classes.dex */
public final class ButtonMessageComponent2 {
    public static final ButtonMessageComponent mergeToMessageComponent(ButtonComponent buttonComponent, int i, ActionInteractionComponentState actionInteractionComponentState, ComponentChatListState.ComponentStoreState componentStoreState) {
        Intrinsics3.checkNotNullParameter(buttonComponent, "$this$mergeToMessageComponent");
        Intrinsics3.checkNotNullParameter(actionInteractionComponentState, "buttonStateInteraction");
        Intrinsics3.checkNotNullParameter(componentStoreState, "componentStoreState");
        Component6 type = buttonComponent.getType();
        String customId = buttonComponent.getCustomId();
        String label = buttonComponent.getLabel();
        ButtonComponent2 style = buttonComponent.getStyle();
        if (buttonComponent.getDisabled()) {
            actionInteractionComponentState = ActionInteractionComponentState.Disabled.INSTANCE;
        } else if (buttonComponent.getUrl() != null) {
            actionInteractionComponentState = ActionInteractionComponentState.Enabled.INSTANCE;
        }
        return new ButtonMessageComponent(type, i, actionInteractionComponentState, customId, label, style, buttonComponent.getEmoji(), buttonComponent.getUrl(), componentStoreState.getAnimateEmojis());
    }
}
