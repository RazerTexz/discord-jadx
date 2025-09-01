package s.a;

import b.d.b.a.outline;
import com.discord.widgets.chat.input.MentionUtils;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.Job;

/* compiled from: JobSupport.kt */
/* loaded from: classes3.dex */
public final class d1 extends g1<Job> {
    public final Function1<Throwable, Unit> n;

    /* JADX WARN: Multi-variable type inference failed */
    public d1(Job job, Function1<? super Throwable, Unit> function1) {
        super(job);
        this.n = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Throwable th) {
        this.n.invoke(th);
        return Unit.a;
    }

    @Override // s.a.CompletionHandler2
    public void q(Throwable th) {
        this.n.invoke(th);
    }

    @Override // s.a.a.LockFreeLinkedList3
    public String toString() {
        StringBuilder sbU = outline.U("InvokeOnCompletion[");
        sbU.append(d1.class.getSimpleName());
        sbU.append(MentionUtils.MENTIONS_CHAR);
        sbU.append(b.i.a.f.e.o.f.l0(this));
        sbU.append(']');
        return sbU.toString();
    }
}
