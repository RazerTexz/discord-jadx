package b.i.a.c;

import android.os.Bundle;
import b.i.a.c.Bundleable;
import b.i.a.c.MediaItem2;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class j0 implements Bundleable.a {
    public static final /* synthetic */ j0 a = new j0();

    @Override // b.i.a.c.Bundleable.a
    public final Bundleable a(Bundle bundle) {
        return new MediaItem2.g(bundle.getLong(MediaItem2.g.a(0), -9223372036854775807L), bundle.getLong(MediaItem2.g.a(1), -9223372036854775807L), bundle.getLong(MediaItem2.g.a(2), -9223372036854775807L), bundle.getFloat(MediaItem2.g.a(3), -3.4028235E38f), bundle.getFloat(MediaItem2.g.a(4), -3.4028235E38f));
    }
}
