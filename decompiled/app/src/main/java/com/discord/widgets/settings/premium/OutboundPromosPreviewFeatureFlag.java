package com.discord.widgets.settings.premium;

import com.discord.models.experiments.domain.Experiment;
import com.discord.stores.StoreExperiments;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: OutboundPromosPreviewFeatureFlag.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/discord/widgets/settings/premium/OutboundPromosPreviewFeatureFlag;", "", "", "isEnabled", "()Z", "Lcom/discord/stores/StoreExperiments;", "storeExperiments", "Lcom/discord/stores/StoreExperiments;", "<init>", "(Lcom/discord/stores/StoreExperiments;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class OutboundPromosPreviewFeatureFlag {
    private final StoreExperiments storeExperiments;

    public OutboundPromosPreviewFeatureFlag(StoreExperiments storeExperiments) {
        Intrinsics3.checkNotNullParameter(storeExperiments, "storeExperiments");
        this.storeExperiments = storeExperiments;
    }

    public final boolean isEnabled() {
        Experiment userExperiment = this.storeExperiments.getUserExperiment("2021-06_preview_promotions", true);
        return userExperiment != null && userExperiment.getBucket() == 1;
    }
}
