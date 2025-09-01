package b.i.a.c;

import android.os.Bundle;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.Bundleable;
import b.i.a.c.MediaItem2;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class i0 implements Bundleable.a {
    public static final /* synthetic */ i0 a = new i0();

    @Override // b.i.a.c.Bundleable.a
    public final Bundleable a(Bundle bundle) {
        MediaItem2.d.a aVar = new MediaItem2.d.a();
        long j = bundle.getLong(MediaItem2.d.a(0), 0L);
        boolean z2 = true;
        AnimatableValueParser.j(j >= 0);
        aVar.a = j;
        long j2 = bundle.getLong(MediaItem2.d.a(1), Long.MIN_VALUE);
        if (j2 != Long.MIN_VALUE && j2 < 0) {
            z2 = false;
        }
        AnimatableValueParser.j(z2);
        aVar.f1035b = j2;
        aVar.c = bundle.getBoolean(MediaItem2.d.a(2), false);
        aVar.d = bundle.getBoolean(MediaItem2.d.a(3), false);
        aVar.e = bundle.getBoolean(MediaItem2.d.a(4), false);
        return aVar.a();
    }
}
