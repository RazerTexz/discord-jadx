package com.discord.widgets.guilds.invite;

import android.content.Context;
import android.content.res.Resources;
import androidx.core.app.NotificationCompat;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.BuildConfig;
import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.stageinstance.StageInstance;
import com.discord.app.AppComponent;
import com.discord.models.domain.ModelInvite;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuildScheduledEvents;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreInstantInvites;
import com.discord.stores.StoreInviteSettings;
import com.discord.stores.StoreMessages;
import com.discord.stores.StoreStageInstances;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.messagesend.MessageQueue4;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableCombineLatestOverloads2;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.guilds.invite.InviteGenerator;
import com.discord.widgets.guilds.invite.WidgetInviteModel;
import d0.Tuples;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.t.Sets5;
import d0.t._Sets;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.Action1;
import rx.subjects.BehaviorSubject;

/* compiled from: WidgetGuildInviteShareViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001~B\u0093\u0001\u0012\b\b\u0002\u0010x\u001a\u00020w\u0012\b\b\u0002\u0010Z\u001a\u00020Y\u0012\b\b\u0002\u0010s\u001a\u00020r\u0012\b\b\u0002\u00103\u001a\u000202\u0012\b\b\u0002\u0010N\u001a\u00020M\u0012\b\b\u0002\u0010U\u001a\u00020T\u0012\b\b\u0002\u0010h\u001a\u00020g\u0012\b\b\u0002\u0010;\u001a\u00020:\u0012\b\b\u0002\u0010F\u001a\u00020E\u0012\u0006\u0010_\u001a\u00020^\u0012\b\b\u0002\u0010n\u001a\u00020m\u0012\n\u0010\u0012\u001a\u00060\fj\u0002`\u0011\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b|\u0010}J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ-\u0010\u000f\u001a\u00020\u00062\u001c\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u000e\u0012\f\u0012\b\u0012\u00060\fj\u0002`\r0\u000b0\tH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J5\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\n\u0010\u0012\u001a\u00060\fj\u0002`\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J5\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u00152\n\u0010\u0012\u001a\u00060\fj\u0002`\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\nH\u0000¢\u0006\u0004\b\u0019\u0010\u0018J\u0015\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\n¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u001f\u001a\u00020\u00062\n\u0010\u001e\u001a\u00060\fj\u0002`\r¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010!\u001a\u00020\u00062\n\u0010\u001e\u001a\u00060\fj\u0002`\r¢\u0006\u0004\b!\u0010 J\u000f\u0010#\u001a\u0004\u0018\u00010\"¢\u0006\u0004\b#\u0010$J+\u0010'\u001a\u00020\u00062\n\u0010\u001e\u001a\u00060\fj\u0002`\r2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010%¢\u0006\u0004\b'\u0010(J+\u0010+\u001a\u00020\u00062\n\u0010*\u001a\u00060\fj\u0002`)2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010%¢\u0006\u0004\b+\u0010(J\u0015\u0010.\u001a\u00020\u00062\u0006\u0010-\u001a\u00020,¢\u0006\u0004\b.\u0010/J\r\u00100\u001a\u00020\u0006¢\u0006\u0004\b0\u00101R\u0019\u00103\u001a\u0002028\u0006@\u0006¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u00107\u001a\u0004\b8\u00109R\u0019\u0010;\u001a\u00020:8\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R\u001d\u0010\u0012\u001a\u00060\fj\u0002`\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010?\u001a\u0004\b@\u0010AR\u001b\u0010\u0014\u001a\u0004\u0018\u00010\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010B\u001a\u0004\bC\u0010DR\u0019\u0010F\u001a\u00020E8\u0006@\u0006¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR\u001c\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00060J8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u0019\u0010N\u001a\u00020M8\u0006@\u0006¢\u0006\f\n\u0004\bN\u0010O\u001a\u0004\bP\u0010QR:\u0010S\u001a&\u0012\f\u0012\n R*\u0004\u0018\u00010\n0\n R*\u0012\u0012\f\u0012\n R*\u0004\u0018\u00010\n0\n\u0018\u00010J0J8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bS\u0010LR\u0019\u0010U\u001a\u00020T8\u0006@\u0006¢\u0006\f\n\u0004\bU\u0010V\u001a\u0004\bW\u0010XR\u0019\u0010Z\u001a\u00020Y8\u0006@\u0006¢\u0006\f\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]R\u0019\u0010_\u001a\u00020^8\u0006@\u0006¢\u0006\f\n\u0004\b_\u0010`\u001a\u0004\ba\u0010bR$\u0010e\u001a\n R*\u0004\u0018\u00010\n0\n*\u0004\u0018\u00010%8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bc\u0010dR \u0010f\u001a\f\u0012\b\u0012\u00060\fj\u0002`\r0J8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bf\u0010LR\u0019\u0010h\u001a\u00020g8\u0006@\u0006¢\u0006\f\n\u0004\bh\u0010i\u001a\u0004\bj\u0010kR2\u0010l\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\n\u0012\u000e\u0012\f\u0012\b\u0012\u00060\fj\u0002`\r0\u000b0\t0J8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bl\u0010LR\u0019\u0010n\u001a\u00020m8\u0006@\u0006¢\u0006\f\n\u0004\bn\u0010o\u001a\u0004\bp\u0010qR\u0019\u0010s\u001a\u00020r8\u0006@\u0006¢\u0006\f\n\u0004\bs\u0010t\u001a\u0004\bu\u0010vR\u0019\u0010x\u001a\u00020w8\u0006@\u0006¢\u0006\f\n\u0004\bx\u0010y\u001a\u0004\bz\u0010{¨\u0006\u007f"}, d2 = {"Lcom/discord/widgets/guilds/invite/WidgetGuildInviteShareViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/guilds/invite/WidgetGuildInviteShareViewModel$ViewState;", "Lcom/discord/app/AppComponent;", "Lcom/discord/widgets/guilds/invite/WidgetGuildInviteShareViewModel$ViewState$Loaded;", "viewState", "", "generateInviteLinkFromViewState", "(Lcom/discord/widgets/guilds/invite/WidgetGuildInviteShareViewModel$ViewState$Loaded;)V", "", "", "", "", "Lcom/discord/primitives/ChannelId;", "sentInvites", "updateSentInvites", "(Ljava/util/Map;)V", "Lcom/discord/primitives/GuildId;", "guildId", "eventId", "inviteStoreKey", "Lrx/Observable;", "Lcom/discord/widgets/guilds/invite/WidgetInviteModel;", "observeWidgetInviteViewModel", "(JLjava/lang/Long;Ljava/lang/String;)Lrx/Observable;", "observeViewStateFromStores$app_productionGoogleRelease", "observeViewStateFromStores", "searchQuery", "updateSearchQuery", "(Ljava/lang/String;)V", "channelId", "selectChannel", "(J)V", "generateInviteLink", "Lcom/discord/models/experiments/domain/Experiment;", "getDefaultInviteExperiment", "()Lcom/discord/models/experiments/domain/Experiment;", "Lcom/discord/models/domain/ModelInvite;", "invite", "sendInviteToChannel", "(JLcom/discord/widgets/guilds/invite/WidgetGuildInviteShareViewModel$ViewState$Loaded;Lcom/discord/models/domain/ModelInvite;)V", "Lcom/discord/primitives/UserId;", "userId", "sendInviteToUser", "Lcom/discord/models/domain/ModelInvite$Settings;", "settings", "updateInviteSettings", "(Lcom/discord/models/domain/ModelInvite$Settings;)V", "refreshUi", "()V", "Lcom/discord/stores/StoreUser;", "storeUser", "Lcom/discord/stores/StoreUser;", "getStoreUser", "()Lcom/discord/stores/StoreUser;", "Ljava/lang/Long;", "getEventId", "()Ljava/lang/Long;", "Lcom/discord/widgets/guilds/invite/InviteGenerator;", "inviteGenerator", "Lcom/discord/widgets/guilds/invite/InviteGenerator;", "getInviteGenerator", "()Lcom/discord/widgets/guilds/invite/InviteGenerator;", "J", "getGuildId", "()J", "Ljava/lang/String;", "getInviteStoreKey", "()Ljava/lang/String;", "Lcom/discord/widgets/guilds/invite/InviteSuggestionsManager;", "inviteSuggestionsManager", "Lcom/discord/widgets/guilds/invite/InviteSuggestionsManager;", "getInviteSuggestionsManager", "()Lcom/discord/widgets/guilds/invite/InviteSuggestionsManager;", "Lrx/subjects/BehaviorSubject;", "refreshUiSubject", "Lrx/subjects/BehaviorSubject;", "Lcom/discord/stores/StoreStageInstances;", "storeStageInstances", "Lcom/discord/stores/StoreStageInstances;", "getStoreStageInstances", "()Lcom/discord/stores/StoreStageInstances;", "kotlin.jvm.PlatformType", "filterPublisher", "Lcom/discord/stores/StoreGuildScheduledEvents;", "storeGuildScheduledEvents", "Lcom/discord/stores/StoreGuildScheduledEvents;", "getStoreGuildScheduledEvents", "()Lcom/discord/stores/StoreGuildScheduledEvents;", "Lcom/discord/stores/StoreGuilds;", "storeGuilds", "Lcom/discord/stores/StoreGuilds;", "getStoreGuilds", "()Lcom/discord/stores/StoreGuilds;", "Landroid/content/res/Resources;", "resources", "Landroid/content/res/Resources;", "getResources", "()Landroid/content/res/Resources;", "getInviteLink", "(Lcom/discord/models/domain/ModelInvite;)Ljava/lang/String;", "inviteLink", "selectedChannelSubject", "Lcom/discord/stores/StoreInstantInvites;", "storeInstantInvites", "Lcom/discord/stores/StoreInstantInvites;", "getStoreInstantInvites", "()Lcom/discord/stores/StoreInstantInvites;", "sentInvitesSubject", "", "subscribeOnInit", "Z", "getSubscribeOnInit", "()Z", "Lcom/discord/stores/StoreInviteSettings;", "storeInviteSettings", "Lcom/discord/stores/StoreInviteSettings;", "getStoreInviteSettings", "()Lcom/discord/stores/StoreInviteSettings;", "Lcom/discord/stores/StoreChannels;", "storeChannels", "Lcom/discord/stores/StoreChannels;", "getStoreChannels", "()Lcom/discord/stores/StoreChannels;", "<init>", "(Lcom/discord/stores/StoreChannels;Lcom/discord/stores/StoreGuilds;Lcom/discord/stores/StoreInviteSettings;Lcom/discord/stores/StoreUser;Lcom/discord/stores/StoreStageInstances;Lcom/discord/stores/StoreGuildScheduledEvents;Lcom/discord/stores/StoreInstantInvites;Lcom/discord/widgets/guilds/invite/InviteGenerator;Lcom/discord/widgets/guilds/invite/InviteSuggestionsManager;Landroid/content/res/Resources;ZJLjava/lang/Long;Ljava/lang/String;)V", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetGuildInviteShareViewModel extends AppViewModel<ViewState> implements AppComponent {
    private final Long eventId;
    private final BehaviorSubject<String> filterPublisher;
    private final long guildId;
    private final InviteGenerator inviteGenerator;
    private final String inviteStoreKey;
    private final InviteSuggestionsManager inviteSuggestionsManager;
    private final BehaviorSubject<Unit> refreshUiSubject;
    private final Resources resources;
    private final BehaviorSubject<Long> selectedChannelSubject;
    private final BehaviorSubject<Map<String, Set<Long>>> sentInvitesSubject;
    private final StoreChannels storeChannels;
    private final StoreGuildScheduledEvents storeGuildScheduledEvents;
    private final StoreGuilds storeGuilds;
    private final StoreInstantInvites storeInstantInvites;
    private final StoreInviteSettings storeInviteSettings;
    private final StoreStageInstances storeStageInstances;
    private final StoreUser storeUser;
    private final boolean subscribeOnInit;

    /* compiled from: WidgetGuildInviteShareViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/widgets/guilds/invite/WidgetGuildInviteShareViewModel$ViewState$Loaded;", "kotlin.jvm.PlatformType", "viewState", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/widgets/guilds/invite/WidgetGuildInviteShareViewModel$ViewState$Loaded;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareViewModel$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Action1<ViewState.Loaded> {
        public AnonymousClass1() {
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(ViewState.Loaded loaded) {
            call2(loaded);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(ViewState.Loaded loaded) {
            WidgetGuildInviteShareViewModel widgetGuildInviteShareViewModel = WidgetGuildInviteShareViewModel.this;
            Intrinsics3.checkNotNullExpressionValue(loaded, "viewState");
            WidgetGuildInviteShareViewModel.access$generateInviteLinkFromViewState(widgetGuildInviteShareViewModel, loaded);
        }
    }

    /* compiled from: WidgetGuildInviteShareViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/guilds/invite/WidgetGuildInviteShareViewModel$ViewState;", "p1", "", "invoke", "(Lcom/discord/widgets/guilds/invite/WidgetGuildInviteShareViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareViewModel$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<ViewState, Unit> {
        public AnonymousClass2(WidgetGuildInviteShareViewModel widgetGuildInviteShareViewModel) {
            super(1, widgetGuildInviteShareViewModel, WidgetGuildInviteShareViewModel.class, "updateViewState", "updateViewState(Ljava/lang/Object;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            WidgetGuildInviteShareViewModel.access$updateViewState((WidgetGuildInviteShareViewModel) this.receiver, viewState);
        }
    }

    /* compiled from: WidgetGuildInviteShareViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/guilds/invite/WidgetGuildInviteShareViewModel$ViewState;", "", "<init>", "()V", "Loaded", "Uninitialized", "Lcom/discord/widgets/guilds/invite/WidgetGuildInviteShareViewModel$ViewState$Uninitialized;", "Lcom/discord/widgets/guilds/invite/WidgetGuildInviteShareViewModel$ViewState$Loaded;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        /* compiled from: WidgetGuildInviteShareViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0017\u001a\u00020\t\u0012\u001c\u0010\u0018\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u000ej\u0002`\u000f0\r0\f\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0012¢\u0006\u0004\b.\u0010/J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ&\u0010\u0010\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u000ej\u0002`\u000f0\r0\fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J^\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0015\u001a\u00020\u00022\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0017\u001a\u00020\t2\u001e\b\u0002\u0010\u0018\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u000ej\u0002`\u000f0\r0\f2\b\b\u0002\u0010\u0019\u001a\u00020\u0012HÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u000bJ\u0010\u0010\u001e\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010\"\u001a\u00020\u00122\b\u0010!\u001a\u0004\u0018\u00010 HÖ\u0003¢\u0006\u0004\b\"\u0010#R/\u0010\u0018\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u000ej\u0002`\u000f0\r0\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010$\u001a\u0004\b%\u0010\u0011R\u0019\u0010\u0019\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010&\u001a\u0004\b'\u0010\u0014R\u0019\u0010\u0017\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010(\u001a\u0004\b)\u0010\u000bR\u001f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010*\u001a\u0004\b+\u0010\bR\u0019\u0010\u0015\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010,\u001a\u0004\b-\u0010\u0004¨\u00060"}, d2 = {"Lcom/discord/widgets/guilds/invite/WidgetGuildInviteShareViewModel$ViewState$Loaded;", "Lcom/discord/widgets/guilds/invite/WidgetGuildInviteShareViewModel$ViewState;", "Lcom/discord/widgets/guilds/invite/WidgetInviteModel;", "component1", "()Lcom/discord/widgets/guilds/invite/WidgetInviteModel;", "", "Lcom/discord/widgets/guilds/invite/InviteSuggestionItem;", "component2", "()Ljava/util/List;", "", "component3", "()Ljava/lang/String;", "", "", "", "Lcom/discord/primitives/ChannelId;", "component4", "()Ljava/util/Map;", "", "component5", "()Z", "widgetInviteModel", "inviteSuggestionItems", "searchQuery", "sentInvites", "showInviteSettings", "copy", "(Lcom/discord/widgets/guilds/invite/WidgetInviteModel;Ljava/util/List;Ljava/lang/String;Ljava/util/Map;Z)Lcom/discord/widgets/guilds/invite/WidgetGuildInviteShareViewModel$ViewState$Loaded;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Map;", "getSentInvites", "Z", "getShowInviteSettings", "Ljava/lang/String;", "getSearchQuery", "Ljava/util/List;", "getInviteSuggestionItems", "Lcom/discord/widgets/guilds/invite/WidgetInviteModel;", "getWidgetInviteModel", "<init>", "(Lcom/discord/widgets/guilds/invite/WidgetInviteModel;Ljava/util/List;Ljava/lang/String;Ljava/util/Map;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Loaded extends ViewState {
            private final List<InviteSuggestionItem> inviteSuggestionItems;
            private final String searchQuery;
            private final Map<String, Set<Long>> sentInvites;
            private final boolean showInviteSettings;
            private final WidgetInviteModel widgetInviteModel;

            public /* synthetic */ Loaded(WidgetInviteModel widgetInviteModel, List list, String str, Map map, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(widgetInviteModel, list, (i & 4) != 0 ? "" : str, map, (i & 16) != 0 ? true : z2);
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, WidgetInviteModel widgetInviteModel, List list, String str, Map map, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    widgetInviteModel = loaded.widgetInviteModel;
                }
                if ((i & 2) != 0) {
                    list = loaded.inviteSuggestionItems;
                }
                List list2 = list;
                if ((i & 4) != 0) {
                    str = loaded.searchQuery;
                }
                String str2 = str;
                if ((i & 8) != 0) {
                    map = loaded.sentInvites;
                }
                Map map2 = map;
                if ((i & 16) != 0) {
                    z2 = loaded.showInviteSettings;
                }
                return loaded.copy(widgetInviteModel, list2, str2, map2, z2);
            }

            /* renamed from: component1, reason: from getter */
            public final WidgetInviteModel getWidgetInviteModel() {
                return this.widgetInviteModel;
            }

            public final List<InviteSuggestionItem> component2() {
                return this.inviteSuggestionItems;
            }

            /* renamed from: component3, reason: from getter */
            public final String getSearchQuery() {
                return this.searchQuery;
            }

            public final Map<String, Set<Long>> component4() {
                return this.sentInvites;
            }

            /* renamed from: component5, reason: from getter */
            public final boolean getShowInviteSettings() {
                return this.showInviteSettings;
            }

            public final Loaded copy(WidgetInviteModel widgetInviteModel, List<? extends InviteSuggestionItem> inviteSuggestionItems, String searchQuery, Map<String, ? extends Set<Long>> sentInvites, boolean showInviteSettings) {
                Intrinsics3.checkNotNullParameter(widgetInviteModel, "widgetInviteModel");
                Intrinsics3.checkNotNullParameter(inviteSuggestionItems, "inviteSuggestionItems");
                Intrinsics3.checkNotNullParameter(searchQuery, "searchQuery");
                Intrinsics3.checkNotNullParameter(sentInvites, "sentInvites");
                return new Loaded(widgetInviteModel, inviteSuggestionItems, searchQuery, sentInvites, showInviteSettings);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return Intrinsics3.areEqual(this.widgetInviteModel, loaded.widgetInviteModel) && Intrinsics3.areEqual(this.inviteSuggestionItems, loaded.inviteSuggestionItems) && Intrinsics3.areEqual(this.searchQuery, loaded.searchQuery) && Intrinsics3.areEqual(this.sentInvites, loaded.sentInvites) && this.showInviteSettings == loaded.showInviteSettings;
            }

            public final List<InviteSuggestionItem> getInviteSuggestionItems() {
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

            public final WidgetInviteModel getWidgetInviteModel() {
                return this.widgetInviteModel;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                WidgetInviteModel widgetInviteModel = this.widgetInviteModel;
                int iHashCode = (widgetInviteModel != null ? widgetInviteModel.hashCode() : 0) * 31;
                List<InviteSuggestionItem> list = this.inviteSuggestionItems;
                int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
                String str = this.searchQuery;
                int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
                Map<String, Set<Long>> map = this.sentInvites;
                int iHashCode4 = (iHashCode3 + (map != null ? map.hashCode() : 0)) * 31;
                boolean z2 = this.showInviteSettings;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                return iHashCode4 + i;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(widgetInviteModel=");
                sbU.append(this.widgetInviteModel);
                sbU.append(", inviteSuggestionItems=");
                sbU.append(this.inviteSuggestionItems);
                sbU.append(", searchQuery=");
                sbU.append(this.searchQuery);
                sbU.append(", sentInvites=");
                sbU.append(this.sentInvites);
                sbU.append(", showInviteSettings=");
                return outline.O(sbU, this.showInviteSettings, ")");
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Loaded(WidgetInviteModel widgetInviteModel, List<? extends InviteSuggestionItem> list, String str, Map<String, ? extends Set<Long>> map, boolean z2) {
                super(null);
                Intrinsics3.checkNotNullParameter(widgetInviteModel, "widgetInviteModel");
                Intrinsics3.checkNotNullParameter(list, "inviteSuggestionItems");
                Intrinsics3.checkNotNullParameter(str, "searchQuery");
                Intrinsics3.checkNotNullParameter(map, "sentInvites");
                this.widgetInviteModel = widgetInviteModel;
                this.inviteSuggestionItems = list;
                this.searchQuery = str;
                this.sentInvites = map;
                this.showInviteSettings = z2;
            }
        }

        /* compiled from: WidgetGuildInviteShareViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/guilds/invite/WidgetGuildInviteShareViewModel$ViewState$Uninitialized;", "Lcom/discord/widgets/guilds/invite/WidgetGuildInviteShareViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
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

    /* compiled from: WidgetGuildInviteShareViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0001\u001a\u00020\u00002\u0016\u0010\u0006\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u00022\u0006\u0010\b\u001a\u00020\u00072\u0018\u0010\n\u001a\u0014 \t*\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00040\u0003j\u0002`\u00042\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0016\u0010\u0012\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00110\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\n¢\u0006\u0004\b\u0018\u0010\u0019"}, d2 = {"Lcom/discord/models/domain/ModelInvite$Settings;", "settings", "", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/channel/Channel;", "invitableChannels", "Lcom/discord/widgets/guilds/invite/InviteGenerator$InviteGenerationState;", "inviteGenerationState", "kotlin.jvm.PlatformType", "selectedChannelId", "Lcom/discord/models/user/MeUser;", "me", "", "dms", "Lcom/discord/models/guild/Guild;", "guild", "Lcom/discord/api/stageinstance/StageInstance;", "guildStageInstances", "Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "guildScheduledEvent", "Lcom/discord/stores/StoreInstantInvites$InviteState;", "storeInvite", "Lcom/discord/widgets/guilds/invite/WidgetInviteModel;", "invoke", "(Lcom/discord/models/domain/ModelInvite$Settings;Ljava/util/Map;Lcom/discord/widgets/guilds/invite/InviteGenerator$InviteGenerationState;Ljava/lang/Long;Lcom/discord/models/user/MeUser;Ljava/util/List;Lcom/discord/models/guild/Guild;Ljava/util/Map;Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;Lcom/discord/stores/StoreInstantInvites$InviteState;)Lcom/discord/widgets/guilds/invite/WidgetInviteModel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareViewModel$observeWidgetInviteViewModel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function10<ModelInvite.Settings, Map<Long, ? extends Channel>, InviteGenerator.InviteGenerationState, Long, MeUser, List<? extends Channel>, Guild, Map<Long, ? extends StageInstance>, GuildScheduledEvent, StoreInstantInvites.InviteState, WidgetInviteModel> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(10);
        }

        @Override // kotlin.jvm.functions.Function10
        public /* bridge */ /* synthetic */ WidgetInviteModel invoke(ModelInvite.Settings settings, Map<Long, ? extends Channel> map, InviteGenerator.InviteGenerationState inviteGenerationState, Long l, MeUser meUser, List<? extends Channel> list, Guild guild, Map<Long, ? extends StageInstance> map2, GuildScheduledEvent guildScheduledEvent, StoreInstantInvites.InviteState inviteState) {
            return invoke2(settings, (Map<Long, Channel>) map, inviteGenerationState, l, meUser, (List<Channel>) list, guild, (Map<Long, StageInstance>) map2, guildScheduledEvent, inviteState);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final WidgetInviteModel invoke2(ModelInvite.Settings settings, Map<Long, Channel> map, InviteGenerator.InviteGenerationState inviteGenerationState, Long l, MeUser meUser, List<Channel> list, Guild guild, Map<Long, StageInstance> map2, GuildScheduledEvent guildScheduledEvent, StoreInstantInvites.InviteState inviteState) {
            StoreInstantInvites.InviteState inviteState2 = inviteState;
            Intrinsics3.checkNotNullParameter(settings, "settings");
            Intrinsics3.checkNotNullParameter(map, "invitableChannels");
            Intrinsics3.checkNotNullParameter(inviteGenerationState, "inviteGenerationState");
            Intrinsics3.checkNotNullParameter(meUser, "me");
            Intrinsics3.checkNotNullParameter(list, "dms");
            Intrinsics3.checkNotNullParameter(map2, "guildStageInstances");
            Intrinsics3.checkNotNullParameter(inviteState2, "storeInvite");
            WidgetInviteModel.Companion companion = WidgetInviteModel.INSTANCE;
            if (!(inviteState2 instanceof StoreInstantInvites.InviteState.Resolved)) {
                inviteState2 = null;
            }
            StoreInstantInvites.InviteState.Resolved resolved = (StoreInstantInvites.InviteState.Resolved) inviteState2;
            return companion.create(settings, map, inviteGenerationState, l, meUser, list, guild, map2, guildScheduledEvent, resolved != null ? resolved.getInvite() : null);
        }
    }

    /* compiled from: WidgetGuildInviteShareViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/messagesend/MessageResult;", "result", "", "invoke", "(Lcom/discord/utilities/messagesend/MessageResult;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareViewModel$sendInviteToChannel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<MessageQueue4, Unit> {
        public final /* synthetic */ ModelInvite $invite;
        public final /* synthetic */ String $inviteLink;
        public final /* synthetic */ ViewState.Loaded $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ModelInvite modelInvite, ViewState.Loaded loaded, String str) {
            super(1);
            this.$invite = modelInvite;
            this.$viewState = loaded;
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
                StoreStream.INSTANCE.getAnalytics().inviteSent(this.$invite, success.getMessage(), "Guild Create Invite Suggestion");
                Map<String, Set<Long>> sentInvites = this.$viewState.getSentInvites();
                String str = this.$inviteLink;
                Intrinsics3.checkNotNullExpressionValue(str, "inviteLink");
                Set<Long> setEmptySet = sentInvites.get(str);
                if (setEmptySet == null) {
                    setEmptySet = Sets5.emptySet();
                }
                WidgetGuildInviteShareViewModel.access$updateSentInvites(WidgetGuildInviteShareViewModel.this, Maps6.plus(sentInvites, MapsJVM.mapOf(Tuples.to(this.$inviteLink, _Sets.plus(setEmptySet, Long.valueOf(success.getMessage().getChannelId()))))));
            }
        }
    }

    /* compiled from: WidgetGuildInviteShareViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/channel/Channel;", "channel", "", "invoke", "(Lcom/discord/api/channel/Channel;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareViewModel$sendInviteToUser$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Channel, Unit> {
        public final /* synthetic */ ModelInvite $invite;
        public final /* synthetic */ ViewState.Loaded $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ViewState.Loaded loaded, ModelInvite modelInvite) {
            super(1);
            this.$viewState = loaded;
            this.$invite = modelInvite;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            WidgetGuildInviteShareViewModel.this.sendInviteToChannel(channel.getId(), this.$viewState, this.$invite);
        }
    }

    public /* synthetic */ WidgetGuildInviteShareViewModel(StoreChannels storeChannels, StoreGuilds storeGuilds, StoreInviteSettings storeInviteSettings, StoreUser storeUser, StoreStageInstances storeStageInstances, StoreGuildScheduledEvents storeGuildScheduledEvents, StoreInstantInvites storeInstantInvites, InviteGenerator inviteGenerator, InviteSuggestionsManager inviteSuggestionsManager, Resources resources, boolean z2, long j, Long l, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels, (i & 2) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds, (i & 4) != 0 ? StoreStream.INSTANCE.getInviteSettings() : storeInviteSettings, (i & 8) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser, (i & 16) != 0 ? StoreStream.INSTANCE.getStageInstances() : storeStageInstances, (i & 32) != 0 ? StoreStream.INSTANCE.getGuildScheduledEvents() : storeGuildScheduledEvents, (i & 64) != 0 ? StoreStream.INSTANCE.getInstantInvites() : storeInstantInvites, (i & 128) != 0 ? new InviteGenerator() : inviteGenerator, (i & 256) != 0 ? new InviteSuggestionsManager(null, null, null, null, null, 31, null) : inviteSuggestionsManager, resources, (i & 1024) != 0 ? true : z2, j, l, str);
    }

    public static final /* synthetic */ void access$generateInviteLinkFromViewState(WidgetGuildInviteShareViewModel widgetGuildInviteShareViewModel, ViewState.Loaded loaded) {
        widgetGuildInviteShareViewModel.generateInviteLinkFromViewState(loaded);
    }

    public static final /* synthetic */ String access$getInviteLink$p(WidgetGuildInviteShareViewModel widgetGuildInviteShareViewModel, ModelInvite modelInvite) {
        return widgetGuildInviteShareViewModel.getInviteLink(modelInvite);
    }

    public static final /* synthetic */ void access$updateSentInvites(WidgetGuildInviteShareViewModel widgetGuildInviteShareViewModel, Map map) {
        widgetGuildInviteShareViewModel.updateSentInvites(map);
    }

    public static final /* synthetic */ void access$updateViewState(WidgetGuildInviteShareViewModel widgetGuildInviteShareViewModel, ViewState viewState) {
        widgetGuildInviteShareViewModel.updateViewState(viewState);
    }

    private final void generateInviteLinkFromViewState(ViewState.Loaded viewState) {
        WidgetInviteModel widgetInviteModel = viewState.getWidgetInviteModel();
        if (widgetInviteModel.isValidInvite() || widgetInviteModel.isGeneratingInvite() || widgetInviteModel.getTargetChannel() == null) {
            return;
        }
        this.inviteGenerator.generateForAppComponent(this, widgetInviteModel.getTargetChannel().getId());
    }

    private final String getInviteLink(ModelInvite modelInvite) {
        return modelInvite == null ? BuildConfig.HOST_INVITE : modelInvite.toLink(this.resources, BuildConfig.HOST_INVITE);
    }

    private final Observable<WidgetInviteModel> observeWidgetInviteViewModel(long guildId, Long eventId, String inviteStoreKey) {
        Observable<WidgetInviteModel> observableR = ObservableExtensionsKt.computationLatest(ObservableCombineLatestOverloads2.combineLatest(this.storeInviteSettings.getInviteSettings(), this.storeInviteSettings.getInvitableChannels(guildId), this.inviteGenerator.getGenerationState(), this.selectedChannelSubject, StoreUser.observeMe$default(this.storeUser, false, 1, null), this.storeChannels.observeDMs(), this.storeGuilds.observeGuild(guildId), this.storeStageInstances.observeStageInstancesForGuild(guildId), this.storeGuildScheduledEvents.observeGuildScheduledEvent(eventId, Long.valueOf(guildId)), this.storeInstantInvites.observeInvite(inviteStoreKey), AnonymousClass1.INSTANCE)).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "combineLatest(\n        s…  .distinctUntilChanged()");
        return observableR;
    }

    private final void updateSentInvites(Map<String, ? extends Set<Long>> sentInvites) {
        this.sentInvitesSubject.onNext(sentInvites);
    }

    public final void generateInviteLink(long channelId) {
        this.inviteGenerator.generateForAppComponent(this, channelId);
    }

    public final Experiment getDefaultInviteExperiment() {
        return this.storeInviteSettings.getInviteGuildExperiment(this.guildId, true);
    }

    public final Long getEventId() {
        return this.eventId;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final InviteGenerator getInviteGenerator() {
        return this.inviteGenerator;
    }

    public final String getInviteStoreKey() {
        return this.inviteStoreKey;
    }

    public final InviteSuggestionsManager getInviteSuggestionsManager() {
        return this.inviteSuggestionsManager;
    }

    public final Resources getResources() {
        return this.resources;
    }

    public final StoreChannels getStoreChannels() {
        return this.storeChannels;
    }

    public final StoreGuildScheduledEvents getStoreGuildScheduledEvents() {
        return this.storeGuildScheduledEvents;
    }

    public final StoreGuilds getStoreGuilds() {
        return this.storeGuilds;
    }

    public final StoreInstantInvites getStoreInstantInvites() {
        return this.storeInstantInvites;
    }

    public final StoreInviteSettings getStoreInviteSettings() {
        return this.storeInviteSettings;
    }

    public final StoreStageInstances getStoreStageInstances() {
        return this.storeStageInstances;
    }

    public final StoreUser getStoreUser() {
        return this.storeUser;
    }

    public final boolean getSubscribeOnInit() {
        return this.subscribeOnInit;
    }

    public final Observable<ViewState.Loaded> observeViewStateFromStores$app_productionGoogleRelease(long guildId, Long eventId, String inviteStoreKey) {
        Observable<ViewState.Loaded> observableG = Observable.g(observeWidgetInviteViewModel(guildId, eventId, inviteStoreKey), this.inviteSuggestionsManager.observeInviteSuggestions(), this.filterPublisher, this.sentInvitesSubject, this.refreshUiSubject, new WidgetGuildInviteShareViewModel2(this));
        Intrinsics3.checkNotNullExpressionValue(observableG, "Observable.combineLatest…iteSettings\n      )\n    }");
        return observableG;
    }

    public final void refreshUi() {
        this.refreshUiSubject.onNext(Unit.a);
    }

    public final void selectChannel(long channelId) {
        this.selectedChannelSubject.onNext(Long.valueOf(channelId));
    }

    public final void sendInviteToChannel(long channelId, ViewState.Loaded viewState, ModelInvite invite) {
        Intrinsics3.checkNotNullParameter(viewState, "viewState");
        String inviteLink = getInviteLink(invite);
        StoreMessages messages = StoreStream.INSTANCE.getMessages();
        MeUser me2 = viewState.getWidgetInviteModel().getMe();
        Intrinsics3.checkNotNullExpressionValue(inviteLink, "inviteLink");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(StoreMessages.sendMessage$default(messages, channelId, me2, inviteLink, null, null, null, null, null, null, null, null, null, null, null, null, 32736, null), this, null, 2, null), WidgetGuildInviteShareViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(invite, viewState, inviteLink), 62, (Object) null);
    }

    public final void sendInviteToUser(long userId, ViewState.Loaded viewState, ModelInvite invite) {
        Intrinsics3.checkNotNullParameter(viewState, "viewState");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().createOrFetchDM(userId), false, 1, null), this, null, 2, null), WidgetGuildInviteShareViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(viewState, invite), 62, (Object) null);
    }

    public final void updateInviteSettings(ModelInvite.Settings settings) {
        Intrinsics3.checkNotNullParameter(settings, "settings");
        this.storeInviteSettings.setInviteSettings(settings);
    }

    public final void updateSearchQuery(String searchQuery) {
        Intrinsics3.checkNotNullParameter(searchQuery, "searchQuery");
        this.filterPublisher.onNext(searchQuery);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildInviteShareViewModel(StoreChannels storeChannels, StoreGuilds storeGuilds, StoreInviteSettings storeInviteSettings, StoreUser storeUser, StoreStageInstances storeStageInstances, StoreGuildScheduledEvents storeGuildScheduledEvents, StoreInstantInvites storeInstantInvites, InviteGenerator inviteGenerator, InviteSuggestionsManager inviteSuggestionsManager, Resources resources, boolean z2, long j, Long l, String str) {
        super(ViewState.Uninitialized.INSTANCE);
        Intrinsics3.checkNotNullParameter(storeChannels, "storeChannels");
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        Intrinsics3.checkNotNullParameter(storeInviteSettings, "storeInviteSettings");
        Intrinsics3.checkNotNullParameter(storeUser, "storeUser");
        Intrinsics3.checkNotNullParameter(storeStageInstances, "storeStageInstances");
        Intrinsics3.checkNotNullParameter(storeGuildScheduledEvents, "storeGuildScheduledEvents");
        Intrinsics3.checkNotNullParameter(storeInstantInvites, "storeInstantInvites");
        Intrinsics3.checkNotNullParameter(inviteGenerator, "inviteGenerator");
        Intrinsics3.checkNotNullParameter(inviteSuggestionsManager, "inviteSuggestionsManager");
        Intrinsics3.checkNotNullParameter(resources, "resources");
        this.storeChannels = storeChannels;
        this.storeGuilds = storeGuilds;
        this.storeInviteSettings = storeInviteSettings;
        this.storeUser = storeUser;
        this.storeStageInstances = storeStageInstances;
        this.storeGuildScheduledEvents = storeGuildScheduledEvents;
        this.storeInstantInvites = storeInstantInvites;
        this.inviteGenerator = inviteGenerator;
        this.inviteSuggestionsManager = inviteSuggestionsManager;
        this.resources = resources;
        this.subscribeOnInit = z2;
        this.guildId = j;
        this.eventId = l;
        this.inviteStoreKey = str;
        BehaviorSubject<Map<String, Set<Long>>> behaviorSubjectL0 = BehaviorSubject.l0(Maps6.emptyMap());
        Intrinsics3.checkNotNullExpressionValue(behaviorSubjectL0, "BehaviorSubject.create(emptyMap())");
        this.sentInvitesSubject = behaviorSubjectL0;
        this.filterPublisher = BehaviorSubject.l0("");
        BehaviorSubject<Long> behaviorSubjectL02 = BehaviorSubject.l0(null);
        Intrinsics3.checkNotNullExpressionValue(behaviorSubjectL02, "BehaviorSubject.create(null as ChannelId?)");
        this.selectedChannelSubject = behaviorSubjectL02;
        BehaviorSubject<Unit> behaviorSubjectL03 = BehaviorSubject.l0(Unit.a);
        Intrinsics3.checkNotNullExpressionValue(behaviorSubjectL03, "BehaviorSubject.create(Unit)");
        this.refreshUiSubject = behaviorSubjectL03;
        if (z2) {
            Observable<ViewState.Loaded> observableU = observeViewStateFromStores$app_productionGoogleRelease(j, l, str).u(new AnonymousClass1());
            Intrinsics3.checkNotNullExpressionValue(observableU, "observeViewStateFromStor…romViewState(viewState) }");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationBuffered(observableU), this, null, 2, null), WidgetGuildInviteShareViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(this), 62, (Object) null);
        }
    }
}
