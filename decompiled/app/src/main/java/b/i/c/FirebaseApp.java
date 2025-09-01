package b.i.c;

import android.content.Context;
import b.i.c.q.Publisher;
import b.i.c.t.Provider2;
import b.i.c.v.DataCollectionConfigStorage;

/* compiled from: FirebaseApp.java */
/* renamed from: b.i.c.b, reason: use source file name */
/* loaded from: classes3.dex */
public final /* synthetic */ class FirebaseApp implements Provider2 {
    public final FirebaseApp2 a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f1652b;

    public FirebaseApp(FirebaseApp2 firebaseApp2, Context context) {
        this.a = firebaseApp2;
        this.f1652b = context;
    }

    @Override // b.i.c.t.Provider2
    public Object get() {
        FirebaseApp2 firebaseApp2 = this.a;
        Context context = this.f1652b;
        Object obj = FirebaseApp2.a;
        return new DataCollectionConfigStorage(context, firebaseApp2.c(), (Publisher) firebaseApp2.g.a(Publisher.class));
    }
}
