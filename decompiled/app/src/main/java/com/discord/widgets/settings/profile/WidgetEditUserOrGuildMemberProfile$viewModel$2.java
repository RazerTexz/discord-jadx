package com.discord.widgets.settings.profile;

import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetEditUserOrGuildMemberProfile.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/settings/profile/SettingsUserProfileViewModel;", "invoke", "()Lcom/discord/widgets/settings/profile/SettingsUserProfileViewModel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetEditUserOrGuildMemberProfile$viewModel$2 extends Lambda implements Function0<EditUserOrGuildMemberProfileViewModel2> {
    public final /* synthetic */ WidgetEditUserOrGuildMemberProfile this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetEditUserOrGuildMemberProfile$viewModel$2(WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile) {
        super(0);
        this.this$0 = widgetEditUserOrGuildMemberProfile;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ EditUserOrGuildMemberProfileViewModel2 invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final EditUserOrGuildMemberProfileViewModel2 invoke() {
        return new EditUserOrGuildMemberProfileViewModel2(WidgetEditUserOrGuildMemberProfile.access$getGuildId$p(this.this$0), null, null, null, null, null, null, 126, null);
    }
}
