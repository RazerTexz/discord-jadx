package com.discord.widgets.chat.input.models;

import b.d.b.a.outline;
import com.discord.api.sticker.Sticker;
import com.discord.models.commands.ApplicationCommandOption;
import com.discord.widgets.chat.AutocompleteUtils2;
import com.discord.widgets.chat.input.autocomplete.Autocompletable;
import com.discord.widgets.chat.input.autocomplete.EmojiAutocompletable;
import com.discord.widgets.chat.input.autocomplete.LeadingIdentifier;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

/* compiled from: AutocompleteInputSelectionModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\t\u0012\u0018\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\f\u0012\u0006\u0010\u001e\u001a\u00020\u0012\u0012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00190\u000e¢\u0006\u0004\b3\u00104J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\"\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u000eHÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJb\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\t2\u001a\b\u0002\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\f2\b\b\u0002\u0010\u001e\u001a\u00020\u00122\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00190\u000eHÆ\u0001¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b#\u0010\u0004J\u0010\u0010$\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b$\u0010\u0007J\u001a\u0010'\u001a\u00020&2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b'\u0010(R\u001f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00190\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010)\u001a\u0004\b*\u0010\u001bR+\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010+\u001a\u0004\b,\u0010\u0011R\u001b\u0010\u001c\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010-\u001a\u0004\b.\u0010\u000bR\u001f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010/\u001a\u0004\b0\u0010\u0018R\u0019\u0010\u001e\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u00101\u001a\u0004\b2\u0010\u0014¨\u00065"}, d2 = {"Lcom/discord/widgets/chat/input/models/AutocompleteInputSelectionModel;", "", "", "getAutocompleteType", "()Ljava/lang/String;", "", "getEmojiNumCount", "()I", "getStickerNumCount", "Lcom/discord/widgets/chat/input/models/MentionToken;", "component1", "()Lcom/discord/widgets/chat/input/models/MentionToken;", "", "Lcom/discord/widgets/chat/input/autocomplete/LeadingIdentifier;", "", "Lcom/discord/widgets/chat/input/autocomplete/Autocompletable;", "component2", "()Ljava/util/Map;", "Lcom/discord/widgets/chat/input/models/InputSelectionModel;", "component3", "()Lcom/discord/widgets/chat/input/models/InputSelectionModel;", "", "Lcom/discord/models/commands/ApplicationCommandOption;", "component4", "()Ljava/util/Set;", "Lcom/discord/api/sticker/Sticker;", "component5", "()Ljava/util/List;", "autocompleteToken", "filteredAutocompletables", "inputSelectionModel", "showErrorsForOptions", "stickerMatches", "copy", "(Lcom/discord/widgets/chat/input/models/MentionToken;Ljava/util/Map;Lcom/discord/widgets/chat/input/models/InputSelectionModel;Ljava/util/Set;Ljava/util/List;)Lcom/discord/widgets/chat/input/models/AutocompleteInputSelectionModel;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getStickerMatches", "Ljava/util/Map;", "getFilteredAutocompletables", "Lcom/discord/widgets/chat/input/models/MentionToken;", "getAutocompleteToken", "Ljava/util/Set;", "getShowErrorsForOptions", "Lcom/discord/widgets/chat/input/models/InputSelectionModel;", "getInputSelectionModel", "<init>", "(Lcom/discord/widgets/chat/input/models/MentionToken;Ljava/util/Map;Lcom/discord/widgets/chat/input/models/InputSelectionModel;Ljava/util/Set;Ljava/util/List;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class AutocompleteInputSelectionModel {
    private final MentionToken autocompleteToken;
    private final Map<LeadingIdentifier, List<Autocompletable>> filteredAutocompletables;
    private final InputSelectionModel inputSelectionModel;
    private final Set<ApplicationCommandOption> showErrorsForOptions;
    private final List<Sticker> stickerMatches;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            LeadingIdentifier.values();
            int[] iArr = new int[5];
            $EnumSwitchMapping$0 = iArr;
            iArr[LeadingIdentifier.APP_COMMAND.ordinal()] = 1;
            iArr[LeadingIdentifier.EMOJI_AND_STICKERS.ordinal()] = 2;
            iArr[LeadingIdentifier.CHANNELS.ordinal()] = 3;
            iArr[LeadingIdentifier.MENTION.ordinal()] = 4;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AutocompleteInputSelectionModel(MentionToken mentionToken, Map<LeadingIdentifier, ? extends List<? extends Autocompletable>> map, InputSelectionModel inputSelectionModel, Set<ApplicationCommandOption> set, List<Sticker> list) {
        Intrinsics3.checkNotNullParameter(map, "filteredAutocompletables");
        Intrinsics3.checkNotNullParameter(inputSelectionModel, "inputSelectionModel");
        Intrinsics3.checkNotNullParameter(set, "showErrorsForOptions");
        Intrinsics3.checkNotNullParameter(list, "stickerMatches");
        this.autocompleteToken = mentionToken;
        this.filteredAutocompletables = map;
        this.inputSelectionModel = inputSelectionModel;
        this.showErrorsForOptions = set;
        this.stickerMatches = list;
    }

    public static /* synthetic */ AutocompleteInputSelectionModel copy$default(AutocompleteInputSelectionModel autocompleteInputSelectionModel, MentionToken mentionToken, Map map, InputSelectionModel inputSelectionModel, Set set, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            mentionToken = autocompleteInputSelectionModel.autocompleteToken;
        }
        if ((i & 2) != 0) {
            map = autocompleteInputSelectionModel.filteredAutocompletables;
        }
        Map map2 = map;
        if ((i & 4) != 0) {
            inputSelectionModel = autocompleteInputSelectionModel.inputSelectionModel;
        }
        InputSelectionModel inputSelectionModel2 = inputSelectionModel;
        if ((i & 8) != 0) {
            set = autocompleteInputSelectionModel.showErrorsForOptions;
        }
        Set set2 = set;
        if ((i & 16) != 0) {
            list = autocompleteInputSelectionModel.stickerMatches;
        }
        return autocompleteInputSelectionModel.copy(mentionToken, map2, inputSelectionModel2, set2, list);
    }

    /* renamed from: component1, reason: from getter */
    public final MentionToken getAutocompleteToken() {
        return this.autocompleteToken;
    }

    public final Map<LeadingIdentifier, List<Autocompletable>> component2() {
        return this.filteredAutocompletables;
    }

    /* renamed from: component3, reason: from getter */
    public final InputSelectionModel getInputSelectionModel() {
        return this.inputSelectionModel;
    }

    public final Set<ApplicationCommandOption> component4() {
        return this.showErrorsForOptions;
    }

    public final List<Sticker> component5() {
        return this.stickerMatches;
    }

    public final AutocompleteInputSelectionModel copy(MentionToken autocompleteToken, Map<LeadingIdentifier, ? extends List<? extends Autocompletable>> filteredAutocompletables, InputSelectionModel inputSelectionModel, Set<ApplicationCommandOption> showErrorsForOptions, List<Sticker> stickerMatches) {
        Intrinsics3.checkNotNullParameter(filteredAutocompletables, "filteredAutocompletables");
        Intrinsics3.checkNotNullParameter(inputSelectionModel, "inputSelectionModel");
        Intrinsics3.checkNotNullParameter(showErrorsForOptions, "showErrorsForOptions");
        Intrinsics3.checkNotNullParameter(stickerMatches, "stickerMatches");
        return new AutocompleteInputSelectionModel(autocompleteToken, filteredAutocompletables, inputSelectionModel, showErrorsForOptions, stickerMatches);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AutocompleteInputSelectionModel)) {
            return false;
        }
        AutocompleteInputSelectionModel autocompleteInputSelectionModel = (AutocompleteInputSelectionModel) other;
        return Intrinsics3.areEqual(this.autocompleteToken, autocompleteInputSelectionModel.autocompleteToken) && Intrinsics3.areEqual(this.filteredAutocompletables, autocompleteInputSelectionModel.filteredAutocompletables) && Intrinsics3.areEqual(this.inputSelectionModel, autocompleteInputSelectionModel.inputSelectionModel) && Intrinsics3.areEqual(this.showErrorsForOptions, autocompleteInputSelectionModel.showErrorsForOptions) && Intrinsics3.areEqual(this.stickerMatches, autocompleteInputSelectionModel.stickerMatches);
    }

    public final MentionToken getAutocompleteToken() {
        return this.autocompleteToken;
    }

    public final String getAutocompleteType() {
        MentionToken mentionToken = this.autocompleteToken;
        LeadingIdentifier leadingIdentifier = mentionToken != null ? mentionToken.getLeadingIdentifier() : null;
        if (leadingIdentifier != null) {
            int iOrdinal = leadingIdentifier.ordinal();
            if (iOrdinal == 0) {
                return AutocompleteUtils2.COMMANDS;
            }
            if (iOrdinal == 1) {
                return AutocompleteUtils2.EMOJIS_AND_STICKERS;
            }
            if (iOrdinal == 2) {
                return AutocompleteUtils2.CHANNELS;
            }
            if (iOrdinal == 3) {
                return AutocompleteUtils2.MENTIONS;
            }
        }
        return "CHOICE";
    }

    public final int getEmojiNumCount() {
        List<Autocompletable> list = this.filteredAutocompletables.get(LeadingIdentifier.EMOJI_AND_STICKERS);
        if (list == null) {
            return 0;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof EmojiAutocompletable) {
                arrayList.add(obj);
            }
        }
        return arrayList.size();
    }

    public final Map<LeadingIdentifier, List<Autocompletable>> getFilteredAutocompletables() {
        return this.filteredAutocompletables;
    }

    public final InputSelectionModel getInputSelectionModel() {
        return this.inputSelectionModel;
    }

    public final Set<ApplicationCommandOption> getShowErrorsForOptions() {
        return this.showErrorsForOptions;
    }

    public final List<Sticker> getStickerMatches() {
        return this.stickerMatches;
    }

    public final int getStickerNumCount() {
        return this.stickerMatches.size();
    }

    public int hashCode() {
        MentionToken mentionToken = this.autocompleteToken;
        int iHashCode = (mentionToken != null ? mentionToken.hashCode() : 0) * 31;
        Map<LeadingIdentifier, List<Autocompletable>> map = this.filteredAutocompletables;
        int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
        InputSelectionModel inputSelectionModel = this.inputSelectionModel;
        int iHashCode3 = (iHashCode2 + (inputSelectionModel != null ? inputSelectionModel.hashCode() : 0)) * 31;
        Set<ApplicationCommandOption> set = this.showErrorsForOptions;
        int iHashCode4 = (iHashCode3 + (set != null ? set.hashCode() : 0)) * 31;
        List<Sticker> list = this.stickerMatches;
        return iHashCode4 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("AutocompleteInputSelectionModel(autocompleteToken=");
        sbU.append(this.autocompleteToken);
        sbU.append(", filteredAutocompletables=");
        sbU.append(this.filteredAutocompletables);
        sbU.append(", inputSelectionModel=");
        sbU.append(this.inputSelectionModel);
        sbU.append(", showErrorsForOptions=");
        sbU.append(this.showErrorsForOptions);
        sbU.append(", stickerMatches=");
        return outline.L(sbU, this.stickerMatches, ")");
    }
}
