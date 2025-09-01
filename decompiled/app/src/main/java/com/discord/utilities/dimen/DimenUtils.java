package com.discord.utilities.dimen;

import android.content.res.Resources;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: DimenUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\u001a\u0015\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0015\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0004¢\u0006\u0004\b\u0002\u0010\u0005\u001a\u0015\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0000¢\u0006\u0004\b\u0007\u0010\u0003\"\u0016\u0010\b\u001a\u00020\u00048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"", "densityPixels", "dpToPixels", "(I)I", "", "(F)I", "pixels", "pixelsToDp", "DENSITY", "F", "utils_release"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class DimenUtils {
    private static final float DENSITY;

    static {
        Resources system = Resources.getSystem();
        Intrinsics3.checkNotNullExpressionValue(system, "Resources.getSystem()");
        DENSITY = system.getDisplayMetrics().density;
    }

    public static final int dpToPixels(int i) {
        return (int) (i * DENSITY);
    }

    public static final int pixelsToDp(int i) {
        return (int) (i / DENSITY);
    }

    public static final int dpToPixels(float f) {
        return (int) (f * DENSITY);
    }
}
