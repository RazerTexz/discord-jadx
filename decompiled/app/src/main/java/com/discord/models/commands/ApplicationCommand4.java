package com.discord.models.commands;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ApplicationCommand.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012$\b\u0002\u0010\u0010\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e\u0012\u0004\u0012\u00020\u0002\u0018\u00010\r¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/discord/models/commands/BuiltInCommand;", "Lcom/discord/models/commands/ApplicationCommand;", "", ModelAuditLogEntry.CHANGE_KEY_ID, "", "Lcom/discord/primitives/ApplicationId;", "applicationId", ModelAuditLogEntry.CHANGE_KEY_NAME, "", "descriptionRes", "", "Lcom/discord/models/commands/ApplicationCommandOption;", "options", "Lkotlin/Function1;", "", "", "execute", "<init>", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/Integer;Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.models.commands.BuiltInCommand, reason: use source file name */
/* loaded from: classes.dex */
public final class ApplicationCommand4 extends ApplicationCommand {
    public /* synthetic */ ApplicationCommand4(String str, long j, String str2, Integer num, List list, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, str2, (i & 8) != 0 ? null : num, list, (i & 32) != 0 ? null : function1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApplicationCommand4(String str, long j, String str2, Integer num, List<ApplicationCommandOption> list, Function1<? super Map<String, ? extends Object>, String> function1) {
        super(str, j, str2, null, num, list, true, null, null, null, null, function1, 1928, null);
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_ID);
        Intrinsics3.checkNotNullParameter(str2, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(list, "options");
    }
}
