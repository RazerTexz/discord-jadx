package com.discord.widgets.chat.input.models;

import b.d.b.a.outline;
import com.discord.widgets.chat.input.autocomplete.Autocompletable;
import com.discord.widgets.chat.input.autocomplete.LeadingIdentifier;
import d0.z.d.Intrinsics3;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

/* compiled from: AutocompleteInputModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b#\u0010$J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\"\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ@\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\u001a\b\u0002\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001d\u001a\u0004\b\u001e\u0010\rR\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001f\u001a\u0004\b \u0010\u0004R+\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010!\u001a\u0004\b\"\u0010\n¨\u0006%"}, d2 = {"Lcom/discord/widgets/chat/input/models/AutocompleteInputModel;", "", "", "component1", "()Ljava/lang/CharSequence;", "", "Lcom/discord/widgets/chat/input/autocomplete/LeadingIdentifier;", "", "Lcom/discord/widgets/chat/input/autocomplete/Autocompletable;", "component2", "()Ljava/util/Map;", "Lcom/discord/widgets/chat/input/models/AutocompleteApplicationCommands;", "component3", "()Lcom/discord/widgets/chat/input/models/AutocompleteApplicationCommands;", "input", "autocompletables", "applicationCommands", "copy", "(Ljava/lang/CharSequence;Ljava/util/Map;Lcom/discord/widgets/chat/input/models/AutocompleteApplicationCommands;)Lcom/discord/widgets/chat/input/models/AutocompleteInputModel;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/widgets/chat/input/models/AutocompleteApplicationCommands;", "getApplicationCommands", "Ljava/lang/CharSequence;", "getInput", "Ljava/util/Map;", "getAutocompletables", "<init>", "(Ljava/lang/CharSequence;Ljava/util/Map;Lcom/discord/widgets/chat/input/models/AutocompleteApplicationCommands;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class AutocompleteInputModel {
    private final AutocompleteApplicationCommands applicationCommands;
    private final Map<LeadingIdentifier, Set<Autocompletable>> autocompletables;
    private final CharSequence input;

    /* JADX WARN: Multi-variable type inference failed */
    public AutocompleteInputModel(CharSequence charSequence, Map<LeadingIdentifier, ? extends Set<? extends Autocompletable>> map, AutocompleteApplicationCommands autocompleteApplicationCommands) {
        Intrinsics3.checkNotNullParameter(charSequence, "input");
        Intrinsics3.checkNotNullParameter(map, "autocompletables");
        Intrinsics3.checkNotNullParameter(autocompleteApplicationCommands, "applicationCommands");
        this.input = charSequence;
        this.autocompletables = map;
        this.applicationCommands = autocompleteApplicationCommands;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AutocompleteInputModel copy$default(AutocompleteInputModel autocompleteInputModel, CharSequence charSequence, Map map, AutocompleteApplicationCommands autocompleteApplicationCommands, int i, Object obj) {
        if ((i & 1) != 0) {
            charSequence = autocompleteInputModel.input;
        }
        if ((i & 2) != 0) {
            map = autocompleteInputModel.autocompletables;
        }
        if ((i & 4) != 0) {
            autocompleteApplicationCommands = autocompleteInputModel.applicationCommands;
        }
        return autocompleteInputModel.copy(charSequence, map, autocompleteApplicationCommands);
    }

    /* renamed from: component1, reason: from getter */
    public final CharSequence getInput() {
        return this.input;
    }

    public final Map<LeadingIdentifier, Set<Autocompletable>> component2() {
        return this.autocompletables;
    }

    /* renamed from: component3, reason: from getter */
    public final AutocompleteApplicationCommands getApplicationCommands() {
        return this.applicationCommands;
    }

    public final AutocompleteInputModel copy(CharSequence input, Map<LeadingIdentifier, ? extends Set<? extends Autocompletable>> autocompletables, AutocompleteApplicationCommands applicationCommands) {
        Intrinsics3.checkNotNullParameter(input, "input");
        Intrinsics3.checkNotNullParameter(autocompletables, "autocompletables");
        Intrinsics3.checkNotNullParameter(applicationCommands, "applicationCommands");
        return new AutocompleteInputModel(input, autocompletables, applicationCommands);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AutocompleteInputModel)) {
            return false;
        }
        AutocompleteInputModel autocompleteInputModel = (AutocompleteInputModel) other;
        return Intrinsics3.areEqual(this.input, autocompleteInputModel.input) && Intrinsics3.areEqual(this.autocompletables, autocompleteInputModel.autocompletables) && Intrinsics3.areEqual(this.applicationCommands, autocompleteInputModel.applicationCommands);
    }

    public final AutocompleteApplicationCommands getApplicationCommands() {
        return this.applicationCommands;
    }

    public final Map<LeadingIdentifier, Set<Autocompletable>> getAutocompletables() {
        return this.autocompletables;
    }

    public final CharSequence getInput() {
        return this.input;
    }

    public int hashCode() {
        CharSequence charSequence = this.input;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Map<LeadingIdentifier, Set<Autocompletable>> map = this.autocompletables;
        int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
        AutocompleteApplicationCommands autocompleteApplicationCommands = this.applicationCommands;
        return iHashCode2 + (autocompleteApplicationCommands != null ? autocompleteApplicationCommands.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("AutocompleteInputModel(input=");
        sbU.append(this.input);
        sbU.append(", autocompletables=");
        sbU.append(this.autocompletables);
        sbU.append(", applicationCommands=");
        sbU.append(this.applicationCommands);
        sbU.append(")");
        return sbU.toString();
    }
}
