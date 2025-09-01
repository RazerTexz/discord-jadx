package b.i.c.u;

/* compiled from: FirebaseInstallations.java */
/* renamed from: b.i.c.u.d, reason: use source file name */
/* loaded from: classes3.dex */
public final /* synthetic */ class FirebaseInstallations2 implements Runnable {
    public final FirebaseInstallations4 j;
    public final boolean k;

    public FirebaseInstallations2(FirebaseInstallations4 firebaseInstallations4, boolean z2) {
        this.j = firebaseInstallations4;
        this.k = z2;
    }

    @Override // java.lang.Runnable
    public void run() {
        FirebaseInstallations4 firebaseInstallations4 = this.j;
        boolean z2 = this.k;
        Object obj = FirebaseInstallations4.a;
        firebaseInstallations4.b(z2);
    }
}
