package com.discord.widgets.announcements;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.permission.Permission;
import com.discord.app.AppComponent;
import com.discord.models.guild.Guild;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.Func5;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;

/* compiled from: WidgetChannelFollowSheetViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u00029:B=\u0012\n\u0010.\u001a\u00060\tj\u0002`\u0018\u0012\n\u00100\u001a\u00060\tj\u0002`\u0014\u0012\b\b\u0002\u0010*\u001a\u00020)\u0012\b\b\u0002\u0010%\u001a\u00020$\u0012\b\b\u0002\u00103\u001a\u000202¢\u0006\u0004\b7\u00108J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J)\u0010\f\u001a\u001c\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\b\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\f\u0010\u0007J\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0004¢\u0006\u0004\b\u0013\u0010\u0007J\u0019\u0010\u0016\u001a\u00020\u000f2\n\u0010\u0015\u001a\u00060\tj\u0002`\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u001a\u001a\u00020\u000f2\n\u0010\u0019\u001a\u00060\tj\u0002`\u0018¢\u0006\u0004\b\u001a\u0010\u0017J\u0019\u0010\u001c\u001a\u00020\u000f2\n\u0010\u001b\u001a\u00060\tj\u0002`\u0014¢\u0006\u0004\b\u001c\u0010\u0017RN\u0010\u001f\u001a:\u0012\u0016\u0012\u0014 \u001e*\n\u0018\u00010\tj\u0004\u0018\u0001`\u00140\tj\u0002`\u0014 \u001e*\u001c\u0012\u0016\u0012\u0014 \u001e*\n\u0018\u00010\tj\u0004\u0018\u0001`\u00140\tj\u0002`\u0014\u0018\u00010\u001d0\u001d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R:\u0010\"\u001a&\u0012\f\u0012\n \u001e*\u0004\u0018\u00010\u00120\u0012 \u001e*\u0012\u0012\f\u0012\n \u001e*\u0004\u0018\u00010\u00120\u0012\u0018\u00010!0!8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0019\u0010%\u001a\u00020$8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0019\u0010*\u001a\u00020)8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u001a\u0010.\u001a\u00060\tj\u0002`\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u001a\u00100\u001a\u00060\tj\u0002`\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u0010/RN\u00101\u001a:\u0012\u0016\u0012\u0014 \u001e*\n\u0018\u00010\tj\u0004\u0018\u0001`\u00180\tj\u0002`\u0018 \u001e*\u001c\u0012\u0016\u0012\u0014 \u001e*\n\u0018\u00010\tj\u0004\u0018\u0001`\u00180\tj\u0002`\u0018\u0018\u00010\u001d0\u001d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u0010 R\u0019\u00103\u001a\u0002028\u0006@\u0006¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106¨\u0006;"}, d2 = {"Lcom/discord/widgets/announcements/WidgetChannelFollowSheetViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/announcements/WidgetChannelFollowSheetViewModel$ViewState;", "Lcom/discord/app/AppComponent;", "Lrx/Observable;", "Lcom/discord/widgets/announcements/WidgetChannelFollowSheetViewModel$ViewState$Loaded;", "observeViewStateFromStores", "()Lrx/Observable;", "", "", "", "Lcom/discord/api/channel/Channel;", "calculateChannelsWithPermissions", "Lcom/discord/utilities/error/Error;", "error", "", "handleChannelFollowError", "(Lcom/discord/utilities/error/Error;)V", "Lcom/discord/widgets/announcements/WidgetChannelFollowSheetViewModel$Event;", "observeEvents", "Lcom/discord/primitives/ChannelId;", "channelId", "selectChannel", "(J)V", "Lcom/discord/primitives/GuildId;", "guildId", "selectGuild", "webhookChannelId", "followChannel", "Lrx/subjects/BehaviorSubject;", "kotlin.jvm.PlatformType", "selectedChannelSubject", "Lrx/subjects/BehaviorSubject;", "Lrx/subjects/PublishSubject;", "eventSubject", "Lrx/subjects/PublishSubject;", "Lcom/discord/stores/StoreChannels;", "storeChannels", "Lcom/discord/stores/StoreChannels;", "getStoreChannels", "()Lcom/discord/stores/StoreChannels;", "Lcom/discord/stores/StoreGuilds;", "storeGuilds", "Lcom/discord/stores/StoreGuilds;", "getStoreGuilds", "()Lcom/discord/stores/StoreGuilds;", "sourceGuildId", "J", "sourceChannelId", "selectedGuildSubject", "Lcom/discord/stores/StorePermissions;", "storePermissions", "Lcom/discord/stores/StorePermissions;", "getStorePermissions", "()Lcom/discord/stores/StorePermissions;", "<init>", "(JJLcom/discord/stores/StoreGuilds;Lcom/discord/stores/StoreChannels;Lcom/discord/stores/StorePermissions;)V", "Event", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChannelFollowSheetViewModel extends AppViewModel<ViewState> implements AppComponent {
    private final PublishSubject<Event> eventSubject;
    private final BehaviorSubject<Long> selectedChannelSubject;
    private final BehaviorSubject<Long> selectedGuildSubject;
    private final long sourceChannelId;
    private final long sourceGuildId;
    private final StoreChannels storeChannels;
    private final StoreGuilds storeGuilds;
    private final StorePermissions storePermissions;

    /* compiled from: WidgetChannelFollowSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/announcements/WidgetChannelFollowSheetViewModel$ViewState$Loaded;", "viewState", "", "invoke", "(Lcom/discord/widgets/announcements/WidgetChannelFollowSheetViewModel$ViewState$Loaded;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.announcements.WidgetChannelFollowSheetViewModel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<ViewState.Loaded, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ViewState.Loaded loaded) {
            invoke2(loaded);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ViewState.Loaded loaded) {
            Intrinsics3.checkNotNullParameter(loaded, "viewState");
            WidgetChannelFollowSheetViewModel.access$updateViewState(WidgetChannelFollowSheetViewModel.this, loaded);
        }
    }

    /* compiled from: WidgetChannelFollowSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/discord/widgets/announcements/WidgetChannelFollowSheetViewModel$Event;", "", "<init>", "()V", "FollowSuccess", "Lcom/discord/widgets/announcements/WidgetChannelFollowSheetViewModel$Event$FollowSuccess;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class Event {

        /* compiled from: WidgetChannelFollowSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/announcements/WidgetChannelFollowSheetViewModel$Event$FollowSuccess;", "Lcom/discord/widgets/announcements/WidgetChannelFollowSheetViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class FollowSuccess extends Event {
            public static final FollowSuccess INSTANCE = new FollowSuccess();

            private FollowSuccess() {
                super(null);
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetChannelFollowSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/announcements/WidgetChannelFollowSheetViewModel$ViewState;", "", "<init>", "()V", "Loaded", "Uninitialized", "Lcom/discord/widgets/announcements/WidgetChannelFollowSheetViewModel$ViewState$Uninitialized;", "Lcom/discord/widgets/announcements/WidgetChannelFollowSheetViewModel$ViewState$Loaded;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        /* compiled from: WidgetChannelFollowSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\u0010\u0010\u0018\u001a\f\u0012\b\u0012\u00060\u000bj\u0002`\f0\n\u0012\u0010\u0010\u0019\u001a\f\u0012\b\u0012\u00060\u000bj\u0002`\u000f0\n\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b2\u00103J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u001a\u0010\r\u001a\f\u0012\b\u0012\u00060\u000bj\u0002`\f0\nHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0010\u001a\f\u0012\b\u0012\u00060\u000bj\u0002`\u000f0\nHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000eJ\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013Jt\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00022\u0012\b\u0002\u0010\u0018\u001a\f\u0012\b\u0012\u00060\u000bj\u0002`\f0\n2\u0012\b\u0002\u0010\u0019\u001a\f\u0012\b\u0012\u00060\u000bj\u0002`\u000f0\n2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0011HÆ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b \u0010!J\u001a\u0010%\u001a\u00020$2\b\u0010#\u001a\u0004\u0018\u00010\"HÖ\u0003¢\u0006\u0004\b%\u0010&R#\u0010\u0018\u001a\f\u0012\b\u0012\u00060\u000bj\u0002`\f0\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010'\u001a\u0004\b(\u0010\u000eR\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010)\u001a\u0004\b*\u0010\u0004R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010)\u001a\u0004\b+\u0010\u0004R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010,\u001a\u0004\b-\u0010\u0007R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010.\u001a\u0004\b/\u0010\u0013R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010,\u001a\u0004\b0\u0010\u0007R#\u0010\u0019\u001a\f\u0012\b\u0012\u00060\u000bj\u0002`\u000f0\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010'\u001a\u0004\b1\u0010\u000e¨\u00064"}, d2 = {"Lcom/discord/widgets/announcements/WidgetChannelFollowSheetViewModel$ViewState$Loaded;", "Lcom/discord/widgets/announcements/WidgetChannelFollowSheetViewModel$ViewState;", "Lcom/discord/api/channel/Channel;", "component1", "()Lcom/discord/api/channel/Channel;", "Lcom/discord/models/guild/Guild;", "component2", "()Lcom/discord/models/guild/Guild;", "component3", "component4", "", "", "Lcom/discord/primitives/GuildId;", "component5", "()Ljava/util/Set;", "Lcom/discord/primitives/ChannelId;", "component6", "", "component7", "()Ljava/lang/Integer;", "sourceChannel", "sourceGuild", "selectedGuild", "selectedChannel", "availableGuilds", "availableChannels", "errorTextRes", "copy", "(Lcom/discord/api/channel/Channel;Lcom/discord/models/guild/Guild;Lcom/discord/models/guild/Guild;Lcom/discord/api/channel/Channel;Ljava/util/Set;Ljava/util/Set;Ljava/lang/Integer;)Lcom/discord/widgets/announcements/WidgetChannelFollowSheetViewModel$ViewState$Loaded;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Set;", "getAvailableGuilds", "Lcom/discord/api/channel/Channel;", "getSourceChannel", "getSelectedChannel", "Lcom/discord/models/guild/Guild;", "getSelectedGuild", "Ljava/lang/Integer;", "getErrorTextRes", "getSourceGuild", "getAvailableChannels", "<init>", "(Lcom/discord/api/channel/Channel;Lcom/discord/models/guild/Guild;Lcom/discord/models/guild/Guild;Lcom/discord/api/channel/Channel;Ljava/util/Set;Ljava/util/Set;Ljava/lang/Integer;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Loaded extends ViewState {
            private final Set<Long> availableChannels;
            private final Set<Long> availableGuilds;
            private final Integer errorTextRes;
            private final Channel selectedChannel;
            private final Guild selectedGuild;
            private final Channel sourceChannel;
            private final Guild sourceGuild;

            public /* synthetic */ Loaded(Channel channel, Guild guild, Guild guild2, Channel channel2, Set set, Set set2, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(channel, guild, guild2, channel2, set, set2, (i & 64) != 0 ? null : num);
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, Channel channel, Guild guild, Guild guild2, Channel channel2, Set set, Set set2, Integer num, int i, Object obj) {
                if ((i & 1) != 0) {
                    channel = loaded.sourceChannel;
                }
                if ((i & 2) != 0) {
                    guild = loaded.sourceGuild;
                }
                Guild guild3 = guild;
                if ((i & 4) != 0) {
                    guild2 = loaded.selectedGuild;
                }
                Guild guild4 = guild2;
                if ((i & 8) != 0) {
                    channel2 = loaded.selectedChannel;
                }
                Channel channel3 = channel2;
                if ((i & 16) != 0) {
                    set = loaded.availableGuilds;
                }
                Set set3 = set;
                if ((i & 32) != 0) {
                    set2 = loaded.availableChannels;
                }
                Set set4 = set2;
                if ((i & 64) != 0) {
                    num = loaded.errorTextRes;
                }
                return loaded.copy(channel, guild3, guild4, channel3, set3, set4, num);
            }

            /* renamed from: component1, reason: from getter */
            public final Channel getSourceChannel() {
                return this.sourceChannel;
            }

            /* renamed from: component2, reason: from getter */
            public final Guild getSourceGuild() {
                return this.sourceGuild;
            }

            /* renamed from: component3, reason: from getter */
            public final Guild getSelectedGuild() {
                return this.selectedGuild;
            }

            /* renamed from: component4, reason: from getter */
            public final Channel getSelectedChannel() {
                return this.selectedChannel;
            }

            public final Set<Long> component5() {
                return this.availableGuilds;
            }

            public final Set<Long> component6() {
                return this.availableChannels;
            }

            /* renamed from: component7, reason: from getter */
            public final Integer getErrorTextRes() {
                return this.errorTextRes;
            }

            public final Loaded copy(Channel sourceChannel, Guild sourceGuild, Guild selectedGuild, Channel selectedChannel, Set<Long> availableGuilds, Set<Long> availableChannels, Integer errorTextRes) {
                Intrinsics3.checkNotNullParameter(availableGuilds, "availableGuilds");
                Intrinsics3.checkNotNullParameter(availableChannels, "availableChannels");
                return new Loaded(sourceChannel, sourceGuild, selectedGuild, selectedChannel, availableGuilds, availableChannels, errorTextRes);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return Intrinsics3.areEqual(this.sourceChannel, loaded.sourceChannel) && Intrinsics3.areEqual(this.sourceGuild, loaded.sourceGuild) && Intrinsics3.areEqual(this.selectedGuild, loaded.selectedGuild) && Intrinsics3.areEqual(this.selectedChannel, loaded.selectedChannel) && Intrinsics3.areEqual(this.availableGuilds, loaded.availableGuilds) && Intrinsics3.areEqual(this.availableChannels, loaded.availableChannels) && Intrinsics3.areEqual(this.errorTextRes, loaded.errorTextRes);
            }

            public final Set<Long> getAvailableChannels() {
                return this.availableChannels;
            }

            public final Set<Long> getAvailableGuilds() {
                return this.availableGuilds;
            }

            public final Integer getErrorTextRes() {
                return this.errorTextRes;
            }

            public final Channel getSelectedChannel() {
                return this.selectedChannel;
            }

            public final Guild getSelectedGuild() {
                return this.selectedGuild;
            }

            public final Channel getSourceChannel() {
                return this.sourceChannel;
            }

            public final Guild getSourceGuild() {
                return this.sourceGuild;
            }

            public int hashCode() {
                Channel channel = this.sourceChannel;
                int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
                Guild guild = this.sourceGuild;
                int iHashCode2 = (iHashCode + (guild != null ? guild.hashCode() : 0)) * 31;
                Guild guild2 = this.selectedGuild;
                int iHashCode3 = (iHashCode2 + (guild2 != null ? guild2.hashCode() : 0)) * 31;
                Channel channel2 = this.selectedChannel;
                int iHashCode4 = (iHashCode3 + (channel2 != null ? channel2.hashCode() : 0)) * 31;
                Set<Long> set = this.availableGuilds;
                int iHashCode5 = (iHashCode4 + (set != null ? set.hashCode() : 0)) * 31;
                Set<Long> set2 = this.availableChannels;
                int iHashCode6 = (iHashCode5 + (set2 != null ? set2.hashCode() : 0)) * 31;
                Integer num = this.errorTextRes;
                return iHashCode6 + (num != null ? num.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(sourceChannel=");
                sbU.append(this.sourceChannel);
                sbU.append(", sourceGuild=");
                sbU.append(this.sourceGuild);
                sbU.append(", selectedGuild=");
                sbU.append(this.selectedGuild);
                sbU.append(", selectedChannel=");
                sbU.append(this.selectedChannel);
                sbU.append(", availableGuilds=");
                sbU.append(this.availableGuilds);
                sbU.append(", availableChannels=");
                sbU.append(this.availableChannels);
                sbU.append(", errorTextRes=");
                return outline.F(sbU, this.errorTextRes, ")");
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(Channel channel, Guild guild, Guild guild2, Channel channel2, Set<Long> set, Set<Long> set2, Integer num) {
                super(null);
                Intrinsics3.checkNotNullParameter(set, "availableGuilds");
                Intrinsics3.checkNotNullParameter(set2, "availableChannels");
                this.sourceChannel = channel;
                this.sourceGuild = guild;
                this.selectedGuild = guild2;
                this.selectedChannel = channel2;
                this.availableGuilds = set;
                this.availableChannels = set2;
                this.errorTextRes = num;
            }
        }

        /* compiled from: WidgetChannelFollowSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/announcements/WidgetChannelFollowSheetViewModel$ViewState$Uninitialized;", "Lcom/discord/widgets/announcements/WidgetChannelFollowSheetViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
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

    /* compiled from: WidgetChannelFollowSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u000b\u001ar\u00122\b\u0001\u0012.\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007 \u0004*\u0016\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0018\u00010\u00000\u0000 \u0004*8\u00122\b\u0001\u0012.\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007 \u0004*\u0016\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0018\u00010\u00000\u0000\u0018\u00010\u00060\u000626\u0010\u0005\u001a2\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0001j\u0002`\u0003 \u0004*\u0018\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0001j\u0002`\u0003\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/permission/PermissionBit;", "kotlin.jvm.PlatformType", "perms", "Lrx/Observable;", "", "Lcom/discord/api/channel/Channel;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.announcements.WidgetChannelFollowSheetViewModel$calculateChannelsWithPermissions$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Map<Long, ? extends Long>, Observable<? extends Map<Long, ? extends List<? extends Channel>>>> {

        /* compiled from: WidgetChannelFollowSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\u0010\t\u001a.\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006 \u0004*\u0016\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0018\u00010\u00000\u00002.\u0010\u0005\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003 \u0004*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/channel/Channel;", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;)Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.announcements.WidgetChannelFollowSheetViewModel$calculateChannelsWithPermissions$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02361<T, R> implements Func1<Map<Long, ? extends Channel>, Map<Long, ? extends List<? extends Channel>>> {
            public final /* synthetic */ Map $perms;

            public C02361(Map map) {
                this.$perms = map;
            }

            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ Map<Long, ? extends List<? extends Channel>> call(Map<Long, ? extends Channel> map) {
                return call2((Map<Long, Channel>) map);
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x005f  */
            /* renamed from: call, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Map<Long, List<Channel>> call2(Map<Long, Channel> map) {
                boolean z2;
                Intrinsics3.checkNotNullExpressionValue(map, "it");
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry<Long, Channel> entry : map.entrySet()) {
                    long jLongValue = entry.getKey().longValue();
                    Channel value = entry.getValue();
                    if (value.getType() == 5 || value.getType() == 0) {
                        Long l = (Long) this.$perms.get(Long.valueOf(jLongValue));
                        z2 = PermissionUtils.can(Permission.MANAGE_WEBHOOKS, Long.valueOf(l != null ? l.longValue() : 0L));
                    }
                    if (z2) {
                        linkedHashMap.put(entry.getKey(), entry.getValue());
                    }
                }
                Collection collectionValues = linkedHashMap.values();
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                for (T t : collectionValues) {
                    Long lValueOf = Long.valueOf(((Channel) t).getGuildId());
                    Object arrayList = linkedHashMap2.get(lValueOf);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        linkedHashMap2.put(lValueOf, arrayList);
                    }
                    ((List) arrayList).add(t);
                }
                return linkedHashMap2;
            }
        }

        public AnonymousClass1() {
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends Map<Long, ? extends List<? extends Channel>>> call(Map<Long, ? extends Long> map) {
            return call2((Map<Long, Long>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Map<Long, List<Channel>>> call2(Map<Long, Long> map) {
            return WidgetChannelFollowSheetViewModel.this.getStoreChannels().observeGuildAndPrivateChannels().r().G(new C02361(map));
        }
    }

    /* compiled from: WidgetChannelFollowSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "p1", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.announcements.WidgetChannelFollowSheetViewModel$followChannel$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Error, Unit> {
        public AnonymousClass1(WidgetChannelFollowSheetViewModel widgetChannelFollowSheetViewModel) {
            super(1, widgetChannelFollowSheetViewModel, WidgetChannelFollowSheetViewModel.class, "handleChannelFollowError", "handleChannelFollowError(Lcom/discord/utilities/error/Error;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "p1");
            WidgetChannelFollowSheetViewModel.access$handleChannelFollowError((WidgetChannelFollowSheetViewModel) this.receiver, error);
        }
    }

    /* compiled from: WidgetChannelFollowSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.announcements.WidgetChannelFollowSheetViewModel$followChannel$2, reason: invalid class name */
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
        public final void invoke2(Void r2) {
            PublishSubject publishSubjectAccess$getEventSubject$p = WidgetChannelFollowSheetViewModel.access$getEventSubject$p(WidgetChannelFollowSheetViewModel.this);
            publishSubjectAccess$getEventSubject$p.k.onNext(Event.FollowSuccess.INSTANCE);
        }
    }

    /* compiled from: WidgetChannelFollowSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\u001e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0005 \u0002*\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00040\u00042\u0018\u0010\u0003\u001a\u0014 \u0002*\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00010\u0000j\u0002`\u0001H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Lcom/discord/primitives/GuildId;", "kotlin.jvm.PlatformType", "it", "Lrx/Observable;", "Lcom/discord/models/guild/Guild;", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Long;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.announcements.WidgetChannelFollowSheetViewModel$observeViewStateFromStores$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Long, Observable<? extends Guild>> {
        public AnonymousClass1() {
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends Guild> call(Long l) {
            return call2(l);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Guild> call2(Long l) {
            if (l != null) {
                Observable<Guild> observableObserveGuild = WidgetChannelFollowSheetViewModel.this.getStoreGuilds().observeGuild(l.longValue());
                if (observableObserveGuild != null) {
                    return observableObserveGuild;
                }
            }
            return new ScalarSynchronousObservable(null);
        }
    }

    /* compiled from: WidgetChannelFollowSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\u001e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0005 \u0002*\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00040\u00042\u0018\u0010\u0003\u001a\u0014 \u0002*\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00010\u0000j\u0002`\u0001H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Lcom/discord/primitives/ChannelId;", "kotlin.jvm.PlatformType", "it", "Lrx/Observable;", "Lcom/discord/api/channel/Channel;", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Long;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.announcements.WidgetChannelFollowSheetViewModel$observeViewStateFromStores$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements Func1<Long, Observable<? extends Channel>> {
        public AnonymousClass2() {
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends Channel> call(Long l) {
            return call2(l);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Channel> call2(Long l) {
            if (l != null) {
                Observable<Channel> observableObserveChannel = WidgetChannelFollowSheetViewModel.this.getStoreChannels().observeChannel(l.longValue());
                if (observableObserveChannel != null) {
                    return observableObserveChannel;
                }
            }
            return new ScalarSynchronousObservable(null);
        }
    }

    /* compiled from: WidgetChannelFollowSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000b2\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u000222\u0010\b\u001a.\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0006 \u0007*\u0016\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0006\u0018\u00010\u00040\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\f\u0010\r"}, d2 = {"Lcom/discord/models/guild/Guild;", "sourceGuild", "Lcom/discord/api/channel/Channel;", "sourceChannel", "", "", "", "kotlin.jvm.PlatformType", "channelsWithPermissions", "selectedGuild", "selectedChannel", "Lcom/discord/widgets/announcements/WidgetChannelFollowSheetViewModel$ViewState$Loaded;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/guild/Guild;Lcom/discord/api/channel/Channel;Ljava/util/Map;Lcom/discord/models/guild/Guild;Lcom/discord/api/channel/Channel;)Lcom/discord/widgets/announcements/WidgetChannelFollowSheetViewModel$ViewState$Loaded;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.announcements.WidgetChannelFollowSheetViewModel$observeViewStateFromStores$3, reason: invalid class name */
    public static final class AnonymousClass3<T1, T2, T3, T4, T5, R> implements Func5<Guild, Channel, Map<Long, ? extends List<? extends Channel>>, Guild, Channel, ViewState.Loaded> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        @Override // rx.functions.Func5
        public /* bridge */ /* synthetic */ ViewState.Loaded call(Guild guild, Channel channel, Map<Long, ? extends List<? extends Channel>> map, Guild guild2, Channel channel2) {
            return call2(guild, channel, (Map<Long, ? extends List<Channel>>) map, guild2, channel2);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final ViewState.Loaded call2(Guild guild, Channel channel, Map<Long, ? extends List<Channel>> map, Guild guild2, Channel channel2) {
            Set<Long> setKeySet = map.keySet();
            List listFlatten = Iterables2.flatten(map.values());
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listFlatten, 10));
            Iterator it = listFlatten.iterator();
            while (it.hasNext()) {
                arrayList.add(Long.valueOf(((Channel) it.next()).getId()));
            }
            return new ViewState.Loaded(channel, guild, guild2, channel2, setKeySet, _Collections.toSet(arrayList), null, 64, null);
        }
    }

    public /* synthetic */ WidgetChannelFollowSheetViewModel(long j, long j2, StoreGuilds storeGuilds, StoreChannels storeChannels, StorePermissions storePermissions, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, (i & 4) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds, (i & 8) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels, (i & 16) != 0 ? StoreStream.INSTANCE.getPermissions() : storePermissions);
    }

    public static final /* synthetic */ PublishSubject access$getEventSubject$p(WidgetChannelFollowSheetViewModel widgetChannelFollowSheetViewModel) {
        return widgetChannelFollowSheetViewModel.eventSubject;
    }

    public static final /* synthetic */ void access$handleChannelFollowError(WidgetChannelFollowSheetViewModel widgetChannelFollowSheetViewModel, Error error) {
        widgetChannelFollowSheetViewModel.handleChannelFollowError(error);
    }

    public static final /* synthetic */ void access$updateViewState(WidgetChannelFollowSheetViewModel widgetChannelFollowSheetViewModel, ViewState viewState) {
        widgetChannelFollowSheetViewModel.updateViewState(viewState);
    }

    private final Observable<Map<Long, List<Channel>>> calculateChannelsWithPermissions() {
        return this.storePermissions.observePermissionsForAllChannels().r().Y(new AnonymousClass1());
    }

    private final void handleChannelFollowError(Error error) {
        Error.Response response = error.getResponse();
        Intrinsics3.checkNotNullExpressionValue(response, "error.response");
        int i = response.getCode() != 30007 ? R.string.follow_modal_fail : R.string.follow_modal_too_many_webhooks;
        ViewState viewState = getViewState();
        Objects.requireNonNull(viewState, "null cannot be cast to non-null type com.discord.widgets.announcements.WidgetChannelFollowSheetViewModel.ViewState.Loaded");
        updateViewState(ViewState.Loaded.copy$default((ViewState.Loaded) viewState, null, null, null, null, null, null, Integer.valueOf(i), 63, null));
    }

    private final Observable<ViewState.Loaded> observeViewStateFromStores() {
        Observable<ViewState.Loaded> observableG = Observable.g(this.storeGuilds.observeGuild(this.sourceGuildId), this.storeChannels.observeChannel(this.sourceChannelId), calculateChannelsWithPermissions(), this.selectedGuildSubject.Y(new AnonymousClass1()), this.selectedChannelSubject.Y(new AnonymousClass2()), AnonymousClass3.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableG, "Observable.combineLatest…  )\n\n      expected\n    }");
        return observableG;
    }

    public final void followChannel(long webhookChannelId) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().createChannelFollower(this.sourceChannelId, new RestAPIParams.ChannelFollowerPost(webhookChannelId)), false, 1, null), this, null, 2, null), WidgetChannelFollowSheetViewModel.class, (Context) null, (Function1) null, new AnonymousClass1(this), (Function0) null, (Function0) null, new AnonymousClass2(), 54, (Object) null);
    }

    public final StoreChannels getStoreChannels() {
        return this.storeChannels;
    }

    public final StoreGuilds getStoreGuilds() {
        return this.storeGuilds;
    }

    public final StorePermissions getStorePermissions() {
        return this.storePermissions;
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void selectChannel(long channelId) {
        this.selectedChannelSubject.onNext(Long.valueOf(channelId));
    }

    public final void selectGuild(long guildId) {
        this.selectedGuildSubject.onNext(Long.valueOf(guildId));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelFollowSheetViewModel(long j, long j2, StoreGuilds storeGuilds, StoreChannels storeChannels, StorePermissions storePermissions) {
        super(ViewState.Uninitialized.INSTANCE);
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        Intrinsics3.checkNotNullParameter(storeChannels, "storeChannels");
        Intrinsics3.checkNotNullParameter(storePermissions, "storePermissions");
        this.sourceGuildId = j;
        this.sourceChannelId = j2;
        this.storeGuilds = storeGuilds;
        this.storeChannels = storeChannels;
        this.storePermissions = storePermissions;
        this.selectedGuildSubject = BehaviorSubject.l0(null);
        this.selectedChannelSubject = BehaviorSubject.l0(null);
        this.eventSubject = PublishSubject.k0();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observeViewStateFromStores()), this, null, 2, null), WidgetChannelFollowSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
