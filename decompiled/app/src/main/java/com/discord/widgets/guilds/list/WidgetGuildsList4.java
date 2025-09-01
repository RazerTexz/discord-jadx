package com.discord.widgets.guilds.list;

import androidx.core.app.NotificationCompat;
import com.discord.widgets.guilds.list.WidgetGuildsList;
import j0.k.Func1;
import kotlin.Metadata;

/* compiled from: WidgetGuildsList.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "Lcom/discord/widgets/guilds/list/WidgetGuildsList$AddGuildHint;", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Throwable;)Lcom/discord/widgets/guilds/list/WidgetGuildsList$AddGuildHint;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guilds.list.WidgetGuildsList$AddGuildHint$Companion$get$3, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGuildsList4<T, R> implements Func1<Throwable, WidgetGuildsList.AddGuildHint> {
    public static final WidgetGuildsList4 INSTANCE = new WidgetGuildsList4();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ WidgetGuildsList.AddGuildHint call(Throwable th) {
        return call2(th);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetGuildsList.AddGuildHint call2(Throwable th) {
        return new WidgetGuildsList.AddGuildHint(false, false, 2, null);
    }
}
