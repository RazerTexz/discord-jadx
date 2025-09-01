package com.discord.widgets.chat.input.models;

import b.d.b.a.outline;
import com.discord.models.commands.Application;
import com.discord.models.commands.ApplicationCommand;
import com.discord.widgets.chat.input.WidgetChatInputDiscoveryCommandsModel;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: AutocompleteApplicationCommands.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u001f\u0010 J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0005J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ<\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u001f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u001b\u0010\u0005R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001d\u0010\nR\u001f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001e\u0010\u0005¨\u0006!"}, d2 = {"Lcom/discord/widgets/chat/input/models/AutocompleteApplicationCommands;", "", "", "Lcom/discord/models/commands/Application;", "component1", "()Ljava/util/List;", "Lcom/discord/models/commands/ApplicationCommand;", "component2", "Lcom/discord/widgets/chat/input/WidgetChatInputDiscoveryCommandsModel;", "component3", "()Lcom/discord/widgets/chat/input/WidgetChatInputDiscoveryCommandsModel;", "applications", "queryCommands", "discoveryCommands", "copy", "(Ljava/util/List;Ljava/util/List;Lcom/discord/widgets/chat/input/WidgetChatInputDiscoveryCommandsModel;)Lcom/discord/widgets/chat/input/models/AutocompleteApplicationCommands;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getApplications", "Lcom/discord/widgets/chat/input/WidgetChatInputDiscoveryCommandsModel;", "getDiscoveryCommands", "getQueryCommands", "<init>", "(Ljava/util/List;Ljava/util/List;Lcom/discord/widgets/chat/input/WidgetChatInputDiscoveryCommandsModel;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class AutocompleteApplicationCommands {
    private final List<Application> applications;
    private final WidgetChatInputDiscoveryCommandsModel discoveryCommands;
    private final List<ApplicationCommand> queryCommands;

    public AutocompleteApplicationCommands() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AutocompleteApplicationCommands(List<Application> list, List<? extends ApplicationCommand> list2, WidgetChatInputDiscoveryCommandsModel widgetChatInputDiscoveryCommandsModel) {
        Intrinsics3.checkNotNullParameter(list, "applications");
        Intrinsics3.checkNotNullParameter(list2, "queryCommands");
        this.applications = list;
        this.queryCommands = list2;
        this.discoveryCommands = widgetChatInputDiscoveryCommandsModel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AutocompleteApplicationCommands copy$default(AutocompleteApplicationCommands autocompleteApplicationCommands, List list, List list2, WidgetChatInputDiscoveryCommandsModel widgetChatInputDiscoveryCommandsModel, int i, Object obj) {
        if ((i & 1) != 0) {
            list = autocompleteApplicationCommands.applications;
        }
        if ((i & 2) != 0) {
            list2 = autocompleteApplicationCommands.queryCommands;
        }
        if ((i & 4) != 0) {
            widgetChatInputDiscoveryCommandsModel = autocompleteApplicationCommands.discoveryCommands;
        }
        return autocompleteApplicationCommands.copy(list, list2, widgetChatInputDiscoveryCommandsModel);
    }

    public final List<Application> component1() {
        return this.applications;
    }

    public final List<ApplicationCommand> component2() {
        return this.queryCommands;
    }

    /* renamed from: component3, reason: from getter */
    public final WidgetChatInputDiscoveryCommandsModel getDiscoveryCommands() {
        return this.discoveryCommands;
    }

    public final AutocompleteApplicationCommands copy(List<Application> applications, List<? extends ApplicationCommand> queryCommands, WidgetChatInputDiscoveryCommandsModel discoveryCommands) {
        Intrinsics3.checkNotNullParameter(applications, "applications");
        Intrinsics3.checkNotNullParameter(queryCommands, "queryCommands");
        return new AutocompleteApplicationCommands(applications, queryCommands, discoveryCommands);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AutocompleteApplicationCommands)) {
            return false;
        }
        AutocompleteApplicationCommands autocompleteApplicationCommands = (AutocompleteApplicationCommands) other;
        return Intrinsics3.areEqual(this.applications, autocompleteApplicationCommands.applications) && Intrinsics3.areEqual(this.queryCommands, autocompleteApplicationCommands.queryCommands) && Intrinsics3.areEqual(this.discoveryCommands, autocompleteApplicationCommands.discoveryCommands);
    }

    public final List<Application> getApplications() {
        return this.applications;
    }

    public final WidgetChatInputDiscoveryCommandsModel getDiscoveryCommands() {
        return this.discoveryCommands;
    }

    public final List<ApplicationCommand> getQueryCommands() {
        return this.queryCommands;
    }

    public int hashCode() {
        List<Application> list = this.applications;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        List<ApplicationCommand> list2 = this.queryCommands;
        int iHashCode2 = (iHashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
        WidgetChatInputDiscoveryCommandsModel widgetChatInputDiscoveryCommandsModel = this.discoveryCommands;
        return iHashCode2 + (widgetChatInputDiscoveryCommandsModel != null ? widgetChatInputDiscoveryCommandsModel.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("AutocompleteApplicationCommands(applications=");
        sbU.append(this.applications);
        sbU.append(", queryCommands=");
        sbU.append(this.queryCommands);
        sbU.append(", discoveryCommands=");
        sbU.append(this.discoveryCommands);
        sbU.append(")");
        return sbU.toString();
    }

    public /* synthetic */ AutocompleteApplicationCommands(List list, List list2, WidgetChatInputDiscoveryCommandsModel widgetChatInputDiscoveryCommandsModel, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Collections2.emptyList() : list, (i & 2) != 0 ? Collections2.emptyList() : list2, (i & 4) != 0 ? null : widgetChatInputDiscoveryCommandsModel);
    }
}
