package d0.y;

import d0.Exceptions;
import java.io.IOException;

/* compiled from: Closeable.kt */
/* renamed from: d0.y.b, reason: use source file name */
/* loaded from: classes3.dex */
public final class Closeable {
    public static final void closeFinally(java.io.Closeable closeable, Throwable th) throws IOException {
        if (closeable == null) {
            return;
        }
        if (th == null) {
            closeable.close();
            return;
        }
        try {
            closeable.close();
        } catch (Throwable th2) {
            Exceptions.addSuppressed(th, th2);
        }
    }
}
