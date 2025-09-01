package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.fragment.app.FragmentActivity;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.f.e.h.j.d1;
import b.i.a.f.e.h.j.f1;
import b.i.a.f.e.h.j.i;
import b.i.a.f.e.h.j.j;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* loaded from: classes3.dex */
public class LifecycleCallback {

    @RecentlyNonNull
    public final j j;

    public LifecycleCallback(@RecentlyNonNull j jVar) {
        this.j = jVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x001f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @RecentlyNonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static j c(@RecentlyNonNull Activity activity) {
        j jVar;
        AnimatableValueParser.z(activity, "Activity must not be null");
        if (activity instanceof FragmentActivity) {
            FragmentActivity fragmentActivity = (FragmentActivity) activity;
            WeakHashMap<FragmentActivity, WeakReference<f1>> weakHashMap = f1.j;
            WeakReference<f1> weakReference = weakHashMap.get(fragmentActivity);
            if (weakReference != null) {
                j jVar2 = (f1) weakReference.get();
                jVar = jVar2;
                if (jVar2 == null) {
                    try {
                        f1 f1Var = (f1) fragmentActivity.getSupportFragmentManager().findFragmentByTag("SupportLifecycleFragmentImpl");
                        if (f1Var != null) {
                            boolean zIsRemoving = f1Var.isRemoving();
                            f1 f1Var2 = f1Var;
                            if (zIsRemoving) {
                                f1 f1Var3 = new f1();
                                fragmentActivity.getSupportFragmentManager().beginTransaction().add(f1Var3, "SupportLifecycleFragmentImpl").commitAllowingStateLoss();
                                f1Var2 = f1Var3;
                            }
                            weakHashMap.put(fragmentActivity, new WeakReference<>(f1Var2));
                            jVar = f1Var2;
                        }
                    } catch (ClassCastException e) {
                        throw new IllegalStateException("Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", e);
                    }
                }
            }
        } else {
            WeakHashMap<Activity, WeakReference<d1>> weakHashMap2 = d1.j;
            WeakReference<d1> weakReference2 = weakHashMap2.get(activity);
            if (weakReference2 != null) {
                j jVar3 = (d1) weakReference2.get();
                jVar = jVar3;
                if (jVar3 == null) {
                    try {
                        d1 d1Var = (d1) activity.getFragmentManager().findFragmentByTag("LifecycleFragmentImpl");
                        if (d1Var != null) {
                            boolean zIsRemoving2 = d1Var.isRemoving();
                            j jVar4 = d1Var;
                            if (zIsRemoving2) {
                                d1 d1Var2 = new d1();
                                activity.getFragmentManager().beginTransaction().add(d1Var2, "LifecycleFragmentImpl").commitAllowingStateLoss();
                                jVar4 = d1Var2;
                            }
                            weakHashMap2.put(activity, new WeakReference<>(jVar4));
                            jVar = jVar4;
                        }
                    } catch (ClassCastException e2) {
                        throw new IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", e2);
                    }
                }
            }
        }
        return jVar;
    }

    @Keep
    private static j getChimeraLifecycleFragmentImpl(i iVar) {
        throw new IllegalStateException("Method not available in SDK.");
    }

    @MainThread
    public void a() {
    }

    @RecentlyNonNull
    public Activity b() {
        return this.j.e();
    }

    @MainThread
    public void d(int i, int i2, @RecentlyNonNull Intent intent) {
    }

    @MainThread
    public void e(@Nullable Bundle bundle) {
    }

    @MainThread
    public void f() {
    }

    @MainThread
    public void g() {
    }

    @MainThread
    public void h(@RecentlyNonNull Bundle bundle) {
    }

    @MainThread
    public void i() {
    }

    @MainThread
    public void j() {
    }
}
