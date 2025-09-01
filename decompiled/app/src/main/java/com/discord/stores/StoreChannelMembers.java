package com.discord.stores;

import android.content.Context;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.permission.Permission;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.api.role.GuildRole;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelGuildMemberListUpdate;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.PermissionOverwriteUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.lazy.memberlist.ChannelMemberList;
import com.discord.utilities.lazy.memberlist.MemberListRow;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.chat.input.MentionUtils;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.l.e.UtilityFunctions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.Ranges2;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: StoreChannelMembers.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000à\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 a2\u00020\u0001:\u0004abcdB\u008b\u0001\u0012\u0006\u0010E\u001a\u00020D\u0012\u0006\u0010B\u001a\u00020A\u0012\u0006\u0010]\u001a\u00020\\\u0012\u0006\u0010T\u001a\u00020S\u0012\u0018\u0010N\u001a\u0014\u0012\b\u0012\u00060\nj\u0002`2\u0012\u0006\u0012\u0004\u0018\u00010M0G\u0012\u0016\u0010Y\u001a\u0012\u0012\b\u0012\u00060\nj\u0002`\u000b\u0012\u0004\u0012\u00020X0G\u0012\u0018\u0010[\u001a\u0014\u0012\b\u0012\u00060\nj\u0002`(\u0012\u0006\u0012\u0004\u0018\u00010Z0G\u0012\u0016\u0010H\u001a\u0012\u0012\b\u0012\u00060\nj\u0002`(\u0012\u0004\u0012\u00020*0G¢\u0006\u0004\b_\u0010`J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J/\u0010\r\u001a\u00020\u00022\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\t\u001a\u00020\b2\n\u0010\f\u001a\u00060\nj\u0002`\u000bH\u0003¢\u0006\u0004\b\r\u0010\u000eJ/\u0010\u0011\u001a\u00020\u00022\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\n\u0010\f\u001a\u00060\nj\u0002`\u000bH\u0003¢\u0006\u0004\b\u0011\u0010\u0012J/\u0010\u0015\u001a\u00020\u00022\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u0014\u001a\u00020\u00132\n\u0010\f\u001a\u00060\nj\u0002`\u000bH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J/\u0010\u0019\u001a\u00020\u00022\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u0018\u001a\u00020\u00172\n\u0010\f\u001a\u00060\nj\u0002`\u000bH\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ/\u0010\u001d\u001a\u00020\u00022\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u001c\u001a\u00020\u001b2\n\u0010\f\u001a\u00060\nj\u0002`\u000bH\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ%\u0010\"\u001a\u0004\u0018\u00010!2\n\u0010\f\u001a\u00060\nj\u0002`\u000b2\u0006\u0010 \u001a\u00020\u001fH\u0003¢\u0006\u0004\b\"\u0010#J#\u0010&\u001a\u00020!2\n\u0010\f\u001a\u00060\nj\u0002`\u000b2\u0006\u0010%\u001a\u00020$H\u0003¢\u0006\u0004\b&\u0010'J1\u0010,\u001a\u0004\u0018\u00010!2\n\u0010\f\u001a\u00060\nj\u0002`\u000b2\n\u0010)\u001a\u00060\nj\u0002`(2\u0006\u0010+\u001a\u00020*H\u0003¢\u0006\u0004\b,\u0010-J)\u0010/\u001a\u0004\u0018\u00010.2\n\u0010\f\u001a\u00060\nj\u0002`\u000b2\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006H\u0003¢\u0006\u0004\b/\u00100J\u001b\u0010+\u001a\u00020*2\n\u0010\f\u001a\u00060\nj\u0002`\u000bH\u0003¢\u0006\u0004\b+\u00101J%\u00104\u001a\u00020.2\n\u0010\f\u001a\u00060\nj\u0002`\u000b2\n\u00103\u001a\u00060\nj\u0002`2¢\u0006\u0004\b4\u00105J+\u00107\u001a\b\u0012\u0004\u0012\u00020.062\n\u0010\f\u001a\u00060\nj\u0002`\u000b2\n\u00103\u001a\u00060\nj\u0002`2¢\u0006\u0004\b7\u00108J\u0017\u0010;\u001a\u00020\u00022\u0006\u0010:\u001a\u000209H\u0007¢\u0006\u0004\b;\u0010<J\u000f\u0010=\u001a\u00020\u0002H\u0016¢\u0006\u0004\b=\u0010\u0004J\u001b\u0010>\u001a\u00020\u00022\n\u0010\f\u001a\u00060\nj\u0002`\u000bH\u0007¢\u0006\u0004\b>\u0010?J\u001b\u0010@\u001a\u00020\u00022\n\u0010\f\u001a\u00060\nj\u0002`\u000bH\u0007¢\u0006\u0004\b@\u0010?R\u0016\u0010B\u001a\u00020A8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010E\u001a\u00020D8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010FR&\u0010H\u001a\u0012\u0012\b\u0012\u00060\nj\u0002`(\u0012\u0004\u0012\u00020*0G8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010IR6\u0010K\u001a\"\u0012\b\u0012\u00060\nj\u0002`\u000b\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020.0J0J8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010LR(\u0010N\u001a\u0014\u0012\b\u0012\u00060\nj\u0002`2\u0012\u0006\u0012\u0004\u0018\u00010M0G8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010IR:\u0010Q\u001a&\u0012\f\u0012\n P*\u0004\u0018\u00010\u00020\u0002 P*\u0012\u0012\f\u0012\n P*\u0004\u0018\u00010\u00020\u0002\u0018\u00010O0O8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010T\u001a\u00020S8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010UR6\u0010W\u001a\"\u0012\b\u0012\u00060\nj\u0002`\u000b\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020.0V0V8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010LR&\u0010Y\u001a\u0012\u0012\b\u0012\u00060\nj\u0002`\u000b\u0012\u0004\u0012\u00020X0G8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bY\u0010IR(\u0010[\u001a\u0014\u0012\b\u0012\u00060\nj\u0002`(\u0012\u0006\u0012\u0004\u0018\u00010Z0G8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b[\u0010IR\u0016\u0010]\u001a\u00020\\8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b]\u0010^¨\u0006e"}, d2 = {"Lcom/discord/stores/StoreChannelMembers;", "Lcom/discord/stores/StoreV2;", "", "throttleMarkChanged", "()V", "", "Lcom/discord/primitives/MemberListId;", "memberListId", "Lcom/discord/models/domain/ModelGuildMemberListUpdate$Operation$Sync;", "syncOperation", "", "Lcom/discord/primitives/GuildId;", "guildId", "handleSync", "(Ljava/lang/String;Lcom/discord/models/domain/ModelGuildMemberListUpdate$Operation$Sync;J)V", "Lcom/discord/models/domain/ModelGuildMemberListUpdate$Operation$Insert;", "insertOperation", "handleInsert", "(Ljava/lang/String;Lcom/discord/models/domain/ModelGuildMemberListUpdate$Operation$Insert;J)V", "Lcom/discord/models/domain/ModelGuildMemberListUpdate$Operation$Update;", "updateOperation", "handleUpdate", "(Ljava/lang/String;Lcom/discord/models/domain/ModelGuildMemberListUpdate$Operation$Update;J)V", "Lcom/discord/models/domain/ModelGuildMemberListUpdate$Operation$Delete;", "deleteOperation", "handleDelete", "(Ljava/lang/String;Lcom/discord/models/domain/ModelGuildMemberListUpdate$Operation$Delete;J)V", "Lcom/discord/models/domain/ModelGuildMemberListUpdate$Operation$Invalidate;", "operation", "handleInvalidate", "(Ljava/lang/String;Lcom/discord/models/domain/ModelGuildMemberListUpdate$Operation$Invalidate;J)V", "Lcom/discord/models/domain/ModelGuildMemberListUpdate$Operation$Item;", "item", "Lcom/discord/utilities/lazy/memberlist/MemberListRow;", "makeRow", "(JLcom/discord/models/domain/ModelGuildMemberListUpdate$Operation$Item;)Lcom/discord/utilities/lazy/memberlist/MemberListRow;", "Lcom/discord/models/domain/ModelGuildMemberListUpdate$Group;", "group", "makeGroup", "(JLcom/discord/models/domain/ModelGuildMemberListUpdate$Group;)Lcom/discord/utilities/lazy/memberlist/MemberListRow;", "Lcom/discord/primitives/UserId;", "userId", "", "allowOwnerIndicator", "makeRowMember", "(JJZ)Lcom/discord/utilities/lazy/memberlist/MemberListRow;", "Lcom/discord/utilities/lazy/memberlist/ChannelMemberList;", "getMemberList", "(JLjava/lang/String;)Lcom/discord/utilities/lazy/memberlist/ChannelMemberList;", "(J)Z", "Lcom/discord/primitives/ChannelId;", "channelId", "getChannelMemberList", "(JJ)Lcom/discord/utilities/lazy/memberlist/ChannelMemberList;", "Lrx/Observable;", "observeChannelMemberList", "(JJ)Lrx/Observable;", "Lcom/discord/models/domain/ModelGuildMemberListUpdate;", "update", "handleGuildMemberListUpdate", "(Lcom/discord/models/domain/ModelGuildMemberListUpdate;)V", "snapshotData", "handleGuildRemove", "(J)V", "handleGuildRoleCreateOrUpdate", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "Lkotlin/Function1;", "isUserStreaming", "Lkotlin/jvm/functions/Function1;", "", "memberLists", "Ljava/util/Map;", "Lcom/discord/api/channel/Channel;", "getChannel", "Lrx/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "markChangedTrigger", "Lrx/subjects/PublishSubject;", "Lcom/discord/stores/StoreUser;", "storeUser", "Lcom/discord/stores/StoreUser;", "", "memberListsSnapshot", "", "getGuildMemberCount", "Lcom/discord/models/presence/Presence;", "getPresence", "Lcom/discord/stores/StoreGuilds;", "storeGuilds", "Lcom/discord/stores/StoreGuilds;", "<init>", "(Lcom/discord/stores/updates/ObservationDeck;Lcom/discord/stores/Dispatcher;Lcom/discord/stores/StoreGuilds;Lcom/discord/stores/StoreUser;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "Companion", "MemberListIdCalculator", "MemberListUpdateException", "MemberListUpdateLogger", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreChannelMembers extends StoreV2 {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Dispatcher dispatcher;
    private final Function1<Long, Channel> getChannel;
    private final Function1<Long, Integer> getGuildMemberCount;
    private final Function1<Long, Presence> getPresence;
    private final Function1<Long, Boolean> isUserStreaming;
    private final PublishSubject<Unit> markChangedTrigger;
    private final Map<Long, Map<String, ChannelMemberList>> memberLists;
    private Map<Long, ? extends Map<String, ChannelMemberList>> memberListsSnapshot;
    private final ObservationDeck observationDeck;
    private final StoreGuilds storeGuilds;
    private final StoreUser storeUser;

    /* compiled from: StoreChannelMembers.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0005\u0010\u0005\u001a\u00020\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "invoke", "(Lkotlin/Unit;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreChannelMembers$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Unit, Unit> {

        /* compiled from: StoreChannelMembers.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreChannelMembers$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01031 extends Lambda implements Function0<Unit> {
            public C01031() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreChannelMembers.this.markChanged();
            }
        }

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
            invoke2(unit);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Unit unit) {
            StoreChannelMembers.access$getDispatcher$p(StoreChannelMembers.this).schedule(new C01031());
        }
    }

    /* compiled from: StoreChannelMembers.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013Jg\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0018\u0010\u0007\u001a\u0014\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0016\u0010\t\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\b0\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/discord/stores/StoreChannelMembers$Companion;", "", "", "Lcom/discord/primitives/UserId;", "userId", "", "Lcom/discord/models/member/GuildMember;", "guildMembers", "Lcom/discord/models/user/User;", "users", "Lcom/discord/models/presence/Presence;", "presence", "", "isUserStreaming", "showOwnerIndicator", "Lcom/discord/utilities/lazy/memberlist/MemberListRow$Member;", "makeRowMember", "(JLjava/util/Map;Ljava/util/Map;Lcom/discord/models/presence/Presence;ZZ)Lcom/discord/utilities/lazy/memberlist/MemberListRow$Member;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final MemberListRow.Member makeRowMember(long userId, Map<Long, GuildMember> guildMembers, Map<Long, ? extends User> users, Presence presence, boolean isUserStreaming, boolean showOwnerIndicator) {
            Intrinsics3.checkNotNullParameter(users, "users");
            GuildMember guildMember = guildMembers != null ? guildMembers.get(Long.valueOf(userId)) : null;
            User user = users.get(Long.valueOf(userId));
            if (user == null || guildMember == null) {
                return null;
            }
            return new MemberListRow.Member(userId, GuildMember.INSTANCE.getNickOrUsername(guildMember, user), user.getIsBot(), Integer.valueOf(user.getIsSystemUser() ? R.string.system_dm_tag_system : R.string.bot_tag_bot), UserUtils.INSTANCE.isVerifiedBot(user), presence, guildMember.getColor() != -16777216 ? Integer.valueOf(guildMember.getColor()) : null, IconUtils.getForGuildMemberOrUser$default(IconUtils.INSTANCE, user, guildMember, null, false, 12, null), showOwnerIndicator, guildMember.getPremiumSince(), isUserStreaming, user.getFlags() | user.getPublicFlags());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreChannelMembers.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000bJ;\u0010\u0013\u001a\u00020\t2\u0018\u0010\u000f\u001a\u0014\u0012\b\u0012\u00060\u0003j\u0002`\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\f2\n\u0010\u0010\u001a\u00060\u0003j\u0002`\r2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/discord/stores/StoreChannelMembers$MemberListIdCalculator;", "", "", "", "toUnsignedLong", "(I)J", "", "Lcom/discord/api/permission/PermissionOverwrite;", "permissionOverwrites", "", "computeIdFromOverwrites", "(Ljava/util/List;)Ljava/lang/String;", "Lkotlin/Function1;", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/channel/Channel;", "channelsProvider", "channelId", "Lcom/discord/stores/StoreGuilds;", "storeGuilds", "computeMemberListId", "(Lkotlin/jvm/functions/Function1;JLcom/discord/stores/StoreGuilds;)Ljava/lang/String;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class MemberListIdCalculator {
        public static final MemberListIdCalculator INSTANCE = new MemberListIdCalculator();

        private MemberListIdCalculator() {
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0079  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final String computeIdFromOverwrites(List<PermissionOverwrite> permissionOverwrites) {
            String strValueOf;
            String strJoinToString$default;
            if (permissionOverwrites != null) {
                ArrayList arrayList = new ArrayList();
                for (PermissionOverwrite permissionOverwrite : permissionOverwrites) {
                    if (PermissionOverwriteUtils.allows(permissionOverwrite, Permission.VIEW_CHANNEL)) {
                        StringBuilder sbU = outline.U("allow:");
                        sbU.append(permissionOverwrite.e());
                        arrayList.add(sbU.toString());
                    } else if (PermissionOverwriteUtils.denies(permissionOverwrite, Permission.VIEW_CHANNEL)) {
                        StringBuilder sbU2 = outline.U("deny:");
                        sbU2.append(permissionOverwrite.e());
                        arrayList.add(sbU2.toString());
                    }
                }
                List listSorted = _Collections.sorted(arrayList);
                strValueOf = (listSorted == null || (strJoinToString$default = _Collections.joinToString$default(listSorted, ",", null, null, 0, null, null, 62, null)) == null) ? null : String.valueOf(INSTANCE.toUnsignedLong(UtilityFunctions.a(strJoinToString$default, 0, strJoinToString$default.length(), 0)));
            }
            return strValueOf != null ? strValueOf : "";
        }

        private final long toUnsignedLong(int i) {
            return i & 4294967295L;
        }

        public final String computeMemberListId(Function1<? super Long, Channel> channelsProvider, long channelId, StoreGuilds storeGuilds) {
            Intrinsics3.checkNotNullParameter(channelsProvider, "channelsProvider");
            Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
            Channel channelInvoke = channelsProvider.invoke(Long.valueOf(channelId));
            String memberListId = channelInvoke != null ? channelInvoke.getMemberListId() : null;
            if (channelInvoke != null) {
                if (memberListId != null) {
                    return memberListId;
                }
                Map mapEmptyMap = (Map) outline.c(channelInvoke, storeGuilds.getRoles());
                if (mapEmptyMap == null) {
                    mapEmptyMap = Maps6.emptyMap();
                }
                if (!PermissionUtils.canEveryone(Permission.VIEW_CHANNEL, channelInvoke, null, mapEmptyMap)) {
                    return computeIdFromOverwrites(channelInvoke.v());
                }
            }
            return ModelGuildMemberListUpdate.EVERYONE_ID;
        }
    }

    /* compiled from: StoreChannelMembers.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0013\u0012\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/discord/stores/StoreChannelMembers$MemberListUpdateException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "<init>", "(Ljava/lang/Exception;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class MemberListUpdateException extends RuntimeException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MemberListUpdateException(Exception exc) {
            super(exc);
            Intrinsics3.checkNotNullParameter(exc, "e");
        }
    }

    /* compiled from: StoreChannelMembers.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ'\u0010\b\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ1\u0010\u0012\u001a\u00020\f2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u00062\n\u0010\u0011\u001a\u00060\u000fj\u0002`\u0010¢\u0006\u0004\b\u0012\u0010\u0013R(\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00150\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u00020\u00058\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/discord/stores/StoreChannelMembers$MemberListUpdateLogger;", "", "", "Lcom/discord/primitives/GuildId;", "guildId", "", "Lcom/discord/primitives/MemberListId;", "memberListId", "makeLogKey", "(JLjava/lang/String;)Ljava/lang/String;", "Lcom/discord/models/domain/ModelGuildMemberListUpdate;", "update", "", "logUpdate", "(Lcom/discord/models/domain/ModelGuildMemberListUpdate;)V", "Ljava/lang/Exception;", "Lkotlin/Exception;", "exception", "dumpLogs", "(JLjava/lang/String;Ljava/lang/Exception;)V", "", "", "opLogs", "Ljava/util/Map;", "ERROR_TAG", "Ljava/lang/String;", "", "MAX_UPDATE_COUNT", "I", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class MemberListUpdateLogger {
        private static final String ERROR_TAG = "MemberListUpdateError";
        private static final int MAX_UPDATE_COUNT = 20;
        public static final MemberListUpdateLogger INSTANCE = new MemberListUpdateLogger();
        private static final Map<String, List<String>> opLogs = new HashMap();

        private MemberListUpdateLogger() {
        }

        private final String makeLogKey(long guildId, String memberListId) {
            return guildId + MentionUtils.EMOJIS_AND_STICKERS_CHAR + memberListId;
        }

        public final void dumpLogs(long guildId, String memberListId, Exception exception) {
            Intrinsics3.checkNotNullParameter(memberListId, "memberListId");
            Intrinsics3.checkNotNullParameter(exception, "exception");
            List<String> list = opLogs.get(makeLogKey(guildId, memberListId));
            StringBuilder sb = new StringBuilder();
            sb.append("guildId: ");
            sb.append(guildId);
            sb.append(" -- memberListId: ");
            sb.append(memberListId);
            sb.append(" -- LAST 20 UPDATES:\n");
            sb.append(list != null ? _Collections.joinToString$default(list, "\n", null, null, 0, null, null, 62, null) : null);
            FirebaseCrashlytics.getInstance().log(sb.toString());
            Logger.e$default(AppLog.g, ERROR_TAG, new MemberListUpdateException(exception), null, 4, null);
        }

        public final void logUpdate(ModelGuildMemberListUpdate update) {
            String string;
            Intrinsics3.checkNotNullParameter(update, "update");
            List<ModelGuildMemberListUpdate.Operation> operations = update.getOperations();
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(operations, 10));
            for (ModelGuildMemberListUpdate.Operation operation : operations) {
                if (operation instanceof ModelGuildMemberListUpdate.Operation.Sync) {
                    StringBuilder sbU = outline.U("  SYNC: ");
                    sbU.append(((ModelGuildMemberListUpdate.Operation.Sync) operation).getRange());
                    string = sbU.toString();
                } else if (operation instanceof ModelGuildMemberListUpdate.Operation.Update) {
                    StringBuilder sbU2 = outline.U("  UPDATE: ");
                    sbU2.append(((ModelGuildMemberListUpdate.Operation.Update) operation).getIndex());
                    string = sbU2.toString();
                } else if (operation instanceof ModelGuildMemberListUpdate.Operation.Insert) {
                    StringBuilder sbU3 = outline.U("  INSERT: ");
                    sbU3.append(((ModelGuildMemberListUpdate.Operation.Insert) operation).getIndex());
                    string = sbU3.toString();
                } else if (operation instanceof ModelGuildMemberListUpdate.Operation.Delete) {
                    StringBuilder sbU4 = outline.U("  DELETE: ");
                    sbU4.append(((ModelGuildMemberListUpdate.Operation.Delete) operation).getIndex());
                    string = sbU4.toString();
                } else {
                    if (!(operation instanceof ModelGuildMemberListUpdate.Operation.Invalidate)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    StringBuilder sbU5 = outline.U("  INVALIDATE: ");
                    sbU5.append(((ModelGuildMemberListUpdate.Operation.Invalidate) operation).getRange());
                    string = sbU5.toString();
                }
                arrayList.add(string);
            }
            String strJ = outline.J(outline.U("GROUPS: ["), _Collections.joinToString$default(update.getGroups(), ",", null, null, 0, null, StoreChannelMembers3.INSTANCE, 30, null), "]");
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(arrayList);
            arrayList2.add(strJ);
            arrayList2.add("-----");
            String strMakeLogKey = makeLogKey(update.getGuildId(), update.getId());
            Map<String, List<String>> map = opLogs;
            List<String> arrayList3 = map.get(strMakeLogKey);
            if (arrayList3 == null) {
                arrayList3 = new ArrayList<>();
            }
            arrayList3.add(_Collections.joinToString$default(arrayList2, "\n", null, null, 0, null, null, 62, null));
            if (arrayList3.size() > 20) {
                arrayList3.remove(0);
            }
            map.put(strMakeLogKey, arrayList3);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            ModelGuildMemberListUpdate.Group.Type.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[ModelGuildMemberListUpdate.Group.Type.ROLE.ordinal()] = 1;
            iArr[ModelGuildMemberListUpdate.Group.Type.OFFLINE.ordinal()] = 2;
            iArr[ModelGuildMemberListUpdate.Group.Type.ONLINE.ordinal()] = 3;
        }
    }

    /* compiled from: StoreChannelMembers.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/domain/ModelGuildMemberListUpdate$Group;", "it", "Lcom/discord/utilities/lazy/memberlist/MemberListRow;", "invoke", "(Lcom/discord/models/domain/ModelGuildMemberListUpdate$Group;)Lcom/discord/utilities/lazy/memberlist/MemberListRow;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreChannelMembers$handleGuildMemberListUpdate$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<ModelGuildMemberListUpdate.Group, MemberListRow> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(long j) {
            super(1);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ MemberListRow invoke(ModelGuildMemberListUpdate.Group group) {
            return invoke2(group);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final MemberListRow invoke2(ModelGuildMemberListUpdate.Group group) {
            Intrinsics3.checkNotNullParameter(group, "it");
            return StoreChannelMembers.access$makeGroup(StoreChannelMembers.this, this.$guildId, group);
        }
    }

    /* compiled from: StoreChannelMembers.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/utilities/lazy/memberlist/ChannelMemberList;", "invoke", "()Lcom/discord/utilities/lazy/memberlist/ChannelMemberList;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreChannelMembers$observeChannelMemberList$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<ChannelMemberList> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, long j2) {
            super(0);
            this.$guildId = j;
            this.$channelId = j2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ ChannelMemberList invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ChannelMemberList invoke() {
            return StoreChannelMembers.this.getChannelMemberList(this.$guildId, this.$channelId);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StoreChannelMembers(ObservationDeck observationDeck, Dispatcher dispatcher, StoreGuilds storeGuilds, StoreUser storeUser, Function1<? super Long, Channel> function1, Function1<? super Long, Integer> function12, Function1<? super Long, Presence> function13, Function1<? super Long, Boolean> function14) {
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        Intrinsics3.checkNotNullParameter(storeUser, "storeUser");
        Intrinsics3.checkNotNullParameter(function1, "getChannel");
        Intrinsics3.checkNotNullParameter(function12, "getGuildMemberCount");
        Intrinsics3.checkNotNullParameter(function13, "getPresence");
        Intrinsics3.checkNotNullParameter(function14, "isUserStreaming");
        this.observationDeck = observationDeck;
        this.dispatcher = dispatcher;
        this.storeGuilds = storeGuilds;
        this.storeUser = storeUser;
        this.getChannel = function1;
        this.getGuildMemberCount = function12;
        this.getPresence = function13;
        this.isUserStreaming = function14;
        this.memberLists = new LinkedHashMap();
        this.memberListsSnapshot = Maps6.emptyMap();
        PublishSubject<Unit> publishSubjectK0 = PublishSubject.k0();
        this.markChangedTrigger = publishSubjectK0;
        Intrinsics3.checkNotNullExpressionValue(publishSubjectK0, "markChangedTrigger");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.leadingEdgeThrottle(publishSubjectK0, 1L, TimeUnit.SECONDS), StoreChannelMembers.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreChannelMembers storeChannelMembers) {
        return storeChannelMembers.dispatcher;
    }

    public static final /* synthetic */ MemberListRow access$makeGroup(StoreChannelMembers storeChannelMembers, long j, ModelGuildMemberListUpdate.Group group) {
        return storeChannelMembers.makeGroup(j, group);
    }

    public static final /* synthetic */ MemberListRow access$makeRowMember(StoreChannelMembers storeChannelMembers, long j, long j2, boolean z2) {
        return storeChannelMembers.makeRowMember(j, j2, z2);
    }

    @Store3
    private final boolean allowOwnerIndicator(long guildId) {
        Collection<GuildRole> collectionValues;
        Map<Long, GuildRole> map = this.storeGuilds.getGuildRolesInternal$app_productionGoogleRelease().get(Long.valueOf(guildId));
        boolean z2 = false;
        if (map != null && (collectionValues = map.values()) != null && !collectionValues.isEmpty()) {
            Iterator<T> it = collectionValues.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                GuildRole guildRole = (GuildRole) it.next();
                if (guildRole.getHoist() && PermissionUtils.can(8L, Long.valueOf(guildRole.getPermissions()))) {
                    z2 = true;
                    break;
                }
            }
        }
        return !z2;
    }

    @Store3
    private final ChannelMemberList getMemberList(long guildId, String memberListId) {
        Map<String, ChannelMemberList> map = this.memberLists.get(Long.valueOf(guildId));
        if (map != null) {
            return map.get(memberListId);
        }
        return null;
    }

    @Store3
    private final void handleDelete(String memberListId, ModelGuildMemberListUpdate.Operation.Delete deleteOperation, long guildId) {
        ChannelMemberList memberList = getMemberList(guildId, memberListId);
        if (memberList != null) {
            memberList.delete(deleteOperation.getIndex());
        }
    }

    @Store3
    private final void handleInsert(String memberListId, ModelGuildMemberListUpdate.Operation.Insert insertOperation, long guildId) {
        int index = insertOperation.getIndex();
        ChannelMemberList memberList = getMemberList(guildId, memberListId);
        if (memberList != null) {
            memberList.insert(index, makeRow(guildId, insertOperation.getItem()));
        }
    }

    @Store3
    private final void handleInvalidate(String memberListId, ModelGuildMemberListUpdate.Operation.Invalidate operation, long guildId) {
        Ranges2 range = operation.getRange();
        ChannelMemberList memberList = getMemberList(guildId, memberListId);
        if (memberList != null) {
            memberList.invalidate(range);
        }
    }

    @Store3
    private final void handleSync(String memberListId, ModelGuildMemberListUpdate.Operation.Sync syncOperation, long guildId) throws NumberFormatException {
        MemberListRow memberListRowMakeGroup;
        Map<String, ChannelMemberList> map = this.memberLists.get(Long.valueOf(guildId));
        if (map == null) {
            map = new HashMap<>();
            this.memberLists.put(Long.valueOf(guildId), map);
        }
        ChannelMemberList channelMemberList = map.get(memberListId);
        if (channelMemberList == null) {
            AppLog appLog = AppLog.g;
            channelMemberList = new ChannelMemberList(memberListId, 0, appLog, 2, null);
            map.put(memberListId, channelMemberList);
            appLog.recordBreadcrumb(channelMemberList.getListId() + " INSTANTIATE", "ChannelMemberList");
        }
        boolean zAllowOwnerIndicator = allowOwnerIndicator(guildId);
        List<ModelGuildMemberListUpdate.Operation.Item> items = syncOperation.getItems();
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(items, 10));
        for (ModelGuildMemberListUpdate.Operation.Item item : items) {
            if (item instanceof ModelGuildMemberListUpdate.Operation.Item.MemberItem) {
                memberListRowMakeGroup = makeRowMember(guildId, ((ModelGuildMemberListUpdate.Operation.Item.MemberItem) item).getMember().getUser().getId(), zAllowOwnerIndicator);
            } else {
                if (!(item instanceof ModelGuildMemberListUpdate.Operation.Item.GroupItem)) {
                    throw new NoWhenBranchMatchedException();
                }
                memberListRowMakeGroup = makeGroup(guildId, ((ModelGuildMemberListUpdate.Operation.Item.GroupItem) item).getGroup());
            }
            arrayList.add(memberListRowMakeGroup);
        }
        channelMemberList.sync(((Number) _Collections.first(syncOperation.getRange())).intValue(), arrayList);
    }

    private final void handleUpdate(String memberListId, ModelGuildMemberListUpdate.Operation.Update updateOperation, long guildId) {
        int index = updateOperation.getIndex();
        ChannelMemberList memberList = getMemberList(guildId, memberListId);
        if (memberList != null) {
            memberList.update(index, makeRow(guildId, updateOperation.getItem()));
        }
    }

    @Store3
    private final MemberListRow makeGroup(long guildId, ModelGuildMemberListUpdate.Group group) throws NumberFormatException {
        String name;
        GuildRole guildRole;
        String id2 = group.getId();
        int iOrdinal = group.getType().ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                return new MemberListRow.StatusHeader(id2, MemberListRow.StatusHeader.Type.OFFLINE, group.getCount());
            }
            if (iOrdinal == 2) {
                return new MemberListRow.StatusHeader(id2, MemberListRow.StatusHeader.Type.ONLINE, group.getCount());
            }
            throw new NoWhenBranchMatchedException();
        }
        long j = Long.parseLong(id2);
        Map<Long, GuildRole> map = this.storeGuilds.getGuildRolesInternal$app_productionGoogleRelease().get(Long.valueOf(guildId));
        if (map == null || (guildRole = map.get(Long.valueOf(j))) == null || (name = guildRole.getName()) == null) {
            name = "";
        }
        return new MemberListRow.RoleHeader(j, name, group.getCount());
    }

    @Store3
    private final MemberListRow makeRow(long guildId, ModelGuildMemberListUpdate.Operation.Item item) {
        if (item instanceof ModelGuildMemberListUpdate.Operation.Item.MemberItem) {
            return makeRowMember(guildId, ((ModelGuildMemberListUpdate.Operation.Item.MemberItem) item).getMember().getUser().getId(), allowOwnerIndicator(guildId));
        }
        if (item instanceof ModelGuildMemberListUpdate.Operation.Item.GroupItem) {
            return makeGroup(guildId, ((ModelGuildMemberListUpdate.Operation.Item.GroupItem) item).getGroup());
        }
        throw new NoWhenBranchMatchedException();
    }

    @Store3
    private final MemberListRow makeRowMember(long guildId, long userId, boolean allowOwnerIndicator) {
        Guild guild;
        return INSTANCE.makeRowMember(userId, this.storeGuilds.getGuildMembersComputedInternal$app_productionGoogleRelease().get(Long.valueOf(guildId)), this.storeUser.getUsersInternal$app_productionGoogleRelease(), this.getPresence.invoke(Long.valueOf(userId)), this.isUserStreaming.invoke(Long.valueOf(userId)).booleanValue(), allowOwnerIndicator && (guild = this.storeGuilds.getGuildsInternal$app_productionGoogleRelease().get(Long.valueOf(guildId))) != null && guild.getOwnerId() == userId);
    }

    private final void throttleMarkChanged() {
        PublishSubject<Unit> publishSubject = this.markChangedTrigger;
        publishSubject.k.onNext(Unit.a);
    }

    public final ChannelMemberList getChannelMemberList(long guildId, long channelId) {
        String strComputeMemberListId = MemberListIdCalculator.INSTANCE.computeMemberListId(this.getChannel, channelId, this.storeGuilds);
        Map<String, ChannelMemberList> mapEmptyMap = this.memberListsSnapshot.get(Long.valueOf(guildId));
        if (mapEmptyMap == null) {
            mapEmptyMap = Maps6.emptyMap();
        }
        ChannelMemberList channelMemberList = mapEmptyMap.get(strComputeMemberListId);
        return channelMemberList != null ? channelMemberList : new ChannelMemberList(strComputeMemberListId, this.getGuildMemberCount.invoke(Long.valueOf(guildId)).intValue(), AppLog.g);
    }

    @Store3
    public final void handleGuildMemberListUpdate(ModelGuildMemberListUpdate update) {
        Intrinsics3.checkNotNullParameter(update, "update");
        long guildId = update.getGuildId();
        String id2 = update.getId();
        MemberListUpdateLogger.INSTANCE.logUpdate(update);
        try {
            for (ModelGuildMemberListUpdate.Operation operation : update.getOperations()) {
                if (operation instanceof ModelGuildMemberListUpdate.Operation.Sync) {
                    handleSync(id2, (ModelGuildMemberListUpdate.Operation.Sync) operation, guildId);
                } else if (operation instanceof ModelGuildMemberListUpdate.Operation.Update) {
                    handleUpdate(id2, (ModelGuildMemberListUpdate.Operation.Update) operation, guildId);
                } else if (operation instanceof ModelGuildMemberListUpdate.Operation.Insert) {
                    handleInsert(id2, (ModelGuildMemberListUpdate.Operation.Insert) operation, guildId);
                } else if (operation instanceof ModelGuildMemberListUpdate.Operation.Delete) {
                    handleDelete(id2, (ModelGuildMemberListUpdate.Operation.Delete) operation, guildId);
                } else if (operation instanceof ModelGuildMemberListUpdate.Operation.Invalidate) {
                    handleInvalidate(id2, (ModelGuildMemberListUpdate.Operation.Invalidate) operation, guildId);
                }
            }
            ChannelMemberList memberList = getMemberList(update.getGuildId(), id2);
            if (memberList != null) {
                memberList.setGroups(update.getGroups(), new AnonymousClass2(guildId));
            }
        } catch (Exception e) {
            MemberListUpdateLogger.INSTANCE.dumpLogs(guildId, id2, e);
        }
        throttleMarkChanged();
    }

    @Store3
    public final void handleGuildRemove(long guildId) {
        if (this.memberLists.remove(Long.valueOf(guildId)) != null) {
            throttleMarkChanged();
        }
    }

    @Store3
    public final void handleGuildRoleCreateOrUpdate(long guildId) {
        boolean zAllowOwnerIndicator = allowOwnerIndicator(guildId);
        Map<String, ChannelMemberList> map = this.memberLists.get(Long.valueOf(guildId));
        if (map != null) {
            Iterator<Map.Entry<String, ChannelMemberList>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().rebuildMembers(new StoreChannelMembers2(this, guildId, zAllowOwnerIndicator));
            }
        }
        throttleMarkChanged();
    }

    public final Observable<ChannelMemberList> observeChannelMemberList(long guildId, long channelId) {
        Observable<ChannelMemberList> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(guildId, channelId), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        Map<Long, Map<String, ChannelMemberList>> map = this.memberLists;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsJVM.mapCapacity(map.size()));
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            Map map2 = (Map) entry.getValue();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsJVM.mapCapacity(map2.size()));
            for (Map.Entry entry2 : map2.entrySet()) {
                linkedHashMap2.put(entry2.getKey(), new ChannelMemberList((ChannelMemberList) entry2.getValue()));
            }
            linkedHashMap.put(key, linkedHashMap2);
        }
        this.memberListsSnapshot = linkedHashMap;
    }
}
