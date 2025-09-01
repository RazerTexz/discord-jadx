package com.discord.models.domain;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ModelChannelFollowerStatsDto.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\"\u0010#J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004JX\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004R\u001b\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001d\u0010\u0004R\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001b\u001a\u0004\b\u001e\u0010\u0004R\u001b\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\u001f\u0010\u0004R\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001b\u001a\u0004\b \u0010\u0004R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u001b\u001a\u0004\b!\u0010\u0004¨\u0006$"}, d2 = {"Lcom/discord/models/domain/ModelChannelFollowerStatsDto;", "", "", "component1", "()Ljava/lang/Integer;", "component2", "component3", "component4", "component5", "component6", "guildsFollowing", "channelsFollowing", "guildMembers", "usersSeenEver", "subscribersGainedSinceLastPost", "subscribersLostSinceLastPost", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/discord/models/domain/ModelChannelFollowerStatsDto;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Integer;", "getChannelsFollowing", "getUsersSeenEver", "getSubscribersLostSinceLastPost", "getGuildMembers", "getSubscribersGainedSinceLastPost", "getGuildsFollowing", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "app_models_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ModelChannelFollowerStatsDto {
    private final Integer channelsFollowing;
    private final Integer guildMembers;
    private final Integer guildsFollowing;
    private final Integer subscribersGainedSinceLastPost;
    private final Integer subscribersLostSinceLastPost;
    private final Integer usersSeenEver;

    public ModelChannelFollowerStatsDto(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6) {
        this.guildsFollowing = num;
        this.channelsFollowing = num2;
        this.guildMembers = num3;
        this.usersSeenEver = num4;
        this.subscribersGainedSinceLastPost = num5;
        this.subscribersLostSinceLastPost = num6;
    }

    public static /* synthetic */ ModelChannelFollowerStatsDto copy$default(ModelChannelFollowerStatsDto modelChannelFollowerStatsDto, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, int i, Object obj) {
        if ((i & 1) != 0) {
            num = modelChannelFollowerStatsDto.guildsFollowing;
        }
        if ((i & 2) != 0) {
            num2 = modelChannelFollowerStatsDto.channelsFollowing;
        }
        Integer num7 = num2;
        if ((i & 4) != 0) {
            num3 = modelChannelFollowerStatsDto.guildMembers;
        }
        Integer num8 = num3;
        if ((i & 8) != 0) {
            num4 = modelChannelFollowerStatsDto.usersSeenEver;
        }
        Integer num9 = num4;
        if ((i & 16) != 0) {
            num5 = modelChannelFollowerStatsDto.subscribersGainedSinceLastPost;
        }
        Integer num10 = num5;
        if ((i & 32) != 0) {
            num6 = modelChannelFollowerStatsDto.subscribersLostSinceLastPost;
        }
        return modelChannelFollowerStatsDto.copy(num, num7, num8, num9, num10, num6);
    }

    /* renamed from: component1, reason: from getter */
    public final Integer getGuildsFollowing() {
        return this.guildsFollowing;
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
    public final Integer getUsersSeenEver() {
        return this.usersSeenEver;
    }

    /* renamed from: component5, reason: from getter */
    public final Integer getSubscribersGainedSinceLastPost() {
        return this.subscribersGainedSinceLastPost;
    }

    /* renamed from: component6, reason: from getter */
    public final Integer getSubscribersLostSinceLastPost() {
        return this.subscribersLostSinceLastPost;
    }

    public final ModelChannelFollowerStatsDto copy(Integer guildsFollowing, Integer channelsFollowing, Integer guildMembers, Integer usersSeenEver, Integer subscribersGainedSinceLastPost, Integer subscribersLostSinceLastPost) {
        return new ModelChannelFollowerStatsDto(guildsFollowing, channelsFollowing, guildMembers, usersSeenEver, subscribersGainedSinceLastPost, subscribersLostSinceLastPost);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelChannelFollowerStatsDto)) {
            return false;
        }
        ModelChannelFollowerStatsDto modelChannelFollowerStatsDto = (ModelChannelFollowerStatsDto) other;
        return Intrinsics3.areEqual(this.guildsFollowing, modelChannelFollowerStatsDto.guildsFollowing) && Intrinsics3.areEqual(this.channelsFollowing, modelChannelFollowerStatsDto.channelsFollowing) && Intrinsics3.areEqual(this.guildMembers, modelChannelFollowerStatsDto.guildMembers) && Intrinsics3.areEqual(this.usersSeenEver, modelChannelFollowerStatsDto.usersSeenEver) && Intrinsics3.areEqual(this.subscribersGainedSinceLastPost, modelChannelFollowerStatsDto.subscribersGainedSinceLastPost) && Intrinsics3.areEqual(this.subscribersLostSinceLastPost, modelChannelFollowerStatsDto.subscribersLostSinceLastPost);
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
        Integer num = this.guildsFollowing;
        int iHashCode = (num != null ? num.hashCode() : 0) * 31;
        Integer num2 = this.channelsFollowing;
        int iHashCode2 = (iHashCode + (num2 != null ? num2.hashCode() : 0)) * 31;
        Integer num3 = this.guildMembers;
        int iHashCode3 = (iHashCode2 + (num3 != null ? num3.hashCode() : 0)) * 31;
        Integer num4 = this.usersSeenEver;
        int iHashCode4 = (iHashCode3 + (num4 != null ? num4.hashCode() : 0)) * 31;
        Integer num5 = this.subscribersGainedSinceLastPost;
        int iHashCode5 = (iHashCode4 + (num5 != null ? num5.hashCode() : 0)) * 31;
        Integer num6 = this.subscribersLostSinceLastPost;
        return iHashCode5 + (num6 != null ? num6.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ModelChannelFollowerStatsDto(guildsFollowing=");
        sbU.append(this.guildsFollowing);
        sbU.append(", channelsFollowing=");
        sbU.append(this.channelsFollowing);
        sbU.append(", guildMembers=");
        sbU.append(this.guildMembers);
        sbU.append(", usersSeenEver=");
        sbU.append(this.usersSeenEver);
        sbU.append(", subscribersGainedSinceLastPost=");
        sbU.append(this.subscribersGainedSinceLastPost);
        sbU.append(", subscribersLostSinceLastPost=");
        return outline.F(sbU, this.subscribersLostSinceLastPost, ")");
    }
}
