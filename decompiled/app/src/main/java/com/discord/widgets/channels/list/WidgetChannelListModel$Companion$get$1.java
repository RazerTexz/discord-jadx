package com.discord.widgets.channels.list;

import androidx.core.app.NotificationCompat;
import com.discord.widgets.channels.list.WidgetChannelListModel;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import kotlin.Metadata;
import rx.Observable;

/* compiled from: WidgetChannelListModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a*\u0012\u000e\b\u0001\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005 \u0002*\u0014\u0012\u000e\b\u0001\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00040\u00042\u0018\u0010\u0003\u001a\u0014 \u0002*\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00010\u0000j\u0002`\u0001H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Lcom/discord/primitives/GuildId;", "kotlin.jvm.PlatformType", "guildId", "Lrx/Observable;", "Lcom/discord/widgets/channels/list/WidgetChannelListModel;", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Long;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChannelListModel$Companion$get$1<T, R> implements Func1<Long, Observable<? extends WidgetChannelListModel>> {
    public static final WidgetChannelListModel$Companion$get$1 INSTANCE = new WidgetChannelListModel$Companion$get$1();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetChannelListModel> call(Long l) {
        return call2(l);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetChannelListModel> call2(Long l) {
        if (l != null && l.longValue() == 0) {
            return WidgetChannelListModel.Companion.access$getPrivateChannelList(WidgetChannelListModel.INSTANCE);
        }
        WidgetChannelListModel.Companion companion = WidgetChannelListModel.INSTANCE;
        Intrinsics3.checkNotNullExpressionValue(l, "guildId");
        return WidgetChannelListModel.Companion.access$getSelectedGuildChannelList(companion, l.longValue());
    }
}
