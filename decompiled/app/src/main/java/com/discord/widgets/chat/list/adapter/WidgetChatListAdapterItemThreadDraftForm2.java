package com.discord.widgets.chat.list.adapter;

import android.view.View;
import com.discord.stores.StoreThreadDraft;
import kotlin.Metadata;

/* compiled from: WidgetChatListAdapterItemThreadDraftForm.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\t\u001a\u00020\u00052\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "<anonymous parameter 0>", "", "hasFocus", "", "onFocusChange", "(Landroid/view/View;Z)V", "com/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemThreadDraftForm$configureThreadNameInput$1$2", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemThreadDraftForm$configureThreadNameInput$$inlined$apply$lambda$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemThreadDraftForm2 implements View.OnFocusChangeListener {
    public final /* synthetic */ StoreThreadDraft.ThreadDraftState $draftState$inlined;
    public final /* synthetic */ StoreThreadDraft $storeThreadDraft$inlined;
    public final /* synthetic */ WidgetChatListAdapterItemThreadDraftForm this$0;

    public WidgetChatListAdapterItemThreadDraftForm2(WidgetChatListAdapterItemThreadDraftForm widgetChatListAdapterItemThreadDraftForm, StoreThreadDraft storeThreadDraft, StoreThreadDraft.ThreadDraftState threadDraftState) {
        this.this$0 = widgetChatListAdapterItemThreadDraftForm;
        this.$storeThreadDraft$inlined = storeThreadDraft;
        this.$draftState$inlined = threadDraftState;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z2) {
        if (z2 || !this.$draftState$inlined.getShouldDisplayNameError()) {
            return;
        }
        this.$storeThreadDraft$inlined.setDraftState(StoreThreadDraft.ThreadDraftState.copy$default(this.$draftState$inlined, false, null, null, false, false, 15, null));
    }
}
