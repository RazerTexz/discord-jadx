package b.i.a.f.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* loaded from: classes3.dex */
public final /* synthetic */ class e implements Runnable {
    public final a j;
    public final Intent k;
    public final Context l;
    public final boolean m;
    public final BroadcastReceiver.PendingResult n;

    public e(a aVar, Intent intent, Context context, boolean z2, BroadcastReceiver.PendingResult pendingResult) {
        this.j = aVar;
        this.k = intent;
        this.l = context;
        this.m = z2;
        this.n = pendingResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a aVar = this.j;
        Intent intent = this.k;
        Context context = this.l;
        boolean z2 = this.m;
        BroadcastReceiver.PendingResult pendingResult = this.n;
        Objects.requireNonNull(aVar);
        try {
            Parcelable parcelableExtra = intent.getParcelableExtra("wrapped_intent");
            Intent intent2 = parcelableExtra instanceof Intent ? (Intent) parcelableExtra : null;
            int iA = intent2 != null ? aVar.a(context, intent2) : aVar.b(context, intent);
            if (z2) {
                pendingResult.setResultCode(iA);
            }
        } finally {
            pendingResult.finish();
        }
    }
}
