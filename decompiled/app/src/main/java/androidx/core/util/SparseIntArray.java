package androidx.core.util;

import d0.t.Iterators4;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* compiled from: SparseIntArray.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\n¢\u0006\u0004\b\u0004\u0010\u0005\u001a$\u0010\b\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0086\n¢\u0006\u0004\b\b\u0010\t\u001a\u001c\u0010\u000b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u000b\u0010\f\u001a\u001c\u0010\r\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\b¢\u0006\u0004\b\r\u0010\u0005\u001a\u001c\u0010\u000e\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0001H\u0086\b¢\u0006\u0004\b\u000e\u0010\u0005\u001a$\u0010\u0010\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0086\b¢\u0006\u0004\b\u0010\u0010\u0011\u001a-\u0010\u0013\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u0012H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u0014\u0010\u0015\u001a\u00020\u0003*\u00020\u0000H\u0086\b¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0014\u0010\u0017\u001a\u00020\u0003*\u00020\u0000H\u0086\b¢\u0006\u0004\b\u0017\u0010\u0016\u001a!\u0010\u0018\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0019\u0010\u001a\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a1\u0010\u001e\u001a\u00020\u0007*\u00020\u00002\u0018\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u001cH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u0011\u0010!\u001a\u00020 *\u00020\u0000¢\u0006\u0004\b!\u0010\"\u001a\u0011\u0010#\u001a\u00020 *\u00020\u0000¢\u0006\u0004\b#\u0010\"\"\u0018\u0010&\u001a\u00020\u0001*\u00020\u00008Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b$\u0010%\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006'"}, d2 = {"Landroid/util/SparseIntArray;", "", "key", "", "contains", "(Landroid/util/SparseIntArray;I)Z", "value", "", "set", "(Landroid/util/SparseIntArray;II)V", "other", "plus", "(Landroid/util/SparseIntArray;Landroid/util/SparseIntArray;)Landroid/util/SparseIntArray;", "containsKey", "containsValue", "defaultValue", "getOrDefault", "(Landroid/util/SparseIntArray;II)I", "Lkotlin/Function0;", "getOrElse", "(Landroid/util/SparseIntArray;ILkotlin/jvm/functions/Function0;)I", "isEmpty", "(Landroid/util/SparseIntArray;)Z", "isNotEmpty", "remove", "(Landroid/util/SparseIntArray;II)Z", "putAll", "(Landroid/util/SparseIntArray;Landroid/util/SparseIntArray;)V", "Lkotlin/Function2;", "action", "forEach", "(Landroid/util/SparseIntArray;Lkotlin/jvm/functions/Function2;)V", "Ld0/t/c0;", "keyIterator", "(Landroid/util/SparseIntArray;)Ld0/t/c0;", "valueIterator", "getSize", "(Landroid/util/SparseIntArray;)I", "size", "core-ktx_release"}, k = 2, mv = {1, 5, 1})
/* renamed from: androidx.core.util.SparseIntArrayKt, reason: use source file name */
/* loaded from: classes.dex */
public final class SparseIntArray {

    /* compiled from: SparseIntArray.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\"\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"androidx/core/util/SparseIntArrayKt$keyIterator$1", "Ld0/t/c0;", "", "hasNext", "()Z", "", "nextInt", "()I", "index", "I", "getIndex", "setIndex", "(I)V", "core-ktx_release"}, k = 1, mv = {1, 5, 1})
    /* renamed from: androidx.core.util.SparseIntArrayKt$keyIterator$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Iterators4 {
        public final /* synthetic */ android.util.SparseIntArray $this_keyIterator;
        private int index;

        public AnonymousClass1(android.util.SparseIntArray sparseIntArray) {
            this.$this_keyIterator = sparseIntArray;
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
            android.util.SparseIntArray sparseIntArray = this.$this_keyIterator;
            int i = this.index;
            this.index = i + 1;
            return sparseIntArray.keyAt(i);
        }

        public final void setIndex(int i) {
            this.index = i;
        }
    }

    /* compiled from: SparseIntArray.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\"\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"androidx/core/util/SparseIntArrayKt$valueIterator$1", "Ld0/t/c0;", "", "hasNext", "()Z", "", "nextInt", "()I", "index", "I", "getIndex", "setIndex", "(I)V", "core-ktx_release"}, k = 1, mv = {1, 5, 1})
    /* renamed from: androidx.core.util.SparseIntArrayKt$valueIterator$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Iterators4 {
        public final /* synthetic */ android.util.SparseIntArray $this_valueIterator;
        private int index;

        public AnonymousClass1(android.util.SparseIntArray sparseIntArray) {
            this.$this_valueIterator = sparseIntArray;
        }

        public final int getIndex() {
            return this.index;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.$this_valueIterator.size();
        }

        @Override // d0.t.Iterators4
        public int nextInt() {
            android.util.SparseIntArray sparseIntArray = this.$this_valueIterator;
            int i = this.index;
            this.index = i + 1;
            return sparseIntArray.valueAt(i);
        }

        public final void setIndex(int i) {
            this.index = i;
        }
    }

    public static final boolean contains(android.util.SparseIntArray sparseIntArray, int i) {
        Intrinsics3.checkNotNullParameter(sparseIntArray, "<this>");
        return sparseIntArray.indexOfKey(i) >= 0;
    }

    public static final boolean containsKey(android.util.SparseIntArray sparseIntArray, int i) {
        Intrinsics3.checkNotNullParameter(sparseIntArray, "<this>");
        return sparseIntArray.indexOfKey(i) >= 0;
    }

    public static final boolean containsValue(android.util.SparseIntArray sparseIntArray, int i) {
        Intrinsics3.checkNotNullParameter(sparseIntArray, "<this>");
        return sparseIntArray.indexOfValue(i) >= 0;
    }

    public static final void forEach(android.util.SparseIntArray sparseIntArray, Function2<? super Integer, ? super Integer, Unit> function2) {
        Intrinsics3.checkNotNullParameter(sparseIntArray, "<this>");
        Intrinsics3.checkNotNullParameter(function2, "action");
        int size = sparseIntArray.size();
        if (size <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i + 1;
            function2.invoke(Integer.valueOf(sparseIntArray.keyAt(i)), Integer.valueOf(sparseIntArray.valueAt(i)));
            if (i2 >= size) {
                return;
            } else {
                i = i2;
            }
        }
    }

    public static final int getOrDefault(android.util.SparseIntArray sparseIntArray, int i, int i2) {
        Intrinsics3.checkNotNullParameter(sparseIntArray, "<this>");
        return sparseIntArray.get(i, i2);
    }

    public static final int getOrElse(android.util.SparseIntArray sparseIntArray, int i, Function0<Integer> function0) {
        Intrinsics3.checkNotNullParameter(sparseIntArray, "<this>");
        Intrinsics3.checkNotNullParameter(function0, "defaultValue");
        int iIndexOfKey = sparseIntArray.indexOfKey(i);
        return iIndexOfKey >= 0 ? sparseIntArray.valueAt(iIndexOfKey) : function0.invoke().intValue();
    }

    public static final int getSize(android.util.SparseIntArray sparseIntArray) {
        Intrinsics3.checkNotNullParameter(sparseIntArray, "<this>");
        return sparseIntArray.size();
    }

    public static final boolean isEmpty(android.util.SparseIntArray sparseIntArray) {
        Intrinsics3.checkNotNullParameter(sparseIntArray, "<this>");
        return sparseIntArray.size() == 0;
    }

    public static final boolean isNotEmpty(android.util.SparseIntArray sparseIntArray) {
        Intrinsics3.checkNotNullParameter(sparseIntArray, "<this>");
        return sparseIntArray.size() != 0;
    }

    public static final Iterators4 keyIterator(android.util.SparseIntArray sparseIntArray) {
        Intrinsics3.checkNotNullParameter(sparseIntArray, "<this>");
        return new AnonymousClass1(sparseIntArray);
    }

    public static final android.util.SparseIntArray plus(android.util.SparseIntArray sparseIntArray, android.util.SparseIntArray sparseIntArray2) {
        Intrinsics3.checkNotNullParameter(sparseIntArray, "<this>");
        Intrinsics3.checkNotNullParameter(sparseIntArray2, "other");
        android.util.SparseIntArray sparseIntArray3 = new android.util.SparseIntArray(sparseIntArray2.size() + sparseIntArray.size());
        putAll(sparseIntArray3, sparseIntArray);
        putAll(sparseIntArray3, sparseIntArray2);
        return sparseIntArray3;
    }

    public static final void putAll(android.util.SparseIntArray sparseIntArray, android.util.SparseIntArray sparseIntArray2) {
        Intrinsics3.checkNotNullParameter(sparseIntArray, "<this>");
        Intrinsics3.checkNotNullParameter(sparseIntArray2, "other");
        int size = sparseIntArray2.size();
        if (size <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i + 1;
            sparseIntArray.put(sparseIntArray2.keyAt(i), sparseIntArray2.valueAt(i));
            if (i2 >= size) {
                return;
            } else {
                i = i2;
            }
        }
    }

    public static final boolean remove(android.util.SparseIntArray sparseIntArray, int i, int i2) {
        Intrinsics3.checkNotNullParameter(sparseIntArray, "<this>");
        int iIndexOfKey = sparseIntArray.indexOfKey(i);
        if (iIndexOfKey < 0 || i2 != sparseIntArray.valueAt(iIndexOfKey)) {
            return false;
        }
        sparseIntArray.removeAt(iIndexOfKey);
        return true;
    }

    public static final void set(android.util.SparseIntArray sparseIntArray, int i, int i2) {
        Intrinsics3.checkNotNullParameter(sparseIntArray, "<this>");
        sparseIntArray.put(i, i2);
    }

    public static final Iterators4 valueIterator(android.util.SparseIntArray sparseIntArray) {
        Intrinsics3.checkNotNullParameter(sparseIntArray, "<this>");
        return new AnonymousClass1(sparseIntArray);
    }
}
