package b.f.m.n;

/* compiled from: SystemDelegate.java */
/* renamed from: b.f.m.n.c, reason: use source file name */
/* loaded from: classes3.dex */
public class SystemDelegate implements NativeLoaderDelegate {
    @Override // b.f.m.n.NativeLoaderDelegate
    public boolean a(String str, int i) {
        System.loadLibrary(str);
        return true;
    }
}
