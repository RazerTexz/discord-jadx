package com.discord.widgets.user.profile;

import com.discord.widgets.user.profile.UserProfileHeaderViewModel;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: UserProfileHeaderView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/user/profile/UserProfileHeaderViewModel$ViewState$Loaded;", "p1", "", "invoke", "(Lcom/discord/widgets/user/profile/UserProfileHeaderViewModel$ViewState$Loaded;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.user.profile.UserProfileHeaderView$Companion$bind$1, reason: use source file name */
/* loaded from: classes.dex */
public final /* synthetic */ class UserProfileHeaderView3 extends FunctionReferenceImpl implements Function1<UserProfileHeaderViewModel.ViewState.Loaded, Unit> {
    public UserProfileHeaderView3(UserProfileHeaderView userProfileHeaderView) {
        super(1, userProfileHeaderView, UserProfileHeaderView.class, "updateViewState", "updateViewState(Lcom/discord/widgets/user/profile/UserProfileHeaderViewModel$ViewState$Loaded;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(UserProfileHeaderViewModel.ViewState.Loaded loaded) {
        invoke2(loaded);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(UserProfileHeaderViewModel.ViewState.Loaded loaded) {
        Intrinsics3.checkNotNullParameter(loaded, "p1");
        ((UserProfileHeaderView) this.receiver).updateViewState(loaded);
    }
}
