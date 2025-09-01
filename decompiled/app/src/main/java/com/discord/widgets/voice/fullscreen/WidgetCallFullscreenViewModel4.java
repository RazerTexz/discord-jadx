package com.discord.widgets.voice.fullscreen;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.widgets.voice.fullscreen.CallParticipant;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreenViewModel;
import d0.z.d.Lambda;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetCallFullscreenViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()Ljava/lang/String;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallFullscreenViewModel$ViewState$Valid$titleText$2, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetCallFullscreenViewModel4 extends Lambda implements Function0<String> {
    public final /* synthetic */ WidgetCallFullscreenViewModel.ViewState.Valid this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCallFullscreenViewModel4(WidgetCallFullscreenViewModel.ViewState.Valid valid) {
        super(0);
        this.this$0 = valid;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ String invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2() {
        Channel channel = this.this$0.getCallModel().getChannel();
        if (ChannelUtils.D(channel) || this.this$0.getActiveEvent() != null) {
            return null;
        }
        String strC = ChannelUtils.c(channel);
        if (this.this$0.getCallModel().isStreaming() || this.this$0.getVisibleVideoParticipants().size() != 1 || !ChannelUtils.B(channel) || !(this.this$0.getVisibleVideoParticipants().get(0) instanceof CallParticipant.UserOrStreamParticipant)) {
            return strC;
        }
        CallParticipant callParticipant = this.this$0.getVisibleVideoParticipants().get(0);
        Objects.requireNonNull(callParticipant, "null cannot be cast to non-null type com.discord.widgets.voice.fullscreen.CallParticipant.UserOrStreamParticipant");
        return ((CallParticipant.UserOrStreamParticipant) callParticipant).getParticipantData().voiceParticipant.getDisplayName();
    }
}
