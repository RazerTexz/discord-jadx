package com.discord.utilities.fcm;

import com.discord.app.AppLog;
import com.discord.utilities.logging.Logger;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: NotificationClient.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", "invoke", "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.fcm.NotificationClient$tokenCallback$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class NotificationClient2 extends Lambda implements Function1<String, Unit> {
    public static final NotificationClient2 INSTANCE = new NotificationClient2();

    public NotificationClient2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        AppLog appLog = AppLog.g;
        String simpleName = NotificationClient.INSTANCE.getClass().getSimpleName();
        Intrinsics3.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
        Logger.w$default(appLog, simpleName, "FCM token was not sent to server", null, 4, null);
    }
}
