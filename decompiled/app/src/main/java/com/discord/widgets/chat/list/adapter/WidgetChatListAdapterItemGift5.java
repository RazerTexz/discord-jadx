package com.discord.widgets.chat.list.adapter;

import androidx.core.app.NotificationCompat;
import com.discord.api.user.User;
import com.discord.models.domain.ModelGift;
import com.discord.models.domain.ModelLibraryApplication;
import com.discord.models.user.MeUser;
import com.discord.utilities.time.ClockFactory;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGift;
import d0.z.d.Intrinsics3;
import java.util.Map;
import kotlin.Metadata;
import rx.functions.Func2;

/* compiled from: WidgetChatListAdapterItemGift.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\n\u001a\n \u0001*\u0004\u0018\u00010\u00070\u00072\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lcom/discord/models/user/MeUser;", "kotlin.jvm.PlatformType", "me", "", "", "Lcom/discord/models/domain/ModelLibraryApplication;", "applications", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGift$Model;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/user/MeUser;Ljava/util/Map;)Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGift$Model;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGift$ModelProvider$getResolvedGiftModel$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemGift5<T1, T2, R> implements Func2<MeUser, Map<Long, ? extends ModelLibraryApplication>, WidgetChatListAdapterItemGift.Model> {
    public final /* synthetic */ ModelGift $gift;
    public final /* synthetic */ boolean $redeeming;

    public WidgetChatListAdapterItemGift5(ModelGift modelGift, boolean z2) {
        this.$gift = modelGift;
        this.$redeeming = z2;
    }

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ WidgetChatListAdapterItemGift.Model call(MeUser meUser, Map<Long, ? extends ModelLibraryApplication> map) {
        return call2(meUser, (Map<Long, ModelLibraryApplication>) map);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetChatListAdapterItemGift.Model call2(MeUser meUser, Map<Long, ModelLibraryApplication> map) {
        WidgetChatListAdapterItemGift.Model invalid;
        if (this.$gift.isExpired(ClockFactory.get().currentTimeMillis())) {
            User user = this.$gift.getUser();
            invalid = new WidgetChatListAdapterItemGift.Model.Invalid(user != null ? Long.valueOf(user.getId()) : null, meUser.getId());
        } else {
            ModelGift modelGift = this.$gift;
            Intrinsics3.checkNotNullExpressionValue(meUser, "me");
            invalid = new WidgetChatListAdapterItemGift.Model.Resolved(modelGift, meUser, map != null && map.containsKey(Long.valueOf(this.$gift.getSkuId())), this.$redeeming);
        }
        return invalid;
    }
}
