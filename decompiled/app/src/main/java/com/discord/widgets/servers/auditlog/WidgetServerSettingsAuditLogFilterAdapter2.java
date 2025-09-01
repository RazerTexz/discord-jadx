package com.discord.widgets.servers.auditlog;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreStream;
import com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilterAdapter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import rx.functions.Action1;

/* compiled from: WidgetServerSettingsAuditLogFilterAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Boolean;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilterAdapter$AuditLogFilterActionViewHolder$onConfigure$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLogFilterAdapter2<T> implements Action1<Boolean> {
    public final /* synthetic */ WidgetServerSettingsAuditLogFilterAdapter.AuditLogActionFilterItem $item;
    public final /* synthetic */ WidgetServerSettingsAuditLogFilterAdapter.AuditLogFilterActionViewHolder this$0;

    public WidgetServerSettingsAuditLogFilterAdapter2(WidgetServerSettingsAuditLogFilterAdapter.AuditLogFilterActionViewHolder auditLogFilterActionViewHolder, WidgetServerSettingsAuditLogFilterAdapter.AuditLogActionFilterItem auditLogActionFilterItem) {
        this.this$0 = auditLogFilterActionViewHolder;
        this.$item = auditLogActionFilterItem;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Boolean bool) {
        call2(bool);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Boolean bool) {
        StoreStream.INSTANCE.getAuditLog().setAuditLogFilterActionId(this.$item.getActionId());
        Function0 function0Access$getOnFilterSelectedCallback$p = WidgetServerSettingsAuditLogFilterAdapter.access$getOnFilterSelectedCallback$p(WidgetServerSettingsAuditLogFilterAdapter.AuditLogFilterActionViewHolder.access$getAdapter$p(this.this$0));
        if (function0Access$getOnFilterSelectedCallback$p != null) {
        }
    }
}
