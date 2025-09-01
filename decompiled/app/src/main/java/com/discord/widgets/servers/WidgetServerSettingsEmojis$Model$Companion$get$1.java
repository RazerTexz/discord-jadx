package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import com.discord.widgets.servers.WidgetServerSettingsEmojis;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import kotlin.Metadata;
import rx.Observable;

/* compiled from: WidgetServerSettingsEmojis.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u001e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0003 \u0004*\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsEmojis$Model$Permission;", "permission", "Lrx/Observable;", "Lcom/discord/widgets/servers/WidgetServerSettingsEmojis$Model;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/widgets/servers/WidgetServerSettingsEmojis$Model$Permission;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetServerSettingsEmojis$Model$Companion$get$1<T, R> implements Func1<WidgetServerSettingsEmojis.Model.Permission, Observable<? extends WidgetServerSettingsEmojis.Model>> {
    public static final WidgetServerSettingsEmojis$Model$Companion$get$1 INSTANCE = new WidgetServerSettingsEmojis$Model$Companion$get$1();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetServerSettingsEmojis.Model> call(WidgetServerSettingsEmojis.Model.Permission permission) {
        return call2(permission);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetServerSettingsEmojis.Model> call2(WidgetServerSettingsEmojis.Model.Permission permission) {
        return (permission == null || !permission.getCanManage()) ? new ScalarSynchronousObservable(null) : WidgetServerSettingsEmojis.Model.Companion.access$getGuildEmojis(WidgetServerSettingsEmojis.Model.INSTANCE, permission.getGuild());
    }
}
