package com.discord.widgets.channels.permissions;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.api.role.GuildRole;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGatewayConnection;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.channels.permissions.AddMemberAdapter;
import com.discord.widgets.channels.permissions.PermissionOwner;
import d0.g0.Strings4;
import d0.t.CollectionsJVM;
import d0.t.Iterables2;
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
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: WidgetChannelSettingsAddMemberFragmentViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 >2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003>?@BS\u0012\n\u00100\u001a\u00060\u0014j\u0002`/\u0012\u0006\u00108\u001a\u00020\u0017\u0012\b\b\u0002\u0010!\u001a\u00020 \u0012\b\b\u0002\u00103\u001a\u000202\u0012\b\b\u0002\u0010-\u001a\u00020,\u0012\b\b\u0002\u00106\u001a\u000205\u0012\u000e\b\u0002\u0010;\u001a\b\u0012\u0004\u0012\u00020\b0:¢\u0006\u0004\b<\u0010=J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J%\u0010\u0018\u001a\u00020\u00172\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\u0010\u0016\u001a\u00060\u0014j\u0002`\u0015H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u001a\u0010\u0007J\u001d\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fR\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R2\u0010%\u001a\u001e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u001c0#j\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u001c`$8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\"\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010\u0007R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010+R\u0016\u0010-\u001a\u00020,8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u001a\u00100\u001a\u00060\u0014j\u0002`/8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00103\u001a\u0002028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00106\u001a\u0002058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u00108\u001a\u00020\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109¨\u0006A"}, d2 = {"Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsAddMemberFragmentViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsAddMemberFragmentViewModel$ViewState;", "", "query", "", "requestMembers", "(Ljava/lang/String;)V", "Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsAddMemberFragmentViewModel$StoreState;", "storeState", "handleStoreState", "(Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsAddMemberFragmentViewModel$StoreState;)V", "generateViewState", "(Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsAddMemberFragmentViewModel$StoreState;)Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsAddMemberFragmentViewModel$ViewState;", "", "Lcom/discord/widgets/channels/permissions/AddMemberAdapter$Item;", "makeAdapterItems", "(Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsAddMemberFragmentViewModel$StoreState;)Ljava/util/List;", "Lcom/discord/api/permission/PermissionOverwrite;", "overwrite", "", "Lcom/discord/api/permission/PermissionBit;", "permission", "", "isPermissionOverrideAlreadyPresent", "(Lcom/discord/api/permission/PermissionOverwrite;J)Z", "updateQuery", ModelAuditLogEntry.CHANGE_KEY_ID, "Lcom/discord/api/permission/PermissionOverwrite$Type;", "type", "toggleItem", "(JLcom/discord/api/permission/PermissionOverwrite$Type;)V", "Lcom/discord/stores/StoreChannels;", "channelsStore", "Lcom/discord/stores/StoreChannels;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "selected", "Ljava/util/HashMap;", "Ljava/lang/String;", "getQuery", "()Ljava/lang/String;", "setQuery", "Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsAddMemberFragmentViewModel$StoreState;", "Lcom/discord/stores/StoreUser;", "userStore", "Lcom/discord/stores/StoreUser;", "Lcom/discord/primitives/ChannelId;", "channelId", "J", "Lcom/discord/stores/StoreGuilds;", "guildsStore", "Lcom/discord/stores/StoreGuilds;", "Lcom/discord/stores/StoreGatewayConnection;", "gatewaySocket", "Lcom/discord/stores/StoreGatewayConnection;", "showRolesWithGuildPermission", "Z", "Lrx/Observable;", "storeStateObservable", "<init>", "(JZLcom/discord/stores/StoreChannels;Lcom/discord/stores/StoreGuilds;Lcom/discord/stores/StoreUser;Lcom/discord/stores/StoreGatewayConnection;Lrx/Observable;)V", "Companion", "StoreState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChannelSettingsAddMemberFragmentViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long channelId;
    private final StoreChannels channelsStore;
    private final StoreGatewayConnection gatewaySocket;
    private final StoreGuilds guildsStore;
    private String query;
    private final HashMap<Long, PermissionOverwrite.Type> selected;
    private final boolean showRolesWithGuildPermission;
    private StoreState storeState;
    private final StoreUser userStore;

    /* compiled from: WidgetChannelSettingsAddMemberFragmentViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsAddMemberFragmentViewModel$StoreState;", "storeState", "", "invoke", "(Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsAddMemberFragmentViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsAddMemberFragmentViewModel$1, reason: invalid class name */
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
            Intrinsics3.checkNotNullParameter(storeState, "storeState");
            WidgetChannelSettingsAddMemberFragmentViewModel.access$handleStoreState(WidgetChannelSettingsAddMemberFragmentViewModel.this, storeState);
        }
    }

    /* compiled from: WidgetChannelSettingsAddMemberFragmentViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J9\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsAddMemberFragmentViewModel$Companion;", "", "", "Lcom/discord/primitives/ChannelId;", "channelId", "Lcom/discord/stores/StoreChannels;", "channelsStore", "Lcom/discord/stores/StoreGuilds;", "guildsStore", "Lcom/discord/stores/StoreUser;", "userStore", "Lrx/Observable;", "Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsAddMemberFragmentViewModel$StoreState;", "observeStoreState", "(JLcom/discord/stores/StoreChannels;Lcom/discord/stores/StoreGuilds;Lcom/discord/stores/StoreUser;)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStoreState(Companion companion, long j, StoreChannels storeChannels, StoreGuilds storeGuilds, StoreUser storeUser) {
            return companion.observeStoreState(j, storeChannels, storeGuilds, storeUser);
        }

        private final Observable<StoreState> observeStoreState(long channelId, StoreChannels channelsStore, StoreGuilds guildsStore, StoreUser userStore) {
            Observable<R> observableG = channelsStore.observeChannel(channelId).y(ObservableExtensionsKt.AnonymousClass1.INSTANCE).G(ObservableExtensionsKt.AnonymousClass2.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
            Observable<StoreState> observableY = observableG.r().Y(new WidgetChannelSettingsAddMemberFragmentViewModel2(guildsStore, userStore));
            Intrinsics3.checkNotNullExpressionValue(observableY, "channelsStore.observeCha…          }\n            }");
            return observableY;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetChannelSettingsAddMemberFragmentViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001Bu\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b\u0012\u0016\u0010\u0018\u001a\u0012\u0012\b\u0012\u00060\tj\u0002`\r\u0012\u0004\u0012\u00020\u000e0\b\u0012\u0016\u0010\u0019\u001a\u0012\u0012\b\u0012\u00060\tj\u0002`\u0010\u0012\u0004\u0012\u00020\u00110\b\u0012\u0016\u0010\u001a\u001a\u0012\u0012\b\u0012\u00060\tj\u0002`\u0010\u0012\u0004\u0012\u00020\u00130\b¢\u0006\u0004\b0\u00101J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u000f\u001a\u0012\u0012\b\u0012\u00060\tj\u0002`\r\u0012\u0004\u0012\u00020\u000e0\bHÆ\u0003¢\u0006\u0004\b\u000f\u0010\fJ \u0010\u0012\u001a\u0012\u0012\b\u0012\u00060\tj\u0002`\u0010\u0012\u0004\u0012\u00020\u00110\bHÆ\u0003¢\u0006\u0004\b\u0012\u0010\fJ \u0010\u0014\u001a\u0012\u0012\b\u0012\u00060\tj\u0002`\u0010\u0012\u0004\u0012\u00020\u00130\bHÆ\u0003¢\u0006\u0004\b\u0014\u0010\fJ\u008a\u0001\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00052\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\u0018\b\u0002\u0010\u0018\u001a\u0012\u0012\b\u0012\u00060\tj\u0002`\r\u0012\u0004\u0012\u00020\u000e0\b2\u0018\b\u0002\u0010\u0019\u001a\u0012\u0012\b\u0012\u00060\tj\u0002`\u0010\u0012\u0004\u0012\u00020\u00110\b2\u0018\b\u0002\u0010\u001a\u001a\u0012\u0012\b\u0012\u00060\tj\u0002`\u0010\u0012\u0004\u0012\u00020\u00130\bHÆ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010!\u001a\u00020 HÖ\u0001¢\u0006\u0004\b!\u0010\"J\u001a\u0010%\u001a\u00020$2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b%\u0010&R%\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010'\u001a\u0004\b(\u0010\fR)\u0010\u0018\u001a\u0012\u0012\b\u0012\u00060\tj\u0002`\r\u0012\u0004\u0012\u00020\u000e0\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010'\u001a\u0004\b)\u0010\fR)\u0010\u0019\u001a\u0012\u0012\b\u0012\u00060\tj\u0002`\u0010\u0012\u0004\u0012\u00020\u00110\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010'\u001a\u0004\b*\u0010\fR)\u0010\u001a\u001a\u0012\u0012\b\u0012\u00060\tj\u0002`\u0010\u0012\u0004\u0012\u00020\u00130\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010'\u001a\u0004\b+\u0010\fR\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010,\u001a\u0004\b-\u0010\u0004R\u0019\u0010\u0016\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010.\u001a\u0004\b/\u0010\u0007¨\u00062"}, d2 = {"Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsAddMemberFragmentViewModel$StoreState;", "", "Lcom/discord/models/guild/Guild;", "component1", "()Lcom/discord/models/guild/Guild;", "Lcom/discord/api/channel/Channel;", "component2", "()Lcom/discord/api/channel/Channel;", "", "", "Lcom/discord/api/permission/PermissionOverwrite;", "component3", "()Ljava/util/Map;", "Lcom/discord/primitives/RoleId;", "Lcom/discord/api/role/GuildRole;", "component4", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/member/GuildMember;", "component5", "Lcom/discord/models/user/User;", "component6", "guild", "channel", "channelPermissionOverwritesMap", "roles", "members", "users", "copy", "(Lcom/discord/models/guild/Guild;Lcom/discord/api/channel/Channel;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsAddMemberFragmentViewModel$StoreState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Map;", "getChannelPermissionOverwritesMap", "getRoles", "getMembers", "getUsers", "Lcom/discord/models/guild/Guild;", "getGuild", "Lcom/discord/api/channel/Channel;", "getChannel", "<init>", "(Lcom/discord/models/guild/Guild;Lcom/discord/api/channel/Channel;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class StoreState {
        private final Channel channel;
        private final Map<Long, PermissionOverwrite> channelPermissionOverwritesMap;
        private final Guild guild;
        private final Map<Long, GuildMember> members;
        private final Map<Long, GuildRole> roles;
        private final Map<Long, User> users;

        /* JADX WARN: Multi-variable type inference failed */
        public StoreState(Guild guild, Channel channel, Map<Long, PermissionOverwrite> map, Map<Long, GuildRole> map2, Map<Long, GuildMember> map3, Map<Long, ? extends User> map4) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Intrinsics3.checkNotNullParameter(map, "channelPermissionOverwritesMap");
            Intrinsics3.checkNotNullParameter(map2, "roles");
            Intrinsics3.checkNotNullParameter(map3, "members");
            Intrinsics3.checkNotNullParameter(map4, "users");
            this.guild = guild;
            this.channel = channel;
            this.channelPermissionOverwritesMap = map;
            this.roles = map2;
            this.members = map3;
            this.users = map4;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, Guild guild, Channel channel, Map map, Map map2, Map map3, Map map4, int i, Object obj) {
            if ((i & 1) != 0) {
                guild = storeState.guild;
            }
            if ((i & 2) != 0) {
                channel = storeState.channel;
            }
            Channel channel2 = channel;
            if ((i & 4) != 0) {
                map = storeState.channelPermissionOverwritesMap;
            }
            Map map5 = map;
            if ((i & 8) != 0) {
                map2 = storeState.roles;
            }
            Map map6 = map2;
            if ((i & 16) != 0) {
                map3 = storeState.members;
            }
            Map map7 = map3;
            if ((i & 32) != 0) {
                map4 = storeState.users;
            }
            return storeState.copy(guild, channel2, map5, map6, map7, map4);
        }

        /* renamed from: component1, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* renamed from: component2, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        public final Map<Long, PermissionOverwrite> component3() {
            return this.channelPermissionOverwritesMap;
        }

        public final Map<Long, GuildRole> component4() {
            return this.roles;
        }

        public final Map<Long, GuildMember> component5() {
            return this.members;
        }

        public final Map<Long, User> component6() {
            return this.users;
        }

        public final StoreState copy(Guild guild, Channel channel, Map<Long, PermissionOverwrite> channelPermissionOverwritesMap, Map<Long, GuildRole> roles, Map<Long, GuildMember> members, Map<Long, ? extends User> users) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Intrinsics3.checkNotNullParameter(channelPermissionOverwritesMap, "channelPermissionOverwritesMap");
            Intrinsics3.checkNotNullParameter(roles, "roles");
            Intrinsics3.checkNotNullParameter(members, "members");
            Intrinsics3.checkNotNullParameter(users, "users");
            return new StoreState(guild, channel, channelPermissionOverwritesMap, roles, members, users);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.guild, storeState.guild) && Intrinsics3.areEqual(this.channel, storeState.channel) && Intrinsics3.areEqual(this.channelPermissionOverwritesMap, storeState.channelPermissionOverwritesMap) && Intrinsics3.areEqual(this.roles, storeState.roles) && Intrinsics3.areEqual(this.members, storeState.members) && Intrinsics3.areEqual(this.users, storeState.users);
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final Map<Long, PermissionOverwrite> getChannelPermissionOverwritesMap() {
            return this.channelPermissionOverwritesMap;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final Map<Long, GuildMember> getMembers() {
            return this.members;
        }

        public final Map<Long, GuildRole> getRoles() {
            return this.roles;
        }

        public final Map<Long, User> getUsers() {
            return this.users;
        }

        public int hashCode() {
            Guild guild = this.guild;
            int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
            Channel channel = this.channel;
            int iHashCode2 = (iHashCode + (channel != null ? channel.hashCode() : 0)) * 31;
            Map<Long, PermissionOverwrite> map = this.channelPermissionOverwritesMap;
            int iHashCode3 = (iHashCode2 + (map != null ? map.hashCode() : 0)) * 31;
            Map<Long, GuildRole> map2 = this.roles;
            int iHashCode4 = (iHashCode3 + (map2 != null ? map2.hashCode() : 0)) * 31;
            Map<Long, GuildMember> map3 = this.members;
            int iHashCode5 = (iHashCode4 + (map3 != null ? map3.hashCode() : 0)) * 31;
            Map<Long, User> map4 = this.users;
            return iHashCode5 + (map4 != null ? map4.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(guild=");
            sbU.append(this.guild);
            sbU.append(", channel=");
            sbU.append(this.channel);
            sbU.append(", channelPermissionOverwritesMap=");
            sbU.append(this.channelPermissionOverwritesMap);
            sbU.append(", roles=");
            sbU.append(this.roles);
            sbU.append(", members=");
            sbU.append(this.members);
            sbU.append(", users=");
            return outline.M(sbU, this.users, ")");
        }
    }

    /* compiled from: WidgetChannelSettingsAddMemberFragmentViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\b\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f¢\u0006\u0004\b-\u0010.J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u001c\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013JV\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\b2\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fHÆ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u001b\u0010\nJ\u0010\u0010\u001d\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010!\u001a\u00020 2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b!\u0010\"R\u0019\u0010\u0016\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010#\u001a\u0004\b$\u0010\nR\u001f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010%\u001a\u0004\b&\u0010\u000eR\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010'\u001a\u0004\b(\u0010\u0004R\u0019\u0010\u0015\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010)\u001a\u0004\b*\u0010\u0007R%\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010+\u001a\u0004\b,\u0010\u0013¨\u0006/"}, d2 = {"Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsAddMemberFragmentViewModel$ViewState;", "", "Lcom/discord/models/guild/Guild;", "component1", "()Lcom/discord/models/guild/Guild;", "Lcom/discord/api/channel/Channel;", "component2", "()Lcom/discord/api/channel/Channel;", "", "component3", "()Ljava/lang/String;", "", "Lcom/discord/widgets/channels/permissions/AddMemberAdapter$Item;", "component4", "()Ljava/util/List;", "", "", "Lcom/discord/api/permission/PermissionOverwrite$Type;", "component5", "()Ljava/util/Map;", "guild", "channel", "query", "items", "selected", "copy", "(Lcom/discord/models/guild/Guild;Lcom/discord/api/channel/Channel;Ljava/lang/String;Ljava/util/List;Ljava/util/Map;)Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsAddMemberFragmentViewModel$ViewState;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getQuery", "Ljava/util/List;", "getItems", "Lcom/discord/models/guild/Guild;", "getGuild", "Lcom/discord/api/channel/Channel;", "getChannel", "Ljava/util/Map;", "getSelected", "<init>", "(Lcom/discord/models/guild/Guild;Lcom/discord/api/channel/Channel;Ljava/lang/String;Ljava/util/List;Ljava/util/Map;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ViewState {
        private final Channel channel;
        private final Guild guild;
        private final List<AddMemberAdapter.Item> items;
        private final String query;
        private final Map<Long, PermissionOverwrite.Type> selected;

        /* JADX WARN: Multi-variable type inference failed */
        public ViewState(Guild guild, Channel channel, String str, List<? extends AddMemberAdapter.Item> list, Map<Long, ? extends PermissionOverwrite.Type> map) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Intrinsics3.checkNotNullParameter(str, "query");
            Intrinsics3.checkNotNullParameter(list, "items");
            Intrinsics3.checkNotNullParameter(map, "selected");
            this.guild = guild;
            this.channel = channel;
            this.query = str;
            this.items = list;
            this.selected = map;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, Guild guild, Channel channel, String str, List list, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                guild = viewState.guild;
            }
            if ((i & 2) != 0) {
                channel = viewState.channel;
            }
            Channel channel2 = channel;
            if ((i & 4) != 0) {
                str = viewState.query;
            }
            String str2 = str;
            if ((i & 8) != 0) {
                list = viewState.items;
            }
            List list2 = list;
            if ((i & 16) != 0) {
                map = viewState.selected;
            }
            return viewState.copy(guild, channel2, str2, list2, map);
        }

        /* renamed from: component1, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* renamed from: component2, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* renamed from: component3, reason: from getter */
        public final String getQuery() {
            return this.query;
        }

        public final List<AddMemberAdapter.Item> component4() {
            return this.items;
        }

        public final Map<Long, PermissionOverwrite.Type> component5() {
            return this.selected;
        }

        public final ViewState copy(Guild guild, Channel channel, String query, List<? extends AddMemberAdapter.Item> items, Map<Long, ? extends PermissionOverwrite.Type> selected) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Intrinsics3.checkNotNullParameter(query, "query");
            Intrinsics3.checkNotNullParameter(items, "items");
            Intrinsics3.checkNotNullParameter(selected, "selected");
            return new ViewState(guild, channel, query, items, selected);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return Intrinsics3.areEqual(this.guild, viewState.guild) && Intrinsics3.areEqual(this.channel, viewState.channel) && Intrinsics3.areEqual(this.query, viewState.query) && Intrinsics3.areEqual(this.items, viewState.items) && Intrinsics3.areEqual(this.selected, viewState.selected);
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final List<AddMemberAdapter.Item> getItems() {
            return this.items;
        }

        public final String getQuery() {
            return this.query;
        }

        public final Map<Long, PermissionOverwrite.Type> getSelected() {
            return this.selected;
        }

        public int hashCode() {
            Guild guild = this.guild;
            int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
            Channel channel = this.channel;
            int iHashCode2 = (iHashCode + (channel != null ? channel.hashCode() : 0)) * 31;
            String str = this.query;
            int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
            List<AddMemberAdapter.Item> list = this.items;
            int iHashCode4 = (iHashCode3 + (list != null ? list.hashCode() : 0)) * 31;
            Map<Long, PermissionOverwrite.Type> map = this.selected;
            return iHashCode4 + (map != null ? map.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("ViewState(guild=");
            sbU.append(this.guild);
            sbU.append(", channel=");
            sbU.append(this.channel);
            sbU.append(", query=");
            sbU.append(this.query);
            sbU.append(", items=");
            sbU.append(this.items);
            sbU.append(", selected=");
            return outline.M(sbU, this.selected, ")");
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetChannelSettingsAddMemberFragmentViewModel(long j, boolean z2, StoreChannels storeChannels, StoreGuilds storeGuilds, StoreUser storeUser, StoreGatewayConnection storeGatewayConnection, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        StoreChannels channels = (i & 4) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels;
        StoreGuilds guilds = (i & 8) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds;
        StoreUser users = (i & 16) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser;
        this(j, z2, channels, guilds, users, (i & 32) != 0 ? StoreStream.INSTANCE.getGatewaySocket() : storeGatewayConnection, (i & 64) != 0 ? Companion.access$observeStoreState(INSTANCE, j, channels, guilds, users) : observable);
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetChannelSettingsAddMemberFragmentViewModel widgetChannelSettingsAddMemberFragmentViewModel, StoreState storeState) {
        widgetChannelSettingsAddMemberFragmentViewModel.handleStoreState(storeState);
    }

    private final ViewState generateViewState(StoreState storeState) {
        return new ViewState(storeState.getGuild(), storeState.getChannel(), this.query, makeAdapterItems(storeState), this.selected);
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        this.storeState = storeState;
        updateViewState(generateViewState(storeState));
    }

    private final boolean isPermissionOverrideAlreadyPresent(PermissionOverwrite overwrite, long permission) {
        return overwrite != null && (overwrite.getAllow() & permission) == permission;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0090  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final List<AddMemberAdapter.Item> makeAdapterItems(StoreState storeState) {
        AddMemberAdapter.Item.PermissionOwnerItem.Companion.AddStatus cannotAdd;
        boolean z2;
        Guild guild = storeState.getGuild();
        Map<Long, PermissionOverwrite> channelPermissionOverwritesMap = storeState.getChannelPermissionOverwritesMap();
        String str = this.query;
        Objects.requireNonNull(str, "null cannot be cast to non-null type kotlin.CharSequence");
        String string = Strings4.trim(str).toString();
        Collection<GuildRole> collectionValues = storeState.getRoles().values();
        ArrayList<GuildRole> arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            GuildRole guildRole = (GuildRole) obj;
            if ((guildRole.getPermissions() & 8) == 0) {
                z2 = (guild == null || guildRole.getId() != guild.getId()) && (this.showRolesWithGuildPermission || !PermissionUtils.INSTANCE.canRole(20971536L, guildRole, channelPermissionOverwritesMap.get(Long.valueOf(guildRole.getId())))) && !isPermissionOverrideAlreadyPresent(channelPermissionOverwritesMap.get(Long.valueOf(guildRole.getId())), 20971536L) && Strings4.contains((CharSequence) guildRole.getName(), (CharSequence) string, true);
            }
            if (z2) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, 10));
        for (GuildRole guildRole2 : arrayList) {
            boolean zCanRole = PermissionUtils.INSTANCE.canRole(20971536L, guildRole2, channelPermissionOverwritesMap.get(Long.valueOf(guildRole2.getId())));
            PermissionOwner.Role role = new PermissionOwner.Role(guildRole2);
            boolean z3 = zCanRole || this.selected.containsKey(Long.valueOf(guildRole2.getId()));
            if (zCanRole) {
                cannotAdd = new AddMemberAdapter.Item.PermissionOwnerItem.Companion.AddStatus.CannotAdd(AddMemberAdapter.Item.PermissionOwnerItem.Companion.AddStatus.CannotAdd.Reason.HAS_GUILD_PERMISSIONS);
            } else {
                if (zCanRole) {
                    throw new NoWhenBranchMatchedException();
                }
                cannotAdd = AddMemberAdapter.Item.PermissionOwnerItem.Companion.AddStatus.CanAdd.INSTANCE;
            }
            arrayList2.add(new AddMemberAdapter.Item.PermissionOwnerItem(role, z3, cannotAdd));
        }
        Set<Map.Entry<Long, GuildMember>> setEntrySet = storeState.getMembers().entrySet();
        ArrayList arrayList3 = new ArrayList();
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            User user = storeState.getUsers().get(entry.getKey());
            Tuples2 tuples2 = user == null ? null : new Tuples2((GuildMember) entry.getValue(), user);
            if (tuples2 != null) {
                arrayList3.add(tuples2);
            }
        }
        ArrayList<Tuples2> arrayList4 = new ArrayList();
        for (Object obj2 : arrayList3) {
            Tuples2 tuples22 = (Tuples2) obj2;
            GuildMember guildMember = (GuildMember) tuples22.component1();
            User user2 = (User) tuples22.component2();
            if (((guild != null ? guild.isOwner(user2.getId()) : false) || isPermissionOverrideAlreadyPresent((PermissionOverwrite) outline.f(user2, channelPermissionOverwritesMap), 20971536L) || (!Strings4.contains((CharSequence) user2.getUsername(), (CharSequence) string, true) && (guildMember.getNick() == null || !Strings4.contains((CharSequence) guildMember.getNick(), (CharSequence) string, true)))) ? false : true) {
                arrayList4.add(obj2);
            }
        }
        ArrayList arrayList5 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList4, 10));
        for (Tuples2 tuples23 : arrayList4) {
            GuildMember guildMember2 = (GuildMember) tuples23.component1();
            User user3 = (User) tuples23.component2();
            arrayList5.add(new AddMemberAdapter.Item.PermissionOwnerItem(new PermissionOwner.Member(user3, guildMember2.getNick(), guild != null && guild.isOwner(user3.getId())), this.selected.containsKey(Long.valueOf(user3.getId())), AddMemberAdapter.Item.PermissionOwnerItem.Companion.AddStatus.CanAdd.INSTANCE));
        }
        return _Collections.plus((Collection) _Collections.plus((Collection) _Collections.plus((Collection) CollectionsJVM.listOf(new AddMemberAdapter.Item.CategoryItem(AddMemberAdapter.Item.CategoryItem.Companion.CategoryType.ROLE)), (Iterable) arrayList2), (Iterable) CollectionsJVM.listOf(new AddMemberAdapter.Item.CategoryItem(AddMemberAdapter.Item.CategoryItem.Companion.CategoryType.MEMBER))), (Iterable) arrayList5);
    }

    private final void requestMembers(String query) {
        Guild guild;
        StoreState storeState = this.storeState;
        if (storeState == null || (guild = storeState.getGuild()) == null) {
            return;
        }
        long id2 = guild.getId();
        StoreGatewayConnection storeGatewayConnection = this.gatewaySocket;
        Objects.requireNonNull(query, "null cannot be cast to non-null type kotlin.CharSequence");
        storeGatewayConnection.requestGuildMembers(id2, Strings4.trim(query).toString(), null, 20);
    }

    public final String getQuery() {
        return this.query;
    }

    public final void setQuery(String str) {
        Intrinsics3.checkNotNullParameter(str, "<set-?>");
        this.query = str;
    }

    public final void toggleItem(long id2, PermissionOverwrite.Type type) {
        Intrinsics3.checkNotNullParameter(type, "type");
        if (this.selected.containsKey(Long.valueOf(id2))) {
            this.selected.remove(Long.valueOf(id2));
        } else {
            this.selected.put(Long.valueOf(id2), type);
        }
        StoreState storeState = this.storeState;
        if (storeState != null) {
            updateViewState(generateViewState(storeState));
        }
    }

    public final void updateQuery(String query) {
        Intrinsics3.checkNotNullParameter(query, "query");
        this.query = query;
        StoreState storeState = this.storeState;
        if (storeState != null) {
            updateViewState(generateViewState(storeState));
        }
        requestMembers(query);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelSettingsAddMemberFragmentViewModel(long j, boolean z2, StoreChannels storeChannels, StoreGuilds storeGuilds, StoreUser storeUser, StoreGatewayConnection storeGatewayConnection, Observable<StoreState> observable) {
        super(null, 1, null);
        Intrinsics3.checkNotNullParameter(storeChannels, "channelsStore");
        Intrinsics3.checkNotNullParameter(storeGuilds, "guildsStore");
        Intrinsics3.checkNotNullParameter(storeUser, "userStore");
        Intrinsics3.checkNotNullParameter(storeGatewayConnection, "gatewaySocket");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.channelId = j;
        this.showRolesWithGuildPermission = z2;
        this.channelsStore = storeChannels;
        this.guildsStore = storeGuilds;
        this.userStore = storeUser;
        this.gatewaySocket = storeGatewayConnection;
        this.query = "";
        this.selected = new HashMap<>();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), WidgetChannelSettingsAddMemberFragmentViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
