package com.discord.stores;

import androidx.core.app.NotificationCompat;
import j0.k.Func1;
import kotlin.Metadata;

/* compiled from: StoreAuthentication.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0005\u0010\u0005\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "kotlin.jvm.PlatformType", "isLoggedIn", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Boolean;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.stores.StoreAuthentication$getPreLogoutSignal$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreAuthentication3<T, R> implements Func1<Boolean, Boolean> {
    public static final StoreAuthentication3 INSTANCE = new StoreAuthentication3();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Boolean call(Boolean bool) {
        return call2(bool);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(Boolean bool) {
        return Boolean.valueOf(!bool.booleanValue());
    }
}
