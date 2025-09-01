package y.a.a;

import android.os.IBinder;
import androidx.browser.customtabs.CustomTabsService;
import androidx.browser.customtabs.CustomTabsSessionToken;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements IBinder.DeathRecipient {
    public final /* synthetic */ CustomTabsService.AnonymousClass1 a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CustomTabsSessionToken f3856b;

    public /* synthetic */ a(CustomTabsService.AnonymousClass1 anonymousClass1, CustomTabsSessionToken customTabsSessionToken) {
        this.a = anonymousClass1;
        this.f3856b = customTabsSessionToken;
    }

    @Override // android.os.IBinder.DeathRecipient
    public final void binderDied() {
        CustomTabsService.AnonymousClass1 anonymousClass1 = this.a;
        CustomTabsService.this.cleanUpSession(this.f3856b);
    }
}
