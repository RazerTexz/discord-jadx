package com.discord.models.domain;

import b.d.b.a.outline;
import com.discord.utilities.time.ClockFactory;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;

/* compiled from: ModelChannelFollowerStats.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u0000 +2\u00020\u0001:\u0001+B]\u0012\f\b\u0002\u0010\u000e\u001a\u00060\u0002j\u0002`\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b)\u0010*J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\n\u0010\bJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u000b\u0010\bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\f\u0010\bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\r\u0010\bJf\u0010\u0015\u001a\u00020\u00002\f\b\u0002\u0010\u000e\u001a\u00060\u0002j\u0002`\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010 \u001a\u0004\b!\u0010\bR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010 \u001a\u0004\b\"\u0010\bR\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010 \u001a\u0004\b#\u0010\bR\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010 \u001a\u0004\b$\u0010\bR\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010 \u001a\u0004\b%\u0010\bR\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010 \u001a\u0004\b&\u0010\bR\u001d\u0010\u000e\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010'\u001a\u0004\b(\u0010\u0005¨\u0006,"}, d2 = {"Lcom/discord/models/domain/ModelChannelFollowerStats;", "", "", "Lcom/discord/primitives/Timestamp;", "component1", "()J", "", "component2", "()Ljava/lang/Integer;", "component3", "component4", "component5", "component6", "component7", "lastFetched", "channelsFollowing", "guildMembers", "guildsFollowing", "usersSeenEver", "subscribersGainedSinceLastPost", "subscribersLostSinceLastPost", "copy", "(JLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/discord/models/domain/ModelChannelFollowerStats;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Integer;", "getChannelsFollowing", "getGuildMembers", "getSubscribersGainedSinceLastPost", "getUsersSeenEver", "getSubscribersLostSinceLastPost", "getGuildsFollowing", "J", "getLastFetched", "<init>", "(JLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "Companion", "app_models_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ModelChannelFollowerStats {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Integer channelsFollowing;
    private final Integer guildMembers;
    private final Integer guildsFollowing;
    private final long lastFetched;
    private final Integer subscribersGainedSinceLastPost;
    private final Integer subscribersLostSinceLastPost;
    private final Integer usersSeenEver;

    /* compiled from: ModelChannelFollowerStats.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/models/domain/ModelChannelFollowerStats$Companion;", "", "Lcom/discord/models/domain/ModelChannelFollowerStatsDto;", "dto", "Lcom/discord/models/domain/ModelChannelFollowerStats;", "fromResponse", "(Lcom/discord/models/domain/ModelChannelFollowerStatsDto;)Lcom/discord/models/domain/ModelChannelFollowerStats;", "<init>", "()V", "app_models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final ModelChannelFollowerStats fromResponse(ModelChannelFollowerStatsDto dto) {
            return dto == null ? new ModelChannelFollowerStats(0L, null, null, null, null, null, null, Opcodes.LAND, null) : new ModelChannelFollowerStats(0L, dto.getChannelsFollowing(), dto.getGuildMembers(), dto.getGuildsFollowing(), dto.getUsersSeenEver(), dto.getSubscribersGainedSinceLastPost(), dto.getSubscribersLostSinceLastPost(), 1, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ModelChannelFollowerStats() {
        this(0L, null, null, null, null, null, null, Opcodes.LAND, null);
    }

    public ModelChannelFollowerStats(long j, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6) {
        this.lastFetched = j;
        this.channelsFollowing = num;
        this.guildMembers = num2;
        this.guildsFollowing = num3;
        this.usersSeenEver = num4;
        this.subscribersGainedSinceLastPost = num5;
        this.subscribersLostSinceLastPost = num6;
    }

    public static /* synthetic */ ModelChannelFollowerStats copy$default(ModelChannelFollowerStats modelChannelFollowerStats, long j, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, int i, Object obj) {
        return modelChannelFollowerStats.copy((i & 1) != 0 ? modelChannelFollowerStats.lastFetched : j, (i & 2) != 0 ? modelChannelFollowerStats.channelsFollowing : num, (i & 4) != 0 ? modelChannelFollowerStats.guildMembers : num2, (i & 8) != 0 ? modelChannelFollowerStats.guildsFollowing : num3, (i & 16) != 0 ? modelChannelFollowerStats.usersSeenEver : num4, (i & 32) != 0 ? modelChannelFollowerStats.subscribersGainedSinceLastPost : num5, (i & 64) != 0 ? modelChannelFollowerStats.subscribersLostSinceLastPost : num6);
    }

    /* renamed from: component1, reason: from getter */
    public final long getLastFetched() {
        return this.lastFetched;
    }

    /* renamed from: component2, reason: from getter */
    public final Integer getChannelsFollowing() {
        return this.channelsFollowing;
    }

    /* renamed from: component3, reason: from getter */
    public final Integer getGuildMembers() {
        return this.guildMembers;
    }

    /* renamed from: component4, reason: from getter */
    public final Integer getGuildsFollowing() {
        return this.guildsFollowing;
    }

    /* renamed from: component5, reason: from getter */
    public final Integer getUsersSeenEver() {
        return this.usersSeenEver;
    }

    /* renamed from: component6, reason: from getter */
    public final Integer getSubscribersGainedSinceLastPost() {
        return this.subscribersGainedSinceLastPost;
    }

    /* renamed from: component7, reason: from getter */
    public final Integer getSubscribersLostSinceLastPost() {
        return this.subscribersLostSinceLastPost;
    }

    public final ModelChannelFollowerStats copy(long lastFetched, Integer channelsFollowing, Integer guildMembers, Integer guildsFollowing, Integer usersSeenEver, Integer subscribersGainedSinceLastPost, Integer subscribersLostSinceLastPost) {
        return new ModelChannelFollowerStats(lastFetched, channelsFollowing, guildMembers, guildsFollowing, usersSeenEver, subscribersGainedSinceLastPost, subscribersLostSinceLastPost);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelChannelFollowerStats)) {
            return false;
        }
        ModelChannelFollowerStats modelChannelFollowerStats = (ModelChannelFollowerStats) other;
        return this.lastFetched == modelChannelFollowerStats.lastFetched && Intrinsics3.areEqual(this.channelsFollowing, modelChannelFollowerStats.channelsFollowing) && Intrinsics3.areEqual(this.guildMembers, modelChannelFollowerStats.guildMembers) && Intrinsics3.areEqual(this.guildsFollowing, modelChannelFollowerStats.guildsFollowing) && Intrinsics3.areEqual(this.usersSeenEver, modelChannelFollowerStats.usersSeenEver) && Intrinsics3.areEqual(this.subscribersGainedSinceLastPost, modelChannelFollowerStats.subscribersGainedSinceLastPost) && Intrinsics3.areEqual(this.subscribersLostSinceLastPost, modelChannelFollowerStats.subscribersLostSinceLastPost);
    }

    public final Integer getChannelsFollowing() {
        return this.channelsFollowing;
    }

    public final Integer getGuildMembers() {
        return this.guildMembers;
    }

    public final Integer getGuildsFollowing() {
        return this.guildsFollowing;
    }

    public final long getLastFetched() {
        return this.lastFetched;
    }

    public final Integer getSubscribersGainedSinceLastPost() {
        return this.subscribersGainedSinceLastPost;
    }

    public final Integer getSubscribersLostSinceLastPost() {
        return this.subscribersLostSinceLastPost;
    }

    public final Integer getUsersSeenEver() {
        return this.usersSeenEver;
    }

    public int hashCode() {
        long j = this.lastFetched;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        Integer num = this.channelsFollowing;
        int iHashCode = (i + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.guildMembers;
        int iHashCode2 = (iHashCode + (num2 != null ? num2.hashCode() : 0)) * 31;
        Integer num3 = this.guildsFollowing;
        int iHashCode3 = (iHashCode2 + (num3 != null ? num3.hashCode() : 0)) * 31;
        Integer num4 = this.usersSeenEver;
        int iHashCode4 = (iHashCode3 + (num4 != null ? num4.hashCode() : 0)) * 31;
        Integer num5 = this.subscribersGainedSinceLastPost;
        int iHashCode5 = (iHashCode4 + (num5 != null ? num5.hashCode() : 0)) * 31;
        Integer num6 = this.subscribersLostSinceLastPost;
        return iHashCode5 + (num6 != null ? num6.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ModelChannelFollowerStats(lastFetched=");
        sbU.append(this.lastFetched);
        sbU.append(", channelsFollowing=");
        sbU.append(this.channelsFollowing);
        sbU.append(", guildMembers=");
        sbU.append(this.guildMembers);
        sbU.append(", guildsFollowing=");
        sbU.append(this.guildsFollowing);
        sbU.append(", usersSeenEver=");
        sbU.append(this.usersSeenEver);
        sbU.append(", subscribersGainedSinceLastPost=");
        sbU.append(this.subscribersGainedSinceLastPost);
        sbU.append(", subscribersLostSinceLastPost=");
        return outline.F(sbU, this.subscribersLostSinceLastPost, ")");
    }

    public /* synthetic */ ModelChannelFollowerStats(long j, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? ClockFactory.get().currentTimeMillis() : j, (i & 2) != 0 ? 0 : num, (i & 4) != 0 ? 0 : num2, (i & 8) != 0 ? 0 : num3, (i & 16) != 0 ? 0 : num4, (i & 32) != 0 ? 0 : num5, (i & 64) != 0 ? 0 : num6);
    }
}
