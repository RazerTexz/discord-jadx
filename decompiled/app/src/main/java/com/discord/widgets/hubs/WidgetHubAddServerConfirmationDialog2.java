package com.discord.widgets.hubs;

import a0.a.a.b;
import android.os.Parcel;
import android.os.Parcelable;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: WidgetHubAddServerConfirmationDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\n\u0010\t\u001a\u00060\u0002j\u0002`\u0003\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b!\u0010\"J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ(\u0010\u000b\u001a\u00020\u00002\f\b\u0002\u0010\t\u001a\u00060\u0002j\u0002`\u00032\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\r\u0010\bJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0010J \u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cR\u001d\u0010\t\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u001d\u001a\u0004\b\u001e\u0010\u0005R\u0019\u0010\n\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u001f\u001a\u0004\b \u0010\b¨\u0006#"}, d2 = {"Lcom/discord/widgets/hubs/AddServerConfirmationArgs;", "Landroid/os/Parcelable;", "", "Lcom/discord/primitives/GuildId;", "component1", "()J", "", "component2", "()Ljava/lang/String;", "guildId", "hubName", "copy", "(JLjava/lang/String;)Lcom/discord/widgets/hubs/AddServerConfirmationArgs;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "J", "getGuildId", "Ljava/lang/String;", "getHubName", "<init>", "(JLjava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.hubs.AddServerConfirmationArgs, reason: use source file name */
/* loaded from: classes2.dex */
public final /* data */ class WidgetHubAddServerConfirmationDialog2 implements Parcelable {
    public static final Parcelable.Creator<WidgetHubAddServerConfirmationDialog2> CREATOR = new Creator();
    private final long guildId;
    private final String hubName;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.hubs.AddServerConfirmationArgs$Creator */
    public static class Creator implements Parcelable.Creator<WidgetHubAddServerConfirmationDialog2> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetHubAddServerConfirmationDialog2 createFromParcel(Parcel parcel) {
            Intrinsics3.checkNotNullParameter(parcel, "in");
            return new WidgetHubAddServerConfirmationDialog2(parcel.readLong(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ WidgetHubAddServerConfirmationDialog2 createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetHubAddServerConfirmationDialog2[] newArray(int i) {
            return new WidgetHubAddServerConfirmationDialog2[i];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ WidgetHubAddServerConfirmationDialog2[] newArray(int i) {
            return newArray(i);
        }
    }

    public WidgetHubAddServerConfirmationDialog2(long j, String str) {
        Intrinsics3.checkNotNullParameter(str, "hubName");
        this.guildId = j;
        this.hubName = str;
    }

    public static /* synthetic */ WidgetHubAddServerConfirmationDialog2 copy$default(WidgetHubAddServerConfirmationDialog2 widgetHubAddServerConfirmationDialog2, long j, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            j = widgetHubAddServerConfirmationDialog2.guildId;
        }
        if ((i & 2) != 0) {
            str = widgetHubAddServerConfirmationDialog2.hubName;
        }
        return widgetHubAddServerConfirmationDialog2.copy(j, str);
    }

    /* renamed from: component1, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getHubName() {
        return this.hubName;
    }

    public final WidgetHubAddServerConfirmationDialog2 copy(long guildId, String hubName) {
        Intrinsics3.checkNotNullParameter(hubName, "hubName");
        return new WidgetHubAddServerConfirmationDialog2(guildId, hubName);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetHubAddServerConfirmationDialog2)) {
            return false;
        }
        WidgetHubAddServerConfirmationDialog2 widgetHubAddServerConfirmationDialog2 = (WidgetHubAddServerConfirmationDialog2) other;
        return this.guildId == widgetHubAddServerConfirmationDialog2.guildId && Intrinsics3.areEqual(this.hubName, widgetHubAddServerConfirmationDialog2.hubName);
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final String getHubName() {
        return this.hubName;
    }

    public int hashCode() {
        int iA = b.a(this.guildId) * 31;
        String str = this.hubName;
        return iA + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("AddServerConfirmationArgs(guildId=");
        sbU.append(this.guildId);
        sbU.append(", hubName=");
        return outline.J(sbU, this.hubName, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics3.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.guildId);
        parcel.writeString(this.hubName);
    }
}
