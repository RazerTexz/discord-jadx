package b.i.a.c.a3.p0;

import android.os.Bundle;
import b.i.a.c.Bundleable;
import b.i.a.c.a3.p0.AdPlaybackState;
import java.util.ArrayList;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class b implements Bundleable.a {
    public static final /* synthetic */ b a = new b();

    @Override // b.i.a.c.Bundleable.a
    public final Bundleable a(Bundle bundle) {
        AdPlaybackState.a[] aVarArr;
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(AdPlaybackState.b(1));
        if (parcelableArrayList == null) {
            aVarArr = new AdPlaybackState.a[0];
        } else {
            AdPlaybackState.a[] aVarArr2 = new AdPlaybackState.a[parcelableArrayList.size()];
            for (int i = 0; i < parcelableArrayList.size(); i++) {
                int i2 = AdPlaybackState.a.j;
                aVarArr2[i] = (AdPlaybackState.a) a.a.a((Bundle) parcelableArrayList.get(i));
            }
            aVarArr = aVarArr2;
        }
        return new AdPlaybackState(null, aVarArr, bundle.getLong(AdPlaybackState.b(2), 0L), bundle.getLong(AdPlaybackState.b(3), -9223372036854775807L), bundle.getInt(AdPlaybackState.b(4)));
    }
}
