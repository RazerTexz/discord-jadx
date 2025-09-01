package androidx.core.graphics.drawable;

import android.graphics.Bitmap;
import android.net.Uri;
import androidx.annotation.RequiresApi;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: Icon.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0087\b¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u0087\b¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u0005H\u0087\b¢\u0006\u0004\b\u0004\u0010\u0006\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u0007H\u0087\b¢\u0006\u0004\b\u0004\u0010\b¨\u0006\t"}, d2 = {"Landroid/graphics/Bitmap;", "Landroid/graphics/drawable/Icon;", "toAdaptiveIcon", "(Landroid/graphics/Bitmap;)Landroid/graphics/drawable/Icon;", "toIcon", "Landroid/net/Uri;", "(Landroid/net/Uri;)Landroid/graphics/drawable/Icon;", "", "([B)Landroid/graphics/drawable/Icon;", "core-ktx_release"}, k = 2, mv = {1, 5, 1})
/* renamed from: androidx.core.graphics.drawable.IconKt, reason: use source file name */
/* loaded from: classes.dex */
public final class Icon {
    @RequiresApi(26)
    public static final android.graphics.drawable.Icon toAdaptiveIcon(Bitmap bitmap) {
        Intrinsics3.checkNotNullParameter(bitmap, "<this>");
        android.graphics.drawable.Icon iconCreateWithAdaptiveBitmap = android.graphics.drawable.Icon.createWithAdaptiveBitmap(bitmap);
        Intrinsics3.checkNotNullExpressionValue(iconCreateWithAdaptiveBitmap, "createWithAdaptiveBitmap(this)");
        return iconCreateWithAdaptiveBitmap;
    }

    @RequiresApi(26)
    public static final android.graphics.drawable.Icon toIcon(Bitmap bitmap) {
        Intrinsics3.checkNotNullParameter(bitmap, "<this>");
        android.graphics.drawable.Icon iconCreateWithBitmap = android.graphics.drawable.Icon.createWithBitmap(bitmap);
        Intrinsics3.checkNotNullExpressionValue(iconCreateWithBitmap, "createWithBitmap(this)");
        return iconCreateWithBitmap;
    }

    @RequiresApi(26)
    public static final android.graphics.drawable.Icon toIcon(Uri uri) {
        Intrinsics3.checkNotNullParameter(uri, "<this>");
        android.graphics.drawable.Icon iconCreateWithContentUri = android.graphics.drawable.Icon.createWithContentUri(uri);
        Intrinsics3.checkNotNullExpressionValue(iconCreateWithContentUri, "createWithContentUri(this)");
        return iconCreateWithContentUri;
    }

    @RequiresApi(26)
    public static final android.graphics.drawable.Icon toIcon(byte[] bArr) {
        Intrinsics3.checkNotNullParameter(bArr, "<this>");
        android.graphics.drawable.Icon iconCreateWithData = android.graphics.drawable.Icon.createWithData(bArr, 0, bArr.length);
        Intrinsics3.checkNotNullExpressionValue(iconCreateWithData, "createWithData(this, 0, size)");
        return iconCreateWithData;
    }
}
