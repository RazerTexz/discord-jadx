package com.discord.utilities.intent;

import d0.d0._Ranges;
import d0.t.MapsJVM;
import d0.z.d.Lambda;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: StaticChannelRoutes.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "", "Lcom/discord/utilities/intent/StaticChannelRoutes;", "invoke", "()Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.intent.StaticChannelRoutes$Companion$routeToName$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class StaticChannelRoutes2 extends Lambda implements Function0<Map<String, ? extends StaticChannelRoutes>> {
    public static final StaticChannelRoutes2 INSTANCE = new StaticChannelRoutes2();

    public StaticChannelRoutes2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Map<String, ? extends StaticChannelRoutes> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Map<String, ? extends StaticChannelRoutes> invoke2() {
        StaticChannelRoutes[] staticChannelRoutesArrValues = StaticChannelRoutes.values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(1), 16));
        for (int i = 0; i < 1; i++) {
            StaticChannelRoutes staticChannelRoutes = staticChannelRoutesArrValues[i];
            linkedHashMap.put(staticChannelRoutes.getRoute(), staticChannelRoutes);
        }
        return linkedHashMap;
    }
}
