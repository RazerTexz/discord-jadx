package i0.e0.b;

import i0.Converter2;
import java.io.IOException;
import okhttp3.ResponseBody;

/* compiled from: ScalarResponseBodyConverters.java */
/* renamed from: i0.e0.b.e, reason: use source file name */
/* loaded from: classes3.dex */
public final class ScalarResponseBodyConverters4 implements Converter2<ResponseBody, Double> {
    public static final ScalarResponseBodyConverters4 a = new ScalarResponseBodyConverters4();

    @Override // i0.Converter2
    public Double convert(ResponseBody responseBody) throws IOException {
        return Double.valueOf(responseBody.d());
    }
}
