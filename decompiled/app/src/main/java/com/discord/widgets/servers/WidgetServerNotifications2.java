package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelNotificationSettings;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import java.util.List;
import kotlin.Metadata;

/* compiled from: WidgetServerNotifications.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\u0010\b\u001a&\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004 \u0001*\u0012\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00050\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/discord/models/domain/ModelNotificationSettings;", "kotlin.jvm.PlatformType", "it", "", "Lcom/discord/models/domain/ModelNotificationSettings$ChannelOverride;", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/domain/ModelNotificationSettings;)Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.WidgetServerNotifications$Companion$getNotificationOverrides$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerNotifications2<T, R> implements Func1<ModelNotificationSettings, List<ModelNotificationSettings.ChannelOverride>> {
    public static final WidgetServerNotifications2 INSTANCE = new WidgetServerNotifications2();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ List<ModelNotificationSettings.ChannelOverride> call(ModelNotificationSettings modelNotificationSettings) {
        return call2(modelNotificationSettings);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final List<ModelNotificationSettings.ChannelOverride> call2(ModelNotificationSettings modelNotificationSettings) {
        Intrinsics3.checkNotNullExpressionValue(modelNotificationSettings, "it");
        return modelNotificationSettings.getChannelOverrides();
    }
}
