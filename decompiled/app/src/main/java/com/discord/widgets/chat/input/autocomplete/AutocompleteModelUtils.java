package com.discord.widgets.chat.input.autocomplete;

import com.discord.api.channel.ChannelUtils;
import com.discord.api.commands.ApplicationCommandAutocompleteChoice;
import com.discord.api.commands.ApplicationCommandType;
import com.discord.api.commands.CommandChoice;
import com.discord.api.sticker.Sticker;
import com.discord.models.commands.Application;
import com.discord.models.commands.ApplicationCommand;
import com.discord.models.commands.ApplicationCommand3;
import com.discord.models.commands.ApplicationCommandOption;
import com.discord.stores.CommandAutocompleteState;
import com.discord.utilities.stickers.StickerUtils;
import com.discord.utilities.string.StringUtils2;
import com.discord.widgets.chat.input.MentionUtils;
import com.discord.widgets.chat.input.autocomplete.sources.ApplicationCommandsAutocompletableSource;
import com.discord.widgets.chat.input.models.ApplicationCommandData;
import com.discord.widgets.chat.input.models.ApplicationCommandValue;
import com.discord.widgets.chat.input.models.AutocompleteInputSelectionModel;
import com.discord.widgets.chat.input.models.ChatInputMentionsMap;
import com.discord.widgets.chat.input.models.CommandOptionValue;
import com.discord.widgets.chat.input.models.InputSelectionModel;
import com.discord.widgets.chat.input.models.InputSelectionModel2;
import com.discord.widgets.chat.input.models.MentionInputModel;
import com.discord.widgets.chat.input.models.MentionToken;
import com.discord.widgets.chat.input.models.OptionRange;
import com.discord.widgets.chat.input.models.StringOptionValue;
import com.lytefast.flexinput.model.Attachment;
import d0.g0.Strings4;
import d0.g0.StringsJVM;
import d0.t.Collections2;
import d0.t.CollectionsJVM;
import d0.t.Iterables2;
import d0.t.MapsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Tuples2;
import kotlin.ranges.Ranges2;

/* compiled from: AutocompleteModelUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bI\u0010JJ\u001b\u0010\u0005\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J)\u0010\u000b\u001a\u0004\u0018\u00010\n*\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u000e\u001a\u00020\u0004*\u00020\r2\u0006\u0010\u0003\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ=\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00112\u0018\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u0013¢\u0006\u0004\b\u0018\u0010\u0019JK\u0010 \u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\u00022\u0018\u0010\u001c\u001a\u0014\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u001b0\u00132\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00160\u00132\u0006\u0010\u001e\u001a\u00020\u0004¢\u0006\u0004\b \u0010!J!\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\u0004\b\"\u0010#J'\u0010%\u001a\u0014\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u00132\u0006\u0010$\u001a\u00020\u0011¢\u0006\u0004\b%\u0010&JW\u00100\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001a\u001a\u00020'2\u0006\u0010(\u001a\u00020\r2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\u00042\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020,0\u00132\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020.0\u0013¢\u0006\u0004\b0\u00101J\u001f\u00102\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001a\u001a\u00020'2\u0006\u0010(\u001a\u00020\r¢\u0006\u0004\b2\u00103JY\u0010=\u001a\u0004\u0018\u00010<2\b\u0010\u0012\u001a\u0004\u0018\u0001042\n\b\u0002\u00105\u001a\u0004\u0018\u00010)2\f\u00107\u001a\b\u0012\u0004\u0012\u0002060\u00152\f\u00109\u001a\b\u0012\u0004\u0012\u0002080\u00152\u0016\u0010;\u001a\u0012\u0012\u0004\u0012\u00020)\u0012\b\u0012\u0006\u0012\u0002\b\u00030:0\u0013¢\u0006\u0004\b=\u0010>J\u001d\u0010@\u001a\b\u0012\u0004\u0012\u00020?0\u00152\b\u0010\u0010\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b@\u0010AJ\u0013\u0010B\u001a\u00020\u0004*\u0004\u0018\u00010\u0002¢\u0006\u0004\bB\u0010CJ+\u0010G\u001a\u0004\u0018\u00010\r*\u00020\r2\u0006\u0010D\u001a\u00020\u00072\u0006\u0010E\u001a\u00020\u00072\u0006\u0010F\u001a\u00020\u0007¢\u0006\u0004\bG\u0010H¨\u0006K"}, d2 = {"Lcom/discord/widgets/chat/input/autocomplete/AutocompleteModelUtils;", "", "", "other", "", "lowerCaseContains", "(Ljava/lang/String;Ljava/lang/String;)Z", "", "tokenPosition", "useNullLeadingIdentifier", "Lcom/discord/widgets/chat/input/models/MentionToken;", "asMentionToken", "(Ljava/lang/String;IZ)Lcom/discord/widgets/chat/input/models/MentionToken;", "Lkotlin/ranges/IntRange;", "isSubRangeOf", "(Lkotlin/ranges/IntRange;Lkotlin/ranges/IntRange;)Z", "token", "Lcom/discord/widgets/chat/input/models/InputSelectionModel;", "inputSelectionModel", "", "Lcom/discord/widgets/chat/input/autocomplete/LeadingIdentifier;", "", "Lcom/discord/widgets/chat/input/autocomplete/Autocompletable;", "mentions", "filterMentionsFromToken", "(Lcom/discord/widgets/chat/input/models/MentionToken;Lcom/discord/widgets/chat/input/models/InputSelectionModel;Ljava/util/Map;)Ljava/util/List;", "input", "", "autocompletables", "currentInputMentionMap", "isCommand", "Lcom/discord/widgets/chat/input/models/ChatInputMentionsMap;", "mapInputToMentions", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Z)Lcom/discord/widgets/chat/input/models/ChatInputMentionsMap;", "filterAutocompletablesForMessageContext", "(Ljava/util/List;)Ljava/util/List;", "model", "filterAutocompletablesForInputContext", "(Lcom/discord/widgets/chat/input/models/InputSelectionModel;)Ljava/util/Map;", "", "selection", "Lcom/discord/models/commands/ApplicationCommandOption;", "selectedCommandOption", "hasSelectedFreeformInputOption", "Lcom/discord/widgets/chat/input/models/OptionRange;", "inputCommandOptionsRanges", "Lcom/discord/widgets/chat/input/models/CommandOptionValue;", "inputCommandOptionValues", "getCommandAutocompleteToken", "(Ljava/lang/CharSequence;Lkotlin/ranges/IntRange;Lcom/discord/models/commands/ApplicationCommandOption;ZLjava/util/Map;Ljava/util/Map;)Lcom/discord/widgets/chat/input/models/MentionToken;", "getMessageAutocompleteToken", "(Ljava/lang/CharSequence;Lkotlin/ranges/IntRange;)Lcom/discord/widgets/chat/input/models/MentionToken;", "Lcom/discord/widgets/chat/input/models/AutocompleteInputSelectionModel;", "focusedOption", "Lcom/discord/models/commands/Application;", "applications", "Lcom/discord/models/commands/ApplicationCommand;", "queryCommands", "Lcom/lytefast/flexinput/model/Attachment;", "attachments", "Lcom/discord/widgets/chat/input/models/ApplicationCommandData;", "getApplicationSendData", "(Lcom/discord/widgets/chat/input/models/AutocompleteInputSelectionModel;Lcom/discord/models/commands/ApplicationCommandOption;Ljava/util/List;Ljava/util/List;Ljava/util/Map;)Lcom/discord/widgets/chat/input/models/ApplicationCommandData;", "Lcom/discord/api/sticker/Sticker;", "getStickerMatches", "(Lcom/discord/widgets/chat/input/models/MentionToken;)Ljava/util/List;", "isBoolean", "(Ljava/lang/String;)Z", "start", "before", "count", "shiftOrRemove", "(Lkotlin/ranges/IntRange;III)Lkotlin/ranges/IntRange;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class AutocompleteModelUtils {
    public static final AutocompleteModelUtils INSTANCE = new AutocompleteModelUtils();

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            ApplicationCommandType.values();
            int[] iArr = new int[12];
            $EnumSwitchMapping$0 = iArr;
            iArr[ApplicationCommandType.CHANNEL.ordinal()] = 1;
            iArr[ApplicationCommandType.USER.ordinal()] = 2;
            iArr[ApplicationCommandType.ROLE.ordinal()] = 3;
            iArr[ApplicationCommandType.MENTIONABLE.ordinal()] = 4;
            iArr[ApplicationCommandType.BOOLEAN.ordinal()] = 5;
        }
    }

    private AutocompleteModelUtils() {
    }

    private final MentionToken asMentionToken(String str, int i, boolean z2) {
        if (str != null) {
            Character chValueOf = ((StringsJVM.isBlank(str) ^ true) && MentionUtils.getDEFAULT_LEADING_IDENTIFIERS().contains(Character.valueOf(str.charAt(0)))) ? Character.valueOf(str.charAt(0)) : null;
            if (chValueOf != null || z2) {
                return new MentionToken(LeadingIdentifier.INSTANCE.fromChar(chValueOf), str, i == 0, i);
            }
        }
        return null;
    }

    public static /* synthetic */ MentionToken asMentionToken$default(AutocompleteModelUtils autocompleteModelUtils, String str, int i, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        return autocompleteModelUtils.asMentionToken(str, i, z2);
    }

    public static /* synthetic */ ApplicationCommandData getApplicationSendData$default(AutocompleteModelUtils autocompleteModelUtils, AutocompleteInputSelectionModel autocompleteInputSelectionModel, ApplicationCommandOption applicationCommandOption, List list, List list2, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            applicationCommandOption = null;
        }
        return autocompleteModelUtils.getApplicationSendData(autocompleteInputSelectionModel, applicationCommandOption, list, list2, map);
    }

    private final boolean isSubRangeOf(Ranges2 ranges2, Ranges2 ranges22) {
        return !ranges2.equals(ranges22) && ranges22.contains(ranges2.getFirst()) && ranges22.contains(ranges2.getLast());
    }

    private final boolean lowerCaseContains(String str, String str2) {
        Locale locale = Locale.getDefault();
        Intrinsics3.checkNotNullExpressionValue(locale, "Locale.getDefault()");
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = str.toLowerCase(locale);
        Intrinsics3.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        Locale locale2 = Locale.getDefault();
        Intrinsics3.checkNotNullExpressionValue(locale2, "Locale.getDefault()");
        Objects.requireNonNull(str2, "null cannot be cast to non-null type java.lang.String");
        String lowerCase2 = str2.toLowerCase(locale2);
        Intrinsics3.checkNotNullExpressionValue(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
        return Strings4.contains$default((CharSequence) lowerCase, (CharSequence) lowerCase2, false, 2, (Object) null);
    }

    public final Map<LeadingIdentifier, List<Autocompletable>> filterAutocompletablesForInputContext(InputSelectionModel model) {
        List arrayList;
        List arrayList2;
        Intrinsics3.checkNotNullParameter(model, "model");
        List<? extends Autocompletable> listFlatten = Iterables2.flatten(model.getInputModel().getAutocompletables().values());
        if (model instanceof InputSelectionModel.MessageInputSelectionModel) {
            List<Autocompletable> listFilterAutocompletablesForMessageContext = filterAutocompletablesForMessageContext(listFlatten);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : listFilterAutocompletablesForMessageContext) {
                LeadingIdentifier leadingIdentifier = ((Autocompletable) obj).leadingIdentifier();
                Object arrayList3 = linkedHashMap.get(leadingIdentifier);
                if (arrayList3 == null) {
                    arrayList3 = new ArrayList();
                    linkedHashMap.put(leadingIdentifier, arrayList3);
                }
                ((List) arrayList3).add(obj);
            }
            return linkedHashMap;
        }
        if (!(model instanceof InputSelectionModel.CommandInputSelectionModel)) {
            throw new NoWhenBranchMatchedException();
        }
        InputSelectionModel.CommandInputSelectionModel commandInputSelectionModel = (InputSelectionModel.CommandInputSelectionModel) model;
        ApplicationCommandOption selectedCommandOption = commandInputSelectionModel.getSelectedCommandOption();
        if (selectedCommandOption == null) {
            ArrayList arrayList4 = new ArrayList();
            for (Object obj2 : listFlatten) {
                if (!(((Autocompletable) obj2) instanceof ApplicationCommandAutocompletable)) {
                    arrayList4.add(obj2);
                }
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Object obj3 : arrayList4) {
                LeadingIdentifier leadingIdentifier2 = ((Autocompletable) obj3).leadingIdentifier();
                Object arrayList5 = linkedHashMap2.get(leadingIdentifier2);
                if (arrayList5 == null) {
                    arrayList5 = new ArrayList();
                    linkedHashMap2.put(leadingIdentifier2, arrayList5);
                }
                ((List) arrayList5).add(obj3);
            }
            return linkedHashMap2;
        }
        boolean z2 = true;
        if (selectedCommandOption.getChoices() != null && (!r2.isEmpty())) {
            List<Autocompletable> listCreateFromCommandOption = ApplicationCommandsAutocompletableSource.INSTANCE.createFromCommandOption(selectedCommandOption);
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            for (Object obj4 : listCreateFromCommandOption) {
                LeadingIdentifier leadingIdentifier3 = ((Autocompletable) obj4).leadingIdentifier();
                Object arrayList6 = linkedHashMap3.get(leadingIdentifier3);
                if (arrayList6 == null) {
                    arrayList6 = new ArrayList();
                    linkedHashMap3.put(leadingIdentifier3, arrayList6);
                }
                ((List) arrayList6).add(obj4);
            }
            return linkedHashMap3;
        }
        switch (selectedCommandOption.getType().ordinal()) {
            case 4:
                arrayList = ApplicationCommandsAutocompletableSource.INSTANCE.createFromCommandOption(selectedCommandOption);
                break;
            case 5:
                arrayList = new ArrayList();
                for (Object obj5 : listFlatten) {
                    if (obj5 instanceof UserAutocompletable) {
                        arrayList.add(obj5);
                    }
                }
                break;
            case 6:
                arrayList = new ArrayList();
                for (Object obj6 : listFlatten) {
                    if (obj6 instanceof ChannelAutocompletable) {
                        arrayList.add(obj6);
                    }
                }
                List<Integer> channelTypes = selectedCommandOption.getChannelTypes();
                if (channelTypes != null && !channelTypes.isEmpty()) {
                    z2 = false;
                }
                if (!z2) {
                    arrayList2 = new ArrayList();
                    for (Object obj7 : arrayList) {
                        if (selectedCommandOption.getChannelTypes().contains(Integer.valueOf(((ChannelAutocompletable) obj7).getChannel().getType()))) {
                            arrayList2.add(obj7);
                        }
                    }
                    arrayList = arrayList2;
                    break;
                }
                break;
            case 7:
                arrayList = new ArrayList();
                for (Object obj8 : listFlatten) {
                    if (obj8 instanceof RoleAutocompletable) {
                        arrayList.add(obj8);
                    }
                }
                break;
            case 8:
                arrayList = new ArrayList();
                for (Object obj9 : listFlatten) {
                    Autocompletable autocompletable = (Autocompletable) obj9;
                    if ((autocompletable instanceof UserAutocompletable) || (autocompletable instanceof RoleAutocompletable)) {
                        arrayList.add(obj9);
                    }
                }
                break;
            default:
                if (selectedCommandOption.getAutocomplete()) {
                    Map<String, CommandAutocompleteState> map = commandInputSelectionModel.getInputModel().getCommandOptionAutocompleteItems().get(selectedCommandOption.getName());
                    if (map != null) {
                        CommandOptionValue commandOptionValue = commandInputSelectionModel.getInputModel().getInputCommandOptionValues().get(selectedCommandOption);
                        commandAutocompleteState = map.get(String.valueOf(commandOptionValue != null ? commandOptionValue.getValue() : null));
                    }
                    if (!(commandAutocompleteState instanceof CommandAutocompleteState.Choices)) {
                        arrayList = Collections2.emptyList();
                        break;
                    } else {
                        List<ApplicationCommandAutocompleteChoice> choices = ((CommandAutocompleteState.Choices) commandAutocompleteState).getChoices();
                        arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(choices, 10));
                        for (ApplicationCommandAutocompleteChoice applicationCommandAutocompleteChoice : choices) {
                            arrayList2.add(new ApplicationCommandChoiceAutocompletable(new CommandChoice(applicationCommandAutocompleteChoice.getName(), applicationCommandAutocompleteChoice.getValue()), selectedCommandOption.getName()));
                        }
                    }
                } else {
                    List listPlus = _Collections.plus((Collection) ApplicationCommandsAutocompletableSource.INSTANCE.createFromCommandOption(selectedCommandOption), (Iterable) listFlatten);
                    arrayList2 = new ArrayList();
                    for (Object obj10 : listPlus) {
                        Autocompletable autocompletable2 = (Autocompletable) obj10;
                        if (autocompletable2 instanceof ChannelAutocompletable ? ChannelUtils.v(((ChannelAutocompletable) autocompletable2).getChannel()) : autocompletable2 instanceof UserAutocompletable ? ((UserAutocompletable) autocompletable2).getCanUserReadChannel() : !(autocompletable2 instanceof ApplicationCommandAutocompletable)) {
                            arrayList2.add(obj10);
                        }
                    }
                }
                arrayList = arrayList2;
                break;
        }
        LinkedHashMap linkedHashMap4 = new LinkedHashMap();
        for (Object obj11 : arrayList) {
            LeadingIdentifier leadingIdentifier4 = ((Autocompletable) obj11).leadingIdentifier();
            Object arrayList7 = linkedHashMap4.get(leadingIdentifier4);
            if (arrayList7 == null) {
                arrayList7 = new ArrayList();
                linkedHashMap4.put(leadingIdentifier4, arrayList7);
            }
            ((List) arrayList7).add(obj11);
        }
        return linkedHashMap4;
    }

    public final List<Autocompletable> filterAutocompletablesForMessageContext(List<? extends Autocompletable> autocompletables) {
        Intrinsics3.checkNotNullParameter(autocompletables, "autocompletables");
        ArrayList arrayList = new ArrayList();
        for (Object obj : autocompletables) {
            Autocompletable autocompletable = (Autocompletable) obj;
            if (autocompletable instanceof ChannelAutocompletable ? ChannelUtils.v(((ChannelAutocompletable) autocompletable).getChannel()) : autocompletable instanceof UserAutocompletable ? ((UserAutocompletable) autocompletable).getCanUserReadChannel() : autocompletable instanceof RoleAutocompletable ? ((RoleAutocompletable) autocompletable).getCanMention() : true) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final List<Autocompletable> filterMentionsFromToken(MentionToken token, InputSelectionModel inputSelectionModel, Map<LeadingIdentifier, ? extends List<? extends Autocompletable>> mentions) {
        ArrayList arrayList;
        ApplicationCommandOption selectedCommandOption;
        Intrinsics3.checkNotNullParameter(token, "token");
        Intrinsics3.checkNotNullParameter(inputSelectionModel, "inputSelectionModel");
        Intrinsics3.checkNotNullParameter(mentions, "mentions");
        if ((inputSelectionModel instanceof InputSelectionModel.CommandInputSelectionModel) && (selectedCommandOption = ((InputSelectionModel.CommandInputSelectionModel) inputSelectionModel).getSelectedCommandOption()) != null && selectedCommandOption.getAutocomplete()) {
            return InputAutocompletables6.flatten(mentions);
        }
        boolean z2 = StringsJVM.isBlank(token.getFormattedToken()) && token.getLeadingIdentifier() == LeadingIdentifier.NONE;
        String formattedToken = token.getFormattedToken();
        Locale locale = Locale.getDefault();
        Intrinsics3.checkNotNullExpressionValue(locale, "Locale.getDefault()");
        Objects.requireNonNull(formattedToken, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = formattedToken.toLowerCase(locale);
        Intrinsics3.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        String strReplace$default = StringsJVM.replace$default(StringUtils2.stripAccents(lowerCase), " ", "", false, 4, (Object) null);
        if (z2 && InputSelectionModel2.hasSelectedCommandOptionWithChoices(inputSelectionModel)) {
            List<? extends Autocompletable> list = mentions.get(LeadingIdentifier.NONE);
            if (list != null) {
                arrayList = new ArrayList();
                for (Object obj : list) {
                    if (obj instanceof ApplicationCommandChoiceAutocompletable) {
                        arrayList.add(obj);
                    }
                }
            } else {
                arrayList = null;
            }
            return arrayList != null ? arrayList : Collections2.emptyList();
        }
        if (z2) {
            return Collections2.emptyList();
        }
        ArrayList arrayList2 = new ArrayList();
        List<? extends Autocompletable> list2 = mentions.get(token.getLeadingIdentifier());
        if (list2 != null) {
            for (Autocompletable autocompletable : list2) {
                Iterator<String> itIterateAutocompleteMatchers = autocompletable.iterateAutocompleteMatchers();
                while (true) {
                    if (itIterateAutocompleteMatchers.hasNext()) {
                        String next = itIterateAutocompleteMatchers.next();
                        Locale locale2 = Locale.getDefault();
                        Intrinsics3.checkNotNullExpressionValue(locale2, "Locale.getDefault()");
                        Objects.requireNonNull(next, "null cannot be cast to non-null type java.lang.String");
                        String lowerCase2 = next.toLowerCase(locale2);
                        Intrinsics3.checkNotNullExpressionValue(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
                        if (INSTANCE.lowerCaseContains(StringsJVM.replace$default(StringUtils2.stripAccents(lowerCase2), " ", "", false, 4, (Object) null), strReplace$default)) {
                            arrayList2.add(autocompletable);
                            break;
                        }
                    }
                }
            }
        }
        return arrayList2;
    }

    public final ApplicationCommandData getApplicationSendData(AutocompleteInputSelectionModel inputSelectionModel, ApplicationCommandOption focusedOption, List<Application> applications, List<? extends ApplicationCommand> queryCommands, Map<ApplicationCommandOption, ? extends Attachment<?>> attachments) {
        boolean z2;
        ApplicationCommandValue applicationCommandValue;
        boolean z3;
        ApplicationCommandValue applicationCommandValue2;
        OptionRange optionRange;
        Ranges2 value;
        boolean z4;
        Intrinsics3.checkNotNullParameter(applications, "applications");
        Intrinsics3.checkNotNullParameter(queryCommands, "queryCommands");
        Intrinsics3.checkNotNullParameter(attachments, "attachments");
        InputSelectionModel inputSelectionModel2 = inputSelectionModel != null ? inputSelectionModel.getInputSelectionModel() : null;
        if (!(inputSelectionModel2 instanceof InputSelectionModel.CommandInputSelectionModel)) {
            return null;
        }
        InputSelectionModel.CommandInputSelectionModel commandInputSelectionModel = (InputSelectionModel.CommandInputSelectionModel) inputSelectionModel2;
        ApplicationCommand selectedCommand = commandInputSelectionModel.getInputModel().getInputCommandContext().getSelectedCommand();
        Application selectedApplication = commandInputSelectionModel.getInputModel().getInputCommandContext().getSelectedApplication();
        MentionInputModel.VerifiedCommandInputModel inputModel = commandInputSelectionModel.getInputModel();
        if (!(inputModel instanceof MentionInputModel.VerifiedCommandInputModel)) {
            inputModel = null;
        }
        if (inputModel == null && selectedCommand != null && selectedApplication != null) {
            List listEmptyList = Collections2.emptyList();
            List<ApplicationCommandOption> options = selectedCommand.getOptions();
            if ((options instanceof Collection) && options.isEmpty()) {
                z4 = true;
            } else {
                Iterator<T> it = options.iterator();
                while (it.hasNext()) {
                    if (!(!((ApplicationCommandOption) it.next()).getRequired())) {
                        z4 = false;
                        break;
                    }
                }
                z4 = true;
            }
            return new ApplicationCommandData(selectedApplication, selectedCommand, listEmptyList, z4);
        }
        if (inputModel == null || selectedCommand == null || selectedApplication == null) {
            return null;
        }
        Map<ApplicationCommandOption, CommandOptionValue> inputCommandOptionValues = inputModel.getInputCommandOptionValues();
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsJVM.mapCapacity(inputCommandOptionValues.size()));
        Iterator<T> it2 = inputCommandOptionValues.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it2.next();
            Object key = entry.getKey();
            Object value2 = ((CommandOptionValue) entry.getValue()).getValue();
            if (entry.getValue() instanceof StringOptionValue) {
                List<CommandChoice> choices = ((ApplicationCommandOption) entry.getKey()).getChoices();
                if ((choices == null || choices.isEmpty()) && !((ApplicationCommandOption) entry.getKey()).getAutocomplete() && (optionRange = inputModel.getInputCommandOptionsRanges().get(entry.getKey())) != null && (value = optionRange.getValue()) != null) {
                    int first = value.getFirst();
                    String string = ((CommandOptionValue) entry.getValue()).getValue().toString();
                    Map<Ranges2, Autocompletable> inputMentionsMap = inputModel.getInputMentionsMap();
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsJVM.mapCapacity(inputMentionsMap.size()));
                    Iterator<T> it3 = inputMentionsMap.entrySet().iterator();
                    while (it3.hasNext()) {
                        Map.Entry entry2 = (Map.Entry) it3.next();
                        linkedHashMap2.put(new Ranges2(((Ranges2) entry2.getKey()).getFirst() - first, ((Ranges2) entry2.getKey()).getLast() - first), entry2.getValue());
                    }
                    LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                    for (Map.Entry entry3 : linkedHashMap2.entrySet()) {
                        if (((Ranges2) entry3.getKey()).getFirst() >= 0 && ((Ranges2) entry3.getKey()).getLast() <= string.length()) {
                            linkedHashMap3.put(entry3.getKey(), entry3.getValue());
                        }
                    }
                    value2 = AutocompleteExtensions.replaceAutocompleteDataWithServerValues(string, linkedHashMap3);
                }
            }
            linkedHashMap.put(key, value2);
        }
        Map<ApplicationCommandOption, Boolean> inputCommandOptionValidity = inputModel.getInputCommandOptionValidity();
        if (!(selectedCommand instanceof ApplicationCommand3)) {
            Collection<Boolean> collectionValues = inputCommandOptionValidity.values();
            if ((collectionValues instanceof Collection) && collectionValues.isEmpty()) {
                z2 = true;
            } else {
                Iterator<T> it4 = collectionValues.iterator();
                while (it4.hasNext()) {
                    if (!((Boolean) it4.next()).booleanValue()) {
                        z2 = false;
                        break;
                    }
                }
                z2 = true;
            }
            Set<ApplicationCommandOption> setKeySet = linkedHashMap.keySet();
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(setKeySet, 10));
            for (ApplicationCommandOption applicationCommandOption : setKeySet) {
                boolean zAreEqual = Intrinsics3.areEqual(focusedOption != null ? focusedOption.getName() : null, applicationCommandOption.getName());
                boolean z5 = (applicationCommandOption.getRequired() && linkedHashMap.get(applicationCommandOption) == null && !applicationCommandOption.getAutocomplete()) || Intrinsics3.areEqual(inputCommandOptionValidity.get(applicationCommandOption), Boolean.FALSE);
                z2 = z2 && !z5;
                Object obj = (!z5 || (zAreEqual && applicationCommandOption.getAutocomplete())) ? linkedHashMap.get(applicationCommandOption) : null;
                if (obj != null || applicationCommandOption.getAutocomplete()) {
                    applicationCommandValue = new ApplicationCommandValue(applicationCommandOption.getName(), obj != null ? obj : "", applicationCommandOption.getType().getType(), null, zAreEqual ? Boolean.TRUE : null, 8, null);
                } else {
                    applicationCommandValue = null;
                }
                arrayList.add(applicationCommandValue);
            }
            return new ApplicationCommandData(selectedApplication, selectedCommand, _Collections.filterNotNull(arrayList), z2);
        }
        Collection<Boolean> collectionValues2 = inputCommandOptionValidity.values();
        if ((collectionValues2 instanceof Collection) && collectionValues2.isEmpty()) {
            z3 = true;
        } else {
            Iterator<T> it5 = collectionValues2.iterator();
            while (it5.hasNext()) {
                if (!((Boolean) it5.next()).booleanValue()) {
                    z3 = false;
                    break;
                }
            }
            z3 = true;
        }
        Set<ApplicationCommandOption> setKeySet2 = linkedHashMap.keySet();
        ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(setKeySet2, 10));
        for (ApplicationCommandOption applicationCommandOption2 : setKeySet2) {
            boolean zAreEqual2 = Intrinsics3.areEqual(focusedOption != null ? focusedOption.getName() : null, applicationCommandOption2.getName());
            boolean z6 = (applicationCommandOption2.getRequired() && linkedHashMap.get(applicationCommandOption2) == null && !applicationCommandOption2.getAutocomplete()) || Intrinsics3.areEqual(inputCommandOptionValidity.get(applicationCommandOption2), Boolean.FALSE);
            z3 = z3 && !z6;
            Object obj2 = (!z6 || (zAreEqual2 && applicationCommandOption2.getAutocomplete())) ? linkedHashMap.get(applicationCommandOption2) : null;
            if (obj2 != null || applicationCommandOption2.getAutocomplete()) {
                applicationCommandValue2 = new ApplicationCommandValue(applicationCommandOption2.getName(), obj2 != null ? obj2 : "", applicationCommandOption2.getType().getType(), null, zAreEqual2 ? Boolean.TRUE : null, 8, null);
            } else {
                applicationCommandValue2 = null;
            }
            arrayList2.add(applicationCommandValue2);
        }
        ApplicationCommand3 applicationCommand3 = (ApplicationCommand3) selectedCommand;
        ApplicationCommandValue applicationCommandValue3 = new ApplicationCommandValue(applicationCommand3.getSubCommandName(), null, ApplicationCommandType.SUBCOMMAND.getType(), _Collections.filterNotNull(arrayList2), null, 18, null);
        String parentGroupName = applicationCommand3.getParentGroupName();
        return parentGroupName != null ? new ApplicationCommandData(selectedApplication, applicationCommand3.getRootCommand(), CollectionsJVM.listOf(new ApplicationCommandValue(parentGroupName, null, ApplicationCommandType.SUBCOMMAND_GROUP.getType(), CollectionsJVM.listOf(applicationCommandValue3), null, 18, null)), z3) : new ApplicationCommandData(selectedApplication, applicationCommand3.getRootCommand(), CollectionsJVM.listOf(applicationCommandValue3), z3);
    }

    public final MentionToken getCommandAutocompleteToken(CharSequence input, Ranges2 selection, ApplicationCommandOption selectedCommandOption, boolean hasSelectedFreeformInputOption, Map<ApplicationCommandOption, OptionRange> inputCommandOptionsRanges, Map<ApplicationCommandOption, ? extends CommandOptionValue> inputCommandOptionValues) {
        String strSubstring;
        Intrinsics3.checkNotNullParameter(input, "input");
        Intrinsics3.checkNotNullParameter(selection, "selection");
        Intrinsics3.checkNotNullParameter(selectedCommandOption, "selectedCommandOption");
        Intrinsics3.checkNotNullParameter(inputCommandOptionsRanges, "inputCommandOptionsRanges");
        Intrinsics3.checkNotNullParameter(inputCommandOptionValues, "inputCommandOptionValues");
        Tuples2<String, Integer> selectedToken = MentionUtils.getSelectedToken(input.toString(), selection.getFirst());
        String strComponent1 = selectedToken.component1();
        int iIntValue = selectedToken.component2().intValue();
        if (strComponent1 != null) {
            strSubstring = Strings4.removePrefix(strComponent1, selectedCommandOption.getName() + ":");
        } else {
            strSubstring = null;
        }
        if (hasSelectedFreeformInputOption) {
            return asMentionToken$default(this, strSubstring, iIntValue, false, 2, null);
        }
        OptionRange optionRange = inputCommandOptionsRanges.get(selectedCommandOption);
        Ranges2 value = optionRange != null ? optionRange.getValue() : null;
        CommandOptionValue commandOptionValue = inputCommandOptionValues.get(selectedCommandOption);
        if (value != null && commandOptionValue != null && selection.getFirst() > value.getFirst()) {
            String string = commandOptionValue.getValue().toString();
            int iMin = Math.min(selection.getFirst() - value.getFirst(), commandOptionValue.getValue().toString().length());
            Objects.requireNonNull(string, "null cannot be cast to non-null type java.lang.String");
            strSubstring = string.substring(0, iMin);
            Intrinsics3.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        }
        if (strSubstring == null) {
            strSubstring = "";
        }
        return asMentionToken(strSubstring, iIntValue, true);
    }

    public final MentionToken getMessageAutocompleteToken(CharSequence input, Ranges2 selection) {
        int i;
        String strGroup;
        Intrinsics3.checkNotNullParameter(input, "input");
        Intrinsics3.checkNotNullParameter(selection, "selection");
        Tuples2<String, Integer> selectedToken = MentionUtils.getSelectedToken(input.toString(), selection.getFirst());
        String strComponent1 = selectedToken.component1();
        int iIntValue = selectedToken.component2().intValue();
        Pattern patternCompile = Pattern.compile("^(/([a-zA-Z0-9_-]+\\s*){1,3})(.|\\n)*");
        Intrinsics3.checkNotNullExpressionValue(patternCompile, "Pattern.compile(\"^(/([a-…_-]+\\\\s*){1,3})(.|\\\\n)*\")");
        Matcher matcher = patternCompile.matcher(input);
        if (matcher.matches()) {
            strGroup = matcher.group(0);
            i = 0;
        } else {
            i = iIntValue;
            strGroup = strComponent1;
        }
        return asMentionToken$default(this, strGroup, i, false, 2, null);
    }

    public final List<Sticker> getStickerMatches(MentionToken token) throws IOException {
        if ((token != null ? token.getLeadingIdentifier() : null) == LeadingIdentifier.EMOJI_AND_STICKERS) {
            String token2 = token.getToken();
            StringBuilder sb = new StringBuilder();
            int length = token2.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = token2.charAt(i);
                if (Character.isLetterOrDigit(cCharAt)) {
                    sb.append(cCharAt);
                }
            }
            String string = sb.toString();
            Intrinsics3.checkNotNullExpressionValue(string, "filterTo(StringBuilder(), predicate).toString()");
            if (string.length() - 1 >= 3) {
                StickerUtils stickerUtils = StickerUtils.INSTANCE;
                return _Collections.toList(stickerUtils.findStickerMatches(StringsJVM.replace(token.getToken(), token.getLeadingIdentifier().toString(), "", true), StickerUtils.getStickersForAutocomplete$default(stickerUtils, null, null, null, null, null, 31, null), true));
            }
        }
        return Collections2.emptyList();
    }

    public final boolean isBoolean(String str) {
        String lowerCase;
        if (str != null) {
            Locale locale = Locale.getDefault();
            Intrinsics3.checkNotNullExpressionValue(locale, "Locale.getDefault()");
            lowerCase = str.toLowerCase(locale);
            Intrinsics3.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        } else {
            lowerCase = null;
        }
        return Intrinsics3.areEqual(lowerCase, "true") || Intrinsics3.areEqual(lowerCase, "false");
    }

    public final ChatInputMentionsMap mapInputToMentions(String input, Map<LeadingIdentifier, ? extends Set<? extends Autocompletable>> autocompletables, Map<Ranges2, ? extends Autocompletable> currentInputMentionMap, boolean isCommand) {
        boolean z2;
        Intrinsics3.checkNotNullParameter(input, "input");
        Intrinsics3.checkNotNullParameter(autocompletables, "autocompletables");
        Intrinsics3.checkNotNullParameter(currentInputMentionMap, "currentInputMentionMap");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        Iterator<Map.Entry<LeadingIdentifier, ? extends Set<? extends Autocompletable>>> it = autocompletables.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<LeadingIdentifier, ? extends Set<? extends Autocompletable>> next = it.next();
            Character identifier = next.getKey().getIdentifier();
            if (identifier == null || Strings4.contains$default((CharSequence) input, identifier.charValue(), false, 2, (Object) null)) {
                linkedHashMap2.put(next.getKey(), next.getValue());
            }
        }
        List<Autocompletable> listPlus = _Collections.plus((Collection) Iterables2.flatten(linkedHashMap2.values()), (Iterable) currentInputMentionMap.values());
        if (!isCommand) {
            listPlus = filterAutocompletablesForMessageContext(listPlus);
        }
        for (Autocompletable autocompletable : listPlus) {
            Iterator<String> itIterateTextMatchers = autocompletable.iterateTextMatchers();
            while (itIterateTextMatchers.hasNext()) {
                String next2 = itIterateTextMatchers.next();
                int iIndexOf$default = Strings4.indexOf$default((CharSequence) input, next2, 0, false, 4, (Object) null);
                while (iIndexOf$default != -1) {
                    Ranges2 ranges2 = new Ranges2(iIndexOf$default, next2.length() + iIndexOf$default);
                    if (!linkedHashMap.isEmpty()) {
                        Iterator it2 = linkedHashMap.entrySet().iterator();
                        while (it2.hasNext()) {
                            Map.Entry entry = (Map.Entry) it2.next();
                            Ranges2 ranges22 = (Ranges2) entry.getKey();
                            Autocompletable autocompletable2 = (Autocompletable) entry.getValue();
                            if (!Intrinsics3.areEqual(ranges2, ranges22) || !(autocompletable instanceof RoleAutocompletable) || (autocompletable2 instanceof RoleAutocompletable)) {
                                AutocompleteModelUtils autocompleteModelUtils = INSTANCE;
                                if (!autocompleteModelUtils.isSubRangeOf(ranges22, ranges2)) {
                                    if (Intrinsics3.areEqual(ranges2, ranges22) || autocompleteModelUtils.isSubRangeOf(ranges2, ranges22)) {
                                        z2 = false;
                                        break;
                                    }
                                }
                            }
                            it2.remove();
                        }
                        z2 = true;
                    } else {
                        z2 = true;
                    }
                    if (z2) {
                        Autocompletable autocompletable3 = currentInputMentionMap.get(ranges2);
                        if (autocompletable3 != null) {
                            linkedHashMap.put(ranges2, autocompletable3);
                        } else {
                            linkedHashMap.put(ranges2, autocompletable);
                        }
                    }
                    iIndexOf$default = Strings4.indexOf$default((CharSequence) input, next2, iIndexOf$default + 1, false, 4, (Object) null);
                }
            }
        }
        return new ChatInputMentionsMap(input, linkedHashMap);
    }

    public final Ranges2 shiftOrRemove(Ranges2 ranges2, int i, int i2, int i3) {
        Intrinsics3.checkNotNullParameter(ranges2, "$this$shiftOrRemove");
        if (i >= ranges2.getLast()) {
            return ranges2;
        }
        int i4 = (i + i3) - i2;
        int i5 = i + i2;
        int i6 = i3 - i2;
        if (i < ranges2.getFirst() && i5 >= ranges2.getFirst()) {
            return null;
        }
        if (i > ranges2.getFirst() && i < ranges2.getLast()) {
            return null;
        }
        if (i >= ranges2.getFirst() && i < ranges2.getLast() && i2 > 0) {
            return null;
        }
        if (ranges2.getFirst() >= i4 || (ranges2.getFirst() == i && i2 == 0)) {
            return new Ranges2(ranges2.getFirst() + i6, ranges2.getLast() + i6);
        }
        return null;
    }
}
