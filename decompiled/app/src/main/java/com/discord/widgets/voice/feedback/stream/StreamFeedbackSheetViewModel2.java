package com.discord.widgets.voice.feedback.stream;

import androidx.core.app.NotificationCompat;
import com.discord.models.experiments.domain.Experiment;
import com.discord.widgets.voice.feedback.stream.StreamFeedbackSheetViewModel;
import j0.k.Func1;
import kotlin.Metadata;

/* compiled from: StreamFeedbackSheetViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/models/experiments/domain/Experiment;", "experiment", "Lcom/discord/widgets/voice/feedback/stream/StreamFeedbackSheetViewModel$StoreState;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/experiments/domain/Experiment;)Lcom/discord/widgets/voice/feedback/stream/StreamFeedbackSheetViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.voice.feedback.stream.StreamFeedbackSheetViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes.dex */
public final class StreamFeedbackSheetViewModel2<T, R> implements Func1<Experiment, StreamFeedbackSheetViewModel.StoreState> {
    public static final StreamFeedbackSheetViewModel2 INSTANCE = new StreamFeedbackSheetViewModel2();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ StreamFeedbackSheetViewModel.StoreState call(Experiment experiment) {
        return call2(experiment);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final StreamFeedbackSheetViewModel.StoreState call2(Experiment experiment) {
        return new StreamFeedbackSheetViewModel.StoreState(experiment != null && experiment.getBucket() == 1);
    }
}
