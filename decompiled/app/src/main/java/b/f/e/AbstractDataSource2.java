package b.f.e;

/* compiled from: AbstractDataSource.java */
/* renamed from: b.f.e.b, reason: use source file name */
/* loaded from: classes.dex */
public class AbstractDataSource2 implements Runnable {
    public final /* synthetic */ DataSubscriber j;
    public final /* synthetic */ AbstractDataSource3 k;

    public AbstractDataSource2(AbstractDataSource3 abstractDataSource3, DataSubscriber dataSubscriber) {
        this.k = abstractDataSource3;
        this.j = dataSubscriber;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.j.onProgressUpdate(this.k);
    }
}
