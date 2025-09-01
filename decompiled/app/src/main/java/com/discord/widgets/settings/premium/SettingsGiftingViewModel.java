package com.discord.widgets.settings.premium;

import a0.a.a.b;
import android.content.Context;
import androidx.annotation.MainThread;
import androidx.annotation.StringRes;
import androidx.core.app.NotificationCompat;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.BuildConfig;
import com.discord.R;
import com.discord.api.premium.ClaimedOutboundPromotion;
import com.discord.api.premium.OutboundPromotion;
import com.discord.app.AppComponent;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelEntitlement;
import com.discord.models.domain.ModelGift;
import com.discord.models.domain.ModelUserSettings;
import com.discord.stores.StoreEntitlements;
import com.discord.stores.StoreGifting;
import com.discord.stores.StoreGooglePlayPurchases;
import com.discord.stores.StoreOutboundPromotions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserSettingsSystem;
import com.discord.utilities.billing.GooglePlayBillingManager;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.chat.input.MentionUtils;
import com.discord.widgets.settings.premium.ClaimStatus;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t.Sets5;
import d0.t._Collections;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func4;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;
import rx.subscriptions.CompositeSubscription;

/* compiled from: SettingsGiftingViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0090\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 {2\b\u0012\u0004\u0012\u00020\u00020\u0001:\r{|}~\u007f\u0080\u0001\u0081\u0001\u0082\u0001\u0083\u0001BS\u0012\b\b\u0002\u0010`\u001a\u00020_\u0012\b\b\u0002\u0010k\u001a\u00020j\u0012\b\b\u0002\u0010h\u001a\u00020g\u0012\b\b\u0002\u0010q\u001a\u00020p\u0012\b\b\u0002\u0010u\u001a\u00020t\u0012\b\b\u0002\u0010w\u001a\u00020v\u0012\u000e\b\u0002\u0010x\u001a\b\u0012\u0004\u0012\u00020\"0>¢\u0006\u0004\by\u0010zJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJE\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u001c\u0010\u0019\u001a\u0018\u0012\b\u0012\u00060\u0015j\u0002`\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\u00142\u0006\u0010\u001b\u001a\u00020\u001aH\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b \u0010!J%\u0010'\u001a\u00020&2\u0006\u0010#\u001a\u00020\"2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020$0\u0017H\u0002¢\u0006\u0004\b'\u0010(J\u0017\u0010*\u001a\u00020\u00052\u0006\u0010)\u001a\u00020&H\u0003¢\u0006\u0004\b*\u0010+J1\u0010/\u001a\b\u0012\u0004\u0012\u00020.0\u00172\f\u0010-\u001a\b\u0012\u0004\u0012\u00020,0\u00172\f\u0010%\u001a\b\u0012\u0004\u0012\u00020$0\u0017H\u0002¢\u0006\u0004\b/\u00100J\u001b\u00104\u001a\u0002032\n\u00102\u001a\u00060\u0015j\u0002`1H\u0002¢\u0006\u0004\b4\u00105J!\u00108\u001a\u00020\u00052\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u000506¢\u0006\u0004\b8\u00109J\u0013\u0010<\u001a\b\u0012\u0004\u0012\u00020;0:¢\u0006\u0004\b<\u0010=J\u0013\u0010@\u001a\b\u0012\u0004\u0012\u00020?0>¢\u0006\u0004\b@\u0010AJ\u001f\u0010E\u001a\u00020\u00052\u0006\u0010B\u001a\u0002032\u0006\u0010D\u001a\u00020CH\u0007¢\u0006\u0004\bE\u0010FJ+\u0010K\u001a\u00020\u00052\n\u0010H\u001a\u00060\u0015j\u0002`G2\u000e\u0010J\u001a\n\u0018\u00010\u0015j\u0004\u0018\u0001`IH\u0007¢\u0006\u0004\bK\u0010LJ\u0017\u0010M\u001a\u00020\u00052\u0006\u0010B\u001a\u000203H\u0007¢\u0006\u0004\bM\u0010NJ\u0015\u0010P\u001a\u00020\u00052\u0006\u0010O\u001a\u00020.¢\u0006\u0004\bP\u0010QJ\u0015\u0010R\u001a\u00020\u00052\u0006\u0010O\u001a\u00020.¢\u0006\u0004\bR\u0010QJ\u0017\u0010U\u001a\u00020\u00052\u0006\u0010T\u001a\u00020SH\u0007¢\u0006\u0004\bU\u0010VJ\u000f\u0010W\u001a\u00020\u0005H\u0014¢\u0006\u0004\bW\u0010XR:\u0010Z\u001a&\u0012\f\u0012\n Y*\u0004\u0018\u00010?0? Y*\u0012\u0012\f\u0012\n Y*\u0004\u0018\u00010?0?\u0018\u00010:0:8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bZ\u0010[RR\u0010]\u001a>\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020$ Y*\n\u0012\u0004\u0012\u00020$\u0018\u00010\u00170\u0017 Y*\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020$ Y*\n\u0012\u0004\u0012\u00020$\u0018\u00010\u00170\u0017\u0018\u00010\\0\\8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010`\u001a\u00020_8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010c\u001a\u00020b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010dR\"\u00107\u001a\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u0005068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u0010eR:\u0010f\u001a&\u0012\f\u0012\n Y*\u0004\u0018\u00010\"0\" Y*\u0012\u0012\f\u0012\n Y*\u0004\u0018\u00010\"0\"\u0018\u00010\\0\\8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bf\u0010^R\u0016\u0010h\u001a\u00020g8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bh\u0010iR\u0016\u0010k\u001a\u00020j8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bk\u0010lR\u0016\u0010n\u001a\u00020m8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bn\u0010oR\u0016\u0010q\u001a\u00020p8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bq\u0010rR:\u0010s\u001a&\u0012\f\u0012\n Y*\u0004\u0018\u00010;0; Y*\u0012\u0012\f\u0012\n Y*\u0004\u0018\u00010;0;\u0018\u00010:0:8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bs\u0010[¨\u0006\u0084\u0001"}, d2 = {"Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$ViewState;", "Lcom/discord/stores/StoreGifting$GiftState;", "giftState", "", "onHandleGiftCode", "(Lcom/discord/stores/StoreGifting$GiftState;)V", "Lcom/discord/stores/StoreGooglePlayPurchases$Event;", "event", "handleGooglePlayPurchaseEvent", "(Lcom/discord/stores/StoreGooglePlayPurchases$Event;)V", "Lcom/discord/stores/StoreGooglePlayPurchases$QueryState;", "queryState", "handleGooglePlayQueryStateUpdate", "(Lcom/discord/stores/StoreGooglePlayPurchases$QueryState;)V", "Lcom/discord/stores/StoreEntitlements$State;", "entitlementState", "Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$ResolvingGiftState;", "resolvingGiftState", "", "", "Lcom/discord/primitives/Snowflake;", "", "Lcom/discord/models/domain/ModelGift;", "myPurchasedGifts", "Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$OutboundPromoData;", "outboundPromoData", "buildViewState", "(Lcom/discord/stores/StoreEntitlements$State;Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$ResolvingGiftState;Ljava/util/Map;Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$OutboundPromoData;)Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$ViewState;", "", "isUserPremium", "maybeCheckClaimedPromos", "(Z)V", "Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$StoreState;", "storeState", "Lcom/discord/api/premium/ClaimedOutboundPromotion;", "claimedPromos", "Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$GiftAndPromoData;", "combineData", "(Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$StoreState;Ljava/util/List;)Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$GiftAndPromoData;", "data", "handleAsyncData", "(Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$GiftAndPromoData;)V", "Lcom/discord/api/premium/OutboundPromotion;", "validActivePromos", "Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$OutboundPromoItem;", "getPromos", "(Ljava/util/List;Ljava/util/List;)Ljava/util/List;", "Lcom/discord/primitives/PromoId;", "promoId", "", "getPromoImageUrl", "(J)Ljava/lang/String;", "Lkotlin/Function1;", "onGiftCodeResolved", "setOnGiftCodeResolved", "(Lkotlin/jvm/functions/Function1;)V", "Lrx/subjects/PublishSubject;", "Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$GiftPurchaseEvent;", "observeGiftPurchaseEvents", "()Lrx/subjects/PublishSubject;", "Lrx/Observable;", "Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$Event;", "observeEvents", "()Lrx/Observable;", "giftCode", "Lcom/discord/app/AppComponent;", "appComponent", "redeemGiftCode", "(Ljava/lang/String;Lcom/discord/app/AppComponent;)V", "Lcom/discord/primitives/SkuId;", "skuId", "Lcom/discord/primitives/PlanId;", "planId", "handleSkuClicked", "(JLjava/lang/Long;)V", "handleCopyClicked", "(Ljava/lang/String;)V", "promoItem", "handlePromoMoreDetailsClicked", "(Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$OutboundPromoItem;)V", "handlePromoButtonClicked", "Lcom/discord/widgets/settings/premium/ClaimStatus$Claimed;", "claimedStatus", "handleClaimedPromo", "(Lcom/discord/widgets/settings/premium/ClaimStatus$Claimed;)V", "onCleared", "()V", "kotlin.jvm.PlatformType", "eventSubject", "Lrx/subjects/PublishSubject;", "Lrx/subjects/BehaviorSubject;", "claimedPromotionsSubject", "Lrx/subjects/BehaviorSubject;", "Lcom/discord/stores/StoreEntitlements;", "storeEntitlements", "Lcom/discord/stores/StoreEntitlements;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "shouldCheckClaimedPromos", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Lkotlin/jvm/functions/Function1;", "storeStateSubject", "Lcom/discord/stores/StoreUserSettingsSystem;", "storeUserSettingsSystem", "Lcom/discord/stores/StoreUserSettingsSystem;", "Lcom/discord/stores/StoreGifting;", "storeGifting", "Lcom/discord/stores/StoreGifting;", "Lrx/subscriptions/CompositeSubscription;", "subscriptions", "Lrx/subscriptions/CompositeSubscription;", "Lcom/discord/stores/StoreOutboundPromotions;", "storeOutboundPromotions", "Lcom/discord/stores/StoreOutboundPromotions;", "giftPurchaseEventSubject", "Lcom/discord/stores/StoreGooglePlayPurchases;", "storeGooglePlayPurchases", "Lcom/discord/utilities/billing/GooglePlayBillingManager;", "gPlayBillingManager", "storeObservable", "<init>", "(Lcom/discord/stores/StoreEntitlements;Lcom/discord/stores/StoreGifting;Lcom/discord/stores/StoreUserSettingsSystem;Lcom/discord/stores/StoreOutboundPromotions;Lcom/discord/stores/StoreGooglePlayPurchases;Lcom/discord/utilities/billing/GooglePlayBillingManager;Lrx/Observable;)V", "Companion", "Event", "GiftAndPromoData", "GiftPurchaseEvent", "OutboundPromoData", "OutboundPromoItem", "ResolvingGiftState", "StoreState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class SettingsGiftingViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final BehaviorSubject<List<ClaimedOutboundPromotion>> claimedPromotionsSubject;
    private final PublishSubject<Event> eventSubject;
    private final PublishSubject<GiftPurchaseEvent> giftPurchaseEventSubject;
    private Function1<? super String, Unit> onGiftCodeResolved;
    private AtomicBoolean shouldCheckClaimedPromos;
    private final StoreEntitlements storeEntitlements;
    private final StoreGifting storeGifting;
    private final StoreOutboundPromotions storeOutboundPromotions;
    private final BehaviorSubject<StoreState> storeStateSubject;
    private final StoreUserSettingsSystem storeUserSettingsSystem;
    private final CompositeSubscription subscriptions;

    /* compiled from: SettingsGiftingViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/stores/StoreGooglePlayPurchases$Event;", "p1", "", "invoke", "(Lcom/discord/stores/StoreGooglePlayPurchases$Event;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.premium.SettingsGiftingViewModel$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<StoreGooglePlayPurchases.Event, Unit> {
        public AnonymousClass1(SettingsGiftingViewModel settingsGiftingViewModel) {
            super(1, settingsGiftingViewModel, SettingsGiftingViewModel.class, "handleGooglePlayPurchaseEvent", "handleGooglePlayPurchaseEvent(Lcom/discord/stores/StoreGooglePlayPurchases$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreGooglePlayPurchases.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreGooglePlayPurchases.Event event) {
            Intrinsics3.checkNotNullParameter(event, "p1");
            SettingsGiftingViewModel.access$handleGooglePlayPurchaseEvent((SettingsGiftingViewModel) this.receiver, event);
        }
    }

    /* compiled from: SettingsGiftingViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/stores/StoreGooglePlayPurchases$QueryState;", "p1", "", "invoke", "(Lcom/discord/stores/StoreGooglePlayPurchases$QueryState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.premium.SettingsGiftingViewModel$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<StoreGooglePlayPurchases.QueryState, Unit> {
        public AnonymousClass2(SettingsGiftingViewModel settingsGiftingViewModel) {
            super(1, settingsGiftingViewModel, SettingsGiftingViewModel.class, "handleGooglePlayQueryStateUpdate", "handleGooglePlayQueryStateUpdate(Lcom/discord/stores/StoreGooglePlayPurchases$QueryState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreGooglePlayPurchases.QueryState queryState) {
            invoke2(queryState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreGooglePlayPurchases.QueryState queryState) {
            Intrinsics3.checkNotNullParameter(queryState, "p1");
            SettingsGiftingViewModel.access$handleGooglePlayQueryStateUpdate((SettingsGiftingViewModel) this.receiver, queryState);
        }
    }

    /* compiled from: SettingsGiftingViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$StoreState;", "kotlin.jvm.PlatformType", "storeState", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.premium.SettingsGiftingViewModel$3, reason: invalid class name */
    public static final class AnonymousClass3<T> implements Action1<StoreState> {
        public AnonymousClass3() {
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(StoreState storeState) {
            call2(storeState);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(StoreState storeState) {
            SettingsGiftingViewModel.access$maybeCheckClaimedPromos(SettingsGiftingViewModel.this, storeState.isUserPremium());
        }
    }

    /* compiled from: SettingsGiftingViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$StoreState;", "kotlin.jvm.PlatformType", "p1", "", "invoke", "(Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.premium.SettingsGiftingViewModel$4, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function1<StoreState, Unit> {
        public AnonymousClass4(BehaviorSubject behaviorSubject) {
            super(1, behaviorSubject, BehaviorSubject.class, "onNext", "onNext(Ljava/lang/Object;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            ((BehaviorSubject) this.receiver).onNext(storeState);
        }
    }

    /* compiled from: SettingsGiftingViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$StoreState;", "p1", "", "Lcom/discord/api/premium/ClaimedOutboundPromotion;", "p2", "Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$GiftAndPromoData;", "invoke", "(Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$StoreState;Ljava/util/List;)Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$GiftAndPromoData;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.premium.SettingsGiftingViewModel$5, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass5 extends FunctionReferenceImpl implements Function2<StoreState, List<? extends ClaimedOutboundPromotion>, GiftAndPromoData> {
        public AnonymousClass5(SettingsGiftingViewModel settingsGiftingViewModel) {
            super(2, settingsGiftingViewModel, SettingsGiftingViewModel.class, "combineData", "combineData(Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$StoreState;Ljava/util/List;)Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$GiftAndPromoData;", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ GiftAndPromoData invoke(StoreState storeState, List<? extends ClaimedOutboundPromotion> list) {
            return invoke2(storeState, (List<ClaimedOutboundPromotion>) list);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final GiftAndPromoData invoke2(StoreState storeState, List<ClaimedOutboundPromotion> list) {
            Intrinsics3.checkNotNullParameter(storeState, "p1");
            Intrinsics3.checkNotNullParameter(list, "p2");
            return SettingsGiftingViewModel.access$combineData((SettingsGiftingViewModel) this.receiver, storeState, list);
        }
    }

    /* compiled from: SettingsGiftingViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$GiftAndPromoData;", "p1", "", "invoke", "(Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$GiftAndPromoData;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.premium.SettingsGiftingViewModel$6, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass6 extends FunctionReferenceImpl implements Function1<GiftAndPromoData, Unit> {
        public AnonymousClass6(SettingsGiftingViewModel settingsGiftingViewModel) {
            super(1, settingsGiftingViewModel, SettingsGiftingViewModel.class, "handleAsyncData", "handleAsyncData(Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$GiftAndPromoData;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GiftAndPromoData giftAndPromoData) {
            invoke2(giftAndPromoData);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GiftAndPromoData giftAndPromoData) {
            Intrinsics3.checkNotNullParameter(giftAndPromoData, "p1");
            SettingsGiftingViewModel.access$handleAsyncData((SettingsGiftingViewModel) this.receiver, giftAndPromoData);
        }
    }

    /* compiled from: SettingsGiftingViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$Companion;", "", "Lrx/Observable;", "Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$StoreState;", "observeStores", "()Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStores(Companion companion) {
            return companion.observeStores();
        }

        private final Observable<StoreState> observeStores() {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable<StoreEntitlements.State> observableObserveEntitlementState = companion.getEntitlements().observeEntitlementState();
            Observable<R> observableY = companion.getUsers().observeMeId().Y(SettingsGiftingViewModel2.INSTANCE);
            Observable<StoreOutboundPromotions.State> observableObserveState = companion.getOutboundPromotions().observeState();
            Observable observableG = StoreUser.observeMe$default(companion.getUsers(), false, 1, null).G(SettingsGiftingViewModel3.INSTANCE);
            SettingsGiftingViewModel4 settingsGiftingViewModel4 = SettingsGiftingViewModel4.INSTANCE;
            Object settingsGiftingViewModel7 = settingsGiftingViewModel4;
            if (settingsGiftingViewModel4 != null) {
                settingsGiftingViewModel7 = new SettingsGiftingViewModel7(settingsGiftingViewModel4);
            }
            Observable<StoreState> observableR = Observable.h(observableObserveEntitlementState, observableY, observableObserveState, observableG, (Func4) settingsGiftingViewModel7).r();
            Intrinsics3.checkNotNullExpressionValue(observableR, "Observable\n          .co…  .distinctUntilChanged()");
            return observableR;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: SettingsGiftingViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$Event;", "", "<init>", "()V", "ShowPromoBottomSheet", "ShowPromoDialog", "Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$Event$ShowPromoBottomSheet;", "Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$Event$ShowPromoDialog;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class Event {

        /* compiled from: SettingsGiftingViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$Event$ShowPromoBottomSheet;", "Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$Event;", "", "component1", "()Ljava/lang/String;", "content", "copy", "(Ljava/lang/String;)Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$Event$ShowPromoBottomSheet;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getContent", "<init>", "(Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class ShowPromoBottomSheet extends Event {
            private final String content;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ShowPromoBottomSheet(String str) {
                super(null);
                Intrinsics3.checkNotNullParameter(str, "content");
                this.content = str;
            }

            public static /* synthetic */ ShowPromoBottomSheet copy$default(ShowPromoBottomSheet showPromoBottomSheet, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = showPromoBottomSheet.content;
                }
                return showPromoBottomSheet.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getContent() {
                return this.content;
            }

            public final ShowPromoBottomSheet copy(String content) {
                Intrinsics3.checkNotNullParameter(content, "content");
                return new ShowPromoBottomSheet(content);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof ShowPromoBottomSheet) && Intrinsics3.areEqual(this.content, ((ShowPromoBottomSheet) other).content);
                }
                return true;
            }

            public final String getContent() {
                return this.content;
            }

            public int hashCode() {
                String str = this.content;
                if (str != null) {
                    return str.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.J(outline.U("ShowPromoBottomSheet(content="), this.content, ")");
            }
        }

        /* compiled from: SettingsGiftingViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$Event$ShowPromoDialog;", "Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$Event;", "Lcom/discord/widgets/settings/premium/ClaimStatus;", "component1", "()Lcom/discord/widgets/settings/premium/ClaimStatus;", "claimStatus", "copy", "(Lcom/discord/widgets/settings/premium/ClaimStatus;)Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$Event$ShowPromoDialog;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/widgets/settings/premium/ClaimStatus;", "getClaimStatus", "<init>", "(Lcom/discord/widgets/settings/premium/ClaimStatus;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class ShowPromoDialog extends Event {
            private final ClaimStatus claimStatus;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ShowPromoDialog(ClaimStatus claimStatus) {
                super(null);
                Intrinsics3.checkNotNullParameter(claimStatus, "claimStatus");
                this.claimStatus = claimStatus;
            }

            public static /* synthetic */ ShowPromoDialog copy$default(ShowPromoDialog showPromoDialog, ClaimStatus claimStatus, int i, Object obj) {
                if ((i & 1) != 0) {
                    claimStatus = showPromoDialog.claimStatus;
                }
                return showPromoDialog.copy(claimStatus);
            }

            /* renamed from: component1, reason: from getter */
            public final ClaimStatus getClaimStatus() {
                return this.claimStatus;
            }

            public final ShowPromoDialog copy(ClaimStatus claimStatus) {
                Intrinsics3.checkNotNullParameter(claimStatus, "claimStatus");
                return new ShowPromoDialog(claimStatus);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof ShowPromoDialog) && Intrinsics3.areEqual(this.claimStatus, ((ShowPromoDialog) other).claimStatus);
                }
                return true;
            }

            public final ClaimStatus getClaimStatus() {
                return this.claimStatus;
            }

            public int hashCode() {
                ClaimStatus claimStatus = this.claimStatus;
                if (claimStatus != null) {
                    return claimStatus.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("ShowPromoDialog(claimStatus=");
                sbU.append(this.claimStatus);
                sbU.append(")");
                return sbU.toString();
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: SettingsGiftingViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0082\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\u001c\u0010\u0017\u001a\u0018\u0012\b\u0012\u00060\tj\u0002`\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\b\u0012\u0006\u0010\u0018\u001a\u00020\u000f\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00120\u000b¢\u0006\u0004\b0\u00101J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\r\u001a\u0018\u0012\b\u0012\u00060\tj\u0002`\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\bHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u000bHÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J^\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00052\u001e\b\u0002\u0010\u0017\u001a\u0018\u0012\b\u0012\u00060\tj\u0002`\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\b2\b\b\u0002\u0010\u0018\u001a\u00020\u000f2\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00120\u000bHÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010 \u001a\u00020\u001fHÖ\u0001¢\u0006\u0004\b \u0010!J\u001a\u0010$\u001a\u00020#2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b$\u0010%R\u0019\u0010\u0016\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010&\u001a\u0004\b'\u0010\u0007R\u001f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00120\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010(\u001a\u0004\b)\u0010\u0014R/\u0010\u0017\u001a\u0018\u0012\b\u0012\u00060\tj\u0002`\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010*\u001a\u0004\b+\u0010\u000eR\u0019\u0010\u0018\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010,\u001a\u0004\b-\u0010\u0011R\u0019\u0010\u0015\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010.\u001a\u0004\b/\u0010\u0004¨\u00062"}, d2 = {"Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$GiftAndPromoData;", "", "Lcom/discord/stores/StoreEntitlements$State;", "component1", "()Lcom/discord/stores/StoreEntitlements$State;", "Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$ResolvingGiftState;", "component2", "()Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$ResolvingGiftState;", "", "", "Lcom/discord/primitives/Snowflake;", "", "Lcom/discord/models/domain/ModelGift;", "component3", "()Ljava/util/Map;", "Lcom/discord/stores/StoreOutboundPromotions$State;", "component4", "()Lcom/discord/stores/StoreOutboundPromotions$State;", "Lcom/discord/api/premium/ClaimedOutboundPromotion;", "component5", "()Ljava/util/List;", "entitlementState", "resolvingGiftState", "myPurchasedGifts", "outboundPromoState", "claimedOutboundPromotions", "copy", "(Lcom/discord/stores/StoreEntitlements$State;Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$ResolvingGiftState;Ljava/util/Map;Lcom/discord/stores/StoreOutboundPromotions$State;Ljava/util/List;)Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$GiftAndPromoData;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$ResolvingGiftState;", "getResolvingGiftState", "Ljava/util/List;", "getClaimedOutboundPromotions", "Ljava/util/Map;", "getMyPurchasedGifts", "Lcom/discord/stores/StoreOutboundPromotions$State;", "getOutboundPromoState", "Lcom/discord/stores/StoreEntitlements$State;", "getEntitlementState", "<init>", "(Lcom/discord/stores/StoreEntitlements$State;Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$ResolvingGiftState;Ljava/util/Map;Lcom/discord/stores/StoreOutboundPromotions$State;Ljava/util/List;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class GiftAndPromoData {
        private final List<ClaimedOutboundPromotion> claimedOutboundPromotions;
        private final StoreEntitlements.State entitlementState;
        private final Map<Long, List<ModelGift>> myPurchasedGifts;
        private final StoreOutboundPromotions.State outboundPromoState;
        private final ResolvingGiftState resolvingGiftState;

        /* JADX WARN: Multi-variable type inference failed */
        public GiftAndPromoData(StoreEntitlements.State state, ResolvingGiftState resolvingGiftState, Map<Long, ? extends List<ModelGift>> map, StoreOutboundPromotions.State state2, List<ClaimedOutboundPromotion> list) {
            Intrinsics3.checkNotNullParameter(state, "entitlementState");
            Intrinsics3.checkNotNullParameter(resolvingGiftState, "resolvingGiftState");
            Intrinsics3.checkNotNullParameter(map, "myPurchasedGifts");
            Intrinsics3.checkNotNullParameter(state2, "outboundPromoState");
            Intrinsics3.checkNotNullParameter(list, "claimedOutboundPromotions");
            this.entitlementState = state;
            this.resolvingGiftState = resolvingGiftState;
            this.myPurchasedGifts = map;
            this.outboundPromoState = state2;
            this.claimedOutboundPromotions = list;
        }

        public static /* synthetic */ GiftAndPromoData copy$default(GiftAndPromoData giftAndPromoData, StoreEntitlements.State state, ResolvingGiftState resolvingGiftState, Map map, StoreOutboundPromotions.State state2, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                state = giftAndPromoData.entitlementState;
            }
            if ((i & 2) != 0) {
                resolvingGiftState = giftAndPromoData.resolvingGiftState;
            }
            ResolvingGiftState resolvingGiftState2 = resolvingGiftState;
            if ((i & 4) != 0) {
                map = giftAndPromoData.myPurchasedGifts;
            }
            Map map2 = map;
            if ((i & 8) != 0) {
                state2 = giftAndPromoData.outboundPromoState;
            }
            StoreOutboundPromotions.State state3 = state2;
            if ((i & 16) != 0) {
                list = giftAndPromoData.claimedOutboundPromotions;
            }
            return giftAndPromoData.copy(state, resolvingGiftState2, map2, state3, list);
        }

        /* renamed from: component1, reason: from getter */
        public final StoreEntitlements.State getEntitlementState() {
            return this.entitlementState;
        }

        /* renamed from: component2, reason: from getter */
        public final ResolvingGiftState getResolvingGiftState() {
            return this.resolvingGiftState;
        }

        public final Map<Long, List<ModelGift>> component3() {
            return this.myPurchasedGifts;
        }

        /* renamed from: component4, reason: from getter */
        public final StoreOutboundPromotions.State getOutboundPromoState() {
            return this.outboundPromoState;
        }

        public final List<ClaimedOutboundPromotion> component5() {
            return this.claimedOutboundPromotions;
        }

        public final GiftAndPromoData copy(StoreEntitlements.State entitlementState, ResolvingGiftState resolvingGiftState, Map<Long, ? extends List<ModelGift>> myPurchasedGifts, StoreOutboundPromotions.State outboundPromoState, List<ClaimedOutboundPromotion> claimedOutboundPromotions) {
            Intrinsics3.checkNotNullParameter(entitlementState, "entitlementState");
            Intrinsics3.checkNotNullParameter(resolvingGiftState, "resolvingGiftState");
            Intrinsics3.checkNotNullParameter(myPurchasedGifts, "myPurchasedGifts");
            Intrinsics3.checkNotNullParameter(outboundPromoState, "outboundPromoState");
            Intrinsics3.checkNotNullParameter(claimedOutboundPromotions, "claimedOutboundPromotions");
            return new GiftAndPromoData(entitlementState, resolvingGiftState, myPurchasedGifts, outboundPromoState, claimedOutboundPromotions);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GiftAndPromoData)) {
                return false;
            }
            GiftAndPromoData giftAndPromoData = (GiftAndPromoData) other;
            return Intrinsics3.areEqual(this.entitlementState, giftAndPromoData.entitlementState) && Intrinsics3.areEqual(this.resolvingGiftState, giftAndPromoData.resolvingGiftState) && Intrinsics3.areEqual(this.myPurchasedGifts, giftAndPromoData.myPurchasedGifts) && Intrinsics3.areEqual(this.outboundPromoState, giftAndPromoData.outboundPromoState) && Intrinsics3.areEqual(this.claimedOutboundPromotions, giftAndPromoData.claimedOutboundPromotions);
        }

        public final List<ClaimedOutboundPromotion> getClaimedOutboundPromotions() {
            return this.claimedOutboundPromotions;
        }

        public final StoreEntitlements.State getEntitlementState() {
            return this.entitlementState;
        }

        public final Map<Long, List<ModelGift>> getMyPurchasedGifts() {
            return this.myPurchasedGifts;
        }

        public final StoreOutboundPromotions.State getOutboundPromoState() {
            return this.outboundPromoState;
        }

        public final ResolvingGiftState getResolvingGiftState() {
            return this.resolvingGiftState;
        }

        public int hashCode() {
            StoreEntitlements.State state = this.entitlementState;
            int iHashCode = (state != null ? state.hashCode() : 0) * 31;
            ResolvingGiftState resolvingGiftState = this.resolvingGiftState;
            int iHashCode2 = (iHashCode + (resolvingGiftState != null ? resolvingGiftState.hashCode() : 0)) * 31;
            Map<Long, List<ModelGift>> map = this.myPurchasedGifts;
            int iHashCode3 = (iHashCode2 + (map != null ? map.hashCode() : 0)) * 31;
            StoreOutboundPromotions.State state2 = this.outboundPromoState;
            int iHashCode4 = (iHashCode3 + (state2 != null ? state2.hashCode() : 0)) * 31;
            List<ClaimedOutboundPromotion> list = this.claimedOutboundPromotions;
            return iHashCode4 + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("GiftAndPromoData(entitlementState=");
            sbU.append(this.entitlementState);
            sbU.append(", resolvingGiftState=");
            sbU.append(this.resolvingGiftState);
            sbU.append(", myPurchasedGifts=");
            sbU.append(this.myPurchasedGifts);
            sbU.append(", outboundPromoState=");
            sbU.append(this.outboundPromoState);
            sbU.append(", claimedOutboundPromotions=");
            return outline.L(sbU, this.claimedOutboundPromotions, ")");
        }
    }

    /* compiled from: SettingsGiftingViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$GiftPurchaseEvent;", "", "<init>", "()V", "CompleteGiftPurchase", "ErrorGiftPurchase", "NotInProgress", "StartGiftPurchase", "Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$GiftPurchaseEvent$StartGiftPurchase;", "Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$GiftPurchaseEvent$NotInProgress;", "Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$GiftPurchaseEvent$ErrorGiftPurchase;", "Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$GiftPurchaseEvent$CompleteGiftPurchase;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class GiftPurchaseEvent {

        /* compiled from: SettingsGiftingViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0006\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0015\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$GiftPurchaseEvent$CompleteGiftPurchase;", "Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$GiftPurchaseEvent;", "", "component1", "()Ljava/lang/String;", "component2", "skuName", "newGiftCode", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$GiftPurchaseEvent$CompleteGiftPurchase;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getSkuName", "getNewGiftCode", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class CompleteGiftPurchase extends GiftPurchaseEvent {
            private final String newGiftCode;
            private final String skuName;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CompleteGiftPurchase(String str, String str2) {
                super(null);
                Intrinsics3.checkNotNullParameter(str, "skuName");
                Intrinsics3.checkNotNullParameter(str2, "newGiftCode");
                this.skuName = str;
                this.newGiftCode = str2;
            }

            public static /* synthetic */ CompleteGiftPurchase copy$default(CompleteGiftPurchase completeGiftPurchase, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = completeGiftPurchase.skuName;
                }
                if ((i & 2) != 0) {
                    str2 = completeGiftPurchase.newGiftCode;
                }
                return completeGiftPurchase.copy(str, str2);
            }

            /* renamed from: component1, reason: from getter */
            public final String getSkuName() {
                return this.skuName;
            }

            /* renamed from: component2, reason: from getter */
            public final String getNewGiftCode() {
                return this.newGiftCode;
            }

            public final CompleteGiftPurchase copy(String skuName, String newGiftCode) {
                Intrinsics3.checkNotNullParameter(skuName, "skuName");
                Intrinsics3.checkNotNullParameter(newGiftCode, "newGiftCode");
                return new CompleteGiftPurchase(skuName, newGiftCode);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof CompleteGiftPurchase)) {
                    return false;
                }
                CompleteGiftPurchase completeGiftPurchase = (CompleteGiftPurchase) other;
                return Intrinsics3.areEqual(this.skuName, completeGiftPurchase.skuName) && Intrinsics3.areEqual(this.newGiftCode, completeGiftPurchase.newGiftCode);
            }

            public final String getNewGiftCode() {
                return this.newGiftCode;
            }

            public final String getSkuName() {
                return this.skuName;
            }

            public int hashCode() {
                String str = this.skuName;
                int iHashCode = (str != null ? str.hashCode() : 0) * 31;
                String str2 = this.newGiftCode;
                return iHashCode + (str2 != null ? str2.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("CompleteGiftPurchase(skuName=");
                sbU.append(this.skuName);
                sbU.append(", newGiftCode=");
                return outline.J(sbU, this.newGiftCode, ")");
            }
        }

        /* compiled from: SettingsGiftingViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0003\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\u0004J\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$GiftPurchaseEvent$ErrorGiftPurchase;", "Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$GiftPurchaseEvent;", "", "component1", "()I", "message", "copy", "(I)Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$GiftPurchaseEvent$ErrorGiftPurchase;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getMessage", "<init>", "(I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class ErrorGiftPurchase extends GiftPurchaseEvent {
            private final int message;

            public ErrorGiftPurchase(@StringRes int i) {
                super(null);
                this.message = i;
            }

            public static /* synthetic */ ErrorGiftPurchase copy$default(ErrorGiftPurchase errorGiftPurchase, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = errorGiftPurchase.message;
                }
                return errorGiftPurchase.copy(i);
            }

            /* renamed from: component1, reason: from getter */
            public final int getMessage() {
                return this.message;
            }

            public final ErrorGiftPurchase copy(@StringRes int message) {
                return new ErrorGiftPurchase(message);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof ErrorGiftPurchase) && this.message == ((ErrorGiftPurchase) other).message;
                }
                return true;
            }

            public final int getMessage() {
                return this.message;
            }

            public int hashCode() {
                return this.message;
            }

            public String toString() {
                return outline.B(outline.U("ErrorGiftPurchase(message="), this.message, ")");
            }
        }

        /* compiled from: SettingsGiftingViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$GiftPurchaseEvent$NotInProgress;", "Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$GiftPurchaseEvent;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class NotInProgress extends GiftPurchaseEvent {
            public static final NotInProgress INSTANCE = new NotInProgress();

            private NotInProgress() {
                super(null);
            }
        }

        /* compiled from: SettingsGiftingViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$GiftPurchaseEvent$StartGiftPurchase;", "Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$GiftPurchaseEvent;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class StartGiftPurchase extends GiftPurchaseEvent {
            public static final StartGiftPurchase INSTANCE = new StartGiftPurchase();

            private StartGiftPurchase() {
                super(null);
            }
        }

        private GiftPurchaseEvent() {
        }

        public /* synthetic */ GiftPurchaseEvent(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: SettingsGiftingViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$OutboundPromoData;", "", "<init>", "()V", "Loaded", "Loading", "Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$OutboundPromoData$Loading;", "Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$OutboundPromoData$Loaded;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class OutboundPromoData {

        /* compiled from: SettingsGiftingViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0005¨\u0006\u0018"}, d2 = {"Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$OutboundPromoData$Loaded;", "Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$OutboundPromoData;", "", "Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$OutboundPromoItem;", "component1", "()Ljava/util/List;", "outboundPromos", "copy", "(Ljava/util/List;)Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$OutboundPromoData$Loaded;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getOutboundPromos", "<init>", "(Ljava/util/List;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Loaded extends OutboundPromoData {
            private final List<OutboundPromoItem> outboundPromos;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(List<OutboundPromoItem> list) {
                super(null);
                Intrinsics3.checkNotNullParameter(list, "outboundPromos");
                this.outboundPromos = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = loaded.outboundPromos;
                }
                return loaded.copy(list);
            }

            public final List<OutboundPromoItem> component1() {
                return this.outboundPromos;
            }

            public final Loaded copy(List<OutboundPromoItem> outboundPromos) {
                Intrinsics3.checkNotNullParameter(outboundPromos, "outboundPromos");
                return new Loaded(outboundPromos);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && Intrinsics3.areEqual(this.outboundPromos, ((Loaded) other).outboundPromos);
                }
                return true;
            }

            public final List<OutboundPromoItem> getOutboundPromos() {
                return this.outboundPromos;
            }

            public int hashCode() {
                List<OutboundPromoItem> list = this.outboundPromos;
                if (list != null) {
                    return list.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.L(outline.U("Loaded(outboundPromos="), this.outboundPromos, ")");
            }
        }

        /* compiled from: SettingsGiftingViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$OutboundPromoData$Loading;", "Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$OutboundPromoData;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Loading extends OutboundPromoData {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        private OutboundPromoData() {
        }

        public /* synthetic */ OutboundPromoData(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: SettingsGiftingViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\n\u0010\u000f\u001a\u00060\u0005j\u0002`\u0006\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\t¢\u0006\u0004\b%\u0010&J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\f\u0010\u000bJ\u0010\u0010\r\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\r\u0010\u000bJF\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\f\b\u0002\u0010\u000f\u001a\u00060\u0005j\u0002`\u00062\b\b\u0002\u0010\u0010\u001a\u00020\t2\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u000bJ\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R\u001d\u0010\u000f\u001a\u00060\u0005j\u0002`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001f\u001a\u0004\b \u0010\bR\u0019\u0010\u0012\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010!\u001a\u0004\b\"\u0010\u000bR\u0019\u0010\u0010\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010!\u001a\u0004\b#\u0010\u000bR\u0019\u0010\u0011\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010!\u001a\u0004\b$\u0010\u000b¨\u0006'"}, d2 = {"Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$OutboundPromoItem;", "", "Lcom/discord/widgets/settings/premium/ClaimStatus;", "component1", "()Lcom/discord/widgets/settings/premium/ClaimStatus;", "", "Lcom/discord/primitives/PromoId;", "component2", "()J", "", "component3", "()Ljava/lang/String;", "component4", "component5", "claimStatus", ModelAuditLogEntry.CHANGE_KEY_ID, "title", "terms", "imageUrl", "copy", "(Lcom/discord/widgets/settings/premium/ClaimStatus;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$OutboundPromoItem;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/widgets/settings/premium/ClaimStatus;", "getClaimStatus", "J", "getId", "Ljava/lang/String;", "getImageUrl", "getTitle", "getTerms", "<init>", "(Lcom/discord/widgets/settings/premium/ClaimStatus;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class OutboundPromoItem {
        private final ClaimStatus claimStatus;
        private final long id;
        private final String imageUrl;
        private final String terms;
        private final String title;

        public OutboundPromoItem(ClaimStatus claimStatus, long j, String str, String str2, String str3) {
            Intrinsics3.checkNotNullParameter(claimStatus, "claimStatus");
            Intrinsics3.checkNotNullParameter(str, "title");
            Intrinsics3.checkNotNullParameter(str2, "terms");
            Intrinsics3.checkNotNullParameter(str3, "imageUrl");
            this.claimStatus = claimStatus;
            this.id = j;
            this.title = str;
            this.terms = str2;
            this.imageUrl = str3;
        }

        public static /* synthetic */ OutboundPromoItem copy$default(OutboundPromoItem outboundPromoItem, ClaimStatus claimStatus, long j, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                claimStatus = outboundPromoItem.claimStatus;
            }
            if ((i & 2) != 0) {
                j = outboundPromoItem.id;
            }
            long j2 = j;
            if ((i & 4) != 0) {
                str = outboundPromoItem.title;
            }
            String str4 = str;
            if ((i & 8) != 0) {
                str2 = outboundPromoItem.terms;
            }
            String str5 = str2;
            if ((i & 16) != 0) {
                str3 = outboundPromoItem.imageUrl;
            }
            return outboundPromoItem.copy(claimStatus, j2, str4, str5, str3);
        }

        /* renamed from: component1, reason: from getter */
        public final ClaimStatus getClaimStatus() {
            return this.claimStatus;
        }

        /* renamed from: component2, reason: from getter */
        public final long getId() {
            return this.id;
        }

        /* renamed from: component3, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* renamed from: component4, reason: from getter */
        public final String getTerms() {
            return this.terms;
        }

        /* renamed from: component5, reason: from getter */
        public final String getImageUrl() {
            return this.imageUrl;
        }

        public final OutboundPromoItem copy(ClaimStatus claimStatus, long id2, String title, String terms, String imageUrl) {
            Intrinsics3.checkNotNullParameter(claimStatus, "claimStatus");
            Intrinsics3.checkNotNullParameter(title, "title");
            Intrinsics3.checkNotNullParameter(terms, "terms");
            Intrinsics3.checkNotNullParameter(imageUrl, "imageUrl");
            return new OutboundPromoItem(claimStatus, id2, title, terms, imageUrl);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OutboundPromoItem)) {
                return false;
            }
            OutboundPromoItem outboundPromoItem = (OutboundPromoItem) other;
            return Intrinsics3.areEqual(this.claimStatus, outboundPromoItem.claimStatus) && this.id == outboundPromoItem.id && Intrinsics3.areEqual(this.title, outboundPromoItem.title) && Intrinsics3.areEqual(this.terms, outboundPromoItem.terms) && Intrinsics3.areEqual(this.imageUrl, outboundPromoItem.imageUrl);
        }

        public final ClaimStatus getClaimStatus() {
            return this.claimStatus;
        }

        public final long getId() {
            return this.id;
        }

        public final String getImageUrl() {
            return this.imageUrl;
        }

        public final String getTerms() {
            return this.terms;
        }

        public final String getTitle() {
            return this.title;
        }

        public int hashCode() {
            ClaimStatus claimStatus = this.claimStatus;
            int iA = (b.a(this.id) + ((claimStatus != null ? claimStatus.hashCode() : 0) * 31)) * 31;
            String str = this.title;
            int iHashCode = (iA + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.terms;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.imageUrl;
            return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("OutboundPromoItem(claimStatus=");
            sbU.append(this.claimStatus);
            sbU.append(", id=");
            sbU.append(this.id);
            sbU.append(", title=");
            sbU.append(this.title);
            sbU.append(", terms=");
            sbU.append(this.terms);
            sbU.append(", imageUrl=");
            return outline.J(sbU, this.imageUrl, ")");
        }
    }

    /* compiled from: SettingsGiftingViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$ResolvingGiftState;", "", "<init>", "()V", "Error", "NotResolving", "Resolving", "Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$ResolvingGiftState$NotResolving;", "Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$ResolvingGiftState$Error;", "Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$ResolvingGiftState$Resolving;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ResolvingGiftState {

        /* compiled from: SettingsGiftingViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$ResolvingGiftState$Error;", "Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$ResolvingGiftState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Error extends ResolvingGiftState {
            public static final Error INSTANCE = new Error();

            private Error() {
                super(null);
            }
        }

        /* compiled from: SettingsGiftingViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$ResolvingGiftState$NotResolving;", "Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$ResolvingGiftState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class NotResolving extends ResolvingGiftState {
            public static final NotResolving INSTANCE = new NotResolving();

            private NotResolving() {
                super(null);
            }
        }

        /* compiled from: SettingsGiftingViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$ResolvingGiftState$Resolving;", "Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$ResolvingGiftState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Resolving extends ResolvingGiftState {
            public static final Resolving INSTANCE = new Resolving();

            private Resolving() {
                super(null);
            }
        }

        private ResolvingGiftState() {
        }

        public /* synthetic */ ResolvingGiftState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: SettingsGiftingViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\f¢\u0006\u0004\b%\u0010&J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ>\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\fHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001c\u001a\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u0019\u0010\u0011\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b\u001f\u0010\u000bR\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010 \u001a\u0004\b!\u0010\u0004R\u001f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\"\u001a\u0004\b#\u0010\bR\u0019\u0010\u0012\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010$\u001a\u0004\b\u0012\u0010\u000e¨\u0006'"}, d2 = {"Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$StoreState;", "", "Lcom/discord/stores/StoreEntitlements$State;", "component1", "()Lcom/discord/stores/StoreEntitlements$State;", "", "Lcom/discord/models/domain/ModelGift;", "component2", "()Ljava/util/List;", "Lcom/discord/stores/StoreOutboundPromotions$State;", "component3", "()Lcom/discord/stores/StoreOutboundPromotions$State;", "", "component4", "()Z", "entitlementState", "myResolvedGifts", "outboundPromoState", "isUserPremium", "copy", "(Lcom/discord/stores/StoreEntitlements$State;Ljava/util/List;Lcom/discord/stores/StoreOutboundPromotions$State;Z)Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$StoreState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/stores/StoreOutboundPromotions$State;", "getOutboundPromoState", "Lcom/discord/stores/StoreEntitlements$State;", "getEntitlementState", "Ljava/util/List;", "getMyResolvedGifts", "Z", "<init>", "(Lcom/discord/stores/StoreEntitlements$State;Ljava/util/List;Lcom/discord/stores/StoreOutboundPromotions$State;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class StoreState {
        private final StoreEntitlements.State entitlementState;
        private final boolean isUserPremium;
        private final List<ModelGift> myResolvedGifts;
        private final StoreOutboundPromotions.State outboundPromoState;

        public StoreState(StoreEntitlements.State state, List<ModelGift> list, StoreOutboundPromotions.State state2, boolean z2) {
            Intrinsics3.checkNotNullParameter(state, "entitlementState");
            Intrinsics3.checkNotNullParameter(list, "myResolvedGifts");
            Intrinsics3.checkNotNullParameter(state2, "outboundPromoState");
            this.entitlementState = state;
            this.myResolvedGifts = list;
            this.outboundPromoState = state2;
            this.isUserPremium = z2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StoreState copy$default(StoreState storeState, StoreEntitlements.State state, List list, StoreOutboundPromotions.State state2, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                state = storeState.entitlementState;
            }
            if ((i & 2) != 0) {
                list = storeState.myResolvedGifts;
            }
            if ((i & 4) != 0) {
                state2 = storeState.outboundPromoState;
            }
            if ((i & 8) != 0) {
                z2 = storeState.isUserPremium;
            }
            return storeState.copy(state, list, state2, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final StoreEntitlements.State getEntitlementState() {
            return this.entitlementState;
        }

        public final List<ModelGift> component2() {
            return this.myResolvedGifts;
        }

        /* renamed from: component3, reason: from getter */
        public final StoreOutboundPromotions.State getOutboundPromoState() {
            return this.outboundPromoState;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getIsUserPremium() {
            return this.isUserPremium;
        }

        public final StoreState copy(StoreEntitlements.State entitlementState, List<ModelGift> myResolvedGifts, StoreOutboundPromotions.State outboundPromoState, boolean isUserPremium) {
            Intrinsics3.checkNotNullParameter(entitlementState, "entitlementState");
            Intrinsics3.checkNotNullParameter(myResolvedGifts, "myResolvedGifts");
            Intrinsics3.checkNotNullParameter(outboundPromoState, "outboundPromoState");
            return new StoreState(entitlementState, myResolvedGifts, outboundPromoState, isUserPremium);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.entitlementState, storeState.entitlementState) && Intrinsics3.areEqual(this.myResolvedGifts, storeState.myResolvedGifts) && Intrinsics3.areEqual(this.outboundPromoState, storeState.outboundPromoState) && this.isUserPremium == storeState.isUserPremium;
        }

        public final StoreEntitlements.State getEntitlementState() {
            return this.entitlementState;
        }

        public final List<ModelGift> getMyResolvedGifts() {
            return this.myResolvedGifts;
        }

        public final StoreOutboundPromotions.State getOutboundPromoState() {
            return this.outboundPromoState;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            StoreEntitlements.State state = this.entitlementState;
            int iHashCode = (state != null ? state.hashCode() : 0) * 31;
            List<ModelGift> list = this.myResolvedGifts;
            int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
            StoreOutboundPromotions.State state2 = this.outboundPromoState;
            int iHashCode3 = (iHashCode2 + (state2 != null ? state2.hashCode() : 0)) * 31;
            boolean z2 = this.isUserPremium;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode3 + i;
        }

        public final boolean isUserPremium() {
            return this.isUserPremium;
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(entitlementState=");
            sbU.append(this.entitlementState);
            sbU.append(", myResolvedGifts=");
            sbU.append(this.myResolvedGifts);
            sbU.append(", outboundPromoState=");
            sbU.append(this.outboundPromoState);
            sbU.append(", isUserPremium=");
            return outline.O(sbU, this.isUserPremium, ")");
        }
    }

    /* compiled from: SettingsGiftingViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$ViewState;", "", "<init>", "()V", "Failure", "Loaded", "Loading", "Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$ViewState$Loading;", "Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$ViewState$Failure;", "Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$ViewState$Loaded;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        /* compiled from: SettingsGiftingViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$ViewState$Failure;", "Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Failure extends ViewState {
            public static final Failure INSTANCE = new Failure();

            private Failure() {
                super(null);
            }
        }

        /* compiled from: SettingsGiftingViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001Bu\u0012\u001c\u0010\u0018\u001a\u0018\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0002\u0012\u0006\u0010\u0019\u001a\u00020\t\u0012\u0010\u0010\u001a\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\r0\f\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00100\u0005\u0012\u001c\u0010\u001c\u001a\u0018\u0012\b\u0012\u00060\u0003j\u0002`\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00050\u0002\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b4\u00105J&\u0010\u0007\u001a\u0018\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\r0\fHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0005HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J&\u0010\u0014\u001a\u0018\u0012\b\u0012\u00060\u0003j\u0002`\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00050\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\bJ\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u008a\u0001\u0010\u001e\u001a\u00020\u00002\u001e\b\u0002\u0010\u0018\u001a\u0018\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00022\b\b\u0002\u0010\u0019\u001a\u00020\t2\u0012\b\u0002\u0010\u001a\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\r0\f2\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00100\u00052\u001e\b\u0002\u0010\u001c\u001a\u0018\u0012\b\u0012\u00060\u0003j\u0002`\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00050\u00022\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0015HÆ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b \u0010\u0017J\u0010\u0010\"\u001a\u00020!HÖ\u0001¢\u0006\u0004\b\"\u0010#J\u001a\u0010'\u001a\u00020&2\b\u0010%\u001a\u0004\u0018\u00010$HÖ\u0003¢\u0006\u0004\b'\u0010(R#\u0010\u001a\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\r0\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010)\u001a\u0004\b*\u0010\u000fR/\u0010\u0018\u001a\u0018\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010+\u001a\u0004\b,\u0010\bR/\u0010\u001c\u001a\u0018\u0012\b\u0012\u00060\u0003j\u0002`\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00050\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010+\u001a\u0004\b-\u0010\bR\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010.\u001a\u0004\b/\u0010\u0017R\u0019\u0010\u0019\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u00100\u001a\u0004\b1\u0010\u000bR\u001f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00100\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u00102\u001a\u0004\b3\u0010\u0012¨\u00066"}, d2 = {"Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$ViewState$Loaded;", "Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$ViewState;", "", "", "Lcom/discord/primitives/SkuId;", "", "Lcom/discord/models/domain/ModelEntitlement;", "component1", "()Ljava/util/Map;", "Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$ResolvingGiftState;", "component2", "()Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$ResolvingGiftState;", "", "Lcom/discord/primitives/Snowflake;", "component3", "()Ljava/util/Set;", "Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$OutboundPromoItem;", "component4", "()Ljava/util/List;", "Lcom/discord/models/domain/ModelGift;", "component5", "", "component6", "()Ljava/lang/String;", "myEntitlements", "resolvingGiftState", "expandedSkuOrPlanIds", "outboundPromos", "myPurchasedGifts", "lastCopiedCode", "copy", "(Ljava/util/Map;Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$ResolvingGiftState;Ljava/util/Set;Ljava/util/List;Ljava/util/Map;Ljava/lang/String;)Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$ViewState$Loaded;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Set;", "getExpandedSkuOrPlanIds", "Ljava/util/Map;", "getMyEntitlements", "getMyPurchasedGifts", "Ljava/lang/String;", "getLastCopiedCode", "Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$ResolvingGiftState;", "getResolvingGiftState", "Ljava/util/List;", "getOutboundPromos", "<init>", "(Ljava/util/Map;Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$ResolvingGiftState;Ljava/util/Set;Ljava/util/List;Ljava/util/Map;Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Loaded extends ViewState {
            private final Set<Long> expandedSkuOrPlanIds;
            private final String lastCopiedCode;
            private final Map<Long, List<ModelEntitlement>> myEntitlements;
            private final Map<Long, List<ModelGift>> myPurchasedGifts;
            private final List<OutboundPromoItem> outboundPromos;
            private final ResolvingGiftState resolvingGiftState;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Loaded(Map<Long, ? extends List<ModelEntitlement>> map, ResolvingGiftState resolvingGiftState, Set<Long> set, List<OutboundPromoItem> list, Map<Long, ? extends List<ModelGift>> map2, String str) {
                super(null);
                Intrinsics3.checkNotNullParameter(map, "myEntitlements");
                Intrinsics3.checkNotNullParameter(resolvingGiftState, "resolvingGiftState");
                Intrinsics3.checkNotNullParameter(set, "expandedSkuOrPlanIds");
                Intrinsics3.checkNotNullParameter(list, "outboundPromos");
                Intrinsics3.checkNotNullParameter(map2, "myPurchasedGifts");
                this.myEntitlements = map;
                this.resolvingGiftState = resolvingGiftState;
                this.expandedSkuOrPlanIds = set;
                this.outboundPromos = list;
                this.myPurchasedGifts = map2;
                this.lastCopiedCode = str;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, Map map, ResolvingGiftState resolvingGiftState, Set set, List list, Map map2, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    map = loaded.myEntitlements;
                }
                if ((i & 2) != 0) {
                    resolvingGiftState = loaded.resolvingGiftState;
                }
                ResolvingGiftState resolvingGiftState2 = resolvingGiftState;
                if ((i & 4) != 0) {
                    set = loaded.expandedSkuOrPlanIds;
                }
                Set set2 = set;
                if ((i & 8) != 0) {
                    list = loaded.outboundPromos;
                }
                List list2 = list;
                if ((i & 16) != 0) {
                    map2 = loaded.myPurchasedGifts;
                }
                Map map3 = map2;
                if ((i & 32) != 0) {
                    str = loaded.lastCopiedCode;
                }
                return loaded.copy(map, resolvingGiftState2, set2, list2, map3, str);
            }

            public final Map<Long, List<ModelEntitlement>> component1() {
                return this.myEntitlements;
            }

            /* renamed from: component2, reason: from getter */
            public final ResolvingGiftState getResolvingGiftState() {
                return this.resolvingGiftState;
            }

            public final Set<Long> component3() {
                return this.expandedSkuOrPlanIds;
            }

            public final List<OutboundPromoItem> component4() {
                return this.outboundPromos;
            }

            public final Map<Long, List<ModelGift>> component5() {
                return this.myPurchasedGifts;
            }

            /* renamed from: component6, reason: from getter */
            public final String getLastCopiedCode() {
                return this.lastCopiedCode;
            }

            public final Loaded copy(Map<Long, ? extends List<ModelEntitlement>> myEntitlements, ResolvingGiftState resolvingGiftState, Set<Long> expandedSkuOrPlanIds, List<OutboundPromoItem> outboundPromos, Map<Long, ? extends List<ModelGift>> myPurchasedGifts, String lastCopiedCode) {
                Intrinsics3.checkNotNullParameter(myEntitlements, "myEntitlements");
                Intrinsics3.checkNotNullParameter(resolvingGiftState, "resolvingGiftState");
                Intrinsics3.checkNotNullParameter(expandedSkuOrPlanIds, "expandedSkuOrPlanIds");
                Intrinsics3.checkNotNullParameter(outboundPromos, "outboundPromos");
                Intrinsics3.checkNotNullParameter(myPurchasedGifts, "myPurchasedGifts");
                return new Loaded(myEntitlements, resolvingGiftState, expandedSkuOrPlanIds, outboundPromos, myPurchasedGifts, lastCopiedCode);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return Intrinsics3.areEqual(this.myEntitlements, loaded.myEntitlements) && Intrinsics3.areEqual(this.resolvingGiftState, loaded.resolvingGiftState) && Intrinsics3.areEqual(this.expandedSkuOrPlanIds, loaded.expandedSkuOrPlanIds) && Intrinsics3.areEqual(this.outboundPromos, loaded.outboundPromos) && Intrinsics3.areEqual(this.myPurchasedGifts, loaded.myPurchasedGifts) && Intrinsics3.areEqual(this.lastCopiedCode, loaded.lastCopiedCode);
            }

            public final Set<Long> getExpandedSkuOrPlanIds() {
                return this.expandedSkuOrPlanIds;
            }

            public final String getLastCopiedCode() {
                return this.lastCopiedCode;
            }

            public final Map<Long, List<ModelEntitlement>> getMyEntitlements() {
                return this.myEntitlements;
            }

            public final Map<Long, List<ModelGift>> getMyPurchasedGifts() {
                return this.myPurchasedGifts;
            }

            public final List<OutboundPromoItem> getOutboundPromos() {
                return this.outboundPromos;
            }

            public final ResolvingGiftState getResolvingGiftState() {
                return this.resolvingGiftState;
            }

            public int hashCode() {
                Map<Long, List<ModelEntitlement>> map = this.myEntitlements;
                int iHashCode = (map != null ? map.hashCode() : 0) * 31;
                ResolvingGiftState resolvingGiftState = this.resolvingGiftState;
                int iHashCode2 = (iHashCode + (resolvingGiftState != null ? resolvingGiftState.hashCode() : 0)) * 31;
                Set<Long> set = this.expandedSkuOrPlanIds;
                int iHashCode3 = (iHashCode2 + (set != null ? set.hashCode() : 0)) * 31;
                List<OutboundPromoItem> list = this.outboundPromos;
                int iHashCode4 = (iHashCode3 + (list != null ? list.hashCode() : 0)) * 31;
                Map<Long, List<ModelGift>> map2 = this.myPurchasedGifts;
                int iHashCode5 = (iHashCode4 + (map2 != null ? map2.hashCode() : 0)) * 31;
                String str = this.lastCopiedCode;
                return iHashCode5 + (str != null ? str.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(myEntitlements=");
                sbU.append(this.myEntitlements);
                sbU.append(", resolvingGiftState=");
                sbU.append(this.resolvingGiftState);
                sbU.append(", expandedSkuOrPlanIds=");
                sbU.append(this.expandedSkuOrPlanIds);
                sbU.append(", outboundPromos=");
                sbU.append(this.outboundPromos);
                sbU.append(", myPurchasedGifts=");
                sbU.append(this.myPurchasedGifts);
                sbU.append(", lastCopiedCode=");
                return outline.J(sbU, this.lastCopiedCode, ")");
            }
        }

        /* compiled from: SettingsGiftingViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$ViewState$Loading;", "Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Loading extends ViewState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: SettingsGiftingViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.premium.SettingsGiftingViewModel$handleGooglePlayPurchaseEvent$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass1() {
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
            SettingsGiftingViewModel.access$getStoreEntitlements$p(SettingsGiftingViewModel.this).fetchMyGiftEntitlements();
            PublishSubject publishSubjectAccess$getGiftPurchaseEventSubject$p = SettingsGiftingViewModel.access$getGiftPurchaseEventSubject$p(SettingsGiftingViewModel.this);
            publishSubjectAccess$getGiftPurchaseEventSubject$p.k.onNext(new GiftPurchaseEvent.ErrorGiftPurchase(R.string.billing_error_purchase));
        }
    }

    /* compiled from: SettingsGiftingViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/domain/ModelGift;", "it", "", "invoke", "(Lcom/discord/models/domain/ModelGift;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.premium.SettingsGiftingViewModel$handleGooglePlayPurchaseEvent$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<ModelGift, Unit> {
        public final /* synthetic */ StoreGooglePlayPurchases.Event $event;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(StoreGooglePlayPurchases.Event event) {
            super(1);
            this.$event = event;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelGift modelGift) {
            invoke2(modelGift);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelGift modelGift) {
            Intrinsics3.checkNotNullParameter(modelGift, "it");
            SettingsGiftingViewModel.access$getStoreEntitlements$p(SettingsGiftingViewModel.this).fetchMyGiftEntitlements();
            PublishSubject publishSubjectAccess$getGiftPurchaseEventSubject$p = SettingsGiftingViewModel.access$getGiftPurchaseEventSubject$p(SettingsGiftingViewModel.this);
            publishSubjectAccess$getGiftPurchaseEventSubject$p.k.onNext(new GiftPurchaseEvent.CompleteGiftPurchase(((StoreGooglePlayPurchases.Event.PurchaseQuerySuccess) this.$event).getNewSkuName(), modelGift.getCode()));
        }
    }

    /* compiled from: SettingsGiftingViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Throwable;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.premium.SettingsGiftingViewModel$maybeCheckClaimedPromos$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Action1<Throwable> {
        public AnonymousClass1() {
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Throwable th) {
            call2(th);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Throwable th) {
            SettingsGiftingViewModel.access$getShouldCheckClaimedPromos$p(SettingsGiftingViewModel.this).set(true);
        }
    }

    /* compiled from: SettingsGiftingViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0001*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "Lcom/discord/api/premium/ClaimedOutboundPromotion;", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Throwable;)Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.premium.SettingsGiftingViewModel$maybeCheckClaimedPromos$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements Func1<Throwable, List<? extends ClaimedOutboundPromotion>> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ List<? extends ClaimedOutboundPromotion> call(Throwable th) {
            return call2(th);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final List<ClaimedOutboundPromotion> call2(Throwable th) {
            return Collections2.emptyList();
        }
    }

    /* compiled from: SettingsGiftingViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/discord/api/premium/ClaimedOutboundPromotion;", "kotlin.jvm.PlatformType", "p1", "", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.premium.SettingsGiftingViewModel$maybeCheckClaimedPromos$3, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<List<? extends ClaimedOutboundPromotion>, Unit> {
        public AnonymousClass3(BehaviorSubject behaviorSubject) {
            super(1, behaviorSubject, BehaviorSubject.class, "onNext", "onNext(Ljava/lang/Object;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ClaimedOutboundPromotion> list) {
            invoke2((List<ClaimedOutboundPromotion>) list);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<ClaimedOutboundPromotion> list) {
            ((BehaviorSubject) this.receiver).onNext(list);
        }
    }

    /* compiled from: SettingsGiftingViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lrx/Subscription;", "it", "", "invoke", "(Lrx/Subscription;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.premium.SettingsGiftingViewModel$redeemGiftCode$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Subscription, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, "it");
            SettingsGiftingViewModel.access$getSubscriptions$p(SettingsGiftingViewModel.this).a(subscription);
        }
    }

    /* compiled from: SettingsGiftingViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/stores/StoreGifting$GiftState;", "p1", "", "invoke", "(Lcom/discord/stores/StoreGifting$GiftState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.premium.SettingsGiftingViewModel$redeemGiftCode$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<StoreGifting.GiftState, Unit> {
        public AnonymousClass2(SettingsGiftingViewModel settingsGiftingViewModel) {
            super(1, settingsGiftingViewModel, SettingsGiftingViewModel.class, "onHandleGiftCode", "onHandleGiftCode(Lcom/discord/stores/StoreGifting$GiftState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreGifting.GiftState giftState) {
            invoke2(giftState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreGifting.GiftState giftState) {
            Intrinsics3.checkNotNullParameter(giftState, "p1");
            SettingsGiftingViewModel.access$onHandleGiftCode((SettingsGiftingViewModel) this.receiver, giftState);
        }
    }

    public SettingsGiftingViewModel() {
        this(null, null, null, null, null, null, null, Opcodes.LAND, null);
    }

    public /* synthetic */ SettingsGiftingViewModel(StoreEntitlements storeEntitlements, StoreGifting storeGifting, StoreUserSettingsSystem storeUserSettingsSystem, StoreOutboundPromotions storeOutboundPromotions, StoreGooglePlayPurchases storeGooglePlayPurchases, GooglePlayBillingManager googlePlayBillingManager, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.INSTANCE.getEntitlements() : storeEntitlements, (i & 2) != 0 ? StoreStream.INSTANCE.getGifting() : storeGifting, (i & 4) != 0 ? StoreStream.INSTANCE.getUserSettingsSystem() : storeUserSettingsSystem, (i & 8) != 0 ? StoreStream.INSTANCE.getOutboundPromotions() : storeOutboundPromotions, (i & 16) != 0 ? StoreStream.INSTANCE.getGooglePlayPurchases() : storeGooglePlayPurchases, (i & 32) != 0 ? GooglePlayBillingManager.INSTANCE : googlePlayBillingManager, (i & 64) != 0 ? Companion.access$observeStores(INSTANCE) : observable);
    }

    public static final /* synthetic */ GiftAndPromoData access$combineData(SettingsGiftingViewModel settingsGiftingViewModel, StoreState storeState, List list) {
        return settingsGiftingViewModel.combineData(storeState, list);
    }

    public static final /* synthetic */ PublishSubject access$getGiftPurchaseEventSubject$p(SettingsGiftingViewModel settingsGiftingViewModel) {
        return settingsGiftingViewModel.giftPurchaseEventSubject;
    }

    public static final /* synthetic */ AtomicBoolean access$getShouldCheckClaimedPromos$p(SettingsGiftingViewModel settingsGiftingViewModel) {
        return settingsGiftingViewModel.shouldCheckClaimedPromos;
    }

    public static final /* synthetic */ StoreEntitlements access$getStoreEntitlements$p(SettingsGiftingViewModel settingsGiftingViewModel) {
        return settingsGiftingViewModel.storeEntitlements;
    }

    public static final /* synthetic */ CompositeSubscription access$getSubscriptions$p(SettingsGiftingViewModel settingsGiftingViewModel) {
        return settingsGiftingViewModel.subscriptions;
    }

    public static final /* synthetic */ void access$handleAsyncData(SettingsGiftingViewModel settingsGiftingViewModel, GiftAndPromoData giftAndPromoData) {
        settingsGiftingViewModel.handleAsyncData(giftAndPromoData);
    }

    public static final /* synthetic */ void access$handleGooglePlayPurchaseEvent(SettingsGiftingViewModel settingsGiftingViewModel, StoreGooglePlayPurchases.Event event) {
        settingsGiftingViewModel.handleGooglePlayPurchaseEvent(event);
    }

    public static final /* synthetic */ void access$handleGooglePlayQueryStateUpdate(SettingsGiftingViewModel settingsGiftingViewModel, StoreGooglePlayPurchases.QueryState queryState) {
        settingsGiftingViewModel.handleGooglePlayQueryStateUpdate(queryState);
    }

    public static final /* synthetic */ void access$maybeCheckClaimedPromos(SettingsGiftingViewModel settingsGiftingViewModel, boolean z2) {
        settingsGiftingViewModel.maybeCheckClaimedPromos(z2);
    }

    public static final /* synthetic */ void access$onHandleGiftCode(SettingsGiftingViewModel settingsGiftingViewModel, StoreGifting.GiftState giftState) {
        settingsGiftingViewModel.onHandleGiftCode(giftState);
    }

    public static final /* synthetic */ void access$setShouldCheckClaimedPromos$p(SettingsGiftingViewModel settingsGiftingViewModel, AtomicBoolean atomicBoolean) {
        settingsGiftingViewModel.shouldCheckClaimedPromos = atomicBoolean;
    }

    @MainThread
    private final ViewState buildViewState(StoreEntitlements.State entitlementState, ResolvingGiftState resolvingGiftState, Map<Long, ? extends List<ModelGift>> myPurchasedGifts, OutboundPromoData outboundPromoData) {
        Set<Long> setEmptySet;
        if (!(entitlementState instanceof StoreEntitlements.State.Loaded) || !(outboundPromoData instanceof OutboundPromoData.Loaded)) {
            return entitlementState instanceof StoreEntitlements.State.Failure ? ViewState.Failure.INSTANCE : ViewState.Loading.INSTANCE;
        }
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded == null || (setEmptySet = loaded.getExpandedSkuOrPlanIds()) == null) {
            setEmptySet = Sets5.emptySet();
        }
        Set<Long> set = setEmptySet;
        ViewState viewState2 = getViewState();
        if (!(viewState2 instanceof ViewState.Loaded)) {
            viewState2 = null;
        }
        ViewState.Loaded loaded2 = (ViewState.Loaded) viewState2;
        return new ViewState.Loaded(((StoreEntitlements.State.Loaded) entitlementState).getGiftableEntitlements(), resolvingGiftState, set, ((OutboundPromoData.Loaded) outboundPromoData).getOutboundPromos(), myPurchasedGifts, loaded2 != null ? loaded2.getLastCopiedCode() : null);
    }

    private final GiftAndPromoData combineData(StoreState storeState, List<ClaimedOutboundPromotion> claimedPromos) {
        ResolvingGiftState resolvingGiftState;
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded == null || (resolvingGiftState = loaded.getResolvingGiftState()) == null) {
            resolvingGiftState = ResolvingGiftState.NotResolving.INSTANCE;
        }
        ResolvingGiftState resolvingGiftState2 = resolvingGiftState;
        StoreEntitlements.State entitlementState = storeState.getEntitlementState();
        StoreOutboundPromotions.State outboundPromoState = storeState.getOutboundPromoState();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (entitlementState instanceof StoreEntitlements.State.Loaded) {
            for (ModelGift modelGift : storeState.getMyResolvedGifts()) {
                Long subscriptionPlanId = modelGift.getSubscriptionPlanId();
                long jLongValue = subscriptionPlanId != null ? subscriptionPlanId.longValue() : modelGift.getSkuId();
                if (!linkedHashMap.containsKey(Long.valueOf(jLongValue))) {
                    linkedHashMap.put(Long.valueOf(jLongValue), new ArrayList());
                }
                List list = (List) linkedHashMap.get(Long.valueOf(jLongValue));
                if (list != null) {
                    list.add(modelGift);
                }
            }
        }
        return new GiftAndPromoData(entitlementState, resolvingGiftState2, linkedHashMap, outboundPromoState, claimedPromos);
    }

    private final String getPromoImageUrl(long promoId) {
        String str = Intrinsics3.areEqual(this.storeUserSettingsSystem.getTheme(), ModelUserSettings.THEME_LIGHT) ? "logo-light" : "logo-dark";
        String str2 = BuildConfig.HOST_CDN;
        if (!(BuildConfig.HOST_CDN.length() > 0)) {
            str2 = null;
        }
        if (str2 == null) {
            str2 = BuildConfig.HOST_API;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append("/promotions/");
        sb.append(promoId);
        sb.append(MentionUtils.SLASH_CHAR);
        return outline.J(sb, str, "?size=256");
    }

    private final List<OutboundPromoItem> getPromos(List<OutboundPromotion> validActivePromos, List<ClaimedOutboundPromotion> claimedPromos) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (OutboundPromotion outboundPromotion : validActivePromos) {
            OutboundPromoItem outboundPromoItem = new OutboundPromoItem(new ClaimStatus.Unclaimed(outboundPromotion.getId(), outboundPromotion.getEndDate()), outboundPromotion.getId(), outboundPromotion.getOutboundTitle(), outboundPromotion.getOutboundTermsAndConditions(), getPromoImageUrl(outboundPromotion.getId()));
            linkedHashMap.put(Long.valueOf(outboundPromoItem.getId()), outboundPromoItem);
        }
        for (ClaimedOutboundPromotion claimedOutboundPromotion : claimedPromos) {
            OutboundPromoItem outboundPromoItem2 = new OutboundPromoItem(new ClaimStatus.Claimed(claimedOutboundPromotion.getPromotion().getId(), claimedOutboundPromotion.getCode(), claimedOutboundPromotion.getPromotion().getOutboundRedemptionModalBody(), claimedOutboundPromotion.d(), claimedOutboundPromotion.c()), claimedOutboundPromotion.getPromotion().getId(), claimedOutboundPromotion.getPromotion().getOutboundTitle(), claimedOutboundPromotion.getPromotion().getOutboundTermsAndConditions(), getPromoImageUrl(claimedOutboundPromotion.getPromotion().getId()));
            linkedHashMap.put(Long.valueOf(outboundPromoItem2.getId()), outboundPromoItem2);
        }
        return _Collections.toList(linkedHashMap.values());
    }

    @MainThread
    private final void handleAsyncData(GiftAndPromoData data) {
        OutboundPromoData loaded;
        StoreOutboundPromotions.State outboundPromoState = data.getOutboundPromoState();
        if (outboundPromoState instanceof StoreOutboundPromotions.State.Loaded) {
            loaded = new OutboundPromoData.Loaded(getPromos(((StoreOutboundPromotions.State.Loaded) outboundPromoState).getValidActivePromotions(), data.getClaimedOutboundPromotions()));
        } else if (outboundPromoState instanceof StoreOutboundPromotions.State.Failed) {
            loaded = new OutboundPromoData.Loaded(Collections2.emptyList());
        } else {
            if (!(outboundPromoState instanceof StoreOutboundPromotions.State.Loading)) {
                throw new NoWhenBranchMatchedException();
            }
            loaded = OutboundPromoData.Loading.INSTANCE;
        }
        ViewState viewStateBuildViewState = buildViewState(data.getEntitlementState(), data.getResolvingGiftState(), data.getMyPurchasedGifts(), loaded);
        if (viewStateBuildViewState instanceof ViewState.Loaded) {
            this.storeOutboundPromotions.markSeen();
        }
        updateViewState(viewStateBuildViewState);
    }

    private final void handleGooglePlayPurchaseEvent(StoreGooglePlayPurchases.Event event) {
        if (!(event instanceof StoreGooglePlayPurchases.Event.PurchaseQuerySuccess)) {
            if (event instanceof StoreGooglePlayPurchases.Event.PurchaseQueryFailure) {
                PublishSubject<GiftPurchaseEvent> publishSubject = this.giftPurchaseEventSubject;
                publishSubject.k.onNext(new GiftPurchaseEvent.ErrorGiftPurchase(R.string.billing_error_purchase));
                return;
            }
            return;
        }
        StoreGooglePlayPurchases.Event.PurchaseQuerySuccess purchaseQuerySuccess = (StoreGooglePlayPurchases.Event.PurchaseQuerySuccess) event;
        if (purchaseQuerySuccess.getGiftCode() != null) {
            this.storeEntitlements.fetchMyGiftEntitlements();
            PublishSubject<GiftPurchaseEvent> publishSubject2 = this.giftPurchaseEventSubject;
            publishSubject2.k.onNext(new GiftPurchaseEvent.CompleteGiftPurchase(purchaseQuerySuccess.getNewSkuName(), purchaseQuerySuccess.getGiftCode()));
            return;
        }
        StoreGifting storeGifting = this.storeGifting;
        Long skuId = purchaseQuerySuccess.getSkuId();
        Intrinsics3.checkNotNull(skuId);
        storeGifting.generateGiftCode(skuId.longValue(), purchaseQuerySuccess.getSubscriptionPlanId(), new AnonymousClass2(event), new AnonymousClass1());
    }

    private final void handleGooglePlayQueryStateUpdate(StoreGooglePlayPurchases.QueryState queryState) {
        if (Intrinsics3.areEqual(queryState, StoreGooglePlayPurchases.QueryState.InProgress.INSTANCE)) {
            PublishSubject<GiftPurchaseEvent> publishSubject = this.giftPurchaseEventSubject;
            publishSubject.k.onNext(GiftPurchaseEvent.StartGiftPurchase.INSTANCE);
        } else if (Intrinsics3.areEqual(queryState, StoreGooglePlayPurchases.QueryState.NotInProgress.INSTANCE)) {
            PublishSubject<GiftPurchaseEvent> publishSubject2 = this.giftPurchaseEventSubject;
            publishSubject2.k.onNext(GiftPurchaseEvent.NotInProgress.INSTANCE);
        }
    }

    private final void maybeCheckClaimedPromos(boolean isUserPremium) {
        if (this.shouldCheckClaimedPromos.compareAndSet(true, false)) {
            if (!isUserPremium) {
                this.claimedPromotionsSubject.onNext(Collections2.emptyList());
                return;
            }
            Observable observableM = ObservableExtensionsKt.restSubscribeOn$default(this.storeOutboundPromotions.fetchClaimedOutboundPromotions(), false, 1, null).t(new AnonymousClass1()).M(AnonymousClass2.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableM, "storeOutboundPromotions.…rorReturn { emptyList() }");
            ObservableExtensionsKt.appSubscribe$default(observableM, SettingsGiftingViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass3(this.claimedPromotionsSubject), 62, (Object) null);
        }
    }

    @MainThread
    private final void onHandleGiftCode(StoreGifting.GiftState giftState) {
        ViewState viewStateBuildViewState;
        ModelGift gift;
        ViewState viewState = getViewState();
        ModelGift gift2 = null;
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            StoreEntitlements.State.Loaded loaded2 = new StoreEntitlements.State.Loaded(loaded.getMyEntitlements(), Maps6.emptyMap());
            OutboundPromoData.Loaded loaded3 = new OutboundPromoData.Loaded(loaded.getOutboundPromos());
            if ((giftState instanceof StoreGifting.GiftState.Loading) || (giftState instanceof StoreGifting.GiftState.Redeeming)) {
                viewStateBuildViewState = buildViewState(loaded2, ResolvingGiftState.Resolving.INSTANCE, loaded.getMyPurchasedGifts(), loaded3);
            } else if ((giftState instanceof StoreGifting.GiftState.LoadFailed) || (giftState instanceof StoreGifting.GiftState.RedeemedFailed) || (giftState instanceof StoreGifting.GiftState.Invalid)) {
                viewStateBuildViewState = buildViewState(loaded2, ResolvingGiftState.Error.INSTANCE, loaded.getMyPurchasedGifts(), loaded3);
            } else {
                boolean z2 = giftState instanceof StoreGifting.GiftState.Revoking;
                if (!z2 && !(giftState instanceof StoreGifting.GiftState.Resolved)) {
                    throw new NoWhenBranchMatchedException();
                }
                StoreGifting.GiftState.Resolved resolved = (StoreGifting.GiftState.Resolved) (!(giftState instanceof StoreGifting.GiftState.Resolved) ? null : giftState);
                if (resolved == null || (gift = resolved.getGift()) == null) {
                    if (!z2) {
                        giftState = null;
                    }
                    StoreGifting.GiftState.Revoking revoking = (StoreGifting.GiftState.Revoking) giftState;
                    if (revoking != null) {
                        gift2 = revoking.getGift();
                    }
                } else {
                    gift2 = gift;
                }
                if (gift2 == null) {
                    return;
                }
                if (!gift2.isClaimedByMe()) {
                    this.onGiftCodeResolved.invoke(gift2.getCode());
                }
                viewStateBuildViewState = buildViewState(loaded2, ResolvingGiftState.NotResolving.INSTANCE, loaded.getMyPurchasedGifts(), loaded3);
            }
            updateViewState(viewStateBuildViewState);
        }
    }

    @MainThread
    public final void handleClaimedPromo(ClaimStatus.Claimed claimedStatus) {
        Intrinsics3.checkNotNullParameter(claimedStatus, "claimedStatus");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            List<OutboundPromoItem> outboundPromos = loaded.getOutboundPromos();
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(outboundPromos, 10));
            for (OutboundPromoItem outboundPromoItemCopy$default : outboundPromos) {
                if (outboundPromoItemCopy$default.getId() == claimedStatus.getPromoId()) {
                    outboundPromoItemCopy$default = OutboundPromoItem.copy$default(outboundPromoItemCopy$default, claimedStatus, 0L, null, null, null, 30, null);
                }
                arrayList.add(outboundPromoItemCopy$default);
            }
            updateViewState(ViewState.Loaded.copy$default(loaded, null, null, null, arrayList, null, null, 55, null));
        }
    }

    @MainThread
    public final void handleCopyClicked(String giftCode) {
        Intrinsics3.checkNotNullParameter(giftCode, "giftCode");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateViewState(ViewState.Loaded.copy$default(loaded, null, null, null, null, null, giftCode, 31, null));
        }
    }

    public final void handlePromoButtonClicked(OutboundPromoItem promoItem) {
        Intrinsics3.checkNotNullParameter(promoItem, "promoItem");
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new Event.ShowPromoDialog(promoItem.getClaimStatus()));
    }

    public final void handlePromoMoreDetailsClicked(OutboundPromoItem promoItem) {
        Intrinsics3.checkNotNullParameter(promoItem, "promoItem");
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new Event.ShowPromoBottomSheet(promoItem.getTerms()));
    }

    @MainThread
    public final void handleSkuClicked(long skuId, Long planId) {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            Set mutableSet = _Collections.toMutableSet(loaded.getExpandedSkuOrPlanIds());
            long jLongValue = planId != null ? planId.longValue() : skuId;
            if (mutableSet.contains(Long.valueOf(jLongValue))) {
                mutableSet.remove(Long.valueOf(jLongValue));
            } else {
                mutableSet.add(Long.valueOf(jLongValue));
                this.storeGifting.fetchMyGiftsForSku(skuId, planId);
            }
            updateViewState(ViewState.Loaded.copy$default(loaded, null, null, mutableSet, null, null, null, 59, null));
        }
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final PublishSubject<GiftPurchaseEvent> observeGiftPurchaseEvents() {
        PublishSubject<GiftPurchaseEvent> publishSubject = this.giftPurchaseEventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "giftPurchaseEventSubject");
        return publishSubject;
    }

    @Override // b.a.d.AppViewModel, androidx.view.ViewModel
    public void onCleared() {
        super.onCleared();
        this.subscriptions.b();
    }

    @MainThread
    public final void redeemGiftCode(String giftCode, AppComponent appComponent) {
        Intrinsics3.checkNotNullParameter(giftCode, "giftCode");
        Intrinsics3.checkNotNullParameter(appComponent, "appComponent");
        if (getViewState() instanceof ViewState.Loaded) {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(this.storeGifting.requestGift(giftCode), appComponent, null, 2, null), SettingsGiftingViewModel.class, (Context) null, new AnonymousClass1(), (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(this), 58, (Object) null);
        }
    }

    public final void setOnGiftCodeResolved(Function1<? super String, Unit> onGiftCodeResolved) {
        Intrinsics3.checkNotNullParameter(onGiftCodeResolved, "onGiftCodeResolved");
        this.onGiftCodeResolved = onGiftCodeResolved;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsGiftingViewModel(StoreEntitlements storeEntitlements, StoreGifting storeGifting, StoreUserSettingsSystem storeUserSettingsSystem, StoreOutboundPromotions storeOutboundPromotions, StoreGooglePlayPurchases storeGooglePlayPurchases, GooglePlayBillingManager googlePlayBillingManager, Observable<StoreState> observable) {
        super(ViewState.Loading.INSTANCE);
        Intrinsics3.checkNotNullParameter(storeEntitlements, "storeEntitlements");
        Intrinsics3.checkNotNullParameter(storeGifting, "storeGifting");
        Intrinsics3.checkNotNullParameter(storeUserSettingsSystem, "storeUserSettingsSystem");
        Intrinsics3.checkNotNullParameter(storeOutboundPromotions, "storeOutboundPromotions");
        Intrinsics3.checkNotNullParameter(storeGooglePlayPurchases, "storeGooglePlayPurchases");
        Intrinsics3.checkNotNullParameter(googlePlayBillingManager, "gPlayBillingManager");
        Intrinsics3.checkNotNullParameter(observable, "storeObservable");
        this.storeEntitlements = storeEntitlements;
        this.storeGifting = storeGifting;
        this.storeUserSettingsSystem = storeUserSettingsSystem;
        this.storeOutboundPromotions = storeOutboundPromotions;
        BehaviorSubject<StoreState> behaviorSubjectK0 = BehaviorSubject.k0();
        this.storeStateSubject = behaviorSubjectK0;
        BehaviorSubject<List<ClaimedOutboundPromotion>> behaviorSubjectK02 = BehaviorSubject.k0();
        this.claimedPromotionsSubject = behaviorSubjectK02;
        this.shouldCheckClaimedPromos = new AtomicBoolean(true);
        this.giftPurchaseEventSubject = PublishSubject.k0();
        this.eventSubject = PublishSubject.k0();
        this.onGiftCodeResolved = SettingsGiftingViewModel5.INSTANCE;
        this.subscriptions = new CompositeSubscription();
        storeEntitlements.fetchMyGiftEntitlements();
        googlePlayBillingManager.queryPurchases();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(storeGooglePlayPurchases.observeEvents(), this, null, 2, null), SettingsGiftingViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(storeGooglePlayPurchases.observeQueryState(), this, null, 2, null), SettingsGiftingViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(this), 62, (Object) null);
        Observable observableU = ObservableExtensionsKt.computationLatest(observable).u(new AnonymousClass3());
        Intrinsics3.checkNotNullExpressionValue(observableU, "storeObservable\n        …oreState.isUserPremium) }");
        ObservableExtensionsKt.appSubscribe$default(observableU, SettingsGiftingViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass4(behaviorSubjectK0), 62, (Object) null);
        Intrinsics3.checkNotNullExpressionValue(behaviorSubjectK0, "storeStateSubject");
        Observable observableComputationLatest = ObservableExtensionsKt.computationLatest(behaviorSubjectK0);
        Intrinsics3.checkNotNullExpressionValue(behaviorSubjectK02, "claimedPromotionsSubject");
        Observable observableR = Observable.j(observableComputationLatest, ObservableExtensionsKt.computationLatest(behaviorSubjectK02), new SettingsGiftingViewModel6(new AnonymousClass5(this))).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "Observable.combineLatest…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableR, this, null, 2, null), SettingsGiftingViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass6(this), 62, (Object) null);
    }
}
