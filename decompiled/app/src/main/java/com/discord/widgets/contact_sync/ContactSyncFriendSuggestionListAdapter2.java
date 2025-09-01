package com.discord.widgets.contact_sync;

import android.widget.CompoundButton;
import com.discord.widgets.contact_sync.ContactSyncFriendSuggestionListAdapter;
import kotlin.Metadata;

/* compiled from: ContactSyncFriendSuggestionListAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "<anonymous parameter 0>", "", "isChecked", "", "onCheckedChanged", "(Landroid/widget/CompoundButton;Z)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.contact_sync.ContactSyncFriendSuggestionListAdapter$ItemFriendSuggestion$onConfigure$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class ContactSyncFriendSuggestionListAdapter2 implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ long $id;
    public final /* synthetic */ ContactSyncFriendSuggestionListAdapter.ItemFriendSuggestion this$0;

    public ContactSyncFriendSuggestionListAdapter2(ContactSyncFriendSuggestionListAdapter.ItemFriendSuggestion itemFriendSuggestion, long j) {
        this.this$0 = itemFriendSuggestion;
        this.$id = j;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
        ContactSyncFriendSuggestionListAdapter.ItemFriendSuggestion.access$getAdapter$p(this.this$0).getOnClickFriendSuggestion().invoke(Long.valueOf(this.$id), Boolean.valueOf(z2));
    }
}
