package f0;

import f0.e0.d.JavaNetAuthenticator;
import java.io.IOException;
import okhttp3.Request;
import okhttp3.Response;

/* compiled from: Authenticator.kt */
/* renamed from: f0.c, reason: use source file name */
/* loaded from: classes3.dex */
public interface Authenticator2 {
    public static final Authenticator2 a = new Authenticator();

    static {
        new JavaNetAuthenticator(null, 1);
    }

    Request a(Route route, Response response) throws IOException;
}
