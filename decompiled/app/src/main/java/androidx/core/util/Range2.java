package androidx.core.util;

import android.util.Range;
import androidx.annotation.RequiresApi;
import androidx.exifinterface.media.ExifInterface;
import d0.d0.Range3;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: Range.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010\u000f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a2\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000*\u00028\u00002\u0006\u0010\u0002\u001a\u00028\u0000H\u0087\f¢\u0006\u0004\b\u0004\u0010\u0005\u001a8\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0006\u001a\u00028\u0000H\u0087\n¢\u0006\u0004\b\u0007\u0010\b\u001a>\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0087\n¢\u0006\u0004\b\u0007\u0010\n\u001a>\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0087\f¢\u0006\u0004\b\u000b\u0010\n\u001a/\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0007¢\u0006\u0004\b\r\u0010\u000e\u001a/\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000*\b\u0012\u0004\u0012\u00028\u00000\fH\u0007¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "that", "Landroid/util/Range;", "rangeTo", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Landroid/util/Range;", "value", "plus", "(Landroid/util/Range;Ljava/lang/Comparable;)Landroid/util/Range;", "other", "(Landroid/util/Range;Landroid/util/Range;)Landroid/util/Range;", "and", "Ld0/d0/a;", "toClosedRange", "(Landroid/util/Range;)Ld0/d0/a;", "toRange", "(Ld0/d0/a;)Landroid/util/Range;", "core-ktx_release"}, k = 2, mv = {1, 5, 1})
/* renamed from: androidx.core.util.RangeKt, reason: use source file name */
/* loaded from: classes.dex */
public final class Range2 {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Range.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001R\u001e\u0010\u0005\u001a\n \u0002*\u0004\u0018\u00018\u00008\u00008V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001e\u0010\u0007\u001a\n \u0002*\u0004\u0018\u00018\u00008\u00008V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004¨\u0006\b"}, d2 = {"androidx/core/util/RangeKt$toClosedRange$1", "Ld0/d0/a;", "kotlin.jvm.PlatformType", "getEndInclusive", "()Ljava/lang/Comparable;", "endInclusive", "getStart", "start", "core-ktx_release"}, k = 1, mv = {1, 5, 1})
    /* renamed from: androidx.core.util.RangeKt$toClosedRange$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Range3<T> {
        public final /* synthetic */ Range<T> $this_toClosedRange;

        public AnonymousClass1(Range<T> range) {
            this.$this_toClosedRange = range;
        }

        /* JADX WARN: Incorrect types in method signature: (TT;)Z */
        @Override // d0.d0.Range3
        public boolean contains(Comparable comparable) {
            return Range3.a.contains(this, comparable);
        }

        /* JADX WARN: Incorrect return type in method signature: ()TT; */
        @Override // d0.d0.Range3
        public Comparable getEndInclusive() {
            return this.$this_toClosedRange.getUpper();
        }

        /* JADX WARN: Incorrect return type in method signature: ()TT; */
        @Override // d0.d0.Range3
        public Comparable getStart() {
            return this.$this_toClosedRange.getLower();
        }

        public boolean isEmpty() {
            return Range3.a.isEmpty(this);
        }
    }

    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> and(Range<T> range, Range<T> range2) {
        Intrinsics3.checkNotNullParameter(range, "<this>");
        Intrinsics3.checkNotNullParameter(range2, "other");
        Range<T> rangeIntersect = range.intersect(range2);
        Intrinsics3.checkNotNullExpressionValue(rangeIntersect, "intersect(other)");
        return rangeIntersect;
    }

    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> plus(Range<T> range, T t) {
        Intrinsics3.checkNotNullParameter(range, "<this>");
        Intrinsics3.checkNotNullParameter(t, "value");
        Range<T> rangeExtend = range.extend((Range<T>) t);
        Intrinsics3.checkNotNullExpressionValue(rangeExtend, "extend(value)");
        return rangeExtend;
    }

    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> rangeTo(T t, T t2) {
        Intrinsics3.checkNotNullParameter(t, "<this>");
        Intrinsics3.checkNotNullParameter(t2, "that");
        return new Range<>(t, t2);
    }

    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range3<T> toClosedRange(Range<T> range) {
        Intrinsics3.checkNotNullParameter(range, "<this>");
        return new AnonymousClass1(range);
    }

    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> toRange(Range3<T> range3) {
        Intrinsics3.checkNotNullParameter(range3, "<this>");
        return new Range<>(range3.getStart(), range3.getEndInclusive());
    }

    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> plus(Range<T> range, Range<T> range2) {
        Intrinsics3.checkNotNullParameter(range, "<this>");
        Intrinsics3.checkNotNullParameter(range2, "other");
        Range<T> rangeExtend = range.extend(range2);
        Intrinsics3.checkNotNullExpressionValue(rangeExtend, "extend(other)");
        return rangeExtend;
    }
}
