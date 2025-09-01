package com.discord.widgets.guilds.invite;

import a0.a.a.b;
import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.BuildConfig;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.stageinstance.StageInstance;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelInvite;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.stores.StoreAnalytics;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreInviteSettings;
import com.discord.stores.StoreMessages;
import com.discord.stores.StoreStageInstances;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.error.Error;
import com.discord.utilities.guilds.GuildUtils;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.messagesend.MessageQueue4;
import com.discord.utilities.recycler.DiffKeyProvider;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.guilds.invite.GuildInvite;
import com.discord.widgets.guilds.invite.InviteSuggestion;
import com.discord.widgets.guilds.invite.InviteSuggestionItemV2;
import d0.Tuples;
import d0.g0.Strings4;
import d0.g0.StringsJVM;
import d0.t.CollectionsJVM;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.t.Sets5;
import d0.t._Collections;
import d0.t._Sets;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* compiled from: GuildInviteShareSheetViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 W2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003WXYBe\u0012\u000e\u0010\u0005\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004\u0012\n\u0010?\u001a\u00060\u0003j\u0002`>\u0012\b\b\u0002\u0010Q\u001a\u00020P\u0012\b\b\u0002\u0010;\u001a\u00020:\u0012\b\b\u0002\u0010D\u001a\u00020C\u0012\b\b\u0002\u00108\u001a\u000207\u0012\b\b\u0002\u00101\u001a\u000200\u0012\u000e\b\u0002\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00170S¢\u0006\u0004\bU\u0010VJ\u001b\u0010\u0007\u001a\u00020\u00062\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004H\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\u000b\u001a\u00020\u00062\n\u0010\n\u001a\u00060\u0003j\u0002`\tH\u0002¢\u0006\u0004\b\u000b\u0010\bJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ-\u0010\u0013\u001a\u00020\u00062\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u00110\u0010H\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0016\u001a\u00020\u00062\n\u0010\u0015\u001a\u00060\u0003j\u0002`\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\bJ\u0017\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017H\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001bH\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\u001f\u0010 JG\u0010$\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u00110\u00102\u0006\u0010\u0018\u001a\u00020!2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0002¢\u0006\u0004\b$\u0010%J\u0017\u0010'\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u0002H\u0015¢\u0006\u0004\b'\u0010(J\u0017\u0010+\u001a\u00020\u00062\u0006\u0010*\u001a\u00020)H\u0007¢\u0006\u0004\b+\u0010,J\u0015\u0010-\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b-\u0010\u000fJ\u0017\u0010.\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\"H\u0007¢\u0006\u0004\b.\u0010/R\u0016\u00101\u001a\u0002008\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u001c\u00104\u001a\b\u0012\u0004\u0012\u00020\f038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u001e\u0010\u0005\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u00106R\u0016\u00108\u001a\u0002078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010;\u001a\u00020:8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010=R\u001d\u0010?\u001a\u00060\u0003j\u0002`>8\u0006@\u0006¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\u0016\u0010D\u001a\u00020C8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010F\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010HR,\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u00110\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010IR\u0016\u0010K\u001a\u00020J8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u0018\u0010N\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010Q\u001a\u00020P8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010R¨\u0006Z"}, d2 = {"Lcom/discord/widgets/guilds/invite/GuildInviteShareSheetViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/guilds/invite/GuildInviteShareSheetViewModel$ViewState;", "", "Lcom/discord/primitives/ChannelId;", "channelId", "", "sendInviteToChannel", "(J)V", "Lcom/discord/primitives/UserId;", "userId", "sendInviteToUser", "", "searchQuery", "updateSearchQuery", "(Ljava/lang/String;)V", "", "", "sentInvites", "updateSentInvites", "(Ljava/util/Map;)V", "targetChannelId", "generateInviteForChannel", "Lcom/discord/widgets/guilds/invite/GuildInviteShareSheetViewModel$StoreState;", "storeState", "handleStoreState", "(Lcom/discord/widgets/guilds/invite/GuildInviteShareSheetViewModel$StoreState;)V", "Lcom/discord/models/domain/ModelInvite;", "invite", "handleInviteCreationSuccess", "(Lcom/discord/models/domain/ModelInvite;)V", "handleInviteCreationFailure", "()V", "Lcom/discord/widgets/guilds/invite/GuildInviteShareSheetViewModel$StoreState$Valid;", "Lcom/discord/widgets/guilds/invite/GuildInvite;", "generatedInvite", "createViewState", "(Ljava/lang/String;Ljava/util/Map;Lcom/discord/widgets/guilds/invite/GuildInviteShareSheetViewModel$StoreState$Valid;Lcom/discord/widgets/guilds/invite/GuildInvite;)Lcom/discord/widgets/guilds/invite/GuildInviteShareSheetViewModel$ViewState;", "viewState", "updateViewState", "(Lcom/discord/widgets/guilds/invite/GuildInviteShareSheetViewModel$ViewState;)V", "Lcom/discord/widgets/guilds/invite/InviteSuggestionItemV2;", "item", "sendInvite", "(Lcom/discord/widgets/guilds/invite/InviteSuggestionItemV2;)V", "onSearchTextChanged", "updateInvite", "(Lcom/discord/widgets/guilds/invite/GuildInvite;)V", "Lcom/discord/utilities/logging/Logger;", "logger", "Lcom/discord/utilities/logging/Logger;", "Lrx/subjects/BehaviorSubject;", "searchQuerySubject", "Lrx/subjects/BehaviorSubject;", "Ljava/lang/Long;", "Lcom/discord/widgets/guilds/invite/TargetChannelSelector;", "targetChannelSelector", "Lcom/discord/widgets/guilds/invite/TargetChannelSelector;", "Lcom/discord/stores/StoreAnalytics;", "storeAnalytics", "Lcom/discord/stores/StoreAnalytics;", "Lcom/discord/widgets/guilds/invite/GuildInvite;", "Lcom/discord/primitives/GuildId;", "guildId", "J", "getGuildId", "()J", "Lcom/discord/stores/StoreMessages;", "storeMessages", "Lcom/discord/stores/StoreMessages;", "currentStoreState", "Lcom/discord/widgets/guilds/invite/GuildInviteShareSheetViewModel$StoreState;", "Ljava/lang/String;", "Ljava/util/Map;", "", "hasTrackedSuggestionsViewed", "Z", "Lcom/discord/api/channel/Channel;", "targetChannel", "Lcom/discord/api/channel/Channel;", "Lcom/discord/stores/StoreInviteSettings;", "storeInviteSettings", "Lcom/discord/stores/StoreInviteSettings;", "Lrx/Observable;", "storeStateObservable", "<init>", "(Ljava/lang/Long;JLcom/discord/stores/StoreInviteSettings;Lcom/discord/stores/StoreAnalytics;Lcom/discord/stores/StoreMessages;Lcom/discord/widgets/guilds/invite/TargetChannelSelector;Lcom/discord/utilities/logging/Logger;Lrx/Observable;)V", "Companion", "StoreState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class GuildInviteShareSheetViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Long channelId;
    private StoreState currentStoreState;
    private final long guildId;
    private boolean hasTrackedSuggestionsViewed;
    private GuildInvite invite;
    private final Logger logger;
    private String searchQuery;
    private BehaviorSubject<String> searchQuerySubject;
    private Map<String, ? extends Set<Long>> sentInvites;
    private final StoreAnalytics storeAnalytics;
    private final StoreInviteSettings storeInviteSettings;
    private final StoreMessages storeMessages;
    private Channel targetChannel;
    private final TargetChannelSelector targetChannelSelector;

    /* compiled from: GuildInviteShareSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/guilds/invite/GuildInviteShareSheetViewModel$StoreState;", "storeState", "", "invoke", "(Lcom/discord/widgets/guilds/invite/GuildInviteShareSheetViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.invite.GuildInviteShareSheetViewModel$1, reason: invalid class name */
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
            GuildInviteShareSheetViewModel.access$handleStoreState(GuildInviteShareSheetViewModel.this, storeState);
        }
    }

    /* compiled from: GuildInviteShareSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "searchQuery", "", "invoke", "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.invite.GuildInviteShareSheetViewModel$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<String, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            GuildInviteShareSheetViewModel guildInviteShareSheetViewModel = GuildInviteShareSheetViewModel.this;
            Intrinsics3.checkNotNullExpressionValue(str, "searchQuery");
            GuildInviteShareSheetViewModel.access$updateSearchQuery(guildInviteShareSheetViewModel, str);
        }
    }

    /* compiled from: GuildInviteShareSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016JQ\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/guilds/invite/GuildInviteShareSheetViewModel$Companion;", "", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/widgets/guilds/invite/InviteSuggestionsManager;", "inviteSuggestionsManager", "Lcom/discord/stores/StoreInviteSettings;", "storeInviteSettings", "Lcom/discord/stores/StoreUser;", "storeUser", "Lcom/discord/stores/StoreChannels;", "storeChannels", "Lcom/discord/stores/StoreGuilds;", "storeGuilds", "Lcom/discord/stores/StoreStageInstances;", "storeStageInstances", "Lrx/Observable;", "Lcom/discord/widgets/guilds/invite/GuildInviteShareSheetViewModel$StoreState;", "observeStoreState", "(JLcom/discord/widgets/guilds/invite/InviteSuggestionsManager;Lcom/discord/stores/StoreInviteSettings;Lcom/discord/stores/StoreUser;Lcom/discord/stores/StoreChannels;Lcom/discord/stores/StoreGuilds;Lcom/discord/stores/StoreStageInstances;)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStoreState(Companion companion, long j, InviteSuggestionsManager inviteSuggestionsManager, StoreInviteSettings storeInviteSettings, StoreUser storeUser, StoreChannels storeChannels, StoreGuilds storeGuilds, StoreStageInstances storeStageInstances) {
            return companion.observeStoreState(j, inviteSuggestionsManager, storeInviteSettings, storeUser, storeChannels, storeGuilds, storeStageInstances);
        }

        private final Observable<StoreState> observeStoreState(long guildId, InviteSuggestionsManager inviteSuggestionsManager, StoreInviteSettings storeInviteSettings, StoreUser storeUser, StoreChannels storeChannels, StoreGuilds storeGuilds, StoreStageInstances storeStageInstances) {
            Observable<StoreState> observableE = Observable.e(storeInviteSettings.getInviteSettings(), storeInviteSettings.getInvitableChannels(guildId), StoreUser.observeMe$default(storeUser, false, 1, null), storeChannels.observeDMs(), storeGuilds.observeGuild(guildId), inviteSuggestionsManager.observeInviteSuggestions(), storeStageInstances.observeStageInstancesForGuild(guildId), GuildInviteShareSheetViewModel2.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableE, "Observable.combineLatest…      )\n        }\n      }");
            return observableE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: GuildInviteShareSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/guilds/invite/GuildInviteShareSheetViewModel$StoreState;", "", "<init>", "()V", "Invalid", "Valid", "Lcom/discord/widgets/guilds/invite/GuildInviteShareSheetViewModel$StoreState$Valid;", "Lcom/discord/widgets/guilds/invite/GuildInviteShareSheetViewModel$StoreState$Invalid;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class StoreState {

        /* compiled from: GuildInviteShareSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/guilds/invite/GuildInviteShareSheetViewModel$StoreState$Invalid;", "Lcom/discord/widgets/guilds/invite/GuildInviteShareSheetViewModel$StoreState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Invalid extends StoreState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* compiled from: GuildInviteShareSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001Bk\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0016\u0010\u0019\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u0005\u0012\u0006\u0010\u001a\u001a\u00020\u000b\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\u000e\u0012\u0006\u0010\u001c\u001a\u00020\u0011\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00140\u000e\u0012\u0016\u0010\u001e\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\u00160\u0005¢\u0006\u0004\b8\u00109J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u000eHÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0010J \u0010\u0017\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\u00160\u0005HÆ\u0003¢\u0006\u0004\b\u0017\u0010\nJ\u0082\u0001\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0018\u001a\u00020\u00022\u0018\b\u0002\u0010\u0019\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u000b2\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u00112\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00140\u000e2\u0018\b\u0002\u0010\u001e\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\u00160\u0005HÆ\u0001¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\"\u001a\u00020!HÖ\u0001¢\u0006\u0004\b\"\u0010#J\u0010\u0010%\u001a\u00020$HÖ\u0001¢\u0006\u0004\b%\u0010&J\u001a\u0010*\u001a\u00020)2\b\u0010(\u001a\u0004\u0018\u00010'HÖ\u0003¢\u0006\u0004\b*\u0010+R)\u0010\u001e\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\u00160\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010,\u001a\u0004\b-\u0010\nR)\u0010\u0019\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010,\u001a\u0004\b.\u0010\nR\u0019\u0010\u001a\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010/\u001a\u0004\b0\u0010\rR\u0019\u0010\u001c\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u00101\u001a\u0004\b2\u0010\u0013R\u001f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00140\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u00103\u001a\u0004\b4\u0010\u0010R\u001f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u00103\u001a\u0004\b5\u0010\u0010R\u0019\u0010\u0018\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u00106\u001a\u0004\b7\u0010\u0004¨\u0006:"}, d2 = {"Lcom/discord/widgets/guilds/invite/GuildInviteShareSheetViewModel$StoreState$Valid;", "Lcom/discord/widgets/guilds/invite/GuildInviteShareSheetViewModel$StoreState;", "Lcom/discord/models/domain/ModelInvite$Settings;", "component1", "()Lcom/discord/models/domain/ModelInvite$Settings;", "", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/channel/Channel;", "component2", "()Ljava/util/Map;", "Lcom/discord/models/user/MeUser;", "component3", "()Lcom/discord/models/user/MeUser;", "", "component4", "()Ljava/util/List;", "Lcom/discord/models/guild/Guild;", "component5", "()Lcom/discord/models/guild/Guild;", "Lcom/discord/widgets/guilds/invite/InviteSuggestion;", "component6", "Lcom/discord/api/stageinstance/StageInstance;", "component7", "inviteSettings", "invitableChannels", "me", "dms", "guild", "inviteSuggestions", "guildStageInstances", "copy", "(Lcom/discord/models/domain/ModelInvite$Settings;Ljava/util/Map;Lcom/discord/models/user/MeUser;Ljava/util/List;Lcom/discord/models/guild/Guild;Ljava/util/List;Ljava/util/Map;)Lcom/discord/widgets/guilds/invite/GuildInviteShareSheetViewModel$StoreState$Valid;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Map;", "getGuildStageInstances", "getInvitableChannels", "Lcom/discord/models/user/MeUser;", "getMe", "Lcom/discord/models/guild/Guild;", "getGuild", "Ljava/util/List;", "getInviteSuggestions", "getDms", "Lcom/discord/models/domain/ModelInvite$Settings;", "getInviteSettings", "<init>", "(Lcom/discord/models/domain/ModelInvite$Settings;Ljava/util/Map;Lcom/discord/models/user/MeUser;Ljava/util/List;Lcom/discord/models/guild/Guild;Ljava/util/List;Ljava/util/Map;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Valid extends StoreState {
            private final List<Channel> dms;
            private final Guild guild;
            private final Map<Long, StageInstance> guildStageInstances;
            private final Map<Long, Channel> invitableChannels;
            private final ModelInvite.Settings inviteSettings;
            private final List<InviteSuggestion> inviteSuggestions;
            private final MeUser me;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Valid(ModelInvite.Settings settings, Map<Long, Channel> map, MeUser meUser, List<Channel> list, Guild guild, List<? extends InviteSuggestion> list2, Map<Long, StageInstance> map2) {
                super(null);
                Intrinsics3.checkNotNullParameter(settings, "inviteSettings");
                Intrinsics3.checkNotNullParameter(map, "invitableChannels");
                Intrinsics3.checkNotNullParameter(meUser, "me");
                Intrinsics3.checkNotNullParameter(list, "dms");
                Intrinsics3.checkNotNullParameter(guild, "guild");
                Intrinsics3.checkNotNullParameter(list2, "inviteSuggestions");
                Intrinsics3.checkNotNullParameter(map2, "guildStageInstances");
                this.inviteSettings = settings;
                this.invitableChannels = map;
                this.me = meUser;
                this.dms = list;
                this.guild = guild;
                this.inviteSuggestions = list2;
                this.guildStageInstances = map2;
            }

            public static /* synthetic */ Valid copy$default(Valid valid, ModelInvite.Settings settings, Map map, MeUser meUser, List list, Guild guild, List list2, Map map2, int i, Object obj) {
                if ((i & 1) != 0) {
                    settings = valid.inviteSettings;
                }
                if ((i & 2) != 0) {
                    map = valid.invitableChannels;
                }
                Map map3 = map;
                if ((i & 4) != 0) {
                    meUser = valid.me;
                }
                MeUser meUser2 = meUser;
                if ((i & 8) != 0) {
                    list = valid.dms;
                }
                List list3 = list;
                if ((i & 16) != 0) {
                    guild = valid.guild;
                }
                Guild guild2 = guild;
                if ((i & 32) != 0) {
                    list2 = valid.inviteSuggestions;
                }
                List list4 = list2;
                if ((i & 64) != 0) {
                    map2 = valid.guildStageInstances;
                }
                return valid.copy(settings, map3, meUser2, list3, guild2, list4, map2);
            }

            /* renamed from: component1, reason: from getter */
            public final ModelInvite.Settings getInviteSettings() {
                return this.inviteSettings;
            }

            public final Map<Long, Channel> component2() {
                return this.invitableChannels;
            }

            /* renamed from: component3, reason: from getter */
            public final MeUser getMe() {
                return this.me;
            }

            public final List<Channel> component4() {
                return this.dms;
            }

            /* renamed from: component5, reason: from getter */
            public final Guild getGuild() {
                return this.guild;
            }

            public final List<InviteSuggestion> component6() {
                return this.inviteSuggestions;
            }

            public final Map<Long, StageInstance> component7() {
                return this.guildStageInstances;
            }

            public final Valid copy(ModelInvite.Settings inviteSettings, Map<Long, Channel> invitableChannels, MeUser me2, List<Channel> dms, Guild guild, List<? extends InviteSuggestion> inviteSuggestions, Map<Long, StageInstance> guildStageInstances) {
                Intrinsics3.checkNotNullParameter(inviteSettings, "inviteSettings");
                Intrinsics3.checkNotNullParameter(invitableChannels, "invitableChannels");
                Intrinsics3.checkNotNullParameter(me2, "me");
                Intrinsics3.checkNotNullParameter(dms, "dms");
                Intrinsics3.checkNotNullParameter(guild, "guild");
                Intrinsics3.checkNotNullParameter(inviteSuggestions, "inviteSuggestions");
                Intrinsics3.checkNotNullParameter(guildStageInstances, "guildStageInstances");
                return new Valid(inviteSettings, invitableChannels, me2, dms, guild, inviteSuggestions, guildStageInstances);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Valid)) {
                    return false;
                }
                Valid valid = (Valid) other;
                return Intrinsics3.areEqual(this.inviteSettings, valid.inviteSettings) && Intrinsics3.areEqual(this.invitableChannels, valid.invitableChannels) && Intrinsics3.areEqual(this.me, valid.me) && Intrinsics3.areEqual(this.dms, valid.dms) && Intrinsics3.areEqual(this.guild, valid.guild) && Intrinsics3.areEqual(this.inviteSuggestions, valid.inviteSuggestions) && Intrinsics3.areEqual(this.guildStageInstances, valid.guildStageInstances);
            }

            public final List<Channel> getDms() {
                return this.dms;
            }

            public final Guild getGuild() {
                return this.guild;
            }

            public final Map<Long, StageInstance> getGuildStageInstances() {
                return this.guildStageInstances;
            }

            public final Map<Long, Channel> getInvitableChannels() {
                return this.invitableChannels;
            }

            public final ModelInvite.Settings getInviteSettings() {
                return this.inviteSettings;
            }

            public final List<InviteSuggestion> getInviteSuggestions() {
                return this.inviteSuggestions;
            }

            public final MeUser getMe() {
                return this.me;
            }

            public int hashCode() {
                ModelInvite.Settings settings = this.inviteSettings;
                int iHashCode = (settings != null ? settings.hashCode() : 0) * 31;
                Map<Long, Channel> map = this.invitableChannels;
                int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
                MeUser meUser = this.me;
                int iHashCode3 = (iHashCode2 + (meUser != null ? meUser.hashCode() : 0)) * 31;
                List<Channel> list = this.dms;
                int iHashCode4 = (iHashCode3 + (list != null ? list.hashCode() : 0)) * 31;
                Guild guild = this.guild;
                int iHashCode5 = (iHashCode4 + (guild != null ? guild.hashCode() : 0)) * 31;
                List<InviteSuggestion> list2 = this.inviteSuggestions;
                int iHashCode6 = (iHashCode5 + (list2 != null ? list2.hashCode() : 0)) * 31;
                Map<Long, StageInstance> map2 = this.guildStageInstances;
                return iHashCode6 + (map2 != null ? map2.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Valid(inviteSettings=");
                sbU.append(this.inviteSettings);
                sbU.append(", invitableChannels=");
                sbU.append(this.invitableChannels);
                sbU.append(", me=");
                sbU.append(this.me);
                sbU.append(", dms=");
                sbU.append(this.dms);
                sbU.append(", guild=");
                sbU.append(this.guild);
                sbU.append(", inviteSuggestions=");
                sbU.append(this.inviteSuggestions);
                sbU.append(", guildStageInstances=");
                return outline.M(sbU, this.guildStageInstances, ")");
            }
        }

        private StoreState() {
        }

        public /* synthetic */ StoreState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: GuildInviteShareSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/domain/ModelInvite;", "invite", "", "invoke", "(Lcom/discord/models/domain/ModelInvite;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.invite.GuildInviteShareSheetViewModel$generateInviteForChannel$1, reason: invalid class name */
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
            GuildInviteShareSheetViewModel.access$handleInviteCreationSuccess(GuildInviteShareSheetViewModel.this, modelInvite);
        }
    }

    /* compiled from: GuildInviteShareSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.invite.GuildInviteShareSheetViewModel$generateInviteForChannel$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            GuildInviteShareSheetViewModel.access$handleInviteCreationFailure(GuildInviteShareSheetViewModel.this);
        }
    }

    /* compiled from: GuildInviteShareSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/messagesend/MessageResult;", "result", "", "invoke", "(Lcom/discord/utilities/messagesend/MessageResult;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.invite.GuildInviteShareSheetViewModel$sendInviteToChannel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<MessageQueue4, Unit> {
        public final /* synthetic */ GuildInvite $invite;
        public final /* synthetic */ String $inviteLink;
        public final /* synthetic */ ViewState $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(GuildInvite guildInvite, ViewState viewState, String str) {
            super(1);
            this.$invite = guildInvite;
            this.$viewState = viewState;
            this.$inviteLink = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MessageQueue4 messageQueue4) {
            invoke2(messageQueue4);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MessageQueue4 messageQueue4) {
            Intrinsics3.checkNotNullParameter(messageQueue4, "result");
            if (messageQueue4 instanceof MessageQueue4.Success) {
                MessageQueue4.Success success = (MessageQueue4.Success) messageQueue4;
                GuildInviteShareSheetViewModel.access$getStoreAnalytics$p(GuildInviteShareSheetViewModel.this).inviteSent(this.$invite, this.$viewState.getChannel(), success.getMessage(), "Guild Create Invite Suggestion");
                Map<String, Set<Long>> sentInvites = this.$viewState.getSentInvites();
                Set<Long> setEmptySet = sentInvites.get(this.$inviteLink);
                if (setEmptySet == null) {
                    setEmptySet = Sets5.emptySet();
                }
                GuildInviteShareSheetViewModel.access$updateSentInvites(GuildInviteShareSheetViewModel.this, Maps6.plus(sentInvites, MapsJVM.mapOf(Tuples.to(this.$inviteLink, _Sets.plus(setEmptySet, Long.valueOf(success.getMessage().getChannelId()))))));
            }
        }
    }

    /* compiled from: GuildInviteShareSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/channel/Channel;", "channel", "", "invoke", "(Lcom/discord/api/channel/Channel;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.invite.GuildInviteShareSheetViewModel$sendInviteToUser$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Channel, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            GuildInviteShareSheetViewModel.access$sendInviteToChannel(GuildInviteShareSheetViewModel.this, channel.getId());
        }
    }

    public /* synthetic */ GuildInviteShareSheetViewModel(Long l, long j, StoreInviteSettings storeInviteSettings, StoreAnalytics storeAnalytics, StoreMessages storeMessages, TargetChannelSelector targetChannelSelector, Logger logger, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Observable observableAccess$observeStoreState;
        StoreInviteSettings inviteSettings = (i & 4) != 0 ? StoreStream.INSTANCE.getInviteSettings() : storeInviteSettings;
        StoreAnalytics analytics = (i & 8) != 0 ? StoreStream.INSTANCE.getAnalytics() : storeAnalytics;
        StoreMessages messages = (i & 16) != 0 ? StoreStream.INSTANCE.getMessages() : storeMessages;
        TargetChannelSelector targetChannelSelector2 = (i & 32) != 0 ? new TargetChannelSelector() : targetChannelSelector;
        Logger logger2 = (i & 64) != 0 ? AppLog.g : logger;
        if ((i & 128) != 0) {
            Companion companion = INSTANCE;
            InviteSuggestionsManager inviteSuggestionsManager = new InviteSuggestionsManager(null, null, null, null, null, 31, null);
            StoreStream.Companion companion2 = StoreStream.INSTANCE;
            observableAccess$observeStoreState = Companion.access$observeStoreState(companion, j, inviteSuggestionsManager, companion2.getInviteSettings(), companion2.getUsers(), companion2.getChannels(), companion2.getGuilds(), companion2.getStageInstances());
        } else {
            observableAccess$observeStoreState = observable;
        }
        this(l, j, inviteSettings, analytics, messages, targetChannelSelector2, logger2, observableAccess$observeStoreState);
    }

    public static final /* synthetic */ StoreAnalytics access$getStoreAnalytics$p(GuildInviteShareSheetViewModel guildInviteShareSheetViewModel) {
        return guildInviteShareSheetViewModel.storeAnalytics;
    }

    public static final /* synthetic */ void access$handleInviteCreationFailure(GuildInviteShareSheetViewModel guildInviteShareSheetViewModel) {
        guildInviteShareSheetViewModel.handleInviteCreationFailure();
    }

    public static final /* synthetic */ void access$handleInviteCreationSuccess(GuildInviteShareSheetViewModel guildInviteShareSheetViewModel, ModelInvite modelInvite) {
        guildInviteShareSheetViewModel.handleInviteCreationSuccess(modelInvite);
    }

    public static final /* synthetic */ void access$handleStoreState(GuildInviteShareSheetViewModel guildInviteShareSheetViewModel, StoreState storeState) {
        guildInviteShareSheetViewModel.handleStoreState(storeState);
    }

    public static final /* synthetic */ void access$sendInviteToChannel(GuildInviteShareSheetViewModel guildInviteShareSheetViewModel, long j) {
        guildInviteShareSheetViewModel.sendInviteToChannel(j);
    }

    public static final /* synthetic */ void access$updateSearchQuery(GuildInviteShareSheetViewModel guildInviteShareSheetViewModel, String str) {
        guildInviteShareSheetViewModel.updateSearchQuery(str);
    }

    public static final /* synthetic */ void access$updateSentInvites(GuildInviteShareSheetViewModel guildInviteShareSheetViewModel, Map map) {
        guildInviteShareSheetViewModel.updateSentInvites(map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17, types: [java.util.List] */
    private final ViewState createViewState(String searchQuery, Map<String, ? extends Set<Long>> sentInvites, StoreState.Valid storeState, GuildInvite generatedInvite) {
        String link;
        ArrayList arrayList;
        DiffKeyProvider userItem;
        boolean zContains;
        Collections.sort(new ArrayList(storeState.getInvitableChannels().values()), ChannelUtils.h(Channel.INSTANCE));
        if (generatedInvite == null || (link = generatedInvite.toLink()) == null) {
            link = BuildConfig.HOST_INVITE;
        }
        Set<Long> setEmptySet = sentInvites.get(link);
        if (setEmptySet == null) {
            setEmptySet = Sets5.emptySet();
        }
        Set<Long> set = setEmptySet;
        List<InviteSuggestion> inviteSuggestions = storeState.getInviteSuggestions();
        if (!StringsJVM.isBlank(searchQuery)) {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : inviteSuggestions) {
                InviteSuggestion inviteSuggestion = (InviteSuggestion) obj;
                if (inviteSuggestion instanceof InviteSuggestion.ChannelItem) {
                    zContains = Strings4.contains((CharSequence) ChannelUtils.c(((InviteSuggestion.ChannelItem) inviteSuggestion).getChannel()), (CharSequence) searchQuery, true);
                } else {
                    if (!(inviteSuggestion instanceof InviteSuggestion.UserSuggestion)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    zContains = Strings4.contains((CharSequence) ((InviteSuggestion.UserSuggestion) inviteSuggestion).getUser().getUsername(), (CharSequence) searchQuery, true);
                }
                if (zContains) {
                    arrayList2.add(obj);
                }
            }
            inviteSuggestions = arrayList2;
        }
        List<Channel> dms = storeState.getDms();
        ArrayList arrayList3 = new ArrayList(Iterables2.collectionSizeOrDefault(dms, 10));
        Iterator it = dms.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Channel channel = (Channel) it.next();
            User userA = ChannelUtils.a(channel);
            if (userA != null) {
                lValueOf = Long.valueOf(userA.getId());
            }
            arrayList3.add(Tuples.to(lValueOf, Long.valueOf(channel.getId())));
        }
        Map map = Maps6.toMap(arrayList3);
        if ((!inviteSuggestions.isEmpty()) || StringsJVM.isBlank(searchQuery)) {
            arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(inviteSuggestions, 10));
            for (InviteSuggestion inviteSuggestion2 : inviteSuggestions) {
                if (inviteSuggestion2 instanceof InviteSuggestion.ChannelItem) {
                    InviteSuggestion.ChannelItem channelItem = (InviteSuggestion.ChannelItem) inviteSuggestion2;
                    userItem = new InviteSuggestionItemV2.ChannelItem(channelItem.getChannel(), set.contains(Long.valueOf(channelItem.getChannel().getId())), searchQuery);
                } else {
                    if (!(inviteSuggestion2 instanceof InviteSuggestion.UserSuggestion)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    InviteSuggestion.UserSuggestion userSuggestion = (InviteSuggestion.UserSuggestion) inviteSuggestion2;
                    userItem = new InviteSuggestionItemV2.UserItem(userSuggestion.getUser(), _Collections.contains(set, map.get(Long.valueOf(userSuggestion.getUser().getId()))), searchQuery);
                }
                arrayList.add(userItem);
            }
        } else {
            arrayList = CollectionsJVM.listOf(InviteSuggestionItemV2.SearchNoResultsItem.INSTANCE);
        }
        return new ViewState(generatedInvite, storeState.getInviteSettings(), arrayList, storeState.getInvitableChannels().get(generatedInvite != null ? generatedInvite.getChannelId() : null), searchQuery, sentInvites, generatedInvite != null ? !generatedInvite.isStaticInvite() : true, storeState.getGuild().getId());
    }

    private final void generateInviteForChannel(long targetChannelId) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(StoreInviteSettings.generateInvite$default(this.storeInviteSettings, targetChannelId, null, 2, null), false, 1, null), this, null, 2, null), GuildInviteShareSheetViewModel.class, (Context) null, (Function1) null, new AnonymousClass2(), (Function0) null, (Function0) null, new AnonymousClass1(), 54, (Object) null);
    }

    @MainThread
    private final void handleInviteCreationFailure() {
        Guild guild;
        String vanityUrlCode;
        StoreState storeState = this.currentStoreState;
        if (!(storeState instanceof StoreState.Valid)) {
            storeState = null;
        }
        StoreState.Valid valid = (StoreState.Valid) storeState;
        if (valid == null || (vanityUrlCode = (guild = valid.getGuild()).getVanityUrlCode()) == null) {
            return;
        }
        ModelInvite modelInviteCreateForStaticUrl = ModelInvite.createForStaticUrl(vanityUrlCode, GuildUtils.createApiGuild(guild));
        GuildInvite.Companion companion = GuildInvite.INSTANCE;
        Intrinsics3.checkNotNullExpressionValue(modelInviteCreateForStaticUrl, "vanityUrlInvite");
        GuildInvite guildInviteCreateFromModelInvite = companion.createFromModelInvite(modelInviteCreateForStaticUrl);
        this.invite = guildInviteCreateFromModelInvite;
        updateViewState2(createViewState(this.searchQuery, this.sentInvites, valid, guildInviteCreateFromModelInvite));
    }

    @MainThread
    private final void handleInviteCreationSuccess(ModelInvite invite) {
        GuildInvite guildInviteCreateFromModelInvite = GuildInvite.INSTANCE.createFromModelInvite(invite);
        this.invite = guildInviteCreateFromModelInvite;
        StoreState storeState = this.currentStoreState;
        if (!(storeState instanceof StoreState.Valid)) {
            storeState = null;
        }
        StoreState.Valid valid = (StoreState.Valid) storeState;
        if (valid != null) {
            updateViewState2(createViewState(this.searchQuery, this.sentInvites, valid, guildInviteCreateFromModelInvite));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x008f  */
    @MainThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void handleStoreState(StoreState storeState) {
        StoreState storeState2 = this.currentStoreState;
        if (Intrinsics3.areEqual(storeState, StoreState.Invalid.INSTANCE)) {
            Logger logger = this.logger;
            StringBuilder sbU = outline.U("invalid StoreState in ");
            sbU.append(GuildInviteShareSheetViewModel.class.getSimpleName());
            Logger.e$default(logger, sbU.toString(), null, null, 6, null);
            return;
        }
        if (storeState instanceof StoreState.Valid) {
            Channel channel = this.targetChannel;
            StoreState.Valid valid = (StoreState.Valid) storeState;
            Channel targetChannel = this.targetChannelSelector.getTargetChannel(valid.getInvitableChannels(), this.channelId);
            Guild guild = valid.getGuild();
            String vanityUrlCode = valid.getGuild().getVanityUrlCode();
            StageInstance stageInstance = valid.getGuildStageInstances().get(this.channelId);
            String inviteCode = stageInstance != null ? stageInstance.getInviteCode() : null;
            if (this.invite == null) {
                boolean z2 = true;
                boolean z3 = this.channelId == null;
                if (storeState2 == null) {
                    if (vanityUrlCode != null && vanityUrlCode.length() != 0) {
                        z2 = false;
                    }
                    if (!z2 && z3) {
                        ModelInvite modelInviteCreateForStaticUrl = ModelInvite.createForStaticUrl(vanityUrlCode, GuildUtils.createApiGuild(guild));
                        GuildInvite.Companion companion = GuildInvite.INSTANCE;
                        Intrinsics3.checkNotNullExpressionValue(modelInviteCreateForStaticUrl, "vanityUrlInvite");
                        this.invite = companion.createFromModelInvite(modelInviteCreateForStaticUrl);
                    }
                } else if (channel == null && targetChannel != null) {
                    generateInviteForChannel(targetChannel.getId());
                } else if (inviteCode != null) {
                    ModelInvite modelInviteCreateForStaticUrl2 = ModelInvite.createForStaticUrl(inviteCode, GuildUtils.createApiGuild(guild));
                    GuildInvite.Companion companion2 = GuildInvite.INSTANCE;
                    Intrinsics3.checkNotNullExpressionValue(modelInviteCreateForStaticUrl2, "stageInstanceInvite");
                    this.invite = companion2.createFromModelInvite(modelInviteCreateForStaticUrl2);
                }
            }
            this.targetChannel = targetChannel;
            updateViewState2(createViewState(this.searchQuery, this.sentInvites, valid, this.invite));
        }
        this.currentStoreState = storeState;
    }

    @MainThread
    private final void sendInviteToChannel(long channelId) {
        ViewState viewState;
        GuildInvite guildInvite;
        StoreState storeState = this.currentStoreState;
        if (!(storeState instanceof StoreState.Valid)) {
            storeState = null;
        }
        StoreState.Valid valid = (StoreState.Valid) storeState;
        if (valid == null || (viewState = getViewState()) == null || (guildInvite = this.invite) == null) {
            return;
        }
        String link = guildInvite.toLink();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(StoreMessages.sendMessage$default(this.storeMessages, channelId, valid.getMe(), link, null, null, null, null, null, null, null, null, null, null, null, null, 32736, null), this, null, 2, null), GuildInviteShareSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(guildInvite, viewState, link), 62, (Object) null);
    }

    private final void sendInviteToUser(long userId) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().createOrFetchDM(userId), false, 1, null), this, null, 2, null), GuildInviteShareSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }

    @MainThread
    private final void updateSearchQuery(String searchQuery) {
        StoreState storeState = this.currentStoreState;
        if (!(storeState instanceof StoreState.Valid)) {
            storeState = null;
        }
        StoreState.Valid valid = (StoreState.Valid) storeState;
        if (valid == null || Intrinsics3.areEqual(searchQuery, this.searchQuery)) {
            return;
        }
        this.searchQuery = searchQuery;
        updateViewState2(createViewState(searchQuery, this.sentInvites, valid, this.invite));
    }

    @MainThread
    private final void updateSentInvites(Map<String, ? extends Set<Long>> sentInvites) {
        this.sentInvites = sentInvites;
        StoreState storeState = this.currentStoreState;
        if (!(storeState instanceof StoreState.Valid)) {
            storeState = null;
        }
        StoreState.Valid valid = (StoreState.Valid) storeState;
        if (valid != null) {
            updateViewState2(createViewState(this.searchQuery, sentInvites, valid, this.invite));
        }
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final void onSearchTextChanged(String searchQuery) {
        Intrinsics3.checkNotNullParameter(searchQuery, "searchQuery");
        this.searchQuerySubject.onNext(searchQuery);
    }

    @MainThread
    public final void sendInvite(InviteSuggestionItemV2 item) {
        Intrinsics3.checkNotNullParameter(item, "item");
        if (item instanceof InviteSuggestionItemV2.ChannelItem) {
            sendInviteToChannel(((InviteSuggestionItemV2.ChannelItem) item).getChannel().getId());
        } else if (item instanceof InviteSuggestionItemV2.UserItem) {
            sendInviteToUser(((InviteSuggestionItemV2.UserItem) item).getUser().getId());
        }
    }

    @MainThread
    public final void updateInvite(GuildInvite invite) {
        Intrinsics3.checkNotNullParameter(invite, "invite");
        this.invite = invite;
        ViewState viewState = getViewState();
        if (viewState != null) {
            StoreState storeState = this.currentStoreState;
            if (!(storeState instanceof StoreState.Valid)) {
                storeState = null;
            }
            StoreState.Valid valid = (StoreState.Valid) storeState;
            if (valid != null) {
                updateViewState2(ViewState.copy$default(viewState, invite, null, null, valid.getInvitableChannels().get(invite.getChannelId()), null, null, false, 0L, 246, null));
            }
        }
    }

    @Override // b.a.d.AppViewModel
    public /* bridge */ /* synthetic */ void updateViewState(ViewState viewState) {
        updateViewState2(viewState);
    }

    @MainThread
    /* renamed from: updateViewState, reason: avoid collision after fix types in other method */
    public void updateViewState2(ViewState viewState) {
        Intrinsics3.checkNotNullParameter(viewState, "viewState");
        super.updateViewState((GuildInviteShareSheetViewModel) viewState);
        if (!viewState.getHasSearchResults() || this.hasTrackedSuggestionsViewed) {
            return;
        }
        long guildId = viewState.getGuildId();
        List<InviteSuggestionItemV2> inviteSuggestionItems = viewState.getInviteSuggestionItems();
        StoreAnalytics storeAnalytics = this.storeAnalytics;
        ArrayList arrayList = new ArrayList();
        for (Object obj : inviteSuggestionItems) {
            if (obj instanceof InviteSuggestionItemV2.ChannelItem) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((InviteSuggestionItemV2.ChannelItem) it.next()).getChannel());
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : inviteSuggestionItems) {
            if (obj2 instanceof InviteSuggestionItemV2.UserItem) {
                arrayList3.add(obj2);
            }
        }
        ArrayList arrayList4 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList3, 10));
        Iterator it2 = arrayList3.iterator();
        while (it2.hasNext()) {
            arrayList4.add(((InviteSuggestionItemV2.UserItem) it2.next()).getUser());
        }
        storeAnalytics.inviteSuggestionOpened(guildId, arrayList2, arrayList4);
        this.hasTrackedSuggestionsViewed = true;
    }

    /* compiled from: GuildInviteShareSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001Bo\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\b\u0010!\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\"\u001a\u00020\u000f\u0012\u001c\u0010#\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0014j\u0002`\u00150\u00130\u0012\u0012\u0006\u0010$\u001a\u00020\u0018\u0012\n\u0010%\u001a\u00060\u0014j\u0002`\u001b¢\u0006\u0004\bC\u0010DJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J&\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0014j\u0002`\u00150\u00130\u0012HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0014\u0010\u001c\u001a\u00060\u0014j\u0002`\u001bHÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0086\u0001\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020\t0\b2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\"\u001a\u00020\u000f2\u001e\b\u0002\u0010#\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0014j\u0002`\u00150\u00130\u00122\b\b\u0002\u0010$\u001a\u00020\u00182\f\b\u0002\u0010%\u001a\u00060\u0014j\u0002`\u001bHÆ\u0001¢\u0006\u0004\b&\u0010'J\u0010\u0010(\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b(\u0010\u0011J\u0010\u0010*\u001a\u00020)HÖ\u0001¢\u0006\u0004\b*\u0010+J\u001a\u0010-\u001a\u00020\u00182\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b-\u0010.R\u0019\u0010/\u001a\u00020\u00188\u0006@\u0006¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u0010\u001aR\u0019\u0010\"\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u00102\u001a\u0004\b3\u0010\u0011R\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u00104\u001a\u0004\b5\u0010\u0004R\u001f\u0010 \u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0006¢\u0006\f\n\u0004\b \u00106\u001a\u0004\b7\u0010\u000bR\u001d\u0010%\u001a\u00060\u0014j\u0002`\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b%\u00108\u001a\u0004\b9\u0010\u001dR\u0019\u0010$\u001a\u00020\u00188\u0006@\u0006¢\u0006\f\n\u0004\b$\u00100\u001a\u0004\b:\u0010\u001aR/\u0010#\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0014j\u0002`\u00150\u00130\u00128\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010;\u001a\u0004\b<\u0010\u0017R\u0019\u0010=\u001a\u00020\u00188\u0006@\u0006¢\u0006\f\n\u0004\b=\u00100\u001a\u0004\b>\u0010\u001aR\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010?\u001a\u0004\b@\u0010\u0007R\u001b\u0010!\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010A\u001a\u0004\bB\u0010\u000e¨\u0006E"}, d2 = {"Lcom/discord/widgets/guilds/invite/GuildInviteShareSheetViewModel$ViewState;", "", "Lcom/discord/widgets/guilds/invite/GuildInvite;", "component1", "()Lcom/discord/widgets/guilds/invite/GuildInvite;", "Lcom/discord/models/domain/ModelInvite$Settings;", "component2", "()Lcom/discord/models/domain/ModelInvite$Settings;", "", "Lcom/discord/widgets/guilds/invite/InviteSuggestionItemV2;", "component3", "()Ljava/util/List;", "Lcom/discord/api/channel/Channel;", "component4", "()Lcom/discord/api/channel/Channel;", "", "component5", "()Ljava/lang/String;", "", "", "", "Lcom/discord/primitives/ChannelId;", "component6", "()Ljava/util/Map;", "", "component7", "()Z", "Lcom/discord/primitives/GuildId;", "component8", "()J", "invite", "inviteSettings", "inviteSuggestionItems", "channel", "searchQuery", "sentInvites", "showInviteSettings", "guildId", "copy", "(Lcom/discord/widgets/guilds/invite/GuildInvite;Lcom/discord/models/domain/ModelInvite$Settings;Ljava/util/List;Lcom/discord/api/channel/Channel;Ljava/lang/String;Ljava/util/Map;ZJ)Lcom/discord/widgets/guilds/invite/GuildInviteShareSheetViewModel$ViewState;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "hasResults", "Z", "getHasResults", "Ljava/lang/String;", "getSearchQuery", "Lcom/discord/widgets/guilds/invite/GuildInvite;", "getInvite", "Ljava/util/List;", "getInviteSuggestionItems", "J", "getGuildId", "getShowInviteSettings", "Ljava/util/Map;", "getSentInvites", "hasSearchResults", "getHasSearchResults", "Lcom/discord/models/domain/ModelInvite$Settings;", "getInviteSettings", "Lcom/discord/api/channel/Channel;", "getChannel", "<init>", "(Lcom/discord/widgets/guilds/invite/GuildInvite;Lcom/discord/models/domain/ModelInvite$Settings;Ljava/util/List;Lcom/discord/api/channel/Channel;Ljava/lang/String;Ljava/util/Map;ZJ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ViewState {
        private final Channel channel;
        private final long guildId;
        private final boolean hasResults;
        private final boolean hasSearchResults;
        private final GuildInvite invite;
        private final ModelInvite.Settings inviteSettings;
        private final List<InviteSuggestionItemV2> inviteSuggestionItems;
        private final String searchQuery;
        private final Map<String, Set<Long>> sentInvites;
        private final boolean showInviteSettings;

        /* JADX WARN: Multi-variable type inference failed */
        public ViewState(GuildInvite guildInvite, ModelInvite.Settings settings, List<? extends InviteSuggestionItemV2> list, Channel channel, String str, Map<String, ? extends Set<Long>> map, boolean z2, long j) {
            Intrinsics3.checkNotNullParameter(list, "inviteSuggestionItems");
            Intrinsics3.checkNotNullParameter(str, "searchQuery");
            Intrinsics3.checkNotNullParameter(map, "sentInvites");
            this.invite = guildInvite;
            this.inviteSettings = settings;
            this.inviteSuggestionItems = list;
            this.channel = channel;
            this.searchQuery = str;
            this.sentInvites = map;
            this.showInviteSettings = z2;
            this.guildId = j;
            this.hasResults = !list.isEmpty();
            this.hasSearchResults = list.size() > 1 && !(list.get(0) instanceof InviteSuggestionItemV2.SearchNoResultsItem);
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, GuildInvite guildInvite, ModelInvite.Settings settings, List list, Channel channel, String str, Map map, boolean z2, long j, int i, Object obj) {
            return viewState.copy((i & 1) != 0 ? viewState.invite : guildInvite, (i & 2) != 0 ? viewState.inviteSettings : settings, (i & 4) != 0 ? viewState.inviteSuggestionItems : list, (i & 8) != 0 ? viewState.channel : channel, (i & 16) != 0 ? viewState.searchQuery : str, (i & 32) != 0 ? viewState.sentInvites : map, (i & 64) != 0 ? viewState.showInviteSettings : z2, (i & 128) != 0 ? viewState.guildId : j);
        }

        /* renamed from: component1, reason: from getter */
        public final GuildInvite getInvite() {
            return this.invite;
        }

        /* renamed from: component2, reason: from getter */
        public final ModelInvite.Settings getInviteSettings() {
            return this.inviteSettings;
        }

        public final List<InviteSuggestionItemV2> component3() {
            return this.inviteSuggestionItems;
        }

        /* renamed from: component4, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* renamed from: component5, reason: from getter */
        public final String getSearchQuery() {
            return this.searchQuery;
        }

        public final Map<String, Set<Long>> component6() {
            return this.sentInvites;
        }

        /* renamed from: component7, reason: from getter */
        public final boolean getShowInviteSettings() {
            return this.showInviteSettings;
        }

        /* renamed from: component8, reason: from getter */
        public final long getGuildId() {
            return this.guildId;
        }

        public final ViewState copy(GuildInvite invite, ModelInvite.Settings inviteSettings, List<? extends InviteSuggestionItemV2> inviteSuggestionItems, Channel channel, String searchQuery, Map<String, ? extends Set<Long>> sentInvites, boolean showInviteSettings, long guildId) {
            Intrinsics3.checkNotNullParameter(inviteSuggestionItems, "inviteSuggestionItems");
            Intrinsics3.checkNotNullParameter(searchQuery, "searchQuery");
            Intrinsics3.checkNotNullParameter(sentInvites, "sentInvites");
            return new ViewState(invite, inviteSettings, inviteSuggestionItems, channel, searchQuery, sentInvites, showInviteSettings, guildId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return Intrinsics3.areEqual(this.invite, viewState.invite) && Intrinsics3.areEqual(this.inviteSettings, viewState.inviteSettings) && Intrinsics3.areEqual(this.inviteSuggestionItems, viewState.inviteSuggestionItems) && Intrinsics3.areEqual(this.channel, viewState.channel) && Intrinsics3.areEqual(this.searchQuery, viewState.searchQuery) && Intrinsics3.areEqual(this.sentInvites, viewState.sentInvites) && this.showInviteSettings == viewState.showInviteSettings && this.guildId == viewState.guildId;
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final long getGuildId() {
            return this.guildId;
        }

        public final boolean getHasResults() {
            return this.hasResults;
        }

        public final boolean getHasSearchResults() {
            return this.hasSearchResults;
        }

        public final GuildInvite getInvite() {
            return this.invite;
        }

        public final ModelInvite.Settings getInviteSettings() {
            return this.inviteSettings;
        }

        public final List<InviteSuggestionItemV2> getInviteSuggestionItems() {
            return this.inviteSuggestionItems;
        }

        public final String getSearchQuery() {
            return this.searchQuery;
        }

        public final Map<String, Set<Long>> getSentInvites() {
            return this.sentInvites;
        }

        public final boolean getShowInviteSettings() {
            return this.showInviteSettings;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            GuildInvite guildInvite = this.invite;
            int iHashCode = (guildInvite != null ? guildInvite.hashCode() : 0) * 31;
            ModelInvite.Settings settings = this.inviteSettings;
            int iHashCode2 = (iHashCode + (settings != null ? settings.hashCode() : 0)) * 31;
            List<InviteSuggestionItemV2> list = this.inviteSuggestionItems;
            int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
            Channel channel = this.channel;
            int iHashCode4 = (iHashCode3 + (channel != null ? channel.hashCode() : 0)) * 31;
            String str = this.searchQuery;
            int iHashCode5 = (iHashCode4 + (str != null ? str.hashCode() : 0)) * 31;
            Map<String, Set<Long>> map = this.sentInvites;
            int iHashCode6 = (iHashCode5 + (map != null ? map.hashCode() : 0)) * 31;
            boolean z2 = this.showInviteSettings;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return b.a(this.guildId) + ((iHashCode6 + i) * 31);
        }

        public String toString() {
            StringBuilder sbU = outline.U("ViewState(invite=");
            sbU.append(this.invite);
            sbU.append(", inviteSettings=");
            sbU.append(this.inviteSettings);
            sbU.append(", inviteSuggestionItems=");
            sbU.append(this.inviteSuggestionItems);
            sbU.append(", channel=");
            sbU.append(this.channel);
            sbU.append(", searchQuery=");
            sbU.append(this.searchQuery);
            sbU.append(", sentInvites=");
            sbU.append(this.sentInvites);
            sbU.append(", showInviteSettings=");
            sbU.append(this.showInviteSettings);
            sbU.append(", guildId=");
            return outline.C(sbU, this.guildId, ")");
        }

        public /* synthetic */ ViewState(GuildInvite guildInvite, ModelInvite.Settings settings, List list, Channel channel, String str, Map map, boolean z2, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(guildInvite, settings, list, channel, (i & 16) != 0 ? "" : str, map, z2, j);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildInviteShareSheetViewModel(Long l, long j, StoreInviteSettings storeInviteSettings, StoreAnalytics storeAnalytics, StoreMessages storeMessages, TargetChannelSelector targetChannelSelector, Logger logger, Observable<StoreState> observable) {
        super(null, 1, null);
        Intrinsics3.checkNotNullParameter(storeInviteSettings, "storeInviteSettings");
        Intrinsics3.checkNotNullParameter(storeAnalytics, "storeAnalytics");
        Intrinsics3.checkNotNullParameter(storeMessages, "storeMessages");
        Intrinsics3.checkNotNullParameter(targetChannelSelector, "targetChannelSelector");
        Intrinsics3.checkNotNullParameter(logger, "logger");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.channelId = l;
        this.guildId = j;
        this.storeInviteSettings = storeInviteSettings;
        this.storeAnalytics = storeAnalytics;
        this.storeMessages = storeMessages;
        this.targetChannelSelector = targetChannelSelector;
        this.logger = logger;
        BehaviorSubject<String> behaviorSubjectL0 = BehaviorSubject.l0("");
        Intrinsics3.checkNotNullExpressionValue(behaviorSubjectL0, "BehaviorSubject.create(\"\")");
        this.searchQuerySubject = behaviorSubjectL0;
        this.searchQuery = "";
        this.sentInvites = Maps6.emptyMap();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), GuildInviteShareSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        Observable<String> observableP = this.searchQuerySubject.p(250L, TimeUnit.MILLISECONDS);
        Intrinsics3.checkNotNullExpressionValue(observableP, "searchQuerySubject\n     …0, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableP, this, null, 2, null), GuildInviteShareSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
    }
}
