package b.d.a.a;

import androidx.annotation.NonNull;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.Purchase;
import java.util.List;

/* compiled from: com.android.billingclient:billing@@4.0.0 */
/* loaded from: classes.dex */
public interface f {
    void onQueryPurchasesResponse(@NonNull BillingResult billingResult, @NonNull List<Purchase> list);
}
