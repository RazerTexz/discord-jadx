package com.discord.api.botuikit;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.io.Serializable;
import kotlin.Metadata;

/* compiled from: SelectComponent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fR\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0004R\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u000e\u001a\u0004\b\u0011\u0010\u0004R\u0019\u0010\u0012\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010\u001b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u000e\u001a\u0004\b\u001c\u0010\u0004¨\u0006\u001d"}, d2 = {"Lcom/discord/api/botuikit/SelectItem;", "Ljava/io/Serializable;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "label", "Ljava/lang/String;", "d", ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION, "b", "default", "Z", "a", "()Z", "Lcom/discord/api/botuikit/ComponentEmoji;", "emoji", "Lcom/discord/api/botuikit/ComponentEmoji;", "c", "()Lcom/discord/api/botuikit/ComponentEmoji;", "value", "e", "discord_api"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.api.botuikit.SelectItem, reason: use source file name */
/* loaded from: classes.dex */
public final /* data */ class SelectComponent2 implements Serializable {
    private final boolean default;
    private final String description;
    private final ComponentEmoji emoji;
    private final String label;
    private final String value;

    /* renamed from: a, reason: from getter */
    public final boolean getDefault() {
        return this.default;
    }

    /* renamed from: b, reason: from getter */
    public final String getDescription() {
        return this.description;
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
    public final String getValue() {
        return this.value;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SelectComponent2)) {
            return false;
        }
        SelectComponent2 selectComponent2 = (SelectComponent2) other;
        return Intrinsics3.areEqual(this.label, selectComponent2.label) && Intrinsics3.areEqual(this.value, selectComponent2.value) && Intrinsics3.areEqual(this.emoji, selectComponent2.emoji) && Intrinsics3.areEqual(this.description, selectComponent2.description) && this.default == selectComponent2.default;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.label;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.value;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        ComponentEmoji componentEmoji = this.emoji;
        int iHashCode3 = (iHashCode2 + (componentEmoji != null ? componentEmoji.hashCode() : 0)) * 31;
        String str3 = this.description;
        int iHashCode4 = (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        boolean z2 = this.default;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        return iHashCode4 + i;
    }

    public String toString() {
        StringBuilder sbU = outline.U("SelectItem(label=");
        sbU.append(this.label);
        sbU.append(", value=");
        sbU.append(this.value);
        sbU.append(", emoji=");
        sbU.append(this.emoji);
        sbU.append(", description=");
        sbU.append(this.description);
        sbU.append(", default=");
        return outline.O(sbU, this.default, ")");
    }
}
