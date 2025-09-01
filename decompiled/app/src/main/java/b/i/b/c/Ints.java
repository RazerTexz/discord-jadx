package b.i.b.c;

import b.i.a.f.e.o.f;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: Ints.java */
/* renamed from: b.i.b.c.a, reason: use source file name */
/* loaded from: classes3.dex */
public class Ints extends AbstractList<Integer> implements RandomAccess, Serializable {
    private static final long serialVersionUID = 0;
    public final int[] array;
    public final int end;
    public final int start;

    public Ints(int[] iArr) {
        int length = iArr.length;
        this.array = iArr;
        this.start = 0;
        this.end = length;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        if (obj instanceof Integer) {
            int[] iArr = this.array;
            int iIntValue = ((Integer) obj).intValue();
            int i = this.start;
            int i2 = this.end;
            while (true) {
                if (i >= i2) {
                    i = -1;
                    break;
                }
                if (iArr[i] == iIntValue) {
                    break;
                }
                i++;
            }
            if (i != -1) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Ints)) {
            return super.equals(obj);
        }
        Ints ints = (Ints) obj;
        int size = size();
        if (ints.size() != size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (this.array[this.start + i] != ints.array[ints.start + i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i) {
        f.x(i, size());
        return Integer.valueOf(this.array[this.start + i]);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i = 1;
        for (int i2 = this.start; i2 < this.end; i2++) {
            i = (i * 31) + this.array[i2];
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (obj instanceof Integer) {
            int[] iArr = this.array;
            int iIntValue = ((Integer) obj).intValue();
            int i = this.start;
            int i2 = this.end;
            while (true) {
                if (i >= i2) {
                    i = -1;
                    break;
                }
                if (iArr[i] == iIntValue) {
                    break;
                }
                i++;
            }
            if (i >= 0) {
                return i - this.start;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        if (obj instanceof Integer) {
            int[] iArr = this.array;
            int iIntValue = ((Integer) obj).intValue();
            int i = this.start;
            int i2 = this.end - 1;
            while (true) {
                if (i2 < i) {
                    i2 = -1;
                    break;
                }
                if (iArr[i2] == iIntValue) {
                    break;
                }
                i2--;
            }
            if (i2 >= 0) {
                return i2 - this.start;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object set(int i, Object obj) {
        Integer num = (Integer) obj;
        f.x(i, size());
        int[] iArr = this.array;
        int i2 = this.start + i;
        int i3 = iArr[i2];
        Objects.requireNonNull(num);
        iArr[i2] = num.intValue();
        return Integer.valueOf(i3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.end - this.start;
    }

    @Override // java.util.AbstractList, java.util.List
    public List<Integer> subList(int i, int i2) {
        f.D(i, i2, size());
        if (i == i2) {
            return Collections.emptyList();
        }
        int[] iArr = this.array;
        int i3 = this.start;
        return new Ints(iArr, i + i3, i3 + i2);
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        StringBuilder sb = new StringBuilder(size() * 5);
        sb.append('[');
        sb.append(this.array[this.start]);
        int i = this.start;
        while (true) {
            i++;
            if (i >= this.end) {
                sb.append(']');
                return sb.toString();
            }
            sb.append(", ");
            sb.append(this.array[i]);
        }
    }

    public Ints(int[] iArr, int i, int i2) {
        this.array = iArr;
        this.start = i;
        this.end = i2;
    }
}
