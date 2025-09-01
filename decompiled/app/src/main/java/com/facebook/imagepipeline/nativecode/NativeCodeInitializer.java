package com.facebook.imagepipeline.nativecode;

import android.content.Context;
import b.f.d.d.DoNotStrip;
import com.facebook.soloader.SoLoader;
import java.io.IOException;

@DoNotStrip
/* loaded from: classes3.dex */
public class NativeCodeInitializer {
    @DoNotStrip
    public static void init(Context context) throws IOException {
        SoLoader.init(context, 0);
    }
}
