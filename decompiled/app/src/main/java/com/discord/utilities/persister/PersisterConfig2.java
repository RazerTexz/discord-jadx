package com.discord.utilities.persister;

import androidx.core.app.NotificationCompat;
import j0.k.Func1;
import kotlin.Metadata;

/* compiled from: PersisterConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Long;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.persister.PersisterConfig$persistenceStrategy$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class PersisterConfig2<T, R> implements Func1<Long, Boolean> {
    public static final PersisterConfig2 INSTANCE = new PersisterConfig2();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Boolean call(Long l) {
        return call2(l);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(Long l) {
        return Boolean.TRUE;
    }
}
