package b.i.c.p;

import androidx.annotation.NonNull;
import java.io.IOException;

/* compiled from: Encoder.java */
/* renamed from: b.i.c.p.b, reason: use source file name */
/* loaded from: classes3.dex */
public interface Encoder<TValue, TContext> {
    void a(@NonNull TValue tvalue, @NonNull TContext tcontext) throws IOException;
}
