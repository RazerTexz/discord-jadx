package b.i.a.f.e.h.j;

import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.f.e.h.a;
import b.i.a.f.e.h.a.d;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* loaded from: classes3.dex */
public final class b<O extends a.d> {
    public final int a;

    /* renamed from: b, reason: collision with root package name */
    public final b.i.a.f.e.h.a<O> f1354b;

    @Nullable
    public final O c;

    public b(b.i.a.f.e.h.a<O> aVar, @Nullable O o) {
        this.f1354b = aVar;
        this.c = o;
        this.a = Arrays.hashCode(new Object[]{aVar, o});
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return AnimatableValueParser.h0(this.f1354b, bVar.f1354b) && AnimatableValueParser.h0(this.c, bVar.c);
    }

    public final int hashCode() {
        return this.a;
    }
}
