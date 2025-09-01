package com.discord.views.calls;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import b.a.i.ViewStageChannelSpeakerBinding;
import com.discord.R;
import com.discord.utilities.analytics.Traits;
import com.discord.views.VoiceUserView;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import rx.Subscription;

/* compiled from: StageCallSpeakerView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/discord/views/calls/StageCallSpeakerView;", "Landroidx/cardview/widget/CardView;", "", "onDetachedFromWindow", "()V", "Lrx/Subscription;", "k", "Lrx/Subscription;", Traits.Payment.Type.SUBSCRIPTION, "Lb/a/i/w3;", "j", "Lb/a/i/w3;", "binding", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StageCallSpeakerView extends CardView {

    /* renamed from: j, reason: from kotlin metadata */
    public final ViewStageChannelSpeakerBinding binding;

    /* renamed from: k, reason: from kotlin metadata */
    public Subscription subscription;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StageCallSpeakerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Intrinsics3.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.view_stage_channel_speaker, this);
        int i = R.id.stage_channel_speaker;
        VoiceUserView voiceUserView = (VoiceUserView) findViewById(R.id.stage_channel_speaker);
        if (voiceUserView != null) {
            i = R.id.stage_channel_speaker_blocked;
            ImageView imageView = (ImageView) findViewById(R.id.stage_channel_speaker_blocked);
            if (imageView != null) {
                i = R.id.stage_channel_speaker_deafen_indicator;
                ImageView imageView2 = (ImageView) findViewById(R.id.stage_channel_speaker_deafen_indicator);
                if (imageView2 != null) {
                    i = R.id.stage_channel_speaker_mod_indicator;
                    ImageView imageView3 = (ImageView) findViewById(R.id.stage_channel_speaker_mod_indicator);
                    if (imageView3 != null) {
                        i = R.id.stage_channel_speaker_mute_indicator;
                        ImageView imageView4 = (ImageView) findViewById(R.id.stage_channel_speaker_mute_indicator);
                        if (imageView4 != null) {
                            i = R.id.stage_channel_speaker_name;
                            TextView textView = (TextView) findViewById(R.id.stage_channel_speaker_name);
                            if (textView != null) {
                                i = R.id.stage_channel_speaker_pulse;
                                SpeakerPulseView speakerPulseView = (SpeakerPulseView) findViewById(R.id.stage_channel_speaker_pulse);
                                if (speakerPulseView != null) {
                                    ViewStageChannelSpeakerBinding viewStageChannelSpeakerBinding = new ViewStageChannelSpeakerBinding(this, voiceUserView, imageView, imageView2, imageView3, imageView4, textView, speakerPulseView);
                                    Intrinsics3.checkNotNullExpressionValue(viewStageChannelSpeakerBinding, "ViewStageChannelSpeakerB…ater.from(context), this)");
                                    this.binding = viewStageChannelSpeakerBinding;
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Subscription subscription = this.subscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }
}
