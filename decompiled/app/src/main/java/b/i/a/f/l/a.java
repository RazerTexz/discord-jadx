package b.i.a.f.l;

import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.f.e.h.a;
import java.util.Arrays;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* loaded from: classes3.dex */
public final class a implements a.d {
    public static final a j = new a();

    public final boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        Objects.requireNonNull((a) obj);
        return AnimatableValueParser.h0(null, null) && AnimatableValueParser.h0(null, null) && AnimatableValueParser.h0(null, null) && AnimatableValueParser.h0(null, null) && AnimatableValueParser.h0(null, null);
    }

    public final int hashCode() {
        Boolean bool = Boolean.FALSE;
        return Arrays.hashCode(new Object[]{bool, bool, null, bool, bool, null, null, null, null});
    }
}
