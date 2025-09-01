package com.discord.widgets.chat.input.autocomplete;

import b.d.b.a.outline;
import com.discord.models.domain.emoji.Emoji;
import com.discord.widgets.chat.input.MentionUtils;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: Autocompletable.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\u0010¢\u0006\u0004\b&\u0010'J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\bH\u0016¢\u0006\u0004\b\f\u0010\nJ\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J$\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\u0010HÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0007J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001d\u001a\u00020\u00102\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u0019\u0010\u0014\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u001f\u001a\u0004\b \u0010\u0012R\u0019\u0010\u0013\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010!\u001a\u0004\b\"\u0010\u000fR\u001f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00050\b8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\n¨\u0006("}, d2 = {"Lcom/discord/widgets/chat/input/autocomplete/EmojiAutocompletable;", "Lcom/discord/widgets/chat/input/autocomplete/Autocompletable;", "Lcom/discord/widgets/chat/input/autocomplete/LeadingIdentifier;", "leadingIdentifier", "()Lcom/discord/widgets/chat/input/autocomplete/LeadingIdentifier;", "", "getInputReplacement", "()Ljava/lang/String;", "", "getInputTextMatchers", "()Ljava/util/List;", "getHiddenInputTextMatchers", "getAutocompleteTextMatchers", "Lcom/discord/models/domain/emoji/Emoji;", "component1", "()Lcom/discord/models/domain/emoji/Emoji;", "", "component2", "()Z", "emoji", "animationsEnabled", "copy", "(Lcom/discord/models/domain/emoji/Emoji;Z)Lcom/discord/widgets/chat/input/autocomplete/EmojiAutocompletable;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getAnimationsEnabled", "Lcom/discord/models/domain/emoji/Emoji;", "getEmoji", "textMatchers", "Ljava/util/List;", "getTextMatchers", "<init>", "(Lcom/discord/models/domain/emoji/Emoji;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class EmojiAutocompletable extends Autocompletable {
    private final boolean animationsEnabled;
    private final Emoji emoji;
    private final List<String> textMatchers;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmojiAutocompletable(Emoji emoji, boolean z2) {
        super(null);
        Intrinsics3.checkNotNullParameter(emoji, "emoji");
        this.emoji = emoji;
        this.animationsEnabled = z2;
        List<String> names = emoji.getNames();
        Intrinsics3.checkNotNullExpressionValue(names, "emoji.names");
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(names, 10));
        Iterator<T> it = names.iterator();
        while (it.hasNext()) {
            arrayList.add(MentionUtils.EMOJIS_AND_STICKERS_CHAR + ((String) it.next()) + MentionUtils.EMOJIS_AND_STICKERS_CHAR);
        }
        this.textMatchers = arrayList;
    }

    public static /* synthetic */ EmojiAutocompletable copy$default(EmojiAutocompletable emojiAutocompletable, Emoji emoji, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            emoji = emojiAutocompletable.emoji;
        }
        if ((i & 2) != 0) {
            z2 = emojiAutocompletable.animationsEnabled;
        }
        return emojiAutocompletable.copy(emoji, z2);
    }

    /* renamed from: component1, reason: from getter */
    public final Emoji getEmoji() {
        return this.emoji;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getAnimationsEnabled() {
        return this.animationsEnabled;
    }

    public final EmojiAutocompletable copy(Emoji emoji, boolean animationsEnabled) {
        Intrinsics3.checkNotNullParameter(emoji, "emoji");
        return new EmojiAutocompletable(emoji, animationsEnabled);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmojiAutocompletable)) {
            return false;
        }
        EmojiAutocompletable emojiAutocompletable = (EmojiAutocompletable) other;
        return Intrinsics3.areEqual(this.emoji, emojiAutocompletable.emoji) && this.animationsEnabled == emojiAutocompletable.animationsEnabled;
    }

    public final boolean getAnimationsEnabled() {
        return this.animationsEnabled;
    }

    @Override // com.discord.widgets.chat.input.autocomplete.Autocompletable
    public List<String> getAutocompleteTextMatchers() {
        return null;
    }

    public final Emoji getEmoji() {
        return this.emoji;
    }

    @Override // com.discord.widgets.chat.input.autocomplete.Autocompletable
    public List<String> getHiddenInputTextMatchers() {
        if (this.emoji.requiresColons()) {
            return null;
        }
        return this.emoji.getNames();
    }

    @Override // com.discord.widgets.chat.input.autocomplete.Autocompletable
    public String getInputReplacement() {
        String messageContentReplacement = this.emoji.getMessageContentReplacement();
        Intrinsics3.checkNotNullExpressionValue(messageContentReplacement, "emoji.messageContentReplacement");
        return messageContentReplacement;
    }

    @Override // com.discord.widgets.chat.input.autocomplete.Autocompletable
    public List<String> getInputTextMatchers() {
        return this.textMatchers;
    }

    public final List<String> getTextMatchers() {
        return this.textMatchers;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        Emoji emoji = this.emoji;
        int iHashCode = (emoji != null ? emoji.hashCode() : 0) * 31;
        boolean z2 = this.animationsEnabled;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        return iHashCode + i;
    }

    @Override // com.discord.widgets.chat.input.autocomplete.Autocompletable
    public LeadingIdentifier leadingIdentifier() {
        boolean zRequiresColons = this.emoji.requiresColons();
        if (zRequiresColons) {
            return LeadingIdentifier.EMOJI_AND_STICKERS;
        }
        if (zRequiresColons) {
            throw new NoWhenBranchMatchedException();
        }
        return LeadingIdentifier.NONE;
    }

    public String toString() {
        StringBuilder sbU = outline.U("EmojiAutocompletable(emoji=");
        sbU.append(this.emoji);
        sbU.append(", animationsEnabled=");
        return outline.O(sbU, this.animationsEnabled, ")");
    }
}
