package com.discord.widgets.chat.input.models;

import b.d.b.a.outline;
import com.discord.models.commands.Application;
import com.discord.models.commands.ApplicationCommand;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: InputCommandContext.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007R\u0019\u0010\u0018\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u001aR\u001b\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004¨\u0006\u001f"}, d2 = {"Lcom/discord/widgets/chat/input/models/InputCommandContext;", "", "Lcom/discord/models/commands/Application;", "component1", "()Lcom/discord/models/commands/Application;", "Lcom/discord/models/commands/ApplicationCommand;", "component2", "()Lcom/discord/models/commands/ApplicationCommand;", "selectedApplication", "selectedCommand", "copy", "(Lcom/discord/models/commands/Application;Lcom/discord/models/commands/ApplicationCommand;)Lcom/discord/widgets/chat/input/models/InputCommandContext;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/commands/ApplicationCommand;", "getSelectedCommand", "isCommand", "Z", "()Z", "Lcom/discord/models/commands/Application;", "getSelectedApplication", "<init>", "(Lcom/discord/models/commands/Application;Lcom/discord/models/commands/ApplicationCommand;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class InputCommandContext {
    private final boolean isCommand;
    private final Application selectedApplication;
    private final ApplicationCommand selectedCommand;

    public InputCommandContext() {
        this(null, null, 3, null);
    }

    public InputCommandContext(Application application, ApplicationCommand applicationCommand) {
        this.selectedApplication = application;
        this.selectedCommand = applicationCommand;
        this.isCommand = applicationCommand != null;
    }

    public static /* synthetic */ InputCommandContext copy$default(InputCommandContext inputCommandContext, Application application, ApplicationCommand applicationCommand, int i, Object obj) {
        if ((i & 1) != 0) {
            application = inputCommandContext.selectedApplication;
        }
        if ((i & 2) != 0) {
            applicationCommand = inputCommandContext.selectedCommand;
        }
        return inputCommandContext.copy(application, applicationCommand);
    }

    /* renamed from: component1, reason: from getter */
    public final Application getSelectedApplication() {
        return this.selectedApplication;
    }

    /* renamed from: component2, reason: from getter */
    public final ApplicationCommand getSelectedCommand() {
        return this.selectedCommand;
    }

    public final InputCommandContext copy(Application selectedApplication, ApplicationCommand selectedCommand) {
        return new InputCommandContext(selectedApplication, selectedCommand);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InputCommandContext)) {
            return false;
        }
        InputCommandContext inputCommandContext = (InputCommandContext) other;
        return Intrinsics3.areEqual(this.selectedApplication, inputCommandContext.selectedApplication) && Intrinsics3.areEqual(this.selectedCommand, inputCommandContext.selectedCommand);
    }

    public final Application getSelectedApplication() {
        return this.selectedApplication;
    }

    public final ApplicationCommand getSelectedCommand() {
        return this.selectedCommand;
    }

    public int hashCode() {
        Application application = this.selectedApplication;
        int iHashCode = (application != null ? application.hashCode() : 0) * 31;
        ApplicationCommand applicationCommand = this.selectedCommand;
        return iHashCode + (applicationCommand != null ? applicationCommand.hashCode() : 0);
    }

    /* renamed from: isCommand, reason: from getter */
    public final boolean getIsCommand() {
        return this.isCommand;
    }

    public String toString() {
        StringBuilder sbU = outline.U("InputCommandContext(selectedApplication=");
        sbU.append(this.selectedApplication);
        sbU.append(", selectedCommand=");
        sbU.append(this.selectedCommand);
        sbU.append(")");
        return sbU.toString();
    }

    public /* synthetic */ InputCommandContext(Application application, ApplicationCommand applicationCommand, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : application, (i & 2) != 0 ? null : applicationCommand);
    }
}
