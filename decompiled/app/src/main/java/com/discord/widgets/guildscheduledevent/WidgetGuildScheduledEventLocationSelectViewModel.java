package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.GuildFeature;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityMetadata;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityType;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuildScheduledEvents;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities2;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities5;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.p.Schedulers2;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: WidgetGuildScheduledEventLocationSelectViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 12\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003123Bk\u0012\n\u0010&\u001a\u00060\u0010j\u0002`%\u0012\u000e\u0010\u001c\u001a\n\u0018\u00010\u0010j\u0004\u0018\u0001`\u0011\u0012\u000e\u0010\u001a\u001a\n\u0018\u00010\u0010j\u0004\u0018\u0001`\u0019\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001d\u0012\b\b\u0002\u0010(\u001a\u00020'\u0012\b\b\u0002\u0010*\u001a\u00020)\u0012\b\b\u0002\u0010,\u001a\u00020+\u0012\u000e\b\u0002\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00030-¢\u0006\u0004\b/\u00100J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0013\u001a\u00020\u00052\n\u0010\u0012\u001a\u00060\u0010j\u0002`\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018R\u001e\u0010\u001a\u001a\n\u0018\u00010\u0010j\u0004\u0018\u0001`\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\n\u0018\u00010\u0010j\u0004\u0018\u0001`\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR$\u0010 \u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010\u0007¨\u00064"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/WidgetGuildScheduledEventLocationSelectViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/guildscheduledevent/WidgetGuildScheduledEventLocationSelectViewModel$ViewState;", "Lcom/discord/widgets/guildscheduledevent/WidgetGuildScheduledEventLocationSelectViewModel$StoreState;", "storeState", "", "handleStoreState", "(Lcom/discord/widgets/guildscheduledevent/WidgetGuildScheduledEventLocationSelectViewModel$StoreState;)V", "Lcom/discord/api/channel/Channel;", "channel", "Lcom/discord/api/guildscheduledevent/GuildScheduledEventEntityType;", "getEntityTypeForChannel", "(Lcom/discord/api/channel/Channel;)Lcom/discord/api/guildscheduledevent/GuildScheduledEventEntityType;", "locationOption", "selectLocationOption", "(Lcom/discord/api/guildscheduledevent/GuildScheduledEventEntityType;)V", "", "Lcom/discord/primitives/ChannelId;", "channelId", "selectChannel", "(J)V", "", "newExternalLocation", "setExternalLocation", "(Ljava/lang/String;)V", "Lcom/discord/primitives/GuildScheduledEventId;", "existingGuildScheduledEventId", "Ljava/lang/Long;", "initialChannelId", "Lcom/discord/stores/StoreChannels;", "channelsStore", "Lcom/discord/stores/StoreChannels;", "currentStoreState", "Lcom/discord/widgets/guildscheduledevent/WidgetGuildScheduledEventLocationSelectViewModel$StoreState;", "getCurrentStoreState", "()Lcom/discord/widgets/guildscheduledevent/WidgetGuildScheduledEventLocationSelectViewModel$StoreState;", "setCurrentStoreState", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/stores/StoreGuilds;", "guildsStore", "Lcom/discord/stores/StorePermissions;", "permissionsStore", "Lcom/discord/stores/StoreGuildScheduledEvents;", "guildScheduledEventsStore", "Lrx/Observable;", "storeStateObservable", "<init>", "(JLjava/lang/Long;Ljava/lang/Long;Lcom/discord/stores/StoreChannels;Lcom/discord/stores/StoreGuilds;Lcom/discord/stores/StorePermissions;Lcom/discord/stores/StoreGuildScheduledEvents;Lrx/Observable;)V", "Companion", "StoreState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetGuildScheduledEventLocationSelectViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final StoreChannels channelsStore;
    private StoreState currentStoreState;
    private final Long existingGuildScheduledEventId;
    private final Long initialChannelId;

    /* compiled from: WidgetGuildScheduledEventLocationSelectViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/WidgetGuildScheduledEventLocationSelectViewModel$StoreState;", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Lcom/discord/widgets/guildscheduledevent/WidgetGuildScheduledEventLocationSelectViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventLocationSelectViewModel$1, reason: invalid class name */
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
            WidgetGuildScheduledEventLocationSelectViewModel widgetGuildScheduledEventLocationSelectViewModel = WidgetGuildScheduledEventLocationSelectViewModel.this;
            Intrinsics3.checkNotNullExpressionValue(storeState, "it");
            WidgetGuildScheduledEventLocationSelectViewModel.access$handleStoreState(widgetGuildScheduledEventLocationSelectViewModel, storeState);
        }
    }

    /* compiled from: WidgetGuildScheduledEventLocationSelectViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014JQ\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u000e\u0010\u0006\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/WidgetGuildScheduledEventLocationSelectViewModel$Companion;", "", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/primitives/GuildScheduledEventId;", "existingGuildScheduledEventId", "Lcom/discord/stores/StoreGuilds;", "guildsStore", "Lcom/discord/stores/StoreChannels;", "channelsStore", "Lcom/discord/stores/StorePermissions;", "permissionsStore", "Lcom/discord/stores/StoreGuildScheduledEvents;", "guildScheduledEventsStore", "Lrx/Observable;", "Lcom/discord/widgets/guildscheduledevent/WidgetGuildScheduledEventLocationSelectViewModel$StoreState;", "observeStores", "(JLjava/lang/Long;Lcom/discord/stores/StoreGuilds;Lcom/discord/stores/StoreChannels;Lcom/discord/stores/StorePermissions;Lcom/discord/stores/StoreGuildScheduledEvents;)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStores(Companion companion, long j, Long l, StoreGuilds storeGuilds, StoreChannels storeChannels, StorePermissions storePermissions, StoreGuildScheduledEvents storeGuildScheduledEvents) {
            return companion.observeStores(j, l, storeGuilds, storeChannels, storePermissions, storeGuildScheduledEvents);
        }

        private final Observable<StoreState> observeStores(long guildId, Long existingGuildScheduledEventId, StoreGuilds guildsStore, StoreChannels channelsStore, StorePermissions permissionsStore, StoreGuildScheduledEvents guildScheduledEventsStore) {
            return ObservationDeck.connectRx$default(ObservationDeck4.get(), new ObservationDeck.UpdateSource[]{channelsStore, permissionsStore}, false, null, null, new WidgetGuildScheduledEventLocationSelectViewModel2(guildsStore, guildId, channelsStore, permissionsStore, existingGuildScheduledEventId, guildScheduledEventsStore), 14, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetGuildScheduledEventLocationSelectViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\u0016\u0010\u0013\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u0005\u0012\u001a\u0010\u0014\u001a\u0016\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\b\u0012\u00060\u0006j\u0002`\u000b0\u0005\u0012\u000e\u0010\u0015\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u000b\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b,\u0010-J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ$\u0010\f\u001a\u0016\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\b\u0012\u00060\u0006j\u0002`\u000b0\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\nJ\u0018\u0010\r\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011Jr\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0018\b\u0002\u0010\u0013\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u00052\u001c\b\u0002\u0010\u0014\u001a\u0016\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\b\u0012\u00060\u0006j\u0002`\u000b0\u00052\u0010\b\u0002\u0010\u0015\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u000b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000fHÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010!\u001a\u00020 2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b!\u0010\"R)\u0010\u0013\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010#\u001a\u0004\b$\u0010\nR\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010%\u001a\u0004\b&\u0010\u0004R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010'\u001a\u0004\b(\u0010\u0011R!\u0010\u0015\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010)\u001a\u0004\b*\u0010\u000eR-\u0010\u0014\u001a\u0016\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\b\u0012\u00060\u0006j\u0002`\u000b0\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010#\u001a\u0004\b+\u0010\n¨\u0006."}, d2 = {"Lcom/discord/widgets/guildscheduledevent/WidgetGuildScheduledEventLocationSelectViewModel$StoreState;", "", "Lcom/discord/models/guild/Guild;", "component1", "()Lcom/discord/models/guild/Guild;", "", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/channel/Channel;", "component2", "()Ljava/util/Map;", "Lcom/discord/api/permission/PermissionBit;", "component3", "component4", "()Ljava/lang/Long;", "Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "component5", "()Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "guild", "channels", "channelPermissions", "guildPermissions", "existingGuildScheduledEvent", "copy", "(Lcom/discord/models/guild/Guild;Ljava/util/Map;Ljava/util/Map;Ljava/lang/Long;Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;)Lcom/discord/widgets/guildscheduledevent/WidgetGuildScheduledEventLocationSelectViewModel$StoreState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Map;", "getChannels", "Lcom/discord/models/guild/Guild;", "getGuild", "Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "getExistingGuildScheduledEvent", "Ljava/lang/Long;", "getGuildPermissions", "getChannelPermissions", "<init>", "(Lcom/discord/models/guild/Guild;Ljava/util/Map;Ljava/util/Map;Ljava/lang/Long;Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class StoreState {
        private final Map<Long, Long> channelPermissions;
        private final Map<Long, Channel> channels;
        private final GuildScheduledEvent existingGuildScheduledEvent;
        private final Guild guild;
        private final Long guildPermissions;

        public StoreState(Guild guild, Map<Long, Channel> map, Map<Long, Long> map2, Long l, GuildScheduledEvent guildScheduledEvent) {
            Intrinsics3.checkNotNullParameter(map, "channels");
            Intrinsics3.checkNotNullParameter(map2, "channelPermissions");
            this.guild = guild;
            this.channels = map;
            this.channelPermissions = map2;
            this.guildPermissions = l;
            this.existingGuildScheduledEvent = guildScheduledEvent;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, Guild guild, Map map, Map map2, Long l, GuildScheduledEvent guildScheduledEvent, int i, Object obj) {
            if ((i & 1) != 0) {
                guild = storeState.guild;
            }
            if ((i & 2) != 0) {
                map = storeState.channels;
            }
            Map map3 = map;
            if ((i & 4) != 0) {
                map2 = storeState.channelPermissions;
            }
            Map map4 = map2;
            if ((i & 8) != 0) {
                l = storeState.guildPermissions;
            }
            Long l2 = l;
            if ((i & 16) != 0) {
                guildScheduledEvent = storeState.existingGuildScheduledEvent;
            }
            return storeState.copy(guild, map3, map4, l2, guildScheduledEvent);
        }

        /* renamed from: component1, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        public final Map<Long, Channel> component2() {
            return this.channels;
        }

        public final Map<Long, Long> component3() {
            return this.channelPermissions;
        }

        /* renamed from: component4, reason: from getter */
        public final Long getGuildPermissions() {
            return this.guildPermissions;
        }

        /* renamed from: component5, reason: from getter */
        public final GuildScheduledEvent getExistingGuildScheduledEvent() {
            return this.existingGuildScheduledEvent;
        }

        public final StoreState copy(Guild guild, Map<Long, Channel> channels, Map<Long, Long> channelPermissions, Long guildPermissions, GuildScheduledEvent existingGuildScheduledEvent) {
            Intrinsics3.checkNotNullParameter(channels, "channels");
            Intrinsics3.checkNotNullParameter(channelPermissions, "channelPermissions");
            return new StoreState(guild, channels, channelPermissions, guildPermissions, existingGuildScheduledEvent);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.guild, storeState.guild) && Intrinsics3.areEqual(this.channels, storeState.channels) && Intrinsics3.areEqual(this.channelPermissions, storeState.channelPermissions) && Intrinsics3.areEqual(this.guildPermissions, storeState.guildPermissions) && Intrinsics3.areEqual(this.existingGuildScheduledEvent, storeState.existingGuildScheduledEvent);
        }

        public final Map<Long, Long> getChannelPermissions() {
            return this.channelPermissions;
        }

        public final Map<Long, Channel> getChannels() {
            return this.channels;
        }

        public final GuildScheduledEvent getExistingGuildScheduledEvent() {
            return this.existingGuildScheduledEvent;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final Long getGuildPermissions() {
            return this.guildPermissions;
        }

        public int hashCode() {
            Guild guild = this.guild;
            int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
            Map<Long, Channel> map = this.channels;
            int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
            Map<Long, Long> map2 = this.channelPermissions;
            int iHashCode3 = (iHashCode2 + (map2 != null ? map2.hashCode() : 0)) * 31;
            Long l = this.guildPermissions;
            int iHashCode4 = (iHashCode3 + (l != null ? l.hashCode() : 0)) * 31;
            GuildScheduledEvent guildScheduledEvent = this.existingGuildScheduledEvent;
            return iHashCode4 + (guildScheduledEvent != null ? guildScheduledEvent.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(guild=");
            sbU.append(this.guild);
            sbU.append(", channels=");
            sbU.append(this.channels);
            sbU.append(", channelPermissions=");
            sbU.append(this.channelPermissions);
            sbU.append(", guildPermissions=");
            sbU.append(this.guildPermissions);
            sbU.append(", existingGuildScheduledEvent=");
            sbU.append(this.existingGuildScheduledEvent);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: WidgetGuildScheduledEventLocationSelectViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/WidgetGuildScheduledEventLocationSelectViewModel$ViewState;", "", "<init>", "()V", "Invalid", "Valid", "Lcom/discord/widgets/guildscheduledevent/WidgetGuildScheduledEventLocationSelectViewModel$ViewState$Invalid;", "Lcom/discord/widgets/guildscheduledevent/WidgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        /* compiled from: WidgetGuildScheduledEventLocationSelectViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/WidgetGuildScheduledEventLocationSelectViewModel$ViewState$Invalid;", "Lcom/discord/widgets/guildscheduledevent/WidgetGuildScheduledEventLocationSelectViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Invalid extends ViewState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* compiled from: WidgetGuildScheduledEventLocationSelectViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001Bu\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u001b\u001a\u00020\b\u0012\u0016\u0010\u001c\u001a\u0012\u0012\b\u0012\u00060\fj\u0002`\r\u0012\u0004\u0012\u00020\u00050\u000b\u0012\u0010\u0010\u001d\u001a\f\u0012\b\u0012\u00060\fj\u0002`\r0\u0010\u0012\u0010\u0010\u001e\u001a\f\u0012\b\u0012\u00060\fj\u0002`\r0\u0010\u0012\u0006\u0010\u001f\u001a\u00020\u0014\u0012\u0006\u0010 \u001a\u00020\u0014\u0012\u0006\u0010!\u001a\u00020\u0014¢\u0006\u0004\b;\u0010<J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ \u0010\u000e\u001a\u0012\u0012\b\u0012\u00060\fj\u0002`\r\u0012\u0004\u0012\u00020\u00050\u000bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\f\u0012\b\u0012\u00060\fj\u0002`\r0\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0013\u001a\f\u0012\b\u0012\u00060\fj\u0002`\r0\u0010HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0012J\u0010\u0010\u0015\u001a\u00020\u0014HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0014HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0014HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0016J\u0090\u0001\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0019\u001a\u00020\u00022\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u001b\u001a\u00020\b2\u0018\b\u0002\u0010\u001c\u001a\u0012\u0012\b\u0012\u00060\fj\u0002`\r\u0012\u0004\u0012\u00020\u00050\u000b2\u0012\b\u0002\u0010\u001d\u001a\f\u0012\b\u0012\u00060\fj\u0002`\r0\u00102\u0012\b\u0002\u0010\u001e\u001a\f\u0012\b\u0012\u00060\fj\u0002`\r0\u00102\b\b\u0002\u0010\u001f\u001a\u00020\u00142\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\u0014HÆ\u0001¢\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b$\u0010\nJ\u0010\u0010&\u001a\u00020%HÖ\u0001¢\u0006\u0004\b&\u0010'J\u001a\u0010*\u001a\u00020\u00142\b\u0010)\u001a\u0004\u0018\u00010(HÖ\u0003¢\u0006\u0004\b*\u0010+R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010,\u001a\u0004\b-\u0010\u0007R\u0019\u0010\u001b\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010.\u001a\u0004\b/\u0010\nR\u0019\u0010!\u001a\u00020\u00148\u0006@\u0006¢\u0006\f\n\u0004\b!\u00100\u001a\u0004\b1\u0010\u0016R)\u0010\u001c\u001a\u0012\u0012\b\u0012\u00060\fj\u0002`\r\u0012\u0004\u0012\u00020\u00050\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u00102\u001a\u0004\b3\u0010\u000fR\u0019\u0010\u0019\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u00104\u001a\u0004\b5\u0010\u0004R\u0019\u0010 \u001a\u00020\u00148\u0006@\u0006¢\u0006\f\n\u0004\b \u00100\u001a\u0004\b6\u0010\u0016R#\u0010\u001e\u001a\f\u0012\b\u0012\u00060\fj\u0002`\r0\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u00107\u001a\u0004\b8\u0010\u0012R#\u0010\u001d\u001a\f\u0012\b\u0012\u00060\fj\u0002`\r0\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u00107\u001a\u0004\b9\u0010\u0012R\u0019\u0010\u001f\u001a\u00020\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u00100\u001a\u0004\b:\u0010\u0016¨\u0006="}, d2 = {"Lcom/discord/widgets/guildscheduledevent/WidgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid;", "Lcom/discord/widgets/guildscheduledevent/WidgetGuildScheduledEventLocationSelectViewModel$ViewState;", "Lcom/discord/api/guildscheduledevent/GuildScheduledEventEntityType;", "component1", "()Lcom/discord/api/guildscheduledevent/GuildScheduledEventEntityType;", "Lcom/discord/api/channel/Channel;", "component2", "()Lcom/discord/api/channel/Channel;", "", "component3", "()Ljava/lang/String;", "", "", "Lcom/discord/primitives/ChannelId;", "component4", "()Ljava/util/Map;", "", "component5", "()Ljava/util/Set;", "component6", "", "component7", "()Z", "component8", "component9", "selectedLocationOption", "selectedChannel", "externalLocation", "availableChannels", "availableVoiceChannelIds", "availableStageChannelIds", "canCreateExternalEvent", "showStageOptionIfUnavailable", "canChangeChannel", "copy", "(Lcom/discord/api/guildscheduledevent/GuildScheduledEventEntityType;Lcom/discord/api/channel/Channel;Ljava/lang/String;Ljava/util/Map;Ljava/util/Set;Ljava/util/Set;ZZZ)Lcom/discord/widgets/guildscheduledevent/WidgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/channel/Channel;", "getSelectedChannel", "Ljava/lang/String;", "getExternalLocation", "Z", "getCanChangeChannel", "Ljava/util/Map;", "getAvailableChannels", "Lcom/discord/api/guildscheduledevent/GuildScheduledEventEntityType;", "getSelectedLocationOption", "getShowStageOptionIfUnavailable", "Ljava/util/Set;", "getAvailableStageChannelIds", "getAvailableVoiceChannelIds", "getCanCreateExternalEvent", "<init>", "(Lcom/discord/api/guildscheduledevent/GuildScheduledEventEntityType;Lcom/discord/api/channel/Channel;Ljava/lang/String;Ljava/util/Map;Ljava/util/Set;Ljava/util/Set;ZZZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Valid extends ViewState {
            private final Map<Long, Channel> availableChannels;
            private final Set<Long> availableStageChannelIds;
            private final Set<Long> availableVoiceChannelIds;
            private final boolean canChangeChannel;
            private final boolean canCreateExternalEvent;
            private final String externalLocation;
            private final Channel selectedChannel;
            private final GuildScheduledEventEntityType selectedLocationOption;
            private final boolean showStageOptionIfUnavailable;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Valid(GuildScheduledEventEntityType guildScheduledEventEntityType, Channel channel, String str, Map<Long, Channel> map, Set<Long> set, Set<Long> set2, boolean z2, boolean z3, boolean z4) {
                super(null);
                Intrinsics3.checkNotNullParameter(guildScheduledEventEntityType, "selectedLocationOption");
                Intrinsics3.checkNotNullParameter(str, "externalLocation");
                Intrinsics3.checkNotNullParameter(map, "availableChannels");
                Intrinsics3.checkNotNullParameter(set, "availableVoiceChannelIds");
                Intrinsics3.checkNotNullParameter(set2, "availableStageChannelIds");
                this.selectedLocationOption = guildScheduledEventEntityType;
                this.selectedChannel = channel;
                this.externalLocation = str;
                this.availableChannels = map;
                this.availableVoiceChannelIds = set;
                this.availableStageChannelIds = set2;
                this.canCreateExternalEvent = z2;
                this.showStageOptionIfUnavailable = z3;
                this.canChangeChannel = z4;
            }

            public static /* synthetic */ Valid copy$default(Valid valid, GuildScheduledEventEntityType guildScheduledEventEntityType, Channel channel, String str, Map map, Set set, Set set2, boolean z2, boolean z3, boolean z4, int i, Object obj) {
                return valid.copy((i & 1) != 0 ? valid.selectedLocationOption : guildScheduledEventEntityType, (i & 2) != 0 ? valid.selectedChannel : channel, (i & 4) != 0 ? valid.externalLocation : str, (i & 8) != 0 ? valid.availableChannels : map, (i & 16) != 0 ? valid.availableVoiceChannelIds : set, (i & 32) != 0 ? valid.availableStageChannelIds : set2, (i & 64) != 0 ? valid.canCreateExternalEvent : z2, (i & 128) != 0 ? valid.showStageOptionIfUnavailable : z3, (i & 256) != 0 ? valid.canChangeChannel : z4);
            }

            /* renamed from: component1, reason: from getter */
            public final GuildScheduledEventEntityType getSelectedLocationOption() {
                return this.selectedLocationOption;
            }

            /* renamed from: component2, reason: from getter */
            public final Channel getSelectedChannel() {
                return this.selectedChannel;
            }

            /* renamed from: component3, reason: from getter */
            public final String getExternalLocation() {
                return this.externalLocation;
            }

            public final Map<Long, Channel> component4() {
                return this.availableChannels;
            }

            public final Set<Long> component5() {
                return this.availableVoiceChannelIds;
            }

            public final Set<Long> component6() {
                return this.availableStageChannelIds;
            }

            /* renamed from: component7, reason: from getter */
            public final boolean getCanCreateExternalEvent() {
                return this.canCreateExternalEvent;
            }

            /* renamed from: component8, reason: from getter */
            public final boolean getShowStageOptionIfUnavailable() {
                return this.showStageOptionIfUnavailable;
            }

            /* renamed from: component9, reason: from getter */
            public final boolean getCanChangeChannel() {
                return this.canChangeChannel;
            }

            public final Valid copy(GuildScheduledEventEntityType selectedLocationOption, Channel selectedChannel, String externalLocation, Map<Long, Channel> availableChannels, Set<Long> availableVoiceChannelIds, Set<Long> availableStageChannelIds, boolean canCreateExternalEvent, boolean showStageOptionIfUnavailable, boolean canChangeChannel) {
                Intrinsics3.checkNotNullParameter(selectedLocationOption, "selectedLocationOption");
                Intrinsics3.checkNotNullParameter(externalLocation, "externalLocation");
                Intrinsics3.checkNotNullParameter(availableChannels, "availableChannels");
                Intrinsics3.checkNotNullParameter(availableVoiceChannelIds, "availableVoiceChannelIds");
                Intrinsics3.checkNotNullParameter(availableStageChannelIds, "availableStageChannelIds");
                return new Valid(selectedLocationOption, selectedChannel, externalLocation, availableChannels, availableVoiceChannelIds, availableStageChannelIds, canCreateExternalEvent, showStageOptionIfUnavailable, canChangeChannel);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Valid)) {
                    return false;
                }
                Valid valid = (Valid) other;
                return Intrinsics3.areEqual(this.selectedLocationOption, valid.selectedLocationOption) && Intrinsics3.areEqual(this.selectedChannel, valid.selectedChannel) && Intrinsics3.areEqual(this.externalLocation, valid.externalLocation) && Intrinsics3.areEqual(this.availableChannels, valid.availableChannels) && Intrinsics3.areEqual(this.availableVoiceChannelIds, valid.availableVoiceChannelIds) && Intrinsics3.areEqual(this.availableStageChannelIds, valid.availableStageChannelIds) && this.canCreateExternalEvent == valid.canCreateExternalEvent && this.showStageOptionIfUnavailable == valid.showStageOptionIfUnavailable && this.canChangeChannel == valid.canChangeChannel;
            }

            public final Map<Long, Channel> getAvailableChannels() {
                return this.availableChannels;
            }

            public final Set<Long> getAvailableStageChannelIds() {
                return this.availableStageChannelIds;
            }

            public final Set<Long> getAvailableVoiceChannelIds() {
                return this.availableVoiceChannelIds;
            }

            public final boolean getCanChangeChannel() {
                return this.canChangeChannel;
            }

            public final boolean getCanCreateExternalEvent() {
                return this.canCreateExternalEvent;
            }

            public final String getExternalLocation() {
                return this.externalLocation;
            }

            public final Channel getSelectedChannel() {
                return this.selectedChannel;
            }

            public final GuildScheduledEventEntityType getSelectedLocationOption() {
                return this.selectedLocationOption;
            }

            public final boolean getShowStageOptionIfUnavailable() {
                return this.showStageOptionIfUnavailable;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                GuildScheduledEventEntityType guildScheduledEventEntityType = this.selectedLocationOption;
                int iHashCode = (guildScheduledEventEntityType != null ? guildScheduledEventEntityType.hashCode() : 0) * 31;
                Channel channel = this.selectedChannel;
                int iHashCode2 = (iHashCode + (channel != null ? channel.hashCode() : 0)) * 31;
                String str = this.externalLocation;
                int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
                Map<Long, Channel> map = this.availableChannels;
                int iHashCode4 = (iHashCode3 + (map != null ? map.hashCode() : 0)) * 31;
                Set<Long> set = this.availableVoiceChannelIds;
                int iHashCode5 = (iHashCode4 + (set != null ? set.hashCode() : 0)) * 31;
                Set<Long> set2 = this.availableStageChannelIds;
                int iHashCode6 = (iHashCode5 + (set2 != null ? set2.hashCode() : 0)) * 31;
                boolean z2 = this.canCreateExternalEvent;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iHashCode6 + i) * 31;
                boolean z3 = this.showStageOptionIfUnavailable;
                int i3 = z3;
                if (z3 != 0) {
                    i3 = 1;
                }
                int i4 = (i2 + i3) * 31;
                boolean z4 = this.canChangeChannel;
                return i4 + (z4 ? 1 : z4 ? 1 : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Valid(selectedLocationOption=");
                sbU.append(this.selectedLocationOption);
                sbU.append(", selectedChannel=");
                sbU.append(this.selectedChannel);
                sbU.append(", externalLocation=");
                sbU.append(this.externalLocation);
                sbU.append(", availableChannels=");
                sbU.append(this.availableChannels);
                sbU.append(", availableVoiceChannelIds=");
                sbU.append(this.availableVoiceChannelIds);
                sbU.append(", availableStageChannelIds=");
                sbU.append(this.availableStageChannelIds);
                sbU.append(", canCreateExternalEvent=");
                sbU.append(this.canCreateExternalEvent);
                sbU.append(", showStageOptionIfUnavailable=");
                sbU.append(this.showStageOptionIfUnavailable);
                sbU.append(", canChangeChannel=");
                return outline.O(sbU, this.canChangeChannel, ")");
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetGuildScheduledEventLocationSelectViewModel(long j, Long l, Long l2, StoreChannels storeChannels, StoreGuilds storeGuilds, StorePermissions storePermissions, StoreGuildScheduledEvents storeGuildScheduledEvents, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        StoreChannels channels = (i & 8) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels;
        StoreGuilds guilds = (i & 16) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds;
        StorePermissions permissions = (i & 32) != 0 ? StoreStream.INSTANCE.getPermissions() : storePermissions;
        StoreGuildScheduledEvents guildScheduledEvents = (i & 64) != 0 ? StoreStream.INSTANCE.getGuildScheduledEvents() : storeGuildScheduledEvents;
        this(j, l, l2, channels, guilds, permissions, guildScheduledEvents, (i & 128) != 0 ? Companion.access$observeStores(INSTANCE, j, l2, guilds, channels, permissions, guildScheduledEvents) : observable);
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetGuildScheduledEventLocationSelectViewModel widgetGuildScheduledEventLocationSelectViewModel, StoreState storeState) {
        widgetGuildScheduledEventLocationSelectViewModel.handleStoreState(storeState);
    }

    private final GuildScheduledEventEntityType getEntityTypeForChannel(Channel channel) {
        return channel == null ? GuildScheduledEventEntityType.NONE : ChannelUtils.J(channel) ? GuildScheduledEventEntityType.VOICE : ChannelUtils.D(channel) ? GuildScheduledEventEntityType.STAGE_INSTANCE : GuildScheduledEventEntityType.NONE;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x014f  */
    @MainThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void handleStoreState(StoreState storeState) {
        Long channelId;
        GuildScheduledEvent existingGuildScheduledEvent;
        GuildScheduledEventEntityMetadata entityMetadata;
        boolean z2;
        Set<GuildFeature> features;
        this.currentStoreState = storeState;
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Valid)) {
            viewState = null;
        }
        ViewState.Valid valid = (ViewState.Valid) viewState;
        boolean zCanCreateExternalEvent = GuildScheduledEventUtilities.INSTANCE.canCreateExternalEvent(storeState.getGuildPermissions());
        Map<Long, Channel> channels = storeState.getChannels();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<Long, Channel> entry : channels.entrySet()) {
            Channel value = entry.getValue();
            if (GuildScheduledEventUtilities.INSTANCE.canStartEventInChannel(value, (Long) outline.d(value, storeState.getChannelPermissions()))) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (Channel channel : linkedHashMap.values()) {
            if (ChannelUtils.J(channel)) {
                hashSet2.add(Long.valueOf(channel.getId()));
            } else if (ChannelUtils.D(channel)) {
                hashSet.add(Long.valueOf(channel.getId()));
            }
        }
        boolean z3 = this.existingGuildScheduledEventId != null;
        if (valid != null) {
            Channel selectedChannel = valid.getSelectedChannel();
            channelId = selectedChannel != null ? Long.valueOf(selectedChannel.getId()) : null;
        } else if (z3) {
            GuildScheduledEvent existingGuildScheduledEvent2 = storeState.getExistingGuildScheduledEvent();
            if (existingGuildScheduledEvent2 != null) {
                channelId = existingGuildScheduledEvent2.getChannelId();
            }
        } else {
            channelId = this.initialChannelId;
        }
        Channel channel2 = (Channel) linkedHashMap.get(channelId);
        GuildScheduledEventEntityType selectedLocationOption = valid != null ? valid.getSelectedLocationOption() : storeState.getExistingGuildScheduledEvent() != null ? storeState.getExistingGuildScheduledEvent().getEntityType() : getEntityTypeForChannel(channel2);
        if (selectedLocationOption == GuildScheduledEventEntityType.STAGE_INSTANCE && hashSet.isEmpty()) {
            selectedLocationOption = GuildScheduledEventEntityType.NONE;
        } else if (selectedLocationOption == GuildScheduledEventEntityType.VOICE && hashSet2.isEmpty()) {
            selectedLocationOption = GuildScheduledEventEntityType.NONE;
        } else if (selectedLocationOption == GuildScheduledEventEntityType.EXTERNAL && !zCanCreateExternalEvent) {
            selectedLocationOption = GuildScheduledEventEntityType.NONE;
        }
        GuildScheduledEventEntityType guildScheduledEventEntityType = selectedLocationOption;
        Guild guild = storeState.getGuild();
        boolean zContains = (guild == null || (features = guild.getFeatures()) == null) ? false : features.contains(GuildFeature.COMMUNITY);
        String externalLocation = valid != null ? valid.getExternalLocation() : (!z3 || channelId != null || (existingGuildScheduledEvent = storeState.getExistingGuildScheduledEvent()) == null || (entityMetadata = existingGuildScheduledEvent.getEntityMetadata()) == null) ? null : entityMetadata.getLocation();
        if (z3) {
            GuildScheduledEvent existingGuildScheduledEvent3 = storeState.getExistingGuildScheduledEvent();
            z2 = (existingGuildScheduledEvent3 != null ? GuildScheduledEventUtilities5.getEventTiming(existingGuildScheduledEvent3) : null) != GuildScheduledEventUtilities2.LIVE;
        }
        if (externalLocation == null) {
            externalLocation = "";
        }
        updateViewState(new ViewState.Valid(guildScheduledEventEntityType, channel2, externalLocation, linkedHashMap, hashSet2, hashSet, zCanCreateExternalEvent, zContains, z2));
    }

    public final StoreState getCurrentStoreState() {
        return this.currentStoreState;
    }

    public final void selectChannel(long channelId) {
        StoreState storeState;
        Map<Long, Channel> channels;
        Channel channel;
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Valid) || (storeState = this.currentStoreState) == null || (channels = storeState.getChannels()) == null || (channel = channels.get(Long.valueOf(channelId))) == null) {
            return;
        }
        updateViewState(ViewState.Valid.copy$default((ViewState.Valid) viewState, null, channel, null, null, null, null, false, false, false, 509, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void selectLocationOption(GuildScheduledEventEntityType locationOption) {
        Channel channel;
        Channel channel2;
        Map<Long, Channel> channels;
        Intrinsics3.checkNotNullParameter(locationOption, "locationOption");
        ViewState viewState = getViewState();
        if (viewState instanceof ViewState.Valid) {
            ViewState.Valid valid = (ViewState.Valid) viewState;
            if (locationOption == valid.getSelectedLocationOption()) {
                return;
            }
            Long l = this.initialChannelId;
            Channel channel3 = null;
            if (l != null) {
                l.longValue();
                StoreState storeState = this.currentStoreState;
                channel = (storeState == null || (channels = storeState.getChannels()) == null) ? null : channels.get(this.initialChannelId);
            }
            GuildScheduledEventEntityType guildScheduledEventEntityType = GuildScheduledEventEntityType.VOICE;
            if (locationOption == guildScheduledEventEntityType && channel != null && channel.getType() == 2) {
                channel2 = channel;
            } else {
                if (locationOption == guildScheduledEventEntityType) {
                    Iterator<T> it = valid.getAvailableChannels().values().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Object next = it.next();
                        if (((Channel) next).getType() == 2) {
                            channel3 = next;
                            break;
                        }
                    }
                    channel3 = channel3;
                } else {
                    GuildScheduledEventEntityType guildScheduledEventEntityType2 = GuildScheduledEventEntityType.STAGE_INSTANCE;
                    if (locationOption != guildScheduledEventEntityType2 || channel == null || channel.getType() != 13) {
                        if (locationOption == guildScheduledEventEntityType2) {
                            Iterator<T> it2 = valid.getAvailableChannels().values().iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                }
                                Object next2 = it2.next();
                                if (((Channel) next2).getType() == 13) {
                                    channel3 = next2;
                                    break;
                                }
                            }
                            channel3 = channel3;
                        }
                    }
                    channel2 = channel;
                }
                channel2 = channel3;
            }
            updateViewState(ViewState.Valid.copy$default(valid, locationOption, channel2, "", null, null, null, false, false, false, 504, null));
        }
    }

    public final void setCurrentStoreState(StoreState storeState) {
        this.currentStoreState = storeState;
    }

    public final void setExternalLocation(String newExternalLocation) {
        Intrinsics3.checkNotNullParameter(newExternalLocation, "newExternalLocation");
        ViewState viewState = getViewState();
        if (viewState instanceof ViewState.Valid) {
            updateViewState(ViewState.Valid.copy$default((ViewState.Valid) viewState, null, null, newExternalLocation, null, null, null, false, false, false, 507, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildScheduledEventLocationSelectViewModel(long j, Long l, Long l2, StoreChannels storeChannels, StoreGuilds storeGuilds, StorePermissions storePermissions, StoreGuildScheduledEvents storeGuildScheduledEvents, Observable<StoreState> observable) {
        super(null, 1, null);
        Intrinsics3.checkNotNullParameter(storeChannels, "channelsStore");
        Intrinsics3.checkNotNullParameter(storeGuilds, "guildsStore");
        Intrinsics3.checkNotNullParameter(storePermissions, "permissionsStore");
        Intrinsics3.checkNotNullParameter(storeGuildScheduledEvents, "guildScheduledEventsStore");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.initialChannelId = l;
        this.existingGuildScheduledEventId = l2;
        this.channelsStore = storeChannels;
        Observable<StoreState> observableX = observable.X(Schedulers2.a());
        Intrinsics3.checkNotNullExpressionValue(observableX, "storeStateObservable\n   …Schedulers.computation())");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableX, this, null, 2, null), WidgetGuildScheduledEventLocationSelectViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
