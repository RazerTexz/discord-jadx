package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelInvite;
import j0.k.Func1;
import kotlin.Metadata;

/* compiled from: StoreInviteSettings.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/models/domain/ModelInvite;", "it", "", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/domain/ModelInvite;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.stores.StoreInviteSettings$trackWithInvite$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreInviteSettings2<T, R> implements Func1<ModelInvite, Boolean> {
    public static final StoreInviteSettings2 INSTANCE = new StoreInviteSettings2();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Boolean call(ModelInvite modelInvite) {
        return call2(modelInvite);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(ModelInvite modelInvite) {
        return Boolean.valueOf(modelInvite != null);
    }
}
