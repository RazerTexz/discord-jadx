package com.discord.widgets.voice.sheet;

import com.discord.utilities.streams.StreamContext;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetVoiceBottomSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/streams/StreamContext;", "it", "", "invoke", "(Lcom/discord/utilities/streams/StreamContext;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$onStreamPreviewClickedListener$1, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetVoiceBottomSheet6 extends Lambda implements Function1<StreamContext, Unit> {
    public static final WidgetVoiceBottomSheet6 INSTANCE = new WidgetVoiceBottomSheet6();

    public WidgetVoiceBottomSheet6() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StreamContext streamContext) {
        invoke2(streamContext);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StreamContext streamContext) {
        Intrinsics3.checkNotNullParameter(streamContext, "it");
    }
}
