package b.p.a;

import android.view.ViewGroup;

/* compiled from: Alerter.kt */
/* renamed from: b.p.a.h, reason: use source file name */
/* loaded from: classes3.dex */
public final class Alerter2 implements Runnable {
    public final /* synthetic */ ViewGroup j;
    public final /* synthetic */ Alerter3 k;

    public Alerter2(ViewGroup viewGroup, Alerter3 alerter3) {
        this.j = viewGroup;
        this.k = alerter3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.j.addView(this.k.f1973b);
    }
}
