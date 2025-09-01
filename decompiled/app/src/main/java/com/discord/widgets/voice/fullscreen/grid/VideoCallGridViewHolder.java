package com.discord.widgets.voice.fullscreen.grid;

import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.DisplayCutoutCompat;
import androidx.recyclerview.widget.RecyclerView;
import b.a.k.FormatUtils;
import b.a.y.PileView2;
import com.discord.R;
import com.discord.api.application.ApplicationAsset;
import com.discord.databinding.VideoCallGridItemEmbeddedActivityBinding;
import com.discord.models.guild.UserGuildMember;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.views.PileView;
import com.discord.views.calls.VideoCallParticipantView;
import com.discord.widgets.voice.fullscreen.CallParticipant;
import com.discord.widgets.voice.fullscreen.grid.VideoCallGridAdapter;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: VideoCallGridViewHolder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0006\u0007B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0001\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/grid/VideoCallGridViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "EmbeddedActivity", "UserOrStream", "Lcom/discord/widgets/voice/fullscreen/grid/VideoCallGridViewHolder$UserOrStream;", "Lcom/discord/widgets/voice/fullscreen/grid/VideoCallGridViewHolder$EmbeddedActivity;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public abstract class VideoCallGridViewHolder extends RecyclerView.ViewHolder {

    /* compiled from: VideoCallGridViewHolder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0012\u0010\u0013J)\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u000b\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/grid/VideoCallGridViewHolder$EmbeddedActivity;", "Lcom/discord/widgets/voice/fullscreen/grid/VideoCallGridViewHolder;", "Lcom/discord/widgets/voice/fullscreen/CallParticipant$EmbeddedActivityParticipant;", "callParticipant", "Lkotlin/Function1;", "Lcom/discord/widgets/voice/fullscreen/CallParticipant;", "", "onTapped", "configure", "(Lcom/discord/widgets/voice/fullscreen/CallParticipant$EmbeddedActivityParticipant;Lkotlin/jvm/functions/Function1;)V", "Lcom/discord/databinding/VideoCallGridItemEmbeddedActivityBinding;", "binding", "Lcom/discord/databinding/VideoCallGridItemEmbeddedActivityBinding;", "getBinding", "()Lcom/discord/databinding/VideoCallGridItemEmbeddedActivityBinding;", "Lcom/discord/utilities/images/MGImages$DistinctChangeDetector;", "distinctChangeDetector", "Lcom/discord/utilities/images/MGImages$DistinctChangeDetector;", "<init>", "(Lcom/discord/databinding/VideoCallGridItemEmbeddedActivityBinding;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class EmbeddedActivity extends VideoCallGridViewHolder {
        private final VideoCallGridItemEmbeddedActivityBinding binding;
        private final MGImages.DistinctChangeDetector distinctChangeDetector;

        /* JADX WARN: Illegal instructions before constructor call */
        public EmbeddedActivity(VideoCallGridItemEmbeddedActivityBinding videoCallGridItemEmbeddedActivityBinding) {
            Intrinsics3.checkNotNullParameter(videoCallGridItemEmbeddedActivityBinding, "binding");
            FrameLayout frameLayout = videoCallGridItemEmbeddedActivityBinding.a;
            Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.root");
            super(frameLayout, null);
            this.binding = videoCallGridItemEmbeddedActivityBinding;
            this.distinctChangeDetector = new MGImages.DistinctChangeDetector();
        }

        public final void configure(CallParticipant.EmbeddedActivityParticipant callParticipant, Function1<? super CallParticipant, Unit> onTapped) {
            Intrinsics3.checkNotNullParameter(callParticipant, "callParticipant");
            Intrinsics3.checkNotNullParameter(onTapped, "onTapped");
            ApplicationAsset backgroundAsset = callParticipant.getBackgroundAsset();
            String assetImage = backgroundAsset != null ? IconUtils.INSTANCE.getAssetImage(Long.valueOf(callParticipant.getApplication().getId()), String.valueOf(backgroundAsset.getId()), 1024) : null;
            SimpleDraweeView simpleDraweeView = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.appBackgroundImage");
            simpleDraweeView.setVisibility(assetImage != null ? 0 : 8);
            View view = this.binding.e;
            Intrinsics3.checkNotNullExpressionValue(view, "binding.appBackgroundOverlay");
            view.setVisibility(assetImage != null ? 0 : 8);
            if (assetImage != null) {
                MGImages mGImages = MGImages.INSTANCE;
                SimpleDraweeView simpleDraweeView2 = this.binding.d;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.appBackgroundImage");
                Uri uri = Uri.parse(assetImage);
                Intrinsics3.checkNotNullExpressionValue(uri, "Uri.parse(backgroundAssetUrl)");
                mGImages.setImage(simpleDraweeView2, uri, this.distinctChangeDetector);
            }
            this.binding.a.setOnClickListener(new VideoCallGridViewHolder2(onTapped, callParticipant));
            FrameLayout frameLayout = this.binding.a;
            Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.root");
            Resources resources = frameLayout.getResources();
            TextView textView = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.activityPreviewTitle");
            CharSequence name = callParticipant.getEmbeddedActivity().getName();
            if (name == null) {
                Intrinsics3.checkNotNullExpressionValue(resources, "resources");
                name = FormatUtils.i(resources, R.string.embedded_activities_unknown_activity_name, new Object[0], null, 4);
            }
            textView.setText(name);
            List<UserGuildMember> participantsInActivity = callParticipant.getParticipantsInActivity();
            int iDpToPixels = DimenUtils.dpToPixels(16);
            Intrinsics3.checkNotNullParameter(participantsInActivity, "userGuildMembers");
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(participantsInActivity, 10));
            for (UserGuildMember userGuildMember : participantsInActivity) {
                arrayList.add(IconUtils.INSTANCE.getForGuildMemberOrUser(userGuildMember.getUser(), userGuildMember.getGuildMember(), Integer.valueOf(iDpToPixels), false));
            }
            ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(new PileView.c(new PileView2((String) it.next()), null));
            }
            this.binding.f2169b.setItems(arrayList2);
        }

        public final VideoCallGridItemEmbeddedActivityBinding getBinding() {
            return this.binding;
        }
    }

    /* compiled from: VideoCallGridViewHolder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001f\u0010 J·\u0001\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0016\u0010\u000b\u001a\u0012\u0012\b\u0012\u00060\tj\u0002`\n\u0012\u0004\u0012\u00020\u00060\u00042\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u001e\u0010\u0014\u001a\u001a\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0004\u0012\u00020\u00060\u0010j\u0002`\u00132\u001e\u0010\u0015\u001a\u001a\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0004\u0012\u00020\u00060\u0010j\u0002`\u00132\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/grid/VideoCallGridViewHolder$UserOrStream;", "Lcom/discord/widgets/voice/fullscreen/grid/VideoCallGridViewHolder;", "Lcom/discord/widgets/voice/fullscreen/CallParticipant$UserOrStreamParticipant;", "callParticipant", "Lkotlin/Function1;", "Lcom/discord/widgets/voice/fullscreen/CallParticipant;", "", "onTapped", "onLongClicked", "", "Lcom/discord/primitives/StreamKey;", "onWatchStreamClicked", "Landroidx/core/view/DisplayCutoutCompat;", "displayCutout", "", "spanCount", "Lkotlin/Function2;", "Lcom/discord/views/calls/VideoCallParticipantView$StreamResolution;", "Lcom/discord/views/calls/VideoCallParticipantView$StreamFps;", "Lcom/discord/views/calls/StreamQualityCallback;", "onStreamQualityIndicatorShown", "onStreamQualityIndicatorClicked", "Lcom/discord/widgets/voice/fullscreen/grid/VideoCallGridAdapter$CallUiInsets;", "callUiInsets", "", "controlsVisible", "configure", "(Lcom/discord/widgets/voice/fullscreen/CallParticipant$UserOrStreamParticipant;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/core/view/DisplayCutoutCompat;ILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lcom/discord/widgets/voice/fullscreen/grid/VideoCallGridAdapter$CallUiInsets;Z)V", "Lcom/discord/views/calls/VideoCallParticipantView;", "videoCallParticipantView", "Lcom/discord/views/calls/VideoCallParticipantView;", "<init>", "(Lcom/discord/views/calls/VideoCallParticipantView;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class UserOrStream extends VideoCallGridViewHolder {
        private final VideoCallParticipantView videoCallParticipantView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UserOrStream(VideoCallParticipantView videoCallParticipantView) {
            super(videoCallParticipantView, null);
            Intrinsics3.checkNotNullParameter(videoCallParticipantView, "videoCallParticipantView");
            this.videoCallParticipantView = videoCallParticipantView;
        }

        public final void configure(CallParticipant.UserOrStreamParticipant callParticipant, Function1<? super CallParticipant, Unit> onTapped, Function1<? super CallParticipant, Unit> onLongClicked, Function1<? super String, Unit> onWatchStreamClicked, DisplayCutoutCompat displayCutout, int spanCount, Function2<? super VideoCallParticipantView.StreamResolution, ? super VideoCallParticipantView.StreamFps, Unit> onStreamQualityIndicatorShown, Function2<? super VideoCallParticipantView.StreamResolution, ? super VideoCallParticipantView.StreamFps, Unit> onStreamQualityIndicatorClicked, VideoCallGridAdapter.CallUiInsets callUiInsets, boolean controlsVisible) {
            Intrinsics3.checkNotNullParameter(callParticipant, "callParticipant");
            Intrinsics3.checkNotNullParameter(onTapped, "onTapped");
            Intrinsics3.checkNotNullParameter(onLongClicked, "onLongClicked");
            Intrinsics3.checkNotNullParameter(onWatchStreamClicked, "onWatchStreamClicked");
            Intrinsics3.checkNotNullParameter(onStreamQualityIndicatorShown, "onStreamQualityIndicatorShown");
            Intrinsics3.checkNotNullParameter(onStreamQualityIndicatorClicked, "onStreamQualityIndicatorClicked");
            Intrinsics3.checkNotNullParameter(callUiInsets, "callUiInsets");
            View view = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view, "itemView");
            Resources resources = view.getResources();
            Intrinsics3.checkNotNullExpressionValue(resources, "itemView.resources");
            this.videoCallParticipantView.c(callParticipant.getParticipantData(), displayCutout, resources.getConfiguration().orientation != 2 ? getAdapterPosition() < spanCount : getAdapterPosition() % spanCount == 0, callUiInsets, controlsVisible);
            this.videoCallParticipantView.setOnWatchStreamClicked(onWatchStreamClicked);
            this.videoCallParticipantView.setOnClickListener(new VideoCallGridViewHolder3(onTapped, callParticipant));
            ViewExtensions.setOnLongClickListenerConsumeClick(this.videoCallParticipantView, new VideoCallGridViewHolder4(onLongClicked, callParticipant));
            VideoCallParticipantView videoCallParticipantView = this.videoCallParticipantView;
            Objects.requireNonNull(videoCallParticipantView);
            Intrinsics3.checkNotNullParameter(onStreamQualityIndicatorShown, "onShown");
            Intrinsics3.checkNotNullParameter(onStreamQualityIndicatorClicked, "onClicked");
            videoCallParticipantView.onStreamQualityIndicatorShown = onStreamQualityIndicatorShown;
            videoCallParticipantView.onStreamQualityIndicatorClicked = onStreamQualityIndicatorClicked;
        }
    }

    private VideoCallGridViewHolder(View view) {
        super(view);
    }

    public /* synthetic */ VideoCallGridViewHolder(View view, DefaultConstructorMarker defaultConstructorMarker) {
        this(view);
    }
}
