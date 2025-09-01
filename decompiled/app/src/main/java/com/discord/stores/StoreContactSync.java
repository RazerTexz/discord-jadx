package com.discord.stores;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionUserContactsSync;
import com.discord.analytics.generated.traits.TrackNetworkMetadata2;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.api.friendsuggestions.AllowedInSuggestionsType;
import com.discord.api.friendsuggestions.BulkFriendSuggestions;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.user.MeUser;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreUserConnections;
import com.discord.stores.utilities.RestCallState5;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.contacts.ContactsFetcher;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.contact_sync.ContactSyncFlowAnalytics;
import com.discord.widgets.contact_sync.ContactSyncUpsellSheet;
import d0.Tuples;
import d0.t.Iterables2;
import d0.t.MapsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: StoreContactSync.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001BG\u0012\u0006\u00101\u001a\u000200\u0012\u0006\u0010\"\u001a\u00020!\u0012\u0006\u0010:\u001a\u000209\u0012\u0006\u00107\u001a\u000206\u0012\u0006\u0010(\u001a\u00020'\u0012\u0006\u00104\u001a\u000203\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b?\u0010@J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\nH\u0007¢\u0006\u0004\b\u000f\u0010\u000eJ\r\u0010\u0010\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u000eJ\r\u0010\u0011\u001a\u00020\n¢\u0006\u0004\b\u0011\u0010\u000eJ\r\u0010\u0012\u001a\u00020\n¢\u0006\u0004\b\u0012\u0010\u000eJ\u0015\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\n¢\u0006\u0004\b\u0017\u0010\u000eR\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00130\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R(\u0010&\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00050$0\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010 R\u0016\u0010(\u001a\u00020'8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R2\u0010,\u001a\u001e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00050*j\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u0005`+8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010.\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00101\u001a\u0002008\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00104\u001a\u0002038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00107\u001a\u0002068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010:\u001a\u0002098\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010=\u001a\u00020<8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b=\u0010>¨\u0006A"}, d2 = {"Lcom/discord/stores/StoreContactSync;", "Lcom/discord/stores/StoreV2;", "Lcom/discord/stores/StoreNotices$Notice;", "createContactSyncNotice", "()Lcom/discord/stores/StoreNotices$Notice;", "", "getFriendsListUpsellDismissed", "()Z", "Landroid/content/Context;", "context", "", "init", "(Landroid/content/Context;)V", "handleConnectionOpen", "()V", "handlePostConnectionOpen", "backgroundUploadContacts", "dismissUpsell", "dismissFriendsListUpsell", "", "timestamp", "setContactSyncUploadTimestamp", "(J)V", "clearDismissStates", "Lcom/discord/stores/StoreUserSettings;", "userSettingsStore", "Lcom/discord/stores/StoreUserSettings;", "Lcom/discord/stores/StoreNotices;", "noticesStore", "Lcom/discord/stores/StoreNotices;", "Lcom/discord/utilities/persister/Persister;", "uploadTimestampCache", "Lcom/discord/utilities/persister/Persister;", "Lcom/discord/utilities/rest/RestAPI;", "restAPI", "Lcom/discord/utilities/rest/RestAPI;", "", "", "dismissStateCache", "Lcom/discord/stores/StoreUser;", "usersStore", "Lcom/discord/stores/StoreUser;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "dismissState", "Ljava/util/HashMap;", "shouldTryUploadContacts", "Z", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "Lcom/discord/stores/StoreExperiments;", "experimentsStore", "Lcom/discord/stores/StoreExperiments;", "Lcom/discord/stores/StoreUserConnections;", "connectionsStore", "Lcom/discord/stores/StoreUserConnections;", "Lcom/discord/utilities/time/Clock;", "clock", "Lcom/discord/utilities/time/Clock;", "Lcom/discord/utilities/contacts/ContactsFetcher;", "contactsFetcher", "Lcom/discord/utilities/contacts/ContactsFetcher;", "<init>", "(Lcom/discord/stores/Dispatcher;Lcom/discord/utilities/rest/RestAPI;Lcom/discord/utilities/time/Clock;Lcom/discord/stores/StoreUserConnections;Lcom/discord/stores/StoreUser;Lcom/discord/stores/StoreExperiments;Lcom/discord/stores/StoreNotices;Lcom/discord/stores/StoreUserSettings;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreContactSync extends StoreV2 {
    private final Clock clock;
    private final StoreUserConnections connectionsStore;
    private ContactsFetcher contactsFetcher;
    private final HashMap<String, Boolean> dismissState;
    private final Persister<Map<String, Boolean>> dismissStateCache;
    private final Dispatcher dispatcher;
    private final StoreExperiments experimentsStore;
    private final StoreNotices noticesStore;
    private final RestAPI restAPI;
    private boolean shouldTryUploadContacts;
    private final Persister<Long> uploadTimestampCache;
    private final StoreUserSettings userSettingsStore;
    private final StoreUser usersStore;

    /* compiled from: StoreContactSync.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/friendsuggestions/BulkFriendSuggestions;", "it", "Lcom/discord/analytics/generated/traits/TrackNetworkMetadataReceiver;", "invoke", "(Lcom/discord/api/friendsuggestions/BulkFriendSuggestions;)Lcom/discord/analytics/generated/traits/TrackNetworkMetadataReceiver;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreContactSync$backgroundUploadContacts$1, reason: invalid class name */
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

    /* compiled from: StoreContactSync.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreContactSync$clearDismissStates$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreContactSync.access$getDismissState$p(StoreContactSync.this).clear();
            StoreContactSync.this.markChanged();
        }
    }

    /* compiled from: StoreContactSync.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/fragment/app/FragmentActivity;", "appActivity", "", "invoke", "(Landroidx/fragment/app/FragmentActivity;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreContactSync$createContactSyncNotice$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<FragmentActivity, Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
            return Boolean.valueOf(invoke2(fragmentActivity));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(FragmentActivity fragmentActivity) {
            Intrinsics3.checkNotNullParameter(fragmentActivity, "appActivity");
            AnalyticsTracker.INSTANCE.openPopout("Contact Sync", new Traits.Location("Release Upsell", null, null, null, null, 30, null));
            ContactSyncFlowAnalytics.Companion.trackStart$default(ContactSyncFlowAnalytics.INSTANCE, false, MapsJVM.mapOf(Tuples.to("location_page", "Release Upsell")), 1, null);
            ContactSyncUpsellSheet.Companion companion = ContactSyncUpsellSheet.INSTANCE;
            FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(supportFragmentManager, "appActivity.supportFragmentManager");
            companion.show(supportFragmentManager);
            return true;
        }
    }

    /* compiled from: StoreContactSync.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreContactSync$dismissFriendsListUpsell$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreContactSync.access$getDismissState$p(StoreContactSync.this).put("CONTACT_SYNC_DISMISS_FRIENDS_UPSELL", Boolean.TRUE);
            StoreContactSync.this.markChanged();
        }
    }

    /* compiled from: StoreContactSync.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreContactSync$dismissUpsell$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreContactSync.access$getDismissState$p(StoreContactSync.this).put("CONTACT_SYNC_DISMISS_UPSELL", Boolean.TRUE);
            StoreContactSync.this.markChanged();
        }
    }

    /* compiled from: StoreContactSync.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreContactSync$handleConnectionOpen$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreContactSync.this.handlePostConnectionOpen();
        }
    }

    /* compiled from: StoreContactSync.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreContactSync$setContactSyncUploadTimestamp$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $timestamp;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$timestamp = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreContactSync storeContactSync = StoreContactSync.this;
            StoreContactSync.access$setShouldTryUploadContacts$p(storeContactSync, StoreContactSync.access$getClock$p(storeContactSync).currentTimeMillis() - this.$timestamp > 86400000);
            StoreContactSync.this.markChanged();
        }
    }

    public StoreContactSync(Dispatcher dispatcher, RestAPI restAPI, Clock clock, StoreUserConnections storeUserConnections, StoreUser storeUser, StoreExperiments storeExperiments, StoreNotices storeNotices, StoreUserSettings storeUserSettings) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        Intrinsics3.checkNotNullParameter(storeUserConnections, "connectionsStore");
        Intrinsics3.checkNotNullParameter(storeUser, "usersStore");
        Intrinsics3.checkNotNullParameter(storeExperiments, "experimentsStore");
        Intrinsics3.checkNotNullParameter(storeNotices, "noticesStore");
        Intrinsics3.checkNotNullParameter(storeUserSettings, "userSettingsStore");
        this.dispatcher = dispatcher;
        this.restAPI = restAPI;
        this.clock = clock;
        this.connectionsStore = storeUserConnections;
        this.usersStore = storeUser;
        this.experimentsStore = storeExperiments;
        this.noticesStore = storeNotices;
        this.userSettingsStore = storeUserSettings;
        this.dismissStateCache = new Persister<>("CONTACT_SYNC_DISMISS_STATE", new HashMap());
        this.uploadTimestampCache = new Persister<>("CONTACT_SYNC_LAST_UPLOAD_TIME", 0L);
        this.dismissState = new HashMap<>();
    }

    public static final /* synthetic */ Clock access$getClock$p(StoreContactSync storeContactSync) {
        return storeContactSync.clock;
    }

    public static final /* synthetic */ HashMap access$getDismissState$p(StoreContactSync storeContactSync) {
        return storeContactSync.dismissState;
    }

    public static final /* synthetic */ boolean access$getShouldTryUploadContacts$p(StoreContactSync storeContactSync) {
        return storeContactSync.shouldTryUploadContacts;
    }

    public static final /* synthetic */ void access$setShouldTryUploadContacts$p(StoreContactSync storeContactSync, boolean z2) {
        storeContactSync.shouldTryUploadContacts = z2;
    }

    private final StoreNotices.Notice createContactSyncNotice() {
        return new StoreNotices.Notice("CONTACT_SYNC_UPSELL", null, 1336L, 0, true, null, 0L, false, 0L, AnonymousClass1.INSTANCE, 482, null);
    }

    public final void backgroundUploadContacts() {
        ContactsFetcher contactsFetcher = this.contactsFetcher;
        if (contactsFetcher == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("contactsFetcher");
        }
        Set<String> setFetchContacts = contactsFetcher.fetchContacts();
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(setFetchContacts, 10));
        for (String str : setFetchContacts) {
            arrayList.add(new RestAPIParams.ContactEntry(str, str, MapsJVM.mapOf(new Tuples2("number", str))));
        }
        RestCallState5.logNetworkAction(this.restAPI.uploadContacts(new RestAPIParams.UploadContacts(arrayList, true, AllowedInSuggestionsType.ANYONE_WITH_CONTACT_INFO)), AnonymousClass1.INSTANCE);
        setContactSyncUploadTimestamp(this.clock.currentTimeMillis());
    }

    public final void clearDismissStates() {
        this.dismissStateCache.clear(true);
        getPrefsSessionDurable().edit().remove("CONTACT_SYNC_DISMISS_UPSELL").apply();
        this.dispatcher.schedule(new AnonymousClass1());
    }

    public final void dismissFriendsListUpsell() {
        this.dismissStateCache.set(this.dismissState, true);
        this.dispatcher.schedule(new AnonymousClass1());
    }

    public final void dismissUpsell() {
        getPrefsSessionDurable().edit().putBoolean("CONTACT_SYNC_DISMISS_UPSELL", true).apply();
        this.dispatcher.schedule(new AnonymousClass1());
    }

    public final boolean getFriendsListUpsellDismissed() {
        return Intrinsics3.areEqual(this.dismissState.get("CONTACT_SYNC_DISMISS_FRIENDS_UPSELL"), Boolean.TRUE);
    }

    @Store3
    public final void handleConnectionOpen() {
        this.dispatcher.schedule(new AnonymousClass1());
    }

    @Store3
    public final void handlePostConnectionOpen() {
        ConnectedAccount connectedAccountPrevious;
        MeUser meSnapshot = this.usersStore.getMeSnapshot();
        StoreUserConnections.State stateSnapshot = this.connectionsStore.getStateSnapshot();
        ListIterator<ConnectedAccount> listIterator = stateSnapshot.listIterator(stateSnapshot.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                connectedAccountPrevious = null;
                break;
            } else {
                connectedAccountPrevious = listIterator.previous();
                if (Intrinsics3.areEqual(connectedAccountPrevious.getType(), "contacts")) {
                    break;
                }
            }
        }
        ConnectedAccount connectedAccount = connectedAccountPrevious;
        Boolean bool = this.dismissState.get("CONTACT_SYNC_DISMISS_UPSELL");
        Boolean contactSyncUpsellShown = this.userSettingsStore.getContactSyncUpsellShown();
        boolean z2 = false;
        Experiment userExperiment = this.experimentsStore.getUserExperiment("2021-04_contact_sync_android_main", connectedAccount == null);
        if (userExperiment != null && userExperiment.getBucket() == 1 && connectedAccount == null) {
            UserUtils userUtils = UserUtils.INSTANCE;
            if (userUtils.getHasPhone(meSnapshot)) {
                Boolean bool2 = Boolean.TRUE;
                if ((!Intrinsics3.areEqual(bool, bool2)) && (!Intrinsics3.areEqual(contactSyncUpsellShown, bool2)) && userUtils.getAgeMs(meSnapshot, ClockFactory.get()) > 604800000) {
                    z2 = true;
                }
            }
        }
        if (Intrinsics3.areEqual(bool, Boolean.TRUE) && (!Intrinsics3.areEqual(contactSyncUpsellShown, r0))) {
            this.userSettingsStore.updateContactSyncShown();
        }
        if (z2) {
            this.noticesStore.requestToShow(createContactSyncNotice());
        }
        if (this.shouldTryUploadContacts) {
            backgroundUploadContacts();
        }
    }

    @Override // com.discord.stores.Store
    public void init(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        super.init(context);
        this.contactsFetcher = new ContactsFetcher(context);
        this.dismissState.putAll(this.dismissStateCache.get());
        if (Intrinsics3.areEqual(this.dismissState.get("CONTACT_SYNC_DISMISS_UPSELL"), Boolean.TRUE)) {
            getPrefsSessionDurable().edit().putBoolean("CONTACT_SYNC_DISMISS_UPSELL", true).apply();
        }
        this.dismissState.put("CONTACT_SYNC_DISMISS_UPSELL", Boolean.valueOf(getPrefsSessionDurable().getBoolean("CONTACT_SYNC_DISMISS_UPSELL", false)));
        this.shouldTryUploadContacts = this.clock.currentTimeMillis() - this.uploadTimestampCache.get().longValue() > 86400000;
        markChanged();
    }

    public final void setContactSyncUploadTimestamp(long timestamp) {
        this.uploadTimestampCache.set(Long.valueOf(timestamp), true);
        this.dispatcher.schedule(new AnonymousClass1(timestamp));
    }
}
