package com.discord.api.botuikit;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TextComponent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fR\u0019\u0010\r\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0007R\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0011\u001a\u0004\b\u0014\u0010\u0004R\u0019\u0010\u0016\u001a\u00020\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001b\u001a\u00020\u001a8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010\u001f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u0011\u001a\u0004\b \u0010\u0004R\u0019\u0010!\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\u0011\u001a\u0004\b\"\u0010\u0004R\u0019\u0010#\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010\u000e\u001a\u0004\b$\u0010\u0007R\u001b\u0010%\u001a\u0004\u0018\u00010\n8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(¨\u0006)"}, d2 = {"Lcom/discord/api/botuikit/TextComponent;", "Lcom/discord/api/botuikit/ActionComponent;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "maxLength", "I", "c", "placeholder", "Ljava/lang/String;", "e", "value", "h", "Lcom/discord/api/botuikit/TextStyle;", "style", "Lcom/discord/api/botuikit/TextStyle;", "g", "()Lcom/discord/api/botuikit/TextStyle;", "Lcom/discord/api/botuikit/ComponentType;", "type", "Lcom/discord/api/botuikit/ComponentType;", "getType", "()Lcom/discord/api/botuikit/ComponentType;", "label", "b", "customId", "a", "minLength", "d", "required", "Ljava/lang/Boolean;", "f", "()Ljava/lang/Boolean;", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TextComponent extends Component5 {
    private final String customId;
    private final String label;
    private final int maxLength;
    private final int minLength;
    private final String placeholder;
    private final Boolean required;
    private final TextComponent2 style;
    private final Component6 type;
    private final String value;

    /* renamed from: a, reason: from getter */
    public final String getCustomId() {
        return this.customId;
    }

    /* renamed from: b, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    /* renamed from: c, reason: from getter */
    public final int getMaxLength() {
        return this.maxLength;
    }

    /* renamed from: d, reason: from getter */
    public final int getMinLength() {
        return this.minLength;
    }

    /* renamed from: e, reason: from getter */
    public final String getPlaceholder() {
        return this.placeholder;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TextComponent)) {
            return false;
        }
        TextComponent textComponent = (TextComponent) other;
        return Intrinsics3.areEqual(this.type, textComponent.type) && Intrinsics3.areEqual(this.style, textComponent.style) && Intrinsics3.areEqual(this.customId, textComponent.customId) && Intrinsics3.areEqual(this.label, textComponent.label) && Intrinsics3.areEqual(this.value, textComponent.value) && Intrinsics3.areEqual(this.placeholder, textComponent.placeholder) && this.minLength == textComponent.minLength && this.maxLength == textComponent.maxLength && Intrinsics3.areEqual(this.required, textComponent.required);
    }

    /* renamed from: f, reason: from getter */
    public final Boolean getRequired() {
        return this.required;
    }

    /* renamed from: g, reason: from getter */
    public final TextComponent2 getStyle() {
        return this.style;
    }

    @Override // com.discord.api.botuikit.Component
    public Component6 getType() {
        return this.type;
    }

    /* renamed from: h, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        Component6 component6 = this.type;
        int iHashCode = (component6 != null ? component6.hashCode() : 0) * 31;
        TextComponent2 textComponent2 = this.style;
        int iHashCode2 = (iHashCode + (textComponent2 != null ? textComponent2.hashCode() : 0)) * 31;
        String str = this.customId;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.label;
        int iHashCode4 = (iHashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.value;
        int iHashCode5 = (iHashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.placeholder;
        int iHashCode6 = (((((iHashCode5 + (str4 != null ? str4.hashCode() : 0)) * 31) + this.minLength) * 31) + this.maxLength) * 31;
        Boolean bool = this.required;
        return iHashCode6 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TextComponent(type=");
        sbU.append(this.type);
        sbU.append(", style=");
        sbU.append(this.style);
        sbU.append(", customId=");
        sbU.append(this.customId);
        sbU.append(", label=");
        sbU.append(this.label);
        sbU.append(", value=");
        sbU.append(this.value);
        sbU.append(", placeholder=");
        sbU.append(this.placeholder);
        sbU.append(", minLength=");
        sbU.append(this.minLength);
        sbU.append(", maxLength=");
        sbU.append(this.maxLength);
        sbU.append(", required=");
        return outline.D(sbU, this.required, ")");
    }
}
