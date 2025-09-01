package com.discord.models.commands;

import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

/* compiled from: ApplicationCommand.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a/\u0010\b\u001a\u00020\u0007*\u00020\u00002\n\u0010\u0003\u001a\u00060\u0001j\u0002`\u00022\u0010\u0010\u0006\u001a\f\u0012\b\u0012\u00060\u0001j\u0002`\u00050\u0004¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/discord/models/commands/ApplicationCommand;", "", "Lcom/discord/primitives/UserId;", "userId", "", "Lcom/discord/primitives/RoleId;", "roles", "", "hasPermission", "(Lcom/discord/models/commands/ApplicationCommand;JLjava/util/List;)Z", "app_productionGoogleRelease"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.models.commands.ApplicationCommandKt, reason: use source file name */
/* loaded from: classes.dex */
public final class ApplicationCommand2 {
    public static final boolean hasPermission(ApplicationCommand applicationCommand, long j, List<Long> list) {
        Object next;
        Intrinsics3.checkNotNullParameter(applicationCommand, "$this$hasPermission");
        Intrinsics3.checkNotNullParameter(list, "roles");
        if (applicationCommand.getDefaultPermissions() == null) {
            return true;
        }
        if (applicationCommand.getPermissions() != null) {
            Boolean bool = applicationCommand.getPermissions().get(Long.valueOf(j));
            if (bool != null) {
                return bool.booleanValue();
            }
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(applicationCommand.getPermissions().get(Long.valueOf(((Number) it.next()).longValue())));
            }
            Iterator it2 = arrayList.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                }
                next = it2.next();
                if (Intrinsics3.areEqual((Boolean) next, Boolean.TRUE)) {
                    break;
                }
            }
            Boolean bool2 = (Boolean) next;
            if (bool2 != null) {
                return bool2.booleanValue();
            }
        }
        return applicationCommand.getDefaultPermissions().booleanValue();
    }
}
