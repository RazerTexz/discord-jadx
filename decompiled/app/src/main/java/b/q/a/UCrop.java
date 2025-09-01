package b.q.a;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;

/* compiled from: UCrop.java */
/* renamed from: b.q.a.a, reason: use source file name */
/* loaded from: classes3.dex */
public class UCrop {
    public Intent a = new Intent();

    /* renamed from: b, reason: collision with root package name */
    public Bundle f1977b;

    public UCrop(@NonNull Uri uri, @NonNull Uri uri2) {
        Bundle bundle = new Bundle();
        this.f1977b = bundle;
        bundle.putParcelable("com.yalantis.ucrop.InputUri", uri);
        this.f1977b.putParcelable("com.yalantis.ucrop.OutputUri", uri2);
    }
}
