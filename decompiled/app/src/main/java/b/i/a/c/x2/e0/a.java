package b.i.a.c.x2.e0;

import android.net.Uri;
import b.i.a.c.x2.Extractor;
import b.i.a.c.x2.ExtractorsFactory;
import b.i.a.c.x2.ExtractorsFactory2;
import java.util.Map;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class a implements ExtractorsFactory2 {
    public static final /* synthetic */ a a = new a();

    @Override // b.i.a.c.x2.ExtractorsFactory2
    public final Extractor[] a() {
        return new Extractor[]{new FlvExtractor()};
    }

    @Override // b.i.a.c.x2.ExtractorsFactory2
    public /* synthetic */ Extractor[] b(Uri uri, Map map) {
        return ExtractorsFactory.a(this, uri, map);
    }
}
