package com.discord.widgets.voice.fullscreen.stage;

import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.views.calls.VideoCallParticipantView;
import com.discord.widgets.user.usersheet.WidgetUserSheet;
import com.discord.widgets.voice.fullscreen.CallParticipant;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: StageCallAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 C2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001CB\u0097\u0001\u0012\u0006\u0010@\u001a\u00020?\u0012\u0006\u0010(\u001a\u00020'\u0012\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\b0!\u0012\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\b0!\u0012\u0016\u0010=\u001a\u0012\u0012\b\u0012\u00060;j\u0002`<\u0012\u0004\u0012\u00020\b0!\u0012\u001e\u00102\u001a\u001a\u0012\u0004\u0012\u00020+\u0012\u0006\u0012\u0004\u0018\u00010,\u0012\u0004\u0012\u00020\b0*j\u0002`-\u0012\u001e\u0010.\u001a\u001a\u0012\u0004\u0012\u00020+\u0012\u0006\u0012\u0004\u0018\u00010,\u0012\u0004\u0012\u00020\b0*j\u0002`-¢\u0006\u0004\bA\u0010BJ#\u0010\t\u001a\u00020\b2\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\f\u0010\rJ+\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0019\u001a\u00020\b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0011¢\u0006\u0004\b\u0019\u0010\u001aR\u0019\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010\u0018\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010 R%\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\b0!8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0016\u0010(\u001a\u00020'8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R1\u0010.\u001a\u001a\u0012\u0004\u0012\u00020+\u0012\u0006\u0012\u0004\u0018\u00010,\u0012\u0004\u0012\u00020\b0*j\u0002`-8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R1\u00102\u001a\u001a\u0012\u0004\u0012\u00020+\u0012\u0006\u0012\u0004\u0018\u00010,\u0012\u0004\u0012\u00020\b0*j\u0002`-8\u0006@\u0006¢\u0006\f\n\u0004\b2\u0010/\u001a\u0004\b3\u00101R%\u00104\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\b0!8\u0006@\u0006¢\u0006\f\n\u0004\b4\u0010$\u001a\u0004\b5\u0010&R\u0019\u00107\u001a\u0002068\u0006@\u0006¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R)\u0010=\u001a\u0012\u0012\b\u0012\u00060;j\u0002`<\u0012\u0004\u0012\u00020\b0!8\u0006@\u0006¢\u0006\f\n\u0004\b=\u0010$\u001a\u0004\b>\u0010&¨\u0006D"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/stage/StageCallAdapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerAdapterSimple;", "Lcom/discord/widgets/voice/fullscreen/stage/StageCallItem;", "", "Lcom/discord/primitives/UserId;", "userId", "Lcom/discord/api/channel/Channel;", "channel", "", "openWidgetUserSheet", "(JLcom/discord/api/channel/Channel;)V", "item", "onItemClick$app_productionGoogleRelease", "(Lcom/discord/widgets/voice/fullscreen/stage/StageCallItem;)V", "onItemClick", "Landroid/view/ViewGroup;", "parent", "", "viewType", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "", "data", "numSpeakers", "setData", "(Ljava/util/List;I)V", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "itemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getItemDecoration", "()Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "I", "Lkotlin/Function1;", "Lcom/discord/widgets/voice/fullscreen/CallParticipant$UserOrStreamParticipant;", "onMediaParticipantLongClicked", "Lkotlin/jvm/functions/Function1;", "getOnMediaParticipantLongClicked", "()Lkotlin/jvm/functions/Function1;", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "Lkotlin/Function2;", "Lcom/discord/views/calls/VideoCallParticipantView$StreamResolution;", "Lcom/discord/views/calls/VideoCallParticipantView$StreamFps;", "Lcom/discord/views/calls/StreamQualityCallback;", "onStreamQualityIndicatorClick", "Lkotlin/jvm/functions/Function2;", "getOnStreamQualityIndicatorClick", "()Lkotlin/jvm/functions/Function2;", "onStreamQualityIndicatorShown", "getOnStreamQualityIndicatorShown", "onMediaParticipantTapped", "getOnMediaParticipantTapped", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "spanSizeLookup", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "getSpanSizeLookup", "()Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "", "Lcom/discord/primitives/StreamKey;", "onWatchStreamClicked", "getOnWatchStreamClicked", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/fragment/app/FragmentManager;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class StageCallAdapter extends MGRecyclerAdapterSimple<StageCallItem> {
    public static final int AUDIENCE_SPAN_COUNT = 3;
    public static final int SPAN_COUNT = 12;
    public static final int SPEAKER_FULL_SPAN_COUNT = 12;
    public static final int SPEAKER_HALF_SPAN_COUNT = 6;
    public static final int SPEAKER_THIRD_SPAN_COUNT = 4;
    private final FragmentManager fragmentManager;
    private final RecyclerView.ItemDecoration itemDecoration;
    private int numSpeakers;
    private final Function1<CallParticipant.UserOrStreamParticipant, Unit> onMediaParticipantLongClicked;
    private final Function1<CallParticipant.UserOrStreamParticipant, Unit> onMediaParticipantTapped;
    private final Function2<VideoCallParticipantView.StreamResolution, VideoCallParticipantView.StreamFps, Unit> onStreamQualityIndicatorClick;
    private final Function2<VideoCallParticipantView.StreamResolution, VideoCallParticipantView.StreamFps, Unit> onStreamQualityIndicatorShown;
    private final Function1<String, Unit> onWatchStreamClicked;
    private final GridLayoutManager.SpanSizeLookup spanSizeLookup;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public StageCallAdapter(RecyclerView recyclerView, FragmentManager fragmentManager, Function1<? super CallParticipant.UserOrStreamParticipant, Unit> function1, Function1<? super CallParticipant.UserOrStreamParticipant, Unit> function12, Function1<? super String, Unit> function13, Function2<? super VideoCallParticipantView.StreamResolution, ? super VideoCallParticipantView.StreamFps, Unit> function2, Function2<? super VideoCallParticipantView.StreamResolution, ? super VideoCallParticipantView.StreamFps, Unit> function22) {
        super(recyclerView, false, 2, null);
        Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics3.checkNotNullParameter(function1, "onMediaParticipantTapped");
        Intrinsics3.checkNotNullParameter(function12, "onMediaParticipantLongClicked");
        Intrinsics3.checkNotNullParameter(function13, "onWatchStreamClicked");
        Intrinsics3.checkNotNullParameter(function2, "onStreamQualityIndicatorShown");
        Intrinsics3.checkNotNullParameter(function22, "onStreamQualityIndicatorClick");
        this.fragmentManager = fragmentManager;
        this.onMediaParticipantTapped = function1;
        this.onMediaParticipantLongClicked = function12;
        this.onWatchStreamClicked = function13;
        this.onStreamQualityIndicatorShown = function2;
        this.onStreamQualityIndicatorClick = function22;
        this.spanSizeLookup = new StageCallAdapter3(this);
        this.itemDecoration = new StageCallAdapter2(this);
    }

    public static final /* synthetic */ List access$getInternalData$p(StageCallAdapter stageCallAdapter) {
        return stageCallAdapter.getInternalData();
    }

    public static final /* synthetic */ int access$getNumSpeakers$p(StageCallAdapter stageCallAdapter) {
        return stageCallAdapter.numSpeakers;
    }

    public static final /* synthetic */ void access$setNumSpeakers$p(StageCallAdapter stageCallAdapter, int i) {
        stageCallAdapter.numSpeakers = i;
    }

    private final void openWidgetUserSheet(long userId, Channel channel) {
        WidgetUserSheet.Companion.show$default(WidgetUserSheet.INSTANCE, userId, Long.valueOf(channel.getId()), this.fragmentManager, Long.valueOf(channel.getGuildId()), Boolean.TRUE, null, null, 96, null);
    }

    public final RecyclerView.ItemDecoration getItemDecoration() {
        return this.itemDecoration;
    }

    public final Function1<CallParticipant.UserOrStreamParticipant, Unit> getOnMediaParticipantLongClicked() {
        return this.onMediaParticipantLongClicked;
    }

    public final Function1<CallParticipant.UserOrStreamParticipant, Unit> getOnMediaParticipantTapped() {
        return this.onMediaParticipantTapped;
    }

    public final Function2<VideoCallParticipantView.StreamResolution, VideoCallParticipantView.StreamFps, Unit> getOnStreamQualityIndicatorClick() {
        return this.onStreamQualityIndicatorClick;
    }

    public final Function2<VideoCallParticipantView.StreamResolution, VideoCallParticipantView.StreamFps, Unit> getOnStreamQualityIndicatorShown() {
        return this.onStreamQualityIndicatorShown;
    }

    public final Function1<String, Unit> getOnWatchStreamClicked() {
        return this.onWatchStreamClicked;
    }

    public final GridLayoutManager.SpanSizeLookup getSpanSizeLookup() {
        return this.spanSizeLookup;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onItemClick$app_productionGoogleRelease(StageCallItem item) {
        Intrinsics3.checkNotNullParameter(item, "item");
        if (item instanceof StageCallItem2) {
            StageCallItem2 stageCallItem2 = (StageCallItem2) item;
            openWidgetUserSheet(stageCallItem2.getVoiceUser().getUser().getId(), stageCallItem2.getChannel());
        }
    }

    public final void setData(List<? extends StageCallItem> data, int numSpeakers) {
        Intrinsics3.checkNotNullParameter(data, "data");
        this.numSpeakers = numSpeakers;
        super.setData(data);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<StageCallAdapter, StageCallItem> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        switch (viewType) {
            case 0:
                return new StageCallViewHolder4(this);
            case 1:
                return new StageCallViewHolder8(this);
            case 2:
                return new StageCallViewHolder2(this);
            case 3:
                return new StageCallViewHolder3(this);
            case 4:
                return new StageCallViewHolder5(this);
            case 5:
                return new StageCallViewHolder7(this);
            case 6:
                return new StageCallViewHolder6(this);
            default:
                throw new IllegalStateException(outline.q("Invalid view type: ", viewType));
        }
    }
}
