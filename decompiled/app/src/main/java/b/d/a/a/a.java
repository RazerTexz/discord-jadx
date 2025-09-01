package b.d.a.a;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import androidx.annotation.Nullable;
import b.d.b.a.outline;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.ProxyBillingActivity;
import com.android.billingclient.api.SkuDetails;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.android.billingclient:billing@@4.0.0 */
/* loaded from: classes.dex */
public class a extends BillingClient {
    public volatile int a;

    /* renamed from: b, reason: collision with root package name */
    public final String f448b;
    public final Handler c;
    public volatile s d;
    public Context e;
    public volatile b.i.a.f.h.n.d f;
    public volatile n g;
    public boolean h;
    public int i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public ExecutorService q;

    @AnyThread
    public a(@Nullable String str, boolean z2, Context context, g gVar) {
        String str2;
        try {
            str2 = (String) Class.forName("b.d.a.b.a").getField("VERSION_NAME").get(null);
        } catch (Exception unused) {
            str2 = "4.0.0";
        }
        this.a = 0;
        this.c = new Handler(Looper.getMainLooper());
        this.i = 0;
        this.f448b = str2;
        Context applicationContext = context.getApplicationContext();
        this.e = applicationContext;
        this.d = new s(applicationContext, gVar);
        this.p = z2;
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void a(d dVar, e eVar) {
        if (!d()) {
            eVar.onConsumeResponse(p.j, dVar.a);
        } else if (l(new t(this, dVar, eVar), 30000L, new x(eVar, dVar), i()) == null) {
            eVar.onConsumeResponse(k(), dVar.a);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void b() {
        try {
            this.d.a();
            if (this.g != null) {
                n nVar = this.g;
                synchronized (nVar.j) {
                    nVar.l = null;
                    nVar.k = true;
                }
            }
            if (this.g != null && this.f != null) {
                b.i.a.f.h.n.a.e("BillingClient", "Unbinding from service.");
                this.e.unbindService(this.g);
                this.g = null;
            }
            this.f = null;
            ExecutorService executorService = this.q;
            if (executorService != null) {
                executorService.shutdownNow();
                this.q = null;
            }
        } catch (Exception e) {
            String strValueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 48);
            sb.append("There was an exception while ending connection: ");
            sb.append(strValueOf);
            b.i.a.f.h.n.a.f("BillingClient", sb.toString());
        } finally {
            this.a = 3;
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public final int c() {
        return this.a;
    }

    @Override // com.android.billingclient.api.BillingClient
    public final boolean d() {
        return (this.a != 2 || this.f == null || this.g == null) ? false : true;
    }

    @Override // com.android.billingclient.api.BillingClient
    public final BillingResult e(Activity activity, BillingFlowParams billingFlowParams) {
        String str;
        String str2;
        String str3;
        String str4;
        Future futureL;
        String str5;
        String str6;
        String str7;
        Bundle bundle;
        String str8;
        boolean z2;
        String strOptString;
        if (!d()) {
            BillingResult billingResult = p.j;
            j(billingResult);
            return billingResult;
        }
        Objects.requireNonNull(billingFlowParams);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(billingFlowParams.f);
        SkuDetails skuDetails = (SkuDetails) arrayList.get(0);
        String strE = skuDetails.e();
        String str9 = "BillingClient";
        if (strE.equals("subs") && !this.h) {
            b.i.a.f.h.n.a.f("BillingClient", "Current client doesn't support subscriptions.");
            BillingResult billingResult2 = p.l;
            j(billingResult2);
            return billingResult2;
        }
        if (((!billingFlowParams.g && billingFlowParams.f2001b == null && billingFlowParams.d == null && billingFlowParams.e == 0 && !billingFlowParams.a) ? false : true) && !this.j) {
            b.i.a.f.h.n.a.f("BillingClient", "Current client doesn't support extra params for buy intent.");
            BillingResult billingResult3 = p.f;
            j(billingResult3);
            return billingResult3;
        }
        if (arrayList.size() > 1 && !this.o) {
            b.i.a.f.h.n.a.f("BillingClient", "Current client doesn't support multi-item purchases.");
            BillingResult billingResult4 = p.m;
            j(billingResult4);
            return billingResult4;
        }
        String str10 = "";
        int i = 0;
        String str11 = "";
        while (i < arrayList.size()) {
            String strValueOf = String.valueOf(str11);
            String strValueOf2 = String.valueOf(arrayList.get(i));
            String str12 = str10;
            String strJ = outline.J(new StringBuilder(strValueOf.length() + strValueOf2.length()), strValueOf, strValueOf2);
            if (i < arrayList.size() - 1) {
                strJ = String.valueOf(strJ).concat(", ");
            }
            str11 = strJ;
            i++;
            str10 = str12;
        }
        String str13 = str10;
        StringBuilder sb = new StringBuilder(String.valueOf(str11).length() + 41 + strE.length());
        sb.append("Constructing buy intent for ");
        sb.append(str11);
        sb.append(", item type: ");
        sb.append(strE);
        b.i.a.f.h.n.a.e("BillingClient", sb.toString());
        if (this.j) {
            boolean z3 = this.k;
            boolean z4 = this.p;
            String str14 = this.f448b;
            Bundle bundle2 = new Bundle();
            bundle2.putString("playBillingLibraryVersion", str14);
            int i2 = billingFlowParams.e;
            if (i2 != 0) {
                bundle2.putInt("prorationMode", i2);
            }
            if (!TextUtils.isEmpty(billingFlowParams.f2001b)) {
                bundle2.putString("accountId", billingFlowParams.f2001b);
            }
            if (!TextUtils.isEmpty(billingFlowParams.d)) {
                bundle2.putString("obfuscatedProfileId", billingFlowParams.d);
            }
            if (billingFlowParams.g) {
                bundle2.putBoolean("vr", true);
            }
            if (!TextUtils.isEmpty(null)) {
                bundle2.putStringArrayList("skusToReplace", new ArrayList<>(Arrays.asList(null)));
            }
            if (!TextUtils.isEmpty(billingFlowParams.c)) {
                bundle2.putString("oldSkuPurchaseToken", billingFlowParams.c);
            }
            if (!TextUtils.isEmpty(null)) {
                bundle2.putString("oldSkuPurchaseId", null);
            }
            if (!TextUtils.isEmpty(null)) {
                bundle2.putString("paymentsPurchaseParams", null);
            }
            if (z3 && z4) {
                bundle2.putBoolean("enablePendingPurchases", true);
            }
            ArrayList<String> arrayList2 = new ArrayList<>();
            ArrayList<String> arrayList3 = new ArrayList<>();
            ArrayList<String> arrayList4 = new ArrayList<>();
            ArrayList<Integer> arrayList5 = new ArrayList<>();
            str2 = "; try to reconnect";
            ArrayList<String> arrayList6 = new ArrayList<>();
            str4 = str11;
            int size = arrayList.size();
            boolean z5 = false;
            boolean z6 = false;
            boolean z7 = false;
            boolean z8 = false;
            str = "BUY_INTENT";
            int i3 = 0;
            while (i3 < size) {
                int i4 = size;
                SkuDetails skuDetails2 = (SkuDetails) arrayList.get(i3);
                String str15 = str9;
                if (!skuDetails2.f2006b.optString("skuDetailsToken").isEmpty()) {
                    arrayList2.add(skuDetails2.f2006b.optString("skuDetailsToken"));
                }
                try {
                    strOptString = new JSONObject(skuDetails2.a).optString("offer_id_token");
                } catch (JSONException unused) {
                    strOptString = str13;
                }
                String str16 = strE;
                String strOptString2 = skuDetails2.f2006b.optString("offer_id");
                int iOptInt = skuDetails2.f2006b.optInt("offer_type");
                String strOptString3 = skuDetails2.f2006b.optString("serializedDocid");
                arrayList3.add(strOptString);
                z5 |= !TextUtils.isEmpty(strOptString);
                arrayList4.add(strOptString2);
                z6 |= !TextUtils.isEmpty(strOptString2);
                arrayList5.add(Integer.valueOf(iOptInt));
                z7 |= iOptInt != 0;
                z8 |= !TextUtils.isEmpty(strOptString3);
                arrayList6.add(strOptString3);
                i3++;
                str9 = str15;
                size = i4;
                strE = str16;
            }
            String str17 = strE;
            str3 = str9;
            if (!arrayList2.isEmpty()) {
                bundle2.putStringArrayList("skuDetailsTokens", arrayList2);
            }
            if (z5) {
                if (!this.m) {
                    BillingResult billingResult5 = p.g;
                    j(billingResult5);
                    return billingResult5;
                }
                bundle2.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", arrayList3);
            }
            if (z6) {
                bundle2.putStringArrayList("SKU_OFFER_ID_LIST", arrayList4);
            }
            if (z7) {
                bundle2.putIntegerArrayList("SKU_OFFER_TYPE_LIST", arrayList5);
            }
            if (z8) {
                bundle2.putStringArrayList("SKU_SERIALIZED_DOCID_LIST", arrayList6);
            }
            if (TextUtils.isEmpty(skuDetails.f())) {
                str8 = null;
                z2 = false;
            } else {
                bundle2.putString("skuPackageName", skuDetails.f());
                str8 = null;
                z2 = true;
            }
            if (!TextUtils.isEmpty(str8)) {
                bundle2.putString("accountName", str8);
            }
            if (arrayList.size() > 1) {
                ArrayList<String> arrayList7 = new ArrayList<>(arrayList.size() - 1);
                ArrayList<String> arrayList8 = new ArrayList<>(arrayList.size() - 1);
                for (int i5 = 1; i5 < arrayList.size(); i5++) {
                    arrayList7.add(((SkuDetails) arrayList.get(i5)).d());
                    arrayList8.add(((SkuDetails) arrayList.get(i5)).e());
                }
                bundle2.putStringArrayList("additionalSkus", arrayList7);
                bundle2.putStringArrayList("additionalSkuTypes", arrayList8);
            }
            if (!TextUtils.isEmpty(activity.getIntent().getStringExtra("PROXY_PACKAGE"))) {
                String stringExtra = activity.getIntent().getStringExtra("PROXY_PACKAGE");
                bundle2.putString("proxyPackage", stringExtra);
                try {
                    bundle2.putString("proxyPackageVersion", this.e.getPackageManager().getPackageInfo(stringExtra, 0).versionName);
                } catch (PackageManager.NameNotFoundException unused2) {
                    bundle2.putString("proxyPackageVersion", "package not found");
                }
            }
            futureL = l(new b0(this, (this.n && z2) ? 15 : this.k ? 9 : billingFlowParams.g ? 7 : 6, skuDetails, str17, billingFlowParams, bundle2), 5000L, null, this.c);
        } else {
            str = "BUY_INTENT";
            str2 = "; try to reconnect";
            str3 = "BillingClient";
            str4 = str11;
            futureL = l(new u(this, skuDetails, strE), 5000L, null, this.c);
        }
        try {
            try {
                try {
                    bundle = (Bundle) futureL.get(5000L, TimeUnit.MILLISECONDS);
                    str7 = str3;
                } catch (CancellationException | TimeoutException unused3) {
                    str7 = str3;
                }
            } catch (Exception unused4) {
                str7 = str3;
            }
        } catch (CancellationException | TimeoutException unused5) {
            str5 = str2;
            str6 = str4;
            str7 = str3;
        }
        try {
            int iA = b.i.a.f.h.n.a.a(bundle, str7);
            String strD = b.i.a.f.h.n.a.d(bundle, str7);
            if (iA == 0) {
                Intent intent = new Intent(activity, (Class<?>) ProxyBillingActivity.class);
                String str18 = str;
                intent.putExtra(str18, (PendingIntent) bundle.getParcelable(str18));
                activity.startActivity(intent);
                return p.i;
            }
            StringBuilder sb2 = new StringBuilder(52);
            sb2.append("Unable to buy item, Error response code: ");
            sb2.append(iA);
            b.i.a.f.h.n.a.f(str7, sb2.toString());
            BillingResult billingResult6 = new BillingResult();
            billingResult6.a = iA;
            billingResult6.f2003b = strD;
            j(billingResult6);
            return billingResult6;
        } catch (CancellationException | TimeoutException unused6) {
            str5 = str2;
            str6 = str4;
            StringBuilder sb3 = new StringBuilder(String.valueOf(str6).length() + 68);
            sb3.append("Time out while launching billing flow: ; for sku: ");
            sb3.append(str6);
            sb3.append(str5);
            b.i.a.f.h.n.a.f(str7, sb3.toString());
            BillingResult billingResult7 = p.k;
            j(billingResult7);
            return billingResult7;
        } catch (Exception unused7) {
            StringBuilder sb4 = new StringBuilder(String.valueOf(str4).length() + 69);
            sb4.append("Exception while launching billing flow: ; for sku: ");
            sb4.append(str4);
            sb4.append(str2);
            b.i.a.f.h.n.a.f(str7, sb4.toString());
            BillingResult billingResult8 = p.j;
            j(billingResult8);
            return billingResult8;
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void f(String str, f fVar) {
        if (!d()) {
            BillingResult billingResult = p.j;
            b.i.a.f.h.n.m<Object> mVar = b.i.a.f.h.n.k.k;
            fVar.onQueryPurchasesResponse(billingResult, b.i.a.f.h.n.l.l);
        } else {
            if (TextUtils.isEmpty(str)) {
                b.i.a.f.h.n.a.f("BillingClient", "Please provide a valid SKU type.");
                BillingResult billingResult2 = p.e;
                b.i.a.f.h.n.m<Object> mVar2 = b.i.a.f.h.n.k.k;
                fVar.onQueryPurchasesResponse(billingResult2, b.i.a.f.h.n.l.l);
                return;
            }
            if (l(new j(this, str, fVar), 30000L, new y(fVar), i()) == null) {
                BillingResult billingResultK = k();
                b.i.a.f.h.n.m<Object> mVar3 = b.i.a.f.h.n.k.k;
                fVar.onQueryPurchasesResponse(billingResultK, b.i.a.f.h.n.l.l);
            }
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void g(h hVar, i iVar) {
        if (!d()) {
            iVar.onSkuDetailsResponse(p.j, null);
            return;
        }
        String str = hVar.a;
        List<String> list = hVar.f450b;
        if (TextUtils.isEmpty(str)) {
            b.i.a.f.h.n.a.f("BillingClient", "Please fix the input params. SKU type can't be empty.");
            iVar.onSkuDetailsResponse(p.e, null);
            return;
        }
        if (list == null) {
            b.i.a.f.h.n.a.f("BillingClient", "Please fix the input params. The list of SKUs can't be empty - set SKU list or SkuWithOffer list.");
            iVar.onSkuDetailsResponse(p.d, null);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str2 : list) {
            if (TextUtils.isEmpty(str2)) {
                throw new IllegalArgumentException("SKU must be set.");
            }
            arrayList.add(new q(str2));
        }
        if (l(new v(this, str, arrayList, iVar), 30000L, new z(iVar), i()) == null) {
            iVar.onSkuDetailsResponse(k(), null);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void h(b bVar) {
        ServiceInfo serviceInfo;
        if (d()) {
            b.i.a.f.h.n.a.e("BillingClient", "Service connection is valid. No need to re-initialize.");
            bVar.onBillingSetupFinished(p.i);
            return;
        }
        if (this.a == 1) {
            b.i.a.f.h.n.a.f("BillingClient", "Client is already in the process of connecting to billing service.");
            bVar.onBillingSetupFinished(p.c);
            return;
        }
        if (this.a == 3) {
            b.i.a.f.h.n.a.f("BillingClient", "Client was already closed and can't be reused. Please create another instance.");
            bVar.onBillingSetupFinished(p.j);
            return;
        }
        this.a = 1;
        s sVar = this.d;
        r rVar = sVar.f453b;
        Context context = sVar.a;
        IntentFilter intentFilter = new IntentFilter("com.android.vending.billing.PURCHASES_UPDATED");
        if (!rVar.f452b) {
            context.registerReceiver(rVar.c.f453b, intentFilter);
            rVar.f452b = true;
        }
        b.i.a.f.h.n.a.e("BillingClient", "Starting in-app billing setup.");
        this.g = new n(this, bVar);
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage("com.android.vending");
        List<ResolveInfo> listQueryIntentServices = this.e.getPackageManager().queryIntentServices(intent, 0);
        if (listQueryIntentServices != null && !listQueryIntentServices.isEmpty() && (serviceInfo = listQueryIntentServices.get(0).serviceInfo) != null) {
            String str = serviceInfo.packageName;
            String str2 = serviceInfo.name;
            if (!"com.android.vending".equals(str) || str2 == null) {
                b.i.a.f.h.n.a.f("BillingClient", "The device doesn't have valid Play Store.");
            } else {
                ComponentName componentName = new ComponentName(str, str2);
                Intent intent2 = new Intent(intent);
                intent2.setComponent(componentName);
                intent2.putExtra("playBillingLibraryVersion", this.f448b);
                if (this.e.bindService(intent2, this.g, 1)) {
                    b.i.a.f.h.n.a.e("BillingClient", "Service was bonded successfully.");
                    return;
                }
                b.i.a.f.h.n.a.f("BillingClient", "Connection to Billing service is blocked.");
            }
        }
        this.a = 0;
        b.i.a.f.h.n.a.e("BillingClient", "Billing service unavailable on device.");
        bVar.onBillingSetupFinished(p.f451b);
    }

    public final Handler i() {
        return Looper.myLooper() == null ? this.c : new Handler(Looper.myLooper());
    }

    public final BillingResult j(BillingResult billingResult) {
        if (Thread.interrupted()) {
            return billingResult;
        }
        this.c.post(new w(this, billingResult));
        return billingResult;
    }

    public final BillingResult k() {
        return (this.a == 0 || this.a == 3) ? p.j : p.h;
    }

    @Nullable
    public final <T> Future<T> l(Callable<T> callable, long j, @Nullable Runnable runnable, Handler handler) {
        long j2 = (long) (j * 0.95d);
        if (this.q == null) {
            this.q = Executors.newFixedThreadPool(b.i.a.f.h.n.a.a, new k(this));
        }
        try {
            Future<T> futureSubmit = this.q.submit(callable);
            handler.postDelayed(new a0(futureSubmit, runnable), j2);
            return futureSubmit;
        } catch (Exception e) {
            String strValueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 28);
            sb.append("Async task throws exception ");
            sb.append(strValueOf);
            b.i.a.f.h.n.a.f("BillingClient", sb.toString());
            return null;
        }
    }
}
