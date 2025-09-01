package s.a.a;

/* compiled from: LockFreeLinkedList.kt */
/* renamed from: s.a.a.i, reason: use source file name */
/* loaded from: classes3.dex */
public class LockFreeLinkedList extends LockFreeLinkedList3 {
    @Override // s.a.a.LockFreeLinkedList3
    public boolean m() {
        return false;
    }

    @Override // s.a.a.LockFreeLinkedList3
    public final boolean n() {
        throw new IllegalStateException("head cannot be removed".toString());
    }
}
