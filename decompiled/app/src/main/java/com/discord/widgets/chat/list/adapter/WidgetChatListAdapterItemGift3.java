package com.discord.widgets.chat.list.adapter;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreGifting;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGift;
import com.discord.widgets.chat.list.entries.GiftEntry;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import rx.Observable;

/* compiled from: WidgetChatListAdapterItemGift.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a*\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004 \u0001*\u0014\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/stores/StoreGifting$GiftState;", "kotlin.jvm.PlatformType", "giftState", "Lrx/Observable;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGift$Model;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/stores/StoreGifting$GiftState;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGift$ModelProvider$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemGift3<T, R> implements Func1<StoreGifting.GiftState, Observable<? extends WidgetChatListAdapterItemGift.Model>> {
    public final /* synthetic */ GiftEntry $item;

    public WidgetChatListAdapterItemGift3(GiftEntry giftEntry) {
        this.$item = giftEntry;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetChatListAdapterItemGift.Model> call(StoreGifting.GiftState giftState) {
        return call2(giftState);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetChatListAdapterItemGift.Model> call2(StoreGifting.GiftState giftState) {
        if ((giftState instanceof StoreGifting.GiftState.Loading) || (giftState instanceof StoreGifting.GiftState.LoadFailed)) {
            return new ScalarSynchronousObservable(WidgetChatListAdapterItemGift.Model.Loading.INSTANCE);
        }
        if (giftState instanceof StoreGifting.GiftState.Revoking) {
            return WidgetChatListAdapterItemGift.ModelProvider.getResolvedGiftModel$default(WidgetChatListAdapterItemGift.ModelProvider.INSTANCE, ((StoreGifting.GiftState.Revoking) giftState).getGift(), false, 2, null);
        }
        if (giftState instanceof StoreGifting.GiftState.Resolved) {
            return WidgetChatListAdapterItemGift.ModelProvider.getResolvedGiftModel$default(WidgetChatListAdapterItemGift.ModelProvider.INSTANCE, ((StoreGifting.GiftState.Resolved) giftState).getGift(), false, 2, null);
        }
        if (giftState instanceof StoreGifting.GiftState.Redeeming) {
            return WidgetChatListAdapterItemGift.ModelProvider.access$getResolvedGiftModel(WidgetChatListAdapterItemGift.ModelProvider.INSTANCE, ((StoreGifting.GiftState.Redeeming) giftState).getGift(), true);
        }
        if (giftState instanceof StoreGifting.GiftState.RedeemedFailed) {
            return WidgetChatListAdapterItemGift.ModelProvider.getResolvedGiftModel$default(WidgetChatListAdapterItemGift.ModelProvider.INSTANCE, ((StoreGifting.GiftState.RedeemedFailed) giftState).getGift(), false, 2, null);
        }
        if (giftState instanceof StoreGifting.GiftState.Invalid) {
            return WidgetChatListAdapterItemGift.ModelProvider.access$getInvalidGift(WidgetChatListAdapterItemGift.ModelProvider.INSTANCE, this.$item);
        }
        throw new NoWhenBranchMatchedException();
    }
}
