package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import com.discord.widgets.servers.WidgetServerSettingsBans;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import kotlin.Metadata;
import rx.Observable;

/* compiled from: WidgetServerSettingsBans.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u001e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0004 \u0001*\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "kotlin.jvm.PlatformType", "canManage", "Lrx/Observable;", "Lcom/discord/widgets/servers/WidgetServerSettingsBans$Model;", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Boolean;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.WidgetServerSettingsBans$Model$Companion$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsBans3<T, R> implements Func1<Boolean, Observable<? extends WidgetServerSettingsBans.Model>> {
    public final /* synthetic */ Observable $filterPublisher;
    public final /* synthetic */ long $guildId;

    public WidgetServerSettingsBans3(long j, Observable observable) {
        this.$guildId = j;
        this.$filterPublisher = observable;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetServerSettingsBans.Model> call(Boolean bool) {
        return call2(bool);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetServerSettingsBans.Model> call2(Boolean bool) {
        Intrinsics3.checkNotNullExpressionValue(bool, "canManage");
        return bool.booleanValue() ? WidgetServerSettingsBans.Model.Companion.access$getBanItems(WidgetServerSettingsBans.Model.INSTANCE, this.$guildId, this.$filterPublisher) : new ScalarSynchronousObservable(null);
    }
}
