package com.discord.widgets.chat.input.autocomplete;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: AutocompleteViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004¨\u0006\u001c"}, d2 = {"Lcom/discord/widgets/chat/input/autocomplete/ViewState;", "", "Lcom/discord/widgets/chat/input/autocomplete/AutocompleteViewState;", "component1", "()Lcom/discord/widgets/chat/input/autocomplete/AutocompleteViewState;", "Lcom/discord/widgets/chat/input/autocomplete/SelectedCommandViewState;", "component2", "()Lcom/discord/widgets/chat/input/autocomplete/SelectedCommandViewState;", "autocompleteViewState", "selectedCommandViewState", "copy", "(Lcom/discord/widgets/chat/input/autocomplete/AutocompleteViewState;Lcom/discord/widgets/chat/input/autocomplete/SelectedCommandViewState;)Lcom/discord/widgets/chat/input/autocomplete/ViewState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/widgets/chat/input/autocomplete/SelectedCommandViewState;", "getSelectedCommandViewState", "Lcom/discord/widgets/chat/input/autocomplete/AutocompleteViewState;", "getAutocompleteViewState", "<init>", "(Lcom/discord/widgets/chat/input/autocomplete/AutocompleteViewState;Lcom/discord/widgets/chat/input/autocomplete/SelectedCommandViewState;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.input.autocomplete.ViewState, reason: use source file name */
/* loaded from: classes2.dex */
public final /* data */ class AutocompleteViewModel7 {
    private final AutocompleteViewModel4 autocompleteViewState;
    private final AutocompleteViewModel6 selectedCommandViewState;

    public AutocompleteViewModel7(AutocompleteViewModel4 autocompleteViewModel4, AutocompleteViewModel6 autocompleteViewModel6) {
        Intrinsics3.checkNotNullParameter(autocompleteViewModel4, "autocompleteViewState");
        Intrinsics3.checkNotNullParameter(autocompleteViewModel6, "selectedCommandViewState");
        this.autocompleteViewState = autocompleteViewModel4;
        this.selectedCommandViewState = autocompleteViewModel6;
    }

    public static /* synthetic */ AutocompleteViewModel7 copy$default(AutocompleteViewModel7 autocompleteViewModel7, AutocompleteViewModel4 autocompleteViewModel4, AutocompleteViewModel6 autocompleteViewModel6, int i, Object obj) {
        if ((i & 1) != 0) {
            autocompleteViewModel4 = autocompleteViewModel7.autocompleteViewState;
        }
        if ((i & 2) != 0) {
            autocompleteViewModel6 = autocompleteViewModel7.selectedCommandViewState;
        }
        return autocompleteViewModel7.copy(autocompleteViewModel4, autocompleteViewModel6);
    }

    /* renamed from: component1, reason: from getter */
    public final AutocompleteViewModel4 getAutocompleteViewState() {
        return this.autocompleteViewState;
    }

    /* renamed from: component2, reason: from getter */
    public final AutocompleteViewModel6 getSelectedCommandViewState() {
        return this.selectedCommandViewState;
    }

    public final AutocompleteViewModel7 copy(AutocompleteViewModel4 autocompleteViewState, AutocompleteViewModel6 selectedCommandViewState) {
        Intrinsics3.checkNotNullParameter(autocompleteViewState, "autocompleteViewState");
        Intrinsics3.checkNotNullParameter(selectedCommandViewState, "selectedCommandViewState");
        return new AutocompleteViewModel7(autocompleteViewState, selectedCommandViewState);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AutocompleteViewModel7)) {
            return false;
        }
        AutocompleteViewModel7 autocompleteViewModel7 = (AutocompleteViewModel7) other;
        return Intrinsics3.areEqual(this.autocompleteViewState, autocompleteViewModel7.autocompleteViewState) && Intrinsics3.areEqual(this.selectedCommandViewState, autocompleteViewModel7.selectedCommandViewState);
    }

    public final AutocompleteViewModel4 getAutocompleteViewState() {
        return this.autocompleteViewState;
    }

    public final AutocompleteViewModel6 getSelectedCommandViewState() {
        return this.selectedCommandViewState;
    }

    public int hashCode() {
        AutocompleteViewModel4 autocompleteViewModel4 = this.autocompleteViewState;
        int iHashCode = (autocompleteViewModel4 != null ? autocompleteViewModel4.hashCode() : 0) * 31;
        AutocompleteViewModel6 autocompleteViewModel6 = this.selectedCommandViewState;
        return iHashCode + (autocompleteViewModel6 != null ? autocompleteViewModel6.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ViewState(autocompleteViewState=");
        sbU.append(this.autocompleteViewState);
        sbU.append(", selectedCommandViewState=");
        sbU.append(this.selectedCommandViewState);
        sbU.append(")");
        return sbU.toString();
    }
}
