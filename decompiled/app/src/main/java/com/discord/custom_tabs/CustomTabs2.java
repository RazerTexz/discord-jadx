package com.discord.custom_tabs;

import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.view.DefaultLifecycleObserver;
import androidx.view.LifecycleOwner;
import b.a.h.CustomTabsPackages;
import b.a.h.CustomTabsPackages2;
import b.a.h.CustomTabsService2;
import d0.t._Arrays;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;
import y.c.DefaultLifecycleObserver2;

/* compiled from: CustomTabs.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"com/discord/custom_tabs/CustomTabs$warmUp$1", "Landroidx/lifecycle/DefaultLifecycleObserver;", "Landroidx/lifecycle/LifecycleOwner;", "owner", "", "onResume", "(Landroidx/lifecycle/LifecycleOwner;)V", "onPause", "Landroidx/browser/customtabs/CustomTabsServiceConnection;", "j", "Landroidx/browser/customtabs/CustomTabsServiceConnection;", "connection", "custom_tabs_release"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.custom_tabs.CustomTabs$warmUp$1, reason: use source file name */
/* loaded from: classes.dex */
public final class CustomTabs2 implements DefaultLifecycleObserver {

    /* renamed from: j, reason: from kotlin metadata */
    public CustomTabsServiceConnection connection;

    @Override // androidx.view.DefaultLifecycleObserver, androidx.view.FullLifecycleObserver
    public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver2.a(this, lifecycleOwner);
    }

    @Override // androidx.view.DefaultLifecycleObserver, androidx.view.FullLifecycleObserver
    public /* synthetic */ void onDestroy(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver2.b(this, lifecycleOwner);
    }

    @Override // androidx.view.DefaultLifecycleObserver, androidx.view.FullLifecycleObserver
    public void onPause(LifecycleOwner owner) {
        Intrinsics3.checkNotNullParameter(owner, "owner");
        DefaultLifecycleObserver2.c(this, owner);
        if (this.connection != null) {
            throw null;
        }
        this.connection = null;
    }

    @Override // androidx.view.DefaultLifecycleObserver, androidx.view.FullLifecycleObserver
    public void onResume(LifecycleOwner owner) {
        Intrinsics3.checkNotNullParameter(owner, "owner");
        DefaultLifecycleObserver2.d(this, owner);
        CustomTabsService2 customTabsService2 = null;
        List list = _Arrays.toList((Object[]) null);
        Intrinsics3.checkNotNullParameter(null, "context");
        Intrinsics3.checkNotNullParameter(list, "uris");
        String strA = CustomTabsPackages2.a.a(null, CustomTabsPackages.j);
        if (strA != null) {
            CustomTabsService2 customTabsService22 = new CustomTabsService2(list);
            if (CustomTabsClient.bindCustomTabsService(null, strA, customTabsService22)) {
                customTabsService2 = customTabsService22;
            }
        }
        this.connection = customTabsService2;
    }

    @Override // androidx.view.DefaultLifecycleObserver, androidx.view.FullLifecycleObserver
    public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver2.e(this, lifecycleOwner);
    }

    @Override // androidx.view.DefaultLifecycleObserver, androidx.view.FullLifecycleObserver
    public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver2.f(this, lifecycleOwner);
    }
}
