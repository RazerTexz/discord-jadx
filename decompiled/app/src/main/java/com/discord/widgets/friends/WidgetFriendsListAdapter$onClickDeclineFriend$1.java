package com.discord.widgets.friends;

import com.discord.models.user.User;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetFriendsListAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/discord/models/user/User;", "<anonymous parameter 0>", "", "Lcom/discord/primitives/RelationshipType;", "<anonymous parameter 1>", "", "invoke", "(Lcom/discord/models/user/User;I)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetFriendsListAdapter$onClickDeclineFriend$1 extends Lambda implements Function2<User, Integer, Unit> {
    public static final WidgetFriendsListAdapter$onClickDeclineFriend$1 INSTANCE = new WidgetFriendsListAdapter$onClickDeclineFriend$1();

    public WidgetFriendsListAdapter$onClickDeclineFriend$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(User user, Integer num) {
        invoke(user, num.intValue());
        return Unit.a;
    }

    public final void invoke(User user, int i) {
        Intrinsics3.checkNotNullParameter(user, "<anonymous parameter 0>");
    }
}
