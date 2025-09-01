package com.discord.widgets.voice.fullscreen.stage;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.a.y.j0.StageCallSpeakerView2;
import b.a.y.j0.StageCallSpeakerView3;
import b.a.y.j0.StageCallSpeakerView4;
import com.discord.R;
import com.discord.databinding.WidgetStageChannelSpeakerBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.colors.RepresentativeColors2;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.views.calls.StageCallSpeakerView;
import com.discord.widgets.voice.fullscreen.stage.StageCallItem;
import d0.z.d.Intrinsics3;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Subscription;

/* compiled from: StageCallViewHolder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/stage/SpeakerViewHolder;", "Lcom/discord/widgets/voice/fullscreen/stage/StageCallViewHolder;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "Lcom/discord/widgets/voice/fullscreen/stage/StageCallItem;", "data", "", "onConfigure", "(ILcom/discord/widgets/voice/fullscreen/stage/StageCallItem;)V", "Lcom/discord/databinding/WidgetStageChannelSpeakerBinding;", "binding", "Lcom/discord/databinding/WidgetStageChannelSpeakerBinding;", "Lcom/discord/widgets/voice/fullscreen/stage/StageCallAdapter;", "adapter", "<init>", "(Lcom/discord/widgets/voice/fullscreen/stage/StageCallAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.voice.fullscreen.stage.SpeakerViewHolder, reason: use source file name */
/* loaded from: classes.dex */
public final class StageCallViewHolder8 extends StageCallViewHolder {
    private final WidgetStageChannelSpeakerBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StageCallViewHolder8(StageCallAdapter stageCallAdapter) {
        super(R.layout.widget_stage_channel_speaker, stageCallAdapter, null);
        Intrinsics3.checkNotNullParameter(stageCallAdapter, "adapter");
        View view = this.itemView;
        StageCallSpeakerView stageCallSpeakerView = (StageCallSpeakerView) view.findViewById(R.id.stage_channel_speaker_container);
        if (stageCallSpeakerView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.stage_channel_speaker_container)));
        }
        WidgetStageChannelSpeakerBinding widgetStageChannelSpeakerBinding = new WidgetStageChannelSpeakerBinding((ConstraintLayout) view, stageCallSpeakerView);
        Intrinsics3.checkNotNullExpressionValue(widgetStageChannelSpeakerBinding, "WidgetStageChannelSpeakerBinding.bind(itemView)");
        this.binding = widgetStageChannelSpeakerBinding;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, StageCallItem stageCallItem) throws Resources.NotFoundException {
        onConfigure2(i, stageCallItem);
    }

    /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, StageCallItem data) throws Resources.NotFoundException {
        int dimensionPixelSize;
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, (int) data);
        StageCallItem.SpeakerItem speakerItem = (StageCallItem.SpeakerItem) data;
        StageCallSpeakerView stageCallSpeakerView = this.binding.f2654b;
        Intrinsics3.checkNotNullExpressionValue(stageCallSpeakerView, "binding.stageChannelSpeakerContainer");
        ViewGroup.LayoutParams layoutParams = stageCallSpeakerView.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        int speakersPerRow = speakerItem.getSpeakersPerRow();
        if (speakersPerRow == 1) {
            dimensionPixelSize = 0;
        } else if (speakersPerRow != 2) {
            ConstraintLayout constraintLayout = this.binding.a;
            Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.root");
            dimensionPixelSize = constraintLayout.getResources().getDimensionPixelSize(R.dimen.speaker_height_three_up);
        } else {
            ConstraintLayout constraintLayout2 = this.binding.a;
            Intrinsics3.checkNotNullExpressionValue(constraintLayout2, "binding.root");
            dimensionPixelSize = constraintLayout2.getResources().getDimensionPixelSize(R.dimen.speaker_height_two_up);
        }
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = dimensionPixelSize;
        layoutParams2.dimensionRatio = speakerItem.getSpeakersPerRow() != 1 ? null : "H,16:9";
        stageCallSpeakerView.setLayoutParams(layoutParams2);
        StageCallSpeakerView stageCallSpeakerView2 = this.binding.f2654b;
        StoreVoiceParticipants.VoiceUser voiceUser = speakerItem.getVoiceUser();
        boolean zIsModerator = speakerItem.isModerator();
        boolean zIsBlocked = speakerItem.isBlocked();
        Objects.requireNonNull(stageCallSpeakerView2);
        Intrinsics3.checkNotNullParameter(voiceUser, "voiceUser");
        String colorId = RepresentativeColors2.getColorId(voiceUser.getUser());
        stageCallSpeakerView2.binding.f223b.setOnBitmapLoadedListener(new StageCallSpeakerView2(colorId));
        stageCallSpeakerView2.binding.h.setPulsing(voiceUser.getIsSpeaking());
        stageCallSpeakerView2.binding.f223b.a(voiceUser, R.dimen.avatar_size_hero);
        stageCallSpeakerView2.binding.f223b.setRingMargin(DimenUtils.dpToPixels(2));
        ImageView imageView = stageCallSpeakerView2.binding.f;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.stageChannelSpeakerMuteIndicator");
        imageView.setVisibility(voiceUser.getIsMuted() && !voiceUser.getIsDeafened() ? 0 : 8);
        ImageView imageView2 = stageCallSpeakerView2.binding.d;
        Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.stageChannelSpeakerDeafenIndicator");
        imageView2.setVisibility(voiceUser.getIsDeafened() ? 0 : 8);
        ImageView imageView3 = stageCallSpeakerView2.binding.e;
        Intrinsics3.checkNotNullExpressionValue(imageView3, "binding.stageChannelSpeakerModIndicator");
        imageView3.setVisibility(zIsModerator ? 0 : 8);
        TextView textView = stageCallSpeakerView2.binding.g;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.stageChannelSpeakerName");
        textView.setText(voiceUser.getDisplayName());
        ImageView imageView4 = stageCallSpeakerView2.binding.c;
        Intrinsics3.checkNotNullExpressionValue(imageView4, "binding.stageChannelSpeakerBlocked");
        imageView4.setVisibility(zIsBlocked ? 0 : 8);
        Subscription subscription = stageCallSpeakerView2.com.discord.utilities.analytics.Traits.Payment.Type.SUBSCRIPTION java.lang.String;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        Observable<R> observableG = RepresentativeColors2.getUserRepresentativeColors().observeRepresentativeColor(colorId).y(ObservableExtensionsKt.AnonymousClass1.INSTANCE).G(ObservableExtensionsKt.AnonymousClass2.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
        Observable observableZ = observableG.Z(1);
        Intrinsics3.checkNotNullExpressionValue(observableZ, "UserRepresentativeColors…erNull()\n        .take(1)");
        ObservableExtensionsKt.appSubscribe$default(observableZ, StageCallSpeakerView.class, (Context) null, new StageCallSpeakerView3(stageCallSpeakerView2), (Function1) null, (Function0) null, (Function0) null, new StageCallSpeakerView4(stageCallSpeakerView2), 58, (Object) null);
    }
}
