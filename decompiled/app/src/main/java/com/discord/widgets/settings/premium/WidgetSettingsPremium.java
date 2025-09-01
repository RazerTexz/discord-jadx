package com.discord.widgets.settings.premium;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppHelpDesk;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.i.ViewPremiumSettingsTier1Binding;
import b.a.i.ViewPremiumSettingsTier2Binding;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.SkuDetails;
import com.discord.R;
import com.discord.api.premium.SubscriptionInterval;
import com.discord.api.premium.SubscriptionPlan;
import com.discord.app.AppFragment;
import com.discord.app.AppLog;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetSettingsPremiumBinding;
import com.discord.i18n.RenderContext;
import com.discord.models.domain.ModelEntitlement;
import com.discord.models.domain.ModelGuildBoostSlot;
import com.discord.models.domain.ModelSubscription;
import com.discord.models.domain.billing.ModelInvoicePreview;
import com.discord.models.domain.billing.ModelInvoicePreview3;
import com.discord.models.domain.premium.SubscriptionPlanType;
import com.discord.stores.StoreStream;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.billing.GooglePlaySku;
import com.discord.utilities.billing.GooglePlaySku2;
import com.discord.utilities.billing.PremiumUtils2;
import com.discord.utilities.locale.LocaleManager;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.premium.BlockRussianPurchasesUtils;
import com.discord.utilities.premium.PremiumUtils;
import com.discord.utilities.rest.SendUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.ActiveSubscriptionView;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoost;
import com.discord.widgets.settings.premium.SettingsPremiumViewModel;
import com.discord.widgets.settings.premium.WidgetChoosePlan;
import com.google.android.material.button.MaterialButton;
import d0.Tuples;
import d0.t.Collections2;
import d0.t.MapsJVM;
import d0.t.SetsJVM;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.text.NumberFormat;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: WidgetSettingsPremium.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 ^2\u00020\u0001:\u0001^B\u0007¢\u0006\u0004\b]\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\u0014\u001a\u00020\u00022\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\r\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J/\u0010\u0018\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\r\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001a\u0010\fJ\u0019\u0010\u001b\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ7\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\r0\u00122\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0002¢\u0006\u0004\b\u0010\u0010\u001fJ-\u0010&\u001a\u00020%2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010!\u001a\u00020 2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0002¢\u0006\u0004\b&\u0010'J!\u0010*\u001a\u00020%2\u0006\u0010(\u001a\u00020 2\b\u0010)\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0004\b*\u0010+J\u0017\u0010,\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b,\u0010\fJ'\u00100\u001a\u00020\u00022\f\u0010.\u001a\b\u0012\u0004\u0012\u00020-0\"2\b\u0010/\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\u0002H\u0002¢\u0006\u0004\b2\u0010\u0004J\u000f\u00103\u001a\u00020\u0002H\u0002¢\u0006\u0004\b3\u0010\u0004J\u0017\u00106\u001a\u00020\u00022\u0006\u00105\u001a\u000204H\u0002¢\u0006\u0004\b6\u00107J\u000f\u00108\u001a\u00020\u0002H\u0002¢\u0006\u0004\b8\u0010\u0004J\u0017\u0010;\u001a\u00020\u00022\u0006\u0010:\u001a\u000209H\u0002¢\u0006\u0004\b;\u0010<J\u0017\u0010=\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b=\u0010\fJ-\u0010?\u001a\u0004\u0018\u00010\u00132\u0006\u0010>\u001a\u00020\u00162\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\r0\u0012H\u0002¢\u0006\u0004\b?\u0010@J/\u0010B\u001a\u00020\u00022\b\u0010>\u001a\u0004\u0018\u00010\u00162\u0014\u0010A\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\r\u0018\u00010\u0012H\u0002¢\u0006\u0004\bB\u0010\u0019J/\u0010C\u001a\u00020\u00022\b\u0010>\u001a\u0004\u0018\u00010\u00162\u0014\u0010A\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\r\u0018\u00010\u0012H\u0002¢\u0006\u0004\bC\u0010\u0019J\u0019\u0010F\u001a\u00020\u000f2\b\u0010E\u001a\u0004\u0018\u00010DH\u0002¢\u0006\u0004\bF\u0010GJ\u0017\u0010J\u001a\u00020\u00022\u0006\u0010I\u001a\u00020HH\u0016¢\u0006\u0004\bJ\u0010KJ\u000f\u0010L\u001a\u00020\u0002H\u0016¢\u0006\u0004\bL\u0010\u0004R\u0016\u0010N\u001a\u00020M8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u001d\u0010:\u001a\u0002098B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010SR\u001d\u0010Y\u001a\u00020T8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bU\u0010V\u001a\u0004\bW\u0010XR\u0016\u0010\\\u001a\u00020\u00138B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bZ\u0010[¨\u0006_"}, d2 = {"Lcom/discord/widgets/settings/premium/WidgetSettingsPremium;", "Lcom/discord/app/AppFragment;", "", "scrollToTop", "()V", "", "section", "scrollToSection", "(Ljava/lang/Integer;)V", "Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel$ViewState$Loaded;", "model", "showContent", "(Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel$ViewState$Loaded;)V", "Lcom/android/billingclient/api/SkuDetails;", "skuDetails", "", "getPriceText", "(Lcom/android/billingclient/api/SkuDetails;)Ljava/lang/CharSequence;", "", "", "configureButtonText", "(Ljava/util/Map;)V", "Lcom/discord/models/domain/ModelSubscription;", "premiumSubscription", "configureButtons", "(Lcom/discord/models/domain/ModelSubscription;Ljava/util/Map;)V", "configureLegalese", "configureGrandfatheredHeader", "(Lcom/discord/models/domain/ModelSubscription;)V", "Lcom/discord/models/domain/billing/ModelInvoiceItem;", "invoiceItem", "(Lcom/discord/models/domain/ModelSubscription;Ljava/util/Map;Lcom/discord/models/domain/billing/ModelInvoiceItem;)Ljava/lang/CharSequence;", "", "canManageGuildBoosts", "", "Lcom/android/billingclient/api/Purchase;", "purchases", "Lcom/discord/widgets/settings/premium/WidgetSettingsPremium$Companion$SubscriptionViewCallbacks;", "getPremiumSubscriptionViewCallbacks", "(Lcom/discord/models/domain/ModelSubscription;ZLjava/util/List;)Lcom/discord/widgets/settings/premium/WidgetSettingsPremium$Companion$SubscriptionViewCallbacks;", "isGoogleGuildBoost", "skuName", "getGuildBoostViewCallbacks", "(ZLjava/lang/String;)Lcom/discord/widgets/settings/premium/WidgetSettingsPremium$Companion$SubscriptionViewCallbacks;", "configureActiveSubscriptionView", "Lcom/discord/models/domain/ModelEntitlement;", "entitlements", "currentSubscription", "configureAccountCredit", "(Ljava/util/List;Lcom/discord/models/domain/ModelSubscription;)V", "showLoadingUI", "showFailureUI", "Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel$Event;", "event", "handleEvent", "(Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel$Event;)V", "showDesktopManageAlert", "Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel;", "viewModel", "showCancelConfirmationAlert", "(Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel;)V", "configurePaymentInfo", Traits.Payment.Type.SUBSCRIPTION, "getGoogleSubscriptionRenewalPrice", "(Lcom/discord/models/domain/ModelSubscription;Ljava/util/Map;)Ljava/lang/String;", "skuDetailsMap", "configurePriceChangeNotice", "configureStatusNotice", "Lcom/discord/models/domain/premium/SubscriptionPlanType;", "planType", "getPlanString", "(Lcom/discord/models/domain/premium/SubscriptionPlanType;)Ljava/lang/CharSequence;", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "Lcom/discord/utilities/locale/LocaleManager;", "localeManager", "Lcom/discord/utilities/locale/LocaleManager;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel;", "Lcom/discord/databinding/WidgetSettingsPremiumBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetSettingsPremiumBinding;", "binding", "getAnalyticsLocationSection", "()Ljava/lang/String;", "analyticsLocationSection", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetSettingsPremium extends AppFragment {
    private static final String ANALYTICS_LOCATION_SECTION = "analytics_location_section";
    private static final String INTENT_SCROLL_TO_SECTION = "intent_section";
    public static final int SECTION_NITRO = 1;
    public static final int SECTION_NITRO_CLASSIC = 0;
    private static final int VIEW_INDEX_CONTENT = 0;
    private static final int VIEW_INDEX_ERROR = 2;
    private static final int VIEW_INDEX_LOADING = 1;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final LocaleManager localeManager;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetSettingsPremium.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsPremiumBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: WidgetSettingsPremium.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0016B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J-\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\u00068\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\u00068\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0016\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/settings/premium/WidgetSettingsPremium$Companion;", "", "Landroid/content/Context;", "context", "", "scrollToSection", "", "locationSection", "", "launch", "(Landroid/content/Context;Ljava/lang/Integer;Ljava/lang/String;)V", "ANALYTICS_LOCATION_SECTION", "Ljava/lang/String;", "INTENT_SCROLL_TO_SECTION", "SECTION_NITRO", "I", "SECTION_NITRO_CLASSIC", "VIEW_INDEX_CONTENT", "VIEW_INDEX_ERROR", "VIEW_INDEX_LOADING", "<init>", "()V", "SubscriptionViewCallbacks", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {

        /* compiled from: WidgetSettingsPremium.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0082\b\u0018\u00002\u00020\u0001BW\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0004\b!\u0010\"J\u0018\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0005J\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0005J\u0018\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0005J\u0018\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0005Jj\u0010\u000f\u001a\u00020\u00002\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR!\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001b\u001a\u0004\b\u001c\u0010\u0005R!\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\u001d\u0010\u0005R!\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001b\u001a\u0004\b\u001e\u0010\u0005R!\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001f\u0010\u0005R!\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u001b\u001a\u0004\b \u0010\u0005¨\u0006#"}, d2 = {"Lcom/discord/widgets/settings/premium/WidgetSettingsPremium$Companion$SubscriptionViewCallbacks;", "", "Lkotlin/Function0;", "", "component1", "()Lkotlin/jvm/functions/Function0;", "component2", "component3", "component4", "component5", "restoreCallback", "managePlanCallback", "cancelCallback", "manageGuildBoostCallback", "manageBillingCallback", "copy", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)Lcom/discord/widgets/settings/premium/WidgetSettingsPremium$Companion$SubscriptionViewCallbacks;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lkotlin/jvm/functions/Function0;", "getManagePlanCallback", "getCancelCallback", "getManageBillingCallback", "getManageGuildBoostCallback", "getRestoreCallback", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class SubscriptionViewCallbacks {
            private final Function0<Unit> cancelCallback;
            private final Function0<Unit> manageBillingCallback;
            private final Function0<Unit> manageGuildBoostCallback;
            private final Function0<Unit> managePlanCallback;
            private final Function0<Unit> restoreCallback;

            public SubscriptionViewCallbacks(Function0<Unit> function0, Function0<Unit> function02, Function0<Unit> function03, Function0<Unit> function04, Function0<Unit> function05) {
                this.restoreCallback = function0;
                this.managePlanCallback = function02;
                this.cancelCallback = function03;
                this.manageGuildBoostCallback = function04;
                this.manageBillingCallback = function05;
            }

            public static /* synthetic */ SubscriptionViewCallbacks copy$default(SubscriptionViewCallbacks subscriptionViewCallbacks, Function0 function0, Function0 function02, Function0 function03, Function0 function04, Function0 function05, int i, Object obj) {
                if ((i & 1) != 0) {
                    function0 = subscriptionViewCallbacks.restoreCallback;
                }
                if ((i & 2) != 0) {
                    function02 = subscriptionViewCallbacks.managePlanCallback;
                }
                Function0 function06 = function02;
                if ((i & 4) != 0) {
                    function03 = subscriptionViewCallbacks.cancelCallback;
                }
                Function0 function07 = function03;
                if ((i & 8) != 0) {
                    function04 = subscriptionViewCallbacks.manageGuildBoostCallback;
                }
                Function0 function08 = function04;
                if ((i & 16) != 0) {
                    function05 = subscriptionViewCallbacks.manageBillingCallback;
                }
                return subscriptionViewCallbacks.copy(function0, function06, function07, function08, function05);
            }

            public final Function0<Unit> component1() {
                return this.restoreCallback;
            }

            public final Function0<Unit> component2() {
                return this.managePlanCallback;
            }

            public final Function0<Unit> component3() {
                return this.cancelCallback;
            }

            public final Function0<Unit> component4() {
                return this.manageGuildBoostCallback;
            }

            public final Function0<Unit> component5() {
                return this.manageBillingCallback;
            }

            public final SubscriptionViewCallbacks copy(Function0<Unit> restoreCallback, Function0<Unit> managePlanCallback, Function0<Unit> cancelCallback, Function0<Unit> manageGuildBoostCallback, Function0<Unit> manageBillingCallback) {
                return new SubscriptionViewCallbacks(restoreCallback, managePlanCallback, cancelCallback, manageGuildBoostCallback, manageBillingCallback);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SubscriptionViewCallbacks)) {
                    return false;
                }
                SubscriptionViewCallbacks subscriptionViewCallbacks = (SubscriptionViewCallbacks) other;
                return Intrinsics3.areEqual(this.restoreCallback, subscriptionViewCallbacks.restoreCallback) && Intrinsics3.areEqual(this.managePlanCallback, subscriptionViewCallbacks.managePlanCallback) && Intrinsics3.areEqual(this.cancelCallback, subscriptionViewCallbacks.cancelCallback) && Intrinsics3.areEqual(this.manageGuildBoostCallback, subscriptionViewCallbacks.manageGuildBoostCallback) && Intrinsics3.areEqual(this.manageBillingCallback, subscriptionViewCallbacks.manageBillingCallback);
            }

            public final Function0<Unit> getCancelCallback() {
                return this.cancelCallback;
            }

            public final Function0<Unit> getManageBillingCallback() {
                return this.manageBillingCallback;
            }

            public final Function0<Unit> getManageGuildBoostCallback() {
                return this.manageGuildBoostCallback;
            }

            public final Function0<Unit> getManagePlanCallback() {
                return this.managePlanCallback;
            }

            public final Function0<Unit> getRestoreCallback() {
                return this.restoreCallback;
            }

            public int hashCode() {
                Function0<Unit> function0 = this.restoreCallback;
                int iHashCode = (function0 != null ? function0.hashCode() : 0) * 31;
                Function0<Unit> function02 = this.managePlanCallback;
                int iHashCode2 = (iHashCode + (function02 != null ? function02.hashCode() : 0)) * 31;
                Function0<Unit> function03 = this.cancelCallback;
                int iHashCode3 = (iHashCode2 + (function03 != null ? function03.hashCode() : 0)) * 31;
                Function0<Unit> function04 = this.manageGuildBoostCallback;
                int iHashCode4 = (iHashCode3 + (function04 != null ? function04.hashCode() : 0)) * 31;
                Function0<Unit> function05 = this.manageBillingCallback;
                return iHashCode4 + (function05 != null ? function05.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("SubscriptionViewCallbacks(restoreCallback=");
                sbU.append(this.restoreCallback);
                sbU.append(", managePlanCallback=");
                sbU.append(this.managePlanCallback);
                sbU.append(", cancelCallback=");
                sbU.append(this.cancelCallback);
                sbU.append(", manageGuildBoostCallback=");
                sbU.append(this.manageGuildBoostCallback);
                sbU.append(", manageBillingCallback=");
                sbU.append(this.manageBillingCallback);
                sbU.append(")");
                return sbU.toString();
            }
        }

        private Companion() {
        }

        public static /* synthetic */ void launch$default(Companion companion, Context context, Integer num, String str, int i, Object obj) {
            if ((i & 2) != 0) {
                num = null;
            }
            if ((i & 4) != 0) {
                str = null;
            }
            companion.launch(context, num, str);
        }

        public final void launch(Context context, Integer scrollToSection, String locationSection) {
            Intrinsics3.checkNotNullParameter(context, "context");
            if (BlockRussianPurchasesUtils.INSTANCE.getINSTANCE().showDialog()) {
                return;
            }
            StoreStream.INSTANCE.getAnalytics().onUserSettingsPaneViewed("Discord Nitro", locationSection);
            AppScreen2.d(context, WidgetSettingsPremium.class, new Intent().putExtra(WidgetSettingsPremium.INTENT_SCROLL_TO_SECTION, scrollToSection).putExtra(WidgetSettingsPremium.ANALYTICS_LOCATION_SECTION, locationSection));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;
        public static final /* synthetic */ int[] $EnumSwitchMapping$4;
        public static final /* synthetic */ int[] $EnumSwitchMapping$5;

        static {
            SubscriptionInterval.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[SubscriptionInterval.YEARLY.ordinal()] = 1;
            iArr[SubscriptionInterval.MONTHLY.ordinal()] = 2;
            SubscriptionPlanType.values();
            int[] iArr2 = new int[17];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[SubscriptionPlanType.PREMIUM_MONTH_LEGACY.ordinal()] = 1;
            iArr2[SubscriptionPlanType.PREMIUM_YEAR_LEGACY.ordinal()] = 2;
            ModelSubscription.Status.values();
            int[] iArr3 = new int[6];
            $EnumSwitchMapping$2 = iArr3;
            ModelSubscription.Status status = ModelSubscription.Status.PAST_DUE;
            iArr3[status.ordinal()] = 1;
            ModelSubscription.Status status2 = ModelSubscription.Status.ACCOUNT_HOLD;
            iArr3[status2.ordinal()] = 2;
            ModelSubscription.Status.values();
            int[] iArr4 = new int[6];
            $EnumSwitchMapping$3 = iArr4;
            iArr4[status.ordinal()] = 1;
            iArr4[status2.ordinal()] = 2;
            ModelSubscription.Status.values();
            int[] iArr5 = new int[6];
            $EnumSwitchMapping$4 = iArr5;
            iArr5[ModelSubscription.Status.ACTIVE.ordinal()] = 1;
            iArr5[ModelSubscription.Status.CANCELED.ordinal()] = 2;
            iArr5[status.ordinal()] = 3;
            iArr5[status2.ordinal()] = 4;
            SubscriptionPlanType.values();
            int[] iArr6 = new int[17];
            $EnumSwitchMapping$5 = iArr6;
            iArr6[SubscriptionPlanType.PREMIUM_MONTH_TIER_1.ordinal()] = 1;
            iArr6[SubscriptionPlanType.PREMIUM_YEAR_TIER_1.ordinal()] = 2;
            iArr6[SubscriptionPlanType.PREMIUM_MONTH_TIER_2.ordinal()] = 3;
            iArr6[SubscriptionPlanType.PREMIUM_3_MONTH_TIER_2.ordinal()] = 4;
            iArr6[SubscriptionPlanType.PREMIUM_6_MONTH_TIER_2.ordinal()] = 5;
            iArr6[SubscriptionPlanType.PREMIUM_YEAR_TIER_2.ordinal()] = 6;
        }
    }

    /* compiled from: WidgetSettingsPremium.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$configurePaymentInfo$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ boolean $isAppleSubscription;

        public AnonymousClass1(boolean z2) {
            this.$isAppleSubscription = z2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (this.$isAppleSubscription) {
                PremiumUtils premiumUtils = PremiumUtils.INSTANCE;
                Intrinsics3.checkNotNullExpressionValue(view, "it");
                Context context = view.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "it.context");
                premiumUtils.openAppleBilling(context);
            }
        }
    }

    /* compiled from: WidgetSettingsPremium.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$configurePaymentInfo$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ boolean $isGoogleSubscription;
        public final /* synthetic */ ModelSubscription $subscription;

        public AnonymousClass2(boolean z2, ModelSubscription modelSubscription) {
            this.$isGoogleSubscription = z2;
            this.$subscription = modelSubscription;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (this.$isGoogleSubscription) {
                PremiumUtils premiumUtils = PremiumUtils.INSTANCE;
                Context contextX = outline.x(view, "it", "it.context");
                ModelSubscription modelSubscription = this.$subscription;
                premiumUtils.openGooglePlayBilling(contextX, modelSubscription != null ? modelSubscription.getPaymentGatewayPlanId() : null);
            }
        }
    }

    /* compiled from: WidgetSettingsPremium.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$configurePriceChangeNotice$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            UriHandler.handle$default(UriHandler.INSTANCE, outline.I(WidgetSettingsPremium.access$getBinding$p(WidgetSettingsPremium.this).k.c, "binding.premiumSettingsPriceChangeNotice.textview", "binding.premiumSettingsP…geNotice.textview.context"), AppHelpDesk.a.a(4407269525911L, null), false, false, null, 28, null);
        }
    }

    /* compiled from: WidgetSettingsPremium.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$configureStatusNotice$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ ModelSubscription $subscription;

        public AnonymousClass1(ModelSubscription modelSubscription) {
            this.$subscription = modelSubscription;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            PremiumUtils.INSTANCE.openGooglePlayBilling(WidgetSettingsPremium.this.requireContext(), this.$subscription.getPaymentGatewayPlanId());
        }
    }

    /* compiled from: WidgetSettingsPremium.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$getGuildBoostViewCallbacks$1, reason: invalid class name */
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
            WidgetSettingsGuildBoost.INSTANCE.launch(WidgetSettingsPremium.this.requireContext());
        }
    }

    /* compiled from: WidgetSettingsPremium.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$getGuildBoostViewCallbacks$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ String $skuName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str) {
            super(0);
            this.$skuName = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            PremiumUtils.INSTANCE.openGooglePlayBilling(WidgetSettingsPremium.this.requireContext(), this.$skuName);
        }
    }

    /* compiled from: WidgetSettingsPremium.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$getGuildBoostViewCallbacks$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ String $skuName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(String str) {
            super(0);
            this.$skuName = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetChoosePlan.Companion.launch$default(WidgetChoosePlan.INSTANCE, WidgetSettingsPremium.this.requireContext(), null, WidgetChoosePlan.ViewType.SWITCH_PLANS, this.$skuName, new Traits.Location(Traits.Location.Page.USER_SETTINGS, WidgetSettingsPremium.access$getAnalyticsLocationSection$p(WidgetSettingsPremium.this), Traits.Location.Obj.BUTTON_CTA, Traits.Location.ObjType.BUY, null, 16, null), null, 34, null);
        }
    }

    /* compiled from: WidgetSettingsPremium.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$getGuildBoostViewCallbacks$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ String $skuName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(String str) {
            super(0);
            this.$skuName = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            PremiumUtils.INSTANCE.openGooglePlayBilling(WidgetSettingsPremium.this.requireContext(), this.$skuName);
        }
    }

    /* compiled from: WidgetSettingsPremium.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$getGuildBoostViewCallbacks$5, reason: invalid class name */
    public static final class AnonymousClass5 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ String $skuName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass5(String str) {
            super(0);
            this.$skuName = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            PremiumUtils.INSTANCE.openGooglePlayBilling(WidgetSettingsPremium.this.requireContext(), this.$skuName);
        }
    }

    /* compiled from: WidgetSettingsPremium.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$getGuildBoostViewCallbacks$6, reason: invalid class name */
    public static final class AnonymousClass6 extends Lambda implements Function0<Unit> {
        public AnonymousClass6() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetSettingsGuildBoost.INSTANCE.launch(WidgetSettingsPremium.this.requireContext());
        }
    }

    /* compiled from: WidgetSettingsPremium.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$getPremiumSubscriptionViewCallbacks$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ModelSubscription $premiumSubscription;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ModelSubscription modelSubscription) {
            super(0);
            this.$premiumSubscription = modelSubscription;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            PremiumUtils.INSTANCE.openGooglePlayBilling(WidgetSettingsPremium.this.requireContext(), this.$premiumSubscription.getPaymentGatewayPlanId());
        }
    }

    /* compiled from: WidgetSettingsPremium.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$getPremiumSubscriptionViewCallbacks$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ModelSubscription $premiumSubscription;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ModelSubscription modelSubscription) {
            super(0);
            this.$premiumSubscription = modelSubscription;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            PremiumUtils.INSTANCE.openGooglePlayBilling(WidgetSettingsPremium.this.requireContext(), this.$premiumSubscription.getPaymentGatewayPlanId());
        }
    }

    /* compiled from: WidgetSettingsPremium.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$getPremiumSubscriptionViewCallbacks$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ModelSubscription $premiumSubscription;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(ModelSubscription modelSubscription) {
            super(0);
            this.$premiumSubscription = modelSubscription;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            PremiumUtils.INSTANCE.openGooglePlayBilling(WidgetSettingsPremium.this.requireContext(), this.$premiumSubscription.getPaymentGatewayPlanId());
        }
    }

    /* compiled from: WidgetSettingsPremium.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$getPremiumSubscriptionViewCallbacks$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements Function0<Unit> {
        public AnonymousClass4() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetSettingsPremium.access$showDesktopManageAlert(WidgetSettingsPremium.this);
        }
    }

    /* compiled from: WidgetSettingsPremium.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$getPremiumSubscriptionViewCallbacks$5, reason: invalid class name */
    public static final class AnonymousClass5 extends Lambda implements Function0<Unit> {
        public AnonymousClass5() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetSettingsPremium widgetSettingsPremium = WidgetSettingsPremium.this;
            WidgetSettingsPremium.access$showCancelConfirmationAlert(widgetSettingsPremium, WidgetSettingsPremium.access$getViewModel$p(widgetSettingsPremium));
        }
    }

    /* compiled from: WidgetSettingsPremium.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel$ViewState;", "kotlin.jvm.PlatformType", "model", "", "invoke", "(Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<SettingsPremiumViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SettingsPremiumViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SettingsPremiumViewModel.ViewState viewState) {
            if (viewState instanceof SettingsPremiumViewModel.ViewState.Loaded) {
                WidgetSettingsPremium.access$showContent(WidgetSettingsPremium.this, (SettingsPremiumViewModel.ViewState.Loaded) viewState);
            } else if (viewState instanceof SettingsPremiumViewModel.ViewState.Loading) {
                WidgetSettingsPremium.access$showLoadingUI(WidgetSettingsPremium.this);
            } else if (viewState instanceof SettingsPremiumViewModel.ViewState.Failure) {
                WidgetSettingsPremium.access$showFailureUI(WidgetSettingsPremium.this);
            }
        }
    }

    /* compiled from: WidgetSettingsPremium.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel$Event;", "p1", "", "invoke", "(Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel$Event;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<SettingsPremiumViewModel.Event, Unit> {
        public AnonymousClass2(WidgetSettingsPremium widgetSettingsPremium) {
            super(1, widgetSettingsPremium, WidgetSettingsPremium.class, "handleEvent", "handleEvent(Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SettingsPremiumViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SettingsPremiumViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "p1");
            WidgetSettingsPremium.access$handleEvent((WidgetSettingsPremium) this.receiver, event);
        }
    }

    /* compiled from: WidgetSettingsPremium.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$showCancelConfirmationAlert$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ SettingsPremiumViewModel $viewModel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(SettingsPremiumViewModel settingsPremiumViewModel) {
            super(1);
            this.$viewModel = settingsPremiumViewModel;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            this.$viewModel.cancelSubscription();
        }
    }

    /* compiled from: WidgetSettingsPremium.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Ljava/lang/Long;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$showContent$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Long, Unit> {
        public final /* synthetic */ Integer $scrollTargetSection;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Integer num) {
            super(1);
            this.$scrollTargetSection = num;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            WidgetSettingsPremium.access$scrollToSection(WidgetSettingsPremium.this, this.$scrollTargetSection);
        }
    }

    /* compiled from: WidgetSettingsPremium.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$showFailureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetSettingsPremium.access$getViewModel$p(WidgetSettingsPremium.this).onRetryClicked();
        }
    }

    public WidgetSettingsPremium() {
        super(R.layout.widget_settings_premium);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetSettingsPremium4.INSTANCE, null, 2, null);
        WidgetSettingsPremium8 widgetSettingsPremium8 = WidgetSettingsPremium8.INSTANCE;
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(SettingsPremiumViewModel.class), new WidgetSettingsPremium$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetSettingsPremium8));
        this.localeManager = new LocaleManager();
    }

    public static final /* synthetic */ String access$getAnalyticsLocationSection$p(WidgetSettingsPremium widgetSettingsPremium) {
        return widgetSettingsPremium.getAnalyticsLocationSection();
    }

    public static final /* synthetic */ WidgetSettingsPremiumBinding access$getBinding$p(WidgetSettingsPremium widgetSettingsPremium) {
        return widgetSettingsPremium.getBinding();
    }

    public static final /* synthetic */ SettingsPremiumViewModel access$getViewModel$p(WidgetSettingsPremium widgetSettingsPremium) {
        return widgetSettingsPremium.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetSettingsPremium widgetSettingsPremium, SettingsPremiumViewModel.Event event) {
        widgetSettingsPremium.handleEvent(event);
    }

    public static final /* synthetic */ void access$scrollToSection(WidgetSettingsPremium widgetSettingsPremium, Integer num) {
        widgetSettingsPremium.scrollToSection(num);
    }

    public static final /* synthetic */ void access$showCancelConfirmationAlert(WidgetSettingsPremium widgetSettingsPremium, SettingsPremiumViewModel settingsPremiumViewModel) {
        widgetSettingsPremium.showCancelConfirmationAlert(settingsPremiumViewModel);
    }

    public static final /* synthetic */ void access$showContent(WidgetSettingsPremium widgetSettingsPremium, SettingsPremiumViewModel.ViewState.Loaded loaded) {
        widgetSettingsPremium.showContent(loaded);
    }

    public static final /* synthetic */ void access$showDesktopManageAlert(WidgetSettingsPremium widgetSettingsPremium) {
        widgetSettingsPremium.showDesktopManageAlert();
    }

    public static final /* synthetic */ void access$showFailureUI(WidgetSettingsPremium widgetSettingsPremium) {
        widgetSettingsPremium.showFailureUI();
    }

    public static final /* synthetic */ void access$showLoadingUI(WidgetSettingsPremium widgetSettingsPremium) {
        widgetSettingsPremium.showLoadingUI();
    }

    private final void configureAccountCredit(List<ModelEntitlement> entitlements, ModelSubscription currentSubscription) {
        int i = 0;
        int i2 = 0;
        for (ModelEntitlement modelEntitlement : entitlements) {
            if (modelEntitlement.getParentId() != null) {
                SubscriptionPlan subscriptionPlan = modelEntitlement.getSubscriptionPlan();
                Long lValueOf = subscriptionPlan != null ? Long.valueOf(subscriptionPlan.getId()) : null;
                long planId = SubscriptionPlanType.PREMIUM_MONTH_TIER_1.getPlanId();
                if (lValueOf != null && lValueOf.longValue() == planId) {
                    i++;
                } else {
                    long planId2 = SubscriptionPlanType.PREMIUM_MONTH_TIER_2.getPlanId();
                    if (lValueOf != null && lValueOf.longValue() == planId2) {
                        i2++;
                    }
                }
            }
        }
        LinearLayout linearLayout = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.premiumSettingsCreditContainer");
        linearLayout.setVisibility(i > 0 || i2 > 0 ? 0 : 8);
        View view = getBinding().f2633b.d;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.accountCredits.creditNitroDivider");
        view.setVisibility(i > 0 && i2 > 0 ? 0 : 8);
        getBinding().f2633b.c.a(SubscriptionPlanType.PREMIUM_MONTH_TIER_1.getPlanId(), i, currentSubscription);
        getBinding().f2633b.f110b.a(SubscriptionPlanType.PREMIUM_MONTH_TIER_2.getPlanId(), i2, currentSubscription);
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0128  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void configureActiveSubscriptionView(SettingsPremiumViewModel.ViewState.Loaded model) {
        ModelInvoicePreview3 modelInvoicePreview3;
        int size;
        boolean z2;
        ModelSubscription.Status status;
        ModelSubscription.Status status2;
        ModelSubscription.Status status3;
        List<ModelInvoicePreview3> invoiceItems;
        Object next;
        Object next2;
        boolean z3;
        Function0<Unit> restoreCallback;
        Function0<Unit> function0;
        ModelSubscription.SubscriptionRenewalMutations renewalMutations;
        ModelSubscription.SubscriptionRenewalMutations renewalMutations2;
        ModelSubscription.SubscriptionRenewalMutations renewalMutations3;
        ModelSubscription.SubscriptionRenewalMutations renewalMutations4;
        String paymentGatewayPlanId;
        ModelSubscription premiumSubscription = model.getPremiumSubscription();
        ModelInvoicePreview currentInvoicePreview = model.getCurrentInvoicePreview();
        Map<String, SkuDetails> skuDetails = model.getSkuDetails();
        boolean z4 = false;
        boolean z5 = (premiumSubscription == null || premiumSubscription.isNonePlan()) ? false : true;
        boolean zIsGoogleSubscription = premiumSubscription != null ? premiumSubscription.isGoogleSubscription() : false;
        GooglePlaySku googlePlaySkuFromSkuName = (premiumSubscription == null || (paymentGatewayPlanId = premiumSubscription.getPaymentGatewayPlanId()) == null) ? null : GooglePlaySku.INSTANCE.fromSkuName(paymentGatewayPlanId);
        LinearLayout linearLayout = getBinding().q;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.premiumSettingsSubscriptionContainer");
        linearLayout.setVisibility(model.getHasAnyGuildBoosts() || z5 ? 0 : 8);
        ActiveSubscriptionView activeSubscriptionView = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(activeSubscriptionView, "binding.premiumSettingsActiveSubscription");
        activeSubscriptionView.setVisibility(z5 && currentInvoicePreview != null ? 0 : 8);
        if (z5 && currentInvoicePreview != null) {
            Intrinsics3.checkNotNull(premiumSubscription);
            Iterator<T> it = currentInvoicePreview.getInvoiceItems().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next2 = null;
                    break;
                }
                next2 = it.next();
                ModelInvoicePreview3 modelInvoicePreview32 = (ModelInvoicePreview3) next2;
                if (modelInvoicePreview32.getSubscriptionPlanId() != premiumSubscription.getPremiumBasePlanId()) {
                    long subscriptionPlanId = modelInvoicePreview32.getSubscriptionPlanId();
                    ModelSubscription.SubscriptionRenewalMutations renewalMutations5 = premiumSubscription.getRenewalMutations();
                    boolean z6 = renewalMutations5 != null && subscriptionPlanId == renewalMutations5.getPremiumBasePlanId();
                    if (z6) {
                        break;
                    }
                }
            }
            ModelInvoicePreview3 modelInvoicePreview33 = (ModelInvoicePreview3) next2;
            int premiumSubscriptionCount = (googlePlaySkuFromSkuName == null || !GooglePlaySku2.isBundledSku(googlePlaySkuFromSkuName)) ? 0 : googlePlaySkuFromSkuName.getPremiumSubscriptionCount();
            CharSequence priceText = getPriceText(premiumSubscription, skuDetails, modelInvoicePreview33);
            if (premiumSubscription.getStatus().isAccountHold()) {
                z3 = false;
                Companion.SubscriptionViewCallbacks premiumSubscriptionViewCallbacks = getPremiumSubscriptionViewCallbacks(premiumSubscription, z3, model.getPurchases());
                if (!premiumSubscription.getStatus().isAccountHold()) {
                    restoreCallback = premiumSubscriptionViewCallbacks.getManageBillingCallback();
                } else if (premiumSubscription.getRenewalMutations() != null) {
                    function0 = null;
                    getBinding().f.a(ActiveSubscriptionView.b(premiumSubscription), premiumSubscription.getStatus(), premiumSubscription.getTrialId() == null, priceText, model.isBusy(), premiumSubscriptionCount, function0, premiumSubscriptionViewCallbacks.getManageGuildBoostCallback(), premiumSubscriptionViewCallbacks.getCancelCallback(), zIsGoogleSubscription && (((renewalMutations = premiumSubscription.getRenewalMutations()) != null && renewalMutations.getPremiumBasePlanId() == SubscriptionPlanType.NONE_MONTH.getPlanId()) || (((renewalMutations2 = premiumSubscription.getRenewalMutations()) != null && renewalMutations2.getPremiumBasePlanId() == SubscriptionPlanType.NONE_YEAR.getPlanId()) || (((renewalMutations3 = premiumSubscription.getRenewalMutations()) != null && renewalMutations3.getPremiumBasePlanId() == SubscriptionPlanType.NONE_3_MONTH.getPlanId()) || ((renewalMutations4 = premiumSubscription.getRenewalMutations()) != null && renewalMutations4.getPremiumBasePlanId() == SubscriptionPlanType.NONE_6_MONTH.getPlanId())))));
                } else {
                    restoreCallback = premiumSubscription.getStatus().isCanceled() ? premiumSubscriptionViewCallbacks.getRestoreCallback() : premiumSubscriptionViewCallbacks.getManagePlanCallback();
                }
                function0 = restoreCallback;
                if (zIsGoogleSubscription) {
                    getBinding().f.a(ActiveSubscriptionView.b(premiumSubscription), premiumSubscription.getStatus(), premiumSubscription.getTrialId() == null, priceText, model.isBusy(), premiumSubscriptionCount, function0, premiumSubscriptionViewCallbacks.getManageGuildBoostCallback(), premiumSubscriptionViewCallbacks.getCancelCallback(), zIsGoogleSubscription && (((renewalMutations = premiumSubscription.getRenewalMutations()) != null && renewalMutations.getPremiumBasePlanId() == SubscriptionPlanType.NONE_MONTH.getPlanId()) || (((renewalMutations2 = premiumSubscription.getRenewalMutations()) != null && renewalMutations2.getPremiumBasePlanId() == SubscriptionPlanType.NONE_YEAR.getPlanId()) || (((renewalMutations3 = premiumSubscription.getRenewalMutations()) != null && renewalMutations3.getPremiumBasePlanId() == SubscriptionPlanType.NONE_3_MONTH.getPlanId()) || ((renewalMutations4 = premiumSubscription.getRenewalMutations()) != null && renewalMutations4.getPremiumBasePlanId() == SubscriptionPlanType.NONE_6_MONTH.getPlanId())))));
                }
            } else {
                if ((googlePlaySkuFromSkuName != null ? googlePlaySkuFromSkuName.getType() : null) != GooglePlaySku.Type.PREMIUM_GUILD) {
                    if ((googlePlaySkuFromSkuName != null ? googlePlaySkuFromSkuName.getType() : null) != GooglePlaySku.Type.PREMIUM_TIER_1) {
                        z3 = true;
                    }
                    Companion.SubscriptionViewCallbacks premiumSubscriptionViewCallbacks2 = getPremiumSubscriptionViewCallbacks(premiumSubscription, z3, model.getPurchases());
                    if (!premiumSubscription.getStatus().isAccountHold()) {
                    }
                    function0 = restoreCallback;
                }
            }
        }
        ModelInvoicePreview currentInvoicePreview2 = model.getCurrentInvoicePreview();
        if (currentInvoicePreview2 == null || (invoiceItems = currentInvoicePreview2.getInvoiceItems()) == null) {
            modelInvoicePreview3 = null;
        } else {
            Iterator<T> it2 = invoiceItems.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                }
                next = it2.next();
                long subscriptionPlanId2 = ((ModelInvoicePreview3) next).getSubscriptionPlanId();
                Long guildBoostPlanId = premiumSubscription != null ? premiumSubscription.getGuildBoostPlanId() : null;
                if (guildBoostPlanId != null && subscriptionPlanId2 == guildBoostPlanId.longValue()) {
                    break;
                }
            }
            modelInvoicePreview3 = (ModelInvoicePreview3) next;
        }
        ActiveSubscriptionView activeSubscriptionView2 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(activeSubscriptionView2, "binding.premiumSettingsActiveGuildSubscription");
        activeSubscriptionView2.setVisibility(model.getHasAnyGuildBoosts() && modelInvoicePreview3 != null ? 0 : 8);
        if (!model.getHasAnyGuildBoosts() || modelInvoicePreview3 == null) {
            return;
        }
        Map<Long, ModelGuildBoostSlot> guildSubscriptions = model.getGuildSubscriptions();
        if (googlePlaySkuFromSkuName == null || !zIsGoogleSubscription) {
            size = guildSubscriptions.values().size() - (premiumSubscription != null ? PremiumUtils.INSTANCE.getGuildBoostCountFromSubscription(premiumSubscription) : 0);
        } else {
            size = googlePlaySkuFromSkuName.getPremiumSubscriptionCount();
        }
        int i = size;
        CharSequence priceText2 = getPriceText(premiumSubscription, skuDetails, modelInvoicePreview3);
        boolean z7 = zIsGoogleSubscription && (premiumSubscription != null ? ActiveSubscriptionView.b(premiumSubscription) : null) == ActiveSubscriptionView.ActiveSubscriptionType.PREMIUM_GUILD;
        ActiveSubscriptionView activeSubscriptionView3 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(activeSubscriptionView3, "binding.premiumSettingsActiveGuildSubscription");
        activeSubscriptionView3.setVisibility(!zIsGoogleSubscription || z7 ? 0 : 8);
        Companion.SubscriptionViewCallbacks guildBoostViewCallbacks = getGuildBoostViewCallbacks(z7, premiumSubscription != null ? premiumSubscription.getPaymentGatewayPlanId() : null);
        Collection<ModelGuildBoostSlot> collectionValues = guildSubscriptions.values();
        if ((collectionValues instanceof Collection) && collectionValues.isEmpty()) {
            z2 = false;
        } else {
            Iterator<T> it3 = collectionValues.iterator();
            while (it3.hasNext()) {
                if (((ModelGuildBoostSlot) it3.next()).getCanceled()) {
                    z2 = true;
                    break;
                }
            }
            z2 = false;
        }
        if (zIsGoogleSubscription) {
            if ((premiumSubscription == null || (status3 = premiumSubscription.getStatus()) == null) ? false : status3.isCanceled()) {
                z4 = true;
            }
        }
        Function0<Unit> restoreCallback2 = z4 ? guildBoostViewCallbacks.getRestoreCallback() : (premiumSubscription == null || (status = premiumSubscription.getStatus()) == null || !status.isAccountHold()) ? guildBoostViewCallbacks.getManagePlanCallback() : guildBoostViewCallbacks.getManageBillingCallback();
        ActiveSubscriptionView activeSubscriptionView4 = getBinding().e;
        ActiveSubscriptionView.ActiveSubscriptionType activeSubscriptionType = ActiveSubscriptionView.ActiveSubscriptionType.PREMIUM_GUILD;
        ModelSubscription.Status status4 = (z2 || z4) ? ModelSubscription.Status.CANCELED : (premiumSubscription == null || (status2 = premiumSubscription.getStatus()) == null || !status2.isAccountHold()) ? ModelSubscription.Status.ACTIVE : ModelSubscription.Status.ACCOUNT_HOLD;
        boolean zIsBusy = model.isBusy();
        Function0<Unit> manageGuildBoostCallback = guildBoostViewCallbacks.getManageGuildBoostCallback();
        Function0<Unit> cancelCallback = guildBoostViewCallbacks.getCancelCallback();
        int i2 = ActiveSubscriptionView.j;
        activeSubscriptionView4.a(activeSubscriptionType, status4, false, priceText2, zIsBusy, i, restoreCallback2, manageGuildBoostCallback, cancelCallback, false);
    }

    private final void configureButtonText(Map<String, ? extends SkuDetails> skuDetails) {
        MaterialButton materialButton = getBinding().t.f76b;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.premiumTier1.premiumSettingsPremiumClassic");
        materialButton.setText(getPriceText(skuDetails != null ? skuDetails.get(GooglePlaySku.PREMIUM_TIER_1_MONTHLY.getSkuName()) : null));
        MaterialButton materialButton2 = getBinding().u.f84b;
        Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.premiumTier2.premiumSettingsPremium");
        materialButton2.setText(getPriceText(skuDetails != null ? skuDetails.get(GooglePlaySku.PREMIUM_TIER_2_MONTHLY.getSkuName()) : null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void configureButtonText$default(WidgetSettingsPremium widgetSettingsPremium, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = null;
        }
        widgetSettingsPremium.configureButtonText(map);
    }

    private final void configureButtons(ModelSubscription premiumSubscription, Map<String, ? extends SkuDetails> skuDetails) {
        configureButtonText(skuDetails);
        if (premiumSubscription == null || !premiumSubscription.isAppleSubscription()) {
            for (MaterialButton materialButton : Collections2.listOf((Object[]) new MaterialButton[]{getBinding().t.f76b, getBinding().u.f84b})) {
                Intrinsics3.checkNotNullExpressionValue(materialButton, "button");
                materialButton.setEnabled(premiumSubscription == null);
                materialButton.setOnClickListener(new WidgetSettingsPremium3(materialButton, this, premiumSubscription));
            }
            return;
        }
        for (MaterialButton materialButton2 : Collections2.listOf((Object[]) new MaterialButton[]{getBinding().t.f76b, getBinding().u.f84b})) {
            Intrinsics3.checkNotNullExpressionValue(materialButton2, "button");
            ViewExtensions.setEnabledAlpha$default(materialButton2, true, 0.0f, 2, null);
            materialButton2.setOnClickListener(new WidgetSettingsPremium2(this));
        }
    }

    private final void configureGrandfatheredHeader(ModelSubscription premiumSubscription) {
        CharSequence charSequenceK = null;
        SubscriptionPlanType planType = premiumSubscription != null ? premiumSubscription.getPlanType() : null;
        if (planType != null) {
            int iOrdinal = planType.ordinal();
            if (iOrdinal == 4) {
                charSequenceK = FormatUtils.k(this, R.string.premium_grandfathered_monthly, new Object[]{DateFormat.getMediumDateFormat(requireContext()).format(PremiumUtils2.getGRANDFATHERED_MONTHLY_END_DATE())}, null, 4);
            } else if (iOrdinal == 5) {
                charSequenceK = FormatUtils.k(this, R.string.premium_grandfathered_yearly, new Object[]{DateFormat.getMediumDateFormat(requireContext()).format(PremiumUtils2.getGRANDFATHERED_YEARLY_END_DATE())}, null, 4);
            }
        }
        TextView textView = getBinding().i;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.premiumSettingsGrandfathered");
        ViewExtensions.setTextAndVisibilityBy(textView, charSequenceK);
    }

    private final void configureLegalese(SettingsPremiumViewModel.ViewState.Loaded model) {
        int i;
        ModelSubscription premiumSubscription = model.getPremiumSubscription();
        Map<String, SkuDetails> skuDetails = model.getSkuDetails();
        ModelInvoicePreview renewalInvoicePreview = model.getRenewalInvoicePreview();
        if (premiumSubscription == null || !premiumSubscription.getPlanType().isPremiumSubscription()) {
            TextView textView = getBinding().j;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.premiumSettingsLegalese");
            textView.setVisibility(8);
            return;
        }
        int iOrdinal = premiumSubscription.getPlanType().getInterval().ordinal();
        if (iOrdinal == 0) {
            i = R.string.billing_payment_premium_terms_legalese_monthly;
        } else {
            if (iOrdinal != 1) {
                throw new NoWhenBranchMatchedException();
            }
            i = R.string.billing_payment_premium_terms_legalese_yearly;
        }
        Object googleSubscriptionRenewalPrice = getGoogleSubscriptionRenewalPrice(premiumSubscription, skuDetails);
        if (googleSubscriptionRenewalPrice == null) {
            googleSubscriptionRenewalPrice = PremiumUtils2.getFormattedPriceUsd(renewalInvoicePreview != null ? renewalInvoicePreview.getTotal() : 0, requireContext());
        }
        TextView textView2 = getBinding().j;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.premiumSettingsLegalese");
        textView2.setVisibility(0);
        TextView textView3 = getBinding().j;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.premiumSettingsLegalese");
        FormatUtils.n(textView3, i, new Object[]{FormatUtils.k(this, R.string.terms_of_service_url, new Object[0], null, 4), FormatUtils.k(this, R.string.paid_services_terms_url, new Object[0], null, 4), FormatUtils.k(this, R.string.privacy_policy_url, new Object[0], null, 4), googleSubscriptionRenewalPrice}, null, 4);
        TextView textView4 = getBinding().j;
        Intrinsics3.checkNotNullExpressionValue(textView4, "binding.premiumSettingsLegalese");
        textView4.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0173  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void configurePaymentInfo(SettingsPremiumViewModel.ViewState.Loaded model) {
        String strRenderUtcDate$default;
        CharSequence charSequenceK;
        int iOrdinal;
        ModelSubscription premiumSubscription = model.getPremiumSubscription();
        ModelInvoicePreview renewalInvoicePreview = model.getRenewalInvoicePreview();
        boolean zIsAppleSubscription = premiumSubscription != null ? premiumSubscription.isAppleSubscription() : false;
        boolean zIsGoogleSubscription = premiumSubscription != null ? premiumSubscription.isGoogleSubscription() : false;
        ModelSubscription.Status status = premiumSubscription != null ? premiumSubscription.getStatus() : null;
        boolean z2 = status != null && ((iOrdinal = status.ordinal()) == 2 || iOrdinal == 5);
        Map<String, SkuDetails> skuDetails = model.getSkuDetails();
        Object objK = "";
        if (premiumSubscription != null) {
            TimeUtils timeUtils = TimeUtils.INSTANCE;
            String currentPeriodStart = z2 ? premiumSubscription.getCurrentPeriodStart() : premiumSubscription.getCurrentPeriodEnd();
            Context contextRequireContext = requireContext();
            int iOrdinal2 = premiumSubscription.getStatus().ordinal();
            strRenderUtcDate$default = TimeUtils.renderUtcDate$default(timeUtils, currentPeriodStart, contextRequireContext, (String) null, (java.text.DateFormat) null, iOrdinal2 != 2 ? iOrdinal2 != 5 ? 0 : 30 : model.getPastDueGracePeriodDays(), 12, (Object) null);
            if (strRenderUtcDate$default == null) {
                strRenderUtcDate$default = "";
            }
        }
        LinearLayout linearLayout = getBinding().c.f;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.payment.premiumSettingsPaymentContainer");
        linearLayout.setVisibility(premiumSubscription != null ? 0 : 8);
        View view = getBinding().c.c;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.payment.premiumSettingsBillingDivider");
        view.setVisibility(zIsAppleSubscription ? 0 : 8);
        if (premiumSubscription != null) {
            ActiveSubscriptionView.ActiveSubscriptionType activeSubscriptionTypeB = ActiveSubscriptionView.b(premiumSubscription);
            SkuDetails skuDetails2 = skuDetails.get(premiumSubscription.getPaymentGatewayPlanId());
            String strA = skuDetails2 != null ? skuDetails2.a() : null;
            if (zIsGoogleSubscription && strA != null) {
                objK = strA;
            } else if (activeSubscriptionTypeB == ActiveSubscriptionView.ActiveSubscriptionType.PREMIUM) {
                objK = FormatUtils.k(this, R.string.premium_tier_2, new Object[0], null, 4);
            } else if (activeSubscriptionTypeB == ActiveSubscriptionView.ActiveSubscriptionType.PREMIUM_CLASSIC) {
                objK = FormatUtils.k(this, R.string.premium_tier_1, new Object[0], null, 4);
            } else if (activeSubscriptionTypeB == ActiveSubscriptionView.ActiveSubscriptionType.PREMIUM_GUILD) {
                objK = FormatUtils.k(this, R.string.premium_guild_subscription_title, new Object[0], null, 4);
            }
        }
        if (zIsAppleSubscription) {
            charSequenceK = FormatUtils.k(this, R.string.billing_managed_by_apple, new Object[0], null, 4);
        } else if (premiumSubscription == null) {
            charSequenceK = null;
        } else {
            int iOrdinal3 = premiumSubscription.getStatus().ordinal();
            if (iOrdinal3 == 1) {
                Object[] objArr = new Object[2];
                objArr[0] = strRenderUtcDate$default;
                Object googleSubscriptionRenewalPrice = getGoogleSubscriptionRenewalPrice(premiumSubscription, skuDetails);
                if (googleSubscriptionRenewalPrice == null) {
                    googleSubscriptionRenewalPrice = PremiumUtils2.getFormattedPriceUsd(renewalInvoicePreview != null ? renewalInvoicePreview.getTotal() : 0, requireContext());
                }
                objArr[1] = googleSubscriptionRenewalPrice;
                charSequenceK = FormatUtils.k(this, R.string.premium_settings_renewal_info, objArr, null, 4);
            } else if (iOrdinal3 == 2) {
                charSequenceK = FormatUtils.k(this, R.string.premium_settings_past_due_info, new Object[]{objK, strRenderUtcDate$default}, null, 4);
            } else if (iOrdinal3 == 3) {
                charSequenceK = FormatUtils.k(this, R.string.premium_settings_cancelled_info, new Object[]{strRenderUtcDate$default}, null, 4);
            } else if (iOrdinal3 == 5) {
                charSequenceK = FormatUtils.k(this, R.string.premium_settings_account_hold_info, new Object[]{TimeUtils.renderUtcDate$default(TimeUtils.INSTANCE, premiumSubscription.getAccountHoldEstimatedExpirationTimestamp(), requireContext(), 0, 4, null)}, null, 4);
            }
        }
        TextView textView = getBinding().c.d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.payment.premiumSettingsBillingInformation");
        textView.setVisibility(charSequenceK != null ? 0 : 8);
        if (charSequenceK != null) {
            TextView textView2 = getBinding().c.d;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.payment.premiumSettingsBillingInformation");
            textView2.setText(charSequenceK);
        }
        MaterialButton materialButton = getBinding().c.f195b;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.payment.activeSubscriptionsBottomButton");
        ViewExtensions.setTextAndVisibilityBy(materialButton, zIsAppleSubscription ? FormatUtils.k(this, R.string.billing_manage_subscription, new Object[0], null, 4) : null);
        getBinding().c.f195b.setOnClickListener(new AnonymousClass1(zIsAppleSubscription));
        TextView textView3 = getBinding().c.e;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.payment.premiumSettingsGooglePlayManage");
        textView3.setVisibility(zIsGoogleSubscription ? 0 : 8);
        getBinding().c.e.setOnClickListener(new AnonymousClass2(zIsGoogleSubscription, premiumSubscription));
    }

    private final void configurePriceChangeNotice(ModelSubscription subscription, Map<String, ? extends SkuDetails> skuDetailsMap) {
        SkuDetails skuDetails = skuDetailsMap != null ? skuDetailsMap.get(GooglePlaySku.PREMIUM_TIER_2_MONTHLY.getSkuName()) : null;
        String strOptString = skuDetails != null ? skuDetails.f2006b.optString("price_currency_code") : null;
        Map mapMapOf = MapsJVM.mapOf(Tuples.to("PLN", Integer.valueOf(R.string.country_name_pl)));
        Objects.requireNonNull(mapMapOf, "null cannot be cast to non-null type kotlin.collections.Map<K, *>");
        boolean z2 = mapMapOf.containsKey(strOptString) && (subscription == null || subscription.isGoogleSubscription());
        CardView cardView = getBinding().k.f79b;
        Intrinsics3.checkNotNullExpressionValue(cardView, "binding.premiumSettingsPriceChangeNotice.card");
        cardView.setVisibility(z2 ? 0 : 8);
        if (z2) {
            int i = subscription == null ? R.string.localized_pricing_mobile_price_change_notice_no_sub : R.string.localized_pricing_mobile_price_change_notice_has_sub;
            TextView textView = getBinding().k.c;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.premiumSettingsPriceChangeNotice.textview");
            Object[] objArr = new Object[3];
            Integer num = (Integer) mapMapOf.get(strOptString);
            objArr[0] = num != null ? FormatUtils.k(this, num.intValue(), new Object[0], null, 4) : null;
            objArr[1] = skuDetails != null ? skuDetails.b() : null;
            objArr[2] = AppHelpDesk.a.a(4407269525911L, null);
            textView.setText(FormatUtils.k(this, i, objArr, null, 4));
            getBinding().k.c.setOnClickListener(new AnonymousClass2());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00ee  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void configureStatusNotice(ModelSubscription subscription, Map<String, ? extends SkuDetails> skuDetailsMap) {
        boolean z2;
        CharSequence charSequenceK;
        SubscriptionPlanType subscriptionPlanType;
        SubscriptionPlanType subscriptionPlanType2;
        CharSequence planString;
        String paymentGatewayPlanId;
        ModelSubscription.Status status;
        boolean z3 = (subscription != null ? subscription.getRenewalMutations() : null) != null;
        boolean zIsAccountHold = (subscription == null || (status = subscription.getStatus()) == null) ? false : status.isAccountHold();
        if (z3 || zIsAccountHold) {
            z2 = (subscription != null ? subscription.getStatus() : null) != ModelSubscription.Status.CANCELED;
        }
        CardView cardView = getBinding().o;
        Intrinsics3.checkNotNullExpressionValue(cardView, "binding.premiumSettingsStatusNoticeContainer");
        cardView.setVisibility(z2 ? 0 : 8);
        if (!z2 || subscription == null) {
            return;
        }
        boolean zIsGoogleSubscription = subscription.isGoogleSubscription();
        if (z3) {
            String strRenderUtcDate$default = TimeUtils.renderUtcDate$default(TimeUtils.INSTANCE, subscription.getCurrentPeriodEnd(), requireContext(), (String) null, (java.text.DateFormat) null, 0, 28, (Object) null);
            ModelSubscription.SubscriptionRenewalMutations renewalMutations = subscription.getRenewalMutations();
            SkuDetails skuDetails = (renewalMutations == null || (paymentGatewayPlanId = renewalMutations.getPaymentGatewayPlanId()) == null || skuDetailsMap == null) ? null : skuDetailsMap.get(paymentGatewayPlanId);
            SubscriptionPlanType[] subscriptionPlanTypeArrValues = SubscriptionPlanType.values();
            int i = 0;
            while (true) {
                if (i >= 17) {
                    subscriptionPlanType2 = null;
                    break;
                }
                subscriptionPlanType2 = subscriptionPlanTypeArrValues[i];
                long planId = subscriptionPlanType2.getPlanId();
                ModelSubscription.SubscriptionRenewalMutations renewalMutations2 = subscription.getRenewalMutations();
                if (renewalMutations2 != null && planId == renewalMutations2.getPremiumBasePlanId()) {
                    break;
                } else {
                    i++;
                }
            }
            if (!zIsGoogleSubscription || skuDetails == null) {
                planString = getPlanString(subscriptionPlanType2);
            } else {
                planString = skuDetails.a();
                Intrinsics3.checkNotNullExpressionValue(planString, "skuDetails.description");
            }
            charSequenceK = FormatUtils.k(this, R.string.premium_pending_plan_change_notice, new Object[]{planString, strRenderUtcDate$default}, null, 4);
        } else if (zIsAccountHold) {
            String paymentGatewayPlanId2 = subscription.getPaymentGatewayPlanId();
            if (paymentGatewayPlanId2 == null) {
                SubscriptionPlanType[] subscriptionPlanTypeArrValues2 = SubscriptionPlanType.values();
                int i2 = 0;
                while (true) {
                    if (i2 >= 17) {
                        subscriptionPlanType = null;
                        break;
                    }
                    subscriptionPlanType = subscriptionPlanTypeArrValues2[i2];
                    if (subscription.hasAnyOfPlans(SetsJVM.setOf(Long.valueOf(subscriptionPlanType.getPlanId())))) {
                        break;
                    } else {
                        i2++;
                    }
                }
                CharSequence planString2 = getPlanString(subscriptionPlanType);
                charSequenceK = FormatUtils.k(this, R.string.premium_settings_account_hold_notice_info, new Object[]{TimeUtils.renderUtcDate$default(TimeUtils.INSTANCE, subscription.getAccountHoldEstimatedExpirationTimestamp(), requireContext(), 0, 4, null), planString2}, null, 4);
            } else {
                SkuDetails skuDetails2 = skuDetailsMap != null ? skuDetailsMap.get(paymentGatewayPlanId2) : null;
                if (skuDetails2 == null || (planString2 = skuDetails2.a()) == null) {
                }
                charSequenceK = FormatUtils.k(this, R.string.premium_settings_account_hold_notice_info, new Object[]{TimeUtils.renderUtcDate$default(TimeUtils.INSTANCE, subscription.getAccountHoldEstimatedExpirationTimestamp(), requireContext(), 0, 4, null), planString2}, null, 4);
            }
        } else {
            charSequenceK = "";
        }
        TextView textView = getBinding().p;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.premiumSettingsStatusNoticeTv");
        textView.setText(charSequenceK);
        Button button = getBinding().n;
        Intrinsics3.checkNotNullExpressionValue(button, "binding.premiumSettingsStatusNoticeButton");
        button.setVisibility(zIsAccountHold ? 0 : 8);
        if (zIsAccountHold) {
            Button button2 = getBinding().n;
            Intrinsics3.checkNotNullExpressionValue(button2, "binding.premiumSettingsStatusNoticeButton");
            FormatUtils.n(button2, R.string.premium_settings_account_hold_notice_change_payment_method_button, new Object[0], null, 4);
            getBinding().n.setOnClickListener(new AnonymousClass1(subscription));
        }
    }

    private final String getAnalyticsLocationSection() {
        String string;
        Bundle extras = getMostRecentIntent().getExtras();
        return (extras == null || (string = extras.getString(ANALYTICS_LOCATION_SECTION)) == null) ? "Discord Nitro" : string;
    }

    private final WidgetSettingsPremiumBinding getBinding() {
        return (WidgetSettingsPremiumBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final String getGoogleSubscriptionRenewalPrice(ModelSubscription subscription, Map<String, ? extends SkuDetails> skuDetails) {
        if (!subscription.isGoogleSubscription()) {
            return null;
        }
        SkuDetails skuDetails2 = skuDetails.get(subscription.getPaymentGatewayPlanId());
        ModelSubscription.SubscriptionRenewalMutations renewalMutations = subscription.getRenewalMutations();
        SkuDetails skuDetails3 = skuDetails.get(renewalMutations != null ? renewalMutations.getPaymentGatewayPlanId() : null);
        if (subscription.getRenewalMutations() != null && skuDetails3 != null) {
            return skuDetails3.b();
        }
        if (subscription.getRenewalMutations() != null || skuDetails2 == null) {
            return null;
        }
        return skuDetails2.b();
    }

    private final Companion.SubscriptionViewCallbacks getGuildBoostViewCallbacks(boolean isGoogleGuildBoost, String skuName) {
        if (!isGoogleGuildBoost) {
            return new Companion.SubscriptionViewCallbacks(null, null, null, new AnonymousClass6(), null);
        }
        return new Companion.SubscriptionViewCallbacks(new AnonymousClass2(skuName), new AnonymousClass3(skuName), new AnonymousClass4(skuName), new AnonymousClass1(), new AnonymousClass5(skuName));
    }

    private final CharSequence getPlanString(SubscriptionPlanType planType) {
        if (planType != null) {
            switch (planType.ordinal()) {
                case 6:
                    return FormatUtils.k(this, R.string.premium_plan_month_tier_1, new Object[0], null, 4);
                case 7:
                    return FormatUtils.k(this, R.string.premium_plan_year_tier_1, new Object[0], null, 4);
                case 8:
                    return FormatUtils.k(this, R.string.premium_plan_month_tier_2, new Object[0], null, 4);
                case 9:
                    return FormatUtils.k(this, R.string.premium_plan_3_month_tier_2, new Object[0], null, 4);
                case 10:
                    return FormatUtils.k(this, R.string.premium_plan_6_month_tier_2, new Object[0], null, 4);
                case 11:
                    return FormatUtils.k(this, R.string.premium_plan_year_tier_2, new Object[0], null, 4);
            }
        }
        return "";
    }

    private final Companion.SubscriptionViewCallbacks getPremiumSubscriptionViewCallbacks(ModelSubscription premiumSubscription, boolean canManageGuildBoosts, List<? extends Purchase> purchases) {
        if (!premiumSubscription.isGoogleSubscription()) {
            return premiumSubscription.isAppleSubscription() ? new Companion.SubscriptionViewCallbacks(null, null, null, null, null) : new Companion.SubscriptionViewCallbacks(null, new AnonymousClass4(), new AnonymousClass5(), null, null);
        }
        WidgetSettingsPremium5 widgetSettingsPremium5 = canManageGuildBoosts ? new WidgetSettingsPremium5(this) : null;
        boolean z2 = true;
        if ((purchases instanceof Collection) && purchases.isEmpty()) {
            z2 = false;
        } else {
            Iterator<T> it = purchases.iterator();
            while (it.hasNext()) {
                if (!((Purchase) it.next()).c()) {
                    break;
                }
            }
            z2 = false;
        }
        return new Companion.SubscriptionViewCallbacks(new AnonymousClass1(premiumSubscription), z2 ? new WidgetSettingsPremium6(this) : new WidgetSettingsPremium7(this, premiumSubscription), new AnonymousClass2(premiumSubscription), widgetSettingsPremium5, new AnonymousClass3(premiumSubscription));
    }

    private final CharSequence getPriceText(SkuDetails skuDetails) {
        return skuDetails != null ? FormatUtils.k(this, R.string.premium_settings_starting_at_per_month, new Object[]{skuDetails.b()}, null, 4) : FormatUtils.k(this, R.string.stream_premium_upsell_cta, new Object[0], null, 4);
    }

    private final SettingsPremiumViewModel getViewModel() {
        return (SettingsPremiumViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(SettingsPremiumViewModel.Event event) {
        if (event instanceof SettingsPremiumViewModel.Event.ErrorToast) {
            AppToast.i(this, ((SettingsPremiumViewModel.Event.ErrorToast) event).getErrorStringResId(), 0, 4);
        }
    }

    private final void scrollToSection(Integer section) {
        int top;
        if (section != null && section.intValue() == 0) {
            ViewPremiumSettingsTier1Binding viewPremiumSettingsTier1Binding = getBinding().t;
            Intrinsics3.checkNotNullExpressionValue(viewPremiumSettingsTier1Binding, "binding.premiumTier1");
            LinearLayout linearLayout = viewPremiumSettingsTier1Binding.a;
            Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.premiumTier1.root");
            int top2 = linearLayout.getTop();
            ScrollView scrollView = getBinding().m;
            Intrinsics3.checkNotNullExpressionValue(scrollView, "binding.premiumSettingsScrollview");
            top = scrollView.getHeight() + top2;
        } else if (section != null && section.intValue() == 1) {
            ViewPremiumSettingsTier2Binding viewPremiumSettingsTier2Binding = getBinding().u;
            Intrinsics3.checkNotNullExpressionValue(viewPremiumSettingsTier2Binding, "binding.premiumTier2");
            LinearLayout linearLayout2 = viewPremiumSettingsTier2Binding.a;
            Intrinsics3.checkNotNullExpressionValue(linearLayout2, "binding.premiumTier2.root");
            top = linearLayout2.getTop();
        } else {
            top = 0;
        }
        getBinding().m.scrollTo(0, top);
    }

    private final void scrollToTop() {
        getBinding().m.scrollTo(0, 0);
    }

    private final void showCancelConfirmationAlert(SettingsPremiumViewModel viewModel) {
        WidgetNoticeDialog.Companion companion = WidgetNoticeDialog.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        WidgetNoticeDialog.Companion.show$default(companion, parentFragmentManager, FormatUtils.k(this, R.string.premium_cancel_confirm_header, new Object[0], null, 4), FormatUtils.k(this, R.string.premium_cancel_confirm_body, new Object[]{AppHelpDesk.a.a(360055386693L, null)}, null, 4), FormatUtils.k(this, R.string.premium_cancel_confirm_button, new Object[0], null, 4), FormatUtils.k(this, R.string.nevermind, new Object[0], null, 4), MapsJVM.mapOf(Tuples.to(Integer.valueOf(R.id.notice_ok), new AnonymousClass1(viewModel))), null, null, null, Integer.valueOf(R.attr.notice_theme_positive_red), null, null, 0, null, 15808, null);
    }

    private final void showContent(SettingsPremiumViewModel.ViewState.Loaded model) {
        SubscriptionPlanType planType;
        AppViewFlipper appViewFlipper = getBinding().f2634s;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.premiumSettingsViewFlipper");
        appViewFlipper.setDisplayedChild(0);
        ModelSubscription premiumSubscription = model.getPremiumSubscription();
        Boolean boolValueOf = (premiumSubscription == null || (planType = premiumSubscription.getPlanType()) == null) ? null : Boolean.valueOf(planType.isPremiumSubscription());
        ModelSubscription premiumSubscription2 = model.getPremiumSubscription();
        Boolean boolValueOf2 = premiumSubscription2 != null ? Boolean.valueOf(premiumSubscription2.isNonePlan()) : null;
        Boolean bool = Boolean.FALSE;
        if (Intrinsics3.areEqual(boolValueOf, bool) && Intrinsics3.areEqual(boolValueOf2, bool)) {
            StringBuilder sbU = outline.U("Attempting to open WidgetSettingsPremium with non-Premium ");
            StringBuilder sbU2 = outline.U("and non-Guild Boost subscription: ");
            sbU2.append(model.getPremiumSubscription().getId());
            sbU.append(sbU2.toString());
            String string = sbU.toString();
            Intrinsics3.checkNotNullExpressionValue(string, "StringBuilder()\n        …}\")\n          .toString()");
            Logger.e$default(AppLog.g, string, null, null, 6, null);
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        configureActiveSubscriptionView(model);
        configureGrandfatheredHeader(model.getPremiumSubscription());
        configureLegalese(model);
        configureButtons(model.getPremiumSubscription(), model.getSkuDetails());
        configureAccountCredit(model.getEntitlements(), model.getPremiumSubscription());
        configurePaymentInfo(model);
        configureStatusNotice(model.getPremiumSubscription(), model.getSkuDetails());
        configurePriceChangeNotice(model.getPremiumSubscription(), model.getSkuDetails());
        Bundle extras = getMostRecentIntent().getExtras();
        Integer numValueOf = extras != null ? Integer.valueOf(extras.getInt(INTENT_SCROLL_TO_SECTION, -1)) : null;
        if (numValueOf != null && numValueOf.intValue() == -1) {
            return;
        }
        try {
            Observable<Long> observableD0 = Observable.d0(300L, TimeUnit.MILLISECONDS);
            Intrinsics3.checkNotNullExpressionValue(observableD0, "Observable\n            .…0, TimeUnit.MILLISECONDS)");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableD0, this, null, 2, null), getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(numValueOf), 62, (Object) null);
        } catch (Exception e) {
            Logger.e$default(AppLog.g, "Error Scrolling to section", e, null, 4, null);
        }
        getMostRecentIntent().removeExtra(INTENT_SCROLL_TO_SECTION);
    }

    private final void showDesktopManageAlert() {
        WidgetNoticeDialog.Companion companion = WidgetNoticeDialog.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        WidgetNoticeDialog.Companion.show$default(companion, parentFragmentManager, FormatUtils.k(this, R.string.billing_manage_subscription, new Object[0], null, 4), FormatUtils.k(this, R.string.premium_manage_via_desktop, new Object[]{AppHelpDesk.a.a(360055386693L, null)}, null, 4), FormatUtils.k(this, R.string.premium_guild_subscription_header_subscribe_tooltip_close, new Object[0], null, 4), null, null, null, null, null, null, null, null, 0, null, 16368, null);
    }

    private final void showFailureUI() {
        AppViewFlipper appViewFlipper = getBinding().f2634s;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.premiumSettingsViewFlipper");
        appViewFlipper.setDisplayedChild(2);
        getBinding().l.setOnClickListener(new AnonymousClass1());
    }

    private final void showLoadingUI() {
        AppViewFlipper appViewFlipper = getBinding().f2634s;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.premiumSettingsViewFlipper");
        appViewFlipper.setDisplayedChild(1);
        scrollToTop();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarSubtitle(R.string.user_settings);
        setActionBarTitle(R.string.premium_title);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        TextView textView = getBinding().d.e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.premiumPerks.uploadSizePerk");
        textView.setText(FormatUtils.d(view, R.string.premium_perks_upload_size, new Object[0], new AnonymousClass1()));
        TextView textView2 = getBinding().t.d;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.premiumTier1.tier1UploadSizePerk");
        textView2.setText(FormatUtils.d(view, R.string.premium_perks_upload_size, new Object[0], new AnonymousClass2()));
        TextView textView3 = getBinding().d.f239b;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.premiumPerks.guildSubscriptionPerk");
        textView3.setText(FormatUtils.d(view, R.string.premium_perks_tier_2_guild_subscription, new Object[0], AnonymousClass3.INSTANCE));
        TextView textView4 = getBinding().t.c;
        Intrinsics3.checkNotNullExpressionValue(textView4, "binding.premiumTier1.tier1GuildSubscriptionPerk");
        textView4.setText(FormatUtils.d(view, R.string.premium_perks_tier_1_guild_subscription, new Object[0], AnonymousClass4.INSTANCE));
        NumberFormat numberFormat = NumberFormat.getInstance(this.localeManager.getPrimaryLocale(requireContext()));
        TextView textView5 = getBinding().d.c;
        Intrinsics3.checkNotNullExpressionValue(textView5, "binding.premiumPerks.maxGuildsPerk");
        textView5.setText(FormatUtils.d(view, R.string.premium_perks_tier_2_max_guilds, new Object[0], new AnonymousClass5(numberFormat)));
        TextView textView6 = getBinding().d.d;
        Intrinsics3.checkNotNullExpressionValue(textView6, "binding.premiumPerks.maxMessageLengthPerk");
        textView6.setText(FormatUtils.e(this, R.string.premium_chat_perks_max_message_length, new Object[0], new AnonymousClass6(numberFormat)));
        configureButtonText$default(this, null, 1, null);
        for (TextView textView7 : Collections2.listOf((Object[]) new TextView[]{getBinding().r, getBinding().h, getBinding().c.g})) {
            AccessibilityUtils accessibilityUtils = AccessibilityUtils.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(textView7, "header");
            accessibilityUtils.setViewIsHeading(textView7);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<SettingsPremiumViewModel.ViewState> observableR = getViewModel().observeViewState().q(200L, TimeUnit.MILLISECONDS).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableR, this, null, 2, null), WidgetSettingsPremium.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(getViewModel().getEventSubject(), this, null, 2, null), WidgetSettingsPremium.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(this), 62, (Object) null);
    }

    private final CharSequence getPriceText(ModelSubscription premiumSubscription, Map<String, ? extends SkuDetails> skuDetails, ModelInvoicePreview3 invoiceItem) {
        SubscriptionPlanType planType;
        SkuDetails skuDetails2;
        boolean zIsGoogleSubscription = premiumSubscription != null ? premiumSubscription.isGoogleSubscription() : false;
        if (invoiceItem == null || (planType = SubscriptionPlanType.INSTANCE.from(invoiceItem.getSubscriptionPlanId())) == null) {
            planType = premiumSubscription != null ? premiumSubscription.getPlanType() : null;
        }
        boolean zIsMonthlyInterval = planType != null ? planType.isMonthlyInterval() : false;
        int intervalCount = planType != null ? planType.getIntervalCount() : 1;
        int i = R.string.billing_price_per_multi_months;
        if (!zIsMonthlyInterval) {
            i = R.string.billing_price_per_year;
        } else if (intervalCount != 3 && intervalCount != 6) {
            i = R.string.billing_price_per_month;
        }
        String strB = (premiumSubscription == null || (skuDetails2 = skuDetails.get(premiumSubscription.getPaymentGatewayPlanId())) == null) ? null : skuDetails2.b();
        if (zIsGoogleSubscription && strB != null) {
            return intervalCount == 1 ? FormatUtils.k(this, i, new Object[]{strB}, null, 4) : FormatUtils.k(this, i, new Object[]{strB, Integer.valueOf(intervalCount)}, null, 4);
        }
        if (intervalCount == 1) {
            Object[] objArr = new Object[1];
            objArr[0] = PremiumUtils2.getFormattedPriceUsd(invoiceItem != null ? invoiceItem.getAmount() : 0, requireContext());
            return FormatUtils.k(this, i, objArr, null, 4);
        }
        Object[] objArr2 = new Object[2];
        objArr2[0] = PremiumUtils2.getFormattedPriceUsd(invoiceItem != null ? invoiceItem.getAmount() : 0, requireContext());
        objArr2[1] = Integer.valueOf(intervalCount);
        return FormatUtils.k(this, i, objArr2, null, 4);
    }

    /* compiled from: WidgetSettingsPremium.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/i18n/RenderContext;", "", "invoke", "(Lcom/discord/i18n/RenderContext;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<RenderContext, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.args.put("maxUploadStandard", FormatUtils.k(WidgetSettingsPremium.this, R.string.file_upload_limit_standard, new Object[0], null, 4).toString());
            renderContext.args.put("maxUploadPremium", FormatUtils.k(WidgetSettingsPremium.this, R.string.file_upload_limit_premium_tier_2, new Object[0], null, 4).toString());
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }
    }

    /* compiled from: WidgetSettingsPremium.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/i18n/RenderContext;", "", "invoke", "(Lcom/discord/i18n/RenderContext;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<RenderContext, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.args.put("maxUploadStandard", FormatUtils.k(WidgetSettingsPremium.this, R.string.file_upload_limit_standard, new Object[0], null, 4).toString());
            renderContext.args.put("maxUploadPremium", FormatUtils.k(WidgetSettingsPremium.this, R.string.file_upload_limit_premium_tier_1, new Object[0], null, 4).toString());
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }
    }

    /* compiled from: WidgetSettingsPremium.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/i18n/RenderContext;", "", "invoke", "(Lcom/discord/i18n/RenderContext;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$onViewBound$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements Function1<RenderContext, Unit> {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        public AnonymousClass4() {
            super(1);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            Map<String, String> map = renderContext.args;
            String str = NumberFormat.getPercentInstance().format(Float.valueOf(0.3f));
            Intrinsics3.checkNotNullExpressionValue(str, "NumberFormat.getPercentI…_DISCOUNT_PERCENT\n      )");
            map.put("discountPercentage", str);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }
    }

    /* compiled from: WidgetSettingsPremium.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/i18n/RenderContext;", "", "invoke", "(Lcom/discord/i18n/RenderContext;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$onViewBound$5, reason: invalid class name */
    public static final class AnonymousClass5 extends Lambda implements Function1<RenderContext, Unit> {
        public final /* synthetic */ NumberFormat $numberFormat;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass5(NumberFormat numberFormat) {
            super(1);
            this.$numberFormat = numberFormat;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            Map<String, String> map = renderContext.args;
            String str = this.$numberFormat.format((Object) 100);
            Intrinsics3.checkNotNullExpressionValue(str, "numberFormat.format(Prem…_NON_PREMIUM_GUILD_COUNT)");
            map.put("nonPremiumMaxGuilds", str);
            Map<String, String> map2 = renderContext.args;
            String str2 = this.$numberFormat.format((Object) 200);
            Intrinsics3.checkNotNullExpressionValue(str2, "numberFormat.format(Prem….MAX_PREMIUM_GUILD_COUNT)");
            map2.put("premiumMaxGuilds", str2);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }
    }

    /* compiled from: WidgetSettingsPremium.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/i18n/RenderContext;", "", "invoke", "(Lcom/discord/i18n/RenderContext;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$onViewBound$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<RenderContext, Unit> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(1);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.args.put("numBoosts", String.valueOf(2));
            Map<String, String> map = renderContext.args;
            String str = NumberFormat.getPercentInstance().format(Float.valueOf(0.3f));
            Intrinsics3.checkNotNullExpressionValue(str, "NumberFormat.getPercentI…_DISCOUNT_PERCENT\n      )");
            map.put("discountPercentage", str);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }
    }

    /* compiled from: WidgetSettingsPremium.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/i18n/RenderContext;", "", "invoke", "(Lcom/discord/i18n/RenderContext;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$onViewBound$6, reason: invalid class name */
    public static final class AnonymousClass6 extends Lambda implements Function1<RenderContext, Unit> {
        public final /* synthetic */ NumberFormat $numberFormat;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass6(NumberFormat numberFormat) {
            super(1);
            this.$numberFormat = numberFormat;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            Map<String, String> map = renderContext.args;
            String str = this.$numberFormat.format((Object) 2000);
            Intrinsics3.checkNotNullExpressionValue(str, "numberFormat.format(Send…_MESSAGE_CHARACTER_COUNT)");
            map.put("nonPremiumMaxMessageLength", str);
            Map<String, String> map2 = renderContext.args;
            String str2 = this.$numberFormat.format(Integer.valueOf(SendUtils.MAX_MESSAGE_CHARACTER_COUNT_PREMIUM));
            Intrinsics3.checkNotNullExpressionValue(str2, "numberFormat.format(Send…_CHARACTER_COUNT_PREMIUM)");
            map2.put("premiumMaxMessageLength", str2);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }
    }
}
