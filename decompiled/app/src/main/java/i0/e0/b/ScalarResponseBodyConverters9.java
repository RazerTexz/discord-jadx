package i0.e0.b;

import i0.Converter2;
import java.io.IOException;
import okhttp3.ResponseBody;

/* compiled from: ScalarResponseBodyConverters.java */
/* renamed from: i0.e0.b.j, reason: use source file name */
/* loaded from: classes3.dex */
public final class ScalarResponseBodyConverters9 implements Converter2<ResponseBody, String> {
    public static final ScalarResponseBodyConverters9 a = new ScalarResponseBodyConverters9();

    @Override // i0.Converter2
    public String convert(ResponseBody responseBody) throws IOException {
        return responseBody.d();
    }
}
