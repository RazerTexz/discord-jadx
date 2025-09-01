package com.discord.widgets.settings.premium;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.a.a0.GiftPurchasedDialog;
import b.a.a.a0.WidgetGiftAcceptDialog;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.a.y.m0.GiftSelectView2;
import b.d.b.a.outline;
import com.android.billingclient.api.SkuDetails;
import com.discord.R;
import com.discord.api.premium.SubscriptionPlan;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetSettingsGiftingBinding;
import com.discord.i18n.RenderContext;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelEntitlement;
import com.discord.models.domain.ModelGift;
import com.discord.models.domain.ModelSku;
import com.discord.stores.StoreGifting;
import com.discord.stores.StoreStream;
import com.discord.utilities.KotlinExtensions;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.billing.GooglePlayInAppSku;
import com.discord.utilities.billing.GooglePlayInAppSku2;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.gifting.GiftingUtils;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.premium.BlockRussianPurchasesUtils;
import com.discord.utilities.recycler.SpaceBetweenItemDecoration;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.premium.GiftSelectView;
import com.discord.widgets.settings.premium.ClaimStatus;
import com.discord.widgets.settings.premium.SettingsGiftingViewModel;
import com.discord.widgets.settings.premium.WidgetOutboundPromoTerms;
import com.discord.widgets.settings.premium.WidgetSettingsGiftingAdapter;
import com.discord.widgets.settings.premium.WidgetSettingsPremium;
import com.google.android.material.textfield.TextInputLayout;
import d0.Tuples;
import d0.g0.StringsJVM;
import d0.t.Collections2;
import d0.t.IndexedValue;
import d0.t.Iterators7;
import d0.t.Maps6;
import d0.t._Collections;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: WidgetSettingsGifting.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 82\u00020\u0001:\u00018B\u0007¢\u0006\u0004\b7\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\r\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J3\u0010\u0019\u001a\u00020\u00042\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00112\u0006\u0010\r\u001a\u00020\u00102\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00120\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001f\u0010\u000bR\u001d\u0010%\u001a\u00020 8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001d\u0010+\u001a\u00020&8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020,8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b-\u0010.R\"\u00102\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u0002010/8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00105\u001a\u0002048\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b5\u00106¨\u00069"}, d2 = {"Lcom/discord/widgets/settings/premium/WidgetSettingsGifting;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$GiftPurchaseEvent;", "event", "", "handleGiftPurchaseEvent", "(Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$GiftPurchaseEvent;)V", "Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$Event;", "handleEvent", "(Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$Event;)V", "enableGiftingButtons", "()V", "Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$ViewState;", "viewState", "configureUI", "(Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$ViewState;)V", "Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$ViewState$Loaded;", "", "Lcom/discord/widgets/settings/premium/WidgetSettingsGiftingAdapter$GiftItem;", "generateListItems", "(Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$ViewState$Loaded;)Ljava/util/List;", "Lcom/discord/models/domain/ModelEntitlement;", "entries", "", "listItems", "addGiftItems", "(Ljava/util/List;Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$ViewState$Loaded;Ljava/util/List;)V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel;", "viewModel", "Lcom/discord/databinding/WidgetSettingsGiftingBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetSettingsGiftingBinding;", "binding", "Lcom/discord/widgets/settings/premium/WidgetSettingsGiftingOutboundPromosAdapter;", "promosAdapter", "Lcom/discord/widgets/settings/premium/WidgetSettingsGiftingOutboundPromosAdapter;", "", "Lcom/discord/views/premium/GiftSelectView;", "Lcom/discord/utilities/billing/GooglePlayInAppSku;", "chooseGiftViews", "Ljava/util/Map;", "Lcom/discord/widgets/settings/premium/WidgetSettingsGiftingAdapter;", "giftingAdapter", "Lcom/discord/widgets/settings/premium/WidgetSettingsGiftingAdapter;", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetSettingsGifting extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetSettingsGifting.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsGiftingBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int VIEW_INDEX_FAILURE = 1;
    public static final int VIEW_INDEX_LOADED = 2;
    public static final int VIEW_INDEX_LOADING = 0;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private Map<GiftSelectView, GooglePlayInAppSku> chooseGiftViews;
    private WidgetSettingsGiftingAdapter giftingAdapter;
    private WidgetSettingsGiftingOutboundPromosAdapter promosAdapter;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetSettingsGifting.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\t8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0016\u0010\r\u001a\u00020\t8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/settings/premium/WidgetSettingsGifting$Companion;", "", "Landroid/content/Context;", "context", "Lcom/discord/utilities/analytics/Traits$Location;", ModelAuditLogEntry.CHANGE_KEY_LOCATION, "", "launch", "(Landroid/content/Context;Lcom/discord/utilities/analytics/Traits$Location;)V", "", "VIEW_INDEX_FAILURE", "I", "VIEW_INDEX_LOADED", "VIEW_INDEX_LOADING", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void launch$default(Companion companion, Context context, Traits.Location location, int i, Object obj) {
            if ((i & 2) != 0) {
                location = null;
            }
            companion.launch(context, location);
        }

        public final void launch(Context context, Traits.Location location) {
            Intrinsics3.checkNotNullParameter(context, "context");
            if (BlockRussianPurchasesUtils.INSTANCE.getINSTANCE().showDialog()) {
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("com.discord.intent.extra.EXTRA_LOCATION", location);
            AppScreen2.d(context, WidgetSettingsGifting.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetSettingsGifting.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u00012\u000e\u0010\u0004\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Lcom/discord/primitives/SkuId;", "skuId", "Lcom/discord/primitives/PlanId;", "planId", "", "invoke", "(JLjava/lang/Long;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.premium.WidgetSettingsGifting$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function2<Long, Long, Unit> {
        public AnonymousClass1() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, Long l2) {
            invoke(l.longValue(), l2);
            return Unit.a;
        }

        public final void invoke(long j, Long l) {
            WidgetSettingsGifting.access$getViewModel$p(WidgetSettingsGifting.this).handleSkuClicked(j, l);
        }
    }

    /* compiled from: WidgetSettingsGifting.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "giftCode", "", "invoke", "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.premium.WidgetSettingsGifting$configureUI$2, reason: invalid class name */
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
            Intrinsics3.checkNotNullParameter(str, "giftCode");
            Context context = WidgetSettingsGifting.this.getContext();
            Object systemService = context != null ? context.getSystemService("clipboard") : null;
            ClipboardManager clipboardManager = (ClipboardManager) (systemService instanceof ClipboardManager ? systemService : null);
            if (clipboardManager != null) {
                clipboardManager.setPrimaryClip(ClipData.newPlainText("", GiftingUtils.INSTANCE.generateGiftUrl(str)));
            }
            WidgetSettingsGifting.access$getViewModel$p(WidgetSettingsGifting.this).handleCopyClicked(str);
        }
    }

    /* compiled from: WidgetSettingsGifting.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/domain/ModelGift;", "gift", "", "invoke", "(Lcom/discord/models/domain/ModelGift;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.premium.WidgetSettingsGifting$configureUI$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<ModelGift, Unit> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelGift modelGift) {
            invoke2(modelGift);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelGift modelGift) {
            Intrinsics3.checkNotNullParameter(modelGift, "gift");
            StoreStream.INSTANCE.getGifting().revokeGiftCode(modelGift);
        }
    }

    /* compiled from: WidgetSettingsGifting.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u00012\u000e\u0010\u0004\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Lcom/discord/primitives/SkuId;", "skuId", "Lcom/discord/primitives/PlanId;", "planId", "", "invoke", "(JLjava/lang/Long;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.premium.WidgetSettingsGifting$configureUI$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements Function2<Long, Long, Unit> {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        public AnonymousClass4() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, Long l2) {
            invoke(l.longValue(), l2);
            return Unit.a;
        }

        public final void invoke(long j, Long l) {
            StoreGifting.generateGiftCode$default(StoreStream.INSTANCE.getGifting(), j, l, null, null, 12, null);
        }
    }

    /* compiled from: WidgetSettingsGifting.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/settings/premium/ClaimStatus$Claimed;", "it", "", "invoke", "(Lcom/discord/widgets/settings/premium/ClaimStatus$Claimed;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.premium.WidgetSettingsGifting$handleEvent$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<ClaimStatus.Claimed, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ClaimStatus.Claimed claimed) {
            invoke2(claimed);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ClaimStatus.Claimed claimed) {
            Intrinsics3.checkNotNullParameter(claimed, "it");
            WidgetSettingsGifting.access$getViewModel$p(WidgetSettingsGifting.this).handleClaimedPromo(claimed);
        }
    }

    /* compiled from: WidgetSettingsGifting.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.premium.WidgetSettingsGifting$handleGiftPurchaseEvent$1, reason: invalid class name */
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
            WidgetSettingsGifting.this.requireAppActivity().setResult(-1);
        }
    }

    /* compiled from: WidgetSettingsGifting.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.premium.WidgetSettingsGifting$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            StoreStream.INSTANCE.getEntitlements().fetchMyGiftEntitlements();
        }
    }

    /* compiled from: WidgetSettingsGifting.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/widget/TextView;", "it", "", "invoke", "(Landroid/widget/TextView;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.premium.WidgetSettingsGifting$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<TextView, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
            invoke2(textView);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(TextView textView) {
            Intrinsics3.checkNotNullParameter(textView, "it");
            TextInputLayout textInputLayout = WidgetSettingsGifting.access$getBinding$p(WidgetSettingsGifting.this).k;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.settingsGiftingGiftCodeInputWrap");
            WidgetSettingsGifting.access$getViewModel$p(WidgetSettingsGifting.this).redeemGiftCode(StringsJVM.replace$default(StringsJVM.replace$default(ViewExtensions.getTextOrEmpty(textInputLayout), "https://discord.gift/", "", false, 4, (Object) null), "-", "", false, 4, (Object) null), WidgetSettingsGifting.this);
        }
    }

    /* compiled from: WidgetSettingsGifting.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$OutboundPromoItem;", "p1", "", "invoke", "(Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$OutboundPromoItem;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.premium.WidgetSettingsGifting$onViewBound$3, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<SettingsGiftingViewModel.OutboundPromoItem, Unit> {
        public AnonymousClass3(SettingsGiftingViewModel settingsGiftingViewModel) {
            super(1, settingsGiftingViewModel, SettingsGiftingViewModel.class, "handlePromoMoreDetailsClicked", "handlePromoMoreDetailsClicked(Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$OutboundPromoItem;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SettingsGiftingViewModel.OutboundPromoItem outboundPromoItem) {
            invoke2(outboundPromoItem);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SettingsGiftingViewModel.OutboundPromoItem outboundPromoItem) {
            Intrinsics3.checkNotNullParameter(outboundPromoItem, "p1");
            ((SettingsGiftingViewModel) this.receiver).handlePromoMoreDetailsClicked(outboundPromoItem);
        }
    }

    /* compiled from: WidgetSettingsGifting.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$OutboundPromoItem;", "p1", "", "invoke", "(Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$OutboundPromoItem;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.premium.WidgetSettingsGifting$onViewBound$4, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function1<SettingsGiftingViewModel.OutboundPromoItem, Unit> {
        public AnonymousClass4(SettingsGiftingViewModel settingsGiftingViewModel) {
            super(1, settingsGiftingViewModel, SettingsGiftingViewModel.class, "handlePromoButtonClicked", "handlePromoButtonClicked(Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$OutboundPromoItem;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SettingsGiftingViewModel.OutboundPromoItem outboundPromoItem) {
            invoke2(outboundPromoItem);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SettingsGiftingViewModel.OutboundPromoItem outboundPromoItem) {
            Intrinsics3.checkNotNullParameter(outboundPromoItem, "p1");
            ((SettingsGiftingViewModel) this.receiver).handlePromoButtonClicked(outboundPromoItem);
        }
    }

    /* compiled from: WidgetSettingsGifting.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/i18n/RenderContext;", "", "invoke", "(Lcom/discord/i18n/RenderContext;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.premium.WidgetSettingsGifting$onViewBound$7, reason: invalid class name */
    public static final class AnonymousClass7 extends Lambda implements Function1<RenderContext, Unit> {
        public static final AnonymousClass7 INSTANCE = new AnonymousClass7();

        /* compiled from: WidgetSettingsGifting.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "view", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.settings.premium.WidgetSettingsGifting$onViewBound$7$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<View, Unit> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                Intrinsics3.checkNotNullParameter(view, "view");
                WidgetSettingsPremium.Companion companion = WidgetSettingsPremium.INSTANCE;
                Context context = view.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "view.context");
                WidgetSettingsPremium.Companion.launch$default(companion, context, 0, null, 4, null);
            }
        }

        public AnonymousClass7() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.b("onClick", AnonymousClass1.INSTANCE);
        }
    }

    /* compiled from: WidgetSettingsGifting.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/i18n/RenderContext;", "", "invoke", "(Lcom/discord/i18n/RenderContext;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.premium.WidgetSettingsGifting$onViewBound$8, reason: invalid class name */
    public static final class AnonymousClass8 extends Lambda implements Function1<RenderContext, Unit> {
        public static final AnonymousClass8 INSTANCE = new AnonymousClass8();

        /* compiled from: WidgetSettingsGifting.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "view", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.settings.premium.WidgetSettingsGifting$onViewBound$8$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<View, Unit> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                Intrinsics3.checkNotNullParameter(view, "view");
                WidgetSettingsPremium.Companion companion = WidgetSettingsPremium.INSTANCE;
                Context context = view.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "view.context");
                WidgetSettingsPremium.Companion.launch$default(companion, context, 1, null, 4, null);
            }
        }

        public AnonymousClass8() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.b("onClick", AnonymousClass1.INSTANCE);
        }
    }

    /* compiled from: WidgetSettingsGifting.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$ViewState;", "p1", "", "invoke", "(Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.premium.WidgetSettingsGifting$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<SettingsGiftingViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetSettingsGifting widgetSettingsGifting) {
            super(1, widgetSettingsGifting, WidgetSettingsGifting.class, "configureUI", "configureUI(Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SettingsGiftingViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SettingsGiftingViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            WidgetSettingsGifting.access$configureUI((WidgetSettingsGifting) this.receiver, viewState);
        }
    }

    /* compiled from: WidgetSettingsGifting.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$GiftPurchaseEvent;", "p1", "", "invoke", "(Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$GiftPurchaseEvent;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.premium.WidgetSettingsGifting$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<SettingsGiftingViewModel.GiftPurchaseEvent, Unit> {
        public AnonymousClass2(WidgetSettingsGifting widgetSettingsGifting) {
            super(1, widgetSettingsGifting, WidgetSettingsGifting.class, "handleGiftPurchaseEvent", "handleGiftPurchaseEvent(Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$GiftPurchaseEvent;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SettingsGiftingViewModel.GiftPurchaseEvent giftPurchaseEvent) {
            invoke2(giftPurchaseEvent);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SettingsGiftingViewModel.GiftPurchaseEvent giftPurchaseEvent) {
            Intrinsics3.checkNotNullParameter(giftPurchaseEvent, "p1");
            WidgetSettingsGifting.access$handleGiftPurchaseEvent((WidgetSettingsGifting) this.receiver, giftPurchaseEvent);
        }
    }

    /* compiled from: WidgetSettingsGifting.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$Event;", "p1", "", "invoke", "(Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$Event;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.premium.WidgetSettingsGifting$onViewBoundOrOnResume$3, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<SettingsGiftingViewModel.Event, Unit> {
        public AnonymousClass3(WidgetSettingsGifting widgetSettingsGifting) {
            super(1, widgetSettingsGifting, WidgetSettingsGifting.class, "handleEvent", "handleEvent(Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SettingsGiftingViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SettingsGiftingViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "p1");
            WidgetSettingsGifting.access$handleEvent((WidgetSettingsGifting) this.receiver, event);
        }
    }

    /* compiled from: WidgetSettingsGifting.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "giftCode", "", "invoke", "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.premium.WidgetSettingsGifting$onViewBoundOrOnResume$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements Function1<String, Unit> {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "giftCode");
            WidgetGiftAcceptDialog.INSTANCE.a(str, "Settings - Gifting", 0L);
        }
    }

    public WidgetSettingsGifting() {
        super(R.layout.widget_settings_gifting);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetSettingsGifting2.INSTANCE, null, 2, null);
        WidgetSettingsGifting4 widgetSettingsGifting4 = WidgetSettingsGifting4.INSTANCE;
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(SettingsGiftingViewModel.class), new WidgetSettingsGifting$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetSettingsGifting4));
    }

    public static final /* synthetic */ void access$configureUI(WidgetSettingsGifting widgetSettingsGifting, SettingsGiftingViewModel.ViewState viewState) {
        widgetSettingsGifting.configureUI(viewState);
    }

    public static final /* synthetic */ void access$enableGiftingButtons(WidgetSettingsGifting widgetSettingsGifting) {
        widgetSettingsGifting.enableGiftingButtons();
    }

    public static final /* synthetic */ WidgetSettingsGiftingBinding access$getBinding$p(WidgetSettingsGifting widgetSettingsGifting) {
        return widgetSettingsGifting.getBinding();
    }

    public static final /* synthetic */ SettingsGiftingViewModel access$getViewModel$p(WidgetSettingsGifting widgetSettingsGifting) {
        return widgetSettingsGifting.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetSettingsGifting widgetSettingsGifting, SettingsGiftingViewModel.Event event) {
        widgetSettingsGifting.handleEvent(event);
    }

    public static final /* synthetic */ void access$handleGiftPurchaseEvent(WidgetSettingsGifting widgetSettingsGifting, SettingsGiftingViewModel.GiftPurchaseEvent giftPurchaseEvent) {
        widgetSettingsGifting.handleGiftPurchaseEvent(giftPurchaseEvent);
    }

    private final void addGiftItems(List<ModelEntitlement> entries, SettingsGiftingViewModel.ViewState.Loaded viewState, List<WidgetSettingsGiftingAdapter.GiftItem> listItems) {
        if (entries.isEmpty()) {
            return;
        }
        ModelEntitlement modelEntitlement = (ModelEntitlement) _Collections.first((List) entries);
        Set<Long> expandedSkuOrPlanIds = viewState.getExpandedSkuOrPlanIds();
        SubscriptionPlan subscriptionPlan = modelEntitlement.getSubscriptionPlan();
        boolean zContains = expandedSkuOrPlanIds.contains(Long.valueOf(subscriptionPlan != null ? subscriptionPlan.getId() : modelEntitlement.getSku().getId()));
        ModelSku sku = modelEntitlement.getSku();
        SubscriptionPlan subscriptionPlan2 = modelEntitlement.getSubscriptionPlan();
        listItems.add(new WidgetSettingsGiftingAdapter.GiftItem(1, null, null, Boolean.valueOf(zContains), sku, Integer.valueOf(entries.size()), subscriptionPlan2 != null ? Long.valueOf(subscriptionPlan2.getId()) : null, null, null, 390, null));
        Iterator itWithIndex = Iterators7.withIndex(entries.iterator());
        boolean z2 = false;
        while (itWithIndex.hasNext()) {
            IndexedValue indexedValue = (IndexedValue) itWithIndex.next();
            int iComponent1 = indexedValue.component1();
            ModelEntitlement modelEntitlement2 = (ModelEntitlement) indexedValue.component2();
            Map<Long, List<ModelGift>> myPurchasedGifts = viewState.getMyPurchasedGifts();
            SubscriptionPlan subscriptionPlan3 = modelEntitlement2.getSubscriptionPlan();
            List<ModelGift> list = myPurchasedGifts.get(Long.valueOf(subscriptionPlan3 != null ? subscriptionPlan3.getId() : modelEntitlement2.getSkuId()));
            ModelGift modelGift = (iComponent1 < (list != null ? list.size() : -1) && list != null) ? list.get(iComponent1) : null;
            if (modelGift == null) {
                if (!z2) {
                    z2 = true;
                }
            }
            SubscriptionPlan subscriptionPlan4 = modelEntitlement2.getSubscriptionPlan();
            listItems.add(new WidgetSettingsGiftingAdapter.GiftItem(2, modelGift, modelEntitlement2, Boolean.valueOf(zContains), null, null, subscriptionPlan4 != null ? Long.valueOf(subscriptionPlan4.getId()) : null, Boolean.valueOf(iComponent1 == entries.size() - 1), Boolean.valueOf(modelGift != null && Intrinsics3.areEqual(modelGift.getCode(), viewState.getLastCopiedCode())), 48, null));
        }
    }

    private final void configureUI(SettingsGiftingViewModel.ViewState viewState) {
        if (viewState instanceof SettingsGiftingViewModel.ViewState.Loading) {
            AppViewFlipper appViewFlipper = getBinding().i;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.settingsGiftingFlipper");
            appViewFlipper.setDisplayedChild(0);
            return;
        }
        if (viewState instanceof SettingsGiftingViewModel.ViewState.Failure) {
            AppViewFlipper appViewFlipper2 = getBinding().i;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper2, "binding.settingsGiftingFlipper");
            appViewFlipper2.setDisplayedChild(1);
            return;
        }
        if (viewState instanceof SettingsGiftingViewModel.ViewState.Loaded) {
            AppViewFlipper appViewFlipper3 = getBinding().i;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper3, "binding.settingsGiftingFlipper");
            appViewFlipper3.setDisplayedChild(2);
        }
        SettingsGiftingViewModel.ViewState.Loaded loaded = (SettingsGiftingViewModel.ViewState.Loaded) viewState;
        boolean z2 = loaded.getResolvingGiftState() instanceof SettingsGiftingViewModel.ResolvingGiftState.Resolving;
        CharSequence charSequenceK = loaded.getResolvingGiftState() instanceof SettingsGiftingViewModel.ResolvingGiftState.Error ? FormatUtils.k(this, R.string.application_entitlement_code_redemption_invalid, new Object[0], null, 4) : null;
        ProgressBar progressBar = getBinding().j;
        Intrinsics3.checkNotNullExpressionValue(progressBar, "binding.settingsGiftingGiftCodeInputProgress");
        progressBar.setVisibility(z2 ? 0 : 8);
        TextInputLayout textInputLayout = getBinding().k;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.settingsGiftingGiftCodeInputWrap");
        ViewExtensions.setEnabledAlpha$default(textInputLayout, !z2, 0.0f, 2, null);
        TextInputLayout textInputLayout2 = getBinding().k;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.settingsGiftingGiftCodeInputWrap");
        EditText editText = textInputLayout2.getEditText();
        if (editText != null) {
            editText.setInputType(z2 ? 0 : 524288);
        }
        TextInputLayout textInputLayout3 = getBinding().k;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout3, "binding.settingsGiftingGiftCodeInputWrap");
        textInputLayout3.setError(charSequenceK);
        boolean z3 = !loaded.getOutboundPromos().isEmpty();
        TextView textView = getBinding().r;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.settingsGiftingYourGiftsHeader");
        textView.setVisibility(z3 ? 0 : 8);
        RecyclerView recyclerView = getBinding().f2621s;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.settingsGiftingYourGiftsRecycler");
        recyclerView.setVisibility(z3 ? 0 : 8);
        WidgetSettingsGiftingOutboundPromosAdapter widgetSettingsGiftingOutboundPromosAdapter = this.promosAdapter;
        if (widgetSettingsGiftingOutboundPromosAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("promosAdapter");
        }
        widgetSettingsGiftingOutboundPromosAdapter.submitList(loaded.getOutboundPromos());
        WidgetSettingsGiftingAdapter widgetSettingsGiftingAdapter = this.giftingAdapter;
        if (widgetSettingsGiftingAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("giftingAdapter");
        }
        widgetSettingsGiftingAdapter.configure(generateListItems(loaded), new AnonymousClass1(), new AnonymousClass2(), AnonymousClass3.INSTANCE, AnonymousClass4.INSTANCE);
    }

    private final void enableGiftingButtons() {
        Map<GiftSelectView, GooglePlayInAppSku> map = this.chooseGiftViews;
        if (map == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("chooseGiftViews");
        }
        for (GiftSelectView giftSelectView : map.keySet()) {
            giftSelectView.binding.c.setOnClickListener(new GiftSelectView2(giftSelectView));
        }
    }

    private final List<WidgetSettingsGiftingAdapter.GiftItem> generateListItems(SettingsGiftingViewModel.ViewState.Loaded viewState) {
        ArrayList arrayList = new ArrayList();
        if (viewState.getMyEntitlements().isEmpty()) {
            arrayList.add(new WidgetSettingsGiftingAdapter.GiftItem(0, null, null, null, null, null, null, null, null, 510, null));
        } else {
            for (Map.Entry<Long, List<ModelEntitlement>> entry : viewState.getMyEntitlements().entrySet()) {
                entry.getKey().longValue();
                List<ModelEntitlement> value = entry.getValue();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Object obj : value) {
                    SubscriptionPlan subscriptionPlan = ((ModelEntitlement) obj).getSubscriptionPlan();
                    Long lValueOf = subscriptionPlan != null ? Long.valueOf(subscriptionPlan.getId()) : null;
                    Object arrayList2 = linkedHashMap.get(lValueOf);
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                        linkedHashMap.put(lValueOf, arrayList2);
                    }
                    ((List) arrayList2).add(obj);
                }
                for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                    addGiftItems((List) entry2.getValue(), viewState, arrayList);
                }
            }
        }
        return arrayList;
    }

    private final WidgetSettingsGiftingBinding getBinding() {
        return (WidgetSettingsGiftingBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final SettingsGiftingViewModel getViewModel() {
        return (SettingsGiftingViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(SettingsGiftingViewModel.Event event) {
        Unit unit;
        if (event instanceof SettingsGiftingViewModel.Event.ShowPromoBottomSheet) {
            WidgetOutboundPromoTerms.Companion companion = WidgetOutboundPromoTerms.INSTANCE;
            String content = ((SettingsGiftingViewModel.Event.ShowPromoBottomSheet) event).getContent();
            FragmentManager parentFragmentManager = getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.show(content, parentFragmentManager);
            unit = Unit.a;
        } else {
            if (!(event instanceof SettingsGiftingViewModel.Event.ShowPromoDialog)) {
                throw new NoWhenBranchMatchedException();
            }
            WidgetClaimOutboundPromo.INSTANCE.showAndRegisterForClaimResult(((SettingsGiftingViewModel.Event.ShowPromoDialog) event).getClaimStatus(), this, new AnonymousClass1());
            unit = Unit.a;
        }
        KotlinExtensions.getExhaustive(unit);
    }

    private final void handleGiftPurchaseEvent(SettingsGiftingViewModel.GiftPurchaseEvent event) {
        enableGiftingButtons();
        if (event instanceof SettingsGiftingViewModel.GiftPurchaseEvent.StartGiftPurchase) {
            DimmerView.setDimmed$default(getBinding().f2620b, true, false, 2, null);
            return;
        }
        if (event instanceof SettingsGiftingViewModel.GiftPurchaseEvent.NotInProgress) {
            DimmerView.setDimmed$default(getBinding().f2620b, false, false, 2, null);
            return;
        }
        if (event instanceof SettingsGiftingViewModel.GiftPurchaseEvent.ErrorGiftPurchase) {
            DimmerView.setDimmed$default(getBinding().f2620b, false, false, 2, null);
            AppToast.i(this, ((SettingsGiftingViewModel.GiftPurchaseEvent.ErrorGiftPurchase) event).getMessage(), 0, 4);
            return;
        }
        if (event instanceof SettingsGiftingViewModel.GiftPurchaseEvent.CompleteGiftPurchase) {
            DimmerView.setDimmed$default(getBinding().f2620b, false, false, 2, null);
            GiftPurchasedDialog.Companion companion = GiftPurchasedDialog.INSTANCE;
            FragmentManager parentFragmentManager = getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            AnonymousClass1 anonymousClass1 = new AnonymousClass1();
            SettingsGiftingViewModel.GiftPurchaseEvent.CompleteGiftPurchase completeGiftPurchase = (SettingsGiftingViewModel.GiftPurchaseEvent.CompleteGiftPurchase) event;
            String skuName = completeGiftPurchase.getSkuName();
            String newGiftCode = completeGiftPurchase.getNewGiftCode();
            Objects.requireNonNull(companion);
            Intrinsics3.checkNotNullParameter(parentFragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(anonymousClass1, "onDismiss");
            Intrinsics3.checkNotNullParameter(skuName, "skuName");
            Intrinsics3.checkNotNullParameter(newGiftCode, "giftCode");
            GiftPurchasedDialog giftPurchasedDialog = new GiftPurchasedDialog();
            giftPurchasedDialog.onDismiss = anonymousClass1;
            Bundle bundle = new Bundle();
            bundle.putString("ARG_SKU_NAME", skuName);
            bundle.putString("ARG_GIFT_CODE", newGiftCode);
            giftPurchasedDialog.setArguments(bundle);
            giftPurchasedDialog.show(parentFragmentManager, GiftPurchasedDialog.class.getSimpleName());
        }
    }

    public static final void launch(Context context, Traits.Location location) {
        INSTANCE.launch(context, location);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        this.chooseGiftViews = Maps6.mapOf(Tuples.to(getBinding().c, GooglePlayInAppSku2.getPremiumTier1Month()), Tuples.to(getBinding().d, GooglePlayInAppSku2.getPremiumTier1Year()), Tuples.to(getBinding().e, GooglePlayInAppSku2.getPremiumTier2Month()), Tuples.to(getBinding().f, GooglePlayInAppSku2.getPremiumTier2Year()));
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        getBinding().o.setOnClickListener(AnonymousClass1.INSTANCE);
        TextInputLayout textInputLayout = getBinding().k;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.settingsGiftingGiftCodeInputWrap");
        ViewExtensions.setOnImeActionDone$default(textInputLayout, false, new AnonymousClass2(), 1, null);
        getBinding().k.setErrorTextColor(ColorStateList.valueOf(ColorCompat.getColor(requireContext(), R.color.status_red_500)));
        WidgetSettingsGiftingOutboundPromosAdapter widgetSettingsGiftingOutboundPromosAdapter = new WidgetSettingsGiftingOutboundPromosAdapter(new AnonymousClass3(getViewModel()), new AnonymousClass4(getViewModel()));
        RecyclerView recyclerView = getBinding().f2621s;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.settingsGiftingYourGiftsRecycler");
        recyclerView.setAdapter(widgetSettingsGiftingOutboundPromosAdapter);
        this.promosAdapter = widgetSettingsGiftingOutboundPromosAdapter;
        RecyclerView recyclerView2 = getBinding().f2621s;
        WidgetSettingsGiftingOutboundPromosAdapter widgetSettingsGiftingOutboundPromosAdapter2 = this.promosAdapter;
        if (widgetSettingsGiftingOutboundPromosAdapter2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("promosAdapter");
        }
        recyclerView2.setAdapter(widgetSettingsGiftingOutboundPromosAdapter2);
        Context context = recyclerView2.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        RecyclerView.LayoutManager layoutManager = recyclerView2.getLayoutManager();
        Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        int orientation = ((LinearLayoutManager) layoutManager).getOrientation();
        WidgetSettingsGiftingOutboundPromosAdapter widgetSettingsGiftingOutboundPromosAdapter3 = this.promosAdapter;
        if (widgetSettingsGiftingOutboundPromosAdapter3 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("promosAdapter");
        }
        recyclerView2.addItemDecoration(new SpaceBetweenItemDecoration(context, orientation, widgetSettingsGiftingOutboundPromosAdapter3, DimenUtils.dpToPixels(16), 0, 16, null));
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView3 = getBinding().m;
        Intrinsics3.checkNotNullExpressionValue(recyclerView3, "binding.settingsGiftingGiftsYouPurchasedRecycler");
        this.giftingAdapter = (WidgetSettingsGiftingAdapter) companion.configure(new WidgetSettingsGiftingAdapter(recyclerView3));
        LinkifiedTextView linkifiedTextView = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.premiumTier1GiftLearnMore");
        FormatUtils.m(linkifiedTextView, R.string.premium_classic_payment_gift_blurb_mobile, new Object[0], AnonymousClass7.INSTANCE);
        LinkifiedTextView linkifiedTextView2 = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView2, "binding.premiumTier2GiftLearnMore");
        FormatUtils.m(linkifiedTextView2, R.string.premium_payment_gift_blurb_mobile, new Object[0], AnonymousClass8.INSTANCE);
        Serializable serializableExtra = getMostRecentIntent().getSerializableExtra("com.discord.intent.extra.EXTRA_LOCATION");
        if (!(serializableExtra instanceof Traits.Location)) {
            serializableExtra = null;
        }
        WidgetSettingsGifting3 widgetSettingsGifting3 = new WidgetSettingsGifting3(this, (Traits.Location) serializableExtra);
        Map<GiftSelectView, GooglePlayInAppSku> map = this.chooseGiftViews;
        if (map == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("chooseGiftViews");
        }
        for (Map.Entry<GiftSelectView, GooglePlayInAppSku> entry : map.entrySet()) {
            GiftSelectView key = entry.getKey();
            GooglePlayInAppSku value = entry.getValue();
            Objects.requireNonNull(key);
            Intrinsics3.checkNotNullParameter(value, "inAppSku");
            Intrinsics3.checkNotNullParameter(widgetSettingsGifting3, "onClickPlan");
            key.onClickPlan = widgetSettingsGifting3;
            key.inAppSku = value;
            SkuDetails skuDetails = value.getSkuDetails();
            if (skuDetails != null) {
                TextView textView = key.binding.f;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.planItemName");
                textView.setText(skuDetails.a());
                TextView textView2 = key.binding.g;
                Intrinsics3.checkNotNullExpressionValue(textView2, "binding.planItemPrice");
                textView2.setText(skuDetails.b());
                TextView textView3 = key.binding.d;
                Intrinsics3.checkNotNullExpressionValue(textView3, "binding.planItemCurrentPlan");
                textView3.setVisibility(8);
                Integer iconForSku = GiftingUtils.INSTANCE.getIconForSku(value);
                if (iconForSku != null) {
                    key.binding.e.setImageResource(iconForSku.intValue());
                }
                TextView textView4 = key.binding.g;
                Intrinsics3.checkNotNullExpressionValue(textView4, "binding.planItemPrice");
                Context context2 = textView4.getContext();
                Intrinsics3.checkNotNullExpressionValue(context2, "binding.planItemPrice.context");
                int themedDrawableRes$default = DrawableCompat.getThemedDrawableRes$default(context2, R.attr.ic_navigate_next, 0, 2, (Object) null);
                TextView textView5 = key.binding.g;
                Intrinsics3.checkNotNullExpressionValue(textView5, "binding.planItemPrice");
                DrawableCompat.setCompoundDrawablesCompat$default(textView5, 0, 0, themedDrawableRes$default, 0, 11, (Object) null);
                key.binding.c.setOnClickListener(new GiftSelectView2(key));
            }
        }
        RecyclerView recyclerView4 = getBinding().m;
        Intrinsics3.checkNotNullExpressionValue(recyclerView4, "binding.settingsGiftingGiftsYouPurchasedRecycler");
        recyclerView4.setItemAnimator(null);
        getBinding().m.setHasFixedSize(false);
        for (TextView textView6 : Collections2.listOf((Object[]) new TextView[]{getBinding().n, getBinding().l, getBinding().q, getBinding().p})) {
            AccessibilityUtils accessibilityUtils = AccessibilityUtils.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(textView6, "header");
            accessibilityUtils.setViewIsHeading(textView6);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<SettingsGiftingViewModel.ViewState> observableR = getViewModel().observeViewState().r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), WidgetSettingsGifting.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(getViewModel().observeGiftPurchaseEvents(), this, null, 2, null), WidgetSettingsGifting.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetSettingsGifting.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass3(this), 62, (Object) null);
        getViewModel().setOnGiftCodeResolved(AnonymousClass4.INSTANCE);
        enableGiftingButtons();
    }
}
