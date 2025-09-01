package com.discord.widgets.chat.input.models;

import b.d.b.a.outline;
import com.discord.models.commands.ApplicationCommandOption;
import com.discord.widgets.chat.input.models.MentionInputModel;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.Ranges2;

/* compiled from: InputSelectionModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u000e\u000fB\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u0003\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\u0082\u0001\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/discord/widgets/chat/input/models/InputSelectionModel;", "", "Lcom/discord/widgets/chat/input/models/MentionInputModel;", "inputModel", "Lcom/discord/widgets/chat/input/models/MentionInputModel;", "getInputModel", "()Lcom/discord/widgets/chat/input/models/MentionInputModel;", "Lkotlin/ranges/IntRange;", "selection", "Lkotlin/ranges/IntRange;", "getSelection", "()Lkotlin/ranges/IntRange;", "<init>", "(Lcom/discord/widgets/chat/input/models/MentionInputModel;Lkotlin/ranges/IntRange;)V", "CommandInputSelectionModel", "MessageInputSelectionModel", "Lcom/discord/widgets/chat/input/models/InputSelectionModel$CommandInputSelectionModel;", "Lcom/discord/widgets/chat/input/models/InputSelectionModel$MessageInputSelectionModel;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public abstract class InputSelectionModel {
    private final MentionInputModel inputModel;
    private final Ranges2 selection;

    /* compiled from: InputSelectionModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ0\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u001c\u0010\u000b\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004R\u001c\u0010\f\u001a\u00020\u00058\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010\u001d\u001a\u0004\b\u001e\u0010\u0007R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001f\u001a\u0004\b \u0010\n¨\u0006#"}, d2 = {"Lcom/discord/widgets/chat/input/models/InputSelectionModel$CommandInputSelectionModel;", "Lcom/discord/widgets/chat/input/models/InputSelectionModel;", "Lcom/discord/widgets/chat/input/models/MentionInputModel$VerifiedCommandInputModel;", "component1", "()Lcom/discord/widgets/chat/input/models/MentionInputModel$VerifiedCommandInputModel;", "Lkotlin/ranges/IntRange;", "component2", "()Lkotlin/ranges/IntRange;", "Lcom/discord/models/commands/ApplicationCommandOption;", "component3", "()Lcom/discord/models/commands/ApplicationCommandOption;", "inputModel", "selection", "selectedCommandOption", "copy", "(Lcom/discord/widgets/chat/input/models/MentionInputModel$VerifiedCommandInputModel;Lkotlin/ranges/IntRange;Lcom/discord/models/commands/ApplicationCommandOption;)Lcom/discord/widgets/chat/input/models/InputSelectionModel$CommandInputSelectionModel;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/widgets/chat/input/models/MentionInputModel$VerifiedCommandInputModel;", "getInputModel", "Lkotlin/ranges/IntRange;", "getSelection", "Lcom/discord/models/commands/ApplicationCommandOption;", "getSelectedCommandOption", "<init>", "(Lcom/discord/widgets/chat/input/models/MentionInputModel$VerifiedCommandInputModel;Lkotlin/ranges/IntRange;Lcom/discord/models/commands/ApplicationCommandOption;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class CommandInputSelectionModel extends InputSelectionModel {
        private final MentionInputModel.VerifiedCommandInputModel inputModel;
        private final ApplicationCommandOption selectedCommandOption;
        private final Ranges2 selection;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CommandInputSelectionModel(MentionInputModel.VerifiedCommandInputModel verifiedCommandInputModel, Ranges2 ranges2, ApplicationCommandOption applicationCommandOption) {
            super(verifiedCommandInputModel, ranges2, null);
            Intrinsics3.checkNotNullParameter(verifiedCommandInputModel, "inputModel");
            Intrinsics3.checkNotNullParameter(ranges2, "selection");
            this.inputModel = verifiedCommandInputModel;
            this.selection = ranges2;
            this.selectedCommandOption = applicationCommandOption;
        }

        public static /* synthetic */ CommandInputSelectionModel copy$default(CommandInputSelectionModel commandInputSelectionModel, MentionInputModel.VerifiedCommandInputModel verifiedCommandInputModel, Ranges2 ranges2, ApplicationCommandOption applicationCommandOption, int i, Object obj) {
            if ((i & 1) != 0) {
                verifiedCommandInputModel = commandInputSelectionModel.getInputModel();
            }
            if ((i & 2) != 0) {
                ranges2 = commandInputSelectionModel.getSelection();
            }
            if ((i & 4) != 0) {
                applicationCommandOption = commandInputSelectionModel.selectedCommandOption;
            }
            return commandInputSelectionModel.copy(verifiedCommandInputModel, ranges2, applicationCommandOption);
        }

        public final MentionInputModel.VerifiedCommandInputModel component1() {
            return getInputModel();
        }

        public final Ranges2 component2() {
            return getSelection();
        }

        /* renamed from: component3, reason: from getter */
        public final ApplicationCommandOption getSelectedCommandOption() {
            return this.selectedCommandOption;
        }

        public final CommandInputSelectionModel copy(MentionInputModel.VerifiedCommandInputModel inputModel, Ranges2 selection, ApplicationCommandOption selectedCommandOption) {
            Intrinsics3.checkNotNullParameter(inputModel, "inputModel");
            Intrinsics3.checkNotNullParameter(selection, "selection");
            return new CommandInputSelectionModel(inputModel, selection, selectedCommandOption);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CommandInputSelectionModel)) {
                return false;
            }
            CommandInputSelectionModel commandInputSelectionModel = (CommandInputSelectionModel) other;
            return Intrinsics3.areEqual(getInputModel(), commandInputSelectionModel.getInputModel()) && Intrinsics3.areEqual(getSelection(), commandInputSelectionModel.getSelection()) && Intrinsics3.areEqual(this.selectedCommandOption, commandInputSelectionModel.selectedCommandOption);
        }

        @Override // com.discord.widgets.chat.input.models.InputSelectionModel
        public /* bridge */ /* synthetic */ MentionInputModel getInputModel() {
            return getInputModel();
        }

        public final ApplicationCommandOption getSelectedCommandOption() {
            return this.selectedCommandOption;
        }

        @Override // com.discord.widgets.chat.input.models.InputSelectionModel
        public Ranges2 getSelection() {
            return this.selection;
        }

        public int hashCode() {
            MentionInputModel.VerifiedCommandInputModel inputModel = getInputModel();
            int iHashCode = (inputModel != null ? inputModel.hashCode() : 0) * 31;
            Ranges2 selection = getSelection();
            int iHashCode2 = (iHashCode + (selection != null ? selection.hashCode() : 0)) * 31;
            ApplicationCommandOption applicationCommandOption = this.selectedCommandOption;
            return iHashCode2 + (applicationCommandOption != null ? applicationCommandOption.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("CommandInputSelectionModel(inputModel=");
            sbU.append(getInputModel());
            sbU.append(", selection=");
            sbU.append(getSelection());
            sbU.append(", selectedCommandOption=");
            sbU.append(this.selectedCommandOption);
            sbU.append(")");
            return sbU.toString();
        }

        @Override // com.discord.widgets.chat.input.models.InputSelectionModel
        public MentionInputModel.VerifiedCommandInputModel getInputModel() {
            return this.inputModel;
        }
    }

    /* compiled from: InputSelectionModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\b\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u001c\u0010\t\u001a\u00020\u00058\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\u0019\u001a\u0004\b\u001a\u0010\u0007¨\u0006\u001d"}, d2 = {"Lcom/discord/widgets/chat/input/models/InputSelectionModel$MessageInputSelectionModel;", "Lcom/discord/widgets/chat/input/models/InputSelectionModel;", "Lcom/discord/widgets/chat/input/models/MentionInputModel;", "component1", "()Lcom/discord/widgets/chat/input/models/MentionInputModel;", "Lkotlin/ranges/IntRange;", "component2", "()Lkotlin/ranges/IntRange;", "inputModel", "selection", "copy", "(Lcom/discord/widgets/chat/input/models/MentionInputModel;Lkotlin/ranges/IntRange;)Lcom/discord/widgets/chat/input/models/InputSelectionModel$MessageInputSelectionModel;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/widgets/chat/input/models/MentionInputModel;", "getInputModel", "Lkotlin/ranges/IntRange;", "getSelection", "<init>", "(Lcom/discord/widgets/chat/input/models/MentionInputModel;Lkotlin/ranges/IntRange;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class MessageInputSelectionModel extends InputSelectionModel {
        private final MentionInputModel inputModel;
        private final Ranges2 selection;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MessageInputSelectionModel(MentionInputModel mentionInputModel, Ranges2 ranges2) {
            super(mentionInputModel, ranges2, null);
            Intrinsics3.checkNotNullParameter(mentionInputModel, "inputModel");
            Intrinsics3.checkNotNullParameter(ranges2, "selection");
            this.inputModel = mentionInputModel;
            this.selection = ranges2;
        }

        public static /* synthetic */ MessageInputSelectionModel copy$default(MessageInputSelectionModel messageInputSelectionModel, MentionInputModel mentionInputModel, Ranges2 ranges2, int i, Object obj) {
            if ((i & 1) != 0) {
                mentionInputModel = messageInputSelectionModel.getInputModel();
            }
            if ((i & 2) != 0) {
                ranges2 = messageInputSelectionModel.getSelection();
            }
            return messageInputSelectionModel.copy(mentionInputModel, ranges2);
        }

        public final MentionInputModel component1() {
            return getInputModel();
        }

        public final Ranges2 component2() {
            return getSelection();
        }

        public final MessageInputSelectionModel copy(MentionInputModel inputModel, Ranges2 selection) {
            Intrinsics3.checkNotNullParameter(inputModel, "inputModel");
            Intrinsics3.checkNotNullParameter(selection, "selection");
            return new MessageInputSelectionModel(inputModel, selection);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MessageInputSelectionModel)) {
                return false;
            }
            MessageInputSelectionModel messageInputSelectionModel = (MessageInputSelectionModel) other;
            return Intrinsics3.areEqual(getInputModel(), messageInputSelectionModel.getInputModel()) && Intrinsics3.areEqual(getSelection(), messageInputSelectionModel.getSelection());
        }

        @Override // com.discord.widgets.chat.input.models.InputSelectionModel
        public MentionInputModel getInputModel() {
            return this.inputModel;
        }

        @Override // com.discord.widgets.chat.input.models.InputSelectionModel
        public Ranges2 getSelection() {
            return this.selection;
        }

        public int hashCode() {
            MentionInputModel inputModel = getInputModel();
            int iHashCode = (inputModel != null ? inputModel.hashCode() : 0) * 31;
            Ranges2 selection = getSelection();
            return iHashCode + (selection != null ? selection.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("MessageInputSelectionModel(inputModel=");
            sbU.append(getInputModel());
            sbU.append(", selection=");
            sbU.append(getSelection());
            sbU.append(")");
            return sbU.toString();
        }
    }

    private InputSelectionModel(MentionInputModel mentionInputModel, Ranges2 ranges2) {
        this.inputModel = mentionInputModel;
        this.selection = ranges2;
    }

    public MentionInputModel getInputModel() {
        return this.inputModel;
    }

    public Ranges2 getSelection() {
        return this.selection;
    }

    public /* synthetic */ InputSelectionModel(MentionInputModel mentionInputModel, Ranges2 ranges2, DefaultConstructorMarker defaultConstructorMarker) {
        this(mentionInputModel, ranges2);
    }
}
