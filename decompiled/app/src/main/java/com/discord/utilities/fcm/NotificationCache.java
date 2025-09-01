package com.discord.utilities.fcm;

import android.annotation.SuppressLint;
import com.discord.app.AppLog;
import com.discord.utilities.fcm.NotificationData;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.persister.Persister;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: NotificationCache.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\n\u001a\u0004\u0018\u00010\u00042\n\u0010\t\u001a\u00060\u0007j\u0002`\b¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u000f\u001a\u00020\u000e2\n\u0010\t\u001a\u00060\u0007j\u0002`\b2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J5\u0010\u0015\u001a\u00020\u000e2\n\u0010\t\u001a\u00060\u0007j\u0002`\b2\u0006\u0010\u0011\u001a\u00020\f2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000e0\u0012¢\u0006\u0004\b\u0015\u0010\u0016R@\u0010\u001b\u001a,\u0012(\u0012&\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0018j\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u0004`\u001a0\u00178\u0002@\u0003X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/discord/utilities/fcm/NotificationCache;", "", "Lcom/discord/utilities/fcm/NotificationData;", "data", "Lcom/discord/utilities/fcm/NotificationData$DisplayPayload;", "getAndUpdate", "(Lcom/discord/utilities/fcm/NotificationData;)Lcom/discord/utilities/fcm/NotificationData$DisplayPayload;", "", "Lcom/discord/primitives/ChannelId;", "channelId", "get", "(J)Lcom/discord/utilities/fcm/NotificationData$DisplayPayload;", "", "shouldIgnoreNextClearForAck", "", "setIgnoreNextClearForAck", "(JZ)V", "isAckRequest", "Lkotlin/Function1;", "", "notificationRemovedCallback", "remove", "(JZLkotlin/jvm/functions/Function1;)V", "Lcom/discord/utilities/persister/Persister;", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "cache", "Lcom/discord/utilities/persister/Persister;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class NotificationCache {
    public static final NotificationCache INSTANCE = new NotificationCache();

    @SuppressLint({"StaticFieldLeak"})
    private static final Persister<HashMap<String, NotificationData.DisplayPayload>> cache = new Persister<>("NOTIFICATION_BUNDLES_V4", new HashMap());

    private NotificationCache() {
    }

    public final synchronized NotificationData.DisplayPayload get(long channelId) {
        Object next;
        NotificationData data;
        Collection<NotificationData.DisplayPayload> collectionValues = cache.get().values();
        Intrinsics3.checkNotNullExpressionValue(collectionValues, "cache.get().values");
        Iterator<T> it = collectionValues.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            NotificationData.DisplayPayload displayPayload = (NotificationData.DisplayPayload) next;
            if ((displayPayload == null || (data = displayPayload.getData()) == null || data.getChannelId() != channelId) ? false : true) {
                break;
            }
        }
        return (NotificationData.DisplayPayload) next;
    }

    public final synchronized NotificationData.DisplayPayload getAndUpdate(NotificationData data) {
        NotificationData.DisplayPayload displayPayload;
        Intrinsics3.checkNotNullParameter(data, "data");
        Persister<HashMap<String, NotificationData.DisplayPayload>> persister = cache;
        HashMap<String, NotificationData.DisplayPayload> map = new HashMap<>(persister.get());
        displayPayload = map.get(data.getKey());
        if (displayPayload == null) {
            displayPayload = new NotificationData.DisplayPayload(data);
            map.put(data.getKey(), displayPayload);
        }
        NotificationData.DisplayPayload.update$default(displayPayload, data, 0, 2, null);
        persister.set(map, true);
        return displayPayload;
    }

    public final synchronized void remove(long channelId, boolean isAckRequest, Function1<? super Integer, Unit> notificationRemovedCallback) {
        NotificationData data;
        Intrinsics3.checkNotNullParameter(notificationRemovedCallback, "notificationRemovedCallback");
        HashMap<String, NotificationData.DisplayPayload> map = new HashMap<>(cache.get());
        Iterator<NotificationData.DisplayPayload> it = map.values().iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            NotificationData.DisplayPayload next = it.next();
            if (next != null && (data = next.getData()) != null && data.getChannelId() == channelId) {
                if (isAckRequest && next.getIgnoreNextClearForAck()) {
                    next.setIgnoreNextClearForAck(false);
                } else {
                    notificationRemovedCallback.invoke(Integer.valueOf(next.getId()));
                    it.remove();
                }
                z2 = true;
            }
        }
        cache.set(map, z2);
    }

    public final synchronized void setIgnoreNextClearForAck(long channelId, boolean shouldIgnoreNextClearForAck) {
        boolean z2;
        HashMap<String, NotificationData.DisplayPayload> map = cache.get();
        Set<Map.Entry<String, NotificationData.DisplayPayload>> setEntrySet = map.entrySet();
        Intrinsics3.checkNotNullExpressionValue(setEntrySet, "content.entries");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String str = (String) entry.getKey();
            if (str == null) {
                str = "";
            }
            Intrinsics3.checkNotNullExpressionValue(str, "entry.key ?: \"\"");
            NotificationData.DisplayPayload displayPayload = (NotificationData.DisplayPayload) entry.getValue();
            if (displayPayload == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("displayPayload value read from the ");
                sb.append("NOTIFICATION_BUNDLES_V4 cache ");
                sb.append("in " + INSTANCE.getClass().getSimpleName() + " is null ");
                sb.append("for channelId: " + channelId + ' ');
                StringBuilder sb2 = new StringBuilder();
                sb2.append("and notification data type: ");
                sb2.append(str);
                sb.append(sb2.toString());
                AppLog appLog = AppLog.g;
                String string = sb.toString();
                Intrinsics3.checkNotNullExpressionValue(string, "warningMessage.toString()");
                Logger.w$default(appLog, string, null, 2, null);
            }
            if (displayPayload != null) {
                arrayList.add(displayPayload);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = arrayList.iterator();
        while (true) {
            boolean z3 = true;
            z2 = false;
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            NotificationData.DisplayPayload displayPayload2 = (NotificationData.DisplayPayload) next;
            if (displayPayload2.getData().getChannelId() != channelId || displayPayload2.getIgnoreNextClearForAck() == shouldIgnoreNextClearForAck) {
                z3 = false;
            }
            if (z3) {
                arrayList2.add(next);
            }
        }
        Iterator it3 = arrayList2.iterator();
        while (it3.hasNext()) {
            ((NotificationData.DisplayPayload) it3.next()).setIgnoreNextClearForAck(shouldIgnoreNextClearForAck);
            z2 = true;
        }
        cache.set(map, z2);
    }
}
