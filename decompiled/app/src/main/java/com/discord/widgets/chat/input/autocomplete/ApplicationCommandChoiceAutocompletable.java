package com.discord.widgets.chat.input.autocomplete;

import b.d.b.a.outline;
import com.discord.api.commands.CommandChoice;
import d0.t.CollectionsJVM;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Autocompletable.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\f\u001a\u00020\b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J&\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u001b\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004R\u0019\u0010\f\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\u001c\u0010\nR\u001f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u0007¨\u0006\""}, d2 = {"Lcom/discord/widgets/chat/input/autocomplete/ApplicationCommandChoiceAutocompletable;", "Lcom/discord/widgets/chat/input/autocomplete/Autocompletable;", "", "getInputReplacement", "()Ljava/lang/String;", "", "getInputTextMatchers", "()Ljava/util/List;", "Lcom/discord/api/commands/CommandChoice;", "component1", "()Lcom/discord/api/commands/CommandChoice;", "component2", "choice", "optionName", "copy", "(Lcom/discord/api/commands/CommandChoice;Ljava/lang/String;)Lcom/discord/widgets/chat/input/autocomplete/ApplicationCommandChoiceAutocompletable;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getOptionName", "Lcom/discord/api/commands/CommandChoice;", "getChoice", "textMatchers", "Ljava/util/List;", "getTextMatchers", "<init>", "(Lcom/discord/api/commands/CommandChoice;Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class ApplicationCommandChoiceAutocompletable extends Autocompletable {
    private final CommandChoice choice;
    private final String optionName;
    private final List<String> textMatchers;

    public /* synthetic */ ApplicationCommandChoiceAutocompletable(CommandChoice commandChoice, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(commandChoice, (i & 2) != 0 ? null : str);
    }

    public static /* synthetic */ ApplicationCommandChoiceAutocompletable copy$default(ApplicationCommandChoiceAutocompletable applicationCommandChoiceAutocompletable, CommandChoice commandChoice, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            commandChoice = applicationCommandChoiceAutocompletable.choice;
        }
        if ((i & 2) != 0) {
            str = applicationCommandChoiceAutocompletable.optionName;
        }
        return applicationCommandChoiceAutocompletable.copy(commandChoice, str);
    }

    /* renamed from: component1, reason: from getter */
    public final CommandChoice getChoice() {
        return this.choice;
    }

    /* renamed from: component2, reason: from getter */
    public final String getOptionName() {
        return this.optionName;
    }

    public final ApplicationCommandChoiceAutocompletable copy(CommandChoice choice, String optionName) {
        Intrinsics3.checkNotNullParameter(choice, "choice");
        return new ApplicationCommandChoiceAutocompletable(choice, optionName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApplicationCommandChoiceAutocompletable)) {
            return false;
        }
        ApplicationCommandChoiceAutocompletable applicationCommandChoiceAutocompletable = (ApplicationCommandChoiceAutocompletable) other;
        return Intrinsics3.areEqual(this.choice, applicationCommandChoiceAutocompletable.choice) && Intrinsics3.areEqual(this.optionName, applicationCommandChoiceAutocompletable.optionName);
    }

    public final CommandChoice getChoice() {
        return this.choice;
    }

    @Override // com.discord.widgets.chat.input.autocomplete.Autocompletable
    public String getInputReplacement() {
        return this.choice.getValue();
    }

    @Override // com.discord.widgets.chat.input.autocomplete.Autocompletable
    public List<String> getInputTextMatchers() {
        return this.textMatchers;
    }

    public final String getOptionName() {
        return this.optionName;
    }

    public final List<String> getTextMatchers() {
        return this.textMatchers;
    }

    public int hashCode() {
        CommandChoice commandChoice = this.choice;
        int iHashCode = (commandChoice != null ? commandChoice.hashCode() : 0) * 31;
        String str = this.optionName;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ApplicationCommandChoiceAutocompletable(choice=");
        sbU.append(this.choice);
        sbU.append(", optionName=");
        return outline.J(sbU, this.optionName, ")");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApplicationCommandChoiceAutocompletable(CommandChoice commandChoice, String str) {
        super(null);
        Intrinsics3.checkNotNullParameter(commandChoice, "choice");
        this.choice = commandChoice;
        this.optionName = str;
        this.textMatchers = CollectionsJVM.listOf(commandChoice.getName());
    }
}
