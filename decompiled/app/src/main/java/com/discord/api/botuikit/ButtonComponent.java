package com.discord.api.botuikit;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ButtonComponent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fR\u0019\u0010\r\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u00020\u00118\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001c\u001a\u0004\b\u001f\u0010\u0004R\u001b\u0010 \u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\u001c\u001a\u0004\b!\u0010\u0004R\u0019\u0010#\u001a\u00020\"8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&¨\u0006'"}, d2 = {"Lcom/discord/api/botuikit/ButtonComponent;", "Lcom/discord/api/botuikit/ActionComponent;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "disabled", "Z", "b", "()Z", "Lcom/discord/api/botuikit/ComponentType;", "type", "Lcom/discord/api/botuikit/ComponentType;", "getType", "()Lcom/discord/api/botuikit/ComponentType;", "Lcom/discord/api/botuikit/ComponentEmoji;", "emoji", "Lcom/discord/api/botuikit/ComponentEmoji;", "c", "()Lcom/discord/api/botuikit/ComponentEmoji;", "label", "Ljava/lang/String;", "d", "customId", "a", "url", "f", "Lcom/discord/api/botuikit/ButtonStyle;", "style", "Lcom/discord/api/botuikit/ButtonStyle;", "e", "()Lcom/discord/api/botuikit/ButtonStyle;", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ButtonComponent extends Component5 {
    private final String customId;
    private final boolean disabled;
    private final ComponentEmoji emoji;
    private final String label;
    private final ButtonComponent2 style;
    private final Component6 type;
    private final String url;

    /* renamed from: a, reason: from getter */
    public final String getCustomId() {
        return this.customId;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getDisabled() {
        return this.disabled;
    }

    /* renamed from: c, reason: from getter */
    public final ComponentEmoji getEmoji() {
        return this.emoji;
    }

    /* renamed from: d, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    /* renamed from: e, reason: from getter */
    public final ButtonComponent2 getStyle() {
        return this.style;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ButtonComponent)) {
            return false;
        }
        ButtonComponent buttonComponent = (ButtonComponent) other;
        return Intrinsics3.areEqual(this.type, buttonComponent.type) && Intrinsics3.areEqual(this.customId, buttonComponent.customId) && Intrinsics3.areEqual(this.label, buttonComponent.label) && Intrinsics3.areEqual(this.style, buttonComponent.style) && this.disabled == buttonComponent.disabled && Intrinsics3.areEqual(this.emoji, buttonComponent.emoji) && Intrinsics3.areEqual(this.url, buttonComponent.url);
    }

    /* renamed from: f, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @Override // com.discord.api.botuikit.Component
    public Component6 getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        Component6 component6 = this.type;
        int iHashCode = (component6 != null ? component6.hashCode() : 0) * 31;
        String str = this.customId;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.label;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        ButtonComponent2 buttonComponent2 = this.style;
        int iHashCode4 = (iHashCode3 + (buttonComponent2 != null ? buttonComponent2.hashCode() : 0)) * 31;
        boolean z2 = this.disabled;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iHashCode4 + i) * 31;
        ComponentEmoji componentEmoji = this.emoji;
        int iHashCode5 = (i2 + (componentEmoji != null ? componentEmoji.hashCode() : 0)) * 31;
        String str3 = this.url;
        return iHashCode5 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ButtonComponent(type=");
        sbU.append(this.type);
        sbU.append(", customId=");
        sbU.append(this.customId);
        sbU.append(", label=");
        sbU.append(this.label);
        sbU.append(", style=");
        sbU.append(this.style);
        sbU.append(", disabled=");
        sbU.append(this.disabled);
        sbU.append(", emoji=");
        sbU.append(this.emoji);
        sbU.append(", url=");
        return outline.J(sbU, this.url, ")");
    }
}
