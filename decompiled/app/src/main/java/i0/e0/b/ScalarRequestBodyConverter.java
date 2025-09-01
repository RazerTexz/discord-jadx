package i0.e0.b;

import i0.Converter2;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* compiled from: ScalarRequestBodyConverter.java */
/* renamed from: i0.e0.b.a, reason: use source file name */
/* loaded from: classes3.dex */
public final class ScalarRequestBodyConverter<T> implements Converter2<T, RequestBody> {
    public static final ScalarRequestBodyConverter<Object> a = new ScalarRequestBodyConverter<>();

    /* renamed from: b, reason: collision with root package name */
    public static final MediaType f3739b;

    static {
        MediaType.Companion companion = MediaType.INSTANCE;
        f3739b = MediaType.Companion.a("text/plain; charset=UTF-8");
    }

    @Override // i0.Converter2
    public RequestBody convert(Object obj) throws IOException {
        return RequestBody.create(f3739b, String.valueOf(obj));
    }
}
