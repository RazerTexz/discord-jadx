package com.discord.widgets.voice.sheet;

import com.discord.tooltips.TooltipManager;
import kotlin.Metadata;

/* compiled from: NoiseCancellationTooltip.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/voice/sheet/NoiseCancellationTooltip;", "Lcom/discord/tooltips/TooltipManager$b;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class NoiseCancellationTooltip extends TooltipManager.b {
    public static final NoiseCancellationTooltip INSTANCE = new NoiseCancellationTooltip();

    private NoiseCancellationTooltip() {
        super("CACHE_KEY_NOISE_CANCELLATION_TOOLTIP_ACKNOWLEDGED", "NOISE_CANCELLATION_TOOLTIP");
    }
}
