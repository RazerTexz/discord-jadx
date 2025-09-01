package com.discord.widgets.chat.input.autocomplete;

import android.text.style.CharacterStyle;
import b.d.b.a.outline;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.Ranges2;

/* compiled from: InputEditTextAction.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\r\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\b\t\n\u000b\f\r\u000e\u000f\u0010B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\b\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018¨\u0006\u0019"}, d2 = {"Lcom/discord/widgets/chat/input/autocomplete/InputEditTextAction;", "", "", "assumedInput", "Ljava/lang/CharSequence;", "getAssumedInput", "()Ljava/lang/CharSequence;", "<init>", "(Ljava/lang/CharSequence;)V", "ClearSpans", "InsertText", "None", "RemoveText", "ReplaceCharacterStyleSpans", "ReplacePillSpans", "ReplaceText", "SelectText", "Lcom/discord/widgets/chat/input/autocomplete/InputEditTextAction$None;", "Lcom/discord/widgets/chat/input/autocomplete/InputEditTextAction$ClearSpans;", "Lcom/discord/widgets/chat/input/autocomplete/InputEditTextAction$ReplaceCharacterStyleSpans;", "Lcom/discord/widgets/chat/input/autocomplete/InputEditTextAction$ReplacePillSpans;", "Lcom/discord/widgets/chat/input/autocomplete/InputEditTextAction$InsertText;", "Lcom/discord/widgets/chat/input/autocomplete/InputEditTextAction$RemoveText;", "Lcom/discord/widgets/chat/input/autocomplete/InputEditTextAction$ReplaceText;", "Lcom/discord/widgets/chat/input/autocomplete/InputEditTextAction$SelectText;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public abstract class InputEditTextAction {
    private final CharSequence assumedInput;

    /* compiled from: InputEditTextAction.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0005\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/chat/input/autocomplete/InputEditTextAction$ClearSpans;", "Lcom/discord/widgets/chat/input/autocomplete/InputEditTextAction;", "", "component1", "()Ljava/lang/CharSequence;", "assumedInput", "copy", "(Ljava/lang/CharSequence;)Lcom/discord/widgets/chat/input/autocomplete/InputEditTextAction$ClearSpans;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/CharSequence;", "getAssumedInput", "<init>", "(Ljava/lang/CharSequence;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ClearSpans extends InputEditTextAction {
        private final CharSequence assumedInput;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ClearSpans(CharSequence charSequence) {
            super(charSequence, null);
            Intrinsics3.checkNotNullParameter(charSequence, "assumedInput");
            this.assumedInput = charSequence;
        }

        public static /* synthetic */ ClearSpans copy$default(ClearSpans clearSpans, CharSequence charSequence, int i, Object obj) {
            if ((i & 1) != 0) {
                charSequence = clearSpans.getAssumedInput();
            }
            return clearSpans.copy(charSequence);
        }

        public final CharSequence component1() {
            return getAssumedInput();
        }

        public final ClearSpans copy(CharSequence assumedInput) {
            Intrinsics3.checkNotNullParameter(assumedInput, "assumedInput");
            return new ClearSpans(assumedInput);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof ClearSpans) && Intrinsics3.areEqual(getAssumedInput(), ((ClearSpans) other).getAssumedInput());
            }
            return true;
        }

        @Override // com.discord.widgets.chat.input.autocomplete.InputEditTextAction
        public CharSequence getAssumedInput() {
            return this.assumedInput;
        }

        public int hashCode() {
            CharSequence assumedInput = getAssumedInput();
            if (assumedInput != null) {
                return assumedInput.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ClearSpans(assumedInput=");
            sbU.append(getAssumedInput());
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: InputEditTextAction.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ8\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u000bJ\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004R\u001c\u0010\f\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\u001d\u0010\u0004R\u0019\u0010\u000f\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b\u001f\u0010\u000bR\u0019\u0010\u000e\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010 \u001a\u0004\b!\u0010\b¨\u0006$"}, d2 = {"Lcom/discord/widgets/chat/input/autocomplete/InputEditTextAction$InsertText;", "Lcom/discord/widgets/chat/input/autocomplete/InputEditTextAction;", "", "component1", "()Ljava/lang/CharSequence;", "component2", "Lkotlin/ranges/IntRange;", "component3", "()Lkotlin/ranges/IntRange;", "", "component4", "()I", "assumedInput", "toAppend", "insertRange", "selectionIndex", "copy", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Lkotlin/ranges/IntRange;I)Lcom/discord/widgets/chat/input/autocomplete/InputEditTextAction$InsertText;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/CharSequence;", "getToAppend", "getAssumedInput", "I", "getSelectionIndex", "Lkotlin/ranges/IntRange;", "getInsertRange", "<init>", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Lkotlin/ranges/IntRange;I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class InsertText extends InputEditTextAction {
        private final CharSequence assumedInput;
        private final Ranges2 insertRange;
        private final int selectionIndex;
        private final CharSequence toAppend;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InsertText(CharSequence charSequence, CharSequence charSequence2, Ranges2 ranges2, int i) {
            super(charSequence, null);
            Intrinsics3.checkNotNullParameter(charSequence, "assumedInput");
            Intrinsics3.checkNotNullParameter(charSequence2, "toAppend");
            Intrinsics3.checkNotNullParameter(ranges2, "insertRange");
            this.assumedInput = charSequence;
            this.toAppend = charSequence2;
            this.insertRange = ranges2;
            this.selectionIndex = i;
        }

        public static /* synthetic */ InsertText copy$default(InsertText insertText, CharSequence charSequence, CharSequence charSequence2, Ranges2 ranges2, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                charSequence = insertText.getAssumedInput();
            }
            if ((i2 & 2) != 0) {
                charSequence2 = insertText.toAppend;
            }
            if ((i2 & 4) != 0) {
                ranges2 = insertText.insertRange;
            }
            if ((i2 & 8) != 0) {
                i = insertText.selectionIndex;
            }
            return insertText.copy(charSequence, charSequence2, ranges2, i);
        }

        public final CharSequence component1() {
            return getAssumedInput();
        }

        /* renamed from: component2, reason: from getter */
        public final CharSequence getToAppend() {
            return this.toAppend;
        }

        /* renamed from: component3, reason: from getter */
        public final Ranges2 getInsertRange() {
            return this.insertRange;
        }

        /* renamed from: component4, reason: from getter */
        public final int getSelectionIndex() {
            return this.selectionIndex;
        }

        public final InsertText copy(CharSequence assumedInput, CharSequence toAppend, Ranges2 insertRange, int selectionIndex) {
            Intrinsics3.checkNotNullParameter(assumedInput, "assumedInput");
            Intrinsics3.checkNotNullParameter(toAppend, "toAppend");
            Intrinsics3.checkNotNullParameter(insertRange, "insertRange");
            return new InsertText(assumedInput, toAppend, insertRange, selectionIndex);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InsertText)) {
                return false;
            }
            InsertText insertText = (InsertText) other;
            return Intrinsics3.areEqual(getAssumedInput(), insertText.getAssumedInput()) && Intrinsics3.areEqual(this.toAppend, insertText.toAppend) && Intrinsics3.areEqual(this.insertRange, insertText.insertRange) && this.selectionIndex == insertText.selectionIndex;
        }

        @Override // com.discord.widgets.chat.input.autocomplete.InputEditTextAction
        public CharSequence getAssumedInput() {
            return this.assumedInput;
        }

        public final Ranges2 getInsertRange() {
            return this.insertRange;
        }

        public final int getSelectionIndex() {
            return this.selectionIndex;
        }

        public final CharSequence getToAppend() {
            return this.toAppend;
        }

        public int hashCode() {
            CharSequence assumedInput = getAssumedInput();
            int iHashCode = (assumedInput != null ? assumedInput.hashCode() : 0) * 31;
            CharSequence charSequence = this.toAppend;
            int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
            Ranges2 ranges2 = this.insertRange;
            return ((iHashCode2 + (ranges2 != null ? ranges2.hashCode() : 0)) * 31) + this.selectionIndex;
        }

        public String toString() {
            StringBuilder sbU = outline.U("InsertText(assumedInput=");
            sbU.append(getAssumedInput());
            sbU.append(", toAppend=");
            sbU.append(this.toAppend);
            sbU.append(", insertRange=");
            sbU.append(this.insertRange);
            sbU.append(", selectionIndex=");
            return outline.B(sbU, this.selectionIndex, ")");
        }
    }

    /* compiled from: InputEditTextAction.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0005\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/chat/input/autocomplete/InputEditTextAction$None;", "Lcom/discord/widgets/chat/input/autocomplete/InputEditTextAction;", "", "component1", "()Ljava/lang/CharSequence;", "assumedInput", "copy", "(Ljava/lang/CharSequence;)Lcom/discord/widgets/chat/input/autocomplete/InputEditTextAction$None;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/CharSequence;", "getAssumedInput", "<init>", "(Ljava/lang/CharSequence;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class None extends InputEditTextAction {
        private final CharSequence assumedInput;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public None(CharSequence charSequence) {
            super(charSequence, null);
            Intrinsics3.checkNotNullParameter(charSequence, "assumedInput");
            this.assumedInput = charSequence;
        }

        public static /* synthetic */ None copy$default(None none, CharSequence charSequence, int i, Object obj) {
            if ((i & 1) != 0) {
                charSequence = none.getAssumedInput();
            }
            return none.copy(charSequence);
        }

        public final CharSequence component1() {
            return getAssumedInput();
        }

        public final None copy(CharSequence assumedInput) {
            Intrinsics3.checkNotNullParameter(assumedInput, "assumedInput");
            return new None(assumedInput);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof None) && Intrinsics3.areEqual(getAssumedInput(), ((None) other).getAssumedInput());
            }
            return true;
        }

        @Override // com.discord.widgets.chat.input.autocomplete.InputEditTextAction
        public CharSequence getAssumedInput() {
            return this.assumedInput;
        }

        public int hashCode() {
            CharSequence assumedInput = getAssumedInput();
            if (assumedInput != null) {
                return assumedInput.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = outline.U("None(assumedInput=");
            sbU.append(getAssumedInput());
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: InputEditTextAction.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ.\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0013\u0010\nJ\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001a\u0010\u0007R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001c\u0010\nR\u001c\u0010\u000b\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004¨\u0006!"}, d2 = {"Lcom/discord/widgets/chat/input/autocomplete/InputEditTextAction$RemoveText;", "Lcom/discord/widgets/chat/input/autocomplete/InputEditTextAction;", "", "component1", "()Ljava/lang/CharSequence;", "Lkotlin/ranges/IntRange;", "component2", "()Lkotlin/ranges/IntRange;", "", "component3", "()I", "assumedInput", "range", "selectionIndex", "copy", "(Ljava/lang/CharSequence;Lkotlin/ranges/IntRange;I)Lcom/discord/widgets/chat/input/autocomplete/InputEditTextAction$RemoveText;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lkotlin/ranges/IntRange;", "getRange", "I", "getSelectionIndex", "Ljava/lang/CharSequence;", "getAssumedInput", "<init>", "(Ljava/lang/CharSequence;Lkotlin/ranges/IntRange;I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class RemoveText extends InputEditTextAction {
        private final CharSequence assumedInput;
        private final Ranges2 range;
        private final int selectionIndex;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RemoveText(CharSequence charSequence, Ranges2 ranges2, int i) {
            super(charSequence, null);
            Intrinsics3.checkNotNullParameter(charSequence, "assumedInput");
            Intrinsics3.checkNotNullParameter(ranges2, "range");
            this.assumedInput = charSequence;
            this.range = ranges2;
            this.selectionIndex = i;
        }

        public static /* synthetic */ RemoveText copy$default(RemoveText removeText, CharSequence charSequence, Ranges2 ranges2, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                charSequence = removeText.getAssumedInput();
            }
            if ((i2 & 2) != 0) {
                ranges2 = removeText.range;
            }
            if ((i2 & 4) != 0) {
                i = removeText.selectionIndex;
            }
            return removeText.copy(charSequence, ranges2, i);
        }

        public final CharSequence component1() {
            return getAssumedInput();
        }

        /* renamed from: component2, reason: from getter */
        public final Ranges2 getRange() {
            return this.range;
        }

        /* renamed from: component3, reason: from getter */
        public final int getSelectionIndex() {
            return this.selectionIndex;
        }

        public final RemoveText copy(CharSequence assumedInput, Ranges2 range, int selectionIndex) {
            Intrinsics3.checkNotNullParameter(assumedInput, "assumedInput");
            Intrinsics3.checkNotNullParameter(range, "range");
            return new RemoveText(assumedInput, range, selectionIndex);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RemoveText)) {
                return false;
            }
            RemoveText removeText = (RemoveText) other;
            return Intrinsics3.areEqual(getAssumedInput(), removeText.getAssumedInput()) && Intrinsics3.areEqual(this.range, removeText.range) && this.selectionIndex == removeText.selectionIndex;
        }

        @Override // com.discord.widgets.chat.input.autocomplete.InputEditTextAction
        public CharSequence getAssumedInput() {
            return this.assumedInput;
        }

        public final Ranges2 getRange() {
            return this.range;
        }

        public final int getSelectionIndex() {
            return this.selectionIndex;
        }

        public int hashCode() {
            CharSequence assumedInput = getAssumedInput();
            int iHashCode = (assumedInput != null ? assumedInput.hashCode() : 0) * 31;
            Ranges2 ranges2 = this.range;
            return ((iHashCode + (ranges2 != null ? ranges2.hashCode() : 0)) * 31) + this.selectionIndex;
        }

        public String toString() {
            StringBuilder sbU = outline.U("RemoveText(assumedInput=");
            sbU.append(getAssumedInput());
            sbU.append(", range=");
            sbU.append(this.range);
            sbU.append(", selectionIndex=");
            return outline.B(sbU, this.selectionIndex, ")");
        }
    }

    /* compiled from: InputEditTextAction.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u001a\b\u0002\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\"\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ6\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\u001a\b\u0002\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u001c\u0010\u000b\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R+\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001c\u001a\u0004\b\u001d\u0010\n¨\u0006 "}, d2 = {"Lcom/discord/widgets/chat/input/autocomplete/InputEditTextAction$ReplaceCharacterStyleSpans;", "Lcom/discord/widgets/chat/input/autocomplete/InputEditTextAction;", "", "component1", "()Ljava/lang/CharSequence;", "", "Lkotlin/ranges/IntRange;", "", "Landroid/text/style/CharacterStyle;", "component2", "()Ljava/util/Map;", "assumedInput", "spans", "copy", "(Ljava/lang/CharSequence;Ljava/util/Map;)Lcom/discord/widgets/chat/input/autocomplete/InputEditTextAction$ReplaceCharacterStyleSpans;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/CharSequence;", "getAssumedInput", "Ljava/util/Map;", "getSpans", "<init>", "(Ljava/lang/CharSequence;Ljava/util/Map;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ReplaceCharacterStyleSpans extends InputEditTextAction {
        private final CharSequence assumedInput;
        private final Map<Ranges2, List<CharacterStyle>> spans;

        public /* synthetic */ ReplaceCharacterStyleSpans(CharSequence charSequence, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(charSequence, (i & 2) != 0 ? Maps6.emptyMap() : map);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ReplaceCharacterStyleSpans copy$default(ReplaceCharacterStyleSpans replaceCharacterStyleSpans, CharSequence charSequence, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                charSequence = replaceCharacterStyleSpans.getAssumedInput();
            }
            if ((i & 2) != 0) {
                map = replaceCharacterStyleSpans.spans;
            }
            return replaceCharacterStyleSpans.copy(charSequence, map);
        }

        public final CharSequence component1() {
            return getAssumedInput();
        }

        public final Map<Ranges2, List<CharacterStyle>> component2() {
            return this.spans;
        }

        public final ReplaceCharacterStyleSpans copy(CharSequence assumedInput, Map<Ranges2, ? extends List<? extends CharacterStyle>> spans) {
            Intrinsics3.checkNotNullParameter(assumedInput, "assumedInput");
            Intrinsics3.checkNotNullParameter(spans, "spans");
            return new ReplaceCharacterStyleSpans(assumedInput, spans);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ReplaceCharacterStyleSpans)) {
                return false;
            }
            ReplaceCharacterStyleSpans replaceCharacterStyleSpans = (ReplaceCharacterStyleSpans) other;
            return Intrinsics3.areEqual(getAssumedInput(), replaceCharacterStyleSpans.getAssumedInput()) && Intrinsics3.areEqual(this.spans, replaceCharacterStyleSpans.spans);
        }

        @Override // com.discord.widgets.chat.input.autocomplete.InputEditTextAction
        public CharSequence getAssumedInput() {
            return this.assumedInput;
        }

        public final Map<Ranges2, List<CharacterStyle>> getSpans() {
            return this.spans;
        }

        public int hashCode() {
            CharSequence assumedInput = getAssumedInput();
            int iHashCode = (assumedInput != null ? assumedInput.hashCode() : 0) * 31;
            Map<Ranges2, List<CharacterStyle>> map = this.spans;
            return iHashCode + (map != null ? map.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("ReplaceCharacterStyleSpans(assumedInput=");
            sbU.append(getAssumedInput());
            sbU.append(", spans=");
            return outline.M(sbU, this.spans, ")");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public ReplaceCharacterStyleSpans(CharSequence charSequence, Map<Ranges2, ? extends List<? extends CharacterStyle>> map) {
            super(charSequence, null);
            Intrinsics3.checkNotNullParameter(charSequence, "assumedInput");
            Intrinsics3.checkNotNullParameter(map, "spans");
            this.assumedInput = charSequence;
            this.spans = map;
        }
    }

    /* compiled from: InputEditTextAction.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u001a\b\u0002\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\"\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ6\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\u001a\b\u0002\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R+\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001b\u0010\nR\u001c\u0010\u000b\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004¨\u0006 "}, d2 = {"Lcom/discord/widgets/chat/input/autocomplete/InputEditTextAction$ReplacePillSpans;", "Lcom/discord/widgets/chat/input/autocomplete/InputEditTextAction;", "", "component1", "()Ljava/lang/CharSequence;", "", "Lkotlin/ranges/IntRange;", "", "Landroid/text/style/CharacterStyle;", "component2", "()Ljava/util/Map;", "assumedInput", "spans", "copy", "(Ljava/lang/CharSequence;Ljava/util/Map;)Lcom/discord/widgets/chat/input/autocomplete/InputEditTextAction$ReplacePillSpans;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Map;", "getSpans", "Ljava/lang/CharSequence;", "getAssumedInput", "<init>", "(Ljava/lang/CharSequence;Ljava/util/Map;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ReplacePillSpans extends InputEditTextAction {
        private final CharSequence assumedInput;
        private final Map<Ranges2, List<CharacterStyle>> spans;

        public /* synthetic */ ReplacePillSpans(CharSequence charSequence, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(charSequence, (i & 2) != 0 ? Maps6.emptyMap() : map);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ReplacePillSpans copy$default(ReplacePillSpans replacePillSpans, CharSequence charSequence, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                charSequence = replacePillSpans.getAssumedInput();
            }
            if ((i & 2) != 0) {
                map = replacePillSpans.spans;
            }
            return replacePillSpans.copy(charSequence, map);
        }

        public final CharSequence component1() {
            return getAssumedInput();
        }

        public final Map<Ranges2, List<CharacterStyle>> component2() {
            return this.spans;
        }

        public final ReplacePillSpans copy(CharSequence assumedInput, Map<Ranges2, ? extends List<? extends CharacterStyle>> spans) {
            Intrinsics3.checkNotNullParameter(assumedInput, "assumedInput");
            Intrinsics3.checkNotNullParameter(spans, "spans");
            return new ReplacePillSpans(assumedInput, spans);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ReplacePillSpans)) {
                return false;
            }
            ReplacePillSpans replacePillSpans = (ReplacePillSpans) other;
            return Intrinsics3.areEqual(getAssumedInput(), replacePillSpans.getAssumedInput()) && Intrinsics3.areEqual(this.spans, replacePillSpans.spans);
        }

        @Override // com.discord.widgets.chat.input.autocomplete.InputEditTextAction
        public CharSequence getAssumedInput() {
            return this.assumedInput;
        }

        public final Map<Ranges2, List<CharacterStyle>> getSpans() {
            return this.spans;
        }

        public int hashCode() {
            CharSequence assumedInput = getAssumedInput();
            int iHashCode = (assumedInput != null ? assumedInput.hashCode() : 0) * 31;
            Map<Ranges2, List<CharacterStyle>> map = this.spans;
            return iHashCode + (map != null ? map.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("ReplacePillSpans(assumedInput=");
            sbU.append(getAssumedInput());
            sbU.append(", spans=");
            return outline.M(sbU, this.spans, ")");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public ReplacePillSpans(CharSequence charSequence, Map<Ranges2, ? extends List<? extends CharacterStyle>> map) {
            super(charSequence, null);
            Intrinsics3.checkNotNullParameter(charSequence, "assumedInput");
            Intrinsics3.checkNotNullParameter(map, "spans");
            this.assumedInput = charSequence;
            this.spans = map;
        }
    }

    /* compiled from: InputEditTextAction.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0011\u0010\bJ\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u001c\u0010\t\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0019\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u001b\u0010\b¨\u0006\u001e"}, d2 = {"Lcom/discord/widgets/chat/input/autocomplete/InputEditTextAction$ReplaceText;", "Lcom/discord/widgets/chat/input/autocomplete/InputEditTextAction;", "", "component1", "()Ljava/lang/CharSequence;", "component2", "", "component3", "()I", "assumedInput", "newText", "selectionIndex", "copy", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;I)Lcom/discord/widgets/chat/input/autocomplete/InputEditTextAction$ReplaceText;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/CharSequence;", "getNewText", "getAssumedInput", "I", "getSelectionIndex", "<init>", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ReplaceText extends InputEditTextAction {
        private final CharSequence assumedInput;
        private final CharSequence newText;
        private final int selectionIndex;

        public /* synthetic */ ReplaceText(CharSequence charSequence, CharSequence charSequence2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(charSequence, charSequence2, (i2 & 4) != 0 ? charSequence2.length() : i);
        }

        public static /* synthetic */ ReplaceText copy$default(ReplaceText replaceText, CharSequence charSequence, CharSequence charSequence2, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                charSequence = replaceText.getAssumedInput();
            }
            if ((i2 & 2) != 0) {
                charSequence2 = replaceText.newText;
            }
            if ((i2 & 4) != 0) {
                i = replaceText.selectionIndex;
            }
            return replaceText.copy(charSequence, charSequence2, i);
        }

        public final CharSequence component1() {
            return getAssumedInput();
        }

        /* renamed from: component2, reason: from getter */
        public final CharSequence getNewText() {
            return this.newText;
        }

        /* renamed from: component3, reason: from getter */
        public final int getSelectionIndex() {
            return this.selectionIndex;
        }

        public final ReplaceText copy(CharSequence assumedInput, CharSequence newText, int selectionIndex) {
            Intrinsics3.checkNotNullParameter(assumedInput, "assumedInput");
            Intrinsics3.checkNotNullParameter(newText, "newText");
            return new ReplaceText(assumedInput, newText, selectionIndex);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ReplaceText)) {
                return false;
            }
            ReplaceText replaceText = (ReplaceText) other;
            return Intrinsics3.areEqual(getAssumedInput(), replaceText.getAssumedInput()) && Intrinsics3.areEqual(this.newText, replaceText.newText) && this.selectionIndex == replaceText.selectionIndex;
        }

        @Override // com.discord.widgets.chat.input.autocomplete.InputEditTextAction
        public CharSequence getAssumedInput() {
            return this.assumedInput;
        }

        public final CharSequence getNewText() {
            return this.newText;
        }

        public final int getSelectionIndex() {
            return this.selectionIndex;
        }

        public int hashCode() {
            CharSequence assumedInput = getAssumedInput();
            int iHashCode = (assumedInput != null ? assumedInput.hashCode() : 0) * 31;
            CharSequence charSequence = this.newText;
            return ((iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31) + this.selectionIndex;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ReplaceText(assumedInput=");
            sbU.append(getAssumedInput());
            sbU.append(", newText=");
            sbU.append(this.newText);
            sbU.append(", selectionIndex=");
            return outline.B(sbU, this.selectionIndex, ")");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ReplaceText(CharSequence charSequence, CharSequence charSequence2, int i) {
            super(charSequence, null);
            Intrinsics3.checkNotNullParameter(charSequence, "assumedInput");
            Intrinsics3.checkNotNullParameter(charSequence2, "newText");
            this.assumedInput = charSequence;
            this.newText = charSequence2;
            this.selectionIndex = i;
        }
    }

    /* compiled from: InputEditTextAction.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\b\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0019\u001a\u0004\b\u001a\u0010\u0007¨\u0006\u001d"}, d2 = {"Lcom/discord/widgets/chat/input/autocomplete/InputEditTextAction$SelectText;", "Lcom/discord/widgets/chat/input/autocomplete/InputEditTextAction;", "", "component1", "()Ljava/lang/CharSequence;", "Lkotlin/ranges/IntRange;", "component2", "()Lkotlin/ranges/IntRange;", "assumedInput", "selection", "copy", "(Ljava/lang/CharSequence;Lkotlin/ranges/IntRange;)Lcom/discord/widgets/chat/input/autocomplete/InputEditTextAction$SelectText;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/CharSequence;", "getAssumedInput", "Lkotlin/ranges/IntRange;", "getSelection", "<init>", "(Ljava/lang/CharSequence;Lkotlin/ranges/IntRange;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class SelectText extends InputEditTextAction {
        private final CharSequence assumedInput;
        private final Ranges2 selection;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SelectText(CharSequence charSequence, Ranges2 ranges2) {
            super(charSequence, null);
            Intrinsics3.checkNotNullParameter(charSequence, "assumedInput");
            Intrinsics3.checkNotNullParameter(ranges2, "selection");
            this.assumedInput = charSequence;
            this.selection = ranges2;
        }

        public static /* synthetic */ SelectText copy$default(SelectText selectText, CharSequence charSequence, Ranges2 ranges2, int i, Object obj) {
            if ((i & 1) != 0) {
                charSequence = selectText.getAssumedInput();
            }
            if ((i & 2) != 0) {
                ranges2 = selectText.selection;
            }
            return selectText.copy(charSequence, ranges2);
        }

        public final CharSequence component1() {
            return getAssumedInput();
        }

        /* renamed from: component2, reason: from getter */
        public final Ranges2 getSelection() {
            return this.selection;
        }

        public final SelectText copy(CharSequence assumedInput, Ranges2 selection) {
            Intrinsics3.checkNotNullParameter(assumedInput, "assumedInput");
            Intrinsics3.checkNotNullParameter(selection, "selection");
            return new SelectText(assumedInput, selection);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SelectText)) {
                return false;
            }
            SelectText selectText = (SelectText) other;
            return Intrinsics3.areEqual(getAssumedInput(), selectText.getAssumedInput()) && Intrinsics3.areEqual(this.selection, selectText.selection);
        }

        @Override // com.discord.widgets.chat.input.autocomplete.InputEditTextAction
        public CharSequence getAssumedInput() {
            return this.assumedInput;
        }

        public final Ranges2 getSelection() {
            return this.selection;
        }

        public int hashCode() {
            CharSequence assumedInput = getAssumedInput();
            int iHashCode = (assumedInput != null ? assumedInput.hashCode() : 0) * 31;
            Ranges2 ranges2 = this.selection;
            return iHashCode + (ranges2 != null ? ranges2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("SelectText(assumedInput=");
            sbU.append(getAssumedInput());
            sbU.append(", selection=");
            sbU.append(this.selection);
            sbU.append(")");
            return sbU.toString();
        }
    }

    private InputEditTextAction(CharSequence charSequence) {
        this.assumedInput = charSequence;
    }

    public CharSequence getAssumedInput() {
        return this.assumedInput;
    }

    public /* synthetic */ InputEditTextAction(CharSequence charSequence, DefaultConstructorMarker defaultConstructorMarker) {
        this(charSequence);
    }
}
