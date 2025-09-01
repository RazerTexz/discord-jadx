package com.discord.widgets.stage.sheet;

import android.view.View;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheetAdapter;
import kotlin.Metadata;

/* compiled from: WidgetStageRaisedHandsBottomSheetAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "com/discord/widgets/stage/sheet/WidgetStageRaisedHandsBottomSheetAdapter$ViewHolderParticipant$onConfigure$2$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheetAdapter$ViewHolderParticipant$onConfigure$$inlined$apply$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetStageRaisedHandsBottomSheetAdapter2 implements View.OnClickListener {
    public final /* synthetic */ StoreVoiceParticipants.VoiceUser $participant$inlined;
    public final /* synthetic */ WidgetStageRaisedHandsBottomSheetAdapter.ViewHolderParticipant this$0;

    public WidgetStageRaisedHandsBottomSheetAdapter2(WidgetStageRaisedHandsBottomSheetAdapter.ViewHolderParticipant viewHolderParticipant, StoreVoiceParticipants.VoiceUser voiceUser) {
        this.this$0 = viewHolderParticipant;
        this.$participant$inlined = voiceUser;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetStageRaisedHandsBottomSheetAdapter.ViewHolderParticipant.access$getAdapter$p(this.this$0).getOnInviteToSpeak().invoke(this.$participant$inlined);
    }
}
