package com.discord.views.calls;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.a.i.ViewStageChannelVisitCommunityBinding;
import com.discord.R;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: StageCallVisitCommunityView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/discord/views/calls/StageCallVisitCommunityView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lb/a/i/x3;", "j", "Lb/a/i/x3;", "binding", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StageCallVisitCommunityView extends ConstraintLayout {

    /* renamed from: j, reason: from kotlin metadata */
    public final ViewStageChannelVisitCommunityBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StageCallVisitCommunityView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Intrinsics3.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.view_stage_channel_visit_community, (ViewGroup) this, false);
        addView(viewInflate);
        int i = R.id.visit_community_icon;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate.findViewById(R.id.visit_community_icon);
        if (simpleDraweeView != null) {
            i = R.id.visit_community_icon_text;
            TextView textView = (TextView) viewInflate.findViewById(R.id.visit_community_icon_text);
            if (textView != null) {
                i = R.id.visit_community_text;
                TextView textView2 = (TextView) viewInflate.findViewById(R.id.visit_community_text);
                if (textView2 != null) {
                    ViewStageChannelVisitCommunityBinding viewStageChannelVisitCommunityBinding = new ViewStageChannelVisitCommunityBinding((ConstraintLayout) viewInflate, simpleDraweeView, textView, textView2);
                    Intrinsics3.checkNotNullExpressionValue(viewStageChannelVisitCommunityBinding, "ViewStageChannelVisitCom…rom(context), this, true)");
                    this.binding = viewStageChannelVisitCommunityBinding;
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
