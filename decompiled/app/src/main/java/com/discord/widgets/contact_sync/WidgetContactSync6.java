package com.discord.widgets.contact_sync;

import com.discord.analytics.generated.events.impression.TrackImpressionContactSyncInputName;
import com.discord.analytics.generated.events.impression.TrackImpressionContactSyncStart;
import com.discord.analytics.generated.events.impression.TrackImpressionContactSyncSuggestions;
import com.discord.analytics.generated.events.impression.TrackImpressionUserAddPhone;
import com.discord.api.science.AnalyticsSchema;
import com.discord.widgets.contact_sync.WidgetContactSyncViewModel;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetContactSync.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/api/science/AnalyticsSchema;", "invoke", "()Lcom/discord/api/science/AnalyticsSchema;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.contact_sync.WidgetContactSync$loggingConfig$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetContactSync6 extends Lambda implements Function0<AnalyticsSchema> {
    public final /* synthetic */ WidgetContactSync this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetContactSync6(WidgetContactSync widgetContactSync) {
        super(0);
        this.this$0 = widgetContactSync;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ AnalyticsSchema invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AnalyticsSchema invoke() {
        int iAccess$getDisplayedChildIndex$p = WidgetContactSync.access$getDisplayedChildIndex$p(this.this$0);
        if (iAccess$getDisplayedChildIndex$p == WidgetContactSyncViewModel.Views.VIEW_LANDING.ordinal()) {
            TrackImpressionContactSyncStart trackImpressionContactSyncStart = new TrackImpressionContactSyncStart();
            trackImpressionContactSyncStart.e(WidgetContactSync.access$getContactSyncFlowMetadata$p(this.this$0));
            return trackImpressionContactSyncStart;
        }
        if (iAccess$getDisplayedChildIndex$p == WidgetContactSyncViewModel.Views.VIEW_ADD_PHONE.ordinal()) {
            TrackImpressionUserAddPhone trackImpressionUserAddPhone = new TrackImpressionUserAddPhone();
            trackImpressionUserAddPhone.e(WidgetContactSync.access$getContactSyncFlowMetadata$p(this.this$0));
            return trackImpressionUserAddPhone;
        }
        if (iAccess$getDisplayedChildIndex$p == WidgetContactSyncViewModel.Views.VIEW_NAME_INPUT.ordinal()) {
            TrackImpressionContactSyncInputName trackImpressionContactSyncInputName = new TrackImpressionContactSyncInputName();
            trackImpressionContactSyncInputName.e(WidgetContactSync.access$getContactSyncFlowMetadata$p(this.this$0));
            return trackImpressionContactSyncInputName;
        }
        if (iAccess$getDisplayedChildIndex$p == WidgetContactSyncViewModel.Views.VIEW_SUGGESTIONS.ordinal()) {
            TrackImpressionContactSyncSuggestions trackImpressionContactSyncSuggestions = new TrackImpressionContactSyncSuggestions();
            trackImpressionContactSyncSuggestions.e(WidgetContactSync.access$getContactSyncFlowMetadata$p(this.this$0));
            return trackImpressionContactSyncSuggestions;
        }
        if (iAccess$getDisplayedChildIndex$p != WidgetContactSyncViewModel.Views.VIEW_SUGGESTIONS_EMPTY.ordinal()) {
            return null;
        }
        TrackImpressionContactSyncSuggestions trackImpressionContactSyncSuggestions2 = new TrackImpressionContactSyncSuggestions();
        trackImpressionContactSyncSuggestions2.e(WidgetContactSync.access$getContactSyncFlowMetadata$p(this.this$0));
        return trackImpressionContactSyncSuggestions2;
    }
}
