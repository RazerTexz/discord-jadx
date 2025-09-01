package com.discord.widgets.voice.fullscreen.stage;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.R;
import com.discord.databinding.WidgetStageChannelPrestartDetailsBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.widgets.voice.fullscreen.stage.StageCallItem;
import d0.z.d.Intrinsics3;
import java.util.Objects;
import kotlin.Metadata;

/* compiled from: StageCallViewHolder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/stage/PrestartDetailsViewHolder;", "Lcom/discord/widgets/voice/fullscreen/stage/StageCallViewHolder;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "Lcom/discord/widgets/voice/fullscreen/stage/StageCallItem;", "data", "", "onConfigure", "(ILcom/discord/widgets/voice/fullscreen/stage/StageCallItem;)V", "Lcom/discord/databinding/WidgetStageChannelPrestartDetailsBinding;", "binding", "Lcom/discord/databinding/WidgetStageChannelPrestartDetailsBinding;", "Lcom/discord/widgets/voice/fullscreen/stage/StageCallAdapter;", "adapter", "<init>", "(Lcom/discord/widgets/voice/fullscreen/stage/StageCallAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.voice.fullscreen.stage.PrestartDetailsViewHolder, reason: use source file name */
/* loaded from: classes.dex */
public final class StageCallViewHolder7 extends StageCallViewHolder {
    private final WidgetStageChannelPrestartDetailsBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StageCallViewHolder7(StageCallAdapter stageCallAdapter) {
        super(R.layout.widget_stage_channel_prestart_details, stageCallAdapter, null);
        Intrinsics3.checkNotNullParameter(stageCallAdapter, "adapter");
        View view = this.itemView;
        int i = R.id.subtitle;
        TextView textView = (TextView) view.findViewById(R.id.subtitle);
        if (textView != null) {
            i = R.id.title;
            TextView textView2 = (TextView) view.findViewById(R.id.title);
            if (textView2 != null) {
                WidgetStageChannelPrestartDetailsBinding widgetStageChannelPrestartDetailsBinding = new WidgetStageChannelPrestartDetailsBinding((ConstraintLayout) view, textView, textView2);
                Intrinsics3.checkNotNullExpressionValue(widgetStageChannelPrestartDetailsBinding, "WidgetStageChannelPresta…ilsBinding.bind(itemView)");
                this.binding = widgetStageChannelPrestartDetailsBinding;
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, StageCallItem stageCallItem) {
        onConfigure2(i, stageCallItem);
    }

    /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, StageCallItem data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, (int) data);
        StageCallItem.PreStartDetailsItem preStartDetailsItem = (StageCallItem.PreStartDetailsItem) data;
        TextView textView = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.title");
        textView.setText(preStartDetailsItem.getTitle());
        TextView textView2 = this.binding.f2653b;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.subtitle");
        textView2.setText(preStartDetailsItem.getSubtitle());
        boolean z2 = preStartDetailsItem.getNumSpeakers() > 0;
        boolean z3 = preStartDetailsItem.getNumAudience() > 0;
        ConstraintLayout constraintLayout = this.binding.a;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.root");
        ViewGroup.LayoutParams layoutParams = constraintLayout.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.bottomMargin = (z2 || !z3) ? DimenUtils.dpToPixels(0) : DimenUtils.dpToPixels(24);
        constraintLayout.setLayoutParams(marginLayoutParams);
    }
}
