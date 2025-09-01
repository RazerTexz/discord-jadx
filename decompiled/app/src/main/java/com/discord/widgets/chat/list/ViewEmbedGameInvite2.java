package com.discord.widgets.chat.list;

import com.discord.api.activity.Activity;
import com.discord.api.application.Application;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.widgets.chat.list.ViewEmbedGameInvite;
import com.discord.widgets.chat.list.entries.GameInviteEntry;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function5;

/* compiled from: ViewEmbedGameInvite.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0016\u0010\f\u001a\u0012\u0012\b\u0012\u00060\tj\u0002`\n\u0012\u0004\u0012\u00020\u000b0\b¢\u0006\u0004\b\u000e\u0010\u000f"}, d2 = {"Lcom/discord/widgets/chat/list/entries/GameInviteEntry;", "p1", "Lcom/discord/models/user/MeUser;", "p2", "Lcom/discord/api/application/Application;", "p3", "Lcom/discord/api/activity/Activity;", "p4", "", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/user/User;", "p5", "Lcom/discord/widgets/chat/list/ViewEmbedGameInvite$Model;", "invoke", "(Lcom/discord/widgets/chat/list/entries/GameInviteEntry;Lcom/discord/models/user/MeUser;Lcom/discord/api/application/Application;Lcom/discord/api/activity/Activity;Ljava/util/Map;)Lcom/discord/widgets/chat/list/ViewEmbedGameInvite$Model;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.list.ViewEmbedGameInvite$Model$Companion$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class ViewEmbedGameInvite2 extends FunctionReferenceImpl implements Function5<GameInviteEntry, MeUser, Application, Activity, Map<Long, ? extends User>, ViewEmbedGameInvite.Model> {
    public ViewEmbedGameInvite2(ViewEmbedGameInvite.Model.Companion companion) {
        super(5, companion, ViewEmbedGameInvite.Model.Companion.class, "create", "create(Lcom/discord/widgets/chat/list/entries/GameInviteEntry;Lcom/discord/models/user/MeUser;Lcom/discord/api/application/Application;Lcom/discord/api/activity/Activity;Ljava/util/Map;)Lcom/discord/widgets/chat/list/ViewEmbedGameInvite$Model;", 0);
    }

    @Override // kotlin.jvm.functions.Function5
    public /* bridge */ /* synthetic */ ViewEmbedGameInvite.Model invoke(GameInviteEntry gameInviteEntry, MeUser meUser, Application application, Activity activity, Map<Long, ? extends User> map) {
        return invoke2(gameInviteEntry, meUser, application, activity, map);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final ViewEmbedGameInvite.Model invoke2(GameInviteEntry gameInviteEntry, MeUser meUser, Application application, Activity activity, Map<Long, ? extends User> map) {
        Intrinsics3.checkNotNullParameter(gameInviteEntry, "p1");
        Intrinsics3.checkNotNullParameter(meUser, "p2");
        Intrinsics3.checkNotNullParameter(map, "p5");
        return ViewEmbedGameInvite.Model.Companion.access$create((ViewEmbedGameInvite.Model.Companion) this.receiver, gameInviteEntry, meUser, application, activity, map);
    }
}
