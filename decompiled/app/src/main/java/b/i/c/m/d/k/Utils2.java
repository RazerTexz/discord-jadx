package b.i.c.m.d.k;

import com.google.android.gms.tasks.Task;
import java.io.FilenameFilter;
import java.util.concurrent.CountDownLatch;

/* compiled from: Utils.java */
/* renamed from: b.i.c.m.d.k.g1, reason: use source file name */
/* loaded from: classes3.dex */
public final /* synthetic */ class Utils2 implements b.i.a.f.n.a {
    public final CountDownLatch a;

    public Utils2(CountDownLatch countDownLatch) {
        this.a = countDownLatch;
    }

    @Override // b.i.a.f.n.a
    public Object a(Task task) {
        CountDownLatch countDownLatch = this.a;
        FilenameFilter filenameFilter = Utils3.a;
        countDownLatch.countDown();
        return null;
    }
}
