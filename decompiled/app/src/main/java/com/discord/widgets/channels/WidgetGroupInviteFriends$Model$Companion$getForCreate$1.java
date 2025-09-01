package com.discord.widgets.channels;

import com.discord.models.user.User;
import com.discord.widgets.channels.WidgetGroupInviteFriends;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetGroupInviteFriends.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Lcom/discord/models/user/User;", "p1", "", "p2", "Lcom/discord/widgets/channels/WidgetGroupInviteFriends$Model$Companion$AddedUsersInput;", "invoke", "(Ljava/util/Collection;Ljava/lang/String;)Lcom/discord/widgets/channels/WidgetGroupInviteFriends$Model$Companion$AddedUsersInput;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetGroupInviteFriends$Model$Companion$getForCreate$1 extends FunctionReferenceImpl implements Function2<Collection<? extends User>, String, WidgetGroupInviteFriends.Model.Companion.AddedUsersInput> {
    public static final WidgetGroupInviteFriends$Model$Companion$getForCreate$1 INSTANCE = new WidgetGroupInviteFriends$Model$Companion$getForCreate$1();

    public WidgetGroupInviteFriends$Model$Companion$getForCreate$1() {
        super(2, WidgetGroupInviteFriends.Model.Companion.AddedUsersInput.class, "<init>", "<init>(Ljava/util/Collection;Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ WidgetGroupInviteFriends.Model.Companion.AddedUsersInput invoke(Collection<? extends User> collection, String str) {
        return invoke2(collection, str);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGroupInviteFriends.Model.Companion.AddedUsersInput invoke2(Collection<? extends User> collection, String str) {
        Intrinsics3.checkNotNullParameter(collection, "p1");
        Intrinsics3.checkNotNullParameter(str, "p2");
        return new WidgetGroupInviteFriends.Model.Companion.AddedUsersInput(collection, str);
    }
}
