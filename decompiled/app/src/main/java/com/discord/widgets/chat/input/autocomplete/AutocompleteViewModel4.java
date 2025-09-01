package com.discord.widgets.chat.input.autocomplete;

import b.d.b.a.outline;
import com.discord.models.commands.Application;
import com.discord.models.commands.ApplicationCommand;
import com.discord.widgets.chat.input.WidgetChatInputAutocompleteStickerAdapter2;
import com.discord.widgets.chat.input.WidgetChatInputDiscoveryCommandsModel;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: AutocompleteViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/discord/widgets/chat/input/autocomplete/AutocompleteViewState;", "", "<init>", "()V", "Autocomplete", "CommandBrowser", "Hidden", "LoadingItems", "Lcom/discord/widgets/chat/input/autocomplete/AutocompleteViewState$Hidden;", "Lcom/discord/widgets/chat/input/autocomplete/AutocompleteViewState$LoadingItems;", "Lcom/discord/widgets/chat/input/autocomplete/AutocompleteViewState$CommandBrowser;", "Lcom/discord/widgets/chat/input/autocomplete/AutocompleteViewState$Autocomplete;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.input.autocomplete.AutocompleteViewState, reason: use source file name */
/* loaded from: classes2.dex */
public abstract class AutocompleteViewModel4 {

    /* compiled from: AutocompleteViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007\u0012\u0006\u0010\u0015\u001a\u00020\r¢\u0006\u0004\b&\u0010'J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007HÆ\u0003¢\u0006\u0004\b\f\u0010\nJ\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJX\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00022\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00072\b\b\u0002\u0010\u0015\u001a\u00020\rHÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u000fJ\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001e\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u0019\u0010\u0015\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010 \u001a\u0004\b!\u0010\u000fR\u001f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\"\u001a\u0004\b#\u0010\nR\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010$\u001a\u0004\b\u0010\u0010\u0004R\u001f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\"\u001a\u0004\b%\u0010\nR\u0019\u0010\u0011\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010$\u001a\u0004\b\u0011\u0010\u0004R\u0019\u0010\u0012\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010$\u001a\u0004\b\u0012\u0010\u0004¨\u0006("}, d2 = {"Lcom/discord/widgets/chat/input/autocomplete/AutocompleteViewState$Autocomplete;", "Lcom/discord/widgets/chat/input/autocomplete/AutocompleteViewState;", "", "component1", "()Z", "component2", "component3", "", "Lcom/discord/widgets/chat/input/autocomplete/Autocompletable;", "component4", "()Ljava/util/List;", "Lcom/discord/widgets/chat/input/AutocompleteStickerItem;", "component5", "", "component6", "()Ljava/lang/String;", "isLoading", "isError", "isAutocomplete", "autocompletables", "stickers", "token", "copy", "(ZZZLjava/util/List;Ljava/util/List;Ljava/lang/String;)Lcom/discord/widgets/chat/input/autocomplete/AutocompleteViewState$Autocomplete;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getToken", "Ljava/util/List;", "getStickers", "Z", "getAutocompletables", "<init>", "(ZZZLjava/util/List;Ljava/util/List;Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.autocomplete.AutocompleteViewState$Autocomplete */
    public static final /* data */ class Autocomplete extends AutocompleteViewModel4 {
        private final List<Autocompletable> autocompletables;
        private final boolean isAutocomplete;
        private final boolean isError;
        private final boolean isLoading;
        private final List<WidgetChatInputAutocompleteStickerAdapter2> stickers;
        private final String token;

        public /* synthetic */ Autocomplete(boolean z2, boolean z3, boolean z4, List list, List list2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z2, (i & 2) != 0 ? false : z3, (i & 4) != 0 ? false : z4, list, list2, str);
        }

        public static /* synthetic */ Autocomplete copy$default(Autocomplete autocomplete, boolean z2, boolean z3, boolean z4, List list, List list2, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = autocomplete.isLoading;
            }
            if ((i & 2) != 0) {
                z3 = autocomplete.isError;
            }
            boolean z5 = z3;
            if ((i & 4) != 0) {
                z4 = autocomplete.isAutocomplete;
            }
            boolean z6 = z4;
            if ((i & 8) != 0) {
                list = autocomplete.autocompletables;
            }
            List list3 = list;
            if ((i & 16) != 0) {
                list2 = autocomplete.stickers;
            }
            List list4 = list2;
            if ((i & 32) != 0) {
                str = autocomplete.token;
            }
            return autocomplete.copy(z2, z5, z6, list3, list4, str);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getIsLoading() {
            return this.isLoading;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getIsError() {
            return this.isError;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getIsAutocomplete() {
            return this.isAutocomplete;
        }

        public final List<Autocompletable> component4() {
            return this.autocompletables;
        }

        public final List<WidgetChatInputAutocompleteStickerAdapter2> component5() {
            return this.stickers;
        }

        /* renamed from: component6, reason: from getter */
        public final String getToken() {
            return this.token;
        }

        public final Autocomplete copy(boolean isLoading, boolean isError, boolean isAutocomplete, List<? extends Autocompletable> autocompletables, List<WidgetChatInputAutocompleteStickerAdapter2> stickers, String token) {
            Intrinsics3.checkNotNullParameter(autocompletables, "autocompletables");
            Intrinsics3.checkNotNullParameter(stickers, "stickers");
            Intrinsics3.checkNotNullParameter(token, "token");
            return new Autocomplete(isLoading, isError, isAutocomplete, autocompletables, stickers, token);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Autocomplete)) {
                return false;
            }
            Autocomplete autocomplete = (Autocomplete) other;
            return this.isLoading == autocomplete.isLoading && this.isError == autocomplete.isError && this.isAutocomplete == autocomplete.isAutocomplete && Intrinsics3.areEqual(this.autocompletables, autocomplete.autocompletables) && Intrinsics3.areEqual(this.stickers, autocomplete.stickers) && Intrinsics3.areEqual(this.token, autocomplete.token);
        }

        public final List<Autocompletable> getAutocompletables() {
            return this.autocompletables;
        }

        public final List<WidgetChatInputAutocompleteStickerAdapter2> getStickers() {
            return this.stickers;
        }

        public final String getToken() {
            return this.token;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v12 */
        /* JADX WARN: Type inference failed for: r0v13 */
        /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
        public int hashCode() {
            boolean z2 = this.isLoading;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            ?? r2 = this.isError;
            int i2 = r2;
            if (r2 != 0) {
                i2 = 1;
            }
            int i3 = (i + i2) * 31;
            boolean z3 = this.isAutocomplete;
            int i4 = (i3 + (z3 ? 1 : z3 ? 1 : 0)) * 31;
            List<Autocompletable> list = this.autocompletables;
            int iHashCode = (i4 + (list != null ? list.hashCode() : 0)) * 31;
            List<WidgetChatInputAutocompleteStickerAdapter2> list2 = this.stickers;
            int iHashCode2 = (iHashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
            String str = this.token;
            return iHashCode2 + (str != null ? str.hashCode() : 0);
        }

        public final boolean isAutocomplete() {
            return this.isAutocomplete;
        }

        public final boolean isError() {
            return this.isError;
        }

        public final boolean isLoading() {
            return this.isLoading;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Autocomplete(isLoading=");
            sbU.append(this.isLoading);
            sbU.append(", isError=");
            sbU.append(this.isError);
            sbU.append(", isAutocomplete=");
            sbU.append(this.isAutocomplete);
            sbU.append(", autocompletables=");
            sbU.append(this.autocompletables);
            sbU.append(", stickers=");
            sbU.append(this.stickers);
            sbU.append(", token=");
            return outline.J(sbU, this.token, ")");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public Autocomplete(boolean z2, boolean z3, boolean z4, List<? extends Autocompletable> list, List<WidgetChatInputAutocompleteStickerAdapter2> list2, String str) {
            super(null);
            Intrinsics3.checkNotNullParameter(list, "autocompletables");
            Intrinsics3.checkNotNullParameter(list2, "stickers");
            Intrinsics3.checkNotNullParameter(str, "token");
            this.isLoading = z2;
            this.isError = z3;
            this.isAutocomplete = z4;
            this.autocompletables = list;
            this.stickers = list2;
            this.token = str;
        }
    }

    /* compiled from: AutocompleteViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b \u0010!J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0005J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ:\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00022\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u001f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001b\u001a\u0004\b\u001c\u0010\u0005R\u001f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\u001d\u0010\u0005R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001e\u001a\u0004\b\u001f\u0010\n¨\u0006\""}, d2 = {"Lcom/discord/widgets/chat/input/autocomplete/AutocompleteViewState$CommandBrowser;", "Lcom/discord/widgets/chat/input/autocomplete/AutocompleteViewState;", "", "Lcom/discord/models/commands/ApplicationCommand;", "component1", "()Ljava/util/List;", "Lcom/discord/models/commands/Application;", "component2", "Lcom/discord/widgets/chat/input/WidgetChatInputDiscoveryCommandsModel;", "component3", "()Lcom/discord/widgets/chat/input/WidgetChatInputDiscoveryCommandsModel;", "frequentCommands", "applications", "discoverCommands", "copy", "(Ljava/util/List;Ljava/util/List;Lcom/discord/widgets/chat/input/WidgetChatInputDiscoveryCommandsModel;)Lcom/discord/widgets/chat/input/autocomplete/AutocompleteViewState$CommandBrowser;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getFrequentCommands", "getApplications", "Lcom/discord/widgets/chat/input/WidgetChatInputDiscoveryCommandsModel;", "getDiscoverCommands", "<init>", "(Ljava/util/List;Ljava/util/List;Lcom/discord/widgets/chat/input/WidgetChatInputDiscoveryCommandsModel;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.autocomplete.AutocompleteViewState$CommandBrowser */
    public static final /* data */ class CommandBrowser extends AutocompleteViewModel4 {
        private final List<Application> applications;
        private final WidgetChatInputDiscoveryCommandsModel discoverCommands;
        private final List<ApplicationCommand> frequentCommands;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public CommandBrowser(List<? extends ApplicationCommand> list, List<Application> list2, WidgetChatInputDiscoveryCommandsModel widgetChatInputDiscoveryCommandsModel) {
            super(null);
            Intrinsics3.checkNotNullParameter(list, "frequentCommands");
            Intrinsics3.checkNotNullParameter(list2, "applications");
            Intrinsics3.checkNotNullParameter(widgetChatInputDiscoveryCommandsModel, "discoverCommands");
            this.frequentCommands = list;
            this.applications = list2;
            this.discoverCommands = widgetChatInputDiscoveryCommandsModel;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ CommandBrowser copy$default(CommandBrowser commandBrowser, List list, List list2, WidgetChatInputDiscoveryCommandsModel widgetChatInputDiscoveryCommandsModel, int i, Object obj) {
            if ((i & 1) != 0) {
                list = commandBrowser.frequentCommands;
            }
            if ((i & 2) != 0) {
                list2 = commandBrowser.applications;
            }
            if ((i & 4) != 0) {
                widgetChatInputDiscoveryCommandsModel = commandBrowser.discoverCommands;
            }
            return commandBrowser.copy(list, list2, widgetChatInputDiscoveryCommandsModel);
        }

        public final List<ApplicationCommand> component1() {
            return this.frequentCommands;
        }

        public final List<Application> component2() {
            return this.applications;
        }

        /* renamed from: component3, reason: from getter */
        public final WidgetChatInputDiscoveryCommandsModel getDiscoverCommands() {
            return this.discoverCommands;
        }

        public final CommandBrowser copy(List<? extends ApplicationCommand> frequentCommands, List<Application> applications, WidgetChatInputDiscoveryCommandsModel discoverCommands) {
            Intrinsics3.checkNotNullParameter(frequentCommands, "frequentCommands");
            Intrinsics3.checkNotNullParameter(applications, "applications");
            Intrinsics3.checkNotNullParameter(discoverCommands, "discoverCommands");
            return new CommandBrowser(frequentCommands, applications, discoverCommands);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CommandBrowser)) {
                return false;
            }
            CommandBrowser commandBrowser = (CommandBrowser) other;
            return Intrinsics3.areEqual(this.frequentCommands, commandBrowser.frequentCommands) && Intrinsics3.areEqual(this.applications, commandBrowser.applications) && Intrinsics3.areEqual(this.discoverCommands, commandBrowser.discoverCommands);
        }

        public final List<Application> getApplications() {
            return this.applications;
        }

        public final WidgetChatInputDiscoveryCommandsModel getDiscoverCommands() {
            return this.discoverCommands;
        }

        public final List<ApplicationCommand> getFrequentCommands() {
            return this.frequentCommands;
        }

        public int hashCode() {
            List<ApplicationCommand> list = this.frequentCommands;
            int iHashCode = (list != null ? list.hashCode() : 0) * 31;
            List<Application> list2 = this.applications;
            int iHashCode2 = (iHashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
            WidgetChatInputDiscoveryCommandsModel widgetChatInputDiscoveryCommandsModel = this.discoverCommands;
            return iHashCode2 + (widgetChatInputDiscoveryCommandsModel != null ? widgetChatInputDiscoveryCommandsModel.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("CommandBrowser(frequentCommands=");
            sbU.append(this.frequentCommands);
            sbU.append(", applications=");
            sbU.append(this.applications);
            sbU.append(", discoverCommands=");
            sbU.append(this.discoverCommands);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: AutocompleteViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/chat/input/autocomplete/AutocompleteViewState$Hidden;", "Lcom/discord/widgets/chat/input/autocomplete/AutocompleteViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.autocomplete.AutocompleteViewState$Hidden */
    public static final class Hidden extends AutocompleteViewModel4 {
        public static final Hidden INSTANCE = new Hidden();

        private Hidden() {
            super(null);
        }
    }

    /* compiled from: AutocompleteViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\u0004J\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/chat/input/autocomplete/AutocompleteViewState$LoadingItems;", "Lcom/discord/widgets/chat/input/autocomplete/AutocompleteViewState;", "", "component1", "()I", "numberLoadingItems", "copy", "(I)Lcom/discord/widgets/chat/input/autocomplete/AutocompleteViewState$LoadingItems;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getNumberLoadingItems", "<init>", "(I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.autocomplete.AutocompleteViewState$LoadingItems */
    public static final /* data */ class LoadingItems extends AutocompleteViewModel4 {
        private final int numberLoadingItems;

        public LoadingItems(int i) {
            super(null);
            this.numberLoadingItems = i;
        }

        public static /* synthetic */ LoadingItems copy$default(LoadingItems loadingItems, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = loadingItems.numberLoadingItems;
            }
            return loadingItems.copy(i);
        }

        /* renamed from: component1, reason: from getter */
        public final int getNumberLoadingItems() {
            return this.numberLoadingItems;
        }

        public final LoadingItems copy(int numberLoadingItems) {
            return new LoadingItems(numberLoadingItems);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof LoadingItems) && this.numberLoadingItems == ((LoadingItems) other).numberLoadingItems;
            }
            return true;
        }

        public final int getNumberLoadingItems() {
            return this.numberLoadingItems;
        }

        public int hashCode() {
            return this.numberLoadingItems;
        }

        public String toString() {
            return outline.B(outline.U("LoadingItems(numberLoadingItems="), this.numberLoadingItems, ")");
        }
    }

    private AutocompleteViewModel4() {
    }

    public /* synthetic */ AutocompleteViewModel4(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
