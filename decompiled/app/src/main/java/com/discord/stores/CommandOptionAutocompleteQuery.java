package com.discord.stores;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: StoreApplicationCommands.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0006\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/stores/CommandOptionAutocompleteQuery;", "", "", "component1", "()Ljava/lang/String;", "component2", "queryString", "commandOptionName", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lcom/discord/stores/CommandOptionAutocompleteQuery;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getQueryString", "getCommandOptionName", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class CommandOptionAutocompleteQuery {
    private final String commandOptionName;
    private final String queryString;

    public CommandOptionAutocompleteQuery(String str, String str2) {
        Intrinsics3.checkNotNullParameter(str, "queryString");
        Intrinsics3.checkNotNullParameter(str2, "commandOptionName");
        this.queryString = str;
        this.commandOptionName = str2;
    }

    public static /* synthetic */ CommandOptionAutocompleteQuery copy$default(CommandOptionAutocompleteQuery commandOptionAutocompleteQuery, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = commandOptionAutocompleteQuery.queryString;
        }
        if ((i & 2) != 0) {
            str2 = commandOptionAutocompleteQuery.commandOptionName;
        }
        return commandOptionAutocompleteQuery.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getQueryString() {
        return this.queryString;
    }

    /* renamed from: component2, reason: from getter */
    public final String getCommandOptionName() {
        return this.commandOptionName;
    }

    public final CommandOptionAutocompleteQuery copy(String queryString, String commandOptionName) {
        Intrinsics3.checkNotNullParameter(queryString, "queryString");
        Intrinsics3.checkNotNullParameter(commandOptionName, "commandOptionName");
        return new CommandOptionAutocompleteQuery(queryString, commandOptionName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommandOptionAutocompleteQuery)) {
            return false;
        }
        CommandOptionAutocompleteQuery commandOptionAutocompleteQuery = (CommandOptionAutocompleteQuery) other;
        return Intrinsics3.areEqual(this.queryString, commandOptionAutocompleteQuery.queryString) && Intrinsics3.areEqual(this.commandOptionName, commandOptionAutocompleteQuery.commandOptionName);
    }

    public final String getCommandOptionName() {
        return this.commandOptionName;
    }

    public final String getQueryString() {
        return this.queryString;
    }

    public int hashCode() {
        String str = this.queryString;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.commandOptionName;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("CommandOptionAutocompleteQuery(queryString=");
        sbU.append(this.queryString);
        sbU.append(", commandOptionName=");
        return outline.J(sbU, this.commandOptionName, ")");
    }
}
