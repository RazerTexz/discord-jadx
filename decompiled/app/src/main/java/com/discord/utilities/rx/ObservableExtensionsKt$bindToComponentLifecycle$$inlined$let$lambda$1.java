package com.discord.utilities.rx;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.discord.app.AppComponent;
import j0.k.Func1;
import kotlin.Metadata;

/* compiled from: ObservableExtensions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0010\u0007\u001a\n \u0001*\u0004\u0018\u00010\u00030\u0003\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Object;)Ljava/lang/Boolean;", "com/discord/utilities/rx/ObservableExtensionsKt$bindToComponentLifecycle$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ObservableExtensionsKt$bindToComponentLifecycle$$inlined$let$lambda$1<T, R> implements Func1<T, Boolean> {
    public final /* synthetic */ AppComponent $appComponent$inlined;

    public ObservableExtensionsKt$bindToComponentLifecycle$$inlined$let$lambda$1(AppComponent appComponent) {
        this.$appComponent$inlined = appComponent;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // j0.k.Func1
    public final Boolean call(T t) {
        FragmentActivity activity;
        return Boolean.valueOf((!((Fragment) this.$appComponent$inlined).isAdded() || ((Fragment) this.$appComponent$inlined).isRemoving() || (activity = ((Fragment) this.$appComponent$inlined).getActivity()) == null || activity.isFinishing()) ? false : true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Boolean call(Object obj) {
        return call((ObservableExtensionsKt$bindToComponentLifecycle$$inlined$let$lambda$1<T, R>) obj);
    }
}
