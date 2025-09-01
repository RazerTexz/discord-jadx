package b.i.a.c.d3;

import android.content.res.Resources;
import java.util.Objects;

/* compiled from: DefaultTrackNameProvider.java */
/* renamed from: b.i.a.c.d3.l, reason: use source file name */
/* loaded from: classes3.dex */
public class DefaultTrackNameProvider implements TrackNameProvider {
    public final Resources a;

    public DefaultTrackNameProvider(Resources resources) {
        Objects.requireNonNull(resources);
        this.a = resources;
    }
}
