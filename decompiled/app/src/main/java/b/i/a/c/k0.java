package b.i.a.c;

import android.os.Bundle;
import b.i.a.c.Bundleable;
import b.i.a.c.MediaItem2;
import java.util.Objects;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class k0 implements Bundleable.a {
    public static final /* synthetic */ k0 a = new k0();

    @Override // b.i.a.c.Bundleable.a
    public final Bundleable a(Bundle bundle) {
        String string = bundle.getString(MediaItem2.a(0), "");
        Objects.requireNonNull(string);
        Bundle bundle2 = bundle.getBundle(MediaItem2.a(1));
        MediaItem2.g gVar = bundle2 == null ? MediaItem2.g.j : (MediaItem2.g) MediaItem2.g.k.a(bundle2);
        Bundle bundle3 = bundle.getBundle(MediaItem2.a(2));
        MediaMetadata mediaMetadata = bundle3 == null ? MediaMetadata.j : (MediaMetadata) MediaMetadata.k.a(bundle3);
        Bundle bundle4 = bundle.getBundle(MediaItem2.a(3));
        return new MediaItem2(string, bundle4 == null ? MediaItem2.e.p : (MediaItem2.e) MediaItem2.d.j.a(bundle4), null, gVar, mediaMetadata);
    }
}
