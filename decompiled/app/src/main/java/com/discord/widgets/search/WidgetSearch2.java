package com.discord.widgets.search;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreSearch;
import com.discord.widgets.search.WidgetSearch;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import rx.functions.Func4;

/* compiled from: WidgetSearch.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\f\u001a\u0004\u0018\u00010\t2\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00042\u000e\u0010\b\u001a\n \u0005*\u0004\u0018\u00010\u00070\u0007H\n¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Lcom/discord/models/guild/Guild;", "guild", "Lcom/discord/api/channel/Channel;", "channel", "Lcom/discord/stores/StoreSearch$DisplayState;", "kotlin.jvm.PlatformType", "displayState", "", "isQueryValid", "Lcom/discord/widgets/search/WidgetSearch$Model;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/guild/Guild;Lcom/discord/api/channel/Channel;Lcom/discord/stores/StoreSearch$DisplayState;Ljava/lang/Boolean;)Lcom/discord/widgets/search/WidgetSearch$Model;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.search.WidgetSearch$Model$Companion$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetSearch2<T1, T2, T3, T4, R> implements Func4<Guild, Channel, StoreSearch.DisplayState, Boolean, WidgetSearch.Model> {
    public static final WidgetSearch2 INSTANCE = new WidgetSearch2();

    @Override // rx.functions.Func4
    public /* bridge */ /* synthetic */ WidgetSearch.Model call(Guild guild, Channel channel, StoreSearch.DisplayState displayState, Boolean bool) {
        return call2(guild, channel, displayState, bool);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetSearch.Model call2(Guild guild, Channel channel, StoreSearch.DisplayState displayState, Boolean bool) {
        if ((guild == null && channel == null) || displayState == null) {
            return null;
        }
        Intrinsics3.checkNotNullExpressionValue(bool, "isQueryValid");
        return new WidgetSearch.Model(guild, channel, displayState, bool.booleanValue());
    }
}
