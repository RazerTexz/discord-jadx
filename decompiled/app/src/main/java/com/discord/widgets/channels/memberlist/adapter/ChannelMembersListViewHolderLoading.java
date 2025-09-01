package com.discord.widgets.channels.memberlist.adapter;

import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.databinding.WidgetChannelMembersListItemLoadingBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.Tuples;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: ChannelMembersListViewHolderLoading.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/discord/widgets/channels/memberlist/adapter/ChannelMembersListViewHolderLoading;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "", "bind", "(I)V", "Lcom/discord/databinding/WidgetChannelMembersListItemLoadingBinding;", "binding", "Lcom/discord/databinding/WidgetChannelMembersListItemLoadingBinding;", "<init>", "(Lcom/discord/databinding/WidgetChannelMembersListItemLoadingBinding;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ChannelMembersListViewHolderLoading extends RecyclerView.ViewHolder {
    private static final Map<Integer, Float> POSITION_PERCENT_MAP;
    private final WidgetChannelMembersListItemLoadingBinding binding;

    static {
        Float fValueOf = Float.valueOf(0.7f);
        Float fValueOf2 = Float.valueOf(0.3f);
        Float fValueOf3 = Float.valueOf(0.6f);
        Float fValueOf4 = Float.valueOf(0.4f);
        POSITION_PERCENT_MAP = Maps6.mapOf(Tuples.to(0, fValueOf), Tuples.to(1, fValueOf2), Tuples.to(2, fValueOf3), Tuples.to(3, fValueOf4), Tuples.to(4, fValueOf3), Tuples.to(5, Float.valueOf(0.8f)), Tuples.to(6, fValueOf2), Tuples.to(7, Float.valueOf(0.5f)), Tuples.to(8, fValueOf), Tuples.to(9, fValueOf4));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelMembersListViewHolderLoading(WidgetChannelMembersListItemLoadingBinding widgetChannelMembersListItemLoadingBinding) {
        super(widgetChannelMembersListItemLoadingBinding.a);
        Intrinsics3.checkNotNullParameter(widgetChannelMembersListItemLoadingBinding, "binding");
        this.binding = widgetChannelMembersListItemLoadingBinding;
    }

    public final void bind(int position) {
        Guideline guideline = this.binding.f2260b;
        Float f = POSITION_PERCENT_MAP.get(Integer.valueOf(position % 10));
        guideline.setGuidelinePercent(f != null ? f.floatValue() : 0.0f);
    }
}
