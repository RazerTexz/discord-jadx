package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.discord.R;
import com.discord.api.sticker.BaseSticker;
import com.discord.api.sticker.Sticker;
import com.discord.databinding.WidgetChatListAdapterItemStickerBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.stickers.StickerUtils;
import com.discord.views.sticker.StickerView;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.StickerEntry;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Subscription;

/* compiled from: WidgetChatListAdapterItemSticker.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\n\u001a\u0004\u0018\u00010\tH\u0014¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemSticker;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListItem;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "data", "", "onConfigure", "(ILcom/discord/widgets/chat/list/entries/ChatListEntry;)V", "Lrx/Subscription;", "getSubscription", "()Lrx/Subscription;", "Lcom/discord/databinding/WidgetChatListAdapterItemStickerBinding;", "binding", "Lcom/discord/databinding/WidgetChatListAdapterItemStickerBinding;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;", "adapter", "<init>", "(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemSticker extends WidgetChatListItem {
    private final WidgetChatListAdapterItemStickerBinding binding;

    /* compiled from: WidgetChatListAdapterItemSticker.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/sticker/Sticker;", "localSticker", "", "invoke", "(Lcom/discord/api/sticker/Sticker;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemSticker$onConfigure$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Sticker, Unit> {
        public final /* synthetic */ ChatListEntry $data;
        public final /* synthetic */ StickerEntry $stickerEntry;

        /* compiled from: WidgetChatListAdapterItemSticker.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemSticker$onConfigure$1$1, reason: invalid class name and collision with other inner class name */
        public static final class ViewOnClickListenerC02761 implements View.OnClickListener {
            public final /* synthetic */ BaseSticker $sticker;

            public ViewOnClickListenerC02761(BaseSticker baseSticker) {
                this.$sticker = baseSticker;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetChatListAdapterItemSticker.access$getAdapter$p(WidgetChatListAdapterItemSticker.this).onStickerClicked(((StickerEntry) AnonymousClass1.this.$data).getMessage(), this.$sticker);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(StickerEntry stickerEntry, ChatListEntry chatListEntry) {
            super(1);
            this.$stickerEntry = stickerEntry;
            this.$data = chatListEntry;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Sticker sticker) {
            invoke2(sticker);
            return Unit.a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v3, types: [com.discord.api.sticker.BaseSticker] */
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Sticker sticker) {
            Sticker sticker2 = sticker;
            if (sticker == null) {
                sticker2 = this.$stickerEntry.getSticker();
            }
            StickerView.e(WidgetChatListAdapterItemSticker.access$getBinding$p(WidgetChatListAdapterItemSticker.this).f2334b, sticker2, null, 2);
            WidgetChatListAdapterItemSticker.access$getBinding$p(WidgetChatListAdapterItemSticker.this).f2334b.setOnClickListener(new ViewOnClickListenerC02761(sticker2));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemSticker(WidgetChatListAdapter widgetChatListAdapter) {
        super(R.layout.widget_chat_list_adapter_item_sticker, widgetChatListAdapter);
        Intrinsics3.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        StickerView stickerView = (StickerView) view.findViewById(R.id.chat_list_adapter_item_sticker);
        if (stickerView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.chat_list_adapter_item_sticker)));
        }
        WidgetChatListAdapterItemStickerBinding widgetChatListAdapterItemStickerBinding = new WidgetChatListAdapterItemStickerBinding((FrameLayout) view, stickerView);
        Intrinsics3.checkNotNullExpressionValue(widgetChatListAdapterItemStickerBinding, "WidgetChatListAdapterIte…kerBinding.bind(itemView)");
        this.binding = widgetChatListAdapterItemStickerBinding;
    }

    public static final /* synthetic */ WidgetChatListAdapter access$getAdapter$p(WidgetChatListAdapterItemSticker widgetChatListAdapterItemSticker) {
        return (WidgetChatListAdapter) widgetChatListAdapterItemSticker.adapter;
    }

    public static final /* synthetic */ WidgetChatListAdapterItemStickerBinding access$getBinding$p(WidgetChatListAdapterItemSticker widgetChatListAdapterItemSticker) {
        return widgetChatListAdapterItemSticker.binding;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public Subscription getSubscription() {
        return this.binding.f2334b.getCom.discord.utilities.analytics.Traits.Payment.Type.SUBSCRIPTION java.lang.String();
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, ChatListEntry chatListEntry) {
        onConfigure(i, chatListEntry);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem
    public void onConfigure(int position, ChatListEntry data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        StickerEntry stickerEntry = (StickerEntry) data;
        Observable observableZ = StickerUtils.getGuildOrStandardSticker$default(StickerUtils.INSTANCE, stickerEntry.getSticker().getId(), false, 2, null).Z(1);
        Intrinsics3.checkNotNullExpressionValue(observableZ, "StickerUtils.getGuildOrS…kerId())\n        .take(1)");
        ObservableExtensionsKt.appSubscribe$default(observableZ, WidgetChatListAdapterItemSticker.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(stickerEntry, data), 62, (Object) null);
    }
}
