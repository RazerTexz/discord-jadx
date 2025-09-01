package b.i.a.c;

import android.net.Uri;
import android.os.Bundle;
import b.i.a.c.Bundleable;
import b.i.a.c.MediaMetadata;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class l0 implements Bundleable.a {
    public static final /* synthetic */ l0 a = new l0();

    @Override // b.i.a.c.Bundleable.a
    public final Bundleable a(Bundle bundle) {
        Bundle bundle2;
        Bundle bundle3;
        MediaMetadata.b bVar = new MediaMetadata.b();
        bVar.a = bundle.getCharSequence(MediaMetadata.b(0));
        bVar.f1050b = bundle.getCharSequence(MediaMetadata.b(1));
        bVar.c = bundle.getCharSequence(MediaMetadata.b(2));
        bVar.d = bundle.getCharSequence(MediaMetadata.b(3));
        bVar.e = bundle.getCharSequence(MediaMetadata.b(4));
        bVar.f = bundle.getCharSequence(MediaMetadata.b(5));
        bVar.g = bundle.getCharSequence(MediaMetadata.b(6));
        bVar.h = (Uri) bundle.getParcelable(MediaMetadata.b(7));
        byte[] byteArray = bundle.getByteArray(MediaMetadata.b(10));
        Integer numValueOf = bundle.containsKey(MediaMetadata.b(29)) ? Integer.valueOf(bundle.getInt(MediaMetadata.b(29))) : null;
        bVar.k = byteArray != null ? (byte[]) byteArray.clone() : null;
        bVar.l = numValueOf;
        bVar.m = (Uri) bundle.getParcelable(MediaMetadata.b(11));
        bVar.f1052x = bundle.getCharSequence(MediaMetadata.b(22));
        bVar.f1053y = bundle.getCharSequence(MediaMetadata.b(23));
        bVar.f1054z = bundle.getCharSequence(MediaMetadata.b(24));
        bVar.C = bundle.getCharSequence(MediaMetadata.b(27));
        bVar.D = bundle.getCharSequence(MediaMetadata.b(28));
        bVar.E = bundle.getBundle(MediaMetadata.b(1000));
        if (bundle.containsKey(MediaMetadata.b(8)) && (bundle3 = bundle.getBundle(MediaMetadata.b(8))) != null) {
            int i = Rating.j;
            bVar.i = (Rating) o0.a.a(bundle3);
        }
        if (bundle.containsKey(MediaMetadata.b(9)) && (bundle2 = bundle.getBundle(MediaMetadata.b(9))) != null) {
            int i2 = Rating.j;
            bVar.j = (Rating) o0.a.a(bundle2);
        }
        if (bundle.containsKey(MediaMetadata.b(12))) {
            bVar.n = Integer.valueOf(bundle.getInt(MediaMetadata.b(12)));
        }
        if (bundle.containsKey(MediaMetadata.b(13))) {
            bVar.o = Integer.valueOf(bundle.getInt(MediaMetadata.b(13)));
        }
        if (bundle.containsKey(MediaMetadata.b(14))) {
            bVar.p = Integer.valueOf(bundle.getInt(MediaMetadata.b(14)));
        }
        if (bundle.containsKey(MediaMetadata.b(15))) {
            bVar.q = Boolean.valueOf(bundle.getBoolean(MediaMetadata.b(15)));
        }
        if (bundle.containsKey(MediaMetadata.b(16))) {
            bVar.r = Integer.valueOf(bundle.getInt(MediaMetadata.b(16)));
        }
        if (bundle.containsKey(MediaMetadata.b(17))) {
            bVar.f1051s = Integer.valueOf(bundle.getInt(MediaMetadata.b(17)));
        }
        if (bundle.containsKey(MediaMetadata.b(18))) {
            bVar.t = Integer.valueOf(bundle.getInt(MediaMetadata.b(18)));
        }
        if (bundle.containsKey(MediaMetadata.b(19))) {
            bVar.u = Integer.valueOf(bundle.getInt(MediaMetadata.b(19)));
        }
        if (bundle.containsKey(MediaMetadata.b(20))) {
            bVar.v = Integer.valueOf(bundle.getInt(MediaMetadata.b(20)));
        }
        if (bundle.containsKey(MediaMetadata.b(21))) {
            bVar.w = Integer.valueOf(bundle.getInt(MediaMetadata.b(21)));
        }
        if (bundle.containsKey(MediaMetadata.b(25))) {
            bVar.A = Integer.valueOf(bundle.getInt(MediaMetadata.b(25)));
        }
        if (bundle.containsKey(MediaMetadata.b(26))) {
            bVar.B = Integer.valueOf(bundle.getInt(MediaMetadata.b(26)));
        }
        return bVar.a();
    }
}
