package com.discord.widgets.servers;

import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.AppLogger2;
import com.discord.databinding.WidgetServerSettingsChannelsBinding;
import com.discord.models.guild.Guild;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.error.Error;
import com.discord.utilities.mg_recycler.CategoricalDragAndDropAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.channels.settings.WidgetTextChannelSettings;
import com.discord.widgets.chat.AutocompleteUtils2;
import com.discord.widgets.servers.SettingsChannelListAdapter;
import com.discord.widgets.servers.WidgetServerSettingsChannelsFabMenuFragment;
import com.discord.widgets.servers.WidgetServerSettingsChannelsSortActions;
import com.discord.widgets.voice.settings.WidgetVoiceChannelSettings;
import d0.f0._Sequences2;
import d0.t._Collections;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Action2;
import rx.subjects.BehaviorSubject;

/* compiled from: WidgetServerSettingsChannels.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 ,2\u00020\u0001:\u0002,-B\u0007¢\u0006\u0004\b+\u0010\u0018J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J/\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0016\u0010\f\u001a\u0012\u0012\b\u0012\u00060\tj\u0002`\n\u0012\u0004\u0012\u00020\u000b0\bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000f\u0010\u0006J\u001b\u0010\u0011\u001a\u00020\u0004*\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR:\u0010\u001e\u001a&\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\u001c0\u001c \u001d*\u0012\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\u001c0\u001c\u0018\u00010\u001b0\u001b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001c\u0010!\u001a\u00020 8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001d\u0010*\u001a\u00020%8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)¨\u0006."}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsChannels;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/servers/WidgetServerSettingsChannels$Model;", "model", "", "configureUI", "(Lcom/discord/widgets/servers/WidgetServerSettingsChannels$Model;)V", "data", "", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/widgets/servers/SettingsChannelListAdapter$UpdatedPosition;", "newPositions", "reorderChannels", "(Lcom/discord/widgets/servers/WidgetServerSettingsChannels$Model;Ljava/util/Map;)V", "configureFabVisibility", "Lcom/discord/widgets/servers/SettingsChannelListAdapter;", "setOnClickListener", "(Lcom/discord/widgets/servers/SettingsChannelListAdapter;Lcom/discord/widgets/servers/WidgetServerSettingsChannels$Model;)V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "()V", "adapter", "Lcom/discord/widgets/servers/SettingsChannelListAdapter;", "Lrx/subjects/BehaviorSubject;", "", "kotlin.jvm.PlatformType", "channelSortTypeSubject", "Lrx/subjects/BehaviorSubject;", "Lcom/discord/app/LoggingConfig;", "loggingConfig", "Lcom/discord/app/LoggingConfig;", "getLoggingConfig", "()Lcom/discord/app/LoggingConfig;", "Lcom/discord/databinding/WidgetServerSettingsChannelsBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetServerSettingsChannelsBinding;", "binding", "<init>", "Companion", ExifInterface.TAG_MODEL, "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetServerSettingsChannels extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetServerSettingsChannels.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsChannelsBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";
    private SettingsChannelListAdapter adapter;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final BehaviorSubject<Integer> channelSortTypeSubject;
    private final AppLogger2 loggingConfig;

    /* compiled from: WidgetServerSettingsChannels.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsChannels$Companion;", "", "Landroid/content/Context;", "context", "", "Lcom/discord/primitives/GuildId;", "guildId", "", "show", "(Landroid/content/Context;J)V", "", WidgetServerSettingsChannels.INTENT_EXTRA_GUILD_ID, "Ljava/lang/String;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void show(Context context, long guildId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            StoreStream.INSTANCE.getAnalytics().onGuildSettingsPaneViewed(AutocompleteUtils2.CHANNELS, guildId);
            Intent intentPutExtra = new Intent().putExtra(WidgetServerSettingsChannels.INTENT_EXTRA_GUILD_ID, guildId);
            Intrinsics3.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE…_EXTRA_GUILD_ID, guildId)");
            AppScreen2.d(context, WidgetServerSettingsChannels.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetServerSettingsChannels.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\b\u0082\b\u0018\u0000 -2\u00020\u0001:\u0001-BU\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0015\u001a\u00020\t\u0012\u0016\u0010\u0016\u001a\u0012\u0012\b\u0012\u00060\rj\u0002`\u000e\u0012\u0004\u0012\u00020\u000f0\f\u0012\u0016\u0010\u0017\u001a\u0012\u0012\b\u0012\u00060\rj\u0002`\u000e\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b+\u0010,J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ \u0010\u0010\u001a\u0012\u0012\b\u0012\u00060\rj\u0002`\u000e\u0012\u0004\u0012\u00020\u000f0\fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J \u0010\u0012\u001a\u0012\u0012\b\u0012\u00060\rj\u0002`\u000e\u0012\u0004\u0012\u00020\r0\fHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0011Jh\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u00022\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0015\u001a\u00020\t2\u0018\b\u0002\u0010\u0016\u001a\u0012\u0012\b\u0012\u00060\rj\u0002`\u000e\u0012\u0004\u0012\u00020\u000f0\f2\u0018\b\u0002\u0010\u0017\u001a\u0012\u0012\b\u0012\u00060\rj\u0002`\u000e\u0012\u0004\u0012\u00020\r0\fHÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010!\u001a\u00020\t2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b!\u0010\"R)\u0010\u0016\u001a\u0012\u0012\b\u0012\u00060\rj\u0002`\u000e\u0012\u0004\u0012\u00020\u000f0\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010#\u001a\u0004\b$\u0010\u0011R\u0019\u0010\u0015\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010%\u001a\u0004\b\u0015\u0010\u000bR)\u0010\u0017\u001a\u0012\u0012\b\u0012\u00060\rj\u0002`\u000e\u0012\u0004\u0012\u00020\r0\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010#\u001a\u0004\b&\u0010\u0011R\u001f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010'\u001a\u0004\b(\u0010\bR\u0019\u0010\u0013\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010)\u001a\u0004\b*\u0010\u0004¨\u0006."}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsChannels$Model;", "", "Lcom/discord/models/guild/Guild;", "component1", "()Lcom/discord/models/guild/Guild;", "", "Lcom/discord/utilities/mg_recycler/CategoricalDragAndDropAdapter$Payload;", "component2", "()Ljava/util/List;", "", "component3", "()Z", "", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/channel/Channel;", "component4", "()Ljava/util/Map;", "component5", "guild", "items", "isSorting", "channels", "channelPermissions", "copy", "(Lcom/discord/models/guild/Guild;Ljava/util/List;ZLjava/util/Map;Ljava/util/Map;)Lcom/discord/widgets/servers/WidgetServerSettingsChannels$Model;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Map;", "getChannels", "Z", "getChannelPermissions", "Ljava/util/List;", "getItems", "Lcom/discord/models/guild/Guild;", "getGuild", "<init>", "(Lcom/discord/models/guild/Guild;Ljava/util/List;ZLjava/util/Map;Ljava/util/Map;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Model {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Map<Long, Long> channelPermissions;
        private final Map<Long, Channel> channels;
        private final Guild guild;
        private final boolean isSorting;
        private final List<CategoricalDragAndDropAdapter.Payload> items;

        /* compiled from: WidgetServerSettingsChannels.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J/\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\t\u0010\nJ=\u0010\u0011\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\f\u0012\u0004\u0012\u00020\r0\u00102\u0016\u0010\u000e\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\f\u0012\u0004\u0012\u00020\r0\u000b2\u0006\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsChannels$Model$Companion;", "", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lrx/Observable;", "", "channelTypeObservable", "Lcom/discord/widgets/servers/WidgetServerSettingsChannels$Model;", "get", "(JLrx/Observable;)Lrx/Observable;", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/channel/Channel;", "guildChannels", "channelType", "Ljava/util/LinkedHashMap;", "getSortedGuildChannels", "(Ljava/util/Map;I)Ljava/util/LinkedHashMap;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(long guildId, Observable<Integer> channelTypeObservable) {
                Intrinsics3.checkNotNullParameter(channelTypeObservable, "channelTypeObservable");
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable observableE = Observable.e(StoreUser.observeMe$default(companion.getUsers(), false, 1, null), companion.getPermissions().observePermissionsForGuild(guildId), companion.getGuilds().observeGuild(guildId), StoreChannels.observeChannelsForGuild$default(companion.getChannels(), guildId, null, 2, null), companion.getChannels().observeChannelCategories(guildId), companion.getPermissions().observeChannelPermissionsForGuild(guildId), channelTypeObservable, WidgetServerSettingsChannels3.INSTANCE);
                Intrinsics3.checkNotNullExpressionValue(observableE, "Observable\n            .…ermissions)\n            }");
                Observable<Model> observableR = ObservableExtensionsKt.computationLatest(observableE).r();
                Intrinsics3.checkNotNullExpressionValue(observableR, "Observable\n            .…  .distinctUntilChanged()");
                return observableR;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final LinkedHashMap<Long, Channel> getSortedGuildChannels(Map<Long, Channel> guildChannels, int channelType) {
                Intrinsics3.checkNotNullParameter(guildChannels, "guildChannels");
                LinkedHashMap<Long, Channel> linkedHashMap = new LinkedHashMap<>();
                for (Object obj : _Sequences2.sortedWith(_Sequences2.filter(_Collections.asSequence(guildChannels.values()), new WidgetServerSettingsChannels2(guildChannels, channelType)), ChannelUtils.h(Channel.INSTANCE))) {
                    linkedHashMap.put(Long.valueOf(((Channel) obj).getId()), obj);
                }
                return linkedHashMap;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Model(Guild guild, List<? extends CategoricalDragAndDropAdapter.Payload> list, boolean z2, Map<Long, Channel> map, Map<Long, Long> map2) {
            Intrinsics3.checkNotNullParameter(guild, "guild");
            Intrinsics3.checkNotNullParameter(list, "items");
            Intrinsics3.checkNotNullParameter(map, "channels");
            Intrinsics3.checkNotNullParameter(map2, "channelPermissions");
            this.guild = guild;
            this.items = list;
            this.isSorting = z2;
            this.channels = map;
            this.channelPermissions = map2;
        }

        public static /* synthetic */ Model copy$default(Model model, Guild guild, List list, boolean z2, Map map, Map map2, int i, Object obj) {
            if ((i & 1) != 0) {
                guild = model.guild;
            }
            if ((i & 2) != 0) {
                list = model.items;
            }
            List list2 = list;
            if ((i & 4) != 0) {
                z2 = model.isSorting;
            }
            boolean z3 = z2;
            if ((i & 8) != 0) {
                map = model.channels;
            }
            Map map3 = map;
            if ((i & 16) != 0) {
                map2 = model.channelPermissions;
            }
            return model.copy(guild, list2, z3, map3, map2);
        }

        /* renamed from: component1, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        public final List<CategoricalDragAndDropAdapter.Payload> component2() {
            return this.items;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getIsSorting() {
            return this.isSorting;
        }

        public final Map<Long, Channel> component4() {
            return this.channels;
        }

        public final Map<Long, Long> component5() {
            return this.channelPermissions;
        }

        public final Model copy(Guild guild, List<? extends CategoricalDragAndDropAdapter.Payload> items, boolean isSorting, Map<Long, Channel> channels, Map<Long, Long> channelPermissions) {
            Intrinsics3.checkNotNullParameter(guild, "guild");
            Intrinsics3.checkNotNullParameter(items, "items");
            Intrinsics3.checkNotNullParameter(channels, "channels");
            Intrinsics3.checkNotNullParameter(channelPermissions, "channelPermissions");
            return new Model(guild, items, isSorting, channels, channelPermissions);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return Intrinsics3.areEqual(this.guild, model.guild) && Intrinsics3.areEqual(this.items, model.items) && this.isSorting == model.isSorting && Intrinsics3.areEqual(this.channels, model.channels) && Intrinsics3.areEqual(this.channelPermissions, model.channelPermissions);
        }

        public final Map<Long, Long> getChannelPermissions() {
            return this.channelPermissions;
        }

        public final Map<Long, Channel> getChannels() {
            return this.channels;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final List<CategoricalDragAndDropAdapter.Payload> getItems() {
            return this.items;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            Guild guild = this.guild;
            int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
            List<CategoricalDragAndDropAdapter.Payload> list = this.items;
            int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
            boolean z2 = this.isSorting;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode2 + i) * 31;
            Map<Long, Channel> map = this.channels;
            int iHashCode3 = (i2 + (map != null ? map.hashCode() : 0)) * 31;
            Map<Long, Long> map2 = this.channelPermissions;
            return iHashCode3 + (map2 != null ? map2.hashCode() : 0);
        }

        public final boolean isSorting() {
            return this.isSorting;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Model(guild=");
            sbU.append(this.guild);
            sbU.append(", items=");
            sbU.append(this.items);
            sbU.append(", isSorting=");
            sbU.append(this.isSorting);
            sbU.append(", channels=");
            sbU.append(this.channels);
            sbU.append(", channelPermissions=");
            return outline.M(sbU, this.channelPermissions, ")");
        }
    }

    /* compiled from: WidgetServerSettingsChannels.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsChannels$configureFabVisibility$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ Model $model;
        public final /* synthetic */ Function0 $setFabVisibility;

        /* compiled from: WidgetServerSettingsChannels.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", NotificationCompat.CATEGORY_CALL, "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.servers.WidgetServerSettingsChannels$configureFabVisibility$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C03051 implements Action0 {
            public C03051() {
            }

            @Override // rx.functions.Action0
            public final void call() {
                AnonymousClass1.this.$setFabVisibility.invoke();
            }
        }

        public AnonymousClass1(Model model, Function0 function0) {
            this.$model = model;
            this.$setFabVisibility = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsChannelsFabMenuFragment.Companion companion = WidgetServerSettingsChannelsFabMenuFragment.INSTANCE;
            long id2 = this.$model.getGuild().getId();
            FragmentManager childFragmentManager = WidgetServerSettingsChannels.this.getChildFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            companion.show(id2, childFragmentManager, new C03051());
            WidgetServerSettingsChannels.access$getBinding$p(WidgetServerSettingsChannels.this).c.hide();
        }
    }

    /* compiled from: WidgetServerSettingsChannels.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "menuItem", "Landroid/content/Context;", "<anonymous parameter 1>", "", NotificationCompat.CATEGORY_CALL, "(Landroid/view/MenuItem;Landroid/content/Context;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsChannels$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2> implements Action2<MenuItem, Context> {

        /* compiled from: WidgetServerSettingsChannels.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "channelType", "", "invoke", "(I)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.servers.WidgetServerSettingsChannels$configureUI$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C03061 extends Lambda implements Function1<Integer, Unit> {
            public C03061() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.a;
            }

            public final void invoke(int i) {
                WidgetServerSettingsChannels.access$getChannelSortTypeSubject$p(WidgetServerSettingsChannels.this).onNext(Integer.valueOf(i));
            }
        }

        public AnonymousClass1() {
        }

        @Override // rx.functions.Action2
        public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
            call2(menuItem, context);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(MenuItem menuItem, Context context) {
            Intrinsics3.checkNotNullExpressionValue(menuItem, "menuItem");
            switch (menuItem.getItemId()) {
                case R.id.menu_sort_channel /* 2131364413 */:
                    WidgetServerSettingsChannelsSortActions.Companion companion = WidgetServerSettingsChannelsSortActions.INSTANCE;
                    FragmentManager childFragmentManager = WidgetServerSettingsChannels.this.getChildFragmentManager();
                    Intrinsics3.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
                    companion.show(childFragmentManager, new C03061());
                    break;
                case R.id.menu_sort_done /* 2131364414 */:
                    WidgetServerSettingsChannels.access$getChannelSortTypeSubject$p(WidgetServerSettingsChannels.this).onNext(-1);
                    break;
            }
        }
    }

    /* compiled from: WidgetServerSettingsChannels.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/Menu;", "kotlin.jvm.PlatformType", "menu", "", NotificationCompat.CATEGORY_CALL, "(Landroid/view/Menu;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsChannels$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements Action1<Menu> {
        public final /* synthetic */ Model $model;

        public AnonymousClass2(Model model) {
            this.$model = model;
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Menu menu) {
            call2(menu);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Menu menu) {
            MenuItem menuItemFindItem = menu.findItem(R.id.menu_sort_channel);
            Intrinsics3.checkNotNullExpressionValue(menuItemFindItem, "menu.findItem(R.id.menu_sort_channel)");
            menuItemFindItem.setVisible(!this.$model.isSorting());
            MenuItem menuItemFindItem2 = menu.findItem(R.id.menu_sort_done);
            Intrinsics3.checkNotNullExpressionValue(menuItemFindItem2, "menu.findItem(R.id.menu_sort_done)");
            menuItemFindItem2.setVisible(this.$model.isSorting());
        }
    }

    /* compiled from: WidgetServerSettingsChannels.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052&\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002 \u0003*\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "", "Lcom/discord/widgets/servers/SettingsChannelListAdapter$UpdatedPosition;", "kotlin.jvm.PlatformType", "newPositions", "", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsChannels$configureUI$3, reason: invalid class name */
    public static final class AnonymousClass3<T> implements Action1<Map<Long, ? extends SettingsChannelListAdapter.UpdatedPosition>> {
        public final /* synthetic */ Model $model;

        public AnonymousClass3(Model model) {
            this.$model = model;
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Map<Long, ? extends SettingsChannelListAdapter.UpdatedPosition> map) {
            call2((Map<Long, SettingsChannelListAdapter.UpdatedPosition>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Map<Long, SettingsChannelListAdapter.UpdatedPosition> map) {
            WidgetServerSettingsChannels widgetServerSettingsChannels = WidgetServerSettingsChannels.this;
            Model model = this.$model;
            Intrinsics3.checkNotNullExpressionValue(map, "newPositions");
            WidgetServerSettingsChannels.access$reorderChannels(widgetServerSettingsChannels, model, map);
        }
    }

    /* compiled from: WidgetServerSettingsChannels.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsChannels$Model;", "p1", "", "invoke", "(Lcom/discord/widgets/servers/WidgetServerSettingsChannels$Model;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsChannels$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Model, Unit> {
        public AnonymousClass1(WidgetServerSettingsChannels widgetServerSettingsChannels) {
            super(1, widgetServerSettingsChannels, WidgetServerSettingsChannels.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/WidgetServerSettingsChannels$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) throws Exception {
            invoke2(model);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) throws Exception {
            WidgetServerSettingsChannels.access$configureUI((WidgetServerSettingsChannels) this.receiver, model);
        }
    }

    /* compiled from: WidgetServerSettingsChannels.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsChannels$reorderChannels$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r4) {
            AppToast.i(WidgetServerSettingsChannels.this, R.string.channel_order_updated, 0, 4);
        }
    }

    /* compiled from: WidgetServerSettingsChannels.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsChannels$reorderChannels$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ Model $data;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Model model) {
            super(1);
            this.$data = model;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) throws Exception {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) throws Exception {
            Intrinsics3.checkNotNullParameter(error, "it");
            WidgetServerSettingsChannels.access$configureUI(WidgetServerSettingsChannels.this, this.$data);
        }
    }

    /* compiled from: WidgetServerSettingsChannels.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/discord/primitives/ChannelId;", "it", "", "invoke", "(J)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsChannels$setOnClickListener$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Long, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.a;
        }

        public final void invoke(long j) {
        }
    }

    /* compiled from: WidgetServerSettingsChannels.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/discord/primitives/ChannelId;", "channelId", "", "invoke", "(J)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsChannels$setOnClickListener$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Long, Unit> {
        public final /* synthetic */ Model $model;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Model model) {
            super(1);
            this.$model = model;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.a;
        }

        public final void invoke(long j) {
            if (PermissionUtils.can(16L, this.$model.getChannelPermissions().get(Long.valueOf(j)))) {
                Channel channel = this.$model.getChannels().get(Long.valueOf(j));
                if (channel == null || !ChannelUtils.w(channel)) {
                    WidgetTextChannelSettings.INSTANCE.launch(j, WidgetServerSettingsChannels.this.requireContext());
                } else {
                    WidgetVoiceChannelSettings.INSTANCE.launch(j, WidgetServerSettingsChannels.this.requireContext());
                }
            }
        }
    }

    public WidgetServerSettingsChannels() {
        super(R.layout.widget_server_settings_channels);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettingsChannels4.INSTANCE, null, 2, null);
        this.channelSortTypeSubject = BehaviorSubject.l0(-1);
        this.loggingConfig = new AppLogger2(false, null, WidgetServerSettingsChannels6.INSTANCE, 3);
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerSettingsChannels widgetServerSettingsChannels, Model model) throws Exception {
        widgetServerSettingsChannels.configureUI(model);
    }

    public static final /* synthetic */ WidgetServerSettingsChannelsBinding access$getBinding$p(WidgetServerSettingsChannels widgetServerSettingsChannels) {
        return widgetServerSettingsChannels.getBinding();
    }

    public static final /* synthetic */ BehaviorSubject access$getChannelSortTypeSubject$p(WidgetServerSettingsChannels widgetServerSettingsChannels) {
        return widgetServerSettingsChannels.channelSortTypeSubject;
    }

    public static final /* synthetic */ void access$reorderChannels(WidgetServerSettingsChannels widgetServerSettingsChannels, Model model, Map map) {
        widgetServerSettingsChannels.reorderChannels(model, map);
    }

    private final void configureFabVisibility(Model model) {
        WidgetServerSettingsChannels5 widgetServerSettingsChannels5 = new WidgetServerSettingsChannels5(this, model);
        widgetServerSettingsChannels5.invoke();
        getBinding().c.setOnClickListener(new AnonymousClass1(model, widgetServerSettingsChannels5));
    }

    private final void configureUI(Model model) throws Exception {
        if (model == null) {
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.onBackPressed();
                return;
            }
            return;
        }
        setActionBarDisplayHomeAsUpEnabled(!model.isSorting());
        setActionBarTitle(!model.isSorting() ? R.string.channels : R.string.sorting);
        setActionBarSubtitle(model.getGuild().getName());
        setActionBarOptionsMenu(R.menu.menu_channel_sort, new AnonymousClass1(), new AnonymousClass2(model));
        configureFabVisibility(model);
        SettingsChannelListAdapter settingsChannelListAdapter = this.adapter;
        if (settingsChannelListAdapter != null) {
            settingsChannelListAdapter.setData(model.getItems());
        }
        SettingsChannelListAdapter settingsChannelListAdapter2 = this.adapter;
        if (settingsChannelListAdapter2 != null) {
            settingsChannelListAdapter2.setPositionUpdateListener(new AnonymousClass3(model));
        }
        SettingsChannelListAdapter settingsChannelListAdapter3 = this.adapter;
        if (settingsChannelListAdapter3 != null) {
            setOnClickListener(settingsChannelListAdapter3, model);
        }
    }

    private final WidgetServerSettingsChannelsBinding getBinding() {
        return (WidgetServerSettingsChannelsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void reorderChannels(Model data, Map<Long, SettingsChannelListAdapter.UpdatedPosition> newPositions) {
        ArrayList arrayList = new ArrayList(newPositions.size());
        for (Map.Entry<Long, SettingsChannelListAdapter.UpdatedPosition> entry : newPositions.entrySet()) {
            long jLongValue = entry.getKey().longValue();
            SettingsChannelListAdapter.UpdatedPosition value = entry.getValue();
            arrayList.add(new RestAPIParams.ChannelPosition(jLongValue, value.getPosition(), value.getParentId()));
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApiSerializeNulls().reorderChannels(data.getGuild().getId(), arrayList), false, 1, null), getBinding().f2550b, 0L, 2, null), this, null, 2, null), WidgetServerSettingsChannels.class, getContext(), (Function1) null, new AnonymousClass2(data), (Function0) null, (Function0) null, new AnonymousClass1(), 52, (Object) null);
    }

    private final void setOnClickListener(SettingsChannelListAdapter settingsChannelListAdapter, Model model) {
        settingsChannelListAdapter.setOnClickListener(model.isSorting() ? AnonymousClass1.INSTANCE : new AnonymousClass2(model));
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.a
    public AppLogger2 getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.serverSettingsChannelsTextRecycler");
        this.adapter = (SettingsChannelListAdapter) companion.configure(new SettingsChannelListAdapter(recyclerView, true));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        long longExtra = getMostRecentIntent().getLongExtra(INTENT_EXTRA_GUILD_ID, -1L);
        Model.Companion companion = Model.INSTANCE;
        BehaviorSubject<Integer> behaviorSubject = this.channelSortTypeSubject;
        Intrinsics3.checkNotNullExpressionValue(behaviorSubject, "channelSortTypeSubject");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(companion.get(longExtra, behaviorSubject), this, null, 2, null), WidgetServerSettingsChannels.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }
}
