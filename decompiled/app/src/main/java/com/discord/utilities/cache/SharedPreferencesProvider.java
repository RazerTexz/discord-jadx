package com.discord.utilities.cache;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.VisibleForTesting;
import androidx.preference.PreferenceManager;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: SharedPreferencesProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\tJ\u0019\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/discord/utilities/cache/SharedPreferencesProvider;", "", "Landroid/content/Context;", "context", "", "init", "(Landroid/content/Context;)V", "Landroid/content/SharedPreferences;", "get", "()Landroid/content/SharedPreferences;", "getPrefsSessionDurable", "prefs", "setInstanceForTesting", "(Landroid/content/SharedPreferences;)V", "prefsSessionDurable", "Landroid/content/SharedPreferences;", "sharedPreferences", "<init>", "()V", "utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class SharedPreferencesProvider {
    public static final SharedPreferencesProvider INSTANCE = new SharedPreferencesProvider();
    private static SharedPreferences prefsSessionDurable;
    private static SharedPreferences sharedPreferences;

    private SharedPreferencesProvider() {
    }

    public final SharedPreferences get() {
        SharedPreferences sharedPreferences2 = sharedPreferences;
        if (sharedPreferences2 != null) {
            return sharedPreferences2;
        }
        throw new IllegalStateException("You must call init() before accessing prefs");
    }

    public final SharedPreferences getPrefsSessionDurable() {
        SharedPreferences sharedPreferences2 = prefsSessionDurable;
        if (sharedPreferences2 != null) {
            return sharedPreferences2;
        }
        throw new IllegalStateException("You must call init() before accessing prefsSessionDurable");
    }

    public final void init(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        prefsSessionDurable = context.getSharedPreferences("prefsSessionDurable", 0);
    }

    @VisibleForTesting
    public final void setInstanceForTesting(SharedPreferences prefs) {
        sharedPreferences = prefs;
    }
}
