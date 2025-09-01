package com.discord.utilities.persister;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import j0.k.Func1;
import kotlin.Metadata;

/* compiled from: Persister.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0010\u0007\u001a\n \u0003*\u0004\u0018\u00010\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u00002\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "", "kotlin.jvm.PlatformType", "persist", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Boolean;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.persister.Persister$Companion$init$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class Persister2<T, R> implements Func1<Boolean, Boolean> {
    public static final Persister2 INSTANCE = new Persister2();

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(Boolean bool) {
        return bool;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Boolean call(Boolean bool) {
        return call2(bool);
    }
}
