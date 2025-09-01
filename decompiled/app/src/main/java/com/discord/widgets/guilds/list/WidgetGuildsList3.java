package com.discord.widgets.guilds.list;

import androidx.core.app.NotificationCompat;
import com.discord.widgets.guilds.list.WidgetGuildsList;
import j0.k.Func1;
import kotlin.Metadata;

/* compiled from: WidgetGuildsList.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/widgets/guilds/list/WidgetGuildsList$AddGuildHint;", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/widgets/guilds/list/WidgetGuildsList$AddGuildHint;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guilds.list.WidgetGuildsList$AddGuildHint$Companion$get$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGuildsList3<T, R> implements Func1<WidgetGuildsList.AddGuildHint, Boolean> {
    public static final WidgetGuildsList3 INSTANCE = new WidgetGuildsList3();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Boolean call(WidgetGuildsList.AddGuildHint addGuildHint) {
        return call2(addGuildHint);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(WidgetGuildsList.AddGuildHint addGuildHint) {
        return Boolean.valueOf(addGuildHint.isEligible());
    }
}
