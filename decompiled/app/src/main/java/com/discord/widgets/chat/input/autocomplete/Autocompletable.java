package com.discord.widgets.chat.input.autocomplete;

import androidx.core.app.NotificationCompat;
import com.discord.utilities.collections.MultiListIterator;
import d0.z.d.Intrinsics3;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Autocompletable.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010(\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\bH&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\bH\u0016¢\u0006\u0004\b\f\u0010\nJ\u0013\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\r¢\u0006\u0004\b\u0010\u0010\u000fJ\u0015\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0005¢\u0006\u0004\b\u0013\u0010\u0014\u0082\u0001\n\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f ¨\u0006!"}, d2 = {"Lcom/discord/widgets/chat/input/autocomplete/Autocompletable;", "", "Lcom/discord/widgets/chat/input/autocomplete/LeadingIdentifier;", "leadingIdentifier", "()Lcom/discord/widgets/chat/input/autocomplete/LeadingIdentifier;", "", "getInputReplacement", "()Ljava/lang/String;", "", "getInputTextMatchers", "()Ljava/util/List;", "getHiddenInputTextMatchers", "getAutocompleteTextMatchers", "", "iterateTextMatchers", "()Ljava/util/Iterator;", "iterateAutocompleteMatchers", NotificationCompat.MessagingStyle.Message.KEY_TEXT, "", "matchesText", "(Ljava/lang/String;)Z", "<init>", "()V", "Lcom/discord/widgets/chat/input/autocomplete/EmojiAutocompletable;", "Lcom/discord/widgets/chat/input/autocomplete/RoleAutocompletable;", "Lcom/discord/widgets/chat/input/autocomplete/GlobalRoleAutocompletable;", "Lcom/discord/widgets/chat/input/autocomplete/UserAutocompletable;", "Lcom/discord/widgets/chat/input/autocomplete/ChannelAutocompletable;", "Lcom/discord/widgets/chat/input/autocomplete/ApplicationCommandAutocompletable;", "Lcom/discord/widgets/chat/input/autocomplete/ApplicationCommandChoiceAutocompletable;", "Lcom/discord/widgets/chat/input/autocomplete/ApplicationPlaceholder;", "Lcom/discord/widgets/chat/input/autocomplete/ApplicationCommandLoadingPlaceholder;", "Lcom/discord/widgets/chat/input/autocomplete/EmojiUpsellPlaceholder;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public abstract class Autocompletable {
    private Autocompletable() {
    }

    public List<String> getAutocompleteTextMatchers() {
        return null;
    }

    public List<String> getHiddenInputTextMatchers() {
        return null;
    }

    public abstract String getInputReplacement();

    public abstract List<String> getInputTextMatchers();

    public final Iterator<String> iterateAutocompleteMatchers() {
        List<String> autocompleteTextMatchers = getAutocompleteTextMatchers();
        if (autocompleteTextMatchers == null || autocompleteTextMatchers.isEmpty()) {
            return getInputTextMatchers().iterator();
        }
        List<String> autocompleteTextMatchers2 = getAutocompleteTextMatchers();
        Intrinsics3.checkNotNull(autocompleteTextMatchers2);
        return new MultiListIterator(getInputTextMatchers(), autocompleteTextMatchers2);
    }

    public final Iterator<String> iterateTextMatchers() {
        List<String> hiddenInputTextMatchers = getHiddenInputTextMatchers();
        if (hiddenInputTextMatchers == null || hiddenInputTextMatchers.isEmpty()) {
            return getInputTextMatchers().iterator();
        }
        List<String> hiddenInputTextMatchers2 = getHiddenInputTextMatchers();
        Intrinsics3.checkNotNull(hiddenInputTextMatchers2);
        return new MultiListIterator(getInputTextMatchers(), hiddenInputTextMatchers2);
    }

    public LeadingIdentifier leadingIdentifier() {
        return LeadingIdentifier.NONE;
    }

    public final boolean matchesText(String text) {
        Intrinsics3.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        if (getInputTextMatchers().contains(text)) {
            return true;
        }
        List<String> hiddenInputTextMatchers = getHiddenInputTextMatchers();
        return hiddenInputTextMatchers != null && hiddenInputTextMatchers.contains(text);
    }

    public /* synthetic */ Autocompletable(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
