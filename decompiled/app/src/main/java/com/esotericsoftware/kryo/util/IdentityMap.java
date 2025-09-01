package com.esotericsoftware.kryo.util;

import b.d.b.a.outline;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public class IdentityMap<K, V> {
    private static final int PRIME2 = -1105259343;
    private static final int PRIME3 = -1262997959;
    private static final int PRIME4 = -825114047;
    public int capacity;
    private Entries entries;
    private int hashShift;
    private boolean isBigTable;
    public K[] keyTable;
    private Keys keys;
    private float loadFactor;
    private int mask;
    private int pushIterations;
    public int size;
    private int stashCapacity;
    public int stashSize;
    private int threshold;
    public V[] valueTable;
    private Values values;

    public static class Entries<K, V> extends MapIterator<K, V> implements Iterable<Entry<K, V>>, Iterator<Entry<K, V>> {
        private Entry<K, V> entry;

        public Entries(IdentityMap<K, V> identityMap) {
            super(identityMap);
            this.entry = new Entry<>();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.hasNext;
        }

        @Override // java.lang.Iterable
        public Iterator<Entry<K, V>> iterator() {
            return this;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return next();
        }

        @Override // com.esotericsoftware.kryo.util.IdentityMap.MapIterator, java.util.Iterator
        public /* bridge */ /* synthetic */ void remove() {
            super.remove();
        }

        @Override // com.esotericsoftware.kryo.util.IdentityMap.MapIterator
        public /* bridge */ /* synthetic */ void reset() {
            super.reset();
        }

        @Override // java.util.Iterator
        public Entry<K, V> next() {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            IdentityMap<K, V> identityMap = this.map;
            K[] kArr = identityMap.keyTable;
            Entry<K, V> entry = this.entry;
            int i = this.nextIndex;
            entry.key = kArr[i];
            entry.value = identityMap.valueTable[i];
            this.currentIndex = i;
            findNextIndex();
            return this.entry;
        }
    }

    public static class Entry<K, V> {
        public K key;
        public V value;

        public String toString() {
            return this.key + "=" + this.value;
        }
    }

    public static class Keys<K> extends MapIterator<K, Object> implements Iterable<K>, Iterator<K> {
        public Keys(IdentityMap<K, ?> identityMap) {
            super(identityMap);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.hasNext;
        }

        @Override // java.lang.Iterable
        public Iterator<K> iterator() {
            return this;
        }

        @Override // java.util.Iterator
        public K next() {
            K[] kArr = this.map.keyTable;
            int i = this.nextIndex;
            K k = kArr[i];
            this.currentIndex = i;
            findNextIndex();
            return k;
        }

        @Override // com.esotericsoftware.kryo.util.IdentityMap.MapIterator, java.util.Iterator
        public /* bridge */ /* synthetic */ void remove() {
            super.remove();
        }

        @Override // com.esotericsoftware.kryo.util.IdentityMap.MapIterator
        public /* bridge */ /* synthetic */ void reset() {
            super.reset();
        }

        public ArrayList<K> toArray() {
            ArrayList<K> arrayList = new ArrayList<>(this.map.size);
            while (this.hasNext) {
                arrayList.add(next());
            }
            return arrayList;
        }
    }

    public static class MapIterator<K, V> {
        public int currentIndex;
        public boolean hasNext;
        public final IdentityMap<K, V> map;
        public int nextIndex;

        public MapIterator(IdentityMap<K, V> identityMap) {
            this.map = identityMap;
            reset();
        }

        public void findNextIndex() {
            int i;
            this.hasNext = false;
            IdentityMap<K, V> identityMap = this.map;
            K[] kArr = identityMap.keyTable;
            int i2 = identityMap.capacity + identityMap.stashSize;
            do {
                i = this.nextIndex + 1;
                this.nextIndex = i;
                if (i >= i2) {
                    return;
                }
            } while (kArr[i] == null);
            this.hasNext = true;
        }

        public void remove() {
            int i = this.currentIndex;
            if (i < 0) {
                throw new IllegalStateException("next must be called before remove.");
            }
            IdentityMap<K, V> identityMap = this.map;
            if (i >= identityMap.capacity) {
                identityMap.removeStashIndex(i);
                this.nextIndex = this.currentIndex - 1;
                findNextIndex();
            } else {
                identityMap.keyTable[i] = null;
                identityMap.valueTable[i] = null;
            }
            this.currentIndex = -1;
            IdentityMap<K, V> identityMap2 = this.map;
            identityMap2.size--;
        }

        public void reset() {
            this.currentIndex = -1;
            this.nextIndex = -1;
            findNextIndex();
        }
    }

    public IdentityMap() {
        this(32, 0.8f);
    }

    private boolean containsKeyStash(K k) {
        K[] kArr = this.keyTable;
        int i = this.capacity;
        int i2 = this.stashSize + i;
        while (i < i2) {
            if (kArr[i] == k) {
                return true;
            }
            i++;
        }
        return false;
    }

    private V getStash(K k, V v) {
        K[] kArr = this.keyTable;
        int i = this.capacity;
        int i2 = this.stashSize + i;
        while (i < i2) {
            if (kArr[i] == k) {
                return this.valueTable[i];
            }
            i++;
        }
        return v;
    }

    private int hash2(int i) {
        int i2 = i * PRIME2;
        return (i2 ^ (i2 >>> this.hashShift)) & this.mask;
    }

    private int hash3(int i) {
        int i2 = i * PRIME3;
        return (i2 ^ (i2 >>> this.hashShift)) & this.mask;
    }

    private int hash4(int i) {
        int i2 = i * PRIME4;
        return (i2 ^ (i2 >>> this.hashShift)) & this.mask;
    }

    private void push(K k, V v, int i, K k2, int i2, K k3, int i3, K k4, int i4, K k5) {
        K[] kArr = this.keyTable;
        V[] vArr = this.valueTable;
        int i5 = this.mask;
        boolean z2 = this.isBigTable;
        int i6 = this.pushIterations;
        int i7 = z2 ? 4 : 3;
        K k6 = k;
        V v2 = v;
        int i8 = i;
        K k7 = k2;
        int i9 = i2;
        K k8 = k3;
        int i10 = i3;
        K k9 = k4;
        int i11 = i4;
        K k10 = k5;
        int i12 = 0;
        while (true) {
            int iNextInt = ObjectMap.random.nextInt(i7);
            int i13 = i7;
            if (iNextInt == 0) {
                V v3 = vArr[i8];
                kArr[i8] = k6;
                vArr[i8] = v2;
                k6 = k7;
                v2 = v3;
            } else if (iNextInt == 1) {
                V v4 = vArr[i9];
                kArr[i9] = k6;
                vArr[i9] = v2;
                v2 = v4;
                k6 = k8;
            } else if (iNextInt != 2) {
                V v5 = vArr[i11];
                kArr[i11] = k6;
                vArr[i11] = v2;
                v2 = v5;
                k6 = k10;
            } else {
                V v6 = vArr[i10];
                kArr[i10] = k6;
                vArr[i10] = v2;
                v2 = v6;
                k6 = k9;
            }
            int iIdentityHashCode = System.identityHashCode(k6);
            int i14 = iIdentityHashCode & i5;
            K k11 = kArr[i14];
            if (k11 == null) {
                kArr[i14] = k6;
                vArr[i14] = v2;
                int i15 = this.size;
                this.size = i15 + 1;
                if (i15 >= this.threshold) {
                    resize(this.capacity << 1);
                    return;
                }
                return;
            }
            int iHash2 = hash2(iIdentityHashCode);
            K k12 = kArr[iHash2];
            if (k12 == null) {
                kArr[iHash2] = k6;
                vArr[iHash2] = v2;
                int i16 = this.size;
                this.size = i16 + 1;
                if (i16 >= this.threshold) {
                    resize(this.capacity << 1);
                    return;
                }
                return;
            }
            int iHash3 = hash3(iIdentityHashCode);
            K k13 = kArr[iHash3];
            if (k13 == null) {
                kArr[iHash3] = k6;
                vArr[iHash3] = v2;
                int i17 = this.size;
                this.size = i17 + 1;
                if (i17 >= this.threshold) {
                    resize(this.capacity << 1);
                    return;
                }
                return;
            }
            if (z2) {
                int iHash4 = hash4(iIdentityHashCode);
                K k14 = kArr[iHash4];
                if (k14 == null) {
                    kArr[iHash4] = k6;
                    vArr[iHash4] = v2;
                    int i18 = this.size;
                    this.size = i18 + 1;
                    if (i18 >= this.threshold) {
                        resize(this.capacity << 1);
                        return;
                    }
                    return;
                }
                k10 = k14;
                i11 = iHash4;
            }
            int i19 = i12 + 1;
            if (i19 == i6) {
                putStash(k6, v2);
                return;
            }
            i12 = i19;
            i8 = i14;
            k7 = k11;
            i9 = iHash2;
            k8 = k12;
            i10 = iHash3;
            i7 = i13;
            k9 = k13;
        }
    }

    private void putResize(K k, V v) {
        K k2;
        int i;
        int iIdentityHashCode = System.identityHashCode(k);
        int i2 = iIdentityHashCode & this.mask;
        K[] kArr = this.keyTable;
        K k3 = kArr[i2];
        if (k3 == null) {
            kArr[i2] = k;
            this.valueTable[i2] = v;
            int i3 = this.size;
            this.size = i3 + 1;
            if (i3 >= this.threshold) {
                resize(this.capacity << 1);
                return;
            }
            return;
        }
        int iHash2 = hash2(iIdentityHashCode);
        K[] kArr2 = this.keyTable;
        K k4 = kArr2[iHash2];
        if (k4 == null) {
            kArr2[iHash2] = k;
            this.valueTable[iHash2] = v;
            int i4 = this.size;
            this.size = i4 + 1;
            if (i4 >= this.threshold) {
                resize(this.capacity << 1);
                return;
            }
            return;
        }
        int iHash3 = hash3(iIdentityHashCode);
        K[] kArr3 = this.keyTable;
        K k5 = kArr3[iHash3];
        if (k5 == null) {
            kArr3[iHash3] = k;
            this.valueTable[iHash3] = v;
            int i5 = this.size;
            this.size = i5 + 1;
            if (i5 >= this.threshold) {
                resize(this.capacity << 1);
                return;
            }
            return;
        }
        if (this.isBigTable) {
            int iHash4 = hash4(iIdentityHashCode);
            K[] kArr4 = this.keyTable;
            K k6 = kArr4[iHash4];
            if (k6 == null) {
                kArr4[iHash4] = k;
                this.valueTable[iHash4] = v;
                int i6 = this.size;
                this.size = i6 + 1;
                if (i6 >= this.threshold) {
                    resize(this.capacity << 1);
                    return;
                }
                return;
            }
            i = iHash4;
            k2 = k6;
        } else {
            k2 = null;
            i = -1;
        }
        push(k, v, i2, k3, iHash2, k4, iHash3, k5, i, k2);
    }

    private void putStash(K k, V v) {
        int i = this.stashSize;
        if (i == this.stashCapacity) {
            resize(this.capacity << 1);
            put(k, v);
            return;
        }
        int i2 = this.capacity + i;
        this.keyTable[i2] = k;
        this.valueTable[i2] = v;
        this.stashSize = i + 1;
        this.size++;
    }

    private void resize(int i) {
        int i2 = this.capacity + this.stashSize;
        this.capacity = i;
        this.threshold = (int) (i * this.loadFactor);
        this.mask = i - 1;
        this.hashShift = 31 - Integer.numberOfTrailingZeros(i);
        double d = i;
        this.stashCapacity = Math.max(3, ((int) Math.ceil(Math.log(d))) * 2);
        this.pushIterations = Math.max(Math.min(i, 8), ((int) Math.sqrt(d)) / 8);
        this.isBigTable = (this.capacity >>> 16) != 0;
        K[] kArr = this.keyTable;
        V[] vArr = this.valueTable;
        int i3 = this.stashCapacity;
        this.keyTable = (K[]) new Object[i + i3];
        this.valueTable = (V[]) new Object[i + i3];
        int i4 = this.size;
        this.size = 0;
        this.stashSize = 0;
        if (i4 > 0) {
            for (int i5 = 0; i5 < i2; i5++) {
                K k = kArr[i5];
                if (k != null) {
                    putResize(k, vArr[i5]);
                }
            }
        }
    }

    public void clear(int i) {
        if (this.capacity <= i) {
            clear();
        } else {
            this.size = 0;
            resize(i);
        }
    }

    public boolean containsKey(K k) {
        int iIdentityHashCode = System.identityHashCode(k);
        if (k == this.keyTable[this.mask & iIdentityHashCode]) {
            return true;
        }
        if (k == this.keyTable[hash2(iIdentityHashCode)]) {
            return true;
        }
        if (k == this.keyTable[hash3(iIdentityHashCode)]) {
            return true;
        }
        if (!this.isBigTable) {
            return containsKeyStash(k);
        }
        if (k != this.keyTable[hash4(iIdentityHashCode)]) {
            return containsKeyStash(k);
        }
        return true;
    }

    public boolean containsValue(Object obj, boolean z2) {
        V[] vArr = this.valueTable;
        if (obj == null) {
            K[] kArr = this.keyTable;
            int i = this.capacity + this.stashSize;
            while (true) {
                int i2 = i - 1;
                if (i <= 0) {
                    return false;
                }
                if (kArr[i2] != null && vArr[i2] == null) {
                    return true;
                }
                i = i2;
            }
        } else if (z2) {
            int i3 = this.capacity + this.stashSize;
            while (true) {
                int i4 = i3 - 1;
                if (i3 <= 0) {
                    return false;
                }
                if (vArr[i4] == obj) {
                    return true;
                }
                i3 = i4;
            }
        } else {
            int i5 = this.capacity + this.stashSize;
            while (true) {
                int i6 = i5 - 1;
                if (i5 <= 0) {
                    return false;
                }
                if (obj.equals(vArr[i6])) {
                    return true;
                }
                i5 = i6;
            }
        }
    }

    public void ensureCapacity(int i) {
        int i2 = this.size + i;
        if (i2 >= this.threshold) {
            resize(ObjectMap.nextPowerOfTwo((int) (i2 / this.loadFactor)));
        }
    }

    public Entries<K, V> entries() {
        Entries entries = this.entries;
        if (entries == null) {
            this.entries = new Entries(this);
        } else {
            entries.reset();
        }
        return this.entries;
    }

    public K findKey(Object obj, boolean z2) {
        V[] vArr = this.valueTable;
        if (obj == null) {
            K[] kArr = this.keyTable;
            int i = this.capacity + this.stashSize;
            while (true) {
                int i2 = i - 1;
                if (i <= 0) {
                    return null;
                }
                if (kArr[i2] != null && vArr[i2] == null) {
                    return kArr[i2];
                }
                i = i2;
            }
        } else if (z2) {
            int i3 = this.capacity + this.stashSize;
            while (true) {
                int i4 = i3 - 1;
                if (i3 <= 0) {
                    return null;
                }
                if (vArr[i4] == obj) {
                    return this.keyTable[i4];
                }
                i3 = i4;
            }
        } else {
            int i5 = this.capacity + this.stashSize;
            while (true) {
                int i6 = i5 - 1;
                if (i5 <= 0) {
                    return null;
                }
                if (obj.equals(vArr[i6])) {
                    return this.keyTable[i6];
                }
                i5 = i6;
            }
        }
    }

    public V get(K k) {
        int iIdentityHashCode = System.identityHashCode(k);
        int iHash2 = this.mask & iIdentityHashCode;
        if (k != this.keyTable[iHash2]) {
            iHash2 = hash2(iIdentityHashCode);
            if (k != this.keyTable[iHash2]) {
                iHash2 = hash3(iIdentityHashCode);
                if (k != this.keyTable[iHash2]) {
                    if (!this.isBigTable) {
                        return getStash(k, null);
                    }
                    iHash2 = hash4(iIdentityHashCode);
                    if (k != this.keyTable[iHash2]) {
                        return getStash(k, null);
                    }
                }
            }
        }
        return this.valueTable[iHash2];
    }

    public Keys<K> keys() {
        Keys keys = this.keys;
        if (keys == null) {
            this.keys = new Keys(this);
        } else {
            keys.reset();
        }
        return this.keys;
    }

    public V put(K k, V v) {
        K k2;
        int i;
        if (k == null) {
            throw new IllegalArgumentException("key cannot be null.");
        }
        K[] kArr = this.keyTable;
        int i2 = this.mask;
        boolean z2 = this.isBigTable;
        int iIdentityHashCode = System.identityHashCode(k);
        int i3 = iIdentityHashCode & i2;
        K k3 = kArr[i3];
        if (k3 == k) {
            V[] vArr = this.valueTable;
            V v2 = vArr[i3];
            vArr[i3] = v;
            return v2;
        }
        int iHash2 = hash2(iIdentityHashCode);
        K k4 = kArr[iHash2];
        if (k4 == k) {
            V[] vArr2 = this.valueTable;
            V v3 = vArr2[iHash2];
            vArr2[iHash2] = v;
            return v3;
        }
        int iHash3 = hash3(iIdentityHashCode);
        K k5 = kArr[iHash3];
        if (k5 == k) {
            V[] vArr3 = this.valueTable;
            V v4 = vArr3[iHash3];
            vArr3[iHash3] = v;
            return v4;
        }
        if (z2) {
            int iHash4 = hash4(iIdentityHashCode);
            K k6 = kArr[iHash4];
            if (k6 == k) {
                V[] vArr4 = this.valueTable;
                V v5 = vArr4[iHash4];
                vArr4[iHash4] = v;
                return v5;
            }
            i = iHash4;
            k2 = k6;
        } else {
            k2 = null;
            i = -1;
        }
        int i4 = this.capacity;
        int i5 = this.stashSize + i4;
        while (i4 < i5) {
            if (kArr[i4] == k) {
                V[] vArr5 = this.valueTable;
                V v6 = vArr5[i4];
                vArr5[i4] = v;
                return v6;
            }
            i4++;
        }
        if (k3 == null) {
            kArr[i3] = k;
            this.valueTable[i3] = v;
            int i6 = this.size;
            this.size = i6 + 1;
            if (i6 >= this.threshold) {
                resize(this.capacity << 1);
            }
            return null;
        }
        if (k4 == null) {
            kArr[iHash2] = k;
            this.valueTable[iHash2] = v;
            int i7 = this.size;
            this.size = i7 + 1;
            if (i7 >= this.threshold) {
                resize(this.capacity << 1);
            }
            return null;
        }
        if (k5 == null) {
            kArr[iHash3] = k;
            this.valueTable[iHash3] = v;
            int i8 = this.size;
            this.size = i8 + 1;
            if (i8 >= this.threshold) {
                resize(this.capacity << 1);
            }
            return null;
        }
        if (!z2 || k2 != null) {
            push(k, v, i3, k3, iHash2, k4, iHash3, k5, i, k2);
            return null;
        }
        kArr[i] = k;
        this.valueTable[i] = v;
        int i9 = this.size;
        this.size = i9 + 1;
        if (i9 >= this.threshold) {
            resize(this.capacity << 1);
        }
        return null;
    }

    public V remove(K k) {
        int iIdentityHashCode = System.identityHashCode(k);
        int i = this.mask & iIdentityHashCode;
        K[] kArr = this.keyTable;
        if (kArr[i] == k) {
            kArr[i] = null;
            V[] vArr = this.valueTable;
            V v = vArr[i];
            vArr[i] = null;
            this.size--;
            return v;
        }
        int iHash2 = hash2(iIdentityHashCode);
        K[] kArr2 = this.keyTable;
        if (kArr2[iHash2] == k) {
            kArr2[iHash2] = null;
            V[] vArr2 = this.valueTable;
            V v2 = vArr2[iHash2];
            vArr2[iHash2] = null;
            this.size--;
            return v2;
        }
        int iHash3 = hash3(iIdentityHashCode);
        K[] kArr3 = this.keyTable;
        if (kArr3[iHash3] == k) {
            kArr3[iHash3] = null;
            V[] vArr3 = this.valueTable;
            V v3 = vArr3[iHash3];
            vArr3[iHash3] = null;
            this.size--;
            return v3;
        }
        if (this.isBigTable) {
            int iHash4 = hash4(iIdentityHashCode);
            K[] kArr4 = this.keyTable;
            if (kArr4[iHash4] == k) {
                kArr4[iHash4] = null;
                V[] vArr4 = this.valueTable;
                V v4 = vArr4[iHash4];
                vArr4[iHash4] = null;
                this.size--;
                return v4;
            }
        }
        return removeStash(k);
    }

    public V removeStash(K k) {
        K[] kArr = this.keyTable;
        int i = this.capacity;
        int i2 = this.stashSize + i;
        while (i < i2) {
            if (kArr[i] == k) {
                V v = this.valueTable[i];
                removeStashIndex(i);
                this.size--;
                return v;
            }
            i++;
        }
        return null;
    }

    public void removeStashIndex(int i) {
        int i2 = this.stashSize - 1;
        this.stashSize = i2;
        int i3 = this.capacity + i2;
        if (i >= i3) {
            this.valueTable[i] = null;
            return;
        }
        K[] kArr = this.keyTable;
        kArr[i] = kArr[i3];
        V[] vArr = this.valueTable;
        vArr[i] = vArr[i3];
        vArr[i3] = null;
    }

    public void shrink(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(outline.q("maximumCapacity must be >= 0: ", i));
        }
        int i2 = this.size;
        if (i2 > i) {
            i = i2;
        }
        if (this.capacity <= i) {
            return;
        }
        resize(ObjectMap.nextPowerOfTwo(i));
    }

    public String toString() {
        int i;
        if (this.size == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder(32);
        sb.append('[');
        K[] kArr = this.keyTable;
        V[] vArr = this.valueTable;
        int length = kArr.length;
        while (true) {
            i = length - 1;
            if (length > 0) {
                K k = kArr[i];
                if (k != null) {
                    sb.append(k);
                    sb.append('=');
                    sb.append(vArr[i]);
                    break;
                }
                length = i;
            } else {
                break;
            }
        }
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                sb.append(']');
                return sb.toString();
            }
            K k2 = kArr[i2];
            if (k2 != null) {
                sb.append(", ");
                sb.append(k2);
                sb.append('=');
                sb.append(vArr[i2]);
            }
            i = i2;
        }
    }

    public Values<V> values() {
        Values values = this.values;
        if (values == null) {
            this.values = new Values(this);
        } else {
            values.reset();
        }
        return this.values;
    }

    public IdentityMap(int i) {
        this(i, 0.8f);
    }

    public static class Values<V> extends MapIterator<Object, V> implements Iterable<V>, Iterator<V> {
        public Values(IdentityMap<?, V> identityMap) {
            super(identityMap);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.hasNext;
        }

        @Override // java.lang.Iterable
        public Iterator<V> iterator() {
            return this;
        }

        @Override // java.util.Iterator
        public V next() {
            V[] vArr = this.map.valueTable;
            int i = this.nextIndex;
            V v = vArr[i];
            this.currentIndex = i;
            findNextIndex();
            return v;
        }

        @Override // com.esotericsoftware.kryo.util.IdentityMap.MapIterator, java.util.Iterator
        public /* bridge */ /* synthetic */ void remove() {
            super.remove();
        }

        @Override // com.esotericsoftware.kryo.util.IdentityMap.MapIterator
        public /* bridge */ /* synthetic */ void reset() {
            super.reset();
        }

        public ArrayList<V> toArray() {
            ArrayList<V> arrayList = new ArrayList<>(this.map.size);
            while (this.hasNext) {
                arrayList.add(next());
            }
            return arrayList;
        }

        public void toArray(ArrayList<V> arrayList) {
            while (this.hasNext) {
                arrayList.add(next());
            }
        }
    }

    public IdentityMap(int i, float f) {
        if (i < 0) {
            throw new IllegalArgumentException(outline.q("initialCapacity must be >= 0: ", i));
        }
        if (i <= 1073741824) {
            int iNextPowerOfTwo = ObjectMap.nextPowerOfTwo(i);
            this.capacity = iNextPowerOfTwo;
            if (f > 0.0f) {
                this.loadFactor = f;
                this.isBigTable = (iNextPowerOfTwo >>> 16) != 0;
                this.threshold = (int) (iNextPowerOfTwo * f);
                this.mask = iNextPowerOfTwo - 1;
                this.hashShift = 31 - Integer.numberOfTrailingZeros(iNextPowerOfTwo);
                this.stashCapacity = Math.max(3, ((int) Math.ceil(Math.log(this.capacity))) * 2);
                this.pushIterations = Math.max(Math.min(this.capacity, 8), ((int) Math.sqrt(this.capacity)) / 8);
                K[] kArr = (K[]) new Object[this.capacity + this.stashCapacity];
                this.keyTable = kArr;
                this.valueTable = (V[]) new Object[kArr.length];
                return;
            }
            throw new IllegalArgumentException("loadFactor must be > 0: " + f);
        }
        throw new IllegalArgumentException(outline.q("initialCapacity is too large: ", i));
    }

    public void clear() {
        K[] kArr = this.keyTable;
        V[] vArr = this.valueTable;
        int i = this.capacity + this.stashSize;
        while (true) {
            int i2 = i - 1;
            if (i > 0) {
                kArr[i2] = null;
                vArr[i2] = null;
                i = i2;
            } else {
                this.size = 0;
                this.stashSize = 0;
                return;
            }
        }
    }

    public V get(K k, V v) {
        int iIdentityHashCode = System.identityHashCode(k);
        int iHash2 = this.mask & iIdentityHashCode;
        if (k != this.keyTable[iHash2]) {
            iHash2 = hash2(iIdentityHashCode);
            if (k != this.keyTable[iHash2]) {
                iHash2 = hash3(iIdentityHashCode);
                if (k != this.keyTable[iHash2]) {
                    if (this.isBigTable) {
                        iHash2 = hash4(iIdentityHashCode);
                        if (k != this.keyTable[iHash2]) {
                            return getStash(k, v);
                        }
                    } else {
                        return getStash(k, v);
                    }
                }
            }
        }
        return this.valueTable[iHash2];
    }
}
