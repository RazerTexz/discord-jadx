package com.discord.utilities.guildautomod;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: AutoModUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0004J\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/discord/utilities/guildautomod/AutoModBlockFailure;", "", "", "component1", "()I", "", "component2", "()Ljava/lang/String;", "errorStringId", "reasonCode", "copy", "(ILjava/lang/String;)Lcom/discord/utilities/guildautomod/AutoModBlockFailure;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getErrorStringId", "Ljava/lang/String;", "getReasonCode", "<init>", "(ILjava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.guildautomod.AutoModBlockFailure, reason: use source file name */
/* loaded from: classes2.dex */
public final /* data */ class AutoModUtils2 extends Throwable {
    private final int errorStringId;
    private final String reasonCode;

    public AutoModUtils2(int i, String str) {
        Intrinsics3.checkNotNullParameter(str, "reasonCode");
        this.errorStringId = i;
        this.reasonCode = str;
    }

    public static /* synthetic */ AutoModUtils2 copy$default(AutoModUtils2 autoModUtils2, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = autoModUtils2.errorStringId;
        }
        if ((i2 & 2) != 0) {
            str = autoModUtils2.reasonCode;
        }
        return autoModUtils2.copy(i, str);
    }

    /* renamed from: component1, reason: from getter */
    public final int getErrorStringId() {
        return this.errorStringId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getReasonCode() {
        return this.reasonCode;
    }

    public final AutoModUtils2 copy(int errorStringId, String reasonCode) {
        Intrinsics3.checkNotNullParameter(reasonCode, "reasonCode");
        return new AutoModUtils2(errorStringId, reasonCode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AutoModUtils2)) {
            return false;
        }
        AutoModUtils2 autoModUtils2 = (AutoModUtils2) other;
        return this.errorStringId == autoModUtils2.errorStringId && Intrinsics3.areEqual(this.reasonCode, autoModUtils2.reasonCode);
    }

    public final int getErrorStringId() {
        return this.errorStringId;
    }

    public final String getReasonCode() {
        return this.reasonCode;
    }

    public int hashCode() {
        int i = this.errorStringId * 31;
        String str = this.reasonCode;
        return i + (str != null ? str.hashCode() : 0);
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder sbU = outline.U("AutoModBlockFailure(errorStringId=");
        sbU.append(this.errorStringId);
        sbU.append(", reasonCode=");
        return outline.J(sbU, this.reasonCode, ")");
    }
}
