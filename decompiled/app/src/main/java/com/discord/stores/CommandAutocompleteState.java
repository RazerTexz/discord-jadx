package com.discord.stores;

import b.d.b.a.outline;
import com.discord.api.commands.ApplicationCommandAutocompleteChoice;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: StoreApplicationCommands.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/discord/stores/CommandAutocompleteState;", "", "<init>", "()V", "Choices", "Failed", "Loading", "Lcom/discord/stores/CommandAutocompleteState$Loading;", "Lcom/discord/stores/CommandAutocompleteState$Failed;", "Lcom/discord/stores/CommandAutocompleteState$Choices;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public abstract class CommandAutocompleteState {

    /* compiled from: StoreApplicationCommands.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0005¨\u0006\u0018"}, d2 = {"Lcom/discord/stores/CommandAutocompleteState$Choices;", "Lcom/discord/stores/CommandAutocompleteState;", "", "Lcom/discord/api/commands/ApplicationCommandAutocompleteChoice;", "component1", "()Ljava/util/List;", "choices", "copy", "(Ljava/util/List;)Lcom/discord/stores/CommandAutocompleteState$Choices;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getChoices", "<init>", "(Ljava/util/List;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Choices extends CommandAutocompleteState {
        private final List<ApplicationCommandAutocompleteChoice> choices;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Choices(List<ApplicationCommandAutocompleteChoice> list) {
            super(null);
            Intrinsics3.checkNotNullParameter(list, "choices");
            this.choices = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Choices copy$default(Choices choices, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = choices.choices;
            }
            return choices.copy(list);
        }

        public final List<ApplicationCommandAutocompleteChoice> component1() {
            return this.choices;
        }

        public final Choices copy(List<ApplicationCommandAutocompleteChoice> choices) {
            Intrinsics3.checkNotNullParameter(choices, "choices");
            return new Choices(choices);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof Choices) && Intrinsics3.areEqual(this.choices, ((Choices) other).choices);
            }
            return true;
        }

        public final List<ApplicationCommandAutocompleteChoice> getChoices() {
            return this.choices;
        }

        public int hashCode() {
            List<ApplicationCommandAutocompleteChoice> list = this.choices;
            if (list != null) {
                return list.hashCode();
            }
            return 0;
        }

        public String toString() {
            return outline.L(outline.U("Choices(choices="), this.choices, ")");
        }
    }

    /* compiled from: StoreApplicationCommands.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/stores/CommandAutocompleteState$Failed;", "Lcom/discord/stores/CommandAutocompleteState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Failed extends CommandAutocompleteState {
        public static final Failed INSTANCE = new Failed();

        private Failed() {
            super(null);
        }
    }

    /* compiled from: StoreApplicationCommands.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/stores/CommandAutocompleteState$Loading;", "Lcom/discord/stores/CommandAutocompleteState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Loading extends CommandAutocompleteState {
        public static final Loading INSTANCE = new Loading();

        private Loading() {
            super(null);
        }
    }

    private CommandAutocompleteState() {
    }

    public /* synthetic */ CommandAutocompleteState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
