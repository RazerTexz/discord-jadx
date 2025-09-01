package com.discord.widgets.chat.input.autocomplete;

import a0.a.a.b;
import b.d.b.a.outline;
import com.discord.models.commands.ApplicationCommandOption;
import com.lytefast.flexinput.model.Attachment;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: AutocompleteViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/discord/widgets/chat/input/autocomplete/Event;", "", "<init>", "()V", "PickAttachment", "PreviewAttachment", "RequestAutocompleteData", "ScrollAutocompletablesToApplication", "Lcom/discord/widgets/chat/input/autocomplete/Event$ScrollAutocompletablesToApplication;", "Lcom/discord/widgets/chat/input/autocomplete/Event$RequestAutocompleteData;", "Lcom/discord/widgets/chat/input/autocomplete/Event$PreviewAttachment;", "Lcom/discord/widgets/chat/input/autocomplete/Event$PickAttachment;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.input.autocomplete.Event, reason: use source file name */
/* loaded from: classes2.dex */
public abstract class AutocompleteViewModel5 {

    /* compiled from: AutocompleteViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/chat/input/autocomplete/Event$PickAttachment;", "Lcom/discord/widgets/chat/input/autocomplete/Event;", "Lcom/discord/models/commands/ApplicationCommandOption;", "component1", "()Lcom/discord/models/commands/ApplicationCommandOption;", "commandOption", "copy", "(Lcom/discord/models/commands/ApplicationCommandOption;)Lcom/discord/widgets/chat/input/autocomplete/Event$PickAttachment;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/commands/ApplicationCommandOption;", "getCommandOption", "<init>", "(Lcom/discord/models/commands/ApplicationCommandOption;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.autocomplete.Event$PickAttachment */
    public static final /* data */ class PickAttachment extends AutocompleteViewModel5 {
        private final ApplicationCommandOption commandOption;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PickAttachment(ApplicationCommandOption applicationCommandOption) {
            super(null);
            Intrinsics3.checkNotNullParameter(applicationCommandOption, "commandOption");
            this.commandOption = applicationCommandOption;
        }

        public static /* synthetic */ PickAttachment copy$default(PickAttachment pickAttachment, ApplicationCommandOption applicationCommandOption, int i, Object obj) {
            if ((i & 1) != 0) {
                applicationCommandOption = pickAttachment.commandOption;
            }
            return pickAttachment.copy(applicationCommandOption);
        }

        /* renamed from: component1, reason: from getter */
        public final ApplicationCommandOption getCommandOption() {
            return this.commandOption;
        }

        public final PickAttachment copy(ApplicationCommandOption commandOption) {
            Intrinsics3.checkNotNullParameter(commandOption, "commandOption");
            return new PickAttachment(commandOption);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof PickAttachment) && Intrinsics3.areEqual(this.commandOption, ((PickAttachment) other).commandOption);
            }
            return true;
        }

        public final ApplicationCommandOption getCommandOption() {
            return this.commandOption;
        }

        public int hashCode() {
            ApplicationCommandOption applicationCommandOption = this.commandOption;
            if (applicationCommandOption != null) {
                return applicationCommandOption.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = outline.U("PickAttachment(commandOption=");
            sbU.append(this.commandOption);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: AutocompleteViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0014\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001e\u0010\u0006\u001a\u00020\u00002\f\b\u0002\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/chat/input/autocomplete/Event$PreviewAttachment;", "Lcom/discord/widgets/chat/input/autocomplete/Event;", "Lcom/lytefast/flexinput/model/Attachment;", "component1", "()Lcom/lytefast/flexinput/model/Attachment;", "attachment", "copy", "(Lcom/lytefast/flexinput/model/Attachment;)Lcom/discord/widgets/chat/input/autocomplete/Event$PreviewAttachment;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/lytefast/flexinput/model/Attachment;", "getAttachment", "<init>", "(Lcom/lytefast/flexinput/model/Attachment;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.autocomplete.Event$PreviewAttachment */
    public static final /* data */ class PreviewAttachment extends AutocompleteViewModel5 {
        private final Attachment<?> attachment;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PreviewAttachment(Attachment<?> attachment) {
            super(null);
            Intrinsics3.checkNotNullParameter(attachment, "attachment");
            this.attachment = attachment;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ PreviewAttachment copy$default(PreviewAttachment previewAttachment, Attachment attachment, int i, Object obj) {
            if ((i & 1) != 0) {
                attachment = previewAttachment.attachment;
            }
            return previewAttachment.copy(attachment);
        }

        public final Attachment<?> component1() {
            return this.attachment;
        }

        public final PreviewAttachment copy(Attachment<?> attachment) {
            Intrinsics3.checkNotNullParameter(attachment, "attachment");
            return new PreviewAttachment(attachment);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof PreviewAttachment) && Intrinsics3.areEqual(this.attachment, ((PreviewAttachment) other).attachment);
            }
            return true;
        }

        public final Attachment<?> getAttachment() {
            return this.attachment;
        }

        public int hashCode() {
            Attachment<?> attachment = this.attachment;
            if (attachment != null) {
                return attachment.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = outline.U("PreviewAttachment(attachment=");
            sbU.append(this.attachment);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: AutocompleteViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/chat/input/autocomplete/Event$RequestAutocompleteData;", "Lcom/discord/widgets/chat/input/autocomplete/Event;", "Lcom/discord/models/commands/ApplicationCommandOption;", "component1", "()Lcom/discord/models/commands/ApplicationCommandOption;", "option", "copy", "(Lcom/discord/models/commands/ApplicationCommandOption;)Lcom/discord/widgets/chat/input/autocomplete/Event$RequestAutocompleteData;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/commands/ApplicationCommandOption;", "getOption", "<init>", "(Lcom/discord/models/commands/ApplicationCommandOption;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.autocomplete.Event$RequestAutocompleteData */
    public static final /* data */ class RequestAutocompleteData extends AutocompleteViewModel5 {
        private final ApplicationCommandOption option;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RequestAutocompleteData(ApplicationCommandOption applicationCommandOption) {
            super(null);
            Intrinsics3.checkNotNullParameter(applicationCommandOption, "option");
            this.option = applicationCommandOption;
        }

        public static /* synthetic */ RequestAutocompleteData copy$default(RequestAutocompleteData requestAutocompleteData, ApplicationCommandOption applicationCommandOption, int i, Object obj) {
            if ((i & 1) != 0) {
                applicationCommandOption = requestAutocompleteData.option;
            }
            return requestAutocompleteData.copy(applicationCommandOption);
        }

        /* renamed from: component1, reason: from getter */
        public final ApplicationCommandOption getOption() {
            return this.option;
        }

        public final RequestAutocompleteData copy(ApplicationCommandOption option) {
            Intrinsics3.checkNotNullParameter(option, "option");
            return new RequestAutocompleteData(option);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof RequestAutocompleteData) && Intrinsics3.areEqual(this.option, ((RequestAutocompleteData) other).option);
            }
            return true;
        }

        public final ApplicationCommandOption getOption() {
            return this.option;
        }

        public int hashCode() {
            ApplicationCommandOption applicationCommandOption = this.option;
            if (applicationCommandOption != null) {
                return applicationCommandOption.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = outline.U("RequestAutocompleteData(option=");
            sbU.append(this.option);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: AutocompleteViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0007J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007¨\u0006\u001b"}, d2 = {"Lcom/discord/widgets/chat/input/autocomplete/Event$ScrollAutocompletablesToApplication;", "Lcom/discord/widgets/chat/input/autocomplete/Event;", "", "component1", "()J", "", "component2", "()I", "applicationId", "targetPosition", "copy", "(JI)Lcom/discord/widgets/chat/input/autocomplete/Event$ScrollAutocompletablesToApplication;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getApplicationId", "I", "getTargetPosition", "<init>", "(JI)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.autocomplete.Event$ScrollAutocompletablesToApplication */
    public static final /* data */ class ScrollAutocompletablesToApplication extends AutocompleteViewModel5 {
        private final long applicationId;
        private final int targetPosition;

        public ScrollAutocompletablesToApplication(long j, int i) {
            super(null);
            this.applicationId = j;
            this.targetPosition = i;
        }

        public static /* synthetic */ ScrollAutocompletablesToApplication copy$default(ScrollAutocompletablesToApplication scrollAutocompletablesToApplication, long j, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                j = scrollAutocompletablesToApplication.applicationId;
            }
            if ((i2 & 2) != 0) {
                i = scrollAutocompletablesToApplication.targetPosition;
            }
            return scrollAutocompletablesToApplication.copy(j, i);
        }

        /* renamed from: component1, reason: from getter */
        public final long getApplicationId() {
            return this.applicationId;
        }

        /* renamed from: component2, reason: from getter */
        public final int getTargetPosition() {
            return this.targetPosition;
        }

        public final ScrollAutocompletablesToApplication copy(long applicationId, int targetPosition) {
            return new ScrollAutocompletablesToApplication(applicationId, targetPosition);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ScrollAutocompletablesToApplication)) {
                return false;
            }
            ScrollAutocompletablesToApplication scrollAutocompletablesToApplication = (ScrollAutocompletablesToApplication) other;
            return this.applicationId == scrollAutocompletablesToApplication.applicationId && this.targetPosition == scrollAutocompletablesToApplication.targetPosition;
        }

        public final long getApplicationId() {
            return this.applicationId;
        }

        public final int getTargetPosition() {
            return this.targetPosition;
        }

        public int hashCode() {
            return (b.a(this.applicationId) * 31) + this.targetPosition;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ScrollAutocompletablesToApplication(applicationId=");
            sbU.append(this.applicationId);
            sbU.append(", targetPosition=");
            return outline.B(sbU, this.targetPosition, ")");
        }
    }

    private AutocompleteViewModel5() {
    }

    public /* synthetic */ AutocompleteViewModel5(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
