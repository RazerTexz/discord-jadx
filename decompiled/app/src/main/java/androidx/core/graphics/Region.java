package androidx.core.graphics;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.RegionIterator;
import d0.z.d.Intrinsics3;
import d0.z.d.g0.KMarkers;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: Region.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\u0003\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\n¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001c\u0010\b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\u0086\n¢\u0006\u0004\b\b\u0010\t\u001a\u001c\u0010\b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0000H\u0086\n¢\u0006\u0004\b\b\u0010\n\u001a\u001c\u0010\u000b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\u0086\n¢\u0006\u0004\b\u000b\u0010\t\u001a\u001c\u0010\u000b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0000H\u0086\n¢\u0006\u0004\b\u000b\u0010\n\u001a\u0014\u0010\f\u001a\u00020\u0000*\u00020\u0000H\u0086\n¢\u0006\u0004\b\f\u0010\r\u001a\u0014\u0010\u000e\u001a\u00020\u0000*\u00020\u0000H\u0086\n¢\u0006\u0004\b\u000e\u0010\r\u001a\u001c\u0010\u000f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\u0086\f¢\u0006\u0004\b\u000f\u0010\t\u001a\u001c\u0010\u000f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0000H\u0086\f¢\u0006\u0004\b\u000f\u0010\n\u001a\u001c\u0010\u0010\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\u0086\f¢\u0006\u0004\b\u0010\u0010\t\u001a\u001c\u0010\u0010\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0000H\u0086\f¢\u0006\u0004\b\u0010\u0010\n\u001a\u001c\u0010\u0011\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\u0086\f¢\u0006\u0004\b\u0011\u0010\t\u001a\u001c\u0010\u0011\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0000H\u0086\f¢\u0006\u0004\b\u0011\u0010\n\u001a+\u0010\u0015\u001a\u00020\u0013*\u00020\u00002\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00130\u0012H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u0017*\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u0018\u0010\u0019\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001a"}, d2 = {"Landroid/graphics/Region;", "Landroid/graphics/Point;", "p", "", "contains", "(Landroid/graphics/Region;Landroid/graphics/Point;)Z", "Landroid/graphics/Rect;", "r", "plus", "(Landroid/graphics/Region;Landroid/graphics/Rect;)Landroid/graphics/Region;", "(Landroid/graphics/Region;Landroid/graphics/Region;)Landroid/graphics/Region;", "minus", "unaryMinus", "(Landroid/graphics/Region;)Landroid/graphics/Region;", "not", "or", "and", "xor", "Lkotlin/Function1;", "", "action", "forEach", "(Landroid/graphics/Region;Lkotlin/jvm/functions/Function1;)V", "", "iterator", "(Landroid/graphics/Region;)Ljava/util/Iterator;", "core-ktx_release"}, k = 2, mv = {1, 5, 1})
/* renamed from: androidx.core.graphics.RegionKt, reason: use source file name */
/* loaded from: classes.dex */
public final class Region {

    /* compiled from: Region.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"androidx/core/graphics/RegionKt$iterator$1", "", "Landroid/graphics/Rect;", "", "hasNext", "()Z", "next", "()Landroid/graphics/Rect;", "hasMore", "Z", "Landroid/graphics/RegionIterator;", "iterator", "Landroid/graphics/RegionIterator;", "rect", "Landroid/graphics/Rect;", "core-ktx_release"}, k = 1, mv = {1, 5, 1})
    /* renamed from: androidx.core.graphics.RegionKt$iterator$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Iterator<Rect>, KMarkers {
        public final /* synthetic */ android.graphics.Region $this_iterator;
        private boolean hasMore;
        private final RegionIterator iterator;
        private final Rect rect;

        public AnonymousClass1(android.graphics.Region region) {
            this.$this_iterator = region;
            RegionIterator regionIterator = new RegionIterator(region);
            this.iterator = regionIterator;
            Rect rect = new Rect();
            this.rect = rect;
            this.hasMore = regionIterator.next(rect);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.hasMore;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Rect next() {
            return next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Rect next() {
            if (!this.hasMore) {
                throw new IndexOutOfBoundsException();
            }
            Rect rect = new Rect(this.rect);
            this.hasMore = this.iterator.next(this.rect);
            return rect;
        }
    }

    public static final android.graphics.Region and(android.graphics.Region region, Rect rect) {
        Intrinsics3.checkNotNullParameter(region, "<this>");
        Intrinsics3.checkNotNullParameter(rect, "r");
        android.graphics.Region region2 = new android.graphics.Region(region);
        region2.op(rect, Region.Op.INTERSECT);
        return region2;
    }

    public static final boolean contains(android.graphics.Region region, Point point) {
        Intrinsics3.checkNotNullParameter(region, "<this>");
        Intrinsics3.checkNotNullParameter(point, "p");
        return region.contains(point.x, point.y);
    }

    public static final void forEach(android.graphics.Region region, Function1<? super Rect, Unit> function1) {
        Intrinsics3.checkNotNullParameter(region, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "action");
        RegionIterator regionIterator = new RegionIterator(region);
        while (true) {
            Rect rect = new Rect();
            if (!regionIterator.next(rect)) {
                return;
            } else {
                function1.invoke(rect);
            }
        }
    }

    public static final Iterator<Rect> iterator(android.graphics.Region region) {
        Intrinsics3.checkNotNullParameter(region, "<this>");
        return new AnonymousClass1(region);
    }

    public static final android.graphics.Region minus(android.graphics.Region region, Rect rect) {
        Intrinsics3.checkNotNullParameter(region, "<this>");
        Intrinsics3.checkNotNullParameter(rect, "r");
        android.graphics.Region region2 = new android.graphics.Region(region);
        region2.op(rect, Region.Op.DIFFERENCE);
        return region2;
    }

    public static final android.graphics.Region not(android.graphics.Region region) {
        Intrinsics3.checkNotNullParameter(region, "<this>");
        android.graphics.Region region2 = new android.graphics.Region(region.getBounds());
        region2.op(region, Region.Op.DIFFERENCE);
        return region2;
    }

    public static final android.graphics.Region or(android.graphics.Region region, Rect rect) {
        Intrinsics3.checkNotNullParameter(region, "<this>");
        Intrinsics3.checkNotNullParameter(rect, "r");
        android.graphics.Region region2 = new android.graphics.Region(region);
        region2.union(rect);
        return region2;
    }

    public static final android.graphics.Region plus(android.graphics.Region region, Rect rect) {
        Intrinsics3.checkNotNullParameter(region, "<this>");
        Intrinsics3.checkNotNullParameter(rect, "r");
        android.graphics.Region region2 = new android.graphics.Region(region);
        region2.union(rect);
        return region2;
    }

    public static final android.graphics.Region unaryMinus(android.graphics.Region region) {
        Intrinsics3.checkNotNullParameter(region, "<this>");
        android.graphics.Region region2 = new android.graphics.Region(region.getBounds());
        region2.op(region, Region.Op.DIFFERENCE);
        return region2;
    }

    public static final android.graphics.Region xor(android.graphics.Region region, Rect rect) {
        Intrinsics3.checkNotNullParameter(region, "<this>");
        Intrinsics3.checkNotNullParameter(rect, "r");
        android.graphics.Region region2 = new android.graphics.Region(region);
        region2.op(rect, Region.Op.XOR);
        return region2;
    }

    public static final android.graphics.Region and(android.graphics.Region region, android.graphics.Region region2) {
        Intrinsics3.checkNotNullParameter(region, "<this>");
        Intrinsics3.checkNotNullParameter(region2, "r");
        android.graphics.Region region3 = new android.graphics.Region(region);
        region3.op(region2, Region.Op.INTERSECT);
        return region3;
    }

    public static final android.graphics.Region minus(android.graphics.Region region, android.graphics.Region region2) {
        Intrinsics3.checkNotNullParameter(region, "<this>");
        Intrinsics3.checkNotNullParameter(region2, "r");
        android.graphics.Region region3 = new android.graphics.Region(region);
        region3.op(region2, Region.Op.DIFFERENCE);
        return region3;
    }

    public static final android.graphics.Region or(android.graphics.Region region, android.graphics.Region region2) {
        Intrinsics3.checkNotNullParameter(region, "<this>");
        Intrinsics3.checkNotNullParameter(region2, "r");
        android.graphics.Region region3 = new android.graphics.Region(region);
        region3.op(region2, Region.Op.UNION);
        return region3;
    }

    public static final android.graphics.Region plus(android.graphics.Region region, android.graphics.Region region2) {
        Intrinsics3.checkNotNullParameter(region, "<this>");
        Intrinsics3.checkNotNullParameter(region2, "r");
        android.graphics.Region region3 = new android.graphics.Region(region);
        region3.op(region2, Region.Op.UNION);
        return region3;
    }

    public static final android.graphics.Region xor(android.graphics.Region region, android.graphics.Region region2) {
        Intrinsics3.checkNotNullParameter(region, "<this>");
        Intrinsics3.checkNotNullParameter(region2, "r");
        android.graphics.Region region3 = new android.graphics.Region(region);
        region3.op(region2, Region.Op.XOR);
        return region3;
    }
}
