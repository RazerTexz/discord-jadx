package com.discord.widgets.channels.threads.browser;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.stores.ArchivedThreadsStore;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuildMemberRequester;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.threads.ThreadUtils;
import com.discord.widgets.channels.threads.browser.ThreadBrowserThreadView;
import com.discord.widgets.channels.threads.browser.WidgetThreadBrowserAdapter;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* compiled from: WidgetThreadBrowserArchivedViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 72\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0005789:;B[\u0012\n\u0010+\u001a\u00060)j\u0002`*\u0012\n\u00104\u001a\u00060)j\u0002`3\u0012\b\b\u0002\u00101\u001a\u000200\u0012\b\b\u0002\u0010!\u001a\u00020 \u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017\u0012\b\b\u0002\u0010'\u001a\u00020&\u0012\b\b\u0002\u0010$\u001a\u00020#\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b5\u00106J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\fH\u0007¢\u0006\u0004\b\u0011\u0010\u000fJ\r\u0010\u0012\u001a\u00020\u0005¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010$\u001a\u00020#8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010'\u001a\u00020&8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u001a\u0010+\u001a\u00060)j\u0002`*8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u001c\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00030-8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00101\u001a\u0002008\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u001a\u00104\u001a\u00060)j\u0002`38\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u0010,¨\u0006<"}, d2 = {"Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserArchivedViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserArchivedViewModel$ViewState;", "Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserArchivedViewModel$StoreState;", "storeState", "", "handleStoreState", "(Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserArchivedViewModel$StoreState;)V", "Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserArchivedViewModel$VisibilityMode;", "visibility", "onVisibilityChanged", "(Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserArchivedViewModel$VisibilityMode;)V", "", "isModeratorMode", "onModeratorModeChanged", "(Z)V", "force", "maybeLoadMore", "trackTabChanged", "()V", "Lcom/discord/stores/StoreGuildMemberRequester;", "storeGuildMemberRequester", "Lcom/discord/stores/StoreGuildMemberRequester;", "Lcom/discord/stores/StoreUser;", "storeUser", "Lcom/discord/stores/StoreUser;", "Lrx/subjects/BehaviorSubject;", "Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserArchivedViewModel$ViewMode;", "viewModeSubject", "Lrx/subjects/BehaviorSubject;", "canLoadMore", "Z", "Lcom/discord/stores/StoreChannels;", "storeChannels", "Lcom/discord/stores/StoreChannels;", "Lcom/discord/stores/StorePermissions;", "storePermissions", "Lcom/discord/stores/StorePermissions;", "Lcom/discord/stores/ArchivedThreadsStore;", "storeArchivedThreads", "Lcom/discord/stores/ArchivedThreadsStore;", "", "Lcom/discord/primitives/GuildId;", "guildId", "J", "Lrx/Observable;", "storeStateObservable", "Lrx/Observable;", "Lcom/discord/stores/StoreGuilds;", "storeGuilds", "Lcom/discord/stores/StoreGuilds;", "Lcom/discord/primitives/ChannelId;", "channelId", "<init>", "(JJLcom/discord/stores/StoreGuilds;Lcom/discord/stores/StoreChannels;Lcom/discord/stores/StoreUser;Lcom/discord/stores/ArchivedThreadsStore;Lcom/discord/stores/StorePermissions;Lcom/discord/stores/StoreGuildMemberRequester;)V", "Companion", "StoreState", "ViewMode", "ViewState", "VisibilityMode", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetThreadBrowserArchivedViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private boolean canLoadMore;
    private final long channelId;
    private final long guildId;
    private final ArchivedThreadsStore storeArchivedThreads;
    private final StoreChannels storeChannels;
    private final StoreGuildMemberRequester storeGuildMemberRequester;
    private final StoreGuilds storeGuilds;
    private final StorePermissions storePermissions;
    private final Observable<StoreState> storeStateObservable;
    private final StoreUser storeUser;
    private final BehaviorSubject<ViewMode> viewModeSubject;

    /* compiled from: WidgetThreadBrowserArchivedViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserArchivedViewModel$StoreState;", "storeState", "", "invoke", "(Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserArchivedViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserArchivedViewModel$1, reason: invalid class name */
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
            WidgetThreadBrowserArchivedViewModel.access$handleStoreState(WidgetThreadBrowserArchivedViewModel.this, storeState);
        }
    }

    /* compiled from: WidgetThreadBrowserArchivedViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018J]\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\n\u0010\b\u001a\u00060\u0004j\u0002`\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserArchivedViewModel$Companion;", "", "Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserArchivedViewModel$ViewMode;", "viewMode", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/primitives/ChannelId;", "channelId", "Lcom/discord/stores/StoreGuilds;", "storeGuilds", "Lcom/discord/stores/StoreChannels;", "storeChannels", "Lcom/discord/stores/StoreUser;", "storeUser", "Lcom/discord/stores/ArchivedThreadsStore;", "storeArchivedThreads", "Lcom/discord/stores/StorePermissions;", "storePermissions", "Lrx/Observable;", "Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserArchivedViewModel$StoreState;", "observeStoreState", "(Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserArchivedViewModel$ViewMode;JJLcom/discord/stores/StoreGuilds;Lcom/discord/stores/StoreChannels;Lcom/discord/stores/StoreUser;Lcom/discord/stores/ArchivedThreadsStore;Lcom/discord/stores/StorePermissions;)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStoreState(Companion companion, ViewMode viewMode, long j, long j2, StoreGuilds storeGuilds, StoreChannels storeChannels, StoreUser storeUser, ArchivedThreadsStore archivedThreadsStore, StorePermissions storePermissions) {
            return companion.observeStoreState(viewMode, j, j2, storeGuilds, storeChannels, storeUser, archivedThreadsStore, storePermissions);
        }

        private final Observable<StoreState> observeStoreState(ViewMode viewMode, long guildId, long channelId, StoreGuilds storeGuilds, StoreChannels storeChannels, StoreUser storeUser, ArchivedThreadsStore storeArchivedThreads, StorePermissions storePermissions) {
            Observable<StoreState> observableY = Observable.j(storeArchivedThreads.loadAndObserveThreadListing(channelId, viewMode.getThreadListingType()), storeChannels.observeChannel(channelId), WidgetThreadBrowserArchivedViewModel2.INSTANCE).Y(new WidgetThreadBrowserArchivedViewModel3(storeUser, storeGuilds, guildId, storePermissions, viewMode));
            Intrinsics3.checkNotNullExpressionValue(observableY, "Observable.combineLatest…            }\n          }");
            return observableY;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetThreadBrowserArchivedViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001Bq\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u0012\u0016\u0010\u001d\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u0005\u0012\u0016\u0010\u001e\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\u000b0\u0005\u0012\u0006\u0010\u001f\u001a\u00020\r\u0012\u0006\u0010 \u001a\u00020\u0010\u0012\u0006\u0010!\u001a\u00020\u0013\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0016\u0012\u000e\u0010#\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0019¢\u0006\u0004\b=\u0010>J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ \u0010\f\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\u000b0\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\nJ\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u001a\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0019HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u008a\u0001\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u001c\u001a\u00020\u00022\u0018\b\u0002\u0010\u001d\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u00052\u0018\b\u0002\u0010\u001e\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\u000b0\u00052\b\b\u0002\u0010\u001f\u001a\u00020\r2\b\b\u0002\u0010 \u001a\u00020\u00102\b\b\u0002\u0010!\u001a\u00020\u00132\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00162\u0010\b\u0002\u0010#\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0019HÆ\u0001¢\u0006\u0004\b$\u0010%J\u0010\u0010'\u001a\u00020&HÖ\u0001¢\u0006\u0004\b'\u0010(J\u0010\u0010*\u001a\u00020)HÖ\u0001¢\u0006\u0004\b*\u0010+J\u001a\u0010-\u001a\u00020\u00102\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b-\u0010.R\u0019\u0010 \u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b \u0010/\u001a\u0004\b \u0010\u0012R\u0019\u0010!\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b!\u00100\u001a\u0004\b1\u0010\u0015R\u0019\u0010\u001c\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u00102\u001a\u0004\b3\u0010\u0004R)\u0010\u001d\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u00104\u001a\u0004\b5\u0010\nR)\u0010\u001e\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\u000b0\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u00104\u001a\u0004\b6\u0010\nR\u0019\u0010\u001f\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u00107\u001a\u0004\b8\u0010\u000fR\u001b\u0010\"\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\"\u00109\u001a\u0004\b:\u0010\u0018R!\u0010#\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00198\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010;\u001a\u0004\b<\u0010\u001b¨\u0006?"}, d2 = {"Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserArchivedViewModel$StoreState;", "", "Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserArchivedViewModel$ViewMode;", "component1", "()Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserArchivedViewModel$ViewMode;", "", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/member/GuildMember;", "component2", "()Ljava/util/Map;", "Lcom/discord/models/user/User;", "component3", "Lcom/discord/stores/ArchivedThreadsStore$ThreadListingState;", "component4", "()Lcom/discord/stores/ArchivedThreadsStore$ThreadListingState;", "", "component5", "()Z", "Lcom/discord/api/channel/Channel;", "component6", "()Lcom/discord/api/channel/Channel;", "Lcom/discord/models/guild/Guild;", "component7", "()Lcom/discord/models/guild/Guild;", "Lcom/discord/api/permission/PermissionBit;", "component8", "()Ljava/lang/Long;", "viewMode", "guildMembers", "users", "listingState", "isModerator", "channel", "guild", ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS, "copy", "(Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserArchivedViewModel$ViewMode;Ljava/util/Map;Ljava/util/Map;Lcom/discord/stores/ArchivedThreadsStore$ThreadListingState;ZLcom/discord/api/channel/Channel;Lcom/discord/models/guild/Guild;Ljava/lang/Long;)Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserArchivedViewModel$StoreState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "Lcom/discord/api/channel/Channel;", "getChannel", "Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserArchivedViewModel$ViewMode;", "getViewMode", "Ljava/util/Map;", "getGuildMembers", "getUsers", "Lcom/discord/stores/ArchivedThreadsStore$ThreadListingState;", "getListingState", "Lcom/discord/models/guild/Guild;", "getGuild", "Ljava/lang/Long;", "getPermissions", "<init>", "(Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserArchivedViewModel$ViewMode;Ljava/util/Map;Ljava/util/Map;Lcom/discord/stores/ArchivedThreadsStore$ThreadListingState;ZLcom/discord/api/channel/Channel;Lcom/discord/models/guild/Guild;Ljava/lang/Long;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class StoreState {
        private final Channel channel;
        private final Guild guild;
        private final Map<Long, GuildMember> guildMembers;
        private final boolean isModerator;
        private final ArchivedThreadsStore.ThreadListingState listingState;
        private final Long permissions;
        private final Map<Long, User> users;
        private final ViewMode viewMode;

        /* JADX WARN: Multi-variable type inference failed */
        public StoreState(ViewMode viewMode, Map<Long, GuildMember> map, Map<Long, ? extends User> map2, ArchivedThreadsStore.ThreadListingState threadListingState, boolean z2, Channel channel, Guild guild, Long l) {
            Intrinsics3.checkNotNullParameter(viewMode, "viewMode");
            Intrinsics3.checkNotNullParameter(map, "guildMembers");
            Intrinsics3.checkNotNullParameter(map2, "users");
            Intrinsics3.checkNotNullParameter(threadListingState, "listingState");
            Intrinsics3.checkNotNullParameter(channel, "channel");
            this.viewMode = viewMode;
            this.guildMembers = map;
            this.users = map2;
            this.listingState = threadListingState;
            this.isModerator = z2;
            this.channel = channel;
            this.guild = guild;
            this.permissions = l;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, ViewMode viewMode, Map map, Map map2, ArchivedThreadsStore.ThreadListingState threadListingState, boolean z2, Channel channel, Guild guild, Long l, int i, Object obj) {
            return storeState.copy((i & 1) != 0 ? storeState.viewMode : viewMode, (i & 2) != 0 ? storeState.guildMembers : map, (i & 4) != 0 ? storeState.users : map2, (i & 8) != 0 ? storeState.listingState : threadListingState, (i & 16) != 0 ? storeState.isModerator : z2, (i & 32) != 0 ? storeState.channel : channel, (i & 64) != 0 ? storeState.guild : guild, (i & 128) != 0 ? storeState.permissions : l);
        }

        /* renamed from: component1, reason: from getter */
        public final ViewMode getViewMode() {
            return this.viewMode;
        }

        public final Map<Long, GuildMember> component2() {
            return this.guildMembers;
        }

        public final Map<Long, User> component3() {
            return this.users;
        }

        /* renamed from: component4, reason: from getter */
        public final ArchivedThreadsStore.ThreadListingState getListingState() {
            return this.listingState;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getIsModerator() {
            return this.isModerator;
        }

        /* renamed from: component6, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* renamed from: component7, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* renamed from: component8, reason: from getter */
        public final Long getPermissions() {
            return this.permissions;
        }

        public final StoreState copy(ViewMode viewMode, Map<Long, GuildMember> guildMembers, Map<Long, ? extends User> users, ArchivedThreadsStore.ThreadListingState listingState, boolean isModerator, Channel channel, Guild guild, Long permissions) {
            Intrinsics3.checkNotNullParameter(viewMode, "viewMode");
            Intrinsics3.checkNotNullParameter(guildMembers, "guildMembers");
            Intrinsics3.checkNotNullParameter(users, "users");
            Intrinsics3.checkNotNullParameter(listingState, "listingState");
            Intrinsics3.checkNotNullParameter(channel, "channel");
            return new StoreState(viewMode, guildMembers, users, listingState, isModerator, channel, guild, permissions);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.viewMode, storeState.viewMode) && Intrinsics3.areEqual(this.guildMembers, storeState.guildMembers) && Intrinsics3.areEqual(this.users, storeState.users) && Intrinsics3.areEqual(this.listingState, storeState.listingState) && this.isModerator == storeState.isModerator && Intrinsics3.areEqual(this.channel, storeState.channel) && Intrinsics3.areEqual(this.guild, storeState.guild) && Intrinsics3.areEqual(this.permissions, storeState.permissions);
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final Map<Long, GuildMember> getGuildMembers() {
            return this.guildMembers;
        }

        public final ArchivedThreadsStore.ThreadListingState getListingState() {
            return this.listingState;
        }

        public final Long getPermissions() {
            return this.permissions;
        }

        public final Map<Long, User> getUsers() {
            return this.users;
        }

        public final ViewMode getViewMode() {
            return this.viewMode;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            ViewMode viewMode = this.viewMode;
            int iHashCode = (viewMode != null ? viewMode.hashCode() : 0) * 31;
            Map<Long, GuildMember> map = this.guildMembers;
            int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
            Map<Long, User> map2 = this.users;
            int iHashCode3 = (iHashCode2 + (map2 != null ? map2.hashCode() : 0)) * 31;
            ArchivedThreadsStore.ThreadListingState threadListingState = this.listingState;
            int iHashCode4 = (iHashCode3 + (threadListingState != null ? threadListingState.hashCode() : 0)) * 31;
            boolean z2 = this.isModerator;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode4 + i) * 31;
            Channel channel = this.channel;
            int iHashCode5 = (i2 + (channel != null ? channel.hashCode() : 0)) * 31;
            Guild guild = this.guild;
            int iHashCode6 = (iHashCode5 + (guild != null ? guild.hashCode() : 0)) * 31;
            Long l = this.permissions;
            return iHashCode6 + (l != null ? l.hashCode() : 0);
        }

        public final boolean isModerator() {
            return this.isModerator;
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(viewMode=");
            sbU.append(this.viewMode);
            sbU.append(", guildMembers=");
            sbU.append(this.guildMembers);
            sbU.append(", users=");
            sbU.append(this.users);
            sbU.append(", listingState=");
            sbU.append(this.listingState);
            sbU.append(", isModerator=");
            sbU.append(this.isModerator);
            sbU.append(", channel=");
            sbU.append(this.channel);
            sbU.append(", guild=");
            sbU.append(this.guild);
            sbU.append(", permissions=");
            return outline.G(sbU, this.permissions, ")");
        }
    }

    /* compiled from: WidgetThreadBrowserArchivedViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0016\u001a\u00020\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u001a\u001a\u0004\b\t\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004¨\u0006\u001f"}, d2 = {"Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserArchivedViewModel$ViewMode;", "", "Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserArchivedViewModel$VisibilityMode;", "component1", "()Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserArchivedViewModel$VisibilityMode;", "", "component2", "()Z", "visibility", "isModeratorMode", "copy", "(Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserArchivedViewModel$VisibilityMode;Z)Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserArchivedViewModel$ViewMode;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/stores/ArchivedThreadsStore$ThreadListingType;", "threadListingType", "Lcom/discord/stores/ArchivedThreadsStore$ThreadListingType;", "getThreadListingType", "()Lcom/discord/stores/ArchivedThreadsStore$ThreadListingType;", "Z", "Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserArchivedViewModel$VisibilityMode;", "getVisibility", "<init>", "(Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserArchivedViewModel$VisibilityMode;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ViewMode {
        private final boolean isModeratorMode;
        private final ArchivedThreadsStore.ThreadListingType threadListingType;
        private final VisibilityMode visibility;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                VisibilityMode.values();
                int[] iArr = new int[2];
                $EnumSwitchMapping$0 = iArr;
                iArr[VisibilityMode.PublicThreads.ordinal()] = 1;
            }
        }

        public ViewMode(VisibilityMode visibilityMode, boolean z2) {
            ArchivedThreadsStore.ThreadListingType threadListingType;
            Intrinsics3.checkNotNullParameter(visibilityMode, "visibility");
            this.visibility = visibilityMode;
            this.isModeratorMode = z2;
            if (visibilityMode.ordinal() == 0) {
                threadListingType = ArchivedThreadsStore.ThreadListingType.ALL_ARCHIVED_PUBLIC_THREADS;
            } else if (!z2) {
                threadListingType = ArchivedThreadsStore.ThreadListingType.MY_ARCHIVED_PRIVATE_THREADS;
            } else {
                if (!z2) {
                    throw new NoWhenBranchMatchedException();
                }
                threadListingType = ArchivedThreadsStore.ThreadListingType.ALL_ARCHIVED_PRIVATE_THREADS;
            }
            this.threadListingType = threadListingType;
        }

        public static /* synthetic */ ViewMode copy$default(ViewMode viewMode, VisibilityMode visibilityMode, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                visibilityMode = viewMode.visibility;
            }
            if ((i & 2) != 0) {
                z2 = viewMode.isModeratorMode;
            }
            return viewMode.copy(visibilityMode, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final VisibilityMode getVisibility() {
            return this.visibility;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getIsModeratorMode() {
            return this.isModeratorMode;
        }

        public final ViewMode copy(VisibilityMode visibility, boolean isModeratorMode) {
            Intrinsics3.checkNotNullParameter(visibility, "visibility");
            return new ViewMode(visibility, isModeratorMode);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewMode)) {
                return false;
            }
            ViewMode viewMode = (ViewMode) other;
            return Intrinsics3.areEqual(this.visibility, viewMode.visibility) && this.isModeratorMode == viewMode.isModeratorMode;
        }

        public final ArchivedThreadsStore.ThreadListingType getThreadListingType() {
            return this.threadListingType;
        }

        public final VisibilityMode getVisibility() {
            return this.visibility;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            VisibilityMode visibilityMode = this.visibility;
            int iHashCode = (visibilityMode != null ? visibilityMode.hashCode() : 0) * 31;
            boolean z2 = this.isModeratorMode;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode + i;
        }

        public final boolean isModeratorMode() {
            return this.isModeratorMode;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ViewMode(visibility=");
            sbU.append(this.visibility);
            sbU.append(", isModeratorMode=");
            return outline.O(sbU, this.isModeratorMode, ")");
        }
    }

    /* compiled from: WidgetThreadBrowserArchivedViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\t¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\f\u0010\u000bJ\u0010\u0010\r\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\r\u0010\u000bJH\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0010\u001a\u00020\t2\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001c\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u0019\u0010\u0011\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010 \u001a\u0004\b\u0011\u0010\u000bR\u001f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010!\u001a\u0004\b\"\u0010\bR\u0019\u0010\u0010\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010 \u001a\u0004\b\u0010\u0010\u000bR\u0019\u0010\u0012\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010 \u001a\u0004\b#\u0010\u000b¨\u0006&"}, d2 = {"Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserArchivedViewModel$ViewState;", "", "Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserArchivedViewModel$ViewMode;", "component1", "()Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserArchivedViewModel$ViewMode;", "", "Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserAdapter$Item;", "component2", "()Ljava/util/List;", "", "component3", "()Z", "component4", "component5", "viewMode", "listItems", "isModerator", "isError", "canCreateThread", "copy", "(Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserArchivedViewModel$ViewMode;Ljava/util/List;ZZZ)Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserArchivedViewModel$ViewState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserArchivedViewModel$ViewMode;", "getViewMode", "Z", "Ljava/util/List;", "getListItems", "getCanCreateThread", "<init>", "(Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserArchivedViewModel$ViewMode;Ljava/util/List;ZZZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ViewState {
        private final boolean canCreateThread;
        private final boolean isError;
        private final boolean isModerator;
        private final List<WidgetThreadBrowserAdapter.Item> listItems;
        private final ViewMode viewMode;

        /* JADX WARN: Multi-variable type inference failed */
        public ViewState(ViewMode viewMode, List<? extends WidgetThreadBrowserAdapter.Item> list, boolean z2, boolean z3, boolean z4) {
            Intrinsics3.checkNotNullParameter(viewMode, "viewMode");
            Intrinsics3.checkNotNullParameter(list, "listItems");
            this.viewMode = viewMode;
            this.listItems = list;
            this.isModerator = z2;
            this.isError = z3;
            this.canCreateThread = z4;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, ViewMode viewMode, List list, boolean z2, boolean z3, boolean z4, int i, Object obj) {
            if ((i & 1) != 0) {
                viewMode = viewState.viewMode;
            }
            if ((i & 2) != 0) {
                list = viewState.listItems;
            }
            List list2 = list;
            if ((i & 4) != 0) {
                z2 = viewState.isModerator;
            }
            boolean z5 = z2;
            if ((i & 8) != 0) {
                z3 = viewState.isError;
            }
            boolean z6 = z3;
            if ((i & 16) != 0) {
                z4 = viewState.canCreateThread;
            }
            return viewState.copy(viewMode, list2, z5, z6, z4);
        }

        /* renamed from: component1, reason: from getter */
        public final ViewMode getViewMode() {
            return this.viewMode;
        }

        public final List<WidgetThreadBrowserAdapter.Item> component2() {
            return this.listItems;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getIsModerator() {
            return this.isModerator;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getIsError() {
            return this.isError;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getCanCreateThread() {
            return this.canCreateThread;
        }

        public final ViewState copy(ViewMode viewMode, List<? extends WidgetThreadBrowserAdapter.Item> listItems, boolean isModerator, boolean isError, boolean canCreateThread) {
            Intrinsics3.checkNotNullParameter(viewMode, "viewMode");
            Intrinsics3.checkNotNullParameter(listItems, "listItems");
            return new ViewState(viewMode, listItems, isModerator, isError, canCreateThread);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return Intrinsics3.areEqual(this.viewMode, viewState.viewMode) && Intrinsics3.areEqual(this.listItems, viewState.listItems) && this.isModerator == viewState.isModerator && this.isError == viewState.isError && this.canCreateThread == viewState.canCreateThread;
        }

        public final boolean getCanCreateThread() {
            return this.canCreateThread;
        }

        public final List<WidgetThreadBrowserAdapter.Item> getListItems() {
            return this.listItems;
        }

        public final ViewMode getViewMode() {
            return this.viewMode;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            ViewMode viewMode = this.viewMode;
            int iHashCode = (viewMode != null ? viewMode.hashCode() : 0) * 31;
            List<WidgetThreadBrowserAdapter.Item> list = this.listItems;
            int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
            boolean z2 = this.isModerator;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode2 + i) * 31;
            boolean z3 = this.isError;
            int i3 = z3;
            if (z3 != 0) {
                i3 = 1;
            }
            int i4 = (i2 + i3) * 31;
            boolean z4 = this.canCreateThread;
            return i4 + (z4 ? 1 : z4 ? 1 : 0);
        }

        public final boolean isError() {
            return this.isError;
        }

        public final boolean isModerator() {
            return this.isModerator;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ViewState(viewMode=");
            sbU.append(this.viewMode);
            sbU.append(", listItems=");
            sbU.append(this.listItems);
            sbU.append(", isModerator=");
            sbU.append(this.isModerator);
            sbU.append(", isError=");
            sbU.append(this.isError);
            sbU.append(", canCreateThread=");
            return outline.O(sbU, this.canCreateThread, ")");
        }
    }

    /* compiled from: WidgetThreadBrowserArchivedViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserArchivedViewModel$VisibilityMode;", "", "<init>", "(Ljava/lang/String;I)V", "PublicThreads", "PrivateThreads", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public enum VisibilityMode {
        PublicThreads,
        PrivateThreads
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            VisibilityMode.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[VisibilityMode.PublicThreads.ordinal()] = 1;
            iArr[VisibilityMode.PrivateThreads.ordinal()] = 2;
            ArchivedThreadsStore.ThreadListingType.values();
            int[] iArr2 = new int[3];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[ArchivedThreadsStore.ThreadListingType.ALL_ARCHIVED_PUBLIC_THREADS.ordinal()] = 1;
            iArr2[ArchivedThreadsStore.ThreadListingType.MY_ARCHIVED_PRIVATE_THREADS.ordinal()] = 2;
            iArr2[ArchivedThreadsStore.ThreadListingType.ALL_ARCHIVED_PRIVATE_THREADS.ordinal()] = 3;
        }
    }

    public /* synthetic */ WidgetThreadBrowserArchivedViewModel(long j, long j2, StoreGuilds storeGuilds, StoreChannels storeChannels, StoreUser storeUser, ArchivedThreadsStore archivedThreadsStore, StorePermissions storePermissions, StoreGuildMemberRequester storeGuildMemberRequester, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, (i & 4) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds, (i & 8) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels, (i & 16) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser, (i & 32) != 0 ? StoreStream.INSTANCE.getArchivedThreads() : archivedThreadsStore, (i & 64) != 0 ? StoreStream.INSTANCE.getPermissions() : storePermissions, (i & 128) != 0 ? StoreStream.INSTANCE.getGuildMemberRequester() : storeGuildMemberRequester);
    }

    public static final /* synthetic */ long access$getChannelId$p(WidgetThreadBrowserArchivedViewModel widgetThreadBrowserArchivedViewModel) {
        return widgetThreadBrowserArchivedViewModel.channelId;
    }

    public static final /* synthetic */ long access$getGuildId$p(WidgetThreadBrowserArchivedViewModel widgetThreadBrowserArchivedViewModel) {
        return widgetThreadBrowserArchivedViewModel.guildId;
    }

    public static final /* synthetic */ ArchivedThreadsStore access$getStoreArchivedThreads$p(WidgetThreadBrowserArchivedViewModel widgetThreadBrowserArchivedViewModel) {
        return widgetThreadBrowserArchivedViewModel.storeArchivedThreads;
    }

    public static final /* synthetic */ StoreChannels access$getStoreChannels$p(WidgetThreadBrowserArchivedViewModel widgetThreadBrowserArchivedViewModel) {
        return widgetThreadBrowserArchivedViewModel.storeChannels;
    }

    public static final /* synthetic */ StoreGuilds access$getStoreGuilds$p(WidgetThreadBrowserArchivedViewModel widgetThreadBrowserArchivedViewModel) {
        return widgetThreadBrowserArchivedViewModel.storeGuilds;
    }

    public static final /* synthetic */ StorePermissions access$getStorePermissions$p(WidgetThreadBrowserArchivedViewModel widgetThreadBrowserArchivedViewModel) {
        return widgetThreadBrowserArchivedViewModel.storePermissions;
    }

    public static final /* synthetic */ StoreUser access$getStoreUser$p(WidgetThreadBrowserArchivedViewModel widgetThreadBrowserArchivedViewModel) {
        return widgetThreadBrowserArchivedViewModel.storeUser;
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetThreadBrowserArchivedViewModel widgetThreadBrowserArchivedViewModel, StoreState storeState) {
        widgetThreadBrowserArchivedViewModel.handleStoreState(storeState);
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        int i;
        ThreadBrowserThreadView.TimestampMode timestampMode;
        ViewMode viewMode = storeState.getViewMode();
        ArrayList arrayList = new ArrayList();
        boolean zIsModerator = storeState.isModerator();
        ArchivedThreadsStore.ThreadListingState listingState = storeState.getListingState();
        if (listingState instanceof ArchivedThreadsStore.ThreadListingState.Listing) {
            Channel channel = storeState.getChannel();
            if (channel != null && channel.getType() == 15) {
                arrayList.add(new WidgetThreadBrowserAdapter.Item.Warning(null, 1, null));
            }
            ArchivedThreadsStore.ThreadListingState.Listing listing = (ArchivedThreadsStore.ThreadListingState.Listing) listingState;
            if (!listing.getThreads().isEmpty()) {
                int iOrdinal = viewMode.getVisibility().ordinal();
                if (iOrdinal == 0) {
                    i = R.string.thread_browser_public_header;
                } else {
                    if (iOrdinal != 1) {
                        throw new NoWhenBranchMatchedException();
                    }
                    i = R.string.thread_browser_private_header;
                }
                arrayList.add(new WidgetThreadBrowserAdapter.Item.Header("header", i, listing.getThreads().size()));
                for (Channel channel2 : listing.getThreads()) {
                    User user = storeState.getUsers().get(Long.valueOf(channel2.getOwnerId()));
                    if (user == null || !storeState.getGuildMembers().containsKey(Long.valueOf(channel2.getOwnerId()))) {
                        this.storeGuildMemberRequester.queueRequest(channel2.getGuildId(), channel2.getOwnerId());
                    }
                    Map<Long, GuildMember> guildMembers = storeState.getGuildMembers();
                    boolean z2 = viewMode.getThreadListingType() == ArchivedThreadsStore.ThreadListingType.MY_ARCHIVED_PRIVATE_THREADS;
                    if (z2) {
                        timestampMode = ThreadBrowserThreadView.TimestampMode.CreatedAt;
                    } else {
                        if (z2) {
                            throw new NoWhenBranchMatchedException();
                        }
                        timestampMode = ThreadBrowserThreadView.TimestampMode.ArchivedAt;
                    }
                    arrayList.add(new WidgetThreadBrowserAdapter.Item.Thread(new ThreadBrowserThreadView.ThreadData.ArchivedThread(channel2, guildMembers, user, timestampMode)));
                }
            }
            if (listing.isLoadingMore()) {
                arrayList.add(new WidgetThreadBrowserAdapter.Item.Loading(null, 1, null));
            }
            this.canLoadMore = !listing.isLoadingMore() && listing.getHasMore();
        } else {
            if (!(listingState instanceof ArchivedThreadsStore.ThreadListingState.Uninitialized)) {
                boolean z3 = listingState instanceof ArchivedThreadsStore.ThreadListingState.Error;
                this.storeGuildMemberRequester.performQueuedRequests();
                updateViewState(new ViewState(viewMode, arrayList, zIsModerator, z3, ThreadUtils.INSTANCE.canCreateThread(storeState.getPermissions(), storeState.getChannel(), null, storeState.getGuild())));
            }
            arrayList.add(new WidgetThreadBrowserAdapter.Item.Loading(null, 1, null));
        }
        this.storeGuildMemberRequester.performQueuedRequests();
        updateViewState(new ViewState(viewMode, arrayList, zIsModerator, z3, ThreadUtils.INSTANCE.canCreateThread(storeState.getPermissions(), storeState.getChannel(), null, storeState.getGuild())));
    }

    public static /* synthetic */ void maybeLoadMore$default(WidgetThreadBrowserArchivedViewModel widgetThreadBrowserArchivedViewModel, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        widgetThreadBrowserArchivedViewModel.maybeLoadMore(z2);
    }

    @MainThread
    public final void maybeLoadMore(boolean force) {
        if (this.canLoadMore || force) {
            ArchivedThreadsStore.fetchListing$default(this.storeArchivedThreads, this.channelId, this.viewModeSubject.n0().getThreadListingType(), false, null, 12, null);
        }
    }

    @MainThread
    public final void onModeratorModeChanged(boolean isModeratorMode) {
        BehaviorSubject<ViewMode> behaviorSubject = this.viewModeSubject;
        behaviorSubject.onNext(ViewMode.copy$default(behaviorSubject.n0(), null, isModeratorMode, 1, null));
        trackTabChanged();
    }

    @MainThread
    public final void onVisibilityChanged(VisibilityMode visibility) {
        Intrinsics3.checkNotNullParameter(visibility, "visibility");
        BehaviorSubject<ViewMode> behaviorSubject = this.viewModeSubject;
        behaviorSubject.onNext(ViewMode.copy$default(behaviorSubject.n0(), visibility, false, 2, null));
        trackTabChanged();
    }

    public final void trackTabChanged() {
        String str;
        ViewMode viewModeN0 = this.viewModeSubject.n0();
        if (viewModeN0 != null) {
            int iOrdinal = viewModeN0.getThreadListingType().ordinal();
            if (iOrdinal == 0) {
                str = "My Private Archived Threads";
            } else if (iOrdinal == 1) {
                str = "Public Archived Threads";
            } else {
                if (iOrdinal != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                str = "All Private Archived Threads";
            }
            StoreStream.INSTANCE.getAnalytics().trackThreadBrowserTabChanged(this.channelId, str);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetThreadBrowserArchivedViewModel(long j, long j2, StoreGuilds storeGuilds, StoreChannels storeChannels, StoreUser storeUser, ArchivedThreadsStore archivedThreadsStore, StorePermissions storePermissions, StoreGuildMemberRequester storeGuildMemberRequester) {
        super(null, 1, null);
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        Intrinsics3.checkNotNullParameter(storeChannels, "storeChannels");
        Intrinsics3.checkNotNullParameter(storeUser, "storeUser");
        Intrinsics3.checkNotNullParameter(archivedThreadsStore, "storeArchivedThreads");
        Intrinsics3.checkNotNullParameter(storePermissions, "storePermissions");
        Intrinsics3.checkNotNullParameter(storeGuildMemberRequester, "storeGuildMemberRequester");
        this.guildId = j;
        this.channelId = j2;
        this.storeGuilds = storeGuilds;
        this.storeChannels = storeChannels;
        this.storeUser = storeUser;
        this.storeArchivedThreads = archivedThreadsStore;
        this.storePermissions = storePermissions;
        this.storeGuildMemberRequester = storeGuildMemberRequester;
        BehaviorSubject<ViewMode> behaviorSubjectL0 = BehaviorSubject.l0(new ViewMode(VisibilityMode.PublicThreads, false));
        Intrinsics3.checkNotNullExpressionValue(behaviorSubjectL0, "BehaviorSubject.create(\n…rMode = false\n      )\n  )");
        this.viewModeSubject = behaviorSubjectL0;
        Observable observableY = behaviorSubjectL0.Y(new WidgetThreadBrowserArchivedViewModel4(this));
        Intrinsics3.checkNotNullExpressionValue(observableY, "viewModeSubject\n        …            )\n          }");
        this.storeStateObservable = observableY;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableY, this, null, 2, null), WidgetThreadBrowserArchivedViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
