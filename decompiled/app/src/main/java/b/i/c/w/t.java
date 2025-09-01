package b.i.c.w;

import android.content.SharedPreferences;
import java.util.Iterator;

/* compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
/* loaded from: classes3.dex */
public final /* synthetic */ class t implements Runnable {
    public final u j;

    public t(u uVar) {
        this.j = uVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        u uVar = this.j;
        synchronized (uVar.d) {
            SharedPreferences.Editor editorEdit = uVar.a.edit();
            String str = uVar.f1797b;
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = uVar.d.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append(uVar.c);
            }
            editorEdit.putString(str, sb.toString()).commit();
        }
    }
}
