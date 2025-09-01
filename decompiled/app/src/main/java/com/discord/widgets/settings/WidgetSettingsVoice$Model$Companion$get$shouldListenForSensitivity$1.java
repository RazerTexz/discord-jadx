package com.discord.widgets.settings;

import androidx.core.app.NotificationCompat;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import rx.functions.Func2;

/* compiled from: WidgetSettingsVoice.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0006\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "userRequestedListenForSensitivity", "isNativeEngineInitialized", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Boolean;Ljava/lang/Boolean;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetSettingsVoice$Model$Companion$get$shouldListenForSensitivity$1<T1, T2, R> implements Func2<Boolean, Boolean, Boolean> {
    public static final WidgetSettingsVoice$Model$Companion$get$shouldListenForSensitivity$1 INSTANCE = new WidgetSettingsVoice$Model$Companion$get$shouldListenForSensitivity$1();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ Boolean call(Boolean bool, Boolean bool2) {
        return call2(bool, bool2);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /* renamed from: call, reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Boolean call2(Boolean bool, Boolean bool2) {
        boolean z2;
        Intrinsics3.checkNotNullExpressionValue(bool, "userRequestedListenForSensitivity");
        if (!bool.booleanValue()) {
            Intrinsics3.checkNotNullExpressionValue(bool2, "isNativeEngineInitialized");
            z2 = bool2.booleanValue();
        }
        return Boolean.valueOf(z2);
    }
}
