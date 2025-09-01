package com.discord.widgets.chat.input.autocomplete;

import b.d.b.a.outline;
import com.discord.models.commands.Application;
import com.discord.models.commands.ApplicationCommand;
import d0.t.CollectionsJVM;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: Autocompletable.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0016\u001a\u00020\u000e\u0012\u0006\u0010\u0017\u001a\u00020\u0011\u0012\u0006\u0010\u0018\u001a\u00020\u0011¢\u0006\u0004\b-\u0010.J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0013J:\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0016\u001a\u00020\u000e2\b\b\u0002\u0010\u0017\u001a\u00020\u00112\b\b\u0002\u0010\u0018\u001a\u00020\u0011HÆ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0007J\u0010\u0010\u001d\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010!\u001a\u00020\u00112\b\u0010 \u001a\u0004\u0018\u00010\u001fHÖ\u0003¢\u0006\u0004\b!\u0010\"R\u0019\u0010\u0016\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010#\u001a\u0004\b$\u0010\u0010R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010%\u001a\u0004\b&\u0010\rR\u0019\u0010\u0018\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010'\u001a\u0004\b(\u0010\u0013R\u001f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00050\b8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010\nR\u0019\u0010\u0017\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010'\u001a\u0004\b,\u0010\u0013¨\u0006/"}, d2 = {"Lcom/discord/widgets/chat/input/autocomplete/ApplicationCommandAutocompletable;", "Lcom/discord/widgets/chat/input/autocomplete/Autocompletable;", "Lcom/discord/widgets/chat/input/autocomplete/LeadingIdentifier;", "leadingIdentifier", "()Lcom/discord/widgets/chat/input/autocomplete/LeadingIdentifier;", "", "getInputReplacement", "()Ljava/lang/String;", "", "getInputTextMatchers", "()Ljava/util/List;", "Lcom/discord/models/commands/Application;", "component1", "()Lcom/discord/models/commands/Application;", "Lcom/discord/models/commands/ApplicationCommand;", "component2", "()Lcom/discord/models/commands/ApplicationCommand;", "", "component3", "()Z", "component4", "application", "command", "hasPermissionToUse", "showAvatar", "copy", "(Lcom/discord/models/commands/Application;Lcom/discord/models/commands/ApplicationCommand;ZZ)Lcom/discord/widgets/chat/input/autocomplete/ApplicationCommandAutocompletable;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/commands/ApplicationCommand;", "getCommand", "Lcom/discord/models/commands/Application;", "getApplication", "Z", "getShowAvatar", "textMatchers", "Ljava/util/List;", "getTextMatchers", "getHasPermissionToUse", "<init>", "(Lcom/discord/models/commands/Application;Lcom/discord/models/commands/ApplicationCommand;ZZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class ApplicationCommandAutocompletable extends Autocompletable {
    private final Application application;
    private final ApplicationCommand command;
    private final boolean hasPermissionToUse;
    private final boolean showAvatar;
    private final List<String> textMatchers;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApplicationCommandAutocompletable(Application application, ApplicationCommand applicationCommand, boolean z2, boolean z3) {
        super(null);
        Intrinsics3.checkNotNullParameter(applicationCommand, "command");
        this.application = application;
        this.command = applicationCommand;
        this.hasPermissionToUse = z2;
        this.showAvatar = z3;
        this.textMatchers = CollectionsJVM.listOf(leadingIdentifier().getIdentifier() + applicationCommand.getName());
    }

    public static /* synthetic */ ApplicationCommandAutocompletable copy$default(ApplicationCommandAutocompletable applicationCommandAutocompletable, Application application, ApplicationCommand applicationCommand, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            application = applicationCommandAutocompletable.application;
        }
        if ((i & 2) != 0) {
            applicationCommand = applicationCommandAutocompletable.command;
        }
        if ((i & 4) != 0) {
            z2 = applicationCommandAutocompletable.hasPermissionToUse;
        }
        if ((i & 8) != 0) {
            z3 = applicationCommandAutocompletable.showAvatar;
        }
        return applicationCommandAutocompletable.copy(application, applicationCommand, z2, z3);
    }

    /* renamed from: component1, reason: from getter */
    public final Application getApplication() {
        return this.application;
    }

    /* renamed from: component2, reason: from getter */
    public final ApplicationCommand getCommand() {
        return this.command;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getHasPermissionToUse() {
        return this.hasPermissionToUse;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getShowAvatar() {
        return this.showAvatar;
    }

    public final ApplicationCommandAutocompletable copy(Application application, ApplicationCommand command, boolean hasPermissionToUse, boolean showAvatar) {
        Intrinsics3.checkNotNullParameter(command, "command");
        return new ApplicationCommandAutocompletable(application, command, hasPermissionToUse, showAvatar);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApplicationCommandAutocompletable)) {
            return false;
        }
        ApplicationCommandAutocompletable applicationCommandAutocompletable = (ApplicationCommandAutocompletable) other;
        return Intrinsics3.areEqual(this.application, applicationCommandAutocompletable.application) && Intrinsics3.areEqual(this.command, applicationCommandAutocompletable.command) && this.hasPermissionToUse == applicationCommandAutocompletable.hasPermissionToUse && this.showAvatar == applicationCommandAutocompletable.showAvatar;
    }

    public final Application getApplication() {
        return this.application;
    }

    public final ApplicationCommand getCommand() {
        return this.command;
    }

    public final boolean getHasPermissionToUse() {
        return this.hasPermissionToUse;
    }

    @Override // com.discord.widgets.chat.input.autocomplete.Autocompletable
    public String getInputReplacement() {
        return leadingIdentifier().getIdentifier() + this.command.getName();
    }

    @Override // com.discord.widgets.chat.input.autocomplete.Autocompletable
    public List<String> getInputTextMatchers() {
        return this.textMatchers;
    }

    public final boolean getShowAvatar() {
        return this.showAvatar;
    }

    public final List<String> getTextMatchers() {
        return this.textMatchers;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        Application application = this.application;
        int iHashCode = (application != null ? application.hashCode() : 0) * 31;
        ApplicationCommand applicationCommand = this.command;
        int iHashCode2 = (iHashCode + (applicationCommand != null ? applicationCommand.hashCode() : 0)) * 31;
        boolean z2 = this.hasPermissionToUse;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iHashCode2 + i) * 31;
        boolean z3 = this.showAvatar;
        return i2 + (z3 ? 1 : z3 ? 1 : 0);
    }

    @Override // com.discord.widgets.chat.input.autocomplete.Autocompletable
    public LeadingIdentifier leadingIdentifier() {
        return LeadingIdentifier.APP_COMMAND;
    }

    public String toString() {
        StringBuilder sbU = outline.U("ApplicationCommandAutocompletable(application=");
        sbU.append(this.application);
        sbU.append(", command=");
        sbU.append(this.command);
        sbU.append(", hasPermissionToUse=");
        sbU.append(this.hasPermissionToUse);
        sbU.append(", showAvatar=");
        return outline.O(sbU, this.showAvatar, ")");
    }
}
