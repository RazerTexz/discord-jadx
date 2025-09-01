package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;
import b.f.d.d.DoNotStrip;
import b.f.m.n.NativeLoader;

@DoNotStrip
/* loaded from: classes3.dex */
public class NativeBlurFilter {
    static {
        NativeLoader.c("native-filters");
    }

    @DoNotStrip
    private static native void nativeIterativeBoxBlur(Bitmap bitmap, int i, int i2);
}
