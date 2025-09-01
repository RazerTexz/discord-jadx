package com.discord.widgets.stage.model;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.stageinstance.StageInstance;
import com.discord.models.guild.UserGuildMember;
import com.discord.models.user.User;
import com.discord.widgets.stage.StageRoles;
import d0.z.d.Intrinsics3;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: StageChannel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u001b\b\u0086\b\u0018\u00002\u00020\u0001Bl\u0012\u0006\u0010\u001e\u001a\u00020\u0002\u0012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010 \u001a\u0004\u0018\u00010\t\u0012\u0010\u0010!\u001a\f\u0012\b\u0012\u00060\u000ej\u0002`\u000f0\r\u0012\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00120\u0005\u0012\u0006\u0010#\u001a\u00020\u0014\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0017\u0012\u0006\u0010%\u001a\u00020\u001a\u0012\u0006\u0010&\u001a\u00020\u001aø\u0001\u0000¢\u0006\u0004\bC\u0010DJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\f\u001a\u0004\u0018\u00010\tHÆ\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u0010\u001a\f\u0012\b\u0012\u00060\u000ej\u0002`\u000f0\rHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0005HÆ\u0003¢\u0006\u0004\b\u0013\u0010\bJ\u0010\u0010\u0015\u001a\u00020\u0014HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u001aHÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001cJ\u008a\u0001\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u001e\u001a\u00020\u00022\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\t2\u0012\b\u0002\u0010!\u001a\f\u0012\b\u0012\u00060\u000ej\u0002`\u000f0\r2\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00120\u00052\b\b\u0002\u0010#\u001a\u00020\u00142\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010%\u001a\u00020\u001a2\b\b\u0002\u0010&\u001a\u00020\u001aHÆ\u0001ø\u0001\u0000ø\u0001\u0002¢\u0006\u0004\b'\u0010(J\u0010\u0010+\u001a\u00020*HÖ\u0001¢\u0006\u0004\b+\u0010,J\u0010\u0010-\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b-\u0010\u0016J\u001a\u0010/\u001a\u00020\u001a2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b/\u00100R$\u0010 \u001a\u0004\u0018\u00010\t8\u0006@\u0006ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\f\n\u0004\b \u00101\u001a\u0004\b2\u0010\u000bR\u0019\u0010%\u001a\u00020\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b%\u00103\u001a\u0004\b4\u0010\u001cR\u0019\u0010\u001e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u00105\u001a\u0004\b6\u0010\u0004R#\u0010!\u001a\f\u0012\b\u0012\u00060\u000ej\u0002`\u000f0\r8\u0006@\u0006¢\u0006\f\n\u0004\b!\u00107\u001a\u0004\b8\u0010\u0011R\u0019\u0010#\u001a\u00020\u00148\u0006@\u0006¢\u0006\f\n\u0004\b#\u00109\u001a\u0004\b:\u0010\u0016R\u001f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010;\u001a\u0004\b<\u0010\bR\u0013\u0010>\u001a\u00020\u001a8F@\u0006¢\u0006\u0006\u001a\u0004\b=\u0010\u001cR\u001f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00120\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010;\u001a\u0004\b?\u0010\bR\u001b\u0010$\u001a\u0004\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010@\u001a\u0004\bA\u0010\u0019R\u0019\u0010&\u001a\u00020\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b&\u00103\u001a\u0004\bB\u0010\u001c\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006E"}, d2 = {"Lcom/discord/widgets/stage/model/StageChannel;", "", "Lcom/discord/api/channel/Channel;", "component1", "()Lcom/discord/api/channel/Channel;", "", "Lcom/discord/models/user/User;", "component2", "()Ljava/util/List;", "Lcom/discord/widgets/stage/StageRoles;", "component3-twRsX-0", "()Lcom/discord/widgets/stage/StageRoles;", "component3", "", "", "Lcom/discord/primitives/UserId;", "component4", "()Ljava/util/Set;", "Lcom/discord/models/guild/UserGuildMember;", "component5", "", "component6", "()I", "Lcom/discord/api/stageinstance/StageInstance;", "component7", "()Lcom/discord/api/stageinstance/StageInstance;", "", "component8", "()Z", "component9", "channel", "participants", "myRoles", "speakerIds", "speakers", "audienceSize", "stageInstance", "canAccess", "containsMe", "copy-LcZnYPc", "(Lcom/discord/api/channel/Channel;Ljava/util/List;Lcom/discord/widgets/stage/StageRoles;Ljava/util/Set;Ljava/util/List;ILcom/discord/api/stageinstance/StageInstance;ZZ)Lcom/discord/widgets/stage/model/StageChannel;", "copy", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/widgets/stage/StageRoles;", "getMyRoles-twRsX-0", "Z", "getCanAccess", "Lcom/discord/api/channel/Channel;", "getChannel", "Ljava/util/Set;", "getSpeakerIds", "I", "getAudienceSize", "Ljava/util/List;", "getParticipants", "getHasActiveStageInstance", "hasActiveStageInstance", "getSpeakers", "Lcom/discord/api/stageinstance/StageInstance;", "getStageInstance", "getContainsMe", "<init>", "(Lcom/discord/api/channel/Channel;Ljava/util/List;Lcom/discord/widgets/stage/StageRoles;Ljava/util/Set;Ljava/util/List;ILcom/discord/api/stageinstance/StageInstance;ZZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class StageChannel {
    private final int audienceSize;
    private final boolean canAccess;
    private final Channel channel;
    private final boolean containsMe;
    private final StageRoles myRoles;
    private final List<User> participants;
    private final Set<Long> speakerIds;
    private final List<UserGuildMember> speakers;
    private final StageInstance stageInstance;

    /* JADX WARN: Multi-variable type inference failed */
    private StageChannel(Channel channel, List<? extends User> list, StageRoles stageRoles, Set<Long> set, List<UserGuildMember> list2, int i, StageInstance stageInstance, boolean z2, boolean z3) {
        this.channel = channel;
        this.participants = list;
        this.myRoles = stageRoles;
        this.speakerIds = set;
        this.speakers = list2;
        this.audienceSize = i;
        this.stageInstance = stageInstance;
        this.canAccess = z2;
        this.containsMe = z3;
    }

    /* renamed from: copy-LcZnYPc$default, reason: not valid java name */
    public static /* synthetic */ StageChannel m43copyLcZnYPc$default(StageChannel stageChannel, Channel channel, List list, StageRoles stageRoles, Set set, List list2, int i, StageInstance stageInstance, boolean z2, boolean z3, int i2, Object obj) {
        return stageChannel.m45copyLcZnYPc((i2 & 1) != 0 ? stageChannel.channel : channel, (i2 & 2) != 0 ? stageChannel.participants : list, (i2 & 4) != 0 ? stageChannel.myRoles : stageRoles, (i2 & 8) != 0 ? stageChannel.speakerIds : set, (i2 & 16) != 0 ? stageChannel.speakers : list2, (i2 & 32) != 0 ? stageChannel.audienceSize : i, (i2 & 64) != 0 ? stageChannel.stageInstance : stageInstance, (i2 & 128) != 0 ? stageChannel.canAccess : z2, (i2 & 256) != 0 ? stageChannel.containsMe : z3);
    }

    /* renamed from: component1, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    public final List<User> component2() {
        return this.participants;
    }

    /* renamed from: component3-twRsX-0, reason: not valid java name and from getter */
    public final StageRoles getMyRoles() {
        return this.myRoles;
    }

    public final Set<Long> component4() {
        return this.speakerIds;
    }

    public final List<UserGuildMember> component5() {
        return this.speakers;
    }

    /* renamed from: component6, reason: from getter */
    public final int getAudienceSize() {
        return this.audienceSize;
    }

    /* renamed from: component7, reason: from getter */
    public final StageInstance getStageInstance() {
        return this.stageInstance;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getCanAccess() {
        return this.canAccess;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getContainsMe() {
        return this.containsMe;
    }

    /* renamed from: copy-LcZnYPc, reason: not valid java name */
    public final StageChannel m45copyLcZnYPc(Channel channel, List<? extends User> participants, StageRoles myRoles, Set<Long> speakerIds, List<UserGuildMember> speakers, int audienceSize, StageInstance stageInstance, boolean canAccess, boolean containsMe) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        Intrinsics3.checkNotNullParameter(participants, "participants");
        Intrinsics3.checkNotNullParameter(speakerIds, "speakerIds");
        Intrinsics3.checkNotNullParameter(speakers, "speakers");
        return new StageChannel(channel, participants, myRoles, speakerIds, speakers, audienceSize, stageInstance, canAccess, containsMe);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StageChannel)) {
            return false;
        }
        StageChannel stageChannel = (StageChannel) other;
        return Intrinsics3.areEqual(this.channel, stageChannel.channel) && Intrinsics3.areEqual(this.participants, stageChannel.participants) && Intrinsics3.areEqual(this.myRoles, stageChannel.myRoles) && Intrinsics3.areEqual(this.speakerIds, stageChannel.speakerIds) && Intrinsics3.areEqual(this.speakers, stageChannel.speakers) && this.audienceSize == stageChannel.audienceSize && Intrinsics3.areEqual(this.stageInstance, stageChannel.stageInstance) && this.canAccess == stageChannel.canAccess && this.containsMe == stageChannel.containsMe;
    }

    public final int getAudienceSize() {
        return this.audienceSize;
    }

    public final boolean getCanAccess() {
        return this.canAccess;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final boolean getContainsMe() {
        return this.containsMe;
    }

    public final boolean getHasActiveStageInstance() {
        return this.stageInstance != null;
    }

    /* renamed from: getMyRoles-twRsX-0, reason: not valid java name */
    public final StageRoles m46getMyRolestwRsX0() {
        return this.myRoles;
    }

    public final List<User> getParticipants() {
        return this.participants;
    }

    public final Set<Long> getSpeakerIds() {
        return this.speakerIds;
    }

    public final List<UserGuildMember> getSpeakers() {
        return this.speakers;
    }

    public final StageInstance getStageInstance() {
        return this.stageInstance;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        Channel channel = this.channel;
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        List<User> list = this.participants;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        StageRoles stageRoles = this.myRoles;
        int iHashCode3 = (iHashCode2 + (stageRoles != null ? stageRoles.hashCode() : 0)) * 31;
        Set<Long> set = this.speakerIds;
        int iHashCode4 = (iHashCode3 + (set != null ? set.hashCode() : 0)) * 31;
        List<UserGuildMember> list2 = this.speakers;
        int iHashCode5 = (((iHashCode4 + (list2 != null ? list2.hashCode() : 0)) * 31) + this.audienceSize) * 31;
        StageInstance stageInstance = this.stageInstance;
        int iHashCode6 = (iHashCode5 + (stageInstance != null ? stageInstance.hashCode() : 0)) * 31;
        boolean z2 = this.canAccess;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iHashCode6 + i) * 31;
        boolean z3 = this.containsMe;
        return i2 + (z3 ? 1 : z3 ? 1 : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("StageChannel(channel=");
        sbU.append(this.channel);
        sbU.append(", participants=");
        sbU.append(this.participants);
        sbU.append(", myRoles=");
        sbU.append(this.myRoles);
        sbU.append(", speakerIds=");
        sbU.append(this.speakerIds);
        sbU.append(", speakers=");
        sbU.append(this.speakers);
        sbU.append(", audienceSize=");
        sbU.append(this.audienceSize);
        sbU.append(", stageInstance=");
        sbU.append(this.stageInstance);
        sbU.append(", canAccess=");
        sbU.append(this.canAccess);
        sbU.append(", containsMe=");
        return outline.O(sbU, this.containsMe, ")");
    }

    public /* synthetic */ StageChannel(Channel channel, List list, StageRoles stageRoles, Set set, List list2, int i, StageInstance stageInstance, boolean z2, boolean z3, DefaultConstructorMarker defaultConstructorMarker) {
        this(channel, list, stageRoles, set, list2, i, stageInstance, z2, z3);
    }
}
