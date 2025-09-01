package com.discord.widgets.voice.controls;

import android.view.View;
import com.discord.widgets.stage.StageRoles;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: VoiceControlsSheetView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "com/discord/widgets/voice/controls/VoiceControlsSheetView$configureMoveToAudienceButton$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.voice.controls.VoiceControlsSheetView$configureMoveToAudienceButton$$inlined$apply$lambda$1, reason: use source file name */
/* loaded from: classes.dex */
public final class VoiceControlsSheetView2 implements View.OnClickListener {
    public final /* synthetic */ Function0 $onMoveToAudienceClick$inlined;
    public final /* synthetic */ StageRoles $stageRoles$inlined;
    public final /* synthetic */ VoiceControlsSheetView this$0;

    public VoiceControlsSheetView2(VoiceControlsSheetView voiceControlsSheetView, StageRoles stageRoles, Function0 function0) {
        this.this$0 = voiceControlsSheetView;
        this.$stageRoles$inlined = stageRoles;
        this.$onMoveToAudienceClick$inlined = function0;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.$onMoveToAudienceClick$inlined.invoke();
    }
}
