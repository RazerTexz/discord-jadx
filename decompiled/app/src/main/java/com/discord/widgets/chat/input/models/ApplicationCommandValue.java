package com.discord.widgets.chat.input.models;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ApplicationCommandValue.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001b\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0012\u001a\u00020\u0007\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\n\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b&\u0010'J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJN\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0012\u001a\u00020\u00072\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\n2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0004J\u0010\u0010\u0018\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0018\u0010\tJ\u001a\u0010\u001a\u001a\u00020\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001c\u001a\u0004\b\u001d\u0010\u0006R!\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u001e\u001a\u0004\b\u001f\u0010\fR\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010 \u001a\u0004\b!\u0010\u0004R\u0019\u0010\u0012\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\"\u001a\u0004\b#\u0010\tR\u001b\u0010\u0014\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010$\u001a\u0004\b%\u0010\u000f¨\u0006("}, d2 = {"Lcom/discord/widgets/chat/input/models/ApplicationCommandValue;", "", "", "component1", "()Ljava/lang/String;", "component2", "()Ljava/lang/Object;", "", "component3", "()I", "", "component4", "()Ljava/util/List;", "", "component5", "()Ljava/lang/Boolean;", ModelAuditLogEntry.CHANGE_KEY_NAME, "value", "type", "options", "focused", "copy", "(Ljava/lang/String;Ljava/lang/Object;ILjava/util/List;Ljava/lang/Boolean;)Lcom/discord/widgets/chat/input/models/ApplicationCommandValue;", "toString", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Object;", "getValue", "Ljava/util/List;", "getOptions", "Ljava/lang/String;", "getName", "I", "getType", "Ljava/lang/Boolean;", "getFocused", "<init>", "(Ljava/lang/String;Ljava/lang/Object;ILjava/util/List;Ljava/lang/Boolean;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class ApplicationCommandValue {
    private final Boolean focused;
    private final String name;
    private final List<ApplicationCommandValue> options;
    private final int type;
    private final Object value;

    public ApplicationCommandValue(String str, Object obj, int i, List<ApplicationCommandValue> list, Boolean bool) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.name = str;
        this.value = obj;
        this.type = i;
        this.options = list;
        this.focused = bool;
    }

    public static /* synthetic */ ApplicationCommandValue copy$default(ApplicationCommandValue applicationCommandValue, String str, Object obj, int i, List list, Boolean bool, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            str = applicationCommandValue.name;
        }
        if ((i2 & 2) != 0) {
            obj = applicationCommandValue.value;
        }
        Object obj3 = obj;
        if ((i2 & 4) != 0) {
            i = applicationCommandValue.type;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            list = applicationCommandValue.options;
        }
        List list2 = list;
        if ((i2 & 16) != 0) {
            bool = applicationCommandValue.focused;
        }
        return applicationCommandValue.copy(str, obj3, i3, list2, bool);
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final Object getValue() {
        return this.value;
    }

    /* renamed from: component3, reason: from getter */
    public final int getType() {
        return this.type;
    }

    public final List<ApplicationCommandValue> component4() {
        return this.options;
    }

    /* renamed from: component5, reason: from getter */
    public final Boolean getFocused() {
        return this.focused;
    }

    public final ApplicationCommandValue copy(String name, Object value, int type, List<ApplicationCommandValue> options, Boolean focused) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return new ApplicationCommandValue(name, value, type, options, focused);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApplicationCommandValue)) {
            return false;
        }
        ApplicationCommandValue applicationCommandValue = (ApplicationCommandValue) other;
        return Intrinsics3.areEqual(this.name, applicationCommandValue.name) && Intrinsics3.areEqual(this.value, applicationCommandValue.value) && this.type == applicationCommandValue.type && Intrinsics3.areEqual(this.options, applicationCommandValue.options) && Intrinsics3.areEqual(this.focused, applicationCommandValue.focused);
    }

    public final Boolean getFocused() {
        return this.focused;
    }

    public final String getName() {
        return this.name;
    }

    public final List<ApplicationCommandValue> getOptions() {
        return this.options;
    }

    public final int getType() {
        return this.type;
    }

    public final Object getValue() {
        return this.value;
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Object obj = this.value;
        int iHashCode2 = (((iHashCode + (obj != null ? obj.hashCode() : 0)) * 31) + this.type) * 31;
        List<ApplicationCommandValue> list = this.options;
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

    public /* synthetic */ ApplicationCommandValue(String str, Object obj, int i, List list, Boolean bool, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? null : obj, i, (i2 & 8) != 0 ? null : list, (i2 & 16) != 0 ? null : bool);
    }
}
