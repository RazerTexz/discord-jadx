package com.discord.widgets.channels.invite;

import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: GroupInviteFriendsSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/channels/invite/GroupInviteFriendsSheetViewModel;", "invoke", "()Lcom/discord/widgets/channels/invite/GroupInviteFriendsSheetViewModel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.invite.GroupInviteFriendsSheet$viewModel$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class GroupInviteFriendsSheet3 extends Lambda implements Function0<GroupInviteFriendsSheetViewModel> {
    public final /* synthetic */ GroupInviteFriendsSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupInviteFriendsSheet3(GroupInviteFriendsSheet groupInviteFriendsSheet) {
        super(0);
        this.this$0 = groupInviteFriendsSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ GroupInviteFriendsSheetViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GroupInviteFriendsSheetViewModel invoke() {
        return new GroupInviteFriendsSheetViewModel(this.this$0.requireArguments().getLong("com.discord.intent.extra.EXTRA_CHANNEL_ID", -1L), null, 0, null, 14, null);
    }
}
