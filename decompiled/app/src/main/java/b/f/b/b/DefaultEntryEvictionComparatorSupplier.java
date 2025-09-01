package b.f.b.b;

import b.f.b.b.DiskStorage;

/* compiled from: DefaultEntryEvictionComparatorSupplier.java */
/* renamed from: b.f.b.b.b, reason: use source file name */
/* loaded from: classes.dex */
public class DefaultEntryEvictionComparatorSupplier implements EntryEvictionComparatorSupplier {

    /* compiled from: DefaultEntryEvictionComparatorSupplier.java */
    /* renamed from: b.f.b.b.b$a */
    public class a implements EntryEvictionComparator {
        public a(DefaultEntryEvictionComparatorSupplier defaultEntryEvictionComparatorSupplier) {
        }

        @Override // java.util.Comparator
        public int compare(DiskStorage.a aVar, DiskStorage.a aVar2) {
            long jA = aVar.a();
            long jA2 = aVar2.a();
            if (jA < jA2) {
                return -1;
            }
            return jA2 == jA ? 0 : 1;
        }
    }

    @Override // b.f.b.b.EntryEvictionComparatorSupplier
    public EntryEvictionComparator get() {
        return new a(this);
    }
}
