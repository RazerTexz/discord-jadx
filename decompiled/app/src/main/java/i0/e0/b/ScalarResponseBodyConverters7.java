package i0.e0.b;

import i0.Converter2;
import java.io.IOException;
import okhttp3.ResponseBody;

/* compiled from: ScalarResponseBodyConverters.java */
/* renamed from: i0.e0.b.h, reason: use source file name */
/* loaded from: classes3.dex */
public final class ScalarResponseBodyConverters7 implements Converter2<ResponseBody, Long> {
    public static final ScalarResponseBodyConverters7 a = new ScalarResponseBodyConverters7();

    @Override // i0.Converter2
    public Long convert(ResponseBody responseBody) throws IOException {
        return Long.valueOf(responseBody.d());
    }
}
