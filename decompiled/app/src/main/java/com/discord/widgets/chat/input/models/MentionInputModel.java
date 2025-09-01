package com.discord.widgets.chat.input.models;

import b.d.b.a.outline;
import com.discord.models.commands.Application;
import com.discord.models.commands.ApplicationCommand;
import com.discord.models.commands.ApplicationCommandOption;
import com.discord.stores.CommandAutocompleteState;
import com.discord.widgets.chat.input.WidgetChatInputDiscoveryCommandsModel;
import com.discord.widgets.chat.input.autocomplete.Autocompletable;
import com.discord.widgets.chat.input.autocomplete.LeadingIdentifier;
import d0.t.Collections2;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.Ranges2;

/* compiled from: MentionInputModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0014\u0015B?\b\u0002\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000f0\u0002\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\u0012\u0010\u0013R(\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\u00020\t8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR.\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000f0\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u0011\u0010\b\u0082\u0001\u0002\u0016\u0017¨\u0006\u0018"}, d2 = {"Lcom/discord/widgets/chat/input/models/MentionInputModel;", "", "", "Lkotlin/ranges/IntRange;", "Lcom/discord/widgets/chat/input/autocomplete/Autocompletable;", "inputMentionsMap", "Ljava/util/Map;", "getInputMentionsMap", "()Ljava/util/Map;", "", "input", "Ljava/lang/CharSequence;", "getInput", "()Ljava/lang/CharSequence;", "Lcom/discord/widgets/chat/input/autocomplete/LeadingIdentifier;", "", "autocompletables", "getAutocompletables", "<init>", "(Ljava/lang/CharSequence;Ljava/util/Map;Ljava/util/Map;)V", "VerifiedCommandInputModel", "VerifiedMessageInputModel", "Lcom/discord/widgets/chat/input/models/MentionInputModel$VerifiedCommandInputModel;", "Lcom/discord/widgets/chat/input/models/MentionInputModel$VerifiedMessageInputModel;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public abstract class MentionInputModel {
    private final Map<LeadingIdentifier, Set<Autocompletable>> autocompletables;
    private final CharSequence input;
    private final Map<Ranges2, Autocompletable> inputMentionsMap;

    /* compiled from: MentionInputModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005\u0012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\"\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u001c\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\nJL\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\u001a\b\u0002\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00052\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0\u0005HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR.\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00058\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b\u001e\u0010\nR(\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0\u00058\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b\u001f\u0010\nR\u001c\u0010\r\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010 \u001a\u0004\b!\u0010\u0004¨\u0006$"}, d2 = {"Lcom/discord/widgets/chat/input/models/MentionInputModel$VerifiedMessageInputModel;", "Lcom/discord/widgets/chat/input/models/MentionInputModel;", "", "component1", "()Ljava/lang/CharSequence;", "", "Lcom/discord/widgets/chat/input/autocomplete/LeadingIdentifier;", "", "Lcom/discord/widgets/chat/input/autocomplete/Autocompletable;", "component2", "()Ljava/util/Map;", "Lkotlin/ranges/IntRange;", "component3", "input", "autocompletables", "inputMentionsMap", "copy", "(Ljava/lang/CharSequence;Ljava/util/Map;Ljava/util/Map;)Lcom/discord/widgets/chat/input/models/MentionInputModel$VerifiedMessageInputModel;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Map;", "getAutocompletables", "getInputMentionsMap", "Ljava/lang/CharSequence;", "getInput", "<init>", "(Ljava/lang/CharSequence;Ljava/util/Map;Ljava/util/Map;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class VerifiedMessageInputModel extends MentionInputModel {
        private final Map<LeadingIdentifier, Set<Autocompletable>> autocompletables;
        private final CharSequence input;
        private final Map<Ranges2, Autocompletable> inputMentionsMap;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public VerifiedMessageInputModel(CharSequence charSequence, Map<LeadingIdentifier, ? extends Set<? extends Autocompletable>> map, Map<Ranges2, ? extends Autocompletable> map2) {
            super(charSequence, map, map2, null);
            Intrinsics3.checkNotNullParameter(charSequence, "input");
            Intrinsics3.checkNotNullParameter(map, "autocompletables");
            Intrinsics3.checkNotNullParameter(map2, "inputMentionsMap");
            this.input = charSequence;
            this.autocompletables = map;
            this.inputMentionsMap = map2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ VerifiedMessageInputModel copy$default(VerifiedMessageInputModel verifiedMessageInputModel, CharSequence charSequence, Map map, Map map2, int i, Object obj) {
            if ((i & 1) != 0) {
                charSequence = verifiedMessageInputModel.getInput();
            }
            if ((i & 2) != 0) {
                map = verifiedMessageInputModel.getAutocompletables();
            }
            if ((i & 4) != 0) {
                map2 = verifiedMessageInputModel.getInputMentionsMap();
            }
            return verifiedMessageInputModel.copy(charSequence, map, map2);
        }

        public final CharSequence component1() {
            return getInput();
        }

        public final Map<LeadingIdentifier, Set<Autocompletable>> component2() {
            return getAutocompletables();
        }

        public final Map<Ranges2, Autocompletable> component3() {
            return getInputMentionsMap();
        }

        public final VerifiedMessageInputModel copy(CharSequence input, Map<LeadingIdentifier, ? extends Set<? extends Autocompletable>> autocompletables, Map<Ranges2, ? extends Autocompletable> inputMentionsMap) {
            Intrinsics3.checkNotNullParameter(input, "input");
            Intrinsics3.checkNotNullParameter(autocompletables, "autocompletables");
            Intrinsics3.checkNotNullParameter(inputMentionsMap, "inputMentionsMap");
            return new VerifiedMessageInputModel(input, autocompletables, inputMentionsMap);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VerifiedMessageInputModel)) {
                return false;
            }
            VerifiedMessageInputModel verifiedMessageInputModel = (VerifiedMessageInputModel) other;
            return Intrinsics3.areEqual(getInput(), verifiedMessageInputModel.getInput()) && Intrinsics3.areEqual(getAutocompletables(), verifiedMessageInputModel.getAutocompletables()) && Intrinsics3.areEqual(getInputMentionsMap(), verifiedMessageInputModel.getInputMentionsMap());
        }

        @Override // com.discord.widgets.chat.input.models.MentionInputModel
        public Map<LeadingIdentifier, Set<Autocompletable>> getAutocompletables() {
            return this.autocompletables;
        }

        @Override // com.discord.widgets.chat.input.models.MentionInputModel
        public CharSequence getInput() {
            return this.input;
        }

        @Override // com.discord.widgets.chat.input.models.MentionInputModel
        public Map<Ranges2, Autocompletable> getInputMentionsMap() {
            return this.inputMentionsMap;
        }

        public int hashCode() {
            CharSequence input = getInput();
            int iHashCode = (input != null ? input.hashCode() : 0) * 31;
            Map<LeadingIdentifier, Set<Autocompletable>> autocompletables = getAutocompletables();
            int iHashCode2 = (iHashCode + (autocompletables != null ? autocompletables.hashCode() : 0)) * 31;
            Map<Ranges2, Autocompletable> inputMentionsMap = getInputMentionsMap();
            return iHashCode2 + (inputMentionsMap != null ? inputMentionsMap.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("VerifiedMessageInputModel(input=");
            sbU.append(getInput());
            sbU.append(", autocompletables=");
            sbU.append(getAutocompletables());
            sbU.append(", inputMentionsMap=");
            sbU.append(getInputMentionsMap());
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private MentionInputModel(CharSequence charSequence, Map<LeadingIdentifier, ? extends Set<? extends Autocompletable>> map, Map<Ranges2, ? extends Autocompletable> map2) {
        this.input = charSequence;
        this.autocompletables = map;
        this.inputMentionsMap = map2;
    }

    public Map<LeadingIdentifier, Set<Autocompletable>> getAutocompletables() {
        return this.autocompletables;
    }

    public CharSequence getInput() {
        return this.input;
    }

    public Map<Ranges2, Autocompletable> getInputMentionsMap() {
        return this.inputMentionsMap;
    }

    public /* synthetic */ MentionInputModel(CharSequence charSequence, Map map, Map map2, DefaultConstructorMarker defaultConstructorMarker) {
        this(charSequence, map, map2);
    }

    /* compiled from: MentionInputModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001BÝ\u0001\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0018\u0010\u001f\u001a\u0014\u0012\u0004\u0012\u00020\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\b\u0012\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u001e0\b\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u000e\b\u0002\u00102\u001a\b\u0012\u0004\u0012\u0002010\u0002\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010,\u0012 \b\u0002\u00106\u001a\u001a\u0012\u0004\u0012\u000204\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u0002050\b0\b\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010(\u001a\u00020'\u0012\u0014\b\u0002\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020!0\b\u0012\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b\u0012\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000f0\b¢\u0006\u0004\b8\u00109R\u001f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R%\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR%\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000f0\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000eR\u001c\u0010\u0013\u001a\u00020\u00128\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0018\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR.\u0010\u001f\u001a\u0014\u0012\u0004\u0012\u00020\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001f\u0010\f\u001a\u0004\b \u0010\u000eR%\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020!0\b8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010\f\u001a\u0004\b#\u0010\u000eR(\u0010%\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u001e0\b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b%\u0010\f\u001a\u0004\b&\u0010\u000eR\u0019\u0010(\u001a\u00020'8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u001b\u0010-\u001a\u0004\u0018\u00010,8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u001f\u00102\u001a\b\u0012\u0004\u0012\u0002010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b2\u0010\u0005\u001a\u0004\b3\u0010\u0007R1\u00106\u001a\u001a\u0012\u0004\u0012\u000204\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u0002050\b0\b8\u0006@\u0006¢\u0006\f\n\u0004\b6\u0010\f\u001a\u0004\b7\u0010\u000e¨\u0006:"}, d2 = {"Lcom/discord/widgets/chat/input/models/MentionInputModel$VerifiedCommandInputModel;", "Lcom/discord/widgets/chat/input/models/MentionInputModel;", "", "Lcom/discord/models/commands/Application;", "applications", "Ljava/util/List;", "getApplications", "()Ljava/util/List;", "", "Lcom/discord/models/commands/ApplicationCommandOption;", "Lcom/discord/widgets/chat/input/models/OptionRange;", "inputCommandOptionsRanges", "Ljava/util/Map;", "getInputCommandOptionsRanges", "()Ljava/util/Map;", "", "inputCommandOptionValidity", "getInputCommandOptionValidity", "", "input", "Ljava/lang/CharSequence;", "getInput", "()Ljava/lang/CharSequence;", "Lcom/discord/widgets/chat/input/models/InputCommandContext;", "inputCommandContext", "Lcom/discord/widgets/chat/input/models/InputCommandContext;", "getInputCommandContext", "()Lcom/discord/widgets/chat/input/models/InputCommandContext;", "Lcom/discord/widgets/chat/input/autocomplete/LeadingIdentifier;", "", "Lcom/discord/widgets/chat/input/autocomplete/Autocompletable;", "autocompletables", "getAutocompletables", "Lcom/discord/widgets/chat/input/models/CommandOptionValue;", "inputCommandOptionValues", "getInputCommandOptionValues", "Lkotlin/ranges/IntRange;", "inputMentionsMap", "getInputMentionsMap", "Lcom/discord/widgets/chat/input/models/AutocompleteApplicationCommands;", "commands", "Lcom/discord/widgets/chat/input/models/AutocompleteApplicationCommands;", "getCommands", "()Lcom/discord/widgets/chat/input/models/AutocompleteApplicationCommands;", "Lcom/discord/widgets/chat/input/WidgetChatInputDiscoveryCommandsModel;", "discoveryCommands", "Lcom/discord/widgets/chat/input/WidgetChatInputDiscoveryCommandsModel;", "getDiscoveryCommands", "()Lcom/discord/widgets/chat/input/WidgetChatInputDiscoveryCommandsModel;", "Lcom/discord/models/commands/ApplicationCommand;", "queryCommands", "getQueryCommands", "", "Lcom/discord/stores/CommandAutocompleteState;", "commandOptionAutocompleteItems", "getCommandOptionAutocompleteItems", "<init>", "(Ljava/lang/CharSequence;Ljava/util/Map;Ljava/util/Map;Ljava/util/List;Ljava/util/List;Lcom/discord/widgets/chat/input/WidgetChatInputDiscoveryCommandsModel;Ljava/util/Map;Lcom/discord/widgets/chat/input/models/InputCommandContext;Lcom/discord/widgets/chat/input/models/AutocompleteApplicationCommands;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class VerifiedCommandInputModel extends MentionInputModel {
        private final List<Application> applications;
        private final Map<LeadingIdentifier, Set<Autocompletable>> autocompletables;
        private final Map<String, Map<String, CommandAutocompleteState>> commandOptionAutocompleteItems;
        private final AutocompleteApplicationCommands commands;
        private final WidgetChatInputDiscoveryCommandsModel discoveryCommands;
        private final CharSequence input;
        private final InputCommandContext inputCommandContext;
        private final Map<ApplicationCommandOption, Boolean> inputCommandOptionValidity;
        private final Map<ApplicationCommandOption, CommandOptionValue> inputCommandOptionValues;
        private final Map<ApplicationCommandOption, OptionRange> inputCommandOptionsRanges;
        private final Map<Ranges2, Autocompletable> inputMentionsMap;
        private final List<ApplicationCommand> queryCommands;

        public /* synthetic */ VerifiedCommandInputModel(CharSequence charSequence, Map map, Map map2, List list, List list2, WidgetChatInputDiscoveryCommandsModel widgetChatInputDiscoveryCommandsModel, Map map3, InputCommandContext inputCommandContext, AutocompleteApplicationCommands autocompleteApplicationCommands, Map map4, Map map5, Map map6, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(charSequence, map, map2, (i & 8) != 0 ? Collections2.emptyList() : list, (i & 16) != 0 ? Collections2.emptyList() : list2, (i & 32) != 0 ? null : widgetChatInputDiscoveryCommandsModel, (i & 64) != 0 ? Maps6.emptyMap() : map3, inputCommandContext, autocompleteApplicationCommands, (i & 512) != 0 ? Maps6.emptyMap() : map4, (i & 1024) != 0 ? Maps6.emptyMap() : map5, (i & 2048) != 0 ? Maps6.emptyMap() : map6);
        }

        public final List<Application> getApplications() {
            return this.applications;
        }

        @Override // com.discord.widgets.chat.input.models.MentionInputModel
        public Map<LeadingIdentifier, Set<Autocompletable>> getAutocompletables() {
            return this.autocompletables;
        }

        public final Map<String, Map<String, CommandAutocompleteState>> getCommandOptionAutocompleteItems() {
            return this.commandOptionAutocompleteItems;
        }

        public final AutocompleteApplicationCommands getCommands() {
            return this.commands;
        }

        public final WidgetChatInputDiscoveryCommandsModel getDiscoveryCommands() {
            return this.discoveryCommands;
        }

        @Override // com.discord.widgets.chat.input.models.MentionInputModel
        public CharSequence getInput() {
            return this.input;
        }

        public final InputCommandContext getInputCommandContext() {
            return this.inputCommandContext;
        }

        public final Map<ApplicationCommandOption, Boolean> getInputCommandOptionValidity() {
            return this.inputCommandOptionValidity;
        }

        public final Map<ApplicationCommandOption, CommandOptionValue> getInputCommandOptionValues() {
            return this.inputCommandOptionValues;
        }

        public final Map<ApplicationCommandOption, OptionRange> getInputCommandOptionsRanges() {
            return this.inputCommandOptionsRanges;
        }

        @Override // com.discord.widgets.chat.input.models.MentionInputModel
        public Map<Ranges2, Autocompletable> getInputMentionsMap() {
            return this.inputMentionsMap;
        }

        public final List<ApplicationCommand> getQueryCommands() {
            return this.queryCommands;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public VerifiedCommandInputModel(CharSequence charSequence, Map<LeadingIdentifier, ? extends Set<? extends Autocompletable>> map, Map<Ranges2, ? extends Autocompletable> map2, List<Application> list, List<? extends ApplicationCommand> list2, WidgetChatInputDiscoveryCommandsModel widgetChatInputDiscoveryCommandsModel, Map<String, ? extends Map<String, ? extends CommandAutocompleteState>> map3, InputCommandContext inputCommandContext, AutocompleteApplicationCommands autocompleteApplicationCommands, Map<ApplicationCommandOption, ? extends CommandOptionValue> map4, Map<ApplicationCommandOption, OptionRange> map5, Map<ApplicationCommandOption, Boolean> map6) {
            super(charSequence, map, map2, null);
            Intrinsics3.checkNotNullParameter(charSequence, "input");
            Intrinsics3.checkNotNullParameter(map, "autocompletables");
            Intrinsics3.checkNotNullParameter(map2, "inputMentionsMap");
            Intrinsics3.checkNotNullParameter(list, "applications");
            Intrinsics3.checkNotNullParameter(list2, "queryCommands");
            Intrinsics3.checkNotNullParameter(map3, "commandOptionAutocompleteItems");
            Intrinsics3.checkNotNullParameter(inputCommandContext, "inputCommandContext");
            Intrinsics3.checkNotNullParameter(autocompleteApplicationCommands, "commands");
            Intrinsics3.checkNotNullParameter(map4, "inputCommandOptionValues");
            Intrinsics3.checkNotNullParameter(map5, "inputCommandOptionsRanges");
            Intrinsics3.checkNotNullParameter(map6, "inputCommandOptionValidity");
            this.input = charSequence;
            this.autocompletables = map;
            this.inputMentionsMap = map2;
            this.applications = list;
            this.queryCommands = list2;
            this.discoveryCommands = widgetChatInputDiscoveryCommandsModel;
            this.commandOptionAutocompleteItems = map3;
            this.inputCommandContext = inputCommandContext;
            this.commands = autocompleteApplicationCommands;
            this.inputCommandOptionValues = map4;
            this.inputCommandOptionsRanges = map5;
            this.inputCommandOptionValidity = map6;
        }
    }
}
