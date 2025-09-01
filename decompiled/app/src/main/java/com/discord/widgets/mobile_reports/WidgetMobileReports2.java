package com.discord.widgets.mobile_reports;

import a0.a.a.b;
import android.os.Parcel;
import android.os.Parcelable;
import b.d.b.a.outline;
import com.discord.api.report.ReportType;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WidgetMobileReports.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u000f\u0010\u0011\u0012B\u001d\b\u0002\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\r\u0010\u000eR \u0010\u0004\u001a\u00060\u0002j\u0002`\u00038\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\t\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u0082\u0001\u0004\u0013\u0014\u0015\u0016¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/mobile_reports/MobileReportArgs;", "Landroid/os/Parcelable;", "", "Lcom/discord/primitives/ChannelId;", "channelId", "J", "getChannelId", "()J", "Lcom/discord/api/report/ReportType;", "reportType", "Lcom/discord/api/report/ReportType;", "getReportType", "()Lcom/discord/api/report/ReportType;", "<init>", "(Lcom/discord/api/report/ReportType;J)V", "DirectoryServer", "GuildScheduledEvent", "Message", "StageChannel", "Lcom/discord/widgets/mobile_reports/MobileReportArgs$Message;", "Lcom/discord/widgets/mobile_reports/MobileReportArgs$StageChannel;", "Lcom/discord/widgets/mobile_reports/MobileReportArgs$DirectoryServer;", "Lcom/discord/widgets/mobile_reports/MobileReportArgs$GuildScheduledEvent;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.mobile_reports.MobileReportArgs, reason: use source file name */
/* loaded from: classes2.dex */
public abstract class WidgetMobileReports2 implements Parcelable {
    private final long channelId;
    private final ReportType reportType;

    /* compiled from: WidgetMobileReports.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\u0010\t\u001a\u00060\u0002j\u0002`\u0003\u0012\n\u0010\n\u001a\u00060\u0002j\u0002`\u0003\u0012\n\u0010\u000b\u001a\u00060\u0002j\u0002`\u0007¢\u0006\u0004\b$\u0010%J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0005J\u0014\u0010\b\u001a\u00060\u0002j\u0002`\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\u0005J:\u0010\f\u001a\u00020\u00002\f\b\u0002\u0010\t\u001a\u00060\u0002j\u0002`\u00032\f\b\u0002\u0010\n\u001a\u00060\u0002j\u0002`\u00032\f\b\u0002\u0010\u000b\u001a\u00060\u0002j\u0002`\u0007HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0013J \u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fR\u001d\u0010\n\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010 \u001a\u0004\b!\u0010\u0005R \u0010\u000b\u001a\u00060\u0002j\u0002`\u00078\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010 \u001a\u0004\b\"\u0010\u0005R\u001d\u0010\t\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010 \u001a\u0004\b#\u0010\u0005¨\u0006&"}, d2 = {"Lcom/discord/widgets/mobile_reports/MobileReportArgs$DirectoryServer;", "Lcom/discord/widgets/mobile_reports/MobileReportArgs;", "", "Lcom/discord/primitives/GuildId;", "component1", "()J", "component2", "Lcom/discord/primitives/ChannelId;", "component3", "guildId", "hubId", "channelId", "copy", "(JJJ)Lcom/discord/widgets/mobile_reports/MobileReportArgs$DirectoryServer;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "J", "getHubId", "getChannelId", "getGuildId", "<init>", "(JJJ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.mobile_reports.MobileReportArgs$DirectoryServer */
    public static final /* data */ class DirectoryServer extends WidgetMobileReports2 {
        public static final Parcelable.Creator<DirectoryServer> CREATOR = new Creator();
        private final long channelId;
        private final long guildId;
        private final long hubId;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.mobile_reports.MobileReportArgs$DirectoryServer$Creator */
        public static class Creator implements Parcelable.Creator<DirectoryServer> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final DirectoryServer createFromParcel(Parcel parcel) {
                Intrinsics3.checkNotNullParameter(parcel, "in");
                return new DirectoryServer(parcel.readLong(), parcel.readLong(), parcel.readLong());
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ DirectoryServer createFromParcel(Parcel parcel) {
                return createFromParcel(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final DirectoryServer[] newArray(int i) {
                return new DirectoryServer[i];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ DirectoryServer[] newArray(int i) {
                return newArray(i);
            }
        }

        public DirectoryServer(long j, long j2, long j3) {
            super(ReportType.DirectoryServer, j3, null);
            this.guildId = j;
            this.hubId = j2;
            this.channelId = j3;
        }

        public static /* synthetic */ DirectoryServer copy$default(DirectoryServer directoryServer, long j, long j2, long j3, int i, Object obj) {
            if ((i & 1) != 0) {
                j = directoryServer.guildId;
            }
            long j4 = j;
            if ((i & 2) != 0) {
                j2 = directoryServer.hubId;
            }
            long j5 = j2;
            if ((i & 4) != 0) {
                j3 = directoryServer.getChannelId();
            }
            return directoryServer.copy(j4, j5, j3);
        }

        /* renamed from: component1, reason: from getter */
        public final long getGuildId() {
            return this.guildId;
        }

        /* renamed from: component2, reason: from getter */
        public final long getHubId() {
            return this.hubId;
        }

        public final long component3() {
            return getChannelId();
        }

        public final DirectoryServer copy(long guildId, long hubId, long channelId) {
            return new DirectoryServer(guildId, hubId, channelId);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DirectoryServer)) {
                return false;
            }
            DirectoryServer directoryServer = (DirectoryServer) other;
            return this.guildId == directoryServer.guildId && this.hubId == directoryServer.hubId && getChannelId() == directoryServer.getChannelId();
        }

        @Override // com.discord.widgets.mobile_reports.WidgetMobileReports2
        public long getChannelId() {
            return this.channelId;
        }

        public final long getGuildId() {
            return this.guildId;
        }

        public final long getHubId() {
            return this.hubId;
        }

        public int hashCode() {
            return b.a(getChannelId()) + ((b.a(this.hubId) + (b.a(this.guildId) * 31)) * 31);
        }

        public String toString() {
            StringBuilder sbU = outline.U("DirectoryServer(guildId=");
            sbU.append(this.guildId);
            sbU.append(", hubId=");
            sbU.append(this.hubId);
            sbU.append(", channelId=");
            sbU.append(getChannelId());
            sbU.append(")");
            return sbU.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics3.checkNotNullParameter(parcel, "parcel");
            parcel.writeLong(this.guildId);
            parcel.writeLong(this.hubId);
            parcel.writeLong(this.channelId);
        }
    }

    /* compiled from: WidgetMobileReports.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\u0010\b\u001a\u00060\u0002j\u0002`\u0003\u0012\n\u0010\t\u001a\u00060\u0002j\u0002`\u0006¢\u0006\u0004\b!\u0010\"J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0007\u001a\u00060\u0002j\u0002`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0005J,\u0010\n\u001a\u00020\u00002\f\b\u0002\u0010\b\u001a\u00060\u0002j\u0002`\u00032\f\b\u0002\u0010\t\u001a\u00060\u0002j\u0002`\u0006HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0011J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u001d\u0010\t\u001a\u00060\u0002j\u0002`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u001e\u001a\u0004\b\u001f\u0010\u0005R\u001d\u0010\b\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u001e\u001a\u0004\b \u0010\u0005¨\u0006#"}, d2 = {"Lcom/discord/widgets/mobile_reports/MobileReportArgs$GuildScheduledEvent;", "Lcom/discord/widgets/mobile_reports/MobileReportArgs;", "", "Lcom/discord/primitives/GuildId;", "component1", "()J", "Lcom/discord/primitives/GuildScheduledEventId;", "component2", "guildId", "eventId", "copy", "(JJ)Lcom/discord/widgets/mobile_reports/MobileReportArgs$GuildScheduledEvent;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "J", "getEventId", "getGuildId", "<init>", "(JJ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.mobile_reports.MobileReportArgs$GuildScheduledEvent */
    public static final /* data */ class GuildScheduledEvent extends WidgetMobileReports2 {
        public static final Parcelable.Creator<GuildScheduledEvent> CREATOR = new Creator();
        private final long eventId;
        private final long guildId;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.mobile_reports.MobileReportArgs$GuildScheduledEvent$Creator */
        public static class Creator implements Parcelable.Creator<GuildScheduledEvent> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final GuildScheduledEvent createFromParcel(Parcel parcel) {
                Intrinsics3.checkNotNullParameter(parcel, "in");
                return new GuildScheduledEvent(parcel.readLong(), parcel.readLong());
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ GuildScheduledEvent createFromParcel(Parcel parcel) {
                return createFromParcel(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final GuildScheduledEvent[] newArray(int i) {
                return new GuildScheduledEvent[i];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ GuildScheduledEvent[] newArray(int i) {
                return newArray(i);
            }
        }

        public GuildScheduledEvent(long j, long j2) {
            super(ReportType.GuildScheduledEvent, -1L, null);
            this.guildId = j;
            this.eventId = j2;
        }

        public static /* synthetic */ GuildScheduledEvent copy$default(GuildScheduledEvent guildScheduledEvent, long j, long j2, int i, Object obj) {
            if ((i & 1) != 0) {
                j = guildScheduledEvent.guildId;
            }
            if ((i & 2) != 0) {
                j2 = guildScheduledEvent.eventId;
            }
            return guildScheduledEvent.copy(j, j2);
        }

        /* renamed from: component1, reason: from getter */
        public final long getGuildId() {
            return this.guildId;
        }

        /* renamed from: component2, reason: from getter */
        public final long getEventId() {
            return this.eventId;
        }

        public final GuildScheduledEvent copy(long guildId, long eventId) {
            return new GuildScheduledEvent(guildId, eventId);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GuildScheduledEvent)) {
                return false;
            }
            GuildScheduledEvent guildScheduledEvent = (GuildScheduledEvent) other;
            return this.guildId == guildScheduledEvent.guildId && this.eventId == guildScheduledEvent.eventId;
        }

        public final long getEventId() {
            return this.eventId;
        }

        public final long getGuildId() {
            return this.guildId;
        }

        public int hashCode() {
            return b.a(this.eventId) + (b.a(this.guildId) * 31);
        }

        public String toString() {
            StringBuilder sbU = outline.U("GuildScheduledEvent(guildId=");
            sbU.append(this.guildId);
            sbU.append(", eventId=");
            return outline.C(sbU, this.eventId, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics3.checkNotNullParameter(parcel, "parcel");
            parcel.writeLong(this.guildId);
            parcel.writeLong(this.eventId);
        }
    }

    /* compiled from: WidgetMobileReports.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\u0010\b\u001a\u00060\u0002j\u0002`\u0003\u0012\n\u0010\t\u001a\u00060\u0002j\u0002`\u0006¢\u0006\u0004\b!\u0010\"J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0007\u001a\u00060\u0002j\u0002`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0005J,\u0010\n\u001a\u00020\u00002\f\b\u0002\u0010\b\u001a\u00060\u0002j\u0002`\u00032\f\b\u0002\u0010\t\u001a\u00060\u0002j\u0002`\u0006HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0011J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR \u0010\t\u001a\u00060\u0002j\u0002`\u00068\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\u001e\u001a\u0004\b\u001f\u0010\u0005R\u001d\u0010\b\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u001e\u001a\u0004\b \u0010\u0005¨\u0006#"}, d2 = {"Lcom/discord/widgets/mobile_reports/MobileReportArgs$Message;", "Lcom/discord/widgets/mobile_reports/MobileReportArgs;", "", "Lcom/discord/primitives/MessageId;", "component1", "()J", "Lcom/discord/primitives/ChannelId;", "component2", "messageId", "channelId", "copy", "(JJ)Lcom/discord/widgets/mobile_reports/MobileReportArgs$Message;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "J", "getChannelId", "getMessageId", "<init>", "(JJ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.mobile_reports.MobileReportArgs$Message */
    public static final /* data */ class Message extends WidgetMobileReports2 {
        public static final Parcelable.Creator<Message> CREATOR = new Creator();
        private final long channelId;
        private final long messageId;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.mobile_reports.MobileReportArgs$Message$Creator */
        public static class Creator implements Parcelable.Creator<Message> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Message createFromParcel(Parcel parcel) {
                Intrinsics3.checkNotNullParameter(parcel, "in");
                return new Message(parcel.readLong(), parcel.readLong());
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Message createFromParcel(Parcel parcel) {
                return createFromParcel(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Message[] newArray(int i) {
                return new Message[i];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Message[] newArray(int i) {
                return newArray(i);
            }
        }

        public Message(long j, long j2) {
            super(ReportType.Message, j2, null);
            this.messageId = j;
            this.channelId = j2;
        }

        public static /* synthetic */ Message copy$default(Message message, long j, long j2, int i, Object obj) {
            if ((i & 1) != 0) {
                j = message.messageId;
            }
            if ((i & 2) != 0) {
                j2 = message.getChannelId();
            }
            return message.copy(j, j2);
        }

        /* renamed from: component1, reason: from getter */
        public final long getMessageId() {
            return this.messageId;
        }

        public final long component2() {
            return getChannelId();
        }

        public final Message copy(long messageId, long channelId) {
            return new Message(messageId, channelId);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Message)) {
                return false;
            }
            Message message = (Message) other;
            return this.messageId == message.messageId && getChannelId() == message.getChannelId();
        }

        @Override // com.discord.widgets.mobile_reports.WidgetMobileReports2
        public long getChannelId() {
            return this.channelId;
        }

        public final long getMessageId() {
            return this.messageId;
        }

        public int hashCode() {
            return b.a(getChannelId()) + (b.a(this.messageId) * 31);
        }

        public String toString() {
            StringBuilder sbU = outline.U("Message(messageId=");
            sbU.append(this.messageId);
            sbU.append(", channelId=");
            sbU.append(getChannelId());
            sbU.append(")");
            return sbU.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics3.checkNotNullParameter(parcel, "parcel");
            parcel.writeLong(this.messageId);
            parcel.writeLong(this.channelId);
        }
    }

    /* compiled from: WidgetMobileReports.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0007\u001a\u00020\u00002\f\b\u0002\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0014\u0010\u000eJ \u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aR \u0010\u0006\u001a\u00060\u0002j\u0002`\u00038\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001b\u001a\u0004\b\u001c\u0010\u0005¨\u0006\u001f"}, d2 = {"Lcom/discord/widgets/mobile_reports/MobileReportArgs$StageChannel;", "Lcom/discord/widgets/mobile_reports/MobileReportArgs;", "", "Lcom/discord/primitives/ChannelId;", "component1", "()J", "channelId", "copy", "(J)Lcom/discord/widgets/mobile_reports/MobileReportArgs$StageChannel;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "J", "getChannelId", "<init>", "(J)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.mobile_reports.MobileReportArgs$StageChannel */
    public static final /* data */ class StageChannel extends WidgetMobileReports2 {
        public static final Parcelable.Creator<StageChannel> CREATOR = new Creator();
        private final long channelId;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.mobile_reports.MobileReportArgs$StageChannel$Creator */
        public static class Creator implements Parcelable.Creator<StageChannel> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final StageChannel createFromParcel(Parcel parcel) {
                Intrinsics3.checkNotNullParameter(parcel, "in");
                return new StageChannel(parcel.readLong());
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ StageChannel createFromParcel(Parcel parcel) {
                return createFromParcel(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final StageChannel[] newArray(int i) {
                return new StageChannel[i];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ StageChannel[] newArray(int i) {
                return newArray(i);
            }
        }

        public StageChannel(long j) {
            super(ReportType.StageChannel, j, null);
            this.channelId = j;
        }

        public static /* synthetic */ StageChannel copy$default(StageChannel stageChannel, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                j = stageChannel.getChannelId();
            }
            return stageChannel.copy(j);
        }

        public final long component1() {
            return getChannelId();
        }

        public final StageChannel copy(long channelId) {
            return new StageChannel(channelId);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof StageChannel) && getChannelId() == ((StageChannel) other).getChannelId();
            }
            return true;
        }

        @Override // com.discord.widgets.mobile_reports.WidgetMobileReports2
        public long getChannelId() {
            return this.channelId;
        }

        public int hashCode() {
            return b.a(getChannelId());
        }

        public String toString() {
            StringBuilder sbU = outline.U("StageChannel(channelId=");
            sbU.append(getChannelId());
            sbU.append(")");
            return sbU.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics3.checkNotNullParameter(parcel, "parcel");
            parcel.writeLong(this.channelId);
        }
    }

    private WidgetMobileReports2(ReportType reportType, long j) {
        this.reportType = reportType;
        this.channelId = j;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public final ReportType getReportType() {
        return this.reportType;
    }

    public /* synthetic */ WidgetMobileReports2(ReportType reportType, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(reportType, j);
    }
}
