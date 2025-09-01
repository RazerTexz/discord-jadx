package com.discord.widgets.channels.permissions;

import com.discord.analytics.generated.events.impression.TrackImpressionChannelAddMembers;
import com.discord.analytics.generated.traits.TrackImpressionMetadata;
import com.discord.analytics.utils.ImpressionGroups;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetCreateChannelAddMember.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/api/science/AnalyticsSchema;", "invoke", "()Lcom/discord/api/science/AnalyticsSchema;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.permissions.WidgetCreateChannelAddMember$loggingConfig$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetCreateChannelAddMember4 extends Lambda implements Function0<AnalyticsSchema> {
    public static final WidgetCreateChannelAddMember4 INSTANCE = new WidgetCreateChannelAddMember4();

    public WidgetCreateChannelAddMember4() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ AnalyticsSchema invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AnalyticsSchema invoke() {
        TrackImpressionChannelAddMembers trackImpressionChannelAddMembers = new TrackImpressionChannelAddMembers();
        trackImpressionChannelAddMembers.e(new TrackImpressionMetadata(null, null, null, ImpressionGroups.CHANNEL_ADD_FLOW, 7));
        return trackImpressionChannelAddMembers;
    }
}
