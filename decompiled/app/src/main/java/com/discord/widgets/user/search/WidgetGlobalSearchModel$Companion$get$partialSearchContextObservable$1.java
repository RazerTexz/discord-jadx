package com.discord.widgets.user.search;

import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function7;

/* compiled from: WidgetGlobalSearchModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0001\u001a\u00020\u00002\u0010\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u00022\n\u0010\u0007\u001a\u00060\u0003j\u0002`\u00062\n\u0010\b\u001a\u00060\u0003j\u0002`\u00062\n\u0010\t\u001a\u00060\u0003j\u0002`\u00062\u001a\u0010\f\u001a\u0016\u0012\b\u0012\u00060\u0003j\u0002`\u0006\u0012\b\u0012\u00060\u0003j\u0002`\u000b0\n2\u0016\u0010\u000e\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0006\u0012\u0004\u0012\u00020\r0\n¢\u0006\u0004\b\u0010\u0010\u0011"}, d2 = {"", "p1", "", "", "Lcom/discord/primitives/GuildId;", "p2", "Lcom/discord/primitives/ChannelId;", "p3", "p4", "p5", "", "Lcom/discord/primitives/MessageId;", "p6", "", "p7", "Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$SearchContext;", "invoke", "(Ljava/lang/String;Ljava/util/List;JJJLjava/util/Map;Ljava/util/Map;)Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$SearchContext;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* synthetic */ class WidgetGlobalSearchModel$Companion$get$partialSearchContextObservable$1 extends FunctionReferenceImpl implements Function7<String, List<? extends Long>, Long, Long, Long, Map<Long, ? extends Long>, Map<Long, ? extends Integer>, WidgetGlobalSearchModel.SearchContext> {
    public static final WidgetGlobalSearchModel$Companion$get$partialSearchContextObservable$1 INSTANCE = new WidgetGlobalSearchModel$Companion$get$partialSearchContextObservable$1();

    public WidgetGlobalSearchModel$Companion$get$partialSearchContextObservable$1() {
        super(7, WidgetGlobalSearchModel.SearchContext.class, "<init>", "<init>(Ljava/lang/String;Ljava/util/List;JJJLjava/util/Map;Ljava/util/Map;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function7
    public /* bridge */ /* synthetic */ WidgetGlobalSearchModel.SearchContext invoke(String str, List<? extends Long> list, Long l, Long l2, Long l3, Map<Long, ? extends Long> map, Map<Long, ? extends Integer> map2) {
        return invoke(str, (List<Long>) list, l.longValue(), l2.longValue(), l3.longValue(), (Map<Long, Long>) map, (Map<Long, Integer>) map2);
    }

    public final WidgetGlobalSearchModel.SearchContext invoke(String str, List<Long> list, long j, long j2, long j3, Map<Long, Long> map, Map<Long, Integer> map2) {
        Intrinsics3.checkNotNullParameter(str, "p1");
        Intrinsics3.checkNotNullParameter(list, "p2");
        Intrinsics3.checkNotNullParameter(map, "p6");
        Intrinsics3.checkNotNullParameter(map2, "p7");
        return new WidgetGlobalSearchModel.SearchContext(str, list, j, j2, j3, map, map2);
    }
}
