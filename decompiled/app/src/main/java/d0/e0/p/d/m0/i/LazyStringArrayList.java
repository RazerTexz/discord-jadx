package d0.e0.p.d.m0.i;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: LazyStringArrayList.java */
/* renamed from: d0.e0.p.d.m0.i.k, reason: use source file name */
/* loaded from: classes3.dex */
public class LazyStringArrayList extends AbstractList<String> implements RandomAccess, LazyStringList {
    public static final LazyStringList j = new LazyStringArrayList().getUnmodifiableView();
    public final List<Object> k;

    public LazyStringArrayList() {
        this.k = new ArrayList();
    }

    public static String c(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof ByteString3 ? ((ByteString3) obj).toStringUtf8() : Internal.toStringUtf8((byte[]) obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ void add(int i, Object obj) {
        add(i, (String) obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.k.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object get(int i) {
        return get(i);
    }

    @Override // d0.e0.p.d.m0.i.LazyStringList
    public ByteString3 getByteString(int i) {
        Object obj = this.k.get(i);
        ByteString3 byteString3CopyFromUtf8 = obj instanceof ByteString3 ? (ByteString3) obj : obj instanceof String ? ByteString3.copyFromUtf8((String) obj) : ByteString3.copyFrom((byte[]) obj);
        if (byteString3CopyFromUtf8 != obj) {
            this.k.set(i, byteString3CopyFromUtf8);
        }
        return byteString3CopyFromUtf8;
    }

    @Override // d0.e0.p.d.m0.i.LazyStringList
    public List<?> getUnderlyingElements() {
        return Collections.unmodifiableList(this.k);
    }

    @Override // d0.e0.p.d.m0.i.LazyStringList
    public LazyStringList getUnmodifiableView() {
        return new UnmodifiableLazyStringList(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object remove(int i) {
        return remove(i);
    }

    @Override // java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        return set(i, (String) obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.k.size();
    }

    public void add(int i, String str) {
        this.k.add(i, str);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i, Collection<? extends String> collection) {
        if (collection instanceof LazyStringList) {
            collection = ((LazyStringList) collection).getUnderlyingElements();
        }
        boolean zAddAll = this.k.addAll(i, collection);
        ((AbstractList) this).modCount++;
        return zAddAll;
    }

    @Override // java.util.AbstractList, java.util.List
    public String get(int i) {
        Object obj = this.k.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof ByteString3) {
            ByteString3 byteString3 = (ByteString3) obj;
            String stringUtf8 = byteString3.toStringUtf8();
            if (byteString3.isValidUtf8()) {
                this.k.set(i, stringUtf8);
            }
            return stringUtf8;
        }
        byte[] bArr = (byte[]) obj;
        String stringUtf82 = Internal.toStringUtf8(bArr);
        if (Internal.isValidUtf8(bArr)) {
            this.k.set(i, stringUtf82);
        }
        return stringUtf82;
    }

    @Override // java.util.AbstractList, java.util.List
    public String remove(int i) {
        Object objRemove = this.k.remove(i);
        ((AbstractList) this).modCount++;
        return c(objRemove);
    }

    public String set(int i, String str) {
        return c(this.k.set(i, str));
    }

    public LazyStringArrayList(LazyStringList lazyStringList) {
        this.k = new ArrayList(lazyStringList.size());
        addAll(lazyStringList);
    }

    @Override // d0.e0.p.d.m0.i.LazyStringList
    public void add(ByteString3 byteString3) {
        this.k.add(byteString3);
        ((AbstractList) this).modCount++;
    }
}
