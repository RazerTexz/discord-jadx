package com.discord.utilities.extensions;

import android.os.Build;
import kotlin.Metadata;

/* compiled from: PendingIntentExtensions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\b\n\u0002\b\u0005\u001a\u0017\u0010\u0002\u001a\u00020\u00002\b\b\u0002\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0017\u0010\u0004\u001a\u00020\u00002\b\b\u0002\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0003¨\u0006\u0005"}, d2 = {"", "flags", "immutablePendingIntentFlag", "(I)I", "mutablePendingIntentFlag", "app_productionGoogleRelease"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.extensions.PendingIntentExtensionsKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class PendingIntentExtensions {
    public static final int immutablePendingIntentFlag(int i) {
        return Build.VERSION.SDK_INT >= 23 ? i | 67108864 : i;
    }

    public static /* synthetic */ int immutablePendingIntentFlag$default(int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return immutablePendingIntentFlag(i);
    }

    public static final int mutablePendingIntentFlag(int i) {
        return i;
    }

    public static /* synthetic */ int mutablePendingIntentFlag$default(int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return mutablePendingIntentFlag(i);
    }
}
