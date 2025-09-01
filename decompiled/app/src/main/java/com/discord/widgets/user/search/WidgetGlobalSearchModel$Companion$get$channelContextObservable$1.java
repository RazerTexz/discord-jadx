package com.discord.widgets.user.search;

import com.discord.api.channel.Channel;
import com.discord.models.guild.Guild;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function8;

/* compiled from: WidgetGlobalSearchModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0014\u001a\u00020\u00112\u0016\u0010\u0004\u001a\u0012\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u00030\u00002\u0016\u0010\u0007\u001a\u0012\u0012\b\u0012\u00060\u0001j\u0002`\u0005\u0012\u0004\u0012\u00020\u00060\u00002\u0016\u0010\b\u001a\u0012\u0012\b\u0012\u00060\u0001j\u0002`\u0005\u0012\u0004\u0012\u00020\u00060\u00002\u001a\u0010\n\u001a\u0016\u0012\b\u0012\u00060\u0001j\u0002`\u0005\u0012\b\u0012\u00060\u0001j\u0002`\t0\u00002\u0016\u0010\u000b\u001a\u0012\u0012\b\u0012\u00060\u0001j\u0002`\u0005\u0012\u0004\u0012\u00020\u00060\u00002 \u0010\r\u001a\u001c\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0001j\u0002`\u00050\f0\u00002\u0010\u0010\u000f\u001a\f\u0012\b\u0012\u00060\u0001j\u0002`\u00050\u000e2\u0010\u0010\u0010\u001a\f\u0012\b\u0012\u00060\u0001j\u0002`\u00020\u000e¢\u0006\u0004\b\u0012\u0010\u0013"}, d2 = {"", "", "Lcom/discord/primitives/GuildId;", "Lcom/discord/models/guild/Guild;", "p1", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/channel/Channel;", "p2", "p3", "Lcom/discord/api/permission/PermissionBit;", "p4", "p5", "", "p6", "", "p7", "p8", "Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$ChannelContext;", "invoke", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Set;Ljava/util/Set;)Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$ChannelContext;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* synthetic */ class WidgetGlobalSearchModel$Companion$get$channelContextObservable$1 extends FunctionReferenceImpl implements Function8<Map<Long, ? extends Guild>, Map<Long, ? extends Channel>, Map<Long, ? extends Channel>, Map<Long, ? extends Long>, Map<Long, ? extends Channel>, Map<Long, ? extends List<? extends Long>>, Set<? extends Long>, Set<? extends Long>, WidgetGlobalSearchModel.ChannelContext> {
    public static final WidgetGlobalSearchModel$Companion$get$channelContextObservable$1 INSTANCE = new WidgetGlobalSearchModel$Companion$get$channelContextObservable$1();

    public WidgetGlobalSearchModel$Companion$get$channelContextObservable$1() {
        super(8, WidgetGlobalSearchModel.ChannelContext.class, "<init>", "<init>(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Set;Ljava/util/Set;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function8
    public /* bridge */ /* synthetic */ WidgetGlobalSearchModel.ChannelContext invoke(Map<Long, ? extends Guild> map, Map<Long, ? extends Channel> map2, Map<Long, ? extends Channel> map3, Map<Long, ? extends Long> map4, Map<Long, ? extends Channel> map5, Map<Long, ? extends List<? extends Long>> map6, Set<? extends Long> set, Set<? extends Long> set2) {
        return invoke2((Map<Long, Guild>) map, (Map<Long, Channel>) map2, (Map<Long, Channel>) map3, (Map<Long, Long>) map4, (Map<Long, Channel>) map5, (Map<Long, ? extends List<Long>>) map6, (Set<Long>) set, (Set<Long>) set2);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGlobalSearchModel.ChannelContext invoke2(Map<Long, Guild> map, Map<Long, Channel> map2, Map<Long, Channel> map3, Map<Long, Long> map4, Map<Long, Channel> map5, Map<Long, ? extends List<Long>> map6, Set<Long> set, Set<Long> set2) {
        Intrinsics3.checkNotNullParameter(map, "p1");
        Intrinsics3.checkNotNullParameter(map2, "p2");
        Intrinsics3.checkNotNullParameter(map3, "p3");
        Intrinsics3.checkNotNullParameter(map4, "p4");
        Intrinsics3.checkNotNullParameter(map5, "p5");
        Intrinsics3.checkNotNullParameter(map6, "p6");
        Intrinsics3.checkNotNullParameter(set, "p7");
        Intrinsics3.checkNotNullParameter(set2, "p8");
        return new WidgetGlobalSearchModel.ChannelContext(map, map2, map3, map4, map5, map6, set, set2);
    }
}
