package com.discord.widgets.servers.auditlog;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import rx.Observable;

/* compiled from: WidgetServerSettingsAuditLogFilter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\n\u001aj\u0012.\b\u0001\u0012*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0007 \u0003*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00060\u0006 \u0003*4\u0012.\b\u0001\u0012*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0007 \u0003*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00060\u0006\u0018\u00010\u00050\u00052\"\u0010\u0004\u001a\u001e\u0012\b\u0012\u00060\u0001j\u0002`\u0002 \u0003*\u000e\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"", "", "Lcom/discord/primitives/UserId;", "kotlin.jvm.PlatformType", "it", "Lrx/Observable;", "", "Lcom/discord/models/user/User;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Set;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilter$Model$Companion$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLogFilter3<T, R> implements Func1<Set<? extends Long>, Observable<? extends Map<Long, ? extends User>>> {
    public static final WidgetServerSettingsAuditLogFilter3 INSTANCE = new WidgetServerSettingsAuditLogFilter3();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends Map<Long, ? extends User>> call(Set<? extends Long> set) {
        return call2((Set<Long>) set);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Map<Long, User>> call2(Set<Long> set) {
        StoreUser users = StoreStream.INSTANCE.getUsers();
        Intrinsics3.checkNotNullExpressionValue(set, "it");
        return users.observeUsers(set);
    }
}
