package b.i.c.u.p;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.i.c.u.p.AutoValue_TokenResult;
import com.google.auto.value.AutoValue;

/* compiled from: TokenResult.java */
@AutoValue
/* renamed from: b.i.c.u.p.f, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class TokenResult {

    /* compiled from: TokenResult.java */
    @AutoValue.Builder
    /* renamed from: b.i.c.u.p.f$a */
    public static abstract class a {
        @NonNull
        public abstract TokenResult a();

        @NonNull
        public abstract a b(long j);
    }

    /* compiled from: TokenResult.java */
    /* renamed from: b.i.c.u.p.f$b */
    public enum b {
        OK,
        BAD_CONFIG,
        AUTH_ERROR
    }

    @NonNull
    public static a a() {
        AutoValue_TokenResult.b bVar = new AutoValue_TokenResult.b();
        bVar.b(0L);
        return bVar;
    }

    @Nullable
    public abstract b b();

    @Nullable
    public abstract String c();

    @NonNull
    public abstract long d();
}
