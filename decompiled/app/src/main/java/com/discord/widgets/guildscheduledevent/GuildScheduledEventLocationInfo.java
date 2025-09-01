package com.discord.widgets.guildscheduledevent;

import androidx.annotation.DrawableRes;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityMetadata;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityType;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: GuildScheduledEventLocationInfo.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00102\u00020\u0001:\u0003\u0011\u0010\u0012B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0003¢\u0006\u0004\b\u0007\u0010\u0006J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\r\u0010\f\u0082\u0001\u0002\u0013\u0014¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventLocationInfo;", "", "Lcom/discord/api/channel/Channel;", "channel", "", "getChannelIcon", "(Lcom/discord/api/channel/Channel;)I", "getChannelIconSmall", "", "getLocationName", "()Ljava/lang/String;", "getLocationIcon", "()I", "getLocationIconSmall", "<init>", "()V", "Companion", "ChannelLocation", "ExternalLocation", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventLocationInfo$ChannelLocation;", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventLocationInfo$ExternalLocation;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public abstract class GuildScheduledEventLocationInfo {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: GuildScheduledEventLocationInfo.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventLocationInfo$ChannelLocation;", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventLocationInfo;", "Lcom/discord/api/channel/Channel;", "component1", "()Lcom/discord/api/channel/Channel;", "channel", "copy", "(Lcom/discord/api/channel/Channel;)Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventLocationInfo$ChannelLocation;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/channel/Channel;", "getChannel", "<init>", "(Lcom/discord/api/channel/Channel;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ChannelLocation extends GuildScheduledEventLocationInfo {
        private final Channel channel;

        public ChannelLocation(Channel channel) {
            super(null);
            this.channel = channel;
        }

        public static /* synthetic */ ChannelLocation copy$default(ChannelLocation channelLocation, Channel channel, int i, Object obj) {
            if ((i & 1) != 0) {
                channel = channelLocation.channel;
            }
            return channelLocation.copy(channel);
        }

        /* renamed from: component1, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        public final ChannelLocation copy(Channel channel) {
            return new ChannelLocation(channel);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof ChannelLocation) && Intrinsics3.areEqual(this.channel, ((ChannelLocation) other).channel);
            }
            return true;
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public int hashCode() {
            Channel channel = this.channel;
            if (channel != null) {
                return channel.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ChannelLocation(channel=");
            sbU.append(this.channel);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: GuildScheduledEventLocationInfo.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventLocationInfo$Companion;", "", "Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "guildScheduledEvent", "Lcom/discord/api/channel/Channel;", "channel", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventLocationInfo;", "buildLocationInfo", "(Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;Lcom/discord/api/channel/Channel;)Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventLocationInfo;", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventModel;", "guildScheduledEventModel", "(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventModel;Lcom/discord/api/channel/Channel;)Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventLocationInfo;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final GuildScheduledEventLocationInfo buildLocationInfo(GuildScheduledEvent guildScheduledEvent, Channel channel) {
            String location;
            Intrinsics3.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
            if (guildScheduledEvent.getEntityType() != GuildScheduledEventEntityType.EXTERNAL) {
                return new ChannelLocation(channel);
            }
            GuildScheduledEventEntityMetadata entityMetadata = guildScheduledEvent.getEntityMetadata();
            if (entityMetadata == null || (location = entityMetadata.getLocation()) == null) {
                location = "";
            }
            return new ExternalLocation(location);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final GuildScheduledEventLocationInfo buildLocationInfo(GuildScheduledEventModel guildScheduledEventModel, Channel channel) {
            String location;
            Intrinsics3.checkNotNullParameter(guildScheduledEventModel, "guildScheduledEventModel");
            if (guildScheduledEventModel.getEntityType() == GuildScheduledEventEntityType.EXTERNAL) {
                GuildScheduledEventEntityMetadata entityMetadata = guildScheduledEventModel.getEntityMetadata();
                if (entityMetadata == null || (location = entityMetadata.getLocation()) == null) {
                    location = "";
                }
                return new ExternalLocation(location);
            }
            return new ChannelLocation(channel);
        }
    }

    /* compiled from: GuildScheduledEventLocationInfo.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventLocationInfo$ExternalLocation;", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventLocationInfo;", "", "component1", "()Ljava/lang/String;", ModelAuditLogEntry.CHANGE_KEY_LOCATION, "copy", "(Ljava/lang/String;)Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventLocationInfo$ExternalLocation;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getLocation", "<init>", "(Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ExternalLocation extends GuildScheduledEventLocationInfo {
        private final String location;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ExternalLocation(String str) {
            super(null);
            Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
            this.location = str;
        }

        public static /* synthetic */ ExternalLocation copy$default(ExternalLocation externalLocation, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = externalLocation.location;
            }
            return externalLocation.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getLocation() {
            return this.location;
        }

        public final ExternalLocation copy(String location) {
            Intrinsics3.checkNotNullParameter(location, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
            return new ExternalLocation(location);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof ExternalLocation) && Intrinsics3.areEqual(this.location, ((ExternalLocation) other).location);
            }
            return true;
        }

        public final String getLocation() {
            return this.location;
        }

        public int hashCode() {
            String str = this.location;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public String toString() {
            return outline.J(outline.U("ExternalLocation(location="), this.location, ")");
        }
    }

    private GuildScheduledEventLocationInfo() {
    }

    @DrawableRes
    private final int getChannelIcon(Channel channel) {
        Integer numValueOf = channel != null ? Integer.valueOf(channel.getType()) : null;
        return ((numValueOf != null && numValueOf.intValue() == 2) || numValueOf == null || numValueOf.intValue() != 13) ? R.drawable.ic_channel_voice : R.drawable.ic_stage_20dp;
    }

    @DrawableRes
    private final int getChannelIconSmall(Channel channel) {
        Integer numValueOf = channel != null ? Integer.valueOf(channel.getType()) : null;
        return ((numValueOf != null && numValueOf.intValue() == 2) || numValueOf == null || numValueOf.intValue() != 13) ? R.drawable.ic_channel_voice_16dp : R.drawable.ic_channel_stage_16dp;
    }

    @DrawableRes
    public final int getLocationIcon() {
        if (this instanceof ChannelLocation) {
            return getChannelIcon(((ChannelLocation) this).getChannel());
        }
        if (this instanceof ExternalLocation) {
            return R.drawable.ic_location_24dp;
        }
        throw new NoWhenBranchMatchedException();
    }

    @DrawableRes
    public final int getLocationIconSmall() {
        if (this instanceof ChannelLocation) {
            return getChannelIconSmall(((ChannelLocation) this).getChannel());
        }
        if (this instanceof ExternalLocation) {
            return R.drawable.ic_location_16dp;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final String getLocationName() {
        String name;
        if (this instanceof ChannelLocation) {
            Channel channel = ((ChannelLocation) this).getChannel();
            return (channel == null || (name = channel.getName()) == null) ? "" : name;
        }
        if (this instanceof ExternalLocation) {
            return ((ExternalLocation) this).getLocation();
        }
        throw new NoWhenBranchMatchedException();
    }

    public /* synthetic */ GuildScheduledEventLocationInfo(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
