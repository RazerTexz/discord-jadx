package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.authentication.AuthState;
import j0.k.Func1;
import kotlin.Metadata;

/* compiled from: StoreAuthentication.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/authentication/AuthState;", "it", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/authentication/AuthState;)Ljava/lang/String;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.stores.StoreAuthentication$getAuthedToken$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreAuthentication2<T, R> implements Func1<AuthState, String> {
    public static final StoreAuthentication2 INSTANCE = new StoreAuthentication2();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ String call(AuthState authState) {
        return call2(authState);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final String call2(AuthState authState) {
        if (authState != null) {
            return authState.getToken();
        }
        return null;
    }
}
