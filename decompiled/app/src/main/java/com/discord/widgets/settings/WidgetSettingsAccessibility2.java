package com.discord.widgets.settings;

import androidx.core.app.NotificationCompat;
import com.discord.widgets.settings.WidgetSettingsAccessibility;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import rx.functions.Func4;

/* compiled from: WidgetSettingsAccessibility.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\n\u001a\n \u0001*\u0004\u0018\u00010\u00070\u00072\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"", "kotlin.jvm.PlatformType", "reducedMotionEnabled", "allowAnimatedEmoji", "autoPlayGifs", "", "currentStickerAnimationSettings", "Lcom/discord/widgets/settings/WidgetSettingsAccessibility$Model;", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;)Lcom/discord/widgets/settings/WidgetSettingsAccessibility$Model;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.settings.WidgetSettingsAccessibility$Model$Companion$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetSettingsAccessibility2<T1, T2, T3, T4, R> implements Func4<Boolean, Boolean, Boolean, Integer, WidgetSettingsAccessibility.Model> {
    public static final WidgetSettingsAccessibility2 INSTANCE = new WidgetSettingsAccessibility2();

    @Override // rx.functions.Func4
    public /* bridge */ /* synthetic */ WidgetSettingsAccessibility.Model call(Boolean bool, Boolean bool2, Boolean bool3, Integer num) {
        return call2(bool, bool2, bool3, num);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetSettingsAccessibility.Model call2(Boolean bool, Boolean bool2, Boolean bool3, Integer num) {
        Intrinsics3.checkNotNullExpressionValue(bool, "reducedMotionEnabled");
        boolean zBooleanValue = bool.booleanValue();
        Intrinsics3.checkNotNullExpressionValue(bool2, "allowAnimatedEmoji");
        boolean zBooleanValue2 = bool2.booleanValue();
        Intrinsics3.checkNotNullExpressionValue(bool3, "autoPlayGifs");
        boolean zBooleanValue3 = bool3.booleanValue();
        Intrinsics3.checkNotNullExpressionValue(num, "currentStickerAnimationSettings");
        return new WidgetSettingsAccessibility.Model(zBooleanValue, zBooleanValue2, zBooleanValue3, num.intValue());
    }
}
