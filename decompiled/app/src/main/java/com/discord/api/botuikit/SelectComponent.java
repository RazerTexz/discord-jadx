package com.discord.api.botuikit;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: SelectComponent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fR\u0019\u0010\r\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0007R\u0019\u0010\u0010\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u000e\u001a\u0004\b\u0011\u0010\u0007R\u001f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004R\u0019\u0010\u001b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0019\u001a\u0004\b\u001c\u0010\u0004R\u0019\u0010\u001d\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010\"\u001a\u00020!8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%¨\u0006&"}, d2 = {"Lcom/discord/api/botuikit/SelectComponent;", "Lcom/discord/api/botuikit/ActionComponent;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "minValues", "I", "d", "maxValues", "c", "", "Lcom/discord/api/botuikit/SelectItem;", "options", "Ljava/util/List;", "e", "()Ljava/util/List;", "placeholder", "Ljava/lang/String;", "f", "customId", "a", "disabled", "Z", "b", "()Z", "Lcom/discord/api/botuikit/ComponentType;", "type", "Lcom/discord/api/botuikit/ComponentType;", "getType", "()Lcom/discord/api/botuikit/ComponentType;", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class SelectComponent extends Component5 {
    private final String customId;
    private final boolean disabled;
    private final int maxValues;
    private final int minValues;
    private final List<SelectComponent2> options;
    private final String placeholder;
    private final Component6 type;

    /* renamed from: a, reason: from getter */
    public final String getCustomId() {
        return this.customId;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getDisabled() {
        return this.disabled;
    }

    /* renamed from: c, reason: from getter */
    public final int getMaxValues() {
        return this.maxValues;
    }

    /* renamed from: d, reason: from getter */
    public final int getMinValues() {
        return this.minValues;
    }

    public final List<SelectComponent2> e() {
        return this.options;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SelectComponent)) {
            return false;
        }
        SelectComponent selectComponent = (SelectComponent) other;
        return Intrinsics3.areEqual(this.type, selectComponent.type) && Intrinsics3.areEqual(this.customId, selectComponent.customId) && this.disabled == selectComponent.disabled && Intrinsics3.areEqual(this.placeholder, selectComponent.placeholder) && this.minValues == selectComponent.minValues && this.maxValues == selectComponent.maxValues && Intrinsics3.areEqual(this.options, selectComponent.options);
    }

    /* renamed from: f, reason: from getter */
    public final String getPlaceholder() {
        return this.placeholder;
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
        boolean z2 = this.disabled;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iHashCode2 + i) * 31;
        String str2 = this.placeholder;
        int iHashCode3 = (((((i2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.minValues) * 31) + this.maxValues) * 31;
        List<SelectComponent2> list = this.options;
        return iHashCode3 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("SelectComponent(type=");
        sbU.append(this.type);
        sbU.append(", customId=");
        sbU.append(this.customId);
        sbU.append(", disabled=");
        sbU.append(this.disabled);
        sbU.append(", placeholder=");
        sbU.append(this.placeholder);
        sbU.append(", minValues=");
        sbU.append(this.minValues);
        sbU.append(", maxValues=");
        sbU.append(this.maxValues);
        sbU.append(", options=");
        return outline.L(sbU, this.options, ")");
    }
}
