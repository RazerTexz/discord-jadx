package androidx.core.util;

import androidx.annotation.RequiresApi;
import d0.t.Iterators4;
import d0.t.Iterators5;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* compiled from: SparseLongArray.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\n¢\u0006\u0004\b\u0004\u0010\u0005\u001a$\u0010\t\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0087\n¢\u0006\u0004\b\t\u0010\n\u001a\u001c\u0010\f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000H\u0087\u0002¢\u0006\u0004\b\f\u0010\r\u001a\u001c\u0010\u000e\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b¢\u0006\u0004\b\u000e\u0010\u0005\u001a\u001c\u0010\u000f\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\u0087\b¢\u0006\u0004\b\u000f\u0010\u0010\u001a$\u0010\u0012\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0006H\u0087\b¢\u0006\u0004\b\u0012\u0010\u0013\u001a-\u0010\u0015\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0014H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0014\u0010\u0017\u001a\u00020\u0003*\u00020\u0000H\u0087\b¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0014\u0010\u0019\u001a\u00020\u0003*\u00020\u0000H\u0087\b¢\u0006\u0004\b\u0019\u0010\u0018\u001a#\u0010\u001a\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001b\u0010\u001c\u001a\u00020\b*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u001c\u0010\u001d\u001a1\u0010 \u001a\u00020\b*\u00020\u00002\u0018\u0010\u001f\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u001eH\u0087\bø\u0001\u0000¢\u0006\u0004\b \u0010!\u001a\u0013\u0010#\u001a\u00020\"*\u00020\u0000H\u0007¢\u0006\u0004\b#\u0010$\u001a\u0013\u0010&\u001a\u00020%*\u00020\u0000H\u0007¢\u0006\u0004\b&\u0010'\"\u0018\u0010*\u001a\u00020\u0001*\u00020\u00008Ç\u0002@\u0006¢\u0006\u0006\u001a\u0004\b(\u0010)\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006+"}, d2 = {"Landroid/util/SparseLongArray;", "", "key", "", "contains", "(Landroid/util/SparseLongArray;I)Z", "", "value", "", "set", "(Landroid/util/SparseLongArray;IJ)V", "other", "plus", "(Landroid/util/SparseLongArray;Landroid/util/SparseLongArray;)Landroid/util/SparseLongArray;", "containsKey", "containsValue", "(Landroid/util/SparseLongArray;J)Z", "defaultValue", "getOrDefault", "(Landroid/util/SparseLongArray;IJ)J", "Lkotlin/Function0;", "getOrElse", "(Landroid/util/SparseLongArray;ILkotlin/jvm/functions/Function0;)J", "isEmpty", "(Landroid/util/SparseLongArray;)Z", "isNotEmpty", "remove", "(Landroid/util/SparseLongArray;IJ)Z", "putAll", "(Landroid/util/SparseLongArray;Landroid/util/SparseLongArray;)V", "Lkotlin/Function2;", "action", "forEach", "(Landroid/util/SparseLongArray;Lkotlin/jvm/functions/Function2;)V", "Ld0/t/c0;", "keyIterator", "(Landroid/util/SparseLongArray;)Ld0/t/c0;", "Ld0/t/d0;", "valueIterator", "(Landroid/util/SparseLongArray;)Ld0/t/d0;", "getSize", "(Landroid/util/SparseLongArray;)I", "size", "core-ktx_release"}, k = 2, mv = {1, 5, 1})
/* renamed from: androidx.core.util.SparseLongArrayKt, reason: use source file name */
/* loaded from: classes.dex */
public final class SparseLongArray {

    /* compiled from: SparseLongArray.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\"\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"androidx/core/util/SparseLongArrayKt$keyIterator$1", "Ld0/t/c0;", "", "hasNext", "()Z", "", "nextInt", "()I", "index", "I", "getIndex", "setIndex", "(I)V", "core-ktx_release"}, k = 1, mv = {1, 5, 1})
    /* renamed from: androidx.core.util.SparseLongArrayKt$keyIterator$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Iterators4 {
        public final /* synthetic */ android.util.SparseLongArray $this_keyIterator;
        private int index;

        public AnonymousClass1(android.util.SparseLongArray sparseLongArray) {
            this.$this_keyIterator = sparseLongArray;
        }

        public final int getIndex() {
            return this.index;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.$this_keyIterator.size();
        }

        @Override // d0.t.Iterators4
        public int nextInt() {
            android.util.SparseLongArray sparseLongArray = this.$this_keyIterator;
            int i = this.index;
            this.index = i + 1;
            return sparseLongArray.keyAt(i);
        }

        public final void setIndex(int i) {
            this.index = i;
        }
    }

    /* compiled from: SparseLongArray.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"androidx/core/util/SparseLongArrayKt$valueIterator$1", "Ld0/t/d0;", "", "hasNext", "()Z", "", "nextLong", "()J", "", "index", "I", "getIndex", "()I", "setIndex", "(I)V", "core-ktx_release"}, k = 1, mv = {1, 5, 1})
    /* renamed from: androidx.core.util.SparseLongArrayKt$valueIterator$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Iterators5 {
        public final /* synthetic */ android.util.SparseLongArray $this_valueIterator;
        private int index;

        public AnonymousClass1(android.util.SparseLongArray sparseLongArray) {
            this.$this_valueIterator = sparseLongArray;
        }

        public final int getIndex() {
            return this.index;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.$this_valueIterator.size();
        }

        @Override // d0.t.Iterators5
        public long nextLong() {
            android.util.SparseLongArray sparseLongArray = this.$this_valueIterator;
            int i = this.index;
            this.index = i + 1;
            return sparseLongArray.valueAt(i);
        }

        public final void setIndex(int i) {
            this.index = i;
        }
    }

    @RequiresApi(18)
    public static final boolean contains(android.util.SparseLongArray sparseLongArray, int i) {
        Intrinsics3.checkNotNullParameter(sparseLongArray, "<this>");
        return sparseLongArray.indexOfKey(i) >= 0;
    }

    @RequiresApi(18)
    public static final boolean containsKey(android.util.SparseLongArray sparseLongArray, int i) {
        Intrinsics3.checkNotNullParameter(sparseLongArray, "<this>");
        return sparseLongArray.indexOfKey(i) >= 0;
    }

    @RequiresApi(18)
    public static final boolean containsValue(android.util.SparseLongArray sparseLongArray, long j) {
        Intrinsics3.checkNotNullParameter(sparseLongArray, "<this>");
        return sparseLongArray.indexOfValue(j) >= 0;
    }

    @RequiresApi(18)
    public static final void forEach(android.util.SparseLongArray sparseLongArray, Function2<? super Integer, ? super Long, Unit> function2) {
        Intrinsics3.checkNotNullParameter(sparseLongArray, "<this>");
        Intrinsics3.checkNotNullParameter(function2, "action");
        int size = sparseLongArray.size();
        if (size <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i + 1;
            function2.invoke(Integer.valueOf(sparseLongArray.keyAt(i)), Long.valueOf(sparseLongArray.valueAt(i)));
            if (i2 >= size) {
                return;
            } else {
                i = i2;
            }
        }
    }

    @RequiresApi(18)
    public static final long getOrDefault(android.util.SparseLongArray sparseLongArray, int i, long j) {
        Intrinsics3.checkNotNullParameter(sparseLongArray, "<this>");
        return sparseLongArray.get(i, j);
    }

    @RequiresApi(18)
    public static final long getOrElse(android.util.SparseLongArray sparseLongArray, int i, Function0<Long> function0) {
        Intrinsics3.checkNotNullParameter(sparseLongArray, "<this>");
        Intrinsics3.checkNotNullParameter(function0, "defaultValue");
        int iIndexOfKey = sparseLongArray.indexOfKey(i);
        return iIndexOfKey >= 0 ? sparseLongArray.valueAt(iIndexOfKey) : function0.invoke().longValue();
    }

    @RequiresApi(18)
    public static final int getSize(android.util.SparseLongArray sparseLongArray) {
        Intrinsics3.checkNotNullParameter(sparseLongArray, "<this>");
        return sparseLongArray.size();
    }

    @RequiresApi(18)
    public static final boolean isEmpty(android.util.SparseLongArray sparseLongArray) {
        Intrinsics3.checkNotNullParameter(sparseLongArray, "<this>");
        return sparseLongArray.size() == 0;
    }

    @RequiresApi(18)
    public static final boolean isNotEmpty(android.util.SparseLongArray sparseLongArray) {
        Intrinsics3.checkNotNullParameter(sparseLongArray, "<this>");
        return sparseLongArray.size() != 0;
    }

    @RequiresApi(18)
    public static final Iterators4 keyIterator(android.util.SparseLongArray sparseLongArray) {
        Intrinsics3.checkNotNullParameter(sparseLongArray, "<this>");
        return new AnonymousClass1(sparseLongArray);
    }

    @RequiresApi(18)
    public static final android.util.SparseLongArray plus(android.util.SparseLongArray sparseLongArray, android.util.SparseLongArray sparseLongArray2) {
        Intrinsics3.checkNotNullParameter(sparseLongArray, "<this>");
        Intrinsics3.checkNotNullParameter(sparseLongArray2, "other");
        android.util.SparseLongArray sparseLongArray3 = new android.util.SparseLongArray(sparseLongArray2.size() + sparseLongArray.size());
        putAll(sparseLongArray3, sparseLongArray);
        putAll(sparseLongArray3, sparseLongArray2);
        return sparseLongArray3;
    }

    @RequiresApi(18)
    public static final void putAll(android.util.SparseLongArray sparseLongArray, android.util.SparseLongArray sparseLongArray2) {
        Intrinsics3.checkNotNullParameter(sparseLongArray, "<this>");
        Intrinsics3.checkNotNullParameter(sparseLongArray2, "other");
        int size = sparseLongArray2.size();
        if (size <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i + 1;
            sparseLongArray.put(sparseLongArray2.keyAt(i), sparseLongArray2.valueAt(i));
            if (i2 >= size) {
                return;
            } else {
                i = i2;
            }
        }
    }

    @RequiresApi(18)
    public static final boolean remove(android.util.SparseLongArray sparseLongArray, int i, long j) {
        Intrinsics3.checkNotNullParameter(sparseLongArray, "<this>");
        int iIndexOfKey = sparseLongArray.indexOfKey(i);
        if (iIndexOfKey < 0 || j != sparseLongArray.valueAt(iIndexOfKey)) {
            return false;
        }
        sparseLongArray.removeAt(iIndexOfKey);
        return true;
    }

    @RequiresApi(18)
    public static final void set(android.util.SparseLongArray sparseLongArray, int i, long j) {
        Intrinsics3.checkNotNullParameter(sparseLongArray, "<this>");
        sparseLongArray.put(i, j);
    }

    @RequiresApi(18)
    public static final Iterators5 valueIterator(android.util.SparseLongArray sparseLongArray) {
        Intrinsics3.checkNotNullParameter(sparseLongArray, "<this>");
        return new AnonymousClass1(sparseLongArray);
    }
}
