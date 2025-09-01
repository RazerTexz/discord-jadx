package b.i.a.c.x2.i0;

import b.i.b.a.Function2;
import java.util.Objects;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class c implements Function2 {
    public final /* synthetic */ FragmentedMp4Extractor a;

    public /* synthetic */ c(FragmentedMp4Extractor fragmentedMp4Extractor) {
        this.a = fragmentedMp4Extractor;
    }

    @Override // b.i.b.a.Function2
    public final Object apply(Object obj) {
        Track track = (Track) obj;
        Objects.requireNonNull(this.a);
        return track;
    }
}
