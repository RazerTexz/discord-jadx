package com.discord.widgets.chat.list;

import com.discord.api.activity.Activity;
import com.discord.api.application.Application;
import com.discord.api.message.activity.MessageActivity;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.widgets.chat.list.ViewEmbedGameInvite;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function6;

/* compiled from: ViewEmbedGameInvite.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0001\u001a\u00020\u00002\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0016\u0010\f\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\n\u0012\u0004\u0012\u00020\u000b0\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0010\u0010\u0011"}, d2 = {"Lcom/discord/models/user/MeUser;", "p1", "", "Lcom/discord/primitives/Timestamp;", "p2", "Lcom/discord/api/message/activity/MessageActivity;", "p3", "Lcom/discord/api/activity/Activity;", "p4", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/user/User;", "p5", "Lcom/discord/api/application/Application;", "p6", "Lcom/discord/widgets/chat/list/ViewEmbedGameInvite$Model;", "invoke", "(Lcom/discord/models/user/MeUser;JLcom/discord/api/message/activity/MessageActivity;Lcom/discord/api/activity/Activity;Ljava/util/Map;Lcom/discord/api/application/Application;)Lcom/discord/widgets/chat/list/ViewEmbedGameInvite$Model;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.list.ViewEmbedGameInvite$Model$Companion$getForShare$1, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class ViewEmbedGameInvite3 extends FunctionReferenceImpl implements Function6<MeUser, Long, MessageActivity, Activity, Map<Long, ? extends User>, Application, ViewEmbedGameInvite.Model> {
    public ViewEmbedGameInvite3(ViewEmbedGameInvite.Model.Companion companion) {
        super(6, companion, ViewEmbedGameInvite.Model.Companion.class, "createForShare", "createForShare(Lcom/discord/models/user/MeUser;JLcom/discord/api/message/activity/MessageActivity;Lcom/discord/api/activity/Activity;Ljava/util/Map;Lcom/discord/api/application/Application;)Lcom/discord/widgets/chat/list/ViewEmbedGameInvite$Model;", 0);
    }

    @Override // kotlin.jvm.functions.Function6
    public /* bridge */ /* synthetic */ ViewEmbedGameInvite.Model invoke(MeUser meUser, Long l, MessageActivity messageActivity, Activity activity, Map<Long, ? extends User> map, Application application) {
        return invoke(meUser, l.longValue(), messageActivity, activity, map, application);
    }

    public final ViewEmbedGameInvite.Model invoke(MeUser meUser, long j, MessageActivity messageActivity, Activity activity, Map<Long, ? extends User> map, Application application) {
        Intrinsics3.checkNotNullParameter(meUser, "p1");
        Intrinsics3.checkNotNullParameter(messageActivity, "p3");
        Intrinsics3.checkNotNullParameter(map, "p5");
        return ViewEmbedGameInvite.Model.Companion.access$createForShare((ViewEmbedGameInvite.Model.Companion) this.receiver, meUser, j, messageActivity, activity, map, application);
    }
}
