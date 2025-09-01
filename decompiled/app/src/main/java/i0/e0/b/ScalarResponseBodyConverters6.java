package i0.e0.b;

import i0.Converter2;
import java.io.IOException;
import okhttp3.ResponseBody;

/* compiled from: ScalarResponseBodyConverters.java */
/* renamed from: i0.e0.b.g, reason: use source file name */
/* loaded from: classes3.dex */
public final class ScalarResponseBodyConverters6 implements Converter2<ResponseBody, Integer> {
    public static final ScalarResponseBodyConverters6 a = new ScalarResponseBodyConverters6();

    @Override // i0.Converter2
    public Integer convert(ResponseBody responseBody) throws IOException {
        return Integer.valueOf(responseBody.d());
    }
}
