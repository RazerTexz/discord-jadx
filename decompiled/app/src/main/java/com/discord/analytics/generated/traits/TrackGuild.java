package com.discord.analytics.generated.traits;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackGuild.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u001d\b\u0086\b\u0018\u00002\u00020\u0001B\u0097\u0001\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b'\u0010(J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001b\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0016\u0010\u0010R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0017\u0010\u0019R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u000e\u001a\u0004\b\u001b\u0010\u0010R\u001b\u0010\u001c\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u000e\u001a\u0004\b\u001d\u0010\u0010R\u001b\u0010\u001e\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u000e\u001a\u0004\b\u001f\u0010\u0010R\u001b\u0010 \u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\u000e\u001a\u0004\b!\u0010\u0010R\u001b\u0010\"\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010\u0018\u001a\u0004\b#\u0010\u0019R\u001b\u0010$\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\u000e\u001a\u0004\b%\u0010\u0010R\u001b\u0010&\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010\u0018\u001a\u0004\b&\u0010\u0019¨\u0006)"}, d2 = {"Lcom/discord/analytics/generated/traits/TrackGuild;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "guildNumChannels", "Ljava/lang/Long;", "getGuildNumChannels", "()Ljava/lang/Long;", "numVoiceChannelsActive", "getNumVoiceChannelsActive", "guildNumTextChannels", "getGuildNumTextChannels", "guildSizeTotal", "getGuildSizeTotal", "isOwner", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "guildMemberPerms", "getGuildMemberPerms", "guildMemberNumRoles", "getGuildMemberNumRoles", "guildNumVoiceChannels", "getGuildNumVoiceChannels", "guildNumRoles", "getGuildNumRoles", "guildIsVip", "getGuildIsVip", "guildId", "b", "isMember", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Boolean;)V", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackGuild {
    private final Long guildId;
    private final Boolean guildIsVip;
    private final Long guildMemberNumRoles;
    private final Long guildMemberPerms;
    private final Long guildNumChannels;
    private final Long guildNumRoles;
    private final Long guildNumTextChannels;
    private final Long guildNumVoiceChannels;
    private final Long guildSizeTotal;
    private final Boolean isMember;
    private final Boolean isOwner;
    private final Long numVoiceChannelsActive;

    public TrackGuild() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, 4095);
    }

    public TrackGuild(Long l, Long l2, Long l3, Long l4, Long l5, Long l6, Long l7, Long l8, Boolean bool, Boolean bool2, Long l9, Boolean bool3) {
        this.guildId = l;
        this.guildSizeTotal = l2;
        this.guildMemberNumRoles = l3;
        this.guildMemberPerms = l4;
        this.guildNumChannels = l5;
        this.guildNumTextChannels = l6;
        this.guildNumVoiceChannels = l7;
        this.guildNumRoles = l8;
        this.guildIsVip = bool;
        this.isMember = bool2;
        this.numVoiceChannelsActive = l9;
        this.isOwner = bool3;
    }

    public static TrackGuild a(TrackGuild trackGuild, Long l, Long l2, Long l3, Long l4, Long l5, Long l6, Long l7, Long l8, Boolean bool, Boolean bool2, Long l9, Boolean bool3, int i) {
        return new TrackGuild((i & 1) != 0 ? trackGuild.guildId : null, (i & 2) != 0 ? trackGuild.guildSizeTotal : null, (i & 4) != 0 ? trackGuild.guildMemberNumRoles : null, (i & 8) != 0 ? trackGuild.guildMemberPerms : null, (i & 16) != 0 ? trackGuild.guildNumChannels : null, (i & 32) != 0 ? trackGuild.guildNumTextChannels : null, (i & 64) != 0 ? trackGuild.guildNumVoiceChannels : null, (i & 128) != 0 ? trackGuild.guildNumRoles : null, (i & 256) != 0 ? trackGuild.guildIsVip : null, (i & 512) != 0 ? trackGuild.isMember : bool2, (i & 1024) != 0 ? trackGuild.numVoiceChannelsActive : null, (i & 2048) != 0 ? trackGuild.isOwner : bool3);
    }

    /* renamed from: b, reason: from getter */
    public final Long getGuildId() {
        return this.guildId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackGuild)) {
            return false;
        }
        TrackGuild trackGuild = (TrackGuild) other;
        return Intrinsics3.areEqual(this.guildId, trackGuild.guildId) && Intrinsics3.areEqual(this.guildSizeTotal, trackGuild.guildSizeTotal) && Intrinsics3.areEqual(this.guildMemberNumRoles, trackGuild.guildMemberNumRoles) && Intrinsics3.areEqual(this.guildMemberPerms, trackGuild.guildMemberPerms) && Intrinsics3.areEqual(this.guildNumChannels, trackGuild.guildNumChannels) && Intrinsics3.areEqual(this.guildNumTextChannels, trackGuild.guildNumTextChannels) && Intrinsics3.areEqual(this.guildNumVoiceChannels, trackGuild.guildNumVoiceChannels) && Intrinsics3.areEqual(this.guildNumRoles, trackGuild.guildNumRoles) && Intrinsics3.areEqual(this.guildIsVip, trackGuild.guildIsVip) && Intrinsics3.areEqual(this.isMember, trackGuild.isMember) && Intrinsics3.areEqual(this.numVoiceChannelsActive, trackGuild.numVoiceChannelsActive) && Intrinsics3.areEqual(this.isOwner, trackGuild.isOwner);
    }

    public int hashCode() {
        Long l = this.guildId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.guildSizeTotal;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.guildMemberNumRoles;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.guildMemberPerms;
        int iHashCode4 = (iHashCode3 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.guildNumChannels;
        int iHashCode5 = (iHashCode4 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.guildNumTextChannels;
        int iHashCode6 = (iHashCode5 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.guildNumVoiceChannels;
        int iHashCode7 = (iHashCode6 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Long l8 = this.guildNumRoles;
        int iHashCode8 = (iHashCode7 + (l8 != null ? l8.hashCode() : 0)) * 31;
        Boolean bool = this.guildIsVip;
        int iHashCode9 = (iHashCode8 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.isMember;
        int iHashCode10 = (iHashCode9 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Long l9 = this.numVoiceChannelsActive;
        int iHashCode11 = (iHashCode10 + (l9 != null ? l9.hashCode() : 0)) * 31;
        Boolean bool3 = this.isOwner;
        return iHashCode11 + (bool3 != null ? bool3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackGuild(guildId=");
        sbU.append(this.guildId);
        sbU.append(", guildSizeTotal=");
        sbU.append(this.guildSizeTotal);
        sbU.append(", guildMemberNumRoles=");
        sbU.append(this.guildMemberNumRoles);
        sbU.append(", guildMemberPerms=");
        sbU.append(this.guildMemberPerms);
        sbU.append(", guildNumChannels=");
        sbU.append(this.guildNumChannels);
        sbU.append(", guildNumTextChannels=");
        sbU.append(this.guildNumTextChannels);
        sbU.append(", guildNumVoiceChannels=");
        sbU.append(this.guildNumVoiceChannels);
        sbU.append(", guildNumRoles=");
        sbU.append(this.guildNumRoles);
        sbU.append(", guildIsVip=");
        sbU.append(this.guildIsVip);
        sbU.append(", isMember=");
        sbU.append(this.isMember);
        sbU.append(", numVoiceChannelsActive=");
        sbU.append(this.numVoiceChannelsActive);
        sbU.append(", isOwner=");
        return outline.D(sbU, this.isOwner, ")");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TrackGuild(Long l, Long l2, Long l3, Long l4, Long l5, Long l6, Long l7, Long l8, Boolean bool, Boolean bool2, Long l9, Boolean bool3, int i) {
        this((i & 1) != 0 ? null : l, null, null, null, null, null, null, null, null, null, null, null);
        int i2 = i & 2;
        int i3 = i & 4;
        int i4 = i & 8;
        int i5 = i & 16;
        int i6 = i & 32;
        int i7 = i & 64;
        int i8 = i & 128;
        int i9 = i & 256;
        int i10 = i & 512;
        int i11 = i & 1024;
        int i12 = i & 2048;
    }
}
