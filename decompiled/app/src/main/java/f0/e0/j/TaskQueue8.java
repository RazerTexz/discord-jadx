package f0.e0.j;

import f0.e0.f.Task2;
import java.io.IOException;

/* compiled from: TaskQueue.kt */
/* renamed from: f0.e0.j.k, reason: use source file name */
/* loaded from: classes3.dex */
public final class TaskQueue8 extends Task2 {
    public final /* synthetic */ Http2Connection e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskQueue8(String str, boolean z2, String str2, boolean z3, Http2Connection http2Connection) {
        super(str2, z3);
        this.e = http2Connection;
    }

    @Override // f0.e0.f.Task2
    public long a() throws IOException {
        this.e.q(false, 2, 0);
        return -1L;
    }
}
