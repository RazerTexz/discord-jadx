package com.discord.widgets.guildscheduledevent;

import a0.a.a.b;
import android.os.Parcel;
import android.os.Parcelable;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0005\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\n¢\u0006\u0004\b,\u0010-J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0006\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\t\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\bHÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJH\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\u0010\b\u0002\u0010\u000e\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00052\u0010\b\u0002\u0010\u000f\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\b2\b\b\u0002\u0010\u0010\u001a\u00020\nHÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0018J \u0010#\u001a\u00020\"2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b#\u0010$R\u0019\u0010\u0010\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010%\u001a\u0004\b&\u0010\fR\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010'\u001a\u0004\b(\u0010\u0004R!\u0010\u000e\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010)\u001a\u0004\b*\u0010\u0007R!\u0010\u000f\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010)\u001a\u0004\b+\u0010\u0007¨\u0006."}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDetailsArgs;", "Landroid/os/Parcelable;", "", "component1", "()J", "Lcom/discord/primitives/GuildId;", "component2", "()Ljava/lang/Long;", "Lcom/discord/primitives/ChannelId;", "component3", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDetailsSource;", "component4", "()Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDetailsSource;", "eventId", "guildId", "channelId", "source", "copy", "(JLjava/lang/Long;Ljava/lang/Long;Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDetailsSource;)Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDetailsArgs;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDetailsSource;", "getSource", "J", "getEventId", "Ljava/lang/Long;", "getGuildId", "getChannelId", "<init>", "(JLjava/lang/Long;Ljava/lang/Long;Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDetailsSource;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventDetailsArgs, reason: use source file name */
/* loaded from: classes2.dex */
public final /* data */ class WidgetGuildScheduledEventDetailsBottomSheet2 implements Parcelable {
    public static final Parcelable.Creator<WidgetGuildScheduledEventDetailsBottomSheet2> CREATOR = new Creator();
    private final Long channelId;
    private final long eventId;
    private final Long guildId;
    private final WidgetGuildScheduledEventDetailsBottomSheet3 source;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventDetailsArgs$Creator */
    public static class Creator implements Parcelable.Creator<WidgetGuildScheduledEventDetailsBottomSheet2> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetGuildScheduledEventDetailsBottomSheet2 createFromParcel(Parcel parcel) {
            Intrinsics3.checkNotNullParameter(parcel, "in");
            return new WidgetGuildScheduledEventDetailsBottomSheet2(parcel.readLong(), parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null, parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null, (WidgetGuildScheduledEventDetailsBottomSheet3) Enum.valueOf(WidgetGuildScheduledEventDetailsBottomSheet3.class, parcel.readString()));
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ WidgetGuildScheduledEventDetailsBottomSheet2 createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetGuildScheduledEventDetailsBottomSheet2[] newArray(int i) {
            return new WidgetGuildScheduledEventDetailsBottomSheet2[i];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ WidgetGuildScheduledEventDetailsBottomSheet2[] newArray(int i) {
            return newArray(i);
        }
    }

    public WidgetGuildScheduledEventDetailsBottomSheet2(long j, Long l, Long l2, WidgetGuildScheduledEventDetailsBottomSheet3 widgetGuildScheduledEventDetailsBottomSheet3) {
        Intrinsics3.checkNotNullParameter(widgetGuildScheduledEventDetailsBottomSheet3, "source");
        this.eventId = j;
        this.guildId = l;
        this.channelId = l2;
        this.source = widgetGuildScheduledEventDetailsBottomSheet3;
    }

    public static /* synthetic */ WidgetGuildScheduledEventDetailsBottomSheet2 copy$default(WidgetGuildScheduledEventDetailsBottomSheet2 widgetGuildScheduledEventDetailsBottomSheet2, long j, Long l, Long l2, WidgetGuildScheduledEventDetailsBottomSheet3 widgetGuildScheduledEventDetailsBottomSheet3, int i, Object obj) {
        if ((i & 1) != 0) {
            j = widgetGuildScheduledEventDetailsBottomSheet2.eventId;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            l = widgetGuildScheduledEventDetailsBottomSheet2.guildId;
        }
        Long l3 = l;
        if ((i & 4) != 0) {
            l2 = widgetGuildScheduledEventDetailsBottomSheet2.channelId;
        }
        Long l4 = l2;
        if ((i & 8) != 0) {
            widgetGuildScheduledEventDetailsBottomSheet3 = widgetGuildScheduledEventDetailsBottomSheet2.source;
        }
        return widgetGuildScheduledEventDetailsBottomSheet2.copy(j2, l3, l4, widgetGuildScheduledEventDetailsBottomSheet3);
    }

    /* renamed from: component1, reason: from getter */
    public final long getEventId() {
        return this.eventId;
    }

    /* renamed from: component2, reason: from getter */
    public final Long getGuildId() {
        return this.guildId;
    }

    /* renamed from: component3, reason: from getter */
    public final Long getChannelId() {
        return this.channelId;
    }

    /* renamed from: component4, reason: from getter */
    public final WidgetGuildScheduledEventDetailsBottomSheet3 getSource() {
        return this.source;
    }

    public final WidgetGuildScheduledEventDetailsBottomSheet2 copy(long eventId, Long guildId, Long channelId, WidgetGuildScheduledEventDetailsBottomSheet3 source) {
        Intrinsics3.checkNotNullParameter(source, "source");
        return new WidgetGuildScheduledEventDetailsBottomSheet2(eventId, guildId, channelId, source);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetGuildScheduledEventDetailsBottomSheet2)) {
            return false;
        }
        WidgetGuildScheduledEventDetailsBottomSheet2 widgetGuildScheduledEventDetailsBottomSheet2 = (WidgetGuildScheduledEventDetailsBottomSheet2) other;
        return this.eventId == widgetGuildScheduledEventDetailsBottomSheet2.eventId && Intrinsics3.areEqual(this.guildId, widgetGuildScheduledEventDetailsBottomSheet2.guildId) && Intrinsics3.areEqual(this.channelId, widgetGuildScheduledEventDetailsBottomSheet2.channelId) && Intrinsics3.areEqual(this.source, widgetGuildScheduledEventDetailsBottomSheet2.source);
    }

    public final Long getChannelId() {
        return this.channelId;
    }

    public final long getEventId() {
        return this.eventId;
    }

    public final Long getGuildId() {
        return this.guildId;
    }

    public final WidgetGuildScheduledEventDetailsBottomSheet3 getSource() {
        return this.source;
    }

    public int hashCode() {
        int iA = b.a(this.eventId) * 31;
        Long l = this.guildId;
        int iHashCode = (iA + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.channelId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        WidgetGuildScheduledEventDetailsBottomSheet3 widgetGuildScheduledEventDetailsBottomSheet3 = this.source;
        return iHashCode2 + (widgetGuildScheduledEventDetailsBottomSheet3 != null ? widgetGuildScheduledEventDetailsBottomSheet3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildScheduledEventDetailsArgs(eventId=");
        sbU.append(this.eventId);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", source=");
        sbU.append(this.source);
        sbU.append(")");
        return sbU.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics3.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.eventId);
        Long l = this.guildId;
        if (l != null) {
            parcel.writeInt(1);
            parcel.writeLong(l.longValue());
        } else {
            parcel.writeInt(0);
        }
        Long l2 = this.channelId;
        if (l2 != null) {
            parcel.writeInt(1);
            parcel.writeLong(l2.longValue());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.source.name());
    }

    public /* synthetic */ WidgetGuildScheduledEventDetailsBottomSheet2(long j, Long l, Long l2, WidgetGuildScheduledEventDetailsBottomSheet3 widgetGuildScheduledEventDetailsBottomSheet3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : l2, (i & 8) != 0 ? WidgetGuildScheduledEventDetailsBottomSheet3.Guild : widgetGuildScheduledEventDetailsBottomSheet3);
    }
}
