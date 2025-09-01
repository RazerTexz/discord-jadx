package com.discord.widgets.chat.list.adapter;

import com.discord.api.user.User;
import com.discord.models.message.Message;
import d0.z.d.Intrinsics3;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

/* compiled from: WidgetChatListItem.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;", "Lcom/discord/models/message/Message;", "message", "", "isUserMentioned", "(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;Lcom/discord/models/message/Message;)Z", "app_productionGoogleRelease"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListItemKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatListItem3 {
    /* JADX WARN: Removed duplicated region for block: B:27:0x007d A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean isUserMentioned(WidgetChatListAdapter widgetChatListAdapter, Message message) {
        boolean z2;
        Intrinsics3.checkNotNullParameter(widgetChatListAdapter, "$this$isUserMentioned");
        Intrinsics3.checkNotNullParameter(message, "message");
        if (widgetChatListAdapter.getMentionMeMessageLevelHighlighting()) {
            if (Intrinsics3.areEqual(message.getMentionEveryone(), Boolean.TRUE)) {
                return true;
            }
            List<User> mentions = message.getMentions();
            if (mentions != null) {
                Iterator<T> it = mentions.iterator();
                while (it.hasNext()) {
                    if (((User) it.next()).getId() == widgetChatListAdapter.getData().getUserId()) {
                        return true;
                    }
                }
            }
            List<Long> mentionRoles = message.getMentionRoles();
            if (mentionRoles != null) {
                if (mentionRoles.isEmpty()) {
                    z2 = false;
                    if (!z2) {
                        return true;
                    }
                } else {
                    Iterator<T> it2 = mentionRoles.iterator();
                    while (it2.hasNext()) {
                        if (widgetChatListAdapter.getData().getMyRoleIds().contains(Long.valueOf(((Number) it2.next()).longValue()))) {
                            z2 = true;
                            break;
                        }
                    }
                    z2 = false;
                    if (!z2) {
                    }
                }
            }
        }
        return false;
    }
}
