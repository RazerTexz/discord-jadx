package com.discord.widgets.guilds.list;

import a0.a.a.b;
import android.content.Context;
import androidx.fragment.app.FragmentManager;
import androidx.media.AudioAttributesCompat;
import b.a.d.AppToast;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guildjoinrequest.ApplicationStatus;
import com.discord.api.guildjoinrequest.GuildJoinRequest;
import com.discord.api.permission.Permission;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.domain.ModelUserSettings;
import com.discord.models.guild.Guild;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreGuildsSorted;
import com.discord.stores.StoreNavigation;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.features.GrowthTeamFeatures;
import com.discord.utilities.guilds.MemberVerificationUtils;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.streams.StreamContextService;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.widgets.guilds.list.GuildListItem;
import com.discord.widgets.guilds.list.WidgetGuildListAdapter;
import d0.c0.Random;
import d0.f0._Sequences2;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t.MutableCollections;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.sequences.Sequence;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: WidgetGuildsListViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 v2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004vwxyB!\u0012\b\b\u0002\u0010g\u001a\u00020f\u0012\u000e\b\u0002\u0010s\u001a\b\u0012\u0004\u0012\u00020\u00180R¢\u0006\u0004\bt\u0010uJ/\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u000e\u0010\b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ9\u0010\u0012\u001a\u00020\t2\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e2\u0010\u0010\u0011\u001a\f\u0012\b\u0012\u00060\u0006j\u0002`\u00070\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J'\u0010\u0014\u001a\u00020\t2\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J7\u0010\u0016\u001a\u00020\t2\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJµ\u0002\u00109\u001a\u0002082\u0006\u0010\u001d\u001a\u00020\u001c2\n\u0010\u001f\u001a\u00060\u0006j\u0002`\u001e2\n\u0010!\u001a\u00060\u0006j\u0002` 2\u0010\u0010\"\u001a\f\u0012\b\u0012\u00060\u0006j\u0002`\u001e0\u00102\u0016\u0010%\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u001e\u0012\u0004\u0012\u00020$0#2\u0006\u0010&\u001a\u00020\u00032 \u0010(\u001a\u001c\u0012\b\u0012\u00060\u0006j\u0002`\u001e\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0006j\u0002` 0'0#2\u0016\u0010*\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002` \u0012\u0004\u0012\u00020)0#2\u0010\u0010+\u001a\f\u0012\b\u0012\u00060\u0006j\u0002`\u001e0\u00102\u0010\u0010,\u001a\f\u0012\b\u0012\u00060\u0006j\u0002`\u001e0\u00102\u0010\u0010-\u001a\f\u0012\b\u0012\u00060\u0006j\u0002`\u001e0\u00102\u000e\u0010\b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00072\b\u0010/\u001a\u0004\u0018\u00010.2\u0018\u00102\u001a\u0014\u0012\b\u0012\u00060\u0006j\u0002`0\u0012\u0004\u0012\u000201\u0018\u00010#2\u001a\u00104\u001a\u0016\u0012\b\u0012\u00060\u0006j\u0002` \u0012\b\u0012\u00060\u0006j\u0002`30#2\b\u00106\u001a\u0004\u0018\u0001052\b\b\u0002\u00107\u001a\u00020.H\u0002¢\u0006\u0004\b9\u0010:JO\u0010@\u001a\b\u0012\u0004\u0012\u00020?0>2\u0016\u0010;\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002` \u0012\u0004\u0012\u00020)0#2\u0016\u0010<\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002` \u0012\u0004\u0012\u00020\u00030#2\b\u0010=\u001a\u0004\u0018\u00010$H\u0002¢\u0006\u0004\b@\u0010AJµ\u0002\u0010F\u001a\b\u0012\u0004\u0012\u00020\r0'2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u001c0'2\u0016\u0010D\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u001e\u0012\u0004\u0012\u00020C0#2\u0010\u0010E\u001a\f\u0012\b\u0012\u00060\u0006j\u0002`\u00070\u00102\n\u0010\u001f\u001a\u00060\u0006j\u0002`\u001e2\n\u0010!\u001a\u00060\u0006j\u0002` 2\u0010\u0010\"\u001a\f\u0012\b\u0012\u00060\u0006j\u0002`\u001e0\u00102\u0016\u0010%\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u001e\u0012\u0004\u0012\u00020$0#2 \u0010(\u001a\u001c\u0012\b\u0012\u00060\u0006j\u0002`\u001e\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0006j\u0002` 0'0#2\u0016\u0010*\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002` \u0012\u0004\u0012\u00020)0#2\u0010\u0010+\u001a\f\u0012\b\u0012\u00060\u0006j\u0002`\u001e0\u00102\u0010\u0010,\u001a\f\u0012\b\u0012\u00060\u0006j\u0002`\u001e0\u00102\u0010\u0010-\u001a\f\u0012\b\u0012\u00060\u0006j\u0002`\u001e0\u00102\u0018\u00102\u001a\u0014\u0012\b\u0012\u00060\u0006j\u0002`0\u0012\u0004\u0012\u000201\u0018\u00010#2\u001a\u00104\u001a\u0016\u0012\b\u0012\u00060\u0006j\u0002` \u0012\b\u0012\u00060\u0006j\u0002`30#H\u0002¢\u0006\u0004\bF\u0010GJU\u0010K\u001a\u00020\u00032\n\u0010H\u001a\u00060\u0006j\u0002`\u001e2 \u0010J\u001a\u001c\u0012\b\u0012\u00060\u0006j\u0002`\u001e\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0006j\u0002` 0I0#2\u0016\u0010<\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002` \u0012\u0004\u0012\u00020\u00030#H\u0002¢\u0006\u0004\bK\u0010LJ[\u0010P\u001a\u00020.2\n\u0010H\u001a\u00060\u0006j\u0002`\u001e2\b\u0010M\u001a\u0004\u0018\u00010$2\u0018\u0010N\u001a\u0014\u0012\b\u0012\u00060\u0006j\u0002`0\u0012\u0004\u0012\u000201\u0018\u00010#2\u001a\u0010O\u001a\u0016\u0012\b\u0012\u00060\u0006j\u0002` \u0012\b\u0012\u00060\u0006j\u0002`30#H\u0002¢\u0006\u0004\bP\u0010QJ\u0013\u0010T\u001a\b\u0012\u0004\u0012\u00020S0R¢\u0006\u0004\bT\u0010UJ%\u0010[\u001a\u00020\t2\u0006\u0010V\u001a\u00020\r2\u0006\u0010X\u001a\u00020W2\u0006\u0010Z\u001a\u00020Y¢\u0006\u0004\b[\u0010\\J\u0015\u0010]\u001a\u00020\t2\u0006\u0010V\u001a\u00020\r¢\u0006\u0004\b]\u0010^J\r\u0010_\u001a\u00020.¢\u0006\u0004\b_\u0010`J\u001d\u0010a\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\ba\u0010bJ\u001d\u0010d\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010c\u001a\u00020\u0003¢\u0006\u0004\bd\u0010bJ\u001d\u0010e\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010c\u001a\u00020\u0003¢\u0006\u0004\be\u0010bR\u0016\u0010g\u001a\u00020f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bg\u0010hR:\u0010k\u001a&\u0012\f\u0012\n j*\u0004\u0018\u00010S0S j*\u0012\u0012\f\u0012\n j*\u0004\u0018\u00010S0S\u0018\u00010i0i8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bk\u0010lR\u0016\u0010m\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010nR\u0016\u0010o\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bo\u0010nR\u0018\u0010q\u001a\u0004\u0018\u00010p8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010r¨\u0006z"}, d2 = {"Lcom/discord/widgets/guilds/list/WidgetGuildsListViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/guilds/list/WidgetGuildsListViewModel$ViewState;", "", "fromPosition", "toPosition", "", "Lcom/discord/primitives/FolderId;", "folderId", "", "move", "(IILjava/lang/Long;)V", "Ljava/util/ArrayList;", "Lcom/discord/widgets/guilds/list/GuildListItem;", "Lkotlin/collections/ArrayList;", "editingList", "", "changedFolderIds", "rebuildFolders", "(Ljava/util/ArrayList;Ljava/util/Set;)V", "untargetCurrentTarget", "(Ljava/util/ArrayList;)V", "performTargetOperation", "(Ljava/util/ArrayList;II)V", "Lcom/discord/widgets/guilds/list/WidgetGuildsListViewModel$StoreState;", "storeState", "handleStoreState", "(Lcom/discord/widgets/guilds/list/WidgetGuildsListViewModel$StoreState;)V", "Lcom/discord/models/guild/Guild;", "guild", "Lcom/discord/primitives/GuildId;", "selectedGuildId", "Lcom/discord/primitives/ChannelId;", "selectedVoiceChannelId", "unreadGuildIds", "", "Lcom/discord/models/domain/ModelNotificationSettings;", "guildSettings", "numMentions", "", "channelIds", "Lcom/discord/api/channel/Channel;", "channels", "lurkingGuildIds", "guildIdsWithActiveStageEvents", "guildIdsWithActiveScheduledEvents", "", "isLastGuildInFolder", "Lcom/discord/primitives/UserId;", "Lcom/discord/utilities/streams/StreamContext;", "allApplicationStreamContexts", "Lcom/discord/api/permission/PermissionBit;", "allChannelPermissions", "Lcom/discord/api/guildjoinrequest/ApplicationStatus;", "applicationStatus", "isPendingGuild", "Lcom/discord/widgets/guilds/list/GuildListItem$GuildItem;", "createGuildItem", "(Lcom/discord/models/guild/Guild;JJLjava/util/Set;Ljava/util/Map;ILjava/util/Map;Ljava/util/Map;Ljava/util/Set;Ljava/util/Set;Ljava/util/Set;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/util/Map;Ljava/util/Map;Lcom/discord/api/guildjoinrequest/ApplicationStatus;Z)Lcom/discord/widgets/guilds/list/GuildListItem$GuildItem;", "privateChannels", "mentionCounts", "dmSettings", "Lkotlin/sequences/Sequence;", "Lcom/discord/widgets/guilds/list/GuildListItem$PrivateChannelItem;", "createDirectMessageItems", "(Ljava/util/Map;Ljava/util/Map;Lcom/discord/models/domain/ModelNotificationSettings;)Lkotlin/sequences/Sequence;", "pendingGuilds", "Lcom/discord/api/guildjoinrequest/GuildJoinRequest;", "guildJoinRequests", "openFolderIds", "createPendingGuildsFolder", "(Ljava/util/List;Ljava/util/Map;Ljava/util/Set;JJLjava/util/Set;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Set;Ljava/util/Set;Ljava/util/Set;Ljava/util/Map;Ljava/util/Map;)Ljava/util/List;", "guildId", "", "guildChannels", "sumMentionCountsForGuild", "(JLjava/util/Map;Ljava/util/Map;)I", "guildNotificationSettings", "streamContexts", ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS, "shouldDisplayVideoIconOnGuild", "(JLcom/discord/models/domain/ModelNotificationSettings;Ljava/util/Map;Ljava/util/Map;)Z", "Lrx/Observable;", "Lcom/discord/widgets/guilds/list/WidgetGuildsListViewModel$Event;", "listenForEvents", "()Lrx/Observable;", "item", "Landroid/content/Context;", "context", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "onItemClicked", "(Lcom/discord/widgets/guilds/list/GuildListItem;Landroid/content/Context;Landroidx/fragment/app/FragmentManager;)V", "onItemLongPressed", "(Lcom/discord/widgets/guilds/list/GuildListItem;)V", "onDrop", "()Z", "target", "(II)V", "targetPosition", "moveAbove", "moveBelow", "Lcom/discord/utilities/time/Clock;", "clock", "Lcom/discord/utilities/time/Clock;", "Lrx/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "eventSubject", "Lrx/subjects/PublishSubject;", "wasOnHomeTab", "Z", "wasLeftPanelOpened", "Lcom/discord/widgets/guilds/list/WidgetGuildListAdapter$Operation$TargetOperation;", "currentTargetOperation", "Lcom/discord/widgets/guilds/list/WidgetGuildListAdapter$Operation$TargetOperation;", "storeObservable", "<init>", "(Lcom/discord/utilities/time/Clock;Lrx/Observable;)V", "Companion", "Event", "StoreState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetGuildsListViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Clock clock;
    private WidgetGuildListAdapter.Operation.TargetOperation currentTargetOperation;
    private final PublishSubject<Event> eventSubject;
    private boolean wasLeftPanelOpened;
    private boolean wasOnHomeTab;

    /* compiled from: WidgetGuildsListViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/widgets/guilds/list/WidgetGuildsListViewModel$StoreState;", "kotlin.jvm.PlatformType", "storeState", "", "invoke", "(Lcom/discord/widgets/guilds/list/WidgetGuildsListViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.list.WidgetGuildsListViewModel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<StoreState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            WidgetGuildsListViewModel widgetGuildsListViewModel = WidgetGuildsListViewModel.this;
            Intrinsics3.checkNotNullExpressionValue(storeState, "storeState");
            WidgetGuildsListViewModel.access$handleStoreState(widgetGuildsListViewModel, storeState);
        }
    }

    /* compiled from: WidgetGuildsListViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0002\n\u000bB\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/discord/widgets/guilds/list/WidgetGuildsListViewModel$Companion;", "", "Lcom/discord/utilities/time/Clock;", "clock", "Lrx/Observable;", "Lcom/discord/widgets/guilds/list/WidgetGuildsListViewModel$StoreState;", "observeStores", "(Lcom/discord/utilities/time/Clock;)Lrx/Observable;", "<init>", "()V", "Chunk", "SecondChunk", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {

        /* compiled from: WidgetGuildsListViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0082\b\u0018\u00002\u00020\u0001B·\u0001\u0012\n\u0010\u0019\u001a\u00060\u0002j\u0002`\u0003\u0012\n\u0010\u001a\u001a\u00060\u0002j\u0002`\u0006\u0012\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\b\u0012\u0010\u0010\u001c\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\f\u0012\u0016\u0010\u001d\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0006\u0012\u0004\u0012\u00020\u000f0\b\u0012 \u0010\u001e\u001a\u001c\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0002j\u0002`\u00060\u00110\b\u0012\u0010\u0010\u001f\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\f\u0012\u0016\u0010 \u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0006\u0012\u0004\u0012\u00020\u00140\b\u0012\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00160\u0011¢\u0006\u0004\b:\u0010;J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0007\u001a\u00060\u0002j\u0002`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0005J\u001c\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\bHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\r\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ \u0010\u0010\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0006\u0012\u0004\u0012\u00020\u000f0\bHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000bJ*\u0010\u0012\u001a\u001c\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0002j\u0002`\u00060\u00110\bHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u000bJ\u001a\u0010\u0013\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\fHÆ\u0003¢\u0006\u0004\b\u0013\u0010\u000eJ \u0010\u0015\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0006\u0012\u0004\u0012\u00020\u00140\bHÆ\u0003¢\u0006\u0004\b\u0015\u0010\u000bJ\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0011HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018JÒ\u0001\u0010\"\u001a\u00020\u00002\f\b\u0002\u0010\u0019\u001a\u00060\u0002j\u0002`\u00032\f\b\u0002\u0010\u001a\u001a\u00060\u0002j\u0002`\u00062\u0014\b\u0002\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\b2\u0012\b\u0002\u0010\u001c\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\f2\u0018\b\u0002\u0010\u001d\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0006\u0012\u0004\u0012\u00020\u000f0\b2\"\b\u0002\u0010\u001e\u001a\u001c\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0002j\u0002`\u00060\u00110\b2\u0012\b\u0002\u0010\u001f\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\f2\u0018\b\u0002\u0010 \u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0006\u0012\u0004\u0012\u00020\u00140\b2\u000e\b\u0002\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00160\u0011HÆ\u0001¢\u0006\u0004\b\"\u0010#J\u0010\u0010%\u001a\u00020$HÖ\u0001¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b'\u0010(J\u001a\u0010+\u001a\u00020*2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b+\u0010,R)\u0010 \u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0006\u0012\u0004\u0012\u00020\u00140\b8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010-\u001a\u0004\b.\u0010\u000bR\u001d\u0010\u001a\u001a\u00060\u0002j\u0002`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010/\u001a\u0004\b0\u0010\u0005R)\u0010\u001d\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0006\u0012\u0004\u0012\u00020\u000f0\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010-\u001a\u0004\b1\u0010\u000bR#\u0010\u001f\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u00102\u001a\u0004\b3\u0010\u000eR\u001f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00160\u00118\u0006@\u0006¢\u0006\f\n\u0004\b!\u00104\u001a\u0004\b5\u0010\u0018R\u001d\u0010\u0019\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010/\u001a\u0004\b6\u0010\u0005R#\u0010\u001c\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u00102\u001a\u0004\b7\u0010\u000eR3\u0010\u001e\u001a\u001c\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0002j\u0002`\u00060\u00110\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010-\u001a\u0004\b8\u0010\u000bR%\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010-\u001a\u0004\b9\u0010\u000b¨\u0006<"}, d2 = {"Lcom/discord/widgets/guilds/list/WidgetGuildsListViewModel$Companion$Chunk;", "", "", "Lcom/discord/primitives/GuildId;", "component1", "()J", "Lcom/discord/primitives/ChannelId;", "component2", "", "Lcom/discord/models/domain/ModelNotificationSettings;", "component3", "()Ljava/util/Map;", "", "component4", "()Ljava/util/Set;", "", "component5", "", "component6", "component7", "Lcom/discord/api/channel/Channel;", "component8", "Lcom/discord/stores/StoreGuildsSorted$Entry;", "component9", "()Ljava/util/List;", "selectedGuildId", "selectedVoiceChannelId", "guildSettings", "unreadGuildIds", "mentionCounts", "channelIds", "unavailableGuilds", "privateChannels", "sortedGuilds", "copy", "(JJLjava/util/Map;Ljava/util/Set;Ljava/util/Map;Ljava/util/Map;Ljava/util/Set;Ljava/util/Map;Ljava/util/List;)Lcom/discord/widgets/guilds/list/WidgetGuildsListViewModel$Companion$Chunk;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Map;", "getPrivateChannels", "J", "getSelectedVoiceChannelId", "getMentionCounts", "Ljava/util/Set;", "getUnavailableGuilds", "Ljava/util/List;", "getSortedGuilds", "getSelectedGuildId", "getUnreadGuildIds", "getChannelIds", "getGuildSettings", "<init>", "(JJLjava/util/Map;Ljava/util/Set;Ljava/util/Map;Ljava/util/Map;Ljava/util/Set;Ljava/util/Map;Ljava/util/List;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Chunk {
            private final Map<Long, List<Long>> channelIds;
            private final Map<Long, ModelNotificationSettings> guildSettings;
            private final Map<Long, Integer> mentionCounts;
            private final Map<Long, Channel> privateChannels;
            private final long selectedGuildId;
            private final long selectedVoiceChannelId;
            private final List<StoreGuildsSorted.Entry> sortedGuilds;
            private final Set<Long> unavailableGuilds;
            private final Set<Long> unreadGuildIds;

            /* JADX WARN: Multi-variable type inference failed */
            public Chunk(long j, long j2, Map<Long, ? extends ModelNotificationSettings> map, Set<Long> set, Map<Long, Integer> map2, Map<Long, ? extends List<Long>> map3, Set<Long> set2, Map<Long, Channel> map4, List<? extends StoreGuildsSorted.Entry> list) {
                Intrinsics3.checkNotNullParameter(map, "guildSettings");
                Intrinsics3.checkNotNullParameter(set, "unreadGuildIds");
                Intrinsics3.checkNotNullParameter(map2, "mentionCounts");
                Intrinsics3.checkNotNullParameter(map3, "channelIds");
                Intrinsics3.checkNotNullParameter(set2, "unavailableGuilds");
                Intrinsics3.checkNotNullParameter(map4, "privateChannels");
                Intrinsics3.checkNotNullParameter(list, "sortedGuilds");
                this.selectedGuildId = j;
                this.selectedVoiceChannelId = j2;
                this.guildSettings = map;
                this.unreadGuildIds = set;
                this.mentionCounts = map2;
                this.channelIds = map3;
                this.unavailableGuilds = set2;
                this.privateChannels = map4;
                this.sortedGuilds = list;
            }

            public static /* synthetic */ Chunk copy$default(Chunk chunk, long j, long j2, Map map, Set set, Map map2, Map map3, Set set2, Map map4, List list, int i, Object obj) {
                return chunk.copy((i & 1) != 0 ? chunk.selectedGuildId : j, (i & 2) != 0 ? chunk.selectedVoiceChannelId : j2, (i & 4) != 0 ? chunk.guildSettings : map, (i & 8) != 0 ? chunk.unreadGuildIds : set, (i & 16) != 0 ? chunk.mentionCounts : map2, (i & 32) != 0 ? chunk.channelIds : map3, (i & 64) != 0 ? chunk.unavailableGuilds : set2, (i & 128) != 0 ? chunk.privateChannels : map4, (i & 256) != 0 ? chunk.sortedGuilds : list);
            }

            /* renamed from: component1, reason: from getter */
            public final long getSelectedGuildId() {
                return this.selectedGuildId;
            }

            /* renamed from: component2, reason: from getter */
            public final long getSelectedVoiceChannelId() {
                return this.selectedVoiceChannelId;
            }

            public final Map<Long, ModelNotificationSettings> component3() {
                return this.guildSettings;
            }

            public final Set<Long> component4() {
                return this.unreadGuildIds;
            }

            public final Map<Long, Integer> component5() {
                return this.mentionCounts;
            }

            public final Map<Long, List<Long>> component6() {
                return this.channelIds;
            }

            public final Set<Long> component7() {
                return this.unavailableGuilds;
            }

            public final Map<Long, Channel> component8() {
                return this.privateChannels;
            }

            public final List<StoreGuildsSorted.Entry> component9() {
                return this.sortedGuilds;
            }

            public final Chunk copy(long selectedGuildId, long selectedVoiceChannelId, Map<Long, ? extends ModelNotificationSettings> guildSettings, Set<Long> unreadGuildIds, Map<Long, Integer> mentionCounts, Map<Long, ? extends List<Long>> channelIds, Set<Long> unavailableGuilds, Map<Long, Channel> privateChannels, List<? extends StoreGuildsSorted.Entry> sortedGuilds) {
                Intrinsics3.checkNotNullParameter(guildSettings, "guildSettings");
                Intrinsics3.checkNotNullParameter(unreadGuildIds, "unreadGuildIds");
                Intrinsics3.checkNotNullParameter(mentionCounts, "mentionCounts");
                Intrinsics3.checkNotNullParameter(channelIds, "channelIds");
                Intrinsics3.checkNotNullParameter(unavailableGuilds, "unavailableGuilds");
                Intrinsics3.checkNotNullParameter(privateChannels, "privateChannels");
                Intrinsics3.checkNotNullParameter(sortedGuilds, "sortedGuilds");
                return new Chunk(selectedGuildId, selectedVoiceChannelId, guildSettings, unreadGuildIds, mentionCounts, channelIds, unavailableGuilds, privateChannels, sortedGuilds);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Chunk)) {
                    return false;
                }
                Chunk chunk = (Chunk) other;
                return this.selectedGuildId == chunk.selectedGuildId && this.selectedVoiceChannelId == chunk.selectedVoiceChannelId && Intrinsics3.areEqual(this.guildSettings, chunk.guildSettings) && Intrinsics3.areEqual(this.unreadGuildIds, chunk.unreadGuildIds) && Intrinsics3.areEqual(this.mentionCounts, chunk.mentionCounts) && Intrinsics3.areEqual(this.channelIds, chunk.channelIds) && Intrinsics3.areEqual(this.unavailableGuilds, chunk.unavailableGuilds) && Intrinsics3.areEqual(this.privateChannels, chunk.privateChannels) && Intrinsics3.areEqual(this.sortedGuilds, chunk.sortedGuilds);
            }

            public final Map<Long, List<Long>> getChannelIds() {
                return this.channelIds;
            }

            public final Map<Long, ModelNotificationSettings> getGuildSettings() {
                return this.guildSettings;
            }

            public final Map<Long, Integer> getMentionCounts() {
                return this.mentionCounts;
            }

            public final Map<Long, Channel> getPrivateChannels() {
                return this.privateChannels;
            }

            public final long getSelectedGuildId() {
                return this.selectedGuildId;
            }

            public final long getSelectedVoiceChannelId() {
                return this.selectedVoiceChannelId;
            }

            public final List<StoreGuildsSorted.Entry> getSortedGuilds() {
                return this.sortedGuilds;
            }

            public final Set<Long> getUnavailableGuilds() {
                return this.unavailableGuilds;
            }

            public final Set<Long> getUnreadGuildIds() {
                return this.unreadGuildIds;
            }

            public int hashCode() {
                int iA = (b.a(this.selectedVoiceChannelId) + (b.a(this.selectedGuildId) * 31)) * 31;
                Map<Long, ModelNotificationSettings> map = this.guildSettings;
                int iHashCode = (iA + (map != null ? map.hashCode() : 0)) * 31;
                Set<Long> set = this.unreadGuildIds;
                int iHashCode2 = (iHashCode + (set != null ? set.hashCode() : 0)) * 31;
                Map<Long, Integer> map2 = this.mentionCounts;
                int iHashCode3 = (iHashCode2 + (map2 != null ? map2.hashCode() : 0)) * 31;
                Map<Long, List<Long>> map3 = this.channelIds;
                int iHashCode4 = (iHashCode3 + (map3 != null ? map3.hashCode() : 0)) * 31;
                Set<Long> set2 = this.unavailableGuilds;
                int iHashCode5 = (iHashCode4 + (set2 != null ? set2.hashCode() : 0)) * 31;
                Map<Long, Channel> map4 = this.privateChannels;
                int iHashCode6 = (iHashCode5 + (map4 != null ? map4.hashCode() : 0)) * 31;
                List<StoreGuildsSorted.Entry> list = this.sortedGuilds;
                return iHashCode6 + (list != null ? list.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Chunk(selectedGuildId=");
                sbU.append(this.selectedGuildId);
                sbU.append(", selectedVoiceChannelId=");
                sbU.append(this.selectedVoiceChannelId);
                sbU.append(", guildSettings=");
                sbU.append(this.guildSettings);
                sbU.append(", unreadGuildIds=");
                sbU.append(this.unreadGuildIds);
                sbU.append(", mentionCounts=");
                sbU.append(this.mentionCounts);
                sbU.append(", channelIds=");
                sbU.append(this.channelIds);
                sbU.append(", unavailableGuilds=");
                sbU.append(this.unavailableGuilds);
                sbU.append(", privateChannels=");
                sbU.append(this.privateChannels);
                sbU.append(", sortedGuilds=");
                return outline.L(sbU, this.sortedGuilds, ")");
            }
        }

        /* compiled from: WidgetGuildsListViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\b\u0082\b\u0018\u00002\u00020\u0001B\u0083\u0001\u0012\u0016\u0010\u0017\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u0002\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0010\u0010\u0019\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\f\u0012\u0010\u0010\u001a\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\f\u0012\u0010\u0010\u001b\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\f\u0012\u0016\u0010\u001c\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0011\u0012\u0004\u0012\u00020\u00120\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u0014¢\u0006\u0004\b4\u00105J \u0010\u0006\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\r\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u000f\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\fHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000eJ\u001a\u0010\u0010\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000eJ \u0010\u0013\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0011\u0012\u0004\u0012\u00020\u00120\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0007J\u0010\u0010\u0015\u001a\u00020\u0014HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u009a\u0001\u0010\u001e\u001a\u00020\u00002\u0018\b\u0002\u0010\u0017\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u00022\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0012\b\u0002\u0010\u0019\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\f2\u0012\b\u0002\u0010\u001a\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\f2\u0012\b\u0002\u0010\u001b\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\f2\u0018\b\u0002\u0010\u001c\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0011\u0012\u0004\u0012\u00020\u00120\u00022\b\b\u0002\u0010\u001d\u001a\u00020\u0014HÆ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010!\u001a\u00020 HÖ\u0001¢\u0006\u0004\b!\u0010\"J\u0010\u0010$\u001a\u00020#HÖ\u0001¢\u0006\u0004\b$\u0010%J\u001a\u0010'\u001a\u00020\u00142\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b'\u0010(R#\u0010\u001b\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010)\u001a\u0004\b*\u0010\u000eR\u001f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010+\u001a\u0004\b,\u0010\u000bR#\u0010\u001a\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010)\u001a\u0004\b-\u0010\u000eR\u0019\u0010\u001d\u001a\u00020\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010.\u001a\u0004\b/\u0010\u0016R)\u0010\u0017\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u00100\u001a\u0004\b1\u0010\u0007R#\u0010\u0019\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010)\u001a\u0004\b2\u0010\u000eR)\u0010\u001c\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0011\u0012\u0004\u0012\u00020\u00120\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u00100\u001a\u0004\b3\u0010\u0007¨\u00066"}, d2 = {"Lcom/discord/widgets/guilds/list/WidgetGuildsListViewModel$Companion$SecondChunk;", "", "", "", "Lcom/discord/primitives/GuildId;", "Lcom/discord/api/guildjoinrequest/GuildJoinRequest;", "component1", "()Ljava/util/Map;", "", "Lcom/discord/models/guild/Guild;", "component2", "()Ljava/util/List;", "", "component3", "()Ljava/util/Set;", "component4", "component5", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/channel/Channel;", "component6", "", "component7", "()Z", "guildJoinRequests", "pendingGuilds", "guildIds", "guildIdsWithActiveStageEvents", "guildIdsWithActiveScheduledEvents", "channels", "showHubSparkle", "copy", "(Ljava/util/Map;Ljava/util/List;Ljava/util/Set;Ljava/util/Set;Ljava/util/Set;Ljava/util/Map;Z)Lcom/discord/widgets/guilds/list/WidgetGuildsListViewModel$Companion$SecondChunk;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Set;", "getGuildIdsWithActiveScheduledEvents", "Ljava/util/List;", "getPendingGuilds", "getGuildIdsWithActiveStageEvents", "Z", "getShowHubSparkle", "Ljava/util/Map;", "getGuildJoinRequests", "getGuildIds", "getChannels", "<init>", "(Ljava/util/Map;Ljava/util/List;Ljava/util/Set;Ljava/util/Set;Ljava/util/Set;Ljava/util/Map;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class SecondChunk {
            private final Map<Long, Channel> channels;
            private final Set<Long> guildIds;
            private final Set<Long> guildIdsWithActiveScheduledEvents;
            private final Set<Long> guildIdsWithActiveStageEvents;
            private final Map<Long, GuildJoinRequest> guildJoinRequests;
            private final List<Guild> pendingGuilds;
            private final boolean showHubSparkle;

            public SecondChunk(Map<Long, GuildJoinRequest> map, List<Guild> list, Set<Long> set, Set<Long> set2, Set<Long> set3, Map<Long, Channel> map2, boolean z2) {
                Intrinsics3.checkNotNullParameter(map, "guildJoinRequests");
                Intrinsics3.checkNotNullParameter(list, "pendingGuilds");
                Intrinsics3.checkNotNullParameter(set, "guildIds");
                Intrinsics3.checkNotNullParameter(set2, "guildIdsWithActiveStageEvents");
                Intrinsics3.checkNotNullParameter(set3, "guildIdsWithActiveScheduledEvents");
                Intrinsics3.checkNotNullParameter(map2, "channels");
                this.guildJoinRequests = map;
                this.pendingGuilds = list;
                this.guildIds = set;
                this.guildIdsWithActiveStageEvents = set2;
                this.guildIdsWithActiveScheduledEvents = set3;
                this.channels = map2;
                this.showHubSparkle = z2;
            }

            public static /* synthetic */ SecondChunk copy$default(SecondChunk secondChunk, Map map, List list, Set set, Set set2, Set set3, Map map2, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    map = secondChunk.guildJoinRequests;
                }
                if ((i & 2) != 0) {
                    list = secondChunk.pendingGuilds;
                }
                List list2 = list;
                if ((i & 4) != 0) {
                    set = secondChunk.guildIds;
                }
                Set set4 = set;
                if ((i & 8) != 0) {
                    set2 = secondChunk.guildIdsWithActiveStageEvents;
                }
                Set set5 = set2;
                if ((i & 16) != 0) {
                    set3 = secondChunk.guildIdsWithActiveScheduledEvents;
                }
                Set set6 = set3;
                if ((i & 32) != 0) {
                    map2 = secondChunk.channels;
                }
                Map map3 = map2;
                if ((i & 64) != 0) {
                    z2 = secondChunk.showHubSparkle;
                }
                return secondChunk.copy(map, list2, set4, set5, set6, map3, z2);
            }

            public final Map<Long, GuildJoinRequest> component1() {
                return this.guildJoinRequests;
            }

            public final List<Guild> component2() {
                return this.pendingGuilds;
            }

            public final Set<Long> component3() {
                return this.guildIds;
            }

            public final Set<Long> component4() {
                return this.guildIdsWithActiveStageEvents;
            }

            public final Set<Long> component5() {
                return this.guildIdsWithActiveScheduledEvents;
            }

            public final Map<Long, Channel> component6() {
                return this.channels;
            }

            /* renamed from: component7, reason: from getter */
            public final boolean getShowHubSparkle() {
                return this.showHubSparkle;
            }

            public final SecondChunk copy(Map<Long, GuildJoinRequest> guildJoinRequests, List<Guild> pendingGuilds, Set<Long> guildIds, Set<Long> guildIdsWithActiveStageEvents, Set<Long> guildIdsWithActiveScheduledEvents, Map<Long, Channel> channels, boolean showHubSparkle) {
                Intrinsics3.checkNotNullParameter(guildJoinRequests, "guildJoinRequests");
                Intrinsics3.checkNotNullParameter(pendingGuilds, "pendingGuilds");
                Intrinsics3.checkNotNullParameter(guildIds, "guildIds");
                Intrinsics3.checkNotNullParameter(guildIdsWithActiveStageEvents, "guildIdsWithActiveStageEvents");
                Intrinsics3.checkNotNullParameter(guildIdsWithActiveScheduledEvents, "guildIdsWithActiveScheduledEvents");
                Intrinsics3.checkNotNullParameter(channels, "channels");
                return new SecondChunk(guildJoinRequests, pendingGuilds, guildIds, guildIdsWithActiveStageEvents, guildIdsWithActiveScheduledEvents, channels, showHubSparkle);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SecondChunk)) {
                    return false;
                }
                SecondChunk secondChunk = (SecondChunk) other;
                return Intrinsics3.areEqual(this.guildJoinRequests, secondChunk.guildJoinRequests) && Intrinsics3.areEqual(this.pendingGuilds, secondChunk.pendingGuilds) && Intrinsics3.areEqual(this.guildIds, secondChunk.guildIds) && Intrinsics3.areEqual(this.guildIdsWithActiveStageEvents, secondChunk.guildIdsWithActiveStageEvents) && Intrinsics3.areEqual(this.guildIdsWithActiveScheduledEvents, secondChunk.guildIdsWithActiveScheduledEvents) && Intrinsics3.areEqual(this.channels, secondChunk.channels) && this.showHubSparkle == secondChunk.showHubSparkle;
            }

            public final Map<Long, Channel> getChannels() {
                return this.channels;
            }

            public final Set<Long> getGuildIds() {
                return this.guildIds;
            }

            public final Set<Long> getGuildIdsWithActiveScheduledEvents() {
                return this.guildIdsWithActiveScheduledEvents;
            }

            public final Set<Long> getGuildIdsWithActiveStageEvents() {
                return this.guildIdsWithActiveStageEvents;
            }

            public final Map<Long, GuildJoinRequest> getGuildJoinRequests() {
                return this.guildJoinRequests;
            }

            public final List<Guild> getPendingGuilds() {
                return this.pendingGuilds;
            }

            public final boolean getShowHubSparkle() {
                return this.showHubSparkle;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                Map<Long, GuildJoinRequest> map = this.guildJoinRequests;
                int iHashCode = (map != null ? map.hashCode() : 0) * 31;
                List<Guild> list = this.pendingGuilds;
                int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
                Set<Long> set = this.guildIds;
                int iHashCode3 = (iHashCode2 + (set != null ? set.hashCode() : 0)) * 31;
                Set<Long> set2 = this.guildIdsWithActiveStageEvents;
                int iHashCode4 = (iHashCode3 + (set2 != null ? set2.hashCode() : 0)) * 31;
                Set<Long> set3 = this.guildIdsWithActiveScheduledEvents;
                int iHashCode5 = (iHashCode4 + (set3 != null ? set3.hashCode() : 0)) * 31;
                Map<Long, Channel> map2 = this.channels;
                int iHashCode6 = (iHashCode5 + (map2 != null ? map2.hashCode() : 0)) * 31;
                boolean z2 = this.showHubSparkle;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                return iHashCode6 + i;
            }

            public String toString() {
                StringBuilder sbU = outline.U("SecondChunk(guildJoinRequests=");
                sbU.append(this.guildJoinRequests);
                sbU.append(", pendingGuilds=");
                sbU.append(this.pendingGuilds);
                sbU.append(", guildIds=");
                sbU.append(this.guildIds);
                sbU.append(", guildIdsWithActiveStageEvents=");
                sbU.append(this.guildIdsWithActiveStageEvents);
                sbU.append(", guildIdsWithActiveScheduledEvents=");
                sbU.append(this.guildIdsWithActiveScheduledEvents);
                sbU.append(", channels=");
                sbU.append(this.channels);
                sbU.append(", showHubSparkle=");
                return outline.O(sbU, this.showHubSparkle, ")");
            }
        }

        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStores(Companion companion, Clock clock) {
            return companion.observeStores(clock);
        }

        private final Observable<StoreState> observeStores(Clock clock) {
            WidgetGuildsListViewModel2 widgetGuildsListViewModel2 = WidgetGuildsListViewModel2.INSTANCE;
            WidgetGuildsListViewModel3 widgetGuildsListViewModel3 = WidgetGuildsListViewModel3.INSTANCE;
            Observable<Chunk> observableInvoke2 = widgetGuildsListViewModel2.invoke2();
            Observable<SecondChunk> observableInvoke22 = widgetGuildsListViewModel3.invoke2();
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable observableC = Observable.c(observableInvoke2, observableInvoke22, companion.getLurking().getLurkingGuildIds(), companion.getExpandedGuildFolders().observeOpenFolderIds(), StoreUser.observeMe$default(companion.getUsers(), false, 1, null).r().G(new WidgetGuildsListViewModel4(clock)), new StreamContextService(null, null, null, null, null, null, null, null, 255, null).getForAllStreamingUsers(), companion.getPermissions().observePermissionsForAllChannels(), companion.getNavigation().observeLeftPanelState().G(WidgetGuildsListViewModel5.INSTANCE), companion.getTabsNavigation().observeSelectedTab().G(WidgetGuildsListViewModel6.INSTANCE), WidgetGuildsListViewModel7.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableC, "Observable.combineLatest…Sparkle\n        )\n      }");
            return ObservableExtensionsKt.leadingEdgeThrottle(observableC, 100L, TimeUnit.MILLISECONDS);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetGuildsListViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0007\u0004\u0005\u0006\u0007\b\t\nB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0007\u000b\f\r\u000e\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/discord/widgets/guilds/list/WidgetGuildsListViewModel$Event;", "", "<init>", "()V", "AnnounceFolderToggleForAccessibility", "FocusFirstElement", "ShowChannelActions", "ShowCreateGuild", "ShowHelp", "ShowHubVerification", "ShowUnavailableGuilds", "Lcom/discord/widgets/guilds/list/WidgetGuildsListViewModel$Event$ShowChannelActions;", "Lcom/discord/widgets/guilds/list/WidgetGuildsListViewModel$Event$ShowUnavailableGuilds;", "Lcom/discord/widgets/guilds/list/WidgetGuildsListViewModel$Event$AnnounceFolderToggleForAccessibility;", "Lcom/discord/widgets/guilds/list/WidgetGuildsListViewModel$Event$ShowCreateGuild;", "Lcom/discord/widgets/guilds/list/WidgetGuildsListViewModel$Event$ShowHubVerification;", "Lcom/discord/widgets/guilds/list/WidgetGuildsListViewModel$Event$ShowHelp;", "Lcom/discord/widgets/guilds/list/WidgetGuildsListViewModel$Event$FocusFirstElement;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class Event {

        /* compiled from: WidgetGuildsListViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/guilds/list/WidgetGuildsListViewModel$Event$AnnounceFolderToggleForAccessibility;", "Lcom/discord/widgets/guilds/list/WidgetGuildsListViewModel$Event;", "Lcom/discord/widgets/guilds/list/GuildListItem$FolderItem;", "component1", "()Lcom/discord/widgets/guilds/list/GuildListItem$FolderItem;", "item", "copy", "(Lcom/discord/widgets/guilds/list/GuildListItem$FolderItem;)Lcom/discord/widgets/guilds/list/WidgetGuildsListViewModel$Event$AnnounceFolderToggleForAccessibility;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/widgets/guilds/list/GuildListItem$FolderItem;", "getItem", "<init>", "(Lcom/discord/widgets/guilds/list/GuildListItem$FolderItem;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class AnnounceFolderToggleForAccessibility extends Event {
            private final GuildListItem.FolderItem item;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnnounceFolderToggleForAccessibility(GuildListItem.FolderItem folderItem) {
                super(null);
                Intrinsics3.checkNotNullParameter(folderItem, "item");
                this.item = folderItem;
            }

            public static /* synthetic */ AnnounceFolderToggleForAccessibility copy$default(AnnounceFolderToggleForAccessibility announceFolderToggleForAccessibility, GuildListItem.FolderItem folderItem, int i, Object obj) {
                if ((i & 1) != 0) {
                    folderItem = announceFolderToggleForAccessibility.item;
                }
                return announceFolderToggleForAccessibility.copy(folderItem);
            }

            /* renamed from: component1, reason: from getter */
            public final GuildListItem.FolderItem getItem() {
                return this.item;
            }

            public final AnnounceFolderToggleForAccessibility copy(GuildListItem.FolderItem item) {
                Intrinsics3.checkNotNullParameter(item, "item");
                return new AnnounceFolderToggleForAccessibility(item);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof AnnounceFolderToggleForAccessibility) && Intrinsics3.areEqual(this.item, ((AnnounceFolderToggleForAccessibility) other).item);
                }
                return true;
            }

            public final GuildListItem.FolderItem getItem() {
                return this.item;
            }

            public int hashCode() {
                GuildListItem.FolderItem folderItem = this.item;
                if (folderItem != null) {
                    return folderItem.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("AnnounceFolderToggleForAccessibility(item=");
                sbU.append(this.item);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: WidgetGuildsListViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/guilds/list/WidgetGuildsListViewModel$Event$FocusFirstElement;", "Lcom/discord/widgets/guilds/list/WidgetGuildsListViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class FocusFirstElement extends Event {
            public static final FocusFirstElement INSTANCE = new FocusFirstElement();

            private FocusFirstElement() {
                super(null);
            }
        }

        /* compiled from: WidgetGuildsListViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0007\u001a\u00020\u00002\f\b\u0002\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0006\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0005¨\u0006\u0018"}, d2 = {"Lcom/discord/widgets/guilds/list/WidgetGuildsListViewModel$Event$ShowChannelActions;", "Lcom/discord/widgets/guilds/list/WidgetGuildsListViewModel$Event;", "", "Lcom/discord/primitives/ChannelId;", "component1", "()J", "channelId", "copy", "(J)Lcom/discord/widgets/guilds/list/WidgetGuildsListViewModel$Event$ShowChannelActions;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getChannelId", "<init>", "(J)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class ShowChannelActions extends Event {
            private final long channelId;

            public ShowChannelActions(long j) {
                super(null);
                this.channelId = j;
            }

            public static /* synthetic */ ShowChannelActions copy$default(ShowChannelActions showChannelActions, long j, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = showChannelActions.channelId;
                }
                return showChannelActions.copy(j);
            }

            /* renamed from: component1, reason: from getter */
            public final long getChannelId() {
                return this.channelId;
            }

            public final ShowChannelActions copy(long channelId) {
                return new ShowChannelActions(channelId);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof ShowChannelActions) && this.channelId == ((ShowChannelActions) other).channelId;
                }
                return true;
            }

            public final long getChannelId() {
                return this.channelId;
            }

            public int hashCode() {
                return b.a(this.channelId);
            }

            public String toString() {
                return outline.C(outline.U("ShowChannelActions(channelId="), this.channelId, ")");
            }
        }

        /* compiled from: WidgetGuildsListViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/guilds/list/WidgetGuildsListViewModel$Event$ShowCreateGuild;", "Lcom/discord/widgets/guilds/list/WidgetGuildsListViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class ShowCreateGuild extends Event {
            public static final ShowCreateGuild INSTANCE = new ShowCreateGuild();

            private ShowCreateGuild() {
                super(null);
            }
        }

        /* compiled from: WidgetGuildsListViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/guilds/list/WidgetGuildsListViewModel$Event$ShowHelp;", "Lcom/discord/widgets/guilds/list/WidgetGuildsListViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class ShowHelp extends Event {
            public static final ShowHelp INSTANCE = new ShowHelp();

            private ShowHelp() {
                super(null);
            }
        }

        /* compiled from: WidgetGuildsListViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/guilds/list/WidgetGuildsListViewModel$Event$ShowHubVerification;", "Lcom/discord/widgets/guilds/list/WidgetGuildsListViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class ShowHubVerification extends Event {
            public static final ShowHubVerification INSTANCE = new ShowHubVerification();

            private ShowHubVerification() {
                super(null);
            }
        }

        /* compiled from: WidgetGuildsListViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\u0004J\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/guilds/list/WidgetGuildsListViewModel$Event$ShowUnavailableGuilds;", "Lcom/discord/widgets/guilds/list/WidgetGuildsListViewModel$Event;", "", "component1", "()I", "unavailableGuildCount", "copy", "(I)Lcom/discord/widgets/guilds/list/WidgetGuildsListViewModel$Event$ShowUnavailableGuilds;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getUnavailableGuildCount", "<init>", "(I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class ShowUnavailableGuilds extends Event {
            private final int unavailableGuildCount;

            public ShowUnavailableGuilds(int i) {
                super(null);
                this.unavailableGuildCount = i;
            }

            public static /* synthetic */ ShowUnavailableGuilds copy$default(ShowUnavailableGuilds showUnavailableGuilds, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = showUnavailableGuilds.unavailableGuildCount;
                }
                return showUnavailableGuilds.copy(i);
            }

            /* renamed from: component1, reason: from getter */
            public final int getUnavailableGuildCount() {
                return this.unavailableGuildCount;
            }

            public final ShowUnavailableGuilds copy(int unavailableGuildCount) {
                return new ShowUnavailableGuilds(unavailableGuildCount);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof ShowUnavailableGuilds) && this.unavailableGuildCount == ((ShowUnavailableGuilds) other).unavailableGuildCount;
                }
                return true;
            }

            public final int getUnavailableGuildCount() {
                return this.unavailableGuildCount;
            }

            public int hashCode() {
                return this.unavailableGuildCount;
            }

            public String toString() {
                return outline.B(outline.U("ShowUnavailableGuilds(unavailableGuildCount="), this.unavailableGuildCount, ")");
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetGuildsListViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000e\n\u0002\b#\b\u0086\b\u0018\u00002\u00020\u0001B£\u0003\u0012\n\u0010/\u001a\u00060\u0002j\u0002`\u0003\u0012\n\u00100\u001a\u00060\u0002j\u0002`\u0006\u0012\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\b\u0012\u0010\u00102\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\f\u0012\u0016\u00103\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0006\u0012\u0004\u0012\u00020\u000f0\b\u0012 \u00104\u001a\u001c\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0002j\u0002`\u00060\u00110\b\u0012\u0010\u00105\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\f\u0012\u0016\u00106\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0006\u0012\u0004\u0012\u00020\u00140\b\u0012\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u00160\u0011\u0012\u0016\u00108\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u00190\b\u0012\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0011\u0012\u0010\u0010:\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\f\u0012\u0010\u0010;\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\f\u0012\u0010\u0010<\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\f\u0012\u0010\u0010=\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\f\u0012\u0016\u0010>\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0006\u0012\u0004\u0012\u00020\u00140\b\u0012\u0010\u0010?\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\"0\f\u0012\u0006\u0010@\u001a\u00020$\u0012\u0016\u0010A\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`'\u0012\u0004\u0012\u00020(0\b\u0012\u001a\u0010B\u001a\u0016\u0012\b\u0012\u00060\u0002j\u0002`\u0006\u0012\b\u0012\u00060\u0002j\u0002`*0\b\u0012\u0006\u0010C\u001a\u00020$\u0012\u0006\u0010D\u001a\u00020$\u0012\u0006\u0010E\u001a\u00020$¢\u0006\u0004\bi\u0010jJ\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0007\u001a\u00060\u0002j\u0002`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0005J\u001c\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\bHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\r\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ \u0010\u0010\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0006\u0012\u0004\u0012\u00020\u000f0\bHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000bJ*\u0010\u0012\u001a\u001c\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0002j\u0002`\u00060\u00110\bHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u000bJ\u001a\u0010\u0013\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\fHÆ\u0003¢\u0006\u0004\b\u0013\u0010\u000eJ \u0010\u0015\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0006\u0012\u0004\u0012\u00020\u00140\bHÆ\u0003¢\u0006\u0004\b\u0015\u0010\u000bJ\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0011HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J \u0010\u001a\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u00190\bHÆ\u0003¢\u0006\u0004\b\u001a\u0010\u000bJ\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0011HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0018J\u001a\u0010\u001d\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\fHÆ\u0003¢\u0006\u0004\b\u001d\u0010\u000eJ\u001a\u0010\u001e\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\fHÆ\u0003¢\u0006\u0004\b\u001e\u0010\u000eJ\u001a\u0010\u001f\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\fHÆ\u0003¢\u0006\u0004\b\u001f\u0010\u000eJ\u001a\u0010 \u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\fHÆ\u0003¢\u0006\u0004\b \u0010\u000eJ \u0010!\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0006\u0012\u0004\u0012\u00020\u00140\bHÆ\u0003¢\u0006\u0004\b!\u0010\u000bJ\u001a\u0010#\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\"0\fHÆ\u0003¢\u0006\u0004\b#\u0010\u000eJ\u0010\u0010%\u001a\u00020$HÆ\u0003¢\u0006\u0004\b%\u0010&J \u0010)\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`'\u0012\u0004\u0012\u00020(0\bHÆ\u0003¢\u0006\u0004\b)\u0010\u000bJ$\u0010+\u001a\u0016\u0012\b\u0012\u00060\u0002j\u0002`\u0006\u0012\b\u0012\u00060\u0002j\u0002`*0\bHÆ\u0003¢\u0006\u0004\b+\u0010\u000bJ\u0010\u0010,\u001a\u00020$HÆ\u0003¢\u0006\u0004\b,\u0010&J\u0010\u0010-\u001a\u00020$HÆ\u0003¢\u0006\u0004\b-\u0010&J\u0010\u0010.\u001a\u00020$HÆ\u0003¢\u0006\u0004\b.\u0010&JÚ\u0003\u0010F\u001a\u00020\u00002\f\b\u0002\u0010/\u001a\u00060\u0002j\u0002`\u00032\f\b\u0002\u00100\u001a\u00060\u0002j\u0002`\u00062\u0014\b\u0002\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\b2\u0012\b\u0002\u00102\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\f2\u0018\b\u0002\u00103\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0006\u0012\u0004\u0012\u00020\u000f0\b2\"\b\u0002\u00104\u001a\u001c\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0002j\u0002`\u00060\u00110\b2\u0012\b\u0002\u00105\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\f2\u0018\b\u0002\u00106\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0006\u0012\u0004\u0012\u00020\u00140\b2\u000e\b\u0002\u00107\u001a\b\u0012\u0004\u0012\u00020\u00160\u00112\u0018\b\u0002\u00108\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u00190\b2\u000e\b\u0002\u00109\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00112\u0012\b\u0002\u0010:\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\f2\u0012\b\u0002\u0010;\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\f2\u0012\b\u0002\u0010<\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\f2\u0012\b\u0002\u0010=\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\f2\u0018\b\u0002\u0010>\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0006\u0012\u0004\u0012\u00020\u00140\b2\u0012\b\u0002\u0010?\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\"0\f2\b\b\u0002\u0010@\u001a\u00020$2\u0018\b\u0002\u0010A\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`'\u0012\u0004\u0012\u00020(0\b2\u001c\b\u0002\u0010B\u001a\u0016\u0012\b\u0012\u00060\u0002j\u0002`\u0006\u0012\b\u0012\u00060\u0002j\u0002`*0\b2\b\b\u0002\u0010C\u001a\u00020$2\b\b\u0002\u0010D\u001a\u00020$2\b\b\u0002\u0010E\u001a\u00020$HÆ\u0001¢\u0006\u0004\bF\u0010GJ\u0010\u0010I\u001a\u00020HHÖ\u0001¢\u0006\u0004\bI\u0010JJ\u0010\u0010K\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\bK\u0010LJ\u001a\u0010N\u001a\u00020$2\b\u0010M\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\bN\u0010OR)\u0010A\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`'\u0012\u0004\u0012\u00020(0\b8\u0006@\u0006¢\u0006\f\n\u0004\bA\u0010P\u001a\u0004\bQ\u0010\u000bR\u0019\u0010C\u001a\u00020$8\u0006@\u0006¢\u0006\f\n\u0004\bC\u0010R\u001a\u0004\bC\u0010&R\u0019\u0010D\u001a\u00020$8\u0006@\u0006¢\u0006\f\n\u0004\bD\u0010R\u001a\u0004\bD\u0010&R\u001f\u00107\u001a\b\u0012\u0004\u0012\u00020\u00160\u00118\u0006@\u0006¢\u0006\f\n\u0004\b7\u0010S\u001a\u0004\bT\u0010\u0018R#\u0010?\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\"0\f8\u0006@\u0006¢\u0006\f\n\u0004\b?\u0010U\u001a\u0004\bV\u0010\u000eR\u0019\u0010E\u001a\u00020$8\u0006@\u0006¢\u0006\f\n\u0004\bE\u0010R\u001a\u0004\bW\u0010&R\u0019\u0010@\u001a\u00020$8\u0006@\u0006¢\u0006\f\n\u0004\b@\u0010R\u001a\u0004\b@\u0010&R)\u00106\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0006\u0012\u0004\u0012\u00020\u00140\b8\u0006@\u0006¢\u0006\f\n\u0004\b6\u0010P\u001a\u0004\bX\u0010\u000bR)\u00108\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u00190\b8\u0006@\u0006¢\u0006\f\n\u0004\b8\u0010P\u001a\u0004\bY\u0010\u000bR)\u0010>\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0006\u0012\u0004\u0012\u00020\u00140\b8\u0006@\u0006¢\u0006\f\n\u0004\b>\u0010P\u001a\u0004\bZ\u0010\u000bR#\u00105\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\f8\u0006@\u0006¢\u0006\f\n\u0004\b5\u0010U\u001a\u0004\b[\u0010\u000eR\u001f\u00109\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00118\u0006@\u0006¢\u0006\f\n\u0004\b9\u0010S\u001a\u0004\b\\\u0010\u0018R\u001d\u00100\u001a\u00060\u0002j\u0002`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b0\u0010]\u001a\u0004\b^\u0010\u0005R#\u0010=\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\f8\u0006@\u0006¢\u0006\f\n\u0004\b=\u0010U\u001a\u0004\b_\u0010\u000eR3\u00104\u001a\u001c\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0002j\u0002`\u00060\u00110\b8\u0006@\u0006¢\u0006\f\n\u0004\b4\u0010P\u001a\u0004\b`\u0010\u000bR)\u00103\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0006\u0012\u0004\u0012\u00020\u000f0\b8\u0006@\u0006¢\u0006\f\n\u0004\b3\u0010P\u001a\u0004\ba\u0010\u000bR\u001d\u0010/\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010]\u001a\u0004\bb\u0010\u0005R#\u00102\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\f8\u0006@\u0006¢\u0006\f\n\u0004\b2\u0010U\u001a\u0004\bc\u0010\u000eR%\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010P\u001a\u0004\bd\u0010\u000bR#\u0010:\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\f8\u0006@\u0006¢\u0006\f\n\u0004\b:\u0010U\u001a\u0004\be\u0010\u000eR#\u0010<\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\f8\u0006@\u0006¢\u0006\f\n\u0004\b<\u0010U\u001a\u0004\bf\u0010\u000eR-\u0010B\u001a\u0016\u0012\b\u0012\u00060\u0002j\u0002`\u0006\u0012\b\u0012\u00060\u0002j\u0002`*0\b8\u0006@\u0006¢\u0006\f\n\u0004\bB\u0010P\u001a\u0004\bg\u0010\u000bR#\u0010;\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\f8\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010U\u001a\u0004\bh\u0010\u000e¨\u0006k"}, d2 = {"Lcom/discord/widgets/guilds/list/WidgetGuildsListViewModel$StoreState;", "", "", "Lcom/discord/primitives/GuildId;", "component1", "()J", "Lcom/discord/primitives/ChannelId;", "component2", "", "Lcom/discord/models/domain/ModelNotificationSettings;", "component3", "()Ljava/util/Map;", "", "component4", "()Ljava/util/Set;", "", "component5", "", "component6", "component7", "Lcom/discord/api/channel/Channel;", "component8", "Lcom/discord/stores/StoreGuildsSorted$Entry;", "component9", "()Ljava/util/List;", "Lcom/discord/api/guildjoinrequest/GuildJoinRequest;", "component10", "Lcom/discord/models/guild/Guild;", "component11", "component12", "component13", "component14", "component15", "component16", "Lcom/discord/primitives/FolderId;", "component17", "", "component18", "()Z", "Lcom/discord/primitives/UserId;", "Lcom/discord/utilities/streams/StreamContext;", "component19", "Lcom/discord/api/permission/PermissionBit;", "component20", "component21", "component22", "component23", "selectedGuildId", "selectedVoiceChannelId", "guildSettings", "unreadGuildIds", "mentionCounts", "channelIds", "unavailableGuilds", "privateChannels", "sortedGuilds", "guildJoinRequests", "pendingGuilds", "guildIds", "lurkingGuildIds", "guildIdsWithActiveStageEvents", "guildIdsWithActiveScheduledEvents", "channels", "openFolderIds", "isNewUser", "allApplicationStreamContexts", "allChannelPermissions", "isLeftPanelOpened", "isOnHomeTab", "showHubSparkle", "copy", "(JJLjava/util/Map;Ljava/util/Set;Ljava/util/Map;Ljava/util/Map;Ljava/util/Set;Ljava/util/Map;Ljava/util/List;Ljava/util/Map;Ljava/util/List;Ljava/util/Set;Ljava/util/Set;Ljava/util/Set;Ljava/util/Set;Ljava/util/Map;Ljava/util/Set;ZLjava/util/Map;Ljava/util/Map;ZZZ)Lcom/discord/widgets/guilds/list/WidgetGuildsListViewModel$StoreState;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Map;", "getAllApplicationStreamContexts", "Z", "Ljava/util/List;", "getSortedGuilds", "Ljava/util/Set;", "getOpenFolderIds", "getShowHubSparkle", "getPrivateChannels", "getGuildJoinRequests", "getChannels", "getUnavailableGuilds", "getPendingGuilds", "J", "getSelectedVoiceChannelId", "getGuildIdsWithActiveScheduledEvents", "getChannelIds", "getMentionCounts", "getSelectedGuildId", "getUnreadGuildIds", "getGuildSettings", "getGuildIds", "getGuildIdsWithActiveStageEvents", "getAllChannelPermissions", "getLurkingGuildIds", "<init>", "(JJLjava/util/Map;Ljava/util/Set;Ljava/util/Map;Ljava/util/Map;Ljava/util/Set;Ljava/util/Map;Ljava/util/List;Ljava/util/Map;Ljava/util/List;Ljava/util/Set;Ljava/util/Set;Ljava/util/Set;Ljava/util/Set;Ljava/util/Map;Ljava/util/Set;ZLjava/util/Map;Ljava/util/Map;ZZZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class StoreState {
        private final Map<Long, StreamContext> allApplicationStreamContexts;
        private final Map<Long, Long> allChannelPermissions;
        private final Map<Long, List<Long>> channelIds;
        private final Map<Long, Channel> channels;
        private final Set<Long> guildIds;
        private final Set<Long> guildIdsWithActiveScheduledEvents;
        private final Set<Long> guildIdsWithActiveStageEvents;
        private final Map<Long, GuildJoinRequest> guildJoinRequests;
        private final Map<Long, ModelNotificationSettings> guildSettings;
        private final boolean isLeftPanelOpened;
        private final boolean isNewUser;
        private final boolean isOnHomeTab;
        private final Set<Long> lurkingGuildIds;
        private final Map<Long, Integer> mentionCounts;
        private final Set<Long> openFolderIds;
        private final List<Guild> pendingGuilds;
        private final Map<Long, Channel> privateChannels;
        private final long selectedGuildId;
        private final long selectedVoiceChannelId;
        private final boolean showHubSparkle;
        private final List<StoreGuildsSorted.Entry> sortedGuilds;
        private final Set<Long> unavailableGuilds;
        private final Set<Long> unreadGuildIds;

        /* JADX WARN: Multi-variable type inference failed */
        public StoreState(long j, long j2, Map<Long, ? extends ModelNotificationSettings> map, Set<Long> set, Map<Long, Integer> map2, Map<Long, ? extends List<Long>> map3, Set<Long> set2, Map<Long, Channel> map4, List<? extends StoreGuildsSorted.Entry> list, Map<Long, GuildJoinRequest> map5, List<Guild> list2, Set<Long> set3, Set<Long> set4, Set<Long> set5, Set<Long> set6, Map<Long, Channel> map6, Set<Long> set7, boolean z2, Map<Long, StreamContext> map7, Map<Long, Long> map8, boolean z3, boolean z4, boolean z5) {
            Intrinsics3.checkNotNullParameter(map, "guildSettings");
            Intrinsics3.checkNotNullParameter(set, "unreadGuildIds");
            Intrinsics3.checkNotNullParameter(map2, "mentionCounts");
            Intrinsics3.checkNotNullParameter(map3, "channelIds");
            Intrinsics3.checkNotNullParameter(set2, "unavailableGuilds");
            Intrinsics3.checkNotNullParameter(map4, "privateChannels");
            Intrinsics3.checkNotNullParameter(list, "sortedGuilds");
            Intrinsics3.checkNotNullParameter(map5, "guildJoinRequests");
            Intrinsics3.checkNotNullParameter(list2, "pendingGuilds");
            Intrinsics3.checkNotNullParameter(set3, "guildIds");
            Intrinsics3.checkNotNullParameter(set4, "lurkingGuildIds");
            Intrinsics3.checkNotNullParameter(set5, "guildIdsWithActiveStageEvents");
            Intrinsics3.checkNotNullParameter(set6, "guildIdsWithActiveScheduledEvents");
            Intrinsics3.checkNotNullParameter(map6, "channels");
            Intrinsics3.checkNotNullParameter(set7, "openFolderIds");
            Intrinsics3.checkNotNullParameter(map7, "allApplicationStreamContexts");
            Intrinsics3.checkNotNullParameter(map8, "allChannelPermissions");
            this.selectedGuildId = j;
            this.selectedVoiceChannelId = j2;
            this.guildSettings = map;
            this.unreadGuildIds = set;
            this.mentionCounts = map2;
            this.channelIds = map3;
            this.unavailableGuilds = set2;
            this.privateChannels = map4;
            this.sortedGuilds = list;
            this.guildJoinRequests = map5;
            this.pendingGuilds = list2;
            this.guildIds = set3;
            this.lurkingGuildIds = set4;
            this.guildIdsWithActiveStageEvents = set5;
            this.guildIdsWithActiveScheduledEvents = set6;
            this.channels = map6;
            this.openFolderIds = set7;
            this.isNewUser = z2;
            this.allApplicationStreamContexts = map7;
            this.allChannelPermissions = map8;
            this.isLeftPanelOpened = z3;
            this.isOnHomeTab = z4;
            this.showHubSparkle = z5;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, long j, long j2, Map map, Set set, Map map2, Map map3, Set set2, Map map4, List list, Map map5, List list2, Set set3, Set set4, Set set5, Set set6, Map map6, Set set7, boolean z2, Map map7, Map map8, boolean z3, boolean z4, boolean z5, int i, Object obj) {
            return storeState.copy((i & 1) != 0 ? storeState.selectedGuildId : j, (i & 2) != 0 ? storeState.selectedVoiceChannelId : j2, (i & 4) != 0 ? storeState.guildSettings : map, (i & 8) != 0 ? storeState.unreadGuildIds : set, (i & 16) != 0 ? storeState.mentionCounts : map2, (i & 32) != 0 ? storeState.channelIds : map3, (i & 64) != 0 ? storeState.unavailableGuilds : set2, (i & 128) != 0 ? storeState.privateChannels : map4, (i & 256) != 0 ? storeState.sortedGuilds : list, (i & 512) != 0 ? storeState.guildJoinRequests : map5, (i & 1024) != 0 ? storeState.pendingGuilds : list2, (i & 2048) != 0 ? storeState.guildIds : set3, (i & 4096) != 0 ? storeState.lurkingGuildIds : set4, (i & 8192) != 0 ? storeState.guildIdsWithActiveStageEvents : set5, (i & 16384) != 0 ? storeState.guildIdsWithActiveScheduledEvents : set6, (i & 32768) != 0 ? storeState.channels : map6, (i & 65536) != 0 ? storeState.openFolderIds : set7, (i & 131072) != 0 ? storeState.isNewUser : z2, (i & 262144) != 0 ? storeState.allApplicationStreamContexts : map7, (i & 524288) != 0 ? storeState.allChannelPermissions : map8, (i & 1048576) != 0 ? storeState.isLeftPanelOpened : z3, (i & 2097152) != 0 ? storeState.isOnHomeTab : z4, (i & 4194304) != 0 ? storeState.showHubSparkle : z5);
        }

        /* renamed from: component1, reason: from getter */
        public final long getSelectedGuildId() {
            return this.selectedGuildId;
        }

        public final Map<Long, GuildJoinRequest> component10() {
            return this.guildJoinRequests;
        }

        public final List<Guild> component11() {
            return this.pendingGuilds;
        }

        public final Set<Long> component12() {
            return this.guildIds;
        }

        public final Set<Long> component13() {
            return this.lurkingGuildIds;
        }

        public final Set<Long> component14() {
            return this.guildIdsWithActiveStageEvents;
        }

        public final Set<Long> component15() {
            return this.guildIdsWithActiveScheduledEvents;
        }

        public final Map<Long, Channel> component16() {
            return this.channels;
        }

        public final Set<Long> component17() {
            return this.openFolderIds;
        }

        /* renamed from: component18, reason: from getter */
        public final boolean getIsNewUser() {
            return this.isNewUser;
        }

        public final Map<Long, StreamContext> component19() {
            return this.allApplicationStreamContexts;
        }

        /* renamed from: component2, reason: from getter */
        public final long getSelectedVoiceChannelId() {
            return this.selectedVoiceChannelId;
        }

        public final Map<Long, Long> component20() {
            return this.allChannelPermissions;
        }

        /* renamed from: component21, reason: from getter */
        public final boolean getIsLeftPanelOpened() {
            return this.isLeftPanelOpened;
        }

        /* renamed from: component22, reason: from getter */
        public final boolean getIsOnHomeTab() {
            return this.isOnHomeTab;
        }

        /* renamed from: component23, reason: from getter */
        public final boolean getShowHubSparkle() {
            return this.showHubSparkle;
        }

        public final Map<Long, ModelNotificationSettings> component3() {
            return this.guildSettings;
        }

        public final Set<Long> component4() {
            return this.unreadGuildIds;
        }

        public final Map<Long, Integer> component5() {
            return this.mentionCounts;
        }

        public final Map<Long, List<Long>> component6() {
            return this.channelIds;
        }

        public final Set<Long> component7() {
            return this.unavailableGuilds;
        }

        public final Map<Long, Channel> component8() {
            return this.privateChannels;
        }

        public final List<StoreGuildsSorted.Entry> component9() {
            return this.sortedGuilds;
        }

        public final StoreState copy(long selectedGuildId, long selectedVoiceChannelId, Map<Long, ? extends ModelNotificationSettings> guildSettings, Set<Long> unreadGuildIds, Map<Long, Integer> mentionCounts, Map<Long, ? extends List<Long>> channelIds, Set<Long> unavailableGuilds, Map<Long, Channel> privateChannels, List<? extends StoreGuildsSorted.Entry> sortedGuilds, Map<Long, GuildJoinRequest> guildJoinRequests, List<Guild> pendingGuilds, Set<Long> guildIds, Set<Long> lurkingGuildIds, Set<Long> guildIdsWithActiveStageEvents, Set<Long> guildIdsWithActiveScheduledEvents, Map<Long, Channel> channels, Set<Long> openFolderIds, boolean isNewUser, Map<Long, StreamContext> allApplicationStreamContexts, Map<Long, Long> allChannelPermissions, boolean isLeftPanelOpened, boolean isOnHomeTab, boolean showHubSparkle) {
            Intrinsics3.checkNotNullParameter(guildSettings, "guildSettings");
            Intrinsics3.checkNotNullParameter(unreadGuildIds, "unreadGuildIds");
            Intrinsics3.checkNotNullParameter(mentionCounts, "mentionCounts");
            Intrinsics3.checkNotNullParameter(channelIds, "channelIds");
            Intrinsics3.checkNotNullParameter(unavailableGuilds, "unavailableGuilds");
            Intrinsics3.checkNotNullParameter(privateChannels, "privateChannels");
            Intrinsics3.checkNotNullParameter(sortedGuilds, "sortedGuilds");
            Intrinsics3.checkNotNullParameter(guildJoinRequests, "guildJoinRequests");
            Intrinsics3.checkNotNullParameter(pendingGuilds, "pendingGuilds");
            Intrinsics3.checkNotNullParameter(guildIds, "guildIds");
            Intrinsics3.checkNotNullParameter(lurkingGuildIds, "lurkingGuildIds");
            Intrinsics3.checkNotNullParameter(guildIdsWithActiveStageEvents, "guildIdsWithActiveStageEvents");
            Intrinsics3.checkNotNullParameter(guildIdsWithActiveScheduledEvents, "guildIdsWithActiveScheduledEvents");
            Intrinsics3.checkNotNullParameter(channels, "channels");
            Intrinsics3.checkNotNullParameter(openFolderIds, "openFolderIds");
            Intrinsics3.checkNotNullParameter(allApplicationStreamContexts, "allApplicationStreamContexts");
            Intrinsics3.checkNotNullParameter(allChannelPermissions, "allChannelPermissions");
            return new StoreState(selectedGuildId, selectedVoiceChannelId, guildSettings, unreadGuildIds, mentionCounts, channelIds, unavailableGuilds, privateChannels, sortedGuilds, guildJoinRequests, pendingGuilds, guildIds, lurkingGuildIds, guildIdsWithActiveStageEvents, guildIdsWithActiveScheduledEvents, channels, openFolderIds, isNewUser, allApplicationStreamContexts, allChannelPermissions, isLeftPanelOpened, isOnHomeTab, showHubSparkle);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return this.selectedGuildId == storeState.selectedGuildId && this.selectedVoiceChannelId == storeState.selectedVoiceChannelId && Intrinsics3.areEqual(this.guildSettings, storeState.guildSettings) && Intrinsics3.areEqual(this.unreadGuildIds, storeState.unreadGuildIds) && Intrinsics3.areEqual(this.mentionCounts, storeState.mentionCounts) && Intrinsics3.areEqual(this.channelIds, storeState.channelIds) && Intrinsics3.areEqual(this.unavailableGuilds, storeState.unavailableGuilds) && Intrinsics3.areEqual(this.privateChannels, storeState.privateChannels) && Intrinsics3.areEqual(this.sortedGuilds, storeState.sortedGuilds) && Intrinsics3.areEqual(this.guildJoinRequests, storeState.guildJoinRequests) && Intrinsics3.areEqual(this.pendingGuilds, storeState.pendingGuilds) && Intrinsics3.areEqual(this.guildIds, storeState.guildIds) && Intrinsics3.areEqual(this.lurkingGuildIds, storeState.lurkingGuildIds) && Intrinsics3.areEqual(this.guildIdsWithActiveStageEvents, storeState.guildIdsWithActiveStageEvents) && Intrinsics3.areEqual(this.guildIdsWithActiveScheduledEvents, storeState.guildIdsWithActiveScheduledEvents) && Intrinsics3.areEqual(this.channels, storeState.channels) && Intrinsics3.areEqual(this.openFolderIds, storeState.openFolderIds) && this.isNewUser == storeState.isNewUser && Intrinsics3.areEqual(this.allApplicationStreamContexts, storeState.allApplicationStreamContexts) && Intrinsics3.areEqual(this.allChannelPermissions, storeState.allChannelPermissions) && this.isLeftPanelOpened == storeState.isLeftPanelOpened && this.isOnHomeTab == storeState.isOnHomeTab && this.showHubSparkle == storeState.showHubSparkle;
        }

        public final Map<Long, StreamContext> getAllApplicationStreamContexts() {
            return this.allApplicationStreamContexts;
        }

        public final Map<Long, Long> getAllChannelPermissions() {
            return this.allChannelPermissions;
        }

        public final Map<Long, List<Long>> getChannelIds() {
            return this.channelIds;
        }

        public final Map<Long, Channel> getChannels() {
            return this.channels;
        }

        public final Set<Long> getGuildIds() {
            return this.guildIds;
        }

        public final Set<Long> getGuildIdsWithActiveScheduledEvents() {
            return this.guildIdsWithActiveScheduledEvents;
        }

        public final Set<Long> getGuildIdsWithActiveStageEvents() {
            return this.guildIdsWithActiveStageEvents;
        }

        public final Map<Long, GuildJoinRequest> getGuildJoinRequests() {
            return this.guildJoinRequests;
        }

        public final Map<Long, ModelNotificationSettings> getGuildSettings() {
            return this.guildSettings;
        }

        public final Set<Long> getLurkingGuildIds() {
            return this.lurkingGuildIds;
        }

        public final Map<Long, Integer> getMentionCounts() {
            return this.mentionCounts;
        }

        public final Set<Long> getOpenFolderIds() {
            return this.openFolderIds;
        }

        public final List<Guild> getPendingGuilds() {
            return this.pendingGuilds;
        }

        public final Map<Long, Channel> getPrivateChannels() {
            return this.privateChannels;
        }

        public final long getSelectedGuildId() {
            return this.selectedGuildId;
        }

        public final long getSelectedVoiceChannelId() {
            return this.selectedVoiceChannelId;
        }

        public final boolean getShowHubSparkle() {
            return this.showHubSparkle;
        }

        public final List<StoreGuildsSorted.Entry> getSortedGuilds() {
            return this.sortedGuilds;
        }

        public final Set<Long> getUnavailableGuilds() {
            return this.unavailableGuilds;
        }

        public final Set<Long> getUnreadGuildIds() {
            return this.unreadGuildIds;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int iA = (b.a(this.selectedVoiceChannelId) + (b.a(this.selectedGuildId) * 31)) * 31;
            Map<Long, ModelNotificationSettings> map = this.guildSettings;
            int iHashCode = (iA + (map != null ? map.hashCode() : 0)) * 31;
            Set<Long> set = this.unreadGuildIds;
            int iHashCode2 = (iHashCode + (set != null ? set.hashCode() : 0)) * 31;
            Map<Long, Integer> map2 = this.mentionCounts;
            int iHashCode3 = (iHashCode2 + (map2 != null ? map2.hashCode() : 0)) * 31;
            Map<Long, List<Long>> map3 = this.channelIds;
            int iHashCode4 = (iHashCode3 + (map3 != null ? map3.hashCode() : 0)) * 31;
            Set<Long> set2 = this.unavailableGuilds;
            int iHashCode5 = (iHashCode4 + (set2 != null ? set2.hashCode() : 0)) * 31;
            Map<Long, Channel> map4 = this.privateChannels;
            int iHashCode6 = (iHashCode5 + (map4 != null ? map4.hashCode() : 0)) * 31;
            List<StoreGuildsSorted.Entry> list = this.sortedGuilds;
            int iHashCode7 = (iHashCode6 + (list != null ? list.hashCode() : 0)) * 31;
            Map<Long, GuildJoinRequest> map5 = this.guildJoinRequests;
            int iHashCode8 = (iHashCode7 + (map5 != null ? map5.hashCode() : 0)) * 31;
            List<Guild> list2 = this.pendingGuilds;
            int iHashCode9 = (iHashCode8 + (list2 != null ? list2.hashCode() : 0)) * 31;
            Set<Long> set3 = this.guildIds;
            int iHashCode10 = (iHashCode9 + (set3 != null ? set3.hashCode() : 0)) * 31;
            Set<Long> set4 = this.lurkingGuildIds;
            int iHashCode11 = (iHashCode10 + (set4 != null ? set4.hashCode() : 0)) * 31;
            Set<Long> set5 = this.guildIdsWithActiveStageEvents;
            int iHashCode12 = (iHashCode11 + (set5 != null ? set5.hashCode() : 0)) * 31;
            Set<Long> set6 = this.guildIdsWithActiveScheduledEvents;
            int iHashCode13 = (iHashCode12 + (set6 != null ? set6.hashCode() : 0)) * 31;
            Map<Long, Channel> map6 = this.channels;
            int iHashCode14 = (iHashCode13 + (map6 != null ? map6.hashCode() : 0)) * 31;
            Set<Long> set7 = this.openFolderIds;
            int iHashCode15 = (iHashCode14 + (set7 != null ? set7.hashCode() : 0)) * 31;
            boolean z2 = this.isNewUser;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode15 + i) * 31;
            Map<Long, StreamContext> map7 = this.allApplicationStreamContexts;
            int iHashCode16 = (i2 + (map7 != null ? map7.hashCode() : 0)) * 31;
            Map<Long, Long> map8 = this.allChannelPermissions;
            int iHashCode17 = (iHashCode16 + (map8 != null ? map8.hashCode() : 0)) * 31;
            boolean z3 = this.isLeftPanelOpened;
            int i3 = z3;
            if (z3 != 0) {
                i3 = 1;
            }
            int i4 = (iHashCode17 + i3) * 31;
            boolean z4 = this.isOnHomeTab;
            int i5 = z4;
            if (z4 != 0) {
                i5 = 1;
            }
            int i6 = (i4 + i5) * 31;
            boolean z5 = this.showHubSparkle;
            return i6 + (z5 ? 1 : z5 ? 1 : 0);
        }

        public final boolean isLeftPanelOpened() {
            return this.isLeftPanelOpened;
        }

        public final boolean isNewUser() {
            return this.isNewUser;
        }

        public final boolean isOnHomeTab() {
            return this.isOnHomeTab;
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(selectedGuildId=");
            sbU.append(this.selectedGuildId);
            sbU.append(", selectedVoiceChannelId=");
            sbU.append(this.selectedVoiceChannelId);
            sbU.append(", guildSettings=");
            sbU.append(this.guildSettings);
            sbU.append(", unreadGuildIds=");
            sbU.append(this.unreadGuildIds);
            sbU.append(", mentionCounts=");
            sbU.append(this.mentionCounts);
            sbU.append(", channelIds=");
            sbU.append(this.channelIds);
            sbU.append(", unavailableGuilds=");
            sbU.append(this.unavailableGuilds);
            sbU.append(", privateChannels=");
            sbU.append(this.privateChannels);
            sbU.append(", sortedGuilds=");
            sbU.append(this.sortedGuilds);
            sbU.append(", guildJoinRequests=");
            sbU.append(this.guildJoinRequests);
            sbU.append(", pendingGuilds=");
            sbU.append(this.pendingGuilds);
            sbU.append(", guildIds=");
            sbU.append(this.guildIds);
            sbU.append(", lurkingGuildIds=");
            sbU.append(this.lurkingGuildIds);
            sbU.append(", guildIdsWithActiveStageEvents=");
            sbU.append(this.guildIdsWithActiveStageEvents);
            sbU.append(", guildIdsWithActiveScheduledEvents=");
            sbU.append(this.guildIdsWithActiveScheduledEvents);
            sbU.append(", channels=");
            sbU.append(this.channels);
            sbU.append(", openFolderIds=");
            sbU.append(this.openFolderIds);
            sbU.append(", isNewUser=");
            sbU.append(this.isNewUser);
            sbU.append(", allApplicationStreamContexts=");
            sbU.append(this.allApplicationStreamContexts);
            sbU.append(", allChannelPermissions=");
            sbU.append(this.allChannelPermissions);
            sbU.append(", isLeftPanelOpened=");
            sbU.append(this.isLeftPanelOpened);
            sbU.append(", isOnHomeTab=");
            sbU.append(this.isOnHomeTab);
            sbU.append(", showHubSparkle=");
            return outline.O(sbU, this.showHubSparkle, ")");
        }
    }

    /* compiled from: WidgetGuildsListViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/guilds/list/WidgetGuildsListViewModel$ViewState;", "", "<init>", "()V", "Loaded", "Uninitialized", "Lcom/discord/widgets/guilds/list/WidgetGuildsListViewModel$ViewState$Uninitialized;", "Lcom/discord/widgets/guilds/list/WidgetGuildsListViewModel$ViewState$Loaded;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        /* compiled from: WidgetGuildsListViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\u001e\u0010\u001fJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ4\u0010\r\u001a\u00020\u00002\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001a\u0010\u0005R\u0019\u0010\u000b\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001b\u001a\u0004\b\u001c\u0010\bR\u0019\u0010\f\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\u001d\u0010\b¨\u0006 "}, d2 = {"Lcom/discord/widgets/guilds/list/WidgetGuildsListViewModel$ViewState$Loaded;", "Lcom/discord/widgets/guilds/list/WidgetGuildsListViewModel$ViewState;", "", "Lcom/discord/widgets/guilds/list/GuildListItem;", "component1", "()Ljava/util/List;", "", "component2", "()Z", "component3", "items", "hasChannels", "wasDragResult", "copy", "(Ljava/util/List;ZZ)Lcom/discord/widgets/guilds/list/WidgetGuildsListViewModel$ViewState$Loaded;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getItems", "Z", "getHasChannels", "getWasDragResult", "<init>", "(Ljava/util/List;ZZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Loaded extends ViewState {
            private final boolean hasChannels;
            private final List<GuildListItem> items;
            private final boolean wasDragResult;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Loaded(List<? extends GuildListItem> list, boolean z2, boolean z3) {
                super(null);
                Intrinsics3.checkNotNullParameter(list, "items");
                this.items = list;
                this.hasChannels = z2;
                this.wasDragResult = z3;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, List list, boolean z2, boolean z3, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = loaded.items;
                }
                if ((i & 2) != 0) {
                    z2 = loaded.hasChannels;
                }
                if ((i & 4) != 0) {
                    z3 = loaded.wasDragResult;
                }
                return loaded.copy(list, z2, z3);
            }

            public final List<GuildListItem> component1() {
                return this.items;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getHasChannels() {
                return this.hasChannels;
            }

            /* renamed from: component3, reason: from getter */
            public final boolean getWasDragResult() {
                return this.wasDragResult;
            }

            public final Loaded copy(List<? extends GuildListItem> items, boolean hasChannels, boolean wasDragResult) {
                Intrinsics3.checkNotNullParameter(items, "items");
                return new Loaded(items, hasChannels, wasDragResult);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return Intrinsics3.areEqual(this.items, loaded.items) && this.hasChannels == loaded.hasChannels && this.wasDragResult == loaded.wasDragResult;
            }

            public final boolean getHasChannels() {
                return this.hasChannels;
            }

            public final List<GuildListItem> getItems() {
                return this.items;
            }

            public final boolean getWasDragResult() {
                return this.wasDragResult;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                List<GuildListItem> list = this.items;
                int iHashCode = (list != null ? list.hashCode() : 0) * 31;
                boolean z2 = this.hasChannels;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iHashCode + i) * 31;
                boolean z3 = this.wasDragResult;
                return i2 + (z3 ? 1 : z3 ? 1 : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(items=");
                sbU.append(this.items);
                sbU.append(", hasChannels=");
                sbU.append(this.hasChannels);
                sbU.append(", wasDragResult=");
                return outline.O(sbU, this.wasDragResult, ")");
            }
        }

        /* compiled from: WidgetGuildsListViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/guilds/list/WidgetGuildsListViewModel$ViewState$Uninitialized;", "Lcom/discord/widgets/guilds/list/WidgetGuildsListViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Uninitialized extends ViewState {
            public static final Uninitialized INSTANCE = new Uninitialized();

            private Uninitialized() {
                super(null);
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetGuildsListViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/channel/Channel;", "channel", "", "invoke", "(Lcom/discord/api/channel/Channel;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.list.WidgetGuildsListViewModel$createDirectMessageItems$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Channel, Boolean> {
        public final /* synthetic */ ModelNotificationSettings $dmSettings;
        public final /* synthetic */ Map $mentionCounts;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ModelNotificationSettings modelNotificationSettings, Map map) {
            super(1);
            this.$dmSettings = modelNotificationSettings;
            this.$mentionCounts = map;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Channel channel) {
            return Boolean.valueOf(invoke2(channel));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(Channel channel) {
            ModelNotificationSettings modelNotificationSettings;
            ModelNotificationSettings.ChannelOverride channelOverride;
            Intrinsics3.checkNotNullParameter(channel, "channel");
            return this.$mentionCounts.containsKey(Long.valueOf(channel.getId())) && ((modelNotificationSettings = this.$dmSettings) == null || (channelOverride = modelNotificationSettings.getChannelOverride(channel.getId())) == null || !channelOverride.isMuted());
        }
    }

    /* compiled from: WidgetGuildsListViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/channel/Channel;", "it", "Lcom/discord/widgets/guilds/list/GuildListItem$PrivateChannelItem;", "invoke", "(Lcom/discord/api/channel/Channel;)Lcom/discord/widgets/guilds/list/GuildListItem$PrivateChannelItem;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.list.WidgetGuildsListViewModel$createDirectMessageItems$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Channel, GuildListItem.PrivateChannelItem> {
        public final /* synthetic */ Map $mentionCounts;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Map map) {
            super(1);
            this.$mentionCounts = map;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ GuildListItem.PrivateChannelItem invoke(Channel channel) {
            return invoke2(channel);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final GuildListItem.PrivateChannelItem invoke2(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "it");
            Integer num = (Integer) outline.d(channel, this.$mentionCounts);
            return new GuildListItem.PrivateChannelItem(channel, num != null ? num.intValue() : 0);
        }
    }

    /* compiled from: WidgetGuildsListViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/stores/StoreGuildsSorted$Entry;", "it", "", "invoke", "(Lcom/discord/stores/StoreGuildsSorted$Entry;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.list.WidgetGuildsListViewModel$handleStoreState$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<StoreGuildsSorted.Entry, Boolean> {
        public final /* synthetic */ StoreState $storeState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(StoreState storeState) {
            super(1);
            this.$storeState = storeState;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(StoreGuildsSorted.Entry entry) {
            return Boolean.valueOf(invoke2(entry));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(StoreGuildsSorted.Entry entry) {
            Intrinsics3.checkNotNullParameter(entry, "it");
            return ((entry instanceof StoreGuildsSorted.Entry.SingletonGuild) && this.$storeState.getLurkingGuildIds().contains(Long.valueOf(((StoreGuildsSorted.Entry.SingletonGuild) entry).getGuild().getId()))) ? false : true;
        }
    }

    /* compiled from: WidgetGuildsListViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/domain/ModelUserSettings;", "it", "", "invoke", "(Lcom/discord/models/domain/ModelUserSettings;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.list.WidgetGuildsListViewModel$onDrop$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<ModelUserSettings, Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelUserSettings modelUserSettings) {
            invoke2(modelUserSettings);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelUserSettings modelUserSettings) {
            Intrinsics3.checkNotNullParameter(modelUserSettings, "it");
        }
    }

    /* compiled from: WidgetGuildsListViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.list.WidgetGuildsListViewModel$onItemClicked$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

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
        }
    }

    public WidgetGuildsListViewModel() {
        this(null, null, 3, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetGuildsListViewModel(Clock clock, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        clock = (i & 1) != 0 ? ClockFactory.get() : clock;
        this(clock, (i & 2) != 0 ? Companion.access$observeStores(INSTANCE, clock) : observable);
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetGuildsListViewModel widgetGuildsListViewModel, StoreState storeState) {
        widgetGuildsListViewModel.handleStoreState(storeState);
    }

    private final Sequence<GuildListItem.PrivateChannelItem> createDirectMessageItems(Map<Long, Channel> privateChannels, Map<Long, Integer> mentionCounts, ModelNotificationSettings dmSettings) {
        return _Sequences2.map(_Sequences2.sortedWith(_Sequences2.filter(_Sequences2.filterNotNull(_Collections.asSequence(privateChannels.values())), new AnonymousClass1(dmSettings, mentionCounts)), ChannelUtils.h(Channel.INSTANCE)), new AnonymousClass2(mentionCounts));
    }

    private final GuildListItem.GuildItem createGuildItem(Guild guild, long selectedGuildId, long selectedVoiceChannelId, Set<Long> unreadGuildIds, Map<Long, ? extends ModelNotificationSettings> guildSettings, int numMentions, Map<Long, ? extends List<Long>> channelIds, Map<Long, Channel> channels, Set<Long> lurkingGuildIds, Set<Long> guildIdsWithActiveStageEvents, Set<Long> guildIdsWithActiveScheduledEvents, Long folderId, Boolean isLastGuildInFolder, Map<Long, StreamContext> allApplicationStreamContexts, Map<Long, Long> allChannelPermissions, ApplicationStatus applicationStatus, boolean isPendingGuild) {
        boolean z2;
        long id2 = guild.getId();
        List<Long> list = channelIds.get(Long.valueOf(id2));
        ModelNotificationSettings modelNotificationSettings = guildSettings.get(Long.valueOf(id2));
        boolean zContains = (modelNotificationSettings == null || !modelNotificationSettings.isMuted()) ? unreadGuildIds.contains(Long.valueOf(id2)) : false;
        boolean z3 = id2 == selectedGuildId;
        if (selectedVoiceChannelId <= 0 || list == null || list.isEmpty()) {
            z2 = false;
        } else {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (selectedVoiceChannelId == ((Number) it.next()).longValue()) {
                    z2 = true;
                    break;
                }
            }
            z2 = false;
        }
        boolean zShouldDisplayVideoIconOnGuild = shouldDisplayVideoIconOnGuild(id2, modelNotificationSettings, allApplicationStreamContexts, allChannelPermissions);
        boolean zContains2 = lurkingGuildIds.contains(Long.valueOf(guild.getId()));
        boolean zContains3 = guildIdsWithActiveStageEvents.contains(Long.valueOf(guild.getId()));
        Channel channel = channels.get(Long.valueOf(selectedVoiceChannelId));
        return new GuildListItem.GuildItem(guild, numMentions, zContains2, zContains, z3, folderId, z2, zShouldDisplayVideoIconOnGuild, false, isLastGuildInFolder, applicationStatus, isPendingGuild, zContains3, channel != null && ChannelUtils.D(channel), guildIdsWithActiveScheduledEvents.contains(Long.valueOf(guild.getId())), 256, null);
    }

    public static /* synthetic */ GuildListItem.GuildItem createGuildItem$default(WidgetGuildsListViewModel widgetGuildsListViewModel, Guild guild, long j, long j2, Set set, Map map, int i, Map map2, Map map3, Set set2, Set set3, Set set4, Long l, Boolean bool, Map map4, Map map5, ApplicationStatus applicationStatus, boolean z2, int i2, Object obj) {
        return widgetGuildsListViewModel.createGuildItem(guild, j, j2, set, map, i, map2, map3, set2, set3, set4, l, bool, map4, map5, applicationStatus, (i2 & 65536) != 0 ? false : z2);
    }

    private final List<GuildListItem> createPendingGuildsFolder(List<Guild> pendingGuilds, Map<Long, GuildJoinRequest> guildJoinRequests, Set<Long> openFolderIds, long selectedGuildId, long selectedVoiceChannelId, Set<Long> unreadGuildIds, Map<Long, ? extends ModelNotificationSettings> guildSettings, Map<Long, ? extends List<Long>> channelIds, Map<Long, Channel> channels, Set<Long> lurkingGuildIds, Set<Long> guildIdsWithActiveStageEvents, Set<Long> guildIdsWithActiveScheduledEvents, Map<Long, StreamContext> allApplicationStreamContexts, Map<Long, Long> allChannelPermissions) {
        ArrayList arrayList = new ArrayList();
        GuildListItem.FolderItem folderItem = new GuildListItem.FolderItem(-7L, null, null, openFolderIds.contains(-7L), pendingGuilds, false, false, false, 0, false, false);
        arrayList.add(folderItem);
        if (folderItem.isOpen()) {
            ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(pendingGuilds, 10));
            int i = 0;
            for (Object obj : pendingGuilds) {
                int i2 = i + 1;
                if (i < 0) {
                    Collections2.throwIndexOverflow();
                }
                Guild guild = (Guild) obj;
                Long lValueOf = Long.valueOf(folderItem.getFolderId());
                Boolean boolValueOf = Boolean.valueOf(Collections2.getLastIndex(pendingGuilds) == i);
                GuildJoinRequest guildJoinRequest = (GuildJoinRequest) outline.e(guild, guildJoinRequests);
                arrayList2.add(createGuildItem(guild, selectedGuildId, selectedVoiceChannelId, unreadGuildIds, guildSettings, 0, channelIds, channels, lurkingGuildIds, guildIdsWithActiveStageEvents, guildIdsWithActiveScheduledEvents, lValueOf, boolValueOf, allApplicationStreamContexts, allChannelPermissions, guildJoinRequest != null ? guildJoinRequest.getApplicationStatus() : null, true));
                i = i2;
            }
            arrayList.addAll(arrayList2);
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:162:0x028d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x028b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void handleStoreState(StoreState storeState) {
        boolean z2;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        Sequence sequence;
        HashMap map;
        ArrayList arrayList4;
        HashMap map2;
        boolean z3;
        boolean z4;
        boolean z5;
        int i;
        boolean z6;
        HashMap map3;
        ArrayList arrayList5;
        boolean z7;
        Integer num;
        ModelNotificationSettings modelNotificationSettings;
        ArrayList arrayList6 = new ArrayList(storeState.getPendingGuilds().size() + storeState.getSortedGuilds().size() + 3);
        arrayList6.add(new GuildListItem.FriendsItem(storeState.getSelectedGuildId() <= 0));
        MutableCollections.addAll(arrayList6, createDirectMessageItems(storeState.getPrivateChannels(), storeState.getMentionCounts(), storeState.getGuildSettings().get(0L)));
        HashMap map4 = new HashMap();
        for (StoreGuildsSorted.Entry entry : storeState.getSortedGuilds()) {
            if (entry instanceof StoreGuildsSorted.Entry.SingletonGuild) {
                long id2 = ((StoreGuildsSorted.Entry.SingletonGuild) entry).getGuild().getId();
                map4.put(Long.valueOf(id2), Integer.valueOf(sumMentionCountsForGuild(id2, storeState.getChannelIds(), storeState.getMentionCounts())));
            } else if (entry instanceof StoreGuildsSorted.Entry.Folder) {
                Iterator<Guild> it = ((StoreGuildsSorted.Entry.Folder) entry).getGuilds().iterator();
                while (it.hasNext()) {
                    long id3 = it.next().getId();
                    map4.put(Long.valueOf(id3), Integer.valueOf(sumMentionCountsForGuild(id3, storeState.getChannelIds(), storeState.getMentionCounts())));
                }
            }
        }
        Sequence sequenceFilter = _Sequences2.filter(_Collections.asSequence(storeState.getSortedGuilds()), _Sequences.INSTANCE);
        Objects.requireNonNull(sequenceFilter, "null cannot be cast to non-null type kotlin.sequences.Sequence<R>");
        Sequence map5 = _Sequences2.map(_Sequences2.filter(sequenceFilter, new WidgetGuildsListViewModel8(storeState)), new WidgetGuildsListViewModel9(this, storeState, map4));
        ArrayList arrayList7 = new ArrayList();
        for (StoreGuildsSorted.Entry entry2 : _Sequences2.filter(_Collections.asSequence(storeState.getSortedGuilds()), new AnonymousClass2(storeState))) {
            if (entry2 instanceof StoreGuildsSorted.Entry.SingletonGuild) {
                StoreGuildsSorted.Entry.SingletonGuild singletonGuild = (StoreGuildsSorted.Entry.SingletonGuild) entry2;
                Guild guild = singletonGuild.getGuild();
                long selectedGuildId = storeState.getSelectedGuildId();
                long selectedVoiceChannelId = storeState.getSelectedVoiceChannelId();
                Set<Long> unreadGuildIds = storeState.getUnreadGuildIds();
                Map<Long, ModelNotificationSettings> guildSettings = storeState.getGuildSettings();
                Integer num2 = (Integer) map4.get(Long.valueOf(singletonGuild.getGuild().getId()));
                if (num2 == null) {
                    num2 = 0;
                }
                Intrinsics3.checkNotNullExpressionValue(num2, "mentionCountsByGuild[folder.guild.id] ?: 0");
                int iIntValue = num2.intValue();
                Map<Long, List<Long>> channelIds = storeState.getChannelIds();
                Map<Long, Channel> channels = storeState.getChannels();
                Set<Long> lurkingGuildIds = storeState.getLurkingGuildIds();
                Set<Long> guildIdsWithActiveStageEvents = storeState.getGuildIdsWithActiveStageEvents();
                Set<Long> guildIdsWithActiveScheduledEvents = storeState.getGuildIdsWithActiveScheduledEvents();
                Map<Long, StreamContext> allApplicationStreamContexts = storeState.getAllApplicationStreamContexts();
                Map<Long, Long> allChannelPermissions = storeState.getAllChannelPermissions();
                ArrayList arrayList8 = arrayList7;
                GuildJoinRequest guildJoinRequest = storeState.getGuildJoinRequests().get(Long.valueOf(singletonGuild.getGuild().getId()));
                sequence = map5;
                map = map4;
                arrayList4 = arrayList6;
                arrayList3 = arrayList8;
                arrayList3.add(createGuildItem$default(this, guild, selectedGuildId, selectedVoiceChannelId, unreadGuildIds, guildSettings, iIntValue, channelIds, channels, lurkingGuildIds, guildIdsWithActiveStageEvents, guildIdsWithActiveScheduledEvents, null, null, allApplicationStreamContexts, allChannelPermissions, guildJoinRequest != null ? guildJoinRequest.getApplicationStatus() : null, false, 65536, null));
            } else {
                arrayList3 = arrayList7;
                sequence = map5;
                map = map4;
                arrayList4 = arrayList6;
                if (entry2 instanceof StoreGuildsSorted.Entry.Folder) {
                    StoreGuildsSorted.Entry.Folder folder = (StoreGuildsSorted.Entry.Folder) entry2;
                    boolean zContains = storeState.getOpenFolderIds().contains(Long.valueOf(folder.getId()));
                    String str = "mentionCountsByGuild[guild.id] ?: 0";
                    if (zContains) {
                        map2 = map;
                        z3 = false;
                        z4 = false;
                        z5 = false;
                        i = 0;
                        z6 = false;
                    } else {
                        boolean z8 = false;
                        int iIntValue2 = 0;
                        boolean z9 = false;
                        boolean z10 = false;
                        boolean z11 = false;
                        for (Guild guild2 : folder.getGuilds()) {
                            z9 = z9 || guild2.getId() == storeState.getSelectedGuildId();
                            if (z10) {
                                z10 = true;
                            } else {
                                List list = (List) outline.e(guild2, storeState.getChannelIds());
                                if (!(list != null ? list.contains(Long.valueOf(storeState.getSelectedVoiceChannelId())) : false)) {
                                    z10 = false;
                                }
                            }
                            if (z11) {
                                z7 = true;
                            } else {
                                Channel channel = storeState.getChannels().get(Long.valueOf(storeState.getSelectedVoiceChannelId()));
                                if (channel != null) {
                                    z7 = true;
                                    if (ChannelUtils.D(channel)) {
                                    }
                                    if (!z8) {
                                        z8 = storeState.getUnreadGuildIds().contains(Long.valueOf(guild2.getId())) && ((modelNotificationSettings = (ModelNotificationSettings) outline.e(guild2, storeState.getGuildSettings())) == null || modelNotificationSettings.isMuted() != z7);
                                    }
                                    HashMap map6 = map;
                                    num = (Integer) map6.get(Long.valueOf(guild2.getId()));
                                    if (num == null) {
                                        num = 0;
                                    }
                                    Intrinsics3.checkNotNullExpressionValue(num, "mentionCountsByGuild[guild.id] ?: 0");
                                    iIntValue2 += num.intValue();
                                    map = map6;
                                } else {
                                    z7 = true;
                                }
                                z11 = false;
                                if (!z8) {
                                }
                                HashMap map62 = map;
                                num = (Integer) map62.get(Long.valueOf(guild2.getId()));
                                if (num == null) {
                                }
                                Intrinsics3.checkNotNullExpressionValue(num, "mentionCountsByGuild[guild.id] ?: 0");
                                iIntValue2 += num.intValue();
                                map = map62;
                            }
                            z11 = true;
                            if (!z8) {
                            }
                            HashMap map622 = map;
                            num = (Integer) map622.get(Long.valueOf(guild2.getId()));
                            if (num == null) {
                            }
                            Intrinsics3.checkNotNullExpressionValue(num, "mentionCountsByGuild[guild.id] ?: 0");
                            iIntValue2 += num.intValue();
                            map = map622;
                        }
                        map2 = map;
                        z6 = z8;
                        i = iIntValue2;
                        z3 = z9;
                        z4 = z10;
                        z5 = z11;
                    }
                    arrayList3.add(new GuildListItem.FolderItem(folder.getId(), folder.getColor(), folder.getName(), zContains, folder.getGuilds(), z3, z4, z5, i, z6, false, 1024, null));
                    if (zContains) {
                        List<Guild> guilds = folder.getGuilds();
                        ArrayList arrayList9 = new ArrayList(Iterables2.collectionSizeOrDefault(guilds, 10));
                        int i2 = 0;
                        for (Object obj : guilds) {
                            int i3 = i2 + 1;
                            if (i2 < 0) {
                                Collections2.throwIndexOverflow();
                            }
                            Guild guild3 = (Guild) obj;
                            long selectedGuildId2 = storeState.getSelectedGuildId();
                            long selectedVoiceChannelId2 = storeState.getSelectedVoiceChannelId();
                            Set<Long> unreadGuildIds2 = storeState.getUnreadGuildIds();
                            Map<Long, ModelNotificationSettings> guildSettings2 = storeState.getGuildSettings();
                            Integer num3 = (Integer) map2.get(Long.valueOf(guild3.getId()));
                            if (num3 == null) {
                                num3 = 0;
                            }
                            Intrinsics3.checkNotNullExpressionValue(num3, str);
                            int iIntValue3 = num3.intValue();
                            Map<Long, List<Long>> channelIds2 = storeState.getChannelIds();
                            Map<Long, Channel> channels2 = storeState.getChannels();
                            Set<Long> lurkingGuildIds2 = storeState.getLurkingGuildIds();
                            Set<Long> guildIdsWithActiveStageEvents2 = storeState.getGuildIdsWithActiveStageEvents();
                            Set<Long> guildIdsWithActiveScheduledEvents2 = storeState.getGuildIdsWithActiveScheduledEvents();
                            Long lValueOf = Long.valueOf(folder.getId());
                            ArrayList arrayList10 = arrayList9;
                            Boolean boolValueOf = Boolean.valueOf(Collections2.getLastIndex(folder.getGuilds()) == i2);
                            Map<Long, StreamContext> allApplicationStreamContexts2 = storeState.getAllApplicationStreamContexts();
                            Map<Long, Long> allChannelPermissions2 = storeState.getAllChannelPermissions();
                            GuildJoinRequest guildJoinRequest2 = (GuildJoinRequest) outline.e(guild3, storeState.getGuildJoinRequests());
                            arrayList10.add(createGuildItem$default(this, guild3, selectedGuildId2, selectedVoiceChannelId2, unreadGuildIds2, guildSettings2, iIntValue3, channelIds2, channels2, lurkingGuildIds2, guildIdsWithActiveStageEvents2, guildIdsWithActiveScheduledEvents2, lValueOf, boolValueOf, allApplicationStreamContexts2, allChannelPermissions2, guildJoinRequest2 != null ? guildJoinRequest2.getApplicationStatus() : null, false, 65536, null));
                            arrayList9 = arrayList10;
                            i2 = i3;
                            map2 = map2;
                            str = str;
                            arrayList3 = arrayList3;
                        }
                        map3 = map2;
                        arrayList5 = arrayList3;
                        arrayList5.addAll(arrayList9);
                    } else {
                        map3 = map2;
                        arrayList5 = arrayList3;
                    }
                }
                arrayList7 = arrayList5;
                map4 = map3;
                map5 = sequence;
                arrayList6 = arrayList4;
            }
            arrayList5 = arrayList3;
            map3 = map;
            arrayList7 = arrayList5;
            map4 = map3;
            map5 = sequence;
            arrayList6 = arrayList4;
        }
        ArrayList arrayList11 = arrayList7;
        Sequence sequence2 = map5;
        ArrayList arrayList12 = arrayList6;
        if (storeState.getOpenFolderIds().contains(-7L)) {
            StoreStream.INSTANCE.getGuildJoinRequests().fetchPendingGuilds();
        }
        Map<Long, GuildJoinRequest> guildJoinRequests = storeState.getGuildJoinRequests();
        if (guildJoinRequests.isEmpty()) {
            z2 = false;
        } else {
            Iterator<Map.Entry<Long, GuildJoinRequest>> it2 = guildJoinRequests.entrySet().iterator();
            while (it2.hasNext()) {
                if (Collections2.emptyList().contains(it2.next().getKey())) {
                    z2 = true;
                    break;
                }
            }
            z2 = false;
        }
        if (z2) {
            arrayList = arrayList11;
            arrayList2 = arrayList12;
            arrayList2.addAll(createPendingGuildsFolder(storeState.getPendingGuilds(), storeState.getGuildJoinRequests(), storeState.getOpenFolderIds(), storeState.getSelectedGuildId(), storeState.getSelectedVoiceChannelId(), storeState.getUnreadGuildIds(), storeState.getGuildSettings(), storeState.getChannelIds(), storeState.getChannels(), storeState.getLurkingGuildIds(), storeState.getGuildIdsWithActiveStageEvents(), storeState.getGuildIdsWithActiveScheduledEvents(), storeState.getAllApplicationStreamContexts(), storeState.getAllChannelPermissions()));
        } else {
            arrayList = arrayList11;
            arrayList2 = arrayList12;
        }
        MutableCollections.addAll(arrayList2, sequence2);
        GuildListItem.DividerItem dividerItem = GuildListItem.DividerItem.INSTANCE;
        arrayList2.add(dividerItem);
        arrayList2.addAll(arrayList);
        if (!storeState.getUnavailableGuilds().isEmpty()) {
            arrayList2.add(new GuildListItem.UnavailableItem(storeState.getUnavailableGuilds().size()));
        }
        arrayList2.add(GuildListItem.CreateItem.INSTANCE);
        GrowthTeamFeatures growthTeamFeatures = GrowthTeamFeatures.INSTANCE;
        if (growthTeamFeatures.isHubDiscoveryEnabled()) {
            arrayList2.add(new GuildListItem.HubItem(storeState.getShowHubSparkle() && growthTeamFeatures.isHubDiscoverySparkleEnabled()));
        }
        if (storeState.isNewUser()) {
            arrayList2.add(dividerItem);
            arrayList2.add(GuildListItem.HelpItem.INSTANCE);
        }
        arrayList2.add(GuildListItem.SpaceItem.INSTANCE);
        ViewState.Loaded loaded = new ViewState.Loaded(arrayList2, !storeState.getChannelIds().isEmpty(), false);
        if (storeState.isLeftPanelOpened() != this.wasLeftPanelOpened || storeState.isOnHomeTab() != this.wasOnHomeTab) {
            if (storeState.isLeftPanelOpened() && storeState.isOnHomeTab()) {
                this.eventSubject.k.onNext(Event.FocusFirstElement.INSTANCE);
            }
            this.wasLeftPanelOpened = storeState.isLeftPanelOpened();
            this.wasOnHomeTab = storeState.isOnHomeTab();
        }
        updateViewState(loaded);
    }

    private final void move(int fromPosition, int toPosition, Long folderId) {
        ArrayList<GuildListItem> arrayList;
        int i = toPosition;
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            List<GuildListItem> items = loaded.getItems();
            GuildListItem guildListItem = items.get(fromPosition);
            if (this.currentTargetOperation != null || (fromPosition > i || Math.abs(fromPosition - i) >= 2) || ((guildListItem instanceof GuildListItem.GuildItem) && (Intrinsics3.areEqual(((GuildListItem.GuildItem) guildListItem).getFolderId(), folderId) ^ true))) {
                ArrayList<GuildListItem> arrayList2 = new ArrayList<>(items);
                untargetCurrentTarget(arrayList2);
                if (fromPosition < i) {
                    i--;
                }
                int i2 = i;
                if (!(guildListItem instanceof GuildListItem.FolderItem)) {
                    if (guildListItem instanceof GuildListItem.GuildItem) {
                        arrayList2.remove(fromPosition);
                        GuildListItem.GuildItem guildItem = (GuildListItem.GuildItem) guildListItem;
                        arrayList = arrayList2;
                        arrayList.add(i2, GuildListItem.GuildItem.copy$default(guildItem, null, 0, false, false, false, folderId, false, false, false, null, null, false, false, false, false, 32735, null));
                        rebuildFolders(arrayList, _Collections.toSet(Collections2.listOfNotNull((Object[]) new Long[]{guildItem.getFolderId(), folderId})));
                    }
                    updateViewState(ViewState.Loaded.copy$default(loaded, arrayList, false, true, 2, null));
                }
                arrayList2.remove(fromPosition);
                arrayList2.add(i2, guildListItem);
                arrayList = arrayList2;
                updateViewState(ViewState.Loaded.copy$default(loaded, arrayList, false, true, 2, null));
            }
        }
    }

    private final void performTargetOperation(ArrayList<GuildListItem> editingList, int fromPosition, int toPosition) {
        GuildListItem guildListItem = editingList.get(fromPosition);
        Intrinsics3.checkNotNullExpressionValue(guildListItem, "editingList[fromPosition]");
        GuildListItem guildListItem2 = guildListItem;
        GuildListItem guildListItem3 = editingList.get(toPosition);
        Intrinsics3.checkNotNullExpressionValue(guildListItem3, "editingList[toPosition]");
        GuildListItem guildListItem4 = guildListItem3;
        boolean z2 = guildListItem2 instanceof GuildListItem.GuildItem;
        if (z2 && (guildListItem4 instanceof GuildListItem.GuildItem)) {
            GuildListItem.GuildItem guildItem = (GuildListItem.GuildItem) guildListItem4;
            GuildListItem.GuildItem guildItem2 = (GuildListItem.GuildItem) guildListItem2;
            editingList.set(toPosition, new GuildListItem.FolderItem(Random.k.nextLong(), null, null, false, Collections2.listOf((Object[]) new Guild[]{guildItem.getGuild(), guildItem2.getGuild()}), guildItem.isSelected() || guildItem2.isSelected(), guildItem.isConnectedToVoice() || guildItem2.isConnectedToVoice(), guildItem.isConnectedToStageChannel() || guildItem2.isConnectedToStageChannel(), guildItem2.getMentionCount() + guildItem.getMentionCount(), guildItem.getIsUnread() || guildItem2.getIsUnread(), false));
            Intrinsics3.checkNotNullExpressionValue(editingList.remove(fromPosition), "editingList.removeAt(fromPosition)");
            return;
        }
        if (z2 && (guildListItem4 instanceof GuildListItem.FolderItem)) {
            GuildListItem.FolderItem folderItem = (GuildListItem.FolderItem) guildListItem4;
            GuildListItem.GuildItem guildItem3 = (GuildListItem.GuildItem) guildListItem2;
            editingList.set(toPosition, GuildListItem.FolderItem.copy$default(folderItem, 0L, null, null, false, _Collections.plus((Collection<? extends Guild>) _Collections.toMutableList((Collection) folderItem.getGuilds()), guildItem3.getGuild()), folderItem.isAnyGuildSelected() || guildItem3.isSelected(), folderItem.isAnyGuildConnectedToVoice() || guildItem3.isConnectedToVoice(), false, 0, folderItem.getIsUnread() || guildItem3.getIsUnread(), false, 399, null));
            editingList.remove(fromPosition);
        }
    }

    private final void rebuildFolders(ArrayList<GuildListItem> editingList, Set<Long> changedFolderIds) {
        if (changedFolderIds.isEmpty()) {
            return;
        }
        HashMap map = new HashMap();
        ArrayList<GuildListItem.GuildItem> arrayList = new ArrayList();
        for (Object obj : editingList) {
            if (obj instanceof GuildListItem.GuildItem) {
                arrayList.add(obj);
            }
        }
        for (GuildListItem.GuildItem guildItem : arrayList) {
            Long folderId = guildItem.getFolderId();
            if (folderId != null) {
                long jLongValue = folderId.longValue();
                ArrayList arrayList2 = (ArrayList) map.get(Long.valueOf(jLongValue));
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                arrayList2.add(guildItem.getGuild());
                map.put(Long.valueOf(jLongValue), arrayList2);
            }
        }
        Iterator<T> it = changedFolderIds.iterator();
        while (it.hasNext()) {
            long jLongValue2 = ((Number) it.next()).longValue();
            Iterator<GuildListItem> it2 = editingList.iterator();
            int i = 0;
            while (true) {
                if (!it2.hasNext()) {
                    i = -1;
                    break;
                }
                GuildListItem next = it2.next();
                if ((next instanceof GuildListItem.FolderItem) && ((GuildListItem.FolderItem) next).getFolderId() == jLongValue2) {
                    break;
                } else {
                    i++;
                }
            }
            GuildListItem guildListItem = editingList.get(i);
            Objects.requireNonNull(guildListItem, "null cannot be cast to non-null type com.discord.widgets.guilds.list.GuildListItem.FolderItem");
            GuildListItem.FolderItem folderItem = (GuildListItem.FolderItem) guildListItem;
            ArrayList arrayList3 = (ArrayList) map.get(Long.valueOf(jLongValue2));
            if (arrayList3 == null) {
                arrayList3 = new ArrayList();
            }
            editingList.set(i, GuildListItem.FolderItem.copy$default(folderItem, 0L, null, null, false, arrayList3, false, false, false, 0, false, false, 2031, null));
        }
    }

    private final boolean shouldDisplayVideoIconOnGuild(long guildId, ModelNotificationSettings guildNotificationSettings, Map<Long, StreamContext> streamContexts, Map<Long, Long> permissions) {
        if (streamContexts == null || streamContexts.isEmpty()) {
            return false;
        }
        if (guildNotificationSettings != null && guildNotificationSettings.isMuted()) {
            return false;
        }
        Collection<StreamContext> collectionValues = streamContexts.values();
        if (!(collectionValues instanceof Collection) || !collectionValues.isEmpty()) {
            for (StreamContext streamContext : collectionValues) {
                Guild guild = streamContext.getGuild();
                if (guild != null && guild.getId() == guildId && PermissionUtils.can(Permission.VIEW_CHANNEL, permissions.get(Long.valueOf(streamContext.getStream().getChannelId())))) {
                    return true;
                }
            }
        }
        return false;
    }

    private final int sumMentionCountsForGuild(long guildId, Map<Long, ? extends Collection<Long>> guildChannels, Map<Long, Integer> mentionCounts) {
        Collection<Long> collection = guildChannels.get(Long.valueOf(guildId));
        if (collection == null) {
            return 0;
        }
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(collection, 10));
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            Integer num = mentionCounts.get(Long.valueOf(((Number) it.next()).longValue()));
            arrayList.add(Integer.valueOf(num != null ? num.intValue() : 0));
        }
        return _Collections.sumOfInt(arrayList);
    }

    private final void untargetCurrentTarget(ArrayList<GuildListItem> editingList) {
        GuildListItem guildListItemCopy$default;
        WidgetGuildListAdapter.Operation.TargetOperation targetOperation = this.currentTargetOperation;
        if (targetOperation != null) {
            int targetPosition = targetOperation.getTargetPosition();
            GuildListItem guildListItem = editingList.get(targetPosition);
            Intrinsics3.checkNotNullExpressionValue(guildListItem, "editingList[toPosition]");
            GuildListItem guildListItem2 = guildListItem;
            if (guildListItem2 instanceof GuildListItem.GuildItem) {
                guildListItemCopy$default = GuildListItem.GuildItem.copy$default((GuildListItem.GuildItem) guildListItem2, null, 0, false, false, false, null, false, false, false, null, null, false, false, false, false, 32511, null);
            } else if (guildListItem2 instanceof GuildListItem.FolderItem) {
                guildListItemCopy$default = GuildListItem.FolderItem.copy$default((GuildListItem.FolderItem) guildListItem2, 0L, null, null, false, null, false, false, false, 0, false, false, AudioAttributesCompat.FLAG_ALL, null);
            }
            editingList.set(targetPosition, guildListItemCopy$default);
        }
        this.currentTargetOperation = null;
    }

    public final Observable<Event> listenForEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void moveAbove(int fromPosition, int targetPosition) {
        ViewState viewState = getViewState();
        Long folderId = null;
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            GuildListItem guildListItem = loaded.getItems().get(targetPosition);
            if (guildListItem instanceof GuildListItem.GuildItem) {
                folderId = ((GuildListItem.GuildItem) guildListItem).getFolderId();
            } else if (!(guildListItem instanceof GuildListItem.FolderItem) && !(guildListItem instanceof GuildListItem.HelpItem) && !(guildListItem instanceof GuildListItem.CreateItem)) {
                throw new IllegalStateException("invalid target");
            }
            move(fromPosition, targetPosition, folderId);
        }
    }

    public final void moveBelow(int fromPosition, int targetPosition) {
        ViewState viewState = getViewState();
        Long lValueOf = null;
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            GuildListItem guildListItem = loaded.getItems().get(targetPosition);
            if (guildListItem instanceof GuildListItem.GuildItem) {
                lValueOf = ((GuildListItem.GuildItem) guildListItem).getFolderId();
            } else {
                if (!(guildListItem instanceof GuildListItem.FolderItem)) {
                    throw new IllegalStateException("invalid target");
                }
                GuildListItem.FolderItem folderItem = (GuildListItem.FolderItem) guildListItem;
                if (folderItem.isOpen()) {
                    lValueOf = Long.valueOf(folderItem.getFolderId());
                }
            }
            move(fromPosition, targetPosition + 1, lValueOf);
        }
    }

    public final boolean onDrop() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded == null) {
            return false;
        }
        List<GuildListItem> items = loaded.getItems();
        ArrayList arrayList = new ArrayList();
        WidgetGuildListAdapter.Operation.TargetOperation targetOperation = this.currentTargetOperation;
        if (targetOperation != null) {
            ArrayList<GuildListItem> arrayList2 = new ArrayList<>(items);
            untargetCurrentTarget(arrayList2);
            performTargetOperation(arrayList2, targetOperation.getFromPosition(), targetOperation.getTargetPosition());
            items = arrayList2;
        }
        for (GuildListItem guildListItem : items) {
            if (guildListItem instanceof GuildListItem.FolderItem) {
                GuildListItem.FolderItem folderItem = (GuildListItem.FolderItem) guildListItem;
                arrayList.add(new StoreGuildsSorted.Entry.Folder(folderItem.getFolderId(), folderItem.getGuilds(), folderItem.getColor(), folderItem.getName()));
            } else if (guildListItem instanceof GuildListItem.GuildItem) {
                GuildListItem.GuildItem guildItem = (GuildListItem.GuildItem) guildListItem;
                if (guildItem.getFolderId() == null) {
                    arrayList.add(new StoreGuildsSorted.Entry.SingletonGuild(guildItem.getGuild()));
                }
            }
        }
        StoreStream.INSTANCE.getGuildsSorted().setPositions(arrayList);
        ArrayList arrayList3 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList3.add(((StoreGuildsSorted.Entry) it.next()).asModelGuildFolder());
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().updateUserSettings(RestAPIParams.UserSettings.INSTANCE.createWithGuildFolders(arrayList3)), false, 1, null), WidgetGuildsListViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, AnonymousClass2.INSTANCE, 62, (Object) null);
        return targetOperation != null;
    }

    public final void onItemClicked(GuildListItem item, Context context, FragmentManager fragmentManager) {
        Intrinsics3.checkNotNullParameter(item, "item");
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
        boolean z2 = !GrowthTeamFeatures.INSTANCE.isHubEnabled();
        if (item instanceof GuildListItem.GuildItem) {
            GuildListItem.GuildItem guildItem = (GuildListItem.GuildItem) item;
            if (guildItem.isPendingGuild()) {
                MemberVerificationUtils.maybeShowVerificationGate$default(MemberVerificationUtils.INSTANCE, context, fragmentManager, guildItem.getGuild().getId(), "Guilds List", null, null, AnonymousClass1.INSTANCE, 48, null);
                return;
            }
            if (guildItem.isSelected()) {
                StoreNavigation.setNavigationPanelAction$default(StoreStream.INSTANCE.getNavigation(), StoreNavigation.PanelAction.CLOSE, null, 2, null);
                return;
            } else if (guildItem.getGuild().isHub() && z2) {
                AppToast.g(context, R.string.discord_u_coming_soon_to_mobile, 0, null, 12);
                return;
            } else {
                StoreStream.INSTANCE.getGuildSelected().set(guildItem.getGuild().getId());
                return;
            }
        }
        if (item instanceof GuildListItem.PrivateChannelItem) {
            ChannelSelector.selectChannel$default(ChannelSelector.INSTANCE.getInstance(), 0L, ((GuildListItem.PrivateChannelItem) item).getChannel().getId(), null, null, 12, null);
            return;
        }
        if (item instanceof GuildListItem.UnavailableItem) {
            this.eventSubject.k.onNext(new Event.ShowUnavailableGuilds(((GuildListItem.UnavailableItem) item).getUnavailableGuildCount()));
            return;
        }
        if (item instanceof GuildListItem.FriendsItem) {
            if (((GuildListItem.FriendsItem) item).isSelected()) {
                StoreNavigation.setNavigationPanelAction$default(StoreStream.INSTANCE.getNavigation(), StoreNavigation.PanelAction.CLOSE, null, 2, null);
                return;
            } else {
                StoreStream.INSTANCE.getGuildSelected().set(0L);
                return;
            }
        }
        if (Intrinsics3.areEqual(item, GuildListItem.CreateItem.INSTANCE)) {
            this.eventSubject.k.onNext(Event.ShowCreateGuild.INSTANCE);
            return;
        }
        if (item instanceof GuildListItem.HubItem) {
            StoreStream.INSTANCE.getDirectories().markDiscordHubClicked();
            this.eventSubject.k.onNext(Event.ShowHubVerification.INSTANCE);
            return;
        }
        if (Intrinsics3.areEqual(item, GuildListItem.HelpItem.INSTANCE)) {
            this.eventSubject.k.onNext(Event.ShowHelp.INSTANCE);
        } else if (item instanceof GuildListItem.FolderItem) {
            GuildListItem.FolderItem folderItem = (GuildListItem.FolderItem) item;
            if (folderItem.isOpen()) {
                StoreStream.INSTANCE.getExpandedGuildFolders().closeFolder(item.getItemId());
            } else {
                StoreStream.INSTANCE.getExpandedGuildFolders().openFolder(item.getItemId());
            }
            this.eventSubject.k.onNext(new Event.AnnounceFolderToggleForAccessibility(folderItem));
        }
    }

    public final void onItemLongPressed(GuildListItem item) {
        Intrinsics3.checkNotNullParameter(item, "item");
        if (item instanceof GuildListItem.PrivateChannelItem) {
            PublishSubject<Event> publishSubject = this.eventSubject;
            publishSubject.k.onNext(new Event.ShowChannelActions(((GuildListItem.PrivateChannelItem) item).getChannel().getId()));
        }
    }

    public final void target(int fromPosition, int toPosition) {
        GuildListItem guildListItemCopy$default;
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded == null) {
            throw new IllegalStateException("targeting with no items");
        }
        ArrayList<GuildListItem> arrayList = new ArrayList<>(loaded.getItems());
        untargetCurrentTarget(arrayList);
        GuildListItem guildListItem = arrayList.get(toPosition);
        if (guildListItem instanceof GuildListItem.GuildItem) {
            guildListItemCopy$default = GuildListItem.GuildItem.copy$default((GuildListItem.GuildItem) guildListItem, null, 0, false, false, false, null, false, false, true, null, null, false, false, false, false, 32511, null);
        } else {
            if (!(guildListItem instanceof GuildListItem.FolderItem)) {
                throw new IllegalStateException("invalid target item: " + guildListItem);
            }
            guildListItemCopy$default = GuildListItem.FolderItem.copy$default((GuildListItem.FolderItem) guildListItem, 0L, null, null, false, null, false, false, false, 0, false, true, AudioAttributesCompat.FLAG_ALL, null);
        }
        arrayList.set(toPosition, guildListItemCopy$default);
        this.currentTargetOperation = new WidgetGuildListAdapter.Operation.TargetOperation(fromPosition, toPosition);
        updateViewState(ViewState.Loaded.copy$default(loaded, arrayList, false, true, 2, null));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildsListViewModel(Clock clock, Observable<StoreState> observable) {
        super(ViewState.Uninitialized.INSTANCE);
        Intrinsics3.checkNotNullParameter(clock, "clock");
        Intrinsics3.checkNotNullParameter(observable, "storeObservable");
        this.clock = clock;
        this.eventSubject = PublishSubject.k0();
        Observable observableR = ObservableExtensionsKt.computationLatest(observable).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "storeObservable\n        …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableR, this, null, 2, null), WidgetGuildsListViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
