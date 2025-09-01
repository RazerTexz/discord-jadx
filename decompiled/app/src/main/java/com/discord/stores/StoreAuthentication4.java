package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelInvite;
import j0.k.Func1;
import kotlin.Metadata;

/* compiled from: StoreAuthentication.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "Lcom/discord/models/domain/ModelInvite;", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Throwable;)Lcom/discord/models/domain/ModelInvite;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.stores.StoreAuthentication$login$1$1$invite$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreAuthentication4<T, R> implements Func1<Throwable, ModelInvite> {
    public static final StoreAuthentication4 INSTANCE = new StoreAuthentication4();

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final ModelInvite call2(Throwable th) {
        return null;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ ModelInvite call(Throwable th) {
        return call2(th);
    }
}
