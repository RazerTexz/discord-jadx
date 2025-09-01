package com.discord.widgets.botuikit.views;

import com.discord.api.botuikit.SelectComponent2;
import java.util.List;
import kotlin.Metadata;

/* compiled from: ComponentView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J#\u0010\b\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJa\u0010\u0013\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/botuikit/views/ComponentActionListener;", "", "", "Lcom/discord/widgets/botuikit/ComponentIndex;", "componentIndex", "", "customId", "", "onButtonComponentClick", "(ILjava/lang/String;)V", "placeholder", "", "Lcom/discord/api/botuikit/SelectItem;", "options", "selectedItems", "minOptionsToSelect", "maxOptionsToSelect", "", "emojiAnimationsEnabled", "onSelectComponentClick", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;IIZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.botuikit.views.ComponentActionListener, reason: use source file name */
/* loaded from: classes2.dex */
public interface ComponentView2 {
    void onButtonComponentClick(int componentIndex, String customId);

    void onSelectComponentClick(int componentIndex, String customId, String placeholder, List<SelectComponent2> options, List<SelectComponent2> selectedItems, int minOptionsToSelect, int maxOptionsToSelect, boolean emojiAnimationsEnabled);
}
