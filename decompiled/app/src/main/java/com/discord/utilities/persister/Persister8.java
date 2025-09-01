package com.discord.utilities.persister;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import j0.k.Func1;
import kotlin.Metadata;

/* compiled from: Persister.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\b\u001a\n \u0003*\u0004\u0018\u00010\u00050\u0005\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0016\u0010\u0004\u001a\u0012\u0012\u0002\b\u0003 \u0003*\b\u0012\u0002\b\u0003\u0018\u00010\u00020\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/discord/utilities/persister/Persister;", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/utilities/persister/Persister;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.persister.Persister$Preloader$isPreloaded$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class Persister8<T, R> implements Func1<Persister<?>, Boolean> {
    public static final Persister8 INSTANCE = new Persister8();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Boolean call(Persister<?> persister) {
        return call2(persister);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(Persister<?> persister) {
        return Boolean.valueOf(persister == null);
    }
}
