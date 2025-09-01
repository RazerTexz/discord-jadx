package com.discord.widgets.chat.list.adapter;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapter;
import kotlin.Metadata;

/* compiled from: WidgetChatListAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/discord/widgets/chat/list/adapter/WidgetChatListAdapter$HandlerOfTouches$tapGestureDetector$1", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "Landroid/view/MotionEvent;", "e", "", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$HandlerOfTouches$tapGestureDetector$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapter2 extends GestureDetector.SimpleOnGestureListener {
    public final /* synthetic */ WidgetChatListAdapter.HandlerOfTouches this$0;

    public WidgetChatListAdapter2(WidgetChatListAdapter.HandlerOfTouches handlerOfTouches) {
        this.this$0 = handlerOfTouches;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent e) {
        WidgetChatListAdapter.this.getEventHandler().onListClicked();
        return super.onSingleTapUp(e);
    }
}
