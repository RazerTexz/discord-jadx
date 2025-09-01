package com.discord.widgets.stage.model;

import com.discord.stores.StoreVoiceParticipants;
import com.discord.widgets.voice.fullscreen.stage.StageCallItem;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: StageCallModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/stage/StageCallItem$SpeakerItem;", "it", "Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;", "invoke", "(Lcom/discord/widgets/voice/fullscreen/stage/StageCallItem$SpeakerItem;)Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.stage.model.StageCallModel$Companion$create$3, reason: use source file name */
/* loaded from: classes2.dex */
public final class StageCallModel3 extends Lambda implements Function1<StageCallItem.SpeakerItem, StoreVoiceParticipants.VoiceUser> {
    public static final StageCallModel3 INSTANCE = new StageCallModel3();

    public StageCallModel3() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ StoreVoiceParticipants.VoiceUser invoke(StageCallItem.SpeakerItem speakerItem) {
        return invoke2(speakerItem);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final StoreVoiceParticipants.VoiceUser invoke2(StageCallItem.SpeakerItem speakerItem) {
        Intrinsics3.checkNotNullParameter(speakerItem, "it");
        return speakerItem.getVoiceUser();
    }
}
