package y.a.b;

import android.net.Uri;
import androidx.browser.trusted.TrustedWebActivityServiceConnectionPool;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ TrustedWebActivityServiceConnectionPool j;
    public final /* synthetic */ Uri k;

    public /* synthetic */ c(TrustedWebActivityServiceConnectionPool trustedWebActivityServiceConnectionPool, Uri uri) {
        this.j = trustedWebActivityServiceConnectionPool;
        this.k = uri;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.j.a(this.k);
    }
}
