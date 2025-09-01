package com.discord.widgets.chat.input.autocomplete;

import b.d.b.a.outline;
import com.discord.models.commands.Application;
import com.discord.models.commands.ApplicationCommand;
import com.discord.models.commands.ApplicationCommandOption;
import d0.t.Maps6;
import d0.t.Sets5;
import d0.z.d.Intrinsics3;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: AutocompleteViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/chat/input/autocomplete/SelectedCommandViewState;", "", "<init>", "()V", "Hidden", "SelectedCommand", "Lcom/discord/widgets/chat/input/autocomplete/SelectedCommandViewState$Hidden;", "Lcom/discord/widgets/chat/input/autocomplete/SelectedCommandViewState$SelectedCommand;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.input.autocomplete.SelectedCommandViewState, reason: use source file name */
/* loaded from: classes2.dex */
public abstract class AutocompleteViewModel6 {

    /* compiled from: AutocompleteViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/chat/input/autocomplete/SelectedCommandViewState$Hidden;", "Lcom/discord/widgets/chat/input/autocomplete/SelectedCommandViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.autocomplete.SelectedCommandViewState$Hidden */
    public static final class Hidden extends AutocompleteViewModel6 {
        public static final Hidden INSTANCE = new Hidden();

        private Hidden() {
            super(null);
        }
    }

    private AutocompleteViewModel6() {
    }

    /* compiled from: AutocompleteViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\b\u0012\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0010\u0016\u001a\u00020\u000f¢\u0006\u0004\b-\u0010.J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u001c\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011JV\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000b2\b\b\u0002\u0010\u0016\u001a\u00020\u000fHÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010!\u001a\u00020\f2\b\u0010 \u001a\u0004\u0018\u00010\u001fHÖ\u0003¢\u0006\u0004\b!\u0010\"R\u0019\u0010\u0012\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010#\u001a\u0004\b$\u0010\u0004R\u001f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010%\u001a\u0004\b&\u0010\nR\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010'\u001a\u0004\b(\u0010\u0007R%\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010)\u001a\u0004\b*\u0010\u000eR\u0019\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010+\u001a\u0004\b,\u0010\u0011¨\u0006/"}, d2 = {"Lcom/discord/widgets/chat/input/autocomplete/SelectedCommandViewState$SelectedCommand;", "Lcom/discord/widgets/chat/input/autocomplete/SelectedCommandViewState;", "Lcom/discord/models/commands/ApplicationCommand;", "component1", "()Lcom/discord/models/commands/ApplicationCommand;", "Lcom/discord/models/commands/ApplicationCommandOption;", "component2", "()Lcom/discord/models/commands/ApplicationCommandOption;", "", "component3", "()Ljava/util/Set;", "", "", "component4", "()Ljava/util/Map;", "Lcom/discord/models/commands/Application;", "component5", "()Lcom/discord/models/commands/Application;", "selectedCommand", "selectedCommandOption", "selectedCommandOptionErrors", "validSelectedCommandOptions", "selectedApplication", "copy", "(Lcom/discord/models/commands/ApplicationCommand;Lcom/discord/models/commands/ApplicationCommandOption;Ljava/util/Set;Ljava/util/Map;Lcom/discord/models/commands/Application;)Lcom/discord/widgets/chat/input/autocomplete/SelectedCommandViewState$SelectedCommand;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/commands/ApplicationCommand;", "getSelectedCommand", "Ljava/util/Set;", "getSelectedCommandOptionErrors", "Lcom/discord/models/commands/ApplicationCommandOption;", "getSelectedCommandOption", "Ljava/util/Map;", "getValidSelectedCommandOptions", "Lcom/discord/models/commands/Application;", "getSelectedApplication", "<init>", "(Lcom/discord/models/commands/ApplicationCommand;Lcom/discord/models/commands/ApplicationCommandOption;Ljava/util/Set;Ljava/util/Map;Lcom/discord/models/commands/Application;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.autocomplete.SelectedCommandViewState$SelectedCommand */
    public static final /* data */ class SelectedCommand extends AutocompleteViewModel6 {
        private final Application selectedApplication;
        private final ApplicationCommand selectedCommand;
        private final ApplicationCommandOption selectedCommandOption;
        private final Set<ApplicationCommandOption> selectedCommandOptionErrors;
        private final Map<ApplicationCommandOption, Boolean> validSelectedCommandOptions;

        public /* synthetic */ SelectedCommand(ApplicationCommand applicationCommand, ApplicationCommandOption applicationCommandOption, Set set, Map map, Application application, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(applicationCommand, applicationCommandOption, (i & 4) != 0 ? Sets5.emptySet() : set, (i & 8) != 0 ? Maps6.emptyMap() : map, application);
        }

        public static /* synthetic */ SelectedCommand copy$default(SelectedCommand selectedCommand, ApplicationCommand applicationCommand, ApplicationCommandOption applicationCommandOption, Set set, Map map, Application application, int i, Object obj) {
            if ((i & 1) != 0) {
                applicationCommand = selectedCommand.selectedCommand;
            }
            if ((i & 2) != 0) {
                applicationCommandOption = selectedCommand.selectedCommandOption;
            }
            ApplicationCommandOption applicationCommandOption2 = applicationCommandOption;
            if ((i & 4) != 0) {
                set = selectedCommand.selectedCommandOptionErrors;
            }
            Set set2 = set;
            if ((i & 8) != 0) {
                map = selectedCommand.validSelectedCommandOptions;
            }
            Map map2 = map;
            if ((i & 16) != 0) {
                application = selectedCommand.selectedApplication;
            }
            return selectedCommand.copy(applicationCommand, applicationCommandOption2, set2, map2, application);
        }

        /* renamed from: component1, reason: from getter */
        public final ApplicationCommand getSelectedCommand() {
            return this.selectedCommand;
        }

        /* renamed from: component2, reason: from getter */
        public final ApplicationCommandOption getSelectedCommandOption() {
            return this.selectedCommandOption;
        }

        public final Set<ApplicationCommandOption> component3() {
            return this.selectedCommandOptionErrors;
        }

        public final Map<ApplicationCommandOption, Boolean> component4() {
            return this.validSelectedCommandOptions;
        }

        /* renamed from: component5, reason: from getter */
        public final Application getSelectedApplication() {
            return this.selectedApplication;
        }

        public final SelectedCommand copy(ApplicationCommand selectedCommand, ApplicationCommandOption selectedCommandOption, Set<ApplicationCommandOption> selectedCommandOptionErrors, Map<ApplicationCommandOption, Boolean> validSelectedCommandOptions, Application selectedApplication) {
            Intrinsics3.checkNotNullParameter(selectedCommand, "selectedCommand");
            Intrinsics3.checkNotNullParameter(selectedCommandOptionErrors, "selectedCommandOptionErrors");
            Intrinsics3.checkNotNullParameter(validSelectedCommandOptions, "validSelectedCommandOptions");
            Intrinsics3.checkNotNullParameter(selectedApplication, "selectedApplication");
            return new SelectedCommand(selectedCommand, selectedCommandOption, selectedCommandOptionErrors, validSelectedCommandOptions, selectedApplication);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SelectedCommand)) {
                return false;
            }
            SelectedCommand selectedCommand = (SelectedCommand) other;
            return Intrinsics3.areEqual(this.selectedCommand, selectedCommand.selectedCommand) && Intrinsics3.areEqual(this.selectedCommandOption, selectedCommand.selectedCommandOption) && Intrinsics3.areEqual(this.selectedCommandOptionErrors, selectedCommand.selectedCommandOptionErrors) && Intrinsics3.areEqual(this.validSelectedCommandOptions, selectedCommand.validSelectedCommandOptions) && Intrinsics3.areEqual(this.selectedApplication, selectedCommand.selectedApplication);
        }

        public final Application getSelectedApplication() {
            return this.selectedApplication;
        }

        public final ApplicationCommand getSelectedCommand() {
            return this.selectedCommand;
        }

        public final ApplicationCommandOption getSelectedCommandOption() {
            return this.selectedCommandOption;
        }

        public final Set<ApplicationCommandOption> getSelectedCommandOptionErrors() {
            return this.selectedCommandOptionErrors;
        }

        public final Map<ApplicationCommandOption, Boolean> getValidSelectedCommandOptions() {
            return this.validSelectedCommandOptions;
        }

        public int hashCode() {
            ApplicationCommand applicationCommand = this.selectedCommand;
            int iHashCode = (applicationCommand != null ? applicationCommand.hashCode() : 0) * 31;
            ApplicationCommandOption applicationCommandOption = this.selectedCommandOption;
            int iHashCode2 = (iHashCode + (applicationCommandOption != null ? applicationCommandOption.hashCode() : 0)) * 31;
            Set<ApplicationCommandOption> set = this.selectedCommandOptionErrors;
            int iHashCode3 = (iHashCode2 + (set != null ? set.hashCode() : 0)) * 31;
            Map<ApplicationCommandOption, Boolean> map = this.validSelectedCommandOptions;
            int iHashCode4 = (iHashCode3 + (map != null ? map.hashCode() : 0)) * 31;
            Application application = this.selectedApplication;
            return iHashCode4 + (application != null ? application.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("SelectedCommand(selectedCommand=");
            sbU.append(this.selectedCommand);
            sbU.append(", selectedCommandOption=");
            sbU.append(this.selectedCommandOption);
            sbU.append(", selectedCommandOptionErrors=");
            sbU.append(this.selectedCommandOptionErrors);
            sbU.append(", validSelectedCommandOptions=");
            sbU.append(this.validSelectedCommandOptions);
            sbU.append(", selectedApplication=");
            sbU.append(this.selectedApplication);
            sbU.append(")");
            return sbU.toString();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SelectedCommand(ApplicationCommand applicationCommand, ApplicationCommandOption applicationCommandOption, Set<ApplicationCommandOption> set, Map<ApplicationCommandOption, Boolean> map, Application application) {
            super(null);
            Intrinsics3.checkNotNullParameter(applicationCommand, "selectedCommand");
            Intrinsics3.checkNotNullParameter(set, "selectedCommandOptionErrors");
            Intrinsics3.checkNotNullParameter(map, "validSelectedCommandOptions");
            Intrinsics3.checkNotNullParameter(application, "selectedApplication");
            this.selectedCommand = applicationCommand;
            this.selectedCommandOption = applicationCommandOption;
            this.selectedCommandOptionErrors = set;
            this.validSelectedCommandOptions = map;
            this.selectedApplication = application;
        }
    }

    public /* synthetic */ AutocompleteViewModel6(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
