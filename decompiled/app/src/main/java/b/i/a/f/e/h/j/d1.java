package b.i.a.f.e.h.j;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import b.d.b.a.outline;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* loaded from: classes3.dex */
public final class d1 extends Fragment implements j {
    public static final WeakHashMap<Activity, WeakReference<d1>> j = new WeakHashMap<>();
    public final Map<String, LifecycleCallback> k = Collections.synchronizedMap(new ArrayMap());
    public int l = 0;

    @Nullable
    public Bundle m;

    @Override // b.i.a.f.e.h.j.j
    public final void a(String str, @NonNull LifecycleCallback lifecycleCallback) {
        if (this.k.containsKey(str)) {
            throw new IllegalArgumentException(outline.K(new StringBuilder(str.length() + 59), "LifecycleCallback with tag ", str, " already added to this fragment."));
        }
        this.k.put(str, lifecycleCallback);
        if (this.l > 0) {
            new b.i.a.f.h.g.d(Looper.getMainLooper()).post(new c1(this, lifecycleCallback, str));
        }
    }

    @Override // b.i.a.f.e.h.j.j
    @Nullable
    public final <T extends LifecycleCallback> T d(String str, Class<T> cls) {
        return cls.cast(this.k.get(str));
    }

    @Override // android.app.Fragment
    public final void dump(String str, @Nullable FileDescriptor fileDescriptor, PrintWriter printWriter, @Nullable String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        Iterator<LifecycleCallback> it = this.k.values().iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    @Override // b.i.a.f.e.h.j.j
    public final Activity e() {
        return getActivity();
    }

    @Override // android.app.Fragment
    public final void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        Iterator<LifecycleCallback> it = this.k.values().iterator();
        while (it.hasNext()) {
            it.next().d(i, i2, intent);
        }
    }

    @Override // android.app.Fragment
    public final void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.l = 1;
        this.m = bundle;
        for (Map.Entry<String, LifecycleCallback> entry : this.k.entrySet()) {
            entry.getValue().e(bundle != null ? bundle.getBundle(entry.getKey()) : null);
        }
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.l = 5;
        Iterator<LifecycleCallback> it = this.k.values().iterator();
        while (it.hasNext()) {
            it.next().f();
        }
    }

    @Override // android.app.Fragment
    public final void onResume() {
        super.onResume();
        this.l = 3;
        Iterator<LifecycleCallback> it = this.k.values().iterator();
        while (it.hasNext()) {
            it.next().g();
        }
    }

    @Override // android.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle == null) {
            return;
        }
        for (Map.Entry<String, LifecycleCallback> entry : this.k.entrySet()) {
            Bundle bundle2 = new Bundle();
            entry.getValue().h(bundle2);
            bundle.putBundle(entry.getKey(), bundle2);
        }
    }

    @Override // android.app.Fragment
    public final void onStart() {
        super.onStart();
        this.l = 2;
        Iterator<LifecycleCallback> it = this.k.values().iterator();
        while (it.hasNext()) {
            it.next().i();
        }
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        this.l = 4;
        Iterator<LifecycleCallback> it = this.k.values().iterator();
        while (it.hasNext()) {
            it.next().j();
        }
    }
}
