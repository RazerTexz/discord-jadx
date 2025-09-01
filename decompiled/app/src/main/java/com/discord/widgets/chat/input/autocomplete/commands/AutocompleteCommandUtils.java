package com.discord.widgets.chat.input.autocomplete.commands;

import androidx.annotation.MainThread;
import androidx.annotation.VisibleForTesting;
import b.d.b.a.outline;
import com.discord.api.commands.ApplicationCommandType;
import com.discord.api.commands.CommandChoice;
import com.discord.models.commands.Application;
import com.discord.models.commands.ApplicationCommand;
import com.discord.models.commands.ApplicationCommand2;
import com.discord.models.commands.ApplicationCommandOption;
import com.discord.stores.StoreApplicationCommandsKt;
import com.discord.utilities.SnowflakeUtils;
import com.discord.widgets.chat.input.MentionUtils;
import com.discord.widgets.chat.input.autocomplete.ApplicationCommandChoiceAutocompletable;
import com.discord.widgets.chat.input.autocomplete.Autocompletable;
import com.discord.widgets.chat.input.autocomplete.AutocompleteModelUtils;
import com.discord.widgets.chat.input.autocomplete.ChannelAutocompletable;
import com.discord.widgets.chat.input.autocomplete.InputEditTextAction;
import com.discord.widgets.chat.input.autocomplete.RoleAutocompletable;
import com.discord.widgets.chat.input.autocomplete.UserAutocompletable;
import com.discord.widgets.chat.input.models.AttachmentOptionValue;
import com.discord.widgets.chat.input.models.AutocompleteApplicationCommands;
import com.discord.widgets.chat.input.models.BooleanOptionValue;
import com.discord.widgets.chat.input.models.ChannelOptionValue;
import com.discord.widgets.chat.input.models.ChatInputMentionsMap;
import com.discord.widgets.chat.input.models.CommandOptionValue;
import com.discord.widgets.chat.input.models.InputCommandContext;
import com.discord.widgets.chat.input.models.IntegerOptionValue;
import com.discord.widgets.chat.input.models.MentionInputModel;
import com.discord.widgets.chat.input.models.NumberOptionValue;
import com.discord.widgets.chat.input.models.OptionRange;
import com.discord.widgets.chat.input.models.RawOptionValue;
import com.discord.widgets.chat.input.models.RoleOptionValue;
import com.discord.widgets.chat.input.models.SnowflakeOptionValue;
import com.discord.widgets.chat.input.models.StringOptionValue;
import com.discord.widgets.chat.input.models.UserOptionValue;
import com.lytefast.flexinput.model.Attachment;
import d0.g0.Regex2;
import d0.g0.StringNumberConversions;
import d0.g0.Strings4;
import d0.g0.StringsJVM;
import d0.t.Sets5;
import d0.t._Collections;
import d0.t._CollectionsJvm;
import d0.z.d.Intrinsics3;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ranges.Ranges2;
import kotlin.text.MatchResult;
import kotlin.text.Regex;

/* compiled from: AutocompleteCommandUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0004\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bS\u0010TJ\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0007\u001a\u00020\u0006*\u00020\u0003H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u0004\u0018\u00010\u0003*\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\t\u001a\u0004\u0018\u00010\u000b*\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\t\u0010\fJ\u0017\u0010\t\u001a\u0004\u0018\u00010\r*\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\t\u0010\u000eJC\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\r2\u0010\u0010\u0014\u001a\f\u0012\b\u0012\u00060\rj\u0002`\u00130\u00122\u0006\u0010\u0016\u001a\u00020\u00152\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u001a\u0010\u001bJ-\u0010!\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001c\u001a\u00020\u000b2\u0014\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001d¢\u0006\u0004\b!\u0010\"J\u0017\u0010&\u001a\u00020%2\u0006\u0010$\u001a\u00020#H\u0007¢\u0006\u0004\b&\u0010'J+\u0010+\u001a\u00020*2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u001e2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u000bH\u0007¢\u0006\u0004\b+\u0010,JY\u00103\u001a\b\u0012\u0004\u0012\u00020\u001e022\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010-\u001a\u0004\u0018\u00010\u001e2\b\u0010.\u001a\u0004\u0018\u00010\u001e2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00060\u001d2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u0002000\u001d¢\u0006\u0004\b3\u00104JU\u00109\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00060\u001d2\u0006\u0010\u0018\u001a\u00020\u00172\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u0002000\u001d2\u0016\u00106\u001a\u0012\u0012\u0004\u0012\u00020\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u0003050\u001d2\u0006\u00108\u001a\u000207¢\u0006\u0004\b9\u0010:JI\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u0002000\u001d2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010;\u001a\u00020\u00172\u0006\u0010<\u001a\u0002072\u0016\u0010=\u001a\u0012\u0012\u0004\u0012\u00020\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u0003050\u001d¢\u0006\u0004\b>\u0010?JK\u0010D\u001a\u0004\u0018\u00010\u00172\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00170\u00122\u0006\u0010A\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\n\u0010\u0011\u001a\u00060\rj\u0002`B2\u0010\u0010C\u001a\f\u0012\b\u0012\u00060\rj\u0002`\u00130\u0012¢\u0006\u0004\bD\u0010EJ\u0013\u0010F\u001a\u0004\u0018\u00010\u0002*\u00020\u000f¢\u0006\u0004\bF\u0010GJ?\u0010H\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u001d*\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0016\u0010=\u001a\u0012\u0012\u0004\u0012\u00020\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u0003050\u001d¢\u0006\u0004\bH\u0010IJ%\u0010L\u001a\u0004\u0018\u00010K*\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010J\u001a\u00020\u0002¢\u0006\u0004\bL\u0010MJ\u001d\u0010N\u001a\u0004\u0018\u00010\u000b*\u00020\u000f2\u0006\u0010J\u001a\u00020\u0002H\u0007¢\u0006\u0004\bN\u0010OJ\u001d\u0010P\u001a\u0004\u0018\u00010\u000b*\u00020\u000f2\u0006\u0010J\u001a\u00020\u0002H\u0007¢\u0006\u0004\bP\u0010OJ\u0015\u0010Q\u001a\u0004\u0018\u00010\u0002*\u0004\u0018\u00010\u0002¢\u0006\u0004\bQ\u0010R¨\u0006U"}, d2 = {"Lcom/discord/widgets/chat/input/autocomplete/commands/AutocompleteCommandUtils;", "", "", "", "parseNumber", "(Ljava/lang/String;)Ljava/lang/Number;", "", "isSafeNumber", "(Ljava/lang/Number;)Z", "asSafeNumberOrNull", "(Ljava/lang/Number;)Ljava/lang/Number;", "", "(Ljava/lang/Integer;)Ljava/lang/Integer;", "", "(Ljava/lang/Long;)Ljava/lang/Long;", "", "input", "userId", "", "Lcom/discord/primitives/RoleId;", "userRoles", "Lcom/discord/widgets/chat/input/models/AutocompleteApplicationCommands;", "applicationCommands", "Lcom/discord/models/commands/ApplicationCommand;", "selectedCommand", "Lcom/discord/widgets/chat/input/models/InputCommandContext;", "getInputCommandContext", "(Ljava/lang/CharSequence;JLjava/util/List;Lcom/discord/widgets/chat/input/models/AutocompleteApplicationCommands;Lcom/discord/models/commands/ApplicationCommand;)Lcom/discord/widgets/chat/input/models/InputCommandContext;", "cursorPosition", "", "Lcom/discord/models/commands/ApplicationCommandOption;", "Lcom/discord/widgets/chat/input/models/OptionRange;", "optionRanges", "getSelectedCommandOption", "(ILjava/util/Map;)Lcom/discord/models/commands/ApplicationCommandOption;", "Lcom/discord/widgets/chat/input/models/MentionInputModel$VerifiedCommandInputModel;", "model", "Lcom/discord/widgets/chat/input/autocomplete/InputEditTextAction;", "appendTextForCommandForInput", "(Lcom/discord/widgets/chat/input/models/MentionInputModel$VerifiedCommandInputModel;)Lcom/discord/widgets/chat/input/autocomplete/InputEditTextAction;", "applicationCommandsOption", "insertIndex", "Lcom/discord/widgets/chat/input/autocomplete/InputEditTextAction$InsertText;", "appendParam", "(Ljava/lang/CharSequence;Lcom/discord/models/commands/ApplicationCommandOption;Ljava/lang/Integer;)Lcom/discord/widgets/chat/input/autocomplete/InputEditTextAction$InsertText;", "selectedCommandOption", "previouslySelected", "validMap", "Lcom/discord/widgets/chat/input/models/CommandOptionValue;", "parsedCommandOptions", "", "getErrorsToShowForCommandParameters", "(Lcom/discord/models/commands/ApplicationCommand;Lcom/discord/models/commands/ApplicationCommandOption;Lcom/discord/models/commands/ApplicationCommandOption;Ljava/util/Map;Ljava/util/Map;)Ljava/util/Set;", "Lcom/lytefast/flexinput/model/Attachment;", "commandOptionAttachments", "Lcom/discord/widgets/chat/input/models/ChatInputMentionsMap;", "inputMentionsMap", "getInputValidity", "(Lcom/discord/models/commands/ApplicationCommand;Ljava/util/Map;Ljava/util/Map;Lcom/discord/widgets/chat/input/models/ChatInputMentionsMap;)Ljava/util/Map;", "command", "mentionMap", "attachments", "parseCommandOptions", "(Ljava/lang/CharSequence;Lcom/discord/models/commands/ApplicationCommand;Lcom/discord/widgets/chat/input/models/ChatInputMentionsMap;Ljava/util/Map;)Ljava/util/Map;", "commands", "prefix", "Lcom/discord/primitives/UserId;", "roles", "getSelectedCommand", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;JLjava/util/List;)Lcom/discord/models/commands/ApplicationCommand;", "getCommandPrefix", "(Ljava/lang/CharSequence;)Ljava/lang/String;", "findOptionRanges", "(Ljava/lang/CharSequence;Lcom/discord/models/commands/ApplicationCommand;Ljava/util/Map;)Ljava/util/Map;", "paramName", "Lkotlin/ranges/IntRange;", "findValueRange", "(Ljava/lang/CharSequence;Lcom/discord/models/commands/ApplicationCommand;Ljava/lang/String;)Lkotlin/ranges/IntRange;", "findStartOfParam", "(Ljava/lang/CharSequence;Ljava/lang/String;)Ljava/lang/Integer;", "findStartOfValue", "transformParameterSpannableString", "(Ljava/lang/String;)Ljava/lang/String;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class AutocompleteCommandUtils {
    public static final AutocompleteCommandUtils INSTANCE = new AutocompleteCommandUtils();

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            ApplicationCommandType.values();
            int[] iArr = new int[12];
            $EnumSwitchMapping$0 = iArr;
            ApplicationCommandType applicationCommandType = ApplicationCommandType.USER;
            iArr[applicationCommandType.ordinal()] = 1;
            ApplicationCommandType applicationCommandType2 = ApplicationCommandType.CHANNEL;
            iArr[applicationCommandType2.ordinal()] = 2;
            ApplicationCommandType applicationCommandType3 = ApplicationCommandType.ROLE;
            iArr[applicationCommandType3.ordinal()] = 3;
            ApplicationCommandType applicationCommandType4 = ApplicationCommandType.MENTIONABLE;
            iArr[applicationCommandType4.ordinal()] = 4;
            ApplicationCommandType.values();
            int[] iArr2 = new int[12];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[ApplicationCommandType.SUBCOMMAND.ordinal()] = 1;
            iArr2[ApplicationCommandType.SUBCOMMAND_GROUP.ordinal()] = 2;
            ApplicationCommandType applicationCommandType5 = ApplicationCommandType.STRING;
            iArr2[applicationCommandType5.ordinal()] = 3;
            ApplicationCommandType applicationCommandType6 = ApplicationCommandType.INTEGER;
            iArr2[applicationCommandType6.ordinal()] = 4;
            ApplicationCommandType applicationCommandType7 = ApplicationCommandType.NUMBER;
            iArr2[applicationCommandType7.ordinal()] = 5;
            ApplicationCommandType applicationCommandType8 = ApplicationCommandType.BOOLEAN;
            iArr2[applicationCommandType8.ordinal()] = 6;
            iArr2[applicationCommandType.ordinal()] = 7;
            iArr2[applicationCommandType2.ordinal()] = 8;
            iArr2[applicationCommandType3.ordinal()] = 9;
            iArr2[applicationCommandType4.ordinal()] = 10;
            iArr2[ApplicationCommandType.UNKNOWN.ordinal()] = 11;
            ApplicationCommandType applicationCommandType9 = ApplicationCommandType.ATTACHMENT;
            iArr2[applicationCommandType9.ordinal()] = 12;
            ApplicationCommandType.values();
            int[] iArr3 = new int[12];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[applicationCommandType5.ordinal()] = 1;
            iArr3[applicationCommandType6.ordinal()] = 2;
            iArr3[applicationCommandType7.ordinal()] = 3;
            iArr3[applicationCommandType8.ordinal()] = 4;
            iArr3[applicationCommandType.ordinal()] = 5;
            iArr3[applicationCommandType2.ordinal()] = 6;
            iArr3[applicationCommandType3.ordinal()] = 7;
            iArr3[applicationCommandType4.ordinal()] = 8;
            iArr3[applicationCommandType9.ordinal()] = 9;
        }
    }

    private AutocompleteCommandUtils() {
    }

    public static /* synthetic */ InputEditTextAction.InsertText appendParam$default(AutocompleteCommandUtils autocompleteCommandUtils, CharSequence charSequence, ApplicationCommandOption applicationCommandOption, Integer num, int i, Object obj) {
        if ((i & 4) != 0) {
            num = null;
        }
        return autocompleteCommandUtils.appendParam(charSequence, applicationCommandOption, num);
    }

    private final Number asSafeNumberOrNull(Number number) {
        if (number == null || !INSTANCE.isSafeNumber(number)) {
            return null;
        }
        return number;
    }

    public static /* synthetic */ InputCommandContext getInputCommandContext$default(AutocompleteCommandUtils autocompleteCommandUtils, CharSequence charSequence, long j, List list, AutocompleteApplicationCommands autocompleteApplicationCommands, ApplicationCommand applicationCommand, int i, Object obj) {
        if ((i & 16) != 0) {
            applicationCommand = null;
        }
        return autocompleteCommandUtils.getInputCommandContext(charSequence, j, list, autocompleteApplicationCommands, applicationCommand);
    }

    private final boolean isSafeNumber(Number number) {
        double dDoubleValue = number.doubleValue();
        return dDoubleValue >= ((double) (-9007199254740991L)) && dDoubleValue <= ((double) 9007199254740991L);
    }

    private final Number parseNumber(String str) throws ParseException {
        if (str == null) {
            return null;
        }
        try {
            ParsePosition parsePosition = new ParsePosition(0);
            Number number = NumberFormat.getInstance().parse(str, parsePosition);
            if (parsePosition.getIndex() != str.length() || parsePosition.getIndex() == 0) {
                throw new ParseException("Invalid input", parsePosition.getIndex());
            }
            return number;
        } catch (ParseException unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004f  */
    @MainThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final InputEditTextAction.InsertText appendParam(CharSequence input, ApplicationCommandOption applicationCommandsOption, Integer insertIndex) {
        Intrinsics3.checkNotNullParameter(input, "input");
        Intrinsics3.checkNotNullParameter(applicationCommandsOption, "applicationCommandsOption");
        input.length();
        String str = "";
        StringBuilder sbU = outline.U((Strings4.endsWith$default(input, ' ', false, 2, (Object) null) || insertIndex != null) ? "" : " ");
        sbU.append(applicationCommandsOption.getName());
        sbU.append(MentionUtils.EMOJIS_AND_STICKERS_CHAR);
        String string = sbU.toString();
        int iOrdinal = applicationCommandsOption.getType().ordinal();
        if (iOrdinal == 5) {
            str = "@";
        } else if (iOrdinal == 6) {
            str = "#";
        } else if (iOrdinal == 7 || iOrdinal == 8) {
        }
        String strW = outline.w(string, str);
        int iIntValue = insertIndex != null ? insertIndex.intValue() : input.length();
        return new InputEditTextAction.InsertText(input, strW, new Ranges2(iIntValue, iIntValue), strW.length() + input.length());
    }

    @MainThread
    public final InputEditTextAction appendTextForCommandForInput(MentionInputModel.VerifiedCommandInputModel model) {
        Intrinsics3.checkNotNullParameter(model, "model");
        ApplicationCommand selectedCommand = model.getInputCommandContext().getSelectedCommand();
        if (selectedCommand != null && selectedCommand.getOptions().size() == 1) {
            ApplicationCommandOption applicationCommandOption = (ApplicationCommandOption) _Collections.first((List) selectedCommand.getOptions());
            StringBuilder sbQ = outline.Q(MentionUtils.SLASH_CHAR);
            sbQ.append(selectedCommand.getName());
            sbQ.append(' ');
            String string = sbQ.toString();
            if (!model.getInputCommandOptionsRanges().containsKey(applicationCommandOption) && model.getInput().length() > string.length() && applicationCommandOption.getType() != ApplicationCommandType.ATTACHMENT) {
                return appendParam(model.getInput(), applicationCommandOption, Integer.valueOf(string.length()));
            }
        }
        return new InputEditTextAction.None(model.getInput());
    }

    public final Map<ApplicationCommandOption, OptionRange> findOptionRanges(CharSequence charSequence, ApplicationCommand applicationCommand, Map<ApplicationCommandOption, ? extends Attachment<?>> map) {
        List<ApplicationCommandOption> options;
        Ranges2 ranges2FindValueRange;
        Intrinsics3.checkNotNullParameter(charSequence, "$this$findOptionRanges");
        Intrinsics3.checkNotNullParameter(map, "attachments");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (applicationCommand != null && (options = applicationCommand.getOptions()) != null) {
            for (ApplicationCommandOption applicationCommandOption : options) {
                AutocompleteCommandUtils autocompleteCommandUtils = INSTANCE;
                Integer numFindStartOfParam = autocompleteCommandUtils.findStartOfParam(charSequence, applicationCommandOption.getName());
                if (numFindStartOfParam != null && (ranges2FindValueRange = autocompleteCommandUtils.findValueRange(charSequence, applicationCommand, applicationCommandOption.getName())) != null) {
                    Attachment<?> attachment = map.get(applicationCommandOption);
                    String displayName = attachment != null ? attachment.getDisplayName() : null;
                }
            }
        }
        return linkedHashMap;
    }

    @VisibleForTesting
    public final Integer findStartOfParam(CharSequence charSequence, String str) {
        Ranges2 range;
        Intrinsics3.checkNotNullParameter(charSequence, "$this$findStartOfParam");
        Intrinsics3.checkNotNullParameter(str, "paramName");
        MatchResult matchResultFind$default = Regex.find$default(new Regex("[\\s|\\n]" + str + MentionUtils.EMOJIS_AND_STICKERS_CHAR), charSequence, 0, 2, null);
        int first = (matchResultFind$default == null || (range = matchResultFind$default.getRange()) == null) ? -1 : range.getFirst();
        if (first == -1) {
            return null;
        }
        return Integer.valueOf(first + 1);
    }

    @VisibleForTesting
    public final Integer findStartOfValue(CharSequence charSequence, String str) {
        Intrinsics3.checkNotNullParameter(charSequence, "$this$findStartOfValue");
        Intrinsics3.checkNotNullParameter(str, "paramName");
        Integer numFindStartOfParam = findStartOfParam(charSequence, str);
        int iIntValue = numFindStartOfParam != null ? numFindStartOfParam.intValue() : -1;
        if (iIntValue != -1) {
            return Integer.valueOf(str.length() + iIntValue + 1);
        }
        return null;
    }

    public final Ranges2 findValueRange(CharSequence charSequence, ApplicationCommand applicationCommand, String str) {
        int first;
        Regex2 next;
        Ranges2 range;
        ApplicationCommandOption applicationCommandOption;
        List<ApplicationCommandOption> options;
        Object next2;
        Intrinsics3.checkNotNullParameter(charSequence, "$this$findValueRange");
        Intrinsics3.checkNotNullParameter(str, "paramName");
        Integer numFindStartOfValue = findStartOfValue(charSequence, str);
        if (numFindStartOfValue == null) {
            return null;
        }
        int iIntValue = numFindStartOfValue.intValue();
        Iterator it = Regex.findAll$default(new Regex(" ([\\p{L}0-9-_]*):"), charSequence.subSequence(iIntValue, charSequence.length()).toString(), 0, 2, null).iterator();
        while (true) {
            if (!it.hasNext()) {
                first = -1;
                break;
            }
            Iterator<Regex2> it2 = ((MatchResult) it.next()).getGroups().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                }
                next = it2.next();
                Regex2 regex2 = next;
                if (applicationCommand == null || (options = applicationCommand.getOptions()) == null) {
                    applicationCommandOption = null;
                } else {
                    Iterator<T> it3 = options.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            next2 = null;
                            break;
                        }
                        next2 = it3.next();
                        if (Intrinsics3.areEqual(regex2 != null ? regex2.getValue() : null, ((ApplicationCommandOption) next2).getName())) {
                            break;
                        }
                    }
                    applicationCommandOption = (ApplicationCommandOption) next2;
                }
                if (applicationCommandOption != null) {
                    break;
                }
            }
            Regex2 regex22 = next;
            first = (regex22 == null || (range = regex22.getRange()) == null) ? -1 : range.getFirst();
            if (first != -1) {
                break;
            }
        }
        return first == -1 ? new Ranges2(iIntValue, charSequence.length()) : new Ranges2(iIntValue, first + iIntValue);
    }

    public final String getCommandPrefix(CharSequence charSequence) {
        List<String> groupValues;
        Intrinsics3.checkNotNullParameter(charSequence, "$this$getCommandPrefix");
        MatchResult matchResultFind$default = Regex.find$default(new Regex("^(/([\\p{L}0-9-_]+\\s*){0,3})"), charSequence, 0, 2, null);
        if (matchResultFind$default == null || (groupValues = matchResultFind$default.getGroupValues()) == null) {
            return null;
        }
        return (String) _Collections.getOrNull(groupValues, 1);
    }

    public final Set<ApplicationCommandOption> getErrorsToShowForCommandParameters(ApplicationCommand selectedCommand, ApplicationCommandOption selectedCommandOption, ApplicationCommandOption previouslySelected, Map<ApplicationCommandOption, Boolean> validMap, Map<ApplicationCommandOption, ? extends CommandOptionValue> parsedCommandOptions) {
        Intrinsics3.checkNotNullParameter(validMap, "validMap");
        Intrinsics3.checkNotNullParameter(parsedCommandOptions, "parsedCommandOptions");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (selectedCommand == null) {
            return Sets5.emptySet();
        }
        for (ApplicationCommandOption applicationCommandOption : selectedCommand.getOptions()) {
            if (parsedCommandOptions.containsKey(applicationCommandOption)) {
                CommandOptionValue commandOptionValue = parsedCommandOptions.get(applicationCommandOption);
                String strValueOf = String.valueOf(commandOptionValue != null ? commandOptionValue.getValue() : null);
                boolean z2 = false;
                boolean z3 = StringsJVM.isBlank(strValueOf) || (strValueOf.length() == 1 && MentionUtils.getDEFAULT_LEADING_IDENTIFIERS().contains(Character.valueOf(strValueOf.charAt(0))));
                boolean zAreEqual = Intrinsics3.areEqual(selectedCommandOption, applicationCommandOption);
                boolean z4 = previouslySelected != null && Intrinsics3.areEqual(previouslySelected, applicationCommandOption);
                boolean zContainsKey = parsedCommandOptions.containsKey(applicationCommandOption);
                boolean z5 = (zAreEqual && z4) || (zAreEqual && z3);
                if (Intrinsics3.areEqual(validMap.get(applicationCommandOption), Boolean.FALSE) && !z5 && zContainsKey) {
                    z2 = true;
                }
                if (z2) {
                    linkedHashSet.add(applicationCommandOption);
                }
            }
        }
        return linkedHashSet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01c9 A[EDGE_INSN: B:101:0x01c9->B:97:0x01c9 BREAK  A[LOOP:0: B:87:0x01a8->B:105:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01ae  */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final InputCommandContext getInputCommandContext(CharSequence input, long userId, List<Long> userRoles, AutocompleteApplicationCommands applicationCommands, ApplicationCommand selectedCommand) {
        ApplicationCommand applicationCommand;
        ApplicationCommand applicationCommand2;
        ApplicationCommand applicationCommand3;
        Iterator it;
        long j = userId;
        List<Long> list = userRoles;
        Intrinsics3.checkNotNullParameter(input, "input");
        Intrinsics3.checkNotNullParameter(list, "userRoles");
        Intrinsics3.checkNotNullParameter(applicationCommands, "applicationCommands");
        String commandPrefix = getCommandPrefix(input);
        Application application = null;
        Object obj = null;
        if (commandPrefix == null) {
            applicationCommand = null;
        } else if (selectedCommand != null) {
            String strSubstring = commandPrefix.substring(1);
            Intrinsics3.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
            StringBuilder sb = new StringBuilder();
            String name = selectedCommand.getName();
            if (name == null) {
                name = "";
            }
            if (!StringsJVM.startsWith$default(strSubstring, outline.J(sb, name, " "), false, 2, null)) {
                Intrinsics3.checkNotNullExpressionValue(commandPrefix.substring(1), "(this as java.lang.String).substring(startIndex)");
                if (!Intrinsics3.areEqual(r12, selectedCommand.getName() != null ? r13 : "")) {
                    if (commandPrefix.length() > 0) {
                        List<ApplicationCommand> listFlattenSubCommands = StoreApplicationCommandsKt.flattenSubCommands(applicationCommands.getQueryCommands());
                        String strSubstring2 = commandPrefix.substring(1);
                        Intrinsics3.checkNotNullExpressionValue(strSubstring2, "(this as java.lang.String).substring(startIndex)");
                        ArrayList arrayList = new ArrayList();
                        for (Object obj2 : listFlattenSubCommands) {
                            ApplicationCommand applicationCommand4 = (ApplicationCommand) obj2;
                            if (ApplicationCommand2.hasPermission(applicationCommand4, j, list) && (StringsJVM.startsWith$default(applicationCommand4.getName(), strSubstring2, false, 2, null) && (Intrinsics3.areEqual(strSubstring2, applicationCommand4.getName()) ^ true))) {
                                arrayList.add(obj2);
                            }
                        }
                        ArrayList arrayList2 = new ArrayList();
                        int length = 0;
                        boolean z2 = false;
                        for (Object obj3 : listFlattenSubCommands) {
                            ApplicationCommand applicationCommand5 = (ApplicationCommand) obj3;
                            boolean zHasPermission = ApplicationCommand2.hasPermission(applicationCommand5, j, list);
                            boolean zAreEqual = Intrinsics3.areEqual(strSubstring2, applicationCommand5.getName());
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(applicationCommand5.getName());
                            sb2.append(" ");
                            boolean z3 = zHasPermission && (StringsJVM.startsWith$default(strSubstring2, sb2.toString(), false, 2, null) || zAreEqual);
                            if (z3 && applicationCommand5.getName().length() == length) {
                                z2 = true;
                            } else if (z3 && applicationCommand5.getName().length() > length) {
                                length = applicationCommand5.getName().length();
                                z2 = false;
                            }
                            if (z3) {
                                arrayList2.add(obj3);
                            }
                            j = userId;
                            list = userRoles;
                        }
                        Iterator it2 = arrayList2.iterator();
                        if (it2.hasNext()) {
                            ?? next = it2.next();
                            if (it2.hasNext()) {
                                String name2 = ((ApplicationCommand) next).getName();
                                do {
                                    Object next2 = it2.next();
                                    String name3 = ((ApplicationCommand) next2).getName();
                                    next = next;
                                    if (name2.compareTo(name3) < 0) {
                                        next = next2;
                                        name2 = name3;
                                    }
                                } while (it2.hasNext());
                            }
                            applicationCommand2 = next;
                        } else {
                            applicationCommand2 = null;
                        }
                        applicationCommand = applicationCommand2;
                        if (arrayList.isEmpty()) {
                            if (z2) {
                                obj = null;
                                applicationCommand3 = StringsJVM.startsWith$default(input.subSequence(1, input.length()).toString(), Intrinsics3.stringPlus(applicationCommand != null ? applicationCommand.getName() : null, " "), false, 2, null) ? null : null;
                            } else {
                                obj = null;
                            }
                        }
                        applicationCommand = applicationCommand3;
                        obj = applicationCommand;
                    }
                    it = applicationCommands.getApplications().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            break;
                        }
                        Object next3 = it.next();
                        if (applicationCommand != null && ((Application) next3).getId() == applicationCommand.getApplicationId()) {
                            obj = next3;
                            break;
                        }
                    }
                    application = (Application) obj;
                }
            }
            applicationCommand = selectedCommand;
            it = applicationCommands.getApplications().iterator();
            while (true) {
                if (it.hasNext()) {
                }
            }
            application = (Application) obj;
        }
        return new InputCommandContext(application, applicationCommand);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Map<ApplicationCommandOption, Boolean> getInputValidity(ApplicationCommand selectedCommand, Map<ApplicationCommandOption, ? extends CommandOptionValue> parsedCommandOptions, Map<ApplicationCommandOption, ? extends Attachment<?>> commandOptionAttachments, ChatInputMentionsMap inputMentionsMap) {
        Object next;
        Intrinsics3.checkNotNullParameter(selectedCommand, "selectedCommand");
        Intrinsics3.checkNotNullParameter(parsedCommandOptions, "parsedCommandOptions");
        Intrinsics3.checkNotNullParameter(commandOptionAttachments, "commandOptionAttachments");
        Intrinsics3.checkNotNullParameter(inputMentionsMap, "inputMentionsMap");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (ApplicationCommandOption applicationCommandOption : selectedCommand.getOptions()) {
            if (applicationCommandOption.getType() == ApplicationCommandType.ATTACHMENT) {
                boolean zContainsKey = commandOptionAttachments.containsKey(applicationCommandOption);
                if (zContainsKey || applicationCommandOption.getRequired()) {
                    linkedHashMap.put(applicationCommandOption, Boolean.valueOf(zContainsKey));
                }
            } else {
                CommandOptionValue commandOptionValue = parsedCommandOptions.get(applicationCommandOption);
                if (commandOptionValue != null) {
                    boolean z2 = false;
                    if (applicationCommandOption.getChoices() != null && (!r3.isEmpty())) {
                        List<CommandChoice> choices = applicationCommandOption.getChoices();
                        if (!(choices instanceof Collection) || !choices.isEmpty()) {
                            Iterator<T> it = choices.iterator();
                            while (it.hasNext()) {
                                if (Intrinsics3.areEqual(((CommandChoice) it.next()).getValue(), commandOptionValue.getValue().toString())) {
                                    z2 = true;
                                }
                            }
                        }
                        linkedHashMap.put(applicationCommandOption, Boolean.valueOf(z2));
                    } else if (applicationCommandOption.getAutocomplete()) {
                        Iterator it2 = _CollectionsJvm.filterIsInstance(inputMentionsMap.getMentions().values(), ApplicationCommandChoiceAutocompletable.class).iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                next = it2.next();
                                if (Intrinsics3.areEqual(((ApplicationCommandChoiceAutocompletable) next).getOptionName(), applicationCommandOption.getName())) {
                                }
                            } else {
                                next = null;
                            }
                        }
                        if (((ApplicationCommandChoiceAutocompletable) next) != null) {
                            z2 = true;
                        }
                        linkedHashMap.put(applicationCommandOption, Boolean.valueOf(z2));
                    } else {
                        switch (applicationCommandOption.getType()) {
                            case SUBCOMMAND:
                            case SUBCOMMAND_GROUP:
                                linkedHashMap.put(applicationCommandOption, Boolean.valueOf(z2));
                                break;
                            case STRING:
                                if ((commandOptionValue instanceof StringOptionValue) && (!StringsJVM.isBlank(commandOptionValue.getValue().toString()))) {
                                }
                                linkedHashMap.put(applicationCommandOption, Boolean.valueOf(z2));
                                break;
                            case INTEGER:
                                if (commandOptionValue instanceof IntegerOptionValue) {
                                    if (applicationCommandOption.getMinValue() != null) {
                                        long jLongValue = applicationCommandOption.getMinValue().longValue();
                                        Object value = commandOptionValue.getValue();
                                        Objects.requireNonNull(value, "null cannot be cast to non-null type kotlin.Long");
                                        if (jLongValue <= ((Long) value).longValue()) {
                                            if (applicationCommandOption.getMaxValue() != null) {
                                                long jLongValue2 = applicationCommandOption.getMaxValue().longValue();
                                                Object value2 = commandOptionValue.getValue();
                                                Objects.requireNonNull(value2, "null cannot be cast to non-null type kotlin.Long");
                                                if (jLongValue2 >= ((Long) value2).longValue()) {
                                                }
                                            }
                                        }
                                    }
                                }
                                linkedHashMap.put(applicationCommandOption, Boolean.valueOf(z2));
                                break;
                            case BOOLEAN:
                                z2 = commandOptionValue instanceof BooleanOptionValue;
                                linkedHashMap.put(applicationCommandOption, Boolean.valueOf(z2));
                                break;
                            case USER:
                                if ((commandOptionValue instanceof UserOptionValue) || (commandOptionValue instanceof SnowflakeOptionValue)) {
                                }
                                linkedHashMap.put(applicationCommandOption, Boolean.valueOf(z2));
                                break;
                            case CHANNEL:
                                if (!(commandOptionValue instanceof ChannelOptionValue)) {
                                    if (commandOptionValue instanceof SnowflakeOptionValue) {
                                    }
                                    linkedHashMap.put(applicationCommandOption, Boolean.valueOf(z2));
                                    break;
                                } else {
                                    List<Integer> channelTypes = applicationCommandOption.getChannelTypes();
                                    if ((channelTypes == null || channelTypes.isEmpty()) || applicationCommandOption.getChannelTypes().contains(Integer.valueOf(((ChannelOptionValue) commandOptionValue).getChannel().getType()))) {
                                    }
                                }
                                break;
                            case ROLE:
                                if ((commandOptionValue instanceof RoleOptionValue) || (commandOptionValue instanceof SnowflakeOptionValue)) {
                                }
                                linkedHashMap.put(applicationCommandOption, Boolean.valueOf(z2));
                                break;
                            case MENTIONABLE:
                                if ((commandOptionValue instanceof UserOptionValue) || (commandOptionValue instanceof RoleOptionValue) || (commandOptionValue instanceof SnowflakeOptionValue)) {
                                }
                                linkedHashMap.put(applicationCommandOption, Boolean.valueOf(z2));
                                break;
                            case NUMBER:
                                if (commandOptionValue instanceof NumberOptionValue) {
                                    if (applicationCommandOption.getMinValue() != null) {
                                        double dDoubleValue = applicationCommandOption.getMinValue().doubleValue();
                                        Object value3 = commandOptionValue.getValue();
                                        Objects.requireNonNull(value3, "null cannot be cast to non-null type kotlin.Number");
                                        if (dDoubleValue <= ((Number) value3).doubleValue()) {
                                            if (applicationCommandOption.getMaxValue() != null) {
                                                double dDoubleValue2 = applicationCommandOption.getMaxValue().doubleValue();
                                                Object value4 = commandOptionValue.getValue();
                                                Objects.requireNonNull(value4, "null cannot be cast to non-null type kotlin.Number");
                                                if (dDoubleValue2 >= ((Number) value4).doubleValue()) {
                                                }
                                            }
                                        }
                                    }
                                }
                                linkedHashMap.put(applicationCommandOption, Boolean.valueOf(z2));
                                break;
                            case ATTACHMENT:
                            case UNKNOWN:
                                break;
                            default:
                                throw new NoWhenBranchMatchedException();
                        }
                    }
                } else if (applicationCommandOption.getRequired()) {
                    linkedHashMap.put(applicationCommandOption, Boolean.FALSE);
                }
            }
        }
        return linkedHashMap;
    }

    public final ApplicationCommand getSelectedCommand(List<? extends ApplicationCommand> commands, String prefix, String input, long userId, List<Long> roles) {
        Intrinsics3.checkNotNullParameter(commands, "commands");
        Intrinsics3.checkNotNullParameter(prefix, "prefix");
        Intrinsics3.checkNotNullParameter(input, "input");
        Intrinsics3.checkNotNullParameter(roles, "roles");
        Object obj = null;
        if (!(prefix.length() > 0)) {
            return null;
        }
        Iterator<T> it = commands.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            ApplicationCommand applicationCommand = (ApplicationCommand) next;
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(MentionUtils.SLASH_CHAR) + applicationCommand.getName());
            sb.append(' ');
            if (StringsJVM.startsWith$default(input, sb.toString(), false, 2, null) && ApplicationCommand2.hasPermission(applicationCommand, userId, roles)) {
                obj = next;
                break;
            }
        }
        return (ApplicationCommand) obj;
    }

    public final ApplicationCommandOption getSelectedCommandOption(int cursorPosition, Map<ApplicationCommandOption, OptionRange> optionRanges) {
        Set<ApplicationCommandOption> setKeySet;
        if (optionRanges == null || (setKeySet = optionRanges.keySet()) == null) {
            return null;
        }
        for (ApplicationCommandOption applicationCommandOption : setKeySet) {
            OptionRange optionRange = optionRanges.get(applicationCommandOption);
            if (optionRange != null && optionRange.getParam().getFirst() < cursorPosition && optionRange.getValue().getLast() >= cursorPosition && applicationCommandOption.getType() != ApplicationCommandType.ATTACHMENT) {
                return applicationCommandOption;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Map<ApplicationCommandOption, CommandOptionValue> parseCommandOptions(CharSequence input, ApplicationCommand command, ChatInputMentionsMap mentionMap, Map<ApplicationCommandOption, ? extends Attachment<?>> attachments) {
        CommandOptionValue stringOptionValue;
        Object next;
        String value;
        Object next2;
        CommandOptionValue integerOptionValue;
        CommandOptionValue numberOptionValue;
        Intrinsics3.checkNotNullParameter(input, "input");
        Intrinsics3.checkNotNullParameter(command, "command");
        Intrinsics3.checkNotNullParameter(mentionMap, "mentionMap");
        Intrinsics3.checkNotNullParameter(attachments, "attachments");
        Map<ApplicationCommandOption, OptionRange> mapFindOptionRanges = findOptionRanges(input, command, attachments);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<ApplicationCommandOption, OptionRange> entry : mapFindOptionRanges.entrySet()) {
            ApplicationCommandOption key = entry.getKey();
            OptionRange value2 = entry.getValue();
            String string = input.subSequence(value2.getValue().getFirst(), value2.getValue().getLast()).toString();
            Objects.requireNonNull(string, "null cannot be cast to non-null type kotlin.CharSequence");
            String string2 = Strings4.trim(string).toString();
            Iterator<T> it = mentionMap.getMentions().values().iterator();
            while (true) {
                stringOptionValue = null;
                if (it.hasNext()) {
                    next = it.next();
                    if (((Autocompletable) next).matchesText(string2)) {
                    }
                } else {
                    next = null;
                }
            }
            Autocompletable autocompletable = (Autocompletable) next;
            if (key.getAutocomplete() && (autocompletable instanceof ApplicationCommandChoiceAutocompletable)) {
                value = ((ApplicationCommandChoiceAutocompletable) autocompletable).getChoice().getValue();
            } else {
                List<CommandChoice> choices = key.getChoices();
                if (choices != null) {
                    Iterator<T> it2 = choices.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            next2 = it2.next();
                            String name = ((CommandChoice) next2).getName();
                            Objects.requireNonNull(name, "null cannot be cast to non-null type kotlin.CharSequence");
                            if (Intrinsics3.areEqual(Strings4.trim(name).toString(), string2)) {
                            }
                        } else {
                            next2 = null;
                        }
                    }
                    CommandChoice commandChoice = (CommandChoice) next2;
                    if (commandChoice == null || (value = commandChoice.getValue()) == null) {
                        value = string2;
                    }
                }
            }
            switch (key.getType().ordinal()) {
                case 2:
                    stringOptionValue = new StringOptionValue(value);
                    break;
                case 3:
                    Long lAsSafeNumberOrNull = asSafeNumberOrNull(StringNumberConversions.toLongOrNull(value));
                    if (lAsSafeNumberOrNull != null) {
                        integerOptionValue = new IntegerOptionValue(lAsSafeNumberOrNull.longValue());
                        stringOptionValue = integerOptionValue;
                        break;
                    }
                    break;
                case 4:
                    if (AutocompleteModelUtils.INSTANCE.isBoolean(value)) {
                        numberOptionValue = new BooleanOptionValue(Boolean.parseBoolean(value));
                        stringOptionValue = numberOptionValue;
                        break;
                    }
                    break;
                case 5:
                    if (!(autocompletable instanceof UserAutocompletable)) {
                        autocompletable = null;
                    }
                    UserAutocompletable userAutocompletable = (UserAutocompletable) autocompletable;
                    if (userAutocompletable != null) {
                        integerOptionValue = new UserOptionValue(userAutocompletable.getUser());
                        stringOptionValue = integerOptionValue;
                        break;
                    }
                    break;
                case 6:
                    if (!(autocompletable instanceof ChannelAutocompletable)) {
                        autocompletable = null;
                    }
                    ChannelAutocompletable channelAutocompletable = (ChannelAutocompletable) autocompletable;
                    if (channelAutocompletable != null) {
                        integerOptionValue = new ChannelOptionValue(channelAutocompletable.getChannel());
                        stringOptionValue = integerOptionValue;
                        break;
                    }
                    break;
                case 7:
                    if (!(autocompletable instanceof RoleAutocompletable)) {
                        autocompletable = null;
                    }
                    RoleAutocompletable roleAutocompletable = (RoleAutocompletable) autocompletable;
                    if (roleAutocompletable != null) {
                        integerOptionValue = new RoleOptionValue(roleAutocompletable.getRole());
                        stringOptionValue = integerOptionValue;
                        break;
                    }
                    break;
                case 8:
                    if (autocompletable instanceof RoleAutocompletable) {
                        stringOptionValue = new RoleOptionValue(((RoleAutocompletable) autocompletable).getRole());
                        break;
                    } else if (autocompletable instanceof UserAutocompletable) {
                        stringOptionValue = new UserOptionValue(((UserAutocompletable) autocompletable).getUser());
                        break;
                    }
                    break;
                case 9:
                    Number numberAsSafeNumberOrNull = asSafeNumberOrNull(parseNumber(value));
                    if (numberAsSafeNumberOrNull != null) {
                        numberOptionValue = new NumberOptionValue(numberAsSafeNumberOrNull);
                        stringOptionValue = numberOptionValue;
                        break;
                    }
                    break;
                case 10:
                    Attachment<?> attachment = attachments.get(key);
                    if (attachment != null) {
                        String string3 = attachment.getUri().toString();
                        Intrinsics3.checkNotNullExpressionValue(string3, "it.uri.toString()");
                        numberOptionValue = new AttachmentOptionValue(string3);
                        stringOptionValue = numberOptionValue;
                        break;
                    }
                    break;
            }
            if (stringOptionValue != null) {
                linkedHashMap.put(key, stringOptionValue);
            } else {
                Long snowflake = SnowflakeUtils.INSTANCE.toSnowflake(string2);
                if (snowflake != null) {
                    linkedHashMap.put(key, new SnowflakeOptionValue(snowflake.longValue()));
                } else {
                    linkedHashMap.put(key, new RawOptionValue(string));
                }
            }
        }
        return linkedHashMap;
    }

    public final String transformParameterSpannableString(String str) {
        if (str == null) {
            return null;
        }
        if (Strings4.endsWith$default((CharSequence) Strings4.trim(str).toString(), MentionUtils.EMOJIS_AND_STICKERS_CHAR, false, 2, (Object) null)) {
            return Strings4.trim(str).toString();
        }
        if (!Strings4.contains$default((CharSequence) str, MentionUtils.EMOJIS_AND_STICKERS_CHAR, false, 2, (Object) null)) {
            return str;
        }
        List listSplit$default = Strings4.split$default((CharSequence) str, new char[]{MentionUtils.EMOJIS_AND_STICKERS_CHAR}, false, 0, 6, (Object) null);
        String str2 = (String) _Collections.firstOrNull(listSplit$default);
        String string = str2 != null ? Strings4.trim(str2).toString() : null;
        String strJoinToString$default = _Collections.joinToString$default(listSplit$default.subList(1, listSplit$default.size()), ":", null, null, 0, null, null, 62, null);
        Objects.requireNonNull(strJoinToString$default, "null cannot be cast to non-null type kotlin.CharSequence");
        return outline.y(string, ": ", Strings4.trim(strJoinToString$default).toString());
    }

    private final Integer asSafeNumberOrNull(Integer num) {
        if (num == null) {
            return null;
        }
        int iIntValue = num.intValue();
        if (INSTANCE.isSafeNumber(Integer.valueOf(iIntValue))) {
            return Integer.valueOf(iIntValue);
        }
        return null;
    }

    private final Long asSafeNumberOrNull(Long l) {
        if (l == null) {
            return null;
        }
        long jLongValue = l.longValue();
        if (INSTANCE.isSafeNumber(Long.valueOf(jLongValue))) {
            return Long.valueOf(jLongValue);
        }
        return null;
    }
}
