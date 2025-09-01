package i0;

import retrofit2.Response;

/* compiled from: Callback.java */
/* renamed from: i0.f, reason: use source file name */
/* loaded from: classes3.dex */
public interface Callback3<T> {
    void a(Call3<T> call3, Throwable th);

    void b(Call3<T> call3, Response<T> response);
}
