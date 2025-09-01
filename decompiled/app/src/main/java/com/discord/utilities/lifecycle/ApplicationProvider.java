package com.discord.utilities.lifecycle;

import android.app.Application;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ApplicationProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0003\u0010\t¨\u0006\f"}, d2 = {"Lcom/discord/utilities/lifecycle/ApplicationProvider;", "", "Landroid/app/Application;", "application", "", "init", "(Landroid/app/Application;)V", "get", "()Landroid/app/Application;", "Landroid/app/Application;", "<init>", "()V", "utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ApplicationProvider {
    public static final ApplicationProvider INSTANCE = new ApplicationProvider();
    private static Application application;

    private ApplicationProvider() {
    }

    public final Application get() {
        Application application2 = application;
        if (application2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("application");
        }
        return application2;
    }

    public final void init(Application application2) {
        Intrinsics3.checkNotNullParameter(application2, "application");
        application = application2;
    }
}
