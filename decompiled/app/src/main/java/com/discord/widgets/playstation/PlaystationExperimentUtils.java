package com.discord.widgets.playstation;

import com.discord.models.experiments.domain.Experiment;
import com.discord.stores.StoreExperiments;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: PlaystationExperimentUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0015\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0004\u001a\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0001\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/discord/stores/StoreExperiments;", "experimentStore", "", "canSeePlaystationUpsells", "(Lcom/discord/stores/StoreExperiments;)Z", "canSeePlaystationAccountIntegration", "", "getExperimentBucket", "(Lcom/discord/stores/StoreExperiments;)Ljava/lang/Integer;", "app_productionGoogleRelease"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.playstation.PlaystationExperimentUtilsKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class PlaystationExperimentUtils {
    public static final boolean canSeePlaystationAccountIntegration(StoreExperiments storeExperiments) {
        Intrinsics3.checkNotNullParameter(storeExperiments, "experimentStore");
        Integer experimentBucket = getExperimentBucket(storeExperiments);
        if (experimentBucket != null && experimentBucket.intValue() == 1) {
            return true;
        }
        return experimentBucket != null && experimentBucket.intValue() == 2;
    }

    public static final boolean canSeePlaystationUpsells(StoreExperiments storeExperiments) {
        Intrinsics3.checkNotNullParameter(storeExperiments, "experimentStore");
        Integer experimentBucket = getExperimentBucket(storeExperiments);
        return experimentBucket != null && experimentBucket.intValue() == 1;
    }

    private static final Integer getExperimentBucket(StoreExperiments storeExperiments) {
        Experiment userExperiment = storeExperiments.getUserExperiment("2021-12_connected_accounts_playstation", true);
        if (userExperiment != null) {
            return Integer.valueOf(userExperiment.getBucket());
        }
        return null;
    }
}
