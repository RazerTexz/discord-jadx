package com.discord.models.botuikit;

import b.d.b.a.outline;
import com.discord.api.botuikit.ButtonComponent2;
import com.discord.api.botuikit.Component6;
import com.discord.api.botuikit.ComponentEmoji;
import com.discord.models.botuikit.ActionInteractionComponentState;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ButtonMessageComponent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\n\u0010\u001b\u001a\u00060\u0005j\u0002`\u0006\u0012\b\b\u0002\u0010\u001c\u001a\u00020\t\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u001f\u001a\u00020\u0010\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\"\u001a\u00020\u0017¢\u0006\u0004\b;\u0010<J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000eJ\u0010\u0010\u0011\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\u0016\u0010\u000eJ\u0010\u0010\u0018\u001a\u00020\u0017HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019Jv\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u001a\u001a\u00020\u00022\f\b\u0002\u0010\u001b\u001a\u00060\u0005j\u0002`\u00062\b\b\u0002\u0010\u001c\u001a\u00020\t2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u001f\u001a\u00020\u00102\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\"\u001a\u00020\u0017HÆ\u0001¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b%\u0010\u000eJ\u0010\u0010&\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b&\u0010\bJ\u001a\u0010)\u001a\u00020\u00172\b\u0010(\u001a\u0004\u0018\u00010'HÖ\u0003¢\u0006\u0004\b)\u0010*R\u0019\u0010\"\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010+\u001a\u0004\b,\u0010\u0019R\u001c\u0010\u001a\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001a\u0010-\u001a\u0004\b.\u0010\u0004R \u0010\u001b\u001a\u00060\u0005j\u0002`\u00068\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001b\u0010/\u001a\u0004\b0\u0010\bR\u001b\u0010\u001e\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u00101\u001a\u0004\b2\u0010\u000eR\u001b\u0010!\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b!\u00101\u001a\u0004\b3\u0010\u000eR\u001b\u0010 \u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b \u00104\u001a\u0004\b5\u0010\u0015R\u001b\u0010\u001d\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u00101\u001a\u0004\b6\u0010\u000eR\u001c\u0010\u001c\u001a\u00020\t8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001c\u00107\u001a\u0004\b8\u0010\u000bR\u0019\u0010\u001f\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u00109\u001a\u0004\b:\u0010\u0012¨\u0006="}, d2 = {"Lcom/discord/models/botuikit/ButtonMessageComponent;", "Lcom/discord/models/botuikit/ActionMessageComponent;", "Lcom/discord/api/botuikit/ComponentType;", "component1", "()Lcom/discord/api/botuikit/ComponentType;", "", "Lcom/discord/widgets/botuikit/ComponentIndex;", "component2", "()I", "Lcom/discord/models/botuikit/ActionInteractionComponentState;", "component3", "()Lcom/discord/models/botuikit/ActionInteractionComponentState;", "", "component4", "()Ljava/lang/String;", "component5", "Lcom/discord/api/botuikit/ButtonStyle;", "component6", "()Lcom/discord/api/botuikit/ButtonStyle;", "Lcom/discord/api/botuikit/ComponentEmoji;", "component7", "()Lcom/discord/api/botuikit/ComponentEmoji;", "component8", "", "component9", "()Z", "type", "index", "stateInteraction", "customId", "label", "style", "emoji", "url", "emojiAnimationsEnabled", "copy", "(Lcom/discord/api/botuikit/ComponentType;ILcom/discord/models/botuikit/ActionInteractionComponentState;Ljava/lang/String;Ljava/lang/String;Lcom/discord/api/botuikit/ButtonStyle;Lcom/discord/api/botuikit/ComponentEmoji;Ljava/lang/String;Z)Lcom/discord/models/botuikit/ButtonMessageComponent;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getEmojiAnimationsEnabled", "Lcom/discord/api/botuikit/ComponentType;", "getType", "I", "getIndex", "Ljava/lang/String;", "getLabel", "getUrl", "Lcom/discord/api/botuikit/ComponentEmoji;", "getEmoji", "getCustomId", "Lcom/discord/models/botuikit/ActionInteractionComponentState;", "getStateInteraction", "Lcom/discord/api/botuikit/ButtonStyle;", "getStyle", "<init>", "(Lcom/discord/api/botuikit/ComponentType;ILcom/discord/models/botuikit/ActionInteractionComponentState;Ljava/lang/String;Ljava/lang/String;Lcom/discord/api/botuikit/ButtonStyle;Lcom/discord/api/botuikit/ComponentEmoji;Ljava/lang/String;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ButtonMessageComponent extends MessageComponent2 {
    private final String customId;
    private final ComponentEmoji emoji;
    private final boolean emojiAnimationsEnabled;
    private final int index;
    private final String label;
    private final ActionInteractionComponentState stateInteraction;
    private final ButtonComponent2 style;
    private final Component6 type;
    private final String url;

    public /* synthetic */ ButtonMessageComponent(Component6 component6, int i, ActionInteractionComponentState actionInteractionComponentState, String str, String str2, ButtonComponent2 buttonComponent2, ComponentEmoji componentEmoji, String str3, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(component6, i, (i2 & 4) != 0 ? ActionInteractionComponentState.Enabled.INSTANCE : actionInteractionComponentState, str, str2, buttonComponent2, (i2 & 64) != 0 ? null : componentEmoji, (i2 & 128) != 0 ? null : str3, z2);
    }

    public static /* synthetic */ ButtonMessageComponent copy$default(ButtonMessageComponent buttonMessageComponent, Component6 component6, int i, ActionInteractionComponentState actionInteractionComponentState, String str, String str2, ButtonComponent2 buttonComponent2, ComponentEmoji componentEmoji, String str3, boolean z2, int i2, Object obj) {
        return buttonMessageComponent.copy((i2 & 1) != 0 ? buttonMessageComponent.getType() : component6, (i2 & 2) != 0 ? buttonMessageComponent.getIndex() : i, (i2 & 4) != 0 ? buttonMessageComponent.getStateInteraction() : actionInteractionComponentState, (i2 & 8) != 0 ? buttonMessageComponent.customId : str, (i2 & 16) != 0 ? buttonMessageComponent.label : str2, (i2 & 32) != 0 ? buttonMessageComponent.style : buttonComponent2, (i2 & 64) != 0 ? buttonMessageComponent.emoji : componentEmoji, (i2 & 128) != 0 ? buttonMessageComponent.url : str3, (i2 & 256) != 0 ? buttonMessageComponent.emojiAnimationsEnabled : z2);
    }

    public final Component6 component1() {
        return getType();
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
    public final String getLabel() {
        return this.label;
    }

    /* renamed from: component6, reason: from getter */
    public final ButtonComponent2 getStyle() {
        return this.style;
    }

    /* renamed from: component7, reason: from getter */
    public final ComponentEmoji getEmoji() {
        return this.emoji;
    }

    /* renamed from: component8, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getEmojiAnimationsEnabled() {
        return this.emojiAnimationsEnabled;
    }

    public final ButtonMessageComponent copy(Component6 type, int index, ActionInteractionComponentState stateInteraction, String customId, String label, ButtonComponent2 style, ComponentEmoji emoji, String url, boolean emojiAnimationsEnabled) {
        Intrinsics3.checkNotNullParameter(type, "type");
        Intrinsics3.checkNotNullParameter(stateInteraction, "stateInteraction");
        Intrinsics3.checkNotNullParameter(style, "style");
        return new ButtonMessageComponent(type, index, stateInteraction, customId, label, style, emoji, url, emojiAnimationsEnabled);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ButtonMessageComponent)) {
            return false;
        }
        ButtonMessageComponent buttonMessageComponent = (ButtonMessageComponent) other;
        return Intrinsics3.areEqual(getType(), buttonMessageComponent.getType()) && getIndex() == buttonMessageComponent.getIndex() && Intrinsics3.areEqual(getStateInteraction(), buttonMessageComponent.getStateInteraction()) && Intrinsics3.areEqual(this.customId, buttonMessageComponent.customId) && Intrinsics3.areEqual(this.label, buttonMessageComponent.label) && Intrinsics3.areEqual(this.style, buttonMessageComponent.style) && Intrinsics3.areEqual(this.emoji, buttonMessageComponent.emoji) && Intrinsics3.areEqual(this.url, buttonMessageComponent.url) && this.emojiAnimationsEnabled == buttonMessageComponent.emojiAnimationsEnabled;
    }

    public final String getCustomId() {
        return this.customId;
    }

    public final ComponentEmoji getEmoji() {
        return this.emoji;
    }

    public final boolean getEmojiAnimationsEnabled() {
        return this.emojiAnimationsEnabled;
    }

    @Override // com.discord.models.botuikit.MessageComponent
    public int getIndex() {
        return this.index;
    }

    public final String getLabel() {
        return this.label;
    }

    @Override // com.discord.models.botuikit.MessageComponent2
    public ActionInteractionComponentState getStateInteraction() {
        return this.stateInteraction;
    }

    public final ButtonComponent2 getStyle() {
        return this.style;
    }

    @Override // com.discord.models.botuikit.MessageComponent
    public Component6 getType() {
        return this.type;
    }

    public final String getUrl() {
        return this.url;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        Component6 type = getType();
        int index = (getIndex() + ((type != null ? type.hashCode() : 0) * 31)) * 31;
        ActionInteractionComponentState stateInteraction = getStateInteraction();
        int iHashCode = (index + (stateInteraction != null ? stateInteraction.hashCode() : 0)) * 31;
        String str = this.customId;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.label;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        ButtonComponent2 buttonComponent2 = this.style;
        int iHashCode4 = (iHashCode3 + (buttonComponent2 != null ? buttonComponent2.hashCode() : 0)) * 31;
        ComponentEmoji componentEmoji = this.emoji;
        int iHashCode5 = (iHashCode4 + (componentEmoji != null ? componentEmoji.hashCode() : 0)) * 31;
        String str3 = this.url;
        int iHashCode6 = (iHashCode5 + (str3 != null ? str3.hashCode() : 0)) * 31;
        boolean z2 = this.emojiAnimationsEnabled;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        return iHashCode6 + i;
    }

    public String toString() {
        StringBuilder sbU = outline.U("ButtonMessageComponent(type=");
        sbU.append(getType());
        sbU.append(", index=");
        sbU.append(getIndex());
        sbU.append(", stateInteraction=");
        sbU.append(getStateInteraction());
        sbU.append(", customId=");
        sbU.append(this.customId);
        sbU.append(", label=");
        sbU.append(this.label);
        sbU.append(", style=");
        sbU.append(this.style);
        sbU.append(", emoji=");
        sbU.append(this.emoji);
        sbU.append(", url=");
        sbU.append(this.url);
        sbU.append(", emojiAnimationsEnabled=");
        return outline.O(sbU, this.emojiAnimationsEnabled, ")");
    }

    public ButtonMessageComponent(Component6 component6, int i, ActionInteractionComponentState actionInteractionComponentState, String str, String str2, ButtonComponent2 buttonComponent2, ComponentEmoji componentEmoji, String str3, boolean z2) {
        Intrinsics3.checkNotNullParameter(component6, "type");
        Intrinsics3.checkNotNullParameter(actionInteractionComponentState, "stateInteraction");
        Intrinsics3.checkNotNullParameter(buttonComponent2, "style");
        this.type = component6;
        this.index = i;
        this.stateInteraction = actionInteractionComponentState;
        this.customId = str;
        this.label = str2;
        this.style = buttonComponent2;
        this.emoji = componentEmoji;
        this.url = str3;
        this.emojiAnimationsEnabled = z2;
    }
}
