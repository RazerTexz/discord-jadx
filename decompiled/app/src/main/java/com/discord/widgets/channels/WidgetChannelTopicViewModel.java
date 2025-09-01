package com.discord.widgets.channels;

import a0.a.a.b;
import android.content.Context;
import androidx.annotation.MainThread;
import androidx.core.app.NotificationCompat;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.role.GuildRole;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.Parser;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreNavigation;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreTabsNavigation;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.channel.GuildChannelIconUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.textprocessing.DiscordParser;
import com.discord.utilities.textprocessing.MessageParseState;
import com.discord.utilities.textprocessing.MessagePreprocessor;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.discord.utilities.textprocessing.node.SpoilerNode;
import d0.t.MapsJVM;
import d0.t.Sets5;
import d0.t._Collections;
import d0.t._Sets;
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
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: WidgetChannelTopicViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 82\b\u0012\u0004\u0012\u00020\u00020\u0001:\u000489:;B=\u0012\u000e\b\u0002\u00105\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0014\u0012$\b\u0002\u0010+\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020)0(j\u0002`*¢\u0006\u0004\b6\u00107J'\u0010\t\u001a\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005j\u0002`\b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0013\u0010\u000fJ\u0013\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u001a\u001a\u00020\r2\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u0018H\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fR\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R:\u0010%\u001a&\u0012\f\u0012\n $*\u0004\u0018\u00010\u00150\u0015 $*\u0012\u0012\f\u0012\n $*\u0004\u0018\u00010\u00150\u0015\u0018\u00010#0#8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010'\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010\"R2\u0010+\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020)0(j\u0002`*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u001e\u0010/\u001a\n\u0018\u00010-j\u0004\u0018\u0001`.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u001c\u00103\u001a\b\u0012\u0004\u0012\u000202018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104¨\u0006<"}, d2 = {"Lcom/discord/widgets/channels/WidgetChannelTopicViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$ViewState;", "", "rawTopicString", "", "Lcom/discord/simpleast/core/node/Node;", "Lcom/discord/utilities/textprocessing/MessageRenderContext;", "Lcom/discord/widgets/channels/AST;", "generateAST", "(Ljava/lang/CharSequence;)Ljava/util/List;", "Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$StoreState;", "storeState", "", "handleStoreState", "(Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$StoreState;)V", "Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$StoreState$Guild;", "handleGuildStoreState", "(Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$StoreState$Guild;)V", "handlePrivateStoreState", "Lrx/Observable;", "Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$Event;", "listenForEvents", "()Lrx/Observable;", "Lcom/discord/utilities/textprocessing/node/SpoilerNode;", "spoilerNode", "handleOnIndexClicked", "(Lcom/discord/utilities/textprocessing/node/SpoilerNode;)V", "Landroid/content/Context;", "context", "handleClosePrivateChannel", "(Landroid/content/Context;)Lkotlin/Unit;", "", "wasOnHomeTab", "Z", "Lrx/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "eventSubject", "Lrx/subjects/PublishSubject;", "wasRightPanelOpened", "Lcom/discord/simpleast/core/parser/Parser;", "Lcom/discord/utilities/textprocessing/MessageParseState;", "Lcom/discord/widgets/channels/TopicParser;", "topicParser", "Lcom/discord/simpleast/core/parser/Parser;", "", "Lcom/discord/primitives/ChannelId;", "previousChannelId", "Ljava/lang/Long;", "", "", "revealedIndices", "Ljava/util/Set;", "storeStateObservable", "<init>", "(Lrx/Observable;Lcom/discord/simpleast/core/parser/Parser;)V", "Companion", "Event", "StoreState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChannelTopicViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final PublishSubject<Event> eventSubject;
    private Long previousChannelId;
    private Set<Integer> revealedIndices;
    private Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> topicParser;
    private boolean wasOnHomeTab;
    private boolean wasRightPanelOpened;

    /* compiled from: WidgetChannelTopicViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a*\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004 \u0001*\u0014\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$Companion$NavState;", "kotlin.jvm.PlatformType", "navState", "Lrx/Observable;", "Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$StoreState;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$Companion$NavState;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.WidgetChannelTopicViewModel$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Companion.NavState, Observable<? extends StoreState>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends StoreState> call(Companion.NavState navState) {
            return call2(navState);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends StoreState> call2(Companion.NavState navState) {
            if (navState.isRightPanelOpened()) {
                Companion companion = WidgetChannelTopicViewModel.INSTANCE;
                Intrinsics3.checkNotNullExpressionValue(navState, "navState");
                return Companion.observeStoreState$default(companion, navState, null, null, null, null, null, 62, null);
            }
            Companion companion2 = WidgetChannelTopicViewModel.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(navState, "navState");
            return Companion.observeStoreState$default(companion2, navState, null, null, null, null, null, 62, null).Z(1);
        }
    }

    /* compiled from: WidgetChannelTopicViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$StoreState;", "storeState", "", "invoke", "(Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.WidgetChannelTopicViewModel$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<StoreState, Unit> {
        public AnonymousClass2() {
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
            WidgetChannelTopicViewModel.access$handleStoreState(WidgetChannelTopicViewModel.this, storeState);
        }
    }

    /* compiled from: WidgetChannelTopicViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001!B\t\b\u0002¢\u0006\u0004\b\u001f\u0010 J)\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJO\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00062\u0006\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J5\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00150\u00062\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJE\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00062\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$Companion;", "", "Lcom/discord/stores/StoreNavigation;", "storeNavigation", "Lcom/discord/stores/StoreTabsNavigation;", "storeTabsNavigation", "Lrx/Observable;", "Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$Companion$NavState;", "observeNavState", "(Lcom/discord/stores/StoreNavigation;Lcom/discord/stores/StoreTabsNavigation;)Lrx/Observable;", "navState", "Lcom/discord/stores/StoreChannelsSelected;", "storeChannelsSelected", "Lcom/discord/stores/StoreChannels;", "storeChannels", "Lcom/discord/stores/StoreUser;", "storeUsers", "Lcom/discord/stores/StoreGuilds;", "storeGuilds", "Lcom/discord/stores/StoreUserSettings;", "storeUserSettings", "Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$StoreState;", "observeStoreState", "(Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$Companion$NavState;Lcom/discord/stores/StoreChannelsSelected;Lcom/discord/stores/StoreChannels;Lcom/discord/stores/StoreUser;Lcom/discord/stores/StoreGuilds;Lcom/discord/stores/StoreUserSettings;)Lrx/Observable;", "Lcom/discord/api/channel/Channel;", "channel", "mapChannelToPrivateStoreState", "(Lcom/discord/api/channel/Channel;Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$Companion$NavState;Lcom/discord/stores/StoreGuilds;Lcom/discord/stores/StoreUserSettings;)Lrx/Observable;", "Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$StoreState$Guild;", "mapChannelToGuildStoreState", "(Lcom/discord/api/channel/Channel;Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$Companion$NavState;Lcom/discord/stores/StoreChannels;Lcom/discord/stores/StoreUser;Lcom/discord/stores/StoreGuilds;Lcom/discord/stores/StoreUserSettings;)Lrx/Observable;", "<init>", "()V", "NavState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {

        /* compiled from: WidgetChannelTopicViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0007\u0010\u0004R\u0019\u0010\u0006\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0006\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$Companion$NavState;", "", "", "component1", "()Z", "component2", "isRightPanelOpened", "isOnHomeTab", "copy", "(ZZ)Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$Companion$NavState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "<init>", "(ZZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class NavState {
            private final boolean isOnHomeTab;
            private final boolean isRightPanelOpened;

            public NavState(boolean z2, boolean z3) {
                this.isRightPanelOpened = z2;
                this.isOnHomeTab = z3;
            }

            public static /* synthetic */ NavState copy$default(NavState navState, boolean z2, boolean z3, int i, Object obj) {
                if ((i & 1) != 0) {
                    z2 = navState.isRightPanelOpened;
                }
                if ((i & 2) != 0) {
                    z3 = navState.isOnHomeTab;
                }
                return navState.copy(z2, z3);
            }

            /* renamed from: component1, reason: from getter */
            public final boolean getIsRightPanelOpened() {
                return this.isRightPanelOpened;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getIsOnHomeTab() {
                return this.isOnHomeTab;
            }

            public final NavState copy(boolean isRightPanelOpened, boolean isOnHomeTab) {
                return new NavState(isRightPanelOpened, isOnHomeTab);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof NavState)) {
                    return false;
                }
                NavState navState = (NavState) other;
                return this.isRightPanelOpened == navState.isRightPanelOpened && this.isOnHomeTab == navState.isOnHomeTab;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [int] */
            /* JADX WARN: Type inference failed for: r0v4 */
            /* JADX WARN: Type inference failed for: r0v5 */
            public int hashCode() {
                boolean z2 = this.isRightPanelOpened;
                ?? r0 = z2;
                if (z2) {
                    r0 = 1;
                }
                int i = r0 * 31;
                boolean z3 = this.isOnHomeTab;
                return i + (z3 ? 1 : z3 ? 1 : 0);
            }

            public final boolean isOnHomeTab() {
                return this.isOnHomeTab;
            }

            public final boolean isRightPanelOpened() {
                return this.isRightPanelOpened;
            }

            public String toString() {
                StringBuilder sbU = outline.U("NavState(isRightPanelOpened=");
                sbU.append(this.isRightPanelOpened);
                sbU.append(", isOnHomeTab=");
                return outline.O(sbU, this.isOnHomeTab, ")");
            }
        }

        private Companion() {
        }

        public static final /* synthetic */ Observable access$mapChannelToGuildStoreState(Companion companion, Channel channel, NavState navState, StoreChannels storeChannels, StoreUser storeUser, StoreGuilds storeGuilds, StoreUserSettings storeUserSettings) {
            return companion.mapChannelToGuildStoreState(channel, navState, storeChannels, storeUser, storeGuilds, storeUserSettings);
        }

        public static final /* synthetic */ Observable access$mapChannelToPrivateStoreState(Companion companion, Channel channel, NavState navState, StoreGuilds storeGuilds, StoreUserSettings storeUserSettings) {
            return companion.mapChannelToPrivateStoreState(channel, navState, storeGuilds, storeUserSettings);
        }

        private final Observable<StoreState.Guild> mapChannelToGuildStoreState(Channel channel, NavState navState, StoreChannels storeChannels, StoreUser storeUsers, StoreGuilds storeGuilds, StoreUserSettings storeUserSettings) {
            long guildId = channel.getGuildId();
            Observable<StoreState.Guild> observableG = Observable.g(StoreChannels.observeChannelsForGuild$default(storeChannels, guildId, null, 2, null), storeUsers.observeAllUsers(), storeGuilds.observeComputed(guildId), storeGuilds.observeRoles(guildId), StoreUserSettings.observeIsAnimatedEmojisEnabled$default(storeUserSettings, false, 1, null), new WidgetChannelTopicViewModel3(channel, navState));
            Intrinsics3.checkNotNullExpressionValue(observableG, "Observable.combineLatest…HomeTab\n        )\n      }");
            return observableG;
        }

        private final Observable<StoreState> mapChannelToPrivateStoreState(Channel channel, NavState navState, StoreGuilds storeGuilds, StoreUserSettings storeUserSettings) {
            if (ChannelUtils.p(channel)) {
                ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(new StoreState.GDM(channel, storeUserSettings.getIsDeveloperMode(), navState.isRightPanelOpened(), navState.isOnHomeTab()));
                Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable.just(\n       …            )\n          )");
                return scalarSynchronousObservable;
            }
            Observable observableG = storeGuilds.observeComputed().G(new WidgetChannelTopicViewModel4(channel, storeUserSettings, navState));
            Intrinsics3.checkNotNullExpressionValue(observableG, "storeGuilds.observeCompu…            )\n          }");
            return observableG;
        }

        private final Observable<NavState> observeNavState(StoreNavigation storeNavigation, StoreTabsNavigation storeTabsNavigation) {
            Observable<NavState> observableJ = Observable.j(storeNavigation.observeRightPanelState().G(WidgetChannelTopicViewModel5.INSTANCE), storeTabsNavigation.observeSelectedTab().G(WidgetChannelTopicViewModel6.INSTANCE), WidgetChannelTopicViewModel7.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…sOpen, isOnHomeTab)\n    }");
            return observableJ;
        }

        public static /* synthetic */ Observable observeNavState$default(Companion companion, StoreNavigation storeNavigation, StoreTabsNavigation storeTabsNavigation, int i, Object obj) {
            if ((i & 1) != 0) {
                storeNavigation = StoreStream.INSTANCE.getNavigation();
            }
            if ((i & 2) != 0) {
                storeTabsNavigation = StoreStream.INSTANCE.getTabsNavigation();
            }
            return companion.observeNavState(storeNavigation, storeTabsNavigation);
        }

        private final Observable<StoreState> observeStoreState(NavState navState, StoreChannelsSelected storeChannelsSelected, StoreChannels storeChannels, StoreUser storeUsers, StoreGuilds storeGuilds, StoreUserSettings storeUserSettings) {
            Observable observableY = storeChannelsSelected.observeSelectedChannel().Y(new WidgetChannelTopicViewModel8(navState, storeGuilds, storeUserSettings, storeChannels, storeUsers));
            Intrinsics3.checkNotNullExpressionValue(observableY, "storeChannelsSelected\n  …            }\n          }");
            return observableY;
        }

        public static /* synthetic */ Observable observeStoreState$default(Companion companion, NavState navState, StoreChannelsSelected storeChannelsSelected, StoreChannels storeChannels, StoreUser storeUser, StoreGuilds storeGuilds, StoreUserSettings storeUserSettings, int i, Object obj) {
            if ((i & 2) != 0) {
                storeChannelsSelected = StoreStream.INSTANCE.getChannelsSelected();
            }
            StoreChannelsSelected storeChannelsSelected2 = storeChannelsSelected;
            if ((i & 4) != 0) {
                storeChannels = StoreStream.INSTANCE.getChannels();
            }
            StoreChannels storeChannels2 = storeChannels;
            if ((i & 8) != 0) {
                storeUser = StoreStream.INSTANCE.getUsers();
            }
            StoreUser storeUser2 = storeUser;
            if ((i & 16) != 0) {
                storeGuilds = StoreStream.INSTANCE.getGuilds();
            }
            StoreGuilds storeGuilds2 = storeGuilds;
            if ((i & 32) != 0) {
                storeUserSettings = StoreStream.INSTANCE.getUserSettings();
            }
            return companion.observeStoreState(navState, storeChannelsSelected2, storeChannels2, storeUser2, storeGuilds2, storeUserSettings);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetChannelTopicViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$Event;", "", "<init>", "()V", "FocusFirstElement", "Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$Event$FocusFirstElement;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class Event {

        /* compiled from: WidgetChannelTopicViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$Event$FocusFirstElement;", "Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class FocusFirstElement extends Event {
            public static final FocusFirstElement INSTANCE = new FocusFirstElement();

            private FocusFirstElement() {
                super(null);
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetChannelTopicViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\t\n\u000b\fB\u0019\b\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u001c\u0010\u0006\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0004\u001a\u0004\b\u0006\u0010\u0005\u0082\u0001\u0004\r\u000e\u000f\u0010¨\u0006\u0011"}, d2 = {"Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$StoreState;", "", "", "isOnHomeTab", "Z", "()Z", "isRightPanelOpened", "<init>", "(ZZ)V", "DM", "GDM", "Guild", "NoChannel", "Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$StoreState$NoChannel;", "Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$StoreState$Guild;", "Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$StoreState$GDM;", "Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$StoreState$DM;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class StoreState {
        private final boolean isOnHomeTab;
        private final boolean isRightPanelOpened;

        /* compiled from: WidgetChannelTopicViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0018\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000b\u0012\u0006\u0010\u0013\u001a\u00020\u000b\u0012\u0006\u0010\u0014\u001a\u00020\u000b¢\u0006\u0004\b'\u0010(J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\"\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u000f\u0010\rJT\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00022\u001a\b\u0002\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\b\b\u0002\u0010\u0013\u001a\u00020\u000b2\b\b\u0002\u0010\u0014\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001f\u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dHÖ\u0003¢\u0006\u0004\b\u001f\u0010 R\u001c\u0010\u0014\u001a\u00020\u000b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010!\u001a\u0004\b\u0014\u0010\rR+\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\"\u001a\u0004\b#\u0010\nR\u0019\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010!\u001a\u0004\b$\u0010\rR\u001c\u0010\u0013\u001a\u00020\u000b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010!\u001a\u0004\b\u0013\u0010\rR\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010%\u001a\u0004\b&\u0010\u0004¨\u0006)"}, d2 = {"Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$StoreState$DM;", "Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$StoreState;", "Lcom/discord/api/channel/Channel;", "component1", "()Lcom/discord/api/channel/Channel;", "", "", "", "Lcom/discord/models/member/GuildMember;", "component2", "()Ljava/util/Collection;", "", "component3", "()Z", "component4", "component5", "channel", "guildMembers", "developerModeEnabled", "isRightPanelOpened", "isOnHomeTab", "copy", "(Lcom/discord/api/channel/Channel;Ljava/util/Collection;ZZZ)Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$StoreState$DM;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "Ljava/util/Collection;", "getGuildMembers", "getDeveloperModeEnabled", "Lcom/discord/api/channel/Channel;", "getChannel", "<init>", "(Lcom/discord/api/channel/Channel;Ljava/util/Collection;ZZZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class DM extends StoreState {
            private final Channel channel;
            private final boolean developerModeEnabled;
            private final Collection<Map<Long, GuildMember>> guildMembers;
            private final boolean isOnHomeTab;
            private final boolean isRightPanelOpened;

            public /* synthetic */ DM(Channel channel, Collection collection, boolean z2, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(channel, collection, (i & 4) != 0 ? false : z2, z3, z4);
            }

            public static /* synthetic */ DM copy$default(DM dm, Channel channel, Collection collection, boolean z2, boolean z3, boolean z4, int i, Object obj) {
                if ((i & 1) != 0) {
                    channel = dm.channel;
                }
                if ((i & 2) != 0) {
                    collection = dm.guildMembers;
                }
                Collection collection2 = collection;
                if ((i & 4) != 0) {
                    z2 = dm.developerModeEnabled;
                }
                boolean z5 = z2;
                if ((i & 8) != 0) {
                    z3 = dm.getIsRightPanelOpened();
                }
                boolean z6 = z3;
                if ((i & 16) != 0) {
                    z4 = dm.getIsOnHomeTab();
                }
                return dm.copy(channel, collection2, z5, z6, z4);
            }

            /* renamed from: component1, reason: from getter */
            public final Channel getChannel() {
                return this.channel;
            }

            public final Collection<Map<Long, GuildMember>> component2() {
                return this.guildMembers;
            }

            /* renamed from: component3, reason: from getter */
            public final boolean getDeveloperModeEnabled() {
                return this.developerModeEnabled;
            }

            public final boolean component4() {
                return getIsRightPanelOpened();
            }

            public final boolean component5() {
                return getIsOnHomeTab();
            }

            public final DM copy(Channel channel, Collection<? extends Map<Long, GuildMember>> guildMembers, boolean developerModeEnabled, boolean isRightPanelOpened, boolean isOnHomeTab) {
                Intrinsics3.checkNotNullParameter(channel, "channel");
                Intrinsics3.checkNotNullParameter(guildMembers, "guildMembers");
                return new DM(channel, guildMembers, developerModeEnabled, isRightPanelOpened, isOnHomeTab);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof DM)) {
                    return false;
                }
                DM dm = (DM) other;
                return Intrinsics3.areEqual(this.channel, dm.channel) && Intrinsics3.areEqual(this.guildMembers, dm.guildMembers) && this.developerModeEnabled == dm.developerModeEnabled && getIsRightPanelOpened() == dm.getIsRightPanelOpened() && getIsOnHomeTab() == dm.getIsOnHomeTab();
            }

            public final Channel getChannel() {
                return this.channel;
            }

            public final boolean getDeveloperModeEnabled() {
                return this.developerModeEnabled;
            }

            public final Collection<Map<Long, GuildMember>> getGuildMembers() {
                return this.guildMembers;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r1v11 */
            /* JADX WARN: Type inference failed for: r1v2, types: [boolean] */
            /* JADX WARN: Type inference failed for: r1v5, types: [int] */
            /* JADX WARN: Type inference failed for: r1v7 */
            /* JADX WARN: Type inference failed for: r2v1 */
            /* JADX WARN: Type inference failed for: r2v2, types: [int] */
            /* JADX WARN: Type inference failed for: r2v3 */
            public int hashCode() {
                Channel channel = this.channel;
                int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
                Collection<Map<Long, GuildMember>> collection = this.guildMembers;
                int iHashCode2 = (iHashCode + (collection != null ? collection.hashCode() : 0)) * 31;
                ?? r1 = this.developerModeEnabled;
                int i = r1;
                if (r1 != 0) {
                    i = 1;
                }
                int i2 = (iHashCode2 + i) * 31;
                boolean isRightPanelOpened = getIsRightPanelOpened();
                ?? r12 = isRightPanelOpened;
                if (isRightPanelOpened) {
                    r12 = 1;
                }
                int i3 = (i2 + r12) * 31;
                boolean isOnHomeTab = getIsOnHomeTab();
                return i3 + (isOnHomeTab ? 1 : isOnHomeTab);
            }

            @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.StoreState
            /* renamed from: isOnHomeTab, reason: from getter */
            public boolean getIsOnHomeTab() {
                return this.isOnHomeTab;
            }

            @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.StoreState
            /* renamed from: isRightPanelOpened, reason: from getter */
            public boolean getIsRightPanelOpened() {
                return this.isRightPanelOpened;
            }

            public String toString() {
                StringBuilder sbU = outline.U("DM(channel=");
                sbU.append(this.channel);
                sbU.append(", guildMembers=");
                sbU.append(this.guildMembers);
                sbU.append(", developerModeEnabled=");
                sbU.append(this.developerModeEnabled);
                sbU.append(", isRightPanelOpened=");
                sbU.append(getIsRightPanelOpened());
                sbU.append(", isOnHomeTab=");
                sbU.append(getIsOnHomeTab());
                sbU.append(")");
                return sbU.toString();
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public DM(Channel channel, Collection<? extends Map<Long, GuildMember>> collection, boolean z2, boolean z3, boolean z4) {
                super(z3, z4, null);
                Intrinsics3.checkNotNullParameter(channel, "channel");
                Intrinsics3.checkNotNullParameter(collection, "guildMembers");
                this.channel = channel;
                this.guildMembers = collection;
                this.developerModeEnabled = z2;
                this.isRightPanelOpened = z3;
                this.isOnHomeTab = z4;
            }
        }

        /* compiled from: WidgetChannelTopicViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J8\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u001c\u0010\f\u001a\u00020\u00058\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010\u001c\u001a\u0004\b\f\u0010\u0007R\u0019\u0010\u000b\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0007R\u001c\u0010\r\u001a\u00020\u00058\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\r\u0010\u0007¨\u0006 "}, d2 = {"Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$StoreState$GDM;", "Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$StoreState;", "Lcom/discord/api/channel/Channel;", "component1", "()Lcom/discord/api/channel/Channel;", "", "component2", "()Z", "component3", "component4", "channel", "developerModeEnabled", "isRightPanelOpened", "isOnHomeTab", "copy", "(Lcom/discord/api/channel/Channel;ZZZ)Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$StoreState$GDM;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/channel/Channel;", "getChannel", "Z", "getDeveloperModeEnabled", "<init>", "(Lcom/discord/api/channel/Channel;ZZZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class GDM extends StoreState {
            private final Channel channel;
            private final boolean developerModeEnabled;
            private final boolean isOnHomeTab;
            private final boolean isRightPanelOpened;

            public /* synthetic */ GDM(Channel channel, boolean z2, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(channel, (i & 2) != 0 ? false : z2, z3, z4);
            }

            public static /* synthetic */ GDM copy$default(GDM gdm, Channel channel, boolean z2, boolean z3, boolean z4, int i, Object obj) {
                if ((i & 1) != 0) {
                    channel = gdm.channel;
                }
                if ((i & 2) != 0) {
                    z2 = gdm.developerModeEnabled;
                }
                if ((i & 4) != 0) {
                    z3 = gdm.getIsRightPanelOpened();
                }
                if ((i & 8) != 0) {
                    z4 = gdm.getIsOnHomeTab();
                }
                return gdm.copy(channel, z2, z3, z4);
            }

            /* renamed from: component1, reason: from getter */
            public final Channel getChannel() {
                return this.channel;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getDeveloperModeEnabled() {
                return this.developerModeEnabled;
            }

            public final boolean component3() {
                return getIsRightPanelOpened();
            }

            public final boolean component4() {
                return getIsOnHomeTab();
            }

            public final GDM copy(Channel channel, boolean developerModeEnabled, boolean isRightPanelOpened, boolean isOnHomeTab) {
                Intrinsics3.checkNotNullParameter(channel, "channel");
                return new GDM(channel, developerModeEnabled, isRightPanelOpened, isOnHomeTab);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof GDM)) {
                    return false;
                }
                GDM gdm = (GDM) other;
                return Intrinsics3.areEqual(this.channel, gdm.channel) && this.developerModeEnabled == gdm.developerModeEnabled && getIsRightPanelOpened() == gdm.getIsRightPanelOpened() && getIsOnHomeTab() == gdm.getIsOnHomeTab();
            }

            public final Channel getChannel() {
                return this.channel;
            }

            public final boolean getDeveloperModeEnabled() {
                return this.developerModeEnabled;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r1v0, types: [boolean] */
            /* JADX WARN: Type inference failed for: r1v3, types: [int] */
            /* JADX WARN: Type inference failed for: r1v5 */
            /* JADX WARN: Type inference failed for: r1v8 */
            /* JADX WARN: Type inference failed for: r2v0 */
            /* JADX WARN: Type inference failed for: r2v1, types: [int] */
            /* JADX WARN: Type inference failed for: r2v2 */
            public int hashCode() {
                Channel channel = this.channel;
                int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
                ?? r1 = this.developerModeEnabled;
                int i = r1;
                if (r1 != 0) {
                    i = 1;
                }
                int i2 = (iHashCode + i) * 31;
                boolean isRightPanelOpened = getIsRightPanelOpened();
                ?? r12 = isRightPanelOpened;
                if (isRightPanelOpened) {
                    r12 = 1;
                }
                int i3 = (i2 + r12) * 31;
                boolean isOnHomeTab = getIsOnHomeTab();
                return i3 + (isOnHomeTab ? 1 : isOnHomeTab);
            }

            @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.StoreState
            /* renamed from: isOnHomeTab, reason: from getter */
            public boolean getIsOnHomeTab() {
                return this.isOnHomeTab;
            }

            @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.StoreState
            /* renamed from: isRightPanelOpened, reason: from getter */
            public boolean getIsRightPanelOpened() {
                return this.isRightPanelOpened;
            }

            public String toString() {
                StringBuilder sbU = outline.U("GDM(channel=");
                sbU.append(this.channel);
                sbU.append(", developerModeEnabled=");
                sbU.append(this.developerModeEnabled);
                sbU.append(", isRightPanelOpened=");
                sbU.append(getIsRightPanelOpened());
                sbU.append(", isOnHomeTab=");
                sbU.append(getIsOnHomeTab());
                sbU.append(")");
                return sbU.toString();
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public GDM(Channel channel, boolean z2, boolean z3, boolean z4) {
                super(z3, z4, null);
                Intrinsics3.checkNotNullParameter(channel, "channel");
                this.channel = channel;
                this.developerModeEnabled = z2;
                this.isRightPanelOpened = z3;
                this.isOnHomeTab = z4;
            }
        }

        /* compiled from: WidgetChannelTopicViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\t\nB\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u001c\u0010\u0006\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0004\u001a\u0004\b\u0006\u0010\u0005\u0082\u0001\u0002\u000b\f¨\u0006\r"}, d2 = {"Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$StoreState$Guild;", "Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$StoreState;", "", "isRightPanelOpened", "Z", "()Z", "isOnHomeTab", "<init>", "(ZZ)V", "DefaultTopic", "Topic", "Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$StoreState$Guild$DefaultTopic;", "Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$StoreState$Guild$Topic;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static abstract class Guild extends StoreState {
            private final boolean isOnHomeTab;
            private final boolean isRightPanelOpened;

            /* compiled from: WidgetChannelTopicViewModel.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ8\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u001c\u0010\u000f\u001a\u00020\b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b\u000f\u0010\nR\u0019\u0010\r\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b\u001e\u0010\u0007R\u001c\u0010\u000e\u001a\u00020\b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b\u000e\u0010\nR\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001f\u001a\u0004\b \u0010\u0004¨\u0006#"}, d2 = {"Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$StoreState$Guild$DefaultTopic;", "Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$StoreState$Guild;", "Lcom/discord/api/channel/Channel;", "component1", "()Lcom/discord/api/channel/Channel;", "Lcom/discord/utilities/channel/GuildChannelIconType;", "component2", "()Lcom/discord/utilities/channel/GuildChannelIconType;", "", "component3", "()Z", "component4", "channel", "channelIconType", "isRightPanelOpened", "isOnHomeTab", "copy", "(Lcom/discord/api/channel/Channel;Lcom/discord/utilities/channel/GuildChannelIconType;ZZ)Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$StoreState$Guild$DefaultTopic;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "Lcom/discord/utilities/channel/GuildChannelIconType;", "getChannelIconType", "Lcom/discord/api/channel/Channel;", "getChannel", "<init>", "(Lcom/discord/api/channel/Channel;Lcom/discord/utilities/channel/GuildChannelIconType;ZZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
            public static final /* data */ class DefaultTopic extends Guild {
                private final Channel channel;
                private final GuildChannelIconUtils channelIconType;
                private final boolean isOnHomeTab;
                private final boolean isRightPanelOpened;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public DefaultTopic(Channel channel, GuildChannelIconUtils guildChannelIconUtils, boolean z2, boolean z3) {
                    super(z2, z3, null);
                    Intrinsics3.checkNotNullParameter(channel, "channel");
                    Intrinsics3.checkNotNullParameter(guildChannelIconUtils, "channelIconType");
                    this.channel = channel;
                    this.channelIconType = guildChannelIconUtils;
                    this.isRightPanelOpened = z2;
                    this.isOnHomeTab = z3;
                }

                public static /* synthetic */ DefaultTopic copy$default(DefaultTopic defaultTopic, Channel channel, GuildChannelIconUtils guildChannelIconUtils, boolean z2, boolean z3, int i, Object obj) {
                    if ((i & 1) != 0) {
                        channel = defaultTopic.channel;
                    }
                    if ((i & 2) != 0) {
                        guildChannelIconUtils = defaultTopic.channelIconType;
                    }
                    if ((i & 4) != 0) {
                        z2 = defaultTopic.getIsRightPanelOpened();
                    }
                    if ((i & 8) != 0) {
                        z3 = defaultTopic.getIsOnHomeTab();
                    }
                    return defaultTopic.copy(channel, guildChannelIconUtils, z2, z3);
                }

                /* renamed from: component1, reason: from getter */
                public final Channel getChannel() {
                    return this.channel;
                }

                /* renamed from: component2, reason: from getter */
                public final GuildChannelIconUtils getChannelIconType() {
                    return this.channelIconType;
                }

                public final boolean component3() {
                    return getIsRightPanelOpened();
                }

                public final boolean component4() {
                    return getIsOnHomeTab();
                }

                public final DefaultTopic copy(Channel channel, GuildChannelIconUtils channelIconType, boolean isRightPanelOpened, boolean isOnHomeTab) {
                    Intrinsics3.checkNotNullParameter(channel, "channel");
                    Intrinsics3.checkNotNullParameter(channelIconType, "channelIconType");
                    return new DefaultTopic(channel, channelIconType, isRightPanelOpened, isOnHomeTab);
                }

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof DefaultTopic)) {
                        return false;
                    }
                    DefaultTopic defaultTopic = (DefaultTopic) other;
                    return Intrinsics3.areEqual(this.channel, defaultTopic.channel) && Intrinsics3.areEqual(this.channelIconType, defaultTopic.channelIconType) && getIsRightPanelOpened() == defaultTopic.getIsRightPanelOpened() && getIsOnHomeTab() == defaultTopic.getIsOnHomeTab();
                }

                public final Channel getChannel() {
                    return this.channel;
                }

                public final GuildChannelIconUtils getChannelIconType() {
                    return this.channelIconType;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r1v3, types: [int] */
                /* JADX WARN: Type inference failed for: r1v5 */
                /* JADX WARN: Type inference failed for: r1v7 */
                /* JADX WARN: Type inference failed for: r2v1 */
                /* JADX WARN: Type inference failed for: r2v2, types: [int] */
                /* JADX WARN: Type inference failed for: r2v3 */
                public int hashCode() {
                    Channel channel = this.channel;
                    int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
                    GuildChannelIconUtils guildChannelIconUtils = this.channelIconType;
                    int iHashCode2 = (iHashCode + (guildChannelIconUtils != null ? guildChannelIconUtils.hashCode() : 0)) * 31;
                    boolean isRightPanelOpened = getIsRightPanelOpened();
                    ?? r1 = isRightPanelOpened;
                    if (isRightPanelOpened) {
                        r1 = 1;
                    }
                    int i = (iHashCode2 + r1) * 31;
                    boolean isOnHomeTab = getIsOnHomeTab();
                    return i + (isOnHomeTab ? 1 : isOnHomeTab);
                }

                @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.StoreState.Guild, com.discord.widgets.channels.WidgetChannelTopicViewModel.StoreState
                /* renamed from: isOnHomeTab, reason: from getter */
                public boolean getIsOnHomeTab() {
                    return this.isOnHomeTab;
                }

                @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.StoreState.Guild, com.discord.widgets.channels.WidgetChannelTopicViewModel.StoreState
                /* renamed from: isRightPanelOpened, reason: from getter */
                public boolean getIsRightPanelOpened() {
                    return this.isRightPanelOpened;
                }

                public String toString() {
                    StringBuilder sbU = outline.U("DefaultTopic(channel=");
                    sbU.append(this.channel);
                    sbU.append(", channelIconType=");
                    sbU.append(this.channelIconType);
                    sbU.append(", isRightPanelOpened=");
                    sbU.append(getIsRightPanelOpened());
                    sbU.append(", isOnHomeTab=");
                    sbU.append(getIsOnHomeTab());
                    sbU.append(")");
                    return sbU.toString();
                }
            }

            /* compiled from: WidgetChannelTopicViewModel.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0016\u0010\u001a\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\u00020\u0005\u0012\u0006\u0010\u001b\u001a\u00020\n\u0012\u0016\u0010\u001c\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\r\u0012\u0004\u0012\u00020\u000e0\u0005\u0012\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00100\u0005\u0012\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00120\u0005\u0012\u0006\u0010\u001f\u001a\u00020\u0014\u0012\u0006\u0010 \u001a\u00020\u0014\u0012\u0006\u0010!\u001a\u00020\u0014¢\u0006\u0004\b9\u0010:J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\b\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u000f\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\r\u0012\u0004\u0012\u00020\u000e0\u0005HÆ\u0003¢\u0006\u0004\b\u000f\u0010\tJ\u001c\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00100\u0005HÆ\u0003¢\u0006\u0004\b\u0011\u0010\tJ\u001c\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00120\u0005HÆ\u0003¢\u0006\u0004\b\u0013\u0010\tJ\u0010\u0010\u0015\u001a\u00020\u0014HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0014HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0014HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0016J¢\u0001\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0019\u001a\u00020\u00022\u0018\b\u0002\u0010\u001a\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\u00020\u00052\b\b\u0002\u0010\u001b\u001a\u00020\n2\u0018\b\u0002\u0010\u001c\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\r\u0012\u0004\u0012\u00020\u000e0\u00052\u0014\b\u0002\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00100\u00052\u0014\b\u0002\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00120\u00052\b\b\u0002\u0010\u001f\u001a\u00020\u00142\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\u0014HÆ\u0001¢\u0006\u0004\b\"\u0010#J\u0010\u0010%\u001a\u00020$HÖ\u0001¢\u0006\u0004\b%\u0010&J\u0010\u0010(\u001a\u00020'HÖ\u0001¢\u0006\u0004\b(\u0010)J\u001a\u0010,\u001a\u00020\u00142\b\u0010+\u001a\u0004\u0018\u00010*HÖ\u0003¢\u0006\u0004\b,\u0010-R\u0019\u0010\u001f\u001a\u00020\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010.\u001a\u0004\b/\u0010\u0016R)\u0010\u001c\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\r\u0012\u0004\u0012\u00020\u000e0\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u00100\u001a\u0004\b1\u0010\tR\u0019\u0010\u001b\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u00102\u001a\u0004\b3\u0010\fR\u001c\u0010 \u001a\u00020\u00148\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b \u0010.\u001a\u0004\b \u0010\u0016R\u001c\u0010!\u001a\u00020\u00148\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b!\u0010.\u001a\u0004\b!\u0010\u0016R%\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00120\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u00100\u001a\u0004\b4\u0010\tR)\u0010\u001a\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u00100\u001a\u0004\b5\u0010\tR%\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00100\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u00100\u001a\u0004\b6\u0010\tR\u0019\u0010\u0019\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u00107\u001a\u0004\b8\u0010\u0004¨\u0006;"}, d2 = {"Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$StoreState$Guild$Topic;", "Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$StoreState$Guild;", "Lcom/discord/api/channel/Channel;", "component1", "()Lcom/discord/api/channel/Channel;", "", "", "Lcom/discord/primitives/ChannelId;", "component2", "()Ljava/util/Map;", "Lcom/discord/utilities/channel/GuildChannelIconType;", "component3", "()Lcom/discord/utilities/channel/GuildChannelIconType;", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/user/User;", "component4", "Lcom/discord/models/member/GuildMember;", "component5", "Lcom/discord/api/role/GuildRole;", "component6", "", "component7", "()Z", "component8", "component9", "channel", "channels", "channelIconType", "users", "members", "roles", "allowAnimatedEmojis", "isRightPanelOpened", "isOnHomeTab", "copy", "(Lcom/discord/api/channel/Channel;Ljava/util/Map;Lcom/discord/utilities/channel/GuildChannelIconType;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;ZZZ)Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$StoreState$Guild$Topic;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getAllowAnimatedEmojis", "Ljava/util/Map;", "getUsers", "Lcom/discord/utilities/channel/GuildChannelIconType;", "getChannelIconType", "getRoles", "getChannels", "getMembers", "Lcom/discord/api/channel/Channel;", "getChannel", "<init>", "(Lcom/discord/api/channel/Channel;Ljava/util/Map;Lcom/discord/utilities/channel/GuildChannelIconType;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;ZZZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
            public static final /* data */ class Topic extends Guild {
                private final boolean allowAnimatedEmojis;
                private final Channel channel;
                private final GuildChannelIconUtils channelIconType;
                private final Map<Long, Channel> channels;
                private final boolean isOnHomeTab;
                private final boolean isRightPanelOpened;
                private final Map<Long, GuildMember> members;
                private final Map<Long, GuildRole> roles;
                private final Map<Long, User> users;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                public Topic(Channel channel, Map<Long, Channel> map, GuildChannelIconUtils guildChannelIconUtils, Map<Long, ? extends User> map2, Map<Long, GuildMember> map3, Map<Long, GuildRole> map4, boolean z2, boolean z3, boolean z4) {
                    super(z3, z4, null);
                    Intrinsics3.checkNotNullParameter(channel, "channel");
                    Intrinsics3.checkNotNullParameter(map, "channels");
                    Intrinsics3.checkNotNullParameter(guildChannelIconUtils, "channelIconType");
                    Intrinsics3.checkNotNullParameter(map2, "users");
                    Intrinsics3.checkNotNullParameter(map3, "members");
                    Intrinsics3.checkNotNullParameter(map4, "roles");
                    this.channel = channel;
                    this.channels = map;
                    this.channelIconType = guildChannelIconUtils;
                    this.users = map2;
                    this.members = map3;
                    this.roles = map4;
                    this.allowAnimatedEmojis = z2;
                    this.isRightPanelOpened = z3;
                    this.isOnHomeTab = z4;
                }

                public static /* synthetic */ Topic copy$default(Topic topic, Channel channel, Map map, GuildChannelIconUtils guildChannelIconUtils, Map map2, Map map3, Map map4, boolean z2, boolean z3, boolean z4, int i, Object obj) {
                    return topic.copy((i & 1) != 0 ? topic.channel : channel, (i & 2) != 0 ? topic.channels : map, (i & 4) != 0 ? topic.channelIconType : guildChannelIconUtils, (i & 8) != 0 ? topic.users : map2, (i & 16) != 0 ? topic.members : map3, (i & 32) != 0 ? topic.roles : map4, (i & 64) != 0 ? topic.allowAnimatedEmojis : z2, (i & 128) != 0 ? topic.getIsRightPanelOpened() : z3, (i & 256) != 0 ? topic.getIsOnHomeTab() : z4);
                }

                /* renamed from: component1, reason: from getter */
                public final Channel getChannel() {
                    return this.channel;
                }

                public final Map<Long, Channel> component2() {
                    return this.channels;
                }

                /* renamed from: component3, reason: from getter */
                public final GuildChannelIconUtils getChannelIconType() {
                    return this.channelIconType;
                }

                public final Map<Long, User> component4() {
                    return this.users;
                }

                public final Map<Long, GuildMember> component5() {
                    return this.members;
                }

                public final Map<Long, GuildRole> component6() {
                    return this.roles;
                }

                /* renamed from: component7, reason: from getter */
                public final boolean getAllowAnimatedEmojis() {
                    return this.allowAnimatedEmojis;
                }

                public final boolean component8() {
                    return getIsRightPanelOpened();
                }

                public final boolean component9() {
                    return getIsOnHomeTab();
                }

                public final Topic copy(Channel channel, Map<Long, Channel> channels, GuildChannelIconUtils channelIconType, Map<Long, ? extends User> users, Map<Long, GuildMember> members, Map<Long, GuildRole> roles, boolean allowAnimatedEmojis, boolean isRightPanelOpened, boolean isOnHomeTab) {
                    Intrinsics3.checkNotNullParameter(channel, "channel");
                    Intrinsics3.checkNotNullParameter(channels, "channels");
                    Intrinsics3.checkNotNullParameter(channelIconType, "channelIconType");
                    Intrinsics3.checkNotNullParameter(users, "users");
                    Intrinsics3.checkNotNullParameter(members, "members");
                    Intrinsics3.checkNotNullParameter(roles, "roles");
                    return new Topic(channel, channels, channelIconType, users, members, roles, allowAnimatedEmojis, isRightPanelOpened, isOnHomeTab);
                }

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof Topic)) {
                        return false;
                    }
                    Topic topic = (Topic) other;
                    return Intrinsics3.areEqual(this.channel, topic.channel) && Intrinsics3.areEqual(this.channels, topic.channels) && Intrinsics3.areEqual(this.channelIconType, topic.channelIconType) && Intrinsics3.areEqual(this.users, topic.users) && Intrinsics3.areEqual(this.members, topic.members) && Intrinsics3.areEqual(this.roles, topic.roles) && this.allowAnimatedEmojis == topic.allowAnimatedEmojis && getIsRightPanelOpened() == topic.getIsRightPanelOpened() && getIsOnHomeTab() == topic.getIsOnHomeTab();
                }

                public final boolean getAllowAnimatedEmojis() {
                    return this.allowAnimatedEmojis;
                }

                public final Channel getChannel() {
                    return this.channel;
                }

                public final GuildChannelIconUtils getChannelIconType() {
                    return this.channelIconType;
                }

                public final Map<Long, Channel> getChannels() {
                    return this.channels;
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

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r1v11 */
                /* JADX WARN: Type inference failed for: r1v2, types: [boolean] */
                /* JADX WARN: Type inference failed for: r1v5, types: [int] */
                /* JADX WARN: Type inference failed for: r1v7 */
                /* JADX WARN: Type inference failed for: r2v13 */
                /* JADX WARN: Type inference failed for: r2v14, types: [int] */
                /* JADX WARN: Type inference failed for: r2v15 */
                public int hashCode() {
                    Channel channel = this.channel;
                    int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
                    Map<Long, Channel> map = this.channels;
                    int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
                    GuildChannelIconUtils guildChannelIconUtils = this.channelIconType;
                    int iHashCode3 = (iHashCode2 + (guildChannelIconUtils != null ? guildChannelIconUtils.hashCode() : 0)) * 31;
                    Map<Long, User> map2 = this.users;
                    int iHashCode4 = (iHashCode3 + (map2 != null ? map2.hashCode() : 0)) * 31;
                    Map<Long, GuildMember> map3 = this.members;
                    int iHashCode5 = (iHashCode4 + (map3 != null ? map3.hashCode() : 0)) * 31;
                    Map<Long, GuildRole> map4 = this.roles;
                    int iHashCode6 = (iHashCode5 + (map4 != null ? map4.hashCode() : 0)) * 31;
                    ?? r1 = this.allowAnimatedEmojis;
                    int i = r1;
                    if (r1 != 0) {
                        i = 1;
                    }
                    int i2 = (iHashCode6 + i) * 31;
                    boolean isRightPanelOpened = getIsRightPanelOpened();
                    ?? r12 = isRightPanelOpened;
                    if (isRightPanelOpened) {
                        r12 = 1;
                    }
                    int i3 = (i2 + r12) * 31;
                    boolean isOnHomeTab = getIsOnHomeTab();
                    return i3 + (isOnHomeTab ? 1 : isOnHomeTab);
                }

                @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.StoreState.Guild, com.discord.widgets.channels.WidgetChannelTopicViewModel.StoreState
                /* renamed from: isOnHomeTab, reason: from getter */
                public boolean getIsOnHomeTab() {
                    return this.isOnHomeTab;
                }

                @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.StoreState.Guild, com.discord.widgets.channels.WidgetChannelTopicViewModel.StoreState
                /* renamed from: isRightPanelOpened, reason: from getter */
                public boolean getIsRightPanelOpened() {
                    return this.isRightPanelOpened;
                }

                public String toString() {
                    StringBuilder sbU = outline.U("Topic(channel=");
                    sbU.append(this.channel);
                    sbU.append(", channels=");
                    sbU.append(this.channels);
                    sbU.append(", channelIconType=");
                    sbU.append(this.channelIconType);
                    sbU.append(", users=");
                    sbU.append(this.users);
                    sbU.append(", members=");
                    sbU.append(this.members);
                    sbU.append(", roles=");
                    sbU.append(this.roles);
                    sbU.append(", allowAnimatedEmojis=");
                    sbU.append(this.allowAnimatedEmojis);
                    sbU.append(", isRightPanelOpened=");
                    sbU.append(getIsRightPanelOpened());
                    sbU.append(", isOnHomeTab=");
                    sbU.append(getIsOnHomeTab());
                    sbU.append(")");
                    return sbU.toString();
                }
            }

            public /* synthetic */ Guild(boolean z2, boolean z3, DefaultConstructorMarker defaultConstructorMarker) {
                this(z2, z3);
            }

            @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.StoreState
            /* renamed from: isOnHomeTab, reason: from getter */
            public boolean getIsOnHomeTab() {
                return this.isOnHomeTab;
            }

            @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.StoreState
            /* renamed from: isRightPanelOpened, reason: from getter */
            public boolean getIsRightPanelOpened() {
                return this.isRightPanelOpened;
            }

            private Guild(boolean z2, boolean z3) {
                super(z2, z3, null);
                this.isRightPanelOpened = z2;
                this.isOnHomeTab = z3;
            }
        }

        /* compiled from: WidgetChannelTopicViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0007\u0010\u0004R\u001c\u0010\u0006\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0006\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$StoreState$NoChannel;", "Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$StoreState;", "", "component1", "()Z", "component2", "isRightPanelOpened", "isOnHomeTab", "copy", "(ZZ)Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$StoreState$NoChannel;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "<init>", "(ZZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class NoChannel extends StoreState {
            private final boolean isOnHomeTab;
            private final boolean isRightPanelOpened;

            public NoChannel(boolean z2, boolean z3) {
                super(z2, z3, null);
                this.isRightPanelOpened = z2;
                this.isOnHomeTab = z3;
            }

            public static /* synthetic */ NoChannel copy$default(NoChannel noChannel, boolean z2, boolean z3, int i, Object obj) {
                if ((i & 1) != 0) {
                    z2 = noChannel.getIsRightPanelOpened();
                }
                if ((i & 2) != 0) {
                    z3 = noChannel.getIsOnHomeTab();
                }
                return noChannel.copy(z2, z3);
            }

            public final boolean component1() {
                return getIsRightPanelOpened();
            }

            public final boolean component2() {
                return getIsOnHomeTab();
            }

            public final NoChannel copy(boolean isRightPanelOpened, boolean isOnHomeTab) {
                return new NoChannel(isRightPanelOpened, isOnHomeTab);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof NoChannel)) {
                    return false;
                }
                NoChannel noChannel = (NoChannel) other;
                return getIsRightPanelOpened() == noChannel.getIsRightPanelOpened() && getIsOnHomeTab() == noChannel.getIsOnHomeTab();
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [int] */
            /* JADX WARN: Type inference failed for: r0v4 */
            /* JADX WARN: Type inference failed for: r0v5 */
            /* JADX WARN: Type inference failed for: r1v0 */
            /* JADX WARN: Type inference failed for: r1v1, types: [int] */
            /* JADX WARN: Type inference failed for: r1v2 */
            public int hashCode() {
                boolean isRightPanelOpened = getIsRightPanelOpened();
                ?? r0 = isRightPanelOpened;
                if (isRightPanelOpened) {
                    r0 = 1;
                }
                int i = r0 * 31;
                boolean isOnHomeTab = getIsOnHomeTab();
                return i + (isOnHomeTab ? 1 : isOnHomeTab);
            }

            @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.StoreState
            /* renamed from: isOnHomeTab, reason: from getter */
            public boolean getIsOnHomeTab() {
                return this.isOnHomeTab;
            }

            @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.StoreState
            /* renamed from: isRightPanelOpened, reason: from getter */
            public boolean getIsRightPanelOpened() {
                return this.isRightPanelOpened;
            }

            public String toString() {
                StringBuilder sbU = outline.U("NoChannel(isRightPanelOpened=");
                sbU.append(getIsRightPanelOpened());
                sbU.append(", isOnHomeTab=");
                sbU.append(getIsOnHomeTab());
                sbU.append(")");
                return sbU.toString();
            }
        }

        private StoreState(boolean z2, boolean z3) {
            this.isRightPanelOpened = z2;
            this.isOnHomeTab = z3;
        }

        /* renamed from: isOnHomeTab, reason: from getter */
        public boolean getIsOnHomeTab() {
            return this.isOnHomeTab;
        }

        /* renamed from: isRightPanelOpened, reason: from getter */
        public boolean getIsRightPanelOpened() {
            return this.isRightPanelOpened;
        }

        public /* synthetic */ StoreState(boolean z2, boolean z3, DefaultConstructorMarker defaultConstructorMarker) {
            this(z2, z3);
        }
    }

    /* compiled from: WidgetChannelTopicViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\t\n\u000b\fB\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u001c\u0010\u0006\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0004\u001a\u0004\b\u0006\u0010\u0005\u0082\u0001\u0004\r\u000e\u000f\u0010¨\u0006\u0011"}, d2 = {"Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$ViewState;", "", "", "isRightPanelOpened", "Z", "()Z", "isOnHomeTab", "<init>", "(ZZ)V", "DM", "GDM", "Guild", "NoChannel", "Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$ViewState$NoChannel;", "Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$ViewState$Guild;", "Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$ViewState$DM;", "Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$ViewState$GDM;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {
        private final boolean isOnHomeTab;
        private final boolean isRightPanelOpened;

        /* compiled from: WidgetChannelTopicViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001Bc\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\u0019\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\t\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\n\u0010\u001c\u001a\u00060\u0005j\u0002`\u0010\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0013\u0012\u0006\u0010\u001e\u001a\u00020\u0013\u0012\u0006\u0010\u001f\u001a\u00020\u0013¢\u0006\u0004\b6\u00107J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0014\u0010\u0011\u001a\u00060\u0005j\u0002`\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0013HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0013HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0015Jz\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u0019\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00062\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\b\u0002\u0010\u001c\u001a\u00060\u0005j\u0002`\u00102\b\b\u0002\u0010\u001d\u001a\u00020\u00132\b\b\u0002\u0010\u001e\u001a\u00020\u00132\b\b\u0002\u0010\u001f\u001a\u00020\u0013HÆ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\"\u0010\u0004J\u0010\u0010$\u001a\u00020#HÖ\u0001¢\u0006\u0004\b$\u0010%J\u001a\u0010(\u001a\u00020\u00132\b\u0010'\u001a\u0004\u0018\u00010&HÖ\u0003¢\u0006\u0004\b(\u0010)R!\u0010\u0019\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010*\u001a\u0004\b+\u0010\bR\u001f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010,\u001a\u0004\b-\u0010\u000fR\u001c\u0010\u001f\u001a\u00020\u00138\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001f\u0010.\u001a\u0004\b\u001f\u0010\u0015R\u001f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010/\u001a\u0004\b0\u0010\u000bR\u001d\u0010\u001c\u001a\u00060\u0005j\u0002`\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u00101\u001a\u0004\b2\u0010\u0012R\u0019\u0010\u001d\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010.\u001a\u0004\b3\u0010\u0015R\u001c\u0010\u001e\u001a\u00020\u00138\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001e\u0010.\u001a\u0004\b\u001e\u0010\u0015R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u00104\u001a\u0004\b5\u0010\u0004¨\u00068"}, d2 = {"Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$ViewState$DM;", "Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$ViewState;", "", "component1", "()Ljava/lang/String;", "", "Lcom/discord/primitives/UserId;", "component2", "()Ljava/lang/Long;", "", "component3", "()Ljava/util/Set;", "", "Lcom/discord/models/member/GuildMember;", "component4", "()Ljava/util/List;", "Lcom/discord/primitives/ChannelId;", "component5", "()J", "", "component6", "()Z", "component7", "component8", "recipientName", "recipientUserId", "recipientNicknames", "guildMembers", "channelId", "developerModeEnabled", "isRightPanelOpened", "isOnHomeTab", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/util/Set;Ljava/util/List;JZZZ)Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$ViewState$DM;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Long;", "getRecipientUserId", "Ljava/util/List;", "getGuildMembers", "Z", "Ljava/util/Set;", "getRecipientNicknames", "J", "getChannelId", "getDeveloperModeEnabled", "Ljava/lang/String;", "getRecipientName", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/util/Set;Ljava/util/List;JZZZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class DM extends ViewState {
            private final long channelId;
            private final boolean developerModeEnabled;
            private final List<GuildMember> guildMembers;
            private final boolean isOnHomeTab;
            private final boolean isRightPanelOpened;
            private final String recipientName;
            private final Set<String> recipientNicknames;
            private final Long recipientUserId;

            public /* synthetic */ DM(String str, Long l, Set set, List list, long j, boolean z2, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, l, set, list, j, (i & 32) != 0 ? false : z2, z3, z4);
            }

            public static /* synthetic */ DM copy$default(DM dm, String str, Long l, Set set, List list, long j, boolean z2, boolean z3, boolean z4, int i, Object obj) {
                return dm.copy((i & 1) != 0 ? dm.recipientName : str, (i & 2) != 0 ? dm.recipientUserId : l, (i & 4) != 0 ? dm.recipientNicknames : set, (i & 8) != 0 ? dm.guildMembers : list, (i & 16) != 0 ? dm.channelId : j, (i & 32) != 0 ? dm.developerModeEnabled : z2, (i & 64) != 0 ? dm.getIsRightPanelOpened() : z3, (i & 128) != 0 ? dm.getIsOnHomeTab() : z4);
            }

            /* renamed from: component1, reason: from getter */
            public final String getRecipientName() {
                return this.recipientName;
            }

            /* renamed from: component2, reason: from getter */
            public final Long getRecipientUserId() {
                return this.recipientUserId;
            }

            public final Set<String> component3() {
                return this.recipientNicknames;
            }

            public final List<GuildMember> component4() {
                return this.guildMembers;
            }

            /* renamed from: component5, reason: from getter */
            public final long getChannelId() {
                return this.channelId;
            }

            /* renamed from: component6, reason: from getter */
            public final boolean getDeveloperModeEnabled() {
                return this.developerModeEnabled;
            }

            public final boolean component7() {
                return getIsRightPanelOpened();
            }

            public final boolean component8() {
                return getIsOnHomeTab();
            }

            public final DM copy(String recipientName, Long recipientUserId, Set<String> recipientNicknames, List<GuildMember> guildMembers, long channelId, boolean developerModeEnabled, boolean isRightPanelOpened, boolean isOnHomeTab) {
                Intrinsics3.checkNotNullParameter(recipientNicknames, "recipientNicknames");
                Intrinsics3.checkNotNullParameter(guildMembers, "guildMembers");
                return new DM(recipientName, recipientUserId, recipientNicknames, guildMembers, channelId, developerModeEnabled, isRightPanelOpened, isOnHomeTab);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof DM)) {
                    return false;
                }
                DM dm = (DM) other;
                return Intrinsics3.areEqual(this.recipientName, dm.recipientName) && Intrinsics3.areEqual(this.recipientUserId, dm.recipientUserId) && Intrinsics3.areEqual(this.recipientNicknames, dm.recipientNicknames) && Intrinsics3.areEqual(this.guildMembers, dm.guildMembers) && this.channelId == dm.channelId && this.developerModeEnabled == dm.developerModeEnabled && getIsRightPanelOpened() == dm.getIsRightPanelOpened() && getIsOnHomeTab() == dm.getIsOnHomeTab();
            }

            public final long getChannelId() {
                return this.channelId;
            }

            public final boolean getDeveloperModeEnabled() {
                return this.developerModeEnabled;
            }

            public final List<GuildMember> getGuildMembers() {
                return this.guildMembers;
            }

            public final String getRecipientName() {
                return this.recipientName;
            }

            public final Set<String> getRecipientNicknames() {
                return this.recipientNicknames;
            }

            public final Long getRecipientUserId() {
                return this.recipientUserId;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v10, types: [boolean] */
            /* JADX WARN: Type inference failed for: r0v13, types: [int] */
            /* JADX WARN: Type inference failed for: r0v15 */
            /* JADX WARN: Type inference failed for: r0v19 */
            /* JADX WARN: Type inference failed for: r2v7 */
            /* JADX WARN: Type inference failed for: r2v8, types: [int] */
            /* JADX WARN: Type inference failed for: r2v9 */
            public int hashCode() {
                String str = this.recipientName;
                int iHashCode = (str != null ? str.hashCode() : 0) * 31;
                Long l = this.recipientUserId;
                int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
                Set<String> set = this.recipientNicknames;
                int iHashCode3 = (iHashCode2 + (set != null ? set.hashCode() : 0)) * 31;
                List<GuildMember> list = this.guildMembers;
                int iA = (b.a(this.channelId) + ((iHashCode3 + (list != null ? list.hashCode() : 0)) * 31)) * 31;
                ?? r0 = this.developerModeEnabled;
                int i = r0;
                if (r0 != 0) {
                    i = 1;
                }
                int i2 = (iA + i) * 31;
                boolean isRightPanelOpened = getIsRightPanelOpened();
                ?? r02 = isRightPanelOpened;
                if (isRightPanelOpened) {
                    r02 = 1;
                }
                int i3 = (i2 + r02) * 31;
                boolean isOnHomeTab = getIsOnHomeTab();
                return i3 + (isOnHomeTab ? 1 : isOnHomeTab);
            }

            @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.ViewState
            /* renamed from: isOnHomeTab, reason: from getter */
            public boolean getIsOnHomeTab() {
                return this.isOnHomeTab;
            }

            @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.ViewState
            /* renamed from: isRightPanelOpened, reason: from getter */
            public boolean getIsRightPanelOpened() {
                return this.isRightPanelOpened;
            }

            public String toString() {
                StringBuilder sbU = outline.U("DM(recipientName=");
                sbU.append(this.recipientName);
                sbU.append(", recipientUserId=");
                sbU.append(this.recipientUserId);
                sbU.append(", recipientNicknames=");
                sbU.append(this.recipientNicknames);
                sbU.append(", guildMembers=");
                sbU.append(this.guildMembers);
                sbU.append(", channelId=");
                sbU.append(this.channelId);
                sbU.append(", developerModeEnabled=");
                sbU.append(this.developerModeEnabled);
                sbU.append(", isRightPanelOpened=");
                sbU.append(getIsRightPanelOpened());
                sbU.append(", isOnHomeTab=");
                sbU.append(getIsOnHomeTab());
                sbU.append(")");
                return sbU.toString();
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public DM(String str, Long l, Set<String> set, List<GuildMember> list, long j, boolean z2, boolean z3, boolean z4) {
                super(z3, z4, null);
                Intrinsics3.checkNotNullParameter(set, "recipientNicknames");
                Intrinsics3.checkNotNullParameter(list, "guildMembers");
                this.recipientName = str;
                this.recipientUserId = l;
                this.recipientNicknames = set;
                this.guildMembers = list;
                this.channelId = j;
                this.developerModeEnabled = z2;
                this.isRightPanelOpened = z3;
                this.isOnHomeTab = z4;
            }
        }

        /* compiled from: WidgetChannelTopicViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\n\u0010\u000f\u001a\u00060\u0005j\u0002`\u0006\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\t¢\u0006\u0004\b%\u0010&J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\f\u0010\u000bJ\u0010\u0010\r\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\r\u0010\u000bJF\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\f\b\u0002\u0010\u000f\u001a\u00060\u0005j\u0002`\u00062\b\b\u0002\u0010\u0010\u001a\u00020\t2\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001d\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u0019\u0010\u0010\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001f\u001a\u0004\b \u0010\u000bR\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010!\u001a\u0004\b\"\u0010\u0004R\u001c\u0010\u0012\u001a\u00020\t8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001f\u001a\u0004\b\u0012\u0010\u000bR\u001c\u0010\u0011\u001a\u00020\t8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001f\u001a\u0004\b\u0011\u0010\u000bR\u001d\u0010\u000f\u001a\u00060\u0005j\u0002`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010#\u001a\u0004\b$\u0010\b¨\u0006'"}, d2 = {"Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$ViewState$GDM;", "Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$ViewState;", "Lcom/discord/api/channel/Channel;", "component1", "()Lcom/discord/api/channel/Channel;", "", "Lcom/discord/primitives/ChannelId;", "component2", "()J", "", "component3", "()Z", "component4", "component5", "channel", "channelId", "developerModeEnabled", "isRightPanelOpened", "isOnHomeTab", "copy", "(Lcom/discord/api/channel/Channel;JZZZ)Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$ViewState$GDM;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getDeveloperModeEnabled", "Lcom/discord/api/channel/Channel;", "getChannel", "J", "getChannelId", "<init>", "(Lcom/discord/api/channel/Channel;JZZZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class GDM extends ViewState {
            private final Channel channel;
            private final long channelId;
            private final boolean developerModeEnabled;
            private final boolean isOnHomeTab;
            private final boolean isRightPanelOpened;

            public /* synthetic */ GDM(Channel channel, long j, boolean z2, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(channel, j, (i & 4) != 0 ? false : z2, z3, z4);
            }

            public static /* synthetic */ GDM copy$default(GDM gdm, Channel channel, long j, boolean z2, boolean z3, boolean z4, int i, Object obj) {
                if ((i & 1) != 0) {
                    channel = gdm.channel;
                }
                if ((i & 2) != 0) {
                    j = gdm.channelId;
                }
                long j2 = j;
                if ((i & 4) != 0) {
                    z2 = gdm.developerModeEnabled;
                }
                boolean z5 = z2;
                if ((i & 8) != 0) {
                    z3 = gdm.getIsRightPanelOpened();
                }
                boolean z6 = z3;
                if ((i & 16) != 0) {
                    z4 = gdm.getIsOnHomeTab();
                }
                return gdm.copy(channel, j2, z5, z6, z4);
            }

            /* renamed from: component1, reason: from getter */
            public final Channel getChannel() {
                return this.channel;
            }

            /* renamed from: component2, reason: from getter */
            public final long getChannelId() {
                return this.channelId;
            }

            /* renamed from: component3, reason: from getter */
            public final boolean getDeveloperModeEnabled() {
                return this.developerModeEnabled;
            }

            public final boolean component4() {
                return getIsRightPanelOpened();
            }

            public final boolean component5() {
                return getIsOnHomeTab();
            }

            public final GDM copy(Channel channel, long channelId, boolean developerModeEnabled, boolean isRightPanelOpened, boolean isOnHomeTab) {
                Intrinsics3.checkNotNullParameter(channel, "channel");
                return new GDM(channel, channelId, developerModeEnabled, isRightPanelOpened, isOnHomeTab);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof GDM)) {
                    return false;
                }
                GDM gdm = (GDM) other;
                return Intrinsics3.areEqual(this.channel, gdm.channel) && this.channelId == gdm.channelId && this.developerModeEnabled == gdm.developerModeEnabled && getIsRightPanelOpened() == gdm.getIsRightPanelOpened() && getIsOnHomeTab() == gdm.getIsOnHomeTab();
            }

            public final Channel getChannel() {
                return this.channel;
            }

            public final long getChannelId() {
                return this.channelId;
            }

            public final boolean getDeveloperModeEnabled() {
                return this.developerModeEnabled;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v13 */
            /* JADX WARN: Type inference failed for: r0v4, types: [boolean] */
            /* JADX WARN: Type inference failed for: r0v7, types: [int] */
            /* JADX WARN: Type inference failed for: r0v9 */
            /* JADX WARN: Type inference failed for: r2v0 */
            /* JADX WARN: Type inference failed for: r2v1, types: [int] */
            /* JADX WARN: Type inference failed for: r2v2 */
            public int hashCode() {
                Channel channel = this.channel;
                int iA = (b.a(this.channelId) + ((channel != null ? channel.hashCode() : 0) * 31)) * 31;
                ?? r0 = this.developerModeEnabled;
                int i = r0;
                if (r0 != 0) {
                    i = 1;
                }
                int i2 = (iA + i) * 31;
                boolean isRightPanelOpened = getIsRightPanelOpened();
                ?? r02 = isRightPanelOpened;
                if (isRightPanelOpened) {
                    r02 = 1;
                }
                int i3 = (i2 + r02) * 31;
                boolean isOnHomeTab = getIsOnHomeTab();
                return i3 + (isOnHomeTab ? 1 : isOnHomeTab);
            }

            @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.ViewState
            /* renamed from: isOnHomeTab, reason: from getter */
            public boolean getIsOnHomeTab() {
                return this.isOnHomeTab;
            }

            @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.ViewState
            /* renamed from: isRightPanelOpened, reason: from getter */
            public boolean getIsRightPanelOpened() {
                return this.isRightPanelOpened;
            }

            public String toString() {
                StringBuilder sbU = outline.U("GDM(channel=");
                sbU.append(this.channel);
                sbU.append(", channelId=");
                sbU.append(this.channelId);
                sbU.append(", developerModeEnabled=");
                sbU.append(this.developerModeEnabled);
                sbU.append(", isRightPanelOpened=");
                sbU.append(getIsRightPanelOpened());
                sbU.append(", isOnHomeTab=");
                sbU.append(getIsOnHomeTab());
                sbU.append(")");
                return sbU.toString();
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public GDM(Channel channel, long j, boolean z2, boolean z3, boolean z4) {
                super(z3, z4, null);
                Intrinsics3.checkNotNullParameter(channel, "channel");
                this.channel = channel;
                this.channelId = j;
                this.developerModeEnabled = z2;
                this.isRightPanelOpened = z3;
                this.isOnHomeTab = z4;
            }
        }

        /* compiled from: WidgetChannelTopicViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u000e\u000fB!\b\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u0003\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u001c\u0010\u0006\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0004\u001a\u0004\b\u0006\u0010\u0005R\u001c\u0010\b\u001a\u00020\u00078\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\u0082\u0001\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$ViewState$Guild;", "Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$ViewState;", "", "isRightPanelOpened", "Z", "()Z", "isOnHomeTab", "Lcom/discord/utilities/channel/GuildChannelIconType;", "channelIconType", "Lcom/discord/utilities/channel/GuildChannelIconType;", "getChannelIconType", "()Lcom/discord/utilities/channel/GuildChannelIconType;", "<init>", "(Lcom/discord/utilities/channel/GuildChannelIconType;ZZ)V", "DefaultTopic", "Topic", "Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$ViewState$Guild$DefaultTopic;", "Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$ViewState$Guild$Topic;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static abstract class Guild extends ViewState {
            private final GuildChannelIconUtils channelIconType;
            private final boolean isOnHomeTab;
            private final boolean isRightPanelOpened;

            /* compiled from: WidgetChannelTopicViewModel.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ8\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u001c\u0010\u000f\u001a\u00020\b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b\u000f\u0010\nR\u0019\u0010\r\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b\u001e\u0010\u0007R\u001c\u0010\u000e\u001a\u00020\b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b\u000e\u0010\nR\u001c\u0010\f\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010\u001f\u001a\u0004\b \u0010\u0004¨\u0006#"}, d2 = {"Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$ViewState$Guild$DefaultTopic;", "Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$ViewState$Guild;", "Lcom/discord/utilities/channel/GuildChannelIconType;", "component1", "()Lcom/discord/utilities/channel/GuildChannelIconType;", "Lcom/discord/api/channel/Channel;", "component2", "()Lcom/discord/api/channel/Channel;", "", "component3", "()Z", "component4", "channelIconType", "channel", "isRightPanelOpened", "isOnHomeTab", "copy", "(Lcom/discord/utilities/channel/GuildChannelIconType;Lcom/discord/api/channel/Channel;ZZ)Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$ViewState$Guild$DefaultTopic;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "Lcom/discord/api/channel/Channel;", "getChannel", "Lcom/discord/utilities/channel/GuildChannelIconType;", "getChannelIconType", "<init>", "(Lcom/discord/utilities/channel/GuildChannelIconType;Lcom/discord/api/channel/Channel;ZZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
            public static final /* data */ class DefaultTopic extends Guild {
                private final Channel channel;
                private final GuildChannelIconUtils channelIconType;
                private final boolean isOnHomeTab;
                private final boolean isRightPanelOpened;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public DefaultTopic(GuildChannelIconUtils guildChannelIconUtils, Channel channel, boolean z2, boolean z3) {
                    super(guildChannelIconUtils, z2, z3, null);
                    Intrinsics3.checkNotNullParameter(guildChannelIconUtils, "channelIconType");
                    Intrinsics3.checkNotNullParameter(channel, "channel");
                    this.channelIconType = guildChannelIconUtils;
                    this.channel = channel;
                    this.isRightPanelOpened = z2;
                    this.isOnHomeTab = z3;
                }

                public static /* synthetic */ DefaultTopic copy$default(DefaultTopic defaultTopic, GuildChannelIconUtils guildChannelIconUtils, Channel channel, boolean z2, boolean z3, int i, Object obj) {
                    if ((i & 1) != 0) {
                        guildChannelIconUtils = defaultTopic.getChannelIconType();
                    }
                    if ((i & 2) != 0) {
                        channel = defaultTopic.channel;
                    }
                    if ((i & 4) != 0) {
                        z2 = defaultTopic.getIsRightPanelOpened();
                    }
                    if ((i & 8) != 0) {
                        z3 = defaultTopic.getIsOnHomeTab();
                    }
                    return defaultTopic.copy(guildChannelIconUtils, channel, z2, z3);
                }

                public final GuildChannelIconUtils component1() {
                    return getChannelIconType();
                }

                /* renamed from: component2, reason: from getter */
                public final Channel getChannel() {
                    return this.channel;
                }

                public final boolean component3() {
                    return getIsRightPanelOpened();
                }

                public final boolean component4() {
                    return getIsOnHomeTab();
                }

                public final DefaultTopic copy(GuildChannelIconUtils channelIconType, Channel channel, boolean isRightPanelOpened, boolean isOnHomeTab) {
                    Intrinsics3.checkNotNullParameter(channelIconType, "channelIconType");
                    Intrinsics3.checkNotNullParameter(channel, "channel");
                    return new DefaultTopic(channelIconType, channel, isRightPanelOpened, isOnHomeTab);
                }

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof DefaultTopic)) {
                        return false;
                    }
                    DefaultTopic defaultTopic = (DefaultTopic) other;
                    return Intrinsics3.areEqual(getChannelIconType(), defaultTopic.getChannelIconType()) && Intrinsics3.areEqual(this.channel, defaultTopic.channel) && getIsRightPanelOpened() == defaultTopic.getIsRightPanelOpened() && getIsOnHomeTab() == defaultTopic.getIsOnHomeTab();
                }

                public final Channel getChannel() {
                    return this.channel;
                }

                @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.ViewState.Guild
                public GuildChannelIconUtils getChannelIconType() {
                    return this.channelIconType;
                }

                public int hashCode() {
                    GuildChannelIconUtils channelIconType = getChannelIconType();
                    int iHashCode = (channelIconType != null ? channelIconType.hashCode() : 0) * 31;
                    Channel channel = this.channel;
                    int iHashCode2 = (iHashCode + (channel != null ? channel.hashCode() : 0)) * 31;
                    boolean isRightPanelOpened = getIsRightPanelOpened();
                    int i = isRightPanelOpened;
                    if (isRightPanelOpened) {
                        i = 1;
                    }
                    int i2 = (iHashCode2 + i) * 31;
                    boolean isOnHomeTab = getIsOnHomeTab();
                    return i2 + (isOnHomeTab ? 1 : isOnHomeTab);
                }

                @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.ViewState.Guild, com.discord.widgets.channels.WidgetChannelTopicViewModel.ViewState
                /* renamed from: isOnHomeTab, reason: from getter */
                public boolean getIsOnHomeTab() {
                    return this.isOnHomeTab;
                }

                @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.ViewState.Guild, com.discord.widgets.channels.WidgetChannelTopicViewModel.ViewState
                /* renamed from: isRightPanelOpened, reason: from getter */
                public boolean getIsRightPanelOpened() {
                    return this.isRightPanelOpened;
                }

                public String toString() {
                    StringBuilder sbU = outline.U("DefaultTopic(channelIconType=");
                    sbU.append(getChannelIconType());
                    sbU.append(", channel=");
                    sbU.append(this.channel);
                    sbU.append(", isRightPanelOpened=");
                    sbU.append(getIsRightPanelOpened());
                    sbU.append(", isOnHomeTab=");
                    sbU.append(getIsOnHomeTab());
                    sbU.append(")");
                    return sbU.toString();
                }
            }

            /* compiled from: WidgetChannelTopicViewModel.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001B\u009b\u0001\u0012\u0006\u0010 \u001a\u00020\u0002\u0012\u0016\u0010!\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\u00020\u0005\u0012\u0016\u0010\"\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\n\u0012\u0004\u0012\u00020\u00020\u0005\u0012\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f0\u0005\u0012\u0006\u0010$\u001a\u00020\u000e\u0012\u0016\u0010%\u001a\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u0011j\u0002`\u0014\u0012\u0006\u0010&\u001a\u00020\u000e\u0012\u0006\u0010'\u001a\u00020\u0018\u0012\u0006\u0010(\u001a\u00020\u001b\u0012\u0006\u0010)\u001a\u00020\u000e\u0012\u0006\u0010*\u001a\u00020\u000e¢\u0006\u0004\bC\u0010DJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\b\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ \u0010\u000b\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\n\u0012\u0004\u0012\u00020\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000b\u0010\tJ\u001c\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f0\u0005HÆ\u0003¢\u0006\u0004\b\r\u0010\tJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J \u0010\u0015\u001a\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u0011j\u0002`\u0014HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0010J\u0010\u0010\u0019\u001a\u00020\u0018HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u001bHÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u001e\u0010\u0010J\u0010\u0010\u001f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u001f\u0010\u0010Jº\u0001\u0010+\u001a\u00020\u00002\b\b\u0002\u0010 \u001a\u00020\u00022\u0018\b\u0002\u0010!\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\u00020\u00052\u0018\b\u0002\u0010\"\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\n\u0012\u0004\u0012\u00020\u00020\u00052\u0014\b\u0002\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f0\u00052\b\b\u0002\u0010$\u001a\u00020\u000e2\u0018\b\u0002\u0010%\u001a\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u0011j\u0002`\u00142\b\b\u0002\u0010&\u001a\u00020\u000e2\b\b\u0002\u0010'\u001a\u00020\u00182\b\b\u0002\u0010(\u001a\u00020\u001b2\b\b\u0002\u0010)\u001a\u00020\u000e2\b\b\u0002\u0010*\u001a\u00020\u000eHÆ\u0001¢\u0006\u0004\b+\u0010,J\u0010\u0010-\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b-\u0010\u0004J\u0010\u0010/\u001a\u00020.HÖ\u0001¢\u0006\u0004\b/\u00100J\u001a\u00103\u001a\u00020\u000e2\b\u00102\u001a\u0004\u0018\u000101HÖ\u0003¢\u0006\u0004\b3\u00104R\u0019\u0010$\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b$\u00105\u001a\u0004\b6\u0010\u0010R\u001c\u0010*\u001a\u00020\u000e8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b*\u00105\u001a\u0004\b*\u0010\u0010R\u0019\u0010&\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b&\u00105\u001a\u0004\b&\u0010\u0010R%\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f0\u00058\u0006@\u0006¢\u0006\f\n\u0004\b#\u00107\u001a\u0004\b8\u0010\tR\u001c\u0010)\u001a\u00020\u000e8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b)\u00105\u001a\u0004\b)\u0010\u0010R\u0019\u0010(\u001a\u00020\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b(\u00109\u001a\u0004\b:\u0010\u001dR\u0019\u0010 \u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b \u0010;\u001a\u0004\b<\u0010\u0004R\u001c\u0010'\u001a\u00020\u00188\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b'\u0010=\u001a\u0004\b>\u0010\u001aR)\u0010%\u001a\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u0011j\u0002`\u00148\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010?\u001a\u0004\b@\u0010\u0016R)\u0010!\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b!\u00107\u001a\u0004\bA\u0010\tR)\u0010\"\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\n\u0012\u0004\u0012\u00020\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\"\u00107\u001a\u0004\bB\u0010\t¨\u0006E"}, d2 = {"Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$ViewState$Guild$Topic;", "Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$ViewState$Guild;", "", "component1", "()Ljava/lang/String;", "", "", "Lcom/discord/primitives/ChannelId;", "component2", "()Ljava/util/Map;", "Lcom/discord/primitives/UserId;", "component3", "Lcom/discord/api/role/GuildRole;", "component4", "", "component5", "()Z", "", "Lcom/discord/simpleast/core/node/Node;", "Lcom/discord/utilities/textprocessing/MessageRenderContext;", "Lcom/discord/widgets/channels/AST;", "component6", "()Ljava/util/List;", "component7", "Lcom/discord/utilities/channel/GuildChannelIconType;", "component8", "()Lcom/discord/utilities/channel/GuildChannelIconType;", "Lcom/discord/api/channel/Channel;", "component9", "()Lcom/discord/api/channel/Channel;", "component10", "component11", "rawTopicString", "channelNames", "userNames", "roles", "allowAnimatedEmojis", "ast", "isLinkifyConflicting", "channelIconType", "channel", "isRightPanelOpened", "isOnHomeTab", "copy", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;ZLjava/util/List;ZLcom/discord/utilities/channel/GuildChannelIconType;Lcom/discord/api/channel/Channel;ZZ)Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$ViewState$Guild$Topic;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getAllowAnimatedEmojis", "Ljava/util/Map;", "getRoles", "Lcom/discord/api/channel/Channel;", "getChannel", "Ljava/lang/String;", "getRawTopicString", "Lcom/discord/utilities/channel/GuildChannelIconType;", "getChannelIconType", "Ljava/util/List;", "getAst", "getChannelNames", "getUserNames", "<init>", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;ZLjava/util/List;ZLcom/discord/utilities/channel/GuildChannelIconType;Lcom/discord/api/channel/Channel;ZZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
            public static final /* data */ class Topic extends Guild {
                private final boolean allowAnimatedEmojis;
                private final List<Node<MessageRenderContext>> ast;
                private final Channel channel;
                private final GuildChannelIconUtils channelIconType;
                private final Map<Long, String> channelNames;
                private final boolean isLinkifyConflicting;
                private final boolean isOnHomeTab;
                private final boolean isRightPanelOpened;
                private final String rawTopicString;
                private final Map<Long, GuildRole> roles;
                private final Map<Long, String> userNames;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public Topic(String str, Map<Long, String> map, Map<Long, String> map2, Map<Long, GuildRole> map3, boolean z2, List<Node<MessageRenderContext>> list, boolean z3, GuildChannelIconUtils guildChannelIconUtils, Channel channel, boolean z4, boolean z5) {
                    super(guildChannelIconUtils, z4, z5, null);
                    Intrinsics3.checkNotNullParameter(str, "rawTopicString");
                    Intrinsics3.checkNotNullParameter(map, "channelNames");
                    Intrinsics3.checkNotNullParameter(map2, "userNames");
                    Intrinsics3.checkNotNullParameter(map3, "roles");
                    Intrinsics3.checkNotNullParameter(list, "ast");
                    Intrinsics3.checkNotNullParameter(guildChannelIconUtils, "channelIconType");
                    Intrinsics3.checkNotNullParameter(channel, "channel");
                    this.rawTopicString = str;
                    this.channelNames = map;
                    this.userNames = map2;
                    this.roles = map3;
                    this.allowAnimatedEmojis = z2;
                    this.ast = list;
                    this.isLinkifyConflicting = z3;
                    this.channelIconType = guildChannelIconUtils;
                    this.channel = channel;
                    this.isRightPanelOpened = z4;
                    this.isOnHomeTab = z5;
                }

                public static /* synthetic */ Topic copy$default(Topic topic, String str, Map map, Map map2, Map map3, boolean z2, List list, boolean z3, GuildChannelIconUtils guildChannelIconUtils, Channel channel, boolean z4, boolean z5, int i, Object obj) {
                    return topic.copy((i & 1) != 0 ? topic.rawTopicString : str, (i & 2) != 0 ? topic.channelNames : map, (i & 4) != 0 ? topic.userNames : map2, (i & 8) != 0 ? topic.roles : map3, (i & 16) != 0 ? topic.allowAnimatedEmojis : z2, (i & 32) != 0 ? topic.ast : list, (i & 64) != 0 ? topic.isLinkifyConflicting : z3, (i & 128) != 0 ? topic.getChannelIconType() : guildChannelIconUtils, (i & 256) != 0 ? topic.channel : channel, (i & 512) != 0 ? topic.getIsRightPanelOpened() : z4, (i & 1024) != 0 ? topic.getIsOnHomeTab() : z5);
                }

                /* renamed from: component1, reason: from getter */
                public final String getRawTopicString() {
                    return this.rawTopicString;
                }

                public final boolean component10() {
                    return getIsRightPanelOpened();
                }

                public final boolean component11() {
                    return getIsOnHomeTab();
                }

                public final Map<Long, String> component2() {
                    return this.channelNames;
                }

                public final Map<Long, String> component3() {
                    return this.userNames;
                }

                public final Map<Long, GuildRole> component4() {
                    return this.roles;
                }

                /* renamed from: component5, reason: from getter */
                public final boolean getAllowAnimatedEmojis() {
                    return this.allowAnimatedEmojis;
                }

                public final List<Node<MessageRenderContext>> component6() {
                    return this.ast;
                }

                /* renamed from: component7, reason: from getter */
                public final boolean getIsLinkifyConflicting() {
                    return this.isLinkifyConflicting;
                }

                public final GuildChannelIconUtils component8() {
                    return getChannelIconType();
                }

                /* renamed from: component9, reason: from getter */
                public final Channel getChannel() {
                    return this.channel;
                }

                public final Topic copy(String rawTopicString, Map<Long, String> channelNames, Map<Long, String> userNames, Map<Long, GuildRole> roles, boolean allowAnimatedEmojis, List<Node<MessageRenderContext>> ast, boolean isLinkifyConflicting, GuildChannelIconUtils channelIconType, Channel channel, boolean isRightPanelOpened, boolean isOnHomeTab) {
                    Intrinsics3.checkNotNullParameter(rawTopicString, "rawTopicString");
                    Intrinsics3.checkNotNullParameter(channelNames, "channelNames");
                    Intrinsics3.checkNotNullParameter(userNames, "userNames");
                    Intrinsics3.checkNotNullParameter(roles, "roles");
                    Intrinsics3.checkNotNullParameter(ast, "ast");
                    Intrinsics3.checkNotNullParameter(channelIconType, "channelIconType");
                    Intrinsics3.checkNotNullParameter(channel, "channel");
                    return new Topic(rawTopicString, channelNames, userNames, roles, allowAnimatedEmojis, ast, isLinkifyConflicting, channelIconType, channel, isRightPanelOpened, isOnHomeTab);
                }

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof Topic)) {
                        return false;
                    }
                    Topic topic = (Topic) other;
                    return Intrinsics3.areEqual(this.rawTopicString, topic.rawTopicString) && Intrinsics3.areEqual(this.channelNames, topic.channelNames) && Intrinsics3.areEqual(this.userNames, topic.userNames) && Intrinsics3.areEqual(this.roles, topic.roles) && this.allowAnimatedEmojis == topic.allowAnimatedEmojis && Intrinsics3.areEqual(this.ast, topic.ast) && this.isLinkifyConflicting == topic.isLinkifyConflicting && Intrinsics3.areEqual(getChannelIconType(), topic.getChannelIconType()) && Intrinsics3.areEqual(this.channel, topic.channel) && getIsRightPanelOpened() == topic.getIsRightPanelOpened() && getIsOnHomeTab() == topic.getIsOnHomeTab();
                }

                public final boolean getAllowAnimatedEmojis() {
                    return this.allowAnimatedEmojis;
                }

                public final List<Node<MessageRenderContext>> getAst() {
                    return this.ast;
                }

                public final Channel getChannel() {
                    return this.channel;
                }

                @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.ViewState.Guild
                public GuildChannelIconUtils getChannelIconType() {
                    return this.channelIconType;
                }

                public final Map<Long, String> getChannelNames() {
                    return this.channelNames;
                }

                public final String getRawTopicString() {
                    return this.rawTopicString;
                }

                public final Map<Long, GuildRole> getRoles() {
                    return this.roles;
                }

                public final Map<Long, String> getUserNames() {
                    return this.userNames;
                }

                /* JADX WARN: Multi-variable type inference failed */
                public int hashCode() {
                    String str = this.rawTopicString;
                    int iHashCode = (str != null ? str.hashCode() : 0) * 31;
                    Map<Long, String> map = this.channelNames;
                    int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
                    Map<Long, String> map2 = this.userNames;
                    int iHashCode3 = (iHashCode2 + (map2 != null ? map2.hashCode() : 0)) * 31;
                    Map<Long, GuildRole> map3 = this.roles;
                    int iHashCode4 = (iHashCode3 + (map3 != null ? map3.hashCode() : 0)) * 31;
                    boolean z2 = this.allowAnimatedEmojis;
                    int i = z2;
                    if (z2 != 0) {
                        i = 1;
                    }
                    int i2 = (iHashCode4 + i) * 31;
                    List<Node<MessageRenderContext>> list = this.ast;
                    int iHashCode5 = (i2 + (list != null ? list.hashCode() : 0)) * 31;
                    boolean z3 = this.isLinkifyConflicting;
                    int i3 = z3;
                    if (z3 != 0) {
                        i3 = 1;
                    }
                    int i4 = (iHashCode5 + i3) * 31;
                    GuildChannelIconUtils channelIconType = getChannelIconType();
                    int iHashCode6 = (i4 + (channelIconType != null ? channelIconType.hashCode() : 0)) * 31;
                    Channel channel = this.channel;
                    int iHashCode7 = (iHashCode6 + (channel != null ? channel.hashCode() : 0)) * 31;
                    boolean isRightPanelOpened = getIsRightPanelOpened();
                    int i5 = isRightPanelOpened;
                    if (isRightPanelOpened) {
                        i5 = 1;
                    }
                    int i6 = (iHashCode7 + i5) * 31;
                    boolean isOnHomeTab = getIsOnHomeTab();
                    return i6 + (isOnHomeTab ? 1 : isOnHomeTab);
                }

                public final boolean isLinkifyConflicting() {
                    return this.isLinkifyConflicting;
                }

                @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.ViewState.Guild, com.discord.widgets.channels.WidgetChannelTopicViewModel.ViewState
                /* renamed from: isOnHomeTab, reason: from getter */
                public boolean getIsOnHomeTab() {
                    return this.isOnHomeTab;
                }

                @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.ViewState.Guild, com.discord.widgets.channels.WidgetChannelTopicViewModel.ViewState
                /* renamed from: isRightPanelOpened, reason: from getter */
                public boolean getIsRightPanelOpened() {
                    return this.isRightPanelOpened;
                }

                public String toString() {
                    StringBuilder sbU = outline.U("Topic(rawTopicString=");
                    sbU.append(this.rawTopicString);
                    sbU.append(", channelNames=");
                    sbU.append(this.channelNames);
                    sbU.append(", userNames=");
                    sbU.append(this.userNames);
                    sbU.append(", roles=");
                    sbU.append(this.roles);
                    sbU.append(", allowAnimatedEmojis=");
                    sbU.append(this.allowAnimatedEmojis);
                    sbU.append(", ast=");
                    sbU.append(this.ast);
                    sbU.append(", isLinkifyConflicting=");
                    sbU.append(this.isLinkifyConflicting);
                    sbU.append(", channelIconType=");
                    sbU.append(getChannelIconType());
                    sbU.append(", channel=");
                    sbU.append(this.channel);
                    sbU.append(", isRightPanelOpened=");
                    sbU.append(getIsRightPanelOpened());
                    sbU.append(", isOnHomeTab=");
                    sbU.append(getIsOnHomeTab());
                    sbU.append(")");
                    return sbU.toString();
                }
            }

            public /* synthetic */ Guild(GuildChannelIconUtils guildChannelIconUtils, boolean z2, boolean z3, DefaultConstructorMarker defaultConstructorMarker) {
                this(guildChannelIconUtils, z2, z3);
            }

            public GuildChannelIconUtils getChannelIconType() {
                return this.channelIconType;
            }

            @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.ViewState
            /* renamed from: isOnHomeTab, reason: from getter */
            public boolean getIsOnHomeTab() {
                return this.isOnHomeTab;
            }

            @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.ViewState
            /* renamed from: isRightPanelOpened, reason: from getter */
            public boolean getIsRightPanelOpened() {
                return this.isRightPanelOpened;
            }

            private Guild(GuildChannelIconUtils guildChannelIconUtils, boolean z2, boolean z3) {
                super(z2, z3, null);
                this.channelIconType = guildChannelIconUtils;
                this.isRightPanelOpened = z2;
                this.isOnHomeTab = z3;
            }
        }

        /* compiled from: WidgetChannelTopicViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0007\u0010\u0004R\u001c\u0010\u0006\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0006\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$ViewState$NoChannel;", "Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$ViewState;", "", "component1", "()Z", "component2", "isRightPanelOpened", "isOnHomeTab", "copy", "(ZZ)Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$ViewState$NoChannel;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "<init>", "(ZZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class NoChannel extends ViewState {
            private final boolean isOnHomeTab;
            private final boolean isRightPanelOpened;

            public NoChannel(boolean z2, boolean z3) {
                super(z2, z3, null);
                this.isRightPanelOpened = z2;
                this.isOnHomeTab = z3;
            }

            public static /* synthetic */ NoChannel copy$default(NoChannel noChannel, boolean z2, boolean z3, int i, Object obj) {
                if ((i & 1) != 0) {
                    z2 = noChannel.getIsRightPanelOpened();
                }
                if ((i & 2) != 0) {
                    z3 = noChannel.getIsOnHomeTab();
                }
                return noChannel.copy(z2, z3);
            }

            public final boolean component1() {
                return getIsRightPanelOpened();
            }

            public final boolean component2() {
                return getIsOnHomeTab();
            }

            public final NoChannel copy(boolean isRightPanelOpened, boolean isOnHomeTab) {
                return new NoChannel(isRightPanelOpened, isOnHomeTab);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof NoChannel)) {
                    return false;
                }
                NoChannel noChannel = (NoChannel) other;
                return getIsRightPanelOpened() == noChannel.getIsRightPanelOpened() && getIsOnHomeTab() == noChannel.getIsOnHomeTab();
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [int] */
            /* JADX WARN: Type inference failed for: r0v4 */
            /* JADX WARN: Type inference failed for: r0v5 */
            /* JADX WARN: Type inference failed for: r1v0 */
            /* JADX WARN: Type inference failed for: r1v1, types: [int] */
            /* JADX WARN: Type inference failed for: r1v2 */
            public int hashCode() {
                boolean isRightPanelOpened = getIsRightPanelOpened();
                ?? r0 = isRightPanelOpened;
                if (isRightPanelOpened) {
                    r0 = 1;
                }
                int i = r0 * 31;
                boolean isOnHomeTab = getIsOnHomeTab();
                return i + (isOnHomeTab ? 1 : isOnHomeTab);
            }

            @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.ViewState
            /* renamed from: isOnHomeTab, reason: from getter */
            public boolean getIsOnHomeTab() {
                return this.isOnHomeTab;
            }

            @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.ViewState
            /* renamed from: isRightPanelOpened, reason: from getter */
            public boolean getIsRightPanelOpened() {
                return this.isRightPanelOpened;
            }

            public String toString() {
                StringBuilder sbU = outline.U("NoChannel(isRightPanelOpened=");
                sbU.append(getIsRightPanelOpened());
                sbU.append(", isOnHomeTab=");
                sbU.append(getIsOnHomeTab());
                sbU.append(")");
                return sbU.toString();
            }
        }

        private ViewState(boolean z2, boolean z3) {
            this.isRightPanelOpened = z2;
            this.isOnHomeTab = z3;
        }

        /* renamed from: isOnHomeTab, reason: from getter */
        public boolean getIsOnHomeTab() {
            return this.isOnHomeTab;
        }

        /* renamed from: isRightPanelOpened, reason: from getter */
        public boolean getIsRightPanelOpened() {
            return this.isRightPanelOpened;
        }

        public /* synthetic */ ViewState(boolean z2, boolean z3, DefaultConstructorMarker defaultConstructorMarker) {
            this(z2, z3);
        }
    }

    public WidgetChannelTopicViewModel() {
        this(null, null, 3, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetChannelTopicViewModel(Observable observable, Parser parser, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            observable = Companion.observeNavState$default(INSTANCE, null, null, 3, null).Y(AnonymousClass1.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observable, "observeNavState().switch…avState\n    ).take(1)\n  }");
        }
        this(observable, (i & 2) != 0 ? DiscordParser.createParser$default(false, true, false, false, false, 28, null) : parser);
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetChannelTopicViewModel widgetChannelTopicViewModel, StoreState storeState) {
        widgetChannelTopicViewModel.handleStoreState(storeState);
    }

    private final List<Node<MessageRenderContext>> generateAST(CharSequence rawTopicString) {
        return Parser.parse$default(this.topicParser, rawTopicString, MessageParseState.INSTANCE.getInitialState(), null, 4, null);
    }

    private final void handleGuildStoreState(StoreState.Guild storeState) {
        String username;
        if (storeState instanceof StoreState.Guild.DefaultTopic) {
            StoreState.Guild.DefaultTopic defaultTopic = (StoreState.Guild.DefaultTopic) storeState;
            updateViewState(new ViewState.Guild.DefaultTopic(defaultTopic.getChannelIconType(), defaultTopic.getChannel(), storeState.getIsRightPanelOpened(), storeState.getIsOnHomeTab()));
            return;
        }
        if (!(storeState instanceof StoreState.Guild.Topic)) {
            throw new NoWhenBranchMatchedException();
        }
        StoreState.Guild.Topic topic = (StoreState.Guild.Topic) storeState;
        String topic2 = topic.getChannel().getTopic();
        List<Node<MessageRenderContext>> listGenerateAST = generateAST(topic2 != null ? topic2 : "");
        MessagePreprocessor messagePreprocessor = new MessagePreprocessor(-1L, this.revealedIndices, null, false, null, 28, null);
        messagePreprocessor.process(listGenerateAST);
        Map<Long, User> users = topic.getUsers();
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsJVM.mapCapacity(users.size()));
        Iterator<T> it = users.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            long jLongValue = ((Number) entry.getKey()).longValue();
            User user = (User) entry.getValue();
            GuildMember guildMember = topic.getMembers().get(Long.valueOf(jLongValue));
            if (guildMember == null || (username = guildMember.getNick()) == null) {
                username = user.getUsername();
            }
            linkedHashMap.put(key, username);
        }
        String str = topic2 != null ? topic2 : "";
        Map<Long, Channel> channels = topic.getChannels();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsJVM.mapCapacity(channels.size()));
        Iterator<T> it2 = channels.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it2.next();
            linkedHashMap2.put(entry2.getKey(), ChannelUtils.c((Channel) entry2.getValue()));
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        for (Map.Entry entry3 : linkedHashMap2.entrySet()) {
            if (((String) entry3.getValue()).length() > 0) {
                linkedHashMap3.put(entry3.getKey(), entry3.getValue());
            }
        }
        updateViewState(new ViewState.Guild.Topic(str, linkedHashMap3, linkedHashMap, topic.getRoles(), topic.getAllowAnimatedEmojis(), listGenerateAST, messagePreprocessor.isLinkifyConflicting(), topic.getChannelIconType(), topic.getChannel(), storeState.getIsRightPanelOpened(), storeState.getIsOnHomeTab()));
    }

    private final void handlePrivateStoreState(StoreState storeState) {
        if (!(storeState instanceof StoreState.DM)) {
            if (storeState instanceof StoreState.GDM) {
                StoreState.GDM gdm = (StoreState.GDM) storeState;
                updateViewState(new ViewState.GDM(gdm.getChannel(), gdm.getChannel().getId(), gdm.getDeveloperModeEnabled(), storeState.getIsRightPanelOpened(), storeState.getIsOnHomeTab()));
                return;
            }
            return;
        }
        StoreState.DM dm = (StoreState.DM) storeState;
        User userA = ChannelUtils.a(dm.getChannel());
        String nickOrUsername$default = userA != null ? GuildMember.Companion.getNickOrUsername$default(GuildMember.INSTANCE, userA, null, dm.getChannel(), null, 8, null) : null;
        User userA2 = ChannelUtils.a(dm.getChannel());
        Long lValueOf = userA2 != null ? Long.valueOf(userA2.getId()) : null;
        long id2 = dm.getChannel().getId();
        Collection<Map<Long, GuildMember>> guildMembers = dm.getGuildMembers();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = guildMembers.iterator();
        while (it.hasNext()) {
            Map map = (Map) it.next();
            User userA3 = ChannelUtils.a(dm.getChannel());
            GuildMember guildMember = (GuildMember) map.get(userA3 != null ? Long.valueOf(userA3.getId()) : null);
            String nick = guildMember != null ? guildMember.getNick() : null;
            if (nick != null) {
                arrayList.add(nick);
            }
        }
        Set set = _Collections.toSet(arrayList);
        Collection<Map<Long, GuildMember>> guildMembers2 = dm.getGuildMembers();
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it2 = guildMembers2.iterator();
        while (it2.hasNext()) {
            Map map2 = (Map) it2.next();
            User userA4 = ChannelUtils.a(dm.getChannel());
            GuildMember guildMember2 = (GuildMember) map2.get(userA4 != null ? Long.valueOf(userA4.getId()) : null);
            if (guildMember2 != null) {
                arrayList2.add(guildMember2);
            }
        }
        updateViewState(new ViewState.DM(nickOrUsername$default, lValueOf, set, _Collections.toList(arrayList2), id2, dm.getDeveloperModeEnabled(), storeState.getIsRightPanelOpened(), storeState.getIsOnHomeTab()));
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        Long lValueOf;
        if (storeState instanceof StoreState.Guild.Topic) {
            long id2 = ((StoreState.Guild.Topic) storeState).getChannel().getId();
            Long l = this.previousChannelId;
            this.revealedIndices = (l != null && id2 == l.longValue()) ? this.revealedIndices : Sets5.emptySet();
            lValueOf = Long.valueOf(id2);
        } else {
            lValueOf = storeState instanceof StoreState.Guild.DefaultTopic ? Long.valueOf(((StoreState.Guild.DefaultTopic) storeState).getChannel().getId()) : storeState instanceof StoreState.DM ? Long.valueOf(((StoreState.DM) storeState).getChannel().getId()) : storeState instanceof StoreState.GDM ? Long.valueOf(((StoreState.GDM) storeState).getChannel().getId()) : null;
        }
        this.previousChannelId = lValueOf;
        if (storeState.getIsRightPanelOpened() != this.wasRightPanelOpened || storeState.getIsOnHomeTab() != this.wasOnHomeTab) {
            if (storeState.getIsRightPanelOpened() && storeState.getIsOnHomeTab()) {
                this.eventSubject.k.onNext(Event.FocusFirstElement.INSTANCE);
            }
            this.wasRightPanelOpened = storeState.getIsRightPanelOpened();
            this.wasOnHomeTab = storeState.getIsOnHomeTab();
        }
        if (storeState instanceof StoreState.NoChannel) {
            updateViewState(new ViewState.NoChannel(storeState.getIsRightPanelOpened(), storeState.getIsOnHomeTab()));
        } else if (storeState instanceof StoreState.Guild) {
            handleGuildStoreState((StoreState.Guild) storeState);
        } else {
            handlePrivateStoreState(storeState);
        }
    }

    public final Unit handleClosePrivateChannel(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Long l = this.previousChannelId;
        if (l == null) {
            return null;
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().deleteChannel(l.longValue()), false, 1, null), this, null, 2, null), context, "javaClass", (Function1) null, new WidgetChannelTopicViewModel2(this, context), (Function1) null, (Function0) null, (Function0) null, 116, (Object) null);
        return Unit.a;
    }

    @MainThread
    public final void handleOnIndexClicked(SpoilerNode<?> spoilerNode) {
        Intrinsics3.checkNotNullParameter(spoilerNode, "spoilerNode");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Guild.Topic)) {
            viewState = null;
        }
        ViewState.Guild.Topic topic = (ViewState.Guild.Topic) viewState;
        if (topic != null) {
            List<Node<MessageRenderContext>> listGenerateAST = generateAST(topic.getRawTopicString());
            this.revealedIndices = _Sets.plus(this.revealedIndices, Integer.valueOf(spoilerNode.getId()));
            MessagePreprocessor messagePreprocessor = new MessagePreprocessor(-1L, this.revealedIndices, null, false, null, 28, null);
            messagePreprocessor.process(listGenerateAST);
            updateViewState(ViewState.Guild.Topic.copy$default(topic, null, null, null, null, false, listGenerateAST, messagePreprocessor.isLinkifyConflicting(), null, null, false, false, 1951, null));
        }
    }

    public final Observable<Event> listenForEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelTopicViewModel(Observable<StoreState> observable, Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> parser) {
        super(new ViewState.NoChannel(false, false));
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        Intrinsics3.checkNotNullParameter(parser, "topicParser");
        this.topicParser = parser;
        this.revealedIndices = Sets5.emptySet();
        this.previousChannelId = 0L;
        this.eventSubject = PublishSubject.k0();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), WidgetChannelTopicViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
    }
}
