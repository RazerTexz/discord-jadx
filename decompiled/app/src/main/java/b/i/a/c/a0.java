package b.i.a.c;

import b.i.a.c.Player2;
import b.i.a.c.f3.ListenerSet;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class a0 implements ListenerSet.a {
    public final /* synthetic */ int a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Player2.f f805b;
    public final /* synthetic */ Player2.f c;

    public /* synthetic */ a0(int i, Player2.f fVar, Player2.f fVar2) {
        this.a = i;
        this.f805b = fVar;
        this.c = fVar2;
    }

    @Override // b.i.a.c.f3.ListenerSet.a
    public final void invoke(Object obj) {
        int i = this.a;
        Player2.f fVar = this.f805b;
        Player2.f fVar2 = this.c;
        Player2.c cVar = (Player2.c) obj;
        cVar.j(i);
        cVar.g(fVar, fVar2, i);
    }
}
