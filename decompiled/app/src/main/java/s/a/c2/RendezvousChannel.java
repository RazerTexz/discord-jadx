package s.a.c2;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: RendezvousChannel.kt */
/* renamed from: s.a.c2.q, reason: use source file name */
/* loaded from: classes3.dex */
public class RendezvousChannel<E> extends AbstractChannel<E> {
    public RendezvousChannel(Function1<? super E, Unit> function1) {
        super(function1);
    }

    @Override // s.a.c2.AbstractChannel3
    public final boolean h() {
        return true;
    }

    @Override // s.a.c2.AbstractChannel3
    public final boolean i() {
        return true;
    }

    @Override // s.a.c2.AbstractChannel
    public final boolean s() {
        return true;
    }

    @Override // s.a.c2.AbstractChannel
    public final boolean t() {
        return true;
    }
}
