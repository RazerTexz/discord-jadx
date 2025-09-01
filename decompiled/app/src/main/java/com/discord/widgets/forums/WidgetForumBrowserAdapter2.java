package com.discord.widgets.forums;

import android.view.View;
import com.discord.widgets.forums.ForumBrowserItem;
import com.discord.widgets.forums.WidgetForumBrowserAdapter;
import kotlin.Metadata;

/* compiled from: WidgetForumBrowserAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.forums.WidgetForumBrowserAdapter$PostItem$onConfigure$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetForumBrowserAdapter2 implements View.OnClickListener {
    public final /* synthetic */ ForumBrowserItem.PostItem $item;
    public final /* synthetic */ WidgetForumBrowserAdapter.PostItem this$0;

    public WidgetForumBrowserAdapter2(WidgetForumBrowserAdapter.PostItem postItem, ForumBrowserItem.PostItem postItem2) {
        this.this$0 = postItem;
        this.$item = postItem2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetForumBrowserAdapter.access$getOnPostClick$p(WidgetForumBrowserAdapter.PostItem.access$getAdapter$p(this.this$0)).invoke(this.$item.getPost().getChannel());
    }
}
