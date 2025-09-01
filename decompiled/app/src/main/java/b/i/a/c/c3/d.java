package b.i.a.c.c3;

import android.os.Bundle;
import b.i.a.c.Bundleable;
import b.i.a.c.c3.TrackSelectionOverrides;
import b.i.a.c.f3.BundleableUtil;
import b.i.b.b.AbstractIndexedListIterator;
import b.i.b.b.ImmutableList2;
import b.i.b.b.ImmutableMap2;
import b.i.b.b.RegularImmutableList;
import java.util.ArrayList;
import java.util.List;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class d implements Bundleable.a {
    public static final /* synthetic */ d a = new d();

    @Override // b.i.a.c.Bundleable.a
    public final Bundleable a(Bundle bundle) {
        TrackSelectionOverrides trackSelectionOverrides = TrackSelectionOverrides.j;
        int i = TrackSelectionOverrides.a.j;
        e eVar = e.a;
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(Integer.toString(0, 36));
        AbstractIndexedListIterator<Object> abstractIndexedListIterator = ImmutableList2.k;
        List listB = BundleableUtil.b(eVar, parcelableArrayList, RegularImmutableList.l);
        ImmutableMap2.a aVar = new ImmutableMap2.a(4);
        for (int i2 = 0; i2 < listB.size(); i2++) {
            TrackSelectionOverrides.a aVar2 = (TrackSelectionOverrides.a) listB.get(i2);
            aVar.c(aVar2.k, aVar2);
        }
        return new TrackSelectionOverrides(aVar.a());
    }
}
