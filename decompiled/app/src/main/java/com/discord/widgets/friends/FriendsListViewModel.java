package com.discord.widgets.friends;

import a0.a.a.b;
import android.content.Context;
import androidx.annotation.MainThread;
import androidx.annotation.StringRes;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.presence.ClientStatus;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.domain.ModelUserRelationship;
import com.discord.models.friendsuggestions.FriendSuggestion;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserConnections;
import com.discord.stores.StoreUserPresence;
import com.discord.stores.StoreUserRelationships;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.error.Error;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rest.RestAPIAbortMessages;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.captcha.WidgetCaptcha4;
import d0.t.Collections2;
import d0.t.MutableCollectionsJVM;
import d0.t.Sets5;
import d0.t._Collections;
import d0.t._Maps;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.p.Schedulers2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$ObjectRef;
import rx.Emitter;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Cancellable;
import rx.subjects.PublishSubject;

/* compiled from: FriendsListViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 l2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0006lmnopqB+\u0012\u000e\b\u0002\u0010f\u001a\b\u0012\u0004\u0012\u00020\u00170?\u0012\b\b\u0002\u0010b\u001a\u00020a\u0012\b\b\u0002\u0010X\u001a\u00020W¢\u0006\u0004\bj\u0010kJ\u0019\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u0010\u001a\u00020\u00052\n\u0010\u000f\u001a\u00060\rj\u0002`\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0003¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010!\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u001dH\u0003¢\u0006\u0004\b!\u0010\"J\u0093\u0001\u00100\u001a\u00020\u001b2\u001a\u0010&\u001a\u0016\u0012\b\u0012\u00060\rj\u0002`$\u0012\b\u0012\u00060\u0003j\u0002`%0#2\u0016\u0010(\u001a\u0012\u0012\b\u0012\u00060\rj\u0002`$\u0012\u0004\u0012\u00020'0#2\u0016\u0010*\u001a\u0012\u0012\b\u0012\u00060\rj\u0002`$\u0012\u0004\u0012\u00020)0#2\u0016\u0010,\u001a\u0012\u0012\b\u0012\u00060\rj\u0002`$\u0012\u0004\u0012\u00020+0#2\u0006\u0010-\u001a\u00020\u001d2\u0016\u0010/\u001a\u0012\u0012\b\u0012\u00060\rj\u0002`$\u0012\u0004\u0012\u00020.0#H\u0002¢\u0006\u0004\b0\u00101J\u001d\u00104\u001a\b\u0012\u0004\u0012\u000203022\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b4\u00105JO\u0010=\u001a\u00020<\"\u0004\b\u0000\u001062\f\u00108\u001a\b\u0012\u0004\u0012\u00028\u0000072\u0016\b\u0002\u0010:\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0005\u0018\u0001092\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000509H\u0002¢\u0006\u0004\b=\u0010>J\u0015\u0010A\u001a\b\u0012\u0004\u0012\u00020@0?H\u0007¢\u0006\u0004\bA\u0010BJ!\u0010D\u001a\u00020\u00052\n\u0010C\u001a\u00060\rj\u0002`$2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\bD\u0010EJ%\u0010G\u001a\u00020\u00052\n\u0010C\u001a\u00060\rj\u0002`$2\n\u0010F\u001a\u00060\u0003j\u0002`%¢\u0006\u0004\bG\u0010HJ)\u0010K\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00032\n\b\u0002\u0010J\u001a\u0004\u0018\u00010I¢\u0006\u0004\bK\u0010LJ\u0019\u0010M\u001a\u00020\u00052\n\u0010C\u001a\u00060\rj\u0002`$¢\u0006\u0004\bM\u0010\u0011J\u0019\u0010N\u001a\u00020\u00052\n\u0010C\u001a\u00060\rj\u0002`$¢\u0006\u0004\bN\u0010\u0011J\u000f\u0010O\u001a\u00020\u0005H\u0007¢\u0006\u0004\bO\u0010PJ\u000f\u0010Q\u001a\u00020\u0005H\u0007¢\u0006\u0004\bQ\u0010PJ\u000f\u0010R\u001a\u00020\u0005H\u0007¢\u0006\u0004\bR\u0010PR:\u0010U\u001a&\u0012\f\u0012\n T*\u0004\u0018\u00010@0@ T*\u0012\u0012\f\u0012\n T*\u0004\u0018\u00010@0@\u0018\u00010S0S8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010VR\u0019\u0010X\u001a\u00020W8\u0006@\u0006¢\u0006\f\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[R\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\\R\u0018\u0010]\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010_\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010`R\u0019\u0010b\u001a\u00020a8\u0006@\u0006¢\u0006\f\n\u0004\bb\u0010c\u001a\u0004\bd\u0010eR\u001f\u0010f\u001a\b\u0012\u0004\u0012\u00020\u00170?8\u0006@\u0006¢\u0006\f\n\u0004\bf\u0010g\u001a\u0004\bh\u0010BR\u0016\u0010i\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010`¨\u0006r"}, d2 = {"Lcom/discord/widgets/friends/FriendsListViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/friends/FriendsListViewModel$ViewState;", "", "stringRes", "", "emitShowToastEvent", "(I)V", "abortCode", "", "username", "emitShowFriendRequestAbortToast", "(ILjava/lang/String;)V", "", "Lcom/discord/primitives/ChannelId;", "channelId", "emitLaunchVoiceCallEvent", "(J)V", "Lcom/discord/utilities/error/Error;", "error", "discriminator", "emitCaptchaErrorEvent", "(Lcom/discord/utilities/error/Error;Ljava/lang/String;I)V", "Lcom/discord/widgets/friends/FriendsListViewModel$StoreState;", "storeState", "handleStoreState", "(Lcom/discord/widgets/friends/FriendsListViewModel$StoreState;)V", "Lcom/discord/widgets/friends/FriendsListViewModel$ListSections;", "listSections", "", "showContactSyncIcon", "handleComputedItems", "(Lcom/discord/widgets/friends/FriendsListViewModel$ListSections;Z)V", "generateLoadedItems", "(Z)V", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/primitives/RelationshipType;", "relationships", "Lcom/discord/models/user/User;", "users", "Lcom/discord/models/presence/Presence;", "presences", "Lcom/discord/models/domain/ModelApplicationStream;", "applicationStreams", "showContactSyncUpsell", "Lcom/discord/models/friendsuggestions/FriendSuggestion;", "friendSuggestions", "getItems", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;ZLjava/util/Map;)Lcom/discord/widgets/friends/FriendsListViewModel$ListSections;", "", "Lcom/discord/widgets/friends/FriendsListViewModel$Item;", "getVisibleItems", "(Lcom/discord/widgets/friends/FriendsListViewModel$ListSections;)Ljava/util/List;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function0;", "compute", "Lkotlin/Function1;", "onError", "onSuccess", "Lrx/functions/Cancellable;", "asyncComputeAndHandleOnUiThread", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Lrx/functions/Cancellable;", "Lrx/Observable;", "Lcom/discord/widgets/friends/FriendsListViewModel$Event;", "observeEvents", "()Lrx/Observable;", "userId", "acceptFriendRequest", "(JLjava/lang/String;)V", "relationshipType", "removeFriendRequest", "(JI)V", "Lcom/discord/utilities/captcha/CaptchaHelper$CaptchaPayload;", "captchaPayload", "acceptFriendSuggestion", "(Ljava/lang/String;ILcom/discord/utilities/captcha/CaptchaHelper$CaptchaPayload;)V", "ignoreSuggestion", "launchVoiceCall", "handleClickPendingHeader", "()V", "handleClickSuggestedHeader", "dismissContactSyncUpsell", "Lrx/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "eventSubject", "Lrx/subjects/PublishSubject;", "Lcom/discord/utilities/rest/RestAPI;", "restAPI", "Lcom/discord/utilities/rest/RestAPI;", "getRestAPI", "()Lcom/discord/utilities/rest/RestAPI;", "Lcom/discord/widgets/friends/FriendsListViewModel$ListSections;", "computeItemJob", "Lrx/functions/Cancellable;", "isPendingSectionExpanded", "Z", "Lcom/discord/stores/StoreChannels;", "storeChannels", "Lcom/discord/stores/StoreChannels;", "getStoreChannels", "()Lcom/discord/stores/StoreChannels;", "storeObservable", "Lrx/Observable;", "getStoreObservable", "isSuggestedSectionExpanded", "<init>", "(Lrx/Observable;Lcom/discord/stores/StoreChannels;Lcom/discord/utilities/rest/RestAPI;)V", "Companion", "Event", "Item", "ListSections", "StoreState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class FriendsListViewModel extends AppViewModel<ViewState> {
    private static final int COLLAPSED_ITEM_COUNT = 2;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String LOCATION = "Friends List";
    private Cancellable computeItemJob;
    private final PublishSubject<Event> eventSubject;
    private boolean isPendingSectionExpanded;
    private boolean isSuggestedSectionExpanded;
    private ListSections listSections;
    private final RestAPI restAPI;
    private final StoreChannels storeChannels;
    private final Observable<StoreState> storeObservable;

    /* compiled from: FriendsListViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/friends/FriendsListViewModel$StoreState;", "storeState", "", "invoke", "(Lcom/discord/widgets/friends/FriendsListViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.friends.FriendsListViewModel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<StoreState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) throws Exception {
            invoke2(storeState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) throws Exception {
            Intrinsics3.checkNotNullParameter(storeState, "storeState");
            FriendsListViewModel.access$handleStoreState(FriendsListViewModel.this, storeState);
        }
    }

    /* compiled from: FriendsListViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/discord/widgets/friends/FriendsListViewModel$Companion;", "", "Lrx/Observable;", "Lcom/discord/widgets/friends/FriendsListViewModel$StoreState;", "observeStores", "()Lrx/Observable;", "", "COLLAPSED_ITEM_COUNT", "I", "", "LOCATION", "Ljava/lang/String;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final Observable<StoreState> observeStores() {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            StoreChannelsSelected channelsSelected = companion.getChannelsSelected();
            StoreUserPresence presences = companion.getPresences();
            StoreUser users = companion.getUsers();
            StoreUserRelationships userRelationships = companion.getUserRelationships();
            StoreUserConnections userConnections = companion.getUserConnections();
            Observable<StoreState> observableG = ObservableExtensionsKt.leadingEdgeThrottle(ObservationDeck.connectRx$default(ObservationDeck4.get(), new ObservationDeck.UpdateSource[]{companion.getChannelsSelected(), companion.getPresences(), companion.getUsers(), companion.getUserRelationships(), companion.getApplicationStreaming(), companion.getUserConnections(), companion.getExperiments(), companion.getContactSync()}, false, null, null, 14, null), 1L, TimeUnit.SECONDS).G(new FriendsListViewModel2(channelsSelected, presences, users, userRelationships, companion.getApplicationStreaming(), userConnections, companion.getExperiments(), companion.getContactSync(), companion.getFriendSuggestions()));
            Intrinsics3.checkNotNullExpressionValue(observableG, "ObservationDeckProvider\n…            )\n          }");
            return observableG;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: FriendsListViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/discord/widgets/friends/FriendsListViewModel$Event;", "", "<init>", "()V", "CaptchaError", "LaunchVoiceCall", "ShowFriendRequestErrorToast", "ShowToast", "Lcom/discord/widgets/friends/FriendsListViewModel$Event$ShowToast;", "Lcom/discord/widgets/friends/FriendsListViewModel$Event$ShowFriendRequestErrorToast;", "Lcom/discord/widgets/friends/FriendsListViewModel$Event$LaunchVoiceCall;", "Lcom/discord/widgets/friends/FriendsListViewModel$Event$CaptchaError;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class Event {

        /* compiled from: FriendsListViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ.\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0007J\u0010\u0010\u0011\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0011\u0010\nJ\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u001a\u0010\nR\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004¨\u0006\u001f"}, d2 = {"Lcom/discord/widgets/friends/FriendsListViewModel$Event$CaptchaError;", "Lcom/discord/widgets/friends/FriendsListViewModel$Event;", "Lcom/discord/utilities/error/Error;", "component1", "()Lcom/discord/utilities/error/Error;", "", "component2", "()Ljava/lang/String;", "", "component3", "()I", "error", "username", "discriminator", "copy", "(Lcom/discord/utilities/error/Error;Ljava/lang/String;I)Lcom/discord/widgets/friends/FriendsListViewModel$Event$CaptchaError;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getUsername", "I", "getDiscriminator", "Lcom/discord/utilities/error/Error;", "getError", "<init>", "(Lcom/discord/utilities/error/Error;Ljava/lang/String;I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class CaptchaError extends Event {
            private final int discriminator;
            private final Error error;
            private final String username;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CaptchaError(Error error, String str, int i) {
                super(null);
                Intrinsics3.checkNotNullParameter(error, "error");
                Intrinsics3.checkNotNullParameter(str, "username");
                this.error = error;
                this.username = str;
                this.discriminator = i;
            }

            public static /* synthetic */ CaptchaError copy$default(CaptchaError captchaError, Error error, String str, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    error = captchaError.error;
                }
                if ((i2 & 2) != 0) {
                    str = captchaError.username;
                }
                if ((i2 & 4) != 0) {
                    i = captchaError.discriminator;
                }
                return captchaError.copy(error, str, i);
            }

            /* renamed from: component1, reason: from getter */
            public final Error getError() {
                return this.error;
            }

            /* renamed from: component2, reason: from getter */
            public final String getUsername() {
                return this.username;
            }

            /* renamed from: component3, reason: from getter */
            public final int getDiscriminator() {
                return this.discriminator;
            }

            public final CaptchaError copy(Error error, String username, int discriminator) {
                Intrinsics3.checkNotNullParameter(error, "error");
                Intrinsics3.checkNotNullParameter(username, "username");
                return new CaptchaError(error, username, discriminator);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof CaptchaError)) {
                    return false;
                }
                CaptchaError captchaError = (CaptchaError) other;
                return Intrinsics3.areEqual(this.error, captchaError.error) && Intrinsics3.areEqual(this.username, captchaError.username) && this.discriminator == captchaError.discriminator;
            }

            public final int getDiscriminator() {
                return this.discriminator;
            }

            public final Error getError() {
                return this.error;
            }

            public final String getUsername() {
                return this.username;
            }

            public int hashCode() {
                Error error = this.error;
                int iHashCode = (error != null ? error.hashCode() : 0) * 31;
                String str = this.username;
                return ((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + this.discriminator;
            }

            public String toString() {
                StringBuilder sbU = outline.U("CaptchaError(error=");
                sbU.append(this.error);
                sbU.append(", username=");
                sbU.append(this.username);
                sbU.append(", discriminator=");
                return outline.B(sbU, this.discriminator, ")");
            }
        }

        /* compiled from: FriendsListViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0007\u001a\u00020\u00002\f\b\u0002\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0006\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0005¨\u0006\u0018"}, d2 = {"Lcom/discord/widgets/friends/FriendsListViewModel$Event$LaunchVoiceCall;", "Lcom/discord/widgets/friends/FriendsListViewModel$Event;", "", "Lcom/discord/primitives/ChannelId;", "component1", "()J", "channelId", "copy", "(J)Lcom/discord/widgets/friends/FriendsListViewModel$Event$LaunchVoiceCall;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getChannelId", "<init>", "(J)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class LaunchVoiceCall extends Event {
            private final long channelId;

            public LaunchVoiceCall(long j) {
                super(null);
                this.channelId = j;
            }

            public static /* synthetic */ LaunchVoiceCall copy$default(LaunchVoiceCall launchVoiceCall, long j, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = launchVoiceCall.channelId;
                }
                return launchVoiceCall.copy(j);
            }

            /* renamed from: component1, reason: from getter */
            public final long getChannelId() {
                return this.channelId;
            }

            public final LaunchVoiceCall copy(long channelId) {
                return new LaunchVoiceCall(channelId);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof LaunchVoiceCall) && this.channelId == ((LaunchVoiceCall) other).channelId;
                }
                return true;
            }

            public final long getChannelId() {
                return this.channelId;
            }

            public int hashCode() {
                return b.a(this.channelId);
            }

            public String toString() {
                return outline.C(outline.U("LaunchVoiceCall(channelId="), this.channelId, ")");
            }
        }

        /* compiled from: FriendsListViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0004J\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0013\u001a\u0004\b\u0014\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004¨\u0006\u0019"}, d2 = {"Lcom/discord/widgets/friends/FriendsListViewModel$Event$ShowFriendRequestErrorToast;", "Lcom/discord/widgets/friends/FriendsListViewModel$Event;", "", "component1", "()I", "", "component2", "()Ljava/lang/String;", "abortCode", "username", "copy", "(ILjava/lang/String;)Lcom/discord/widgets/friends/FriendsListViewModel$Event$ShowFriendRequestErrorToast;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getUsername", "I", "getAbortCode", "<init>", "(ILjava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class ShowFriendRequestErrorToast extends Event {
            private final int abortCode;
            private final String username;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ShowFriendRequestErrorToast(int i, String str) {
                super(null);
                Intrinsics3.checkNotNullParameter(str, "username");
                this.abortCode = i;
                this.username = str;
            }

            public static /* synthetic */ ShowFriendRequestErrorToast copy$default(ShowFriendRequestErrorToast showFriendRequestErrorToast, int i, String str, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = showFriendRequestErrorToast.abortCode;
                }
                if ((i2 & 2) != 0) {
                    str = showFriendRequestErrorToast.username;
                }
                return showFriendRequestErrorToast.copy(i, str);
            }

            /* renamed from: component1, reason: from getter */
            public final int getAbortCode() {
                return this.abortCode;
            }

            /* renamed from: component2, reason: from getter */
            public final String getUsername() {
                return this.username;
            }

            public final ShowFriendRequestErrorToast copy(int abortCode, String username) {
                Intrinsics3.checkNotNullParameter(username, "username");
                return new ShowFriendRequestErrorToast(abortCode, username);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ShowFriendRequestErrorToast)) {
                    return false;
                }
                ShowFriendRequestErrorToast showFriendRequestErrorToast = (ShowFriendRequestErrorToast) other;
                return this.abortCode == showFriendRequestErrorToast.abortCode && Intrinsics3.areEqual(this.username, showFriendRequestErrorToast.username);
            }

            public final int getAbortCode() {
                return this.abortCode;
            }

            public final String getUsername() {
                return this.username;
            }

            public int hashCode() {
                int i = this.abortCode * 31;
                String str = this.username;
                return i + (str != null ? str.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("ShowFriendRequestErrorToast(abortCode=");
                sbU.append(this.abortCode);
                sbU.append(", username=");
                return outline.J(sbU, this.username, ")");
            }
        }

        /* compiled from: FriendsListViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\u0004J\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/friends/FriendsListViewModel$Event$ShowToast;", "Lcom/discord/widgets/friends/FriendsListViewModel$Event;", "", "component1", "()I", "stringRes", "copy", "(I)Lcom/discord/widgets/friends/FriendsListViewModel$Event$ShowToast;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getStringRes", "<init>", "(I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class ShowToast extends Event {
            private final int stringRes;

            public ShowToast(int i) {
                super(null);
                this.stringRes = i;
            }

            public static /* synthetic */ ShowToast copy$default(ShowToast showToast, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = showToast.stringRes;
                }
                return showToast.copy(i);
            }

            /* renamed from: component1, reason: from getter */
            public final int getStringRes() {
                return this.stringRes;
            }

            public final ShowToast copy(int stringRes) {
                return new ShowToast(stringRes);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof ShowToast) && this.stringRes == ((ShowToast) other).stringRes;
                }
                return true;
            }

            public final int getStringRes() {
                return this.stringRes;
            }

            public int hashCode() {
                return this.stringRes;
            }

            public String toString() {
                return outline.B(outline.U("ShowToast(stringRes="), this.stringRes, ")");
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: FriendsListViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \t2\u00020\u0001:\b\t\n\u000b\f\r\u000e\u000f\u0010B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0007\u0011\u0012\u0013\u0014\u0015\u0016\u0017¨\u0006\u0018"}, d2 = {"Lcom/discord/widgets/friends/FriendsListViewModel$Item;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "", "type", "I", "getType", "()I", "<init>", "(I)V", "Companion", "ContactSyncUpsell", "Friend", Traits.Location.Section.HEADER, "PendingFriendRequest", "PendingHeader", "SuggestedFriend", "SuggestedFriendsHeader", "Lcom/discord/widgets/friends/FriendsListViewModel$Item$Friend;", "Lcom/discord/widgets/friends/FriendsListViewModel$Item$PendingFriendRequest;", "Lcom/discord/widgets/friends/FriendsListViewModel$Item$PendingHeader;", "Lcom/discord/widgets/friends/FriendsListViewModel$Item$Header;", "Lcom/discord/widgets/friends/FriendsListViewModel$Item$SuggestedFriendsHeader;", "Lcom/discord/widgets/friends/FriendsListViewModel$Item$SuggestedFriend;", "Lcom/discord/widgets/friends/FriendsListViewModel$Item$ContactSyncUpsell;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class Item implements MGRecyclerDataPayload {
        public static final int TYPE_CONTACT_SYNC_UPSELL = 6;
        public static final int TYPE_FRIEND = 0;
        public static final int TYPE_HEADER = 3;
        public static final int TYPE_PENDING_FRIEND = 1;
        public static final int TYPE_PENDING_HEADER = 2;
        public static final int TYPE_SUGGESTED_FRIEND = 5;
        public static final int TYPE_SUGGESTED_FRIEND_HEADER = 4;
        private final int type;

        /* compiled from: FriendsListViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u00020\b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\nR\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004¨\u0006\u0019"}, d2 = {"Lcom/discord/widgets/friends/FriendsListViewModel$Item$ContactSyncUpsell;", "Lcom/discord/widgets/friends/FriendsListViewModel$Item;", "", "component1", "()Z", "dismissed", "copy", "(Z)Lcom/discord/widgets/friends/FriendsListViewModel$Item$ContactSyncUpsell;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "key", "Ljava/lang/String;", "getKey", "Z", "getDismissed", "<init>", "(Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class ContactSyncUpsell extends Item {
            private final boolean dismissed;
            private final String key;

            public ContactSyncUpsell(boolean z2) {
                super(6, null);
                this.dismissed = z2;
                this.key = String.valueOf(getType());
            }

            public static /* synthetic */ ContactSyncUpsell copy$default(ContactSyncUpsell contactSyncUpsell, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    z2 = contactSyncUpsell.dismissed;
                }
                return contactSyncUpsell.copy(z2);
            }

            /* renamed from: component1, reason: from getter */
            public final boolean getDismissed() {
                return this.dismissed;
            }

            public final ContactSyncUpsell copy(boolean dismissed) {
                return new ContactSyncUpsell(dismissed);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof ContactSyncUpsell) && this.dismissed == ((ContactSyncUpsell) other).dismissed;
                }
                return true;
            }

            public final boolean getDismissed() {
                return this.dismissed;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            public int hashCode() {
                boolean z2 = this.dismissed;
                if (z2) {
                    return 1;
                }
                return z2 ? 1 : 0;
            }

            public String toString() {
                return outline.O(outline.U("ContactSyncUpsell(dismissed="), this.dismissed, ")");
            }
        }

        /* compiled from: FriendsListViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b#\u0010$J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J0\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u000e\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u00020\u00118\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0013R\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001e\u001a\u0004\b\u001f\u0010\u0007R\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010 \u001a\u0004\b\u000e\u0010\u0004R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010!\u001a\u0004\b\"\u0010\n¨\u0006%"}, d2 = {"Lcom/discord/widgets/friends/FriendsListViewModel$Item$Friend;", "Lcom/discord/widgets/friends/FriendsListViewModel$Item;", "", "isOnline", "()Z", "Lcom/discord/models/user/User;", "component1", "()Lcom/discord/models/user/User;", "Lcom/discord/models/presence/Presence;", "component2", "()Lcom/discord/models/presence/Presence;", "component3", "user", "presence", "isApplicationStreaming", "copy", "(Lcom/discord/models/user/User;Lcom/discord/models/presence/Presence;Z)Lcom/discord/widgets/friends/FriendsListViewModel$Item$Friend;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "key", "Ljava/lang/String;", "getKey", "Lcom/discord/models/user/User;", "getUser", "Z", "Lcom/discord/models/presence/Presence;", "getPresence", "<init>", "(Lcom/discord/models/user/User;Lcom/discord/models/presence/Presence;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Friend extends Item {
            private final boolean isApplicationStreaming;
            private final String key;
            private final Presence presence;
            private final User user;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Friend(User user, Presence presence, boolean z2) {
                super(0, null);
                Intrinsics3.checkNotNullParameter(user, "user");
                this.user = user;
                this.presence = presence;
                this.isApplicationStreaming = z2;
                StringBuilder sb = new StringBuilder();
                sb.append(getType());
                sb.append(user.getId());
                this.key = sb.toString();
            }

            public static /* synthetic */ Friend copy$default(Friend friend, User user, Presence presence, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    user = friend.user;
                }
                if ((i & 2) != 0) {
                    presence = friend.presence;
                }
                if ((i & 4) != 0) {
                    z2 = friend.isApplicationStreaming;
                }
                return friend.copy(user, presence, z2);
            }

            /* renamed from: component1, reason: from getter */
            public final User getUser() {
                return this.user;
            }

            /* renamed from: component2, reason: from getter */
            public final Presence getPresence() {
                return this.presence;
            }

            /* renamed from: component3, reason: from getter */
            public final boolean getIsApplicationStreaming() {
                return this.isApplicationStreaming;
            }

            public final Friend copy(User user, Presence presence, boolean isApplicationStreaming) {
                Intrinsics3.checkNotNullParameter(user, "user");
                return new Friend(user, presence, isApplicationStreaming);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Friend)) {
                    return false;
                }
                Friend friend = (Friend) other;
                return Intrinsics3.areEqual(this.user, friend.user) && Intrinsics3.areEqual(this.presence, friend.presence) && this.isApplicationStreaming == friend.isApplicationStreaming;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            public final Presence getPresence() {
                return this.presence;
            }

            public final User getUser() {
                return this.user;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                User user = this.user;
                int iHashCode = (user != null ? user.hashCode() : 0) * 31;
                Presence presence = this.presence;
                int iHashCode2 = (iHashCode + (presence != null ? presence.hashCode() : 0)) * 31;
                boolean z2 = this.isApplicationStreaming;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                return iHashCode2 + i;
            }

            public final boolean isApplicationStreaming() {
                return this.isApplicationStreaming;
            }

            public final boolean isOnline() {
                return this.presence != null && Sets5.setOf((Object[]) new ClientStatus[]{ClientStatus.ONLINE, ClientStatus.IDLE, ClientStatus.DND}).contains(this.presence.getStatus());
            }

            public String toString() {
                StringBuilder sbU = outline.U("Friend(user=");
                sbU.append(this.user);
                sbU.append(", presence=");
                sbU.append(this.presence);
                sbU.append(", isApplicationStreaming=");
                return outline.O(sbU, this.isApplicationStreaming, ")");
            }
        }

        /* compiled from: FriendsListViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0003\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0004J\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u0019\u0010\u0006\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0015\u0010\u0004R\u001c\u0010\u0016\u001a\u00020\n8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/discord/widgets/friends/FriendsListViewModel$Item$Header;", "Lcom/discord/widgets/friends/FriendsListViewModel$Item;", "", "component1", "()I", "component2", "titleStringResId", "count", "copy", "(II)Lcom/discord/widgets/friends/FriendsListViewModel$Item$Header;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getCount", "getTitleStringResId", "key", "Ljava/lang/String;", "getKey", "<init>", "(II)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Header extends Item {
            private final int count;
            private final String key;
            private final int titleStringResId;

            public Header(@StringRes int i, int i2) {
                super(3, null);
                this.titleStringResId = i;
                this.count = i2;
                StringBuilder sb = new StringBuilder();
                sb.append(getType());
                sb.append(i);
                this.key = sb.toString();
            }

            public static /* synthetic */ Header copy$default(Header header, int i, int i2, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    i = header.titleStringResId;
                }
                if ((i3 & 2) != 0) {
                    i2 = header.count;
                }
                return header.copy(i, i2);
            }

            /* renamed from: component1, reason: from getter */
            public final int getTitleStringResId() {
                return this.titleStringResId;
            }

            /* renamed from: component2, reason: from getter */
            public final int getCount() {
                return this.count;
            }

            public final Header copy(@StringRes int titleStringResId, int count) {
                return new Header(titleStringResId, count);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Header)) {
                    return false;
                }
                Header header = (Header) other;
                return this.titleStringResId == header.titleStringResId && this.count == header.count;
            }

            public final int getCount() {
                return this.count;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            public final int getTitleStringResId() {
                return this.titleStringResId;
            }

            public int hashCode() {
                return (this.titleStringResId * 31) + this.count;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Header(titleStringResId=");
                sbU.append(this.titleStringResId);
                sbU.append(", count=");
                return outline.B(sbU, this.count, ")");
            }
        }

        /* compiled from: FriendsListViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\u0010\u000e\u001a\u00060\bj\u0002`\t¢\u0006\u0004\b#\u0010$J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\n\u001a\u00060\bj\u0002`\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ4\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\f\b\u0002\u0010\u000e\u001a\u00060\bj\u0002`\tHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0014\u0010\u000bJ\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u001d\u0010\u000e\u001a\u00060\bj\u0002`\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001a\u001a\u0004\b\u001b\u0010\u000bR\u001b\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001d\u0010\u0007R\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u001c\u0010 \u001a\u00020\u00118\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\u0013¨\u0006%"}, d2 = {"Lcom/discord/widgets/friends/FriendsListViewModel$Item$PendingFriendRequest;", "Lcom/discord/widgets/friends/FriendsListViewModel$Item;", "Lcom/discord/models/user/User;", "component1", "()Lcom/discord/models/user/User;", "Lcom/discord/models/presence/Presence;", "component2", "()Lcom/discord/models/presence/Presence;", "", "Lcom/discord/primitives/RelationshipType;", "component3", "()I", "user", "presence", "relationshipType", "copy", "(Lcom/discord/models/user/User;Lcom/discord/models/presence/Presence;I)Lcom/discord/widgets/friends/FriendsListViewModel$Item$PendingFriendRequest;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getRelationshipType", "Lcom/discord/models/presence/Presence;", "getPresence", "Lcom/discord/models/user/User;", "getUser", "key", "Ljava/lang/String;", "getKey", "<init>", "(Lcom/discord/models/user/User;Lcom/discord/models/presence/Presence;I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class PendingFriendRequest extends Item {
            private final String key;
            private final Presence presence;
            private final int relationshipType;
            private final User user;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public PendingFriendRequest(User user, Presence presence, int i) {
                super(1, null);
                Intrinsics3.checkNotNullParameter(user, "user");
                this.user = user;
                this.presence = presence;
                this.relationshipType = i;
                StringBuilder sb = new StringBuilder();
                sb.append(getType());
                sb.append(user.getId());
                this.key = sb.toString();
            }

            public static /* synthetic */ PendingFriendRequest copy$default(PendingFriendRequest pendingFriendRequest, User user, Presence presence, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    user = pendingFriendRequest.user;
                }
                if ((i2 & 2) != 0) {
                    presence = pendingFriendRequest.presence;
                }
                if ((i2 & 4) != 0) {
                    i = pendingFriendRequest.relationshipType;
                }
                return pendingFriendRequest.copy(user, presence, i);
            }

            /* renamed from: component1, reason: from getter */
            public final User getUser() {
                return this.user;
            }

            /* renamed from: component2, reason: from getter */
            public final Presence getPresence() {
                return this.presence;
            }

            /* renamed from: component3, reason: from getter */
            public final int getRelationshipType() {
                return this.relationshipType;
            }

            public final PendingFriendRequest copy(User user, Presence presence, int relationshipType) {
                Intrinsics3.checkNotNullParameter(user, "user");
                return new PendingFriendRequest(user, presence, relationshipType);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof PendingFriendRequest)) {
                    return false;
                }
                PendingFriendRequest pendingFriendRequest = (PendingFriendRequest) other;
                return Intrinsics3.areEqual(this.user, pendingFriendRequest.user) && Intrinsics3.areEqual(this.presence, pendingFriendRequest.presence) && this.relationshipType == pendingFriendRequest.relationshipType;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            public final Presence getPresence() {
                return this.presence;
            }

            public final int getRelationshipType() {
                return this.relationshipType;
            }

            public final User getUser() {
                return this.user;
            }

            public int hashCode() {
                User user = this.user;
                int iHashCode = (user != null ? user.hashCode() : 0) * 31;
                Presence presence = this.presence;
                return ((iHashCode + (presence != null ? presence.hashCode() : 0)) * 31) + this.relationshipType;
            }

            public String toString() {
                StringBuilder sbU = outline.U("PendingFriendRequest(user=");
                sbU.append(this.user);
                sbU.append(", presence=");
                sbU.append(this.presence);
                sbU.append(", relationshipType=");
                return outline.B(sbU, this.relationshipType, ")");
            }
        }

        /* compiled from: FriendsListViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0001\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ8\u0010\u000e\u001a\u00020\u00002\b\b\u0003\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0004J\u001a\u0010\u0016\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u001c\u0010\u001a\u001a\u00020\u00108\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0012R\u0019\u0010\f\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001d\u001a\u0004\b\f\u0010\bR\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u001e\u0010\u0004R\u0019\u0010\r\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b\u001f\u0010\b¨\u0006\""}, d2 = {"Lcom/discord/widgets/friends/FriendsListViewModel$Item$PendingHeader;", "Lcom/discord/widgets/friends/FriendsListViewModel$Item;", "", "component1", "()I", "component2", "", "component3", "()Z", "component4", "titleStringResId", "count", "isPendingSectionExpanded", "showExpandButton", "copy", "(IIZZ)Lcom/discord/widgets/friends/FriendsListViewModel$Item$PendingHeader;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "I", "getCount", "key", "Ljava/lang/String;", "getKey", "Z", "getTitleStringResId", "getShowExpandButton", "<init>", "(IIZZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class PendingHeader extends Item {
            private final int count;
            private final boolean isPendingSectionExpanded;
            private final String key;
            private final boolean showExpandButton;
            private final int titleStringResId;

            public PendingHeader(@StringRes int i, int i2, boolean z2, boolean z3) {
                super(2, null);
                this.titleStringResId = i;
                this.count = i2;
                this.isPendingSectionExpanded = z2;
                this.showExpandButton = z3;
                this.key = String.valueOf(getType());
            }

            public static /* synthetic */ PendingHeader copy$default(PendingHeader pendingHeader, int i, int i2, boolean z2, boolean z3, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    i = pendingHeader.titleStringResId;
                }
                if ((i3 & 2) != 0) {
                    i2 = pendingHeader.count;
                }
                if ((i3 & 4) != 0) {
                    z2 = pendingHeader.isPendingSectionExpanded;
                }
                if ((i3 & 8) != 0) {
                    z3 = pendingHeader.showExpandButton;
                }
                return pendingHeader.copy(i, i2, z2, z3);
            }

            /* renamed from: component1, reason: from getter */
            public final int getTitleStringResId() {
                return this.titleStringResId;
            }

            /* renamed from: component2, reason: from getter */
            public final int getCount() {
                return this.count;
            }

            /* renamed from: component3, reason: from getter */
            public final boolean getIsPendingSectionExpanded() {
                return this.isPendingSectionExpanded;
            }

            /* renamed from: component4, reason: from getter */
            public final boolean getShowExpandButton() {
                return this.showExpandButton;
            }

            public final PendingHeader copy(@StringRes int titleStringResId, int count, boolean isPendingSectionExpanded, boolean showExpandButton) {
                return new PendingHeader(titleStringResId, count, isPendingSectionExpanded, showExpandButton);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof PendingHeader)) {
                    return false;
                }
                PendingHeader pendingHeader = (PendingHeader) other;
                return this.titleStringResId == pendingHeader.titleStringResId && this.count == pendingHeader.count && this.isPendingSectionExpanded == pendingHeader.isPendingSectionExpanded && this.showExpandButton == pendingHeader.showExpandButton;
            }

            public final int getCount() {
                return this.count;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            public final boolean getShowExpandButton() {
                return this.showExpandButton;
            }

            public final int getTitleStringResId() {
                return this.titleStringResId;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                int i = ((this.titleStringResId * 31) + this.count) * 31;
                boolean z2 = this.isPendingSectionExpanded;
                int i2 = z2;
                if (z2 != 0) {
                    i2 = 1;
                }
                int i3 = (i + i2) * 31;
                boolean z3 = this.showExpandButton;
                return i3 + (z3 ? 1 : z3 ? 1 : 0);
            }

            public final boolean isPendingSectionExpanded() {
                return this.isPendingSectionExpanded;
            }

            public String toString() {
                StringBuilder sbU = outline.U("PendingHeader(titleStringResId=");
                sbU.append(this.titleStringResId);
                sbU.append(", count=");
                sbU.append(this.count);
                sbU.append(", isPendingSectionExpanded=");
                sbU.append(this.isPendingSectionExpanded);
                sbU.append(", showExpandButton=");
                return outline.O(sbU, this.showExpandButton, ")");
            }
        }

        /* compiled from: FriendsListViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u001c\u0010\u0015\u001a\u00020\b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/discord/widgets/friends/FriendsListViewModel$Item$SuggestedFriend;", "Lcom/discord/widgets/friends/FriendsListViewModel$Item;", "Lcom/discord/models/friendsuggestions/FriendSuggestion;", "component1", "()Lcom/discord/models/friendsuggestions/FriendSuggestion;", "suggestion", "copy", "(Lcom/discord/models/friendsuggestions/FriendSuggestion;)Lcom/discord/widgets/friends/FriendsListViewModel$Item$SuggestedFriend;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/friendsuggestions/FriendSuggestion;", "getSuggestion", "key", "Ljava/lang/String;", "getKey", "<init>", "(Lcom/discord/models/friendsuggestions/FriendSuggestion;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class SuggestedFriend extends Item {
            private final String key;
            private final FriendSuggestion suggestion;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SuggestedFriend(FriendSuggestion friendSuggestion) {
                super(5, null);
                Intrinsics3.checkNotNullParameter(friendSuggestion, "suggestion");
                this.suggestion = friendSuggestion;
                this.key = getType() + " -- " + friendSuggestion.getUser().getId();
            }

            public static /* synthetic */ SuggestedFriend copy$default(SuggestedFriend suggestedFriend, FriendSuggestion friendSuggestion, int i, Object obj) {
                if ((i & 1) != 0) {
                    friendSuggestion = suggestedFriend.suggestion;
                }
                return suggestedFriend.copy(friendSuggestion);
            }

            /* renamed from: component1, reason: from getter */
            public final FriendSuggestion getSuggestion() {
                return this.suggestion;
            }

            public final SuggestedFriend copy(FriendSuggestion suggestion) {
                Intrinsics3.checkNotNullParameter(suggestion, "suggestion");
                return new SuggestedFriend(suggestion);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof SuggestedFriend) && Intrinsics3.areEqual(this.suggestion, ((SuggestedFriend) other).suggestion);
                }
                return true;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            public final FriendSuggestion getSuggestion() {
                return this.suggestion;
            }

            public int hashCode() {
                FriendSuggestion friendSuggestion = this.suggestion;
                if (friendSuggestion != null) {
                    return friendSuggestion.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("SuggestedFriend(suggestion=");
                sbU.append(this.suggestion);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: FriendsListViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004J\u001a\u0010\u0014\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\n\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\n\u0010\u0007R\u001c\u0010\u0017\u001a\u00020\u000e8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0010R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u001c\u0010\u0007¨\u0006\u001f"}, d2 = {"Lcom/discord/widgets/friends/FriendsListViewModel$Item$SuggestedFriendsHeader;", "Lcom/discord/widgets/friends/FriendsListViewModel$Item;", "", "component1", "()I", "", "component2", "()Z", "component3", "count", "isExpanded", "showExpandButton", "copy", "(IZZ)Lcom/discord/widgets/friends/FriendsListViewModel$Item$SuggestedFriendsHeader;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "key", "Ljava/lang/String;", "getKey", "I", "getCount", "getShowExpandButton", "<init>", "(IZZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class SuggestedFriendsHeader extends Item {
            private final int count;
            private final boolean isExpanded;
            private final String key;
            private final boolean showExpandButton;

            public SuggestedFriendsHeader(int i, boolean z2, boolean z3) {
                super(4, null);
                this.count = i;
                this.isExpanded = z2;
                this.showExpandButton = z3;
                this.key = String.valueOf(getType());
            }

            public static /* synthetic */ SuggestedFriendsHeader copy$default(SuggestedFriendsHeader suggestedFriendsHeader, int i, boolean z2, boolean z3, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = suggestedFriendsHeader.count;
                }
                if ((i2 & 2) != 0) {
                    z2 = suggestedFriendsHeader.isExpanded;
                }
                if ((i2 & 4) != 0) {
                    z3 = suggestedFriendsHeader.showExpandButton;
                }
                return suggestedFriendsHeader.copy(i, z2, z3);
            }

            /* renamed from: component1, reason: from getter */
            public final int getCount() {
                return this.count;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getIsExpanded() {
                return this.isExpanded;
            }

            /* renamed from: component3, reason: from getter */
            public final boolean getShowExpandButton() {
                return this.showExpandButton;
            }

            public final SuggestedFriendsHeader copy(int count, boolean isExpanded, boolean showExpandButton) {
                return new SuggestedFriendsHeader(count, isExpanded, showExpandButton);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SuggestedFriendsHeader)) {
                    return false;
                }
                SuggestedFriendsHeader suggestedFriendsHeader = (SuggestedFriendsHeader) other;
                return this.count == suggestedFriendsHeader.count && this.isExpanded == suggestedFriendsHeader.isExpanded && this.showExpandButton == suggestedFriendsHeader.showExpandButton;
            }

            public final int getCount() {
                return this.count;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            public final boolean getShowExpandButton() {
                return this.showExpandButton;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                int i = this.count * 31;
                boolean z2 = this.isExpanded;
                int i2 = z2;
                if (z2 != 0) {
                    i2 = 1;
                }
                int i3 = (i + i2) * 31;
                boolean z3 = this.showExpandButton;
                return i3 + (z3 ? 1 : z3 ? 1 : 0);
            }

            public final boolean isExpanded() {
                return this.isExpanded;
            }

            public String toString() {
                StringBuilder sbU = outline.U("SuggestedFriendsHeader(count=");
                sbU.append(this.count);
                sbU.append(", isExpanded=");
                sbU.append(this.isExpanded);
                sbU.append(", showExpandButton=");
                return outline.O(sbU, this.showExpandButton, ")");
            }
        }

        private Item(int i) {
            this.type = i;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        public /* synthetic */ Item(int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(i);
        }
    }

    /* compiled from: FriendsListViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0082\b\u0018\u00002\u00020\u0001BO\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\t\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u0005\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u0005\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b.\u0010/J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u0005HÆ\u0003¢\u0006\u0004\b\r\u0010\bJ\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u0005HÆ\u0003¢\u0006\u0004\b\u000e\u0010\bJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011Jd\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\t2\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u00052\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000fHÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010\"\u001a\u00020!2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\"\u0010#R\u001f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010$\u001a\u0004\b%\u0010\bR\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010&\u001a\u0004\b'\u0010\u0004R\u001f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010$\u001a\u0004\b(\u0010\bR\u001f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010$\u001a\u0004\b)\u0010\bR\u001b\u0010\u0014\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010*\u001a\u0004\b+\u0010\u000bR\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010,\u001a\u0004\b-\u0010\u0011¨\u00060"}, d2 = {"Lcom/discord/widgets/friends/FriendsListViewModel$ListSections;", "", "Lcom/discord/widgets/friends/FriendsListViewModel$Item$SuggestedFriendsHeader;", "component1", "()Lcom/discord/widgets/friends/FriendsListViewModel$Item$SuggestedFriendsHeader;", "", "Lcom/discord/widgets/friends/FriendsListViewModel$Item$SuggestedFriend;", "component2", "()Ljava/util/List;", "Lcom/discord/widgets/friends/FriendsListViewModel$Item$PendingHeader;", "component3", "()Lcom/discord/widgets/friends/FriendsListViewModel$Item$PendingHeader;", "Lcom/discord/widgets/friends/FriendsListViewModel$Item;", "component4", "component5", "Lcom/discord/widgets/friends/FriendsListViewModel$Item$ContactSyncUpsell;", "component6", "()Lcom/discord/widgets/friends/FriendsListViewModel$Item$ContactSyncUpsell;", "suggestionsHeaderItem", "suggestedFriendItems", "pendingHeaderItem", "pendingItems", "friendsItemsWithHeaders", "contactSyncUpsell", "copy", "(Lcom/discord/widgets/friends/FriendsListViewModel$Item$SuggestedFriendsHeader;Ljava/util/List;Lcom/discord/widgets/friends/FriendsListViewModel$Item$PendingHeader;Ljava/util/List;Ljava/util/List;Lcom/discord/widgets/friends/FriendsListViewModel$Item$ContactSyncUpsell;)Lcom/discord/widgets/friends/FriendsListViewModel$ListSections;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getPendingItems", "Lcom/discord/widgets/friends/FriendsListViewModel$Item$SuggestedFriendsHeader;", "getSuggestionsHeaderItem", "getSuggestedFriendItems", "getFriendsItemsWithHeaders", "Lcom/discord/widgets/friends/FriendsListViewModel$Item$PendingHeader;", "getPendingHeaderItem", "Lcom/discord/widgets/friends/FriendsListViewModel$Item$ContactSyncUpsell;", "getContactSyncUpsell", "<init>", "(Lcom/discord/widgets/friends/FriendsListViewModel$Item$SuggestedFriendsHeader;Ljava/util/List;Lcom/discord/widgets/friends/FriendsListViewModel$Item$PendingHeader;Ljava/util/List;Ljava/util/List;Lcom/discord/widgets/friends/FriendsListViewModel$Item$ContactSyncUpsell;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ListSections {
        private final Item.ContactSyncUpsell contactSyncUpsell;
        private final List<Item> friendsItemsWithHeaders;
        private final Item.PendingHeader pendingHeaderItem;
        private final List<Item> pendingItems;
        private final List<Item.SuggestedFriend> suggestedFriendItems;
        private final Item.SuggestedFriendsHeader suggestionsHeaderItem;

        /* JADX WARN: Multi-variable type inference failed */
        public ListSections(Item.SuggestedFriendsHeader suggestedFriendsHeader, List<Item.SuggestedFriend> list, Item.PendingHeader pendingHeader, List<? extends Item> list2, List<? extends Item> list3, Item.ContactSyncUpsell contactSyncUpsell) {
            Intrinsics3.checkNotNullParameter(list, "suggestedFriendItems");
            Intrinsics3.checkNotNullParameter(list2, "pendingItems");
            Intrinsics3.checkNotNullParameter(list3, "friendsItemsWithHeaders");
            this.suggestionsHeaderItem = suggestedFriendsHeader;
            this.suggestedFriendItems = list;
            this.pendingHeaderItem = pendingHeader;
            this.pendingItems = list2;
            this.friendsItemsWithHeaders = list3;
            this.contactSyncUpsell = contactSyncUpsell;
        }

        public static /* synthetic */ ListSections copy$default(ListSections listSections, Item.SuggestedFriendsHeader suggestedFriendsHeader, List list, Item.PendingHeader pendingHeader, List list2, List list3, Item.ContactSyncUpsell contactSyncUpsell, int i, Object obj) {
            if ((i & 1) != 0) {
                suggestedFriendsHeader = listSections.suggestionsHeaderItem;
            }
            if ((i & 2) != 0) {
                list = listSections.suggestedFriendItems;
            }
            List list4 = list;
            if ((i & 4) != 0) {
                pendingHeader = listSections.pendingHeaderItem;
            }
            Item.PendingHeader pendingHeader2 = pendingHeader;
            if ((i & 8) != 0) {
                list2 = listSections.pendingItems;
            }
            List list5 = list2;
            if ((i & 16) != 0) {
                list3 = listSections.friendsItemsWithHeaders;
            }
            List list6 = list3;
            if ((i & 32) != 0) {
                contactSyncUpsell = listSections.contactSyncUpsell;
            }
            return listSections.copy(suggestedFriendsHeader, list4, pendingHeader2, list5, list6, contactSyncUpsell);
        }

        /* renamed from: component1, reason: from getter */
        public final Item.SuggestedFriendsHeader getSuggestionsHeaderItem() {
            return this.suggestionsHeaderItem;
        }

        public final List<Item.SuggestedFriend> component2() {
            return this.suggestedFriendItems;
        }

        /* renamed from: component3, reason: from getter */
        public final Item.PendingHeader getPendingHeaderItem() {
            return this.pendingHeaderItem;
        }

        public final List<Item> component4() {
            return this.pendingItems;
        }

        public final List<Item> component5() {
            return this.friendsItemsWithHeaders;
        }

        /* renamed from: component6, reason: from getter */
        public final Item.ContactSyncUpsell getContactSyncUpsell() {
            return this.contactSyncUpsell;
        }

        public final ListSections copy(Item.SuggestedFriendsHeader suggestionsHeaderItem, List<Item.SuggestedFriend> suggestedFriendItems, Item.PendingHeader pendingHeaderItem, List<? extends Item> pendingItems, List<? extends Item> friendsItemsWithHeaders, Item.ContactSyncUpsell contactSyncUpsell) {
            Intrinsics3.checkNotNullParameter(suggestedFriendItems, "suggestedFriendItems");
            Intrinsics3.checkNotNullParameter(pendingItems, "pendingItems");
            Intrinsics3.checkNotNullParameter(friendsItemsWithHeaders, "friendsItemsWithHeaders");
            return new ListSections(suggestionsHeaderItem, suggestedFriendItems, pendingHeaderItem, pendingItems, friendsItemsWithHeaders, contactSyncUpsell);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ListSections)) {
                return false;
            }
            ListSections listSections = (ListSections) other;
            return Intrinsics3.areEqual(this.suggestionsHeaderItem, listSections.suggestionsHeaderItem) && Intrinsics3.areEqual(this.suggestedFriendItems, listSections.suggestedFriendItems) && Intrinsics3.areEqual(this.pendingHeaderItem, listSections.pendingHeaderItem) && Intrinsics3.areEqual(this.pendingItems, listSections.pendingItems) && Intrinsics3.areEqual(this.friendsItemsWithHeaders, listSections.friendsItemsWithHeaders) && Intrinsics3.areEqual(this.contactSyncUpsell, listSections.contactSyncUpsell);
        }

        public final Item.ContactSyncUpsell getContactSyncUpsell() {
            return this.contactSyncUpsell;
        }

        public final List<Item> getFriendsItemsWithHeaders() {
            return this.friendsItemsWithHeaders;
        }

        public final Item.PendingHeader getPendingHeaderItem() {
            return this.pendingHeaderItem;
        }

        public final List<Item> getPendingItems() {
            return this.pendingItems;
        }

        public final List<Item.SuggestedFriend> getSuggestedFriendItems() {
            return this.suggestedFriendItems;
        }

        public final Item.SuggestedFriendsHeader getSuggestionsHeaderItem() {
            return this.suggestionsHeaderItem;
        }

        public int hashCode() {
            Item.SuggestedFriendsHeader suggestedFriendsHeader = this.suggestionsHeaderItem;
            int iHashCode = (suggestedFriendsHeader != null ? suggestedFriendsHeader.hashCode() : 0) * 31;
            List<Item.SuggestedFriend> list = this.suggestedFriendItems;
            int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
            Item.PendingHeader pendingHeader = this.pendingHeaderItem;
            int iHashCode3 = (iHashCode2 + (pendingHeader != null ? pendingHeader.hashCode() : 0)) * 31;
            List<Item> list2 = this.pendingItems;
            int iHashCode4 = (iHashCode3 + (list2 != null ? list2.hashCode() : 0)) * 31;
            List<Item> list3 = this.friendsItemsWithHeaders;
            int iHashCode5 = (iHashCode4 + (list3 != null ? list3.hashCode() : 0)) * 31;
            Item.ContactSyncUpsell contactSyncUpsell = this.contactSyncUpsell;
            return iHashCode5 + (contactSyncUpsell != null ? contactSyncUpsell.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("ListSections(suggestionsHeaderItem=");
            sbU.append(this.suggestionsHeaderItem);
            sbU.append(", suggestedFriendItems=");
            sbU.append(this.suggestedFriendItems);
            sbU.append(", pendingHeaderItem=");
            sbU.append(this.pendingHeaderItem);
            sbU.append(", pendingItems=");
            sbU.append(this.pendingItems);
            sbU.append(", friendsItemsWithHeaders=");
            sbU.append(this.friendsItemsWithHeaders);
            sbU.append(", contactSyncUpsell=");
            sbU.append(this.contactSyncUpsell);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: FriendsListViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001B\u008b\u0001\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\n\u0010\u001a\u001a\u00060\u0006j\u0002`\u0007\u0012\u0006\u0010\u001b\u001a\u00020\n\u0012\u0016\u0010\u001c\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u000e\u0012\u0004\u0012\u00020\u000f0\r\u0012\u0016\u0010\u001d\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u000e\u0012\u0004\u0012\u00020\u00120\r\u0012\u0016\u0010\u001e\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u000e\u0012\u0004\u0012\u00020\u00140\r\u0012\u0016\u0010\u001f\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u000e\u0012\u0004\u0012\u00020\u00160\r¢\u0006\u0004\b7\u00108J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0014\u0010\b\u001a\u00060\u0006j\u0002`\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0010\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u000e\u0012\u0004\u0012\u00020\u000f0\rHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J \u0010\u0013\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u000e\u0012\u0004\u0012\u00020\u00120\rHÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0011J \u0010\u0015\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u000e\u0012\u0004\u0012\u00020\u00140\rHÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0011J \u0010\u0017\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u000e\u0012\u0004\u0012\u00020\u00160\rHÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0011J¤\u0001\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0018\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u00022\f\b\u0002\u0010\u001a\u001a\u00060\u0006j\u0002`\u00072\b\b\u0002\u0010\u001b\u001a\u00020\n2\u0018\b\u0002\u0010\u001c\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u000e\u0012\u0004\u0012\u00020\u000f0\r2\u0018\b\u0002\u0010\u001d\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u000e\u0012\u0004\u0012\u00020\u00120\r2\u0018\b\u0002\u0010\u001e\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u000e\u0012\u0004\u0012\u00020\u00140\r2\u0018\b\u0002\u0010\u001f\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u000e\u0012\u0004\u0012\u00020\u00160\rHÆ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010#\u001a\u00020\"HÖ\u0001¢\u0006\u0004\b#\u0010$J\u0010\u0010&\u001a\u00020%HÖ\u0001¢\u0006\u0004\b&\u0010'J\u001a\u0010)\u001a\u00020\u00022\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b)\u0010*R\u0019\u0010\u0018\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010+\u001a\u0004\b,\u0010\u0004R)\u0010\u001f\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u000e\u0012\u0004\u0012\u00020\u00160\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010-\u001a\u0004\b.\u0010\u0011R\u001d\u0010\u001a\u001a\u00060\u0006j\u0002`\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010/\u001a\u0004\b0\u0010\tR)\u0010\u001d\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u000e\u0012\u0004\u0012\u00020\u00120\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010-\u001a\u0004\b1\u0010\u0011R)\u0010\u001e\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u000e\u0012\u0004\u0012\u00020\u00140\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010-\u001a\u0004\b2\u0010\u0011R\u0019\u0010\u0019\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010+\u001a\u0004\b3\u0010\u0004R)\u0010\u001c\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u000e\u0012\u0004\u0012\u00020\u000f0\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010-\u001a\u0004\b4\u0010\u0011R\u0019\u0010\u001b\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u00105\u001a\u0004\b6\u0010\f¨\u00069"}, d2 = {"Lcom/discord/widgets/friends/FriendsListViewModel$StoreState;", "", "", "component1", "()Z", "component2", "", "Lcom/discord/primitives/ChannelId;", "component3", "()J", "Lcom/discord/stores/StoreUserRelationships$UserRelationshipsState;", "component4", "()Lcom/discord/stores/StoreUserRelationships$UserRelationshipsState;", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/user/User;", "component5", "()Ljava/util/Map;", "Lcom/discord/models/presence/Presence;", "component6", "Lcom/discord/models/domain/ModelApplicationStream;", "component7", "Lcom/discord/models/friendsuggestions/FriendSuggestion;", "component8", "showContactSyncIcon", "showContactSyncUpsell", "channelId", "relationshipsState", "users", "presences", "applicationStreams", "friendSuggestions", "copy", "(ZZJLcom/discord/stores/StoreUserRelationships$UserRelationshipsState;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)Lcom/discord/widgets/friends/FriendsListViewModel$StoreState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getShowContactSyncIcon", "Ljava/util/Map;", "getFriendSuggestions", "J", "getChannelId", "getPresences", "getApplicationStreams", "getShowContactSyncUpsell", "getUsers", "Lcom/discord/stores/StoreUserRelationships$UserRelationshipsState;", "getRelationshipsState", "<init>", "(ZZJLcom/discord/stores/StoreUserRelationships$UserRelationshipsState;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class StoreState {
        private final Map<Long, ModelApplicationStream> applicationStreams;
        private final long channelId;
        private final Map<Long, FriendSuggestion> friendSuggestions;
        private final Map<Long, Presence> presences;
        private final StoreUserRelationships.UserRelationshipsState relationshipsState;
        private final boolean showContactSyncIcon;
        private final boolean showContactSyncUpsell;
        private final Map<Long, User> users;

        /* JADX WARN: Multi-variable type inference failed */
        public StoreState(boolean z2, boolean z3, long j, StoreUserRelationships.UserRelationshipsState userRelationshipsState, Map<Long, ? extends User> map, Map<Long, Presence> map2, Map<Long, ? extends ModelApplicationStream> map3, Map<Long, FriendSuggestion> map4) {
            Intrinsics3.checkNotNullParameter(userRelationshipsState, "relationshipsState");
            Intrinsics3.checkNotNullParameter(map, "users");
            Intrinsics3.checkNotNullParameter(map2, "presences");
            Intrinsics3.checkNotNullParameter(map3, "applicationStreams");
            Intrinsics3.checkNotNullParameter(map4, "friendSuggestions");
            this.showContactSyncIcon = z2;
            this.showContactSyncUpsell = z3;
            this.channelId = j;
            this.relationshipsState = userRelationshipsState;
            this.users = map;
            this.presences = map2;
            this.applicationStreams = map3;
            this.friendSuggestions = map4;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, boolean z2, boolean z3, long j, StoreUserRelationships.UserRelationshipsState userRelationshipsState, Map map, Map map2, Map map3, Map map4, int i, Object obj) {
            return storeState.copy((i & 1) != 0 ? storeState.showContactSyncIcon : z2, (i & 2) != 0 ? storeState.showContactSyncUpsell : z3, (i & 4) != 0 ? storeState.channelId : j, (i & 8) != 0 ? storeState.relationshipsState : userRelationshipsState, (i & 16) != 0 ? storeState.users : map, (i & 32) != 0 ? storeState.presences : map2, (i & 64) != 0 ? storeState.applicationStreams : map3, (i & 128) != 0 ? storeState.friendSuggestions : map4);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getShowContactSyncIcon() {
            return this.showContactSyncIcon;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getShowContactSyncUpsell() {
            return this.showContactSyncUpsell;
        }

        /* renamed from: component3, reason: from getter */
        public final long getChannelId() {
            return this.channelId;
        }

        /* renamed from: component4, reason: from getter */
        public final StoreUserRelationships.UserRelationshipsState getRelationshipsState() {
            return this.relationshipsState;
        }

        public final Map<Long, User> component5() {
            return this.users;
        }

        public final Map<Long, Presence> component6() {
            return this.presences;
        }

        public final Map<Long, ModelApplicationStream> component7() {
            return this.applicationStreams;
        }

        public final Map<Long, FriendSuggestion> component8() {
            return this.friendSuggestions;
        }

        public final StoreState copy(boolean showContactSyncIcon, boolean showContactSyncUpsell, long channelId, StoreUserRelationships.UserRelationshipsState relationshipsState, Map<Long, ? extends User> users, Map<Long, Presence> presences, Map<Long, ? extends ModelApplicationStream> applicationStreams, Map<Long, FriendSuggestion> friendSuggestions) {
            Intrinsics3.checkNotNullParameter(relationshipsState, "relationshipsState");
            Intrinsics3.checkNotNullParameter(users, "users");
            Intrinsics3.checkNotNullParameter(presences, "presences");
            Intrinsics3.checkNotNullParameter(applicationStreams, "applicationStreams");
            Intrinsics3.checkNotNullParameter(friendSuggestions, "friendSuggestions");
            return new StoreState(showContactSyncIcon, showContactSyncUpsell, channelId, relationshipsState, users, presences, applicationStreams, friendSuggestions);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return this.showContactSyncIcon == storeState.showContactSyncIcon && this.showContactSyncUpsell == storeState.showContactSyncUpsell && this.channelId == storeState.channelId && Intrinsics3.areEqual(this.relationshipsState, storeState.relationshipsState) && Intrinsics3.areEqual(this.users, storeState.users) && Intrinsics3.areEqual(this.presences, storeState.presences) && Intrinsics3.areEqual(this.applicationStreams, storeState.applicationStreams) && Intrinsics3.areEqual(this.friendSuggestions, storeState.friendSuggestions);
        }

        public final Map<Long, ModelApplicationStream> getApplicationStreams() {
            return this.applicationStreams;
        }

        public final long getChannelId() {
            return this.channelId;
        }

        public final Map<Long, FriendSuggestion> getFriendSuggestions() {
            return this.friendSuggestions;
        }

        public final Map<Long, Presence> getPresences() {
            return this.presences;
        }

        public final StoreUserRelationships.UserRelationshipsState getRelationshipsState() {
            return this.relationshipsState;
        }

        public final boolean getShowContactSyncIcon() {
            return this.showContactSyncIcon;
        }

        public final boolean getShowContactSyncUpsell() {
            return this.showContactSyncUpsell;
        }

        public final Map<Long, User> getUsers() {
            return this.users;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v22 */
        /* JADX WARN: Type inference failed for: r0v23 */
        public int hashCode() {
            boolean z2 = this.showContactSyncIcon;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            boolean z3 = this.showContactSyncUpsell;
            int iA = (b.a(this.channelId) + ((i + (z3 ? 1 : z3 ? 1 : 0)) * 31)) * 31;
            StoreUserRelationships.UserRelationshipsState userRelationshipsState = this.relationshipsState;
            int iHashCode = (iA + (userRelationshipsState != null ? userRelationshipsState.hashCode() : 0)) * 31;
            Map<Long, User> map = this.users;
            int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
            Map<Long, Presence> map2 = this.presences;
            int iHashCode3 = (iHashCode2 + (map2 != null ? map2.hashCode() : 0)) * 31;
            Map<Long, ModelApplicationStream> map3 = this.applicationStreams;
            int iHashCode4 = (iHashCode3 + (map3 != null ? map3.hashCode() : 0)) * 31;
            Map<Long, FriendSuggestion> map4 = this.friendSuggestions;
            return iHashCode4 + (map4 != null ? map4.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(showContactSyncIcon=");
            sbU.append(this.showContactSyncIcon);
            sbU.append(", showContactSyncUpsell=");
            sbU.append(this.showContactSyncUpsell);
            sbU.append(", channelId=");
            sbU.append(this.channelId);
            sbU.append(", relationshipsState=");
            sbU.append(this.relationshipsState);
            sbU.append(", users=");
            sbU.append(this.users);
            sbU.append(", presences=");
            sbU.append(this.presences);
            sbU.append(", applicationStreams=");
            sbU.append(this.applicationStreams);
            sbU.append(", friendSuggestions=");
            return outline.M(sbU, this.friendSuggestions, ")");
        }
    }

    /* compiled from: FriendsListViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/discord/widgets/friends/FriendsListViewModel$ViewState;", "", "<init>", "()V", "Empty", "Loaded", "Uninitialized", "Lcom/discord/widgets/friends/FriendsListViewModel$ViewState$Uninitialized;", "Lcom/discord/widgets/friends/FriendsListViewModel$ViewState$Empty;", "Lcom/discord/widgets/friends/FriendsListViewModel$ViewState$Loaded;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        /* compiled from: FriendsListViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/discord/widgets/friends/FriendsListViewModel$ViewState$Empty;", "Lcom/discord/widgets/friends/FriendsListViewModel$ViewState;", "", "component1", "()Z", "showContactSyncIcon", "copy", "(Z)Lcom/discord/widgets/friends/FriendsListViewModel$ViewState$Empty;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getShowContactSyncIcon", "<init>", "(Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Empty extends ViewState {
            private final boolean showContactSyncIcon;

            public Empty(boolean z2) {
                super(null);
                this.showContactSyncIcon = z2;
            }

            public static /* synthetic */ Empty copy$default(Empty empty, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    z2 = empty.showContactSyncIcon;
                }
                return empty.copy(z2);
            }

            /* renamed from: component1, reason: from getter */
            public final boolean getShowContactSyncIcon() {
                return this.showContactSyncIcon;
            }

            public final Empty copy(boolean showContactSyncIcon) {
                return new Empty(showContactSyncIcon);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Empty) && this.showContactSyncIcon == ((Empty) other).showContactSyncIcon;
                }
                return true;
            }

            public final boolean getShowContactSyncIcon() {
                return this.showContactSyncIcon;
            }

            public int hashCode() {
                boolean z2 = this.showContactSyncIcon;
                if (z2) {
                    return 1;
                }
                return z2 ? 1 : 0;
            }

            public String toString() {
                return outline.O(outline.U("Empty(showContactSyncIcon="), this.showContactSyncIcon, ")");
            }
        }

        /* compiled from: FriendsListViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\bR\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004¨\u0006\u001d"}, d2 = {"Lcom/discord/widgets/friends/FriendsListViewModel$ViewState$Loaded;", "Lcom/discord/widgets/friends/FriendsListViewModel$ViewState;", "", "component1", "()Z", "", "Lcom/discord/widgets/friends/FriendsListViewModel$Item;", "component2", "()Ljava/util/List;", "showContactSyncIcon", "items", "copy", "(ZLjava/util/List;)Lcom/discord/widgets/friends/FriendsListViewModel$ViewState$Loaded;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getItems", "Z", "getShowContactSyncIcon", "<init>", "(ZLjava/util/List;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Loaded extends ViewState {
            private final List<Item> items;
            private final boolean showContactSyncIcon;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Loaded(boolean z2, List<? extends Item> list) {
                super(null);
                Intrinsics3.checkNotNullParameter(list, "items");
                this.showContactSyncIcon = z2;
                this.items = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, boolean z2, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    z2 = loaded.showContactSyncIcon;
                }
                if ((i & 2) != 0) {
                    list = loaded.items;
                }
                return loaded.copy(z2, list);
            }

            /* renamed from: component1, reason: from getter */
            public final boolean getShowContactSyncIcon() {
                return this.showContactSyncIcon;
            }

            public final List<Item> component2() {
                return this.items;
            }

            public final Loaded copy(boolean showContactSyncIcon, List<? extends Item> items) {
                Intrinsics3.checkNotNullParameter(items, "items");
                return new Loaded(showContactSyncIcon, items);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return this.showContactSyncIcon == loaded.showContactSyncIcon && Intrinsics3.areEqual(this.items, loaded.items);
            }

            public final List<Item> getItems() {
                return this.items;
            }

            public final boolean getShowContactSyncIcon() {
                return this.showContactSyncIcon;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [int] */
            /* JADX WARN: Type inference failed for: r0v4 */
            /* JADX WARN: Type inference failed for: r0v5 */
            public int hashCode() {
                boolean z2 = this.showContactSyncIcon;
                ?? r0 = z2;
                if (z2) {
                    r0 = 1;
                }
                int i = r0 * 31;
                List<Item> list = this.items;
                return i + (list != null ? list.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(showContactSyncIcon=");
                sbU.append(this.showContactSyncIcon);
                sbU.append(", items=");
                return outline.L(sbU, this.items, ")");
            }
        }

        /* compiled from: FriendsListViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/friends/FriendsListViewModel$ViewState$Uninitialized;", "Lcom/discord/widgets/friends/FriendsListViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
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

    /* compiled from: FriendsListViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.friends.FriendsListViewModel$acceptFriendRequest$1, reason: invalid class name */
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
        public final void invoke2(Void r2) {
            FriendsListViewModel.access$emitShowToastEvent(FriendsListViewModel.this, R.string.accept_request_button_after);
        }
    }

    /* compiled from: FriendsListViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "error", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.friends.FriendsListViewModel$acceptFriendRequest$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ String $username;

        /* compiled from: FriendsListViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.friends.FriendsListViewModel$acceptFriendRequest$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ Error $error;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Error error) {
                super(0);
                this.$error = error;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                FriendsListViewModel friendsListViewModel = FriendsListViewModel.this;
                Error.Response response = this.$error.getResponse();
                Intrinsics3.checkNotNullExpressionValue(response, "error.response");
                FriendsListViewModel.access$emitShowFriendRequestAbortToast(friendsListViewModel, response.getCode(), AnonymousClass2.this.$username);
            }
        }

        /* compiled from: FriendsListViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.friends.FriendsListViewModel$acceptFriendRequest$2$2, reason: invalid class name and collision with other inner class name */
        public static final class C02892 extends Lambda implements Function0<Boolean> {
            public C02892() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Boolean invoke() {
                return Boolean.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2() {
                FriendsListViewModel.access$emitShowToastEvent(FriendsListViewModel.this, R.string.default_failure_to_perform_action_message);
                return false;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str) {
            super(1);
            this.$username = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "error");
            RestAPIAbortMessages.INSTANCE.handleAbortCodeOrDefault(error, new AnonymousClass1(error), new C02892());
        }
    }

    /* compiled from: FriendsListViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.friends.FriendsListViewModel$acceptFriendSuggestion$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
        }
    }

    /* compiled from: FriendsListViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "error", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.friends.FriendsListViewModel$acceptFriendSuggestion$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ int $discriminator;
        public final /* synthetic */ String $username;

        /* compiled from: FriendsListViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.friends.FriendsListViewModel$acceptFriendSuggestion$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ Error $error;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Error error) {
                super(0);
                this.$error = error;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                if (WidgetCaptcha4.isCaptchaError(this.$error)) {
                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                    FriendsListViewModel.access$emitCaptchaErrorEvent(FriendsListViewModel.this, this.$error, anonymousClass2.$username, anonymousClass2.$discriminator);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str, int i) {
            super(1);
            this.$username = str;
            this.$discriminator = i;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "error");
            RestAPIAbortMessages.handleAbortCodeOrDefault$default(RestAPIAbortMessages.INSTANCE, error, new AnonymousClass1(error), null, 4, null);
        }
    }

    /* compiled from: FriendsListViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002*\u0010\u0003\u001a&\u0012\f\u0012\n \u0002*\u0004\u0018\u00018\u00008\u0000 \u0002*\u0012\u0012\f\u0012\n \u0002*\u0004\u0018\u00018\u00008\u0000\u0018\u00010\u00010\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lrx/Emitter;", "kotlin.jvm.PlatformType", "emitter", "", NotificationCompat.CATEGORY_CALL, "(Lrx/Emitter;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.friends.FriendsListViewModel$asyncComputeAndHandleOnUiThread$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Action1<Emitter<T>> {
        public final /* synthetic */ Function0 $compute;

        public AnonymousClass1(Function0 function0) {
            this.$compute = function0;
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((Emitter) obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void call(Emitter<T> emitter) {
            emitter.onNext(this.$compute.invoke());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: FriendsListViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "kotlin.jvm.PlatformType", "it", "", "invoke", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.friends.FriendsListViewModel$asyncComputeAndHandleOnUiThread$2, reason: invalid class name */
    public static final class AnonymousClass2<T> extends Lambda implements Function1<T, Unit> {
        public final /* synthetic */ Function1 $onSuccess;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Function1 function1) {
            super(1);
            this.$onSuccess = function1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            invoke2((AnonymousClass2<T>) obj);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(T t) {
            this.$onSuccess.invoke(t);
        }
    }

    /* compiled from: FriendsListViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.friends.FriendsListViewModel$asyncComputeAndHandleOnUiThread$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ Function1 $onError;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(Function1 function1) {
            super(1);
            this.$onError = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            Function1 function1 = this.$onError;
            if (function1 != null) {
            }
        }
    }

    /* compiled from: FriendsListViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lrx/Subscription;", "it", "", "invoke", "(Lrx/Subscription;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.friends.FriendsListViewModel$asyncComputeAndHandleOnUiThread$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements Function1<Subscription, Unit> {
        public final /* synthetic */ Ref$ObjectRef $subscription;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(Ref$ObjectRef ref$ObjectRef) {
            super(1);
            this.$subscription = ref$ObjectRef;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, "it");
            this.$subscription.element = subscription;
        }
    }

    /* compiled from: FriendsListViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "cancel", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.friends.FriendsListViewModel$asyncComputeAndHandleOnUiThread$5, reason: invalid class name */
    public static final class AnonymousClass5 implements Cancellable {
        public final /* synthetic */ Ref$ObjectRef $subscription;

        public AnonymousClass5(Ref$ObjectRef ref$ObjectRef) {
            this.$subscription = ref$ObjectRef;
        }

        @Override // rx.functions.Cancellable
        public final void cancel() {
            Subscription subscription = (Subscription) this.$subscription.element;
            if (subscription != null) {
                subscription.unsubscribe();
            }
        }
    }

    /* compiled from: FriendsListViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/discord/primitives/RelationshipType;", "relationshipType", "", "invoke", "(I)Z", "isPendingInvite"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.friends.FriendsListViewModel$getItems$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<Integer, Boolean> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
            return Boolean.valueOf(invoke(num.intValue()));
        }

        public final boolean invoke(int i) {
            return Sets5.setOf((Object[]) new Integer[]{3, 4}).contains(Integer.valueOf(i));
        }
    }

    /* compiled from: FriendsListViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/friends/FriendsListViewModel$ListSections;", "invoke", "()Lcom/discord/widgets/friends/FriendsListViewModel$ListSections;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.friends.FriendsListViewModel$handleStoreState$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<ListSections> {
        public final /* synthetic */ Map $relationships;
        public final /* synthetic */ StoreState $storeState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Map map, StoreState storeState) {
            super(0);
            this.$relationships = map;
            this.$storeState = storeState;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ ListSections invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ListSections invoke() {
            return FriendsListViewModel.access$getItems(FriendsListViewModel.this, this.$relationships, this.$storeState.getUsers(), this.$storeState.getPresences(), this.$storeState.getApplicationStreams(), this.$storeState.getShowContactSyncUpsell(), this.$storeState.getFriendSuggestions());
        }
    }

    /* compiled from: FriendsListViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/friends/FriendsListViewModel$ListSections;", "it", "", "invoke", "(Lcom/discord/widgets/friends/FriendsListViewModel$ListSections;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.friends.FriendsListViewModel$handleStoreState$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<ListSections, Unit> {
        public final /* synthetic */ StoreState $storeState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(StoreState storeState) {
            super(1);
            this.$storeState = storeState;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ListSections listSections) {
            invoke2(listSections);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ListSections listSections) {
            Intrinsics3.checkNotNullParameter(listSections, "it");
            FriendsListViewModel.access$handleComputedItems(FriendsListViewModel.this, listSections, this.$storeState.getShowContactSyncIcon());
        }
    }

    /* compiled from: FriendsListViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.friends.FriendsListViewModel$ignoreSuggestion$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
        }
    }

    /* compiled from: FriendsListViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/channel/Channel;", "channel", "", "invoke", "(Lcom/discord/api/channel/Channel;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.friends.FriendsListViewModel$launchVoiceCall$1, reason: invalid class name */
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
            FriendsListViewModel.access$emitLaunchVoiceCallEvent(FriendsListViewModel.this, channel.getId());
        }
    }

    /* compiled from: FriendsListViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.friends.FriendsListViewModel$launchVoiceCall$2, reason: invalid class name */
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
            FriendsListViewModel.access$emitShowToastEvent(FriendsListViewModel.this, R.string.default_failure_to_perform_action_message);
        }
    }

    /* compiled from: FriendsListViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.friends.FriendsListViewModel$removeFriendRequest$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
        public final /* synthetic */ int $successMessageStringRes;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(int i) {
            super(1);
            this.$successMessageStringRes = i;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r2) {
            FriendsListViewModel.access$emitShowToastEvent(FriendsListViewModel.this, this.$successMessageStringRes);
        }
    }

    /* compiled from: FriendsListViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.friends.FriendsListViewModel$removeFriendRequest$2, reason: invalid class name */
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
            FriendsListViewModel.access$emitShowToastEvent(FriendsListViewModel.this, R.string.default_failure_to_perform_action_message);
        }
    }

    public FriendsListViewModel() {
        this(null, null, null, 7, null);
    }

    public /* synthetic */ FriendsListViewModel(Observable observable, StoreChannels storeChannels, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? INSTANCE.observeStores() : observable, (i & 2) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels, (i & 4) != 0 ? RestAPI.INSTANCE.getApi() : restAPI);
    }

    public static /* synthetic */ void acceptFriendSuggestion$default(FriendsListViewModel friendsListViewModel, String str, int i, CaptchaHelper.CaptchaPayload captchaPayload, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            captchaPayload = null;
        }
        friendsListViewModel.acceptFriendSuggestion(str, i, captchaPayload);
    }

    public static final /* synthetic */ void access$emitCaptchaErrorEvent(FriendsListViewModel friendsListViewModel, Error error, String str, int i) {
        friendsListViewModel.emitCaptchaErrorEvent(error, str, i);
    }

    public static final /* synthetic */ void access$emitLaunchVoiceCallEvent(FriendsListViewModel friendsListViewModel, long j) {
        friendsListViewModel.emitLaunchVoiceCallEvent(j);
    }

    public static final /* synthetic */ void access$emitShowFriendRequestAbortToast(FriendsListViewModel friendsListViewModel, int i, String str) {
        friendsListViewModel.emitShowFriendRequestAbortToast(i, str);
    }

    public static final /* synthetic */ void access$emitShowToastEvent(FriendsListViewModel friendsListViewModel, int i) {
        friendsListViewModel.emitShowToastEvent(i);
    }

    public static final /* synthetic */ ListSections access$getItems(FriendsListViewModel friendsListViewModel, Map map, Map map2, Map map3, Map map4, boolean z2, Map map5) {
        return friendsListViewModel.getItems(map, map2, map3, map4, z2, map5);
    }

    public static final /* synthetic */ void access$handleComputedItems(FriendsListViewModel friendsListViewModel, ListSections listSections, boolean z2) {
        friendsListViewModel.handleComputedItems(listSections, z2);
    }

    public static final /* synthetic */ void access$handleStoreState(FriendsListViewModel friendsListViewModel, StoreState storeState) throws Exception {
        friendsListViewModel.handleStoreState(storeState);
    }

    private final <T> Cancellable asyncComputeAndHandleOnUiThread(Function0<? extends T> compute, Function1<? super Error, Unit> onError, Function1<? super T, Unit> onSuccess) {
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = null;
        Observable<T> observableX = Observable.o(new AnonymousClass1(compute), Emitter.BackpressureMode.NONE).X(Schedulers2.a());
        Intrinsics3.checkNotNullExpressionValue(observableX, "Observable\n        .crea…Schedulers.computation())");
        Observable observableUi$default = ObservableExtensionsKt.ui$default(observableX, this, null, 2, null);
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(onSuccess);
        ObservableExtensionsKt.appSubscribe$default(observableUi$default, FriendsListViewModel.class, (Context) null, new AnonymousClass4(ref$ObjectRef), new AnonymousClass3(onError), (Function0) null, (Function0) null, anonymousClass2, 50, (Object) null);
        return new AnonymousClass5(ref$ObjectRef);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Cancellable asyncComputeAndHandleOnUiThread$default(FriendsListViewModel friendsListViewModel, Function0 function0, Function1 function1, Function1 function12, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        return friendsListViewModel.asyncComputeAndHandleOnUiThread(function0, function1, function12);
    }

    private final void emitCaptchaErrorEvent(Error error, String username, int discriminator) {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new Event.CaptchaError(error, username, discriminator));
    }

    private final void emitLaunchVoiceCallEvent(long channelId) {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new Event.LaunchVoiceCall(channelId));
    }

    private final void emitShowFriendRequestAbortToast(int abortCode, String username) {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new Event.ShowFriendRequestErrorToast(abortCode, username));
    }

    private final void emitShowToastEvent(@StringRes int stringRes) {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new Event.ShowToast(stringRes));
    }

    @MainThread
    private final void generateLoadedItems(boolean showContactSyncIcon) {
        Item.SuggestedFriendsHeader suggestionsHeaderItem = this.listSections.getSuggestionsHeaderItem();
        Item.SuggestedFriendsHeader suggestedFriendsHeaderCopy$default = suggestionsHeaderItem != null ? Item.SuggestedFriendsHeader.copy$default(suggestionsHeaderItem, 0, this.isSuggestedSectionExpanded, false, 5, null) : null;
        Item.PendingHeader pendingHeaderItem = this.listSections.getPendingHeaderItem();
        ListSections listSectionsCopy$default = ListSections.copy$default(this.listSections, suggestedFriendsHeaderCopy$default, null, pendingHeaderItem != null ? Item.PendingHeader.copy$default(pendingHeaderItem, 0, 0, this.isPendingSectionExpanded, false, 11, null) : null, null, null, null, 58, null);
        this.listSections = listSectionsCopy$default;
        List<Item> visibleItems = getVisibleItems(listSectionsCopy$default);
        updateViewState(visibleItems.isEmpty() ^ true ? new ViewState.Loaded(showContactSyncIcon, visibleItems) : new ViewState.Empty(showContactSyncIcon));
    }

    public static /* synthetic */ void generateLoadedItems$default(FriendsListViewModel friendsListViewModel, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        friendsListViewModel.generateLoadedItems(z2);
    }

    private final ListSections getItems(Map<Long, Integer> relationships, Map<Long, ? extends User> users, Map<Long, Presence> presences, Map<Long, ? extends ModelApplicationStream> applicationStreams, boolean showContactSyncUpsell, Map<Long, FriendSuggestion> friendSuggestions) {
        ArrayList arrayList = new ArrayList();
        if (!friendSuggestions.isEmpty()) {
            Iterator<T> it = friendSuggestions.values().iterator();
            while (it.hasNext()) {
                arrayList.add(new Item.SuggestedFriend((FriendSuggestion) it.next()));
            }
            if (arrayList.size() > 1) {
                MutableCollectionsJVM.sortWith(arrayList, new FriendsListViewModel$getItems$$inlined$sortBy$1());
            }
        }
        Item.SuggestedFriendsHeader suggestedFriendsHeader = !arrayList.isEmpty() ? new Item.SuggestedFriendsHeader(arrayList.size(), false, arrayList.size() > 2) : null;
        AnonymousClass3 anonymousClass3 = AnonymousClass3.INSTANCE;
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (Map.Entry entry : _Maps.asSequence(relationships)) {
            long jLongValue = ((Number) entry.getKey()).longValue();
            int iIntValue = ((Number) entry.getValue()).intValue();
            User user = users.get(Long.valueOf(jLongValue));
            int type = ModelUserRelationship.getType(Integer.valueOf(iIntValue));
            Presence presence = presences.get(Long.valueOf(jLongValue));
            boolean zContainsKey = applicationStreams.containsKey(Long.valueOf(jLongValue));
            if (user != null && type != 2) {
                if (AnonymousClass3.INSTANCE.invoke(type)) {
                    arrayList2.add(new Item.PendingFriendRequest(user, presence, type));
                } else {
                    arrayList3.add(new Item.Friend(user, presence, zContainsKey));
                }
            }
        }
        List list = _Collections.toList(_Collections.sortedWith(arrayList2, FriendsListViewModel5.INSTANCE));
        Item.PendingHeader pendingHeader = !list.isEmpty() ? new Item.PendingHeader(R.string.friends_pending_request_header, list.size(), false, list.size() > 2) : null;
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        for (Object obj : arrayList3) {
            if (((Item.Friend) obj).isOnline()) {
                arrayList5.add(obj);
            }
        }
        List list2 = _Collections.toList(_Collections.sortedWith(arrayList5, FriendsListViewModel4.INSTANCE));
        if (!list2.isEmpty()) {
            arrayList4.add(new Item.Header(R.string.friends_online_header, list2.size()));
            arrayList4.addAll(list2);
        }
        ArrayList arrayList6 = new ArrayList();
        for (Object obj2 : arrayList3) {
            if (!((Item.Friend) obj2).isOnline()) {
                arrayList6.add(obj2);
            }
        }
        List list3 = _Collections.toList(_Collections.sortedWith(arrayList6, FriendsListViewModel3.INSTANCE));
        if (true ^ list3.isEmpty()) {
            arrayList4.add(new Item.Header(R.string.friends_offline_header, list3.size()));
            arrayList4.addAll(list3);
        }
        return new ListSections(suggestedFriendsHeader, arrayList, pendingHeader, list, arrayList4, showContactSyncUpsell ? new Item.ContactSyncUpsell(false) : null);
    }

    private final List<Item> getVisibleItems(ListSections listSections) {
        Item.SuggestedFriendsHeader suggestionsHeaderItem = listSections.getSuggestionsHeaderItem();
        List<Item.SuggestedFriend> suggestedFriendItems = listSections.getSuggestedFriendItems();
        Item.PendingHeader pendingHeaderItem = listSections.getPendingHeaderItem();
        List<Item> pendingItems = listSections.getPendingItems();
        List<Item> friendsItemsWithHeaders = listSections.getFriendsItemsWithHeaders();
        ArrayList arrayList = new ArrayList();
        if (listSections.getContactSyncUpsell() != null) {
            arrayList.add(listSections.getContactSyncUpsell());
        }
        if (!this.isSuggestedSectionExpanded) {
            suggestedFriendItems = _Collections.take(suggestedFriendItems, 2);
        }
        if (suggestionsHeaderItem != null && (!suggestedFriendItems.isEmpty())) {
            arrayList.add(suggestionsHeaderItem);
            arrayList.addAll(suggestedFriendItems);
        }
        if (!this.isPendingSectionExpanded) {
            pendingItems = _Collections.take(pendingItems, 2);
        }
        if (pendingHeaderItem != null && (!pendingItems.isEmpty())) {
            arrayList.add(pendingHeaderItem);
            arrayList.addAll(pendingItems);
        }
        arrayList.addAll(friendsItemsWithHeaders);
        return arrayList;
    }

    @MainThread
    private final void handleComputedItems(ListSections listSections, boolean showContactSyncIcon) {
        this.listSections = listSections;
        generateLoadedItems(showContactSyncIcon);
    }

    private final void handleStoreState(StoreState storeState) throws Exception {
        Cancellable cancellable = this.computeItemJob;
        if (cancellable != null) {
            cancellable.cancel();
        }
        if (!(storeState.getRelationshipsState() instanceof StoreUserRelationships.UserRelationshipsState.Loaded)) {
            updateViewState(ViewState.Uninitialized.INSTANCE);
            return;
        }
        Map<Long, Integer> relationships = ((StoreUserRelationships.UserRelationshipsState.Loaded) storeState.getRelationshipsState()).getRelationships();
        if (relationships.isEmpty()) {
            updateViewState(new ViewState.Empty(storeState.getShowContactSyncIcon() || storeState.getShowContactSyncUpsell()));
        } else {
            this.computeItemJob = asyncComputeAndHandleOnUiThread$default(this, new AnonymousClass1(relationships, storeState), null, new AnonymousClass2(storeState), 2, null);
        }
    }

    public final void acceptFriendRequest(long userId, String username) {
        Intrinsics3.checkNotNullParameter(username, "username");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.addRelationship$default(this.restAPI, LOCATION, userId, null, null, null, 28, null), false, 1, null), this, null, 2, null), FriendsListViewModel.class, (Context) null, (Function1) null, new AnonymousClass2(username), (Function0) null, (Function0) null, new AnonymousClass1(), 54, (Object) null);
    }

    public final void acceptFriendSuggestion(String username, int discriminator, CaptchaHelper.CaptchaPayload captchaPayload) {
        Intrinsics3.checkNotNullParameter(username, "username");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().sendRelationshipRequest("Friends List - Friend Suggestion", username, discriminator, captchaPayload), false, 1, null), this, null, 2, null), FriendsListViewModel.class, (Context) null, (Function1) null, new AnonymousClass2(username, discriminator), (Function0) null, (Function0) null, AnonymousClass1.INSTANCE, 54, (Object) null);
    }

    @MainThread
    public final void dismissContactSyncUpsell() {
        StoreStream.INSTANCE.getContactSync().dismissFriendsListUpsell();
    }

    public final RestAPI getRestAPI() {
        return this.restAPI;
    }

    public final StoreChannels getStoreChannels() {
        return this.storeChannels;
    }

    public final Observable<StoreState> getStoreObservable() {
        return this.storeObservable;
    }

    @MainThread
    public final void handleClickPendingHeader() {
        this.isPendingSectionExpanded = !this.isPendingSectionExpanded;
        ViewState viewState = getViewState();
        generateLoadedItems(viewState instanceof ViewState.Empty ? ((ViewState.Empty) viewState).getShowContactSyncIcon() : viewState instanceof ViewState.Loaded ? ((ViewState.Loaded) viewState).getShowContactSyncIcon() : false);
    }

    @MainThread
    public final void handleClickSuggestedHeader() {
        this.isSuggestedSectionExpanded = !this.isSuggestedSectionExpanded;
        ViewState viewState = getViewState();
        generateLoadedItems(viewState instanceof ViewState.Empty ? ((ViewState.Empty) viewState).getShowContactSyncIcon() : viewState instanceof ViewState.Loaded ? ((ViewState.Loaded) viewState).getShowContactSyncIcon() : false);
    }

    public final void ignoreSuggestion(long userId) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.ignoreFriendSuggestion(userId), false, 1, null), this, null, 2, null), FriendsListViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, AnonymousClass1.INSTANCE, 62, (Object) null);
    }

    public final void launchVoiceCall(long userId) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.createOrFetchDM(userId), false, 1, null), this, null, 2, null), FriendsListViewModel.class, (Context) null, (Function1) null, new AnonymousClass2(), (Function0) null, (Function0) null, new AnonymousClass1(), 54, (Object) null);
    }

    @MainThread
    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void removeFriendRequest(long userId, int relationshipType) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.removeRelationship(LOCATION, userId), false, 1, null), this, null, 2, null), FriendsListViewModel.class, (Context) null, (Function1) null, new AnonymousClass2(), (Function0) null, (Function0) null, new AnonymousClass1(relationshipType == 3 ? R.string.friend_request_ignored : R.string.friend_request_cancelled), 54, (Object) null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FriendsListViewModel(Observable<StoreState> observable, StoreChannels storeChannels, RestAPI restAPI) {
        super(ViewState.Uninitialized.INSTANCE);
        Intrinsics3.checkNotNullParameter(observable, "storeObservable");
        Intrinsics3.checkNotNullParameter(storeChannels, "storeChannels");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        this.storeObservable = observable;
        this.storeChannels = storeChannels;
        this.restAPI = restAPI;
        this.listSections = new ListSections(null, Collections2.emptyList(), null, Collections2.emptyList(), Collections2.emptyList(), null);
        this.eventSubject = PublishSubject.k0();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), FriendsListViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
