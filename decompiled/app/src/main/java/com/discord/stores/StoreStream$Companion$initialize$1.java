package com.discord.stores;

import com.discord.models.authentication.AuthState;
import com.discord.stores.StoreStream;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: StoreStream.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()Ljava/lang/String;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreStream$Companion$initialize$1 extends Lambda implements Function0<String> {
    public static final StoreStream$Companion$initialize$1 INSTANCE = new StoreStream$Companion$initialize$1();

    public StoreStream$Companion$initialize$1() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ String invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2() {
        AuthState authState = StoreStream.Companion.access$getCollector$p(StoreStream.INSTANCE).getAuthentication().getAuthState();
        if (authState != null) {
            return authState.getToken();
        }
        return null;
    }
}
