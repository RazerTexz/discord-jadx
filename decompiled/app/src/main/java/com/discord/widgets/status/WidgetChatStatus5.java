package com.discord.widgets.status;

import androidx.core.app.NotificationCompat;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import kotlin.Metadata;

/* compiled from: WidgetChatStatus.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0005\u0010\u0005\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "kotlin.jvm.PlatformType", "it", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Boolean;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.status.WidgetChatStatus$Model$Companion$get$isUnreadValidObs$1$isLastAckOlderThanMostRecent$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatStatus5<T, R> implements Func1<Boolean, Boolean> {
    public static final WidgetChatStatus5 INSTANCE = new WidgetChatStatus5();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Boolean call(Boolean bool) {
        return call2(bool);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(Boolean bool) {
        return Boolean.valueOf(Intrinsics3.areEqual(bool, Boolean.FALSE));
    }
}
