package com.discord.widgets.user.profile;

import com.discord.widgets.user.Badge;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: UserProfileHeaderView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/user/Badge;", "it", "", "invoke", "(Lcom/discord/widgets/user/Badge;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.user.profile.UserProfileHeaderView$onBadgeClick$1, reason: use source file name */
/* loaded from: classes.dex */
public final class UserProfileHeaderView6 extends Lambda implements Function1<Badge, Unit> {
    public static final UserProfileHeaderView6 INSTANCE = new UserProfileHeaderView6();

    public UserProfileHeaderView6() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Badge badge) {
        invoke2(badge);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Badge badge) {
        Intrinsics3.checkNotNullParameter(badge, "it");
    }
}
