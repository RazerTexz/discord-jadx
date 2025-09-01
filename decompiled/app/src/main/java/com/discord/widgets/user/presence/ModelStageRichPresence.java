package com.discord.widgets.user.presence;

import a0.a.a.b;
import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserPresence;
import d0.z.d.Intrinsics3;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: ModelStageRichPresence.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u001a\b\u0086\b\u0018\u0000 D2\u00020\u0001:\u0001DB\u0091\u0001\u0012\n\u0010\u001b\u001a\u00060\u0002j\u0002`\u0003\u0012\n\u0010\u001c\u001a\u00060\u0002j\u0002`\u0006\u0012\u0006\u0010\u001d\u001a\u00020\b\u0012\n\u0010\u001e\u001a\u00060\u0002j\u0002`\u000b\u0012\u0006\u0010\u001f\u001a\u00020\b\u0012\u0006\u0010 \u001a\u00020\b\u0012\u0006\u0010!\u001a\u00020\u000f\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010#\u001a\u00020\u000f\u0012\u0010\u0010$\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00150\u0014\u0012\u0010\u0010%\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00150\u0014\u0012\u0006\u0010&\u001a\u00020\u0002\u0012\u0006\u0010'\u001a\u00020\u0002¢\u0006\u0004\bB\u0010CJ\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0007\u001a\u00060\u0002j\u0002`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0005J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0014\u0010\f\u001a\u00060\u0002j\u0002`\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\u0005J\u0010\u0010\r\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\r\u0010\nJ\u0010\u0010\u000e\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\nJ\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0011J\u001a\u0010\u0016\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00150\u0014HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u0018\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00150\u0014HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0005J\u0010\u0010\u001a\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0005J´\u0001\u0010(\u001a\u00020\u00002\f\b\u0002\u0010\u001b\u001a\u00060\u0002j\u0002`\u00032\f\b\u0002\u0010\u001c\u001a\u00060\u0002j\u0002`\u00062\b\b\u0002\u0010\u001d\u001a\u00020\b2\f\b\u0002\u0010\u001e\u001a\u00060\u0002j\u0002`\u000b2\b\b\u0002\u0010\u001f\u001a\u00020\b2\b\b\u0002\u0010 \u001a\u00020\b2\b\b\u0002\u0010!\u001a\u00020\u000f2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010#\u001a\u00020\u000f2\u0012\b\u0002\u0010$\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00150\u00142\u0012\b\u0002\u0010%\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00150\u00142\b\b\u0002\u0010&\u001a\u00020\u00022\b\b\u0002\u0010'\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b(\u0010)J\u0010\u0010*\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b*\u0010\u0011J\u0010\u0010,\u001a\u00020+HÖ\u0001¢\u0006\u0004\b,\u0010-J\u001a\u0010/\u001a\u00020\b2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b/\u00100R\u0019\u0010\u001d\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u00101\u001a\u0004\b2\u0010\nR\u001d\u0010\u001c\u001a\u00060\u0002j\u0002`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u00103\u001a\u0004\b4\u0010\u0005R#\u0010%\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00150\u00148\u0006@\u0006¢\u0006\f\n\u0004\b%\u00105\u001a\u0004\b6\u0010\u0017R\u001d\u0010\u001e\u001a\u00060\u0002j\u0002`\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u00103\u001a\u0004\b7\u0010\u0005R\u0019\u0010'\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b'\u00103\u001a\u0004\b8\u0010\u0005R\u0019\u0010\u001f\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u00101\u001a\u0004\b9\u0010\nR\u0019\u0010 \u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b \u00101\u001a\u0004\b:\u0010\nR\u001d\u0010\u001b\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u00103\u001a\u0004\b;\u0010\u0005R\u0019\u0010!\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010<\u001a\u0004\b=\u0010\u0011R\u0019\u0010#\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010<\u001a\u0004\b>\u0010\u0011R\u0019\u0010&\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b&\u00103\u001a\u0004\b?\u0010\u0005R#\u0010$\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00150\u00148\u0006@\u0006¢\u0006\f\n\u0004\b$\u00105\u001a\u0004\b@\u0010\u0017R\u001b\u0010\"\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010<\u001a\u0004\bA\u0010\u0011¨\u0006E"}, d2 = {"Lcom/discord/widgets/user/presence/ModelStageRichPresence;", "", "", "Lcom/discord/primitives/ChannelId;", "component1", "()J", "Lcom/discord/primitives/StageInstanceId;", "component2", "", "component3", "()Z", "Lcom/discord/primitives/GuildId;", "component4", "component5", "component6", "", "component7", "()Ljava/lang/String;", "component8", "component9", "", "Lcom/discord/primitives/UserId;", "component10", "()Ljava/util/Set;", "component11", "component12", "component13", "channelId", "stageInstanceId", "userIsSpeaker", "guildId", "guildIsPartnered", "guildIsVerified", "guildName", "guildIcon", ModelAuditLogEntry.CHANGE_KEY_TOPIC, "knownUserIds", "speakerIds", "speakerCount", "audienceSize", "copy", "(JJZJZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Set;Ljava/util/Set;JJ)Lcom/discord/widgets/user/presence/ModelStageRichPresence;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getUserIsSpeaker", "J", "getStageInstanceId", "Ljava/util/Set;", "getSpeakerIds", "getGuildId", "getAudienceSize", "getGuildIsPartnered", "getGuildIsVerified", "getChannelId", "Ljava/lang/String;", "getGuildName", "getTopic", "getSpeakerCount", "getKnownUserIds", "getGuildIcon", "<init>", "(JJZJZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Set;Ljava/util/Set;JJ)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ModelStageRichPresence {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long audienceSize;
    private final long channelId;
    private final String guildIcon;
    private final long guildId;
    private final boolean guildIsPartnered;
    private final boolean guildIsVerified;
    private final String guildName;
    private final Set<Long> knownUserIds;
    private final long speakerCount;
    private final Set<Long> speakerIds;
    private final long stageInstanceId;
    private final String topic;
    private final boolean userIsSpeaker;

    /* compiled from: ModelStageRichPresence.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/discord/widgets/user/presence/ModelStageRichPresence$Companion;", "", "Lcom/discord/stores/StoreUserPresence;", "storeUserPresence", "Lrx/Observable;", "", "Lcom/discord/widgets/user/presence/ModelStageRichPresence;", "observeStageRichPresence", "(Lcom/discord/stores/StoreUserPresence;)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ Observable observeStageRichPresence$default(Companion companion, StoreUserPresence storeUserPresence, int i, Object obj) {
            if ((i & 1) != 0) {
                storeUserPresence = StoreStream.INSTANCE.getPresences();
            }
            return companion.observeStageRichPresence(storeUserPresence);
        }

        public final Observable<List<ModelStageRichPresence>> observeStageRichPresence(StoreUserPresence storeUserPresence) {
            Intrinsics3.checkNotNullParameter(storeUserPresence, "storeUserPresence");
            Observable observableG = storeUserPresence.observeAllPresences().G(ModelStageRichPresence2.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableG, "storeUserPresence\n      …   }.toList()\n          }");
            return observableG;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ModelStageRichPresence(long j, long j2, boolean z2, long j3, boolean z3, boolean z4, String str, String str2, String str3, Set<Long> set, Set<Long> set2, long j4, long j5) {
        Intrinsics3.checkNotNullParameter(str, "guildName");
        Intrinsics3.checkNotNullParameter(str3, ModelAuditLogEntry.CHANGE_KEY_TOPIC);
        Intrinsics3.checkNotNullParameter(set, "knownUserIds");
        Intrinsics3.checkNotNullParameter(set2, "speakerIds");
        this.channelId = j;
        this.stageInstanceId = j2;
        this.userIsSpeaker = z2;
        this.guildId = j3;
        this.guildIsPartnered = z3;
        this.guildIsVerified = z4;
        this.guildName = str;
        this.guildIcon = str2;
        this.topic = str3;
        this.knownUserIds = set;
        this.speakerIds = set2;
        this.speakerCount = j4;
        this.audienceSize = j5;
    }

    public static /* synthetic */ ModelStageRichPresence copy$default(ModelStageRichPresence modelStageRichPresence, long j, long j2, boolean z2, long j3, boolean z3, boolean z4, String str, String str2, String str3, Set set, Set set2, long j4, long j5, int i, Object obj) {
        return modelStageRichPresence.copy((i & 1) != 0 ? modelStageRichPresence.channelId : j, (i & 2) != 0 ? modelStageRichPresence.stageInstanceId : j2, (i & 4) != 0 ? modelStageRichPresence.userIsSpeaker : z2, (i & 8) != 0 ? modelStageRichPresence.guildId : j3, (i & 16) != 0 ? modelStageRichPresence.guildIsPartnered : z3, (i & 32) != 0 ? modelStageRichPresence.guildIsVerified : z4, (i & 64) != 0 ? modelStageRichPresence.guildName : str, (i & 128) != 0 ? modelStageRichPresence.guildIcon : str2, (i & 256) != 0 ? modelStageRichPresence.topic : str3, (i & 512) != 0 ? modelStageRichPresence.knownUserIds : set, (i & 1024) != 0 ? modelStageRichPresence.speakerIds : set2, (i & 2048) != 0 ? modelStageRichPresence.speakerCount : j4, (i & 4096) != 0 ? modelStageRichPresence.audienceSize : j5);
    }

    /* renamed from: component1, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    public final Set<Long> component10() {
        return this.knownUserIds;
    }

    public final Set<Long> component11() {
        return this.speakerIds;
    }

    /* renamed from: component12, reason: from getter */
    public final long getSpeakerCount() {
        return this.speakerCount;
    }

    /* renamed from: component13, reason: from getter */
    public final long getAudienceSize() {
        return this.audienceSize;
    }

    /* renamed from: component2, reason: from getter */
    public final long getStageInstanceId() {
        return this.stageInstanceId;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getUserIsSpeaker() {
        return this.userIsSpeaker;
    }

    /* renamed from: component4, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getGuildIsPartnered() {
        return this.guildIsPartnered;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getGuildIsVerified() {
        return this.guildIsVerified;
    }

    /* renamed from: component7, reason: from getter */
    public final String getGuildName() {
        return this.guildName;
    }

    /* renamed from: component8, reason: from getter */
    public final String getGuildIcon() {
        return this.guildIcon;
    }

    /* renamed from: component9, reason: from getter */
    public final String getTopic() {
        return this.topic;
    }

    public final ModelStageRichPresence copy(long channelId, long stageInstanceId, boolean userIsSpeaker, long guildId, boolean guildIsPartnered, boolean guildIsVerified, String guildName, String guildIcon, String topic, Set<Long> knownUserIds, Set<Long> speakerIds, long speakerCount, long audienceSize) {
        Intrinsics3.checkNotNullParameter(guildName, "guildName");
        Intrinsics3.checkNotNullParameter(topic, ModelAuditLogEntry.CHANGE_KEY_TOPIC);
        Intrinsics3.checkNotNullParameter(knownUserIds, "knownUserIds");
        Intrinsics3.checkNotNullParameter(speakerIds, "speakerIds");
        return new ModelStageRichPresence(channelId, stageInstanceId, userIsSpeaker, guildId, guildIsPartnered, guildIsVerified, guildName, guildIcon, topic, knownUserIds, speakerIds, speakerCount, audienceSize);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelStageRichPresence)) {
            return false;
        }
        ModelStageRichPresence modelStageRichPresence = (ModelStageRichPresence) other;
        return this.channelId == modelStageRichPresence.channelId && this.stageInstanceId == modelStageRichPresence.stageInstanceId && this.userIsSpeaker == modelStageRichPresence.userIsSpeaker && this.guildId == modelStageRichPresence.guildId && this.guildIsPartnered == modelStageRichPresence.guildIsPartnered && this.guildIsVerified == modelStageRichPresence.guildIsVerified && Intrinsics3.areEqual(this.guildName, modelStageRichPresence.guildName) && Intrinsics3.areEqual(this.guildIcon, modelStageRichPresence.guildIcon) && Intrinsics3.areEqual(this.topic, modelStageRichPresence.topic) && Intrinsics3.areEqual(this.knownUserIds, modelStageRichPresence.knownUserIds) && Intrinsics3.areEqual(this.speakerIds, modelStageRichPresence.speakerIds) && this.speakerCount == modelStageRichPresence.speakerCount && this.audienceSize == modelStageRichPresence.audienceSize;
    }

    public final long getAudienceSize() {
        return this.audienceSize;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final String getGuildIcon() {
        return this.guildIcon;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final boolean getGuildIsPartnered() {
        return this.guildIsPartnered;
    }

    public final boolean getGuildIsVerified() {
        return this.guildIsVerified;
    }

    public final String getGuildName() {
        return this.guildName;
    }

    public final Set<Long> getKnownUserIds() {
        return this.knownUserIds;
    }

    public final long getSpeakerCount() {
        return this.speakerCount;
    }

    public final Set<Long> getSpeakerIds() {
        return this.speakerIds;
    }

    public final long getStageInstanceId() {
        return this.stageInstanceId;
    }

    public final String getTopic() {
        return this.topic;
    }

    public final boolean getUserIsSpeaker() {
        return this.userIsSpeaker;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iA = (b.a(this.stageInstanceId) + (b.a(this.channelId) * 31)) * 31;
        boolean z2 = this.userIsSpeaker;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int iA2 = (b.a(this.guildId) + ((iA + i) * 31)) * 31;
        boolean z3 = this.guildIsPartnered;
        int i2 = z3;
        if (z3 != 0) {
            i2 = 1;
        }
        int i3 = (iA2 + i2) * 31;
        boolean z4 = this.guildIsVerified;
        int i4 = (i3 + (z4 ? 1 : z4 ? 1 : 0)) * 31;
        String str = this.guildName;
        int iHashCode = (i4 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.guildIcon;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.topic;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Set<Long> set = this.knownUserIds;
        int iHashCode4 = (iHashCode3 + (set != null ? set.hashCode() : 0)) * 31;
        Set<Long> set2 = this.speakerIds;
        return b.a(this.audienceSize) + ((b.a(this.speakerCount) + ((iHashCode4 + (set2 != null ? set2.hashCode() : 0)) * 31)) * 31);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ModelStageRichPresence(channelId=");
        sbU.append(this.channelId);
        sbU.append(", stageInstanceId=");
        sbU.append(this.stageInstanceId);
        sbU.append(", userIsSpeaker=");
        sbU.append(this.userIsSpeaker);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", guildIsPartnered=");
        sbU.append(this.guildIsPartnered);
        sbU.append(", guildIsVerified=");
        sbU.append(this.guildIsVerified);
        sbU.append(", guildName=");
        sbU.append(this.guildName);
        sbU.append(", guildIcon=");
        sbU.append(this.guildIcon);
        sbU.append(", topic=");
        sbU.append(this.topic);
        sbU.append(", knownUserIds=");
        sbU.append(this.knownUserIds);
        sbU.append(", speakerIds=");
        sbU.append(this.speakerIds);
        sbU.append(", speakerCount=");
        sbU.append(this.speakerCount);
        sbU.append(", audienceSize=");
        return outline.C(sbU, this.audienceSize, ")");
    }
}
