package com.discord.models.botuikit;

import b.d.b.a.outline;
import com.discord.api.botuikit.Component6;
import com.discord.api.botuikit.SelectComponent2;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: SelectMessageComponent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001Bi\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\n\u0010\u001b\u001a\u00060\u0005j\u0002`\u0006\u0012\u0006\u0010\u001c\u001a\u00020\t\u0012\u0006\u0010\u001d\u001a\u00020\f\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u001f\u001a\u00020\u0005\u0012\u0006\u0010 \u001a\u00020\u0005\u0012\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u0006\u0010#\u001a\u00020\u0017¢\u0006\u0004\b<\u0010=J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0010\u0010\bJ\u0010\u0010\u0011\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0011\u0010\bJ\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0015J\u0010\u0010\u0018\u001a\u00020\u0017HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0086\u0001\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u001a\u001a\u00020\u00022\f\b\u0002\u0010\u001b\u001a\u00060\u0005j\u0002`\u00062\b\b\u0002\u0010\u001c\u001a\u00020\t2\b\b\u0002\u0010\u001d\u001a\u00020\f2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u001f\u001a\u00020\u00052\b\b\u0002\u0010 \u001a\u00020\u00052\u000e\b\u0002\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\b\b\u0002\u0010#\u001a\u00020\u0017HÆ\u0001¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b&\u0010\u000eJ\u0010\u0010'\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b'\u0010\bJ\u001a\u0010*\u001a\u00020\u00172\b\u0010)\u001a\u0004\u0018\u00010(HÖ\u0003¢\u0006\u0004\b*\u0010+R\u001c\u0010\u001a\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001a\u0010,\u001a\u0004\b-\u0010\u0004R\u0019\u0010\u001f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010.\u001a\u0004\b/\u0010\bR\u001c\u0010\u001c\u001a\u00020\t8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001c\u00100\u001a\u0004\b1\u0010\u000bR\u0019\u0010 \u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b \u0010.\u001a\u0004\b2\u0010\bR\u001f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\"\u00103\u001a\u0004\b4\u0010\u0015R \u0010\u001b\u001a\u00060\u0005j\u0002`\u00068\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001b\u0010.\u001a\u0004\b5\u0010\bR\u001b\u0010\u001e\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u00106\u001a\u0004\b7\u0010\u000eR\u0019\u0010#\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b#\u00108\u001a\u0004\b9\u0010\u0019R\u0019\u0010\u001d\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u00106\u001a\u0004\b:\u0010\u000eR\u001f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006@\u0006¢\u0006\f\n\u0004\b!\u00103\u001a\u0004\b;\u0010\u0015¨\u0006>"}, d2 = {"Lcom/discord/models/botuikit/SelectMessageComponent;", "Lcom/discord/models/botuikit/ActionMessageComponent;", "Lcom/discord/api/botuikit/ComponentType;", "component1", "()Lcom/discord/api/botuikit/ComponentType;", "", "Lcom/discord/widgets/botuikit/ComponentIndex;", "component2", "()I", "Lcom/discord/models/botuikit/ActionInteractionComponentState;", "component3", "()Lcom/discord/models/botuikit/ActionInteractionComponentState;", "", "component4", "()Ljava/lang/String;", "component5", "component6", "component7", "", "Lcom/discord/api/botuikit/SelectItem;", "component8", "()Ljava/util/List;", "component9", "", "component10", "()Z", "type", "index", "stateInteraction", "customId", "placeholder", "minValues", "maxValues", "options", "selectedOptions", "emojiAnimationsEnabled", "copy", "(Lcom/discord/api/botuikit/ComponentType;ILcom/discord/models/botuikit/ActionInteractionComponentState;Ljava/lang/String;Ljava/lang/String;IILjava/util/List;Ljava/util/List;Z)Lcom/discord/models/botuikit/SelectMessageComponent;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/botuikit/ComponentType;", "getType", "I", "getMinValues", "Lcom/discord/models/botuikit/ActionInteractionComponentState;", "getStateInteraction", "getMaxValues", "Ljava/util/List;", "getSelectedOptions", "getIndex", "Ljava/lang/String;", "getPlaceholder", "Z", "getEmojiAnimationsEnabled", "getCustomId", "getOptions", "<init>", "(Lcom/discord/api/botuikit/ComponentType;ILcom/discord/models/botuikit/ActionInteractionComponentState;Ljava/lang/String;Ljava/lang/String;IILjava/util/List;Ljava/util/List;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class SelectMessageComponent extends MessageComponent2 {
    private final String customId;
    private final boolean emojiAnimationsEnabled;
    private final int index;
    private final int maxValues;
    private final int minValues;
    private final List<SelectComponent2> options;
    private final String placeholder;
    private final List<SelectComponent2> selectedOptions;
    private final ActionInteractionComponentState stateInteraction;
    private final Component6 type;

    public SelectMessageComponent(Component6 component6, int i, ActionInteractionComponentState actionInteractionComponentState, String str, String str2, int i2, int i3, List<SelectComponent2> list, List<SelectComponent2> list2, boolean z2) {
        Intrinsics3.checkNotNullParameter(component6, "type");
        Intrinsics3.checkNotNullParameter(actionInteractionComponentState, "stateInteraction");
        Intrinsics3.checkNotNullParameter(str, "customId");
        Intrinsics3.checkNotNullParameter(list, "options");
        Intrinsics3.checkNotNullParameter(list2, "selectedOptions");
        this.type = component6;
        this.index = i;
        this.stateInteraction = actionInteractionComponentState;
        this.customId = str;
        this.placeholder = str2;
        this.minValues = i2;
        this.maxValues = i3;
        this.options = list;
        this.selectedOptions = list2;
        this.emojiAnimationsEnabled = z2;
    }

    public static /* synthetic */ SelectMessageComponent copy$default(SelectMessageComponent selectMessageComponent, Component6 component6, int i, ActionInteractionComponentState actionInteractionComponentState, String str, String str2, int i2, int i3, List list, List list2, boolean z2, int i4, Object obj) {
        return selectMessageComponent.copy((i4 & 1) != 0 ? selectMessageComponent.getType() : component6, (i4 & 2) != 0 ? selectMessageComponent.getIndex() : i, (i4 & 4) != 0 ? selectMessageComponent.getStateInteraction() : actionInteractionComponentState, (i4 & 8) != 0 ? selectMessageComponent.customId : str, (i4 & 16) != 0 ? selectMessageComponent.placeholder : str2, (i4 & 32) != 0 ? selectMessageComponent.minValues : i2, (i4 & 64) != 0 ? selectMessageComponent.maxValues : i3, (i4 & 128) != 0 ? selectMessageComponent.options : list, (i4 & 256) != 0 ? selectMessageComponent.selectedOptions : list2, (i4 & 512) != 0 ? selectMessageComponent.emojiAnimationsEnabled : z2);
    }

    public final Component6 component1() {
        return getType();
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getEmojiAnimationsEnabled() {
        return this.emojiAnimationsEnabled;
    }

    public final int component2() {
        return getIndex();
    }

    public final ActionInteractionComponentState component3() {
        return getStateInteraction();
    }

    /* renamed from: component4, reason: from getter */
    public final String getCustomId() {
        return this.customId;
    }

    /* renamed from: component5, reason: from getter */
    public final String getPlaceholder() {
        return this.placeholder;
    }

    /* renamed from: component6, reason: from getter */
    public final int getMinValues() {
        return this.minValues;
    }

    /* renamed from: component7, reason: from getter */
    public final int getMaxValues() {
        return this.maxValues;
    }

    public final List<SelectComponent2> component8() {
        return this.options;
    }

    public final List<SelectComponent2> component9() {
        return this.selectedOptions;
    }

    public final SelectMessageComponent copy(Component6 type, int index, ActionInteractionComponentState stateInteraction, String customId, String placeholder, int minValues, int maxValues, List<SelectComponent2> options, List<SelectComponent2> selectedOptions, boolean emojiAnimationsEnabled) {
        Intrinsics3.checkNotNullParameter(type, "type");
        Intrinsics3.checkNotNullParameter(stateInteraction, "stateInteraction");
        Intrinsics3.checkNotNullParameter(customId, "customId");
        Intrinsics3.checkNotNullParameter(options, "options");
        Intrinsics3.checkNotNullParameter(selectedOptions, "selectedOptions");
        return new SelectMessageComponent(type, index, stateInteraction, customId, placeholder, minValues, maxValues, options, selectedOptions, emojiAnimationsEnabled);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SelectMessageComponent)) {
            return false;
        }
        SelectMessageComponent selectMessageComponent = (SelectMessageComponent) other;
        return Intrinsics3.areEqual(getType(), selectMessageComponent.getType()) && getIndex() == selectMessageComponent.getIndex() && Intrinsics3.areEqual(getStateInteraction(), selectMessageComponent.getStateInteraction()) && Intrinsics3.areEqual(this.customId, selectMessageComponent.customId) && Intrinsics3.areEqual(this.placeholder, selectMessageComponent.placeholder) && this.minValues == selectMessageComponent.minValues && this.maxValues == selectMessageComponent.maxValues && Intrinsics3.areEqual(this.options, selectMessageComponent.options) && Intrinsics3.areEqual(this.selectedOptions, selectMessageComponent.selectedOptions) && this.emojiAnimationsEnabled == selectMessageComponent.emojiAnimationsEnabled;
    }

    public final String getCustomId() {
        return this.customId;
    }

    public final boolean getEmojiAnimationsEnabled() {
        return this.emojiAnimationsEnabled;
    }

    @Override // com.discord.models.botuikit.MessageComponent
    public int getIndex() {
        return this.index;
    }

    public final int getMaxValues() {
        return this.maxValues;
    }

    public final int getMinValues() {
        return this.minValues;
    }

    public final List<SelectComponent2> getOptions() {
        return this.options;
    }

    public final String getPlaceholder() {
        return this.placeholder;
    }

    public final List<SelectComponent2> getSelectedOptions() {
        return this.selectedOptions;
    }

    @Override // com.discord.models.botuikit.MessageComponent2
    public ActionInteractionComponentState getStateInteraction() {
        return this.stateInteraction;
    }

    @Override // com.discord.models.botuikit.MessageComponent
    public Component6 getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        Component6 type = getType();
        int index = (getIndex() + ((type != null ? type.hashCode() : 0) * 31)) * 31;
        ActionInteractionComponentState stateInteraction = getStateInteraction();
        int iHashCode = (index + (stateInteraction != null ? stateInteraction.hashCode() : 0)) * 31;
        String str = this.customId;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.placeholder;
        int iHashCode3 = (((((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.minValues) * 31) + this.maxValues) * 31;
        List<SelectComponent2> list = this.options;
        int iHashCode4 = (iHashCode3 + (list != null ? list.hashCode() : 0)) * 31;
        List<SelectComponent2> list2 = this.selectedOptions;
        int iHashCode5 = (iHashCode4 + (list2 != null ? list2.hashCode() : 0)) * 31;
        boolean z2 = this.emojiAnimationsEnabled;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        return iHashCode5 + i;
    }

    public String toString() {
        StringBuilder sbU = outline.U("SelectMessageComponent(type=");
        sbU.append(getType());
        sbU.append(", index=");
        sbU.append(getIndex());
        sbU.append(", stateInteraction=");
        sbU.append(getStateInteraction());
        sbU.append(", customId=");
        sbU.append(this.customId);
        sbU.append(", placeholder=");
        sbU.append(this.placeholder);
        sbU.append(", minValues=");
        sbU.append(this.minValues);
        sbU.append(", maxValues=");
        sbU.append(this.maxValues);
        sbU.append(", options=");
        sbU.append(this.options);
        sbU.append(", selectedOptions=");
        sbU.append(this.selectedOptions);
        sbU.append(", emojiAnimationsEnabled=");
        return outline.O(sbU, this.emojiAnimationsEnabled, ")");
    }
}
