package com.discord.api.commands;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: ApplicationCommandData.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0018\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0013\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004R!\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0018\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0007R\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/discord/api/commands/ApplicationCommandValue;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "focused", "Ljava/lang/Boolean;", "getFocused", "()Ljava/lang/Boolean;", ModelAuditLogEntry.CHANGE_KEY_NAME, "Ljava/lang/String;", "b", "", "options", "Ljava/util/List;", "c", "()Ljava/util/List;", "type", "I", "d", "value", "Ljava/lang/Object;", "e", "()Ljava/lang/Object;", "<init>", "(Ljava/lang/String;Ljava/lang/Object;ILjava/util/List;Ljava/lang/Boolean;)V", "discord_api"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.api.commands.ApplicationCommandValue, reason: use source file name */
/* loaded from: classes.dex */
public final /* data */ class ApplicationCommandData3 {
    private final Boolean focused;
    private final String name;
    private final List<ApplicationCommandData3> options;
    private final int type;
    private final Object value;

    public ApplicationCommandData3(String str, Object obj, int i, List<ApplicationCommandData3> list, Boolean bool) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.name = str;
        this.value = obj;
        this.type = i;
        this.options = list;
        this.focused = bool;
    }

    public static ApplicationCommandData3 a(ApplicationCommandData3 applicationCommandData3, String str, Object obj, int i, List list, Boolean bool, int i2) {
        String str2 = (i2 & 1) != 0 ? applicationCommandData3.name : null;
        if ((i2 & 2) != 0) {
            obj = applicationCommandData3.value;
        }
        Object obj2 = obj;
        if ((i2 & 4) != 0) {
            i = applicationCommandData3.type;
        }
        int i3 = i;
        List<ApplicationCommandData3> list2 = (i2 & 8) != 0 ? applicationCommandData3.options : null;
        Boolean bool2 = (i2 & 16) != 0 ? applicationCommandData3.focused : null;
        Intrinsics3.checkNotNullParameter(str2, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return new ApplicationCommandData3(str2, obj2, i3, list2, bool2);
    }

    /* renamed from: b, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final List<ApplicationCommandData3> c() {
        return this.options;
    }

    /* renamed from: d, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* renamed from: e, reason: from getter */
    public final Object getValue() {
        return this.value;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApplicationCommandData3)) {
            return false;
        }
        ApplicationCommandData3 applicationCommandData3 = (ApplicationCommandData3) other;
        return Intrinsics3.areEqual(this.name, applicationCommandData3.name) && Intrinsics3.areEqual(this.value, applicationCommandData3.value) && this.type == applicationCommandData3.type && Intrinsics3.areEqual(this.options, applicationCommandData3.options) && Intrinsics3.areEqual(this.focused, applicationCommandData3.focused);
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Object obj = this.value;
        int iHashCode2 = (((iHashCode + (obj != null ? obj.hashCode() : 0)) * 31) + this.type) * 31;
        List<ApplicationCommandData3> list = this.options;
        int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        Boolean bool = this.focused;
        return iHashCode3 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ApplicationCommandValue(name=");
        sbU.append(this.name);
        sbU.append(", value=");
        sbU.append(this.value);
        sbU.append(", type=");
        sbU.append(this.type);
        sbU.append(", options=");
        sbU.append(this.options);
        sbU.append(", focused=");
        return outline.D(sbU, this.focused, ")");
    }
}
