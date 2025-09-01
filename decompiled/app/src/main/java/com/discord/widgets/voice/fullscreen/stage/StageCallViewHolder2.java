package com.discord.widgets.voice.fullscreen.stage;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.databinding.WidgetStageChannelAudienceRoleBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.locale.LocaleManager;
import com.discord.widgets.voice.fullscreen.stage.StageCallItem;
import d0.z.d.Intrinsics3;
import java.text.NumberFormat;
import kotlin.Metadata;

/* compiled from: StageCallViewHolder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0015¢\u0006\u0004\b\u0007\u0010\bR\u001e\u0010\u000b\u001a\n \n*\u0004\u0018\u00010\t0\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/stage/AudienceHeaderViewHolder;", "Lcom/discord/widgets/voice/fullscreen/stage/StageCallViewHolder;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "Lcom/discord/widgets/voice/fullscreen/stage/StageCallItem;", "data", "", "onConfigure", "(ILcom/discord/widgets/voice/fullscreen/stage/StageCallItem;)V", "Ljava/text/NumberFormat;", "kotlin.jvm.PlatformType", "numberFormatter", "Ljava/text/NumberFormat;", "Lcom/discord/databinding/WidgetStageChannelAudienceRoleBinding;", "binding", "Lcom/discord/databinding/WidgetStageChannelAudienceRoleBinding;", "Lcom/discord/widgets/voice/fullscreen/stage/StageCallAdapter;", "adapter", "<init>", "(Lcom/discord/widgets/voice/fullscreen/stage/StageCallAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.voice.fullscreen.stage.AudienceHeaderViewHolder, reason: use source file name */
/* loaded from: classes.dex */
public final class StageCallViewHolder2 extends StageCallViewHolder {
    private final WidgetStageChannelAudienceRoleBinding binding;
    private final NumberFormat numberFormatter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StageCallViewHolder2(StageCallAdapter stageCallAdapter) {
        super(R.layout.widget_stage_channel_audience_role, stageCallAdapter, null);
        Intrinsics3.checkNotNullParameter(stageCallAdapter, "adapter");
        View view = this.itemView;
        TextView textView = (TextView) view.findViewById(R.id.stage_channel_audience_role_text);
        if (textView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.stage_channel_audience_role_text)));
        }
        WidgetStageChannelAudienceRoleBinding widgetStageChannelAudienceRoleBinding = new WidgetStageChannelAudienceRoleBinding((ConstraintLayout) view, textView);
        Intrinsics3.checkNotNullExpressionValue(widgetStageChannelAudienceRoleBinding, "WidgetStageChannelAudien…oleBinding.bind(itemView)");
        this.binding = widgetStageChannelAudienceRoleBinding;
        LocaleManager localeManager = new LocaleManager();
        View view2 = this.itemView;
        Intrinsics3.checkNotNullExpressionValue(view2, "itemView");
        this.numberFormatter = NumberFormat.getNumberInstance(localeManager.getPrimaryLocale(view2.getContext()));
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, StageCallItem stageCallItem) {
        onConfigure2(i, stageCallItem);
    }

    @SuppressLint({"SetTextI18n"})
    /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, StageCallItem data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, (int) data);
        String str = this.numberFormatter.format(Integer.valueOf(((StageCallItem.AudienceHeaderItem) data).getAudienceSize()));
        TextView textView = this.binding.f2650b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.stageChannelAudienceRoleText");
        FormatUtils.n(textView, R.string.audience_section_header, new Object[]{str}, null, 4);
    }
}
