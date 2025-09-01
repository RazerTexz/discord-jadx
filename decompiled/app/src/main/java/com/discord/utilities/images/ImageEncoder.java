package com.discord.utilities.images;

import android.graphics.Bitmap;
import android.util.Base64;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;

/* compiled from: ImageEncoder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/discord/utilities/images/ImageEncoder;", "", "Landroid/graphics/Bitmap;", "bitmap", "", "jpegQuality", "", "encodeBitmapAsJpegDataUrl", "(Landroid/graphics/Bitmap;I)Ljava/lang/String;", "mimeType", "Ljava/io/InputStream;", "inputStream", "getDataUrl", "(Ljava/lang/String;Ljava/io/InputStream;)Ljava/lang/String;", "flags", "getBase64EncodedString", "(Ljava/io/InputStream;I)Ljava/lang/String;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ImageEncoder {
    public static /* synthetic */ String encodeBitmapAsJpegDataUrl$default(ImageEncoder imageEncoder, Bitmap bitmap, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 100;
        }
        return imageEncoder.encodeBitmapAsJpegDataUrl(bitmap, i);
    }

    public final String encodeBitmapAsJpegDataUrl(Bitmap bitmap, int jpegQuality) {
        Intrinsics3.checkNotNullParameter(bitmap, "bitmap");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, jpegQuality, byteArrayOutputStream);
        String strEncodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
        Intrinsics3.checkNotNullExpressionValue(strEncodeToString, "Base64.encodeToString(jp…eArray(), Base64.NO_WRAP)");
        return outline.P(new Object[]{"image/jpeg", strEncodeToString}, 2, "data:%s;base64,%s", "java.lang.String.format(format, *args)");
    }

    public final String getBase64EncodedString(InputStream inputStream, int flags) throws IOException {
        Intrinsics3.checkNotNullParameter(inputStream, "inputStream");
        byte[] bArr = new byte[8192];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                return Base64.encodeToString(byteArrayOutputStream.toByteArray(), flags);
            }
            byteArrayOutputStream.write(bArr, 0, i);
        }
    }

    public final String getDataUrl(String mimeType, InputStream inputStream) throws IOException {
        Intrinsics3.checkNotNullParameter(mimeType, "mimeType");
        Intrinsics3.checkNotNullParameter(inputStream, "inputStream");
        return outline.P(new Object[]{mimeType, getBase64EncodedString(inputStream, 2)}, 2, "data:%s;base64,%s", "java.lang.String.format(format, *args)");
    }
}
