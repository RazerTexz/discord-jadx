package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.api.permission.Permission;
import com.discord.utilities.permissions.PermissionUtils;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: StoreNotifications.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\n\u001a<\u0012\b\u0012\u00060\u0001j\u0002`\u0002 \u0004*\u001e\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0018\u00010\u0006j\u000e\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0018\u0001`\u00070\u0006j\f\u0012\b\u0012\u00060\u0001j\u0002`\u0002`\u000726\u0010\u0005\u001a2\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0001j\u0002`\u0003 \u0004*\u0018\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0001j\u0002`\u0003\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/permission/PermissionBit;", "kotlin.jvm.PlatformType", "channelPermissions", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;)Ljava/util/HashSet;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.stores.StoreNotifications$configureNotificationClient$completedSettings$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreNotifications2<T, R> implements Func1<Map<Long, ? extends Long>, HashSet<Long>> {
    public static final StoreNotifications2 INSTANCE = new StoreNotifications2();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ HashSet<Long> call(Map<Long, ? extends Long> map) {
        return call2((Map<Long, Long>) map);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final HashSet<Long> call2(Map<Long, Long> map) {
        Intrinsics3.checkNotNullExpressionValue(map, "channelPermissions");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<Long, Long> entry : map.entrySet()) {
            if (!PermissionUtils.can(Permission.SEND_MESSAGES, Long.valueOf(entry.getValue().longValue()))) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return _Collections.toHashSet(linkedHashMap.keySet());
    }
}
