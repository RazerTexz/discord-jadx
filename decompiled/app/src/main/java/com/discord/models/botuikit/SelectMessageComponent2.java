package com.discord.models.botuikit;

import com.discord.api.botuikit.Component6;
import com.discord.api.botuikit.SelectComponent;
import com.discord.api.botuikit.SelectComponent2;
import com.discord.models.botuikit.ActionInteractionComponentState;
import com.discord.widgets.botuikit.ComponentChatListState;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: SelectMessageComponent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a-\u0010\t\u001a\u00020\b*\u00020\u00002\n\u0010\u0003\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/discord/api/botuikit/SelectComponent;", "", "Lcom/discord/widgets/botuikit/ComponentIndex;", "index", "Lcom/discord/models/botuikit/ActionInteractionComponentState;", "actionInteractionComponentState", "Lcom/discord/widgets/botuikit/ComponentChatListState$ComponentStoreState;", "componentStoreState", "Lcom/discord/models/botuikit/SelectMessageComponent;", "mergeToMessageComponent", "(Lcom/discord/api/botuikit/SelectComponent;ILcom/discord/models/botuikit/ActionInteractionComponentState;Lcom/discord/widgets/botuikit/ComponentChatListState$ComponentStoreState;)Lcom/discord/models/botuikit/SelectMessageComponent;", "app_productionGoogleRelease"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.models.botuikit.SelectMessageComponentKt, reason: use source file name */
/* loaded from: classes.dex */
public final class SelectMessageComponent2 {
    public static final SelectMessageComponent mergeToMessageComponent(SelectComponent selectComponent, int i, ActionInteractionComponentState actionInteractionComponentState, ComponentChatListState.ComponentStoreState componentStoreState) {
        Intrinsics3.checkNotNullParameter(selectComponent, "$this$mergeToMessageComponent");
        Intrinsics3.checkNotNullParameter(actionInteractionComponentState, "actionInteractionComponentState");
        Intrinsics3.checkNotNullParameter(componentStoreState, "componentStoreState");
        Map<Integer, List<SelectComponent2>> selections = componentStoreState.getSelections();
        List arrayList = selections != null ? selections.get(Integer.valueOf(i)) : null;
        Component6 type = selectComponent.getType();
        String customId = selectComponent.getCustomId();
        String placeholder = selectComponent.getPlaceholder();
        int minValues = selectComponent.getMinValues();
        int maxValues = selectComponent.getMaxValues();
        List<SelectComponent2> listE = selectComponent.e();
        if (selectComponent.getDisabled()) {
            actionInteractionComponentState = ActionInteractionComponentState.Disabled.INSTANCE;
        }
        ActionInteractionComponentState actionInteractionComponentState2 = actionInteractionComponentState;
        if (arrayList == null) {
            List<SelectComponent2> listE2 = selectComponent.e();
            arrayList = new ArrayList();
            for (Object obj : listE2) {
                if (((SelectComponent2) obj).getDefault()) {
                    arrayList.add(obj);
                }
            }
        }
        return new SelectMessageComponent(type, i, actionInteractionComponentState2, customId, placeholder, minValues, maxValues, listE, arrayList, componentStoreState.getAnimateEmojis());
    }
}
