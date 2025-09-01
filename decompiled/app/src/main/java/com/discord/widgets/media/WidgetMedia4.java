package com.discord.widgets.media;

import com.discord.player.AppMediaPlayer;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetMedia.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/discord/player/AppMediaPlayer$Event;", "event", "", "invoke", "(Lcom/discord/player/AppMediaPlayer$Event;)V", "com/discord/widgets/media/WidgetMedia$onViewBoundOrOnResume$2$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.media.WidgetMedia$onViewBoundOrOnResume$$inlined$let$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetMedia4 extends Lambda implements Function1<AppMediaPlayer.Event, Unit> {
    public final /* synthetic */ WidgetMedia this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetMedia4(WidgetMedia widgetMedia) {
        super(1);
        this.this$0 = widgetMedia;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(AppMediaPlayer.Event event) {
        invoke2(event);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(AppMediaPlayer.Event event) {
        Intrinsics3.checkNotNullParameter(event, "event");
        WidgetMedia.access$handlePlayerEvent(this.this$0, event);
    }
}
