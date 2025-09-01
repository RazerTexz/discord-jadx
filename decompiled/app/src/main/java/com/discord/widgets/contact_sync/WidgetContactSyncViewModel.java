package com.discord.widgets.contact_sync;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionUserBulkRelationshipsUpdate;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionUserConnectionsUpdate;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionUserContactsSync;
import com.discord.analytics.generated.traits.TrackNetworkMetadata2;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.api.friendsuggestions.AllowedInSuggestionsType;
import com.discord.api.friendsuggestions.BulkAddFriendsResponse;
import com.discord.api.friendsuggestions.BulkFriendSuggestions;
import com.discord.api.friendsuggestions.FriendSuggestion;
import com.discord.api.friendsuggestions.FriendSuggestionReason;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelUserSettings;
import com.discord.models.phone.PhoneCountryCode;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StorePhone;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserConnections;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.stores.utilities.RestCallState5;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.error.Error;
import com.discord.utilities.features.GrowthTeamFeatures;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.ClockFactory;
import com.discord.widgets.captcha.WidgetCaptcha4;
import com.discord.widgets.user.phone.WidgetUserPhoneManage;
import d0.Tuples;
import d0.g0.Strings4;
import d0.g0.StringsJVM;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: WidgetContactSyncViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \\2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0007\\]^_`abBe\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\b\b\u0002\u0010,\u001a\u00020+\u0012\b\b\u0002\u0010-\u001a\u00020+\u0012\b\b\u0002\u0010W\u001a\u00020V\u0012\u000e\b\u0002\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00180\"\u0012\b\b\u0002\u0010N\u001a\u00020M\u0012\b\b\u0002\u0010H\u001a\u00020+\u0012\u0012\u0010K\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030J¢\u0006\u0004\bZ\u0010[J\u000f\u0010\u0004\u001a\u00020\u0003H\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0003¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\u000e\u0010\tJ\u0017\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000fH\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\u0013\u0010\tJ\u000f\u0010\u0014\u001a\u00020\u0003H\u0003¢\u0006\u0004\b\u0014\u0010\u0005J\u000f\u0010\u0015\u001a\u00020\u0003H\u0003¢\u0006\u0004\b\u0015\u0010\u0005J\u000f\u0010\u0016\u001a\u00020\u0003H\u0003¢\u0006\u0004\b\u0016\u0010\u0005J\u0017\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\u0017\u0010\tJ\u0017\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001c\u0010\u0005J\u0017\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b \u0010!J\u0013\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\"¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0003H\u0007¢\u0006\u0004\b&\u0010\u0005J\u000f\u0010'\u001a\u00020\u0003H\u0007¢\u0006\u0004\b'\u0010\u0005J\u000f\u0010(\u001a\u00020\u0003H\u0007¢\u0006\u0004\b(\u0010\u0005J\u000f\u0010)\u001a\u00020\u0003H\u0007¢\u0006\u0004\b)\u0010\u0005J\u000f\u0010*\u001a\u00020\u0003H\u0007¢\u0006\u0004\b*\u0010\u0005J\u001f\u0010.\u001a\u00020\u00032\u0006\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020+H\u0007¢\u0006\u0004\b.\u0010/J#\u00104\u001a\u00020\u00032\n\u00102\u001a\u000600j\u0002`12\u0006\u00103\u001a\u00020+H\u0007¢\u0006\u0004\b4\u00105J\u0017\u00108\u001a\u00020\u00032\u0006\u00107\u001a\u000206H\u0007¢\u0006\u0004\b8\u00109J\u001d\u0010<\u001a\u00020\u00032\f\u0010;\u001a\b\u0012\u0004\u0012\u0002060:H\u0007¢\u0006\u0004\b<\u0010=J\u000f\u0010>\u001a\u00020\u0003H\u0007¢\u0006\u0004\b>\u0010\u0005J\u000f\u0010?\u001a\u00020\u0003H\u0007¢\u0006\u0004\b?\u0010\u0005J!\u0010C\u001a\u00020\u00032\u0006\u0010@\u001a\u0002062\b\u0010B\u001a\u0004\u0018\u00010AH\u0007¢\u0006\u0004\bC\u0010DJ\u0017\u0010F\u001a\u00020\u00032\u0006\u0010E\u001a\u000206H\u0007¢\u0006\u0004\bF\u00109J\r\u0010G\u001a\u00020\u0003¢\u0006\u0004\bG\u0010\u0005R\u0016\u0010H\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\"\u0010K\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030J8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u0019\u0010N\u001a\u00020M8\u0006@\u0006¢\u0006\f\n\u0004\bN\u0010O\u001a\u0004\bP\u0010QR:\u0010T\u001a&\u0012\f\u0012\n S*\u0004\u0018\u00010#0# S*\u0012\u0012\f\u0012\n S*\u0004\u0018\u00010#0#\u0018\u00010R0R8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010W\u001a\u00020V8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010X¨\u0006c"}, d2 = {"Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$ViewState;", "", "handleContactsEnabled", "()V", "Lcom/discord/utilities/error/Error;", "error", "handleContactsEnableError", "(Lcom/discord/utilities/error/Error;)V", "Lcom/discord/api/friendsuggestions/BulkFriendSuggestions;", "suggestions", "handleFriendSuggestions", "(Lcom/discord/api/friendsuggestions/BulkFriendSuggestions;)V", "handleUploadError", "Lcom/discord/api/friendsuggestions/BulkAddFriendsResponse;", "result", "handleFriendsAdded", "(Lcom/discord/api/friendsuggestions/BulkAddFriendsResponse;)V", "handleFriendsAddedError", "handlePhoneSubmitted", "handlePhoneSubmittedError", "handlePhoneVerified", "handlePhoneVerifiedError", "Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$StoreState;", "storeState", "handleStoreState", "(Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$StoreState;)V", "handleComplete", "Lcom/discord/widgets/contact_sync/ContactSyncMode;", "mode", "Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$ToolbarConfig;", "getLandingToolbarConfig", "(Lcom/discord/widgets/contact_sync/ContactSyncMode;)Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$ToolbarConfig;", "Lrx/Observable;", "Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$Event;", "observeEvents", "()Lrx/Observable;", "onLandingNext", "requestingPermissions", "onPermissionsGranted", "onPermissionsBecameAvailable", "onPermissionsDenied", "", "allowPhone", "allowEmail", "onPermissionsToggle", "(ZZ)V", "", "Lcom/discord/primitives/UserId;", "userId", "isSelected", "handleToggleFriendSuggestionSelected", "(JZ)V", "", ModelAuditLogEntry.CHANGE_KEY_NAME, "onNameSubmitted", "(Ljava/lang/String;)V", "", "contactNumbers", "onContactsFetched", "(Ljava/util/Set;)V", "onBulkAddFriends", "dismissUpsell", "phoneNumber", "Lcom/discord/utilities/captcha/CaptchaHelper$CaptchaPayload;", "captchaPayload", "onPhoneNumberSubmitted", "(Ljava/lang/String;Lcom/discord/utilities/captcha/CaptchaHelper$CaptchaPayload;)V", ModelAuditLogEntry.CHANGE_KEY_CODE, "onVerifyPhone", "skip", "initialized", "Z", "Lkotlin/Function1;", "captchaLauncher", "Lkotlin/jvm/functions/Function1;", "Lcom/discord/widgets/contact_sync/ContactSyncFlowAnalytics;", "tracker", "Lcom/discord/widgets/contact_sync/ContactSyncFlowAnalytics;", "getTracker", "()Lcom/discord/widgets/contact_sync/ContactSyncFlowAnalytics;", "Lrx/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "eventsSubject", "Lrx/subjects/PublishSubject;", "Lcom/discord/utilities/rest/RestAPI;", "restAPI", "Lcom/discord/utilities/rest/RestAPI;", "storeObservable", "<init>", "(Lcom/discord/widgets/contact_sync/ContactSyncMode;ZZLcom/discord/utilities/rest/RestAPI;Lrx/Observable;Lcom/discord/widgets/contact_sync/ContactSyncFlowAnalytics;ZLkotlin/jvm/functions/Function1;)V", "Companion", "Event", "Item", "StoreState", "ToolbarConfig", "ViewState", "Views", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetContactSyncViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Function1<Error, Unit> captchaLauncher;
    private final PublishSubject<Event> eventsSubject;
    private boolean initialized;
    private final RestAPI restAPI;
    private final ContactSyncFlowAnalytics tracker;

    /* compiled from: WidgetContactSyncViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$StoreState;", "storeState", "", "invoke", "(Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.contact_sync.WidgetContactSyncViewModel$1, reason: invalid class name */
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
            WidgetContactSyncViewModel.access$handleStoreState(WidgetContactSyncViewModel.this, storeState);
        }
    }

    /* compiled from: WidgetContactSyncViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$Companion;", "", "Lrx/Observable;", "Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$StoreState;", "observeStores", "()Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final Observable<StoreState> observeStores() {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            StoreUser users = companion.getUsers();
            StorePhone phone = companion.getPhone();
            StoreUserConnections userConnections = companion.getUserConnections();
            Observable<StoreState> observableG = ObservableExtensionsKt.leadingEdgeThrottle(ObservationDeck.connectRx$default(ObservationDeck4.get(), new ObservationDeck.UpdateSource[]{users, phone, userConnections}, false, null, null, 14, null), 1L, TimeUnit.SECONDS).G(new WidgetContactSyncViewModel2(users, phone, userConnections));
            Intrinsics3.checkNotNullExpressionValue(observableG, "ObservationDeckProvider\n…            )\n          }");
            return observableG;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetContactSyncViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\f\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b¨\u0006\u001c"}, d2 = {"Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$Event;", "", "<init>", "()V", "AddFriendsFailed", "AddFriendsFailedPartial", "Completed", "ContactsEnableFailed", "ContactsEnabled", "MaybeProceedFromLanding", "PermissionsNeeded", "PhoneInvalid", "RateLimited", "UploadFailed", "VerificationCodeInvalid", "VerificationFailed", "Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$Event$MaybeProceedFromLanding;", "Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$Event$PermissionsNeeded;", "Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$Event$ContactsEnabled;", "Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$Event$Completed;", "Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$Event$RateLimited;", "Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$Event$ContactsEnableFailed;", "Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$Event$UploadFailed;", "Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$Event$AddFriendsFailed;", "Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$Event$AddFriendsFailedPartial;", "Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$Event$PhoneInvalid;", "Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$Event$VerificationCodeInvalid;", "Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$Event$VerificationFailed;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class Event {

        /* compiled from: WidgetContactSyncViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$Event$AddFriendsFailed;", "Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class AddFriendsFailed extends Event {
            public static final AddFriendsFailed INSTANCE = new AddFriendsFailed();

            private AddFriendsFailed() {
                super(null);
            }
        }

        /* compiled from: WidgetContactSyncViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$Event$AddFriendsFailedPartial;", "Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class AddFriendsFailedPartial extends Event {
            public static final AddFriendsFailedPartial INSTANCE = new AddFriendsFailedPartial();

            private AddFriendsFailedPartial() {
                super(null);
            }
        }

        /* compiled from: WidgetContactSyncViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$Event$Completed;", "Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Completed extends Event {
            public static final Completed INSTANCE = new Completed();

            private Completed() {
                super(null);
            }
        }

        /* compiled from: WidgetContactSyncViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$Event$ContactsEnableFailed;", "Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class ContactsEnableFailed extends Event {
            public static final ContactsEnableFailed INSTANCE = new ContactsEnableFailed();

            private ContactsEnableFailed() {
                super(null);
            }
        }

        /* compiled from: WidgetContactSyncViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$Event$ContactsEnabled;", "Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class ContactsEnabled extends Event {
            public static final ContactsEnabled INSTANCE = new ContactsEnabled();

            private ContactsEnabled() {
                super(null);
            }
        }

        /* compiled from: WidgetContactSyncViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$Event$MaybeProceedFromLanding;", "Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class MaybeProceedFromLanding extends Event {
            public static final MaybeProceedFromLanding INSTANCE = new MaybeProceedFromLanding();

            private MaybeProceedFromLanding() {
                super(null);
            }
        }

        /* compiled from: WidgetContactSyncViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$Event$PermissionsNeeded;", "Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class PermissionsNeeded extends Event {
            public static final PermissionsNeeded INSTANCE = new PermissionsNeeded();

            private PermissionsNeeded() {
                super(null);
            }
        }

        /* compiled from: WidgetContactSyncViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$Event$PhoneInvalid;", "Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class PhoneInvalid extends Event {
            public static final PhoneInvalid INSTANCE = new PhoneInvalid();

            private PhoneInvalid() {
                super(null);
            }
        }

        /* compiled from: WidgetContactSyncViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$Event$RateLimited;", "Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class RateLimited extends Event {
            public static final RateLimited INSTANCE = new RateLimited();

            private RateLimited() {
                super(null);
            }
        }

        /* compiled from: WidgetContactSyncViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$Event$UploadFailed;", "Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class UploadFailed extends Event {
            public static final UploadFailed INSTANCE = new UploadFailed();

            private UploadFailed() {
                super(null);
            }
        }

        /* compiled from: WidgetContactSyncViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$Event$VerificationCodeInvalid;", "Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class VerificationCodeInvalid extends Event {
            public static final VerificationCodeInvalid INSTANCE = new VerificationCodeInvalid();

            private VerificationCodeInvalid() {
                super(null);
            }
        }

        /* compiled from: WidgetContactSyncViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$Event$VerificationFailed;", "Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class VerificationFailed extends Event {
            public static final VerificationFailed INSTANCE = new VerificationFailed();

            private VerificationFailed() {
                super(null);
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetContactSyncViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0001\n¨\u0006\u000b"}, d2 = {"Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$Item;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "", "type", "I", "getType", "()I", "<init>", "(I)V", "FriendSuggestionItem", "Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$Item$FriendSuggestionItem;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class Item implements MGRecyclerDataPayload {
        private final int type;

        /* compiled from: WidgetContactSyncViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u00020\f8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u000eR\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u001b\u001a\u0004\b\u001c\u0010\u0007¨\u0006\u001f"}, d2 = {"Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$Item$FriendSuggestionItem;", "Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$Item;", "Lcom/discord/api/friendsuggestions/FriendSuggestion;", "component1", "()Lcom/discord/api/friendsuggestions/FriendSuggestion;", "", "component2", "()Z", "suggestion", "selected", "copy", "(Lcom/discord/api/friendsuggestions/FriendSuggestion;Z)Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$Item$FriendSuggestionItem;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "key", "Ljava/lang/String;", "getKey", "Lcom/discord/api/friendsuggestions/FriendSuggestion;", "getSuggestion", "Z", "getSelected", "<init>", "(Lcom/discord/api/friendsuggestions/FriendSuggestion;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class FriendSuggestionItem extends Item {
            private final String key;
            private final boolean selected;
            private final FriendSuggestion suggestion;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FriendSuggestionItem(FriendSuggestion friendSuggestion, boolean z2) {
                super(0, null);
                Intrinsics3.checkNotNullParameter(friendSuggestion, "suggestion");
                this.suggestion = friendSuggestion;
                this.selected = z2;
                this.key = String.valueOf(friendSuggestion.getSuggestedUser().getId());
            }

            public static /* synthetic */ FriendSuggestionItem copy$default(FriendSuggestionItem friendSuggestionItem, FriendSuggestion friendSuggestion, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    friendSuggestion = friendSuggestionItem.suggestion;
                }
                if ((i & 2) != 0) {
                    z2 = friendSuggestionItem.selected;
                }
                return friendSuggestionItem.copy(friendSuggestion, z2);
            }

            /* renamed from: component1, reason: from getter */
            public final FriendSuggestion getSuggestion() {
                return this.suggestion;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getSelected() {
                return this.selected;
            }

            public final FriendSuggestionItem copy(FriendSuggestion suggestion, boolean selected) {
                Intrinsics3.checkNotNullParameter(suggestion, "suggestion");
                return new FriendSuggestionItem(suggestion, selected);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof FriendSuggestionItem)) {
                    return false;
                }
                FriendSuggestionItem friendSuggestionItem = (FriendSuggestionItem) other;
                return Intrinsics3.areEqual(this.suggestion, friendSuggestionItem.suggestion) && this.selected == friendSuggestionItem.selected;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            public final boolean getSelected() {
                return this.selected;
            }

            public final FriendSuggestion getSuggestion() {
                return this.suggestion;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                FriendSuggestion friendSuggestion = this.suggestion;
                int iHashCode = (friendSuggestion != null ? friendSuggestion.hashCode() : 0) * 31;
                boolean z2 = this.selected;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                return iHashCode + i;
            }

            public String toString() {
                StringBuilder sbU = outline.U("FriendSuggestionItem(suggestion=");
                sbU.append(this.suggestion);
                sbU.append(", selected=");
                return outline.O(sbU, this.selected, ")");
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

    /* compiled from: WidgetContactSyncViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b!\u0010\"J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ<\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u001b\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u001c\u0010\u0004R\u0019\u0010\u000e\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b\u001e\u0010\bR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001f\u001a\u0004\b \u0010\u000b¨\u0006#"}, d2 = {"Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$StoreState;", "", "", "component1", "()Ljava/lang/String;", "component2", "Lcom/discord/models/phone/PhoneCountryCode;", "component3", "()Lcom/discord/models/phone/PhoneCountryCode;", "Lcom/discord/api/connectedaccounts/ConnectedAccount;", "component4", "()Lcom/discord/api/connectedaccounts/ConnectedAccount;", "userPhone", "username", "countryCode", "contactsConnection", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/discord/models/phone/PhoneCountryCode;Lcom/discord/api/connectedaccounts/ConnectedAccount;)Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$StoreState;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getUserPhone", "getUsername", "Lcom/discord/models/phone/PhoneCountryCode;", "getCountryCode", "Lcom/discord/api/connectedaccounts/ConnectedAccount;", "getContactsConnection", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/discord/models/phone/PhoneCountryCode;Lcom/discord/api/connectedaccounts/ConnectedAccount;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class StoreState {
        private final ConnectedAccount contactsConnection;
        private final PhoneCountryCode countryCode;
        private final String userPhone;
        private final String username;

        public StoreState(String str, String str2, PhoneCountryCode phoneCountryCode, ConnectedAccount connectedAccount) {
            Intrinsics3.checkNotNullParameter(str2, "username");
            Intrinsics3.checkNotNullParameter(phoneCountryCode, "countryCode");
            this.userPhone = str;
            this.username = str2;
            this.countryCode = phoneCountryCode;
            this.contactsConnection = connectedAccount;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, String str, String str2, PhoneCountryCode phoneCountryCode, ConnectedAccount connectedAccount, int i, Object obj) {
            if ((i & 1) != 0) {
                str = storeState.userPhone;
            }
            if ((i & 2) != 0) {
                str2 = storeState.username;
            }
            if ((i & 4) != 0) {
                phoneCountryCode = storeState.countryCode;
            }
            if ((i & 8) != 0) {
                connectedAccount = storeState.contactsConnection;
            }
            return storeState.copy(str, str2, phoneCountryCode, connectedAccount);
        }

        /* renamed from: component1, reason: from getter */
        public final String getUserPhone() {
            return this.userPhone;
        }

        /* renamed from: component2, reason: from getter */
        public final String getUsername() {
            return this.username;
        }

        /* renamed from: component3, reason: from getter */
        public final PhoneCountryCode getCountryCode() {
            return this.countryCode;
        }

        /* renamed from: component4, reason: from getter */
        public final ConnectedAccount getContactsConnection() {
            return this.contactsConnection;
        }

        public final StoreState copy(String userPhone, String username, PhoneCountryCode countryCode, ConnectedAccount contactsConnection) {
            Intrinsics3.checkNotNullParameter(username, "username");
            Intrinsics3.checkNotNullParameter(countryCode, "countryCode");
            return new StoreState(userPhone, username, countryCode, contactsConnection);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.userPhone, storeState.userPhone) && Intrinsics3.areEqual(this.username, storeState.username) && Intrinsics3.areEqual(this.countryCode, storeState.countryCode) && Intrinsics3.areEqual(this.contactsConnection, storeState.contactsConnection);
        }

        public final ConnectedAccount getContactsConnection() {
            return this.contactsConnection;
        }

        public final PhoneCountryCode getCountryCode() {
            return this.countryCode;
        }

        public final String getUserPhone() {
            return this.userPhone;
        }

        public final String getUsername() {
            return this.username;
        }

        public int hashCode() {
            String str = this.userPhone;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.username;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            PhoneCountryCode phoneCountryCode = this.countryCode;
            int iHashCode3 = (iHashCode2 + (phoneCountryCode != null ? phoneCountryCode.hashCode() : 0)) * 31;
            ConnectedAccount connectedAccount = this.contactsConnection;
            return iHashCode3 + (connectedAccount != null ? connectedAccount.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(userPhone=");
            sbU.append(this.userPhone);
            sbU.append(", username=");
            sbU.append(this.username);
            sbU.append(", countryCode=");
            sbU.append(this.countryCode);
            sbU.append(", contactsConnection=");
            sbU.append(this.contactsConnection);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: WidgetContactSyncViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0006\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0015\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$ToolbarConfig;", "", "", "component1", "()Z", "component2", "showBackButton", "showSkip", "copy", "(ZZ)Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$ToolbarConfig;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getShowBackButton", "getShowSkip", "<init>", "(ZZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ToolbarConfig {
        private final boolean showBackButton;
        private final boolean showSkip;

        public ToolbarConfig(boolean z2, boolean z3) {
            this.showBackButton = z2;
            this.showSkip = z3;
        }

        public static /* synthetic */ ToolbarConfig copy$default(ToolbarConfig toolbarConfig, boolean z2, boolean z3, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = toolbarConfig.showBackButton;
            }
            if ((i & 2) != 0) {
                z3 = toolbarConfig.showSkip;
            }
            return toolbarConfig.copy(z2, z3);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getShowBackButton() {
            return this.showBackButton;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getShowSkip() {
            return this.showSkip;
        }

        public final ToolbarConfig copy(boolean showBackButton, boolean showSkip) {
            return new ToolbarConfig(showBackButton, showSkip);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ToolbarConfig)) {
                return false;
            }
            ToolbarConfig toolbarConfig = (ToolbarConfig) other;
            return this.showBackButton == toolbarConfig.showBackButton && this.showSkip == toolbarConfig.showSkip;
        }

        public final boolean getShowBackButton() {
            return this.showBackButton;
        }

        public final boolean getShowSkip() {
            return this.showSkip;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            boolean z2 = this.showBackButton;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            boolean z3 = this.showSkip;
            return i + (z3 ? 1 : z3 ? 1 : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("ToolbarConfig(showBackButton=");
            sbU.append(this.showBackButton);
            sbU.append(", showSkip=");
            return outline.O(sbU, this.showSkip, ")");
        }
    }

    /* compiled from: WidgetContactSyncViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u001f\b\u0086\b\u0018\u00002\u00020\u0001B\u009f\u0001\u0012\u0006\u0010%\u001a\u00020\u0002\u0012\u0006\u0010&\u001a\u00020\u0005\u0012\b\u0010'\u001a\u0004\u0018\u00010\b\u0012\b\u0010(\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010)\u001a\u00020\u000e\u0012\u0006\u0010*\u001a\u00020\b\u0012\b\u0010+\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010,\u001a\u00020\u0002\u0012\u0006\u0010-\u001a\u00020\u0002\u0012\u0006\u0010.\u001a\u00020\u0015\u0012\u0006\u0010/\u001a\u00020\u0002\u0012\u0006\u00100\u001a\u00020\u0002\u0012\b\u00101\u001a\u0004\u0018\u00010\b\u0012\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b\u0012\u0010\u00103\u001a\f\u0012\b\u0012\u00060\u001fj\u0002` 0\u001b\u0012\u0006\u00104\u001a\u00020\"¢\u0006\u0004\bU\u0010VJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u0011\u0010\nJ\u0012\u0010\u0012\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u0012\u0010\nJ\u0010\u0010\u0013\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0004J\u0010\u0010\u0016\u001a\u00020\u0015HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0004J\u0010\u0010\u0019\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0004J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u001a\u0010\nJ\u0016\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bHÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010!\u001a\f\u0012\b\u0012\u00060\u001fj\u0002` 0\u001bHÆ\u0003¢\u0006\u0004\b!\u0010\u001eJ\u0010\u0010#\u001a\u00020\"HÆ\u0003¢\u0006\u0004\b#\u0010$JÈ\u0001\u00105\u001a\u00020\u00002\b\b\u0002\u0010%\u001a\u00020\u00022\b\b\u0002\u0010&\u001a\u00020\u00052\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010)\u001a\u00020\u000e2\b\b\u0002\u0010*\u001a\u00020\b2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010,\u001a\u00020\u00022\b\b\u0002\u0010-\u001a\u00020\u00022\b\b\u0002\u0010.\u001a\u00020\u00152\b\b\u0002\u0010/\u001a\u00020\u00022\b\b\u0002\u00100\u001a\u00020\u00022\n\b\u0002\u00101\u001a\u0004\u0018\u00010\b2\u000e\b\u0002\u00102\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0012\b\u0002\u00103\u001a\f\u0012\b\u0012\u00060\u001fj\u0002` 0\u001b2\b\b\u0002\u00104\u001a\u00020\"HÆ\u0001¢\u0006\u0004\b5\u00106J\u0010\u00107\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b7\u0010\nJ\u0010\u00109\u001a\u000208HÖ\u0001¢\u0006\u0004\b9\u0010:J\u001a\u0010<\u001a\u00020\u00022\b\u0010;\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b<\u0010=R\u0019\u0010-\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010>\u001a\u0004\b?\u0010\u0004R\u0019\u0010*\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010@\u001a\u0004\bA\u0010\nR\u0019\u00104\u001a\u00020\"8\u0006@\u0006¢\u0006\f\n\u0004\b4\u0010B\u001a\u0004\bC\u0010$R\u0019\u0010%\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010>\u001a\u0004\bD\u0010\u0004R\u001f\u00102\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b2\u0010E\u001a\u0004\bF\u0010\u001eR\u0019\u0010,\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010>\u001a\u0004\b,\u0010\u0004R\u001b\u0010'\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010@\u001a\u0004\bG\u0010\nR\u0019\u0010)\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010H\u001a\u0004\bI\u0010\u0010R\u0019\u0010.\u001a\u00020\u00158\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010J\u001a\u0004\bK\u0010\u0017R\u001b\u0010(\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010L\u001a\u0004\bM\u0010\rR#\u00103\u001a\f\u0012\b\u0012\u00060\u001fj\u0002` 0\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b3\u0010E\u001a\u0004\bN\u0010\u001eR\u0019\u00100\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b0\u0010>\u001a\u0004\bO\u0010\u0004R\u001b\u00101\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010@\u001a\u0004\bP\u0010\nR\u0019\u0010/\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010>\u001a\u0004\bQ\u0010\u0004R\u0019\u0010&\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010R\u001a\u0004\bS\u0010\u0007R\u001b\u0010+\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010@\u001a\u0004\bT\u0010\n¨\u0006W"}, d2 = {"Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$ViewState;", "", "", "component1", "()Z", "Lcom/discord/widgets/contact_sync/ContactSyncMode;", "component2", "()Lcom/discord/widgets/contact_sync/ContactSyncMode;", "", "component3", "()Ljava/lang/String;", "Lcom/discord/api/connectedaccounts/ConnectedAccount;", "component4", "()Lcom/discord/api/connectedaccounts/ConnectedAccount;", "Lcom/discord/models/phone/PhoneCountryCode;", "component5", "()Lcom/discord/models/phone/PhoneCountryCode;", "component6", "component7", "component8", "component9", "Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$Views;", "component10", "()Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$Views;", "component11", "component12", "component13", "", "Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$Item;", "component14", "()Ljava/util/List;", "", "Lcom/discord/primitives/UserId;", "component15", "Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$ToolbarConfig;", "component16", "()Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$ToolbarConfig;", "landingNextEnabled", "mode", "phoneNumber", "existingConnection", "countryCode", "username", ModelAuditLogEntry.CHANGE_KEY_NAME, "isSubmitting", "permissionsDenied", "displayedChild", "allowPhone", "allowEmail", "bulkAddToken", "friendSuggestions", "selectedFriendIds", "toolbarConfig", "copy", "(ZLcom/discord/widgets/contact_sync/ContactSyncMode;Ljava/lang/String;Lcom/discord/api/connectedaccounts/ConnectedAccount;Lcom/discord/models/phone/PhoneCountryCode;Ljava/lang/String;Ljava/lang/String;ZZLcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$Views;ZZLjava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$ToolbarConfig;)Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$ViewState;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getPermissionsDenied", "Ljava/lang/String;", "getUsername", "Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$ToolbarConfig;", "getToolbarConfig", "getLandingNextEnabled", "Ljava/util/List;", "getFriendSuggestions", "getPhoneNumber", "Lcom/discord/models/phone/PhoneCountryCode;", "getCountryCode", "Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$Views;", "getDisplayedChild", "Lcom/discord/api/connectedaccounts/ConnectedAccount;", "getExistingConnection", "getSelectedFriendIds", "getAllowEmail", "getBulkAddToken", "getAllowPhone", "Lcom/discord/widgets/contact_sync/ContactSyncMode;", "getMode", "getName", "<init>", "(ZLcom/discord/widgets/contact_sync/ContactSyncMode;Ljava/lang/String;Lcom/discord/api/connectedaccounts/ConnectedAccount;Lcom/discord/models/phone/PhoneCountryCode;Ljava/lang/String;Ljava/lang/String;ZZLcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$Views;ZZLjava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$ToolbarConfig;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ViewState {
        private final boolean allowEmail;
        private final boolean allowPhone;
        private final String bulkAddToken;
        private final PhoneCountryCode countryCode;
        private final Views displayedChild;
        private final ConnectedAccount existingConnection;
        private final List<Item> friendSuggestions;
        private final boolean isSubmitting;
        private final boolean landingNextEnabled;
        private final ContactSyncMode mode;
        private final String name;
        private final boolean permissionsDenied;
        private final String phoneNumber;
        private final List<Long> selectedFriendIds;
        private final ToolbarConfig toolbarConfig;
        private final String username;

        /* JADX WARN: Multi-variable type inference failed */
        public ViewState(boolean z2, ContactSyncMode contactSyncMode, String str, ConnectedAccount connectedAccount, PhoneCountryCode phoneCountryCode, String str2, String str3, boolean z3, boolean z4, Views views, boolean z5, boolean z6, String str4, List<? extends Item> list, List<Long> list2, ToolbarConfig toolbarConfig) {
            Intrinsics3.checkNotNullParameter(contactSyncMode, "mode");
            Intrinsics3.checkNotNullParameter(phoneCountryCode, "countryCode");
            Intrinsics3.checkNotNullParameter(str2, "username");
            Intrinsics3.checkNotNullParameter(views, "displayedChild");
            Intrinsics3.checkNotNullParameter(list, "friendSuggestions");
            Intrinsics3.checkNotNullParameter(list2, "selectedFriendIds");
            Intrinsics3.checkNotNullParameter(toolbarConfig, "toolbarConfig");
            this.landingNextEnabled = z2;
            this.mode = contactSyncMode;
            this.phoneNumber = str;
            this.existingConnection = connectedAccount;
            this.countryCode = phoneCountryCode;
            this.username = str2;
            this.name = str3;
            this.isSubmitting = z3;
            this.permissionsDenied = z4;
            this.displayedChild = views;
            this.allowPhone = z5;
            this.allowEmail = z6;
            this.bulkAddToken = str4;
            this.friendSuggestions = list;
            this.selectedFriendIds = list2;
            this.toolbarConfig = toolbarConfig;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, boolean z2, ContactSyncMode contactSyncMode, String str, ConnectedAccount connectedAccount, PhoneCountryCode phoneCountryCode, String str2, String str3, boolean z3, boolean z4, Views views, boolean z5, boolean z6, String str4, List list, List list2, ToolbarConfig toolbarConfig, int i, Object obj) {
            return viewState.copy((i & 1) != 0 ? viewState.landingNextEnabled : z2, (i & 2) != 0 ? viewState.mode : contactSyncMode, (i & 4) != 0 ? viewState.phoneNumber : str, (i & 8) != 0 ? viewState.existingConnection : connectedAccount, (i & 16) != 0 ? viewState.countryCode : phoneCountryCode, (i & 32) != 0 ? viewState.username : str2, (i & 64) != 0 ? viewState.name : str3, (i & 128) != 0 ? viewState.isSubmitting : z3, (i & 256) != 0 ? viewState.permissionsDenied : z4, (i & 512) != 0 ? viewState.displayedChild : views, (i & 1024) != 0 ? viewState.allowPhone : z5, (i & 2048) != 0 ? viewState.allowEmail : z6, (i & 4096) != 0 ? viewState.bulkAddToken : str4, (i & 8192) != 0 ? viewState.friendSuggestions : list, (i & 16384) != 0 ? viewState.selectedFriendIds : list2, (i & 32768) != 0 ? viewState.toolbarConfig : toolbarConfig);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getLandingNextEnabled() {
            return this.landingNextEnabled;
        }

        /* renamed from: component10, reason: from getter */
        public final Views getDisplayedChild() {
            return this.displayedChild;
        }

        /* renamed from: component11, reason: from getter */
        public final boolean getAllowPhone() {
            return this.allowPhone;
        }

        /* renamed from: component12, reason: from getter */
        public final boolean getAllowEmail() {
            return this.allowEmail;
        }

        /* renamed from: component13, reason: from getter */
        public final String getBulkAddToken() {
            return this.bulkAddToken;
        }

        public final List<Item> component14() {
            return this.friendSuggestions;
        }

        public final List<Long> component15() {
            return this.selectedFriendIds;
        }

        /* renamed from: component16, reason: from getter */
        public final ToolbarConfig getToolbarConfig() {
            return this.toolbarConfig;
        }

        /* renamed from: component2, reason: from getter */
        public final ContactSyncMode getMode() {
            return this.mode;
        }

        /* renamed from: component3, reason: from getter */
        public final String getPhoneNumber() {
            return this.phoneNumber;
        }

        /* renamed from: component4, reason: from getter */
        public final ConnectedAccount getExistingConnection() {
            return this.existingConnection;
        }

        /* renamed from: component5, reason: from getter */
        public final PhoneCountryCode getCountryCode() {
            return this.countryCode;
        }

        /* renamed from: component6, reason: from getter */
        public final String getUsername() {
            return this.username;
        }

        /* renamed from: component7, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: component8, reason: from getter */
        public final boolean getIsSubmitting() {
            return this.isSubmitting;
        }

        /* renamed from: component9, reason: from getter */
        public final boolean getPermissionsDenied() {
            return this.permissionsDenied;
        }

        public final ViewState copy(boolean landingNextEnabled, ContactSyncMode mode, String phoneNumber, ConnectedAccount existingConnection, PhoneCountryCode countryCode, String username, String name, boolean isSubmitting, boolean permissionsDenied, Views displayedChild, boolean allowPhone, boolean allowEmail, String bulkAddToken, List<? extends Item> friendSuggestions, List<Long> selectedFriendIds, ToolbarConfig toolbarConfig) {
            Intrinsics3.checkNotNullParameter(mode, "mode");
            Intrinsics3.checkNotNullParameter(countryCode, "countryCode");
            Intrinsics3.checkNotNullParameter(username, "username");
            Intrinsics3.checkNotNullParameter(displayedChild, "displayedChild");
            Intrinsics3.checkNotNullParameter(friendSuggestions, "friendSuggestions");
            Intrinsics3.checkNotNullParameter(selectedFriendIds, "selectedFriendIds");
            Intrinsics3.checkNotNullParameter(toolbarConfig, "toolbarConfig");
            return new ViewState(landingNextEnabled, mode, phoneNumber, existingConnection, countryCode, username, name, isSubmitting, permissionsDenied, displayedChild, allowPhone, allowEmail, bulkAddToken, friendSuggestions, selectedFriendIds, toolbarConfig);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return this.landingNextEnabled == viewState.landingNextEnabled && Intrinsics3.areEqual(this.mode, viewState.mode) && Intrinsics3.areEqual(this.phoneNumber, viewState.phoneNumber) && Intrinsics3.areEqual(this.existingConnection, viewState.existingConnection) && Intrinsics3.areEqual(this.countryCode, viewState.countryCode) && Intrinsics3.areEqual(this.username, viewState.username) && Intrinsics3.areEqual(this.name, viewState.name) && this.isSubmitting == viewState.isSubmitting && this.permissionsDenied == viewState.permissionsDenied && Intrinsics3.areEqual(this.displayedChild, viewState.displayedChild) && this.allowPhone == viewState.allowPhone && this.allowEmail == viewState.allowEmail && Intrinsics3.areEqual(this.bulkAddToken, viewState.bulkAddToken) && Intrinsics3.areEqual(this.friendSuggestions, viewState.friendSuggestions) && Intrinsics3.areEqual(this.selectedFriendIds, viewState.selectedFriendIds) && Intrinsics3.areEqual(this.toolbarConfig, viewState.toolbarConfig);
        }

        public final boolean getAllowEmail() {
            return this.allowEmail;
        }

        public final boolean getAllowPhone() {
            return this.allowPhone;
        }

        public final String getBulkAddToken() {
            return this.bulkAddToken;
        }

        public final PhoneCountryCode getCountryCode() {
            return this.countryCode;
        }

        public final Views getDisplayedChild() {
            return this.displayedChild;
        }

        public final ConnectedAccount getExistingConnection() {
            return this.existingConnection;
        }

        public final List<Item> getFriendSuggestions() {
            return this.friendSuggestions;
        }

        public final boolean getLandingNextEnabled() {
            return this.landingNextEnabled;
        }

        public final ContactSyncMode getMode() {
            return this.mode;
        }

        public final String getName() {
            return this.name;
        }

        public final boolean getPermissionsDenied() {
            return this.permissionsDenied;
        }

        public final String getPhoneNumber() {
            return this.phoneNumber;
        }

        public final List<Long> getSelectedFriendIds() {
            return this.selectedFriendIds;
        }

        public final ToolbarConfig getToolbarConfig() {
            return this.toolbarConfig;
        }

        public final String getUsername() {
            return this.username;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v32 */
        /* JADX WARN: Type inference failed for: r0v33 */
        /* JADX WARN: Type inference failed for: r2v18, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v20, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v25, types: [boolean] */
        public int hashCode() {
            boolean z2 = this.landingNextEnabled;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            ContactSyncMode contactSyncMode = this.mode;
            int iHashCode = (i + (contactSyncMode != null ? contactSyncMode.hashCode() : 0)) * 31;
            String str = this.phoneNumber;
            int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
            ConnectedAccount connectedAccount = this.existingConnection;
            int iHashCode3 = (iHashCode2 + (connectedAccount != null ? connectedAccount.hashCode() : 0)) * 31;
            PhoneCountryCode phoneCountryCode = this.countryCode;
            int iHashCode4 = (iHashCode3 + (phoneCountryCode != null ? phoneCountryCode.hashCode() : 0)) * 31;
            String str2 = this.username;
            int iHashCode5 = (iHashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.name;
            int iHashCode6 = (iHashCode5 + (str3 != null ? str3.hashCode() : 0)) * 31;
            ?? r2 = this.isSubmitting;
            int i2 = r2;
            if (r2 != 0) {
                i2 = 1;
            }
            int i3 = (iHashCode6 + i2) * 31;
            ?? r22 = this.permissionsDenied;
            int i4 = r22;
            if (r22 != 0) {
                i4 = 1;
            }
            int i5 = (i3 + i4) * 31;
            Views views = this.displayedChild;
            int iHashCode7 = (i5 + (views != null ? views.hashCode() : 0)) * 31;
            ?? r23 = this.allowPhone;
            int i6 = r23;
            if (r23 != 0) {
                i6 = 1;
            }
            int i7 = (iHashCode7 + i6) * 31;
            boolean z3 = this.allowEmail;
            int i8 = (i7 + (z3 ? 1 : z3 ? 1 : 0)) * 31;
            String str4 = this.bulkAddToken;
            int iHashCode8 = (i8 + (str4 != null ? str4.hashCode() : 0)) * 31;
            List<Item> list = this.friendSuggestions;
            int iHashCode9 = (iHashCode8 + (list != null ? list.hashCode() : 0)) * 31;
            List<Long> list2 = this.selectedFriendIds;
            int iHashCode10 = (iHashCode9 + (list2 != null ? list2.hashCode() : 0)) * 31;
            ToolbarConfig toolbarConfig = this.toolbarConfig;
            return iHashCode10 + (toolbarConfig != null ? toolbarConfig.hashCode() : 0);
        }

        public final boolean isSubmitting() {
            return this.isSubmitting;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ViewState(landingNextEnabled=");
            sbU.append(this.landingNextEnabled);
            sbU.append(", mode=");
            sbU.append(this.mode);
            sbU.append(", phoneNumber=");
            sbU.append(this.phoneNumber);
            sbU.append(", existingConnection=");
            sbU.append(this.existingConnection);
            sbU.append(", countryCode=");
            sbU.append(this.countryCode);
            sbU.append(", username=");
            sbU.append(this.username);
            sbU.append(", name=");
            sbU.append(this.name);
            sbU.append(", isSubmitting=");
            sbU.append(this.isSubmitting);
            sbU.append(", permissionsDenied=");
            sbU.append(this.permissionsDenied);
            sbU.append(", displayedChild=");
            sbU.append(this.displayedChild);
            sbU.append(", allowPhone=");
            sbU.append(this.allowPhone);
            sbU.append(", allowEmail=");
            sbU.append(this.allowEmail);
            sbU.append(", bulkAddToken=");
            sbU.append(this.bulkAddToken);
            sbU.append(", friendSuggestions=");
            sbU.append(this.friendSuggestions);
            sbU.append(", selectedFriendIds=");
            sbU.append(this.selectedFriendIds);
            sbU.append(", toolbarConfig=");
            sbU.append(this.toolbarConfig);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: WidgetContactSyncViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$Views;", "", "", "trackingStep", "Ljava/lang/String;", "getTrackingStep", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "VIEW_LANDING", "VIEW_ADD_PHONE", "VIEW_VERIFY_PHONE", "VIEW_NAME_INPUT", "VIEW_SUGGESTIONS", "VIEW_SUGGESTIONS_EMPTY", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public enum Views {
        VIEW_LANDING("Landing"),
        VIEW_ADD_PHONE("Add Phone Number"),
        VIEW_VERIFY_PHONE("Verify Phone Number"),
        VIEW_NAME_INPUT("Name Input"),
        VIEW_SUGGESTIONS("Suggestions Results"),
        VIEW_SUGGESTIONS_EMPTY("Suggestions Results");

        private final String trackingStep;

        Views(String str) {
            this.trackingStep = str;
        }

        public final String getTrackingStep() {
            return this.trackingStep;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            ContactSyncMode.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            ContactSyncMode contactSyncMode = ContactSyncMode.ONBOARDING;
            iArr[contactSyncMode.ordinal()] = 1;
            ContactSyncMode contactSyncMode2 = ContactSyncMode.DEFAULT;
            iArr[contactSyncMode2.ordinal()] = 2;
            Views.values();
            int[] iArr2 = new int[6];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[Views.VIEW_LANDING.ordinal()] = 1;
            iArr2[Views.VIEW_NAME_INPUT.ordinal()] = 2;
            iArr2[Views.VIEW_SUGGESTIONS.ordinal()] = 3;
            iArr2[Views.VIEW_SUGGESTIONS_EMPTY.ordinal()] = 4;
            iArr2[Views.VIEW_ADD_PHONE.ordinal()] = 5;
            iArr2[Views.VIEW_VERIFY_PHONE.ordinal()] = 6;
            ContactSyncMode.values();
            int[] iArr3 = new int[2];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[contactSyncMode.ordinal()] = 1;
            iArr3[contactSyncMode2.ordinal()] = 2;
        }
    }

    /* compiled from: WidgetContactSyncViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/friendsuggestions/BulkAddFriendsResponse;", "it", "Lcom/discord/analytics/generated/traits/TrackNetworkMetadataReceiver;", "invoke", "(Lcom/discord/api/friendsuggestions/BulkAddFriendsResponse;)Lcom/discord/analytics/generated/traits/TrackNetworkMetadataReceiver;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.contact_sync.WidgetContactSyncViewModel$onBulkAddFriends$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<BulkAddFriendsResponse, TrackNetworkMetadata2> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ TrackNetworkMetadata2 invoke(BulkAddFriendsResponse bulkAddFriendsResponse) {
            return invoke2(bulkAddFriendsResponse);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final TrackNetworkMetadata2 invoke2(BulkAddFriendsResponse bulkAddFriendsResponse) {
            return new TrackNetworkActionUserBulkRelationshipsUpdate();
        }
    }

    /* compiled from: WidgetContactSyncViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/friendsuggestions/BulkAddFriendsResponse;", "it", "", "invoke", "(Lcom/discord/api/friendsuggestions/BulkAddFriendsResponse;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.contact_sync.WidgetContactSyncViewModel$onBulkAddFriends$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<BulkAddFriendsResponse, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(BulkAddFriendsResponse bulkAddFriendsResponse) {
            invoke2(bulkAddFriendsResponse);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(BulkAddFriendsResponse bulkAddFriendsResponse) {
            Intrinsics3.checkNotNullParameter(bulkAddFriendsResponse, "it");
            WidgetContactSyncViewModel.access$handleFriendsAdded(WidgetContactSyncViewModel.this, bulkAddFriendsResponse);
        }
    }

    /* compiled from: WidgetContactSyncViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.contact_sync.WidgetContactSyncViewModel$onBulkAddFriends$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass3() {
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
            WidgetContactSyncViewModel.access$handleFriendsAddedError(WidgetContactSyncViewModel.this, error);
        }
    }

    /* compiled from: WidgetContactSyncViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/friendsuggestions/BulkFriendSuggestions;", "it", "Lcom/discord/analytics/generated/traits/TrackNetworkMetadataReceiver;", "invoke", "(Lcom/discord/api/friendsuggestions/BulkFriendSuggestions;)Lcom/discord/analytics/generated/traits/TrackNetworkMetadataReceiver;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.contact_sync.WidgetContactSyncViewModel$onContactsFetched$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<BulkFriendSuggestions, TrackNetworkMetadata2> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ TrackNetworkMetadata2 invoke(BulkFriendSuggestions bulkFriendSuggestions) {
            return invoke2(bulkFriendSuggestions);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final TrackNetworkMetadata2 invoke2(BulkFriendSuggestions bulkFriendSuggestions) {
            return new TrackNetworkActionUserContactsSync();
        }
    }

    /* compiled from: WidgetContactSyncViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/friendsuggestions/BulkFriendSuggestions;", "it", "", "invoke", "(Lcom/discord/api/friendsuggestions/BulkFriendSuggestions;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.contact_sync.WidgetContactSyncViewModel$onContactsFetched$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<BulkFriendSuggestions, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(BulkFriendSuggestions bulkFriendSuggestions) {
            invoke2(bulkFriendSuggestions);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(BulkFriendSuggestions bulkFriendSuggestions) {
            Intrinsics3.checkNotNullParameter(bulkFriendSuggestions, "it");
            WidgetContactSyncViewModel.access$handleFriendSuggestions(WidgetContactSyncViewModel.this, bulkFriendSuggestions);
        }
    }

    /* compiled from: WidgetContactSyncViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.contact_sync.WidgetContactSyncViewModel$onContactsFetched$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass3() {
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
            WidgetContactSyncViewModel.access$handleUploadError(WidgetContactSyncViewModel.this, error);
        }
    }

    /* compiled from: WidgetContactSyncViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/connectedaccounts/ConnectedAccount;", "it", "Lcom/discord/analytics/generated/traits/TrackNetworkMetadataReceiver;", "invoke", "(Lcom/discord/api/connectedaccounts/ConnectedAccount;)Lcom/discord/analytics/generated/traits/TrackNetworkMetadataReceiver;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.contact_sync.WidgetContactSyncViewModel$onNameSubmitted$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<ConnectedAccount, TrackNetworkMetadata2> {
        public final /* synthetic */ String $submittingName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(1);
            this.$submittingName = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ TrackNetworkMetadata2 invoke(ConnectedAccount connectedAccount) {
            return invoke2(connectedAccount);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final TrackNetworkMetadata2 invoke2(ConnectedAccount connectedAccount) {
            return new TrackNetworkActionUserConnectionsUpdate(this.$submittingName, Boolean.TRUE, null, null, 12);
        }
    }

    /* compiled from: WidgetContactSyncViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/connectedaccounts/ConnectedAccount;", "it", "", "invoke", "(Lcom/discord/api/connectedaccounts/ConnectedAccount;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.contact_sync.WidgetContactSyncViewModel$onNameSubmitted$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<ConnectedAccount, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ConnectedAccount connectedAccount) {
            invoke2(connectedAccount);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ConnectedAccount connectedAccount) {
            Intrinsics3.checkNotNullParameter(connectedAccount, "it");
            WidgetContactSyncViewModel.access$handleContactsEnabled(WidgetContactSyncViewModel.this);
        }
    }

    /* compiled from: WidgetContactSyncViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.contact_sync.WidgetContactSyncViewModel$onNameSubmitted$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass3() {
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
            WidgetContactSyncViewModel.access$handleContactsEnableError(WidgetContactSyncViewModel.this, error);
        }
    }

    /* compiled from: WidgetContactSyncViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/connectedaccounts/ConnectedAccount;", "it", "", "invoke", "(Lcom/discord/api/connectedaccounts/ConnectedAccount;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.contact_sync.WidgetContactSyncViewModel$onNameSubmitted$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements Function1<ConnectedAccount, Unit> {
        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ConnectedAccount connectedAccount) {
            invoke2(connectedAccount);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ConnectedAccount connectedAccount) {
            Intrinsics3.checkNotNullParameter(connectedAccount, "it");
            WidgetContactSyncViewModel.access$handleContactsEnabled(WidgetContactSyncViewModel.this);
        }
    }

    /* compiled from: WidgetContactSyncViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.contact_sync.WidgetContactSyncViewModel$onNameSubmitted$5, reason: invalid class name */
    public static final class AnonymousClass5 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass5() {
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
            WidgetContactSyncViewModel.access$handleContactsEnableError(WidgetContactSyncViewModel.this, error);
        }
    }

    /* compiled from: WidgetContactSyncViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/domain/ModelUserSettings;", "it", "", "invoke", "(Lcom/discord/models/domain/ModelUserSettings;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.contact_sync.WidgetContactSyncViewModel$onNameSubmitted$6, reason: invalid class name */
    public static final class AnonymousClass6 extends Lambda implements Function1<ModelUserSettings, Unit> {
        public static final AnonymousClass6 INSTANCE = new AnonymousClass6();

        public AnonymousClass6() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelUserSettings modelUserSettings) {
            invoke2(modelUserSettings);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelUserSettings modelUserSettings) {
            Intrinsics3.checkNotNullParameter(modelUserSettings, "it");
        }
    }

    /* compiled from: WidgetContactSyncViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.contact_sync.WidgetContactSyncViewModel$onNameSubmitted$7, reason: invalid class name */
    public static final class AnonymousClass7 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass7() {
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
            WidgetContactSyncViewModel.access$handleContactsEnableError(WidgetContactSyncViewModel.this, error);
        }
    }

    /* compiled from: WidgetContactSyncViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.contact_sync.WidgetContactSyncViewModel$onPhoneNumberSubmitted$1, reason: invalid class name */
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
        public final void invoke2(Void r1) {
            WidgetContactSyncViewModel.access$handlePhoneSubmitted(WidgetContactSyncViewModel.this);
        }
    }

    /* compiled from: WidgetContactSyncViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "error", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.contact_sync.WidgetContactSyncViewModel$onPhoneNumberSubmitted$2, reason: invalid class name */
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
            Intrinsics3.checkNotNullParameter(error, "error");
            if (GrowthTeamFeatures.INSTANCE.isPhoneVerifyCaptchaEnabled() && WidgetCaptcha4.isCaptchaError(error)) {
                WidgetContactSyncViewModel.access$getCaptchaLauncher$p(WidgetContactSyncViewModel.this).invoke(error);
            } else {
                WidgetContactSyncViewModel.access$handlePhoneSubmittedError(WidgetContactSyncViewModel.this);
            }
        }
    }

    /* compiled from: WidgetContactSyncViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.contact_sync.WidgetContactSyncViewModel$onVerifyPhone$1, reason: invalid class name */
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
        public final void invoke2(Void r1) {
            WidgetContactSyncViewModel.access$handlePhoneVerified(WidgetContactSyncViewModel.this);
        }
    }

    /* compiled from: WidgetContactSyncViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.contact_sync.WidgetContactSyncViewModel$onVerifyPhone$2, reason: invalid class name */
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
            WidgetContactSyncViewModel.access$handlePhoneVerifiedError(WidgetContactSyncViewModel.this, error);
        }
    }

    public /* synthetic */ WidgetContactSyncViewModel(ContactSyncMode contactSyncMode, boolean z2, boolean z3, RestAPI restAPI, Observable observable, ContactSyncFlowAnalytics contactSyncFlowAnalytics, boolean z4, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        ContactSyncFlowAnalytics contactSyncFlowAnalytics2;
        boolean z5 = (i & 2) != 0 ? true : z2;
        boolean z6 = (i & 4) != 0 ? true : z3;
        RestAPI api = (i & 8) != 0 ? RestAPI.INSTANCE.getApi() : restAPI;
        Observable observableObserveStores = (i & 16) != 0 ? INSTANCE.observeStores() : observable;
        if ((i & 32) != 0) {
            contactSyncFlowAnalytics2 = new ContactSyncFlowAnalytics(contactSyncMode == ContactSyncMode.ONBOARDING, ClockFactory.get());
        } else {
            contactSyncFlowAnalytics2 = contactSyncFlowAnalytics;
        }
        this(contactSyncMode, z5, z6, api, observableObserveStores, contactSyncFlowAnalytics2, (i & 64) != 0 ? false : z4, function1);
    }

    public static final /* synthetic */ Function1 access$getCaptchaLauncher$p(WidgetContactSyncViewModel widgetContactSyncViewModel) {
        return widgetContactSyncViewModel.captchaLauncher;
    }

    public static final /* synthetic */ void access$handleContactsEnableError(WidgetContactSyncViewModel widgetContactSyncViewModel, Error error) {
        widgetContactSyncViewModel.handleContactsEnableError(error);
    }

    public static final /* synthetic */ void access$handleContactsEnabled(WidgetContactSyncViewModel widgetContactSyncViewModel) {
        widgetContactSyncViewModel.handleContactsEnabled();
    }

    public static final /* synthetic */ void access$handleFriendSuggestions(WidgetContactSyncViewModel widgetContactSyncViewModel, BulkFriendSuggestions bulkFriendSuggestions) {
        widgetContactSyncViewModel.handleFriendSuggestions(bulkFriendSuggestions);
    }

    public static final /* synthetic */ void access$handleFriendsAdded(WidgetContactSyncViewModel widgetContactSyncViewModel, BulkAddFriendsResponse bulkAddFriendsResponse) {
        widgetContactSyncViewModel.handleFriendsAdded(bulkAddFriendsResponse);
    }

    public static final /* synthetic */ void access$handleFriendsAddedError(WidgetContactSyncViewModel widgetContactSyncViewModel, Error error) {
        widgetContactSyncViewModel.handleFriendsAddedError(error);
    }

    public static final /* synthetic */ void access$handlePhoneSubmitted(WidgetContactSyncViewModel widgetContactSyncViewModel) {
        widgetContactSyncViewModel.handlePhoneSubmitted();
    }

    public static final /* synthetic */ void access$handlePhoneSubmittedError(WidgetContactSyncViewModel widgetContactSyncViewModel) {
        widgetContactSyncViewModel.handlePhoneSubmittedError();
    }

    public static final /* synthetic */ void access$handlePhoneVerified(WidgetContactSyncViewModel widgetContactSyncViewModel) {
        widgetContactSyncViewModel.handlePhoneVerified();
    }

    public static final /* synthetic */ void access$handlePhoneVerifiedError(WidgetContactSyncViewModel widgetContactSyncViewModel, Error error) {
        widgetContactSyncViewModel.handlePhoneVerifiedError(error);
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetContactSyncViewModel widgetContactSyncViewModel, StoreState storeState) {
        widgetContactSyncViewModel.handleStoreState(storeState);
    }

    public static final /* synthetic */ void access$handleUploadError(WidgetContactSyncViewModel widgetContactSyncViewModel, Error error) {
        widgetContactSyncViewModel.handleUploadError(error);
    }

    private final ToolbarConfig getLandingToolbarConfig(ContactSyncMode mode) {
        int iOrdinal = mode.ordinal();
        if (iOrdinal == 0) {
            return WidgetContactSyncViewModel3.access$getTOOLBAR_CONFIG_ONBOARDING$p();
        }
        if (iOrdinal == 1) {
            return WidgetContactSyncViewModel3.access$getTOOLBAR_CONFIG_DEFAULT$p();
        }
        throw new NoWhenBranchMatchedException();
    }

    private final void handleComplete() {
        ViewState viewState = getViewState();
        if (viewState != null) {
            if (viewState.getMode() == ContactSyncMode.ONBOARDING) {
                StoreStream.INSTANCE.getNux().setContactSyncCompleted(true);
            }
            PublishSubject<Event> publishSubject = this.eventsSubject;
            publishSubject.k.onNext(Event.Completed.INSTANCE);
        }
    }

    @MainThread
    private final void handleContactsEnableError(Error error) {
        if (error.getType() == Error.Type.RATE_LIMITED) {
            PublishSubject<Event> publishSubject = this.eventsSubject;
            publishSubject.k.onNext(Event.RateLimited.INSTANCE);
        } else {
            PublishSubject<Event> publishSubject2 = this.eventsSubject;
            publishSubject2.k.onNext(Event.ContactsEnableFailed.INSTANCE);
        }
        ViewState viewState = getViewState();
        if (viewState != null) {
            updateViewState(ViewState.copy$default(viewState, false, null, null, null, null, null, null, false, false, Views.VIEW_LANDING, false, false, null, null, null, getLandingToolbarConfig(viewState.getMode()), 32255, null));
        }
    }

    @MainThread
    private final void handleContactsEnabled() {
        ViewState viewState = getViewState();
        if (viewState != null) {
            AnalyticsTracker.INSTANCE.contactSyncToggled(true, viewState.getAllowPhone(), viewState.getAllowEmail());
            PublishSubject<Event> publishSubject = this.eventsSubject;
            publishSubject.k.onNext(Event.ContactsEnabled.INSTANCE);
        }
    }

    @MainThread
    private final void handleFriendSuggestions(BulkFriendSuggestions suggestions) {
        ViewState viewState = getViewState();
        if (viewState != null) {
            if (suggestions.b().isEmpty()) {
                ContactSyncFlowAnalytics contactSyncFlowAnalytics = this.tracker;
                Views views = Views.VIEW_SUGGESTIONS_EMPTY;
                contactSyncFlowAnalytics.trackFlowStep(views.getTrackingStep(), false, false, MapsJVM.mapOf(Tuples.to("num_contacts_found", 0)));
                updateViewState(ViewState.copy$default(viewState, false, null, null, null, null, null, null, false, false, views, false, false, null, null, null, new ToolbarConfig(false, false), 32127, null));
                return;
            }
            StoreStream.INSTANCE.getFriendSuggestions().updateFriendSuggestions(suggestions.b());
            List<FriendSuggestion> listB = suggestions.b();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = listB.iterator();
            while (true) {
                boolean z2 = true;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                List<FriendSuggestionReason> listA = ((FriendSuggestion) next).a();
                if ((listA instanceof Collection) && listA.isEmpty()) {
                    z2 = false;
                } else {
                    Iterator<T> it2 = listA.iterator();
                    while (it2.hasNext()) {
                        if (Intrinsics3.areEqual(((FriendSuggestionReason) it2.next()).getPlatformType(), "contacts")) {
                            break;
                        }
                    }
                    z2 = false;
                }
                if (z2) {
                    arrayList.add(next);
                }
            }
            this.tracker.trackFlowStep(Views.VIEW_SUGGESTIONS.getTrackingStep(), false, false, MapsJVM.mapOf(Tuples.to("num_contacts_found", Integer.valueOf(arrayList.size()))));
            String strA = suggestions.getBulkAddToken();
            ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, 10));
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                arrayList2.add(new Item.FriendSuggestionItem((FriendSuggestion) it3.next(), true));
            }
            ArrayList arrayList3 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, 10));
            Iterator it4 = arrayList.iterator();
            while (it4.hasNext()) {
                arrayList3.add(Long.valueOf(((FriendSuggestion) it4.next()).getSuggestedUser().getId()));
            }
            updateViewState(ViewState.copy$default(viewState, false, null, null, null, null, null, null, false, false, Views.VIEW_SUGGESTIONS, false, false, strA, arrayList2, arrayList3, new ToolbarConfig(false, true), 3455, null));
        }
    }

    @MainThread
    private final void handleFriendsAdded(BulkAddFriendsResponse result) {
        ViewState viewState = getViewState();
        if (viewState != null) {
            updateViewState(ViewState.copy$default(viewState, false, null, null, null, null, null, null, false, false, null, false, false, null, null, null, null, 65407, null));
            this.tracker.trackEnd(false, Maps6.mapOf(Tuples.to("num_contacts_found", Integer.valueOf(viewState.getFriendSuggestions().size())), Tuples.to("num_contacts_added", Integer.valueOf(result.b().size()))));
            if (!(!result.a().isEmpty())) {
                handleComplete();
            } else {
                this.eventsSubject.k.onNext(Event.AddFriendsFailedPartial.INSTANCE);
            }
        }
    }

    @MainThread
    private final void handleFriendsAddedError(Error error) {
        ViewState viewState = getViewState();
        if (viewState != null) {
            updateViewState(ViewState.copy$default(viewState, false, null, null, null, null, null, null, false, false, null, false, false, null, null, null, null, 65407, null));
            this.tracker.trackEnd(false, Maps6.mapOf(Tuples.to("num_contacts_found", Integer.valueOf(viewState.getFriendSuggestions().size())), Tuples.to("num_contacts_added", 0)));
            Error.Response response = error.getResponse();
            Intrinsics3.checkNotNullExpressionValue(response, "error.response");
            Intrinsics3.checkNotNullExpressionValue(response.getMessages(), "error.response.messages");
            if (!r1.isEmpty()) {
                this.eventsSubject.k.onNext(Event.AddFriendsFailed.INSTANCE);
            }
        }
    }

    @MainThread
    private final void handlePhoneSubmitted() {
        ViewState viewState = getViewState();
        if (viewState != null) {
            ContactSyncFlowAnalytics contactSyncFlowAnalytics = this.tracker;
            Views views = Views.VIEW_VERIFY_PHONE;
            ContactSyncFlowAnalytics.trackFlowStep$default(contactSyncFlowAnalytics, views.getTrackingStep(), false, false, null, 8, null);
            updateViewState(ViewState.copy$default(viewState, false, null, null, null, null, null, null, false, false, views, false, false, null, null, null, null, 65023, null));
        }
    }

    @MainThread
    private final void handlePhoneSubmittedError() {
        PublishSubject<Event> publishSubject = this.eventsSubject;
        publishSubject.k.onNext(Event.PhoneInvalid.INSTANCE);
    }

    @MainThread
    private final void handlePhoneVerified() {
        ViewState viewState = getViewState();
        if (viewState != null) {
            updateViewState(ViewState.copy$default(viewState, false, null, null, null, null, null, null, false, false, Views.VIEW_LANDING, false, false, null, null, null, getLandingToolbarConfig(viewState.getMode()), 32255, null));
            PublishSubject<Event> publishSubject = this.eventsSubject;
            publishSubject.k.onNext(Event.PermissionsNeeded.INSTANCE);
        }
    }

    @MainThread
    private final void handlePhoneVerifiedError(Error error) {
        Error.Response response = error.getResponse();
        Intrinsics3.checkNotNullExpressionValue(response, "error.response");
        Intrinsics3.checkNotNullExpressionValue(response.getMessages(), "error.response.messages");
        if (!r2.isEmpty()) {
            this.eventsSubject.k.onNext(Event.VerificationCodeInvalid.INSTANCE);
        } else {
            this.eventsSubject.k.onNext(Event.VerificationFailed.INSTANCE);
        }
    }

    private final void handleStoreState(StoreState storeState) {
        ViewState viewState = getViewState();
        if (viewState != null) {
            updateViewState(ViewState.copy$default(viewState, true, null, storeState.getUserPhone(), storeState.getContactsConnection(), storeState.getCountryCode(), storeState.getUsername(), null, false, false, null, false, false, null, null, null, null, 65474, null));
            if (this.initialized) {
                return;
            }
            this.initialized = true;
            PublishSubject<Event> publishSubject = this.eventsSubject;
            publishSubject.k.onNext(Event.MaybeProceedFromLanding.INSTANCE);
        }
    }

    @MainThread
    private final void handleUploadError(Error error) {
        ViewState viewState = getViewState();
        if (viewState != null) {
            updateViewState(ViewState.copy$default(viewState, false, null, null, null, null, null, null, false, false, Views.VIEW_LANDING, false, false, null, null, null, getLandingToolbarConfig(viewState.getMode()), 32127, null));
            if (error.getType() == Error.Type.RATE_LIMITED) {
                PublishSubject<Event> publishSubject = this.eventsSubject;
                publishSubject.k.onNext(Event.RateLimited.INSTANCE);
            } else {
                PublishSubject<Event> publishSubject2 = this.eventsSubject;
                publishSubject2.k.onNext(Event.UploadFailed.INSTANCE);
            }
        }
    }

    @MainThread
    public final void dismissUpsell() {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        companion.getContactSync().dismissUpsell();
        companion.getUserSettings().updateContactSyncShown();
    }

    public final ContactSyncFlowAnalytics getTracker() {
        return this.tracker;
    }

    @MainThread
    public final void handleToggleFriendSuggestionSelected(long userId, boolean isSelected) {
        ViewState viewState = getViewState();
        if (viewState != null) {
            List mutableList = _Collections.toMutableList((Collection) viewState.getSelectedFriendIds());
            if (isSelected) {
                mutableList.add(Long.valueOf(userId));
            } else {
                mutableList.remove(Long.valueOf(userId));
            }
            updateViewState(ViewState.copy$default(viewState, false, null, null, null, null, null, null, false, false, null, false, false, null, null, mutableList, null, 49151, null));
        }
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventsSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventsSubject");
        return publishSubject;
    }

    @MainThread
    public final void onBulkAddFriends() {
        String bulkAddToken;
        ViewState viewState = getViewState();
        if (viewState == null || (bulkAddToken = viewState.getBulkAddToken()) == null) {
            return;
        }
        List<Long> selectedFriendIds = viewState.getSelectedFriendIds();
        if (selectedFriendIds.isEmpty()) {
            this.tracker.trackEnd(false, Maps6.mapOf(Tuples.to("num_contacts_found", Integer.valueOf(viewState.getFriendSuggestions().size())), Tuples.to("num_contacts_added", 0)));
            handleComplete();
        } else {
            updateViewState(ViewState.copy$default(viewState, false, null, null, null, null, null, null, true, false, null, false, false, null, null, null, null, 65407, null));
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(RestCallState5.logNetworkAction(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.bulkAddRelationships(new RestAPIParams.UserBulkRelationship(selectedFriendIds, bulkAddToken)), false, 1, null), AnonymousClass1.INSTANCE), this, null, 2, null), WidgetContactSyncViewModel.class, (Context) null, (Function1) null, new AnonymousClass3(), (Function0) null, (Function0) null, new AnonymousClass2(), 54, (Object) null);
        }
    }

    @MainThread
    public final void onContactsFetched(Set<String> contactNumbers) {
        Intrinsics3.checkNotNullParameter(contactNumbers, "contactNumbers");
        ViewState viewState = getViewState();
        if (viewState != null) {
            updateViewState(ViewState.copy$default(viewState, false, null, null, null, null, null, null, true, false, null, false, false, null, null, null, null, 65407, null));
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(contactNumbers, 10));
            for (String str : contactNumbers) {
                arrayList.add(new RestAPIParams.ContactEntry(str, str, MapsJVM.mapOf(new Tuples2("number", str))));
            }
            RestAPIParams.UploadContacts uploadContacts = new RestAPIParams.UploadContacts(arrayList, false, AllowedInSuggestionsType.ANYONE_WITH_CONTACT_INFO);
            StoreStream.INSTANCE.getContactSync().setContactSyncUploadTimestamp(ClockFactory.get().currentTimeMillis());
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestCallState5.logNetworkAction(this.restAPI.uploadContacts(uploadContacts), AnonymousClass1.INSTANCE), false, 1, null), this, null, 2, null), WidgetContactSyncViewModel.class, (Context) null, (Function1) null, new AnonymousClass3(), (Function0) null, (Function0) null, new AnonymousClass2(), 54, (Object) null);
        }
    }

    @MainThread
    public final void onLandingNext() {
        ViewState viewState = getViewState();
        if (viewState != null) {
            if (viewState.getPhoneNumber() != null) {
                PublishSubject<Event> publishSubject = this.eventsSubject;
                publishSubject.k.onNext(Event.PermissionsNeeded.INSTANCE);
            } else {
                ContactSyncFlowAnalytics contactSyncFlowAnalytics = this.tracker;
                Views views = Views.VIEW_ADD_PHONE;
                ContactSyncFlowAnalytics.trackFlowStep$default(contactSyncFlowAnalytics, views.getTrackingStep(), false, false, null, 8, null);
                updateViewState(ViewState.copy$default(viewState, false, null, null, null, null, null, null, false, false, views, false, false, null, null, null, WidgetContactSyncViewModel3.access$getTOOLBAR_CONFIG_DEFAULT$p(), 32255, null));
            }
        }
    }

    @MainThread
    public final void onNameSubmitted(String name) {
        MGRecyclerAdapterSimple mGRecyclerAdapterSimple;
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        AnalyticsTracker.INSTANCE.nameSubmitted(Strings4.split$default((CharSequence) name, new String[]{" "}, false, 0, 6, (Object) null).size(), name.length());
        String string = StringsJVM.isBlank(name) ? null : Strings4.trim(name).toString();
        ViewState viewState = getViewState();
        if (viewState != null) {
            updateViewState(ViewState.copy$default(viewState, false, null, null, null, null, null, name, false, false, null, false, false, null, null, null, null, 65471, null));
            ConnectedAccount existingConnection = viewState.getExistingConnection();
            if (existingConnection != null) {
                mGRecyclerAdapterSimple = null;
                ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(RestCallState5.logNetworkAction(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.updateConnection(existingConnection.getType(), existingConnection.getId(), new RestAPIParams.ConnectedAccount(true, existingConnection.getId(), string, existingConnection.getRevoked(), existingConnection.getShowActivity(), existingConnection.getType(), existingConnection.getVerified(), existingConnection.getVisibility())), false, 1, null), new AnonymousClass1(string)), this, null, 2, null), WidgetContactSyncViewModel.class, (Context) null, (Function1) null, new AnonymousClass3(), (Function0) null, (Function0) null, new AnonymousClass2(), 54, (Object) null);
            } else {
                mGRecyclerAdapterSimple = null;
                ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.createConnectionContacts(new RestAPIParams.ConnectedAccountContacts(string, true)), false, 1, null), this, null, 2, null), WidgetContactSyncViewModel.class, (Context) null, (Function1) null, new AnonymousClass5(), (Function0) null, (Function0) null, new AnonymousClass4(), 54, (Object) null);
            }
            int i = viewState.getAllowPhone() ? 2 : 0;
            if (viewState.getAllowEmail()) {
                i |= 4;
            }
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.updateUserSettings(RestAPIParams.UserSettings.INSTANCE.createWithFriendDiscoveryFlags(Integer.valueOf(i))), false, 1, mGRecyclerAdapterSimple), this, mGRecyclerAdapterSimple, 2, mGRecyclerAdapterSimple), WidgetContactSyncViewModel.class, (Context) null, (Function1) null, new AnonymousClass7(), (Function0) null, (Function0) null, AnonymousClass6.INSTANCE, 54, (Object) null);
        }
    }

    @MainThread
    public final void onPermissionsBecameAvailable() {
        ViewState viewState = getViewState();
        if (viewState != null) {
            updateViewState(ViewState.copy$default(viewState, false, null, null, null, null, null, null, false, false, null, false, false, null, null, null, null, 65279, null));
        }
    }

    @MainThread
    public final void onPermissionsDenied() {
        this.tracker.trackFlowStep(Views.VIEW_LANDING.getTrackingStep(), true, false, MapsJVM.mapOf(Tuples.to("mobile_contacts_permission", "denied")));
        AnalyticsTracker.INSTANCE.permissionsAcked("contacts", false);
        ViewState viewState = getViewState();
        if (viewState != null) {
            updateViewState(ViewState.copy$default(viewState, false, null, null, null, null, null, null, false, true, null, false, false, null, null, null, null, 65151, null));
        }
    }

    @MainThread
    public final void onPermissionsGranted() {
        ViewState viewState = getViewState();
        if (viewState == null || viewState.getDisplayedChild() == Views.VIEW_SUGGESTIONS || viewState.getDisplayedChild() == Views.VIEW_SUGGESTIONS_EMPTY) {
            return;
        }
        AnalyticsTracker.INSTANCE.permissionsAcked("contacts", true);
        ContactSyncFlowAnalytics contactSyncFlowAnalytics = this.tracker;
        Views views = Views.VIEW_NAME_INPUT;
        ContactSyncFlowAnalytics.trackFlowStep$default(contactSyncFlowAnalytics, views.getTrackingStep(), false, false, null, 8, null);
        if (viewState.getName() != null) {
            onNameSubmitted(viewState.getName());
        } else {
            updateViewState(ViewState.copy$default(viewState, false, null, null, null, null, null, null, false, false, views, false, false, null, null, null, new ToolbarConfig(false, true), 31871, null));
        }
    }

    @MainThread
    public final void onPermissionsToggle(boolean allowPhone, boolean allowEmail) {
        AnalyticsTracker.INSTANCE.contactSyncToggled(false, allowPhone, allowEmail);
        ViewState viewState = getViewState();
        if (viewState != null) {
            updateViewState(ViewState.copy$default(viewState, false, null, null, null, null, null, null, false, false, null, allowPhone, allowEmail, null, null, null, null, 62463, null));
        }
    }

    @MainThread
    public final void onPhoneNumberSubmitted(String phoneNumber, CaptchaHelper.CaptchaPayload captchaPayload) {
        Intrinsics3.checkNotNullParameter(phoneNumber, "phoneNumber");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.userAddPhone(new RestAPIParams.Phone(phoneNumber, WidgetUserPhoneManage.Companion.Source.CONTACT_SYNC.getSource(), captchaPayload != null ? captchaPayload.getCaptchaKey() : null, captchaPayload != null ? captchaPayload.getCaptchaRqtoken() : null)), false, 1, null), this, null, 2, null), WidgetContactSyncViewModel.class, (Context) null, (Function1) null, new AnonymousClass2(), (Function0) null, (Function0) null, new AnonymousClass1(), 54, (Object) null);
    }

    @MainThread
    public final void onVerifyPhone(String code) {
        Intrinsics3.checkNotNullParameter(code, ModelAuditLogEntry.CHANGE_KEY_CODE);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.userAddPhoneNoPassword(new RestAPIParams.VerificationCodeOnly(code)), false, 1, null), this, null, 2, null), WidgetContactSyncViewModel.class, (Context) null, (Function1) null, new AnonymousClass2(), (Function0) null, (Function0) null, new AnonymousClass1(), 54, (Object) null);
    }

    @MainThread
    public final void requestingPermissions() {
        ContactSyncFlowAnalytics.trackFlowStep$default(this.tracker, "Contacts Permission Requested", false, false, null, 8, null);
    }

    public final void skip() {
        ViewState viewState = getViewState();
        if (viewState != null) {
            int iOrdinal = viewState.getDisplayedChild().ordinal();
            if (iOrdinal == 0) {
                ContactSyncFlowAnalytics.trackEnd$default(this.tracker, true, null, 2, null);
                handleComplete();
                return;
            }
            if (iOrdinal == 1) {
                ContactSyncFlowAnalytics contactSyncFlowAnalytics = this.tracker;
                Views views = Views.VIEW_LANDING;
                ContactSyncFlowAnalytics.trackFlowStep$default(contactSyncFlowAnalytics, views.getTrackingStep(), false, true, null, 8, null);
                updateViewState(ViewState.copy$default(viewState, false, null, null, null, null, null, null, false, false, views, false, false, null, null, null, getLandingToolbarConfig(viewState.getMode()), 32255, null));
                return;
            }
            if (iOrdinal == 2) {
                ContactSyncFlowAnalytics contactSyncFlowAnalytics2 = this.tracker;
                Views views2 = Views.VIEW_ADD_PHONE;
                ContactSyncFlowAnalytics.trackFlowStep$default(contactSyncFlowAnalytics2, views2.getTrackingStep(), false, true, null, 8, null);
                updateViewState(ViewState.copy$default(viewState, false, null, null, null, null, null, null, false, false, views2, false, false, null, null, null, null, 65023, null));
                return;
            }
            if (iOrdinal == 3) {
                onNameSubmitted("");
                return;
            }
            if (iOrdinal == 4) {
                this.tracker.trackEnd(false, Maps6.mapOf(Tuples.to("num_contacts_found", Integer.valueOf(viewState.getFriendSuggestions().size())), Tuples.to("num_contacts_added", 0)));
                handleComplete();
            } else {
                if (iOrdinal != 5) {
                    return;
                }
                this.tracker.trackEnd(false, Maps6.mapOf(Tuples.to("num_contacts_found", Integer.valueOf(viewState.getFriendSuggestions().size())), Tuples.to("num_contacts_added", 0)));
                handleComplete();
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    public WidgetContactSyncViewModel(ContactSyncMode contactSyncMode, boolean z2, boolean z3, RestAPI restAPI, Observable<StoreState> observable, ContactSyncFlowAnalytics contactSyncFlowAnalytics, boolean z4, Function1<? super Error, Unit> function1) {
        ToolbarConfig toolbarConfigAccess$getTOOLBAR_CONFIG_ONBOARDING$p;
        Intrinsics3.checkNotNullParameter(contactSyncMode, "mode");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        Intrinsics3.checkNotNullParameter(observable, "storeObservable");
        Intrinsics3.checkNotNullParameter(contactSyncFlowAnalytics, "tracker");
        Intrinsics3.checkNotNullParameter(function1, "captchaLauncher");
        PhoneCountryCode default_country_code = PhoneCountryCode.INSTANCE.getDEFAULT_COUNTRY_CODE();
        Views views = Views.VIEW_LANDING;
        List listEmptyList = Collections2.emptyList();
        List listEmptyList2 = Collections2.emptyList();
        int iOrdinal = contactSyncMode.ordinal();
        if (iOrdinal == 0) {
            toolbarConfigAccess$getTOOLBAR_CONFIG_ONBOARDING$p = WidgetContactSyncViewModel3.access$getTOOLBAR_CONFIG_ONBOARDING$p();
        } else {
            if (iOrdinal != 1) {
                throw new NoWhenBranchMatchedException();
            }
            toolbarConfigAccess$getTOOLBAR_CONFIG_ONBOARDING$p = WidgetContactSyncViewModel3.access$getTOOLBAR_CONFIG_DEFAULT$p();
        }
        super(new ViewState(false, contactSyncMode, null, null, default_country_code, "", null, false, false, views, z2, z3, null, listEmptyList, listEmptyList2, toolbarConfigAccess$getTOOLBAR_CONFIG_ONBOARDING$p));
        this.restAPI = restAPI;
        this.tracker = contactSyncFlowAnalytics;
        this.initialized = z4;
        this.captchaLauncher = function1;
        this.eventsSubject = PublishSubject.k0();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), WidgetContactSyncViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
