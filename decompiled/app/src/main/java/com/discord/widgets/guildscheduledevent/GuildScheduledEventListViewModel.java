package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import androidx.fragment.app.Fragment;
import b.a.d.AppToast;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.permission.Permission;
import com.discord.models.guild.UserGuildMember;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuildScheduledEvents;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreVoiceChannelSelected;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.channel.ChannelInviteLaunchUtils;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventListItem;
import d0.t.Iterables2;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: GuildScheduledEventListViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 02\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003012Bo\u0012\n\u0010\u0018\u001a\u00060\u0016j\u0002`\u0017\u0012\u000e\u0010*\u001a\n\u0018\u00010\u0016j\u0004\u0018\u0001`)\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001d\u0012\b\b\u0002\u0010$\u001a\u00020#\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001a\u0012\b\b\u0002\u0010!\u001a\u00020 \u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u0012\b\b\u0002\u0010'\u001a\u00020&\u0012\u000e\b\u0002\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00030,¢\u0006\u0004\b.\u0010/J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ1\u0010\u0011\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\f¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0018\u001a\u00060\u0016j\u0002`\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010$\u001a\u00020#8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010'\u001a\u00020&8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u001e\u0010*\u001a\n\u0018\u00010\u0016j\u0004\u0018\u0001`)8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+¨\u00063"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventListViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventListViewModel$ViewState;", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventListViewModel$StoreState;", "storeState", "", "handleStoreState", "(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventListViewModel$StoreState;)V", "Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "guildScheduledEvent", "toggleRsvp", "(Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;)V", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "weakContext", "Landroidx/fragment/app/Fragment;", "weakFragment", "onShareClicked", "(Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;Ljava/lang/ref/WeakReference;Ljava/lang/ref/WeakReference;)V", "Lcom/discord/stores/StoreVoiceChannelSelected;", "voiceChannelSelectedStore", "Lcom/discord/stores/StoreVoiceChannelSelected;", "", "Lcom/discord/primitives/GuildId;", "guildId", "J", "Lcom/discord/stores/StorePermissions;", "permissionsStore", "Lcom/discord/stores/StorePermissions;", "Lcom/discord/stores/StoreGuildScheduledEvents;", "guildScheduledEventsStore", "Lcom/discord/stores/StoreGuildScheduledEvents;", "Lcom/discord/stores/StoreGuilds;", "guildsStore", "Lcom/discord/stores/StoreGuilds;", "Lcom/discord/stores/StoreChannels;", "channelsStore", "Lcom/discord/stores/StoreChannels;", "Lcom/discord/stores/StoreUser;", "userStore", "Lcom/discord/stores/StoreUser;", "Lcom/discord/primitives/ChannelId;", "channelId", "Ljava/lang/Long;", "Lrx/Observable;", "storeStateObservable", "<init>", "(JLjava/lang/Long;Lcom/discord/stores/StoreGuildScheduledEvents;Lcom/discord/stores/StoreChannels;Lcom/discord/stores/StorePermissions;Lcom/discord/stores/StoreGuilds;Lcom/discord/stores/StoreVoiceChannelSelected;Lcom/discord/stores/StoreUser;Lrx/Observable;)V", "Companion", "StoreState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class GuildScheduledEventListViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Long channelId;
    private final StoreChannels channelsStore;
    private final long guildId;
    private final StoreGuildScheduledEvents guildScheduledEventsStore;
    private final StoreGuilds guildsStore;
    private final StorePermissions permissionsStore;
    private final StoreUser userStore;
    private final StoreVoiceChannelSelected voiceChannelSelectedStore;

    /* compiled from: GuildScheduledEventListViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventListViewModel$StoreState;", "p1", "", "invoke", "(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventListViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventListViewModel$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<StoreState, Unit> {
        public AnonymousClass1(GuildScheduledEventListViewModel guildScheduledEventListViewModel) {
            super(1, guildScheduledEventListViewModel, GuildScheduledEventListViewModel.class, "handleStoreState", "handleStoreState(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventListViewModel$StoreState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "p1");
            GuildScheduledEventListViewModel.access$handleStoreState((GuildScheduledEventListViewModel) this.receiver, storeState);
        }
    }

    /* compiled from: GuildScheduledEventListViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018Ja\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u000e\u0010\u0006\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventListViewModel$Companion;", "", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/primitives/ChannelId;", "channelId", "Lcom/discord/stores/StoreGuildScheduledEvents;", "guildScheduledEventsStore", "Lcom/discord/stores/StoreChannels;", "channelStore", "Lcom/discord/stores/StorePermissions;", "permissionsStore", "Lcom/discord/stores/StoreGuilds;", "guildStore", "Lcom/discord/stores/StoreVoiceChannelSelected;", "voiceChannelSelectedStore", "Lcom/discord/stores/StoreUser;", "userStore", "Lrx/Observable;", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventListViewModel$StoreState;", "observeStores", "(JLjava/lang/Long;Lcom/discord/stores/StoreGuildScheduledEvents;Lcom/discord/stores/StoreChannels;Lcom/discord/stores/StorePermissions;Lcom/discord/stores/StoreGuilds;Lcom/discord/stores/StoreVoiceChannelSelected;Lcom/discord/stores/StoreUser;)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStores(Companion companion, long j, Long l, StoreGuildScheduledEvents storeGuildScheduledEvents, StoreChannels storeChannels, StorePermissions storePermissions, StoreGuilds storeGuilds, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreUser storeUser) {
            return companion.observeStores(j, l, storeGuildScheduledEvents, storeChannels, storePermissions, storeGuilds, storeVoiceChannelSelected, storeUser);
        }

        private final Observable<StoreState> observeStores(long guildId, Long channelId, StoreGuildScheduledEvents guildScheduledEventsStore, StoreChannels channelStore, StorePermissions permissionsStore, StoreGuilds guildStore, StoreVoiceChannelSelected voiceChannelSelectedStore, StoreUser userStore) {
            return ObservationDeck.connectRx$default(ObservationDeck4.get(), new ObservationDeck.UpdateSource[]{guildScheduledEventsStore, channelStore, permissionsStore, guildStore, voiceChannelSelectedStore, userStore}, false, null, null, new GuildScheduledEventListViewModel2(channelStore, guildId, guildScheduledEventsStore, channelId, userStore, guildStore, permissionsStore, voiceChannelSelectedStore), 14, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: GuildScheduledEventListViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001B\u008b\u0001\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0010\u0010\u001b\u001a\f\u0012\b\u0012\u00060\u0007j\u0002`\b0\u0006\u0012\u0016\u0010\u001c\u001a\u0012\u0012\b\u0012\u00060\u0007j\u0002`\f\u0012\u0004\u0012\u00020\r0\u000b\u0012\u0016\u0010\u001d\u001a\u0012\u0012\b\u0012\u00060\u0007j\u0002`\u0010\u0012\u0004\u0012\u00020\u00110\u000b\u0012\u0006\u0010\u001e\u001a\u00020\u0013\u0012\u000e\u0010\u001f\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\f\u0012\u001a\u0010 \u001a\u0016\u0012\b\u0012\u00060\u0007j\u0002`\f\u0012\b\u0012\u00060\u0007j\u0002`\u00180\u000b¢\u0006\u0004\b8\u00109J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\t\u001a\f\u0012\b\u0012\u00060\u0007j\u0002`\b0\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ \u0010\u000e\u001a\u0012\u0012\b\u0012\u00060\u0007j\u0002`\f\u0012\u0004\u0012\u00020\r0\u000bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ \u0010\u0012\u001a\u0012\u0012\b\u0012\u00060\u0007j\u0002`\u0010\u0012\u0004\u0012\u00020\u00110\u000bHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u000fJ\u0010\u0010\u0014\u001a\u00020\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0016\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\fHÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J$\u0010\u0019\u001a\u0016\u0012\b\u0012\u00060\u0007j\u0002`\f\u0012\b\u0012\u00060\u0007j\u0002`\u00180\u000bHÆ\u0003¢\u0006\u0004\b\u0019\u0010\u000fJ¢\u0001\u0010!\u001a\u00020\u00002\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0012\b\u0002\u0010\u001b\u001a\f\u0012\b\u0012\u00060\u0007j\u0002`\b0\u00062\u0018\b\u0002\u0010\u001c\u001a\u0012\u0012\b\u0012\u00060\u0007j\u0002`\f\u0012\u0004\u0012\u00020\r0\u000b2\u0018\b\u0002\u0010\u001d\u001a\u0012\u0012\b\u0012\u00060\u0007j\u0002`\u0010\u0012\u0004\u0012\u00020\u00110\u000b2\b\b\u0002\u0010\u001e\u001a\u00020\u00132\u0010\b\u0002\u0010\u001f\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\f2\u001c\b\u0002\u0010 \u001a\u0016\u0012\b\u0012\u00060\u0007j\u0002`\f\u0012\b\u0012\u00060\u0007j\u0002`\u00180\u000bHÆ\u0001¢\u0006\u0004\b!\u0010\"J\u0010\u0010$\u001a\u00020#HÖ\u0001¢\u0006\u0004\b$\u0010%J\u0010\u0010'\u001a\u00020&HÖ\u0001¢\u0006\u0004\b'\u0010(J\u001a\u0010*\u001a\u00020\u00132\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b*\u0010+R)\u0010\u001d\u001a\u0012\u0012\b\u0012\u00060\u0007j\u0002`\u0010\u0012\u0004\u0012\u00020\u00110\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010,\u001a\u0004\b-\u0010\u000fR!\u0010\u001f\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010.\u001a\u0004\b/\u0010\u0017R\u0019\u0010\u001e\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u00100\u001a\u0004\b1\u0010\u0015R#\u0010\u001b\u001a\f\u0012\b\u0012\u00060\u0007j\u0002`\b0\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u00102\u001a\u0004\b3\u0010\nR\u001f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u00104\u001a\u0004\b5\u0010\u0005R-\u0010 \u001a\u0016\u0012\b\u0012\u00060\u0007j\u0002`\f\u0012\b\u0012\u00060\u0007j\u0002`\u00180\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010,\u001a\u0004\b6\u0010\u000fR)\u0010\u001c\u001a\u0012\u0012\b\u0012\u00060\u0007j\u0002`\f\u0012\u0004\u0012\u00020\r0\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010,\u001a\u0004\b7\u0010\u000f¨\u0006:"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventListViewModel$StoreState;", "", "", "Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "component1", "()Ljava/util/List;", "", "", "Lcom/discord/primitives/GuildScheduledEventId;", "component2", "()Ljava/util/Set;", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/channel/Channel;", "component3", "()Ljava/util/Map;", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/guild/UserGuildMember;", "component4", "", "component5", "()Z", "component6", "()Ljava/lang/Long;", "Lcom/discord/api/permission/PermissionBit;", "component7", "guildScheduledEvents", "userGuildScheduledEventIds", "guildChannels", "creators", "canCreateEvents", "selectedVoiceChannelId", "channelPermissions", "copy", "(Ljava/util/List;Ljava/util/Set;Ljava/util/Map;Ljava/util/Map;ZLjava/lang/Long;Ljava/util/Map;)Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventListViewModel$StoreState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Map;", "getCreators", "Ljava/lang/Long;", "getSelectedVoiceChannelId", "Z", "getCanCreateEvents", "Ljava/util/Set;", "getUserGuildScheduledEventIds", "Ljava/util/List;", "getGuildScheduledEvents", "getChannelPermissions", "getGuildChannels", "<init>", "(Ljava/util/List;Ljava/util/Set;Ljava/util/Map;Ljava/util/Map;ZLjava/lang/Long;Ljava/util/Map;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class StoreState {
        private final boolean canCreateEvents;
        private final Map<Long, Long> channelPermissions;
        private final Map<Long, UserGuildMember> creators;
        private final Map<Long, Channel> guildChannels;
        private final List<GuildScheduledEvent> guildScheduledEvents;
        private final Long selectedVoiceChannelId;
        private final Set<Long> userGuildScheduledEventIds;

        public StoreState(List<GuildScheduledEvent> list, Set<Long> set, Map<Long, Channel> map, Map<Long, UserGuildMember> map2, boolean z2, Long l, Map<Long, Long> map3) {
            Intrinsics3.checkNotNullParameter(list, "guildScheduledEvents");
            Intrinsics3.checkNotNullParameter(set, "userGuildScheduledEventIds");
            Intrinsics3.checkNotNullParameter(map, "guildChannels");
            Intrinsics3.checkNotNullParameter(map2, "creators");
            Intrinsics3.checkNotNullParameter(map3, "channelPermissions");
            this.guildScheduledEvents = list;
            this.userGuildScheduledEventIds = set;
            this.guildChannels = map;
            this.creators = map2;
            this.canCreateEvents = z2;
            this.selectedVoiceChannelId = l;
            this.channelPermissions = map3;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, List list, Set set, Map map, Map map2, boolean z2, Long l, Map map3, int i, Object obj) {
            if ((i & 1) != 0) {
                list = storeState.guildScheduledEvents;
            }
            if ((i & 2) != 0) {
                set = storeState.userGuildScheduledEventIds;
            }
            Set set2 = set;
            if ((i & 4) != 0) {
                map = storeState.guildChannels;
            }
            Map map4 = map;
            if ((i & 8) != 0) {
                map2 = storeState.creators;
            }
            Map map5 = map2;
            if ((i & 16) != 0) {
                z2 = storeState.canCreateEvents;
            }
            boolean z3 = z2;
            if ((i & 32) != 0) {
                l = storeState.selectedVoiceChannelId;
            }
            Long l2 = l;
            if ((i & 64) != 0) {
                map3 = storeState.channelPermissions;
            }
            return storeState.copy(list, set2, map4, map5, z3, l2, map3);
        }

        public final List<GuildScheduledEvent> component1() {
            return this.guildScheduledEvents;
        }

        public final Set<Long> component2() {
            return this.userGuildScheduledEventIds;
        }

        public final Map<Long, Channel> component3() {
            return this.guildChannels;
        }

        public final Map<Long, UserGuildMember> component4() {
            return this.creators;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getCanCreateEvents() {
            return this.canCreateEvents;
        }

        /* renamed from: component6, reason: from getter */
        public final Long getSelectedVoiceChannelId() {
            return this.selectedVoiceChannelId;
        }

        public final Map<Long, Long> component7() {
            return this.channelPermissions;
        }

        public final StoreState copy(List<GuildScheduledEvent> guildScheduledEvents, Set<Long> userGuildScheduledEventIds, Map<Long, Channel> guildChannels, Map<Long, UserGuildMember> creators, boolean canCreateEvents, Long selectedVoiceChannelId, Map<Long, Long> channelPermissions) {
            Intrinsics3.checkNotNullParameter(guildScheduledEvents, "guildScheduledEvents");
            Intrinsics3.checkNotNullParameter(userGuildScheduledEventIds, "userGuildScheduledEventIds");
            Intrinsics3.checkNotNullParameter(guildChannels, "guildChannels");
            Intrinsics3.checkNotNullParameter(creators, "creators");
            Intrinsics3.checkNotNullParameter(channelPermissions, "channelPermissions");
            return new StoreState(guildScheduledEvents, userGuildScheduledEventIds, guildChannels, creators, canCreateEvents, selectedVoiceChannelId, channelPermissions);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.guildScheduledEvents, storeState.guildScheduledEvents) && Intrinsics3.areEqual(this.userGuildScheduledEventIds, storeState.userGuildScheduledEventIds) && Intrinsics3.areEqual(this.guildChannels, storeState.guildChannels) && Intrinsics3.areEqual(this.creators, storeState.creators) && this.canCreateEvents == storeState.canCreateEvents && Intrinsics3.areEqual(this.selectedVoiceChannelId, storeState.selectedVoiceChannelId) && Intrinsics3.areEqual(this.channelPermissions, storeState.channelPermissions);
        }

        public final boolean getCanCreateEvents() {
            return this.canCreateEvents;
        }

        public final Map<Long, Long> getChannelPermissions() {
            return this.channelPermissions;
        }

        public final Map<Long, UserGuildMember> getCreators() {
            return this.creators;
        }

        public final Map<Long, Channel> getGuildChannels() {
            return this.guildChannels;
        }

        public final List<GuildScheduledEvent> getGuildScheduledEvents() {
            return this.guildScheduledEvents;
        }

        public final Long getSelectedVoiceChannelId() {
            return this.selectedVoiceChannelId;
        }

        public final Set<Long> getUserGuildScheduledEventIds() {
            return this.userGuildScheduledEventIds;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            List<GuildScheduledEvent> list = this.guildScheduledEvents;
            int iHashCode = (list != null ? list.hashCode() : 0) * 31;
            Set<Long> set = this.userGuildScheduledEventIds;
            int iHashCode2 = (iHashCode + (set != null ? set.hashCode() : 0)) * 31;
            Map<Long, Channel> map = this.guildChannels;
            int iHashCode3 = (iHashCode2 + (map != null ? map.hashCode() : 0)) * 31;
            Map<Long, UserGuildMember> map2 = this.creators;
            int iHashCode4 = (iHashCode3 + (map2 != null ? map2.hashCode() : 0)) * 31;
            boolean z2 = this.canCreateEvents;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode4 + i) * 31;
            Long l = this.selectedVoiceChannelId;
            int iHashCode5 = (i2 + (l != null ? l.hashCode() : 0)) * 31;
            Map<Long, Long> map3 = this.channelPermissions;
            return iHashCode5 + (map3 != null ? map3.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(guildScheduledEvents=");
            sbU.append(this.guildScheduledEvents);
            sbU.append(", userGuildScheduledEventIds=");
            sbU.append(this.userGuildScheduledEventIds);
            sbU.append(", guildChannels=");
            sbU.append(this.guildChannels);
            sbU.append(", creators=");
            sbU.append(this.creators);
            sbU.append(", canCreateEvents=");
            sbU.append(this.canCreateEvents);
            sbU.append(", selectedVoiceChannelId=");
            sbU.append(this.selectedVoiceChannelId);
            sbU.append(", channelPermissions=");
            return outline.M(sbU, this.channelPermissions, ")");
        }
    }

    /* compiled from: GuildScheduledEventListViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventListViewModel$ViewState;", "", "<init>", "()V", "Initial", "Loaded", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventListViewModel$ViewState$Initial;", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventListViewModel$ViewState$Loaded;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        /* compiled from: GuildScheduledEventListViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventListViewModel$ViewState$Initial;", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventListViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Initial extends ViewState {
            public static final Initial INSTANCE = new Initial();

            private Initial() {
                super(null);
            }
        }

        /* compiled from: GuildScheduledEventListViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u001b\u0010\u001cJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0005R\u0019\u0010\n\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001a\u0010\b¨\u0006\u001d"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventListViewModel$ViewState$Loaded;", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventListViewModel$ViewState;", "", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventListItem$Event;", "component1", "()Ljava/util/List;", "", "component2", "()Z", "guildScheduledEvents", "canCreateEvents", "copy", "(Ljava/util/List;Z)Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventListViewModel$ViewState$Loaded;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getGuildScheduledEvents", "Z", "getCanCreateEvents", "<init>", "(Ljava/util/List;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Loaded extends ViewState {
            private final boolean canCreateEvents;
            private final List<GuildScheduledEventListItem.Event> guildScheduledEvents;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(List<GuildScheduledEventListItem.Event> list, boolean z2) {
                super(null);
                Intrinsics3.checkNotNullParameter(list, "guildScheduledEvents");
                this.guildScheduledEvents = list;
                this.canCreateEvents = z2;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, List list, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = loaded.guildScheduledEvents;
                }
                if ((i & 2) != 0) {
                    z2 = loaded.canCreateEvents;
                }
                return loaded.copy(list, z2);
            }

            public final List<GuildScheduledEventListItem.Event> component1() {
                return this.guildScheduledEvents;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getCanCreateEvents() {
                return this.canCreateEvents;
            }

            public final Loaded copy(List<GuildScheduledEventListItem.Event> guildScheduledEvents, boolean canCreateEvents) {
                Intrinsics3.checkNotNullParameter(guildScheduledEvents, "guildScheduledEvents");
                return new Loaded(guildScheduledEvents, canCreateEvents);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return Intrinsics3.areEqual(this.guildScheduledEvents, loaded.guildScheduledEvents) && this.canCreateEvents == loaded.canCreateEvents;
            }

            public final boolean getCanCreateEvents() {
                return this.canCreateEvents;
            }

            public final List<GuildScheduledEventListItem.Event> getGuildScheduledEvents() {
                return this.guildScheduledEvents;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                List<GuildScheduledEventListItem.Event> list = this.guildScheduledEvents;
                int iHashCode = (list != null ? list.hashCode() : 0) * 31;
                boolean z2 = this.canCreateEvents;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                return iHashCode + i;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(guildScheduledEvents=");
                sbU.append(this.guildScheduledEvents);
                sbU.append(", canCreateEvents=");
                return outline.O(sbU, this.canCreateEvents, ")");
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: GuildScheduledEventListViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/channel/Channel;", "defaultChannel", "", "invoke", "(Lcom/discord/api/channel/Channel;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventListViewModel$onShareClicked$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Channel, Unit> {
        public final /* synthetic */ Channel $channel;
        public final /* synthetic */ long $guildEventId;
        public final /* synthetic */ WeakReference $weakFragment;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(WeakReference weakReference, Channel channel, long j) {
            super(1);
            this.$weakFragment = weakReference;
            this.$channel = channel;
            this.$guildEventId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            Fragment fragment = (Fragment) this.$weakFragment.get();
            if (fragment != null) {
                ChannelInviteLaunchUtils channelInviteLaunchUtils = ChannelInviteLaunchUtils.INSTANCE;
                Intrinsics3.checkNotNullExpressionValue(fragment, "fragment");
                Channel channel2 = this.$channel;
                ChannelInviteLaunchUtils.inviteToChannel$default(channelInviteLaunchUtils, fragment, channel2 != null ? channel2 : channel, GuildScheduledEventUtilities.ANALYTICS_SOURCE, Long.valueOf(this.$guildEventId), null, 16, null);
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ GuildScheduledEventListViewModel(long j, Long l, StoreGuildScheduledEvents storeGuildScheduledEvents, StoreChannels storeChannels, StorePermissions storePermissions, StoreGuilds storeGuilds, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreUser storeUser, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        StoreGuildScheduledEvents guildScheduledEvents = (i & 4) != 0 ? StoreStream.INSTANCE.getGuildScheduledEvents() : storeGuildScheduledEvents;
        StoreChannels channels = (i & 8) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels;
        StorePermissions permissions = (i & 16) != 0 ? StoreStream.INSTANCE.getPermissions() : storePermissions;
        StoreGuilds guilds = (i & 32) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds;
        StoreVoiceChannelSelected voiceChannelSelected = (i & 64) != 0 ? StoreStream.INSTANCE.getVoiceChannelSelected() : storeVoiceChannelSelected;
        StoreUser users = (i & 128) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser;
        this(j, l, guildScheduledEvents, channels, permissions, guilds, voiceChannelSelected, users, (i & 256) != 0 ? Companion.access$observeStores(INSTANCE, j, l, guildScheduledEvents, channels, permissions, guilds, voiceChannelSelected, users) : observable);
    }

    public static final /* synthetic */ void access$handleStoreState(GuildScheduledEventListViewModel guildScheduledEventListViewModel, StoreState storeState) {
        guildScheduledEventListViewModel.handleStoreState(storeState);
    }

    private final void handleStoreState(StoreState storeState) {
        boolean z2;
        if (!(getViewState() instanceof ViewState.Loaded)) {
            AnalyticsTracker.INSTANCE.openGuildScheduledEventSheet(this.guildId, storeState.getGuildScheduledEvents().size());
        }
        List<GuildScheduledEvent> guildScheduledEvents = storeState.getGuildScheduledEvents();
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(guildScheduledEvents, 10));
        for (GuildScheduledEvent guildScheduledEvent : guildScheduledEvents) {
            Long channelId = guildScheduledEvent.getChannelId();
            Channel channel = channelId != null ? storeState.getGuildChannels().get(Long.valueOf(channelId.longValue())) : null;
            Long creatorId = guildScheduledEvent.getCreatorId();
            UserGuildMember userGuildMember = creatorId != null ? storeState.getCreators().get(Long.valueOf(creatorId.longValue())) : null;
            boolean zContains = storeState.getUserGuildScheduledEventIds().contains(Long.valueOf(guildScheduledEvent.getId()));
            GuildScheduledEventUtilities.Companion companion = GuildScheduledEventUtilities.INSTANCE;
            boolean zCanStartEvent$default = GuildScheduledEventUtilities.Companion.canStartEvent$default(companion, this.guildId, channel != null ? Long.valueOf(channel.getId()) : null, null, null, 12, null);
            boolean zCanShareEvent$default = GuildScheduledEventUtilities.Companion.canShareEvent$default(companion, channel != null ? Long.valueOf(channel.getId()) : null, this.guildId, null, null, null, null, 60, null);
            Long selectedVoiceChannelId = storeState.getSelectedVoiceChannelId();
            if (selectedVoiceChannelId != null) {
                long jLongValue = selectedVoiceChannelId.longValue();
                Long channelId2 = guildScheduledEvent.getChannelId();
                z2 = channelId2 != null && jLongValue == channelId2.longValue();
            } else {
                z2 = false;
            }
            Long channelId3 = guildScheduledEvent.getChannelId();
            arrayList.add(new GuildScheduledEventListItem.Event(guildScheduledEvent, channel, userGuildMember, zContains, zCanStartEvent$default, zCanShareEvent$default, z2, channelId3 != null ? PermissionUtils.can(Permission.CONNECT, storeState.getChannelPermissions().get(Long.valueOf(channelId3.longValue()))) : false));
        }
        updateViewState(new ViewState.Loaded(arrayList, storeState.getCanCreateEvents()));
    }

    public final void onShareClicked(GuildScheduledEvent guildScheduledEvent, WeakReference<Context> weakContext, WeakReference<Fragment> weakFragment) {
        Channel channel;
        Intrinsics3.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
        Intrinsics3.checkNotNullParameter(weakContext, "weakContext");
        Intrinsics3.checkNotNullParameter(weakFragment, "weakFragment");
        long guildId = guildScheduledEvent.getGuildId();
        long id2 = guildScheduledEvent.getId();
        Long channelId = guildScheduledEvent.getChannelId();
        boolean zCanShareEvent$default = GuildScheduledEventUtilities.Companion.canShareEvent$default(GuildScheduledEventUtilities.INSTANCE, channelId, guildId, null, null, null, null, 60, null);
        if (channelId != null) {
            channel = this.channelsStore.getChannel(channelId.longValue());
        } else {
            channel = null;
        }
        if (zCanShareEvent$default) {
            Observable<Channel> observableZ = StoreStream.INSTANCE.getChannels().observeDefaultChannel(guildId).z();
            Intrinsics3.checkNotNullExpressionValue(observableZ, "StoreStream.getChannels(…ildId)\n          .first()");
            ObservableExtensionsKt.appSubscribe$default(observableZ, GuildScheduledEventListViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(weakFragment, channel, id2), 62, (Object) null);
        } else {
            Context context = weakContext.get();
            if (context != null) {
                CharSequence eventDetailsUrl = GuildScheduledEventUrlUtils.INSTANCE.getEventDetailsUrl(guildId, id2);
                Intrinsics3.checkNotNullExpressionValue(context, "context");
                AppToast.c(context, eventDetailsUrl, 0, 4);
            }
        }
    }

    public final void toggleRsvp(GuildScheduledEvent guildScheduledEvent) {
        Intrinsics3.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
        this.guildScheduledEventsStore.toggleMeRsvpForEvent(guildScheduledEvent);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildScheduledEventListViewModel(long j, Long l, StoreGuildScheduledEvents storeGuildScheduledEvents, StoreChannels storeChannels, StorePermissions storePermissions, StoreGuilds storeGuilds, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreUser storeUser, Observable<StoreState> observable) {
        super(ViewState.Initial.INSTANCE);
        Intrinsics3.checkNotNullParameter(storeGuildScheduledEvents, "guildScheduledEventsStore");
        Intrinsics3.checkNotNullParameter(storeChannels, "channelsStore");
        Intrinsics3.checkNotNullParameter(storePermissions, "permissionsStore");
        Intrinsics3.checkNotNullParameter(storeGuilds, "guildsStore");
        Intrinsics3.checkNotNullParameter(storeVoiceChannelSelected, "voiceChannelSelectedStore");
        Intrinsics3.checkNotNullParameter(storeUser, "userStore");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.guildId = j;
        this.channelId = l;
        this.guildScheduledEventsStore = storeGuildScheduledEvents;
        this.channelsStore = storeChannels;
        this.permissionsStore = storePermissions;
        this.guildsStore = storeGuilds;
        this.voiceChannelSelectedStore = storeVoiceChannelSelected;
        this.userStore = storeUser;
        storeGuildScheduledEvents.fetchGuildScheduledEventUserCounts(j);
        storeGuildScheduledEvents.fetchMeGuildScheduledEvents(j);
        storeGuildScheduledEvents.ackGuildEvents(j);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), GuildScheduledEventListViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }
}
