package androidx.core.util;

import android.annotation.SuppressLint;
import androidx.exifinterface.media.ExifInterface;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Tuples2;

/* compiled from: Pair.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a,\u0010\u0003\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0087\n¢\u0006\u0004\b\u0003\u0010\u0004\u001a,\u0010\u0005\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0087\n¢\u0006\u0004\b\u0005\u0010\u0004\u001a8\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0086\b¢\u0006\u0004\b\u0007\u0010\b\u001a8\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006H\u0086\b¢\u0006\u0004\b\t\u0010\n\u001a,\u0010\u0003\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000bH\u0087\n¢\u0006\u0004\b\u0003\u0010\f\u001a,\u0010\u0005\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000bH\u0087\n¢\u0006\u0004\b\u0005\u0010\f\u001a8\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000bH\u0086\b¢\u0006\u0004\b\u0007\u0010\r\u001a8\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006H\u0086\b¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"F", ExifInterface.LATITUDE_SOUTH, "Landroidx/core/util/Pair;", "component1", "(Landroidx/core/util/Pair;)Ljava/lang/Object;", "component2", "Lkotlin/Pair;", "toKotlinPair", "(Landroidx/core/util/Pair;)Lkotlin/Pair;", "toAndroidXPair", "(Lkotlin/Pair;)Landroidx/core/util/Pair;", "Landroid/util/Pair;", "(Landroid/util/Pair;)Ljava/lang/Object;", "(Landroid/util/Pair;)Lkotlin/Pair;", "toAndroidPair", "(Lkotlin/Pair;)Landroid/util/Pair;", "core-ktx_release"}, k = 2, mv = {1, 5, 1})
/* renamed from: androidx.core.util.PairKt, reason: use source file name */
/* loaded from: classes.dex */
public final class Pair2 {
    @SuppressLint({"UnknownNullness"})
    public static final <F, S> F component1(Pair<F, S> pair) {
        Intrinsics3.checkNotNullParameter(pair, "<this>");
        return pair.first;
    }

    @SuppressLint({"UnknownNullness"})
    public static final <F, S> S component2(Pair<F, S> pair) {
        Intrinsics3.checkNotNullParameter(pair, "<this>");
        return pair.second;
    }

    public static final <F, S> android.util.Pair<F, S> toAndroidPair(Tuples2<? extends F, ? extends S> tuples2) {
        Intrinsics3.checkNotNullParameter(tuples2, "<this>");
        return new android.util.Pair<>(tuples2.getFirst(), tuples2.getSecond());
    }

    public static final <F, S> Pair<F, S> toAndroidXPair(Tuples2<? extends F, ? extends S> tuples2) {
        Intrinsics3.checkNotNullParameter(tuples2, "<this>");
        return new Pair<>(tuples2.getFirst(), tuples2.getSecond());
    }

    public static final <F, S> Tuples2<F, S> toKotlinPair(Pair<F, S> pair) {
        Intrinsics3.checkNotNullParameter(pair, "<this>");
        return new Tuples2<>(pair.first, pair.second);
    }

    @SuppressLint({"UnknownNullness"})
    public static final <F, S> F component1(android.util.Pair<F, S> pair) {
        Intrinsics3.checkNotNullParameter(pair, "<this>");
        return (F) pair.first;
    }

    @SuppressLint({"UnknownNullness"})
    public static final <F, S> S component2(android.util.Pair<F, S> pair) {
        Intrinsics3.checkNotNullParameter(pair, "<this>");
        return (S) pair.second;
    }

    public static final <F, S> Tuples2<F, S> toKotlinPair(android.util.Pair<F, S> pair) {
        Intrinsics3.checkNotNullParameter(pair, "<this>");
        return new Tuples2<>(pair.first, pair.second);
    }
}
