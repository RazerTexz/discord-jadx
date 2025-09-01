package j0.l.e.o;

import j0.l.e.n.LinkedQueueNode;

/* compiled from: BaseLinkedQueue.java */
/* renamed from: j0.l.e.o.d, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class BaseLinkedQueue4<E> extends BaseLinkedQueue2<E> {
    public static final long j = UnsafeAccess.a(BaseLinkedQueue4.class, "producerNode");
    public LinkedQueueNode<E> producerNode;

    public final LinkedQueueNode<E> c() {
        return (LinkedQueueNode) UnsafeAccess.a.getObjectVolatile(this, j);
    }
}
