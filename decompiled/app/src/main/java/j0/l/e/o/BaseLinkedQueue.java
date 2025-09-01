package j0.l.e.o;

import j0.l.e.n.LinkedQueueNode;

/* compiled from: BaseLinkedQueue.java */
/* renamed from: j0.l.e.o.a, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class BaseLinkedQueue<E> extends BaseLinkedQueue3<E> {
    public static final long k = UnsafeAccess.a(BaseLinkedQueue.class, "consumerNode");
    public LinkedQueueNode<E> consumerNode;

    public final LinkedQueueNode<E> d() {
        return (LinkedQueueNode) UnsafeAccess.a.getObjectVolatile(this, k);
    }
}
