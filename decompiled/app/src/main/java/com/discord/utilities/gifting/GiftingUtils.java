package com.discord.utilities.gifting;

import android.content.Context;
import android.view.View;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.SkuDetails;
import com.discord.R;
import com.discord.api.premium.PremiumTier;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelSku4;
import com.discord.stores.StoreGooglePlayPurchases;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.billing.GooglePlayBillingManager;
import com.discord.utilities.billing.GooglePlayInAppSku;
import com.discord.utilities.billing.GooglePlayInAppSku2;
import com.discord.utilities.premium.PremiumUtils;
import com.discord.utilities.resources.DurationUtils2;
import com.discord.utilities.resources.DurationUtils3;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.google.gson.JsonIOException;
import d0.Tuples;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: GiftingUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001$B\t\b\u0002¢\u0006\u0004\b\"\u0010#J\u0015\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u000e\u0010\u0013\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0012¢\u0006\u0004\b\u0015\u0010\u0016J7\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u00192\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b¢\u0006\u0004\b\u001e\u0010\u001fR\u0016\u0010 \u001a\u00020\u00068\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b \u0010!¨\u0006%"}, d2 = {"Lcom/discord/utilities/gifting/GiftingUtils;", "", "", "giftCode", "generateGiftUrl", "(Ljava/lang/String;)Ljava/lang/String;", "", "millis", "Landroid/content/Context;", "context", "", "getTimeString", "(JLandroid/content/Context;)Ljava/lang/CharSequence;", "Lcom/discord/utilities/billing/GooglePlayInAppSku;", "inAppSku", "", "getIconForSku", "(Lcom/discord/utilities/billing/GooglePlayInAppSku;)Ljava/lang/Integer;", "Lcom/discord/primitives/SkuId;", "skuId", "Lcom/discord/api/premium/PremiumTier;", "getTierForSku", "(Ljava/lang/Long;)Lcom/discord/api/premium/PremiumTier;", "Landroidx/fragment/app/FragmentActivity;", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "Lcom/discord/utilities/analytics/Traits$Location;", ModelAuditLogEntry.CHANGE_KEY_LOCATION, "Lkotlin/Function0;", "", "dismissWarningCallback", "buyGift", "(Landroidx/fragment/app/FragmentActivity;Lcom/discord/utilities/billing/GooglePlayInAppSku;Lcom/discord/utilities/analytics/Traits$Location;Lkotlin/jvm/functions/Function0;)V", "PREMIUM_SUBSCRIPTION_APPLICATION_ID", "J", "<init>", "()V", "SkuTypes", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class GiftingUtils {
    public static final GiftingUtils INSTANCE = new GiftingUtils();
    public static final long PREMIUM_SUBSCRIPTION_APPLICATION_ID = 521842831262875670L;

    /* compiled from: GiftingUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/discord/utilities/gifting/GiftingUtils$SkuTypes;", "", "", ModelAuditLogEntry.CHANGE_KEY_ID, "I", "getId", "()I", "<init>", "(Ljava/lang/String;II)V", "DURABLE_PRIMARY", "DURABLE", "CONSUMABLE", "BUNDLE", "SUBSCRIPTION", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public enum SkuTypes {
        DURABLE_PRIMARY(1),
        DURABLE(2),
        CONSUMABLE(3),
        BUNDLE(4),
        SUBSCRIPTION(5);

        private final int id;

        SkuTypes(int i) {
            this.id = i;
        }

        public final int getId() {
            return this.id;
        }
    }

    /* compiled from: GiftingUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "launchBillingFlow"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.gifting.GiftingUtils$buyGift$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ FragmentActivity $activity;
        public final /* synthetic */ BillingFlowParams $billingParams;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(FragmentActivity fragmentActivity, BillingFlowParams billingFlowParams) {
            super(0);
            this.$activity = fragmentActivity;
            this.$billingParams = billingFlowParams;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            GooglePlayBillingManager googlePlayBillingManager = GooglePlayBillingManager.INSTANCE;
            if (googlePlayBillingManager.launchBillingFlow(this.$activity, this.$billingParams) == 7) {
                googlePlayBillingManager.queryPurchases();
            }
        }
    }

    /* compiled from: GiftingUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.gifting.GiftingUtils$buyGift$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ GooglePlayInAppSku $inAppSku;
        public final /* synthetic */ AnonymousClass1 $launchBillingFlow$1;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(GooglePlayInAppSku googlePlayInAppSku, AnonymousClass1 anonymousClass1) {
            super(1);
            this.$inAppSku = googlePlayInAppSku;
            this.$launchBillingFlow$1 = anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) throws JsonIOException {
            invoke2(view);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) throws JsonIOException {
            Intrinsics3.checkNotNullParameter(view, "it");
            StoreStream.INSTANCE.getGooglePlayPurchases().trackPaymentFlowStep(this.$inAppSku.getPaymentGatewaySkuId(), "warning_dialog", "");
            this.$launchBillingFlow$1.invoke2();
        }
    }

    /* compiled from: GiftingUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.gifting.GiftingUtils$buyGift$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ Function0 $dismissWarningCallback;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(Function0 function0) {
            super(1);
            this.$dismissWarningCallback = function0;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            Function0 function0 = this.$dismissWarningCallback;
            if (function0 != null) {
            }
        }
    }

    /* compiled from: GiftingUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.gifting.GiftingUtils$buyGift$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Function0 $dismissWarningCallback;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(Function0 function0) {
            super(0);
            this.$dismissWarningCallback = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Function0 function0 = this.$dismissWarningCallback;
            if (function0 != null) {
            }
        }
    }

    private GiftingUtils() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void buyGift$default(GiftingUtils giftingUtils, FragmentActivity fragmentActivity, GooglePlayInAppSku googlePlayInAppSku, Traits.Location location, Function0 function0, int i, Object obj) throws Exception {
        if ((i & 8) != 0) {
            function0 = null;
        }
        giftingUtils.buyGift(fragmentActivity, googlePlayInAppSku, location, function0);
    }

    public final void buyGift(FragmentActivity activity, GooglePlayInAppSku inAppSku, Traits.Location location, Function0<Unit> dismissWarningCallback) throws Exception {
        Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Intrinsics3.checkNotNullParameter(inAppSku, "inAppSku");
        Intrinsics3.checkNotNullParameter(location, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        SkuDetails skuDetails = inAppSku.getSkuDetails();
        if (skuDetails == null) {
            throw new Exception("No skuDetails for " + inAppSku);
        }
        UserUtils userUtils = UserUtils.INSTANCE;
        StoreStream.Companion companion = StoreStream.INSTANCE;
        String obfuscatedUserId = userUtils.getObfuscatedUserId(Long.valueOf(companion.getUsers().getMeSnapshot().getId()));
        if (obfuscatedUserId == null) {
            throw new Exception("No current user ID");
        }
        BillingFlowParams.a aVar = new BillingFlowParams.a();
        ArrayList<SkuDetails> arrayList = new ArrayList<>();
        arrayList.add(skuDetails);
        aVar.d = arrayList;
        aVar.a = obfuscatedUserId;
        BillingFlowParams billingFlowParamsA = aVar.a();
        Intrinsics3.checkNotNullExpressionValue(billingFlowParamsA, "BillingFlowParams\n      …dUserId)\n        .build()");
        Long skuId = inAppSku.getSkuId();
        if (skuId == null) {
            throw new Exception("No skuId for " + inAppSku);
        }
        long jLongValue = skuId.longValue();
        StoreGooglePlayPurchases googlePlayPurchases = companion.getGooglePlayPurchases();
        String paymentGatewaySkuId = inAppSku.getPaymentGatewaySkuId();
        int id2 = SkuTypes.SUBSCRIPTION.getId();
        String strA = skuDetails.a();
        Intrinsics3.checkNotNullExpressionValue(strA, "skuDetails.description");
        Traits.StoreSku storeSku = new Traits.StoreSku(jLongValue, id2, 521842831262875670L, strA);
        PremiumUtils premiumUtils = PremiumUtils.INSTANCE;
        int iMicroAmountToMinor = premiumUtils.microAmountToMinor(skuDetails.c());
        int iMicroAmountToMinor2 = premiumUtils.microAmountToMinor(skuDetails.f2006b.has("original_price_micros") ? skuDetails.f2006b.optLong("original_price_micros") : skuDetails.c());
        String strOptString = skuDetails.f2006b.optString("price_currency_code");
        Intrinsics3.checkNotNullExpressionValue(strOptString, "skuDetails.priceCurrencyCode");
        Locale locale = Locale.ROOT;
        Intrinsics3.checkNotNullExpressionValue(locale, "Locale.ROOT");
        Objects.requireNonNull(strOptString, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = strOptString.toLowerCase(locale);
        Intrinsics3.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        googlePlayPurchases.trackPaymentFlowStarted(paymentGatewaySkuId, jLongValue, location, storeSku, new Traits.Payment(Traits.Payment.Type.SUBSCRIPTION, iMicroAmountToMinor, iMicroAmountToMinor2, lowerCase, true));
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(activity, billingFlowParamsA);
        if (companion.getGooglePlayPurchases().hasSeenGiftingWarning()) {
            anonymousClass1.invoke2();
            return;
        }
        WidgetNoticeDialog.Companion companion2 = WidgetNoticeDialog.INSTANCE;
        FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
        String string = activity.getString(R.string.dialog_just_so_you_know);
        String string2 = activity.getString(R.string.gift_purchase_google_play_notice_extended);
        Intrinsics3.checkNotNullExpressionValue(string2, "activity.getString(R.str…gle_play_notice_extended)");
        WidgetNoticeDialog.Companion.show$default(companion2, supportFragmentManager, string, string2, activity.getString(R.string.application_store_buy_gift), activity.getString(R.string.nevermind), Maps6.mapOf(Tuples.to(Integer.valueOf(R.id.notice_ok), new AnonymousClass2(inAppSku, anonymousClass1)), Tuples.to(Integer.valueOf(R.id.notice_cancel), new AnonymousClass3(dismissWarningCallback))), null, null, null, null, null, null, 0, new AnonymousClass4(dismissWarningCallback), 8128, null);
        companion.getGooglePlayPurchases().markViewedGiftingWarning();
    }

    public final String generateGiftUrl(String giftCode) {
        Intrinsics3.checkNotNullParameter(giftCode, "giftCode");
        return "https://discord.gift/" + giftCode;
    }

    public final Integer getIconForSku(GooglePlayInAppSku inAppSku) {
        Intrinsics3.checkNotNullParameter(inAppSku, "inAppSku");
        if (Intrinsics3.areEqual(inAppSku, GooglePlayInAppSku2.getPremiumTier1Month())) {
            return Integer.valueOf(R.drawable.ic_plan_premium_tier_1);
        }
        if (Intrinsics3.areEqual(inAppSku, GooglePlayInAppSku2.getPremiumTier1Year())) {
            return Integer.valueOf(R.drawable.ic_plan_premium_tier_1_year);
        }
        if (Intrinsics3.areEqual(inAppSku, GooglePlayInAppSku2.getPremiumTier2Month())) {
            return Integer.valueOf(R.drawable.ic_plan_premium_tier_2);
        }
        if (Intrinsics3.areEqual(inAppSku, GooglePlayInAppSku2.getPremiumTier2Year())) {
            return Integer.valueOf(R.drawable.ic_plan_premium_tier_2_year);
        }
        return null;
    }

    public final PremiumTier getTierForSku(Long skuId) {
        if (skuId != null && skuId.longValue() == ModelSku4.PREMIUM_TIER_1_SKU_ID) {
            return PremiumTier.TIER_1;
        }
        if (skuId != null && skuId.longValue() == ModelSku4.PREMIUM_TIER_2_SKU_ID) {
            return PremiumTier.TIER_2;
        }
        return null;
    }

    public final CharSequence getTimeString(long millis, Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        TimeUtils timeUtils = TimeUtils.INSTANCE;
        int hoursFromMillis = timeUtils.getHoursFromMillis(millis);
        if (hoursFromMillis > 0) {
            return DurationUtils3.formatDuration(context, DurationUtils2.HOURS, hoursFromMillis);
        }
        return DurationUtils3.formatDuration(context, DurationUtils2.MINS, timeUtils.getMinutesFromMillis(millis));
    }
}
