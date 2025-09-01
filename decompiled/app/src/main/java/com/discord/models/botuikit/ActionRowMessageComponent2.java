package com.discord.models.botuikit;

import com.discord.api.botuikit.ActionRowComponent;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: ActionRowMessageComponent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a+\u0010\b\u001a\u00020\u0007*\u00020\u00002\n\u0010\u0003\u001a\u00060\u0001j\u0002`\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/discord/api/botuikit/ActionRowComponent;", "", "Lcom/discord/widgets/botuikit/ComponentIndex;", "index", "", "Lcom/discord/models/botuikit/MessageComponent;", "children", "Lcom/discord/models/botuikit/ActionRowMessageComponent;", "mergeToMessageComponent", "(Lcom/discord/api/botuikit/ActionRowComponent;ILjava/util/List;)Lcom/discord/models/botuikit/ActionRowMessageComponent;", "app_productionGoogleRelease"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.models.botuikit.ActionRowMessageComponentKt, reason: use source file name */
/* loaded from: classes.dex */
public final class ActionRowMessageComponent2 {
    public static final ActionRowMessageComponent mergeToMessageComponent(ActionRowComponent actionRowComponent, int i, List<? extends MessageComponent> list) {
        Intrinsics3.checkNotNullParameter(actionRowComponent, "$this$mergeToMessageComponent");
        Intrinsics3.checkNotNullParameter(list, "children");
        return new ActionRowMessageComponent(actionRowComponent.getType(), i, list);
    }
}
