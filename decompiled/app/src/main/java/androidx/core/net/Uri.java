package androidx.core.net;

import d0.z.d.Intrinsics3;
import java.io.File;
import kotlin.Metadata;

/* compiled from: Uri.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0086\b¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0004H\u0086\b¢\u0006\u0004\b\u0002\u0010\u0005\u001a\u0011\u0010\u0006\u001a\u00020\u0004*\u00020\u0001¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"", "Landroid/net/Uri;", "toUri", "(Ljava/lang/String;)Landroid/net/Uri;", "Ljava/io/File;", "(Ljava/io/File;)Landroid/net/Uri;", "toFile", "(Landroid/net/Uri;)Ljava/io/File;", "core-ktx_release"}, k = 2, mv = {1, 5, 1})
/* renamed from: androidx.core.net.UriKt, reason: use source file name */
/* loaded from: classes.dex */
public final class Uri {
    public static final File toFile(android.net.Uri uri) {
        Intrinsics3.checkNotNullParameter(uri, "<this>");
        if (!Intrinsics3.areEqual(uri.getScheme(), "file")) {
            throw new IllegalArgumentException(Intrinsics3.stringPlus("Uri lacks 'file' scheme: ", uri).toString());
        }
        String path = uri.getPath();
        if (path != null) {
            return new File(path);
        }
        throw new IllegalArgumentException(Intrinsics3.stringPlus("Uri path is null: ", uri).toString());
    }

    public static final android.net.Uri toUri(String str) {
        Intrinsics3.checkNotNullParameter(str, "<this>");
        android.net.Uri uri = android.net.Uri.parse(str);
        Intrinsics3.checkNotNullExpressionValue(uri, "parse(this)");
        return uri;
    }

    public static final android.net.Uri toUri(File file) {
        Intrinsics3.checkNotNullParameter(file, "<this>");
        android.net.Uri uriFromFile = android.net.Uri.fromFile(file);
        Intrinsics3.checkNotNullExpressionValue(uriFromFile, "fromFile(this)");
        return uriFromFile;
    }
}
