package com.discord.widgets.voice.fullscreen.stage;

import android.view.View;
import androidx.cardview.widget.CardView;
import com.discord.R;
import com.discord.databinding.WidgetStageChannelSpeakerMediaBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.views.calls.VideoCallParticipantView;
import com.discord.widgets.voice.fullscreen.grid.VideoCallGridAdapter;
import com.discord.widgets.voice.fullscreen.stage.StageCallItem;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: StageCallViewHolder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/stage/MediaViewHolder;", "Lcom/discord/widgets/voice/fullscreen/stage/StageCallViewHolder;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "Lcom/discord/widgets/voice/fullscreen/stage/StageCallItem;", "data", "", "onConfigure", "(ILcom/discord/widgets/voice/fullscreen/stage/StageCallItem;)V", "Lcom/discord/databinding/WidgetStageChannelSpeakerMediaBinding;", "binding", "Lcom/discord/databinding/WidgetStageChannelSpeakerMediaBinding;", "Lcom/discord/widgets/voice/fullscreen/stage/StageCallAdapter;", "adapter", "<init>", "(Lcom/discord/widgets/voice/fullscreen/stage/StageCallAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.voice.fullscreen.stage.MediaViewHolder, reason: use source file name */
/* loaded from: classes.dex */
public final class StageCallViewHolder6 extends StageCallViewHolder {
    private final WidgetStageChannelSpeakerMediaBinding binding;

    /* compiled from: StageCallViewHolder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.fullscreen.stage.MediaViewHolder$onConfigure$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ StageCallItem.MediaItem $item;

        public AnonymousClass1(StageCallItem.MediaItem mediaItem) {
            this.$item = mediaItem;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            StageCallViewHolder6.access$getAdapter$p(StageCallViewHolder6.this).getOnMediaParticipantTapped().invoke(this.$item.getUserOrStreamParticipant());
        }
    }

    /* compiled from: StageCallViewHolder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.fullscreen.stage.MediaViewHolder$onConfigure$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ StageCallItem.MediaItem $item;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(StageCallItem.MediaItem mediaItem) {
            super(1);
            this.$item = mediaItem;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            StageCallViewHolder6.access$getAdapter$p(StageCallViewHolder6.this).getOnMediaParticipantLongClicked().invoke(this.$item.getUserOrStreamParticipant());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StageCallViewHolder6(StageCallAdapter stageCallAdapter) {
        super(R.layout.widget_stage_channel_speaker_media, stageCallAdapter, null);
        Intrinsics3.checkNotNullParameter(stageCallAdapter, "adapter");
        View view = this.itemView;
        VideoCallParticipantView videoCallParticipantView = (VideoCallParticipantView) view.findViewById(R.id.stage_channel_media_speaker_container);
        if (videoCallParticipantView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.stage_channel_media_speaker_container)));
        }
        WidgetStageChannelSpeakerMediaBinding widgetStageChannelSpeakerMediaBinding = new WidgetStageChannelSpeakerMediaBinding((CardView) view, videoCallParticipantView);
        Intrinsics3.checkNotNullExpressionValue(widgetStageChannelSpeakerMediaBinding, "WidgetStageChannelSpeake…diaBinding.bind(itemView)");
        this.binding = widgetStageChannelSpeakerMediaBinding;
    }

    public static final /* synthetic */ StageCallAdapter access$getAdapter$p(StageCallViewHolder6 stageCallViewHolder6) {
        return (StageCallAdapter) stageCallViewHolder6.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, StageCallItem stageCallItem) {
        onConfigure2(i, stageCallItem);
    }

    /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, StageCallItem data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, (int) data);
        StageCallItem.MediaItem mediaItem = (StageCallItem.MediaItem) data;
        VideoCallParticipantView videoCallParticipantView = this.binding.f2655b;
        Intrinsics3.checkNotNullExpressionValue(videoCallParticipantView, "binding.stageChannelMediaSpeakerContainer");
        videoCallParticipantView.c(mediaItem.getParticipantData(), null, false, new VideoCallGridAdapter.CallUiInsets(0, 0, 0, 0), true);
        videoCallParticipantView.setOnWatchStreamClicked(((StageCallAdapter) this.adapter).getOnWatchStreamClicked());
        videoCallParticipantView.setOnClickListener(new AnonymousClass1(mediaItem));
        ViewExtensions.setOnLongClickListenerConsumeClick(videoCallParticipantView, new AnonymousClass2(mediaItem));
        Function2<VideoCallParticipantView.StreamResolution, VideoCallParticipantView.StreamFps, Unit> onStreamQualityIndicatorShown = ((StageCallAdapter) this.adapter).getOnStreamQualityIndicatorShown();
        Function2<VideoCallParticipantView.StreamResolution, VideoCallParticipantView.StreamFps, Unit> onStreamQualityIndicatorClick = ((StageCallAdapter) this.adapter).getOnStreamQualityIndicatorClick();
        Intrinsics3.checkNotNullParameter(onStreamQualityIndicatorShown, "onShown");
        Intrinsics3.checkNotNullParameter(onStreamQualityIndicatorClick, "onClicked");
        videoCallParticipantView.onStreamQualityIndicatorShown = onStreamQualityIndicatorShown;
        videoCallParticipantView.onStreamQualityIndicatorClicked = onStreamQualityIndicatorClick;
    }
}
