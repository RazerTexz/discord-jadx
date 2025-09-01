package com.discord.widgets.user.search;

import com.discord.models.member.GuildMember;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;

/* compiled from: WidgetGlobalSearchModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u000f\u001a\u00020\f2\u0016\u0010\u0004\u001a\u0012\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u00030\u00002\u0016\u0010\u0006\u001a\u0012\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u00050\u00002\u0016\u0010\b\u001a\u0012\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u00070\u00002&\u0010\u000b\u001a\"\u0012\b\u0012\u00060\u0001j\u0002`\t\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\n0\u00000\u0000¢\u0006\u0004\b\r\u0010\u000e"}, d2 = {"", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/user/User;", "p1", "Lcom/discord/models/presence/Presence;", "p2", "", "p3", "Lcom/discord/primitives/GuildId;", "Lcom/discord/models/member/GuildMember;", "p4", "Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$UsersContext;", "invoke", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$UsersContext;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* synthetic */ class WidgetGlobalSearchModel$Companion$get$usersContextObservable$1 extends FunctionReferenceImpl implements Function4<Map<Long, ? extends User>, Map<Long, ? extends Presence>, Map<Long, ? extends Integer>, Map<Long, ? extends Map<Long, ? extends GuildMember>>, WidgetGlobalSearchModel.UsersContext> {
    public static final WidgetGlobalSearchModel$Companion$get$usersContextObservable$1 INSTANCE = new WidgetGlobalSearchModel$Companion$get$usersContextObservable$1();

    public WidgetGlobalSearchModel$Companion$get$usersContextObservable$1() {
        super(4, WidgetGlobalSearchModel.UsersContext.class, "<init>", "<init>(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ WidgetGlobalSearchModel.UsersContext invoke(Map<Long, ? extends User> map, Map<Long, ? extends Presence> map2, Map<Long, ? extends Integer> map3, Map<Long, ? extends Map<Long, ? extends GuildMember>> map4) {
        return invoke2(map, (Map<Long, Presence>) map2, (Map<Long, Integer>) map3, (Map<Long, ? extends Map<Long, GuildMember>>) map4);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGlobalSearchModel.UsersContext invoke2(Map<Long, ? extends User> map, Map<Long, Presence> map2, Map<Long, Integer> map3, Map<Long, ? extends Map<Long, GuildMember>> map4) {
        Intrinsics3.checkNotNullParameter(map, "p1");
        Intrinsics3.checkNotNullParameter(map2, "p2");
        Intrinsics3.checkNotNullParameter(map3, "p3");
        Intrinsics3.checkNotNullParameter(map4, "p4");
        return new WidgetGlobalSearchModel.UsersContext(map, map2, map3, map4);
    }
}
