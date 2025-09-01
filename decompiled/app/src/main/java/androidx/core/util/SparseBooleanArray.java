package androidx.core.util;

import d0.t.Iterators4;
import d0.t.Iterators6;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* compiled from: SparseBooleanArray.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\n¢\u0006\u0004\b\u0004\u0010\u0005\u001a$\u0010\b\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0003H\u0086\n¢\u0006\u0004\b\b\u0010\t\u001a\u001c\u0010\u000b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u000b\u0010\f\u001a\u001c\u0010\r\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\b¢\u0006\u0004\b\r\u0010\u0005\u001a\u001c\u0010\u000e\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0003H\u0086\b¢\u0006\u0004\b\u000e\u0010\u000f\u001a$\u0010\u0011\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0003H\u0086\b¢\u0006\u0004\b\u0011\u0010\u0012\u001a-\u0010\u0014\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0014\u0010\u0016\u001a\u00020\u0003*\u00020\u0000H\u0086\b¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0014\u0010\u0018\u001a\u00020\u0003*\u00020\u0000H\u0086\b¢\u0006\u0004\b\u0018\u0010\u0017\u001a!\u0010\u0019\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0019\u0010\u0012\u001a\u0019\u0010\u001a\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a1\u0010\u001e\u001a\u00020\u0007*\u00020\u00002\u0018\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u001cH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u0011\u0010!\u001a\u00020 *\u00020\u0000¢\u0006\u0004\b!\u0010\"\u001a\u0011\u0010$\u001a\u00020#*\u00020\u0000¢\u0006\u0004\b$\u0010%\"\u0018\u0010(\u001a\u00020\u0001*\u00020\u00008Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b&\u0010'\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006)"}, d2 = {"Landroid/util/SparseBooleanArray;", "", "key", "", "contains", "(Landroid/util/SparseBooleanArray;I)Z", "value", "", "set", "(Landroid/util/SparseBooleanArray;IZ)V", "other", "plus", "(Landroid/util/SparseBooleanArray;Landroid/util/SparseBooleanArray;)Landroid/util/SparseBooleanArray;", "containsKey", "containsValue", "(Landroid/util/SparseBooleanArray;Z)Z", "defaultValue", "getOrDefault", "(Landroid/util/SparseBooleanArray;IZ)Z", "Lkotlin/Function0;", "getOrElse", "(Landroid/util/SparseBooleanArray;ILkotlin/jvm/functions/Function0;)Z", "isEmpty", "(Landroid/util/SparseBooleanArray;)Z", "isNotEmpty", "remove", "putAll", "(Landroid/util/SparseBooleanArray;Landroid/util/SparseBooleanArray;)V", "Lkotlin/Function2;", "action", "forEach", "(Landroid/util/SparseBooleanArray;Lkotlin/jvm/functions/Function2;)V", "Ld0/t/c0;", "keyIterator", "(Landroid/util/SparseBooleanArray;)Ld0/t/c0;", "Ld0/t/l;", "valueIterator", "(Landroid/util/SparseBooleanArray;)Ld0/t/l;", "getSize", "(Landroid/util/SparseBooleanArray;)I", "size", "core-ktx_release"}, k = 2, mv = {1, 5, 1})
/* renamed from: androidx.core.util.SparseBooleanArrayKt, reason: use source file name */
/* loaded from: classes.dex */
public final class SparseBooleanArray {

    /* compiled from: SparseBooleanArray.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\"\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"androidx/core/util/SparseBooleanArrayKt$keyIterator$1", "Ld0/t/c0;", "", "hasNext", "()Z", "", "nextInt", "()I", "index", "I", "getIndex", "setIndex", "(I)V", "core-ktx_release"}, k = 1, mv = {1, 5, 1})
    /* renamed from: androidx.core.util.SparseBooleanArrayKt$keyIterator$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Iterators4 {
        public final /* synthetic */ android.util.SparseBooleanArray $this_keyIterator;
        private int index;

        public AnonymousClass1(android.util.SparseBooleanArray sparseBooleanArray) {
            this.$this_keyIterator = sparseBooleanArray;
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
            android.util.SparseBooleanArray sparseBooleanArray = this.$this_keyIterator;
            int i = this.index;
            this.index = i + 1;
            return sparseBooleanArray.keyAt(i);
        }

        public final void setIndex(int i) {
            this.index = i;
        }
    }

    /* compiled from: SparseBooleanArray.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"androidx/core/util/SparseBooleanArrayKt$valueIterator$1", "Ld0/t/l;", "", "hasNext", "()Z", "nextBoolean", "", "index", "I", "getIndex", "()I", "setIndex", "(I)V", "core-ktx_release"}, k = 1, mv = {1, 5, 1})
    /* renamed from: androidx.core.util.SparseBooleanArrayKt$valueIterator$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Iterators6 {
        public final /* synthetic */ android.util.SparseBooleanArray $this_valueIterator;
        private int index;

        public AnonymousClass1(android.util.SparseBooleanArray sparseBooleanArray) {
            this.$this_valueIterator = sparseBooleanArray;
        }

        public final int getIndex() {
            return this.index;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.$this_valueIterator.size();
        }

        @Override // d0.t.Iterators6
        public boolean nextBoolean() {
            android.util.SparseBooleanArray sparseBooleanArray = this.$this_valueIterator;
            int i = this.index;
            this.index = i + 1;
            return sparseBooleanArray.valueAt(i);
        }

        public final void setIndex(int i) {
            this.index = i;
        }
    }

    public static final boolean contains(android.util.SparseBooleanArray sparseBooleanArray, int i) {
        Intrinsics3.checkNotNullParameter(sparseBooleanArray, "<this>");
        return sparseBooleanArray.indexOfKey(i) >= 0;
    }

    public static final boolean containsKey(android.util.SparseBooleanArray sparseBooleanArray, int i) {
        Intrinsics3.checkNotNullParameter(sparseBooleanArray, "<this>");
        return sparseBooleanArray.indexOfKey(i) >= 0;
    }

    public static final boolean containsValue(android.util.SparseBooleanArray sparseBooleanArray, boolean z2) {
        Intrinsics3.checkNotNullParameter(sparseBooleanArray, "<this>");
        return sparseBooleanArray.indexOfValue(z2) >= 0;
    }

    public static final void forEach(android.util.SparseBooleanArray sparseBooleanArray, Function2<? super Integer, ? super Boolean, Unit> function2) {
        Intrinsics3.checkNotNullParameter(sparseBooleanArray, "<this>");
        Intrinsics3.checkNotNullParameter(function2, "action");
        int size = sparseBooleanArray.size();
        if (size <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i + 1;
            function2.invoke(Integer.valueOf(sparseBooleanArray.keyAt(i)), Boolean.valueOf(sparseBooleanArray.valueAt(i)));
            if (i2 >= size) {
                return;
            } else {
                i = i2;
            }
        }
    }

    public static final boolean getOrDefault(android.util.SparseBooleanArray sparseBooleanArray, int i, boolean z2) {
        Intrinsics3.checkNotNullParameter(sparseBooleanArray, "<this>");
        return sparseBooleanArray.get(i, z2);
    }

    public static final boolean getOrElse(android.util.SparseBooleanArray sparseBooleanArray, int i, Function0<Boolean> function0) {
        Intrinsics3.checkNotNullParameter(sparseBooleanArray, "<this>");
        Intrinsics3.checkNotNullParameter(function0, "defaultValue");
        int iIndexOfKey = sparseBooleanArray.indexOfKey(i);
        return iIndexOfKey >= 0 ? sparseBooleanArray.valueAt(iIndexOfKey) : function0.invoke().booleanValue();
    }

    public static final int getSize(android.util.SparseBooleanArray sparseBooleanArray) {
        Intrinsics3.checkNotNullParameter(sparseBooleanArray, "<this>");
        return sparseBooleanArray.size();
    }

    public static final boolean isEmpty(android.util.SparseBooleanArray sparseBooleanArray) {
        Intrinsics3.checkNotNullParameter(sparseBooleanArray, "<this>");
        return sparseBooleanArray.size() == 0;
    }

    public static final boolean isNotEmpty(android.util.SparseBooleanArray sparseBooleanArray) {
        Intrinsics3.checkNotNullParameter(sparseBooleanArray, "<this>");
        return sparseBooleanArray.size() != 0;
    }

    public static final Iterators4 keyIterator(android.util.SparseBooleanArray sparseBooleanArray) {
        Intrinsics3.checkNotNullParameter(sparseBooleanArray, "<this>");
        return new AnonymousClass1(sparseBooleanArray);
    }

    public static final android.util.SparseBooleanArray plus(android.util.SparseBooleanArray sparseBooleanArray, android.util.SparseBooleanArray sparseBooleanArray2) {
        Intrinsics3.checkNotNullParameter(sparseBooleanArray, "<this>");
        Intrinsics3.checkNotNullParameter(sparseBooleanArray2, "other");
        android.util.SparseBooleanArray sparseBooleanArray3 = new android.util.SparseBooleanArray(sparseBooleanArray2.size() + sparseBooleanArray.size());
        putAll(sparseBooleanArray3, sparseBooleanArray);
        putAll(sparseBooleanArray3, sparseBooleanArray2);
        return sparseBooleanArray3;
    }

    public static final void putAll(android.util.SparseBooleanArray sparseBooleanArray, android.util.SparseBooleanArray sparseBooleanArray2) {
        Intrinsics3.checkNotNullParameter(sparseBooleanArray, "<this>");
        Intrinsics3.checkNotNullParameter(sparseBooleanArray2, "other");
        int size = sparseBooleanArray2.size();
        if (size <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i + 1;
            sparseBooleanArray.put(sparseBooleanArray2.keyAt(i), sparseBooleanArray2.valueAt(i));
            if (i2 >= size) {
                return;
            } else {
                i = i2;
            }
        }
    }

    public static final boolean remove(android.util.SparseBooleanArray sparseBooleanArray, int i, boolean z2) {
        Intrinsics3.checkNotNullParameter(sparseBooleanArray, "<this>");
        int iIndexOfKey = sparseBooleanArray.indexOfKey(i);
        if (iIndexOfKey < 0 || z2 != sparseBooleanArray.valueAt(iIndexOfKey)) {
            return false;
        }
        sparseBooleanArray.delete(i);
        return true;
    }

    public static final void set(android.util.SparseBooleanArray sparseBooleanArray, int i, boolean z2) {
        Intrinsics3.checkNotNullParameter(sparseBooleanArray, "<this>");
        sparseBooleanArray.put(i, z2);
    }

    public static final Iterators6 valueIterator(android.util.SparseBooleanArray sparseBooleanArray) {
        Intrinsics3.checkNotNullParameter(sparseBooleanArray, "<this>");
        return new AnonymousClass1(sparseBooleanArray);
    }
}
