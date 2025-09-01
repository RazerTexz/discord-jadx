package com.discord.widgets.voice.fullscreen;

import androidx.recyclerview.widget.RecyclerView;
import com.discord.widgets.voice.fullscreen.grid.VideoCallGridLayoutManager;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetCallFullscreen.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/grid/VideoCallGridLayoutManager;", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView$State;", "<anonymous parameter 1>", "", "invoke", "(Lcom/discord/widgets/voice/fullscreen/grid/VideoCallGridLayoutManager;Landroidx/recyclerview/widget/RecyclerView$State;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetCallFullscreen$setUpGridRecycler$layoutManager$2 extends Lambda implements Function2<VideoCallGridLayoutManager, RecyclerView.State, Unit> {
    public final /* synthetic */ WidgetCallFullscreen this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCallFullscreen$setUpGridRecycler$layoutManager$2(WidgetCallFullscreen widgetCallFullscreen) {
        super(2);
        this.this$0 = widgetCallFullscreen;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(VideoCallGridLayoutManager videoCallGridLayoutManager, RecyclerView.State state) {
        invoke2(videoCallGridLayoutManager, state);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(VideoCallGridLayoutManager videoCallGridLayoutManager, RecyclerView.State state) {
        Intrinsics3.checkNotNullParameter(videoCallGridLayoutManager, "layoutManager");
        if (WidgetCallFullscreen.access$getHasVideoCallGridChildrenChanged$p(this.this$0)) {
            WidgetCallFullscreen.access$setHasVideoCallGridChildrenChanged$p(this.this$0, false);
            WidgetCallFullscreen.access$getViewModel$p(this.this$0).updateOffScreenParticipantsFromScroll(WidgetCallFullscreen.access$getVisibleParticipants(this.this$0, videoCallGridLayoutManager));
        }
    }
}
