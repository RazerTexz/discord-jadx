package b.d.a.a;

import android.os.Bundle;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.SkuDetails;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import org.json.JSONException;

/* compiled from: com.android.billingclient:billing@@4.0.0 */
/* loaded from: classes.dex */
public final /* synthetic */ class v implements Callable {
    public final /* synthetic */ a j;
    public final /* synthetic */ String k;
    public final /* synthetic */ List l;
    public final /* synthetic */ i m;

    public /* synthetic */ v(a aVar, String str, List list, i iVar) {
        this.j = aVar;
        this.k = str;
        this.l = list;
        this.m = iVar;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        String strD;
        int iA;
        int i;
        Bundle bundleE0;
        a aVar = this.j;
        String str = this.k;
        List list = this.l;
        i iVar = this.m;
        Objects.requireNonNull(aVar);
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                strD = "";
                iA = 0;
                break;
            }
            int i3 = i2 + 20;
            ArrayList arrayList2 = new ArrayList(list.subList(i2, i3 > size ? size : i3));
            ArrayList<String> arrayList3 = new ArrayList<>();
            int size2 = arrayList2.size();
            for (int i4 = 0; i4 < size2; i4++) {
                arrayList3.add(((q) arrayList2.get(i4)).a);
            }
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("ITEM_ID_LIST", arrayList3);
            bundle.putString("playBillingLibraryVersion", aVar.f448b);
            try {
                if (aVar.l) {
                    i = i3;
                    bundleE0 = aVar.f.o(10, aVar.e.getPackageName(), str, bundle, b.i.a.f.h.n.a.b(aVar.i, aVar.p, aVar.f448b, null, arrayList2));
                } else {
                    i = i3;
                    bundleE0 = aVar.f.e0(3, aVar.e.getPackageName(), str, bundle);
                }
                if (bundleE0 == null) {
                    b.i.a.f.h.n.a.f("BillingClient", "querySkuDetailsAsync got null sku details list");
                    break;
                }
                if (bundleE0.containsKey("DETAILS_LIST")) {
                    ArrayList<String> stringArrayList = bundleE0.getStringArrayList("DETAILS_LIST");
                    if (stringArrayList == null) {
                        b.i.a.f.h.n.a.f("BillingClient", "querySkuDetailsAsync got null response list");
                        break;
                    }
                    for (int i5 = 0; i5 < stringArrayList.size(); i5++) {
                        try {
                            SkuDetails skuDetails = new SkuDetails(stringArrayList.get(i5));
                            String strValueOf = String.valueOf(skuDetails);
                            StringBuilder sb = new StringBuilder(strValueOf.length() + 17);
                            sb.append("Got sku details: ");
                            sb.append(strValueOf);
                            b.i.a.f.h.n.a.e("BillingClient", sb.toString());
                            arrayList.add(skuDetails);
                        } catch (JSONException unused) {
                            b.i.a.f.h.n.a.f("BillingClient", "Got a JSON exception trying to decode SkuDetails.");
                            strD = "Error trying to decode SkuDetails.";
                            arrayList = null;
                            iA = 6;
                            BillingResult billingResult = new BillingResult();
                            billingResult.a = iA;
                            billingResult.f2003b = strD;
                            iVar.onSkuDetailsResponse(billingResult, arrayList);
                            return null;
                        }
                    }
                    i2 = i;
                } else {
                    iA = b.i.a.f.h.n.a.a(bundleE0, "BillingClient");
                    strD = b.i.a.f.h.n.a.d(bundleE0, "BillingClient");
                    if (iA != 0) {
                        StringBuilder sb2 = new StringBuilder(50);
                        sb2.append("getSkuDetails() failed. Response code: ");
                        sb2.append(iA);
                        b.i.a.f.h.n.a.f("BillingClient", sb2.toString());
                    } else {
                        b.i.a.f.h.n.a.f("BillingClient", "getSkuDetails() returned a bundle with neither an error nor a detail list.");
                    }
                }
            } catch (Exception e) {
                String strValueOf2 = String.valueOf(e);
                StringBuilder sb3 = new StringBuilder(strValueOf2.length() + 63);
                sb3.append("querySkuDetailsAsync got a remote exception (try to reconnect).");
                sb3.append(strValueOf2);
                b.i.a.f.h.n.a.f("BillingClient", sb3.toString());
                iA = -1;
                strD = "Service connection is disconnected.";
            }
        }
        iA = 4;
        strD = "Item is unavailable for purchase.";
        arrayList = null;
        BillingResult billingResult2 = new BillingResult();
        billingResult2.a = iA;
        billingResult2.f2003b = strD;
        iVar.onSkuDetailsResponse(billingResult2, arrayList);
        return null;
    }
}
