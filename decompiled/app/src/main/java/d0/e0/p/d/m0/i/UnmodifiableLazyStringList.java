package d0.e0.p.d.m0.i;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: UnmodifiableLazyStringList.java */
/* renamed from: d0.e0.p.d.m0.i.u, reason: use source file name */
/* loaded from: classes3.dex */
public class UnmodifiableLazyStringList extends AbstractList<String> implements RandomAccess, LazyStringList {
    public final LazyStringList j;

    /* compiled from: UnmodifiableLazyStringList.java */
    /* renamed from: d0.e0.p.d.m0.i.u$a */
    public class a implements ListIterator<String> {
        public ListIterator<String> j;
        public final /* synthetic */ int k;

        public a(int i) {
            this.k = i;
            this.j = UnmodifiableLazyStringList.this.j.listIterator(i);
        }

        @Override // java.util.ListIterator
        public /* bridge */ /* synthetic */ void add(String str) {
            add2(str);
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.j.hasNext();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.j.hasPrevious();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return next();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.j.nextIndex();
        }

        @Override // java.util.ListIterator
        public /* bridge */ /* synthetic */ String previous() {
            return previous2();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.j.previousIndex();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator
        public /* bridge */ /* synthetic */ void set(String str) {
            set2(str);
        }

        /* renamed from: add, reason: avoid collision after fix types in other method */
        public void add2(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public String next() {
            return this.j.next();
        }

        @Override // java.util.ListIterator
        /* renamed from: previous, reason: avoid collision after fix types in other method */
        public String previous2() {
            return this.j.previous();
        }

        /* renamed from: set, reason: avoid collision after fix types in other method */
        public void set2(String str) {
            throw new UnsupportedOperationException();
        }
    }

    /* compiled from: UnmodifiableLazyStringList.java */
    /* renamed from: d0.e0.p.d.m0.i.u$b */
    public class b implements Iterator<String> {
        public Iterator<String> j;

        public b() {
            this.j = UnmodifiableLazyStringList.this.j.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.j.hasNext();
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ String next() {
            return next2();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        /* renamed from: next, reason: avoid collision after fix types in other method */
        public String next2() {
            return this.j.next();
        }
    }

    public UnmodifiableLazyStringList(LazyStringList lazyStringList) {
        this.j = lazyStringList;
    }

    @Override // d0.e0.p.d.m0.i.LazyStringList
    public void add(ByteString3 byteString3) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object get(int i) {
        return get(i);
    }

    @Override // d0.e0.p.d.m0.i.LazyStringList
    public ByteString3 getByteString(int i) {
        return this.j.getByteString(i);
    }

    @Override // d0.e0.p.d.m0.i.LazyStringList
    public List<?> getUnderlyingElements() {
        return this.j.getUnderlyingElements();
    }

    @Override // d0.e0.p.d.m0.i.LazyStringList
    public LazyStringList getUnmodifiableView() {
        return this;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<String> iterator() {
        return new b();
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<String> listIterator(int i) {
        return new a(i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.j.size();
    }

    @Override // java.util.AbstractList, java.util.List
    public String get(int i) {
        return this.j.get(i);
    }
}
