package com.discord.widgets.settings.profile;

import android.text.Editable;
import com.discord.widgets.settings.profile.EditUserOrGuildMemberProfileViewModel2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetEditUserOrGuildMemberProfile.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroid/text/Editable;", "editable", "", "invoke", "(Landroid/text/Editable;)V", "com/discord/widgets/settings/profile/WidgetEditUserOrGuildMemberProfile$configureNick$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetEditUserOrGuildMemberProfile$configureNick$$inlined$also$lambda$1 extends Lambda implements Function1<Editable, Unit> {
    public final /* synthetic */ EditUserOrGuildMemberProfileViewModel2.ViewState.Loaded $viewState$inlined;
    public final /* synthetic */ WidgetEditUserOrGuildMemberProfile this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetEditUserOrGuildMemberProfile$configureNick$$inlined$also$lambda$1(WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile, EditUserOrGuildMemberProfileViewModel2.ViewState.Loaded loaded) {
        super(1);
        this.this$0 = widgetEditUserOrGuildMemberProfile;
        this.$viewState$inlined = loaded;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
        invoke2(editable);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Editable editable) {
        Intrinsics3.checkNotNullParameter(editable, "editable");
        WidgetEditUserOrGuildMemberProfile.access$getViewModel$p(this.this$0).updateNickname(editable.toString());
    }
}
