package com.discord.widgets.stage.model;

import com.discord.widgets.voice.fullscreen.stage.StageCallItem;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: StageCallModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/stage/StageCallItem$SpeakerItem;", "it", "", "invoke", "(Lcom/discord/widgets/voice/fullscreen/stage/StageCallItem$SpeakerItem;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.stage.model.StageCallModel$Companion$create$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class StageCallModel2 extends Lambda implements Function1<StageCallItem.SpeakerItem, Boolean> {
    public static final StageCallModel2 INSTANCE = new StageCallModel2();

    public StageCallModel2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(StageCallItem.SpeakerItem speakerItem) {
        return Boolean.valueOf(invoke2(speakerItem));
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(StageCallItem.SpeakerItem speakerItem) {
        Intrinsics3.checkNotNullParameter(speakerItem, "it");
        return speakerItem.getVoiceUser().getIsSpeaking() && !speakerItem.getVoiceUser().isMe();
    }
}
