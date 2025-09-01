package com.discord.stores;

import android.content.Context;
import com.discord.api.guild.Guild;
import com.discord.api.guildscheduledevent.ApiGuildScheduledEventUser;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.guildscheduledevent.GuildScheduledEventMeUser;
import com.discord.api.guildscheduledevent.GuildScheduledEventStatus;
import com.discord.api.guildscheduledevent.GuildScheduledEventUserUpdate;
import com.discord.api.permission.Permission;
import com.discord.models.domain.ModelPayload;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.error.Error;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventUser;
import d0.d0._Ranges;
import d0.f0._Sequences2;
import d0.t.Collections2;
import d0.t.CollectionsJVM;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t.Sets5;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* compiled from: StoreGuildScheduledEvents.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u0086\u00012\u00020\u0001:\u0002\u0086\u0001BC\u0012\b\u0010\u0082\u0001\u001a\u00030\u0081\u0001\u0012\u0006\u0010v\u001a\u00020u\u0012\u0006\u0010|\u001a\u00020{\u0012\u0006\u0010X\u001a\u00020W\u0012\u0006\u0010m\u001a\u00020l\u0012\u0006\u0010y\u001a\u00020x\u0012\u0006\u0010i\u001a\u00020h¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J'\u0010\n\u001a\u00020\u00022\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u00062\n\u0010\t\u001a\u00060\u0005j\u0002`\bH\u0003¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\f\u001a\u00020\u00022\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u00062\n\u0010\t\u001a\u00060\u0005j\u0002`\bH\u0003¢\u0006\u0004\b\f\u0010\u000bJ3\u0010\u000f\u001a\u00020\u00022\n\u0010\u000e\u001a\u00060\u0005j\u0002`\r2\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u00062\n\u0010\t\u001a\u00060\u0005j\u0002`\bH\u0003¢\u0006\u0004\b\u000f\u0010\u0010J3\u0010\u0011\u001a\u00020\u00022\n\u0010\u000e\u001a\u00060\u0005j\u0002`\r2\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u00062\n\u0010\t\u001a\u00060\u0005j\u0002`\bH\u0003¢\u0006\u0004\b\u0011\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\n\u0010\u000e\u001a\u00060\u0005j\u0002`\rH\u0003¢\u0006\u0004\b\u0016\u0010\u0017J#\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\n\u0010\u000e\u001a\u00060\u0005j\u0002`\rH\u0003¢\u0006\u0004\b\u0018\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ/\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u001f0\u001e2\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u00062\b\b\u0002\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b \u0010!J\u0019\u0010\"\u001a\u00020\u00022\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0004\b\"\u0010#J\u0019\u0010$\u001a\u00020\u00022\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0004\b$\u0010#J%\u0010&\u001a\u00020\u00022\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u00062\n\u0010%\u001a\u00060\u0005j\u0002`\b¢\u0006\u0004\b&\u0010\u000bJ\u0019\u0010'\u001a\u00020\u00022\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0004\b'\u0010#J)\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u001e2\b\u0010%\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b(\u0010)J)\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00120\u001f2\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u00062\b\b\u0002\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b*\u0010+J#\u0010-\u001a\u0018\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u001f0,¢\u0006\u0004\b-\u0010.J#\u00100\u001a\f\u0012\b\u0012\u00060\u0005j\u0002`\b0/2\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0004\b0\u00101J)\u00103\u001a\u0012\u0012\b\u0012\u00060\u0005j\u0002`\r\u0012\u0004\u0012\u0002020,2\n\u0010%\u001a\u00060\u0005j\u0002`\b¢\u0006\u0004\b3\u00104J\r\u00105\u001a\u00020\u001c¢\u0006\u0004\b5\u00106J\r\u00107\u001a\u00020\u001c¢\u0006\u0004\b7\u00106J%\u00108\u001a\u00020\u001c2\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u00062\n\u0010\t\u001a\u00060\u0005j\u0002`\b¢\u0006\u0004\b8\u00109J1\u0010<\u001a\u00020\u00022 \u0010;\u001a\u001c\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\b\u0012\u00060\u0005j\u0002`\b0:0\u001fH\u0007¢\u0006\u0004\b<\u0010=J\u0015\u0010>\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b>\u0010\u0015J\u0015\u0010?\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b?\u0010\u0015J/\u0010B\u001a\u0004\u0018\u00010\u00122\u000e\u0010\u0007\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00062\u000e\u0010A\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`@¢\u0006\u0004\bB\u0010CJ\u0017\u0010F\u001a\u00020\u00022\u0006\u0010E\u001a\u00020DH\u0007¢\u0006\u0004\bF\u0010GJ\u0017\u0010J\u001a\u00020\u00022\u0006\u0010I\u001a\u00020HH\u0007¢\u0006\u0004\bJ\u0010KJ\u001b\u0010L\u001a\u00020\u00022\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006H\u0007¢\u0006\u0004\bL\u0010#J\u0017\u0010O\u001a\u00020\u00022\u0006\u0010N\u001a\u00020MH\u0007¢\u0006\u0004\bO\u0010PJ\u0017\u0010Q\u001a\u00020\u00022\u0006\u0010N\u001a\u00020MH\u0007¢\u0006\u0004\bQ\u0010PJ\u0017\u0010R\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0007¢\u0006\u0004\bR\u0010\u0015J\u0017\u0010S\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0007¢\u0006\u0004\bS\u0010\u0015J\u0017\u0010T\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0007¢\u0006\u0004\bT\u0010\u0015J-\u0010\u001a\u001a\u0004\u0018\u00010\u00122\n\u0010%\u001a\u00060\u0005j\u0002`\b2\u0010\b\u0002\u0010\u0007\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006¢\u0006\u0004\b\u001a\u0010UJ\u000f\u0010V\u001a\u00020\u0002H\u0016¢\u0006\u0004\bV\u0010\u0004R\u0016\u0010X\u001a\u00020W8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bX\u0010YR6\u0010Z\u001a\"\u0012\b\u0012\u00060\u0005j\u0002`\b\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0005j\u0002`\r\u0012\u0004\u0012\u0002020,0,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010[RB\u0010^\u001a.\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\b\u0012\u00060\u0005j\u0002`\b0\\j\u0016\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\b\u0012\u00060\u0005j\u0002`\b`]8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b^\u0010_R:\u0010`\u001a&\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\u00050\\j\u0012\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\u0005`]8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b`\u0010_RN\u0010b\u001a:\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0005j\u0002`\b0a0\\j\u001c\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0005j\u0002`\b0a`]8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bb\u0010_R.\u0010e\u001a\u001a\u0012\b\u0012\u00060\u0005j\u0002`\u00060cj\f\u0012\b\u0012\u00060\u0005j\u0002`\u0006`d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\be\u0010fRN\u0010g\u001a:\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0005j\u0002`\b0a0\\j\u001c\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0005j\u0002`\b0a`]8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bg\u0010_R\u0016\u0010i\u001a\u00020h8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bi\u0010jR0\u0010k\u001a\u001c\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0005j\u0002`\b0/0,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010[R\u0016\u0010m\u001a\u00020l8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bm\u0010nR,\u0010o\u001a\u0018\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u001f0,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bo\u0010[Rn\u0010p\u001aZ\u0012\b\u0012\u00060\u0005j\u0002`\b\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0005j\u0002`\r\u0012\u0004\u0012\u0002020\\0\\j6\u0012\b\u0012\u00060\u0005j\u0002`\b\u0012(\u0012&\u0012\b\u0012\u00060\u0005j\u0002`\r\u0012\u0004\u0012\u0002020\\j\u0012\u0012\b\u0012\u00060\u0005j\u0002`\r\u0012\u0004\u0012\u000202`]`]8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bp\u0010_R\u0016\u0010q\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010rR&\u0010s\u001a\u0012\u0012\u0004\u0012\u00020\u00050cj\b\u0012\u0004\u0012\u00020\u0005`d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010fR&\u0010t\u001a\u0012\u0012\u0004\u0012\u00020\u00050cj\b\u0012\u0004\u0012\u00020\u0005`d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bt\u0010fR\u0016\u0010v\u001a\u00020u8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bv\u0010wR\u0016\u0010y\u001a\u00020x8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\by\u0010zR\u0016\u0010|\u001a\u00020{8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b|\u0010}RF\u0010\u007f\u001a2\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120~0\\j\u0018\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120~`]8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u007f\u0010_R\u0018\u0010\u0080\u0001\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0080\u0001\u0010rR\u001a\u0010\u0082\u0001\u001a\u00030\u0081\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001¨\u0006\u0087\u0001"}, d2 = {"Lcom/discord/stores/StoreGuildScheduledEvents;", "Lcom/discord/stores/StoreV2;", "", "handleFetchRsvpUsersFailure", "()V", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/primitives/GuildScheduledEventId;", "guildScheduledEventId", "removeMeRsvpForEvent", "(JJ)V", "addMeRsvpForEvent", "Lcom/discord/primitives/UserId;", "userId", "removeUserRsvpForEvent", "(JJJ)V", "addUserRsvpForEvent", "Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "guildScheduledEvent", "processGuildScheduledEventCreateOrUpdate", "(Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;)V", "processRsvpDelete", "(Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;J)V", "processRsvpCreate", "event", "findEventFromStore", "(Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;)Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "", "filterInaccessible", "Lrx/Observable;", "", "observeGuildScheduledEvents", "(JZ)Lrx/Observable;", "fetchMeGuildScheduledEvents", "(J)V", "fetchGuildScheduledEventUserCounts", "eventId", "fetchGuildScheduledEventUsers", "ackGuildEvents", "observeGuildScheduledEvent", "(Ljava/lang/Long;Ljava/lang/Long;)Lrx/Observable;", "getGuildScheduledEvents", "(JZ)Ljava/util/List;", "", "getAllGuildScheduledEvents", "()Ljava/util/Map;", "", "getMeGuildScheduledEventIds", "(J)Ljava/util/Set;", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventUser;", "getGuildScheduledEventUsers", "(J)Ljava/util/Map;", "getIsFetchingGuildScheduledEventUsers", "()Z", "getIsGuildScheduledEventUsersError", "isMeRsvpedToEvent", "(JJ)Z", "Lkotlin/Pair;", "events", "addMeRsvpsForEvent", "(Ljava/util/List;)V", "toggleMeRsvpForEvent", "addGuildScheduledEventFromInvite", "Lcom/discord/primitives/ChannelId;", "channelId", "getActiveEventForChannel", "(Ljava/lang/Long;Ljava/lang/Long;)Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "Lcom/discord/models/domain/ModelPayload;", "payload", "handleConnectionOpen", "(Lcom/discord/models/domain/ModelPayload;)V", "Lcom/discord/api/guild/Guild;", "guild", "handleGuildCreate", "(Lcom/discord/api/guild/Guild;)V", "handleGuildRemove", "Lcom/discord/api/guildscheduledevent/GuildScheduledEventUserUpdate;", "guildScheduledEventUserUpdate", "handleGuildScheduledEventUserAdd", "(Lcom/discord/api/guildscheduledevent/GuildScheduledEventUserUpdate;)V", "handleGuildScheduledEventUserRemove", "handleGuildScheduledEventCreate", "handleGuildScheduledEventUpdate", "handleGuildScheduledEventDelete", "(JLjava/lang/Long;)Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "snapshotData", "Lcom/discord/stores/StoreUser;", "userStore", "Lcom/discord/stores/StoreUser;", "guildScheduledEventUsersSnapshot", "Ljava/util/Map;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "lastAckedGuildScheduledEventIds", "Ljava/util/HashMap;", "guildScheduledEventsFetchTimestamps", "", "meGuildScheduledEventIds", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "meGuildScheduledEventsFetches", "Ljava/util/HashSet;", "guildScheduledEventUsersFetches", "Lcom/discord/stores/StoreExperiments;", "experimentsStore", "Lcom/discord/stores/StoreExperiments;", "meGuildScheduledEventIdsSnapshot", "Lcom/discord/stores/StoreGuilds;", "guildsStore", "Lcom/discord/stores/StoreGuilds;", "guildScheduledEventsSnapshot", "guildScheduledEventUsers", "isFetchingGuildScheduledEventUsers", "Z", "rsvpsAwaitingSnapshot", "rsvpsAwaitingNetwork", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "Lcom/discord/utilities/time/Clock;", "clock", "Lcom/discord/utilities/time/Clock;", "Lcom/discord/stores/StorePermissions;", "permissionsStore", "Lcom/discord/stores/StorePermissions;", "", "guildScheduledEvents", "isGuildScheduledEventUsersError", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "<init>", "(Lcom/discord/stores/Dispatcher;Lcom/discord/stores/updates/ObservationDeck;Lcom/discord/stores/StorePermissions;Lcom/discord/stores/StoreUser;Lcom/discord/stores/StoreGuilds;Lcom/discord/utilities/time/Clock;Lcom/discord/stores/StoreExperiments;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreGuildScheduledEvents extends StoreV2 {
    public static final long FETCH_GUILD_EVENTS_THRESHOLD = 1800000;
    private final Clock clock;
    private final Dispatcher dispatcher;
    private final StoreExperiments experimentsStore;
    private final HashMap<Long, HashMap<Long, GuildScheduledEventUser>> guildScheduledEventUsers;
    private final HashMap<Long, Set<Long>> guildScheduledEventUsersFetches;
    private Map<Long, ? extends Map<Long, GuildScheduledEventUser>> guildScheduledEventUsersSnapshot;
    private final HashMap<Long, List<GuildScheduledEvent>> guildScheduledEvents;
    private final HashMap<Long, Long> guildScheduledEventsFetchTimestamps;
    private Map<Long, ? extends List<GuildScheduledEvent>> guildScheduledEventsSnapshot;
    private final StoreGuilds guildsStore;
    private boolean isFetchingGuildScheduledEventUsers;
    private boolean isGuildScheduledEventUsersError;
    private final HashMap<Long, Long> lastAckedGuildScheduledEventIds;
    private final HashMap<Long, Set<Long>> meGuildScheduledEventIds;
    private Map<Long, ? extends Set<Long>> meGuildScheduledEventIdsSnapshot;
    private final HashSet<Long> meGuildScheduledEventsFetches;
    private final ObservationDeck observationDeck;
    private final StorePermissions permissionsStore;
    private final HashSet<Long> rsvpsAwaitingNetwork;
    private HashSet<Long> rsvpsAwaitingSnapshot;
    private final StoreUser userStore;

    /* compiled from: StoreGuildScheduledEvents.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildScheduledEvents$ackGuildEvents$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ GuildScheduledEvent $mostRecentEvent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(GuildScheduledEvent guildScheduledEvent, long j) {
            super(1);
            this.$mostRecentEvent = guildScheduledEvent;
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r4) {
            StoreGuildScheduledEvents.access$getLastAckedGuildScheduledEventIds$p(StoreGuildScheduledEvents.this).put(Long.valueOf(this.$guildId), Long.valueOf(this.$mostRecentEvent.getId()));
        }
    }

    /* compiled from: StoreGuildScheduledEvents.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "events", "", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildScheduledEvents$fetchGuildScheduledEventUserCounts$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<List<? extends GuildScheduledEvent>, Unit> {
        public final /* synthetic */ long $guildId;

        /* compiled from: StoreGuildScheduledEvents.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreGuildScheduledEvents$fetchGuildScheduledEventUserCounts$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01271 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ List $events;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01271(List list) {
                super(0);
                this.$events = list;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreGuildScheduledEvents.access$getGuildScheduledEvents$p(StoreGuildScheduledEvents.this).put(Long.valueOf(AnonymousClass1.this.$guildId), _Collections.toMutableList((Collection) this.$events));
                StoreGuildScheduledEvents.access$getGuildScheduledEventsFetchTimestamps$p(StoreGuildScheduledEvents.this).put(Long.valueOf(AnonymousClass1.this.$guildId), Long.valueOf(StoreGuildScheduledEvents.access$getClock$p(StoreGuildScheduledEvents.this).currentTimeMillis()));
                StoreGuildScheduledEvents.this.markChanged();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(1);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends GuildScheduledEvent> list) {
            invoke2((List<GuildScheduledEvent>) list);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<GuildScheduledEvent> list) {
            Intrinsics3.checkNotNullParameter(list, "events");
            StoreGuildScheduledEvents.access$getDispatcher$p(StoreGuildScheduledEvents.this).schedule(new C01271(list));
        }
    }

    /* compiled from: StoreGuildScheduledEvents.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildScheduledEvents$fetchGuildScheduledEventUsers$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $eventId;
        public final /* synthetic */ long $guildId;

        /* compiled from: StoreGuildScheduledEvents.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreGuildScheduledEvents$fetchGuildScheduledEventUsers$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01281 extends Lambda implements Function1<Error, Unit> {
            public C01281() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Error error) {
                invoke2(error);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Error error) {
                Intrinsics3.checkNotNullParameter(error, "it");
                StoreGuildScheduledEvents.access$handleFetchRsvpUsersFailure(StoreGuildScheduledEvents.this);
            }
        }

        /* compiled from: StoreGuildScheduledEvents.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/discord/api/guildscheduledevent/ApiGuildScheduledEventUser;", "apiGuildScheduledEventUsers", "", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreGuildScheduledEvents$fetchGuildScheduledEventUsers$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends Lambda implements Function1<List<? extends ApiGuildScheduledEventUser>, Unit> {

            /* compiled from: StoreGuildScheduledEvents.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
            /* renamed from: com.discord.stores.StoreGuildScheduledEvents$fetchGuildScheduledEventUsers$1$2$1, reason: invalid class name and collision with other inner class name */
            public static final class C01291 extends Lambda implements Function0<Unit> {
                public final /* synthetic */ List $apiGuildScheduledEventUsers;

                /* compiled from: StoreGuildScheduledEvents.kt */
                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/guildscheduledevent/ApiGuildScheduledEventUser;", "apiEventUser", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventUser;", "invoke", "(Lcom/discord/api/guildscheduledevent/ApiGuildScheduledEventUser;)Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventUser;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
                /* renamed from: com.discord.stores.StoreGuildScheduledEvents$fetchGuildScheduledEventUsers$1$2$1$1, reason: invalid class name and collision with other inner class name */
                public static final class C01301 extends Lambda implements Function1<ApiGuildScheduledEventUser, GuildScheduledEventUser> {
                    public C01301() {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ GuildScheduledEventUser invoke(ApiGuildScheduledEventUser apiGuildScheduledEventUser) {
                        return invoke2(apiGuildScheduledEventUser);
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final GuildScheduledEventUser invoke2(ApiGuildScheduledEventUser apiGuildScheduledEventUser) {
                        Intrinsics3.checkNotNullParameter(apiGuildScheduledEventUser, "apiEventUser");
                        return GuildScheduledEventUser.INSTANCE.from(apiGuildScheduledEventUser, AnonymousClass1.this.$guildId);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C01291(List list) {
                    super(0);
                    this.$apiGuildScheduledEventUsers = list;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    StoreGuildScheduledEvents.access$getUserStore$p(StoreGuildScheduledEvents.this).handleGuildScheduledEventUsersFetch(this.$apiGuildScheduledEventUsers);
                    StoreGuildScheduledEvents.access$getGuildsStore$p(StoreGuildScheduledEvents.this).handleGuildScheduledEventUsersFetch(this.$apiGuildScheduledEventUsers, AnonymousClass1.this.$guildId);
                    HashMap map = (HashMap) StoreGuildScheduledEvents.access$getGuildScheduledEventUsers$p(StoreGuildScheduledEvents.this).get(Long.valueOf(AnonymousClass1.this.$eventId));
                    if (map == null) {
                        map = new HashMap();
                    }
                    for (GuildScheduledEventUser guildScheduledEventUser : _Sequences2.mapNotNull(_Collections.asSequence(this.$apiGuildScheduledEventUsers), new C01301())) {
                        map.put(Long.valueOf(guildScheduledEventUser.getUser().getId()), guildScheduledEventUser);
                    }
                    StoreGuildScheduledEvents.access$getGuildScheduledEventUsers$p(StoreGuildScheduledEvents.this).put(Long.valueOf(AnonymousClass1.this.$eventId), map);
                    Set linkedHashSet = (Set) StoreGuildScheduledEvents.access$getGuildScheduledEventUsersFetches$p(StoreGuildScheduledEvents.this).get(Long.valueOf(AnonymousClass1.this.$guildId));
                    if (linkedHashSet == null) {
                        linkedHashSet = new LinkedHashSet();
                    }
                    linkedHashSet.add(Long.valueOf(AnonymousClass1.this.$eventId));
                    StoreGuildScheduledEvents.access$getGuildScheduledEventUsersFetches$p(StoreGuildScheduledEvents.this).put(Long.valueOf(AnonymousClass1.this.$guildId), linkedHashSet);
                    StoreGuildScheduledEvents.access$setFetchingGuildScheduledEventUsers$p(StoreGuildScheduledEvents.this, false);
                    StoreGuildScheduledEvents.access$setGuildScheduledEventUsersError$p(StoreGuildScheduledEvents.this, false);
                    StoreGuildScheduledEvents.this.markChanged();
                }
            }

            public AnonymousClass2() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends ApiGuildScheduledEventUser> list) {
                invoke2((List<ApiGuildScheduledEventUser>) list);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<ApiGuildScheduledEventUser> list) {
                Intrinsics3.checkNotNullParameter(list, "apiGuildScheduledEventUsers");
                StoreGuildScheduledEvents.access$getDispatcher$p(StoreGuildScheduledEvents.this).schedule(new C01291(list));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, long j2) {
            super(0);
            this.$guildId = j;
            this.$eventId = j2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Set setEmptySet = (Set) StoreGuildScheduledEvents.access$getGuildScheduledEventUsersFetches$p(StoreGuildScheduledEvents.this).get(Long.valueOf(this.$guildId));
            if (setEmptySet == null) {
                setEmptySet = Sets5.emptySet();
            }
            if (setEmptySet.contains(Long.valueOf(this.$eventId))) {
                return;
            }
            StoreGuildScheduledEvents.access$setFetchingGuildScheduledEventUsers$p(StoreGuildScheduledEvents.this, true);
            StoreGuildScheduledEvents.access$setGuildScheduledEventUsersError$p(StoreGuildScheduledEvents.this, false);
            StoreGuildScheduledEvents.this.markChanged();
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().getGuildScheduledEventUsers(this.$guildId, this.$eventId, 100, true, true), false, 1, null), StoreGuildScheduledEvents.this.getClass(), (Context) null, (Function1) null, new C01281(), (Function0) null, (Function0) null, new AnonymousClass2(), 54, (Object) null);
        }
    }

    /* compiled from: StoreGuildScheduledEvents.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/discord/api/guildscheduledevent/GuildScheduledEventMeUser;", "eventUsers", "", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildScheduledEvents$fetchMeGuildScheduledEvents$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<List<? extends GuildScheduledEventMeUser>, Unit> {
        public final /* synthetic */ long $guildId;

        /* compiled from: StoreGuildScheduledEvents.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreGuildScheduledEvents$fetchMeGuildScheduledEvents$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01311 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ List $eventUsers;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01311(List list) {
                super(0);
                this.$eventUsers = list;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                List list = this.$eventUsers;
                ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(Long.valueOf(((GuildScheduledEventMeUser) it.next()).getGuildScheduledEventId()));
                }
                StoreGuildScheduledEvents.access$getMeGuildScheduledEventIds$p(StoreGuildScheduledEvents.this).put(Long.valueOf(AnonymousClass1.this.$guildId), _Collections.toMutableSet(arrayList));
                StoreGuildScheduledEvents.access$getMeGuildScheduledEventsFetches$p(StoreGuildScheduledEvents.this).add(Long.valueOf(AnonymousClass1.this.$guildId));
                StoreGuildScheduledEvents.this.markChanged();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(1);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends GuildScheduledEventMeUser> list) {
            invoke2((List<GuildScheduledEventMeUser>) list);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<GuildScheduledEventMeUser> list) {
            Intrinsics3.checkNotNullParameter(list, "eventUsers");
            StoreGuildScheduledEvents.access$getDispatcher$p(StoreGuildScheduledEvents.this).schedule(new C01311(list));
        }
    }

    /* compiled from: StoreGuildScheduledEvents.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildScheduledEvents$handleFetchRsvpUsersFailure$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGuildScheduledEvents.access$setFetchingGuildScheduledEventUsers$p(StoreGuildScheduledEvents.this, false);
            StoreGuildScheduledEvents.access$setGuildScheduledEventUsersError$p(StoreGuildScheduledEvents.this, true);
            StoreGuildScheduledEvents.this.markChanged();
        }
    }

    /* compiled from: StoreGuildScheduledEvents.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "invoke", "()Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildScheduledEvents$observeGuildScheduledEvent$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<GuildScheduledEvent> {
        public final /* synthetic */ Long $eventId;
        public final /* synthetic */ Long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Long l, Long l2) {
            super(0);
            this.$eventId = l;
            this.$guildId = l2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ GuildScheduledEvent invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final GuildScheduledEvent invoke() {
            Long l = this.$eventId;
            if (l != null) {
                return StoreGuildScheduledEvents.this.findEventFromStore(l.longValue(), this.$guildId);
            }
            return null;
        }
    }

    /* compiled from: StoreGuildScheduledEvents.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "invoke", "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildScheduledEvents$observeGuildScheduledEvents$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<List<? extends GuildScheduledEvent>> {
        public final /* synthetic */ boolean $filterInaccessible;
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, boolean z2) {
            super(0);
            this.$guildId = j;
            this.$filterInaccessible = z2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ List<? extends GuildScheduledEvent> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<? extends GuildScheduledEvent> invoke2() {
            return StoreGuildScheduledEvents.this.getGuildScheduledEvents(this.$guildId, this.$filterInaccessible);
        }
    }

    /* compiled from: StoreGuildScheduledEvents.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildScheduledEvents$toggleMeRsvpForEvent$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $eventId;
        public final /* synthetic */ GuildScheduledEvent $guildScheduledEvent;
        public final /* synthetic */ GuildScheduledEvent $storeEvent;

        /* compiled from: StoreGuildScheduledEvents.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreGuildScheduledEvents$toggleMeRsvpForEvent$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01321 extends Lambda implements Function1<Error, Unit> {
            public C01321() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Error error) {
                invoke2(error);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Error error) {
                Intrinsics3.checkNotNullParameter(error, "it");
                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                StoreGuildScheduledEvents storeGuildScheduledEvents = StoreGuildScheduledEvents.this;
                StoreGuildScheduledEvents.access$processRsvpCreate(storeGuildScheduledEvents, StoreGuildScheduledEvents.access$findEventFromStore(storeGuildScheduledEvents, anonymousClass1.$storeEvent), StoreGuildScheduledEvents.access$getUserStore$p(StoreGuildScheduledEvents.this).getMeSnapshot().getId());
                StoreGuildScheduledEvents.access$getRsvpsAwaitingNetwork$p(StoreGuildScheduledEvents.this).remove(Long.valueOf(AnonymousClass1.this.$eventId));
            }
        }

        /* compiled from: StoreGuildScheduledEvents.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreGuildScheduledEvents$toggleMeRsvpForEvent$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends Lambda implements Function1<Void, Unit> {
            public AnonymousClass2() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
                invoke2(r1);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Void r3) {
                StoreGuildScheduledEvents.access$getRsvpsAwaitingNetwork$p(StoreGuildScheduledEvents.this).remove(Long.valueOf(AnonymousClass1.this.$eventId));
            }
        }

        /* compiled from: StoreGuildScheduledEvents.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreGuildScheduledEvents$toggleMeRsvpForEvent$1$3, reason: invalid class name */
        public static final class AnonymousClass3 extends Lambda implements Function1<Error, Unit> {
            public AnonymousClass3() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Error error) {
                invoke2(error);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Error error) {
                Intrinsics3.checkNotNullParameter(error, "it");
                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                StoreGuildScheduledEvents storeGuildScheduledEvents = StoreGuildScheduledEvents.this;
                StoreGuildScheduledEvents.access$processRsvpDelete(storeGuildScheduledEvents, StoreGuildScheduledEvents.access$findEventFromStore(storeGuildScheduledEvents, anonymousClass1.$storeEvent), StoreGuildScheduledEvents.access$getUserStore$p(StoreGuildScheduledEvents.this).getMeSnapshot().getId());
                StoreGuildScheduledEvents.access$getRsvpsAwaitingNetwork$p(StoreGuildScheduledEvents.this).remove(Long.valueOf(AnonymousClass1.this.$eventId));
            }
        }

        /* compiled from: StoreGuildScheduledEvents.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "it", "invoke", "(Lkotlin/Unit;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreGuildScheduledEvents$toggleMeRsvpForEvent$1$4, reason: invalid class name */
        public static final class AnonymousClass4 extends Lambda implements Function1<Unit, Unit> {
            public AnonymousClass4() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                invoke2(unit);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Unit unit) {
                Intrinsics3.checkNotNullParameter(unit, "it");
                StoreGuildScheduledEvents.access$getRsvpsAwaitingNetwork$p(StoreGuildScheduledEvents.this).remove(Long.valueOf(AnonymousClass1.this.$eventId));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(GuildScheduledEvent guildScheduledEvent, long j, GuildScheduledEvent guildScheduledEvent2) {
            super(0);
            this.$guildScheduledEvent = guildScheduledEvent;
            this.$eventId = j;
            this.$storeEvent = guildScheduledEvent2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (StoreGuildScheduledEvents.this.isMeRsvpedToEvent(this.$guildScheduledEvent.getGuildId(), this.$eventId)) {
                StoreGuildScheduledEvents storeGuildScheduledEvents = StoreGuildScheduledEvents.this;
                StoreGuildScheduledEvents.access$processRsvpDelete(storeGuildScheduledEvents, this.$storeEvent, StoreGuildScheduledEvents.access$getUserStore$p(storeGuildScheduledEvents).getMeSnapshot().getId());
                ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().deleteGuildScheduledEventRsvp(this.$storeEvent.getGuildId(), this.$storeEvent.getId()), false, 1, null), StoreGuildScheduledEvents.this.getClass(), (Context) null, (Function1) null, new C01321(), (Function0) null, (Function0) null, new AnonymousClass2(), 54, (Object) null);
            } else {
                StoreGuildScheduledEvents storeGuildScheduledEvents2 = StoreGuildScheduledEvents.this;
                StoreGuildScheduledEvents.access$processRsvpCreate(storeGuildScheduledEvents2, this.$storeEvent, StoreGuildScheduledEvents.access$getUserStore$p(storeGuildScheduledEvents2).getMeSnapshot().getId());
                ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().createGuildScheduledEventRsvp(this.$guildScheduledEvent.getGuildId(), this.$storeEvent.getId()), false, 1, null), StoreGuildScheduledEvents.this.getClass(), (Context) null, (Function1) null, new AnonymousClass3(), (Function0) null, (Function0) null, new AnonymousClass4(), 54, (Object) null);
            }
        }
    }

    public StoreGuildScheduledEvents(Dispatcher dispatcher, ObservationDeck observationDeck, StorePermissions storePermissions, StoreUser storeUser, StoreGuilds storeGuilds, Clock clock, StoreExperiments storeExperiments) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(storePermissions, "permissionsStore");
        Intrinsics3.checkNotNullParameter(storeUser, "userStore");
        Intrinsics3.checkNotNullParameter(storeGuilds, "guildsStore");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        Intrinsics3.checkNotNullParameter(storeExperiments, "experimentsStore");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.permissionsStore = storePermissions;
        this.userStore = storeUser;
        this.guildsStore = storeGuilds;
        this.clock = clock;
        this.experimentsStore = storeExperiments;
        this.guildScheduledEvents = new HashMap<>();
        this.guildScheduledEventsSnapshot = Maps6.emptyMap();
        this.lastAckedGuildScheduledEventIds = new HashMap<>();
        this.guildScheduledEventsFetchTimestamps = new HashMap<>();
        this.meGuildScheduledEventIds = new HashMap<>();
        this.meGuildScheduledEventIdsSnapshot = Maps6.emptyMap();
        this.meGuildScheduledEventsFetches = new HashSet<>();
        this.rsvpsAwaitingNetwork = new HashSet<>();
        this.rsvpsAwaitingSnapshot = new HashSet<>();
        this.guildScheduledEventUsers = new HashMap<>();
        this.guildScheduledEventUsersSnapshot = Maps6.emptyMap();
        this.guildScheduledEventUsersFetches = new HashMap<>();
    }

    public static final /* synthetic */ GuildScheduledEvent access$findEventFromStore(StoreGuildScheduledEvents storeGuildScheduledEvents, GuildScheduledEvent guildScheduledEvent) {
        return storeGuildScheduledEvents.findEventFromStore(guildScheduledEvent);
    }

    public static final /* synthetic */ Clock access$getClock$p(StoreGuildScheduledEvents storeGuildScheduledEvents) {
        return storeGuildScheduledEvents.clock;
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreGuildScheduledEvents storeGuildScheduledEvents) {
        return storeGuildScheduledEvents.dispatcher;
    }

    public static final /* synthetic */ HashMap access$getGuildScheduledEventUsers$p(StoreGuildScheduledEvents storeGuildScheduledEvents) {
        return storeGuildScheduledEvents.guildScheduledEventUsers;
    }

    public static final /* synthetic */ HashMap access$getGuildScheduledEventUsersFetches$p(StoreGuildScheduledEvents storeGuildScheduledEvents) {
        return storeGuildScheduledEvents.guildScheduledEventUsersFetches;
    }

    public static final /* synthetic */ HashMap access$getGuildScheduledEvents$p(StoreGuildScheduledEvents storeGuildScheduledEvents) {
        return storeGuildScheduledEvents.guildScheduledEvents;
    }

    public static final /* synthetic */ HashMap access$getGuildScheduledEventsFetchTimestamps$p(StoreGuildScheduledEvents storeGuildScheduledEvents) {
        return storeGuildScheduledEvents.guildScheduledEventsFetchTimestamps;
    }

    public static final /* synthetic */ StoreGuilds access$getGuildsStore$p(StoreGuildScheduledEvents storeGuildScheduledEvents) {
        return storeGuildScheduledEvents.guildsStore;
    }

    public static final /* synthetic */ HashMap access$getLastAckedGuildScheduledEventIds$p(StoreGuildScheduledEvents storeGuildScheduledEvents) {
        return storeGuildScheduledEvents.lastAckedGuildScheduledEventIds;
    }

    public static final /* synthetic */ HashMap access$getMeGuildScheduledEventIds$p(StoreGuildScheduledEvents storeGuildScheduledEvents) {
        return storeGuildScheduledEvents.meGuildScheduledEventIds;
    }

    public static final /* synthetic */ HashSet access$getMeGuildScheduledEventsFetches$p(StoreGuildScheduledEvents storeGuildScheduledEvents) {
        return storeGuildScheduledEvents.meGuildScheduledEventsFetches;
    }

    public static final /* synthetic */ HashSet access$getRsvpsAwaitingNetwork$p(StoreGuildScheduledEvents storeGuildScheduledEvents) {
        return storeGuildScheduledEvents.rsvpsAwaitingNetwork;
    }

    public static final /* synthetic */ StoreUser access$getUserStore$p(StoreGuildScheduledEvents storeGuildScheduledEvents) {
        return storeGuildScheduledEvents.userStore;
    }

    public static final /* synthetic */ void access$handleFetchRsvpUsersFailure(StoreGuildScheduledEvents storeGuildScheduledEvents) {
        storeGuildScheduledEvents.handleFetchRsvpUsersFailure();
    }

    public static final /* synthetic */ boolean access$isFetchingGuildScheduledEventUsers$p(StoreGuildScheduledEvents storeGuildScheduledEvents) {
        return storeGuildScheduledEvents.isFetchingGuildScheduledEventUsers;
    }

    public static final /* synthetic */ boolean access$isGuildScheduledEventUsersError$p(StoreGuildScheduledEvents storeGuildScheduledEvents) {
        return storeGuildScheduledEvents.isGuildScheduledEventUsersError;
    }

    public static final /* synthetic */ void access$processRsvpCreate(StoreGuildScheduledEvents storeGuildScheduledEvents, GuildScheduledEvent guildScheduledEvent, long j) {
        storeGuildScheduledEvents.processRsvpCreate(guildScheduledEvent, j);
    }

    public static final /* synthetic */ void access$processRsvpDelete(StoreGuildScheduledEvents storeGuildScheduledEvents, GuildScheduledEvent guildScheduledEvent, long j) {
        storeGuildScheduledEvents.processRsvpDelete(guildScheduledEvent, j);
    }

    public static final /* synthetic */ void access$setFetchingGuildScheduledEventUsers$p(StoreGuildScheduledEvents storeGuildScheduledEvents, boolean z2) {
        storeGuildScheduledEvents.isFetchingGuildScheduledEventUsers = z2;
    }

    public static final /* synthetic */ void access$setGuildScheduledEventUsersError$p(StoreGuildScheduledEvents storeGuildScheduledEvents, boolean z2) {
        storeGuildScheduledEvents.isGuildScheduledEventUsersError = z2;
    }

    @Store3
    private final void addMeRsvpForEvent(long guildId, long guildScheduledEventId) {
        if (!this.meGuildScheduledEventIds.containsKey(Long.valueOf(guildId))) {
            this.meGuildScheduledEventIds.put(Long.valueOf(guildId), Sets5.mutableSetOf(Long.valueOf(guildScheduledEventId)));
            return;
        }
        Set<Long> set = this.meGuildScheduledEventIds.get(Long.valueOf(guildId));
        if (set != null) {
            set.add(Long.valueOf(guildScheduledEventId));
        }
    }

    @Store3
    private final void addUserRsvpForEvent(long userId, long guildId, long guildScheduledEventId) {
        GuildMember member;
        if (userId == this.userStore.getMeSnapshot().getId() && !isMeRsvpedToEvent(guildId, guildScheduledEventId)) {
            addMeRsvpForEvent(guildId, guildScheduledEventId);
        }
        HashMap<Long, GuildScheduledEventUser> map = this.guildScheduledEventUsers.get(Long.valueOf(guildScheduledEventId));
        if (map == null) {
            map = new HashMap<>();
        }
        User user = this.userStore.getUsers(CollectionsJVM.listOf(Long.valueOf(userId)), false).get(Long.valueOf(userId));
        if (user != null && (member = this.guildsStore.getMember(guildId, userId)) != null) {
            map.put(Long.valueOf(userId), new GuildScheduledEventUser(user, member, guildScheduledEventId));
        }
        this.guildScheduledEventUsers.put(Long.valueOf(guildScheduledEventId), map);
    }

    private final GuildScheduledEvent findEventFromStore(GuildScheduledEvent event) {
        GuildScheduledEvent guildScheduledEventFindEventFromStore = findEventFromStore(event.getId(), Long.valueOf(event.getGuildId()));
        return guildScheduledEventFindEventFromStore != null ? guildScheduledEventFindEventFromStore : event;
    }

    public static /* synthetic */ GuildScheduledEvent findEventFromStore$default(StoreGuildScheduledEvents storeGuildScheduledEvents, long j, Long l, int i, Object obj) {
        if ((i & 2) != 0) {
            l = null;
        }
        return storeGuildScheduledEvents.findEventFromStore(j, l);
    }

    public static /* synthetic */ List getGuildScheduledEvents$default(StoreGuildScheduledEvents storeGuildScheduledEvents, long j, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        return storeGuildScheduledEvents.getGuildScheduledEvents(j, z2);
    }

    private final void handleFetchRsvpUsersFailure() {
        this.dispatcher.schedule(new AnonymousClass1());
    }

    public static /* synthetic */ Observable observeGuildScheduledEvents$default(StoreGuildScheduledEvents storeGuildScheduledEvents, long j, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        return storeGuildScheduledEvents.observeGuildScheduledEvents(j, z2);
    }

    private final void processGuildScheduledEventCreateOrUpdate(GuildScheduledEvent guildScheduledEvent) {
        int i;
        int i2;
        GuildScheduledEvent guildScheduledEvent2;
        GuildScheduledEvent guildScheduledEventA = guildScheduledEvent;
        long guildId = guildScheduledEvent.getGuildId();
        List<GuildScheduledEvent> list = this.guildScheduledEvents.get(Long.valueOf(guildId));
        if (list != null) {
            Iterator<GuildScheduledEvent> it = list.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                if (it.next().getId() == guildScheduledEvent.getId()) {
                    i = i3;
                    break;
                }
                i3++;
            }
            i = -1;
        } else {
            i = -1;
        }
        if (this.guildScheduledEvents.get(Long.valueOf(guildId)) == null) {
            this.guildScheduledEvents.put(Long.valueOf(guildId), Collections2.mutableListOf(guildScheduledEventA));
        } else if (i == -1) {
            List<GuildScheduledEvent> list2 = this.guildScheduledEvents.get(Long.valueOf(guildId));
            if (list2 != null) {
                list2.add(guildScheduledEventA);
            }
        } else {
            List<GuildScheduledEvent> list3 = this.guildScheduledEvents.get(Long.valueOf(guildId));
            Integer userCount = (list3 == null || (guildScheduledEvent2 = list3.get(i)) == null) ? null : guildScheduledEvent2.getUserCount();
            if (guildScheduledEvent.getUserCount() == null) {
                i2 = i;
                guildScheduledEventA = GuildScheduledEvent.a(guildScheduledEvent, 0L, 0L, null, null, null, null, null, null, null, null, null, null, null, null, null, userCount, null, null, 229375);
            } else {
                i2 = i;
            }
            List<GuildScheduledEvent> list4 = this.guildScheduledEvents.get(Long.valueOf(guildId));
            if (list4 != null) {
                list4.set(i2, guildScheduledEventA);
            }
        }
        markChanged();
    }

    @Store3
    private final void processRsvpCreate(GuildScheduledEvent guildScheduledEvent, long userId) {
        long id2 = guildScheduledEvent.getId();
        if (userId == this.userStore.getMeSnapshot().getId() && isMeRsvpedToEvent(guildScheduledEvent.getGuildId(), id2)) {
            return;
        }
        this.rsvpsAwaitingSnapshot.add(Long.valueOf(id2));
        addUserRsvpForEvent(userId, guildScheduledEvent.getGuildId(), id2);
        Integer userCount = guildScheduledEvent.getUserCount();
        GuildScheduledEvent guildScheduledEventA = GuildScheduledEvent.a(guildScheduledEvent, 0L, 0L, null, null, null, null, null, null, null, null, null, null, null, null, null, Integer.valueOf((userCount != null ? userCount.intValue() : 0) + 1), null, null, 229375);
        List<GuildScheduledEvent> list = this.guildScheduledEvents.get(Long.valueOf(guildScheduledEventA.getGuildId()));
        if (list != null) {
            Intrinsics3.checkNotNullExpressionValue(list, "eventList");
            Iterator<GuildScheduledEvent> it = list.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                } else {
                    if (it.next().getId() == id2) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
            if (i != -1) {
                list.set(i, guildScheduledEventA);
            } else {
                list.add(guildScheduledEventA);
            }
        } else {
            this.guildScheduledEvents.put(Long.valueOf(guildScheduledEvent.getGuildId()), Collections2.mutableListOf(guildScheduledEventA));
        }
        markChanged();
    }

    @Store3
    private final void processRsvpDelete(GuildScheduledEvent guildScheduledEvent, long userId) {
        long id2 = guildScheduledEvent.getId();
        if (userId != this.userStore.getMeSnapshot().getId() || isMeRsvpedToEvent(guildScheduledEvent.getGuildId(), id2)) {
            this.rsvpsAwaitingSnapshot.add(Long.valueOf(id2));
            removeUserRsvpForEvent(userId, guildScheduledEvent.getGuildId(), id2);
            List<GuildScheduledEvent> list = this.guildScheduledEvents.get(Long.valueOf(guildScheduledEvent.getGuildId()));
            if (list != null) {
                Intrinsics3.checkNotNullExpressionValue(list, "eventList");
                Iterator<GuildScheduledEvent> it = list.iterator();
                int i = 0;
                while (true) {
                    if (!it.hasNext()) {
                        i = -1;
                        break;
                    } else {
                        if (it.next().getId() == id2) {
                            break;
                        } else {
                            i++;
                        }
                    }
                }
                Integer numValueOf = Integer.valueOf(i);
                if (!(numValueOf.intValue() != -1)) {
                    numValueOf = null;
                }
                if (numValueOf != null) {
                    int iIntValue = numValueOf.intValue();
                    Integer userCount = guildScheduledEvent.getUserCount();
                    list.set(iIntValue, GuildScheduledEvent.a(guildScheduledEvent, 0L, 0L, null, null, null, null, null, null, null, null, null, null, null, null, null, Integer.valueOf(_Ranges.coerceAtLeast(0, userCount != null ? userCount.intValue() - 1 : 0)), null, null, 229375));
                }
            }
            markChanged();
        }
    }

    @Store3
    private final void removeMeRsvpForEvent(long guildId, long guildScheduledEventId) {
        Set<Long> set = this.meGuildScheduledEventIds.get(Long.valueOf(guildId));
        if (set != null) {
            set.remove(Long.valueOf(guildScheduledEventId));
        }
    }

    @Store3
    private final void removeUserRsvpForEvent(long userId, long guildId, long guildScheduledEventId) {
        if (userId == this.userStore.getMeSnapshot().getId() && isMeRsvpedToEvent(guildId, guildScheduledEventId)) {
            removeMeRsvpForEvent(guildId, guildScheduledEventId);
        }
        HashMap<Long, GuildScheduledEventUser> map = this.guildScheduledEventUsers.get(Long.valueOf(guildScheduledEventId));
        if (map != null) {
            map.remove(Long.valueOf(userId));
        }
    }

    public final void ackGuildEvents(long guildId) {
        Object next;
        List<GuildScheduledEvent> list = this.guildScheduledEvents.get(Long.valueOf(guildId));
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<T> it = list.iterator();
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                long id2 = ((GuildScheduledEvent) next).getId();
                do {
                    Object next2 = it.next();
                    long id3 = ((GuildScheduledEvent) next2).getId();
                    if (id2 < id3) {
                        next = next2;
                        id2 = id3;
                    }
                } while (it.hasNext());
            }
        } else {
            next = null;
        }
        GuildScheduledEvent guildScheduledEvent = (GuildScheduledEvent) next;
        if (guildScheduledEvent != null) {
            Long l = this.lastAckedGuildScheduledEventIds.get(Long.valueOf(guildId));
            if (l == null || l.longValue() < guildScheduledEvent.getId()) {
                ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().postGuildFeatureAck(guildId, 1, guildScheduledEvent.getId(), new RestAPIParams.GuildFeatureAck(Boolean.FALSE, 0)), false, 1, null), (Context) null, "REST: guildFeatureAck", (Function1) null, new AnonymousClass1(guildScheduledEvent, guildId), (Function1) null, (Function0) null, (Function0) null, 117, (Object) null);
            }
        }
    }

    public final void addGuildScheduledEventFromInvite(GuildScheduledEvent guildScheduledEvent) {
        int i;
        Intrinsics3.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
        long guildId = guildScheduledEvent.getGuildId();
        List<GuildScheduledEvent> list = this.guildScheduledEvents.get(Long.valueOf(guildId));
        if (list != null) {
            Iterator<GuildScheduledEvent> it = list.iterator();
            i = 0;
            while (it.hasNext()) {
                if (it.next().getId() == guildScheduledEvent.getId()) {
                    break;
                } else {
                    i++;
                }
            }
            i = -1;
        } else {
            i = -1;
        }
        if (i == -1 && !this.guildScheduledEvents.containsKey(Long.valueOf(guildId))) {
            this.guildScheduledEvents.put(Long.valueOf(guildId), Collections2.mutableListOf(guildScheduledEvent));
        } else if (i == -1) {
            ((List) Maps6.getValue(this.guildScheduledEvents, Long.valueOf(guildId))).add(guildScheduledEvent);
        } else {
            ((List) Maps6.getValue(this.guildScheduledEvents, Long.valueOf(guildId))).set(i, guildScheduledEvent);
        }
        if (guildScheduledEvent.getUserRsvp() != null) {
            addMeRsvpForEvent(guildId, guildScheduledEvent.getId());
        }
        markChanged();
    }

    @Store3
    public final void addMeRsvpsForEvent(List<Tuples2<Long, Long>> events) {
        Intrinsics3.checkNotNullParameter(events, "events");
        Iterator<T> it = events.iterator();
        while (it.hasNext()) {
            Tuples2 tuples2 = (Tuples2) it.next();
            addMeRsvpForEvent(((Number) tuples2.getFirst()).longValue(), ((Number) tuples2.getSecond()).longValue());
        }
        markChanged();
    }

    public final void fetchGuildScheduledEventUserCounts(long guildId) {
        List<GuildScheduledEvent> list = this.guildScheduledEvents.get(Long.valueOf(guildId));
        if (list == null || list.isEmpty()) {
            return;
        }
        Long l = this.guildScheduledEventsFetchTimestamps.get(Long.valueOf(guildId));
        if (l == null || this.clock.currentTimeMillis() - l.longValue() >= FETCH_GUILD_EVENTS_THRESHOLD) {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().getGuildScheduledEvents(guildId, true), false, 1, null), StoreGuildScheduledEvents.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(guildId), 62, (Object) null);
        }
    }

    public final void fetchGuildScheduledEventUsers(long guildId, long eventId) {
        this.dispatcher.schedule(new AnonymousClass1(guildId, eventId));
    }

    public final void fetchMeGuildScheduledEvents(long guildId) {
        List<GuildScheduledEvent> list = this.guildScheduledEvents.get(Long.valueOf(guildId));
        if ((list == null || list.isEmpty()) || this.meGuildScheduledEventsFetches.contains(Long.valueOf(guildId))) {
            return;
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().getMeGuildScheduledEvents(guildId), false, 1, null), StoreGuildScheduledEvents.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(guildId), 62, (Object) null);
    }

    public final GuildScheduledEvent getActiveEventForChannel(Long guildId, Long channelId) {
        Object obj = null;
        if (guildId == null || channelId == null) {
            return null;
        }
        Iterator it = getGuildScheduledEvents$default(this, guildId.longValue(), false, 2, null).iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            GuildScheduledEvent guildScheduledEvent = (GuildScheduledEvent) next;
            if (Intrinsics3.areEqual(guildScheduledEvent.getChannelId(), channelId) && guildScheduledEvent.getStatus() == GuildScheduledEventStatus.ACTIVE) {
                obj = next;
                break;
            }
        }
        return (GuildScheduledEvent) obj;
    }

    public final Map<Long, List<GuildScheduledEvent>> getAllGuildScheduledEvents() {
        return this.guildScheduledEventsSnapshot;
    }

    public final Map<Long, GuildScheduledEventUser> getGuildScheduledEventUsers(long eventId) {
        HashMap<Long, GuildScheduledEventUser> map = this.guildScheduledEventUsers.get(Long.valueOf(eventId));
        return map != null ? map : Maps6.emptyMap();
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<GuildScheduledEvent> getGuildScheduledEvents(long guildId, boolean filterInaccessible) {
        Map<Long, Long> permissionsByChannel = this.permissionsStore.getPermissionsByChannel();
        List<GuildScheduledEvent> list = this.guildScheduledEventsSnapshot.get(Long.valueOf(guildId));
        if (list == null) {
            return Collections2.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            GuildScheduledEvent guildScheduledEvent = (GuildScheduledEvent) obj;
            boolean zCan = false;
            if (filterInaccessible) {
                if (guildScheduledEvent.getStatus() != GuildScheduledEventStatus.COMPLETED) {
                    if (guildScheduledEvent.getChannelId() == null) {
                        zCan = true;
                    } else {
                        Long l = permissionsByChannel.get(guildScheduledEvent.getChannelId());
                        if (l != null) {
                            zCan = PermissionUtils.can(Permission.VIEW_CHANNEL, Long.valueOf(l.longValue()));
                        }
                    }
                }
            }
            if (zCan) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final boolean getIsFetchingGuildScheduledEventUsers() {
        return this.isFetchingGuildScheduledEventUsers;
    }

    public final boolean getIsGuildScheduledEventUsersError() {
        return this.isGuildScheduledEventUsersError;
    }

    public final Set<Long> getMeGuildScheduledEventIds(long guildId) {
        Set<Long> set = this.meGuildScheduledEventIdsSnapshot.get(Long.valueOf(guildId));
        return set != null ? set : Sets5.emptySet();
    }

    @Store3
    public final void handleConnectionOpen(ModelPayload payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        this.guildScheduledEventsFetchTimestamps.clear();
        this.meGuildScheduledEventsFetches.clear();
        this.guildScheduledEventUsersFetches.clear();
        this.guildScheduledEvents.clear();
        this.meGuildScheduledEventIds.clear();
        List<Guild> guilds = payload.getGuilds();
        Intrinsics3.checkNotNullExpressionValue(guilds, "payload.guilds");
        Iterator<T> it = guilds.iterator();
        while (it.hasNext()) {
            List<GuildScheduledEvent> listO = ((Guild) it.next()).o();
            if (listO != null) {
                Iterator<T> it2 = listO.iterator();
                while (it2.hasNext()) {
                    processGuildScheduledEventCreateOrUpdate((GuildScheduledEvent) it2.next());
                }
            }
        }
        markChanged();
    }

    @Store3
    public final void handleGuildCreate(Guild guild) {
        Intrinsics3.checkNotNullParameter(guild, "guild");
        List<GuildScheduledEvent> listO = guild.o();
        if (listO != null) {
            Iterator<T> it = listO.iterator();
            while (it.hasNext()) {
                processGuildScheduledEventCreateOrUpdate((GuildScheduledEvent) it.next());
            }
        }
    }

    @Store3
    public final void handleGuildRemove(long guildId) {
        this.guildScheduledEvents.remove(Long.valueOf(guildId));
        this.guildScheduledEventsFetchTimestamps.remove(Long.valueOf(guildId));
        this.meGuildScheduledEventIds.remove(Long.valueOf(guildId));
        this.meGuildScheduledEventsFetches.remove(Long.valueOf(guildId));
        this.guildScheduledEventUsersFetches.remove(Long.valueOf(guildId));
        markChanged();
    }

    @Store3
    public final void handleGuildScheduledEventCreate(GuildScheduledEvent guildScheduledEvent) {
        Intrinsics3.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
        processGuildScheduledEventCreateOrUpdate(guildScheduledEvent);
    }

    @Store3
    public final void handleGuildScheduledEventDelete(GuildScheduledEvent guildScheduledEvent) {
        List<GuildScheduledEvent> list;
        Intrinsics3.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
        List<GuildScheduledEvent> list2 = this.guildScheduledEvents.get(Long.valueOf(guildScheduledEvent.getGuildId()));
        if (list2 != null) {
            Iterator<GuildScheduledEvent> it = list2.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                } else {
                    if (it.next().getId() == guildScheduledEvent.getId()) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
            if (i != -1 && (list = this.guildScheduledEvents.get(Long.valueOf(guildScheduledEvent.getGuildId()))) != null) {
                list.remove(i);
            }
            removeMeRsvpForEvent(guildScheduledEvent.getGuildId(), guildScheduledEvent.getId());
            markChanged();
        }
    }

    @Store3
    public final void handleGuildScheduledEventUpdate(GuildScheduledEvent guildScheduledEvent) {
        Intrinsics3.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
        processGuildScheduledEventCreateOrUpdate(guildScheduledEvent);
    }

    @Store3
    public final void handleGuildScheduledEventUserAdd(GuildScheduledEventUserUpdate guildScheduledEventUserUpdate) {
        Intrinsics3.checkNotNullParameter(guildScheduledEventUserUpdate, "guildScheduledEventUserUpdate");
        GuildScheduledEvent guildScheduledEventFindEventFromStore$default = findEventFromStore$default(this, guildScheduledEventUserUpdate.getGuildScheduledEventId(), null, 2, null);
        if (guildScheduledEventFindEventFromStore$default != null) {
            processRsvpCreate(guildScheduledEventFindEventFromStore$default, guildScheduledEventUserUpdate.getUserId());
        }
    }

    @Store3
    public final void handleGuildScheduledEventUserRemove(GuildScheduledEventUserUpdate guildScheduledEventUserUpdate) {
        Intrinsics3.checkNotNullParameter(guildScheduledEventUserUpdate, "guildScheduledEventUserUpdate");
        GuildScheduledEvent guildScheduledEventFindEventFromStore$default = findEventFromStore$default(this, guildScheduledEventUserUpdate.getGuildScheduledEventId(), null, 2, null);
        if (guildScheduledEventFindEventFromStore$default != null) {
            processRsvpDelete(guildScheduledEventFindEventFromStore$default, guildScheduledEventUserUpdate.getUserId());
        }
    }

    public final boolean isMeRsvpedToEvent(long guildId, long guildScheduledEventId) {
        Set<Long> setEmptySet = this.meGuildScheduledEventIdsSnapshot.get(Long.valueOf(guildId));
        if (setEmptySet == null) {
            setEmptySet = Sets5.emptySet();
        }
        return setEmptySet.contains(Long.valueOf(guildScheduledEventId));
    }

    public final Observable<GuildScheduledEvent> observeGuildScheduledEvent(Long eventId, Long guildId) {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(eventId, guildId), 14, null);
    }

    public final Observable<List<GuildScheduledEvent>> observeGuildScheduledEvents(long guildId, boolean filterInaccessible) {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(guildId, filterInaccessible), 14, null);
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.guildScheduledEventsSnapshot = new HashMap(this.guildScheduledEvents);
        this.meGuildScheduledEventIdsSnapshot = new HashMap(this.meGuildScheduledEventIds);
        this.guildScheduledEventUsersSnapshot = new HashMap(this.guildScheduledEventUsers);
        this.rsvpsAwaitingSnapshot.clear();
    }

    public final void toggleMeRsvpForEvent(GuildScheduledEvent guildScheduledEvent) {
        Intrinsics3.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
        GuildScheduledEvent guildScheduledEventFindEventFromStore = findEventFromStore(guildScheduledEvent);
        long id2 = guildScheduledEventFindEventFromStore.getId();
        if (this.rsvpsAwaitingNetwork.contains(Long.valueOf(id2)) || this.rsvpsAwaitingSnapshot.contains(Long.valueOf(id2))) {
            return;
        }
        this.rsvpsAwaitingNetwork.add(Long.valueOf(id2));
        this.dispatcher.schedule(new AnonymousClass1(guildScheduledEvent, id2, guildScheduledEventFindEventFromStore));
    }

    public final GuildScheduledEvent findEventFromStore(long eventId, Long guildId) {
        GuildScheduledEvent guildScheduledEvent;
        Object next;
        Object obj = null;
        if (guildId != null) {
            List<GuildScheduledEvent> list = this.guildScheduledEventsSnapshot.get(Long.valueOf(guildId.longValue()));
            if (list != null) {
                Iterator<T> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (eventId == ((GuildScheduledEvent) next).getId()) {
                        break;
                    }
                }
                guildScheduledEvent = (GuildScheduledEvent) next;
            } else {
                guildScheduledEvent = null;
            }
            if (guildScheduledEvent != null) {
                return guildScheduledEvent;
            }
        }
        Iterator it2 = Iterables2.flatten(this.guildScheduledEventsSnapshot.values()).iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next2 = it2.next();
            if (eventId == ((GuildScheduledEvent) next2).getId()) {
                obj = next2;
                break;
            }
        }
        return (GuildScheduledEvent) obj;
    }
}
