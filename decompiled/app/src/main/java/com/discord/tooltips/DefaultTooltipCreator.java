package com.discord.tooltips;

import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: DefaultTooltipCreator.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/discord/tooltips/DefaultTooltipCreator;", "", "Lcom/discord/tooltips/TooltipManager;", "a", "Lcom/discord/tooltips/TooltipManager;", "tooltipManager", "<init>", "(Lcom/discord/tooltips/TooltipManager;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class DefaultTooltipCreator {

    /* renamed from: a, reason: from kotlin metadata */
    public final TooltipManager tooltipManager;

    public DefaultTooltipCreator(TooltipManager tooltipManager) {
        Intrinsics3.checkNotNullParameter(tooltipManager, "tooltipManager");
        this.tooltipManager = tooltipManager;
    }
}
