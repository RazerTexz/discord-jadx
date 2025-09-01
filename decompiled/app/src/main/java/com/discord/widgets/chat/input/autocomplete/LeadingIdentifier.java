package com.discord.widgets.chat.input.autocomplete;

import com.discord.widgets.chat.AutocompleteUtils;
import com.discord.widgets.chat.AutocompleteUtils2;
import com.discord.widgets.chat.input.MentionUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Autocompletable.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\f\n\u0002\b\r\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0013\b\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001b\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/discord/widgets/chat/input/autocomplete/LeadingIdentifier;", "", "", "identifier", "Ljava/lang/Character;", "getIdentifier", "()Ljava/lang/Character;", "<init>", "(Ljava/lang/String;ILjava/lang/Character;)V", "Companion", "APP_COMMAND", "EMOJI_AND_STICKERS", AutocompleteUtils2.CHANNELS, AutocompleteUtils.MENTION, "NONE", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public enum LeadingIdentifier {
    APP_COMMAND(Character.valueOf(MentionUtils.SLASH_CHAR)),
    EMOJI_AND_STICKERS(Character.valueOf(MentionUtils.EMOJIS_AND_STICKERS_CHAR)),
    CHANNELS(Character.valueOf(MentionUtils.CHANNELS_CHAR)),
    MENTION(Character.valueOf(MentionUtils.MENTIONS_CHAR)),
    NONE(null);


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Character identifier;

    /* compiled from: Autocompletable.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/widgets/chat/input/autocomplete/LeadingIdentifier$Companion;", "", "", "identifier", "Lcom/discord/widgets/chat/input/autocomplete/LeadingIdentifier;", "fromChar", "(Ljava/lang/Character;)Lcom/discord/widgets/chat/input/autocomplete/LeadingIdentifier;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final LeadingIdentifier fromChar(Character identifier) {
            return (identifier != null && identifier.charValue() == '/') ? LeadingIdentifier.APP_COMMAND : (identifier != null && identifier.charValue() == ':') ? LeadingIdentifier.EMOJI_AND_STICKERS : (identifier != null && identifier.charValue() == '#') ? LeadingIdentifier.CHANNELS : (identifier != null && identifier.charValue() == '@') ? LeadingIdentifier.MENTION : LeadingIdentifier.NONE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    LeadingIdentifier(Character ch) {
        this.identifier = ch;
    }

    public final Character getIdentifier() {
        return this.identifier;
    }
}
