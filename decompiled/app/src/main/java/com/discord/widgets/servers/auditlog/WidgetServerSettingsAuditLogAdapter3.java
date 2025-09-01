package com.discord.widgets.servers.auditlog;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogAdapter;
import kotlin.Metadata;

/* compiled from: WidgetServerSettingsAuditLogAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogAdapter$AuditLogEntryViewHolder$onConfigure$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLogAdapter3 implements Runnable {
    public final /* synthetic */ WidgetServerSettingsAuditLogAdapter.AuditLogEntryViewHolder this$0;

    public WidgetServerSettingsAuditLogAdapter3(WidgetServerSettingsAuditLogAdapter.AuditLogEntryViewHolder auditLogEntryViewHolder) {
        this.this$0 = auditLogEntryViewHolder;
    }

    @Override // java.lang.Runnable
    public final void run() {
        RecyclerView.LayoutManager layoutManager = WidgetServerSettingsAuditLogAdapter.AuditLogEntryViewHolder.access$getAdapter$p(this.this$0).getRecycler().getLayoutManager();
        if (!(layoutManager instanceof LinearLayoutManager)) {
            layoutManager = null;
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        if (linearLayoutManager != null) {
            int iFindFirstCompletelyVisibleItemPosition = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
            int iMin = Math.min(linearLayoutManager.findLastCompletelyVisibleItemPosition(), WidgetServerSettingsAuditLogAdapter.AuditLogEntryViewHolder.access$getAdapter$p(this.this$0).getItemCount() - 1);
            int adapterPosition = this.this$0.getAdapterPosition();
            if (iFindFirstCompletelyVisibleItemPosition >= 0 && iMin >= iFindFirstCompletelyVisibleItemPosition && adapterPosition >= 0) {
                if (iFindFirstCompletelyVisibleItemPosition > adapterPosition || iMin < adapterPosition) {
                    WidgetServerSettingsAuditLogAdapter.AuditLogEntryViewHolder.access$getAdapter$p(this.this$0).getRecycler().smoothScrollToPosition(this.this$0.getAdapterPosition());
                }
            }
        }
    }
}
