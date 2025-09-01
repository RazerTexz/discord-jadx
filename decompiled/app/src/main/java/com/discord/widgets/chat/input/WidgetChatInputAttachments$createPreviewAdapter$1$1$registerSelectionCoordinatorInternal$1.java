package com.discord.widgets.chat.input;

import com.discord.widgets.chat.input.WidgetChatInputAttachments;
import com.lytefast.flexinput.model.Attachment;
import com.lytefast.flexinput.utils.SelectionCoordinator;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: WidgetChatInputAttachments.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096\u0001¢\u0006\u0004\b\u0006\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0003H\u0096\u0001¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/discord/widgets/chat/input/WidgetChatInputAttachments$createPreviewAdapter$1$1$registerSelectionCoordinatorInternal$1", "Lcom/lytefast/flexinput/utils/SelectionCoordinator$ItemSelectionListener;", "item", "", "onItemSelected", "(Lcom/lytefast/flexinput/model/Attachment;)V", "onItemUnselected", "unregister", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChatInputAttachments$createPreviewAdapter$1$1$registerSelectionCoordinatorInternal$1<T> implements SelectionCoordinator.ItemSelectionListener<T> {
    private final /* synthetic */ SelectionCoordinator.ItemSelectionListener<? super T> $$delegate_0;
    public final /* synthetic */ SelectionCoordinator.ItemSelectionListener $oldItemSelectionListener;
    public final /* synthetic */ WidgetChatInputAttachments.AnonymousClass1.C02531 this$0;

    public WidgetChatInputAttachments$createPreviewAdapter$1$1$registerSelectionCoordinatorInternal$1(WidgetChatInputAttachments.AnonymousClass1.C02531 c02531, SelectionCoordinator.ItemSelectionListener itemSelectionListener) {
        this.this$0 = c02531;
        this.$oldItemSelectionListener = itemSelectionListener;
        this.$$delegate_0 = itemSelectionListener;
    }

    @Override // com.lytefast.flexinput.utils.SelectionCoordinator.ItemSelectionListener
    public /* bridge */ /* synthetic */ void onItemSelected(Object obj) {
        onItemSelected((Attachment) obj);
    }

    /* JADX WARN: Incorrect types in method signature: (TT;)V */
    public void onItemUnselected(Attachment item) {
        Intrinsics3.checkNotNullParameter(item, "item");
        this.$$delegate_0.onItemUnselected(item);
    }

    @Override // com.lytefast.flexinput.utils.SelectionCoordinator.ItemSelectionListener
    public /* bridge */ /* synthetic */ void onItemUnselected(Object obj) {
        onItemUnselected((Attachment) obj);
    }

    @Override // com.lytefast.flexinput.utils.SelectionCoordinator.ItemSelectionListener
    public void unregister() {
        this.$$delegate_0.unregister();
    }

    /* JADX WARN: Incorrect types in method signature: (TT;)V */
    public void onItemSelected(Attachment item) {
        Intrinsics3.checkNotNullParameter(item, "item");
        WidgetChatInputAttachments.AnonymousClass1.C02531.access$track(this.this$0, item);
        this.$oldItemSelectionListener.onItemSelected(item);
    }
}
