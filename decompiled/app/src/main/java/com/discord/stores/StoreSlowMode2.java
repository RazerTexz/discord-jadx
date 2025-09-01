package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreSlowMode;
import com.discord.utilities.permissions.PermissionUtils;
import j0.k.Func1;
import kotlin.Metadata;

/* compiled from: StoreSlowMode.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/discord/api/permission/PermissionBit;", ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS, "", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Long;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.stores.StoreSlowMode$getChannelCooldownObservable$newObservable$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreSlowMode2<T, R> implements Func1<Long, Boolean> {
    public final /* synthetic */ StoreSlowMode.Type $type;

    public StoreSlowMode2(StoreSlowMode.Type type) {
        this.$type = type;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Boolean call(Long l) {
        return call2(l);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(Long l) {
        return Boolean.valueOf(PermissionUtils.INSTANCE.hasBypassSlowmodePermissions(l, this.$type));
    }
}
