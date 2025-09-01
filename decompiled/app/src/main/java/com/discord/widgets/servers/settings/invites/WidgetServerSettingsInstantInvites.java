package com.discord.widgets.servers.settings.invites;

import a0.a.a.b;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppScreen2;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.user.User;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.AppLogger2;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetServerSettingsInstantInvitesBinding;
import com.discord.models.domain.ModelInvite;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreInstantInvites;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.user.UserUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.servers.WidgetServerSettingsInstantInvitesActions;
import d0.LazyJVM;
import d0.g0.StringsJVM;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: WidgetServerSettingsInstantInvites.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\u0018\u0000 %2\u00020\u0001:\u0003&%'B\u0007¢\u0006\u0004\b$\u0010\fJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u00020\r8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0017\u001a\u00020\u00128B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001d\u0010#\u001a\u00020\u001e8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"¨\u0006("}, d2 = {"Lcom/discord/widgets/servers/settings/invites/WidgetServerSettingsInstantInvites;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/servers/settings/invites/WidgetServerSettingsInstantInvites$Model;", "data", "", "configureUI", "(Lcom/discord/widgets/servers/settings/invites/WidgetServerSettingsInstantInvites$Model;)V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "()V", "Lcom/discord/app/LoggingConfig;", "loggingConfig", "Lcom/discord/app/LoggingConfig;", "getLoggingConfig", "()Lcom/discord/app/LoggingConfig;", "Lcom/discord/databinding/WidgetServerSettingsInstantInvitesBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetServerSettingsInstantInvitesBinding;", "binding", "Lcom/discord/widgets/servers/settings/invites/WidgetServerSettingsInstantInvites$Adapter;", "adapter", "Lcom/discord/widgets/servers/settings/invites/WidgetServerSettingsInstantInvites$Adapter;", "Lcom/discord/stores/StoreInstantInvites;", "storeInstantInvites", "Lcom/discord/stores/StoreInstantInvites;", "", "guildId$delegate", "Lkotlin/Lazy;", "getGuildId", "()J", "guildId", "<init>", "Companion", "Adapter", ExifInterface.TAG_MODEL, "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetServerSettingsInstantInvites extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetServerSettingsInstantInvites.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsInstantInvitesBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";
    private static final int VIEW_INDEX_INVITES_LIST = 1;
    private static final int VIEW_INDEX_INVITES_LOADING = 0;
    private static final int VIEW_INDEX_NO_INVITES = 2;
    private Adapter adapter;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;
    private final AppLogger2 loggingConfig;
    private final StoreInstantInvites storeInstantInvites;

    /* compiled from: WidgetServerSettingsInstantInvites.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ)\u0010\b\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJC\u0010\u0011\u001a\u00020\u000e2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\r¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\r¢\u0006\u0004\b\u0016\u0010\u0015R\"\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0017R\"\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/discord/widgets/servers/settings/invites/WidgetServerSettingsInstantInvites$Adapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerAdapterSimple;", "Lcom/discord/widgets/servers/settings/invites/WidgetServerSettingsInstantInvites$Model$InviteItem;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "", "data", "Lkotlin/Function1;", "Lcom/discord/models/domain/ModelInvite;", "", "onInviteSelectedListener", "onInviteExpiredListener", "configure", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "invite", "onInviteSelected", "(Lcom/discord/models/domain/ModelInvite;)V", "onInviteExpired", "Lkotlin/jvm/functions/Function1;", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Adapter extends MGRecyclerAdapterSimple<Model.InviteItem> {
        private Function1<? super ModelInvite, Unit> onInviteExpiredListener;
        private Function1<? super ModelInvite, Unit> onInviteSelectedListener;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Adapter(RecyclerView recyclerView) {
            super(recyclerView, false, 2, null);
            Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
            this.onInviteSelectedListener = WidgetServerSettingsInstantInvites3.INSTANCE;
            this.onInviteExpiredListener = WidgetServerSettingsInstantInvites2.INSTANCE;
        }

        public final void configure(List<Model.InviteItem> data, Function1<? super ModelInvite, Unit> onInviteSelectedListener, Function1<? super ModelInvite, Unit> onInviteExpiredListener) {
            Intrinsics3.checkNotNullParameter(data, "data");
            Intrinsics3.checkNotNullParameter(onInviteSelectedListener, "onInviteSelectedListener");
            Intrinsics3.checkNotNullParameter(onInviteExpiredListener, "onInviteExpiredListener");
            this.onInviteSelectedListener = onInviteSelectedListener;
            this.onInviteExpiredListener = onInviteExpiredListener;
            setData(data);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return onCreateViewHolder(viewGroup, i);
        }

        public final void onInviteExpired(ModelInvite invite) {
            Intrinsics3.checkNotNullParameter(invite, "invite");
            this.onInviteExpiredListener.invoke(invite);
        }

        public final void onInviteSelected(ModelInvite invite) {
            Intrinsics3.checkNotNullParameter(invite, "invite");
            this.onInviteSelectedListener.invoke(invite);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public MGRecyclerViewHolder<?, Model.InviteItem> onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics3.checkNotNullParameter(parent, "parent");
            if (viewType == 0) {
                return new WidgetServerSettingsInstantInvitesListItem(this);
            }
            throw invalidViewTypeException(viewType);
        }
    }

    /* compiled from: WidgetServerSettingsInstantInvites.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\r8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/discord/widgets/servers/settings/invites/WidgetServerSettingsInstantInvites$Companion;", "", "Landroid/content/Context;", "context", "", "Lcom/discord/primitives/GuildId;", "guildId", "", "create", "(Landroid/content/Context;J)V", "", "INTENT_EXTRA_GUILD_ID", "Ljava/lang/String;", "", "VIEW_INDEX_INVITES_LIST", "I", "VIEW_INDEX_INVITES_LOADING", "VIEW_INDEX_NO_INVITES", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void create(Context context, long guildId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            StoreStream.INSTANCE.getAnalytics().onGuildSettingsPaneViewed("INSTANT_INVITES", guildId);
            Intent intentPutExtra = new Intent().putExtra("INTENT_EXTRA_GUILD_ID", guildId);
            Intrinsics3.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE…_EXTRA_GUILD_ID, guildId)");
            AppScreen2.d(context, WidgetServerSettingsInstantInvites.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetServerSettingsInstantInvites.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001d\u001eB\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ,\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R!\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001a\u0010\b¨\u0006\u001f"}, d2 = {"Lcom/discord/widgets/servers/settings/invites/WidgetServerSettingsInstantInvites$Model;", "", "Lcom/discord/models/guild/Guild;", "component1", "()Lcom/discord/models/guild/Guild;", "", "Lcom/discord/widgets/servers/settings/invites/WidgetServerSettingsInstantInvites$Model$InviteItem;", "component2", "()Ljava/util/List;", "guild", "inviteItems", "copy", "(Lcom/discord/models/guild/Guild;Ljava/util/List;)Lcom/discord/widgets/servers/settings/invites/WidgetServerSettingsInstantInvites$Model;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/guild/Guild;", "getGuild", "Ljava/util/List;", "getInviteItems", "<init>", "(Lcom/discord/models/guild/Guild;Ljava/util/List;)V", "Companion", "InviteItem", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Model {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Guild guild;
        private final List<InviteItem> inviteItems;

        /* compiled from: WidgetServerSettingsInstantInvites.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ5\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/discord/widgets/servers/settings/invites/WidgetServerSettingsInstantInvites$Model$Companion;", "", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/stores/StoreGuilds;", "storeGuilds", "Lcom/discord/stores/StoreInstantInvites;", "storeInstantInvites", "Lrx/Observable;", "Lcom/discord/widgets/servers/settings/invites/WidgetServerSettingsInstantInvites$Model;", "get", "(JLcom/discord/stores/StoreGuilds;Lcom/discord/stores/StoreInstantInvites;)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public static /* synthetic */ Observable get$default(Companion companion, long j, StoreGuilds storeGuilds, StoreInstantInvites storeInstantInvites, int i, Object obj) {
                if ((i & 2) != 0) {
                    storeGuilds = StoreStream.INSTANCE.getGuilds();
                }
                if ((i & 4) != 0) {
                    storeInstantInvites = StoreStream.INSTANCE.getInstantInvites();
                }
                return companion.get(j, storeGuilds, storeInstantInvites);
            }

            public final Observable<Model> get(long guildId, StoreGuilds storeGuilds, StoreInstantInvites storeInstantInvites) {
                Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
                Intrinsics3.checkNotNullParameter(storeInstantInvites, "storeInstantInvites");
                Observable<Model> observableR = ObservableExtensionsKt.computationLatest(ObservationDeck.connectRx$default(ObservationDeck4.get(), new ObservationDeck.UpdateSource[]{storeGuilds, storeInstantInvites}, false, null, null, new WidgetServerSettingsInstantInvites4(storeGuilds, guildId, storeInstantInvites), 14, null)).r();
                Intrinsics3.checkNotNullExpressionValue(observableR, "ObservationDeckProvider.…  .distinctUntilChanged()");
                return observableR;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* compiled from: WidgetServerSettingsInstantInvites.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u0000 -2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001-B%\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u0012\n\u0010\u0012\u001a\u00060\nj\u0002`\u000b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b+\u0010,J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\f\u001a\u00060\nj\u0002`\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J4\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00072\f\b\u0002\u0010\u0012\u001a\u00060\nj\u0002`\u000b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u0003\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u00020\u00168\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u0018R\u001c\u0010\"\u001a\u00020\u00048\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u001aR\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010%\u001a\u0004\b&\u0010\u0010R\u0019\u0010\u0011\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010'\u001a\u0004\b(\u0010\tR\u001d\u0010\u0012\u001a\u00060\nj\u0002`\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010)\u001a\u0004\b*\u0010\r¨\u0006."}, d2 = {"Lcom/discord/widgets/servers/settings/invites/WidgetServerSettingsInstantInvites$Model$InviteItem;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "", "other", "", "compareTo", "(Lcom/discord/widgets/servers/settings/invites/WidgetServerSettingsInstantInvites$Model$InviteItem;)I", "Lcom/discord/models/domain/ModelInvite;", "component1", "()Lcom/discord/models/domain/ModelInvite;", "", "Lcom/discord/primitives/GuildId;", "component2", "()J", "Lcom/discord/models/member/GuildMember;", "component3", "()Lcom/discord/models/member/GuildMember;", "invite", "guildId", "guildMember", "copy", "(Lcom/discord/models/domain/ModelInvite;JLcom/discord/models/member/GuildMember;)Lcom/discord/widgets/servers/settings/invites/WidgetServerSettingsInstantInvites$Model$InviteItem;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "", "equals", "(Ljava/lang/Object;)Z", "key", "Ljava/lang/String;", "getKey", "type", "I", "getType", "Lcom/discord/models/member/GuildMember;", "getGuildMember", "Lcom/discord/models/domain/ModelInvite;", "getInvite", "J", "getGuildId", "<init>", "(Lcom/discord/models/domain/ModelInvite;JLcom/discord/models/member/GuildMember;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class InviteItem implements MGRecyclerDataPayload, Comparable<InviteItem> {

            /* renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            public static final int TYPE_INVITE = 0;
            private final long guildId;
            private final GuildMember guildMember;
            private final ModelInvite invite;
            private final String key;
            private final int type;

            /* compiled from: WidgetServerSettingsInstantInvites.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014JK\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\n\u0010\b\u001a\u00060\u0006j\u0002`\u00072\u0016\u0010\u000b\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\t\u0012\u0004\u0012\u00020\n0\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/servers/settings/invites/WidgetServerSettingsInstantInvites$Model$InviteItem$Companion;", "", "", "", "Lcom/discord/models/domain/ModelInvite;", "invites", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/member/GuildMember;", "guildMembers", "", "Lcom/discord/widgets/servers/settings/invites/WidgetServerSettingsInstantInvites$Model$InviteItem;", "createList", "(Ljava/util/Map;JLjava/util/Map;)Ljava/util/List;", "", "TYPE_INVITE", "I", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
            public static final class Companion {
                private Companion() {
                }

                public final List<InviteItem> createList(Map<String, ? extends ModelInvite> invites, long guildId, Map<Long, GuildMember> guildMembers) {
                    Intrinsics3.checkNotNullParameter(invites, "invites");
                    Intrinsics3.checkNotNullParameter(guildMembers, "guildMembers");
                    Collection<? extends ModelInvite> collectionValues = invites.values();
                    ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(collectionValues, 10));
                    for (ModelInvite modelInvite : collectionValues) {
                        User inviter = modelInvite.getInviter();
                        arrayList.add(new InviteItem(modelInvite, guildId, inviter != null ? guildMembers.get(Long.valueOf(inviter.getId())) : null));
                    }
                    return _Collections.sorted(arrayList);
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            public InviteItem(ModelInvite modelInvite, long j, GuildMember guildMember) {
                Intrinsics3.checkNotNullParameter(modelInvite, "invite");
                this.invite = modelInvite;
                this.guildId = j;
                this.guildMember = guildMember;
                String str = modelInvite.code;
                Intrinsics3.checkNotNullExpressionValue(str, "invite.code");
                this.key = str;
            }

            public static /* synthetic */ InviteItem copy$default(InviteItem inviteItem, ModelInvite modelInvite, long j, GuildMember guildMember, int i, Object obj) {
                if ((i & 1) != 0) {
                    modelInvite = inviteItem.invite;
                }
                if ((i & 2) != 0) {
                    j = inviteItem.guildId;
                }
                if ((i & 4) != 0) {
                    guildMember = inviteItem.guildMember;
                }
                return inviteItem.copy(modelInvite, j, guildMember);
            }

            @Override // java.lang.Comparable
            public /* bridge */ /* synthetic */ int compareTo(InviteItem inviteItem) {
                return compareTo2(inviteItem);
            }

            /* renamed from: component1, reason: from getter */
            public final ModelInvite getInvite() {
                return this.invite;
            }

            /* renamed from: component2, reason: from getter */
            public final long getGuildId() {
                return this.guildId;
            }

            /* renamed from: component3, reason: from getter */
            public final GuildMember getGuildMember() {
                return this.guildMember;
            }

            public final InviteItem copy(ModelInvite invite, long guildId, GuildMember guildMember) {
                Intrinsics3.checkNotNullParameter(invite, "invite");
                return new InviteItem(invite, guildId, guildMember);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof InviteItem)) {
                    return false;
                }
                InviteItem inviteItem = (InviteItem) other;
                return Intrinsics3.areEqual(this.invite, inviteItem.invite) && this.guildId == inviteItem.guildId && Intrinsics3.areEqual(this.guildMember, inviteItem.guildMember);
            }

            public final long getGuildId() {
                return this.guildId;
            }

            public final GuildMember getGuildMember() {
                return this.guildMember;
            }

            public final ModelInvite getInvite() {
                return this.invite;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
            public int getType() {
                return this.type;
            }

            public int hashCode() {
                ModelInvite modelInvite = this.invite;
                int iA = (b.a(this.guildId) + ((modelInvite != null ? modelInvite.hashCode() : 0) * 31)) * 31;
                GuildMember guildMember = this.guildMember;
                return iA + (guildMember != null ? guildMember.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("InviteItem(invite=");
                sbU.append(this.invite);
                sbU.append(", guildId=");
                sbU.append(this.guildId);
                sbU.append(", guildMember=");
                sbU.append(this.guildMember);
                sbU.append(")");
                return sbU.toString();
            }

            /* renamed from: compareTo, reason: avoid collision after fix types in other method */
            public int compareTo2(InviteItem other) {
                String username;
                String username2;
                Intrinsics3.checkNotNullParameter(other, "other");
                Channel channel = this.invite.getChannel();
                String strC = channel != null ? ChannelUtils.c(channel) : null;
                Channel channel2 = other.invite.getChannel();
                String strC2 = channel2 != null ? ChannelUtils.c(channel2) : null;
                int iCompareTo = (strC == null || strC2 == null) ? 0 : StringsJVM.compareTo(strC, strC2, true);
                User inviter = this.invite.getInviter();
                User inviter2 = other.invite.getInviter();
                if (iCompareTo != 0) {
                    return iCompareTo;
                }
                UserUtils userUtils = UserUtils.INSTANCE;
                if (inviter == null || (username = inviter.getUsername()) == null) {
                    username = "";
                }
                if (inviter2 == null || (username2 = inviter2.getUsername()) == null) {
                    username2 = "";
                }
                return userUtils.compareUserNames(username, username2, null, null, inviter != null ? inviter.getId() : 0L, inviter2 != null ? inviter2.getId() : 0L);
            }
        }

        public Model(Guild guild, List<InviteItem> list) {
            Intrinsics3.checkNotNullParameter(guild, "guild");
            this.guild = guild;
            this.inviteItems = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Model copy$default(Model model, Guild guild, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                guild = model.guild;
            }
            if ((i & 2) != 0) {
                list = model.inviteItems;
            }
            return model.copy(guild, list);
        }

        /* renamed from: component1, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        public final List<InviteItem> component2() {
            return this.inviteItems;
        }

        public final Model copy(Guild guild, List<InviteItem> inviteItems) {
            Intrinsics3.checkNotNullParameter(guild, "guild");
            return new Model(guild, inviteItems);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return Intrinsics3.areEqual(this.guild, model.guild) && Intrinsics3.areEqual(this.inviteItems, model.inviteItems);
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final List<InviteItem> getInviteItems() {
            return this.inviteItems;
        }

        public int hashCode() {
            Guild guild = this.guild;
            int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
            List<InviteItem> list = this.inviteItems;
            return iHashCode + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("Model(guild=");
            sbU.append(this.guild);
            sbU.append(", inviteItems=");
            return outline.L(sbU, this.inviteItems, ")");
        }
    }

    /* compiled from: WidgetServerSettingsInstantInvites.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/domain/ModelInvite;", "invite", "", "invoke", "(Lcom/discord/models/domain/ModelInvite;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.settings.invites.WidgetServerSettingsInstantInvites$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<ModelInvite, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelInvite modelInvite) {
            invoke2(modelInvite);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelInvite modelInvite) {
            Intrinsics3.checkNotNullParameter(modelInvite, "invite");
            WidgetServerSettingsInstantInvitesActions.Companion companion = WidgetServerSettingsInstantInvitesActions.INSTANCE;
            FragmentManager parentFragmentManager = WidgetServerSettingsInstantInvites.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            String str = modelInvite.code;
            Intrinsics3.checkNotNullExpressionValue(str, "invite.code");
            companion.create(parentFragmentManager, str);
        }
    }

    /* compiled from: WidgetServerSettingsInstantInvites.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/domain/ModelInvite;", "invite", "", "invoke", "(Lcom/discord/models/domain/ModelInvite;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.settings.invites.WidgetServerSettingsInstantInvites$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<ModelInvite, Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelInvite modelInvite) {
            invoke2(modelInvite);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelInvite modelInvite) {
            Intrinsics3.checkNotNullParameter(modelInvite, "invite");
            StoreStream.INSTANCE.getInstantInvites().onInviteRemoved(modelInvite);
        }
    }

    /* compiled from: WidgetServerSettingsInstantInvites.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/servers/settings/invites/WidgetServerSettingsInstantInvites$Model;", "p1", "", "invoke", "(Lcom/discord/widgets/servers/settings/invites/WidgetServerSettingsInstantInvites$Model;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.settings.invites.WidgetServerSettingsInstantInvites$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Model, Unit> {
        public AnonymousClass1(WidgetServerSettingsInstantInvites widgetServerSettingsInstantInvites) {
            super(1, widgetServerSettingsInstantInvites, WidgetServerSettingsInstantInvites.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/settings/invites/WidgetServerSettingsInstantInvites$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) throws Exception {
            invoke2(model);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) throws Exception {
            WidgetServerSettingsInstantInvites.access$configureUI((WidgetServerSettingsInstantInvites) this.receiver, model);
        }
    }

    public WidgetServerSettingsInstantInvites() {
        super(R.layout.widget_server_settings_instant_invites);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettingsInstantInvites5.INSTANCE, null, 2, null);
        this.guildId = LazyJVM.lazy(new WidgetServerSettingsInstantInvites6(this));
        this.storeInstantInvites = StoreStream.INSTANCE.getInstantInvites();
        this.loggingConfig = new AppLogger2(false, null, WidgetServerSettingsInstantInvites7.INSTANCE, 3);
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerSettingsInstantInvites widgetServerSettingsInstantInvites, Model model) throws Exception {
        widgetServerSettingsInstantInvites.configureUI(model);
    }

    private final void configureUI(Model data) throws Exception {
        if (data == null) {
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.onBackPressed();
                return;
            }
            return;
        }
        if (data.getInviteItems() == null) {
            AppViewFlipper appViewFlipper = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.serverSettingsInstantInvitesViewFlipper");
            appViewFlipper.setDisplayedChild(0);
        } else if (data.getInviteItems().isEmpty()) {
            AppViewFlipper appViewFlipper2 = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper2, "binding.serverSettingsInstantInvitesViewFlipper");
            appViewFlipper2.setDisplayedChild(2);
        } else {
            AppViewFlipper appViewFlipper3 = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper3, "binding.serverSettingsInstantInvitesViewFlipper");
            appViewFlipper3.setDisplayedChild(1);
            Adapter adapter = this.adapter;
            if (adapter != null) {
                adapter.configure(data.getInviteItems(), new AnonymousClass1(), AnonymousClass2.INSTANCE);
            }
        }
        setActionBarTitle(R.string.instant_invites);
        setActionBarSubtitle(data.getGuild().getName());
    }

    private final WidgetServerSettingsInstantInvitesBinding getBinding() {
        return (WidgetServerSettingsInstantInvitesBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
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
        RecyclerView recyclerView = getBinding().f2575b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.serverSettingsInstantInvitesRecycler");
        this.adapter = (Adapter) companion.configure(new Adapter(recyclerView));
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        this.storeInstantInvites.clearInvites(getGuildId());
        this.storeInstantInvites.fetchGuildInvites(getGuildId());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(Model.Companion.get$default(Model.INSTANCE, getGuildId(), null, null, 6, null), this, null, 2, null), WidgetServerSettingsInstantInvites.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }
}
