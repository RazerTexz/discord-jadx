package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import com.esotericsoftware.kryo.io.Util;
import d0.d0._Ranges;
import d0.t.AbstractList;
import d0.t.AbstractMutableList;
import d0.t.ArraysJVM;
import d0.t.Collections2;
import d0.t._Arrays;
import d0.t._ArraysJvm;
import d0.z.d.Intrinsics3;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ArrayDeque.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0011\b\u0007\u0018\u0000 D*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0001EB\t\b\u0016¢\u0006\u0004\bB\u0010/B\u0017\b\u0016\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r¢\u0006\u0004\bB\u0010CJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000b\u0010\nJ%\u0010\u000f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00028\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00028\u0000¢\u0006\u0004\b\u0017\u0010\u0016J\r\u0010\u0018\u001a\u00028\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u001a\u0010\u0019J\r\u0010\u001b\u001a\u00028\u0000¢\u0006\u0004\b\u001b\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u001c\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u001c\u0010\u001eJ\u001d\u0010\u001f\u001a\u00020\u00112\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0016¢\u0006\u0004\b\u001f\u0010 J%\u0010\u001f\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0016¢\u0006\u0004\b\u001f\u0010!J\u0018\u0010\"\u001a\u00028\u00002\u0006\u0010\b\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\"\u0010#J \u0010$\u001a\u00028\u00002\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b$\u0010%J\u0018\u0010&\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b&\u0010\u001dJ\u0017\u0010'\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00028\u0000H\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010)\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00028\u0000H\u0016¢\u0006\u0004\b)\u0010(J\u0017\u0010*\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00028\u0000H\u0016¢\u0006\u0004\b*\u0010\u001dJ\u0017\u0010+\u001a\u00028\u00002\u0006\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b+\u0010#J\u001d\u0010,\u001a\u00020\u00112\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0016¢\u0006\u0004\b,\u0010 J\u001d\u0010-\u001a\u00020\u00112\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0016¢\u0006\u0004\b-\u0010 J\u000f\u0010.\u001a\u00020\u0005H\u0016¢\u0006\u0004\b.\u0010/J)\u00103\u001a\b\u0012\u0004\u0012\u00028\u000101\"\u0004\b\u0001\u001002\f\u00102\u001a\b\u0012\u0004\u0012\u00028\u000101H\u0016¢\u0006\u0004\b3\u00104J\u0017\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010501H\u0016¢\u0006\u0004\b3\u00106R\u001e\u00109\u001a\n\u0012\u0006\u0012\u0004\u0018\u000105018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R$\u0010?\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\u00038\u0016@RX\u0096\u000e¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R\u0016\u0010A\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010<¨\u0006F"}, d2 = {"Lkotlin/collections/ArrayDeque;", ExifInterface.LONGITUDE_EAST, "Ld0/t/e;", "", "minCapacity", "", "e", "(I)V", "index", "g", "(I)I", "d", "internalIndex", "", "elements", "c", "(ILjava/util/Collection;)V", "", "isEmpty", "()Z", "element", "addFirst", "(Ljava/lang/Object;)V", "addLast", "removeFirst", "()Ljava/lang/Object;", "removeFirstOrNull", "removeLast", "add", "(Ljava/lang/Object;)Z", "(ILjava/lang/Object;)V", "addAll", "(Ljava/util/Collection;)Z", "(ILjava/util/Collection;)Z", "get", "(I)Ljava/lang/Object;", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "contains", "indexOf", "(Ljava/lang/Object;)I", "lastIndexOf", "remove", "removeAt", "removeAll", "retainAll", "clear", "()V", ExifInterface.GPS_DIRECTION_TRUE, "", "array", "toArray", "([Ljava/lang/Object;)[Ljava/lang/Object;", "", "()[Ljava/lang/Object;", "m", "[Ljava/lang/Object;", "elementData", "<set-?>", "n", "I", "getSize", "()I", "size", "l", "head", "<init>", "(Ljava/util/Collection;)V", "k", "a", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class ArrayDeque<E> extends AbstractMutableList<E> {

    /* renamed from: l, reason: from kotlin metadata */
    public int head;

    /* renamed from: m, reason: from kotlin metadata */
    public Object[] elementData;

    /* renamed from: n, reason: from kotlin metadata */
    public int size;

    /* renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Object[] j = new Object[0];

    /* compiled from: ArrayDeque.kt */
    /* renamed from: kotlin.collections.ArrayDeque$a, reason: from kotlin metadata */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final int newCapacity$kotlin_stdlib(int i, int i2) {
            int i3 = i + (i >> 1);
            if (i3 - i2 < 0) {
                i3 = i2;
            }
            if (i3 - Util.MAX_SAFE_ARRAY_SIZE <= 0) {
                return i3;
            }
            if (i2 > 2147483639) {
                return Integer.MAX_VALUE;
            }
            return Util.MAX_SAFE_ARRAY_SIZE;
        }
    }

    public ArrayDeque() {
        this.elementData = j;
    }

    public static final /* synthetic */ Object[] access$getElementData$p(ArrayDeque arrayDeque) {
        return arrayDeque.elementData;
    }

    public static final /* synthetic */ int access$getHead$p(ArrayDeque arrayDeque) {
        return arrayDeque.head;
    }

    public static final /* synthetic */ int access$incremented(ArrayDeque arrayDeque, int i) {
        return arrayDeque.g(i);
    }

    public static final int access$negativeMod(ArrayDeque arrayDeque, int i) {
        Objects.requireNonNull(arrayDeque);
        return i < 0 ? i + arrayDeque.elementData.length : i;
    }

    public static final int access$positiveMod(ArrayDeque arrayDeque, int i) {
        Object[] objArr = arrayDeque.elementData;
        return i >= objArr.length ? i - objArr.length : i;
    }

    public static final /* synthetic */ void access$setSize$p(ArrayDeque arrayDeque, int i) {
        arrayDeque.size = i;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E element) {
        addLast(element);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> elements) {
        Intrinsics3.checkNotNullParameter(elements, "elements");
        if (elements.isEmpty()) {
            return false;
        }
        e(elements.size() + size());
        c(access$positiveMod(this, access$getHead$p(this) + size()), elements);
        return true;
    }

    public final void addFirst(E element) {
        e(size() + 1);
        int iD = d(this.head);
        this.head = iD;
        this.elementData[iD] = element;
        this.size = size() + 1;
    }

    public final void addLast(E element) {
        e(size() + 1);
        this.elementData[access$positiveMod(this, access$getHead$p(this) + size())] = element;
        this.size = size() + 1;
    }

    public final void c(int internalIndex, Collection<? extends E> elements) {
        Iterator<? extends E> it = elements.iterator();
        int length = this.elementData.length;
        while (internalIndex < length && it.hasNext()) {
            this.elementData[internalIndex] = it.next();
            internalIndex++;
        }
        int i = this.head;
        for (int i2 = 0; i2 < i && it.hasNext(); i2++) {
            this.elementData[i2] = it.next();
        }
        this.size = elements.size() + size();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        int iAccess$positiveMod = access$positiveMod(this, access$getHead$p(this) + size());
        int i = this.head;
        if (i < iAccess$positiveMod) {
            _ArraysJvm.fill(this.elementData, (Object) null, i, iAccess$positiveMod);
        } else if (!isEmpty()) {
            Object[] objArr = this.elementData;
            _ArraysJvm.fill(objArr, (Object) null, this.head, objArr.length);
            _ArraysJvm.fill(this.elementData, (Object) null, 0, iAccess$positiveMod);
        }
        this.head = 0;
        this.size = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object element) {
        return indexOf(element) != -1;
    }

    public final int d(int index) {
        return index == 0 ? _Arrays.getLastIndex(this.elementData) : index - 1;
    }

    public final void e(int minCapacity) {
        if (minCapacity < 0) {
            throw new IllegalStateException("Deque is too big.");
        }
        Object[] objArr = this.elementData;
        if (minCapacity <= objArr.length) {
            return;
        }
        if (objArr == j) {
            this.elementData = new Object[_Ranges.coerceAtLeast(minCapacity, 10)];
            return;
        }
        Object[] objArr2 = new Object[INSTANCE.newCapacity$kotlin_stdlib(objArr.length, minCapacity)];
        Object[] objArr3 = this.elementData;
        _ArraysJvm.copyInto(objArr3, objArr2, 0, this.head, objArr3.length);
        Object[] objArr4 = this.elementData;
        int length = objArr4.length;
        int i = this.head;
        _ArraysJvm.copyInto(objArr4, objArr2, length - i, 0, i);
        this.head = 0;
        this.elementData = objArr2;
    }

    public final int g(int index) {
        if (index == _Arrays.getLastIndex(this.elementData)) {
            return 0;
        }
        return index + 1;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int index) {
        AbstractList.j.checkElementIndex$kotlin_stdlib(index, size());
        return (E) access$getElementData$p(this)[access$positiveMod(this, access$getHead$p(this) + index)];
    }

    @Override // d0.t.AbstractMutableList
    public int getSize() {
        return this.size;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object element) {
        int i;
        int iAccess$positiveMod = access$positiveMod(this, access$getHead$p(this) + size());
        int length = this.head;
        if (length < iAccess$positiveMod) {
            while (length < iAccess$positiveMod) {
                if (Intrinsics3.areEqual(element, this.elementData[length])) {
                    i = this.head;
                } else {
                    length++;
                }
            }
            return -1;
        }
        if (length < iAccess$positiveMod) {
            return -1;
        }
        int length2 = this.elementData.length;
        while (true) {
            if (length >= length2) {
                for (int i2 = 0; i2 < iAccess$positiveMod; i2++) {
                    if (Intrinsics3.areEqual(element, this.elementData[i2])) {
                        length = i2 + this.elementData.length;
                        i = this.head;
                    }
                }
                return -1;
            }
            if (Intrinsics3.areEqual(element, this.elementData[length])) {
                i = this.head;
                break;
            }
            length++;
        }
        return length - i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object element) {
        int lastIndex;
        int i;
        int iAccess$positiveMod = access$positiveMod(this, access$getHead$p(this) + size());
        int i2 = this.head;
        if (i2 < iAccess$positiveMod) {
            lastIndex = iAccess$positiveMod - 1;
            if (lastIndex < i2) {
                return -1;
            }
            while (!Intrinsics3.areEqual(element, this.elementData[lastIndex])) {
                if (lastIndex == i2) {
                    return -1;
                }
                lastIndex--;
            }
            i = this.head;
        } else {
            if (i2 <= iAccess$positiveMod) {
                return -1;
            }
            int i3 = iAccess$positiveMod - 1;
            while (true) {
                if (i3 < 0) {
                    lastIndex = _Arrays.getLastIndex(this.elementData);
                    int i4 = this.head;
                    if (lastIndex < i4) {
                        return -1;
                    }
                    while (!Intrinsics3.areEqual(element, this.elementData[lastIndex])) {
                        if (lastIndex == i4) {
                            return -1;
                        }
                        lastIndex--;
                    }
                    i = this.head;
                } else {
                    if (Intrinsics3.areEqual(element, this.elementData[i3])) {
                        lastIndex = i3 + this.elementData.length;
                        i = this.head;
                        break;
                    }
                    i3--;
                }
            }
        }
        return lastIndex - i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object element) {
        int iIndexOf = indexOf(element);
        if (iIndexOf == -1) {
            return false;
        }
        remove(iIndexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<? extends Object> elements) {
        Intrinsics3.checkNotNullParameter(elements, "elements");
        boolean z2 = false;
        z2 = false;
        z2 = false;
        if (!isEmpty()) {
            if (!(access$getElementData$p(this).length == 0)) {
                int iAccess$positiveMod = access$positiveMod(this, access$getHead$p(this) + size());
                int iAccess$getHead$p = access$getHead$p(this);
                if (access$getHead$p(this) < iAccess$positiveMod) {
                    for (int iAccess$getHead$p2 = access$getHead$p(this); iAccess$getHead$p2 < iAccess$positiveMod; iAccess$getHead$p2++) {
                        Object obj = access$getElementData$p(this)[iAccess$getHead$p2];
                        if (!elements.contains(obj)) {
                            access$getElementData$p(this)[iAccess$getHead$p] = obj;
                            iAccess$getHead$p++;
                        } else {
                            z2 = true;
                        }
                    }
                    _ArraysJvm.fill(access$getElementData$p(this), (Object) null, iAccess$getHead$p, iAccess$positiveMod);
                } else {
                    int length = access$getElementData$p(this).length;
                    boolean z3 = false;
                    for (int iAccess$getHead$p3 = access$getHead$p(this); iAccess$getHead$p3 < length; iAccess$getHead$p3++) {
                        Object obj2 = access$getElementData$p(this)[iAccess$getHead$p3];
                        access$getElementData$p(this)[iAccess$getHead$p3] = null;
                        if (!elements.contains(obj2)) {
                            access$getElementData$p(this)[iAccess$getHead$p] = obj2;
                            iAccess$getHead$p++;
                        } else {
                            z3 = true;
                        }
                    }
                    iAccess$getHead$p = access$positiveMod(this, iAccess$getHead$p);
                    for (int i = 0; i < iAccess$positiveMod; i++) {
                        Object obj3 = access$getElementData$p(this)[i];
                        access$getElementData$p(this)[i] = null;
                        if (!elements.contains(obj3)) {
                            access$getElementData$p(this)[iAccess$getHead$p] = obj3;
                            iAccess$getHead$p = access$incremented(this, iAccess$getHead$p);
                        } else {
                            z3 = true;
                        }
                    }
                    z2 = z3;
                }
                if (z2) {
                    access$setSize$p(this, access$negativeMod(this, iAccess$getHead$p - access$getHead$p(this)));
                }
            }
        }
        return z2;
    }

    @Override // d0.t.AbstractMutableList
    public E removeAt(int index) {
        AbstractList.j.checkElementIndex$kotlin_stdlib(index, size());
        if (index == Collections2.getLastIndex(this)) {
            return removeLast();
        }
        if (index == 0) {
            return removeFirst();
        }
        int iAccess$positiveMod = access$positiveMod(this, access$getHead$p(this) + index);
        E e = (E) access$getElementData$p(this)[iAccess$positiveMod];
        if (index < (size() >> 1)) {
            int i = this.head;
            if (iAccess$positiveMod >= i) {
                Object[] objArr = this.elementData;
                _ArraysJvm.copyInto(objArr, objArr, i + 1, i, iAccess$positiveMod);
            } else {
                Object[] objArr2 = this.elementData;
                _ArraysJvm.copyInto(objArr2, objArr2, 1, 0, iAccess$positiveMod);
                Object[] objArr3 = this.elementData;
                objArr3[0] = objArr3[objArr3.length - 1];
                int i2 = this.head;
                _ArraysJvm.copyInto(objArr3, objArr3, i2 + 1, i2, objArr3.length - 1);
            }
            Object[] objArr4 = this.elementData;
            int i3 = this.head;
            objArr4[i3] = null;
            this.head = g(i3);
        } else {
            int iAccess$positiveMod2 = access$positiveMod(this, access$getHead$p(this) + Collections2.getLastIndex(this));
            if (iAccess$positiveMod <= iAccess$positiveMod2) {
                Object[] objArr5 = this.elementData;
                _ArraysJvm.copyInto(objArr5, objArr5, iAccess$positiveMod, iAccess$positiveMod + 1, iAccess$positiveMod2 + 1);
            } else {
                Object[] objArr6 = this.elementData;
                _ArraysJvm.copyInto(objArr6, objArr6, iAccess$positiveMod, iAccess$positiveMod + 1, objArr6.length);
                Object[] objArr7 = this.elementData;
                objArr7[objArr7.length - 1] = objArr7[0];
                _ArraysJvm.copyInto(objArr7, objArr7, 0, 1, iAccess$positiveMod2 + 1);
            }
            this.elementData[iAccess$positiveMod2] = null;
        }
        this.size = size() - 1;
        return e;
    }

    public final E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        E e = (E) access$getElementData$p(this)[this.head];
        Object[] objArr = this.elementData;
        int i = this.head;
        objArr[i] = null;
        this.head = g(i);
        this.size = size() - 1;
        return e;
    }

    public final E removeFirstOrNull() {
        if (isEmpty()) {
            return null;
        }
        return removeFirst();
    }

    public final E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        int iAccess$positiveMod = access$positiveMod(this, access$getHead$p(this) + Collections2.getLastIndex(this));
        E e = (E) access$getElementData$p(this)[iAccess$positiveMod];
        this.elementData[iAccess$positiveMod] = null;
        this.size = size() - 1;
        return e;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<? extends Object> elements) {
        Intrinsics3.checkNotNullParameter(elements, "elements");
        boolean z2 = false;
        z2 = false;
        z2 = false;
        if (!isEmpty()) {
            if (!(access$getElementData$p(this).length == 0)) {
                int iAccess$positiveMod = access$positiveMod(this, access$getHead$p(this) + size());
                int iAccess$getHead$p = access$getHead$p(this);
                if (access$getHead$p(this) < iAccess$positiveMod) {
                    for (int iAccess$getHead$p2 = access$getHead$p(this); iAccess$getHead$p2 < iAccess$positiveMod; iAccess$getHead$p2++) {
                        Object obj = access$getElementData$p(this)[iAccess$getHead$p2];
                        if (elements.contains(obj)) {
                            access$getElementData$p(this)[iAccess$getHead$p] = obj;
                            iAccess$getHead$p++;
                        } else {
                            z2 = true;
                        }
                    }
                    _ArraysJvm.fill(access$getElementData$p(this), (Object) null, iAccess$getHead$p, iAccess$positiveMod);
                } else {
                    int length = access$getElementData$p(this).length;
                    boolean z3 = false;
                    for (int iAccess$getHead$p3 = access$getHead$p(this); iAccess$getHead$p3 < length; iAccess$getHead$p3++) {
                        Object obj2 = access$getElementData$p(this)[iAccess$getHead$p3];
                        access$getElementData$p(this)[iAccess$getHead$p3] = null;
                        if (elements.contains(obj2)) {
                            access$getElementData$p(this)[iAccess$getHead$p] = obj2;
                            iAccess$getHead$p++;
                        } else {
                            z3 = true;
                        }
                    }
                    iAccess$getHead$p = access$positiveMod(this, iAccess$getHead$p);
                    for (int i = 0; i < iAccess$positiveMod; i++) {
                        Object obj3 = access$getElementData$p(this)[i];
                        access$getElementData$p(this)[i] = null;
                        if (elements.contains(obj3)) {
                            access$getElementData$p(this)[iAccess$getHead$p] = obj3;
                            iAccess$getHead$p = access$incremented(this, iAccess$getHead$p);
                        } else {
                            z3 = true;
                        }
                    }
                    z2 = z3;
                }
                if (z2) {
                    access$setSize$p(this, access$negativeMod(this, iAccess$getHead$p - access$getHead$p(this)));
                }
            }
        }
        return z2;
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int index, E element) {
        AbstractList.j.checkElementIndex$kotlin_stdlib(index, size());
        int iAccess$positiveMod = access$positiveMod(this, access$getHead$p(this) + index);
        E e = (E) access$getElementData$p(this)[iAccess$positiveMod];
        this.elementData[iAccess$positiveMod] = element;
        return e;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] array) {
        Intrinsics3.checkNotNullParameter(array, "array");
        if (array.length < size()) {
            array = (T[]) ArraysJVM.arrayOfNulls(array, size());
        }
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        int iAccess$positiveMod = access$positiveMod(this, access$getHead$p(this) + size());
        int i = this.head;
        if (i < iAccess$positiveMod) {
            _ArraysJvm.copyInto$default(this.elementData, array, 0, i, iAccess$positiveMod, 2, (Object) null);
        } else if (!isEmpty()) {
            Object[] objArr = this.elementData;
            _ArraysJvm.copyInto(objArr, array, 0, this.head, objArr.length);
            Object[] objArr2 = this.elementData;
            _ArraysJvm.copyInto(objArr2, array, objArr2.length - this.head, 0, iAccess$positiveMod);
        }
        if (array.length > size()) {
            array[size()] = null;
        }
        return array;
    }

    public ArrayDeque(Collection<? extends E> collection) {
        Intrinsics3.checkNotNullParameter(collection, "elements");
        Object[] array = collection.toArray(new Object[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        this.elementData = array;
        this.size = array.length;
        if (array.length == 0) {
            this.elementData = j;
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int index, E element) {
        AbstractList.j.checkPositionIndex$kotlin_stdlib(index, size());
        if (index == size()) {
            addLast(element);
            return;
        }
        if (index == 0) {
            addFirst(element);
            return;
        }
        e(size() + 1);
        int iAccess$positiveMod = access$positiveMod(this, access$getHead$p(this) + index);
        if (index < ((size() + 1) >> 1)) {
            int iD = d(iAccess$positiveMod);
            int iD2 = d(this.head);
            int i = this.head;
            if (iD >= i) {
                Object[] objArr = this.elementData;
                objArr[iD2] = objArr[i];
                _ArraysJvm.copyInto(objArr, objArr, i, i + 1, iD + 1);
            } else {
                Object[] objArr2 = this.elementData;
                _ArraysJvm.copyInto(objArr2, objArr2, i - 1, i, objArr2.length);
                Object[] objArr3 = this.elementData;
                objArr3[objArr3.length - 1] = objArr3[0];
                _ArraysJvm.copyInto(objArr3, objArr3, 0, 1, iD + 1);
            }
            this.elementData[iD] = element;
            this.head = iD2;
        } else {
            int iAccess$positiveMod2 = access$positiveMod(this, access$getHead$p(this) + size());
            if (iAccess$positiveMod < iAccess$positiveMod2) {
                Object[] objArr4 = this.elementData;
                _ArraysJvm.copyInto(objArr4, objArr4, iAccess$positiveMod + 1, iAccess$positiveMod, iAccess$positiveMod2);
            } else {
                Object[] objArr5 = this.elementData;
                _ArraysJvm.copyInto(objArr5, objArr5, 1, 0, iAccess$positiveMod2);
                Object[] objArr6 = this.elementData;
                objArr6[0] = objArr6[objArr6.length - 1];
                _ArraysJvm.copyInto(objArr6, objArr6, iAccess$positiveMod + 1, iAccess$positiveMod, objArr6.length - 1);
            }
            this.elementData[iAccess$positiveMod] = element;
        }
        this.size = size() + 1;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int index, Collection<? extends E> elements) {
        Intrinsics3.checkNotNullParameter(elements, "elements");
        AbstractList.j.checkPositionIndex$kotlin_stdlib(index, size());
        if (elements.isEmpty()) {
            return false;
        }
        if (index == size()) {
            return addAll(elements);
        }
        e(elements.size() + size());
        int iAccess$positiveMod = access$positiveMod(this, access$getHead$p(this) + size());
        int iAccess$positiveMod2 = access$positiveMod(this, access$getHead$p(this) + index);
        int size = elements.size();
        if (index < ((size() + 1) >> 1)) {
            int i = this.head;
            int length = i - size;
            if (iAccess$positiveMod2 < i) {
                Object[] objArr = this.elementData;
                _ArraysJvm.copyInto(objArr, objArr, length, i, objArr.length);
                if (size >= iAccess$positiveMod2) {
                    Object[] objArr2 = this.elementData;
                    _ArraysJvm.copyInto(objArr2, objArr2, objArr2.length - size, 0, iAccess$positiveMod2);
                } else {
                    Object[] objArr3 = this.elementData;
                    _ArraysJvm.copyInto(objArr3, objArr3, objArr3.length - size, 0, size);
                    Object[] objArr4 = this.elementData;
                    _ArraysJvm.copyInto(objArr4, objArr4, 0, size, iAccess$positiveMod2);
                }
            } else if (length >= 0) {
                Object[] objArr5 = this.elementData;
                _ArraysJvm.copyInto(objArr5, objArr5, length, i, iAccess$positiveMod2);
            } else {
                Object[] objArr6 = this.elementData;
                length += objArr6.length;
                int i2 = iAccess$positiveMod2 - i;
                int length2 = objArr6.length - length;
                if (length2 >= i2) {
                    _ArraysJvm.copyInto(objArr6, objArr6, length, i, iAccess$positiveMod2);
                } else {
                    _ArraysJvm.copyInto(objArr6, objArr6, length, i, i + length2);
                    Object[] objArr7 = this.elementData;
                    _ArraysJvm.copyInto(objArr7, objArr7, 0, this.head + length2, iAccess$positiveMod2);
                }
            }
            this.head = length;
            int length3 = iAccess$positiveMod2 - size;
            if (length3 < 0) {
                length3 += this.elementData.length;
            }
            c(length3, elements);
        } else {
            int i3 = iAccess$positiveMod2 + size;
            if (iAccess$positiveMod2 < iAccess$positiveMod) {
                int i4 = size + iAccess$positiveMod;
                Object[] objArr8 = this.elementData;
                if (i4 <= objArr8.length) {
                    _ArraysJvm.copyInto(objArr8, objArr8, i3, iAccess$positiveMod2, iAccess$positiveMod);
                } else if (i3 >= objArr8.length) {
                    _ArraysJvm.copyInto(objArr8, objArr8, i3 - objArr8.length, iAccess$positiveMod2, iAccess$positiveMod);
                } else {
                    int length4 = iAccess$positiveMod - (i4 - objArr8.length);
                    _ArraysJvm.copyInto(objArr8, objArr8, 0, length4, iAccess$positiveMod);
                    Object[] objArr9 = this.elementData;
                    _ArraysJvm.copyInto(objArr9, objArr9, i3, iAccess$positiveMod2, length4);
                }
            } else {
                Object[] objArr10 = this.elementData;
                _ArraysJvm.copyInto(objArr10, objArr10, size, 0, iAccess$positiveMod);
                Object[] objArr11 = this.elementData;
                if (i3 >= objArr11.length) {
                    _ArraysJvm.copyInto(objArr11, objArr11, i3 - objArr11.length, iAccess$positiveMod2, objArr11.length);
                } else {
                    _ArraysJvm.copyInto(objArr11, objArr11, 0, objArr11.length - size, objArr11.length);
                    Object[] objArr12 = this.elementData;
                    _ArraysJvm.copyInto(objArr12, objArr12, i3, iAccess$positiveMod2, objArr12.length - size);
                }
            }
            c(iAccess$positiveMod2, elements);
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
