package com.discord.widgets.chat.input.models;

import b.d.b.a.outline;
import com.discord.models.commands.Application;
import com.discord.models.commands.ApplicationCommand;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ApplicationCommandData.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\b\b\u0002\u0010\u0012\u001a\u00020\f¢\u0006\u0004\b&\u0010'J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ>\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00052\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\u0012\u001a\u00020\fHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001c\u001a\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u0019\u0010\u0012\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u001e\u001a\u0004\b\u001f\u0010\u000eR\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010 \u001a\u0004\b!\u0010\u0004R\u001f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\"\u001a\u0004\b#\u0010\u000bR\u0019\u0010\u0010\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010$\u001a\u0004\b%\u0010\u0007¨\u0006("}, d2 = {"Lcom/discord/widgets/chat/input/models/ApplicationCommandData;", "", "Lcom/discord/models/commands/Application;", "component1", "()Lcom/discord/models/commands/Application;", "Lcom/discord/models/commands/ApplicationCommand;", "component2", "()Lcom/discord/models/commands/ApplicationCommand;", "", "Lcom/discord/widgets/chat/input/models/ApplicationCommandValue;", "component3", "()Ljava/util/List;", "", "component4", "()Z", "application", "applicationCommand", "values", "validInputs", "copy", "(Lcom/discord/models/commands/Application;Lcom/discord/models/commands/ApplicationCommand;Ljava/util/List;Z)Lcom/discord/widgets/chat/input/models/ApplicationCommandData;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getValidInputs", "Lcom/discord/models/commands/Application;", "getApplication", "Ljava/util/List;", "getValues", "Lcom/discord/models/commands/ApplicationCommand;", "getApplicationCommand", "<init>", "(Lcom/discord/models/commands/Application;Lcom/discord/models/commands/ApplicationCommand;Ljava/util/List;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class ApplicationCommandData {
    private final Application application;
    private final ApplicationCommand applicationCommand;
    private final boolean validInputs;
    private final List<ApplicationCommandValue> values;

    public ApplicationCommandData(Application application, ApplicationCommand applicationCommand, List<ApplicationCommandValue> list, boolean z2) {
        Intrinsics3.checkNotNullParameter(application, "application");
        Intrinsics3.checkNotNullParameter(applicationCommand, "applicationCommand");
        Intrinsics3.checkNotNullParameter(list, "values");
        this.application = application;
        this.applicationCommand = applicationCommand;
        this.values = list;
        this.validInputs = z2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ApplicationCommandData copy$default(ApplicationCommandData applicationCommandData, Application application, ApplicationCommand applicationCommand, List list, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            application = applicationCommandData.application;
        }
        if ((i & 2) != 0) {
            applicationCommand = applicationCommandData.applicationCommand;
        }
        if ((i & 4) != 0) {
            list = applicationCommandData.values;
        }
        if ((i & 8) != 0) {
            z2 = applicationCommandData.validInputs;
        }
        return applicationCommandData.copy(application, applicationCommand, list, z2);
    }

    /* renamed from: component1, reason: from getter */
    public final Application getApplication() {
        return this.application;
    }

    /* renamed from: component2, reason: from getter */
    public final ApplicationCommand getApplicationCommand() {
        return this.applicationCommand;
    }

    public final List<ApplicationCommandValue> component3() {
        return this.values;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getValidInputs() {
        return this.validInputs;
    }

    public final ApplicationCommandData copy(Application application, ApplicationCommand applicationCommand, List<ApplicationCommandValue> values, boolean validInputs) {
        Intrinsics3.checkNotNullParameter(application, "application");
        Intrinsics3.checkNotNullParameter(applicationCommand, "applicationCommand");
        Intrinsics3.checkNotNullParameter(values, "values");
        return new ApplicationCommandData(application, applicationCommand, values, validInputs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApplicationCommandData)) {
            return false;
        }
        ApplicationCommandData applicationCommandData = (ApplicationCommandData) other;
        return Intrinsics3.areEqual(this.application, applicationCommandData.application) && Intrinsics3.areEqual(this.applicationCommand, applicationCommandData.applicationCommand) && Intrinsics3.areEqual(this.values, applicationCommandData.values) && this.validInputs == applicationCommandData.validInputs;
    }

    public final Application getApplication() {
        return this.application;
    }

    public final ApplicationCommand getApplicationCommand() {
        return this.applicationCommand;
    }

    public final boolean getValidInputs() {
        return this.validInputs;
    }

    public final List<ApplicationCommandValue> getValues() {
        return this.values;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        Application application = this.application;
        int iHashCode = (application != null ? application.hashCode() : 0) * 31;
        ApplicationCommand applicationCommand = this.applicationCommand;
        int iHashCode2 = (iHashCode + (applicationCommand != null ? applicationCommand.hashCode() : 0)) * 31;
        List<ApplicationCommandValue> list = this.values;
        int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        boolean z2 = this.validInputs;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        return iHashCode3 + i;
    }

    public String toString() {
        StringBuilder sbU = outline.U("ApplicationCommandData(application=");
        sbU.append(this.application);
        sbU.append(", applicationCommand=");
        sbU.append(this.applicationCommand);
        sbU.append(", values=");
        sbU.append(this.values);
        sbU.append(", validInputs=");
        return outline.O(sbU, this.validInputs, ")");
    }

    public /* synthetic */ ApplicationCommandData(Application application, ApplicationCommand applicationCommand, List list, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(application, applicationCommand, list, (i & 8) != 0 ? false : z2);
    }
}
