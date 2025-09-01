package com.discord.widgets.user.profile;

import com.discord.utilities.colors.RepresentativeColors2;
import com.discord.widgets.user.profile.UserProfileHeaderViewModel;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: UserProfileHeaderViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()Ljava/lang/String;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.user.profile.UserProfileHeaderViewModel$ViewState$Loaded$avatarColorId$2, reason: use source file name */
/* loaded from: classes.dex */
public final class UserProfileHeaderViewModel5 extends Lambda implements Function0<String> {
    public final /* synthetic */ UserProfileHeaderViewModel.ViewState.Loaded this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserProfileHeaderViewModel5(UserProfileHeaderViewModel.ViewState.Loaded loaded) {
        super(0);
        this.this$0 = loaded;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ String invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2() {
        return RepresentativeColors2.getColorId(this.this$0.getUser());
    }
}
