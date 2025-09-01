package com.discord.widgets.user;

import androidx.core.app.NotificationCompat;
import com.discord.api.message.Message;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

/* compiled from: WidgetUserMentions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0002*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00000\u00002\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/discord/api/message/Message;", "kotlin.jvm.PlatformType", "messages", "Lcom/discord/models/message/Message;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/List;)Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetUserMentions$Model$MessageLoader$tryLoad$2<T, R> implements Func1<List<? extends Message>, List<? extends com.discord.models.message.Message>> {
    public static final WidgetUserMentions$Model$MessageLoader$tryLoad$2 INSTANCE = new WidgetUserMentions$Model$MessageLoader$tryLoad$2();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ List<? extends com.discord.models.message.Message> call(List<? extends Message> list) {
        return call2((List<Message>) list);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final List<com.discord.models.message.Message> call2(List<Message> list) {
        Intrinsics3.checkNotNullExpressionValue(list, "messages");
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new com.discord.models.message.Message((Message) it.next()));
        }
        return arrayList;
    }
}
