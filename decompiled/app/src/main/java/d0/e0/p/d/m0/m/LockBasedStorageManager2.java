package d0.e0.p.d.m0.m;

import d0.e0.p.d.m0.m.LockBasedStorageManager;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: LockBasedStorageManager.java */
/* renamed from: d0.e0.p.d.m0.m.g, reason: use source file name */
/* loaded from: classes3.dex */
public class LockBasedStorageManager2<K, V> implements Function1<LockBasedStorageManager.g<K, V>, V> {
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke((LockBasedStorageManager.g) obj);
    }

    public V invoke(LockBasedStorageManager.g<K, V> gVar) {
        return gVar.f3515b.invoke();
    }
}
