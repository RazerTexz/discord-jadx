package f0;

import java.io.IOException;
import okhttp3.Request;
import okhttp3.Response;

/* compiled from: Call.kt */
/* renamed from: f0.e, reason: use source file name */
/* loaded from: classes3.dex */
public interface Call2 extends Cloneable {

    /* compiled from: Call.kt */
    /* renamed from: f0.e$a */
    public interface a {
        Call2 b(Request request);
    }

    Request c();

    void cancel();

    boolean d();

    void e(Callback2 callback2);

    Response execute() throws IOException;
}
