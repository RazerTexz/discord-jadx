package com.discord.widgets.chat.list.adapter;

import android.view.KeyEvent;
import android.widget.TextView;
import com.discord.stores.StoreThreadDraft;
import com.discord.widgets.chat.input.AppFlexInputViewModel;
import kotlin.Metadata;

/* compiled from: WidgetChatListAdapterItemThreadDraftForm.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0010\u000b\u001a\u00020\u00072\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "<anonymous parameter 0>", "", "actionId", "Landroid/view/KeyEvent;", "<anonymous parameter 2>", "", "onEditorAction", "(Landroid/widget/TextView;ILandroid/view/KeyEvent;)Z", "com/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemThreadDraftForm$configureThreadNameInput$1$3", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemThreadDraftForm$configureThreadNameInput$$inlined$apply$lambda$3, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemThreadDraftForm3 implements TextView.OnEditorActionListener {
    public final /* synthetic */ StoreThreadDraft.ThreadDraftState $draftState$inlined;
    public final /* synthetic */ StoreThreadDraft $storeThreadDraft$inlined;
    public final /* synthetic */ WidgetChatListAdapterItemThreadDraftForm this$0;

    public WidgetChatListAdapterItemThreadDraftForm3(WidgetChatListAdapterItemThreadDraftForm widgetChatListAdapterItemThreadDraftForm, StoreThreadDraft storeThreadDraft, StoreThreadDraft.ThreadDraftState threadDraftState) {
        this.this$0 = widgetChatListAdapterItemThreadDraftForm;
        this.$storeThreadDraft$inlined = storeThreadDraft;
        this.$draftState$inlined = threadDraftState;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        AppFlexInputViewModel flexInputViewModel;
        if (i != 5 || (flexInputViewModel = this.this$0.getFlexInputViewModel()) == null) {
            return false;
        }
        flexInputViewModel.focus();
        return false;
    }
}
