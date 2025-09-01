package com.discord.widgets.voice.fullscreen.stage;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.role.GuildRole;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.views.calls.VideoCallParticipantView;
import com.discord.widgets.voice.fullscreen.CallParticipant;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: StageCallItem.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u000e2\u00020\u0001:\t\u000f\u0010\u000e\u0011\u0012\u0013\u0014\u0015\u0016B\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u0003\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\u0082\u0001\u0007\u0017\u0018\u0019\u001a\u001b\u001c\u001d¨\u0006\u001e"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/stage/StageCallItem;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "", "key", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "", "type", "I", "getType", "()I", "<init>", "(Ljava/lang/String;I)V", "Companion", "AudienceHeaderItem", "AudienceItem", "DetailsItem", "DividerItem", "MediaItem", "MediaType", "PreStartDetailsItem", "SpeakerItem", "Lcom/discord/widgets/voice/fullscreen/stage/StageCallItem$DetailsItem;", "Lcom/discord/widgets/voice/fullscreen/stage/StageCallItem$PreStartDetailsItem;", "Lcom/discord/widgets/voice/fullscreen/stage/StageCallItem$MediaItem;", "Lcom/discord/widgets/voice/fullscreen/stage/StageCallItem$SpeakerItem;", "Lcom/discord/widgets/voice/fullscreen/stage/StageCallItem$AudienceHeaderItem;", "Lcom/discord/widgets/voice/fullscreen/stage/StageCallItem$AudienceItem;", "Lcom/discord/widgets/voice/fullscreen/stage/StageCallItem$DividerItem;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public abstract class StageCallItem implements MGRecyclerDataPayload {
    public static final int TYPE_AUDIENCE = 3;
    public static final int TYPE_AUDIENCE_HEADER = 2;
    public static final int TYPE_DETAILS = 0;
    public static final int TYPE_DIVIDER = 4;
    public static final int TYPE_MEDIA = 6;
    public static final int TYPE_PRESTART_DETAILS = 5;
    public static final int TYPE_SPEAKER = 1;
    private final String key;
    private final int type;

    /* compiled from: StageCallItem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\u0004J\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/stage/StageCallItem$AudienceHeaderItem;", "Lcom/discord/widgets/voice/fullscreen/stage/StageCallItem;", "", "component1", "()I", "audienceSize", "copy", "(I)Lcom/discord/widgets/voice/fullscreen/stage/StageCallItem$AudienceHeaderItem;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getAudienceSize", "<init>", "(I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class AudienceHeaderItem extends StageCallItem {
        private final int audienceSize;

        public AudienceHeaderItem(int i) {
            super("audience-header", 2, null);
            this.audienceSize = i;
        }

        public static /* synthetic */ AudienceHeaderItem copy$default(AudienceHeaderItem audienceHeaderItem, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = audienceHeaderItem.audienceSize;
            }
            return audienceHeaderItem.copy(i);
        }

        /* renamed from: component1, reason: from getter */
        public final int getAudienceSize() {
            return this.audienceSize;
        }

        public final AudienceHeaderItem copy(int audienceSize) {
            return new AudienceHeaderItem(audienceSize);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof AudienceHeaderItem) && this.audienceSize == ((AudienceHeaderItem) other).audienceSize;
            }
            return true;
        }

        public final int getAudienceSize() {
            return this.audienceSize;
        }

        public int hashCode() {
            return this.audienceSize;
        }

        public String toString() {
            return outline.B(outline.U("AudienceHeaderItem(audienceSize="), this.audienceSize, ")");
        }
    }

    /* compiled from: StageCallItem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00000\u0003B)\u0012\u0006\u0010\u0014\u001a\u00020\b\u0012\u0006\u0010\u0015\u001a\u00020\u000b\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u0017\u001a\u00020\u0011¢\u0006\u0004\b)\u0010*J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J:\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0014\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\u000b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0017\u001a\u00020\u0011HÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010 \u001a\u00020\u00112\b\u0010\u0004\u001a\u0004\u0018\u00010\u001fHÖ\u0003¢\u0006\u0004\b \u0010!R\u001c\u0010\u0015\u001a\u00020\u000b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0015\u0010\"\u001a\u0004\b#\u0010\rR\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010$\u001a\u0004\b%\u0010\u0010R\u0019\u0010\u0017\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010&\u001a\u0004\b\u0017\u0010\u0013R\u001c\u0010\u0014\u001a\u00020\b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010'\u001a\u0004\b(\u0010\n¨\u0006+"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/stage/StageCallItem$AudienceItem;", "Lcom/discord/widgets/voice/fullscreen/stage/StageCallItem;", "Lcom/discord/widgets/voice/fullscreen/stage/StageCallParticipantItem;", "", "other", "", "compareTo", "(Lcom/discord/widgets/voice/fullscreen/stage/StageCallItem$AudienceItem;)I", "Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;", "component1", "()Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;", "Lcom/discord/api/channel/Channel;", "component2", "()Lcom/discord/api/channel/Channel;", "Lcom/discord/api/role/GuildRole;", "component3", "()Lcom/discord/api/role/GuildRole;", "", "component4", "()Z", "voiceUser", "channel", "hoistedGuildRole", "isBlocked", "copy", "(Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;Lcom/discord/api/channel/Channel;Lcom/discord/api/role/GuildRole;Z)Lcom/discord/widgets/voice/fullscreen/stage/StageCallItem$AudienceItem;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/channel/Channel;", "getChannel", "Lcom/discord/api/role/GuildRole;", "getHoistedGuildRole", "Z", "Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;", "getVoiceUser", "<init>", "(Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;Lcom/discord/api/channel/Channel;Lcom/discord/api/role/GuildRole;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class AudienceItem extends StageCallItem implements StageCallItem2, Comparable<AudienceItem> {
        private final Channel channel;
        private final GuildRole hoistedGuildRole;
        private final boolean isBlocked;
        private final StoreVoiceParticipants.VoiceUser voiceUser;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AudienceItem(StoreVoiceParticipants.VoiceUser voiceUser, Channel channel, GuildRole guildRole, boolean z2) {
            super("audience-" + voiceUser.getUser().getId(), 3, null);
            Intrinsics3.checkNotNullParameter(voiceUser, "voiceUser");
            Intrinsics3.checkNotNullParameter(channel, "channel");
            this.voiceUser = voiceUser;
            this.channel = channel;
            this.hoistedGuildRole = guildRole;
            this.isBlocked = z2;
        }

        public static /* synthetic */ AudienceItem copy$default(AudienceItem audienceItem, StoreVoiceParticipants.VoiceUser voiceUser, Channel channel, GuildRole guildRole, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                voiceUser = audienceItem.getVoiceUser();
            }
            if ((i & 2) != 0) {
                channel = audienceItem.getChannel();
            }
            if ((i & 4) != 0) {
                guildRole = audienceItem.hoistedGuildRole;
            }
            if ((i & 8) != 0) {
                z2 = audienceItem.isBlocked;
            }
            return audienceItem.copy(voiceUser, channel, guildRole, z2);
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(AudienceItem audienceItem) {
            return compareTo2(audienceItem);
        }

        public final StoreVoiceParticipants.VoiceUser component1() {
            return getVoiceUser();
        }

        public final Channel component2() {
            return getChannel();
        }

        /* renamed from: component3, reason: from getter */
        public final GuildRole getHoistedGuildRole() {
            return this.hoistedGuildRole;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getIsBlocked() {
            return this.isBlocked;
        }

        public final AudienceItem copy(StoreVoiceParticipants.VoiceUser voiceUser, Channel channel, GuildRole hoistedGuildRole, boolean isBlocked) {
            Intrinsics3.checkNotNullParameter(voiceUser, "voiceUser");
            Intrinsics3.checkNotNullParameter(channel, "channel");
            return new AudienceItem(voiceUser, channel, hoistedGuildRole, isBlocked);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AudienceItem)) {
                return false;
            }
            AudienceItem audienceItem = (AudienceItem) other;
            return Intrinsics3.areEqual(getVoiceUser(), audienceItem.getVoiceUser()) && Intrinsics3.areEqual(getChannel(), audienceItem.getChannel()) && Intrinsics3.areEqual(this.hoistedGuildRole, audienceItem.hoistedGuildRole) && this.isBlocked == audienceItem.isBlocked;
        }

        @Override // com.discord.widgets.voice.fullscreen.stage.StageCallItem2
        public Channel getChannel() {
            return this.channel;
        }

        public final GuildRole getHoistedGuildRole() {
            return this.hoistedGuildRole;
        }

        @Override // com.discord.widgets.voice.fullscreen.stage.StageCallItem2
        public StoreVoiceParticipants.VoiceUser getVoiceUser() {
            return this.voiceUser;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            StoreVoiceParticipants.VoiceUser voiceUser = getVoiceUser();
            int iHashCode = (voiceUser != null ? voiceUser.hashCode() : 0) * 31;
            Channel channel = getChannel();
            int iHashCode2 = (iHashCode + (channel != null ? channel.hashCode() : 0)) * 31;
            GuildRole guildRole = this.hoistedGuildRole;
            int iHashCode3 = (iHashCode2 + (guildRole != null ? guildRole.hashCode() : 0)) * 31;
            boolean z2 = this.isBlocked;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode3 + i;
        }

        public final boolean isBlocked() {
            return this.isBlocked;
        }

        public String toString() {
            StringBuilder sbU = outline.U("AudienceItem(voiceUser=");
            sbU.append(getVoiceUser());
            sbU.append(", channel=");
            sbU.append(getChannel());
            sbU.append(", hoistedGuildRole=");
            sbU.append(this.hoistedGuildRole);
            sbU.append(", isBlocked=");
            return outline.O(sbU, this.isBlocked, ")");
        }

        /* renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(AudienceItem other) {
            Intrinsics3.checkNotNullParameter(other, "other");
            return RoleUtils.getROLE_COMPARATOR().compare(this.hoistedGuildRole, other.hoistedGuildRole);
        }
    }

    /* compiled from: StageCallItem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\u0006\u0010\u0012\u001a\u00020\u0006\u0012\u0006\u0010\u0013\u001a\u00020\u0006\u0012\u0006\u0010\u0014\u001a\u00020\u0006\u0012\u0006\u0010\u0015\u001a\u00020\f¢\u0006\u0004\b'\u0010(J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ\u0010\u0010\n\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\n\u0010\bJ\u0010\u0010\u000b\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u000b\u0010\bJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJX\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\fHÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0004J\u0010\u0010\u0019\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0019\u0010\bJ\u001a\u0010\u001c\u001a\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u0019\u0010\u0015\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u001e\u001a\u0004\b\u0015\u0010\u000eR\u0019\u0010\u0012\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u001f\u001a\u0004\b \u0010\bR\u0019\u0010\u0013\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u001f\u001a\u0004\b!\u0010\bR\u0019\u0010\u0014\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u001f\u001a\u0004\b\"\u0010\bR\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010#\u001a\u0004\b$\u0010\u0004R\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010#\u001a\u0004\b%\u0010\u0004R\u0019\u0010\u0011\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001f\u001a\u0004\b&\u0010\b¨\u0006)"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/stage/StageCallItem$DetailsItem;", "Lcom/discord/widgets/voice/fullscreen/stage/StageCallItem;", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()I", "component4", "component5", "component6", "", "component7", "()Z", ModelAuditLogEntry.CHANGE_KEY_TOPIC, "displayName", "numUsersConnected", "numSpeakers", "numAudience", "numBlocked", "isPublic", "copy", "(Ljava/lang/String;Ljava/lang/String;IIIIZ)Lcom/discord/widgets/voice/fullscreen/stage/StageCallItem$DetailsItem;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "I", "getNumSpeakers", "getNumAudience", "getNumBlocked", "Ljava/lang/String;", "getDisplayName", "getTopic", "getNumUsersConnected", "<init>", "(Ljava/lang/String;Ljava/lang/String;IIIIZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class DetailsItem extends StageCallItem {
        private final String displayName;
        private final boolean isPublic;
        private final int numAudience;
        private final int numBlocked;
        private final int numSpeakers;
        private final int numUsersConnected;
        private final String topic;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DetailsItem(String str, String str2, int i, int i2, int i3, int i4, boolean z2) {
            super("details", 0, null);
            Intrinsics3.checkNotNullParameter(str2, "displayName");
            this.topic = str;
            this.displayName = str2;
            this.numUsersConnected = i;
            this.numSpeakers = i2;
            this.numAudience = i3;
            this.numBlocked = i4;
            this.isPublic = z2;
        }

        public static /* synthetic */ DetailsItem copy$default(DetailsItem detailsItem, String str, String str2, int i, int i2, int i3, int i4, boolean z2, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                str = detailsItem.topic;
            }
            if ((i5 & 2) != 0) {
                str2 = detailsItem.displayName;
            }
            String str3 = str2;
            if ((i5 & 4) != 0) {
                i = detailsItem.numUsersConnected;
            }
            int i6 = i;
            if ((i5 & 8) != 0) {
                i2 = detailsItem.numSpeakers;
            }
            int i7 = i2;
            if ((i5 & 16) != 0) {
                i3 = detailsItem.numAudience;
            }
            int i8 = i3;
            if ((i5 & 32) != 0) {
                i4 = detailsItem.numBlocked;
            }
            int i9 = i4;
            if ((i5 & 64) != 0) {
                z2 = detailsItem.isPublic;
            }
            return detailsItem.copy(str, str3, i6, i7, i8, i9, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getTopic() {
            return this.topic;
        }

        /* renamed from: component2, reason: from getter */
        public final String getDisplayName() {
            return this.displayName;
        }

        /* renamed from: component3, reason: from getter */
        public final int getNumUsersConnected() {
            return this.numUsersConnected;
        }

        /* renamed from: component4, reason: from getter */
        public final int getNumSpeakers() {
            return this.numSpeakers;
        }

        /* renamed from: component5, reason: from getter */
        public final int getNumAudience() {
            return this.numAudience;
        }

        /* renamed from: component6, reason: from getter */
        public final int getNumBlocked() {
            return this.numBlocked;
        }

        /* renamed from: component7, reason: from getter */
        public final boolean getIsPublic() {
            return this.isPublic;
        }

        public final DetailsItem copy(String topic, String displayName, int numUsersConnected, int numSpeakers, int numAudience, int numBlocked, boolean isPublic) {
            Intrinsics3.checkNotNullParameter(displayName, "displayName");
            return new DetailsItem(topic, displayName, numUsersConnected, numSpeakers, numAudience, numBlocked, isPublic);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DetailsItem)) {
                return false;
            }
            DetailsItem detailsItem = (DetailsItem) other;
            return Intrinsics3.areEqual(this.topic, detailsItem.topic) && Intrinsics3.areEqual(this.displayName, detailsItem.displayName) && this.numUsersConnected == detailsItem.numUsersConnected && this.numSpeakers == detailsItem.numSpeakers && this.numAudience == detailsItem.numAudience && this.numBlocked == detailsItem.numBlocked && this.isPublic == detailsItem.isPublic;
        }

        public final String getDisplayName() {
            return this.displayName;
        }

        public final int getNumAudience() {
            return this.numAudience;
        }

        public final int getNumBlocked() {
            return this.numBlocked;
        }

        public final int getNumSpeakers() {
            return this.numSpeakers;
        }

        public final int getNumUsersConnected() {
            return this.numUsersConnected;
        }

        public final String getTopic() {
            return this.topic;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            String str = this.topic;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.displayName;
            int iHashCode2 = (((((((((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.numUsersConnected) * 31) + this.numSpeakers) * 31) + this.numAudience) * 31) + this.numBlocked) * 31;
            boolean z2 = this.isPublic;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode2 + i;
        }

        public final boolean isPublic() {
            return this.isPublic;
        }

        public String toString() {
            StringBuilder sbU = outline.U("DetailsItem(topic=");
            sbU.append(this.topic);
            sbU.append(", displayName=");
            sbU.append(this.displayName);
            sbU.append(", numUsersConnected=");
            sbU.append(this.numUsersConnected);
            sbU.append(", numSpeakers=");
            sbU.append(this.numSpeakers);
            sbU.append(", numAudience=");
            sbU.append(this.numAudience);
            sbU.append(", numBlocked=");
            sbU.append(this.numBlocked);
            sbU.append(", isPublic=");
            return outline.O(sbU, this.isPublic, ")");
        }
    }

    /* compiled from: StageCallItem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/stage/StageCallItem$DividerItem;", "Lcom/discord/widgets/voice/fullscreen/stage/StageCallItem;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class DividerItem extends StageCallItem {
        public static final DividerItem INSTANCE = new DividerItem();

        private DividerItem() {
            super("divider", 4, null);
        }
    }

    /* compiled from: StageCallItem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B7\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0006\u0012\u0006\u0010\u0015\u001a\u00020\t\u0012\u0006\u0010\u0016\u001a\u00020\t\u0012\u0006\u0010\u0017\u001a\u00020\r\u0012\u0006\u0010\u0018\u001a\u00020\u0010¢\u0006\u0004\b3\u00104J\u0010\u0010\u0004\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\f\u0010\u000bJ\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012JL\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\t2\b\b\u0002\u0010\u0016\u001a\u00020\t2\b\b\u0002\u0010\u0017\u001a\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\u0010HÆ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001f\u001a\u00020\u001eHÖ\u0001¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010#\u001a\u00020\t2\b\u0010\"\u001a\u0004\u0018\u00010!HÖ\u0003¢\u0006\u0004\b#\u0010$R\u0019\u0010\u0015\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010%\u001a\u0004\b\u0015\u0010\u000bR\u0019\u0010'\u001a\u00020&8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0019\u0010\u0016\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010%\u001a\u0004\b\u0016\u0010\u000bR\u001c\u0010\u0014\u001a\u00020\u00068\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010+\u001a\u0004\b,\u0010\bR\u001c\u0010\u0013\u001a\u00020\u00038\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010-\u001a\u0004\b.\u0010\u0005R\u0019\u0010\u0018\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010/\u001a\u0004\b0\u0010\u0012R\u0019\u0010\u0017\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u00101\u001a\u0004\b2\u0010\u000f¨\u00065"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/stage/StageCallItem$MediaItem;", "Lcom/discord/widgets/voice/fullscreen/stage/StageCallItem;", "Lcom/discord/widgets/voice/fullscreen/stage/StageCallParticipantItem;", "Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;", "component1", "()Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;", "Lcom/discord/api/channel/Channel;", "component2", "()Lcom/discord/api/channel/Channel;", "", "component3", "()Z", "component4", "Lcom/discord/widgets/voice/fullscreen/stage/StageCallItem$MediaType;", "component5", "()Lcom/discord/widgets/voice/fullscreen/stage/StageCallItem$MediaType;", "Lcom/discord/widgets/voice/fullscreen/CallParticipant$UserOrStreamParticipant;", "component6", "()Lcom/discord/widgets/voice/fullscreen/CallParticipant$UserOrStreamParticipant;", "voiceUser", "channel", "isModerator", "isBlocked", "mediaType", "userOrStreamParticipant", "copy", "(Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;Lcom/discord/api/channel/Channel;ZZLcom/discord/widgets/voice/fullscreen/stage/StageCallItem$MediaType;Lcom/discord/widgets/voice/fullscreen/CallParticipant$UserOrStreamParticipant;)Lcom/discord/widgets/voice/fullscreen/stage/StageCallItem$MediaItem;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "Lcom/discord/views/calls/VideoCallParticipantView$ParticipantData;", "participantData", "Lcom/discord/views/calls/VideoCallParticipantView$ParticipantData;", "getParticipantData", "()Lcom/discord/views/calls/VideoCallParticipantView$ParticipantData;", "Lcom/discord/api/channel/Channel;", "getChannel", "Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;", "getVoiceUser", "Lcom/discord/widgets/voice/fullscreen/CallParticipant$UserOrStreamParticipant;", "getUserOrStreamParticipant", "Lcom/discord/widgets/voice/fullscreen/stage/StageCallItem$MediaType;", "getMediaType", "<init>", "(Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;Lcom/discord/api/channel/Channel;ZZLcom/discord/widgets/voice/fullscreen/stage/StageCallItem$MediaType;Lcom/discord/widgets/voice/fullscreen/CallParticipant$UserOrStreamParticipant;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class MediaItem extends StageCallItem implements StageCallItem2 {
        private final Channel channel;
        private final boolean isBlocked;
        private final boolean isModerator;
        private final MediaType mediaType;
        private final VideoCallParticipantView.ParticipantData participantData;
        private final CallParticipant.UserOrStreamParticipant userOrStreamParticipant;
        private final StoreVoiceParticipants.VoiceUser voiceUser;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MediaItem(StoreVoiceParticipants.VoiceUser voiceUser, Channel channel, boolean z2, boolean z3, MediaType mediaType, CallParticipant.UserOrStreamParticipant userOrStreamParticipant) {
            super("media-" + voiceUser.getUser().getId() + '-' + mediaType, 6, null);
            Intrinsics3.checkNotNullParameter(voiceUser, "voiceUser");
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Intrinsics3.checkNotNullParameter(mediaType, "mediaType");
            Intrinsics3.checkNotNullParameter(userOrStreamParticipant, "userOrStreamParticipant");
            this.voiceUser = voiceUser;
            this.channel = channel;
            this.isModerator = z2;
            this.isBlocked = z3;
            this.mediaType = mediaType;
            this.userOrStreamParticipant = userOrStreamParticipant;
            this.participantData = userOrStreamParticipant.getParticipantData();
        }

        public static /* synthetic */ MediaItem copy$default(MediaItem mediaItem, StoreVoiceParticipants.VoiceUser voiceUser, Channel channel, boolean z2, boolean z3, MediaType mediaType, CallParticipant.UserOrStreamParticipant userOrStreamParticipant, int i, Object obj) {
            if ((i & 1) != 0) {
                voiceUser = mediaItem.getVoiceUser();
            }
            if ((i & 2) != 0) {
                channel = mediaItem.getChannel();
            }
            Channel channel2 = channel;
            if ((i & 4) != 0) {
                z2 = mediaItem.isModerator;
            }
            boolean z4 = z2;
            if ((i & 8) != 0) {
                z3 = mediaItem.isBlocked;
            }
            boolean z5 = z3;
            if ((i & 16) != 0) {
                mediaType = mediaItem.mediaType;
            }
            MediaType mediaType2 = mediaType;
            if ((i & 32) != 0) {
                userOrStreamParticipant = mediaItem.userOrStreamParticipant;
            }
            return mediaItem.copy(voiceUser, channel2, z4, z5, mediaType2, userOrStreamParticipant);
        }

        public final StoreVoiceParticipants.VoiceUser component1() {
            return getVoiceUser();
        }

        public final Channel component2() {
            return getChannel();
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getIsModerator() {
            return this.isModerator;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getIsBlocked() {
            return this.isBlocked;
        }

        /* renamed from: component5, reason: from getter */
        public final MediaType getMediaType() {
            return this.mediaType;
        }

        /* renamed from: component6, reason: from getter */
        public final CallParticipant.UserOrStreamParticipant getUserOrStreamParticipant() {
            return this.userOrStreamParticipant;
        }

        public final MediaItem copy(StoreVoiceParticipants.VoiceUser voiceUser, Channel channel, boolean isModerator, boolean isBlocked, MediaType mediaType, CallParticipant.UserOrStreamParticipant userOrStreamParticipant) {
            Intrinsics3.checkNotNullParameter(voiceUser, "voiceUser");
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Intrinsics3.checkNotNullParameter(mediaType, "mediaType");
            Intrinsics3.checkNotNullParameter(userOrStreamParticipant, "userOrStreamParticipant");
            return new MediaItem(voiceUser, channel, isModerator, isBlocked, mediaType, userOrStreamParticipant);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MediaItem)) {
                return false;
            }
            MediaItem mediaItem = (MediaItem) other;
            return Intrinsics3.areEqual(getVoiceUser(), mediaItem.getVoiceUser()) && Intrinsics3.areEqual(getChannel(), mediaItem.getChannel()) && this.isModerator == mediaItem.isModerator && this.isBlocked == mediaItem.isBlocked && Intrinsics3.areEqual(this.mediaType, mediaItem.mediaType) && Intrinsics3.areEqual(this.userOrStreamParticipant, mediaItem.userOrStreamParticipant);
        }

        @Override // com.discord.widgets.voice.fullscreen.stage.StageCallItem2
        public Channel getChannel() {
            return this.channel;
        }

        public final MediaType getMediaType() {
            return this.mediaType;
        }

        public final VideoCallParticipantView.ParticipantData getParticipantData() {
            return this.participantData;
        }

        public final CallParticipant.UserOrStreamParticipant getUserOrStreamParticipant() {
            return this.userOrStreamParticipant;
        }

        @Override // com.discord.widgets.voice.fullscreen.stage.StageCallItem2
        public StoreVoiceParticipants.VoiceUser getVoiceUser() {
            return this.voiceUser;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            StoreVoiceParticipants.VoiceUser voiceUser = getVoiceUser();
            int iHashCode = (voiceUser != null ? voiceUser.hashCode() : 0) * 31;
            Channel channel = getChannel();
            int iHashCode2 = (iHashCode + (channel != null ? channel.hashCode() : 0)) * 31;
            boolean z2 = this.isModerator;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode2 + i) * 31;
            boolean z3 = this.isBlocked;
            int i3 = (i2 + (z3 ? 1 : z3 ? 1 : 0)) * 31;
            MediaType mediaType = this.mediaType;
            int iHashCode3 = (i3 + (mediaType != null ? mediaType.hashCode() : 0)) * 31;
            CallParticipant.UserOrStreamParticipant userOrStreamParticipant = this.userOrStreamParticipant;
            return iHashCode3 + (userOrStreamParticipant != null ? userOrStreamParticipant.hashCode() : 0);
        }

        public final boolean isBlocked() {
            return this.isBlocked;
        }

        public final boolean isModerator() {
            return this.isModerator;
        }

        public String toString() {
            StringBuilder sbU = outline.U("MediaItem(voiceUser=");
            sbU.append(getVoiceUser());
            sbU.append(", channel=");
            sbU.append(getChannel());
            sbU.append(", isModerator=");
            sbU.append(this.isModerator);
            sbU.append(", isBlocked=");
            sbU.append(this.isBlocked);
            sbU.append(", mediaType=");
            sbU.append(this.mediaType);
            sbU.append(", userOrStreamParticipant=");
            sbU.append(this.userOrStreamParticipant);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: StageCallItem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/stage/StageCallItem$MediaType;", "", "<init>", "(Ljava/lang/String;I)V", "USER", "STREAM", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public enum MediaType {
        USER,
        STREAM
    }

    /* compiled from: StageCallItem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ8\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0011\u0010\bJ\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0019\u0010\u0004R\u0019\u0010\r\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u001b\u0010\bR\u0019\u0010\f\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001c\u0010\b¨\u0006\u001f"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/stage/StageCallItem$PreStartDetailsItem;", "Lcom/discord/widgets/voice/fullscreen/stage/StageCallItem;", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()I", "component4", "title", "subtitle", "numSpeakers", "numAudience", "copy", "(Ljava/lang/String;Ljava/lang/String;II)Lcom/discord/widgets/voice/fullscreen/stage/StageCallItem$PreStartDetailsItem;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTitle", "getSubtitle", "I", "getNumAudience", "getNumSpeakers", "<init>", "(Ljava/lang/String;Ljava/lang/String;II)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class PreStartDetailsItem extends StageCallItem {
        private final int numAudience;
        private final int numSpeakers;
        private final String subtitle;
        private final String title;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PreStartDetailsItem(String str, String str2, int i, int i2) {
            super("pre-start-details", 5, null);
            Intrinsics3.checkNotNullParameter(str, "title");
            Intrinsics3.checkNotNullParameter(str2, "subtitle");
            this.title = str;
            this.subtitle = str2;
            this.numSpeakers = i;
            this.numAudience = i2;
        }

        public static /* synthetic */ PreStartDetailsItem copy$default(PreStartDetailsItem preStartDetailsItem, String str, String str2, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = preStartDetailsItem.title;
            }
            if ((i3 & 2) != 0) {
                str2 = preStartDetailsItem.subtitle;
            }
            if ((i3 & 4) != 0) {
                i = preStartDetailsItem.numSpeakers;
            }
            if ((i3 & 8) != 0) {
                i2 = preStartDetailsItem.numAudience;
            }
            return preStartDetailsItem.copy(str, str2, i, i2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* renamed from: component2, reason: from getter */
        public final String getSubtitle() {
            return this.subtitle;
        }

        /* renamed from: component3, reason: from getter */
        public final int getNumSpeakers() {
            return this.numSpeakers;
        }

        /* renamed from: component4, reason: from getter */
        public final int getNumAudience() {
            return this.numAudience;
        }

        public final PreStartDetailsItem copy(String title, String subtitle, int numSpeakers, int numAudience) {
            Intrinsics3.checkNotNullParameter(title, "title");
            Intrinsics3.checkNotNullParameter(subtitle, "subtitle");
            return new PreStartDetailsItem(title, subtitle, numSpeakers, numAudience);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PreStartDetailsItem)) {
                return false;
            }
            PreStartDetailsItem preStartDetailsItem = (PreStartDetailsItem) other;
            return Intrinsics3.areEqual(this.title, preStartDetailsItem.title) && Intrinsics3.areEqual(this.subtitle, preStartDetailsItem.subtitle) && this.numSpeakers == preStartDetailsItem.numSpeakers && this.numAudience == preStartDetailsItem.numAudience;
        }

        public final int getNumAudience() {
            return this.numAudience;
        }

        public final int getNumSpeakers() {
            return this.numSpeakers;
        }

        public final String getSubtitle() {
            return this.subtitle;
        }

        public final String getTitle() {
            return this.title;
        }

        public int hashCode() {
            String str = this.title;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.subtitle;
            return ((((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.numSpeakers) * 31) + this.numAudience;
        }

        public String toString() {
            StringBuilder sbU = outline.U("PreStartDetailsItem(title=");
            sbU.append(this.title);
            sbU.append(", subtitle=");
            sbU.append(this.subtitle);
            sbU.append(", numSpeakers=");
            sbU.append(this.numSpeakers);
            sbU.append(", numAudience=");
            return outline.B(sbU, this.numAudience, ")");
        }
    }

    /* compiled from: StageCallItem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B7\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0006\u0012\u0006\u0010\u0015\u001a\u00020\t\u0012\u0006\u0010\u0016\u001a\u00020\f\u0012\u0006\u0010\u0017\u001a\u00020\u000f\u0012\u0006\u0010\u0018\u001a\u00020\t¢\u0006\u0004\b*\u0010+J\u0010\u0010\u0004\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u000bJL\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\t2\b\b\u0002\u0010\u0016\u001a\u00020\f2\b\b\u0002\u0010\u0017\u001a\u00020\u000f2\b\b\u0002\u0010\u0018\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u000eJ\u0010\u0010\u001c\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0011J\u001a\u0010\u001f\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dHÖ\u0003¢\u0006\u0004\b\u001f\u0010 R\u0019\u0010\u0016\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010!\u001a\u0004\b\"\u0010\u000eR\u0019\u0010\u0018\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010#\u001a\u0004\b\u0018\u0010\u000bR\u001c\u0010\u0014\u001a\u00020\u00068\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010$\u001a\u0004\b%\u0010\bR\u0019\u0010\u0017\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010&\u001a\u0004\b'\u0010\u0011R\u001c\u0010\u0013\u001a\u00020\u00038\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010(\u001a\u0004\b)\u0010\u0005R\u0019\u0010\u0015\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010#\u001a\u0004\b\u0015\u0010\u000b¨\u0006,"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/stage/StageCallItem$SpeakerItem;", "Lcom/discord/widgets/voice/fullscreen/stage/StageCallItem;", "Lcom/discord/widgets/voice/fullscreen/stage/StageCallParticipantItem;", "Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;", "component1", "()Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;", "Lcom/discord/api/channel/Channel;", "component2", "()Lcom/discord/api/channel/Channel;", "", "component3", "()Z", "", "component4", "()Ljava/lang/String;", "", "component5", "()I", "component6", "voiceUser", "channel", "isModerator", "positionKey", "speakersPerRow", "isBlocked", "copy", "(Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;Lcom/discord/api/channel/Channel;ZLjava/lang/String;IZ)Lcom/discord/widgets/voice/fullscreen/stage/StageCallItem$SpeakerItem;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getPositionKey", "Z", "Lcom/discord/api/channel/Channel;", "getChannel", "I", "getSpeakersPerRow", "Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;", "getVoiceUser", "<init>", "(Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;Lcom/discord/api/channel/Channel;ZLjava/lang/String;IZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class SpeakerItem extends StageCallItem implements StageCallItem2 {
        private final Channel channel;
        private final boolean isBlocked;
        private final boolean isModerator;
        private final String positionKey;
        private final int speakersPerRow;
        private final StoreVoiceParticipants.VoiceUser voiceUser;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SpeakerItem(StoreVoiceParticipants.VoiceUser voiceUser, Channel channel, boolean z2, String str, int i, boolean z3) {
            super("speaker-" + voiceUser.getUser().getId(), 1, null);
            Intrinsics3.checkNotNullParameter(voiceUser, "voiceUser");
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Intrinsics3.checkNotNullParameter(str, "positionKey");
            this.voiceUser = voiceUser;
            this.channel = channel;
            this.isModerator = z2;
            this.positionKey = str;
            this.speakersPerRow = i;
            this.isBlocked = z3;
        }

        public static /* synthetic */ SpeakerItem copy$default(SpeakerItem speakerItem, StoreVoiceParticipants.VoiceUser voiceUser, Channel channel, boolean z2, String str, int i, boolean z3, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                voiceUser = speakerItem.getVoiceUser();
            }
            if ((i2 & 2) != 0) {
                channel = speakerItem.getChannel();
            }
            Channel channel2 = channel;
            if ((i2 & 4) != 0) {
                z2 = speakerItem.isModerator;
            }
            boolean z4 = z2;
            if ((i2 & 8) != 0) {
                str = speakerItem.positionKey;
            }
            String str2 = str;
            if ((i2 & 16) != 0) {
                i = speakerItem.speakersPerRow;
            }
            int i3 = i;
            if ((i2 & 32) != 0) {
                z3 = speakerItem.isBlocked;
            }
            return speakerItem.copy(voiceUser, channel2, z4, str2, i3, z3);
        }

        public final StoreVoiceParticipants.VoiceUser component1() {
            return getVoiceUser();
        }

        public final Channel component2() {
            return getChannel();
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getIsModerator() {
            return this.isModerator;
        }

        /* renamed from: component4, reason: from getter */
        public final String getPositionKey() {
            return this.positionKey;
        }

        /* renamed from: component5, reason: from getter */
        public final int getSpeakersPerRow() {
            return this.speakersPerRow;
        }

        /* renamed from: component6, reason: from getter */
        public final boolean getIsBlocked() {
            return this.isBlocked;
        }

        public final SpeakerItem copy(StoreVoiceParticipants.VoiceUser voiceUser, Channel channel, boolean isModerator, String positionKey, int speakersPerRow, boolean isBlocked) {
            Intrinsics3.checkNotNullParameter(voiceUser, "voiceUser");
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Intrinsics3.checkNotNullParameter(positionKey, "positionKey");
            return new SpeakerItem(voiceUser, channel, isModerator, positionKey, speakersPerRow, isBlocked);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SpeakerItem)) {
                return false;
            }
            SpeakerItem speakerItem = (SpeakerItem) other;
            return Intrinsics3.areEqual(getVoiceUser(), speakerItem.getVoiceUser()) && Intrinsics3.areEqual(getChannel(), speakerItem.getChannel()) && this.isModerator == speakerItem.isModerator && Intrinsics3.areEqual(this.positionKey, speakerItem.positionKey) && this.speakersPerRow == speakerItem.speakersPerRow && this.isBlocked == speakerItem.isBlocked;
        }

        @Override // com.discord.widgets.voice.fullscreen.stage.StageCallItem2
        public Channel getChannel() {
            return this.channel;
        }

        public final String getPositionKey() {
            return this.positionKey;
        }

        public final int getSpeakersPerRow() {
            return this.speakersPerRow;
        }

        @Override // com.discord.widgets.voice.fullscreen.stage.StageCallItem2
        public StoreVoiceParticipants.VoiceUser getVoiceUser() {
            return this.voiceUser;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            StoreVoiceParticipants.VoiceUser voiceUser = getVoiceUser();
            int iHashCode = (voiceUser != null ? voiceUser.hashCode() : 0) * 31;
            Channel channel = getChannel();
            int iHashCode2 = (iHashCode + (channel != null ? channel.hashCode() : 0)) * 31;
            boolean z2 = this.isModerator;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode2 + i) * 31;
            String str = this.positionKey;
            int iHashCode3 = (((i2 + (str != null ? str.hashCode() : 0)) * 31) + this.speakersPerRow) * 31;
            boolean z3 = this.isBlocked;
            return iHashCode3 + (z3 ? 1 : z3 ? 1 : 0);
        }

        public final boolean isBlocked() {
            return this.isBlocked;
        }

        public final boolean isModerator() {
            return this.isModerator;
        }

        public String toString() {
            StringBuilder sbU = outline.U("SpeakerItem(voiceUser=");
            sbU.append(getVoiceUser());
            sbU.append(", channel=");
            sbU.append(getChannel());
            sbU.append(", isModerator=");
            sbU.append(this.isModerator);
            sbU.append(", positionKey=");
            sbU.append(this.positionKey);
            sbU.append(", speakersPerRow=");
            sbU.append(this.speakersPerRow);
            sbU.append(", isBlocked=");
            return outline.O(sbU, this.isBlocked, ")");
        }
    }

    private StageCallItem(String str, int i) {
        this.key = str;
        this.type = i;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public /* synthetic */ StageCallItem(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i);
    }
}
