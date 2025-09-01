package com.discord.utilities.textprocessing;

import com.discord.utilities.textprocessing.Rules;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: MessageParseState.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0003\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0003\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/discord/utilities/textprocessing/MessageParseState;", "Lcom/discord/utilities/textprocessing/Rules$BlockQuoteState;", "", "isInQuote", "newBlockQuoteState", "(Z)Lcom/discord/utilities/textprocessing/MessageParseState;", "Z", "()Z", "<init>", "(Z)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class MessageParseState implements Rules.BlockQuoteState<MessageParseState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final MessageParseState initialState = new MessageParseState(false);
    private final boolean isInQuote;

    /* compiled from: MessageParseState.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/utilities/textprocessing/MessageParseState$Companion;", "", "Lcom/discord/utilities/textprocessing/MessageParseState;", "initialState", "Lcom/discord/utilities/textprocessing/MessageParseState;", "getInitialState", "()Lcom/discord/utilities/textprocessing/MessageParseState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final MessageParseState getInitialState() {
            return MessageParseState.access$getInitialState$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private MessageParseState(boolean z2) {
        this.isInQuote = z2;
    }

    public static final /* synthetic */ MessageParseState access$getInitialState$cp() {
        return initialState;
    }

    @Override // com.discord.utilities.textprocessing.Rules.BlockQuoteState
    /* renamed from: isInQuote, reason: from getter */
    public boolean getIsInQuote() {
        return this.isInQuote;
    }

    @Override // com.discord.utilities.textprocessing.Rules.BlockQuoteState
    public /* bridge */ /* synthetic */ Rules.BlockQuoteState newBlockQuoteState(boolean z2) {
        return newBlockQuoteState(z2);
    }

    @Override // com.discord.utilities.textprocessing.Rules.BlockQuoteState
    public MessageParseState newBlockQuoteState(boolean isInQuote) {
        return new MessageParseState(isInQuote);
    }
}
