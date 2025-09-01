package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.f.c.a.f.e;
import b.i.a.f.c.a.f.f;
import b.i.a.f.e.h.a;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* loaded from: classes3.dex */
public class GoogleSignInOptions extends AbstractSafeParcelable implements a.d, ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInOptions> CREATOR;
    public static final Scope j;
    public static final Scope k;
    public static final Scope l;
    public static final Scope m;
    public static final GoogleSignInOptions n;
    public static Comparator<Scope> o;
    public final int p;
    public final ArrayList<Scope> q;

    @Nullable
    public Account r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f2997s;
    public final boolean t;
    public final boolean u;

    @Nullable
    public String v;

    @Nullable
    public String w;

    /* renamed from: x, reason: collision with root package name */
    public ArrayList<GoogleSignInOptionsExtensionParcelable> f2998x;

    /* renamed from: y, reason: collision with root package name */
    @Nullable
    public String f2999y;

    /* renamed from: z, reason: collision with root package name */
    public Map<Integer, GoogleSignInOptionsExtensionParcelable> f3000z;

    static {
        Scope scope = new Scope("profile");
        j = scope;
        new Scope(NotificationCompat.CATEGORY_EMAIL);
        Scope scope2 = new Scope("openid");
        k = scope2;
        Scope scope3 = new Scope("https://www.googleapis.com/auth/games_lite");
        l = scope3;
        Scope scope4 = new Scope("https://www.googleapis.com/auth/games");
        m = scope4;
        HashSet hashSet = new HashSet();
        HashMap map = new HashMap();
        hashSet.add(scope2);
        hashSet.add(scope);
        if (hashSet.contains(scope4) && hashSet.contains(scope3)) {
            hashSet.remove(scope3);
        }
        n = new GoogleSignInOptions(3, new ArrayList(hashSet), null, false, false, false, null, null, map, null);
        HashSet hashSet2 = new HashSet();
        HashMap map2 = new HashMap();
        hashSet2.add(scope3);
        hashSet2.addAll(Arrays.asList(new Scope[0]));
        if (hashSet2.contains(scope4) && hashSet2.contains(scope3)) {
            hashSet2.remove(scope3);
        }
        new GoogleSignInOptions(3, new ArrayList(hashSet2), null, false, false, false, null, null, map2, null);
        CREATOR = new f();
        o = new e();
    }

    public GoogleSignInOptions(int i, ArrayList<Scope> arrayList, @Nullable Account account, boolean z2, boolean z3, boolean z4, @Nullable String str, @Nullable String str2, Map<Integer, GoogleSignInOptionsExtensionParcelable> map, @Nullable String str3) {
        this.p = i;
        this.q = arrayList;
        this.r = account;
        this.f2997s = z2;
        this.t = z3;
        this.u = z4;
        this.v = str;
        this.w = str2;
        this.f2998x = new ArrayList<>(map.values());
        this.f3000z = map;
        this.f2999y = str3;
    }

    @Nullable
    public static GoogleSignInOptions x0(@Nullable String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("scopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        String strOptString = jSONObject.has("accountName") ? jSONObject.optString("accountName") : null;
        return new GoogleSignInOptions(3, new ArrayList(hashSet), !TextUtils.isEmpty(strOptString) ? new Account(strOptString, "com.google") : null, jSONObject.getBoolean("idTokenRequested"), jSONObject.getBoolean("serverAuthRequested"), jSONObject.getBoolean("forceCodeForRefreshToken"), jSONObject.has("serverClientId") ? jSONObject.optString("serverClientId") : null, jSONObject.has("hostedDomain") ? jSONObject.optString("hostedDomain") : null, new HashMap(), null);
    }

    public static Map<Integer, GoogleSignInOptionsExtensionParcelable> y0(@Nullable List<GoogleSignInOptionsExtensionParcelable> list) {
        HashMap map = new HashMap();
        if (list == null) {
            return map;
        }
        for (GoogleSignInOptionsExtensionParcelable googleSignInOptionsExtensionParcelable : list) {
            map.put(Integer.valueOf(googleSignInOptionsExtensionParcelable.k), googleSignInOptionsExtensionParcelable);
        }
        return map;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x004d A[Catch: ClassCastException -> 0x007e, TryCatch #0 {ClassCastException -> 0x007e, blocks: (B:5:0x0004, B:7:0x000e, B:10:0x0017, B:12:0x0027, B:15:0x0034, B:17:0x0038, B:22:0x0045, B:24:0x004d, B:29:0x0060, B:31:0x0066, B:33:0x006c, B:35:0x0072, B:27:0x0056, B:20:0x003d), top: B:41:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0056 A[Catch: ClassCastException -> 0x007e, TryCatch #0 {ClassCastException -> 0x007e, blocks: (B:5:0x0004, B:7:0x000e, B:10:0x0017, B:12:0x0027, B:15:0x0034, B:17:0x0038, B:22:0x0045, B:24:0x004d, B:29:0x0060, B:31:0x0066, B:33:0x006c, B:35:0x0072, B:27:0x0056, B:20:0x003d), top: B:41:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007c A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            GoogleSignInOptions googleSignInOptions = (GoogleSignInOptions) obj;
            if (this.f2998x.size() <= 0 && googleSignInOptions.f2998x.size() <= 0 && this.q.size() == googleSignInOptions.w0().size() && this.q.containsAll(googleSignInOptions.w0())) {
                Account account = this.r;
                if (account == null) {
                    if (googleSignInOptions.r == null) {
                        if (TextUtils.isEmpty(this.v)) {
                            if (this.v.equals(googleSignInOptions.v)) {
                                if (this.u == googleSignInOptions.u) {
                                    if (!TextUtils.equals(this.f2999y, googleSignInOptions.f2999y)) {
                                    }
                                }
                            }
                        } else if (TextUtils.isEmpty(googleSignInOptions.v)) {
                            if (this.u == googleSignInOptions.u && this.f2997s == googleSignInOptions.f2997s && this.t == googleSignInOptions.t) {
                                if (!TextUtils.equals(this.f2999y, googleSignInOptions.f2999y)) {
                                    return true;
                                }
                            }
                        }
                    }
                } else if (account.equals(googleSignInOptions.r)) {
                    if (TextUtils.isEmpty(this.v)) {
                    }
                }
            }
        } catch (ClassCastException unused) {
        }
        return false;
    }

    public int hashCode() {
        ArrayList arrayList = new ArrayList();
        ArrayList<Scope> arrayList2 = this.q;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Scope scope = arrayList2.get(i);
            i++;
            arrayList.add(scope.k);
        }
        Collections.sort(arrayList);
        int iHashCode = arrayList.hashCode() + 31;
        Account account = this.r;
        int iHashCode2 = (iHashCode * 31) + (account == null ? 0 : account.hashCode());
        String str = this.v;
        int iHashCode3 = (((((((iHashCode2 * 31) + (str == null ? 0 : str.hashCode())) * 31) + (this.u ? 1 : 0)) * 31) + (this.f2997s ? 1 : 0)) * 31) + (this.t ? 1 : 0);
        String str2 = this.f2999y;
        return (iHashCode3 * 31) + (str2 != null ? str2.hashCode() : 0);
    }

    public ArrayList<Scope> w0() {
        return new ArrayList<>(this.q);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iY2 = AnimatableValueParser.y2(parcel, 20293);
        int i2 = this.p;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        AnimatableValueParser.w2(parcel, 2, w0(), false);
        AnimatableValueParser.s2(parcel, 3, this.r, i, false);
        boolean z2 = this.f2997s;
        parcel.writeInt(262148);
        parcel.writeInt(z2 ? 1 : 0);
        boolean z3 = this.t;
        parcel.writeInt(262149);
        parcel.writeInt(z3 ? 1 : 0);
        boolean z4 = this.u;
        parcel.writeInt(262150);
        parcel.writeInt(z4 ? 1 : 0);
        AnimatableValueParser.t2(parcel, 7, this.v, false);
        AnimatableValueParser.t2(parcel, 8, this.w, false);
        AnimatableValueParser.w2(parcel, 9, this.f2998x, false);
        AnimatableValueParser.t2(parcel, 10, this.f2999y, false);
        AnimatableValueParser.A2(parcel, iY2);
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.3.0 */
    public static final class a {
        public Set<Scope> a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f3001b;
        public boolean c;
        public boolean d;

        @Nullable
        public String e;

        @Nullable
        public Account f;

        @Nullable
        public String g;
        public Map<Integer, GoogleSignInOptionsExtensionParcelable> h;

        @Nullable
        public String i;

        public a() {
            this.a = new HashSet();
            this.h = new HashMap();
        }

        public final GoogleSignInOptions a() {
            if (this.a.contains(GoogleSignInOptions.m)) {
                Set<Scope> set = this.a;
                Scope scope = GoogleSignInOptions.l;
                if (set.contains(scope)) {
                    this.a.remove(scope);
                }
            }
            if (this.d && (this.f == null || !this.a.isEmpty())) {
                this.a.add(GoogleSignInOptions.k);
            }
            return new GoogleSignInOptions(3, new ArrayList(this.a), this.f, this.d, this.f3001b, this.c, this.e, this.g, this.h, this.i);
        }

        public a(@NonNull GoogleSignInOptions googleSignInOptions) {
            this.a = new HashSet();
            this.h = new HashMap();
            this.a = new HashSet(googleSignInOptions.q);
            this.f3001b = googleSignInOptions.t;
            this.c = googleSignInOptions.u;
            this.d = googleSignInOptions.f2997s;
            this.e = googleSignInOptions.v;
            this.f = googleSignInOptions.r;
            this.g = googleSignInOptions.w;
            this.h = GoogleSignInOptions.y0(googleSignInOptions.f2998x);
            this.i = googleSignInOptions.f2999y;
        }
    }
}
