package b.d.a.a;

/* compiled from: com.android.billingclient:billing@@4.0.0 */
/* loaded from: classes.dex */
public final /* synthetic */ class z implements Runnable {
    public final /* synthetic */ i j;

    public /* synthetic */ z(i iVar) {
        this.j = iVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.j.onSkuDetailsResponse(p.k, null);
    }
}
