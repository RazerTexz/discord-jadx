package b.i.a.c.c3;

import androidx.annotation.Nullable;
import b.i.a.c.Bundleable;
import b.i.a.c.a3.TrackGroup;
import b.i.b.b.ImmutableCollection;
import b.i.b.b.ImmutableList2;
import b.i.b.b.ImmutableMap2;
import b.i.b.b.RegularImmutableMap;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* compiled from: TrackSelectionOverrides.java */
/* renamed from: b.i.a.c.c3.o, reason: use source file name */
/* loaded from: classes3.dex */
public final class TrackSelectionOverrides implements Bundleable {
    public static final TrackSelectionOverrides j = new TrackSelectionOverrides(RegularImmutableMap.m);
    public static final Bundleable.a<TrackSelectionOverrides> k = d.a;
    public final ImmutableMap2<TrackGroup, a> l;

    public TrackSelectionOverrides(Map<TrackGroup, a> map) {
        this.l = ImmutableMap2.a(map);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TrackSelectionOverrides.class != obj.getClass()) {
            return false;
        }
        return this.l.equals(((TrackSelectionOverrides) obj).l);
    }

    public int hashCode() {
        return this.l.hashCode();
    }

    /* compiled from: TrackSelectionOverrides.java */
    /* renamed from: b.i.a.c.c3.o$a */
    public static final class a implements Bundleable {
        public static final /* synthetic */ int j = 0;
        public final TrackGroup k;
        public final ImmutableList2<Integer> l;

        public a(TrackGroup trackGroup) {
            this.k = trackGroup;
            b.i.a.f.e.o.f.A(4, "initialCapacity");
            Object[] objArrCopyOf = new Object[4];
            int i = 0;
            int i2 = 0;
            while (i < trackGroup.k) {
                Integer numValueOf = Integer.valueOf(i);
                Objects.requireNonNull(numValueOf);
                int i3 = i2 + 1;
                if (objArrCopyOf.length < i3) {
                    objArrCopyOf = Arrays.copyOf(objArrCopyOf, ImmutableCollection.b.a(objArrCopyOf.length, i3));
                }
                objArrCopyOf[i2] = numValueOf;
                i++;
                i2 = i3;
            }
            this.l = ImmutableList2.l(objArrCopyOf, i2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.k.equals(aVar.k) && this.l.equals(aVar.l);
        }

        public int hashCode() {
            return (this.l.hashCode() * 31) + this.k.hashCode();
        }

        public a(TrackGroup trackGroup, List<Integer> list) {
            if (!list.isEmpty() && (((Integer) Collections.min(list)).intValue() < 0 || ((Integer) Collections.max(list)).intValue() >= trackGroup.k)) {
                throw new IndexOutOfBoundsException();
            }
            this.k = trackGroup;
            this.l = ImmutableList2.n(list);
        }
    }
}
