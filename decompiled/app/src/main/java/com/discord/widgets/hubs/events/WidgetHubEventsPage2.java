package com.discord.widgets.hubs.events;

import a0.a.a.b;
import android.os.Parcel;
import android.os.Parcelable;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: WidgetHubEventsPage.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\u0010\b\u001a\u00060\u0002j\u0002`\u0003\u0012\n\u0010\t\u001a\u00060\u0002j\u0002`\u0006¢\u0006\u0004\b!\u0010\"J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0007\u001a\u00060\u0002j\u0002`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0005J,\u0010\n\u001a\u00020\u00002\f\b\u0002\u0010\b\u001a\u00060\u0002j\u0002`\u00032\f\b\u0002\u0010\t\u001a\u00060\u0002j\u0002`\u0006HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0011J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u001d\u0010\t\u001a\u00060\u0002j\u0002`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u001e\u001a\u0004\b\u001f\u0010\u0005R\u001d\u0010\b\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u001e\u001a\u0004\b \u0010\u0005¨\u0006#"}, d2 = {"Lcom/discord/widgets/hubs/events/HubEventsArgs;", "Landroid/os/Parcelable;", "", "Lcom/discord/primitives/GuildId;", "component1", "()J", "Lcom/discord/primitives/ChannelId;", "component2", "guildId", "directoryChannelId", "copy", "(JJ)Lcom/discord/widgets/hubs/events/HubEventsArgs;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "J", "getDirectoryChannelId", "getGuildId", "<init>", "(JJ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.hubs.events.HubEventsArgs, reason: use source file name */
/* loaded from: classes2.dex */
public final /* data */ class WidgetHubEventsPage2 implements Parcelable {
    public static final Parcelable.Creator<WidgetHubEventsPage2> CREATOR = new Creator();
    private final long directoryChannelId;
    private final long guildId;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.hubs.events.HubEventsArgs$Creator */
    public static class Creator implements Parcelable.Creator<WidgetHubEventsPage2> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetHubEventsPage2 createFromParcel(Parcel parcel) {
            Intrinsics3.checkNotNullParameter(parcel, "in");
            return new WidgetHubEventsPage2(parcel.readLong(), parcel.readLong());
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ WidgetHubEventsPage2 createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetHubEventsPage2[] newArray(int i) {
            return new WidgetHubEventsPage2[i];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ WidgetHubEventsPage2[] newArray(int i) {
            return newArray(i);
        }
    }

    public WidgetHubEventsPage2(long j, long j2) {
        this.guildId = j;
        this.directoryChannelId = j2;
    }

    public static /* synthetic */ WidgetHubEventsPage2 copy$default(WidgetHubEventsPage2 widgetHubEventsPage2, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = widgetHubEventsPage2.guildId;
        }
        if ((i & 2) != 0) {
            j2 = widgetHubEventsPage2.directoryChannelId;
        }
        return widgetHubEventsPage2.copy(j, j2);
    }

    /* renamed from: component1, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* renamed from: component2, reason: from getter */
    public final long getDirectoryChannelId() {
        return this.directoryChannelId;
    }

    public final WidgetHubEventsPage2 copy(long guildId, long directoryChannelId) {
        return new WidgetHubEventsPage2(guildId, directoryChannelId);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetHubEventsPage2)) {
            return false;
        }
        WidgetHubEventsPage2 widgetHubEventsPage2 = (WidgetHubEventsPage2) other;
        return this.guildId == widgetHubEventsPage2.guildId && this.directoryChannelId == widgetHubEventsPage2.directoryChannelId;
    }

    public final long getDirectoryChannelId() {
        return this.directoryChannelId;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public int hashCode() {
        return b.a(this.directoryChannelId) + (b.a(this.guildId) * 31);
    }

    public String toString() {
        StringBuilder sbU = outline.U("HubEventsArgs(guildId=");
        sbU.append(this.guildId);
        sbU.append(", directoryChannelId=");
        return outline.C(sbU, this.directoryChannelId, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics3.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.guildId);
        parcel.writeLong(this.directoryChannelId);
    }
}
