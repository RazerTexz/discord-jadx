package com.discord.widgets.stage.sheet;

import androidx.core.app.NotificationCompat;
import com.discord.widgets.stage.StageRoles;
import com.discord.widgets.stage.sheet.StageAudienceBlockedBottomSheetViewModel;
import com.discord.widgets.voice.model.CallModel;
import d0.t.Maps6;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import rx.functions.Func3;

/* compiled from: StageAudienceBlockedBottomSheetViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000b2\b\u0010\u0001\u001a\u0004\u0018\u00010\u000026\u0010\b\u001a2\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\b\u0012\u00060\u0005j\u0002`\u0006 \u0007*\u0018\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0018\u00010\u00020\u00022\u0018\u0010\n\u001a\u0014\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\t\u0018\u00010\u0002H\n¢\u0006\u0004\b\f\u0010\r"}, d2 = {"Lcom/discord/widgets/voice/model/CallModel;", "callModel", "", "", "Lcom/discord/primitives/UserId;", "", "Lcom/discord/primitives/RelationshipType;", "kotlin.jvm.PlatformType", "blockedUserMap", "Lcom/discord/widgets/stage/StageRoles;", "stageRoles", "Lcom/discord/widgets/stage/sheet/StageAudienceBlockedBottomSheetViewModel$StoreState;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/widgets/voice/model/CallModel;Ljava/util/Map;Ljava/util/Map;)Lcom/discord/widgets/stage/sheet/StageAudienceBlockedBottomSheetViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.stage.sheet.StageAudienceBlockedBottomSheetViewModel$Companion$observeStores$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class StageAudienceBlockedBottomSheetViewModel2<T1, T2, T3, R> implements Func3<CallModel, Map<Long, ? extends Integer>, Map<Long, ? extends StageRoles>, StageAudienceBlockedBottomSheetViewModel.StoreState> {
    public final /* synthetic */ long $channelId;

    public StageAudienceBlockedBottomSheetViewModel2(long j) {
        this.$channelId = j;
    }

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ StageAudienceBlockedBottomSheetViewModel.StoreState call(CallModel callModel, Map<Long, ? extends Integer> map, Map<Long, ? extends StageRoles> map2) {
        return call2(callModel, (Map<Long, Integer>) map, (Map<Long, StageRoles>) map2);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final StageAudienceBlockedBottomSheetViewModel.StoreState call2(CallModel callModel, Map<Long, Integer> map, Map<Long, StageRoles> map2) {
        long j = this.$channelId;
        Set<Long> setKeySet = map.keySet();
        if (map2 == null) {
            map2 = Maps6.emptyMap();
        }
        return new StageAudienceBlockedBottomSheetViewModel.StoreState(j, callModel, setKeySet, map2);
    }
}
