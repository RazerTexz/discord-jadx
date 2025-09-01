package com.discord.utilities.locale;

import android.content.Context;
import android.content.res.Resources;
import androidx.core.os.ConfigurationCompat;
import d0.z.d.Intrinsics3;
import java.util.Locale;
import kotlin.Metadata;

/* compiled from: LocaleManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/utilities/locale/LocaleManager;", "", "Landroid/content/Context;", "context", "Ljava/util/Locale;", "getPrimaryLocale", "(Landroid/content/Context;)Ljava/util/Locale;", "<init>", "()V", "utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class LocaleManager {
    public final Locale getPrimaryLocale(Context context) {
        if (context == null) {
            Locale locale = Locale.getDefault();
            Intrinsics3.checkNotNullExpressionValue(locale, "Locale.getDefault()");
            return locale;
        }
        Resources resources = context.getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "context.resources");
        Locale locale2 = ConfigurationCompat.getLocales(resources.getConfiguration()).get(0);
        Intrinsics3.checkNotNullExpressionValue(locale2, "ConfigurationCompat.getL…sources.configuration)[0]");
        return locale2;
    }
}
