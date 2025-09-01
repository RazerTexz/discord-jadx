package com.discord.widgets.chat.input.models;

import com.discord.api.commands.ApplicationCommandType;
import com.discord.api.commands.CommandChoice;
import com.discord.models.commands.ApplicationCommand;
import com.discord.models.commands.ApplicationCommandOption;
import com.discord.widgets.chat.input.models.InputSelectionModel;
import com.discord.widgets.chat.input.models.MentionInputModel;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: InputSelectionModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0004\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005*\u00020\u0000¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/chat/input/models/InputSelectionModel;", "", "hasSelectedCommandOptionWithChoices", "(Lcom/discord/widgets/chat/input/models/InputSelectionModel;)Z", "hasSelectedFreeformInput", "Lcom/discord/models/commands/ApplicationCommand;", "getSelectedCommand", "(Lcom/discord/widgets/chat/input/models/InputSelectionModel;)Lcom/discord/models/commands/ApplicationCommand;", "app_productionGoogleRelease"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.input.models.InputSelectionModelKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class InputSelectionModel2 {
    public static final ApplicationCommand getSelectedCommand(InputSelectionModel inputSelectionModel) {
        InputCommandContext inputCommandContext;
        Intrinsics3.checkNotNullParameter(inputSelectionModel, "$this$getSelectedCommand");
        MentionInputModel inputModel = inputSelectionModel.getInputModel();
        if (!(inputModel instanceof MentionInputModel.VerifiedCommandInputModel)) {
            inputModel = null;
        }
        MentionInputModel.VerifiedCommandInputModel verifiedCommandInputModel = (MentionInputModel.VerifiedCommandInputModel) inputModel;
        if (verifiedCommandInputModel == null || (inputCommandContext = verifiedCommandInputModel.getInputCommandContext()) == null) {
            return null;
        }
        return inputCommandContext.getSelectedCommand();
    }

    public static final boolean hasSelectedCommandOptionWithChoices(InputSelectionModel inputSelectionModel) {
        Intrinsics3.checkNotNullParameter(inputSelectionModel, "$this$hasSelectedCommandOptionWithChoices");
        if (inputSelectionModel instanceof InputSelectionModel.CommandInputSelectionModel) {
            InputSelectionModel.CommandInputSelectionModel commandInputSelectionModel = (InputSelectionModel.CommandInputSelectionModel) inputSelectionModel;
            ApplicationCommandOption selectedCommandOption = commandInputSelectionModel.getSelectedCommandOption();
            List<CommandChoice> choices = selectedCommandOption != null ? selectedCommandOption.getChoices() : null;
            if (!(choices == null || choices.isEmpty())) {
                return true;
            }
            ApplicationCommandOption selectedCommandOption2 = commandInputSelectionModel.getSelectedCommandOption();
            if ((selectedCommandOption2 != null ? selectedCommandOption2.getType() : null) == ApplicationCommandType.BOOLEAN) {
                return true;
            }
        }
        return false;
    }

    public static final boolean hasSelectedFreeformInput(InputSelectionModel inputSelectionModel) {
        Intrinsics3.checkNotNullParameter(inputSelectionModel, "$this$hasSelectedFreeformInput");
        if (!(inputSelectionModel instanceof InputSelectionModel.CommandInputSelectionModel)) {
            if (inputSelectionModel instanceof InputSelectionModel.MessageInputSelectionModel) {
                return true;
            }
            throw new NoWhenBranchMatchedException();
        }
        InputSelectionModel.CommandInputSelectionModel commandInputSelectionModel = (InputSelectionModel.CommandInputSelectionModel) inputSelectionModel;
        if (commandInputSelectionModel.getSelectedCommandOption() == null) {
            return true;
        }
        List<CommandChoice> choices = commandInputSelectionModel.getSelectedCommandOption().getChoices();
        boolean z2 = choices != null && (choices.isEmpty() ^ true);
        ApplicationCommandType type = commandInputSelectionModel.getSelectedCommandOption().getType();
        return (commandInputSelectionModel.getSelectedCommandOption().getAutocomplete() || z2 || (type != ApplicationCommandType.INTEGER && type != ApplicationCommandType.STRING)) ? false : true;
    }
}
