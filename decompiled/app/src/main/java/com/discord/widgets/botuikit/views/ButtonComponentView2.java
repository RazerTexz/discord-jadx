package com.discord.widgets.botuikit.views;

import com.discord.api.botuikit.ButtonComponent2;
import com.discord.models.botuikit.ButtonMessageComponent;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ButtonComponentView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0004\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/discord/models/botuikit/ButtonMessageComponent;", "", "hasEmoji", "(Lcom/discord/models/botuikit/ButtonMessageComponent;)Z", "hasIcon", "app_productionGoogleRelease"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.botuikit.views.ButtonComponentViewKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class ButtonComponentView2 {
    public static final boolean hasEmoji(ButtonMessageComponent buttonMessageComponent) {
        Intrinsics3.checkNotNullParameter(buttonMessageComponent, "$this$hasEmoji");
        return buttonMessageComponent.getEmoji() != null;
    }

    public static final boolean hasIcon(ButtonMessageComponent buttonMessageComponent) {
        Intrinsics3.checkNotNullParameter(buttonMessageComponent, "$this$hasIcon");
        return buttonMessageComponent.getStyle() == ButtonComponent2.LINK;
    }
}
