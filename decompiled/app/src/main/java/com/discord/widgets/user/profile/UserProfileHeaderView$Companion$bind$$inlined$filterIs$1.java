package com.discord.widgets.user.profile;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.discord.widgets.user.profile.UserProfileHeaderViewModel;
import j0.k.Func1;
import kotlin.Metadata;

/* compiled from: ObservableExtensions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0010\b\u001a\n \u0002*\u0004\u0018\u00010\u00040\u0004\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Object;)Ljava/lang/Boolean;", "com/discord/utilities/rx/ObservableExtensionsKt$filterIs$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class UserProfileHeaderView$Companion$bind$$inlined$filterIs$1<T, R> implements Func1<Object, Boolean> {
    public static final UserProfileHeaderView$Companion$bind$$inlined$filterIs$1 INSTANCE = new UserProfileHeaderView$Companion$bind$$inlined$filterIs$1();

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // j0.k.Func1
    public final Boolean call(Object obj) {
        return Boolean.valueOf(obj instanceof UserProfileHeaderViewModel.ViewState.Loaded);
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Boolean call(Object obj) {
        return call(obj);
    }
}
