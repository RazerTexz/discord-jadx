package com.discord.stores;

import androidx.core.app.NotificationCompat;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import rx.functions.Func2;

/* compiled from: StoreUserSettings.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0010\u0007\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "kotlin.jvm.PlatformType", "stickerAnimationSettings", "", "useReducedMotion", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Integer;Ljava/lang/Boolean;)Ljava/lang/Integer;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.stores.StoreUserSettings$observeStickerAnimationSettings$1$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreUserSettings5<T1, T2, R> implements Func2<Integer, Boolean, Integer> {
    public static final StoreUserSettings5 INSTANCE = new StoreUserSettings5();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ Integer call(Integer num, Boolean bool) {
        return call2(num, bool);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Integer call2(Integer num, Boolean bool) {
        if (num == null || num.intValue() != 0) {
            return num;
        }
        Intrinsics3.checkNotNullExpressionValue(bool, "useReducedMotion");
        if (bool.booleanValue()) {
            return 1;
        }
        return num;
    }
}
