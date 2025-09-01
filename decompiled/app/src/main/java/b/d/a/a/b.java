package b.d.a.a;

import androidx.annotation.NonNull;
import com.android.billingclient.api.BillingResult;

/* compiled from: com.android.billingclient:billing@@4.0.0 */
/* loaded from: classes.dex */
public interface b {
    void onBillingServiceDisconnected();

    void onBillingSetupFinished(@NonNull BillingResult billingResult);
}
