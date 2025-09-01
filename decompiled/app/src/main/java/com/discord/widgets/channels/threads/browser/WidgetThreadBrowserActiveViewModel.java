package com.discord.widgets.channels.threads.browser;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.role.GuildRole;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuildMemberRequester;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreThreadMessages;
import com.discord.stores.StoreThreadsActive;
import com.discord.stores.StoreThreadsActiveJoined;
import com.discord.stores.StoreUser;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.threads.ThreadUtils;
import com.discord.widgets.channels.threads.browser.ThreadBrowserThreadView;
import com.discord.widgets.channels.threads.browser.WidgetThreadBrowserAdapter;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Tuples3;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: WidgetThreadBrowserActiveViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 *2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003*+,B\u007f\u0012\n\u0010%\u001a\u00060\bj\u0002`$\u0012\n\u0010\n\u001a\u00060\bj\u0002`\t\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001e\u0012\b\b\u0002\u0010\"\u001a\u00020!\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001b\u0012\u000e\b\u0002\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00030&¢\u0006\u0004\b(\u0010)J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\n\u001a\u00060\bj\u0002`\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u001a\u0010%\u001a\u00060\bj\u0002`$8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010\u000b¨\u0006-"}, d2 = {"Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserActiveViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserActiveViewModel$ViewState;", "Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserActiveViewModel$StoreState;", "storeState", "", "handleStoreState", "(Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserActiveViewModel$StoreState;)V", "", "Lcom/discord/primitives/ChannelId;", "channelId", "J", "Lcom/discord/stores/StoreUser;", "storeUser", "Lcom/discord/stores/StoreUser;", "Lcom/discord/stores/StoreThreadMessages;", "storeThreadMessages", "Lcom/discord/stores/StoreThreadMessages;", "Lcom/discord/stores/StoreChannels;", "storeChannels", "Lcom/discord/stores/StoreChannels;", "Lcom/discord/stores/StoreThreadsActiveJoined;", "storeThreadsActiveJoined", "Lcom/discord/stores/StoreThreadsActiveJoined;", "Lcom/discord/stores/StoreGuilds;", "storeGuilds", "Lcom/discord/stores/StoreGuilds;", "Lcom/discord/stores/StorePermissions;", "storePermissions", "Lcom/discord/stores/StorePermissions;", "Lcom/discord/stores/StoreGuildMemberRequester;", "storeGuildMemberRequester", "Lcom/discord/stores/StoreGuildMemberRequester;", "Lcom/discord/stores/StoreThreadsActive;", "storeThreadsActive", "Lcom/discord/stores/StoreThreadsActive;", "Lcom/discord/primitives/GuildId;", "guildId", "Lrx/Observable;", "storeStateObservable", "<init>", "(JJLcom/discord/stores/StoreUser;Lcom/discord/stores/StoreGuildMemberRequester;Lcom/discord/stores/StoreThreadsActive;Lcom/discord/stores/StoreThreadsActiveJoined;Lcom/discord/stores/StoreThreadMessages;Lcom/discord/stores/StoreGuilds;Lcom/discord/stores/StoreChannels;Lcom/discord/stores/StorePermissions;Lrx/Observable;)V", "Companion", "StoreState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetThreadBrowserActiveViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long channelId;
    private final long guildId;
    private final StoreChannels storeChannels;
    private final StoreGuildMemberRequester storeGuildMemberRequester;
    private final StoreGuilds storeGuilds;
    private final StorePermissions storePermissions;
    private final StoreThreadMessages storeThreadMessages;
    private final StoreThreadsActive storeThreadsActive;
    private final StoreThreadsActiveJoined storeThreadsActiveJoined;
    private final StoreUser storeUser;

    /* compiled from: WidgetThreadBrowserActiveViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserActiveViewModel$StoreState;", "storeState", "", "invoke", "(Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserActiveViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserActiveViewModel$1, reason: invalid class name */
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
            WidgetThreadBrowserActiveViewModel.access$handleStoreState(WidgetThreadBrowserActiveViewModel.this, storeState);
        }
    }

    /* compiled from: WidgetThreadBrowserActiveViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0019\u0010\u001aJe\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserActiveViewModel$Companion;", "", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/primitives/ChannelId;", "channelId", "Lcom/discord/stores/StoreUser;", "storeUser", "Lcom/discord/stores/StoreThreadsActive;", "storeThreadsActive", "Lcom/discord/stores/StoreThreadsActiveJoined;", "storeThreadsActiveJoined", "Lcom/discord/stores/StoreThreadMessages;", "storeThreadMessages", "Lcom/discord/stores/StoreGuilds;", "storeGuilds", "Lcom/discord/stores/StoreChannels;", "storeChannels", "Lcom/discord/stores/StorePermissions;", "storePermissions", "Lrx/Observable;", "Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserActiveViewModel$StoreState;", "observeStoreState", "(JJLcom/discord/stores/StoreUser;Lcom/discord/stores/StoreThreadsActive;Lcom/discord/stores/StoreThreadsActiveJoined;Lcom/discord/stores/StoreThreadMessages;Lcom/discord/stores/StoreGuilds;Lcom/discord/stores/StoreChannels;Lcom/discord/stores/StorePermissions;)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStoreState(Companion companion, long j, long j2, StoreUser storeUser, StoreThreadsActive storeThreadsActive, StoreThreadsActiveJoined storeThreadsActiveJoined, StoreThreadMessages storeThreadMessages, StoreGuilds storeGuilds, StoreChannels storeChannels, StorePermissions storePermissions) {
            return companion.observeStoreState(j, j2, storeUser, storeThreadsActive, storeThreadsActiveJoined, storeThreadMessages, storeGuilds, storeChannels, storePermissions);
        }

        private final Observable<StoreState> observeStoreState(long guildId, long channelId, StoreUser storeUser, StoreThreadsActive storeThreadsActive, StoreThreadsActiveJoined storeThreadsActiveJoined, StoreThreadMessages storeThreadMessages, StoreGuilds storeGuilds, StoreChannels storeChannels, StorePermissions storePermissions) {
            Observable<StoreState> observableY = Observable.j(storeThreadsActiveJoined.observeActiveJoinedThreadsForChannel(guildId, channelId).G(WidgetThreadBrowserActiveViewModel2.INSTANCE), storeThreadsActive.observeActiveThreadsForChannel(guildId, Long.valueOf(channelId)), WidgetThreadBrowserActiveViewModel3.INSTANCE).Y(new WidgetThreadBrowserActiveViewModel4(storeUser, storeThreadMessages, storeGuilds, guildId, storeChannels, storePermissions, channelId));
            Intrinsics3.checkNotNullExpressionValue(observableY, "Observable.combineLatest…            }\n          }");
            return observableY;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetThreadBrowserActiveViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001B÷\u0001\u0012\u0006\u0010#\u001a\u00020\u0002\u0012\u0016\u0010$\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u0005\u0012\u0016\u0010%\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u0005\u0012\u0016\u0010&\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\f0\u0005\u0012\u0016\u0010'\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u000e\u0012\u0004\u0012\u00020\u000f0\u0005\u0012\u0016\u0010(\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u000e\u0012\u0004\u0012\u00020\u00110\u0005\u0012\u0016\u0010)\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0013\u0012\u0004\u0012\u00020\u00140\u0005\u0012\u0016\u0010*\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\u00160\u0005\u0012\u000e\u0010+\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0018\u0012\u001a\u0010,\u001a\u0016\u0012\b\u0012\u00060\u0006j\u0002`\u000e\u0012\b\u0012\u00060\u001bj\u0002`\u001c0\u0005\u0012\b\u0010-\u001a\u0004\u0018\u00010\b\u0012\b\u0010.\u001a\u0004\u0018\u00010 ¢\u0006\u0004\bJ\u0010KJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ \u0010\u000b\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u0005HÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ \u0010\r\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\f0\u0005HÆ\u0003¢\u0006\u0004\b\r\u0010\nJ \u0010\u0010\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u000e\u0012\u0004\u0012\u00020\u000f0\u0005HÆ\u0003¢\u0006\u0004\b\u0010\u0010\nJ \u0010\u0012\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u000e\u0012\u0004\u0012\u00020\u00110\u0005HÆ\u0003¢\u0006\u0004\b\u0012\u0010\nJ \u0010\u0015\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0013\u0012\u0004\u0012\u00020\u00140\u0005HÆ\u0003¢\u0006\u0004\b\u0015\u0010\nJ \u0010\u0017\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\u00160\u0005HÆ\u0003¢\u0006\u0004\b\u0017\u0010\nJ\u0018\u0010\u0019\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0018HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ$\u0010\u001d\u001a\u0016\u0012\b\u0012\u00060\u0006j\u0002`\u000e\u0012\b\u0012\u00060\u001bj\u0002`\u001c0\u0005HÆ\u0003¢\u0006\u0004\b\u001d\u0010\nJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0012\u0010!\u001a\u0004\u0018\u00010 HÆ\u0003¢\u0006\u0004\b!\u0010\"J\u0098\u0002\u0010/\u001a\u00020\u00002\b\b\u0002\u0010#\u001a\u00020\u00022\u0018\b\u0002\u0010$\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u00052\u0018\b\u0002\u0010%\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u00052\u0018\b\u0002\u0010&\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\f0\u00052\u0018\b\u0002\u0010'\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u000e\u0012\u0004\u0012\u00020\u000f0\u00052\u0018\b\u0002\u0010(\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u000e\u0012\u0004\u0012\u00020\u00110\u00052\u0018\b\u0002\u0010)\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0013\u0012\u0004\u0012\u00020\u00140\u00052\u0018\b\u0002\u0010*\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\u00160\u00052\u0010\b\u0002\u0010+\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00182\u001c\b\u0002\u0010,\u001a\u0016\u0012\b\u0012\u00060\u0006j\u0002`\u000e\u0012\b\u0012\u00060\u001bj\u0002`\u001c0\u00052\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010 HÆ\u0001¢\u0006\u0004\b/\u00100J\u0010\u00101\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b1\u00102J\u0010\u00103\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b3\u00104J\u001a\u00107\u001a\u0002062\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b7\u00108R)\u0010%\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u00058\u0006@\u0006¢\u0006\f\n\u0004\b%\u00109\u001a\u0004\b:\u0010\nR)\u0010)\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0013\u0012\u0004\u0012\u00020\u00140\u00058\u0006@\u0006¢\u0006\f\n\u0004\b)\u00109\u001a\u0004\b;\u0010\nR\u001b\u0010-\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010<\u001a\u0004\b=\u0010\u001fR-\u0010,\u001a\u0016\u0012\b\u0012\u00060\u0006j\u0002`\u000e\u0012\b\u0012\u00060\u001bj\u0002`\u001c0\u00058\u0006@\u0006¢\u0006\f\n\u0004\b,\u00109\u001a\u0004\b>\u0010\nR)\u0010*\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\u00160\u00058\u0006@\u0006¢\u0006\f\n\u0004\b*\u00109\u001a\u0004\b?\u0010\nR)\u0010$\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u00058\u0006@\u0006¢\u0006\f\n\u0004\b$\u00109\u001a\u0004\b@\u0010\nR\u0019\u0010#\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010A\u001a\u0004\bB\u0010\u0004R\u001b\u0010.\u001a\u0004\u0018\u00010 8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010C\u001a\u0004\bD\u0010\"R)\u0010'\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u000e\u0012\u0004\u0012\u00020\u000f0\u00058\u0006@\u0006¢\u0006\f\n\u0004\b'\u00109\u001a\u0004\bE\u0010\nR)\u0010(\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u000e\u0012\u0004\u0012\u00020\u00110\u00058\u0006@\u0006¢\u0006\f\n\u0004\b(\u00109\u001a\u0004\bF\u0010\nR)\u0010&\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\f0\u00058\u0006@\u0006¢\u0006\f\n\u0004\b&\u00109\u001a\u0004\bG\u0010\nR!\u0010+\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00188\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010H\u001a\u0004\bI\u0010\u001a¨\u0006L"}, d2 = {"Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserActiveViewModel$StoreState;", "", "Lcom/discord/models/user/MeUser;", "component1", "()Lcom/discord/models/user/MeUser;", "", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/channel/Channel;", "component2", "()Ljava/util/Map;", "component3", "Lcom/discord/stores/StoreThreadMessages$ThreadState;", "component4", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/member/GuildMember;", "component5", "Lcom/discord/models/user/User;", "component6", "Lcom/discord/primitives/RoleId;", "Lcom/discord/api/role/GuildRole;", "component7", "", "component8", "Lcom/discord/api/permission/PermissionBit;", "component9", "()Ljava/lang/Long;", "", "Lcom/discord/primitives/RelationshipType;", "component10", "component11", "()Lcom/discord/api/channel/Channel;", "Lcom/discord/models/guild/Guild;", "component12", "()Lcom/discord/models/guild/Guild;", "meUser", "activeJoinedThreads", "activeThreads", "threadStates", "guildMembers", "users", "guildRoles", "channelNames", ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS, "blockedUsers", "channel", "guild", "copy", "(Lcom/discord/models/user/MeUser;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/lang/Long;Ljava/util/Map;Lcom/discord/api/channel/Channel;Lcom/discord/models/guild/Guild;)Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserActiveViewModel$StoreState;", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Map;", "getActiveThreads", "getGuildRoles", "Lcom/discord/api/channel/Channel;", "getChannel", "getBlockedUsers", "getChannelNames", "getActiveJoinedThreads", "Lcom/discord/models/user/MeUser;", "getMeUser", "Lcom/discord/models/guild/Guild;", "getGuild", "getGuildMembers", "getUsers", "getThreadStates", "Ljava/lang/Long;", "getPermissions", "<init>", "(Lcom/discord/models/user/MeUser;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/lang/Long;Ljava/util/Map;Lcom/discord/api/channel/Channel;Lcom/discord/models/guild/Guild;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class StoreState {
        private final Map<Long, Channel> activeJoinedThreads;
        private final Map<Long, Channel> activeThreads;
        private final Map<Long, Integer> blockedUsers;
        private final Channel channel;
        private final Map<Long, String> channelNames;
        private final Guild guild;
        private final Map<Long, GuildMember> guildMembers;
        private final Map<Long, GuildRole> guildRoles;
        private final MeUser meUser;
        private final Long permissions;
        private final Map<Long, StoreThreadMessages.ThreadState> threadStates;
        private final Map<Long, User> users;

        /* JADX WARN: Multi-variable type inference failed */
        public StoreState(MeUser meUser, Map<Long, Channel> map, Map<Long, Channel> map2, Map<Long, StoreThreadMessages.ThreadState> map3, Map<Long, GuildMember> map4, Map<Long, ? extends User> map5, Map<Long, GuildRole> map6, Map<Long, String> map7, Long l, Map<Long, Integer> map8, Channel channel, Guild guild) {
            Intrinsics3.checkNotNullParameter(meUser, "meUser");
            Intrinsics3.checkNotNullParameter(map, "activeJoinedThreads");
            Intrinsics3.checkNotNullParameter(map2, "activeThreads");
            Intrinsics3.checkNotNullParameter(map3, "threadStates");
            Intrinsics3.checkNotNullParameter(map4, "guildMembers");
            Intrinsics3.checkNotNullParameter(map5, "users");
            Intrinsics3.checkNotNullParameter(map6, "guildRoles");
            Intrinsics3.checkNotNullParameter(map7, "channelNames");
            Intrinsics3.checkNotNullParameter(map8, "blockedUsers");
            this.meUser = meUser;
            this.activeJoinedThreads = map;
            this.activeThreads = map2;
            this.threadStates = map3;
            this.guildMembers = map4;
            this.users = map5;
            this.guildRoles = map6;
            this.channelNames = map7;
            this.permissions = l;
            this.blockedUsers = map8;
            this.channel = channel;
            this.guild = guild;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, MeUser meUser, Map map, Map map2, Map map3, Map map4, Map map5, Map map6, Map map7, Long l, Map map8, Channel channel, Guild guild, int i, Object obj) {
            return storeState.copy((i & 1) != 0 ? storeState.meUser : meUser, (i & 2) != 0 ? storeState.activeJoinedThreads : map, (i & 4) != 0 ? storeState.activeThreads : map2, (i & 8) != 0 ? storeState.threadStates : map3, (i & 16) != 0 ? storeState.guildMembers : map4, (i & 32) != 0 ? storeState.users : map5, (i & 64) != 0 ? storeState.guildRoles : map6, (i & 128) != 0 ? storeState.channelNames : map7, (i & 256) != 0 ? storeState.permissions : l, (i & 512) != 0 ? storeState.blockedUsers : map8, (i & 1024) != 0 ? storeState.channel : channel, (i & 2048) != 0 ? storeState.guild : guild);
        }

        /* renamed from: component1, reason: from getter */
        public final MeUser getMeUser() {
            return this.meUser;
        }

        public final Map<Long, Integer> component10() {
            return this.blockedUsers;
        }

        /* renamed from: component11, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* renamed from: component12, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        public final Map<Long, Channel> component2() {
            return this.activeJoinedThreads;
        }

        public final Map<Long, Channel> component3() {
            return this.activeThreads;
        }

        public final Map<Long, StoreThreadMessages.ThreadState> component4() {
            return this.threadStates;
        }

        public final Map<Long, GuildMember> component5() {
            return this.guildMembers;
        }

        public final Map<Long, User> component6() {
            return this.users;
        }

        public final Map<Long, GuildRole> component7() {
            return this.guildRoles;
        }

        public final Map<Long, String> component8() {
            return this.channelNames;
        }

        /* renamed from: component9, reason: from getter */
        public final Long getPermissions() {
            return this.permissions;
        }

        public final StoreState copy(MeUser meUser, Map<Long, Channel> activeJoinedThreads, Map<Long, Channel> activeThreads, Map<Long, StoreThreadMessages.ThreadState> threadStates, Map<Long, GuildMember> guildMembers, Map<Long, ? extends User> users, Map<Long, GuildRole> guildRoles, Map<Long, String> channelNames, Long permissions, Map<Long, Integer> blockedUsers, Channel channel, Guild guild) {
            Intrinsics3.checkNotNullParameter(meUser, "meUser");
            Intrinsics3.checkNotNullParameter(activeJoinedThreads, "activeJoinedThreads");
            Intrinsics3.checkNotNullParameter(activeThreads, "activeThreads");
            Intrinsics3.checkNotNullParameter(threadStates, "threadStates");
            Intrinsics3.checkNotNullParameter(guildMembers, "guildMembers");
            Intrinsics3.checkNotNullParameter(users, "users");
            Intrinsics3.checkNotNullParameter(guildRoles, "guildRoles");
            Intrinsics3.checkNotNullParameter(channelNames, "channelNames");
            Intrinsics3.checkNotNullParameter(blockedUsers, "blockedUsers");
            return new StoreState(meUser, activeJoinedThreads, activeThreads, threadStates, guildMembers, users, guildRoles, channelNames, permissions, blockedUsers, channel, guild);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.meUser, storeState.meUser) && Intrinsics3.areEqual(this.activeJoinedThreads, storeState.activeJoinedThreads) && Intrinsics3.areEqual(this.activeThreads, storeState.activeThreads) && Intrinsics3.areEqual(this.threadStates, storeState.threadStates) && Intrinsics3.areEqual(this.guildMembers, storeState.guildMembers) && Intrinsics3.areEqual(this.users, storeState.users) && Intrinsics3.areEqual(this.guildRoles, storeState.guildRoles) && Intrinsics3.areEqual(this.channelNames, storeState.channelNames) && Intrinsics3.areEqual(this.permissions, storeState.permissions) && Intrinsics3.areEqual(this.blockedUsers, storeState.blockedUsers) && Intrinsics3.areEqual(this.channel, storeState.channel) && Intrinsics3.areEqual(this.guild, storeState.guild);
        }

        public final Map<Long, Channel> getActiveJoinedThreads() {
            return this.activeJoinedThreads;
        }

        public final Map<Long, Channel> getActiveThreads() {
            return this.activeThreads;
        }

        public final Map<Long, Integer> getBlockedUsers() {
            return this.blockedUsers;
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final Map<Long, String> getChannelNames() {
            return this.channelNames;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final Map<Long, GuildMember> getGuildMembers() {
            return this.guildMembers;
        }

        public final Map<Long, GuildRole> getGuildRoles() {
            return this.guildRoles;
        }

        public final MeUser getMeUser() {
            return this.meUser;
        }

        public final Long getPermissions() {
            return this.permissions;
        }

        public final Map<Long, StoreThreadMessages.ThreadState> getThreadStates() {
            return this.threadStates;
        }

        public final Map<Long, User> getUsers() {
            return this.users;
        }

        public int hashCode() {
            MeUser meUser = this.meUser;
            int iHashCode = (meUser != null ? meUser.hashCode() : 0) * 31;
            Map<Long, Channel> map = this.activeJoinedThreads;
            int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
            Map<Long, Channel> map2 = this.activeThreads;
            int iHashCode3 = (iHashCode2 + (map2 != null ? map2.hashCode() : 0)) * 31;
            Map<Long, StoreThreadMessages.ThreadState> map3 = this.threadStates;
            int iHashCode4 = (iHashCode3 + (map3 != null ? map3.hashCode() : 0)) * 31;
            Map<Long, GuildMember> map4 = this.guildMembers;
            int iHashCode5 = (iHashCode4 + (map4 != null ? map4.hashCode() : 0)) * 31;
            Map<Long, User> map5 = this.users;
            int iHashCode6 = (iHashCode5 + (map5 != null ? map5.hashCode() : 0)) * 31;
            Map<Long, GuildRole> map6 = this.guildRoles;
            int iHashCode7 = (iHashCode6 + (map6 != null ? map6.hashCode() : 0)) * 31;
            Map<Long, String> map7 = this.channelNames;
            int iHashCode8 = (iHashCode7 + (map7 != null ? map7.hashCode() : 0)) * 31;
            Long l = this.permissions;
            int iHashCode9 = (iHashCode8 + (l != null ? l.hashCode() : 0)) * 31;
            Map<Long, Integer> map8 = this.blockedUsers;
            int iHashCode10 = (iHashCode9 + (map8 != null ? map8.hashCode() : 0)) * 31;
            Channel channel = this.channel;
            int iHashCode11 = (iHashCode10 + (channel != null ? channel.hashCode() : 0)) * 31;
            Guild guild = this.guild;
            return iHashCode11 + (guild != null ? guild.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(meUser=");
            sbU.append(this.meUser);
            sbU.append(", activeJoinedThreads=");
            sbU.append(this.activeJoinedThreads);
            sbU.append(", activeThreads=");
            sbU.append(this.activeThreads);
            sbU.append(", threadStates=");
            sbU.append(this.threadStates);
            sbU.append(", guildMembers=");
            sbU.append(this.guildMembers);
            sbU.append(", users=");
            sbU.append(this.users);
            sbU.append(", guildRoles=");
            sbU.append(this.guildRoles);
            sbU.append(", channelNames=");
            sbU.append(this.channelNames);
            sbU.append(", permissions=");
            sbU.append(this.permissions);
            sbU.append(", blockedUsers=");
            sbU.append(this.blockedUsers);
            sbU.append(", channel=");
            sbU.append(this.channel);
            sbU.append(", guild=");
            sbU.append(this.guild);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: WidgetThreadBrowserActiveViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u001a\u0010\u001bJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0014\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0005R\u0019\u0010\n\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\b¨\u0006\u001c"}, d2 = {"Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserActiveViewModel$ViewState;", "", "", "Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserAdapter$Item;", "component1", "()Ljava/util/List;", "", "component2", "()Z", "listItems", "canCreateThread", "copy", "(Ljava/util/List;Z)Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserActiveViewModel$ViewState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getListItems", "Z", "getCanCreateThread", "<init>", "(Ljava/util/List;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ViewState {
        private final boolean canCreateThread;
        private final List<WidgetThreadBrowserAdapter.Item> listItems;

        /* JADX WARN: Multi-variable type inference failed */
        public ViewState(List<? extends WidgetThreadBrowserAdapter.Item> list, boolean z2) {
            Intrinsics3.checkNotNullParameter(list, "listItems");
            this.listItems = list;
            this.canCreateThread = z2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ViewState copy$default(ViewState viewState, List list, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                list = viewState.listItems;
            }
            if ((i & 2) != 0) {
                z2 = viewState.canCreateThread;
            }
            return viewState.copy(list, z2);
        }

        public final List<WidgetThreadBrowserAdapter.Item> component1() {
            return this.listItems;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getCanCreateThread() {
            return this.canCreateThread;
        }

        public final ViewState copy(List<? extends WidgetThreadBrowserAdapter.Item> listItems, boolean canCreateThread) {
            Intrinsics3.checkNotNullParameter(listItems, "listItems");
            return new ViewState(listItems, canCreateThread);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return Intrinsics3.areEqual(this.listItems, viewState.listItems) && this.canCreateThread == viewState.canCreateThread;
        }

        public final boolean getCanCreateThread() {
            return this.canCreateThread;
        }

        public final List<WidgetThreadBrowserAdapter.Item> getListItems() {
            return this.listItems;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            List<WidgetThreadBrowserAdapter.Item> list = this.listItems;
            int iHashCode = (list != null ? list.hashCode() : 0) * 31;
            boolean z2 = this.canCreateThread;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode + i;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ViewState(listItems=");
            sbU.append(this.listItems);
            sbU.append(", canCreateThread=");
            return outline.O(sbU, this.canCreateThread, ")");
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetThreadBrowserActiveViewModel(long j, long j2, StoreUser storeUser, StoreGuildMemberRequester storeGuildMemberRequester, StoreThreadsActive storeThreadsActive, StoreThreadsActiveJoined storeThreadsActiveJoined, StoreThreadMessages storeThreadMessages, StoreGuilds storeGuilds, StoreChannels storeChannels, StorePermissions storePermissions, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        StoreUser users = (i & 4) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser;
        StoreGuildMemberRequester guildMemberRequester = (i & 8) != 0 ? StoreStream.INSTANCE.getGuildMemberRequester() : storeGuildMemberRequester;
        StoreThreadsActive threadsActive = (i & 16) != 0 ? StoreStream.INSTANCE.getThreadsActive() : storeThreadsActive;
        StoreThreadsActiveJoined threadsActiveJoined = (i & 32) != 0 ? StoreStream.INSTANCE.getThreadsActiveJoined() : storeThreadsActiveJoined;
        StoreThreadMessages threadMessages = (i & 64) != 0 ? StoreStream.INSTANCE.getThreadMessages() : storeThreadMessages;
        StoreGuilds guilds = (i & 128) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds;
        StoreChannels channels = (i & 256) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels;
        StorePermissions permissions = (i & 512) != 0 ? StoreStream.INSTANCE.getPermissions() : storePermissions;
        this(j, j2, users, guildMemberRequester, threadsActive, threadsActiveJoined, threadMessages, guilds, channels, permissions, (i & 1024) != 0 ? Companion.access$observeStoreState(INSTANCE, j, j2, users, threadsActive, threadsActiveJoined, threadMessages, guilds, channels, permissions) : observable);
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetThreadBrowserActiveViewModel widgetThreadBrowserActiveViewModel, StoreState storeState) {
        widgetThreadBrowserActiveViewModel.handleStoreState(storeState);
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        int i;
        Iterator it;
        Iterator it2;
        com.discord.api.user.User author;
        com.discord.api.user.User author2;
        ArrayList arrayList = new ArrayList();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        boolean z2 = true;
        List listListOf = Collections2.listOf((Object[]) new Tuples3[]{new Tuples3("joined", Integer.valueOf(R.string.thread_browser_joined_header), storeState.getActiveJoinedThreads()), new Tuples3("other", Integer.valueOf(R.string.thread_browser_other_header), storeState.getActiveThreads())});
        Channel channel = storeState.getChannel();
        Message message = null;
        if (channel != null && channel.getType() == 15) {
            arrayList.add(new WidgetThreadBrowserAdapter.Item.Warning(null, 1, null));
        }
        Iterator it3 = listListOf.iterator();
        while (it3.hasNext()) {
            Tuples3 tuples3 = (Tuples3) it3.next();
            String str = (String) tuples3.component1();
            int iIntValue = ((Number) tuples3.component2()).intValue();
            Map map = (Map) tuples3.component3();
            if (map.isEmpty()) {
                i = 0;
            } else {
                Iterator it4 = map.entrySet().iterator();
                i = 0;
                while (it4.hasNext()) {
                    if (linkedHashSet.contains(Long.valueOf(((Number) ((Map.Entry) it4.next()).getKey()).longValue())) ^ z2) {
                        i++;
                    }
                }
            }
            if (i != 0) {
                arrayList.add(new WidgetThreadBrowserAdapter.Item.Header(str, iIntValue, i));
                Iterator it5 = map.entrySet().iterator();
                while (it5.hasNext()) {
                    Map.Entry entry = (Map.Entry) it5.next();
                    long jLongValue = ((Number) entry.getKey()).longValue();
                    Channel channel2 = (Channel) entry.getValue();
                    if (linkedHashSet.contains(Long.valueOf(jLongValue))) {
                        it = it3;
                        it2 = it5;
                    } else {
                        User user = storeState.getUsers().get(Long.valueOf(channel2.getOwnerId()));
                        if (user == null || !storeState.getGuildMembers().containsKey(Long.valueOf(channel2.getOwnerId()))) {
                            this.storeGuildMemberRequester.queueRequest(channel2.getGuildId(), channel2.getOwnerId());
                        }
                        StoreThreadMessages.ThreadState threadState = storeState.getThreadStates().get(Long.valueOf(jLongValue));
                        Message mostRecentMessage = threadState != null ? threadState.getMostRecentMessage() : message;
                        if (mostRecentMessage == null || (author2 = mostRecentMessage.getAuthor()) == null || storeState.getGuildMembers().containsKey(Long.valueOf(author2.getId()))) {
                            it = it3;
                            it2 = it5;
                        } else {
                            it = it3;
                            it2 = it5;
                            this.storeGuildMemberRequester.queueRequest(channel2.getGuildId(), author2.getId());
                        }
                        arrayList.add(new WidgetThreadBrowserAdapter.Item.Thread(new ThreadBrowserThreadView.ThreadData.ActiveThread(channel2, user, mostRecentMessage, storeState.getMeUser().getId(), storeState.getGuildMembers(), storeState.getGuildRoles(), storeState.getChannelNames(), storeState.getBlockedUsers().containsKey((mostRecentMessage == null || (author = mostRecentMessage.getAuthor()) == null) ? null : Long.valueOf(author.getId())))));
                        linkedHashSet.add(Long.valueOf(jLongValue));
                    }
                    it3 = it;
                    it5 = it2;
                    message = null;
                }
            }
            it3 = it3;
            z2 = true;
            message = null;
        }
        if (linkedHashSet.isEmpty()) {
            arrayList.clear();
        }
        this.storeGuildMemberRequester.performQueuedRequests();
        updateViewState(new ViewState(arrayList, ThreadUtils.INSTANCE.canCreateThread(storeState.getPermissions(), storeState.getChannel(), null, storeState.getGuild())));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetThreadBrowserActiveViewModel(long j, long j2, StoreUser storeUser, StoreGuildMemberRequester storeGuildMemberRequester, StoreThreadsActive storeThreadsActive, StoreThreadsActiveJoined storeThreadsActiveJoined, StoreThreadMessages storeThreadMessages, StoreGuilds storeGuilds, StoreChannels storeChannels, StorePermissions storePermissions, Observable<StoreState> observable) {
        super(null, 1, null);
        Intrinsics3.checkNotNullParameter(storeUser, "storeUser");
        Intrinsics3.checkNotNullParameter(storeGuildMemberRequester, "storeGuildMemberRequester");
        Intrinsics3.checkNotNullParameter(storeThreadsActive, "storeThreadsActive");
        Intrinsics3.checkNotNullParameter(storeThreadsActiveJoined, "storeThreadsActiveJoined");
        Intrinsics3.checkNotNullParameter(storeThreadMessages, "storeThreadMessages");
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        Intrinsics3.checkNotNullParameter(storeChannels, "storeChannels");
        Intrinsics3.checkNotNullParameter(storePermissions, "storePermissions");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.guildId = j;
        this.channelId = j2;
        this.storeUser = storeUser;
        this.storeGuildMemberRequester = storeGuildMemberRequester;
        this.storeThreadsActive = storeThreadsActive;
        this.storeThreadsActiveJoined = storeThreadsActiveJoined;
        this.storeThreadMessages = storeThreadMessages;
        this.storeGuilds = storeGuilds;
        this.storeChannels = storeChannels;
        this.storePermissions = storePermissions;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), WidgetThreadBrowserActiveViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
