package com.discord.utilities.billing;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.DrawableRes;
import com.discord.R;
import com.discord.models.domain.ModelPaymentSource;
import com.discord.utilities.locale.LocaleManager;
import d0.z.d.Intrinsics3;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.Objects;
import kotlin.Metadata;

/* compiled from: PremiumUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\n\"\u0019\u0010\f\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0016\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011\"\u0016\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011\"\u0016\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011\"\u0019\u0010\u0014\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0015\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/discord/models/domain/ModelPaymentSource;", "paymentSource", "", "getPaymentSourceIcon", "(Lcom/discord/models/domain/ModelPaymentSource;)I", "priceUsCents", "Landroid/content/Context;", "context", "", "getFormattedPriceUsd", "(ILandroid/content/Context;)Ljava/lang/CharSequence;", "Ljava/util/Date;", "GRANDFATHERED_YEARLY_END_DATE", "Ljava/util/Date;", "getGRANDFATHERED_YEARLY_END_DATE", "()Ljava/util/Date;", "GRACE_PERIOD_SHORT", "I", "MAX_ACCOUNT_HOLD_DAYS", "GRACE_PERIOD_LONG", "GRANDFATHERED_MONTHLY_END_DATE", "getGRANDFATHERED_MONTHLY_END_DATE", "app_productionGoogleRelease"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.billing.PremiumUtilsKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class PremiumUtils2 {
    public static final int GRACE_PERIOD_LONG = 7;
    public static final int GRACE_PERIOD_SHORT = 3;
    private static final Date GRANDFATHERED_MONTHLY_END_DATE;
    private static final Date GRANDFATHERED_YEARLY_END_DATE;
    public static final int MAX_ACCOUNT_HOLD_DAYS = 30;

    static {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, 2, 1);
        Intrinsics3.checkNotNullExpressionValue(calendar, "Calendar.getInstance().apply { set(2020, 2, 1) }");
        Date time = calendar.getTime();
        Intrinsics3.checkNotNullExpressionValue(time, "Calendar.getInstance().a… { set(2020, 2, 1) }.time");
        GRANDFATHERED_MONTHLY_END_DATE = time;
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(2021, 0, 1);
        Intrinsics3.checkNotNullExpressionValue(calendar2, "Calendar.getInstance().apply { set(2021, 0, 1) }");
        Date time2 = calendar2.getTime();
        Intrinsics3.checkNotNullExpressionValue(time2, "Calendar.getInstance().a… { set(2021, 0, 1) }.time");
        GRANDFATHERED_YEARLY_END_DATE = time2;
    }

    public static final CharSequence getFormattedPriceUsd(int i, Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(new LocaleManager().getPrimaryLocale(context));
        currencyInstance.setCurrency(Currency.getInstance("USD"));
        String str = currencyInstance.format(Float.valueOf(i / 100));
        Intrinsics3.checkNotNullExpressionValue(str, "numberFormat.format(priceUsdDollars)");
        return str;
    }

    public static final Date getGRANDFATHERED_MONTHLY_END_DATE() {
        return GRANDFATHERED_MONTHLY_END_DATE;
    }

    public static final Date getGRANDFATHERED_YEARLY_END_DATE() {
        return GRANDFATHERED_YEARLY_END_DATE;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    @DrawableRes
    @SuppressLint({"DefaultLocale"})
    public static final int getPaymentSourceIcon(ModelPaymentSource modelPaymentSource) {
        Intrinsics3.checkNotNullParameter(modelPaymentSource, "paymentSource");
        if (modelPaymentSource instanceof ModelPaymentSource.ModelPaymentSourcePaypal) {
            return R.drawable.ic_creditcard_paypal;
        }
        if (!(modelPaymentSource instanceof ModelPaymentSource.ModelPaymentSourceCard)) {
            return R.drawable.ic_creditcard_generic;
        }
        String brand = ((ModelPaymentSource.ModelPaymentSourceCard) modelPaymentSource).getBrand();
        Objects.requireNonNull(brand, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = brand.toLowerCase();
        Intrinsics3.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
        switch (lowerCase.hashCode()) {
            case -2038717326:
                if (lowerCase.equals("mastercard")) {
                }
                break;
            case 2997727:
                if (lowerCase.equals("amex")) {
                }
                break;
            case 3619905:
                if (lowerCase.equals("visa")) {
                }
                break;
            case 61060803:
                if (lowerCase.equals("american-express")) {
                }
                break;
            case 273184745:
                if (lowerCase.equals("discover")) {
                }
                break;
            case 1174445979:
                if (lowerCase.equals("master-card")) {
                }
                break;
        }
        return R.drawable.ic_creditcard_generic;
    }
}
