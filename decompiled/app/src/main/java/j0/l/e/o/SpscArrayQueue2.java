package j0.l.e.o;

/* compiled from: SpscArrayQueue.java */
/* renamed from: j0.l.e.o.o, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class SpscArrayQueue2<E> extends SpscArrayQueue4<E> {
    public static final long q = UnsafeAccess.a(SpscArrayQueue2.class, "consumerIndex");
    public long consumerIndex;

    public SpscArrayQueue2(int i) {
        super(i);
    }
}
