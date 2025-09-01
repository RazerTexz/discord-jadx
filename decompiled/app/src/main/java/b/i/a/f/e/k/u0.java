package b.i.a.f.e.k;

import android.net.Uri;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* loaded from: classes3.dex */
public final class u0 {
    public static final Uri a;

    static {
        Uri uri = Uri.parse("https://plus.google.com/");
        a = uri;
        uri.buildUpon().appendPath("circles").appendPath("find").build();
    }
}
