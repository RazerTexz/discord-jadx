package com.discord.stores;

import b.c.a.a0.AnimatableValueParser;
import com.discord.api.channel.Channel;
import com.discord.api.permission.Permission;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.api.role.GuildRole;
import com.discord.api.voice.state.StageRequestToSpeakState;
import com.discord.api.voice.state.VoiceState;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.widgets.stage.StageRoles;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: StoreStageChannels.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001a0\u0019\u0012\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020 0\u0019¢\u0006\u0004\b\"\u0010#J#\u0010\b\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ/\u0010\f\u001a\u00020\u00072\n\u0010\u000b\u001a\u00060\u0002j\u0002`\n2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\f\u0010\rJ!\u0010\u000e\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u000e\u0010\tJ\u0019\u0010\u0010\u001a\u00020\u000f2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0010\u0010\u0011J*\u0010\u0015\u001a\u00020\u00122\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\"\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001a0\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\"\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020 0\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\u001c\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006$"}, d2 = {"Lcom/discord/stores/StageChannelRoleContext;", "", "", "Lcom/discord/primitives/UserId;", "userId", "Lcom/discord/models/member/GuildMember;", "member", "", "isSpeaker", "(JLcom/discord/models/member/GuildMember;)Z", "Lcom/discord/api/permission/PermissionBit;", "permission", "can", "(JJLcom/discord/models/member/GuildMember;)Z", "isModerator", "Lcom/discord/api/voice/state/StageRequestToSpeakState;", "getRequestToSpeakState", "(J)Lcom/discord/api/voice/state/StageRequestToSpeakState;", "Lcom/discord/widgets/stage/StageRoles;", "getRole-K-6mKVE", "(JLcom/discord/models/member/GuildMember;)I", "getRole", "Lcom/discord/models/guild/Guild;", "guild", "Lcom/discord/models/guild/Guild;", "", "Lcom/discord/api/role/GuildRole;", "guildRolesMap", "Ljava/util/Map;", "Lcom/discord/api/channel/Channel;", "channel", "Lcom/discord/api/channel/Channel;", "Lcom/discord/api/voice/state/VoiceState;", "voiceStates", "<init>", "(Lcom/discord/models/guild/Guild;Lcom/discord/api/channel/Channel;Ljava/util/Map;Ljava/util/Map;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.stores.StageChannelRoleContext, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreStageChannels2 {
    private final Channel channel;
    private final Guild guild;
    private final Map<Long, GuildRole> guildRolesMap;
    private final Map<Long, VoiceState> voiceStates;

    public StoreStageChannels2(Guild guild, Channel channel, Map<Long, GuildRole> map, Map<Long, VoiceState> map2) {
        Intrinsics3.checkNotNullParameter(guild, "guild");
        Intrinsics3.checkNotNullParameter(channel, "channel");
        Intrinsics3.checkNotNullParameter(map, "guildRolesMap");
        Intrinsics3.checkNotNullParameter(map2, "voiceStates");
        this.guild = guild;
        this.channel = channel;
        this.guildRolesMap = map;
        this.voiceStates = map2;
    }

    private final boolean can(long permission, long userId, GuildMember member) {
        long id2 = this.guild.getId();
        long ownerId = this.guild.getOwnerId();
        Map<Long, GuildRole> map = this.guildRolesMap;
        List<PermissionOverwrite> listV = this.channel.v();
        if (listV == null) {
            listV = Collections2.emptyList();
        }
        return PermissionUtils.can(permission, Long.valueOf(PermissionUtils.computeNonThreadPermissions(userId, id2, ownerId, member, map, listV)));
    }

    private final boolean isSpeaker(long userId, GuildMember member) {
        return this.voiceStates.get(Long.valueOf(userId)) != null ? getRequestToSpeakState(userId) == StageRequestToSpeakState.ON_STAGE : can(Permission.SPEAK, userId, member);
    }

    public final StageRequestToSpeakState getRequestToSpeakState(long userId) {
        return AnimatableValueParser.y0(this.voiceStates.get(Long.valueOf(userId)));
    }

    /* renamed from: getRole-K-6mKVE, reason: not valid java name */
    public final int m7getRoleK6mKVE(long userId, GuildMember member) {
        Intrinsics3.checkNotNullParameter(member, "member");
        return StageRoles.INSTANCE.m38invokeH48EO60(isSpeaker(userId, member), isModerator(userId, member), getRequestToSpeakState(userId) == StageRequestToSpeakState.REQUESTED_TO_SPEAK_AND_AWAITING_USER_ACK);
    }

    public final boolean isModerator(long userId, GuildMember member) {
        Intrinsics3.checkNotNullParameter(member, "member");
        return can(20971536L, userId, member);
    }
}
