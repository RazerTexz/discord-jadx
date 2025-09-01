package com.facebook.imagepipeline.nativecode;

import b.f.d.d.DoNotStrip;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@DoNotStrip
/* loaded from: classes3.dex */
public class WebpTranscoderImpl {
    @DoNotStrip
    private static native void nativeTranscodeWebpToJpeg(InputStream inputStream, OutputStream outputStream, int i) throws IOException;

    @DoNotStrip
    private static native void nativeTranscodeWebpToPng(InputStream inputStream, OutputStream outputStream) throws IOException;
}
