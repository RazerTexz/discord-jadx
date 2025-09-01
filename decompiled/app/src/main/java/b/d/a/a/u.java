package b.d.a.a;

import com.android.billingclient.api.SkuDetails;
import java.util.concurrent.Callable;

/* compiled from: com.android.billingclient:billing@@4.0.0 */
/* loaded from: classes.dex */
public final /* synthetic */ class u implements Callable {
    public final /* synthetic */ a j;
    public final /* synthetic */ SkuDetails k;
    public final /* synthetic */ String l;

    public /* synthetic */ u(a aVar, SkuDetails skuDetails, String str) {
        this.j = aVar;
        this.k = skuDetails;
        this.l = str;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        a aVar = this.j;
        SkuDetails skuDetails = this.k;
        return aVar.f.F(3, aVar.e.getPackageName(), skuDetails.d(), this.l, null);
    }
}
