package com.discord.views.calls;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.a.i.ViewVoiceCallActiveEventBinding;
import com.discord.R;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: VoiceCallActiveEventView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\f"}, d2 = {"Lcom/discord/views/calls/VoiceCallActiveEventView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lb/a/i/i4;", "j", "Lb/a/i/i4;", "binding", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class VoiceCallActiveEventView extends ConstraintLayout {

    /* renamed from: j, reason: from kotlin metadata */
    public final ViewVoiceCallActiveEventBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceCallActiveEventView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.view_voice_call_active_event, (ViewGroup) this, false);
        addView(viewInflate);
        int i = R.id.channel_name;
        TextView textView = (TextView) viewInflate.findViewById(R.id.channel_name);
        if (textView != null) {
            i = R.id.event_icon;
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.event_icon);
            if (imageView != null) {
                i = R.id.event_name;
                TextView textView2 = (TextView) viewInflate.findViewById(R.id.event_name);
                if (textView2 != null) {
                    ViewVoiceCallActiveEventBinding viewVoiceCallActiveEventBinding = new ViewVoiceCallActiveEventBinding((ConstraintLayout) viewInflate, textView, imageView, textView2);
                    Intrinsics3.checkNotNullExpressionValue(viewVoiceCallActiveEventBinding, "ViewVoiceCallActiveEvent…rom(context), this, true)");
                    this.binding = viewVoiceCallActiveEventBinding;
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
