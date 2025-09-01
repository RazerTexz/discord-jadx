package com.discord.widgets.channels.settings;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelNotificationSettings;
import d0.z.d.Intrinsics3;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ChannelSettings.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB!\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ0\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0010\u0010\nJ\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0015\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u0017\u001a\u0004\b\u0018\u0010\nR\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004R\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\f\u0010\u0007¨\u0006\u001f"}, d2 = {"Lcom/discord/widgets/channels/settings/ChannelSettings;", "", "Lcom/discord/api/channel/Channel;", "component1", "()Lcom/discord/api/channel/Channel;", "", "component2", "()Z", "", "component3", "()Ljava/lang/String;", "channel", "isMuted", "muteEndTime", "copy", "(Lcom/discord/api/channel/Channel;ZLjava/lang/String;)Lcom/discord/widgets/channels/settings/ChannelSettings;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getMuteEndTime", "Lcom/discord/api/channel/Channel;", "getChannel", "Z", "<init>", "(Lcom/discord/api/channel/Channel;ZLjava/lang/String;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class ChannelSettings {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Channel channel;
    private final boolean isMuted;
    private final String muteEndTime;

    /* compiled from: ChannelSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/discord/widgets/channels/settings/ChannelSettings$Companion;", "", "Lcom/discord/api/channel/Channel;", "channel", "Lcom/discord/models/domain/ModelNotificationSettings;", "notificationSettings", "Lcom/discord/widgets/channels/settings/ChannelSettings;", "createFromNotificationSettings", "(Lcom/discord/api/channel/Channel;Lcom/discord/models/domain/ModelNotificationSettings;)Lcom/discord/widgets/channels/settings/ChannelSettings;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final ChannelSettings createFromNotificationSettings(Channel channel, ModelNotificationSettings notificationSettings) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Intrinsics3.checkNotNullParameter(notificationSettings, "notificationSettings");
            boolean zIsMuted = notificationSettings.isMuted();
            String muteEndTime = notificationSettings.getMuteEndTime();
            Iterator<ModelNotificationSettings.ChannelOverride> it = notificationSettings.getChannelOverrides().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ModelNotificationSettings.ChannelOverride next = it.next();
                Intrinsics3.checkNotNullExpressionValue(next, "override");
                if (next.getChannelId() == channel.getId()) {
                    zIsMuted = next.isMuted();
                    muteEndTime = next.getMuteEndTime();
                    break;
                }
            }
            return new ChannelSettings(channel, zIsMuted, muteEndTime);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ChannelSettings(Channel channel, boolean z2, String str) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        this.channel = channel;
        this.isMuted = z2;
        this.muteEndTime = str;
    }

    public static /* synthetic */ ChannelSettings copy$default(ChannelSettings channelSettings, Channel channel, boolean z2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            channel = channelSettings.channel;
        }
        if ((i & 2) != 0) {
            z2 = channelSettings.isMuted;
        }
        if ((i & 4) != 0) {
            str = channelSettings.muteEndTime;
        }
        return channelSettings.copy(channel, z2, str);
    }

    /* renamed from: component1, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsMuted() {
        return this.isMuted;
    }

    /* renamed from: component3, reason: from getter */
    public final String getMuteEndTime() {
        return this.muteEndTime;
    }

    public final ChannelSettings copy(Channel channel, boolean isMuted, String muteEndTime) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        return new ChannelSettings(channel, isMuted, muteEndTime);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelSettings)) {
            return false;
        }
        ChannelSettings channelSettings = (ChannelSettings) other;
        return Intrinsics3.areEqual(this.channel, channelSettings.channel) && this.isMuted == channelSettings.isMuted && Intrinsics3.areEqual(this.muteEndTime, channelSettings.muteEndTime);
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final String getMuteEndTime() {
        return this.muteEndTime;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        Channel channel = this.channel;
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        boolean z2 = this.isMuted;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iHashCode + i) * 31;
        String str = this.muteEndTime;
        return i2 + (str != null ? str.hashCode() : 0);
    }

    public final boolean isMuted() {
        return this.isMuted;
    }

    public String toString() {
        StringBuilder sbU = outline.U("ChannelSettings(channel=");
        sbU.append(this.channel);
        sbU.append(", isMuted=");
        sbU.append(this.isMuted);
        sbU.append(", muteEndTime=");
        return outline.J(sbU, this.muteEndTime, ")");
    }
}
