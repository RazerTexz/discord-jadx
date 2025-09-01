package b.i.a.c;

import android.os.Bundle;
import b.i.a.c.Bundleable;
import b.i.a.c.MediaItem2;
import b.i.a.c.Timeline;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class q0 implements Bundleable.a {
    public static final /* synthetic */ q0 a = new q0();

    @Override // b.i.a.c.Bundleable.a
    public final Bundleable a(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle(Timeline.c.d(1));
        MediaItem2 mediaItem2 = bundle2 != null ? (MediaItem2) MediaItem2.j.a(bundle2) : null;
        long j = bundle.getLong(Timeline.c.d(2), -9223372036854775807L);
        long j2 = bundle.getLong(Timeline.c.d(3), -9223372036854775807L);
        long j3 = bundle.getLong(Timeline.c.d(4), -9223372036854775807L);
        boolean z2 = bundle.getBoolean(Timeline.c.d(5), false);
        boolean z3 = bundle.getBoolean(Timeline.c.d(6), false);
        Bundle bundle3 = bundle.getBundle(Timeline.c.d(7));
        MediaItem2.g gVar = bundle3 != null ? (MediaItem2.g) MediaItem2.g.k.a(bundle3) : null;
        boolean z4 = bundle.getBoolean(Timeline.c.d(8), false);
        long j4 = bundle.getLong(Timeline.c.d(9), 0L);
        long j5 = bundle.getLong(Timeline.c.d(10), -9223372036854775807L);
        int i = bundle.getInt(Timeline.c.d(11), 0);
        int i2 = bundle.getInt(Timeline.c.d(12), 0);
        long j6 = bundle.getLong(Timeline.c.d(13), 0L);
        Timeline.c cVar = new Timeline.c();
        cVar.e(Timeline.c.k, mediaItem2, null, j, j2, j3, z2, z3, gVar, j4, j5, i, i2, j6);
        cVar.f1044y = z4;
        return cVar;
    }
}
