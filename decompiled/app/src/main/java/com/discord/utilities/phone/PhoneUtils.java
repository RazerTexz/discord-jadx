package com.discord.utilities.phone;

import android.content.Context;
import b.d.b.a.outline;
import com.discord.models.phone.PhoneCountryCode;
import d0.z.d.Intrinsics3;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.text.Regex;

/* compiled from: PhoneUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u001d\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/discord/utilities/phone/PhoneUtils;", "", "", "input", "", "isValidPhoneFragment", "(Ljava/lang/String;)Z", "isLikelyToContainPhoneNumber", "Lcom/discord/models/phone/PhoneCountryCode;", "data", "Landroid/content/Context;", "context", "getTranslatedStringForCountry", "(Lcom/discord/models/phone/PhoneCountryCode;Landroid/content/Context;)Ljava/lang/String;", "Lkotlin/text/Regex;", "PARTIAL_PHONE_RE", "Lkotlin/text/Regex;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class PhoneUtils {
    public static final PhoneUtils INSTANCE = new PhoneUtils();
    private static final Regex PARTIAL_PHONE_RE = new Regex("^[-() \\d]+$");

    private PhoneUtils() {
    }

    public final String getTranslatedStringForCountry(PhoneCountryCode data, Context context) {
        Intrinsics3.checkNotNullParameter(data, "data");
        Intrinsics3.checkNotNullParameter(context, "context");
        String phoneCountryCode = data.getPhoneCountryCode();
        Locale locale = Locale.getDefault();
        Intrinsics3.checkNotNullExpressionValue(locale, "Locale.getDefault()");
        Objects.requireNonNull(phoneCountryCode, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = phoneCountryCode.toLowerCase(locale);
        Intrinsics3.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        int identifier = context.getResources().getIdentifier(outline.w("country_name_", lowerCase), "string", context.getPackageName());
        if (identifier == 0) {
            return data.getName();
        }
        String string = context.getString(identifier);
        Intrinsics3.checkNotNullExpressionValue(string, "context.getString(identifier)");
        return string;
    }

    public final boolean isLikelyToContainPhoneNumber(String input) {
        Intrinsics3.checkNotNullParameter(input, "input");
        if (input.length() < 3) {
            return false;
        }
        return isValidPhoneFragment(input);
    }

    public final boolean isValidPhoneFragment(String input) {
        Intrinsics3.checkNotNullParameter(input, "input");
        return PARTIAL_PHONE_RE.matches(input);
    }
}
