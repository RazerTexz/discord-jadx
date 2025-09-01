package j0.l.e.o;

/* compiled from: SpscArrayQueue.java */
/* renamed from: j0.l.e.o.r, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class SpscArrayQueue5<E> extends SpscArrayQueue3<E> {
    public static final long p = UnsafeAccess.a(SpscArrayQueue5.class, "producerIndex");
    public long producerIndex;

    public SpscArrayQueue5(int i) {
        super(i);
    }
}
