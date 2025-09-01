package com.discord.widgets.tabs;

import androidx.core.app.NotificationCompat;
import com.discord.models.guild.Guild;
import com.discord.panels.PanelState;
import com.discord.widgets.tabs.TabsHostViewModel;
import d0.z.d.Intrinsics3;
import java.util.Map;
import kotlin.Metadata;
import rx.functions.Func6;

/* compiled from: TabsHostViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0013\u001a\n \u0001*\u0004\u0018\u00010\u00100\u00102\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u0018\u0010\u0007\u001a\u0014 \u0001*\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00060\u0005j\u0002`\u00062.\u0010\u000b\u001a*\u0012\b\u0012\u00060\u0005j\u0002`\t\u0012\u0004\u0012\u00020\n \u0001*\u0014\u0012\b\u0012\u00060\u0005j\u0002`\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b0\b2\u000e\u0010\r\u001a\n \u0001*\u0004\u0018\u00010\f0\f26\u0010\u000f\u001a2\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\b\u0012\u00060\fj\u0002`\u000e \u0001*\u0018\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\b\u0012\u00060\fj\u0002`\u000e\u0018\u00010\b0\bH\n¢\u0006\u0004\b\u0011\u0010\u0012"}, d2 = {"Lcom/discord/panels/PanelState;", "kotlin.jvm.PlatformType", "leftPanelState", "Lcom/discord/widgets/tabs/NavigationTab;", "selectedTab", "", "Lcom/discord/primitives/UserId;", "myUserId", "", "Lcom/discord/primitives/GuildId;", "Lcom/discord/models/guild/Guild;", "guildIdToGuildMap", "", "numTotalMentions", "Lcom/discord/primitives/RelationshipType;", "userRelationships", "Lcom/discord/widgets/tabs/TabsHostViewModel$StoreState;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/panels/PanelState;Lcom/discord/widgets/tabs/NavigationTab;Ljava/lang/Long;Ljava/util/Map;Ljava/lang/Integer;Ljava/util/Map;)Lcom/discord/widgets/tabs/TabsHostViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.tabs.TabsHostViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes.dex */
public final class TabsHostViewModel2<T1, T2, T3, T4, T5, T6, R> implements Func6<PanelState, NavigationTab, Long, Map<Long, ? extends Guild>, Integer, Map<Long, ? extends Integer>, TabsHostViewModel.StoreState> {
    public static final TabsHostViewModel2 INSTANCE = new TabsHostViewModel2();

    @Override // rx.functions.Func6
    public /* bridge */ /* synthetic */ TabsHostViewModel.StoreState call(PanelState panelState, NavigationTab navigationTab, Long l, Map<Long, ? extends Guild> map, Integer num, Map<Long, ? extends Integer> map2) {
        return call2(panelState, navigationTab, l, (Map<Long, Guild>) map, num, (Map<Long, Integer>) map2);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final TabsHostViewModel.StoreState call2(PanelState panelState, NavigationTab navigationTab, Long l, Map<Long, Guild> map, Integer num, Map<Long, Integer> map2) {
        Intrinsics3.checkNotNullExpressionValue(panelState, "leftPanelState");
        Intrinsics3.checkNotNullExpressionValue(navigationTab, "selectedTab");
        Intrinsics3.checkNotNullExpressionValue(l, "myUserId");
        long jLongValue = l.longValue();
        Intrinsics3.checkNotNullExpressionValue(map, "guildIdToGuildMap");
        Intrinsics3.checkNotNullExpressionValue(num, "numTotalMentions");
        int iIntValue = num.intValue();
        Intrinsics3.checkNotNullExpressionValue(map2, "userRelationships");
        return new TabsHostViewModel.StoreState(panelState, navigationTab, jLongValue, map, iIntValue, map2);
    }
}
