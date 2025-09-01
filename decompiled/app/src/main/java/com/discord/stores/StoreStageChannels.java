package com.discord.stores;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.permission.Permission;
import com.discord.api.role.GuildRole;
import com.discord.api.stageinstance.StageInstance;
import com.discord.api.voice.state.StageRequestToSpeakState;
import com.discord.api.voice.state.VoiceState;
import com.discord.models.guild.Guild;
import com.discord.models.guild.UserGuildMember;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.widgets.stage.StageChannelNotifications;
import com.discord.widgets.stage.StageRoles;
import com.discord.widgets.stage.model.StageChannel;
import d0.d0._Ranges;
import d0.f0._Sequences2;
import d0.f0.n;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.t.MutableCollections;
import d0.t.Sets5;
import d0.t._Collections;
import d0.t._Sets;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.sequences.Sequence;
import rx.Observable;

/* compiled from: StoreStageChannels.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u0088\u00012\u00020\u0001:\u0004\u0088\u0001\u0089\u0001BG\u0012\u0006\u0010d\u001a\u00020c\u0012\u0006\u0010z\u001a\u00020y\u0012\u0006\u0010g\u001a\u00020f\u0012\u0006\u0010~\u001a\u00020}\u0012\b\u0010\u0081\u0001\u001a\u00030\u0080\u0001\u0012\b\u0010\u0084\u0001\u001a\u00030\u0083\u0001\u0012\b\b\u0002\u0010w\u001a\u00020v¢\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001J;\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\fJ1\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\u000e\u001a\u00020\u0007H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010J;\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\u0012\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u0007H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u00192\n\u0010\u0018\u001a\u00060\u0004j\u0002`\u0017H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJd\u0010#\u001a\u00020\u00072\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u001a\b\u0002\u0010\u001e\u001a\u0014\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c2\u001a\b\u0002\u0010\u000e\u001a\u0014\u0012\b\u0012\u00060\u0004j\u0002`\u001f\u0012\u0004\u0012\u00020 \u0018\u00010\u001cH\u0002ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b!\u0010\"J]\u0010'\u001a\u0004\u0018\u00010&2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$2\u001a\b\u0002\u0010\u001e\u001a\u0014\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c2\u001a\b\u0002\u0010\u000e\u001a\u0014\u0012\b\u0012\u00060\u0004j\u0002`\u001f\u0012\u0004\u0012\u00020 \u0018\u00010\u001cH\u0002¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\nH\u0002¢\u0006\u0004\b)\u0010*J0\u0010/\u001a\u0004\u0018\u00010\u00072\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\n\u0010,\u001a\u00060\u0004j\u0002`+ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b-\u0010.J$\u00102\u001a\u0004\u0018\u00010\u00072\n\u0010,\u001a\u00060\u0004j\u0002`+ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b0\u00101J0\u00104\u001a\u0004\u0018\u00010\u00072\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\n\u0010,\u001a\u00060\u0004j\u0002`+ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b3\u0010.J$\u00106\u001a\u0004\u0018\u00010\u00072\n\u0010,\u001a\u00060\u0004j\u0002`+ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b5\u00101J.\u00107\u001a\u0014\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001c2\n\u0010,\u001a\u00060\u0004j\u0002`+ø\u0001\u0000¢\u0006\u0004\b7\u00108J.\u00109\u001a\u0014\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001c2\n\u0010,\u001a\u00060\u0004j\u0002`+ø\u0001\u0000¢\u0006\u0004\b9\u00108J\u0085\u0001\u0010?\u001a\u0012\u0012\b\u0012\u00060\u0004j\u0002`+\u0012\u0004\u0012\u00020>0\u001c2\n\u0010\u0018\u001a\u00060\u0004j\u0002`\u00172\u0018\b\u0002\u0010:\u001a\u0012\u0012\b\u0012\u00060\u0004j\u0002`+\u0012\u0004\u0012\u00020\u00020\u001c2\f\b\u0002\u0010;\u001a\u00060\u0004j\u0002`\u00052\u0018\b\u0002\u0010=\u001a\u0012\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0004\u0012\u00020<0\u001c2\u0018\b\u0002\u0010\u001e\u001a\u0012\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0004\u0012\u00020\u001d0\u001c¢\u0006\u0004\b?\u0010@J#\u0010B\u001a\u00020A2\u0006\u0010\u0003\u001a\u00020\u00022\f\b\u0002\u0010;\u001a\u00060\u0004j\u0002`\u0005¢\u0006\u0004\bB\u0010CJ/\u0010E\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0004j\u0002`+\u0012\u0004\u0012\u00020>0\u001c0D2\n\u0010\u0018\u001a\u00060\u0004j\u0002`\u0017¢\u0006\u0004\bE\u0010FJ#\u0010G\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0004j\u0002`+\u0012\u0004\u0012\u00020>0\u001c0D¢\u0006\u0004\bG\u0010HJ6\u0010I\u001a(\u0012$\u0012\"\u0012\b\u0012\u00060\u0004j\u0002`+\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0004\u0012\u00020\u00070\u001c0\u001c0Dø\u0001\u0000¢\u0006\u0004\bI\u0010HJ0\u0010J\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070D2\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\n\u0010,\u001a\u00060\u0004j\u0002`+ø\u0001\u0000¢\u0006\u0004\bJ\u0010KJ$\u0010L\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070D2\n\u0010,\u001a\u00060\u0004j\u0002`+ø\u0001\u0000¢\u0006\u0004\bL\u0010FJ4\u0010M\u001a\u001a\u0012\u0016\u0012\u0014\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001c0D2\n\u0010,\u001a\u00060\u0004j\u0002`+ø\u0001\u0000¢\u0006\u0004\bM\u0010FJ\u001f\u0010O\u001a\b\u0012\u0004\u0012\u00020N0D2\n\u0010,\u001a\u00060\u0004j\u0002`+¢\u0006\u0004\bO\u0010FJ+\u0010P\u001a\b\u0012\u0004\u0012\u00020N0D2\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\n\u0010,\u001a\u00060\u0004j\u0002`+¢\u0006\u0004\bP\u0010KJ\u000f\u0010Q\u001a\u00020\nH\u0007¢\u0006\u0004\bQ\u0010*J3\u0010S\u001a\u00020\n2\n\u0010\u0018\u001a\u00060\u0004j\u0002`\u00172\n\u0010R\u001a\u00060\u0004j\u0002`+2\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0007¢\u0006\u0004\bS\u0010TJ\u0017\u0010V\u001a\u00020\n2\u0006\u0010%\u001a\u00020UH\u0007¢\u0006\u0004\bV\u0010WJ\u0017\u0010X\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\bX\u0010YJ\u0017\u0010\\\u001a\u00020\n2\u0006\u0010[\u001a\u00020ZH\u0007¢\u0006\u0004\b\\\u0010]J'\u0010^\u001a\u00020\n2\n\u0010\u0018\u001a\u00060\u0004j\u0002`\u00172\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0007¢\u0006\u0004\b^\u0010_J\u001b\u0010`\u001a\u00020\n2\n\u0010\u0018\u001a\u00060\u0004j\u0002`\u0017H\u0007¢\u0006\u0004\b`\u0010aJ\u000f\u0010b\u001a\u00020\nH\u0017¢\u0006\u0004\bb\u0010*R\u0016\u0010d\u001a\u00020c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bd\u0010eR\u0016\u0010g\u001a\u00020f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bg\u0010hR9\u0010j\u001a\"\u0012\b\u0012\u00060\u0004j\u0002`+\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0004\u0012\u00020\u00070i0i8\u0002@\u0002X\u0082\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\bj\u0010kR \u0010m\u001a\f\u0012\b\u0012\u00060\u0004j\u0002`+0l8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bm\u0010nR*\u0010q\u001a\u0012\u0012\b\u0012\u00060\u0004j\u0002`\u001f\u0012\u0004\u0012\u00020 0\u001c*\u00020$8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bo\u0010pR\u001c\u0010%\u001a\u0004\u0018\u00010$*\u00020\u00028B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\br\u0010sR6\u0010u\u001a\"\u0012\b\u0012\u00060\u0004j\u0002`\u0017\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0004j\u0002`+\u0012\u0004\u0012\u00020t0i0i8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bu\u0010kR\u0016\u0010w\u001a\u00020v8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bw\u0010xR\u0016\u0010z\u001a\u00020y8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bz\u0010{R9\u0010|\u001a\"\u0012\b\u0012\u00060\u0004j\u0002`+\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0004\u0012\u00020\u00070\u001c0\u001c8\u0002@\u0002X\u0082\u000eø\u0001\u0000¢\u0006\u0006\n\u0004\b|\u0010kR\u0016\u0010~\u001a\u00020}8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b~\u0010\u007fR\u001a\u0010\u0081\u0001\u001a\u00030\u0080\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R\u001a\u0010\u0084\u0001\u001a\u00030\u0083\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0084\u0001\u0010\u0085\u0001\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u008a\u0001"}, d2 = {"Lcom/discord/stores/StoreStageChannels;", "Lcom/discord/stores/StoreV2;", "Lcom/discord/api/channel/Channel;", "channel", "", "Lcom/discord/primitives/UserId;", "userId", "Lcom/discord/widgets/stage/StageRoles;", "oldRole", "newRole", "", "handleUserRoleChange-uOJZ9lM", "(Lcom/discord/api/channel/Channel;JLcom/discord/widgets/stage/StageRoles;I)V", "handleUserRoleChange", "roles", "handleUserJoinedStageOrGainedRole-oRmTEFA", "(Lcom/discord/api/channel/Channel;JI)V", "handleUserJoinedStageOrGainedRole", "oldRoles", "newRoles", "handleUserLeftStageOrLostRoles-GM3QuyE", "(Lcom/discord/api/channel/Channel;JII)V", "handleUserLeftStageOrLostRoles", "Lcom/discord/primitives/GuildId;", "guildId", "Lkotlin/sequences/Sequence;", "stageChannelIdsInGuildForDispatch", "(J)Lkotlin/sequences/Sequence;", "", "Lcom/discord/api/voice/state/VoiceState;", "voiceStates", "Lcom/discord/primitives/RoleId;", "Lcom/discord/api/role/GuildRole;", "computeUserRolesInDispatch-t27eFtU", "(JLcom/discord/api/channel/Channel;Ljava/util/Map;Ljava/util/Map;)I", "computeUserRolesInDispatch", "Lcom/discord/models/guild/Guild;", "guild", "Lcom/discord/stores/StageChannelRoleContext;", "roleContext", "(Lcom/discord/api/channel/Channel;Lcom/discord/models/guild/Guild;Ljava/util/Map;Ljava/util/Map;)Lcom/discord/stores/StageChannelRoleContext;", "markStageEventDirty", "()V", "Lcom/discord/primitives/ChannelId;", "channelId", "getUserRoles-uOBN1zc", "(JJ)Lcom/discord/widgets/stage/StageRoles;", "getUserRoles", "getMyRoles-visDeB4", "(J)Lcom/discord/widgets/stage/StageRoles;", "getMyRoles", "getUserRolesInternal-uOBN1zc", "getUserRolesInternal", "getMyRolesInternal-visDeB4", "getMyRolesInternal", "getChannelRolesInternal", "(J)Ljava/util/Map;", "getChannelRoles", "channelsInGuild", "myId", "Lcom/discord/models/user/User;", "users", "Lcom/discord/widgets/stage/model/StageChannel;", "getStageChannelsInGuild", "(JLjava/util/Map;JLjava/util/Map;Ljava/util/Map;)Ljava/util/Map;", "", "getOtherModeratorsCountInChannel", "(Lcom/discord/api/channel/Channel;J)I", "Lrx/Observable;", "observeGuildStageChannels", "(J)Lrx/Observable;", "observeStageChannels", "()Lrx/Observable;", "observeRoles", "observeUserRoles", "(JJ)Lrx/Observable;", "observeMyRoles", "observeStageRolesByChannel", "Lcom/discord/api/voice/state/StageRequestToSpeakState;", "observeMyRequestToSpeakState", "observeUserRequestToSpeakState", "handleConnectionOpen", "fromChannelId", "handleVoiceStatesUpdated", "(JJJ)V", "Lcom/discord/api/guild/Guild;", "handleGuildRemove", "(Lcom/discord/api/guild/Guild;)V", "handleChannelDelete", "(Lcom/discord/api/channel/Channel;)V", "Lcom/discord/api/guildmember/GuildMember;", "member", "handleGuildMemberAdd", "(Lcom/discord/api/guildmember/GuildMember;)V", "handleGuildMemberRemove", "(JJ)V", "handleGuildRoleCreateOrUpdate", "(J)V", "snapshotData", "Lcom/discord/stores/StoreUser;", "userStore", "Lcom/discord/stores/StoreUser;", "Lcom/discord/stores/StoreChannels;", "channelsStore", "Lcom/discord/stores/StoreChannels;", "", "stageRolesByChannel", "Ljava/util/Map;", "", "dirtyChannelIds", "Ljava/util/Set;", "getRolesMap", "(Lcom/discord/models/guild/Guild;)Ljava/util/Map;", "rolesMap", "getGuild", "(Lcom/discord/api/channel/Channel;)Lcom/discord/models/guild/Guild;", "Lcom/discord/stores/StoreStageChannels$StageEventActivationState;", "stageEventStates", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "Lcom/discord/stores/StoreGuilds;", "guildsStore", "Lcom/discord/stores/StoreGuilds;", "stageRolesByChannelSnapshot", "Lcom/discord/stores/StoreVoiceStates;", "voiceStatesStore", "Lcom/discord/stores/StoreVoiceStates;", "Lcom/discord/stores/StorePermissions;", "permissionsStore", "Lcom/discord/stores/StorePermissions;", "Lcom/discord/stores/StoreStageInstances;", "stageInstancesStore", "Lcom/discord/stores/StoreStageInstances;", "<init>", "(Lcom/discord/stores/StoreUser;Lcom/discord/stores/StoreGuilds;Lcom/discord/stores/StoreChannels;Lcom/discord/stores/StoreVoiceStates;Lcom/discord/stores/StorePermissions;Lcom/discord/stores/StoreStageInstances;Lcom/discord/stores/updates/ObservationDeck;)V", "Companion", "StageEventActivationState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreStageChannels extends StoreV2 {
    public static final long CAN_MODERATE_STAGE_CHANNELS = 20971536;
    private static final StoreStageChannels3 EventStateUpdateSource = new StoreStageChannels3();
    private final StoreChannels channelsStore;
    private final Set<Long> dirtyChannelIds;
    private final StoreGuilds guildsStore;
    private final ObservationDeck observationDeck;
    private final StorePermissions permissionsStore;
    private final Map<Long, Map<Long, StageEventActivationState>> stageEventStates;
    private final StoreStageInstances stageInstancesStore;
    private final Map<Long, Map<Long, StageRoles>> stageRolesByChannel;
    private Map<Long, ? extends Map<Long, StageRoles>> stageRolesByChannelSnapshot;
    private final StoreUser userStore;
    private final StoreVoiceStates voiceStatesStore;

    /* compiled from: StoreStageChannels.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0082\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\b\u0002\u0010\u0007\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J$\u0010\b\u001a\u00020\u00002\u0012\b\u0002\u0010\u0007\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R#\u0010\u0007\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\u0006¨\u0006\u0018"}, d2 = {"Lcom/discord/stores/StoreStageChannels$StageEventActivationState;", "", "", "", "Lcom/discord/primitives/UserId;", "component1", "()Ljava/util/Set;", "moderators", "copy", "(Ljava/util/Set;)Lcom/discord/stores/StoreStageChannels$StageEventActivationState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Set;", "getModerators", "<init>", "(Ljava/util/Set;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class StageEventActivationState {
        private final Set<Long> moderators;

        public StageEventActivationState() {
            this(null, 1, null);
        }

        public StageEventActivationState(Set<Long> set) {
            Intrinsics3.checkNotNullParameter(set, "moderators");
            this.moderators = set;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StageEventActivationState copy$default(StageEventActivationState stageEventActivationState, Set set, int i, Object obj) {
            if ((i & 1) != 0) {
                set = stageEventActivationState.moderators;
            }
            return stageEventActivationState.copy(set);
        }

        public final Set<Long> component1() {
            return this.moderators;
        }

        public final StageEventActivationState copy(Set<Long> moderators) {
            Intrinsics3.checkNotNullParameter(moderators, "moderators");
            return new StageEventActivationState(moderators);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof StageEventActivationState) && Intrinsics3.areEqual(this.moderators, ((StageEventActivationState) other).moderators);
            }
            return true;
        }

        public final Set<Long> getModerators() {
            return this.moderators;
        }

        public int hashCode() {
            Set<Long> set = this.moderators;
            if (set != null) {
                return set.hashCode();
            }
            return 0;
        }

        public String toString() {
            return outline.N(outline.U("StageEventActivationState(moderators="), this.moderators, ")");
        }

        public /* synthetic */ StageEventActivationState(Set set, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? Sets5.emptySet() : set);
        }
    }

    /* compiled from: StoreStageChannels.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u0012\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u00030\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/widgets/stage/model/StageChannel;", "invoke", "()Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreStageChannels$observeGuildStageChannels$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends StageChannel>> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends StageChannel> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends StageChannel> invoke2() {
            StoreStageChannels storeStageChannels = StoreStageChannels.this;
            long j = this.$guildId;
            Map<Long, Channel> channelsForGuild = StoreStageChannels.access$getChannelsStore$p(storeStageChannels).getChannelsForGuild(this.$guildId);
            long id2 = StoreStageChannels.access$getUserStore$p(StoreStageChannels.this).getMeSnapshot().getId();
            Map<Long, User> users = StoreStageChannels.access$getUserStore$p(StoreStageChannels.this).getUsers();
            Map<Long, VoiceState> mapEmptyMap = StoreStageChannels.access$getVoiceStatesStore$p(StoreStageChannels.this).get().get(Long.valueOf(this.$guildId));
            if (mapEmptyMap == null) {
                mapEmptyMap = Maps6.emptyMap();
            }
            return storeStageChannels.getStageChannelsInGuild(j, channelsForGuild, id2, users, mapEmptyMap);
        }
    }

    /* compiled from: StoreStageChannels.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/api/voice/state/StageRequestToSpeakState;", "invoke", "()Lcom/discord/api/voice/state/StageRequestToSpeakState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreStageChannels$observeMyRequestToSpeakState$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<StageRequestToSpeakState> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ StageRequestToSpeakState invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final StageRequestToSpeakState invoke() {
            StageRequestToSpeakState requestToSpeakState;
            Channel channel = StoreStageChannels.access$getChannelsStore$p(StoreStageChannels.this).getChannel(this.$channelId);
            if (channel == null) {
                return StageRequestToSpeakState.NONE;
            }
            StoreStageChannels2 storeStageChannels2RoleContext$default = StoreStageChannels.roleContext$default(StoreStageChannels.this, channel, null, null, null, 14, null);
            return (storeStageChannels2RoleContext$default == null || (requestToSpeakState = storeStageChannels2RoleContext$default.getRequestToSpeakState(StoreStageChannels.access$getUserStore$p(StoreStageChannels.this).getMeSnapshot().getId())) == null) ? StageRequestToSpeakState.NONE : requestToSpeakState;
        }
    }

    /* compiled from: StoreStageChannels.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/stage/StageRoles;", "invoke", "()Lcom/discord/widgets/stage/StageRoles;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreStageChannels$observeMyRoles$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<StageRoles> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ StageRoles invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final StageRoles invoke() {
            Channel channel = StoreStageChannels.access$getChannelsStore$p(StoreStageChannels.this).getChannel(this.$channelId);
            if (channel != null) {
                return StoreStageChannels.this.m15getMyRolesvisDeB4(channel.getId());
            }
            return null;
        }
    }

    /* compiled from: StoreStageChannels.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\"\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0001j\u0002`\u0003\u0012\u0004\u0012\u00020\u00040\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/primitives/UserId;", "Lcom/discord/widgets/stage/StageRoles;", "invoke", "()Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreStageChannels$observeRoles$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends Map<Long, ? extends StageRoles>>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends Map<Long, ? extends StageRoles>> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends Map<Long, ? extends StageRoles>> invoke2() {
            return StoreStageChannels.access$getStageRolesByChannelSnapshot$p(StoreStageChannels.this);
        }
    }

    /* compiled from: StoreStageChannels.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u0012\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u00030\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/widgets/stage/model/StageChannel;", "invoke", "()Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreStageChannels$observeStageChannels$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends StageChannel>> {

        /* compiled from: StoreStageChannels.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\u0012\u0012\b\u0012\u00060\u0000j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u00032\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Lcom/discord/primitives/GuildId;", "guildId", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/widgets/stage/model/StageChannel;", "invoke", "(J)Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreStageChannels$observeStageChannels$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01731 extends Lambda implements Function1<Long, Map<Long, ? extends StageChannel>> {
            public C01731() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Map<Long, ? extends StageChannel> invoke(Long l) {
                return invoke(l.longValue());
            }

            public final Map<Long, StageChannel> invoke(long j) {
                return StoreStageChannels.getStageChannelsInGuild$default(StoreStageChannels.this, j, null, 0L, null, null, 30, null);
            }
        }

        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends StageChannel> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends StageChannel> invoke2() {
            Object obj;
            Iterator it = _Sequences2.map(_Collections.asSequence(StoreStageChannels.access$getGuildsStore$p(StoreStageChannels.this).getGuilds().keySet()), new C01731()).iterator();
            if (it.hasNext()) {
                Object next = it.next();
                while (it.hasNext()) {
                    next = Maps6.plus((Map) next, (Map) it.next());
                }
                obj = next;
            } else {
                obj = null;
            }
            Map<Long, ? extends StageChannel> map = (Map) obj;
            return map != null ? map : Maps6.emptyMap();
        }
    }

    /* compiled from: StoreStageChannels.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/widgets/stage/StageRoles;", "invoke", "()Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreStageChannels$observeStageRolesByChannel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends StageRoles>> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends StageRoles> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends StageRoles> invoke2() {
            return (Map) StoreStageChannels.access$getStageRolesByChannelSnapshot$p(StoreStageChannels.this).get(Long.valueOf(this.$channelId));
        }
    }

    /* compiled from: StoreStageChannels.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/api/voice/state/StageRequestToSpeakState;", "invoke", "()Lcom/discord/api/voice/state/StageRequestToSpeakState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreStageChannels$observeUserRequestToSpeakState$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<StageRequestToSpeakState> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ long $userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, long j2) {
            super(0);
            this.$channelId = j;
            this.$userId = j2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ StageRequestToSpeakState invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final StageRequestToSpeakState invoke() {
            StageRequestToSpeakState requestToSpeakState;
            Channel channel = StoreStageChannels.access$getChannelsStore$p(StoreStageChannels.this).getChannel(this.$channelId);
            if (channel == null) {
                return StageRequestToSpeakState.NONE;
            }
            StoreStageChannels2 storeStageChannels2RoleContext$default = StoreStageChannels.roleContext$default(StoreStageChannels.this, channel, null, null, null, 14, null);
            return (storeStageChannels2RoleContext$default == null || (requestToSpeakState = storeStageChannels2RoleContext$default.getRequestToSpeakState(this.$userId)) == null) ? StageRequestToSpeakState.NONE : requestToSpeakState;
        }
    }

    /* compiled from: StoreStageChannels.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/stage/StageRoles;", "invoke", "()Lcom/discord/widgets/stage/StageRoles;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreStageChannels$observeUserRoles$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<StageRoles> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ long $userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, long j2) {
            super(0);
            this.$channelId = j;
            this.$userId = j2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ StageRoles invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final StageRoles invoke() {
            Channel channel = StoreStageChannels.access$getChannelsStore$p(StoreStageChannels.this).getChannel(this.$channelId);
            if (channel != null) {
                return StoreStageChannels.this.m17getUserRolesuOBN1zc(this.$userId, channel.getId());
            }
            return null;
        }
    }

    /* compiled from: StoreStageChannels.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/channel/Channel;", "channel", "", "invoke", "(Lcom/discord/api/channel/Channel;)Ljava/lang/Long;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreStageChannels$stageChannelIdsInGuildForDispatch$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Channel, Long> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Long invoke(Channel channel) {
            return invoke2(channel);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Long invoke2(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Long lValueOf = Long.valueOf(channel.getId());
            lValueOf.longValue();
            if (ChannelUtils.D(channel)) {
                return lValueOf;
            }
            return null;
        }
    }

    public /* synthetic */ StoreStageChannels(StoreUser storeUser, StoreGuilds storeGuilds, StoreChannels storeChannels, StoreVoiceStates storeVoiceStates, StorePermissions storePermissions, StoreStageInstances storeStageInstances, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storeUser, storeGuilds, storeChannels, storeVoiceStates, storePermissions, storeStageInstances, (i & 64) != 0 ? ObservationDeck4.get() : observationDeck);
    }

    public static final /* synthetic */ StoreChannels access$getChannelsStore$p(StoreStageChannels storeStageChannels) {
        return storeStageChannels.channelsStore;
    }

    public static final /* synthetic */ StoreGuilds access$getGuildsStore$p(StoreStageChannels storeStageChannels) {
        return storeStageChannels.guildsStore;
    }

    public static final /* synthetic */ Map access$getStageRolesByChannelSnapshot$p(StoreStageChannels storeStageChannels) {
        return storeStageChannels.stageRolesByChannelSnapshot;
    }

    public static final /* synthetic */ StoreUser access$getUserStore$p(StoreStageChannels storeStageChannels) {
        return storeStageChannels.userStore;
    }

    public static final /* synthetic */ StoreVoiceStates access$getVoiceStatesStore$p(StoreStageChannels storeStageChannels) {
        return storeStageChannels.voiceStatesStore;
    }

    public static final /* synthetic */ void access$setStageRolesByChannelSnapshot$p(StoreStageChannels storeStageChannels, Map map) {
        storeStageChannels.stageRolesByChannelSnapshot = map;
    }

    /* renamed from: computeUserRolesInDispatch-t27eFtU, reason: not valid java name */
    private final int m9computeUserRolesInDispatcht27eFtU(long userId, Channel channel, Map<Long, VoiceState> voiceStates, Map<Long, GuildRole> roles) {
        Guild guild = (Guild) outline.c(channel, this.guildsStore.getGuildsInternal$app_productionGoogleRelease());
        if (guild == null) {
            return StageRoles.INSTANCE.m37getAUDIENCE1LxfuJo();
        }
        Map map = (Map) outline.c(channel, this.guildsStore.getGuildMembersComputedInternal$app_productionGoogleRelease());
        if (map == null) {
            return StageRoles.INSTANCE.m37getAUDIENCE1LxfuJo();
        }
        GuildMember guildMember = (GuildMember) map.get(Long.valueOf(userId));
        if (guildMember == null) {
            return StageRoles.INSTANCE.m37getAUDIENCE1LxfuJo();
        }
        if (roles == null) {
            roles = (Map) outline.c(channel, this.guildsStore.getGuildRolesInternal$app_productionGoogleRelease());
        }
        if (voiceStates == null) {
            voiceStates = (Map) outline.c(channel, this.voiceStatesStore.getInternal$app_productionGoogleRelease());
        }
        if (voiceStates == null) {
            return StageRoles.INSTANCE.m37getAUDIENCE1LxfuJo();
        }
        StoreStageChannels2 storeStageChannels2RoleContext = roleContext(channel, guild, voiceStates, roles);
        return storeStageChannels2RoleContext != null ? storeStageChannels2RoleContext.m7getRoleK6mKVE(userId, guildMember) : StageRoles.INSTANCE.m37getAUDIENCE1LxfuJo();
    }

    /* renamed from: computeUserRolesInDispatch-t27eFtU$default, reason: not valid java name */
    public static /* synthetic */ int m10computeUserRolesInDispatcht27eFtU$default(StoreStageChannels storeStageChannels, long j, Channel channel, Map map, Map map2, int i, Object obj) {
        return storeStageChannels.m9computeUserRolesInDispatcht27eFtU(j, channel, (i & 4) != 0 ? null : map, (i & 8) != 0 ? null : map2);
    }

    private final Guild getGuild(Channel channel) {
        return (Guild) outline.c(channel, this.guildsStore.getGuilds());
    }

    public static /* synthetic */ int getOtherModeratorsCountInChannel$default(StoreStageChannels storeStageChannels, Channel channel, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = storeStageChannels.userStore.getMeSnapshot().getId();
        }
        return storeStageChannels.getOtherModeratorsCountInChannel(channel, j);
    }

    private final Map<Long, GuildRole> getRolesMap(Guild guild) {
        Map<Long, GuildRole> map = (Map) outline.e(guild, this.guildsStore.getRoles());
        return map != null ? map : Maps6.emptyMap();
    }

    public static /* synthetic */ Map getStageChannelsInGuild$default(StoreStageChannels storeStageChannels, long j, Map map, long j2, Map map2, Map map3, int i, Object obj) {
        Map map4;
        Map channelsForGuild = (i & 2) != 0 ? storeStageChannels.channelsStore.getChannelsForGuild(j) : map;
        long id2 = (i & 4) != 0 ? storeStageChannels.userStore.getMeSnapshot().getId() : j2;
        Map users = (i & 8) != 0 ? storeStageChannels.userStore.getUsers() : map2;
        if ((i & 16) != 0) {
            Map<Long, VoiceState> mapEmptyMap = storeStageChannels.voiceStatesStore.get().get(Long.valueOf(j));
            if (mapEmptyMap == null) {
                mapEmptyMap = Maps6.emptyMap();
            }
            map4 = mapEmptyMap;
        } else {
            map4 = map3;
        }
        return storeStageChannels.getStageChannelsInGuild(j, channelsForGuild, id2, users, map4);
    }

    /* renamed from: handleUserJoinedStageOrGainedRole-oRmTEFA, reason: not valid java name */
    private final void m11handleUserJoinedStageOrGainedRoleoRmTEFA(Channel channel, long userId, int roles) {
        if (StageRoles.m32isModeratorimpl(roles) || StageRoles.m33isSpeakerimpl(roles)) {
            Map<Long, StageEventActivationState> linkedHashMap = (Map) outline.c(channel, this.stageEventStates);
            if (linkedHashMap == null) {
                linkedHashMap = new LinkedHashMap<>();
                this.stageEventStates.put(Long.valueOf(channel.getGuildId()), linkedHashMap);
            }
            StageEventActivationState stageEventActivationState = (StageEventActivationState) outline.d(channel, linkedHashMap);
            if (stageEventActivationState == null) {
                stageEventActivationState = new StageEventActivationState(null, 1, null);
                linkedHashMap.put(Long.valueOf(channel.getId()), stageEventActivationState);
            }
            boolean z2 = StageRoles.m32isModeratorimpl(roles) && !stageEventActivationState.getModerators().contains(Long.valueOf(userId));
            if (z2) {
                linkedHashMap.put(Long.valueOf(channel.getId()), stageEventActivationState.copy(z2 ? _Sets.plus(stageEventActivationState.getModerators(), Long.valueOf(userId)) : stageEventActivationState.getModerators()));
                markStageEventDirty();
            }
        }
    }

    /* renamed from: handleUserLeftStageOrLostRoles-GM3QuyE, reason: not valid java name */
    private final void m12handleUserLeftStageOrLostRolesGM3QuyE(Channel channel, long userId, int oldRoles, int newRoles) {
        Map map;
        StageEventActivationState stageEventActivationState;
        if ((!StageRoles.m32isModeratorimpl(oldRoles) && !StageRoles.m33isSpeakerimpl(oldRoles)) || (map = (Map) outline.c(channel, this.stageEventStates)) == null || (stageEventActivationState = (StageEventActivationState) outline.d(channel, map)) == null) {
            return;
        }
        boolean z2 = !StageRoles.m32isModeratorimpl(newRoles) && StageRoles.m32isModeratorimpl(oldRoles) && stageEventActivationState.getModerators().contains(Long.valueOf(userId));
        if (z2) {
            map.put(Long.valueOf(channel.getId()), stageEventActivationState.copy(z2 ? _Sets.minus(stageEventActivationState.getModerators(), Long.valueOf(userId)) : stageEventActivationState.getModerators()));
            markStageEventDirty();
        }
    }

    /* renamed from: handleUserLeftStageOrLostRoles-GM3QuyE$default, reason: not valid java name */
    public static /* synthetic */ void m13handleUserLeftStageOrLostRolesGM3QuyE$default(StoreStageChannels storeStageChannels, Channel channel, long j, int i, int i2, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            i2 = StageRoles.INSTANCE.m37getAUDIENCE1LxfuJo();
        }
        storeStageChannels.m12handleUserLeftStageOrLostRolesGM3QuyE(channel, j, i, i2);
    }

    /* renamed from: handleUserRoleChange-uOJZ9lM, reason: not valid java name */
    private final void m14handleUserRoleChangeuOJZ9lM(Channel channel, long userId, StageRoles oldRole, int newRole) {
        if ((StageRoles.m32isModeratorimpl(newRole) && (oldRole == null || !StageRoles.m32isModeratorimpl(oldRole.m35unboximpl()))) || (StageRoles.m33isSpeakerimpl(newRole) && (oldRole == null || !StageRoles.m33isSpeakerimpl(oldRole.m35unboximpl())))) {
            m11handleUserJoinedStageOrGainedRoleoRmTEFA(channel, userId, newRole);
        }
        if ((oldRole != null && StageRoles.m32isModeratorimpl(oldRole.m35unboximpl()) && !StageRoles.m32isModeratorimpl(newRole)) || (oldRole != null && StageRoles.m33isSpeakerimpl(oldRole.m35unboximpl()) && !StageRoles.m33isSpeakerimpl(newRole))) {
            m12handleUserLeftStageOrLostRolesGM3QuyE(channel, userId, oldRole.m35unboximpl(), newRole);
        }
        if (userId == this.userStore.getMeSnapshot().getId()) {
            if (oldRole != null && !StageRoles.m31isInvitedToSpeakimpl(oldRole.m35unboximpl()) && StageRoles.m31isInvitedToSpeakimpl(newRole)) {
                StageChannelNotifications.INSTANCE.getINSTANCE().onInvitedToSpeak(channel.getId());
            } else {
                if (oldRole == null || !StageRoles.m31isInvitedToSpeakimpl(oldRole.m35unboximpl()) || StageRoles.m31isInvitedToSpeakimpl(newRole)) {
                    return;
                }
                StageChannelNotifications.INSTANCE.getINSTANCE().onInviteToSpeakRescinded();
            }
        }
    }

    private final void markStageEventDirty() {
        markChanged(EventStateUpdateSource);
    }

    private final StoreStageChannels2 roleContext(Channel channel, Guild guild, Map<Long, VoiceState> voiceStates, Map<Long, GuildRole> roles) {
        if (guild == null) {
            guild = getGuild(channel);
        }
        if (guild == null) {
            return null;
        }
        if (voiceStates == null) {
            voiceStates = this.voiceStatesStore.getForChannel(guild.getId(), channel.getId());
        }
        if (roles == null) {
            roles = getRolesMap(guild);
        }
        return new StoreStageChannels2(guild, channel, roles, voiceStates);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StoreStageChannels2 roleContext$default(StoreStageChannels storeStageChannels, Channel channel, Guild guild, Map map, Map map2, int i, Object obj) {
        if ((i & 2) != 0) {
            guild = null;
        }
        if ((i & 4) != 0) {
            map = null;
        }
        if ((i & 8) != 0) {
            map2 = null;
        }
        return storeStageChannels.roleContext(channel, guild, map, map2);
    }

    private final Sequence<Long> stageChannelIdsInGuildForDispatch(long guildId) {
        Collection<Channel> collectionValues;
        Sequence sequenceAsSequence;
        Sequence<Long> sequenceMapNotNull;
        Map<Long, Channel> channelsForGuildInternal$app_productionGoogleRelease = this.channelsStore.getChannelsForGuildInternal$app_productionGoogleRelease(guildId);
        return (channelsForGuildInternal$app_productionGoogleRelease == null || (collectionValues = channelsForGuildInternal$app_productionGoogleRelease.values()) == null || (sequenceAsSequence = _Collections.asSequence(collectionValues)) == null || (sequenceMapNotNull = _Sequences2.mapNotNull(sequenceAsSequence, AnonymousClass1.INSTANCE)) == null) ? n.emptySequence() : sequenceMapNotNull;
    }

    public final Map<Long, StageRoles> getChannelRoles(long channelId) {
        return this.stageRolesByChannelSnapshot.get(Long.valueOf(channelId));
    }

    public final Map<Long, StageRoles> getChannelRolesInternal(long channelId) {
        return this.stageRolesByChannel.get(Long.valueOf(channelId));
    }

    /* renamed from: getMyRoles-visDeB4, reason: not valid java name */
    public final StageRoles m15getMyRolesvisDeB4(long channelId) {
        return m17getUserRolesuOBN1zc(this.userStore.getMeSnapshot().getId(), channelId);
    }

    /* renamed from: getMyRolesInternal-visDeB4, reason: not valid java name */
    public final StageRoles m16getMyRolesInternalvisDeB4(long channelId) {
        return m18getUserRolesInternaluOBN1zc(this.userStore.getMeSnapshot().getId(), channelId);
    }

    public final int getOtherModeratorsCountInChannel(Channel channel, long myId) {
        StageEventActivationState stageEventActivationState;
        Intrinsics3.checkNotNullParameter(channel, "channel");
        Map map = (Map) outline.c(channel, this.stageEventStates);
        if (map == null || (stageEventActivationState = (StageEventActivationState) outline.d(channel, map)) == null) {
            return 0;
        }
        int size = stageEventActivationState.getModerators().size();
        return stageEventActivationState.getModerators().contains(Long.valueOf(myId)) ? size - 1 : size;
    }

    public final Map<Long, StageChannel> getStageChannelsInGuild(long guildId, Map<Long, Channel> channelsInGuild, long myId, Map<Long, ? extends User> users, Map<Long, VoiceState> voiceStates) {
        StoreStageChannels storeStageChannels = this;
        Map<Long, ? extends User> map = users;
        Intrinsics3.checkNotNullParameter(channelsInGuild, "channelsInGuild");
        Intrinsics3.checkNotNullParameter(map, "users");
        Intrinsics3.checkNotNullParameter(voiceStates, "voiceStates");
        Collection<Channel> collectionValues = channelsInGuild.values();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            if (ChannelUtils.D((Channel) obj)) {
                arrayList.add(obj);
            }
        }
        int i = 10;
        ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Channel channel = (Channel) it.next();
            Map mapEmptyMap = (Map) outline.d(channel, storeStageChannels.stageRolesByChannelSnapshot);
            if (mapEmptyMap == null) {
                mapEmptyMap = Maps6.emptyMap();
            }
            Set setKeySet = mapEmptyMap.keySet();
            ArrayList arrayList3 = new ArrayList();
            Iterator it2 = setKeySet.iterator();
            while (it2.hasNext()) {
                User user = map.get(Long.valueOf(((Number) it2.next()).longValue()));
                if (user != null) {
                    arrayList3.add(user);
                }
            }
            ArrayList arrayList4 = new ArrayList();
            for (Object obj2 : arrayList3) {
                StageRoles stageRolesM17getUserRolesuOBN1zc = storeStageChannels.m17getUserRolesuOBN1zc(((User) obj2).getId(), channel.getId());
                if (stageRolesM17getUserRolesuOBN1zc != null && StageRoles.m33isSpeakerimpl(stageRolesM17getUserRolesuOBN1zc.m35unboximpl())) {
                    arrayList4.add(obj2);
                }
            }
            ArrayList arrayList5 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList4, 10));
            Iterator it3 = arrayList4.iterator();
            while (it3.hasNext()) {
                arrayList5.add(Long.valueOf(((User) it3.next()).getId()));
            }
            Set set = _Collections.toSet(arrayList5);
            int size = arrayList3.size() - set.size();
            Long l = (Long) outline.d(channel, storeStageChannels.permissionsStore.getPermissionsByChannel());
            boolean z2 = PermissionUtils.can(Permission.CONNECT, l) && PermissionUtils.can(Permission.VIEW_CHANNEL, l);
            Map<Long, GuildMember> map2 = storeStageChannels.guildsStore.getMembers().get(Long.valueOf(guildId));
            ArrayList<User> arrayList6 = new ArrayList();
            for (Object obj3 : arrayList3) {
                if (set.contains(Long.valueOf(((User) obj3).getId()))) {
                    arrayList6.add(obj3);
                }
            }
            ArrayList arrayList7 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList6, 10));
            for (User user2 : arrayList6) {
                arrayList7.add(new UserGuildMember(user2, map2 != null ? (GuildMember) outline.f(user2, map2) : null));
            }
            ArrayList arrayList8 = arrayList2;
            Iterator it4 = it;
            StageRoles stageRolesM15getMyRolesvisDeB4 = storeStageChannels.m15getMyRolesvisDeB4(channel.getId());
            StageInstance stageInstanceForChannel = storeStageChannels.stageInstancesStore.getStageInstanceForChannel(channel.getId());
            VoiceState voiceState = voiceStates.get(Long.valueOf(myId));
            Long channelId = voiceState != null ? voiceState.getChannelId() : null;
            arrayList8.add(new StageChannel(channel, arrayList3, stageRolesM15getMyRolesvisDeB4, set, arrayList7, size, stageInstanceForChannel, z2, channelId != null && channelId.longValue() == channel.getId(), null));
            i = 10;
            map = users;
            arrayList2 = arrayList8;
            it = it4;
            storeStageChannels = this;
        }
        ArrayList arrayList9 = arrayList2;
        LinkedHashMap linkedHashMap = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(arrayList9, i)), 16));
        for (Object obj4 : arrayList9) {
            linkedHashMap.put(Long.valueOf(((StageChannel) obj4).getChannel().getId()), obj4);
        }
        return linkedHashMap;
    }

    /* renamed from: getUserRoles-uOBN1zc, reason: not valid java name */
    public final StageRoles m17getUserRolesuOBN1zc(long userId, long channelId) {
        Map<Long, StageRoles> map = this.stageRolesByChannelSnapshot.get(Long.valueOf(channelId));
        if (map == null) {
            return null;
        }
        StageRoles stageRoles = map.get(Long.valueOf(userId));
        return StageRoles.m25boximpl(stageRoles != null ? stageRoles.m35unboximpl() : StageRoles.INSTANCE.m37getAUDIENCE1LxfuJo());
    }

    /* renamed from: getUserRolesInternal-uOBN1zc, reason: not valid java name */
    public final StageRoles m18getUserRolesInternaluOBN1zc(long userId, long channelId) {
        Map<Long, StageRoles> map = this.stageRolesByChannel.get(Long.valueOf(channelId));
        if (map == null) {
            return null;
        }
        StageRoles stageRoles = map.get(Long.valueOf(userId));
        return StageRoles.m25boximpl(stageRoles != null ? stageRoles.m35unboximpl() : StageRoles.INSTANCE.m37getAUDIENCE1LxfuJo());
    }

    @Store3
    public final void handleChannelDelete(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        if (ChannelUtils.D(channel)) {
            if (this.stageRolesByChannel.remove(Long.valueOf(channel.getId())) != null) {
                this.dirtyChannelIds.add(Long.valueOf(channel.getId()));
                markChanged();
            }
            Map map = (Map) outline.c(channel, this.stageEventStates);
            if (map == null || ((StageEventActivationState) map.remove(Long.valueOf(channel.getId()))) == null) {
                return;
            }
            markStageEventDirty();
        }
    }

    @Store3
    public final void handleConnectionOpen() {
        this.stageRolesByChannel.clear();
        this.stageEventStates.clear();
    }

    @Store3
    public final void handleGuildMemberAdd(com.discord.api.guildmember.GuildMember member) {
        StageRoles stageRoles;
        Intrinsics3.checkNotNullParameter(member, "member");
        User user = this.userStore.getUsersInternal$app_productionGoogleRelease().get(Long.valueOf(member.getUser().getId()));
        if (user == null || !user.getIsBot()) {
            Iterator<Long> it = stageChannelIdsInGuildForDispatch(member.getGuildId()).iterator();
            while (it.hasNext()) {
                long jLongValue = it.next().longValue();
                Map<Long, StageRoles> map = this.stageRolesByChannel.get(Long.valueOf(jLongValue));
                if (map != null && (stageRoles = map.get(Long.valueOf(member.getUser().getId()))) != null) {
                    int iM35unboximpl = stageRoles.m35unboximpl();
                    Channel channel = this.channelsStore.getChannelsByIdInternal$app_productionGoogleRelease().get(Long.valueOf(jLongValue));
                    if (channel != null) {
                        int iM10computeUserRolesInDispatcht27eFtU$default = m10computeUserRolesInDispatcht27eFtU$default(this, member.getUser().getId(), channel, null, null, 12, null);
                        if (!StageRoles.m28equalsimpl0(iM10computeUserRolesInDispatcht27eFtU$default, iM35unboximpl)) {
                            map.put(Long.valueOf(member.getUser().getId()), StageRoles.m25boximpl(iM10computeUserRolesInDispatcht27eFtU$default));
                            m14handleUserRoleChangeuOJZ9lM(channel, member.getUser().getId(), StageRoles.m25boximpl(iM35unboximpl), iM10computeUserRolesInDispatcht27eFtU$default);
                            this.dirtyChannelIds.add(Long.valueOf(jLongValue));
                            markChanged();
                        }
                    }
                }
            }
        }
    }

    @Store3
    public final void handleGuildMemberRemove(long guildId, long userId) {
        StageRoles stageRoles;
        Channel channel;
        User user = this.userStore.getUsersInternal$app_productionGoogleRelease().get(Long.valueOf(userId));
        if (user == null || !user.getIsBot()) {
            Iterator<Long> it = stageChannelIdsInGuildForDispatch(guildId).iterator();
            while (it.hasNext()) {
                long jLongValue = it.next().longValue();
                Map<Long, StageRoles> map = this.stageRolesByChannel.get(Long.valueOf(jLongValue));
                if (map != null && (stageRoles = map.get(Long.valueOf(userId))) != null && (channel = this.channelsStore.getChannelsByIdInternal$app_productionGoogleRelease().get(Long.valueOf(jLongValue))) != null) {
                    m13handleUserLeftStageOrLostRolesGM3QuyE$default(this, channel, userId, stageRoles.m35unboximpl(), 0, 8, null);
                    this.dirtyChannelIds.add(Long.valueOf(jLongValue));
                    markChanged();
                }
            }
        }
    }

    @Store3
    public final void handleGuildRemove(com.discord.api.guild.Guild guild) {
        Intrinsics3.checkNotNullParameter(guild, "guild");
        if (this.stageEventStates.remove(Long.valueOf(guild.getId())) != null) {
            markStageEventDirty();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<T> it = this.channelsStore.getChannelsForGuild(guild.getId()).keySet().iterator();
        while (it.hasNext()) {
            long jLongValue = ((Number) it.next()).longValue();
            if (this.stageRolesByChannel.remove(Long.valueOf(jLongValue)) != null) {
                linkedHashSet.add(Long.valueOf(jLongValue));
            }
        }
        if (!linkedHashSet.isEmpty()) {
            MutableCollections.addAll(this.dirtyChannelIds, linkedHashSet);
            markChanged();
        }
    }

    @Store3
    public final void handleGuildRoleCreateOrUpdate(long guildId) {
        Iterator<Long> it = stageChannelIdsInGuildForDispatch(guildId).iterator();
        while (it.hasNext()) {
            long jLongValue = it.next().longValue();
            Map<Long, StageRoles> map = this.stageRolesByChannel.get(Long.valueOf(jLongValue));
            if (map != null) {
                Iterator it2 = _Collections.toList(map.keySet()).iterator();
                while (it2.hasNext()) {
                    handleVoiceStatesUpdated(guildId, jLongValue, ((Number) it2.next()).longValue());
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0097  */
    @Store3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void handleVoiceStatesUpdated(long guildId, long fromChannelId, long userId) {
        boolean z2;
        Long channelId;
        Long channelId2;
        Map<Long, VoiceState> map = this.voiceStatesStore.getInternal$app_productionGoogleRelease().get(Long.valueOf(guildId));
        VoiceState voiceState = map != null ? map.get(Long.valueOf(userId)) : null;
        long jLongValue = (voiceState == null || (channelId2 = voiceState.getChannelId()) == null) ? fromChannelId : channelId2.longValue();
        Channel channelInternal$app_productionGoogleRelease = this.channelsStore.getChannelInternal$app_productionGoogleRelease(guildId, jLongValue);
        Channel channelInternal$app_productionGoogleRelease2 = this.channelsStore.getChannelInternal$app_productionGoogleRelease(guildId, fromChannelId);
        if (channelInternal$app_productionGoogleRelease2 != null && ChannelUtils.D(channelInternal$app_productionGoogleRelease2) && (voiceState == null || (channelId = voiceState.getChannelId()) == null || channelId.longValue() != fromChannelId)) {
            Map<Long, StageRoles> map2 = this.stageRolesByChannel.get(Long.valueOf(fromChannelId));
            StageRoles stageRolesRemove = map2 != null ? map2.remove(Long.valueOf(userId)) : null;
            if (stageRolesRemove != null) {
                z2 = true;
                m13handleUserLeftStageOrLostRolesGM3QuyE$default(this, channelInternal$app_productionGoogleRelease2, userId, stageRolesRemove.m35unboximpl(), 0, 8, null);
                this.dirtyChannelIds.add(Long.valueOf(fromChannelId));
                markChanged();
            }
        } else {
            z2 = true;
        }
        if (voiceState == null || channelInternal$app_productionGoogleRelease == null || ChannelUtils.D(channelInternal$app_productionGoogleRelease) != z2) {
            return;
        }
        Map<Long, StageRoles> linkedHashMap = this.stageRolesByChannel.get(Long.valueOf(jLongValue));
        if (linkedHashMap == null) {
            linkedHashMap = new LinkedHashMap<>();
            this.stageRolesByChannel.put(Long.valueOf(jLongValue), linkedHashMap);
        }
        Map<Long, StageRoles> map3 = linkedHashMap;
        StageRoles stageRoles = map3.get(Long.valueOf(userId));
        int iM10computeUserRolesInDispatcht27eFtU$default = m10computeUserRolesInDispatcht27eFtU$default(this, userId, channelInternal$app_productionGoogleRelease, map, null, 8, null);
        if (StageRoles.m27equalsimpl(iM10computeUserRolesInDispatcht27eFtU$default, stageRoles) ^ z2) {
            m14handleUserRoleChangeuOJZ9lM(channelInternal$app_productionGoogleRelease, userId, stageRoles, iM10computeUserRolesInDispatcht27eFtU$default);
            map3.put(Long.valueOf(userId), StageRoles.m25boximpl(iM10computeUserRolesInDispatcht27eFtU$default));
            this.dirtyChannelIds.add(Long.valueOf(jLongValue));
            markChanged();
        }
    }

    public final Observable<Map<Long, StageChannel>> observeGuildStageChannels(long guildId) {
        Observable<Map<Long, StageChannel>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this, this.channelsStore, this.userStore, this.voiceStatesStore, this.stageInstancesStore}, false, null, null, new AnonymousClass1(guildId), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public final Observable<StageRequestToSpeakState> observeMyRequestToSpeakState(long channelId) {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this, this.channelsStore, this.guildsStore, this.userStore, this.voiceStatesStore}, false, null, null, new AnonymousClass1(channelId), 14, null);
    }

    public final Observable<StageRoles> observeMyRoles(long channelId) {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this, this.channelsStore}, false, null, null, new AnonymousClass1(channelId), 14, null);
    }

    public final Observable<Map<Long, Map<Long, StageRoles>>> observeRoles() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    public final Observable<Map<Long, StageChannel>> observeStageChannels() {
        Observable<Map<Long, StageChannel>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this, this.channelsStore, this.guildsStore, this.userStore, this.voiceStatesStore, this.stageInstancesStore}, false, null, null, new AnonymousClass1(), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Map<Long, StageRoles>> observeStageRolesByChannel(long channelId) {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(channelId), 14, null);
    }

    public final Observable<StageRequestToSpeakState> observeUserRequestToSpeakState(long userId, long channelId) {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this, this.channelsStore, this.guildsStore, this.voiceStatesStore}, false, null, null, new AnonymousClass1(channelId, userId), 14, null);
    }

    public final Observable<StageRoles> observeUserRoles(long userId, long channelId) {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this, this.channelsStore}, false, null, null, new AnonymousClass1(channelId, userId), 14, null);
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        Map<Long, Map<Long, StageRoles>> map = this.stageRolesByChannel;
        Map<Long, ? extends Map<Long, StageRoles>> map2 = this.stageRolesByChannelSnapshot;
        Set<Long> set = this.dirtyChannelIds;
        if (!set.isEmpty()) {
            HashMap map3 = new HashMap(map.size());
            for (Map.Entry<Long, Map<Long, StageRoles>> entry : map.entrySet()) {
                Long key = entry.getKey();
                Map<Long, StageRoles> value = entry.getValue();
                if (set.contains(key)) {
                    key.longValue();
                    map3.put(key, new HashMap(value));
                } else {
                    Map<Long, StageRoles> map4 = map2.get(key);
                    if (map4 != null) {
                        map3.put(key, map4);
                    }
                }
            }
            map2 = map3;
        }
        this.stageRolesByChannelSnapshot = map2;
        this.dirtyChannelIds.clear();
    }

    public StoreStageChannels(StoreUser storeUser, StoreGuilds storeGuilds, StoreChannels storeChannels, StoreVoiceStates storeVoiceStates, StorePermissions storePermissions, StoreStageInstances storeStageInstances, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(storeUser, "userStore");
        Intrinsics3.checkNotNullParameter(storeGuilds, "guildsStore");
        Intrinsics3.checkNotNullParameter(storeChannels, "channelsStore");
        Intrinsics3.checkNotNullParameter(storeVoiceStates, "voiceStatesStore");
        Intrinsics3.checkNotNullParameter(storePermissions, "permissionsStore");
        Intrinsics3.checkNotNullParameter(storeStageInstances, "stageInstancesStore");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.userStore = storeUser;
        this.guildsStore = storeGuilds;
        this.channelsStore = storeChannels;
        this.voiceStatesStore = storeVoiceStates;
        this.permissionsStore = storePermissions;
        this.stageInstancesStore = storeStageInstances;
        this.observationDeck = observationDeck;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.stageRolesByChannel = linkedHashMap;
        this.stageRolesByChannelSnapshot = new HashMap(linkedHashMap);
        this.stageEventStates = new LinkedHashMap();
        this.dirtyChannelIds = new LinkedHashSet();
    }
}
