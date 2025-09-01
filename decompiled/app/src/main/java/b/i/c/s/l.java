package b.i.c.s;

import android.content.SharedPreferences;
import b.i.c.s.w;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;

/* compiled from: com.google.firebase:firebase-iid@@21.0.0 */
/* loaded from: classes3.dex */
public final /* synthetic */ class l implements b.i.a.f.n.f {
    public final FirebaseInstanceId a;

    /* renamed from: b, reason: collision with root package name */
    public final String f1768b;
    public final String c;
    public final String d;

    public l(FirebaseInstanceId firebaseInstanceId, String str, String str2, String str3) {
        this.a = firebaseInstanceId;
        this.f1768b = str;
        this.c = str2;
        this.d = str3;
    }

    @Override // b.i.a.f.n.f
    public final Task a(Object obj) {
        FirebaseInstanceId firebaseInstanceId = this.a;
        String str = this.f1768b;
        String str2 = this.c;
        String str3 = this.d;
        String str4 = (String) obj;
        w wVar = FirebaseInstanceId.f3111b;
        String strH = firebaseInstanceId.h();
        String strA = firebaseInstanceId.g.a();
        synchronized (wVar) {
            String strA2 = w.a.a(str4, strA, System.currentTimeMillis());
            if (strA2 != null) {
                SharedPreferences.Editor editorEdit = wVar.a.edit();
                editorEdit.putString(wVar.b(strH, str, str2), strA2);
                editorEdit.commit();
            }
        }
        return b.i.a.f.e.o.f.Z(new p(str3, str4));
    }
}
