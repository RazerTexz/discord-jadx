package com.discord.widgets.voice.fullscreen.grid;

import com.discord.stores.StoreVoiceParticipants;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* compiled from: PrivateCallBlurredGridView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;", "o1", "o2", "", "invoke", "(Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.voice.fullscreen.grid.PrivateCallBlurredGridView$configure$callUserOrderChanged$1, reason: use source file name */
/* loaded from: classes.dex */
public final class PrivateCallBlurredGridView2 extends Lambda implements Function2<StoreVoiceParticipants.VoiceUser, StoreVoiceParticipants.VoiceUser, Boolean> {
    public static final PrivateCallBlurredGridView2 INSTANCE = new PrivateCallBlurredGridView2();

    public PrivateCallBlurredGridView2() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Boolean invoke(StoreVoiceParticipants.VoiceUser voiceUser, StoreVoiceParticipants.VoiceUser voiceUser2) {
        return Boolean.valueOf(invoke2(voiceUser, voiceUser2));
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(StoreVoiceParticipants.VoiceUser voiceUser, StoreVoiceParticipants.VoiceUser voiceUser2) {
        Intrinsics3.checkNotNullParameter(voiceUser, "o1");
        Intrinsics3.checkNotNullParameter(voiceUser2, "o2");
        return voiceUser.getUser().getId() == voiceUser2.getUser().getId();
    }
}
