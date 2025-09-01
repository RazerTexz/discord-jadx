package com.discord.stores;

import androidx.core.app.NotificationCompat;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import rx.functions.Func2;

/* compiled from: StoreUserSettings.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0006\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "allowAnimatedEmojis", "useReducedMotion", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Boolean;Ljava/lang/Boolean;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.stores.StoreUserSettings$observeIsAnimatedEmojisEnabled$1$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreUserSettings3<T1, T2, R> implements Func2<Boolean, Boolean, Boolean> {
    public static final StoreUserSettings3 INSTANCE = new StoreUserSettings3();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ Boolean call(Boolean bool, Boolean bool2) {
        return call2(bool, bool2);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(Boolean bool, Boolean bool2) {
        Intrinsics3.checkNotNullExpressionValue(bool, "allowAnimatedEmojis");
        return Boolean.valueOf(bool.booleanValue() && !bool2.booleanValue());
    }
}
