package b.i.a.c.c3;

import android.os.Bundle;
import b.i.a.c.Bundleable;
import b.i.a.c.Format2;
import b.i.a.c.a3.TrackGroup;
import b.i.a.c.c3.TrackSelectionOverrides;
import b.i.a.c.f3.BundleableUtil;
import b.i.b.b.AbstractIndexedListIterator;
import b.i.b.b.ImmutableList2;
import b.i.b.b.RegularImmutableList;
import b.i.b.c.Ints;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class e implements Bundleable.a {
    public static final /* synthetic */ e a = new e();

    @Override // b.i.a.c.Bundleable.a
    public final Bundleable a(Bundle bundle) {
        int i = TrackSelectionOverrides.a.j;
        Bundle bundle2 = bundle.getBundle(Integer.toString(0, 36));
        Objects.requireNonNull(bundle2);
        int i2 = TrackGroup.j;
        Bundleable.a<Format2> aVar = Format2.k;
        ArrayList parcelableArrayList = bundle2.getParcelableArrayList(Integer.toString(0, 36));
        AbstractIndexedListIterator<Object> abstractIndexedListIterator = ImmutableList2.k;
        TrackGroup trackGroup = new TrackGroup((Format2[]) BundleableUtil.b(aVar, parcelableArrayList, RegularImmutableList.l).toArray(new Format2[0]));
        int[] intArray = bundle.getIntArray(Integer.toString(1, 36));
        if (intArray == null) {
            return new TrackSelectionOverrides.a(trackGroup);
        }
        return new TrackSelectionOverrides.a(trackGroup, intArray.length == 0 ? Collections.emptyList() : new Ints(intArray));
    }
}
