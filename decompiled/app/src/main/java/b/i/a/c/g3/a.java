package b.i.a.c.g3;

import android.os.Bundle;
import b.i.a.c.Bundleable;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class a implements Bundleable.a {
    public static final /* synthetic */ a a = new a();

    @Override // b.i.a.c.Bundleable.a
    public final Bundleable a(Bundle bundle) {
        return new ColorInfo(bundle.getInt(ColorInfo.c(0), -1), bundle.getInt(ColorInfo.c(1), -1), bundle.getInt(ColorInfo.c(2), -1), bundle.getByteArray(ColorInfo.c(3)));
    }
}
