package i0.e0.b;

import i0.Converter2;
import java.io.IOException;
import okhttp3.ResponseBody;

/* compiled from: ScalarResponseBodyConverters.java */
/* renamed from: i0.e0.b.c, reason: use source file name */
/* loaded from: classes3.dex */
public final class ScalarResponseBodyConverters2 implements Converter2<ResponseBody, Byte> {
    public static final ScalarResponseBodyConverters2 a = new ScalarResponseBodyConverters2();

    @Override // i0.Converter2
    public Byte convert(ResponseBody responseBody) throws IOException {
        return Byte.valueOf(responseBody.d());
    }
}
