package com.discord.widgets.voice.fullscreen;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.stores.StoreVoiceParticipants;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

/* compiled from: WidgetCallFullscreen.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tR(\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"com/discord/widgets/voice/fullscreen/WidgetCallFullscreen$stageSpeakerPillManagingScrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", "", "Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;", "activeSpeakers", "Ljava/util/List;", "getActiveSpeakers", "()Ljava/util/List;", "setActiveSpeakers", "(Ljava/util/List;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetCallFullscreen$stageSpeakerPillManagingScrollListener$1 extends RecyclerView.OnScrollListener {
    private List<StoreVoiceParticipants.VoiceUser> activeSpeakers = Collections2.emptyList();
    public final /* synthetic */ WidgetCallFullscreen this$0;

    public WidgetCallFullscreen$stageSpeakerPillManagingScrollListener$1(WidgetCallFullscreen widgetCallFullscreen) {
        this.this$0 = widgetCallFullscreen;
    }

    public final List<StoreVoiceParticipants.VoiceUser> getActiveSpeakers() {
        return this.activeSpeakers;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
        List<StoreVoiceParticipants.VoiceUser> list = this.activeSpeakers;
        boolean z2 = true;
        if ((list instanceof Collection) && list.isEmpty()) {
            z2 = false;
        } else {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (!WidgetCallFullscreen.access$isStageUserVisible(this.this$0, ((StoreVoiceParticipants.VoiceUser) it.next()).getUser().getId())) {
                    break;
                }
            }
            z2 = false;
        }
        ConstraintLayout constraintLayout = WidgetCallFullscreen.access$getBinding$p(this.this$0).t;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.stageCallSpeakingChip");
        constraintLayout.setVisibility(z2 ? 0 : 8);
    }

    public final void setActiveSpeakers(List<StoreVoiceParticipants.VoiceUser> list) {
        Intrinsics3.checkNotNullParameter(list, "<set-?>");
        this.activeSpeakers = list;
    }
}
