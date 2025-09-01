package com.discord.widgets.stage.sheet;

import com.discord.stores.StoreVoiceParticipants;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetStageRaisedHandsBottomSheetAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;", "it", "", "invoke", "(Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheetAdapter$onViewProfile$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetStageRaisedHandsBottomSheetAdapter7 extends Lambda implements Function1<StoreVoiceParticipants.VoiceUser, Unit> {
    public static final WidgetStageRaisedHandsBottomSheetAdapter7 INSTANCE = new WidgetStageRaisedHandsBottomSheetAdapter7();

    public WidgetStageRaisedHandsBottomSheetAdapter7() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StoreVoiceParticipants.VoiceUser voiceUser) {
        invoke2(voiceUser);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StoreVoiceParticipants.VoiceUser voiceUser) {
        Intrinsics3.checkNotNullParameter(voiceUser, "it");
    }
}
